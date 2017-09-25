package com.tencent.mm.sdk.platformtools;

import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetMusicPlayerState;
import java.io.File;
import java.io.IOException;

public class FLock {
    private File iyI;
    private volatile int usy;

    private static native int nativeFree(int i);

    private static native int nativeInit(String str);

    private static native int nativeLockRead(int i, boolean z);

    private static native int nativeLockWrite(int i, boolean z);

    private static native int nativeUnlock(int i);

    public FLock(String str) {
        this(new File(str), true);
    }

    public FLock(File file, boolean z) {
        this.iyI = null;
        this.usy = -1;
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Throwable e) {
                throw new IllegalStateException(e);
            }
        } else if (!file.isFile()) {
            throw new IllegalArgumentException("target is not a file.");
        }
        this.iyI = file;
    }

    protected void finalize() {
        super.finalize();
        unlock();
    }

    private synchronized int bIB() {
        if (!this.iyI.exists()) {
            try {
                this.iyI.createNewFile();
            } catch (IOException e) {
            }
            this.usy = -1;
        }
        if (this.usy == -1) {
            this.usy = nativeInit(this.iyI.getAbsolutePath());
        }
        return this.usy;
    }

    private synchronized void free() {
        if (this.usy != -1) {
            nativeFree(this.usy);
            this.usy = -1;
        }
    }

    public final synchronized void bIC() {
        int bIB = bIB();
        while (true) {
            switch (nativeLockRead(bIB, true)) {
                case 4:
                case 11:
                    try {
                        Thread.sleep(0);
                    } catch (InterruptedException e) {
                    }
                case 9:
                    throw new IllegalStateException("bad file descriptor.");
                case 22:
                    throw new IllegalStateException("bad operation.");
                case JsApiGetMusicPlayerState.CTRL_INDEX /*46*/:
                    throw new IllegalStateException("kernel lock spaces ran out.");
                default:
            }
        }
    }

    public final synchronized boolean bID() {
        boolean z = false;
        synchronized (this) {
            int bIB = bIB();
            while (true) {
                switch (nativeLockWrite(bIB, false)) {
                    case 4:
                        try {
                            Thread.sleep(0);
                        } catch (InterruptedException e) {
                        }
                    case 9:
                        throw new IllegalStateException("bad file descriptor.");
                    case 11:
                        break;
                    case 22:
                        throw new IllegalStateException("bad operation.");
                    case JsApiGetMusicPlayerState.CTRL_INDEX /*46*/:
                        throw new IllegalStateException("kernel lock spaces ran out.");
                    default:
                        z = true;
                        break;
                }
            }
        }
        return z;
    }

    public final synchronized void bIE() {
        int bIB = bIB();
        while (true) {
            switch (nativeLockWrite(bIB, true)) {
                case 4:
                case 11:
                    try {
                        Thread.sleep(0);
                    } catch (InterruptedException e) {
                    }
                case 9:
                    throw new IllegalStateException("bad file descriptor.");
                case 22:
                    throw new IllegalStateException("bad operation.");
                case JsApiGetMusicPlayerState.CTRL_INDEX /*46*/:
                    throw new IllegalStateException("kernel lock spaces ran out.");
                default:
            }
        }
    }

    public final synchronized void unlock() {
        if (this.usy != -1) {
            try {
                int nativeUnlock = nativeUnlock(this.usy);
                switch (nativeUnlock) {
                    case 0:
                        free();
                        break;
                    case 9:
                        throw new IllegalArgumentException(this.usy + " is not a valid fd.");
                    case 22:
                        throw new IllegalStateException("bad operation.");
                    default:
                        throw new IllegalStateException("other err: " + nativeUnlock);
                }
            } catch (Throwable th) {
                free();
            }
        }
    }
}
