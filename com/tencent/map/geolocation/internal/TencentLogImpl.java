package com.tencent.map.geolocation.internal;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.format.DateFormat;
import ct.b.a;
import java.io.File;
import java.io.IOException;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

public final class TencentLogImpl implements TencentLog {
    private static boolean DEBUG = false;
    private static final String TAG = "TencentLogImpl";
    public final File mBackupDir;
    public Handler mHandler;
    private final Runnable mKiller;
    public boolean mPrepared;
    public HandlerThread mWorker;

    final class LogHandler extends Handler {
        private static final String TXWATCHDOG = "txwatchdog";
        private File mDest;

        private LogHandler(Looper looper) {
            super(looper);
            this.mDest = makeSureDest();
        }

        public final void handleMessage(Message message) {
            super.handleMessage(message);
            if (this.mDest == null || !"txwatchdog".equals(this.mDest.getName())) {
                this.mDest = makeSureDest();
            }
            try {
                a.a(message.obj.toString().getBytes("GBK"), this.mDest);
                File file = TencentLogImpl.this.mBackupDir;
                File file2 = this.mDest;
                if (file != null && file2 != null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (file2.length() > 409600) {
                        file2.renameTo(new File(file, new StringBuilder(TencentLog.PREFIX).append(currentTimeMillis).toString()));
                    }
                    File[] listFiles = file.listFiles();
                    if (listFiles != null && listFiles.length > 10) {
                        for (File file3 : listFiles) {
                            if (!"txwatchdog".equals(file3.getName()) && !file3.isDirectory() && file3.getName().startsWith(TencentLog.PREFIX) && currentTimeMillis - file3.lastModified() > -1702967296) {
                                file3.delete();
                            }
                        }
                    }
                }
            } catch (IOException e) {
                this.mDest = null;
            }
        }

        private File makeSureDest() {
            File file = TencentLogImpl.this.mBackupDir;
            if (!file.exists()) {
                file.mkdirs();
            }
            return new File(file, "txwatchdog");
        }
    }

    public TencentLogImpl(Context context, @Nullable File file) {
        this.mBackupDir = file;
        boolean z = file != null && (file.exists() || file.mkdirs());
        this.mPrepared = z;
        if (this.mPrepared) {
            this.mWorker = new HandlerThread("log_worker", 10);
            this.mWorker.start();
            this.mHandler = new LogHandler(this.mWorker.getLooper());
        }
        this.mKiller = new Runnable() {
            public void run() {
                if (TencentLogImpl.this._isPrepared()) {
                    TencentLogImpl.this.mPrepared = false;
                    TencentLogImpl.this.mHandler.removeCallbacksAndMessages(null);
                    TencentLogImpl.this.mWorker.quit();
                }
            }
        };
        if (DEBUG) {
            new StringBuilder("log dir=").append(this.mBackupDir);
            if (!this.mPrepared) {
                new StringBuilder("init failed: mPrepared=").append(this.mPrepared);
            }
        }
    }

    public final void shutdown(long j) {
        if (_isPrepared()) {
            this.mHandler.removeCallbacks(this.mKiller);
            this.mHandler.postDelayed(this.mKiller, j);
        }
    }

    public final boolean tryRestart() {
        if (!_isPrepared()) {
            return false;
        }
        this.mHandler.removeCallbacks(this.mKiller);
        return true;
    }

    public final boolean _isPrepared() {
        return this.mPrepared && this.mHandler != null;
    }

    final boolean isPrepared() {
        return this.mPrepared;
    }

    public static void setDebugEnabled(boolean z) {
        DEBUG = z;
    }

    public static boolean isDebugEnabled() {
        return DEBUG;
    }

    public final void println(String str, int i, @NonNull String str2) {
        if (_isPrepared()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(DateFormat.format("yyyy-MM-dd kk:mm:ss", System.currentTimeMillis()));
            stringBuilder.append(":").append(str);
            stringBuilder.append(":").append(str2).append("\n");
            this.mHandler.obtainMessage(1, stringBuilder.toString()).sendToTarget();
        }
        if (DEBUG && i != 4) {
        }
    }

    public final String getDirString() {
        if (this.mBackupDir != null) {
            return this.mBackupDir.getName();
        }
        return null;
    }
}
