package com.tencent.mm.plugin.gallery.model;

import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;

public final class e {
    private ae hgN;
    ae meA;
    ae meB;
    HandlerThread mew = new HandlerThread("galleryDecodeHanlderThread", 10);
    HandlerThread mex;
    HandlerThread mey;
    ae mez = null;

    public e() {
        w.d("MicroMsg.GalleryHandlerThread", "galleryhandlerthread init");
        this.mew.start();
        this.mex = new HandlerThread("galleryQueryHandlerThread", 1);
        this.meA = null;
        this.mex.start();
        this.mey = new HandlerThread("galleryAfterTakePicThreadThread", 0);
        this.meB = null;
        this.mey.start();
    }

    public final ae ayx() {
        if (this.mez == null && this.mew != null) {
            this.mez = new ae(this.mew.getLooper());
        }
        return this.mez;
    }

    public final void nb(int i) {
        try {
            Process.setThreadPriority(this.mey.getThreadId(), i);
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.GalleryHandlerThread", e, "", new Object[0]);
        }
    }

    public final ae ayy() {
        if (this.meA == null) {
            this.meA = new ae(this.mex.getLooper());
        }
        return this.meA;
    }

    public final ae ayz() {
        if (this.hgN == null) {
            this.hgN = new ae(Looper.getMainLooper());
        }
        return this.hgN;
    }

    public final void u(Runnable runnable) {
        ae ayx = ayx();
        if (ayx == null) {
            w.e("MicroMsg.GalleryHandlerThread", "post to decode worker, but decode handler is null");
        } else {
            ayx.post(runnable);
        }
    }

    public final void ayA() {
        ae ayx = ayx();
        if (ayx == null) {
            w.e("MicroMsg.GalleryHandlerThread", "remove all work handler callbacks, but decode handler is null");
        } else {
            ayx.removeCallbacksAndMessages(null);
        }
    }

    public final void v(Runnable runnable) {
        ayz().post(runnable);
    }
}
