package com.tencent.mm.plugin.mmsight.model;

import android.app.Activity;
import android.hardware.Camera;
import com.tencent.mm.compatible.d.c;
import com.tencent.mm.compatible.d.c.a.a;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

final class n {
    public Object lock = new byte[0];
    public boolean nCP = false;
    public a nCQ;

    n() {
    }

    public final a e(Activity activity, int i) {
        if (activity == null) {
            return null;
        }
        final long Nz = bg.Nz();
        final long id = Thread.currentThread().getId();
        this.nCP = false;
        this.nCQ = null;
        synchronized (this.lock) {
            final Activity activity2 = activity;
            final int i2 = i;
            e.post(new Runnable(this) {
                final /* synthetic */ n nCT;

                public final void run() {
                    w.i("MicroMsg.SightCamera.OpenCameraThread", "Start Open Camera thread[parent:%d this:%d] time:%d", new Object[]{Long.valueOf(id), Long.valueOf(Thread.currentThread().getId()), Long.valueOf(bg.Nz() - Nz)});
                    try {
                        this.nCT.nCQ = c.n(activity2, i2);
                    } catch (Exception e) {
                        w.e("MicroMsg.SightCamera.OpenCameraThread", "openCamera failed e:%s", new Object[]{e.getMessage()});
                    }
                    synchronized (this.nCT.lock) {
                        if (this.nCT.nCP && this.nCT.nCQ != null) {
                            w.e("MicroMsg.SightCamera.OpenCameraThread", "thread time out now, release camera :%d ", new Object[]{Long.valueOf(bg.Nz() - Nz)});
                            try {
                                Camera camera = this.nCT.nCQ.gPJ;
                                camera.setPreviewCallback(null);
                                camera.stopPreview();
                                camera.release();
                                this.nCT.nCQ = null;
                            } catch (Exception e2) {
                                w.e("MicroMsg.SightCamera.OpenCameraThread", "realease Camera failed e:%s", new Object[]{e2.getMessage()});
                            }
                        }
                        this.nCT.lock.notify();
                    }
                }
            }, "SightCamera_openCamera");
            try {
                this.lock.wait(30000);
            } catch (InterruptedException e) {
                w.e("MicroMsg.SightCamera.OpenCameraThread", "Lock wait failed e:%s", new Object[]{e.getMessage()});
            }
            if (this.nCQ == null || this.nCQ.gPJ == null) {
                this.nCP = true;
                w.e("MicroMsg.SightCamera.OpenCameraThread", "Open Camera Timeout:%d", new Object[]{Long.valueOf(bg.Nz() - Nz)});
                return null;
            }
            w.i("MicroMsg.SightCamera.OpenCameraThread", "Open Camera Succ thread:%d Time:%d camera:%s", new Object[]{Long.valueOf(id), Long.valueOf(bg.Nz() - Nz), this.nCQ.gPJ});
            a aVar = this.nCQ;
            return aVar;
        }
    }
}
