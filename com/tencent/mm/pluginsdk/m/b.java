package com.tencent.mm.pluginsdk.m;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.SensorManager;
import android.media.MediaRecorder;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.mm.compatible.d.c;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.sdk.platformtools.w;

public final class b {
    public Context context;
    public int fileSize;
    public String filename;
    public int hYB;
    private boolean nBH = false;
    public MediaRecorder nEx;
    public a pxW;
    public f sHn;
    public int sHo = 0;
    private final int sHp = 5;
    private a sHq = new a(Looper.getMainLooper());

    private static class a extends Handler {
        int kzY = 0;
        boolean nBH = false;

        public a(Looper looper) {
            super(looper);
        }

        @TargetApi(8)
        public final void handleMessage(Message message) {
            Camera camera = (Camera) message.obj;
            Parameters parameters = camera.getParameters();
            int zoom = parameters.getZoom() + this.kzY;
            if (this.nBH) {
                if (zoom >= parameters.getMaxZoom() / 2) {
                    zoom = parameters.getMaxZoom() / 2;
                } else {
                    sendMessageDelayed(Message.obtain(this, 4353, 0, 0, message.obj), 20);
                }
            } else if (zoom <= 0) {
                zoom = 0;
            } else {
                sendMessageDelayed(Message.obtain(this, 4353, 0, 0, message.obj), 20);
            }
            parameters.setZoom(zoom);
            camera.setParameters(parameters);
        }
    }

    @SuppressLint({"NewApi"})
    public final void a(Surface surface, int i, int i2) {
        while (this.sHn != null) {
            Camera camera = this.sHn.gPJ;
            if (surface == null || camera == null) {
                w.e("MicroMsg.SceneVideo", "holder or cam is null ");
                return;
            }
            int i3 = p.gRl.gQi == -1 ? i : p.gRl.gQi;
            int bDR = f.bDR();
            try {
                camera.unlock();
            } catch (Exception e) {
                w.w("MicroMsg.SceneVideo", "exception in cam.unlock() [%s]", new Object[]{e.getMessage()});
            }
            this.nEx = new MediaRecorder();
            this.nEx.setCamera(camera);
            this.nEx.setAudioSource(5);
            this.nEx.setVideoSource(1);
            this.nEx.setOutputFormat(2);
            this.nEx.setVideoSize(this.pxW.lAJ, this.pxW.lAK);
            this.nEx.setVideoEncoder(2);
            this.nEx.setAudioEncoder(3);
            if (VERSION.SDK_INT > 7) {
                this.nEx.setVideoEncodingBitRate(this.pxW.nDb);
            }
            try {
                if (p.gRe.gRC) {
                    this.nEx.setVideoFrameRate(p.gRe.gRF);
                } else {
                    this.nEx.setVideoFrameRate(i3);
                }
            } catch (Exception e2) {
                w.d("MicroMsg.SceneVideo", "try set fps failed: " + i3);
            }
            this.nEx.setOutputFile(this.pxW.nDk);
            this.nEx.setPreviewDisplay(surface);
            w.d("MicroMsg.SceneVideo", "doStart camid[%s] params:\n%s", new Object[]{Integer.valueOf(bDR), this.pxW.toString()});
            if (bDR == 0) {
                setOrientationHint(p.gRl.gQc == -1 ? 90 : p.gRl.gQc);
            } else {
                if (p.gRl.gQd == -1) {
                    i3 = 270;
                } else {
                    i3 = p.gRl.gQd;
                }
                setOrientationHint(i3);
            }
            try {
                this.nEx.prepare();
                this.nEx.start();
                return;
            } catch (Throwable e3) {
                w.w("MicroMsg.SceneVideo", "exception in mediaRecorder[%s] doStartCount[%s]", new Object[]{e3.getMessage(), Integer.valueOf(this.sHo)});
                w.printErrStackTrace("MicroMsg.SceneVideo", e3, "", new Object[0]);
                this.sHo++;
                if (this.sHo < 5) {
                    f fVar = this.sHn;
                    if (i2 < 0 || i2 >= fVar.sHy.size()) {
                        w.d("MicroMsg.YuvReocrder", "ret fr " + i);
                    } else {
                        w.d("MicroMsg.YuvReocrder", "ret fr " + fVar.sHy.get(i2));
                        i = ((Integer) fVar.sHy.get(i2)).intValue();
                    }
                    i2++;
                } else {
                    return;
                }
            }
        }
        w.e("MicroMsg.SceneVideo", "yuvRecoder is null");
    }

    @TargetApi(9)
    private void setOrientationHint(final int i) {
        com.tencent.mm.compatible.a.a.a(9, new com.tencent.mm.compatible.a.a.a(this) {
            final /* synthetic */ b sHr;

            public final void run() {
                if (this.sHr.nEx != null) {
                    this.sHr.nEx.setOrientationHint(i);
                }
            }
        });
    }

    public final int g(Activity activity, boolean z) {
        int sb;
        this.context = activity;
        f fVar = this.sHn;
        a aVar = this.pxW;
        if (aVar == null) {
            sb = 0 - g.sb();
        } else {
            fVar.sHx = aVar;
            if (fVar.aJs == null && fVar.nBN == null) {
                fVar.aJs = (SensorManager) activity.getSystemService("sensor");
                fVar.nBN = fVar.aJs.getDefaultSensor(1);
            }
            if (z || fVar.gPJ == null) {
                fVar.aKL();
                if (z) {
                    f.nBK = (f.nBK ^ -1) & 1;
                }
                fVar.nBM = c.n(activity, f.nBK);
                if (fVar.nBM == null) {
                    w.e("MicroMsg.YuvReocrder", "start camera FAILED!");
                    sb = 0 - g.sb();
                } else {
                    fVar.gPJ = fVar.nBM.gPJ;
                    fVar.sHx.gPG = fVar.nBM.gPG;
                    if (fVar.gPJ == null) {
                        w.e("MicroMsg.YuvReocrder", "start camera FAILED!");
                        sb = 0 - g.sb();
                    }
                }
            }
            sb = 0;
        }
        if (sb != 0) {
            return sb;
        }
        return 0;
    }

    public final int bDM() {
        this.sHn.aKL();
        return 0;
    }

    public final int b(SurfaceHolder surfaceHolder) {
        return this.sHn.b(surfaceHolder);
    }

    public final int arP() {
        if (this.sHn.gPJ == null) {
            return 0;
        }
        return this.sHn.gPJ.getParameters().getPreviewSize().width;
    }

    public final int arQ() {
        if (this.sHn.gPJ == null) {
            return 0;
        }
        return this.sHn.gPJ.getParameters().getPreviewSize().height;
    }
}
