package com.tencent.mm.plugin.facedetect.e;

import com.tencent.mm.plugin.facedetect.model.o;
import com.tencent.mm.plugin.mmsight.model.a.d;
import com.tencent.mm.plugin.mmsight.model.a.j;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.File;

public class a {
    static final String lAN = (o.arS() + File.separator + "fdv_");
    public static final String lAO = (o.arS() + File.separator + "video_temp_test.mp4");
    static final String lAP = (o.arS() + File.separator + "fdv_t_");
    private static volatile a lAy = null;
    public d ivE;
    private final int lAA;
    private final int lAB;
    private final int lAC;
    public int lAD;
    public int lAE;
    public boolean lAF;
    public int lAG;
    public boolean lAH;
    public b lAI;
    public int lAJ;
    public int lAK;
    public String lAL;
    public com.tencent.mm.plugin.mmsight.a.a lAM;
    public com.tencent.mm.plugin.mmsight.model.a.d.a lAQ;
    public com.tencent.mm.plugin.facedetect.model.d.b lAR;
    public af lAz;
    public com.tencent.mm.remoteservice.d lvq;
    public String mFilePath;
    public final Object mLock;

    class AnonymousClass1 implements Runnable {
        final /* synthetic */ int lAS;
        final /* synthetic */ int lAT;
        final /* synthetic */ int lAU;
        final /* synthetic */ boolean lAV = false;
        final /* synthetic */ int lAW = 0;
        final /* synthetic */ int lAX;
        final /* synthetic */ int lAY;
        final /* synthetic */ a lAZ;

        public AnonymousClass1(a aVar, int i, int i2, int i3, boolean z, int i4, int i5, int i6) {
            this.lAZ = aVar;
            this.lAS = i;
            this.lAT = i2;
            this.lAU = i3;
            this.lAX = i5;
            this.lAY = i6;
        }

        public final void run() {
            if (this.lAS == 90 || this.lAS == 270) {
                w.i("MicroMsg.FaceVideoRecorder", "hy: need make width and height upside down");
                this.lAZ.lAJ = this.lAT;
                this.lAZ.lAK = this.lAU;
            } else {
                this.lAZ.lAJ = this.lAU;
                this.lAZ.lAK = this.lAT;
            }
            this.lAZ.lAE = this.lAS;
            this.lAZ.lAF = this.lAV;
            this.lAZ.lAG = this.lAW;
            this.lAZ.mFilePath = a.lAN + bg.NA() + ".mp4";
            this.lAZ.lAL = a.lAP + bg.NA() + ".thumb";
            this.lAZ.asB();
            af.v(new Runnable(this) {
                final /* synthetic */ AnonymousClass1 lBa;

                {
                    this.lBa = r1;
                }

                public final void run() {
                    final long NA = bg.NA();
                    this.lBa.lAZ.lvq.G(new Runnable(this) {
                        final /* synthetic */ AnonymousClass1 lBc;

                        public final void run() {
                            synchronized (this.lBc.lBa.lAZ.mLock) {
                                w.i("MicroMsg.FaceVideoRecorder", "hy: connect cost %s ms", new Object[]{Long.valueOf(bg.aB(NA))});
                                long NA = bg.NA();
                                this.lBc.lBa.lAZ.ivE = this.lBc.lBa.lAZ.lAM.Pk();
                                this.lBc.lBa.lAZ.ivE.setFilePath(this.lBc.lBa.lAZ.mFilePath);
                                this.lBc.lBa.lAZ.ivE.AQ(this.lBc.lBa.lAZ.lAL);
                                this.lBc.lBa.lAZ.ivE.aLm();
                                this.lBc.lBa.lAZ.ivE.j(this.lBc.lBa.lAZ.lAJ, this.lBc.lBa.lAZ.lAK, this.lBc.lBa.lAX, this.lBc.lBa.lAY);
                                this.lBc.lBa.lAZ.ivE.pE(this.lBc.lBa.lAZ.lAE);
                                this.lBc.lBa.lAZ.ivE.a(this.lBc.lBa.lAZ.lAQ);
                                this.lBc.lBa.lAZ.lAD = a.lBi;
                                w.i("MicroMsg.FaceVideoRecorder", "hy: init in main thread cost %d ms", new Object[]{Long.valueOf(bg.aB(NA))});
                            }
                        }
                    });
                }
            });
        }
    }

    public enum a {
        ;

        static {
            lBh = 1;
            lBi = 2;
            lBj = 3;
            lBk = 4;
            lBl = 5;
            lBm = 6;
            lBn = new int[]{lBh, lBi, lBj, lBk, lBl, lBm};
        }
    }

    public interface b {
        void vK(String str);
    }

    private a() {
        this.mLock = new Object();
        this.lAz = null;
        this.lAA = 960;
        this.lAB = 540;
        this.lAC = 15;
        this.lAD = a.lBh;
        this.lAE = 0;
        this.lAF = false;
        this.lAG = 0;
        this.lAH = false;
        this.lAI = null;
        this.lAJ = -1;
        this.lAK = -1;
        this.mFilePath = "";
        this.lAL = "";
        this.lvq = new com.tencent.mm.remoteservice.d(ab.getContext());
        this.lAM = com.tencent.mm.plugin.mmsight.a.a.nAQ.Pl();
        this.lAQ = new com.tencent.mm.plugin.mmsight.model.a.d.a(this) {
            final /* synthetic */ a lAZ;

            class AnonymousClass1 implements Runnable {
                final /* synthetic */ int jSo = 1;
                final /* synthetic */ AnonymousClass5 lBf;

                AnonymousClass1(AnonymousClass5 anonymousClass5, int i) {
                    this.lBf = anonymousClass5;
                }

                /* JADX WARNING: inconsistent code. */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void run() {
                    /*
                    r5 = this;
                    r0 = r5.lBf;	 Catch:{ Exception -> 0x002d }
                    r0 = r0.lAZ;	 Catch:{ Exception -> 0x002d }
                    r0 = r0.ivE;	 Catch:{ Exception -> 0x002d }
                    if (r0 == 0) goto L_0x0011;
                L_0x0008:
                    r0 = r5.lBf;	 Catch:{ Exception -> 0x002d }
                    r0 = r0.lAZ;	 Catch:{ Exception -> 0x002d }
                    r0 = r0.ivE;	 Catch:{ Exception -> 0x002d }
                    r0.reset();	 Catch:{ Exception -> 0x002d }
                L_0x0011:
                    r0 = r5.lBf;
                    r0 = r0.lAZ;
                    r0.asB();
                L_0x0018:
                    r0 = r5.lBf;
                    r0 = r0.lAZ;
                    r1 = com.tencent.mm.plugin.facedetect.e.a.a.lBi;
                    r0.lAD = r1;
                    r0 = com.tencent.mm.plugin.facedetect.model.FaceContextData.arw();
                    r0 = r0.lvO;
                    r2 = 2;
                    r3 = r5.jSo;
                    com.tencent.mm.plugin.facedetect.model.FaceDetectReporter.d(r0, r2, r3);
                    return;
                L_0x002d:
                    r0 = move-exception;
                    r1 = "MicroMsg.FaceVideoRecorder";
                    r2 = "hy: onError, reset mediaRecorder error: %s";
                    r3 = 1;
                    r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x0049 }
                    r4 = 0;
                    r0 = r0.getMessage();	 Catch:{ all -> 0x0049 }
                    r3[r4] = r0;	 Catch:{ all -> 0x0049 }
                    com.tencent.mm.sdk.platformtools.w.e(r1, r2, r3);	 Catch:{ all -> 0x0049 }
                    r0 = r5.lBf;
                    r0 = r0.lAZ;
                    r0.asB();
                    goto L_0x0018;
                L_0x0049:
                    r0 = move-exception;
                    r1 = r5.lBf;
                    r1 = r1.lAZ;
                    r1.asB();
                    throw r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.facedetect.e.a.5.1.run():void");
                }
            }

            {
                this.lAZ = r1;
            }

            public final void asE() {
                w.e("MicroMsg.FaceVideoRecorder", "hy: video capture error: %d", new Object[]{Integer.valueOf(1)});
                this.lAZ.lAz.D(new AnonymousClass1(this, 1));
            }
        };
        this.lAR = new com.tencent.mm.plugin.facedetect.model.d.b(this) {
            final /* synthetic */ a lAZ;

            {
                this.lAZ = r1;
            }

            public final void an(final byte[] bArr) {
                w.v("MicroMsg.FaceVideoRecorder", "hy: on video data come");
                this.lAZ.lAz.D(new Runnable(this) {
                    final /* synthetic */ AnonymousClass6 lBg;

                    public final void run() {
                        SightVideoJNI.mirrorCameraData(bArr, this.lBg.lAZ.lAJ, this.lBg.lAZ.lAK, false);
                        if (this.lBg.lAZ.ivE.aLg() != null) {
                            this.lBg.lAZ.ivE.aLg().ax(bArr);
                        }
                    }
                });
            }

            public final com.tencent.mm.memory.a<byte[]> arv() {
                return j.nEA;
            }
        };
        this.lAz = new af("face_video_handler");
    }

    public static a asA() {
        if (lAy != null) {
            return lAy;
        }
        a aVar;
        synchronized (a.class) {
            if (lAy == null) {
                lAy = new a();
            }
            aVar = lAy;
        }
        return aVar;
    }

    public final boolean isStarted() {
        return this.lAD == a.lBj;
    }

    public final void asB() {
        com.tencent.mm.loader.stub.b.deleteFile(this.mFilePath);
        com.tencent.mm.loader.stub.b.deleteFile(this.lAL);
    }

    public final com.tencent.mm.c.b.c.a asC() {
        if (this.ivE != null) {
            return this.ivE.aLn();
        }
        w.w("MicroMsg.FaceVideoRecorder", "hy: no media recorder");
        return null;
    }

    public final void asD() {
        this.lAz.D(new Runnable(this) {
            final /* synthetic */ a lAZ;

            {
                this.lAZ = r1;
            }

            public final void run() {
                synchronized (this.lAZ.mLock) {
                    if (this.lAZ.lAD == a.lBh) {
                        w.e("MicroMsg.FaceVideoRecorder", "hy: not started when cancel. should not happen");
                        this.lAZ.asB();
                        return;
                    }
                    w.i("MicroMsg.FaceVideoRecorder", "hy: cancel record");
                    this.lAZ.ivE.cancel();
                    this.lAZ.asB();
                    com.tencent.mm.plugin.facedetect.model.d.aru().b(this.lAZ.lAR);
                    this.lAZ.lAD = a.lBm;
                    this.lAZ.lvq.release();
                }
            }
        });
    }

    public final void a(final b bVar) {
        this.lAz.D(new Runnable(this) {
            final /* synthetic */ a lAZ;

            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                /*
                r3 = this;
                r0 = r3.lAZ;
                r1 = r0.mLock;
                monitor-enter(r1);
                r0 = r3.lAZ;	 Catch:{ all -> 0x005f }
                r2 = r3;	 Catch:{ all -> 0x005f }
                r0.lAI = r2;	 Catch:{ all -> 0x005f }
                r0 = r3.lAZ;	 Catch:{ all -> 0x005f }
                r0 = r0.lAD;	 Catch:{ all -> 0x005f }
                r2 = com.tencent.mm.plugin.facedetect.e.a.a.lBh;	 Catch:{ all -> 0x005f }
                if (r0 != r2) goto L_0x0031;
            L_0x0013:
                r0 = "MicroMsg.FaceVideoRecorder";
                r2 = "hy: not initialized. should not happen";
                com.tencent.mm.sdk.platformtools.w.e(r0, r2);	 Catch:{ all -> 0x005f }
                r0 = r3.lAZ;	 Catch:{ all -> 0x005f }
                r0.asB();	 Catch:{ all -> 0x005f }
                r0 = r3.lAZ;	 Catch:{ all -> 0x005f }
                r0 = r0.lAI;	 Catch:{ all -> 0x005f }
                if (r0 == 0) goto L_0x002f;
            L_0x0027:
                r0 = r3.lAZ;	 Catch:{ all -> 0x005f }
                r0 = r0.lAI;	 Catch:{ all -> 0x005f }
                r2 = 0;
                r0.vK(r2);	 Catch:{ all -> 0x005f }
            L_0x002f:
                monitor-exit(r1);	 Catch:{ all -> 0x005f }
            L_0x0030:
                return;
            L_0x0031:
                r0 = r3.lAZ;	 Catch:{ all -> 0x005f }
                r0 = r0.lAD;	 Catch:{ all -> 0x005f }
                r2 = com.tencent.mm.plugin.facedetect.e.a.a.lBm;	 Catch:{ all -> 0x005f }
                if (r0 == r2) goto L_0x0041;
            L_0x0039:
                r0 = r3.lAZ;	 Catch:{ all -> 0x005f }
                r0 = r0.lAD;	 Catch:{ all -> 0x005f }
                r2 = com.tencent.mm.plugin.facedetect.e.a.a.lBi;	 Catch:{ all -> 0x005f }
                if (r0 != r2) goto L_0x0062;
            L_0x0041:
                r0 = "MicroMsg.FaceVideoRecorder";
                r2 = "hy: cancelled or not started capturing.";
                com.tencent.mm.sdk.platformtools.w.w(r0, r2);	 Catch:{ all -> 0x005f }
                r0 = r3.lAZ;	 Catch:{ all -> 0x005f }
                r0.asB();	 Catch:{ all -> 0x005f }
                r0 = r3.lAZ;	 Catch:{ all -> 0x005f }
                r0 = r0.lAI;	 Catch:{ all -> 0x005f }
                if (r0 == 0) goto L_0x005d;
            L_0x0055:
                r0 = r3.lAZ;	 Catch:{ all -> 0x005f }
                r0 = r0.lAI;	 Catch:{ all -> 0x005f }
                r2 = 0;
                r0.vK(r2);	 Catch:{ all -> 0x005f }
            L_0x005d:
                monitor-exit(r1);	 Catch:{ all -> 0x005f }
                goto L_0x0030;
            L_0x005f:
                r0 = move-exception;
                monitor-exit(r1);	 Catch:{ all -> 0x005f }
                throw r0;
            L_0x0062:
                r0 = r3.lAZ;	 Catch:{ all -> 0x005f }
                r0 = r0.lAD;	 Catch:{ all -> 0x005f }
                r2 = com.tencent.mm.plugin.facedetect.e.a.a.lBl;	 Catch:{ all -> 0x005f }
                if (r0 != r2) goto L_0x008a;
            L_0x006a:
                r0 = "MicroMsg.FaceVideoRecorder";
                r2 = "hy: already stopped";
                com.tencent.mm.sdk.platformtools.w.i(r0, r2);	 Catch:{ all -> 0x005f }
                r0 = r3.lAZ;	 Catch:{ all -> 0x005f }
                r0 = r0.lAI;	 Catch:{ all -> 0x005f }
                if (r0 == 0) goto L_0x0088;
            L_0x0079:
                r0 = r3.lAZ;	 Catch:{ all -> 0x005f }
                r0 = r0.lAI;	 Catch:{ all -> 0x005f }
                r2 = r3.lAZ;	 Catch:{ all -> 0x005f }
                r2 = r2.ivE;	 Catch:{ all -> 0x005f }
                r2 = r2.getFilePath();	 Catch:{ all -> 0x005f }
                r0.vK(r2);	 Catch:{ all -> 0x005f }
            L_0x0088:
                monitor-exit(r1);	 Catch:{ all -> 0x005f }
                goto L_0x0030;
            L_0x008a:
                r0 = r3.lAZ;	 Catch:{ all -> 0x005f }
                r0 = r0.lAD;	 Catch:{ all -> 0x005f }
                r2 = com.tencent.mm.plugin.facedetect.e.a.a.lBk;	 Catch:{ all -> 0x005f }
                if (r0 != r2) goto L_0x009d;
            L_0x0092:
                r0 = "MicroMsg.FaceVideoRecorder";
                r2 = "hy: stopping. wait";
                com.tencent.mm.sdk.platformtools.w.i(r0, r2);	 Catch:{ all -> 0x005f }
                monitor-exit(r1);	 Catch:{ all -> 0x005f }
                goto L_0x0030;
            L_0x009d:
                r0 = "MicroMsg.FaceVideoRecorder";
                r2 = "hy: stop record and release";
                com.tencent.mm.sdk.platformtools.w.i(r0, r2);	 Catch:{ all -> 0x005f }
                r0 = com.tencent.mm.plugin.facedetect.model.d.aru();	 Catch:{ all -> 0x005f }
                r2 = r3.lAZ;	 Catch:{ all -> 0x005f }
                r2 = r2.lAR;	 Catch:{ all -> 0x005f }
                r0.b(r2);	 Catch:{ all -> 0x005f }
                r0 = r3.lAZ;	 Catch:{ all -> 0x005f }
                r2 = com.tencent.mm.plugin.facedetect.e.a.a.lBk;	 Catch:{ all -> 0x005f }
                r0.lAD = r2;	 Catch:{ all -> 0x005f }
                r0 = r3.lAZ;	 Catch:{ all -> 0x005f }
                r0 = r0.ivE;	 Catch:{ all -> 0x005f }
                r2 = new com.tencent.mm.plugin.facedetect.e.a$4$1;	 Catch:{ all -> 0x005f }
                r2.<init>(r3);	 Catch:{ all -> 0x005f }
                r0.A(r2);	 Catch:{ all -> 0x005f }
                monitor-exit(r1);	 Catch:{ all -> 0x005f }
                goto L_0x0030;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.facedetect.e.a.4.run():void");
            }
        });
    }
}
