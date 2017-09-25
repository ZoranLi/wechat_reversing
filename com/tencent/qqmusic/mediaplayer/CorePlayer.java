package com.tencent.qqmusic.mediaplayer;

import android.annotation.SuppressLint;
import android.media.AudioTrack;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.opensdk.constants.ConstantsAPI.AppSupportContentFlag;
import com.tencent.mm.plugin.appbrand.jsapi.map.m;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ah;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.audiofx.IAudioListener;
import com.tencent.qqmusic.mediaplayer.codec.BaseDecoder;
import com.tencent.qqmusic.mediaplayer.codec.ffmpeg.FfmpegPlayer;
import com.tencent.qqmusic.mediaplayer.codec.flac.FLACDecoder;
import com.tencent.qqmusic.mediaplayer.codec.mp3.MP3Decoder;
import com.tencent.qqmusic.mediaplayer.codec.mp3.MP3Information;
import com.tencent.qqmusic.mediaplayer.formatdetector.FormatDetector;
import com.tencent.qqmusic.mediaplayer.network.IMediaHTTPService;
import com.tencent.qqmusic.mediaplayer.perf.PerformanceTracer;
import com.tencent.qqmusic.mediaplayer.seektable.SeekTable;
import com.tencent.qqmusic.mediaplayer.seektable.mp3.Mp3CbrSeekTable;
import com.tencent.qqmusic.mediaplayer.seektable.mp3.Mp3VbrVBRISeekTable;
import com.tencent.qqmusic.mediaplayer.seektable.mp3.Mp3VbrXingSeekTable;
import com.tencent.qqmusic.mediaplayer.seektable.mpeg4.Mp4SeekTable;
import com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes.InvalidBoxException;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import com.tencent.qqmusic.mediaplayer.upstream.INativeDataSource;
import com.tencent.qqmusic.mediaplayer.util.AudioTrackMonitor;
import com.tencent.qqmusic.mediaplayer.util.CpuInfoUtil;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import com.tencent.qqmusic.mediaplayer.util.ReferenceTimer;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;

@SuppressLint({"DefaultLocale"})
class CorePlayer implements PlayerException, Runnable {
    private static final int BIT_RATE_FLAC = 700;
    private static final int CALL_PREPARED_DELAY_TIME = 20;
    private static final int DTS_OPTIMAL_FRAME_BYTE = 2048;
    private static final int MAX_AUDIO_TRACK_BUFFER_TIME = 1;
    private static final int MIN_AUDIO_TRACK_BUFFER_TIMES = 1;
    private static final int MIN_FIRST_PIECE_SIZE = 102400;
    private static final int MSG_BUFFER_READ_TO_PLAY = 50;
    private static final int MSG_SEEK = 49;
    private static final AtomicInteger PLAYER_ID_CREATOR = new AtomicInteger(0);
    private static final String TAG = "CorePlayer";
    private final List<IAudioListener> audioEffects = new ArrayList(3);
    public final Object bufferLock = new Object();
    private long bufferWaitingPosition;
    private int bufferWaitingTime;
    private boolean isBuffering;
    private BufferInfo m24BitBufferInfo = new BufferInfo();
    public long mAdjustLength = 0;
    private int mAudioStreamType = 3;
    private AudioTrack mAudioTrack;
    public AudioType mAudioType = AudioType.UNSUPPORT;
    private int mBuffSize;
    public PlayerCallback mCallback;
    private boolean mCreateAudioTrackFail = false;
    private long mCurPosition = 0;
    private long mCurrentFrameCount = 0;
    private BufferInfo mDTSBufferInfo = new BufferInfo();
    private IDataSource mDataSource;
    private BufferInfo mDecodeBufferInfo = new BufferInfo();
    public BaseDecoder mDecoder;
    public long mFileLength = 0;
    public String mFileName;
    public Handler mHandler = null;
    public boolean mHasDecode = false;
    private boolean mHasDecodeSuccess = false;
    private boolean mHasInit = false;
    private AudioInformation mInformation;
    private volatile boolean mIsExit = false;
    public final MediaHTTPManager mMediaHTTPManager;
    private INativeDataSource mNativeDataSource;
    private volatile boolean mNeedChangePlayThreadPriority = false;
    private boolean mNeedFlush = false;
    private OnlineSeekHandler mOnlineSeekHandler = null;
    private HandlerThread mOnlineSeekHandlerThread = null;
    private long mPlaySample;
    private int mPlayerID = PLAYER_ID_CREATOR.addAndGet(1);
    private BufferInfo mReSampleBufferInfo = new BufferInfo();
    private final Stack<Integer> mSeekRecord = new Stack();
    public SeekTable mSeekTable = null;
    private WaitNotify mSignalControl = new WaitNotify();
    public StateRunner<Integer> mStateRunner = new StateRunner(Integer.valueOf(0));
    private final List<IAudioListener> mTerminalAudioEffectList = new ArrayList();
    private String mThreadName = "Unnamed";
    private ReferenceTimer mTimer = new ReferenceTimer();
    private int mTrackBufferSizeInByte;
    private AudioTrackMonitor monitor = null;
    private final PerformanceTracer performanceTracer = new PerformanceTracer();

    private static class OnlineSeekHandler extends Handler {
        private boolean mIsLastSeekPlaying = false;
        private final WeakReference<CorePlayer> mPlayer;

        OnlineSeekHandler(Looper looper, CorePlayer corePlayer) {
            super(looper);
            this.mPlayer = new WeakReference(corePlayer);
        }

        public void handleMessage(Message message) {
            final CorePlayer corePlayer = (CorePlayer) this.mPlayer.get();
            if (corePlayer != null) {
                switch (message.what) {
                    case CorePlayer.MSG_SEEK /*49*/:
                        AudioInformation currentAudioInformation = corePlayer.getCurrentAudioInformation();
                        if ((message.obj instanceof Long) && currentAudioInformation != null && corePlayer.mMediaHTTPManager != null) {
                            final long longValue = ((Long) message.obj).longValue();
                            boolean isPlaying = corePlayer.isPlaying();
                            if (!corePlayer.isPaused()) {
                                if (isPlaying) {
                                    this.mIsLastSeekPlaying = true;
                                    corePlayer.pause();
                                } else {
                                    this.mIsLastSeekPlaying = false;
                                }
                            }
                            long fileOffsetAndUpdateAdjustLength = corePlayer.getFileOffsetAndUpdateAdjustLength(longValue, (int) ((long) corePlayer.getCurrentAudioInformation().getBitrate()));
                            if (fileOffsetAndUpdateAdjustLength >= corePlayer.mFileLength) {
                                fileOffsetAndUpdateAdjustLength = corePlayer.mFileLength - corePlayer.mAdjustLength;
                            }
                            if (fileOffsetAndUpdateAdjustLength - corePlayer.mAdjustLength < 0) {
                                fileOffsetAndUpdateAdjustLength = 0;
                            } else {
                                fileOffsetAndUpdateAdjustLength -= corePlayer.mAdjustLength;
                            }
                            corePlayer.mMediaHTTPManager.seekByBytePosition(fileOffsetAndUpdateAdjustLength);
                            corePlayer.mMediaHTTPManager.setBufferListener(new OnBufferListener() {
                                public void onBufferReadyToPlay() {
                                    OnlineSeekHandler.this.removeMessages(50);
                                    corePlayer.addSeekRecord((int) longValue);
                                    Message obtain = Message.obtain(OnlineSeekHandler.this, 50);
                                    obtain.arg1 = (int) longValue;
                                    obtain.obj = Boolean.valueOf(OnlineSeekHandler.this.mIsLastSeekPlaying);
                                    OnlineSeekHandler.this.sendMessageDelayed(obtain, 100);
                                }

                                public void onBufferProgress(long j, long j2) {
                                    corePlayer.notifyDownloadProgress(j, j2);
                                }
                            });
                            removeMessages(50);
                            return;
                        }
                        return;
                    case 50:
                        if (message.obj instanceof Boolean) {
                            int i = message.arg1;
                            if (((Boolean) message.obj).booleanValue()) {
                                this.mIsLastSeekPlaying = false;
                                corePlayer.play();
                                corePlayer.refreshTimeAndNotify(i);
                                return;
                            }
                            corePlayer.mStateRunner.transfer(Integer.valueOf(5));
                            corePlayer.refreshTimeAndNotify(i);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }

    private void initThreadHandler() {
        try {
            Logger.i(TAG, "static initializer CommonPlayer_Handler");
            new Thread("CommonPlayer_Handler") {
                public void run() {
                    super.run();
                    Logger.i(CorePlayer.TAG, "CommonPlayer_Handler thread is run");
                    Looper.prepare();
                    CorePlayer.this.mHandler = new Handler(Looper.myLooper());
                    Looper.loop();
                }
            }.start();
        } catch (Throwable th) {
            Logger.e(TAG, th);
        }
    }

    CorePlayer(IDataSource iDataSource, AudioType audioType, PlayerCallback playerCallback) {
        initThreadHandler();
        this.mAudioType = audioType;
        this.mCallback = playerCallback;
        this.mDataSource = iDataSource;
        this.mNativeDataSource = null;
        this.mFileName = null;
        this.mMediaHTTPManager = null;
        this.mDecoder = MediaCodecFactory.createDecoderByType(audioType);
        this.mStateRunner.transfer(Integer.valueOf(1));
        Logger.i(TAG, axiliary("audioType: " + audioType + ", dataSource: " + iDataSource));
    }

    CorePlayer(INativeDataSource iNativeDataSource, AudioType audioType, PlayerCallback playerCallback) {
        initThreadHandler();
        this.mAudioType = audioType;
        this.mCallback = playerCallback;
        this.mNativeDataSource = iNativeDataSource;
        this.mDataSource = null;
        this.mFileName = null;
        this.mMediaHTTPManager = null;
        this.mDecoder = MediaCodecFactory.createDecoderByType(audioType);
        this.mStateRunner.transfer(Integer.valueOf(1));
        Logger.i(TAG, axiliary("audioType: " + audioType + ", dataSource: " + iNativeDataSource));
    }

    CorePlayer(String str, AudioType audioType, PlayerCallback playerCallback) {
        initThreadHandler();
        this.mAudioType = audioType;
        this.mCallback = playerCallback;
        this.mFileName = str;
        this.mDecoder = MediaCodecFactory.createDecoderByType(audioType);
        this.mStateRunner.transfer(Integer.valueOf(1));
        this.mMediaHTTPManager = null;
        Logger.i(TAG, axiliary("audioType: " + audioType + ", filepath: " + str));
    }

    CorePlayer(IMediaHTTPService iMediaHTTPService, URL url, PlayerCallback playerCallback) {
        MediaHTTPManager mediaHTTPManager;
        initThreadHandler();
        this.mCallback = playerCallback;
        try {
            this.mFileName = File.createTempFile("mediaHttpCommonPlayer", "tmp").getAbsolutePath();
        } catch (Throwable th) {
            Logger.e(TAG, "createTempFile", th);
        }
        try {
            mediaHTTPManager = new MediaHTTPManager(iMediaHTTPService, this.mFileName, url);
        } catch (Throwable th2) {
            Logger.e(TAG, "init MediaHTTPManager", th2);
            mediaHTTPManager = null;
        }
        this.mMediaHTTPManager = mediaHTTPManager;
        if (this.mMediaHTTPManager != null) {
            this.mMediaHTTPManager.setBufferListener(new OnBufferListener() {
                public void onBufferReadyToPlay() {
                    if (!CorePlayer.this.mHasDecode) {
                        AudioType audioFormat = FormatDetector.getAudioFormat(CorePlayer.this.mFileName, false);
                        if (AudioFormat.isAudioType(audioFormat)) {
                            CorePlayer.this.mAudioType = audioFormat;
                            CorePlayer.this.mDecoder = MediaCodecFactory.createDecoderByType(audioFormat);
                            if (CorePlayer.this.mDecoder instanceof MP3Decoder) {
                                ((MP3Decoder) CorePlayer.this.mDecoder).setFileTotalLength(CorePlayer.this.mFileLength);
                            }
                            CorePlayer.this.mSeekTable = CorePlayer.createSeekTable(audioFormat, CorePlayer.this.mFileName);
                            new Thread(CorePlayer.this, "decoder-" + CorePlayer.this.mFileName).start();
                            return;
                        }
                        CorePlayer.this.callExceptionCallback(91, 55);
                    }
                }

                public void onBufferProgress(long j, long j2) {
                    CorePlayer.this.notifyDownloadProgress(j, j2);
                }
            });
            this.mMediaHTTPManager.setConnectionListener(new OnConnectionListener() {
                public void onConnected(long j, String str) {
                    CorePlayer.this.setFileLength(j);
                }

                public void onError(int i, int i2) {
                    synchronized (CorePlayer.this.bufferLock) {
                        CorePlayer.this.bufferLock.notifyAll();
                    }
                    CorePlayer.this.callExceptionCallback(i, i2);
                }
            });
            this.mMediaHTTPManager.setSniffListener(new OnSniffListener() {
                public boolean sniff() {
                    boolean z = false;
                    AudioType audioFormat = FormatDetector.getAudioFormat(CorePlayer.this.mFileName, false);
                    if (AudioFormat.isAudioType(audioFormat)) {
                        BaseDecoder createDecoderByType = MediaCodecFactory.createDecoderByType(audioFormat);
                        if (createDecoderByType.init(CorePlayer.this.mFileName, false) == 0) {
                            z = true;
                        }
                        if (z) {
                            createDecoderByType.release();
                        }
                    }
                    return z;
                }
            });
        } else if (playerCallback != null) {
            playerCallback.playerException(90, 70, 0);
        }
    }

    void setThreadName(String str) {
        this.mThreadName = str;
    }

    private void initHandler() {
        if (this.mHandler == null) {
            this.mHandler = new Handler(Looper.getMainLooper());
            Logger.e(TAG, "initHandler mHandler with getMainLooper");
        }
    }

    private void postRunnable(Runnable runnable, int i) {
        if (this.mHandler == null) {
            Logger.e(TAG, "postRunnable mHandler == null");
            initHandler();
        }
        if (this.mHandler != null) {
            this.mHandler.postDelayed(runnable, (long) i);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void notifyDownloadProgress(long r8, long r10) {
        /*
        r7 = this;
        r1 = r7.bufferLock;
        monitor-enter(r1);
        r2 = r7.bufferWaitingPosition;	 Catch:{ all -> 0x003a }
        r4 = 0;
        r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r0 != 0) goto L_0x000d;
    L_0x000b:
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
    L_0x000c:
        return;
    L_0x000d:
        r2 = r7.bufferWaitingPosition;	 Catch:{ all -> 0x003a }
        r0 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1));
        if (r0 >= 0) goto L_0x001b;
    L_0x0013:
        r2 = 1;
        r2 = r10 - r2;
        r0 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1));
        if (r0 != 0) goto L_0x0038;
    L_0x001b:
        r0 = "CorePlayer";
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x003a }
        r3 = "[onBufferProgress] notify buffer position: ";
        r2.<init>(r3);	 Catch:{ all -> 0x003a }
        r4 = r7.bufferWaitingPosition;	 Catch:{ all -> 0x003a }
        r2 = r2.append(r4);	 Catch:{ all -> 0x003a }
        r2 = r2.toString();	 Catch:{ all -> 0x003a }
        com.tencent.qqmusic.mediaplayer.util.Logger.i(r0, r2);	 Catch:{ all -> 0x003a }
        r0 = r7.bufferLock;	 Catch:{ all -> 0x003a }
        r0.notifyAll();	 Catch:{ all -> 0x003a }
    L_0x0038:
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        goto L_0x000c;
    L_0x003a:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qqmusic.mediaplayer.CorePlayer.notifyDownloadProgress(long, long):void");
    }

    private int calcBitDept(long j, long j2, int i, long j3) {
        return AudioRecognition.calcBitDept(j, j2, i, j3);
    }

    void exitNotCallback() {
        Logger.i(TAG, axiliary("exitNotCallback"));
        this.mIsExit = true;
    }

    void changePlayThreadPriorityImmediately() {
        Logger.d(TAG, axiliary("changePlayThreadPriorityImmediately"));
        this.mNeedChangePlayThreadPriority = true;
    }

    private long getCalcBitMinSize(AudioInformation audioInformation) {
        if (audioInformation != null) {
            return (long) (((((float) (audioInformation.getSampleRate() * ((long) audioInformation.getChannels()))) * 2.0f) * 5.0f) / 1000.0f);
        }
        return 0;
    }

    public void run() {
        int init;
        int i;
        CpuInfoUtil.startProcessInfoOutput();
        Logger.i(TAG, axiliary("run, thread: " + Thread.currentThread().getName()));
        PlayerConfigManager.getInstance().changeDecodeThreadPriorityIfNeed();
        if (this.mDecoder != null) {
            try {
                this.mCallback.playThreadStart();
                if (this.mDataSource != null) {
                    init = this.mDecoder.init(this.mDataSource);
                    Logger.i(TAG, axiliary("mDecoder init from dataSource: " + init));
                } else if (this.mNativeDataSource != null) {
                    init = this.mDecoder.init(this.mNativeDataSource);
                    Logger.i(TAG, axiliary("mDecoder init from native dataSource: " + init));
                } else {
                    init = this.mDecoder.init(this.mFileName, false);
                    Logger.i(TAG, axiliary("mDecoder init from filePath: " + init));
                }
                if (init == 0 || this.mIsExit) {
                    if (this.mDecoder instanceof MP3Decoder) {
                        ((MP3Decoder) this.mDecoder).setFileTotalLength(this.mFileLength);
                    }
                    this.mInformation = this.mDecoder.getAudioInformation();
                    if (this.mInformation == null || 0 == this.mInformation.getSampleRate()) {
                        this.mInformation = this.mDecoder.getAudioInformation();
                    }
                } else {
                    Logger.e(TAG, axiliary("不留痕迹的退出 时机：初始化时 step = 1"));
                    this.mStateRunner.transfer(Integer.valueOf(9));
                    callExceptionCallback(91, 62);
                    Logger.i(TAG, axiliary("thread finally, mIsExit = " + this.mIsExit));
                    if (this.monitor != null) {
                        this.monitor.stop();
                    }
                    CpuInfoUtil.stopProcessInfoOutput();
                    if (this.mDecoder != null) {
                        try {
                            this.mDecoder.release();
                            this.mDecoder = null;
                        } catch (Throwable th) {
                            Logger.e(TAG, axiliary("release throw a exception = " + th.getMessage()), th);
                        }
                    }
                    if (this.mDataSource != null) {
                        try {
                            this.mDataSource.close();
                        } catch (Throwable th2) {
                            Logger.e(TAG, axiliary("release dataSource throw a exception = " + th2.getMessage()), th2);
                        }
                    }
                    if (this.mAudioTrack != null) {
                        try {
                            this.mAudioTrack.stop();
                        } catch (Throwable th22) {
                            Logger.e(TAG, th22);
                        }
                        try {
                            this.mAudioTrack.flush();
                        } catch (Throwable th222) {
                            Logger.e(TAG, th222);
                        }
                        this.mCurrentFrameCount = 0;
                        try {
                            this.mAudioTrack.release();
                        } catch (Throwable th2222) {
                            Logger.e(TAG, th2222);
                        }
                        try {
                            destroyAudioListeners();
                        } catch (Throwable th22222) {
                            Logger.i(TAG, "[run] failed to destroyAudioListeners!", th22222);
                        }
                        this.mAudioTrack = null;
                        Logger.d(TAG, axiliary("finally release audioTrack"));
                        return;
                    }
                    return;
                }
            } catch (Throwable th222222) {
                Logger.i(TAG, "[run] failed to destroyAudioListeners!", th222222);
            }
        }
        if (this.mInformation == null || this.mIsExit) {
            if (!this.mIsExit) {
                Logger.e(TAG, axiliary("不留痕迹的退出 时机：获取Information时 step = 3"));
                this.mStateRunner.transfer(Integer.valueOf(9));
                callExceptionCallback(91, 63);
            }
            Logger.i(TAG, axiliary("thread finally, mIsExit = " + this.mIsExit));
            if (this.monitor != null) {
                this.monitor.stop();
            }
            CpuInfoUtil.stopProcessInfoOutput();
            if (this.mDecoder != null) {
                try {
                    this.mDecoder.release();
                    this.mDecoder = null;
                } catch (Throwable th2222222) {
                    Logger.e(TAG, axiliary("release throw a exception = " + th2222222.getMessage()), th2222222);
                }
            }
            if (this.mDataSource != null) {
                try {
                    this.mDataSource.close();
                } catch (Throwable th22222222) {
                    Logger.e(TAG, axiliary("release dataSource throw a exception = " + th22222222.getMessage()), th22222222);
                }
            }
            if (this.mAudioTrack != null) {
                try {
                    this.mAudioTrack.stop();
                } catch (Throwable th222222222) {
                    Logger.e(TAG, th222222222);
                }
                try {
                    this.mAudioTrack.flush();
                } catch (Throwable th2222222222) {
                    Logger.e(TAG, th2222222222);
                }
                this.mCurrentFrameCount = 0;
                try {
                    this.mAudioTrack.release();
                } catch (Throwable th22222222222) {
                    Logger.e(TAG, th22222222222);
                }
                try {
                    destroyAudioListeners();
                } catch (Throwable th222222222222) {
                    Logger.i(TAG, "[run] failed to destroyAudioListeners!", th222222222222);
                }
                this.mAudioTrack = null;
                Logger.d(TAG, axiliary("finally release audioTrack"));
                return;
            }
            return;
        }
        try {
            if (0 == this.mInformation.getSampleRate()) {
                Logger.e(TAG, "failed to getSampleRate");
                this.mStateRunner.transfer(Integer.valueOf(9));
                callExceptionCallback(91, 63);
                Logger.i(TAG, axiliary("thread finally, mIsExit = " + this.mIsExit));
                if (this.monitor != null) {
                    this.monitor.stop();
                }
                CpuInfoUtil.stopProcessInfoOutput();
                if (this.mDecoder != null) {
                    try {
                        this.mDecoder.release();
                        this.mDecoder = null;
                    } catch (Throwable th2222222222222) {
                        Logger.e(TAG, axiliary("release throw a exception = " + th2222222222222.getMessage()), th2222222222222);
                    }
                }
                if (this.mDataSource != null) {
                    try {
                        this.mDataSource.close();
                    } catch (Throwable th22222222222222) {
                        Logger.e(TAG, axiliary("release dataSource throw a exception = " + th22222222222222.getMessage()), th22222222222222);
                    }
                }
                if (this.mAudioTrack != null) {
                    try {
                        this.mAudioTrack.stop();
                    } catch (Throwable th222222222222222) {
                        Logger.e(TAG, th222222222222222);
                    }
                    try {
                        this.mAudioTrack.flush();
                    } catch (Throwable th2222222222222222) {
                        Logger.e(TAG, th2222222222222222);
                    }
                    this.mCurrentFrameCount = 0;
                    try {
                        this.mAudioTrack.release();
                    } catch (Throwable th22222222222222222) {
                        Logger.e(TAG, th22222222222222222);
                    }
                    try {
                        destroyAudioListeners();
                    } catch (Throwable th222222222222222222) {
                        Logger.i(TAG, "[run] failed to destroyAudioListeners!", th222222222222222222);
                    }
                    this.mAudioTrack = null;
                    Logger.d(TAG, axiliary("finally release audioTrack"));
                    return;
                }
                return;
            }
            this.mHasInit = true;
            if (!createAudioTrack()) {
                Logger.e(TAG, "failed to createAudioTrack");
                this.mStateRunner.transfer(Integer.valueOf(9));
                Logger.i(TAG, axiliary("thread finally, mIsExit = " + this.mIsExit));
                if (this.monitor != null) {
                    this.monitor.stop();
                }
                CpuInfoUtil.stopProcessInfoOutput();
                if (this.mDecoder != null) {
                    try {
                        this.mDecoder.release();
                        this.mDecoder = null;
                    } catch (Throwable th2222222222222222222) {
                        Logger.e(TAG, axiliary("release throw a exception = " + th2222222222222222222.getMessage()), th2222222222222222222);
                    }
                }
                if (this.mDataSource != null) {
                    try {
                        this.mDataSource.close();
                    } catch (Throwable th22222222222222222222) {
                        Logger.e(TAG, axiliary("release dataSource throw a exception = " + th22222222222222222222.getMessage()), th22222222222222222222);
                    }
                }
                if (this.mAudioTrack != null) {
                    try {
                        this.mAudioTrack.stop();
                    } catch (Throwable th222222222222222222222) {
                        Logger.e(TAG, th222222222222222222222);
                    }
                    try {
                        this.mAudioTrack.flush();
                    } catch (Throwable th2222222222222222222222) {
                        Logger.e(TAG, th2222222222222222222222);
                    }
                    this.mCurrentFrameCount = 0;
                    try {
                        this.mAudioTrack.release();
                    } catch (Throwable th22222222222222222222222) {
                        Logger.e(TAG, th22222222222222222222222);
                    }
                    try {
                        destroyAudioListeners();
                    } catch (Throwable th222222222222222222222222) {
                        Logger.i(TAG, "[run] failed to destroyAudioListeners!", th222222222222222222222222);
                    }
                    this.mAudioTrack = null;
                    Logger.d(TAG, axiliary("finally release audioTrack"));
                    return;
                }
                return;
            }
            this.mStateRunner.transfer(Integer.valueOf(2));
            initAudioListeners(this.mInformation.getPlaySample(), this.mInformation.getBitDept(), this.mInformation.getChannels());
            postRunnable(new Runnable() {
                public void run() {
                    CorePlayer.this.mCallback.playerPrepared();
                }
            }, 20);
            if (!(isPlaying() || this.mIsExit)) {
                Logger.i(TAG, axiliary("prepared. waiting..."));
                this.mSignalControl.doWait();
                Logger.i(TAG, axiliary("woke after preparing"));
            }
            PlayerConfigManager.getInstance().setCommonPlayerRef(this);
            this.monitor = new AudioTrackMonitor(this.mAudioTrack);
            this.monitor.start();
            this.mDecodeBufferInfo.setShortBufferCapacity(this.mBuffSize);
            i = 0;
            long j = 0;
            long currentTimeMillis = System.currentTimeMillis();
            long j2 = 0;
            int i2 = 0;
            int i3 = 0;
            while (!this.mIsExit) {
                init = -1;
                synchronized (this.mSeekRecord) {
                    if (!this.mSeekRecord.empty()) {
                        init = ((Integer) this.mSeekRecord.pop()).intValue();
                        this.mSeekRecord.clear();
                        Logger.i(TAG, "execute seek: " + init + ", abandon the others");
                    }
                }
                if (init < 0) {
                    if (this.mNeedFlush) {
                        init = getAudioTrackPosition(this.mCurrentFrameCount, this.mAudioTrack);
                        Logger.i(TAG, axiliary("[run] flashback to " + init));
                        this.mNeedFlush = false;
                    }
                }
                if (init >= 0) {
                    int seekTo = this.mDecoder.seekTo(init);
                    Logger.d(TAG, axiliary("seek result: " + seekTo + ", seek position: " + init));
                    if (seekTo < 0) {
                        Logger.e(TAG, axiliary("seekTo failed: " + seekTo));
                        this.mStateRunner.transfer(Integer.valueOf(9));
                        callExceptionCallback(95, 74);
                        Logger.i(TAG, axiliary("thread finally, mIsExit = " + this.mIsExit));
                        if (this.monitor != null) {
                            this.monitor.stop();
                        }
                        CpuInfoUtil.stopProcessInfoOutput();
                        if (this.mDecoder != null) {
                            try {
                                this.mDecoder.release();
                                this.mDecoder = null;
                            } catch (Throwable th2222222222222222222222222) {
                                Logger.e(TAG, axiliary("release throw a exception = " + th2222222222222222222222222.getMessage()), th2222222222222222222222222);
                            }
                        }
                        if (this.mDataSource != null) {
                            try {
                                this.mDataSource.close();
                            } catch (Throwable th22222222222222222222222222) {
                                Logger.e(TAG, axiliary("release dataSource throw a exception = " + th22222222222222222222222222.getMessage()), th22222222222222222222222222);
                            }
                        }
                        if (this.mAudioTrack != null) {
                            try {
                                this.mAudioTrack.stop();
                            } catch (Throwable th222222222222222222222222222) {
                                Logger.e(TAG, th222222222222222222222222222);
                            }
                            try {
                                this.mAudioTrack.flush();
                            } catch (Throwable th2222222222222222222222222222) {
                                Logger.e(TAG, th2222222222222222222222222222);
                            }
                            this.mCurrentFrameCount = 0;
                            try {
                                this.mAudioTrack.release();
                            } catch (Throwable th22222222222222222222222222222) {
                                Logger.e(TAG, th22222222222222222222222222222);
                            }
                            try {
                                destroyAudioListeners();
                            } catch (Throwable th222222222222222222222222222222) {
                                Logger.i(TAG, "[run] failed to destroyAudioListeners!", th222222222222222222222222222222);
                            }
                            this.mAudioTrack = null;
                            Logger.d(TAG, axiliary("finally release audioTrack"));
                            return;
                        }
                        return;
                    }
                    if (this.mAudioTrack != null) {
                        this.mCurrentFrameCount = Math.round((((double) init) / 1000.0d) * ((double) this.mAudioTrack.getSampleRate()));
                        if (this.mAudioTrack.getPlayState() == 3) {
                            this.mAudioTrack.pause();
                            this.mAudioTrack.flush();
                            this.mAudioTrack.play();
                        } else {
                            this.mAudioTrack.flush();
                        }
                        i2 = 0;
                    }
                    this.mCurPosition = (long) init;
                    this.mTimer.refreshTimeInMs((long) init);
                    notifySeekCompleteForAudioListeners((long) init);
                    this.mCallback.playerSeeked();
                }
                if (!isPaused()) {
                    if (isIdle() || isError() || isStopped()) {
                        break;
                    } else if (isCompleted()) {
                        init = (i2 / this.mInformation.getChannels()) - i3;
                        if (init <= 0) {
                            init = 0;
                        }
                        i = (this.mTrackBufferSizeInByte / this.mInformation.getBitDept()) / this.mInformation.getChannels();
                        if (init >= i) {
                            init = i;
                        }
                        init = (int) (((long) (init * 1000)) / this.mInformation.getSampleRate());
                        Logger.i(TAG, axiliary("writeShortCount: " + i2 + ", playFramePosition: " + i3 + ", leftTimeInMs: " + init));
                        if (init > 0) {
                            synchronized (this) {
                                wait((long) init);
                            }
                        }
                    } else {
                        long calcBitMinSize;
                        long j3;
                        int i4;
                        int i5;
                        long j4;
                        if (isPlaying() && this.mAudioTrack.getPlayState() != 3) {
                            this.mAudioTrack.play();
                        }
                        synchronized (this.bufferLock) {
                            if (this.bufferWaitingPosition > 0) {
                                Logger.i(TAG, "[run] waiting for more data. pos: " + this.bufferWaitingPosition);
                                this.isBuffering = true;
                                this.bufferLock.wait();
                                Logger.i(TAG, "[run] finish waiting. seekTo: " + this.bufferWaitingTime);
                                this.mTimer.refreshTimeInMs((long) this.bufferWaitingTime);
                                this.mDecoder.seekTo(this.bufferWaitingTime);
                                this.isBuffering = false;
                                this.bufferWaitingTime = 0;
                            }
                            this.bufferWaitingPosition = 0;
                        }
                        if (this.mDecoder != null) {
                            try {
                                init = this.mDecoder.decodeData(this.mBuffSize * 2, this.mDecodeBufferInfo.shortBuffer);
                                this.mDecodeBufferInfo.bufferSize = init / 2;
                                j += (long) (this.mDecodeBufferInfo.bufferSize * 2);
                                j2 += (long) (this.mDecodeBufferInfo.bufferSize * 2);
                                this.mHasDecode = true;
                                if (i == 0) {
                                    i = 10;
                                    calcBitMinSize = getCalcBitMinSize(this.mInformation);
                                    Logger.i(TAG, axiliary("minSize: " + calcBitMinSize + ", mDecodeBufferInfo.bufferSize: " + this.mDecodeBufferInfo.bufferSize));
                                    if (calcBitMinSize > 0) {
                                        j3 = j2;
                                        j2 = j;
                                        while (((long) this.mDecodeBufferInfo.bufferSize) < calcBitMinSize && i >= 0) {
                                            this.mDecodeBufferInfo.setTempShortBufferCapacity(this.mBuffSize);
                                            init = this.mDecoder.decodeData(this.mBuffSize * 2, this.mDecodeBufferInfo.tempShortBuffer);
                                            int i6 = init / 2;
                                            if (i6 > 0) {
                                                this.mDecodeBufferInfo.appendShort(this.mDecodeBufferInfo.tempShortBuffer, 0, i6);
                                                BufferInfo bufferInfo = this.mDecodeBufferInfo;
                                                bufferInfo.bufferSize += i6;
                                                j2 += (long) (i6 * 2);
                                                j3 += (long) (i6 * 2);
                                            }
                                            i--;
                                            Logger.d(TAG, axiliary("decode tmpSize: " + i6 + ", mDecodeBufferInfo.bufferSize: " + this.mDecodeBufferInfo.bufferSize));
                                        }
                                    } else {
                                        j3 = j2;
                                        j2 = j;
                                    }
                                    if (this.mInformation.getBitDept() == 0) {
                                        this.mInformation.setBitDept(calcBitDept(j2, getCurPositionByDecoder(), this.mInformation.getChannels(), this.mInformation.getSampleRate()));
                                    }
                                    i = this.mInformation.getBitDept();
                                    if (i >= 3 || i <= 0) {
                                        Logger.w(TAG, "mPlayBitDept is set with 2, old value: " + i);
                                        i = 2;
                                    }
                                    Logger.d(TAG, axiliary("mPlayBitDept: " + i));
                                    j = j2;
                                    j2 = j3;
                                }
                                i4 = init;
                                j3 = j;
                                i5 = i;
                                j4 = j2;
                            } catch (Throwable th2222222222222222222222222222222) {
                                Logger.e(TAG, th2222222222222222222222222222222);
                                this.mStateRunner.transfer(Integer.valueOf(9));
                                callExceptionCallback(92, 62);
                                Logger.i(TAG, axiliary("thread finally, mIsExit = " + this.mIsExit));
                                if (this.monitor != null) {
                                    this.monitor.stop();
                                }
                                CpuInfoUtil.stopProcessInfoOutput();
                                if (this.mDecoder != null) {
                                    this.mDecoder.release();
                                    this.mDecoder = null;
                                }
                            } catch (Throwable th22222222222222222222222222222222) {
                                Logger.i(TAG, "[run] failed to destroyAudioListeners!", th22222222222222222222222222222222);
                            }
                        } else {
                            i4 = Integer.MAX_VALUE;
                            j3 = j;
                            i5 = i;
                            j4 = j2;
                        }
                        if (this.mNeedChangePlayThreadPriority) {
                            this.mNeedChangePlayThreadPriority = false;
                            PlayerConfigManager.getInstance().changeDecodeThreadPriorityIfNeed();
                        }
                        j2 = System.currentTimeMillis();
                        j = j2 - currentTimeMillis;
                        if (j > 1000) {
                            PlayerConfigManager.getInstance().updateDecodeSpeed((long) ((((float) j4) * 1.0f) / ((float) j)));
                            j = 0;
                            calcBitMinSize = j2;
                        } else {
                            j = j4;
                            calcBitMinSize = currentTimeMillis;
                        }
                        if (this.mDecodeBufferInfo.bufferSize > 0) {
                            if (!this.mHasDecodeSuccess) {
                                this.mCallback.playerStarted();
                                this.mHasDecodeSuccess = true;
                            }
                            handleHighBitdept(this.mDecodeBufferInfo, this.m24BitBufferInfo);
                            handleHighSample(this.m24BitBufferInfo, this.mReSampleBufferInfo);
                            processAudioListeners(this.mReSampleBufferInfo, this.mDTSBufferInfo);
                            if (!(this.mDTSBufferInfo == null || this.mDTSBufferInfo.shortBuffer == null || this.mAudioTrack == null || !isPlaying())) {
                                Object obj;
                                for (int size = this.mTerminalAudioEffectList.size() - 1; size >= 0; size--) {
                                    IAudioListener iAudioListener = (IAudioListener) this.mTerminalAudioEffectList.get(size);
                                    if (iAudioListener.isEnabled()) {
                                        iAudioListener.onPcm(this.mReSampleBufferInfo, this.mDTSBufferInfo);
                                        obj = 1;
                                        break;
                                    }
                                }
                                obj = null;
                                if (obj == null) {
                                    init = this.mAudioTrack.write(this.mDTSBufferInfo.shortBuffer, 0, this.mDTSBufferInfo.bufferSize);
                                    if (init < 0) {
                                        Logger.e(TAG, axiliary("mAudioTrack write failed: " + init + ", expect: " + this.mDTSBufferInfo.bufferSize));
                                        this.mStateRunner.transfer(Integer.valueOf(9));
                                        callExceptionCallback(92, 102);
                                        Logger.i(TAG, axiliary("thread finally, mIsExit = " + this.mIsExit));
                                        if (this.monitor != null) {
                                            this.monitor.stop();
                                        }
                                        CpuInfoUtil.stopProcessInfoOutput();
                                        if (this.mDecoder != null) {
                                            try {
                                                this.mDecoder.release();
                                                this.mDecoder = null;
                                            } catch (Throwable th222222222222222222222222222222222) {
                                                Logger.e(TAG, axiliary("release throw a exception = " + th222222222222222222222222222222222.getMessage()), th222222222222222222222222222222222);
                                            }
                                        }
                                        if (this.mDataSource != null) {
                                            try {
                                                this.mDataSource.close();
                                            } catch (Throwable th2222222222222222222222222222222222) {
                                                Logger.e(TAG, axiliary("release dataSource throw a exception = " + th2222222222222222222222222222222222.getMessage()), th2222222222222222222222222222222222);
                                            }
                                        }
                                        if (this.mAudioTrack != null) {
                                            try {
                                                this.mAudioTrack.stop();
                                            } catch (Throwable th22222222222222222222222222222222222) {
                                                Logger.e(TAG, th22222222222222222222222222222222222);
                                            }
                                            try {
                                                this.mAudioTrack.flush();
                                            } catch (Throwable th222222222222222222222222222222222222) {
                                                Logger.e(TAG, th222222222222222222222222222222222222);
                                            }
                                            this.mCurrentFrameCount = 0;
                                            try {
                                                this.mAudioTrack.release();
                                            } catch (Throwable th2222222222222222222222222222222222222) {
                                                Logger.e(TAG, th2222222222222222222222222222222222222);
                                            }
                                            try {
                                                destroyAudioListeners();
                                            } catch (Throwable th22222222222222222222222222222222222222) {
                                                Logger.i(TAG, "[run] failed to destroyAudioListeners!", th22222222222222222222222222222222222222);
                                            }
                                            this.mAudioTrack = null;
                                            Logger.d(TAG, axiliary("finally release audioTrack"));
                                            return;
                                        }
                                        return;
                                    }
                                    if (init != this.mDTSBufferInfo.bufferSize) {
                                        Logger.w(TAG, axiliary("mAudioTrack write not equal: " + init + ", expect: " + this.mDTSBufferInfo.bufferSize));
                                    }
                                    i = i2 + this.mDTSBufferInfo.bufferSize;
                                    init = this.mAudioTrack.getPlaybackHeadPosition();
                                } else {
                                    init = i3;
                                    i = i2;
                                }
                                j2 = j;
                                currentTimeMillis = calcBitMinSize;
                                i3 = init;
                                i2 = i;
                                j = j3;
                                i = i5;
                            }
                        } else {
                            decodeEndOrFailed(i4);
                        }
                        j2 = j;
                        currentTimeMillis = calcBitMinSize;
                        i = i5;
                        j = j3;
                    }
                } else {
                    if (this.mAudioTrack.getPlayState() != 2) {
                        this.mAudioTrack.pause();
                    }
                    postRunnable(new Runnable() {
                        public void run() {
                            CorePlayer.this.mCallback.playerPaused();
                        }
                    }, 20);
                    Logger.i(TAG, axiliary("paused. waiting..."));
                    this.mSignalControl.doWait();
                    Logger.i(TAG, axiliary("woke after pausing"));
                }
            }
            Logger.i(TAG, axiliary("thread finally, mIsExit = " + this.mIsExit));
            if (this.monitor != null) {
                this.monitor.stop();
            }
            CpuInfoUtil.stopProcessInfoOutput();
            if (this.mDecoder != null) {
                try {
                    this.mDecoder.release();
                    this.mDecoder = null;
                } catch (Throwable th222222222222222222222222222222222222222) {
                    Logger.e(TAG, axiliary("release throw a exception = " + th222222222222222222222222222222222222222.getMessage()), th222222222222222222222222222222222222222);
                }
            }
            if (this.mDataSource != null) {
                try {
                    this.mDataSource.close();
                } catch (Throwable th2222222222222222222222222222222222222222) {
                    Logger.e(TAG, axiliary("release dataSource throw a exception = " + th2222222222222222222222222222222222222222.getMessage()), th2222222222222222222222222222222222222222);
                }
            }
            if (this.mAudioTrack != null) {
                try {
                    this.mAudioTrack.stop();
                } catch (Throwable th22222222222222222222222222222222222222222) {
                    Logger.e(TAG, th22222222222222222222222222222222222222222);
                }
                try {
                    this.mAudioTrack.flush();
                } catch (Throwable th222222222222222222222222222222222222222222) {
                    Logger.e(TAG, th222222222222222222222222222222222222222222);
                }
                this.mCurrentFrameCount = 0;
                try {
                    this.mAudioTrack.release();
                } catch (Throwable th2222222222222222222222222222222222222222222) {
                    Logger.e(TAG, th2222222222222222222222222222222222222222222);
                }
                try {
                    destroyAudioListeners();
                } catch (Throwable th22222222222222222222222222222222222222222222) {
                    Logger.i(TAG, "[run] failed to destroyAudioListeners!", th22222222222222222222222222222222222222222222);
                }
                this.mAudioTrack = null;
                Logger.d(TAG, axiliary("finally release audioTrack"));
            }
            if (!this.mIsExit) {
                if (this.mStateRunner.isEqual(Integer.valueOf(7))) {
                    this.mCallback.playerEnded();
                } else {
                    this.mCallback.playerStopped();
                }
            }
            Logger.i(TAG, axiliary("exit, thread: " + Thread.currentThread().getName()));
            return;
        } catch (Throwable th222222222222222222222222222222222222222222222) {
            Logger.e(TAG, th222222222222222222222222222222222222222222222);
        }
        this.mCurrentFrameCount = 0;
        this.mAudioTrack.release();
        destroyAudioListeners();
        this.mAudioTrack = null;
        Logger.d(TAG, axiliary("finally release audioTrack"));
        return;
        this.mCurrentFrameCount = 0;
        this.mAudioTrack.release();
        destroyAudioListeners();
        this.mAudioTrack = null;
        Logger.d(TAG, axiliary("finally release audioTrack"));
        if (this.mDataSource != null) {
            try {
                this.mDataSource.close();
            } catch (Throwable th2222222222222222222222222222222222222222222222) {
                Logger.e(TAG, axiliary("release dataSource throw a exception = " + th2222222222222222222222222222222222222222222222.getMessage()), th2222222222222222222222222222222222222222222222);
            }
        }
        if (this.mAudioTrack != null) {
            this.mAudioTrack.stop();
            this.mAudioTrack.flush();
            this.mCurrentFrameCount = 0;
            this.mAudioTrack.release();
            destroyAudioListeners();
            this.mAudioTrack = null;
            Logger.d(TAG, axiliary("finally release audioTrack"));
            return;
        }
        return;
        destroyAudioListeners();
        this.mAudioTrack = null;
        Logger.d(TAG, axiliary("finally release audioTrack"));
        return;
        destroyAudioListeners();
        this.mAudioTrack = null;
        Logger.d(TAG, axiliary("finally release audioTrack"));
        this.mAudioTrack = null;
        Logger.d(TAG, axiliary("finally release audioTrack"));
        return;
        if (this.mAudioTrack != null) {
            this.mAudioTrack.stop();
            this.mAudioTrack.flush();
            this.mCurrentFrameCount = 0;
            this.mAudioTrack.release();
            destroyAudioListeners();
            this.mAudioTrack = null;
            Logger.d(TAG, axiliary("finally release audioTrack"));
            return;
        }
        return;
        this.mAudioTrack = null;
        Logger.d(TAG, axiliary("finally release audioTrack"));
        if (this.mDataSource != null) {
            try {
                this.mDataSource.close();
            } catch (Throwable th3) {
                Logger.e(TAG, axiliary("release dataSource throw a exception = " + th3.getMessage()), th3);
            }
        }
        if (this.mAudioTrack != null) {
            this.mAudioTrack.stop();
            this.mAudioTrack.flush();
            this.mCurrentFrameCount = 0;
            this.mAudioTrack.release();
            destroyAudioListeners();
            this.mAudioTrack = null;
            Logger.d(TAG, axiliary("finally release audioTrack"));
        }
        this.mAudioTrack.flush();
        this.mCurrentFrameCount = 0;
        this.mAudioTrack.release();
        destroyAudioListeners();
        this.mAudioTrack = null;
        Logger.d(TAG, axiliary("finally release audioTrack"));
        return;
        if (this.mAudioTrack != null) {
            this.mAudioTrack.stop();
            this.mAudioTrack.flush();
            this.mCurrentFrameCount = 0;
            this.mAudioTrack.release();
            destroyAudioListeners();
            this.mAudioTrack = null;
            Logger.d(TAG, axiliary("finally release audioTrack"));
        }
        this.mCurrentFrameCount = 0;
        this.mAudioTrack.release();
        destroyAudioListeners();
        this.mAudioTrack = null;
        Logger.d(TAG, axiliary("finally release audioTrack"));
        return;
        this.mAudioTrack.flush();
        this.mCurrentFrameCount = 0;
        this.mAudioTrack.release();
        destroyAudioListeners();
        this.mAudioTrack = null;
        Logger.d(TAG, axiliary("finally release audioTrack"));
        destroyAudioListeners();
        this.mAudioTrack = null;
        Logger.d(TAG, axiliary("finally release audioTrack"));
        return;
        this.mAudioTrack = null;
        Logger.d(TAG, axiliary("finally release audioTrack"));
        return;
        this.mCurrentFrameCount = 0;
        this.mAudioTrack.release();
        destroyAudioListeners();
        this.mAudioTrack = null;
        Logger.d(TAG, axiliary("finally release audioTrack"));
        destroyAudioListeners();
        this.mAudioTrack = null;
        Logger.d(TAG, axiliary("finally release audioTrack"));
        this.mAudioTrack = null;
        Logger.d(TAG, axiliary("finally release audioTrack"));
        if (this.mDataSource != null) {
            try {
                this.mDataSource.close();
            } catch (Throwable th22222222222222222222222222222222222222222222222) {
                Logger.e(TAG, axiliary("release dataSource throw a exception = " + th22222222222222222222222222222222222222222222222.getMessage()), th22222222222222222222222222222222222222222222222);
            }
        }
        if (this.mAudioTrack != null) {
            this.mAudioTrack.stop();
            this.mAudioTrack.flush();
            this.mCurrentFrameCount = 0;
            this.mAudioTrack.release();
            destroyAudioListeners();
            this.mAudioTrack = null;
            Logger.d(TAG, axiliary("finally release audioTrack"));
            return;
        }
        return;
        if (this.mDataSource != null) {
            try {
                this.mDataSource.close();
            } catch (Throwable th222222222222222222222222222222222222222222222222) {
                Logger.e(TAG, axiliary("release dataSource throw a exception = " + th222222222222222222222222222222222222222222222222.getMessage()), th222222222222222222222222222222222222222222222222);
            }
        }
        if (this.mAudioTrack != null) {
            this.mAudioTrack.stop();
            this.mAudioTrack.flush();
            this.mCurrentFrameCount = 0;
            this.mAudioTrack.release();
            destroyAudioListeners();
            this.mAudioTrack = null;
            Logger.d(TAG, axiliary("finally release audioTrack"));
        }
        return;
        if (this.mAudioTrack != null) {
            this.mAudioTrack.stop();
            this.mAudioTrack.flush();
            this.mCurrentFrameCount = 0;
            this.mAudioTrack.release();
            destroyAudioListeners();
            this.mAudioTrack = null;
            Logger.d(TAG, axiliary("finally release audioTrack"));
            return;
        }
        return;
        if (this.mAudioTrack != null) {
            this.mAudioTrack.stop();
            this.mAudioTrack.flush();
            this.mCurrentFrameCount = 0;
            this.mAudioTrack.release();
            destroyAudioListeners();
            this.mAudioTrack = null;
            Logger.d(TAG, axiliary("finally release audioTrack"));
        }
        return;
        this.mAudioTrack.flush();
        this.mCurrentFrameCount = 0;
        this.mAudioTrack.release();
        destroyAudioListeners();
        this.mAudioTrack = null;
        Logger.d(TAG, axiliary("finally release audioTrack"));
        return;
        this.mAudioTrack.flush();
        this.mCurrentFrameCount = 0;
        this.mAudioTrack.release();
        destroyAudioListeners();
        this.mAudioTrack = null;
        Logger.d(TAG, axiliary("finally release audioTrack"));
    }

    private void handleHighBitdept(BufferInfo bufferInfo, BufferInfo bufferInfo2) {
        int i = 0;
        if (bufferInfo != null && bufferInfo.shortBuffer != null && bufferInfo.bufferSize > 0 && bufferInfo2 != null) {
            if (this.mInformation.getBitDept() != 3) {
                bufferInfo.copy(bufferInfo2);
                return;
            }
            try {
                int i2 = bufferInfo.bufferSize;
                bufferInfo2.setTempByteBufferCapacity(this.mBuffSize * 2);
                for (int i3 = 0; i3 < i2; i3++) {
                    int i4;
                    if ((i3 * 2) % 3 != 0) {
                        i4 = i + 1;
                        bufferInfo2.tempByteBuffer[i] = (byte) bufferInfo.shortBuffer[i3];
                    } else {
                        i4 = i;
                    }
                    if (((i3 * 2) + 1) % 3 != 0) {
                        i = i4 + 1;
                        bufferInfo2.tempByteBuffer[i4] = (byte) (bufferInfo.shortBuffer[i3] >> 8);
                    } else {
                        i = i4;
                    }
                }
                bufferInfo2.fillShort(bufferInfo2.tempByteBuffer, i);
                bufferInfo2.bufferSize = i / 2;
            } catch (Throwable th) {
                Logger.e(TAG, th);
            }
        }
    }

    private void handleHighSample(BufferInfo bufferInfo, BufferInfo bufferInfo2) {
        if (bufferInfo != null && bufferInfo.shortBuffer != null && bufferInfo.bufferSize > 0 && bufferInfo2 != null) {
            if (this.mInformation.getSampleRate() == this.mPlaySample) {
                bufferInfo.copy(bufferInfo2);
                return;
            }
            try {
                ReSample.reSample(bufferInfo, bufferInfo2, this.mInformation.getSampleRate(), this.mPlaySample);
            } catch (Throwable th) {
                Logger.e(TAG, th);
            }
        }
    }

    private boolean createAudioTrack() {
        Logger.d(TAG, axiliary("createAudioTrack"));
        if (!this.mStateRunner.isEqual(Integer.valueOf(3))) {
            Logger.e(TAG, "mState is not preparing");
            callExceptionCallback(91, 54);
            return false;
        } else if (this.mInformation.getSampleRate() <= 0) {
            Logger.e(TAG, "mInformation.getSampleRate() failed");
            callExceptionCallback(91, 64);
            return false;
        } else {
            int i;
            int i2;
            int i3;
            int i4;
            int i5 = 12;
            int channels = this.mInformation.getChannels();
            if (channels == 1) {
                i5 = 4;
            } else if (channels == 2) {
                i5 = 12;
            } else if (channels == 6) {
                i5 = ah.CTRL_BYTE;
            } else if (channels == 8) {
                i5 = 1020;
            }
            try {
                if (this.mDecoder instanceof FLACDecoder) {
                    i = ((FLACDecoder) this.mDecoder).getminBufferSize() / 2;
                } else {
                    i = 0;
                }
                i2 = 92;
                i3 = 66;
            } catch (Throwable e) {
                Logger.e(TAG, e);
                i2 = 91;
                i3 = 62;
                i = 0;
            }
            Logger.d(TAG, axiliary(this.mInformation.toString()));
            this.mPlaySample = this.mInformation.getSampleRate();
            while (this.mPlaySample > 48000) {
                this.mPlaySample /= 2;
            }
            this.mInformation.setPlaySample(this.mPlaySample);
            int bitDept = this.mInformation.getBitDept();
            if (bitDept == 0) {
                i4 = 2;
            } else {
                i4 = bitDept;
            }
            bitDept = AudioTrack.getMinBufferSize((int) this.mPlaySample, i5, i4 == 1 ? 3 : 2);
            if (bitDept < 0) {
                callExceptionCallback(92, 66);
                return false;
            }
            int i6;
            if (AudioType.FLAC.equals(this.mAudioType)) {
                this.mBuffSize = i;
                i6 = bitDept;
            } else {
                if (bitDept % 2048 != 0) {
                    i = ((bitDept / 2048) + 1) * 2048;
                } else {
                    i = bitDept;
                }
                this.mBuffSize = i;
                this.mBuffSize /= PlayerConfigManager.getInstance().getBufRatio();
                this.mBuffSize *= 2;
                i6 = i;
            }
            if (this.mDecoder instanceof FfmpegPlayer) {
                this.mBuffSize = Math.max(Downloads.RECV_BUFFER_SIZE, this.mBuffSize);
            }
            if (this.mDecoder instanceof MP3Decoder) {
                ((MP3Decoder) this.mDecoder).initInputBuffer(this.mBuffSize);
            }
            Logger.d(TAG, axiliary(String.format("playback_bufsize: %d, mBuffSize: %d, mPlaySample: %d, playChannel: %d", new Object[]{Integer.valueOf(i6), Integer.valueOf(this.mBuffSize), Long.valueOf(this.mPlaySample), Integer.valueOf(channels)})));
            i = Math.max((int) (Math.floor((double) ((((1 * this.mPlaySample) * ((long) channels)) * 2) / ((long) i6))) + 1.0d), 1);
            Logger.d(TAG, axiliary("times: " + i + ", MIN_AUDIO_TRACK_BUFFER_TIMES: 1"));
            int i7 = i;
            while (i7 > 0) {
                try {
                    this.mTrackBufferSizeInByte = i6 * i7;
                    this.mAudioTrack = new AudioTrack(this.mAudioStreamType, (int) this.mPlaySample, i5, i4 == 1 ? 3 : 2, this.mTrackBufferSizeInByte, 1);
                    Logger.d(TAG, axiliary("new AudioTrack, sampleRate: " + this.mPlaySample + ", channels: " + i5 + ", bitDepth: " + i4 + ", buffer: " + this.mTrackBufferSizeInByte));
                    if (this.mAudioTrack.getState() == 1) {
                        Logger.d(TAG, axiliary("new AudioTrack succeed"));
                        break;
                    }
                    this.mAudioTrack.release();
                    i7 -= 2;
                } catch (Throwable e2) {
                    Logger.e(TAG, e2);
                }
            }
            if (this.mAudioTrack == null || this.mAudioTrack.getState() != 1) {
                this.mCreateAudioTrackFail = true;
                Logger.e(TAG, axiliary("create audioTrack fail mCreateAudioTrackFail = true"));
                this.mAudioTrack = null;
                callExceptionCallback(i2, i3);
                return false;
            }
            Logger.d(TAG, axiliary("create audioTrack success times = " + i7));
            return true;
        }
    }

    public void callExceptionCallback(int i, int i2) {
        callExceptionCallback(i, i2, 0);
    }

    private void callExceptionCallback(int i, int i2, int i3) {
        if (this.mCallback != null) {
            this.mCallback.playerException(i, i2, i3);
        }
    }

    private String axiliary(String str) {
        return "ID: " + this.mPlayerID + ". " + str;
    }

    private boolean decodeEndOrFailed(int i) {
        Logger.d(TAG, axiliary("decodeEndOrFaild"));
        try {
            if (!(this.mDecoder == null || this.mInformation == null)) {
                Logger.i(TAG, axiliary(String.format("current: %d, duration: %d, isExit: %b, decodeSucc: %b", new Object[]{Long.valueOf(this.mDecoder.getCurrentTime()), Long.valueOf(this.mInformation.getDuration()), Boolean.valueOf(this.mIsExit), Boolean.valueOf(this.mHasDecodeSuccess)})));
                i &= this.mDecoder.getErrorCodeMask();
            }
            if (this.mIsExit || !this.mHasDecodeSuccess) {
                Logger.i(TAG, axiliary("不留痕迹的退出 时机：解码时退出  step = 4"));
                exitNotCallback();
                this.mStateRunner.transfer(Integer.valueOf(9));
                callExceptionCallback(92, 67, i);
                return true;
            } else if (getCurPositionByDecoder() > 0 && this.mFileName != null && !this.mFileName.contains("/qqmusic/") && !this.mFileName.contains("/com.tencent.qqmusic/")) {
                Logger.i(TAG, axiliary("Decode ended! Exiting. mFileName = " + this.mFileName + ",is't qqmusic file."));
                if (this.mInformation == null || this.mMediaHTTPManager == null || this.mMediaHTTPManager.isDownloadFinished()) {
                    this.mStateRunner.transfer(Integer.valueOf(7));
                    return true;
                }
                int i2;
                int bitrate = this.mInformation.getBitrate();
                if (bitrate == 0) {
                    i2 = 320;
                } else {
                    i2 = bitrate;
                }
                long duration = getDuration();
                if (duration == 0) {
                    duration = 300000;
                }
                this.bufferWaitingTime = (int) getCurPositionByDecoder();
                this.bufferWaitingPosition = getFirstPieceSize(5, i2, duration) + this.mMediaHTTPManager.getBufferedFileLength();
                Logger.i(TAG, "[decodeEndOrFailed] lack of data. setting bufferWaitingPosition to " + this.bufferWaitingPosition);
                return false;
            } else if (getCurPositionByDecoder() < getDuration() - 5000) {
                Logger.e(TAG, axiliary("Decode failed! Exiting."));
                callExceptionCallback(92, 67, i);
                this.mStateRunner.transfer(Integer.valueOf(6));
                return false;
            } else {
                Logger.i(TAG, axiliary("Decode ended! Exiting."));
                this.mStateRunner.transfer(Integer.valueOf(7));
                return true;
            }
        } catch (Throwable th) {
            Logger.e(TAG, th);
            return true;
        }
    }

    long getDuration() {
        if (this.mInformation != null) {
            try {
                return this.mInformation.getDuration();
            } catch (Throwable th) {
                Logger.e(TAG, th);
            }
        }
        return 0;
    }

    long getCurPosition() {
        if (this.mDecoder == null) {
            return this.mCurPosition;
        }
        if (this.isBuffering) {
            return this.mCurPosition;
        }
        if (isPlaying() || isCompleted()) {
            this.mCurPosition = this.mTimer.getTimeInMs();
        }
        return this.mCurPosition;
    }

    long getCurPositionByDecoder() {
        if (this.mDecoder == null) {
            return this.mCurPosition;
        }
        try {
            return this.mDecoder.getCurrentTime();
        } catch (Throwable e) {
            Logger.e(TAG, e);
            return 0;
        } catch (Throwable e2) {
            Logger.e(TAG, "Strange Exception!", e2);
            return 0;
        }
    }

    public void prepare() {
        Logger.i(TAG, axiliary("prepare"));
        this.mStateRunner.transfer(Integer.valueOf(3));
        if (this.mMediaHTTPManager != null) {
            this.mMediaHTTPManager.prepare();
        } else {
            new Thread(this, "decoder-" + this.mThreadName).start();
        }
    }

    void play() {
        Logger.i(TAG, axiliary("play"));
        this.mTimer.refreshTimeInMs(this.mCurPosition);
        this.mStateRunner.transfer(Integer.valueOf(4));
        if (this.mSignalControl.isWaiting()) {
            Logger.d(TAG, axiliary("lock is Waiting, event: play, doNotify"));
            this.mSignalControl.doNotify();
        }
    }

    void pause() {
        Logger.i(TAG, axiliary("pause"));
        this.mStateRunner.transfer(Integer.valueOf(5), Integer.valueOf(4), Integer.valueOf(2));
    }

    void stop() {
        Logger.i(TAG, axiliary("stop"));
        if (this.mStateRunner.transfer(Integer.valueOf(6), Integer.valueOf(4), Integer.valueOf(5), Integer.valueOf(2)) && this.mSignalControl.isWaiting()) {
            Logger.d(TAG, axiliary("lock is Waiting, event: stop, doNotify"));
            this.mSignalControl.doNotify();
        }
        synchronized (this.bufferLock) {
            this.bufferLock.notifyAll();
        }
    }

    public void seek(int i) {
        if (this.mMediaHTTPManager != null) {
            if (this.mOnlineSeekHandler == null || this.mOnlineSeekHandlerThread == null || !this.mOnlineSeekHandlerThread.isAlive()) {
                this.mOnlineSeekHandlerThread = new HandlerThread("CorePlayer_online_seek_handler_thread");
                this.mOnlineSeekHandlerThread.start();
                this.mOnlineSeekHandler = new OnlineSeekHandler(this.mOnlineSeekHandlerThread.getLooper(), this);
            }
            this.mOnlineSeekHandler.removeMessages(MSG_SEEK);
            Message.obtain(this.mOnlineSeekHandler, MSG_SEEK, Long.valueOf((long) i)).sendToTarget();
            return;
        }
        addSeekRecord(i);
        refreshTimeAndNotify(i);
    }

    public void addSeekRecord(int i) {
        synchronized (this.mSeekRecord) {
            Logger.i(TAG, "add seek: " + i);
            this.mSeekRecord.push(Integer.valueOf(i));
        }
    }

    public void refreshTimeAndNotify(int i) {
        this.mTimer.refreshTimeInMs((long) i);
        if (this.mSignalControl.isWaiting()) {
            Logger.d(TAG, axiliary("lock is Waiting, event: seek, doNotify"));
            this.mSignalControl.doNotify();
        }
    }

    public void release() {
        Logger.i(TAG, axiliary("release"));
        if (this.mMediaHTTPManager != null) {
            this.mMediaHTTPManager.release();
        }
        if (this.mOnlineSeekHandler != null) {
            this.mOnlineSeekHandler.removeCallbacksAndMessages(null);
        }
        if (this.mOnlineSeekHandlerThread != null) {
            if (VERSION.SDK_INT >= 19) {
                this.mOnlineSeekHandlerThread.quitSafely();
            } else {
                this.mOnlineSeekHandlerThread.quit();
            }
        }
        if (this.mHandler != null) {
            Looper looper = this.mHandler.getLooper();
            if (looper != null) {
                if (VERSION.SDK_INT >= 19) {
                    looper.quitSafely();
                } else {
                    looper.quit();
                }
            }
        }
        exitNotCallback();
        if (this.mSignalControl.isWaiting()) {
            Logger.d(TAG, axiliary("lock is Waiting, event: release, doNotify"));
            this.mSignalControl.doNotify();
        }
        this.mStateRunner.transfer(Integer.valueOf(8));
    }

    int getPlayerState() {
        return ((Integer) this.mStateRunner.get()).intValue();
    }

    synchronized boolean hasDecodeData() {
        return this.mHasDecode;
    }

    boolean isCreateAudioTrackFail() {
        return this.mCreateAudioTrackFail;
    }

    synchronized boolean hasDecodeDataSuccess() {
        return this.mHasDecodeSuccess;
    }

    boolean isInit() {
        return this.mHasInit;
    }

    private synchronized boolean isError() {
        return this.mStateRunner.isEqual(Integer.valueOf(9));
    }

    private synchronized boolean isIdle() {
        return this.mStateRunner.isEqual(Integer.valueOf(0));
    }

    public synchronized boolean isPlaying() {
        return this.mStateRunner.isEqual(Integer.valueOf(4));
    }

    public synchronized boolean isPaused() {
        return this.mStateRunner.isEqual(Integer.valueOf(5));
    }

    private synchronized boolean isStopped() {
        return this.mStateRunner.isEqual(Integer.valueOf(6));
    }

    private synchronized boolean isCompleted() {
        return this.mStateRunner.isEqual(Integer.valueOf(7));
    }

    void setVolume(float f, float f2) {
        if (this.mAudioTrack != null) {
            this.mAudioTrack.setStereoVolume(f, f2);
        }
    }

    void setAudioStreamType(int i) {
        Throwable e;
        if (i != this.mAudioStreamType) {
            try {
                this.mAudioStreamType = i;
                if (this.mAudioTrack != null) {
                    AudioTrack audioTrack = new AudioTrack(i, this.mAudioTrack.getSampleRate(), this.mAudioTrack.getChannelConfiguration(), this.mAudioTrack.getAudioFormat(), this.mTrackBufferSizeInByte, 1);
                    int playState = this.mAudioTrack.getPlayState();
                    if (playState == 3) {
                        pause();
                    }
                    this.mAudioTrack.release();
                    this.mAudioTrack = audioTrack;
                    if (playState == 3) {
                        play();
                    }
                }
            } catch (IllegalArgumentException e2) {
                e = e2;
                Logger.e(TAG, "failed in setting audio stream type to :" + i, e);
            } catch (IllegalStateException e3) {
                e = e3;
                Logger.e(TAG, "failed in setting audio stream type to :" + i, e);
            }
        }
    }

    void copyPlayerStatus(CorePlayer corePlayer) {
    }

    AudioInformation getCurrentAudioInformation() {
        if (this.mInformation != null) {
            this.mInformation.setAudioType(this.mAudioType);
        }
        return this.mInformation;
    }

    String getPlayingFilePath() {
        return this.mFileName;
    }

    int getSessionId() {
        if (this.mAudioTrack == null || VERSION.SDK_INT < 9) {
            return 0;
        }
        return this.mAudioTrack.getAudioSessionId();
    }

    void setFileLength(long j) {
        this.mFileLength = j;
        try {
            if (this.mDecoder != null && (this.mDecoder instanceof MP3Decoder)) {
                ((MP3Decoder) this.mDecoder).setFileTotalLength(j);
                this.mInformation = this.mDecoder.getAudioInformation();
            }
        } catch (Throwable th) {
            Logger.e(TAG, th);
        }
    }

    void addAudioListener(IAudioListener iAudioListener) {
        if (iAudioListener.isTerminal()) {
            synchronized (this.mTerminalAudioEffectList) {
                if (!this.mTerminalAudioEffectList.contains(iAudioListener)) {
                    this.mTerminalAudioEffectList.add(iAudioListener);
                    Logger.i(TAG, "[addAudioListener] terminal audio added: " + iAudioListener);
                }
            }
        } else {
            synchronized (this.audioEffects) {
                if (!this.audioEffects.contains(iAudioListener)) {
                    this.audioEffects.add(iAudioListener);
                    Logger.i(TAG, "[addAudioListener] audio added: " + iAudioListener);
                }
            }
        }
        if (this.mInformation == null || this.mInformation.getPlaySample() <= 0 || this.mInformation.getChannels() <= 0) {
            Logger.i(TAG, "[addAudioListener] audio information not ready. init will be delayed.");
            return;
        }
        long onPlayerReady;
        try {
            onPlayerReady = iAudioListener.onPlayerReady(this.mInformation.getPlaySample(), this.mInformation.getBitDept(), this.mInformation.getChannels());
        } catch (Throwable th) {
            Logger.e(TAG, "[addAudioListener] failed to init audio: " + iAudioListener, th);
            onPlayerReady = 0;
        }
        if (onPlayerReady != 0) {
            Logger.e(TAG, "[addAudioListener] failed to init audio %s, ret: %d", iAudioListener, Long.valueOf(onPlayerReady));
        }
    }

    void removeAudioListener(IAudioListener iAudioListener) {
        synchronized (this.audioEffects) {
            if (this.audioEffects.remove(iAudioListener)) {
                Logger.i(TAG, "[removeAudioListener] audio removed: " + iAudioListener);
            }
        }
        synchronized (this.mTerminalAudioEffectList) {
            if (this.mTerminalAudioEffectList.remove(iAudioListener)) {
                Logger.i(TAG, "[removeAudioListener] terminal audio removed: " + iAudioListener);
            }
        }
    }

    private void initAudioListeners(long j, int i, int i2) {
        synchronized (this.audioEffects) {
            for (IAudioListener onPlayerReady : this.audioEffects) {
                onPlayerReady.onPlayerReady(j, i, i2);
            }
        }
        synchronized (this.mTerminalAudioEffectList) {
            for (IAudioListener onPlayerReady2 : this.mTerminalAudioEffectList) {
                onPlayerReady2.onPlayerReady(j, i, i2);
            }
        }
    }

    private void destroyAudioListeners() {
        synchronized (this.audioEffects) {
            for (IAudioListener onPlayerStopped : this.audioEffects) {
                onPlayerStopped.onPlayerStopped();
            }
        }
        synchronized (this.mTerminalAudioEffectList) {
            for (IAudioListener onPlayerStopped2 : this.mTerminalAudioEffectList) {
                onPlayerStopped2.onPlayerStopped();
            }
        }
    }

    private void notifySeekCompleteForAudioListeners(long j) {
        synchronized (this.audioEffects) {
            for (IAudioListener onPlayerSeekComplete : this.audioEffects) {
                onPlayerSeekComplete.onPlayerSeekComplete(j);
            }
        }
        synchronized (this.mTerminalAudioEffectList) {
            for (IAudioListener onPlayerSeekComplete2 : this.mTerminalAudioEffectList) {
                onPlayerSeekComplete2.onPlayerSeekComplete(j);
            }
        }
    }

    void processAudioListeners(BufferInfo bufferInfo, BufferInfo bufferInfo2) {
        synchronized (this.audioEffects) {
            if (this.audioEffects.size() == 0) {
                bufferInfo.copy(bufferInfo2);
            } else {
                BufferInfo bufferInfo3 = bufferInfo2;
                BufferInfo bufferInfo4 = bufferInfo;
                for (IAudioListener iAudioListener : this.audioEffects) {
                    if (!iAudioListener.isEnabled()) {
                        bufferInfo4.copy(bufferInfo3);
                    } else if (processAudioListener(iAudioListener, bufferInfo4, bufferInfo3)) {
                        BufferInfo bufferInfo5 = bufferInfo4;
                        bufferInfo4 = bufferInfo3;
                        bufferInfo3 = bufferInfo5;
                    } else {
                        bufferInfo4.copy(bufferInfo3);
                    }
                }
                if (bufferInfo4 == bufferInfo) {
                    bufferInfo.copy(bufferInfo2);
                }
            }
        }
    }

    int getBufferedPercentage() {
        if (this.mMediaHTTPManager == null || this.mFileLength <= 0) {
            return 100;
        }
        return (int) Math.round((((double) this.mMediaHTTPManager.getBufferedFileLength()) / ((double) this.mFileLength)) * 100.0d);
    }

    boolean isDownloadFinished() {
        return this.mMediaHTTPManager == null || this.mMediaHTTPManager.isDownloadFinished();
    }

    public long getFileOffsetAndUpdateAdjustLength(long j, int i) {
        long j2 = -1;
        if (this.mSeekTable != null) {
            try {
                j2 = this.mSeekTable.seek(j);
            } catch (Throwable th) {
            }
        }
        if (i <= 0) {
            long duration = getDuration() / 1000;
            if (duration > 0) {
                i = (int) (((((double) this.mFileLength) * 8.0d) / 1024.0d) / ((double) duration));
            }
        }
        if (j2 < 0) {
            j2 = getFirstPieceSize((int) (j / 1000), i, getDuration());
            this.mAdjustLength = (long) (((i / 8) * 15) * 1000);
            return j2;
        }
        this.mAdjustLength = (long) (((i / 8) * 2) * 1000);
        return j2;
    }

    private static boolean processAudioListener(IAudioListener iAudioListener, BufferInfo bufferInfo, BufferInfo bufferInfo2) {
        try {
            bufferInfo2.setShortBufferCapacity(bufferInfo.bufferSize);
            return iAudioListener.onPcm(bufferInfo, bufferInfo2);
        } catch (Throwable th) {
            Logger.e(TAG, "[processAudioListener] failed. audio: " + iAudioListener, th);
            return false;
        }
    }

    private static long getFirstPieceSize(int i, int i2, long j) {
        long j2;
        if (i2 >= 700) {
            i2 += m.CTRL_INDEX;
        }
        if (i2 > 48) {
            j2 = (((j / 1000) / 60) * 10) * AppSupportContentFlag.MMAPP_SUPPORT_XLS;
        } else {
            j2 = (((j / 1000) / 60) * 5) * AppSupportContentFlag.MMAPP_SUPPORT_XLS;
        }
        return Math.max(102400, j2 + ((long) (((i2 / 8) * i) * 1000)));
    }

    public static SeekTable createSeekTable(AudioType audioType, String str) {
        InputStream fileInputStream;
        InputStream bufferedInputStream;
        BaseDecoder baseDecoder;
        Throwable e;
        Object obj;
        BaseDecoder baseDecoder2;
        Closeable closeable;
        Closeable closeable2;
        Object obj2;
        BaseDecoder baseDecoder3;
        Closeable closeable3 = null;
        try {
            SeekTable mp4SeekTable;
            if (audioType == AudioType.M4A) {
                mp4SeekTable = new Mp4SeekTable();
                fileInputStream = new FileInputStream(str);
                try {
                    bufferedInputStream = new BufferedInputStream(fileInputStream);
                    try {
                        mp4SeekTable.parse(bufferedInputStream);
                        baseDecoder = null;
                        closeable3 = bufferedInputStream;
                        bufferedInputStream = fileInputStream;
                    } catch (FileNotFoundException e2) {
                        e = e2;
                        obj = fileInputStream;
                        Object obj3 = bufferedInputStream;
                        baseDecoder2 = null;
                        try {
                            Logger.e(TAG, "[createSeekTable] buffer file not found!", e);
                            if (baseDecoder2 != null) {
                                baseDecoder2.release();
                            }
                            safeClose(closeable, closeable2);
                            return null;
                        } catch (Throwable th) {
                            e = th;
                            closeable3 = closeable;
                            closeable = closeable2;
                            baseDecoder = baseDecoder2;
                            if (baseDecoder != null) {
                                baseDecoder.release();
                            }
                            safeClose(closeable3, fileInputStream);
                            throw e;
                        }
                    } catch (IOException e3) {
                        e = e3;
                        baseDecoder = null;
                        try {
                            Logger.e(TAG, "[createSeekTable] failed to read from buffer file!", e);
                            if (baseDecoder != null) {
                                baseDecoder.release();
                            }
                            safeClose(bufferedInputStream, fileInputStream);
                            return null;
                        } catch (Throwable th2) {
                            e = th2;
                            obj2 = bufferedInputStream;
                            if (baseDecoder != null) {
                                baseDecoder.release();
                            }
                            safeClose(closeable3, fileInputStream);
                            throw e;
                        }
                    } catch (InvalidBoxException e4) {
                        e = e4;
                        baseDecoder = null;
                        Logger.e(TAG, "[createSeekTable] failed to create seektable for buffer file!", e);
                        if (baseDecoder != null) {
                            baseDecoder.release();
                        }
                        safeClose(bufferedInputStream, fileInputStream);
                        return null;
                    } catch (Throwable th3) {
                        e = th3;
                        baseDecoder = null;
                        obj2 = bufferedInputStream;
                        if (baseDecoder != null) {
                            baseDecoder.release();
                        }
                        safeClose(closeable3, fileInputStream);
                        throw e;
                    }
                } catch (FileNotFoundException e5) {
                    e = e5;
                    baseDecoder2 = null;
                    obj = fileInputStream;
                    closeable = null;
                    Logger.e(TAG, "[createSeekTable] buffer file not found!", e);
                    if (baseDecoder2 != null) {
                        baseDecoder2.release();
                    }
                    safeClose(closeable, closeable2);
                    return null;
                } catch (IOException e6) {
                    e = e6;
                    baseDecoder = null;
                    bufferedInputStream = null;
                    Logger.e(TAG, "[createSeekTable] failed to read from buffer file!", e);
                    if (baseDecoder != null) {
                        baseDecoder.release();
                    }
                    safeClose(bufferedInputStream, fileInputStream);
                    return null;
                } catch (InvalidBoxException e7) {
                    e = e7;
                    baseDecoder = null;
                    bufferedInputStream = null;
                    Logger.e(TAG, "[createSeekTable] failed to create seektable for buffer file!", e);
                    if (baseDecoder != null) {
                        baseDecoder.release();
                    }
                    safeClose(bufferedInputStream, fileInputStream);
                    return null;
                } catch (Throwable th4) {
                    e = th4;
                    baseDecoder = null;
                    if (baseDecoder != null) {
                        baseDecoder.release();
                    }
                    safeClose(closeable3, fileInputStream);
                    throw e;
                }
            } else if (audioType == AudioType.MP3) {
                baseDecoder = new MP3Decoder();
                try {
                    baseDecoder.init(str, false);
                    MP3Information mP3Information = (MP3Information) baseDecoder.getAudioInformation();
                    SeekTable mp3VbrXingSeekTable;
                    if (mP3Information.isVbr()) {
                        if (mP3Information.getVbrType() == 2) {
                            mp3VbrXingSeekTable = new Mp3VbrXingSeekTable();
                            ((Mp3VbrXingSeekTable) mp3VbrXingSeekTable).setAudioInfomation(mP3Information);
                            bufferedInputStream = new FileInputStream(str);
                            try {
                                mp3VbrXingSeekTable.parse(bufferedInputStream);
                                mp4SeekTable = mp3VbrXingSeekTable;
                            } catch (FileNotFoundException e8) {
                                e = e8;
                                closeable = null;
                                baseDecoder3 = baseDecoder;
                                obj = bufferedInputStream;
                                baseDecoder2 = baseDecoder3;
                                Logger.e(TAG, "[createSeekTable] buffer file not found!", e);
                                if (baseDecoder2 != null) {
                                    baseDecoder2.release();
                                }
                                safeClose(closeable, closeable2);
                                return null;
                            } catch (IOException e9) {
                                e = e9;
                                fileInputStream = bufferedInputStream;
                                bufferedInputStream = null;
                                Logger.e(TAG, "[createSeekTable] failed to read from buffer file!", e);
                                if (baseDecoder != null) {
                                    baseDecoder.release();
                                }
                                safeClose(bufferedInputStream, fileInputStream);
                                return null;
                            } catch (InvalidBoxException e10) {
                                e = e10;
                                fileInputStream = bufferedInputStream;
                                bufferedInputStream = null;
                                Logger.e(TAG, "[createSeekTable] failed to create seektable for buffer file!", e);
                                if (baseDecoder != null) {
                                    baseDecoder.release();
                                }
                                safeClose(bufferedInputStream, fileInputStream);
                                return null;
                            } catch (Throwable th5) {
                                e = th5;
                                fileInputStream = bufferedInputStream;
                                if (baseDecoder != null) {
                                    baseDecoder.release();
                                }
                                safeClose(closeable3, fileInputStream);
                                throw e;
                            }
                        } else if (mP3Information.getVbrType() == 3) {
                            mp3VbrXingSeekTable = new Mp3VbrVBRISeekTable();
                            ((Mp3VbrVBRISeekTable) mp3VbrXingSeekTable).setAudioInfomation(mP3Information);
                            bufferedInputStream = new FileInputStream(str);
                            try {
                                mp3VbrXingSeekTable.parse(bufferedInputStream);
                                mp4SeekTable = mp3VbrXingSeekTable;
                            } catch (FileNotFoundException e11) {
                                e = e11;
                                closeable = null;
                                baseDecoder3 = baseDecoder;
                                obj = bufferedInputStream;
                                baseDecoder2 = baseDecoder3;
                                Logger.e(TAG, "[createSeekTable] buffer file not found!", e);
                                if (baseDecoder2 != null) {
                                    baseDecoder2.release();
                                }
                                safeClose(closeable, closeable2);
                                return null;
                            } catch (IOException e12) {
                                e = e12;
                                fileInputStream = bufferedInputStream;
                                bufferedInputStream = null;
                                Logger.e(TAG, "[createSeekTable] failed to read from buffer file!", e);
                                if (baseDecoder != null) {
                                    baseDecoder.release();
                                }
                                safeClose(bufferedInputStream, fileInputStream);
                                return null;
                            } catch (InvalidBoxException e13) {
                                e = e13;
                                fileInputStream = bufferedInputStream;
                                bufferedInputStream = null;
                                Logger.e(TAG, "[createSeekTable] failed to create seektable for buffer file!", e);
                                if (baseDecoder != null) {
                                    baseDecoder.release();
                                }
                                safeClose(bufferedInputStream, fileInputStream);
                                return null;
                            } catch (Throwable th6) {
                                e = th6;
                                fileInputStream = bufferedInputStream;
                                if (baseDecoder != null) {
                                    baseDecoder.release();
                                }
                                safeClose(closeable3, fileInputStream);
                                throw e;
                            }
                        }
                    } else if (mP3Information.isCbr()) {
                        mp3VbrXingSeekTable = new Mp3CbrSeekTable();
                        ((Mp3CbrSeekTable) mp3VbrXingSeekTable).setAudioInfomation(mP3Information);
                        bufferedInputStream = new FileInputStream(str);
                        try {
                            mp3VbrXingSeekTable.parse(bufferedInputStream);
                            mp4SeekTable = mp3VbrXingSeekTable;
                        } catch (FileNotFoundException e14) {
                            e = e14;
                            closeable = null;
                            baseDecoder3 = baseDecoder;
                            obj = bufferedInputStream;
                            baseDecoder2 = baseDecoder3;
                            Logger.e(TAG, "[createSeekTable] buffer file not found!", e);
                            if (baseDecoder2 != null) {
                                baseDecoder2.release();
                            }
                            safeClose(closeable, closeable2);
                            return null;
                        } catch (IOException e15) {
                            e = e15;
                            fileInputStream = bufferedInputStream;
                            bufferedInputStream = null;
                            Logger.e(TAG, "[createSeekTable] failed to read from buffer file!", e);
                            if (baseDecoder != null) {
                                baseDecoder.release();
                            }
                            safeClose(bufferedInputStream, fileInputStream);
                            return null;
                        } catch (InvalidBoxException e16) {
                            e = e16;
                            fileInputStream = bufferedInputStream;
                            bufferedInputStream = null;
                            Logger.e(TAG, "[createSeekTable] failed to create seektable for buffer file!", e);
                            if (baseDecoder != null) {
                                baseDecoder.release();
                            }
                            safeClose(bufferedInputStream, fileInputStream);
                            return null;
                        } catch (Throwable th7) {
                            e = th7;
                            fileInputStream = bufferedInputStream;
                            if (baseDecoder != null) {
                                baseDecoder.release();
                            }
                            safeClose(closeable3, fileInputStream);
                            throw e;
                        }
                    }
                    bufferedInputStream = null;
                    mp4SeekTable = null;
                } catch (FileNotFoundException e17) {
                    e = e17;
                    baseDecoder2 = baseDecoder;
                    closeable = null;
                    closeable2 = null;
                    Logger.e(TAG, "[createSeekTable] buffer file not found!", e);
                    if (baseDecoder2 != null) {
                        baseDecoder2.release();
                    }
                    safeClose(closeable, closeable2);
                    return null;
                } catch (IOException e18) {
                    e = e18;
                    bufferedInputStream = null;
                    fileInputStream = null;
                    Logger.e(TAG, "[createSeekTable] failed to read from buffer file!", e);
                    if (baseDecoder != null) {
                        baseDecoder.release();
                    }
                    safeClose(bufferedInputStream, fileInputStream);
                    return null;
                } catch (InvalidBoxException e19) {
                    e = e19;
                    bufferedInputStream = null;
                    fileInputStream = null;
                    Logger.e(TAG, "[createSeekTable] failed to create seektable for buffer file!", e);
                    if (baseDecoder != null) {
                        baseDecoder.release();
                    }
                    safeClose(bufferedInputStream, fileInputStream);
                    return null;
                } catch (Throwable th8) {
                    e = th8;
                    fileInputStream = null;
                    if (baseDecoder != null) {
                        baseDecoder.release();
                    }
                    safeClose(closeable3, fileInputStream);
                    throw e;
                }
            } else {
                baseDecoder = null;
                bufferedInputStream = null;
                mp4SeekTable = null;
            }
            if (baseDecoder != null) {
                baseDecoder.release();
            }
            safeClose(closeable3, bufferedInputStream);
            return mp4SeekTable;
        } catch (FileNotFoundException e20) {
            e = e20;
            baseDecoder2 = null;
            closeable = null;
            closeable2 = null;
            Logger.e(TAG, "[createSeekTable] buffer file not found!", e);
            if (baseDecoder2 != null) {
                baseDecoder2.release();
            }
            safeClose(closeable, closeable2);
            return null;
        } catch (IOException e21) {
            e = e21;
            baseDecoder = null;
            bufferedInputStream = null;
            fileInputStream = null;
            Logger.e(TAG, "[createSeekTable] failed to read from buffer file!", e);
            if (baseDecoder != null) {
                baseDecoder.release();
            }
            safeClose(bufferedInputStream, fileInputStream);
            return null;
        } catch (InvalidBoxException e22) {
            e = e22;
            baseDecoder = null;
            bufferedInputStream = null;
            fileInputStream = null;
            Logger.e(TAG, "[createSeekTable] failed to create seektable for buffer file!", e);
            if (baseDecoder != null) {
                baseDecoder.release();
            }
            safeClose(bufferedInputStream, fileInputStream);
            return null;
        } catch (Throwable th9) {
            e = th9;
            baseDecoder = null;
            fileInputStream = null;
            if (baseDecoder != null) {
                baseDecoder.release();
            }
            safeClose(closeable3, fileInputStream);
            throw e;
        }
    }

    private static void safeClose(Closeable... closeableArr) {
        for (Closeable closeable : closeableArr) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (Throwable th) {
                    Logger.e(TAG, "[safeClose] failed.", th);
                }
            }
        }
    }

    void flush() {
        this.mNeedFlush = true;
    }

    private static int getAudioTrackPosition(long j, AudioTrack audioTrack) {
        return (int) Math.round((((double) (((long) audioTrack.getPlaybackHeadPosition()) + j)) / ((double) audioTrack.getSampleRate())) * 1000.0d);
    }
}
