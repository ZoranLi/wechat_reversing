package com.tencent.mm.plugin.shake.d.a;

import com.tencent.mm.c.b.c;
import com.tencent.mm.protocal.c.avp;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.qafpapi.QAFPNative;

public final class a implements e {
    private com.tencent.mm.c.b.c.a fAv = new com.tencent.mm.c.b.c.a(this) {
        final /* synthetic */ a pqd;

        {
            this.pqd = r1;
        }

        public final void d(byte[] bArr, int i) {
            int QAFPProcessTV;
            com.tencent.mm.compatible.util.g.a aVar = new com.tencent.mm.compatible.util.g.a();
            synchronized (this.pqd.ppU) {
                if (this.pqd.ppR == 408) {
                    w.v("MicroMsg.MusicFingerPrintRecorder", "shake tv branch, QAFPProcessTV");
                    QAFPProcessTV = QAFPNative.QAFPProcessTV(bArr, i);
                } else {
                    QAFPProcessTV = QAFPNative.QAFPProcess(bArr, i);
                }
            }
            long Nz = bg.Nz() - this.pqd.pqb;
            w.d("MicroMsg.MusicFingerPrintRecorder", "QAFPProcess clientid:%d pcm:%d ret:%d dur:%d usetime:%d", new Object[]{Integer.valueOf(this.pqd.ppY), Integer.valueOf(i), Integer.valueOf(QAFPProcessTV), Long.valueOf(Nz), Long.valueOf(aVar.se())});
            if (Nz > ((long) ((this.pqd.pqc * 3000) + 4000))) {
                Object obj = new byte[10240];
                com.tencent.mm.compatible.util.g.a aVar2 = new com.tencent.mm.compatible.util.g.a();
                if (this.pqd.ppR == 408) {
                    w.v("MicroMsg.MusicFingerPrintRecorder", "shake tv branch, QAFPGetAudioFingerPrintTV");
                    QAFPProcessTV = QAFPNative.QAFPGetAudioFingerPrintTV(obj);
                } else {
                    QAFPProcessTV = QAFPNative.QAFPGetAudioFingerPrint(obj);
                }
                w.d("MicroMsg.MusicFingerPrintRecorder", "QAFPGetAudioFingerPrint clientid:%d outLen:%d time:%d", new Object[]{Integer.valueOf(this.pqd.ppY), Integer.valueOf(QAFPProcessTV), Long.valueOf(aVar2.se())});
                if (QAFPProcessTV >= 10240 || QAFPProcessTV <= 0) {
                    w.e("MicroMsg.MusicFingerPrintRecorder", "QAFPGetAudioFingerPrint clientid:%d  out ret:%d  !stop record now", new Object[]{Integer.valueOf(this.pqd.ppY), Integer.valueOf(QAFPProcessTV)});
                    this.pqd.reset();
                    return;
                }
                synchronized (this.pqd.ppN) {
                    System.arraycopy(obj, 0, this.pqd.ppN, 0, QAFPProcessTV);
                    this.pqd.ppO = QAFPProcessTV;
                    this.pqd.ppX = this.pqd.pqc >= 3;
                    this.pqd.ppP = (int) (Nz / 1000);
                }
                this.pqd.pq();
                a aVar3 = this.pqd;
                aVar3.pqc++;
            }
            if (this.pqd.ppX) {
                w.w("MicroMsg.MusicFingerPrintRecorder", "client:%d stop now! duration:%d  ", new Object[]{Integer.valueOf(this.pqd.ppY), Long.valueOf(Nz)});
                this.pqd.reset();
            }
        }

        public final void ax(int i, int i2) {
        }
    };
    public c fzv;
    public byte[] ppN = new byte[10240];
    public int ppO = 0;
    public int ppP = 0;
    public long ppQ = 0;
    public int ppR = 0;
    public boolean ppS = false;
    public e ppT = null;
    public Object ppU = new Object();
    public a ppV = null;
    public boolean ppW = false;
    public boolean ppX = false;
    public int ppY = 0;
    public int ppZ;
    private boolean pqa = false;
    public long pqb;
    public int pqc;

    class AnonymousClass2 implements Runnable {
        final /* synthetic */ a pqd;
        final /* synthetic */ boolean pqe = false;
        final /* synthetic */ boolean pqf;

        AnonymousClass2(a aVar, boolean z, boolean z2) {
            this.pqd = aVar;
            this.pqf = z2;
        }

        public final void run() {
            if (this.pqe) {
                this.pqd.ppV.a(null, -1, this.pqf);
            } else if (!this.pqd.ppS) {
                w.w("MicroMsg.MusicFingerPrintRecorder", "tryCallBack netscen not return.");
            } else if (this.pqd.fzv != null) {
                w.w("MicroMsg.MusicFingerPrintRecorder", "tryCallBack device not ready!");
            } else if (this.pqd.ppT != null) {
                a aVar = this.pqd.ppV;
                avp bbu = this.pqd.ppT.bbu();
                e eVar = this.pqd.ppT;
                long Nz = bg.Nz();
                if (eVar.pqj > 0 && eVar.pqj < Nz) {
                    Nz = eVar.pqj;
                }
                aVar.a(bbu, Nz, this.pqf);
            } else {
                this.pqd.ppV.a(null, -1, this.pqf);
            }
        }
    }

    public interface a {
        void a(avp com_tencent_mm_protocal_c_avp, long j, boolean z);
    }

    public final boolean bbr() {
        boolean z = false;
        synchronized (this.ppU) {
            if (this.pqa) {
                w.d("MicroMsg.MusicFingerPrintRecorder", "QAFPInit already inited");
            } else {
                int QAFPInit = QAFPNative.QAFPInit();
                w.d("MicroMsg.MusicFingerPrintRecorder", "QAFPInit ret:%d", new Object[]{Integer.valueOf(QAFPInit)});
                if (QAFPInit >= 0) {
                    this.pqa = true;
                }
                if (QAFPInit >= 0) {
                    z = true;
                }
            }
        }
        return z;
    }

    public final boolean bbs() {
        boolean z = false;
        synchronized (this.ppU) {
            if (this.pqa) {
                w.d("MicroMsg.MusicFingerPrintRecorder", "QAFPRelease ret:%d", new Object[]{Integer.valueOf(QAFPNative.QAFPRelease())});
                if (QAFPNative.QAFPRelease() >= 0) {
                    z = true;
                }
            } else {
                w.d("MicroMsg.MusicFingerPrintRecorder", "QAFPRelease never inited");
            }
        }
        return z;
    }

    public final boolean oX() {
        w.d("MicroMsg.MusicFingerPrintRecorder", "stopRecord now clientid:%d", new Object[]{Integer.valueOf(this.ppY)});
        ap.vd().b(367, this);
        ap.vd().b(408, this);
        synchronized (this.ppN) {
            this.ppO = 0;
        }
        if (this.fzv != null) {
            this.fzv.oX();
            this.fzv = null;
        }
        return true;
    }

    public final boolean a(int i, a aVar) {
        oX();
        synchronized (this.ppU) {
            this.ppZ = QAFPNative.QAFPGetVersion();
        }
        bbr();
        this.ppR = i;
        this.ppV = aVar;
        this.ppX = false;
        this.ppW = false;
        this.ppS = false;
        ap.vd().a(367, this);
        ap.vd().a(408, this);
        this.ppY = (int) bg.Nz();
        w.d("MicroMsg.MusicFingerPrintRecorder", "startRecord now clientid:%d", new Object[]{Integer.valueOf(this.ppY)});
        this.fzv = new c(8000, 4);
        this.fzv.fzT = -19;
        this.fzv.fAe = this.fAv;
        if (this.fzv.pf()) {
            synchronized (this.ppU) {
                w.d("MicroMsg.MusicFingerPrintRecorder", "QAFPReset ret:%d", new Object[]{Integer.valueOf(QAFPNative.QAFPReset())});
                if (QAFPNative.QAFPReset() < 0) {
                    w.e("MicroMsg.MusicFingerPrintRecorder", "init failed QAFPReset:%d clientid:%d", new Object[]{Integer.valueOf(r3), Integer.valueOf(this.ppY)});
                    reset();
                    return false;
                }
                this.ppQ = bg.Nz();
                this.pqb = bg.Nz();
                this.pqc = 0;
                return true;
            }
        }
        w.e("MicroMsg.MusicFingerPrintRecorder", "start record failed");
        reset();
        return false;
    }

    public final void reset() {
        w.d("MicroMsg.MusicFingerPrintRecorder", "reset recorder clientid:%d", new Object[]{Integer.valueOf(this.ppY)});
        if (this.fzv != null) {
            this.fzv.oX();
            this.fzv = null;
        }
        gS(false);
    }

    private void gS(boolean z) {
        w.d("MicroMsg.MusicFingerPrintRecorder", "tryCallBack, directFail = %s", new Object[]{Boolean.valueOf(false)});
        af.v(new AnonymousClass2(this, false, z));
    }

    public final void pq() {
        ap.vL().D(new Runnable(this) {
            final /* synthetic */ a pqd;

            {
                this.pqd = r1;
            }

            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                /*
                r10 = this;
                r6 = 1;
                r9 = 0;
                r0 = r10.pqd;
                r0 = r0.ppW;
                if (r0 == 0) goto L_0x001e;
            L_0x0008:
                r0 = "MicroMsg.MusicFingerPrintRecorder";
                r1 = "tryStartNetscene clientid: %d but netscene is running.";
                r2 = new java.lang.Object[r6];
                r3 = r10.pqd;
                r3 = r3.ppY;
                r3 = java.lang.Integer.valueOf(r3);
                r2[r9] = r3;
                com.tencent.mm.sdk.platformtools.w.e(r0, r1, r2);
            L_0x001d:
                return;
            L_0x001e:
                r0 = r10.pqd;
                r1 = r0.ppN;
                monitor-enter(r1);
                r0 = r10.pqd;	 Catch:{ all -> 0x002b }
                r0 = r0.ppO;	 Catch:{ all -> 0x002b }
                if (r0 > 0) goto L_0x002e;
            L_0x0029:
                monitor-exit(r1);	 Catch:{ all -> 0x002b }
                goto L_0x001d;
            L_0x002b:
                r0 = move-exception;
                monitor-exit(r1);	 Catch:{ all -> 0x002b }
                throw r0;
            L_0x002e:
                r0 = r10.pqd;	 Catch:{ all -> 0x002b }
                r0 = r0.ppO;	 Catch:{ all -> 0x002b }
                r2 = new byte[r0];	 Catch:{ all -> 0x002b }
                r0 = r10.pqd;	 Catch:{ all -> 0x002b }
                r0 = r0.ppN;	 Catch:{ all -> 0x002b }
                r3 = 0;
                r4 = 0;
                r5 = r10.pqd;	 Catch:{ all -> 0x002b }
                r5 = r5.ppO;	 Catch:{ all -> 0x002b }
                java.lang.System.arraycopy(r0, r3, r2, r4, r5);	 Catch:{ all -> 0x002b }
                r0 = r10.pqd;	 Catch:{ all -> 0x002b }
                r3 = 0;
                r0.ppO = r3;	 Catch:{ all -> 0x002b }
                r0 = r10.pqd;	 Catch:{ all -> 0x002b }
                r4 = r0.ppQ;	 Catch:{ all -> 0x002b }
                monitor-exit(r1);	 Catch:{ all -> 0x002b }
                r0 = r10.pqd;
                r0.ppW = r6;
                r0 = r10.pqd;
                r0 = r0.ppR;
                r1 = r10.pqd;
                r3 = r1.ppP;
                r1 = r10.pqd;
                r6 = r1.ppY;
                r1 = r10.pqd;
                r7 = r1.ppX;
                r1 = r10.pqd;
                r8 = r1.ppZ;
                r1 = 367; // 0x16f float:5.14E-43 double:1.813E-321;
                if (r0 != r1) goto L_0x0074;
            L_0x0067:
                r1 = new com.tencent.mm.plugin.shake.d.a.f;
                r1.<init>(r2, r3, r4, r6, r7, r8);
            L_0x006c:
                r0 = com.tencent.mm.u.ap.vd();
                r0.a(r1, r9);
                goto L_0x001d;
            L_0x0074:
                r1 = 408; // 0x198 float:5.72E-43 double:2.016E-321;
                if (r0 != r1) goto L_0x007e;
            L_0x0078:
                r1 = new com.tencent.mm.plugin.shake.d.a.g;
                r1.<init>(r2, r3, r4, r6, r7, r8);
                goto L_0x006c;
            L_0x007e:
                r1 = 0;
                goto L_0x006c;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.shake.d.a.a.3.run():void");
            }

            public final String toString() {
                return super.toString() + "|tryStartNetscene";
            }
        });
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() == 367 || kVar.getType() == 408) {
            w.d("MicroMsg.MusicFingerPrintRecorder", "onSceneEnd errType = %s, errCode = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            this.ppW = false;
            if (((e) kVar).bbt()) {
                w.d("MicroMsg.MusicFingerPrintRecorder", "NetSceneShakeMedia isRecogSuccess stop now ! clientid:%d", new Object[]{Integer.valueOf(this.ppY)});
                oX();
                this.ppT = (e) kVar;
                this.ppS = true;
                gS(false);
            } else if (this.ppO == 0 && this.ppX) {
                w.d("MicroMsg.MusicFingerPrintRecorder", "recog failed . clientid:%d", new Object[]{Integer.valueOf(this.ppY)});
                this.ppT = null;
                this.ppS = true;
                if (i == 0 && i2 == 0) {
                    gS(false);
                } else {
                    gS(true);
                }
                ap.vd().b(367, this);
                ap.vd().b(408, this);
            } else {
                w.d("MicroMsg.MusicFingerPrintRecorder", "NetScene try again clientId:%d", new Object[]{Integer.valueOf(this.ppY)});
                pq();
            }
        }
    }
}
