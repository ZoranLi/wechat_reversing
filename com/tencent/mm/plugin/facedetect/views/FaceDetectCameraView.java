package com.tencent.mm.plugin.facedetect.views;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.TextureView.SurfaceTextureListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import com.tencent.mm.plugin.facedetect.FaceProNative.FaceResult;
import com.tencent.mm.plugin.facedetect.model.FaceCharacteristicsResult;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.mm.plugin.facedetect.model.d;
import com.tencent.mm.plugin.facedetect.model.f;
import com.tencent.mm.plugin.facedetect.model.g;
import com.tencent.mm.plugin.facedetect.model.m;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.MMTextureView;
import java.lang.ref.WeakReference;

public class FaceDetectCameraView extends MMTextureView implements SurfaceTextureListener {
    private static a lBF = null;
    private int height;
    private boolean jQt;
    private final Object lBA;
    private final Object lBB;
    private Rect lBC;
    private c lBD;
    private boolean lBE;
    public b lBG;
    private byte[] lBH;
    private boolean lBI;
    private long lBJ;
    b lBo;
    private SurfaceTexture lBp;
    private ActivityManager lBq;
    private long lBr;
    private long lBs;
    private int lBt;
    private boolean lBu;
    private boolean lBv;
    private boolean lBw;
    private final Object lBx;
    private boolean lBy;
    private boolean lBz;
    private long lvQ;
    private int width;

    private static class a extends ae {
        private WeakReference<FaceDetectCameraView> zv;

        public a(FaceDetectCameraView faceDetectCameraView) {
            super(Looper.getMainLooper());
            this.zv = new WeakReference(faceDetectCameraView);
        }

        public final void handleMessage(Message message) {
            super.handleMessage(message);
            if (this.zv == null || this.zv.get() == null) {
                w.e("MicroMsg.FaceDetectCameraView", "hy: no referenced view. exit");
            } else if (message.what == 1) {
                FaceCharacteristicsResult faceCharacteristicsResult = (FaceCharacteristicsResult) message.obj;
                if (FaceCharacteristicsResult.mh(faceCharacteristicsResult.errCode)) {
                    if (((FaceDetectCameraView) this.zv.get()).lBo != null) {
                        ((FaceDetectCameraView) this.zv.get()).lBo.d(faceCharacteristicsResult);
                    }
                } else if (FaceCharacteristicsResult.mg(faceCharacteristicsResult.errCode)) {
                    if (((FaceDetectCameraView) this.zv.get()).lBo != null) {
                        ((FaceDetectCameraView) this.zv.get()).lBo.b(faceCharacteristicsResult.errCode, faceCharacteristicsResult.fPf);
                    }
                } else if (((FaceDetectCameraView) this.zv.get()).lBo != null) {
                    ((FaceDetectCameraView) this.zv.get()).lBo.c(faceCharacteristicsResult);
                }
            }
        }
    }

    private interface b {
        void a(c cVar);

        int arP();

        int arQ();

        void asJ();

        void asK();

        Point asL();

        void bO(long j);

        int getRotation();

        void stopPreview();
    }

    private class c implements b {
        final /* synthetic */ FaceDetectCameraView lBK;
        public m lBO = null;
        public PreviewCallback lBP = new PreviewCallback(this) {
            final /* synthetic */ c lBS;

            {
                this.lBS = r1;
            }

            public final void onPreviewFrame(byte[] bArr, Camera camera) {
                w.v("MicroMsg.FaceDetectCameraView", "hy: on preview callback");
                d aru = d.aru();
                synchronized (d.mLock) {
                    w.v("MicroMsg.FaceCameraDataCallbackHolder", "hy: publish");
                    if (aru.lvJ == null || aru.lvJ.size() == 0) {
                        w.w("MicroMsg.FaceCameraDataCallbackHolder", "hy: nothing's listening to preview data");
                    } else if (bArr == null || bArr.length == 0) {
                        w.w("MicroMsg.FaceCameraDataCallbackHolder", "hy: null camera data got");
                    } else {
                        for (a aVar : aru.lvJ) {
                            int length = bArr.length;
                            aVar.data = (byte[]) aVar.lvK.arv().c(Integer.valueOf(length));
                            System.arraycopy(bArr, 0, aVar.data, 0, length);
                            aVar.lvK.an(aVar.data);
                        }
                    }
                }
            }
        };
        private com.tencent.mm.plugin.facedetect.model.d.b lBQ = new com.tencent.mm.plugin.facedetect.model.d.b(this) {
            final /* synthetic */ c lBS;

            {
                this.lBS = r1;
            }

            public final void an(byte[] bArr) {
                if (!this.lBS.lBK.lBI) {
                    if (this.lBS.lBK.lBH == null) {
                        this.lBS.lBK.lBH = com.tencent.mm.plugin.facedetect.model.c.lvG.h(Integer.valueOf(bArr.length));
                    }
                    System.arraycopy(bArr, 0, this.lBS.lBK.lBH, 0, bArr.length);
                    this.lBS.lBK.lBH = bArr;
                }
                com.tencent.mm.plugin.facedetect.model.c.lvG.x(bArr);
                f.arE().post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass4 lBU;

                    {
                        this.lBU = r1;
                    }

                    public final void run() {
                        w.v("MicroMsg.FaceDetectCameraView", "hy: on get preview");
                        long NA = bg.NA();
                        long p = NA - this.lBU.lBS.lBK.lBs;
                        if (this.lBU.lBS.lBK.lBs >= 0) {
                            w.v("MicroMsg.FaceDetectCameraView", "hy: tweenMillis: %d", new Object[]{Long.valueOf(p)});
                        }
                        if (this.lBU.lBS.lBK.lBs < 0 || p > this.lBU.lBS.lBK.lBr) {
                            this.lBU.lBS.lBK.lBs = NA;
                            FaceDetectCameraView.b(this.lBU.lBS.lBK, this.lBU.lBS.lBK.lBH);
                        }
                    }
                });
            }

            public final com.tencent.mm.memory.a<byte[]> arv() {
                return com.tencent.mm.plugin.facedetect.model.c.lvG;
            }
        };

        public c(FaceDetectCameraView faceDetectCameraView) {
            this.lBK = faceDetectCameraView;
            this.lBO = new m(faceDetectCameraView.getContext());
            faceDetectCameraView.lBs = -1;
            faceDetectCameraView.lBI = false;
        }

        public final void a(c cVar) {
            this.lBK.lBD = cVar;
            if (this.lBO == null) {
                w.w("MicroMsg.FaceDetectCameraView", "hy: camera is null. return");
            } else if (this.lBO.lwK) {
                w.w("MicroMsg.FaceDetectCameraView", "hy: already previewed. return");
                FaceDetectCameraView.e(this.lBK);
            } else {
                this.lBK.lBz = true;
                if (this.lBK.lBu) {
                    final long NA = bg.NA();
                    e.post(new Runnable(this) {
                        final /* synthetic */ c lBS;

                        /* JADX WARNING: inconsistent code. */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public final void run() {
                            /*
                            r10 = this;
                            r0 = 1;
                            r1 = 0;
                            r2 = r10.lBS;
                            r2 = r2.lBK;
                            r2 = r2.lBB;
                            monitor-enter(r2);
                            r3 = "MicroMsg.FaceDetectCameraView";
                            r4 = "hy: enter worker thread. using %d ms";
                            r5 = 1;
                            r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x0120 }
                            r6 = 0;
                            r8 = r0;	 Catch:{ all -> 0x0120 }
                            r8 = com.tencent.mm.sdk.platformtools.bg.aB(r8);	 Catch:{ all -> 0x0120 }
                            r7 = java.lang.Long.valueOf(r8);	 Catch:{ all -> 0x0120 }
                            r5[r6] = r7;	 Catch:{ all -> 0x0120 }
                            com.tencent.mm.sdk.platformtools.w.i(r3, r4, r5);	 Catch:{ all -> 0x0120 }
                            r4 = com.tencent.mm.sdk.platformtools.bg.NA();	 Catch:{ all -> 0x0120 }
                            r3 = r10.lBS;	 Catch:{ all -> 0x0120 }
                            r3 = r3.lBO;	 Catch:{ all -> 0x0120 }
                            if (r3 != 0) goto L_0x004b;
                        L_0x002e:
                            r0 = "MicroMsg.FaceDetectCameraView";
                            r1 = "hy: already released";
                            com.tencent.mm.sdk.platformtools.w.e(r0, r1);	 Catch:{ all -> 0x0120 }
                            r0 = r10.lBS;	 Catch:{ all -> 0x0120 }
                            r0 = r0.lBK;	 Catch:{ all -> 0x0120 }
                            r0 = r0.lBD;	 Catch:{ all -> 0x0120 }
                            if (r0 == 0) goto L_0x0049;
                        L_0x0041:
                            r0 = new com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView$c$1$1;	 Catch:{ all -> 0x0120 }
                            r0.<init>(r10);	 Catch:{ all -> 0x0120 }
                            com.tencent.mm.sdk.platformtools.af.v(r0);	 Catch:{ all -> 0x0120 }
                        L_0x0049:
                            monitor-exit(r2);	 Catch:{ all -> 0x0120 }
                        L_0x004a:
                            return;
                        L_0x004b:
                            r3 = r10.lBS;	 Catch:{ IOException -> 0x0126 }
                            r3 = r3.lBO;	 Catch:{ IOException -> 0x0126 }
                            r6 = r10.lBS;	 Catch:{ IOException -> 0x0126 }
                            r6 = r6.lBK;	 Catch:{ IOException -> 0x0126 }
                            r6 = r6.width;	 Catch:{ IOException -> 0x0126 }
                            r7 = r10.lBS;	 Catch:{ IOException -> 0x0126 }
                            r7 = r7.lBK;	 Catch:{ IOException -> 0x0126 }
                            r7 = r7.height;	 Catch:{ IOException -> 0x0126 }
                            r8 = new android.graphics.Point;	 Catch:{ IOException -> 0x0126 }
                            r8.<init>(r6, r7);	 Catch:{ IOException -> 0x0126 }
                            r3.lwM = r8;	 Catch:{ IOException -> 0x0126 }
                            r3 = r10.lBS;	 Catch:{ IOException -> 0x0126 }
                            r3 = r3.lBO;	 Catch:{ IOException -> 0x0126 }
                            r6 = r3.gPJ;	 Catch:{ IOException -> 0x0126 }
                            if (r6 == 0) goto L_0x0123;
                        L_0x006e:
                            r3 = r3.lwS;	 Catch:{ IOException -> 0x0126 }
                            if (r3 == 0) goto L_0x0123;
                        L_0x0072:
                            if (r0 != 0) goto L_0x0083;
                        L_0x0074:
                            r0 = r10.lBS;	 Catch:{ IOException -> 0x0126 }
                            r0 = r0.lBO;	 Catch:{ IOException -> 0x0126 }
                            r1 = r10.lBS;	 Catch:{ IOException -> 0x0126 }
                            r1 = r1.lBK;	 Catch:{ IOException -> 0x0126 }
                            r1 = r1.lBp;	 Catch:{ IOException -> 0x0126 }
                            r0.a(r1);	 Catch:{ IOException -> 0x0126 }
                        L_0x0083:
                            r0 = r10.lBS;	 Catch:{ IOException -> 0x0126 }
                            r0 = r0.lBO;	 Catch:{ IOException -> 0x0126 }
                            r0 = r0.lwL;	 Catch:{ IOException -> 0x0126 }
                            r1 = r10.lBS;	 Catch:{ IOException -> 0x0126 }
                            r1 = r1.lBK;	 Catch:{ IOException -> 0x0126 }
                            com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView.a(r1, r0);	 Catch:{ IOException -> 0x0126 }
                            r0 = r10.lBS;	 Catch:{ IOException -> 0x0126 }
                            r0 = r0.lBO;	 Catch:{ IOException -> 0x0126 }
                            r1 = r10.lBS;	 Catch:{ IOException -> 0x0126 }
                            r1 = r1.lBK;	 Catch:{ IOException -> 0x0126 }
                            r1 = r1.lBp;	 Catch:{ IOException -> 0x0126 }
                            r6 = com.tencent.mm.sdk.platformtools.bg.NA();	 Catch:{ IOException -> 0x0126 }
                            r3 = r0.gPJ;	 Catch:{ IOException -> 0x0126 }
                            if (r3 == 0) goto L_0x00e2;
                        L_0x00a4:
                            r3 = r0.lwK;	 Catch:{ IOException -> 0x0126 }
                            if (r3 != 0) goto L_0x00e2;
                        L_0x00a8:
                            if (r1 == 0) goto L_0x00b8;
                        L_0x00aa:
                            r3 = "MicroMsg.FaceScanCamera";
                            r8 = "hy: SurfaceTexture is not null";
                            com.tencent.mm.sdk.platformtools.w.i(r3, r8);	 Catch:{ IOException -> 0x0126 }
                            r3 = r0.gPJ;	 Catch:{ IOException -> 0x0126 }
                            r3.setPreviewTexture(r1);	 Catch:{ IOException -> 0x0126 }
                        L_0x00b8:
                            r1 = r0.arP();	 Catch:{ IOException -> 0x0126 }
                            r3 = r0.arQ();	 Catch:{ IOException -> 0x0126 }
                            com.tencent.mm.plugin.facedetect.model.c.bT(r1, r3);	 Catch:{ IOException -> 0x0126 }
                            r1 = r0.gPJ;	 Catch:{ IOException -> 0x0126 }
                            r1.startPreview();	 Catch:{ IOException -> 0x0126 }
                            r1 = 1;
                            r0.lwK = r1;	 Catch:{ IOException -> 0x0126 }
                            r0 = "MicroMsg.FaceScanCamera";
                            r1 = "startPreview done costTime=[%s]";
                            r3 = 1;
                            r3 = new java.lang.Object[r3];	 Catch:{ IOException -> 0x0126 }
                            r8 = 0;
                            r6 = com.tencent.mm.sdk.platformtools.bg.aB(r6);	 Catch:{ IOException -> 0x0126 }
                            r6 = java.lang.Long.valueOf(r6);	 Catch:{ IOException -> 0x0126 }
                            r3[r8] = r6;	 Catch:{ IOException -> 0x0126 }
                            com.tencent.mm.sdk.platformtools.w.d(r0, r1, r3);	 Catch:{ IOException -> 0x0126 }
                        L_0x00e2:
                            r0 = r10.lBS;	 Catch:{ IOException -> 0x0126 }
                            r0 = r0.lBO;	 Catch:{ IOException -> 0x0126 }
                            r1 = r10.lBS;	 Catch:{ IOException -> 0x0126 }
                            r1 = r1.lBP;	 Catch:{ IOException -> 0x0126 }
                            r0.setPreviewCallback(r1);	 Catch:{ IOException -> 0x0126 }
                            r0 = r10.lBS;	 Catch:{ IOException -> 0x0126 }
                            r0 = r0.lBK;	 Catch:{ IOException -> 0x0126 }
                            r0 = r0.lBD;	 Catch:{ IOException -> 0x0126 }
                            if (r0 == 0) goto L_0x00ff;
                        L_0x00f7:
                            r0 = new com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView$c$1$2;	 Catch:{ IOException -> 0x0126 }
                            r0.<init>(r10);	 Catch:{ IOException -> 0x0126 }
                            com.tencent.mm.sdk.platformtools.af.v(r0);	 Catch:{ IOException -> 0x0126 }
                        L_0x00ff:
                            r0 = "MicroMsg.FaceDetectCameraView";
                            r1 = "hy: opened and start preview. use: %d ms";
                            r3 = 1;
                            r3 = new java.lang.Object[r3];	 Catch:{ IOException -> 0x0126 }
                            r6 = 0;
                            r4 = com.tencent.mm.sdk.platformtools.bg.aB(r4);	 Catch:{ IOException -> 0x0126 }
                            r4 = java.lang.Long.valueOf(r4);	 Catch:{ IOException -> 0x0126 }
                            r3[r6] = r4;	 Catch:{ IOException -> 0x0126 }
                            com.tencent.mm.sdk.platformtools.w.i(r0, r1, r3);	 Catch:{ IOException -> 0x0126 }
                            r0 = r10.lBS;	 Catch:{ all -> 0x0120 }
                            r0 = r0.lBK;	 Catch:{ all -> 0x0120 }
                            com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView.e(r0);	 Catch:{ all -> 0x0120 }
                            monitor-exit(r2);	 Catch:{ all -> 0x0120 }
                            goto L_0x004a;
                        L_0x0120:
                            r0 = move-exception;
                            monitor-exit(r2);	 Catch:{ all -> 0x0120 }
                            throw r0;
                        L_0x0123:
                            r0 = r1;
                            goto L_0x0072;
                        L_0x0126:
                            r0 = move-exception;
                            r1 = "MicroMsg.FaceDetectCameraView";
                            r3 = "hy: exception caused";
                            r4 = 0;
                            r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x0120 }
                            com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r1, r0, r3, r4);	 Catch:{ all -> 0x0120 }
                            r0 = r10.lBS;	 Catch:{ all -> 0x0120 }
                            r0 = r0.lBK;	 Catch:{ all -> 0x0120 }
                            r0 = r0.lBD;	 Catch:{ all -> 0x0120 }
                            if (r0 == 0) goto L_0x0145;
                        L_0x013d:
                            r0 = new com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView$c$1$3;	 Catch:{ all -> 0x0120 }
                            r0.<init>(r10);	 Catch:{ all -> 0x0120 }
                            com.tencent.mm.sdk.platformtools.af.v(r0);	 Catch:{ all -> 0x0120 }
                        L_0x0145:
                            monitor-exit(r2);	 Catch:{ all -> 0x0120 }
                            goto L_0x004a;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView.c.1.run():void");
                        }
                    }, "FaceDetectCameraView_Camera");
                } else if (this.lBK.isAvailable()) {
                    w.i("MicroMsg.FaceDetectCameraView", "hy: already available. manually call available");
                    this.lBK.onSurfaceTextureAvailable(this.lBK.getSurfaceTexture(), this.lBK.getWidth(), this.lBK.getHeight());
                } else {
                    w.w("MicroMsg.FaceDetectCameraView", "hy: not initialized yet. do after init");
                }
            }
        }

        public final void stopPreview() {
            synchronized (this.lBK.lBB) {
                if (this.lBO != null && this.lBO.lwK) {
                    m mVar = this.lBO;
                    if (mVar.gPJ != null) {
                        mVar.gPJ.stopPreview();
                        mVar.lwK = false;
                        com.tencent.mm.plugin.facedetect.model.c.lvG.wl();
                    }
                }
            }
        }

        public final void asJ() {
            if (!this.lBK.lBw) {
                this.lBK.lBw = true;
                e.post(new Runnable(this) {
                    final /* synthetic */ c lBS;

                    {
                        this.lBS = r1;
                    }

                    public final void run() {
                        synchronized (this.lBS.lBK.lBB) {
                            if (this.lBS.lBO == null) {
                                return;
                            }
                            w.d("MicroMsg.FaceDetectCameraView", "hy: closeCamera");
                            this.lBS.lBO.setPreviewCallback(null);
                            d aru = d.aru();
                            synchronized (d.mLock) {
                                if (aru.lvJ != null) {
                                    aru.lvJ.clear();
                                }
                            }
                            if (this.lBS.lBK.lBp != null) {
                                this.lBS.lBK.lBp.release();
                            }
                            this.lBS.lBO.release();
                            this.lBS.lBO = null;
                            w.d("MicroMsg.FaceDetectCameraView", "hy: scanCamera.release() done");
                            this.lBS.lBK.lBw = false;
                        }
                    }
                }, "FaceDetectCameraView_Camera");
            }
        }

        public final int arP() {
            return this.lBO.arP();
        }

        public final int arQ() {
            return this.lBO.arQ();
        }

        public final int getRotation() {
            return this.lBO.lwP;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void bO(long r8) {
            /*
            r7 = this;
            r0 = r7.lBK;
            r1 = r0.lBB;
            monitor-enter(r1);
            r0 = r7.lBO;	 Catch:{ all -> 0x005f }
            if (r0 != 0) goto L_0x0016;
        L_0x000b:
            r0 = "MicroMsg.FaceDetectCameraView";
            r2 = "hy: camera is null. return";
            com.tencent.mm.sdk.platformtools.w.w(r0, r2);	 Catch:{ all -> 0x005f }
            monitor-exit(r1);	 Catch:{ all -> 0x005f }
        L_0x0015:
            return;
        L_0x0016:
            r0 = "MicroMsg.FaceDetectCameraView";
            r2 = "hy: start capturing. tween: %d";
            r3 = 1;
            r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x005f }
            r4 = 0;
            r5 = java.lang.Long.valueOf(r8);	 Catch:{ all -> 0x005f }
            r3[r4] = r5;	 Catch:{ all -> 0x005f }
            com.tencent.mm.sdk.platformtools.w.i(r0, r2, r3);	 Catch:{ all -> 0x005f }
            r0 = r7.lBK;	 Catch:{ all -> 0x005f }
            r0.lBr = r8;	 Catch:{ all -> 0x005f }
            r0 = r7.lBK;	 Catch:{ all -> 0x005f }
            r0 = r0.jQt;	 Catch:{ all -> 0x005f }
            if (r0 != 0) goto L_0x0072;
        L_0x0036:
            r0 = r7.lBO;	 Catch:{ all -> 0x005f }
            if (r0 == 0) goto L_0x0062;
        L_0x003a:
            r0 = r7.lBO;	 Catch:{ all -> 0x005f }
            r0 = r0.lwK;	 Catch:{ all -> 0x005f }
            if (r0 == 0) goto L_0x0062;
        L_0x0040:
            r0 = "MicroMsg.FaceDetectCameraView";
            r2 = "hy: is previewing. directly start capture";
            com.tencent.mm.sdk.platformtools.w.i(r0, r2);	 Catch:{ all -> 0x005f }
            r0 = r7.lBK;	 Catch:{ all -> 0x005f }
            r2 = 0;
            r0.lBy = r2;	 Catch:{ all -> 0x005f }
            r0 = com.tencent.mm.plugin.facedetect.model.d.aru();	 Catch:{ all -> 0x005f }
            r2 = r7.lBQ;	 Catch:{ all -> 0x005f }
            r0.a(r2);	 Catch:{ all -> 0x005f }
            r0 = r7.lBK;	 Catch:{ all -> 0x005f }
            r0.jQt = true;	 Catch:{ all -> 0x005f }
        L_0x005d:
            monitor-exit(r1);	 Catch:{ all -> 0x005f }
            goto L_0x0015;
        L_0x005f:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x005f }
            throw r0;
        L_0x0062:
            r0 = "MicroMsg.FaceDetectCameraView";
            r2 = "hy: not previewed yet. wait";
            com.tencent.mm.sdk.platformtools.w.i(r0, r2);	 Catch:{ all -> 0x005f }
            r0 = r7.lBK;	 Catch:{ all -> 0x005f }
            r2 = 1;
            r0.lBy = r2;	 Catch:{ all -> 0x005f }
            goto L_0x005d;
        L_0x0072:
            r0 = "MicroMsg.FaceDetectCameraView";
            r2 = "hy: already scanning";
            com.tencent.mm.sdk.platformtools.w.w(r0, r2);	 Catch:{ all -> 0x005f }
            goto L_0x005d;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView.c.bO(long):void");
        }

        public final void asK() {
            synchronized (this.lBK.lBB) {
                if (this.lBO != null && this.lBO.lwK) {
                    d.aru().b(this.lBQ);
                    if (!this.lBK.lBI) {
                        this.lBK.lBH = null;
                    }
                }
            }
        }

        public final Point asL() {
            return this.lBO.lwT;
        }
    }

    static /* synthetic */ void a(FaceDetectCameraView faceDetectCameraView, Point point) {
        DisplayMetrics displayMetrics = faceDetectCameraView.getResources().getDisplayMetrics();
        int i = displayMetrics.widthPixels;
        final int i2 = displayMetrics.heightPixels;
        w.v("MicroMsg.FaceDetectCameraView", "alvinluo screen size: (%d, %d)", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        final int i3 = displayMetrics.widthPixels;
        i = (int) (((1.0d * ((double) i3)) * ((double) point.x)) / ((double) point.y));
        w.i("MicroMsg.FaceDetectCameraView", "alvinluo previewResolution: (%d, %d), adjust: (%d, %d), temp:%f", new Object[]{Integer.valueOf(point.x), Integer.valueOf(point.y), Integer.valueOf(i3), Integer.valueOf(i), Double.valueOf(((1.0d * ((double) i3)) * ((double) point.x)) / ((double) point.y))});
        af.v(new Runnable(faceDetectCameraView) {
            final /* synthetic */ FaceDetectCameraView lBK;

            public final void run() {
                int i = i2 - i;
                w.i("MicroMsg.FaceDetectCameraView", "alvinluo restHeight: %d", new Object[]{Integer.valueOf(i)});
                if (i > 0) {
                    i /= 2;
                    LayoutParams layoutParams = new FrameLayout.LayoutParams(i3, i);
                    MarginLayoutParams marginLayoutParams = new MarginLayoutParams(this.lBK.getLayoutParams());
                    layoutParams.setMargins(marginLayoutParams.leftMargin, i, marginLayoutParams.rightMargin, marginLayoutParams.height + i);
                    w.v("MicroMsg.FaceDetectCameraView", "alvinluo margin left: %d, right: %d, top: %d, bottom: %d", new Object[]{Integer.valueOf(marginLayoutParams.leftMargin), Integer.valueOf(marginLayoutParams.rightMargin), Integer.valueOf(i), Integer.valueOf(i + marginLayoutParams.height)});
                    this.lBK.setLayoutParams(layoutParams);
                    this.lBK.invalidate();
                }
            }
        });
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void b(com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView r14, byte[] r15) {
        /*
        r0 = 4;
        r13 = 2;
        r6 = 0;
        r12 = 1;
        r8 = r14.lBA;
        monitor-enter(r8);
        r1 = r14.jQt;	 Catch:{ all -> 0x00a5 }
        if (r1 != 0) goto L_0x0016;
    L_0x000b:
        r0 = "MicroMsg.FaceDetectCameraView";
        r1 = "hy: not requesting scanning. stop send msg";
        com.tencent.mm.sdk.platformtools.w.w(r0, r1);	 Catch:{ all -> 0x00a5 }
        monitor-exit(r8);	 Catch:{ all -> 0x00a5 }
    L_0x0015:
        return;
    L_0x0016:
        if (r15 == 0) goto L_0x00a2;
    L_0x0018:
        r1 = r14.lBI;	 Catch:{ all -> 0x00a5 }
        if (r1 != 0) goto L_0x00a2;
    L_0x001c:
        r1 = 1;
        r14.lBI = r1;	 Catch:{ all -> 0x00a5 }
        r1 = com.tencent.mm.plugin.facedetect.model.f.lvS;	 Catch:{ all -> 0x00a5 }
        r2 = r14.lBG;	 Catch:{ all -> 0x00a5 }
        r2 = r2.arP();	 Catch:{ all -> 0x00a5 }
        r3 = r14.lBG;	 Catch:{ all -> 0x00a5 }
        r3 = r3.arQ();	 Catch:{ all -> 0x00a5 }
        r4 = r14.lBG;	 Catch:{ all -> 0x00a5 }
        r4 = r4.getRotation();	 Catch:{ all -> 0x00a5 }
        r1 = r1.lvT;	 Catch:{ all -> 0x00a5 }
        r1 = r1.lxY;	 Catch:{ all -> 0x00a5 }
        r5 = "MicroMsg.FaceDetectNativeManager";
        r7 = "alvinluo process parameter: width: %d, height: %d, depth: %d, imageType: %d, rotateAngle: %d, imgData length: %d";
        r9 = 6;
        r9 = new java.lang.Object[r9];	 Catch:{ all -> 0x00a5 }
        r10 = 0;
        r11 = java.lang.Integer.valueOf(r2);	 Catch:{ all -> 0x00a5 }
        r9[r10] = r11;	 Catch:{ all -> 0x00a5 }
        r10 = 1;
        r11 = java.lang.Integer.valueOf(r3);	 Catch:{ all -> 0x00a5 }
        r9[r10] = r11;	 Catch:{ all -> 0x00a5 }
        r10 = 2;
        r11 = 3;
        r11 = java.lang.Integer.valueOf(r11);	 Catch:{ all -> 0x00a5 }
        r9[r10] = r11;	 Catch:{ all -> 0x00a5 }
        r10 = 3;
        r11 = 1;
        r11 = java.lang.Integer.valueOf(r11);	 Catch:{ all -> 0x00a5 }
        r9[r10] = r11;	 Catch:{ all -> 0x00a5 }
        r10 = 4;
        r11 = java.lang.Integer.valueOf(r4);	 Catch:{ all -> 0x00a5 }
        r9[r10] = r11;	 Catch:{ all -> 0x00a5 }
        r10 = 5;
        r11 = r15.length;	 Catch:{ all -> 0x00a5 }
        r11 = java.lang.Integer.valueOf(r11);	 Catch:{ all -> 0x00a5 }
        r9[r10] = r11;	 Catch:{ all -> 0x00a5 }
        com.tencent.mm.sdk.platformtools.w.v(r5, r7, r9);	 Catch:{ all -> 0x00a5 }
        r7 = new com.tencent.mm.plugin.facedetect.model.FaceCharacteristicsResult;	 Catch:{ all -> 0x00a5 }
        r7.<init>();	 Catch:{ all -> 0x00a5 }
        r5 = r1.lvW;	 Catch:{ all -> 0x00a5 }
        if (r5 != 0) goto L_0x00a8;
    L_0x0079:
        r0 = "MicroMsg.FaceDetectNativeManager";
        r1 = "hy: process not init";
        com.tencent.mm.sdk.platformtools.w.e(r0, r1);	 Catch:{ all -> 0x00a5 }
        r0 = 4;
        r1 = com.tencent.mm.sdk.platformtools.ab.getContext();	 Catch:{ all -> 0x00a5 }
        r2 = com.tencent.mm.plugin.facedetect.a.h.luq;	 Catch:{ all -> 0x00a5 }
        r1 = r1.getString(r2);	 Catch:{ all -> 0x00a5 }
        r7.P(r0, r1);	 Catch:{ all -> 0x00a5 }
        r0 = r7;
    L_0x0091:
        r1 = 0;
        r14.lBI = r1;	 Catch:{ all -> 0x00a5 }
        r1 = lBF;	 Catch:{ all -> 0x00a5 }
        r1 = r1.obtainMessage();	 Catch:{ all -> 0x00a5 }
        r2 = 1;
        r1.what = r2;	 Catch:{ all -> 0x00a5 }
        r1.obj = r0;	 Catch:{ all -> 0x00a5 }
        r1.sendToTarget();	 Catch:{ all -> 0x00a5 }
    L_0x00a2:
        monitor-exit(r8);	 Catch:{ all -> 0x00a5 }
        goto L_0x0015;
    L_0x00a5:
        r0 = move-exception;
        monitor-exit(r8);	 Catch:{ all -> 0x00a5 }
        throw r0;
    L_0x00a8:
        switch(r4) {
            case 0: goto L_0x00c5;
            case 90: goto L_0x00c4;
            case 270: goto L_0x0122;
            default: goto L_0x00ab;
        };
    L_0x00ab:
        r0 = "MicroMsg.FaceDetectNativeManager";
        r1 = "hy: rotate type not support!";
        com.tencent.mm.sdk.platformtools.w.w(r0, r1);	 Catch:{ all -> 0x00a5 }
        r0 = 1;
        r1 = com.tencent.mm.sdk.platformtools.ab.getContext();	 Catch:{ all -> 0x00a5 }
        r2 = com.tencent.mm.plugin.facedetect.a.h.lun;	 Catch:{ all -> 0x00a5 }
        r1 = r1.getString(r2);	 Catch:{ all -> 0x00a5 }
        r7.P(r0, r1);	 Catch:{ all -> 0x00a5 }
        r0 = r7;
        goto L_0x0091;
    L_0x00c4:
        r6 = r0;
    L_0x00c5:
        r10 = com.tencent.mm.sdk.platformtools.bg.NA();	 Catch:{ all -> 0x00a5 }
        r0 = r1.lvW;	 Catch:{ all -> 0x00a5 }
        r4 = 3;
        r5 = 1;
        r1 = r15;
        r0 = r0.engineFaceProcess(r1, r2, r3, r4, r5, r6);	 Catch:{ all -> 0x00a5 }
        r2 = com.tencent.mm.sdk.platformtools.bg.aB(r10);	 Catch:{ all -> 0x00a5 }
        if (r0 == 0) goto L_0x00e1;
    L_0x00d8:
        r1 = com.tencent.mm.plugin.facedetect.model.FaceDetectReporter.arN();	 Catch:{ all -> 0x00a5 }
        r4 = r0.result;	 Catch:{ all -> 0x00a5 }
        r1.o(r4, r2);	 Catch:{ all -> 0x00a5 }
    L_0x00e1:
        r1 = "MicroMsg.FaceDetectNativeManager";
        r4 = "hy: process using: %d ms. result: %d";
        r5 = 2;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x00a5 }
        r6 = 0;
        r2 = java.lang.Long.valueOf(r2);	 Catch:{ all -> 0x00a5 }
        r5[r6] = r2;	 Catch:{ all -> 0x00a5 }
        r2 = 1;
        r3 = r0.result;	 Catch:{ all -> 0x00a5 }
        r3 = java.lang.Integer.valueOf(r3);	 Catch:{ all -> 0x00a5 }
        r5[r2] = r3;	 Catch:{ all -> 0x00a5 }
        com.tencent.mm.sdk.platformtools.w.d(r1, r4, r5);	 Catch:{ all -> 0x00a5 }
        r7.lvM = r0;	 Catch:{ all -> 0x00a5 }
        r0 = r7.lvM;	 Catch:{ all -> 0x00a5 }
        if (r0 != 0) goto L_0x0124;
    L_0x0103:
        r0 = "MicroMsg.FaceCharacteristicsResult";
        r1 = "hy: invalid face status";
        com.tencent.mm.sdk.platformtools.w.e(r0, r1);	 Catch:{ all -> 0x00a5 }
    L_0x010c:
        r0 = "MicroMsg.FaceDetectNativeManager";
        r1 = "hy: detect result is: %s";
        r2 = 1;
        r2 = new java.lang.Object[r2];	 Catch:{ all -> 0x00a5 }
        r3 = 0;
        r4 = r7.toString();	 Catch:{ all -> 0x00a5 }
        r2[r3] = r4;	 Catch:{ all -> 0x00a5 }
        com.tencent.mm.sdk.platformtools.w.d(r0, r1, r2);	 Catch:{ all -> 0x00a5 }
        r0 = r7;
        goto L_0x0091;
    L_0x0122:
        r6 = 5;
        goto L_0x00c5;
    L_0x0124:
        r0 = r7.lvM;	 Catch:{ all -> 0x00a5 }
        r0 = r0.result;	 Catch:{ all -> 0x00a5 }
        if (r0 <= 0) goto L_0x016c;
    L_0x012a:
        r0 = r7.lvM;	 Catch:{ all -> 0x00a5 }
        r0 = r0.result;	 Catch:{ all -> 0x00a5 }
        if (r0 != r12) goto L_0x013f;
    L_0x0130:
        r0 = 0;
        r1 = com.tencent.mm.sdk.platformtools.ab.getContext();	 Catch:{ all -> 0x00a5 }
        r2 = com.tencent.mm.plugin.facedetect.a.h.luo;	 Catch:{ all -> 0x00a5 }
        r1 = r1.getString(r2);	 Catch:{ all -> 0x00a5 }
        r7.P(r0, r1);	 Catch:{ all -> 0x00a5 }
        goto L_0x010c;
    L_0x013f:
        r0 = r7.lvM;	 Catch:{ all -> 0x00a5 }
        r0 = r0.result;	 Catch:{ all -> 0x00a5 }
        if (r0 != r13) goto L_0x0154;
    L_0x0145:
        r0 = -1;
        r1 = com.tencent.mm.sdk.platformtools.ab.getContext();	 Catch:{ all -> 0x00a5 }
        r2 = com.tencent.mm.plugin.facedetect.a.h.luo;	 Catch:{ all -> 0x00a5 }
        r1 = r1.getString(r2);	 Catch:{ all -> 0x00a5 }
        r7.P(r0, r1);	 Catch:{ all -> 0x00a5 }
        goto L_0x010c;
    L_0x0154:
        r0 = "MicroMsg.FaceCharacteristicsResult";
        r1 = "hy: unknown face num. regard as ok";
        com.tencent.mm.sdk.platformtools.w.e(r0, r1);	 Catch:{ all -> 0x00a5 }
        r0 = 0;
        r1 = com.tencent.mm.sdk.platformtools.ab.getContext();	 Catch:{ all -> 0x00a5 }
        r2 = com.tencent.mm.plugin.facedetect.a.h.luo;	 Catch:{ all -> 0x00a5 }
        r1 = r1.getString(r2);	 Catch:{ all -> 0x00a5 }
        r7.P(r0, r1);	 Catch:{ all -> 0x00a5 }
        goto L_0x010c;
    L_0x016c:
        r0 = r7.lvM;	 Catch:{ all -> 0x00a5 }
        r0 = r0.result;	 Catch:{ all -> 0x00a5 }
        if (r0 != 0) goto L_0x0182;
    L_0x0172:
        r0 = 10;
        r1 = com.tencent.mm.sdk.platformtools.ab.getContext();	 Catch:{ all -> 0x00a5 }
        r2 = com.tencent.mm.plugin.facedetect.a.h.luj;	 Catch:{ all -> 0x00a5 }
        r1 = r1.getString(r2);	 Catch:{ all -> 0x00a5 }
        r7.P(r0, r1);	 Catch:{ all -> 0x00a5 }
        goto L_0x010c;
    L_0x0182:
        r0 = r7.lvM;	 Catch:{ all -> 0x00a5 }
        r0 = r0.result;	 Catch:{ all -> 0x00a5 }
        r1 = -1;
        if (r0 == r1) goto L_0x0190;
    L_0x0189:
        r0 = r7.lvM;	 Catch:{ all -> 0x00a5 }
        r0 = r0.result;	 Catch:{ all -> 0x00a5 }
        r1 = -2;
        if (r0 != r1) goto L_0x01a0;
    L_0x0190:
        r0 = 1;
        r1 = com.tencent.mm.sdk.platformtools.ab.getContext();	 Catch:{ all -> 0x00a5 }
        r2 = com.tencent.mm.plugin.facedetect.a.h.luq;	 Catch:{ all -> 0x00a5 }
        r1 = r1.getString(r2);	 Catch:{ all -> 0x00a5 }
        r7.P(r0, r1);	 Catch:{ all -> 0x00a5 }
        goto L_0x010c;
    L_0x01a0:
        r0 = r7.lvM;	 Catch:{ all -> 0x00a5 }
        r0 = r0.result;	 Catch:{ all -> 0x00a5 }
        r1 = -11;
        if (r0 != r1) goto L_0x01b9;
    L_0x01a8:
        r0 = 13;
        r1 = com.tencent.mm.sdk.platformtools.ab.getContext();	 Catch:{ all -> 0x00a5 }
        r2 = com.tencent.mm.plugin.facedetect.a.h.lur;	 Catch:{ all -> 0x00a5 }
        r1 = r1.getString(r2);	 Catch:{ all -> 0x00a5 }
        r7.P(r0, r1);	 Catch:{ all -> 0x00a5 }
        goto L_0x010c;
    L_0x01b9:
        r0 = r7.lvM;	 Catch:{ all -> 0x00a5 }
        r0 = r0.result;	 Catch:{ all -> 0x00a5 }
        r1 = -12;
        if (r0 != r1) goto L_0x01d2;
    L_0x01c1:
        r0 = 15;
        r1 = com.tencent.mm.sdk.platformtools.ab.getContext();	 Catch:{ all -> 0x00a5 }
        r2 = com.tencent.mm.plugin.facedetect.a.h.lus;	 Catch:{ all -> 0x00a5 }
        r1 = r1.getString(r2);	 Catch:{ all -> 0x00a5 }
        r7.P(r0, r1);	 Catch:{ all -> 0x00a5 }
        goto L_0x010c;
    L_0x01d2:
        r0 = r7.lvM;	 Catch:{ all -> 0x00a5 }
        r0 = r0.result;	 Catch:{ all -> 0x00a5 }
        r1 = -13;
        if (r0 != r1) goto L_0x01eb;
    L_0x01da:
        r0 = 14;
        r1 = com.tencent.mm.sdk.platformtools.ab.getContext();	 Catch:{ all -> 0x00a5 }
        r2 = com.tencent.mm.plugin.facedetect.a.h.lug;	 Catch:{ all -> 0x00a5 }
        r1 = r1.getString(r2);	 Catch:{ all -> 0x00a5 }
        r7.P(r0, r1);	 Catch:{ all -> 0x00a5 }
        goto L_0x010c;
    L_0x01eb:
        r0 = r7.lvM;	 Catch:{ all -> 0x00a5 }
        r0 = r0.result;	 Catch:{ all -> 0x00a5 }
        r1 = -101; // 0xffffffffffffff9b float:NaN double:NaN;
        if (r0 != r1) goto L_0x0204;
    L_0x01f3:
        r0 = 102; // 0x66 float:1.43E-43 double:5.04E-322;
        r1 = com.tencent.mm.sdk.platformtools.ab.getContext();	 Catch:{ all -> 0x00a5 }
        r2 = com.tencent.mm.plugin.facedetect.a.h.luh;	 Catch:{ all -> 0x00a5 }
        r1 = r1.getString(r2);	 Catch:{ all -> 0x00a5 }
        r7.P(r0, r1);	 Catch:{ all -> 0x00a5 }
        goto L_0x010c;
    L_0x0204:
        r0 = r7.lvM;	 Catch:{ all -> 0x00a5 }
        r0 = r0.result;	 Catch:{ all -> 0x00a5 }
        r1 = -102; // 0xffffffffffffff9a float:NaN double:NaN;
        if (r0 != r1) goto L_0x021d;
    L_0x020c:
        r0 = 16;
        r1 = com.tencent.mm.sdk.platformtools.ab.getContext();	 Catch:{ all -> 0x00a5 }
        r2 = com.tencent.mm.plugin.facedetect.a.h.lui;	 Catch:{ all -> 0x00a5 }
        r1 = r1.getString(r2);	 Catch:{ all -> 0x00a5 }
        r7.P(r0, r1);	 Catch:{ all -> 0x00a5 }
        goto L_0x010c;
    L_0x021d:
        r0 = r7.lvM;	 Catch:{ all -> 0x00a5 }
        r0 = r0.result;	 Catch:{ all -> 0x00a5 }
        r1 = -103; // 0xffffffffffffff99 float:NaN double:NaN;
        if (r0 != r1) goto L_0x0236;
    L_0x0225:
        r0 = 17;
        r1 = com.tencent.mm.sdk.platformtools.ab.getContext();	 Catch:{ all -> 0x00a5 }
        r2 = com.tencent.mm.plugin.facedetect.a.h.lul;	 Catch:{ all -> 0x00a5 }
        r1 = r1.getString(r2);	 Catch:{ all -> 0x00a5 }
        r7.P(r0, r1);	 Catch:{ all -> 0x00a5 }
        goto L_0x010c;
    L_0x0236:
        r0 = r7.lvM;	 Catch:{ all -> 0x00a5 }
        r0 = r0.result;	 Catch:{ all -> 0x00a5 }
        r1 = -105; // 0xffffffffffffff97 float:NaN double:NaN;
        if (r0 != r1) goto L_0x024f;
    L_0x023e:
        r0 = 18;
        r1 = com.tencent.mm.sdk.platformtools.ab.getContext();	 Catch:{ all -> 0x00a5 }
        r2 = com.tencent.mm.plugin.facedetect.a.h.luk;	 Catch:{ all -> 0x00a5 }
        r1 = r1.getString(r2);	 Catch:{ all -> 0x00a5 }
        r7.P(r0, r1);	 Catch:{ all -> 0x00a5 }
        goto L_0x010c;
    L_0x024f:
        r0 = r7.lvM;	 Catch:{ all -> 0x00a5 }
        r0 = r0.result;	 Catch:{ all -> 0x00a5 }
        r1 = -106; // 0xffffffffffffff96 float:NaN double:NaN;
        if (r0 != r1) goto L_0x0268;
    L_0x0257:
        r0 = 11;
        r1 = com.tencent.mm.sdk.platformtools.ab.getContext();	 Catch:{ all -> 0x00a5 }
        r2 = com.tencent.mm.plugin.facedetect.a.h.lum;	 Catch:{ all -> 0x00a5 }
        r1 = r1.getString(r2);	 Catch:{ all -> 0x00a5 }
        r7.P(r0, r1);	 Catch:{ all -> 0x00a5 }
        goto L_0x010c;
    L_0x0268:
        r0 = r7.lvM;	 Catch:{ all -> 0x00a5 }
        r0 = r0.result;	 Catch:{ all -> 0x00a5 }
        r1 = -107; // 0xffffffffffffff95 float:NaN double:NaN;
        if (r0 != r1) goto L_0x0280;
    L_0x0270:
        r0 = 3;
        r1 = com.tencent.mm.sdk.platformtools.ab.getContext();	 Catch:{ all -> 0x00a5 }
        r2 = com.tencent.mm.plugin.facedetect.a.h.lup;	 Catch:{ all -> 0x00a5 }
        r1 = r1.getString(r2);	 Catch:{ all -> 0x00a5 }
        r7.P(r0, r1);	 Catch:{ all -> 0x00a5 }
        goto L_0x010c;
    L_0x0280:
        r0 = r7.lvM;	 Catch:{ all -> 0x00a5 }
        r0 = r0.result;	 Catch:{ all -> 0x00a5 }
        r1 = -108; // 0xffffffffffffff94 float:NaN double:NaN;
        if (r0 != r1) goto L_0x0298;
    L_0x0288:
        r0 = 6;
        r1 = com.tencent.mm.sdk.platformtools.ab.getContext();	 Catch:{ all -> 0x00a5 }
        r2 = com.tencent.mm.plugin.facedetect.a.h.luk;	 Catch:{ all -> 0x00a5 }
        r1 = r1.getString(r2);	 Catch:{ all -> 0x00a5 }
        r7.P(r0, r1);	 Catch:{ all -> 0x00a5 }
        goto L_0x010c;
    L_0x0298:
        r0 = r7.lvM;	 Catch:{ all -> 0x00a5 }
        r0 = r0.result;	 Catch:{ all -> 0x00a5 }
        r1 = -109; // 0xffffffffffffff93 float:NaN double:NaN;
        if (r0 != r1) goto L_0x02b0;
    L_0x02a0:
        r0 = 5;
        r1 = com.tencent.mm.sdk.platformtools.ab.getContext();	 Catch:{ all -> 0x00a5 }
        r2 = com.tencent.mm.plugin.facedetect.a.h.luk;	 Catch:{ all -> 0x00a5 }
        r1 = r1.getString(r2);	 Catch:{ all -> 0x00a5 }
        r7.P(r0, r1);	 Catch:{ all -> 0x00a5 }
        goto L_0x010c;
    L_0x02b0:
        r0 = "MicroMsg.FaceCharacteristicsResult";
        r1 = "hy: not defined system error! %d";
        r2 = 1;
        r2 = new java.lang.Object[r2];	 Catch:{ all -> 0x00a5 }
        r3 = 0;
        r4 = r7.lvM;	 Catch:{ all -> 0x00a5 }
        r4 = r4.result;	 Catch:{ all -> 0x00a5 }
        r4 = java.lang.Integer.valueOf(r4);	 Catch:{ all -> 0x00a5 }
        r2[r3] = r4;	 Catch:{ all -> 0x00a5 }
        com.tencent.mm.sdk.platformtools.w.e(r0, r1, r2);	 Catch:{ all -> 0x00a5 }
        r0 = 1;
        r1 = com.tencent.mm.sdk.platformtools.ab.getContext();	 Catch:{ all -> 0x00a5 }
        r2 = com.tencent.mm.plugin.facedetect.a.h.luq;	 Catch:{ all -> 0x00a5 }
        r1 = r1.getString(r2);	 Catch:{ all -> 0x00a5 }
        r7.P(r0, r1);	 Catch:{ all -> 0x00a5 }
        goto L_0x010c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView.b(com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView, byte[]):void");
    }

    static /* synthetic */ void e(FaceDetectCameraView faceDetectCameraView) {
        if (faceDetectCameraView.lBy && faceDetectCameraView.lBr > 0) {
            w.i("MicroMsg.FaceDetectCameraView", "hy: already request scanning face and now automatically capture");
            af.v(new Runnable(faceDetectCameraView) {
                final /* synthetic */ FaceDetectCameraView lBK;

                {
                    this.lBK = r1;
                }

                public final void run() {
                    this.lBK.a(this.lBK.lBC, this.lBK.lBr);
                    this.lBK.lBy = false;
                }
            });
        }
    }

    public FaceDetectCameraView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FaceDetectCameraView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lBo = null;
        this.lBp = null;
        this.lBr = FaceDetectView.lCq;
        this.lBs = -1;
        this.lvQ = -1;
        this.lBt = 1;
        this.lBu = false;
        this.lBv = false;
        this.lBw = false;
        this.lBx = new Object();
        this.lBy = false;
        this.lBz = false;
        this.jQt = false;
        this.lBA = new Object();
        this.lBB = new Object();
        this.lBC = null;
        this.width = 324;
        this.height = 576;
        this.lBD = null;
        this.lBE = false;
        this.lBG = null;
        this.lBH = null;
        this.lBI = false;
        this.lBJ = -1;
        this.lBq = (ActivityManager) getContext().getSystemService("activity");
        w.i("MicroMsg.FaceDetectCameraView", "hy: face vedio debug: %b", new Object[]{Boolean.valueOf(this.lBE)});
        this.lBG = new c(this);
        lBF = new a(this);
        setOpaque(false);
        setSurfaceTextureListener(this);
    }

    public final void a(c cVar) {
        this.lBG.a(cVar);
        this.lvQ = -1;
    }

    public final synchronized void a(Rect rect, long j) {
        asF();
        this.lBC = rect;
        asH();
        this.lBG.bO(j);
    }

    private static void asF() {
        w.i("MicroMsg.FaceDetectCameraView", "hy: request clear queue");
        f.arD();
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        w.i("MicroMsg.FaceDetectCameraView", "hy: onSurfaceTextureAvailable");
        bSB();
        this.lBu = true;
        this.lBp = surfaceTexture;
        if (this.lBz) {
            a(this.lBD);
        }
    }

    public final void asG() {
        this.jQt = false;
        this.lBG.asK();
        asF();
        int arI = f.lvS.arI();
        w.i("MicroMsg.FaceDetectCameraView", "alvinluo pause motion time: %d", new Object[]{Long.valueOf(System.currentTimeMillis())});
        FaceDetectReporter.arN().q(arI, r2);
    }

    private synchronized void asH() {
        w.i("MicroMsg.FaceDetectCameraView", "alvinluo capture face");
        f.lvS.arH();
        g gVar = f.lvS.lvT.lxY;
        if (gVar.lvW == null) {
            w.e("MicroMsg.FaceDetectNativeManager", "hy: init motion no instance");
        } else {
            w.i("MicroMsg.FaceDetectNativeManager", "hy: start init motion");
            gVar.lvW.engineGetCurrMotion();
        }
        int arI = f.lvS.arI();
        w.i("MicroMsg.FaceDetectCameraView", "alvinluo start motion time: %d", new Object[]{Long.valueOf(System.currentTimeMillis())});
        FaceDetectReporter.arN().p(arI, r2);
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        w.i("MicroMsg.FaceDetectCameraView", "hy: onSurfaceTextureSizeChanged");
        this.lBp = surfaceTexture;
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        w.i("MicroMsg.FaceDetectCameraView", "hy: onSurfaceTextureDestroyed");
        this.lBu = false;
        return false;
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        w.i("MicroMsg.FaceDetectCameraView", "hy: attached");
    }

    final synchronized FaceResult asI() {
        f.arD();
        int arH = f.lvS.arH();
        w.i("MicroMsg.FaceDetectCameraView", "hy: motionResult: %d, finalResult: %d", new Object[]{Integer.valueOf(arH), Integer.valueOf(f.lvS.lvT.lxY.arK().result)});
        return f.lvS.lvT.lxY.arK();
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.width = getMeasuredWidth();
        this.height = getMeasuredHeight();
        w.i("MicroMsg.FaceDetectCameraView", "hy: camera view on measure to %d, %d", new Object[]{Integer.valueOf(this.width), Integer.valueOf(this.height)});
    }
}
