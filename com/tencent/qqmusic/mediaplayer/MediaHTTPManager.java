package com.tencent.qqmusic.mediaplayer;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.qqmusic.mediaplayer.network.IMediaHTTPConnection;
import com.tencent.qqmusic.mediaplayer.network.IMediaHTTPService;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.HashMap;

class MediaHTTPManager {
    private static final int BUFFER_SIZE = 8192;
    private static final int MINIMAL_BUFFER_SIZE_TO_START = 204800;
    private static final int MSG_DISCONNECT = 51;
    private static final int MSG_PREPARE = 49;
    private static final int MSG_QUIT_THREAD = 53;
    private static final int MSG_READ_AT = 50;
    private static final int MSG_SEEK = 52;
    private static final int SNIFF_INTERVAL = 8192;
    private static final String TAG = "MediaHTTPManager";
    public IMediaHTTPConnection mConn;
    public boolean mDownloadFinished;
    public final String mFileName;
    private MediaHTTPHandler mHandler = null;
    public HandlerThread mHandlerThread = null;
    public OnBufferListener mOnBufferListener = null;
    public OnConnectionListener mOnConnectionListener = null;
    public OnSniffListener mOnSniffListener = null;
    public final IMediaHTTPService mService;
    public final URL mUrl;
    public RandomAccessFile mWriteFile;

    private static class MediaHTTPHandler extends Handler {
        private byte[] buffer;
        private long mCurrentPosition = 0;
        private DataRangeTracker mDataRangeTracker;
        private boolean mHasCalledMiniBufferReady = false;
        private final WeakReference<MediaHTTPManager> mManager;
        private boolean mSniffFinished = false;
        private long mTargetPositionToStart = 0;

        MediaHTTPHandler(Looper looper, MediaHTTPManager mediaHTTPManager) {
            super(looper);
            this.mManager = new WeakReference(mediaHTTPManager);
        }

        long getBufferedFileLength() {
            return this.mCurrentPosition;
        }

        void removeMessageThenSendEmptyMessage(int i) {
            removeMessages(i);
            sendEmptyMessage(i);
        }

        public void handleMessage(Message message) {
            MediaHTTPManager mediaHTTPManager = (MediaHTTPManager) this.mManager.get();
            if (mediaHTTPManager != null) {
                switch (message.what) {
                    case MediaHTTPManager.MSG_PREPARE /*49*/:
                        try {
                            mediaHTTPManager.mWriteFile = new RandomAccessFile(mediaHTTPManager.mFileName, "rw");
                            mediaHTTPManager.mConn = mediaHTTPManager.mService.makeHTTPConnection();
                            boolean connect = mediaHTTPManager.mConn.connect(mediaHTTPManager.mUrl, new HashMap());
                            Logger.i(MediaHTTPManager.TAG, "connect result " + connect);
                            if (connect) {
                                this.buffer = new byte[8192];
                                this.mTargetPositionToStart = this.mCurrentPosition + 8192;
                                if (this.mTargetPositionToStart >= mediaHTTPManager.mConn.getSize()) {
                                    this.mTargetPositionToStart = mediaHTTPManager.mConn.getSize() - 1;
                                }
                                if (mediaHTTPManager.mOnConnectionListener != null) {
                                    mediaHTTPManager.mOnConnectionListener.onConnected(mediaHTTPManager.mConn.getSize(), mediaHTTPManager.mConn.getMIMEType());
                                    this.mDataRangeTracker = new DataRangeTracker();
                                }
                                removeMessageThenSendEmptyMessage(50);
                                return;
                            } else if (mediaHTTPManager.mOnConnectionListener != null) {
                                mediaHTTPManager.mOnConnectionListener.onError(91, 80);
                                return;
                            } else {
                                return;
                            }
                        } catch (FileNotFoundException e) {
                            mediaHTTPManager.mOnConnectionListener.onError(91, 53);
                            return;
                        }
                    case 50:
                        byte[] bArr = this.buffer;
                        int readAt = mediaHTTPManager.mConn.readAt(bArr, (int) this.mCurrentPosition, 8192);
                        if (readAt > 0) {
                            if (writeToFile(this.mCurrentPosition, bArr, readAt, mediaHTTPManager.mWriteFile)) {
                                this.mDataRangeTracker.addRange(this.mCurrentPosition, (this.mCurrentPosition + ((long) readAt)) - 1);
                                this.mCurrentPosition += (long) readAt;
                            }
                            if (mediaHTTPManager.mOnBufferListener != null) {
                                mediaHTTPManager.mOnBufferListener.onBufferProgress(this.mCurrentPosition, mediaHTTPManager.mConn.getSize());
                            }
                            if (!this.mHasCalledMiniBufferReady && this.mCurrentPosition >= this.mTargetPositionToStart) {
                                if (!(this.mSniffFinished || mediaHTTPManager.mOnSniffListener == null)) {
                                    if (mediaHTTPManager.mOnSniffListener.sniff()) {
                                        this.mSniffFinished = true;
                                    } else {
                                        this.mTargetPositionToStart += 8192;
                                        if (this.mTargetPositionToStart >= mediaHTTPManager.mConn.getSize()) {
                                            this.mTargetPositionToStart = mediaHTTPManager.mConn.getSize() - 1;
                                        }
                                    }
                                }
                                if (this.mSniffFinished) {
                                    this.mHasCalledMiniBufferReady = true;
                                    if (mediaHTTPManager.mOnBufferListener != null) {
                                        mediaHTTPManager.mOnBufferListener.onBufferReadyToPlay();
                                    }
                                }
                            }
                            if (this.mCurrentPosition < mediaHTTPManager.mConn.getSize()) {
                                removeMessageThenSendEmptyMessage(50);
                                return;
                            }
                            mediaHTTPManager.mDownloadFinished = true;
                            if (!this.mSniffFinished && mediaHTTPManager.mOnConnectionListener != null) {
                                mediaHTTPManager.mOnConnectionListener.onError(91, 55);
                                return;
                            }
                            return;
                        }
                        if (mediaHTTPManager.mOnConnectionListener != null) {
                            mediaHTTPManager.mOnConnectionListener.onError(91, 80);
                        }
                        Logger.e(MediaHTTPManager.TAG, "connection.read failed " + readAt);
                        return;
                    case 51:
                        if (mediaHTTPManager.mConn != null) {
                            mediaHTTPManager.mConn.disconnect();
                        }
                        if (mediaHTTPManager.mWriteFile != null) {
                            try {
                                mediaHTTPManager.mWriteFile.close();
                            } catch (IOException e2) {
                            }
                        }
                        removeMessages(50);
                        return;
                    case 52:
                        if (message.obj instanceof Long) {
                            this.mCurrentPosition = ((Long) message.obj).longValue();
                            this.mHasCalledMiniBufferReady = false;
                            this.mTargetPositionToStart = this.mCurrentPosition + 204800;
                            if (this.mTargetPositionToStart >= mediaHTTPManager.mConn.getSize()) {
                                this.mTargetPositionToStart = mediaHTTPManager.mConn.getSize() - 1;
                            }
                            removeMessageThenSendEmptyMessage(50);
                            return;
                        }
                        return;
                    case 53:
                        if (mediaHTTPManager.mHandlerThread != null) {
                            if (VERSION.SDK_INT >= 19) {
                                mediaHTTPManager.mHandlerThread.quitSafely();
                            } else {
                                mediaHTTPManager.mHandlerThread.quit();
                            }
                            Logger.i(MediaHTTPManager.TAG, "temp file deleted " + new File(mediaHTTPManager.mFileName).delete());
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }

        private boolean writeToFile(long j, byte[] bArr, int i, RandomAccessFile randomAccessFile) {
            try {
                randomAccessFile.seek(j);
                randomAccessFile.write(bArr, 0, i);
                return true;
            } catch (Throwable e) {
                Logger.e(MediaHTTPManager.TAG, "file not found", e);
                return false;
            } catch (Throwable e2) {
                Logger.e(MediaHTTPManager.TAG, "io ", e2);
                return false;
            }
        }
    }

    interface OnBufferListener {
        void onBufferProgress(long j, long j2);

        void onBufferReadyToPlay();
    }

    interface OnConnectionListener {
        void onConnected(long j, String str);

        void onError(int i, int i2);
    }

    interface OnSniffListener {
        boolean sniff();
    }

    MediaHTTPManager(IMediaHTTPService iMediaHTTPService, String str, URL url) {
        this.mService = iMediaHTTPService;
        this.mFileName = str;
        this.mUrl = url;
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
        if (!file.exists()) {
            file.createNewFile();
        }
    }

    void setBufferListener(OnBufferListener onBufferListener) {
        this.mOnBufferListener = onBufferListener;
    }

    void setConnectionListener(OnConnectionListener onConnectionListener) {
        this.mOnConnectionListener = onConnectionListener;
    }

    void setSniffListener(OnSniffListener onSniffListener) {
        this.mOnSniffListener = onSniffListener;
    }

    void prepare() {
        this.mHandlerThread = new HandlerThread(new StringBuilder(TAG).append(this.mFileName).toString());
        this.mHandlerThread.start();
        this.mHandler = new MediaHTTPHandler(this.mHandlerThread.getLooper(), this);
        Message.obtain(this.mHandler, MSG_PREPARE).sendToTarget();
    }

    void seekByBytePosition(long j) {
        Message.obtain(this.mHandler, 52, Long.valueOf(j)).sendToTarget();
    }

    void release() {
        if (this.mHandler != null) {
            Message.obtain(this.mHandler, 51).sendToTarget();
            Message.obtain(this.mHandler, 53).sendToTarget();
        }
    }

    boolean isDownloadFinished() {
        return this.mDownloadFinished;
    }

    long getBufferedFileLength() {
        if (this.mHandler != null) {
            return this.mHandler.getBufferedFileLength();
        }
        return 0;
    }
}
