package com.tencent.qqmusic.mediaplayer;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.audiofx.IAudioListener;
import com.tencent.qqmusic.mediaplayer.network.DefaultMediaHTTPService;
import com.tencent.qqmusic.mediaplayer.network.IMediaHTTPService;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource.Factory;
import com.tencent.qqmusic.mediaplayer.upstream.INativeDataSource;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.FileDescriptor;
import java.lang.ref.WeakReference;
import java.net.URL;

public class CommonPlayer extends BaseMediaPlayer implements PlayerException {
    private static final int INIT_STATE_CHECK_TIME = 5000;
    private static final String TAG = "CommonPlayer";
    private PlayerCallback callback = new PlayerCallback() {
        public void playThreadStart() {
            if (CommonPlayer.this.mRecognitionByExtensions) {
                Logger.i(CommonPlayer.TAG, "mCheckAudioInitSuccessHandler 开始检查，等待5S");
                CommonPlayer.this.checkPlayerAndRePlay(5000);
            }
        }

        public void playerPrepared() {
            Logger.i(CommonPlayer.TAG, "playerPrepared() callback prepared");
            CommonPlayer.this.TransferStateTo(2);
            CommonPlayer.this.mCheckAudioInitSuccessHandler.sendEmptyMessage(2);
            if (CommonPlayer.this.mCallback != null) {
                CommonPlayer.this.mCallback.onPrepared(CommonPlayer.this);
            }
        }

        public void playerStopped() {
            Logger.i(CommonPlayer.TAG, "playerStopped() callback stopped");
            CommonPlayer.this.mCheckAudioInitSuccessHandler.removeCallbacksAndMessages(null);
        }

        public void playerStarted() {
            Logger.i(CommonPlayer.TAG, "playerStarted() callback started");
            if (CommonPlayer.this.mCallback != null) {
                CommonPlayer.this.mCallback.onStarted(CommonPlayer.this);
            }
        }

        public void playerSeeked() {
            Logger.i(CommonPlayer.TAG, "playerSeeked() callback seeked");
            if (CommonPlayer.this.mCallback != null) {
                CommonPlayer.this.mCallback.onSeekComplete(CommonPlayer.this);
            }
        }

        public void playerPaused() {
            Logger.i(CommonPlayer.TAG, "playerPaused() callback paused");
        }

        public void playerException(int i, int i2, int i3) {
            Logger.e(CommonPlayer.TAG, "playerException() callback exception what = " + i + ",extra = " + i2 + " mAudioPlayer:" + CommonPlayer.this.mAudioPlayer);
            if (CommonPlayer.this.mAudioPlayer != null) {
                Logger.e(CommonPlayer.TAG, "handleMessage state = " + CommonPlayer.this.mAudioPlayer.getPlayerState());
                Logger.e(CommonPlayer.TAG, "handleMessage isInit = " + CommonPlayer.this.mAudioPlayer.isInit() + ",isStartDecode = " + CommonPlayer.this.mAudioPlayer.hasDecodeData() + ",decodeSuccess = " + CommonPlayer.this.mAudioPlayer.hasDecodeDataSuccess());
            }
            CommonPlayer.this.mCheckAudioInitSuccessHandler.removeMessages(1);
            if (!CommonPlayer.this.mRecognitionByExtensions || CommonPlayer.this.mAudioPlayer == null || CommonPlayer.this.mAudioPlayer.hasDecodeDataSuccess() || i2 == 70 || i2 == 66) {
                CommonPlayer.this.onError(i, i2, i3);
                return;
            }
            Logger.i(CommonPlayer.TAG, "playerException() path =" + CommonPlayer.this.mAudioPlayer.getPlayingFilePath() + "mCheckAudioInitSuccessHandler throw a exception so check immediately");
            CommonPlayer.this.checkPlayerAndRePlay(0);
        }

        public void playerEnded() {
            Logger.i(CommonPlayer.TAG, "playerEnded() callback ended");
            CommonPlayer.this.TransferStateTo(7);
            CommonPlayer.this.mCheckAudioInitSuccessHandler.removeCallbacksAndMessages(null);
            if (CommonPlayer.this.mCallback != null) {
                CommonPlayer.this.mCallback.onCompletion(CommonPlayer.this);
            }
        }
    };
    private final StateRunner<Integer> currentState = new StateRunner(Integer.valueOf(0));
    public CorePlayer mAudioPlayer = null;
    public AudioType mAudioType = AudioType.UNSUPPORT;
    public PlayerListenerCallback mCallback;
    public final Handler mCheckAudioInitSuccessHandler = new CheckAudioInitSuccessHandler(this);
    private long mDuration;
    private long mFileLength = 0;
    public boolean mRecognitionByExtensions = true;

    private static class CheckAudioInitSuccessHandler extends Handler {
        private static final int MSG_CHECK = 1;
        private static final int MSG_NOTIFY_BUFFER_PROGRESS = 2;
        private final WeakReference<CommonPlayer> mQQMediaPlayer;

        CheckAudioInitSuccessHandler(CommonPlayer commonPlayer) {
            super(Looper.getMainLooper());
            this.mQQMediaPlayer = new WeakReference(commonPlayer);
        }

        public void handleMessage(Message message) {
            CommonPlayer commonPlayer = (CommonPlayer) this.mQQMediaPlayer.get();
            if (commonPlayer != null) {
                if (message.what == 1) {
                    check(message, commonPlayer);
                } else if (message.what == 2) {
                    PlayerListenerCallback playerListenerCallback = commonPlayer.mCallback;
                    if (playerListenerCallback != null) {
                        CorePlayer corePlayer = commonPlayer.mAudioPlayer;
                        if (corePlayer != null) {
                            int bufferedPercentage = corePlayer.getBufferedPercentage();
                            playerListenerCallback.onBufferingUpdate(commonPlayer, bufferedPercentage);
                            if (bufferedPercentage != 100 && commonPlayer.getPlayerState() != 9 && commonPlayer.getPlayerState() != 8 && commonPlayer.getPlayerState() != 7) {
                                sendEmptyMessageDelayed(2, 200);
                            }
                        }
                    }
                }
            }
        }

        @SuppressLint({"DefaultLocale"})
        private void check(Message message, CommonPlayer commonPlayer) {
            Logger.i(CommonPlayer.TAG, "mCheckAudioInitSuccessHandler wait 5s");
            String str = "null";
            CorePlayer corePlayer = commonPlayer.mAudioPlayer;
            if (corePlayer != null) {
                Logger.i(CommonPlayer.TAG, String.format("handleMessage, init: %b, startDecode: %b, decode: %b, statue: %d ", new Object[]{Boolean.valueOf(corePlayer.isInit()), Boolean.valueOf(corePlayer.hasDecodeData()), Boolean.valueOf(corePlayer.hasDecodeDataSuccess()), Integer.valueOf(corePlayer.getPlayerState())}));
                str = corePlayer.getPlayingFilePath();
                Logger.i(CommonPlayer.TAG, "handleMessage mFilePath = " + str);
            }
            if (str == null) {
                return;
            }
            if (corePlayer != null && corePlayer.isCreateAudioTrackFail()) {
                Logger.w(CommonPlayer.TAG, "create audiotrack fail,EXCEPTION_TYPE_CREATAUDIOTRACK");
                commonPlayer.onError(92, 66);
            } else if ((commonPlayer.mRecognitionByExtensions && corePlayer != null && corePlayer.getPlayerState() == 5) || (corePlayer != null && corePlayer.isInit() && !corePlayer.hasDecodeData())) {
                commonPlayer.checkPlayerAndRePlay(5000);
            } else if (corePlayer == null || corePlayer.hasDecodeDataSuccess() || !commonPlayer.mRecognitionByExtensions) {
                Logger.i(CommonPlayer.TAG, "path =" + str + ", AudioPlayer exit check");
            } else {
                try {
                    commonPlayer.mRecognitionByExtensions = false;
                    corePlayer.exitNotCallback();
                    AudioType recognitionAudioFormatExactly = AudioRecognition.recognitionAudioFormatExactly(str);
                    AudioType audioType = commonPlayer.mAudioType;
                    if (!AudioFormat.isAudioType(recognitionAudioFormatExactly) || recognitionAudioFormatExactly.equals(audioType)) {
                        Logger.w(CommonPlayer.TAG, "path =" + str + ", mAudioType = " + commonPlayer.mAudioType + ",newAudioType = " + recognitionAudioFormatExactly + "recognition audio format second same with first  or is other，switch QQMediaplayer");
                        commonPlayer.onError(90, 101);
                        return;
                    }
                    commonPlayer.mAudioType = recognitionAudioFormatExactly;
                    commonPlayer.newCommonPlayer(corePlayer.getPlayingFilePath(), recognitionAudioFormatExactly);
                    corePlayer.copyPlayerStatus(corePlayer);
                    Logger.i(CommonPlayer.TAG, "recognition again, path =" + str + "recognition audio format second ,result =  " + commonPlayer.mAudioType + "，init decoder again");
                    commonPlayer.prepare();
                } catch (Throwable e) {
                    commonPlayer.onError(90, 53);
                    Logger.e(CommonPlayer.TAG, e);
                } catch (Throwable e2) {
                    commonPlayer.onError(90, 90);
                    Logger.e(CommonPlayer.TAG, e2);
                }
            }
        }
    }

    public CommonPlayer(PlayerListenerCallback playerListenerCallback) {
        this.mCallback = playerListenerCallback;
        reset();
    }

    public int getDuration() {
        long j = 0;
        if (this.mAudioPlayer != null) {
            this.mDuration = this.mAudioPlayer.getDuration();
            return (int) this.mDuration;
        }
        Logger.e(TAG, "getDuration() mAudioPlayer is null!");
        if (this.mDuration > 0) {
            j = this.mDuration;
        }
        return (int) j;
    }

    public int getPlayerState() {
        return ((Integer) this.currentState.get()).intValue();
    }

    public boolean isPlaying() {
        if (this.mAudioPlayer == null) {
            Logger.e(TAG, "isPlaying() mAudioPlayer is null!");
            return false;
        } else if (this.mAudioPlayer.getPlayerState() == 4) {
            return true;
        } else {
            return false;
        }
    }

    public void pause() {
        TransferStateTo(5);
        Logger.i(TAG, auxiliary("[pause]"));
        if (this.mAudioPlayer != null) {
            this.mAudioPlayer.pause();
        } else {
            Logger.e(TAG, "pause() mAudioPlayer is null!");
        }
        notifyPauseSong();
    }

    public void prepare() {
        TransferStateTo(3);
        Logger.i(TAG, auxiliary("[prepare]"));
        if (this.mAudioPlayer != null) {
            this.mAudioPlayer.prepare();
        } else {
            Logger.e(TAG, "prepare() null mAudioPlayer!");
        }
    }

    public void prepareAsync() {
        throw new UnSupportMethodException("Soft decode player cannot support prepareAsync");
    }

    public void release() {
        TransferStateTo(8);
        Logger.i(TAG, auxiliary("[release]"));
        this.mCheckAudioInitSuccessHandler.removeCallbacksAndMessages(null);
        if (this.mAudioPlayer != null) {
            this.mAudioPlayer.release();
            this.mAudioPlayer = null;
        } else {
            Logger.w(TAG, "release() mAudioPlayer is null!");
        }
        this.mCallback = null;
    }

    public void reset() {
        TransferStateTo(0);
        Logger.i(TAG, auxiliary("[reset]"));
        this.mCheckAudioInitSuccessHandler.removeCallbacksAndMessages(null);
        if (this.mAudioPlayer != null) {
            this.mAudioPlayer.release();
            this.mAudioPlayer = null;
        }
        this.mDuration = 0;
        this.mAudioType = AudioType.UNSUPPORT;
        this.mRecognitionByExtensions = true;
        this.mFileLength = 0;
    }

    public void seekTo(int i) {
        if (this.mAudioPlayer != null) {
            this.mAudioPlayer.seek(i);
        } else {
            Logger.e(TAG, "seekTo() mAudioPlayer is null!");
        }
    }

    public void setDataSource(String str) {
        TransferStateTo(1);
        if (str == null) {
            Logger.e(TAG, "setDataSource() ERROR:the path is null!");
            throw new NullPointerException("the path is null!");
        }
        Logger.i(TAG, "setDataSource, path: " + str);
        try {
            this.mAudioType = AudioRecognition.recognitionAudioFormatByExtensions(str);
            if (AudioFormat.isAudioType(this.mAudioType)) {
                newCommonPlayer(str, this.mAudioType);
                this.mRecognitionByExtensions = true;
                Logger.i(TAG, "setDataSource() recognition audio format first result =  " + this.mAudioType);
            } else {
                onError(90, 55);
            }
            this.mRecognitionByExtensions = true;
        } catch (Throwable e) {
            Logger.e(TAG, e);
        }
    }

    public void setDataSource(FileDescriptor fileDescriptor) {
        throw new UnSupportMethodException("Soft decode player cannot support setDataSource by FileDescriptor");
    }

    public void setVolume(float f, float f2) {
        if (this.mAudioPlayer != null) {
            this.mAudioPlayer.setVolume(f, f2);
        }
    }

    public void start() {
        TransferStateTo(4);
        Logger.i(TAG, auxiliary("[start]"));
        if (this.mAudioPlayer != null) {
            this.mAudioPlayer.play();
        } else {
            Logger.e(TAG, "start() mAudioPlayer is null!");
        }
        notifyStartPlaySong();
    }

    public void stop() {
        try {
            TransferStateTo(6);
            Logger.i(TAG, auxiliary("[stop]"));
            this.mCheckAudioInitSuccessHandler.removeCallbacksAndMessages(null);
            if (this.mAudioPlayer != null) {
                this.mAudioPlayer.stop();
            } else {
                Logger.e(TAG, "stop() mAudioPlayer is null!");
            }
        } catch (Throwable e) {
            Logger.e(TAG, e);
        }
    }

    public void setPlayerListenerCallback(PlayerListenerCallback playerListenerCallback) {
        this.mCallback = playerListenerCallback;
    }

    public long getCurrentPosition() {
        if (this.mAudioPlayer != null) {
            return this.mAudioPlayer.getCurPosition();
        }
        Logger.e(TAG, "getCurrentPosition() mAudioPlayer is null!");
        return 0;
    }

    public void flush() {
        if (this.mAudioPlayer == null) {
            Logger.e(TAG, "[getCurrentFrame] mAudioPlayer is null!");
        } else {
            this.mAudioPlayer.flush();
        }
    }

    public long getDecodePosition() {
        if (this.mAudioPlayer != null) {
            return this.mAudioPlayer.getCurPositionByDecoder();
        }
        Logger.e(TAG, "getDecodePosition() ERROR : mAudioPlayer is null!");
        return 0;
    }

    public void setDataSource(Context context, Uri uri) {
        TransferStateTo(1);
        if (uri == null) {
            Logger.e(TAG, "setDataSource() ERROR:the path is null!");
            throw new IllegalArgumentException("the path is null!");
        }
        Logger.i(TAG, "setDataSource, uri: " + uri);
        try {
            this.mAudioPlayer = new CorePlayer(new DefaultMediaHTTPService(), new URL(uri.toString()), this.callback);
            this.mAudioPlayer.setThreadName(uri.toString());
            this.mRecognitionByExtensions = false;
        } catch (Throwable e) {
            Logger.e(TAG, e);
            onError(90, 55);
        }
    }

    public void setDataSource(IMediaHTTPService iMediaHTTPService, Uri uri) {
        TransferStateTo(1);
        if (iMediaHTTPService == null) {
            throw new IllegalArgumentException("httpService can't be null!");
        }
        Logger.i(TAG, "[setDataSource] httpService: " + iMediaHTTPService);
        try {
            this.mAudioPlayer = new CorePlayer(iMediaHTTPService, new URL(uri.toString()), this.callback);
            this.mAudioPlayer.setThreadName(uri.toString());
            this.mRecognitionByExtensions = false;
        } catch (Throwable e) {
            Logger.e(TAG, e);
            onError(90, 55);
        }
    }

    public void setDataSource(Factory factory) {
        TransferStateTo(1);
        if (factory == null) {
            Logger.e(TAG, "[setDataSource] dataSourceFactory is null!");
            throw new NullPointerException("dataSourceFactory is null!");
        }
        Logger.i(TAG, "[setDataSource] dataSourceFactory: " + factory);
        try {
            IDataSource createDataSource = factory.createDataSource();
            try {
                this.mAudioType = createDataSource.getAudioType();
                if (AudioFormat.isAudioType(this.mAudioType)) {
                    this.mAudioPlayer = new CorePlayer(createDataSource, this.mAudioType, this.callback);
                    this.mAudioPlayer.setThreadName(factory.toString());
                    this.mRecognitionByExtensions = false;
                    Logger.i(TAG, "[setDataSource] create CorePlayer with audioType: " + this.mAudioType);
                    return;
                }
                onError(90, 55);
            } catch (Throwable e) {
                Logger.e(TAG, "[setDataSource] dataSource.getAudioType failed!", e);
                onError(90, 70);
            }
        } catch (Throwable e2) {
            Logger.e(TAG, "[setDataSource] failed to create java DataSource!", e2);
            onError(90, 82, e2.getErrorCode());
        }
    }

    public void setDataSource(INativeDataSource.Factory factory) {
        TransferStateTo(1);
        if (factory == null) {
            Logger.e(TAG, "[setDataSource] dataSourceFactory is null!");
            throw new NullPointerException("dataSourceFactory is null!");
        }
        Logger.i(TAG, "[setDataSource] dataSourceFactory: " + factory);
        try {
            INativeDataSource createDataSource = factory.createDataSource();
            try {
                this.mAudioType = createDataSource.getAudioType();
                if (AudioFormat.isAudioType(this.mAudioType)) {
                    this.mAudioPlayer = new CorePlayer(createDataSource, this.mAudioType, this.callback);
                    this.mAudioPlayer.setThreadName(factory.toString());
                    this.mRecognitionByExtensions = false;
                    Logger.i(TAG, "[setDataSource] create CorePlayer with audioType: " + this.mAudioType);
                    return;
                }
                onError(90, 55);
            } catch (Throwable e) {
                Logger.e(TAG, "[setDataSource] dataSource.getAudioType failed!", e);
                onError(90, 70);
            }
        } catch (Throwable e2) {
            Logger.e(TAG, "[setDataSource] failed to create native DataSource!", e2);
            onError(90, 81, e2.getErrorCode());
        }
    }

    public void setAudioStreamType(int i) {
        if (this.mAudioPlayer != null) {
            this.mAudioPlayer.setAudioStreamType(i);
        }
    }

    public void setWakeMode(Context context, int i) {
        throw new UnSupportMethodException("Soft decode player cannot support setWakeMode");
    }

    protected void TransferStateTo(int i) {
        this.currentState.transfer(Integer.valueOf(i));
        if (this.mCallback != null) {
            this.mCallback.onStateChanged(i);
        }
        Logger.d(TAG, "TransferStateTo() CURSTATE:" + i);
    }

    public long getCurrentPositionFromFile() {
        return 0;
    }

    public AudioInformation getCurrentAudioInformation() {
        if (this.mAudioPlayer != null) {
            return this.mAudioPlayer.getCurrentAudioInformation();
        }
        return null;
    }

    public void setFileTotalLength(long j) {
        this.mFileLength = j;
        if (this.mAudioPlayer != null) {
            this.mAudioPlayer.setFileLength(j);
            Logger.i(TAG, "setFileLength length = " + j);
        }
    }

    public int getSessionId() {
        if (this.mAudioPlayer != null) {
            return this.mAudioPlayer.getSessionId();
        }
        return 0;
    }

    public boolean isSoftDecoder() {
        return true;
    }

    public void addAudioListener(IAudioListener iAudioListener) {
        if (this.mAudioPlayer != null) {
            this.mAudioPlayer.addAudioListener(iAudioListener);
        }
    }

    public void removeAudioListener(IAudioListener iAudioListener) {
        if (this.mAudioPlayer != null) {
            this.mAudioPlayer.removeAudioListener(iAudioListener);
        }
    }

    public String getFilePath() {
        return this.mAudioPlayer == null ? "" : this.mAudioPlayer.getPlayingFilePath();
    }

    public void onError(int i, int i2) {
        onError(i, i2, 0);
    }

    public void onError(int i, int i2, int i3) {
        TransferStateTo(9);
        if (this.mCallback != null) {
            this.mCallback.onError(this, i, i2, i3);
        } else {
            Logger.e(TAG, "onError() mOnErrorListener is null!");
        }
    }

    public void checkPlayerAndRePlay(long j) {
        this.mCheckAudioInitSuccessHandler.removeMessages(1);
        this.mCheckAudioInitSuccessHandler.sendEmptyMessageDelayed(1, j);
    }

    public boolean newCommonPlayer(String str, AudioType audioType) {
        if (audioType == null) {
            return false;
        }
        this.mAudioPlayer = new CorePlayer(str, audioType, this.callback);
        this.mAudioPlayer.setThreadName(str);
        this.mAudioPlayer.setFileLength(this.mFileLength);
        return true;
    }

    private String auxiliary(String str) {
        CorePlayer corePlayer = this.mAudioPlayer;
        return corePlayer == null ? "null" : "[" + corePlayer.getPlayingFilePath() + "]" + str;
    }

    public int getBufferedPercentage() {
        CorePlayer corePlayer = this.mAudioPlayer;
        if (corePlayer != null) {
            return corePlayer.getBufferedPercentage();
        }
        return 0;
    }
}
