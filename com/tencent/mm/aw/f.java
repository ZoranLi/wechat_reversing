package com.tencent.mm.aw;

import com.tencent.mm.c.b.c;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.jsapi.map.m;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.storage.w;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.File;
import java.util.Set;

public final class f implements e {
    public static int fBC = Downloads.MIN_RETYR_AFTER;
    public static final String icS = (w.hgq + "voice_temp.silk");
    public com.tencent.mm.c.b.c.a fAe = new com.tencent.mm.c.b.c.a(this) {
        short[] idi;
        final /* synthetic */ f idj;

        {
            this.idj = r1;
        }

        public final void d(byte[] bArr, int i) {
            int i2;
            com.tencent.mm.sdk.platformtools.w.d("MicroMsg.SceneVoiceInputAddr", "OnRecPcmDataReady len: %s time: %s", Integer.valueOf(i), Long.valueOf(System.currentTimeMillis()));
            if (this.idi == null || this.idi.length < i / 2) {
                this.idi = new short[(i / 2)];
            }
            for (i2 = 0; i2 < i / 2; i2++) {
                this.idi[i2] = (short) ((bArr[i2 * 2] & 255) | (bArr[(i2 * 2) + 1] << 8));
            }
            f fVar = this.idj;
            short[] sArr = this.idi;
            int i3 = i / 2;
            for (i2 = 0; i2 < i3; i2++) {
                short s = sArr[i2];
                if (s > fVar.icU) {
                    fVar.icU = s;
                }
            }
            com.tencent.mm.sdk.platformtools.w.d("MicroMsg.SceneVoiceInputAddr", "setCurAmplitude mMaxAmpSinceLastCall = %s", Integer.valueOf(fVar.icU));
            if (this.idj.idg != null) {
                this.idj.idg.c(this.idi, i / 2);
                return;
            }
            this.idj.be(9, -1);
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.SceneVoiceInputAddr", "mVoiceSilentDetectAPI is null");
        }

        public final void ax(int i, int i2) {
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.SceneVoiceInputAddr", "onRecError state = %s detailState = %s", Integer.valueOf(i), Integer.valueOf(i2));
            this.idj.be(10, -1);
        }
    };
    public c fzv;
    public int icU = 0;
    public int icV = 0;
    public boolean icW = false;
    public com.tencent.mm.c.c.a ida;
    public a idc = null;
    public boolean ide = false;
    private b idf = null;
    public com.tencent.mm.aw.a.c idg;
    public com.tencent.mm.aw.a.c.a idh = new com.tencent.mm.aw.a.c.a(this) {
        final /* synthetic */ f idj;
        byte[] idk;

        {
            this.idj = r1;
        }

        public final void a(short[] sArr, int i) {
            if (sArr != null) {
                int i2;
                if (this.idk == null || this.idk.length < i * 2) {
                    this.idk = new byte[(i * 2)];
                }
                for (i2 = 0; i2 < i; i2++) {
                    this.idk[i2 * 2] = (byte) (sArr[i2] & 255);
                    this.idk[(i2 * 2) + 1] = (byte) ((sArr[i2] & 65280) >> 8);
                }
                if (this.idj.ida != null) {
                    i2 = this.idj.ida.a(new com.tencent.mm.c.b.g.a(this.idk, i * 2), 0, true);
                } else {
                    i2 = -1;
                }
                if (-1 == i2) {
                    this.idj.be(4, -1);
                    com.tencent.mm.sdk.platformtools.w.e("MicroMsg.SceneVoiceInputAddr", "write to file failed");
                    return;
                }
                this.idj.icV = i2 + this.idj.icV;
                if (!this.idj.ide && this.idj.icV > m.CTRL_INDEX && !this.idj.icW) {
                    h.vL().D(new Runnable(this) {
                        final /* synthetic */ AnonymousClass2 idl;

                        {
                            this.idl = r1;
                        }

                        public final void run() {
                            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.SceneVoiceInputAddr", "run NetSceneNewVoiceInput mWroteBytesCnt %s time %s", Integer.valueOf(this.idl.idj.icV), Long.valueOf(System.currentTimeMillis()));
                            if (this.idl.idj.ide || this.idl.idj.idc == null || this.idl.idj.icV == 0) {
                                com.tencent.mm.sdk.platformtools.w.w("MicroMsg.SceneVoiceInputAddr", "WorkerThread too busy can not do work");
                                return;
                            }
                            h.vd().a(235, this.idl.idj);
                            if (!((b) this.idl.idj.idc).LK() || !h.vd().a(this.idl.idj.idc, 0)) {
                                this.idl.idj.be(13, 131);
                            }
                        }
                    });
                    this.idj.icW = true;
                }
            }
        }

        public final void LR() {
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.SceneVoiceInputAddr", "onSpeakToSilent");
            if (this.idj.idc instanceof b) {
                try {
                    ((b) this.idj.idc).gS(com.tencent.mm.a.e.aN(f.LQ()));
                } catch (Throwable e) {
                    com.tencent.mm.sdk.platformtools.w.printErrStackTrace("MicroMsg.SceneVoiceInputAddr", e, "cutShortSentence error", new Object[0]);
                    this.idj.be(6, -1);
                }
            }
        }

        public final void LS() {
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.SceneVoiceInputAddr", "onSilentToSpeak");
            if (this.idj.idc instanceof b) {
                try {
                    g gVar = ((b) this.idj.idc).icB;
                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.ShortSentenceContainer", "createNewShortSentence");
                    gVar.ido.writeLock().lock();
                    com.tencent.mm.aw.g.a aVar = new com.tencent.mm.aw.g.a(gVar);
                    gVar.idn.put(aVar.idq, aVar);
                    gVar.ido.writeLock().unlock();
                    if (!this.idj.ida.pt()) {
                        this.idj.be(5, -1);
                    }
                } catch (Throwable e) {
                    com.tencent.mm.sdk.platformtools.w.printErrStackTrace("MicroMsg.SceneVoiceInputAddr", e, "createShortSentence error", new Object[0]);
                    this.idj.be(6, -1);
                }
            }
        }

        public final void LT() {
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.SceneVoiceInputAddr", "Silent enough to finish time %s", Long.valueOf(System.currentTimeMillis()));
            this.idj.ap(false);
        }
    };

    private class a implements Runnable {
        final /* synthetic */ f idj;

        public a(f fVar) {
            this.idj = fVar;
        }

        public final void run() {
            synchronized (this.idj) {
                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.SceneVoiceInputAddr", "initDeviceInLock time %s", Long.valueOf(System.currentTimeMillis()));
                long nanoTime = System.nanoTime() & 4294967295L;
                if (nanoTime < 0) {
                    nanoTime = Math.abs(nanoTime);
                }
                String valueOf = String.valueOf(nanoTime);
                try {
                    File file = new File(f.icS);
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    file = new File(f.LQ());
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    file.delete();
                } catch (Throwable e) {
                    com.tencent.mm.sdk.platformtools.w.printErrStackTrace("MicroMsg.SceneVoiceInputAddr", e, "delete file failed", new Object[0]);
                }
                this.idj.fzv = new c(16000, 3);
                this.idj.fzv.fzT = -19;
                this.idj.fzv.as(false);
                this.idj.ida = new com.tencent.mm.c.c.c(16000, 23900);
                if (this.idj.ida.bz(f.LQ())) {
                    if (p.gRl.gPY > 0) {
                        this.idj.fzv.r(p.gRl.gPY, true);
                    } else {
                        this.idj.fzv.r(5, false);
                    }
                    this.idj.fzv.cY(50);
                    this.idj.fzv.at(false);
                    try {
                        this.idj.idg = new com.tencent.mm.aw.a.c();
                        this.idj.idg.idL = this.idj.idh;
                        com.tencent.mm.storage.c dX = com.tencent.mm.u.c.c.Az().dX("100235");
                        this.idj.idc = new b(f.LQ(), valueOf, String.valueOf(dX.isValid() ? bg.getInt((String) dX.bKK().get("MMVoipVadOn"), 0) : 0));
                        this.idj.fzv.fAe = this.idj.fAe;
                        if (!this.idj.fzv.pf()) {
                            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.SceneVoiceInputAddr", "start record failed");
                            this.idj.be(8, -1);
                        }
                    } catch (Throwable e2) {
                        com.tencent.mm.sdk.platformtools.w.printErrStackTrace("MicroMsg.SceneVoiceInputAddr", e2, "init VoiceDetectAPI failed", new Object[0]);
                        this.idj.be(7, -1);
                    }
                } else {
                    com.tencent.mm.sdk.platformtools.w.e("MicroMsg.SceneVoiceInputAddr", "init speex writer failed");
                    this.idj.ida.ps();
                    this.idj.ida = null;
                    this.idj.be(5, -1);
                }
            }
        }
    }

    public interface b {
        void LP();

        void LU();

        void a(String[] strArr, Set<String> set);

        void u(int i, int i2, int i3);
    }

    public f(b bVar) {
        this.idf = bVar;
    }

    public static String LQ() {
        return icS;
    }

    public final void a(int i, int i2, String str, k kVar) {
        String[] LH = ((a) kVar).LH();
        Set LJ = ((a) kVar).LJ();
        String str2 = "MicroMsg.SceneVoiceInputAddr";
        String str3 = "onSceneEnd time %s errType:%s errCode:%s list:%s scene.hashCode():%s,this.hashCode():%s";
        Object[] objArr = new Object[6];
        objArr[0] = Long.valueOf(System.currentTimeMillis());
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = Integer.valueOf(LH == null ? -1 : LH.length);
        objArr[4] = Integer.valueOf(kVar.hashCode());
        objArr[5] = Integer.valueOf(this.idc == null ? -1 : this.idc.hashCode());
        com.tencent.mm.sdk.platformtools.w.d(str2, str3, objArr);
        if (this.idc == null || kVar.hashCode() != this.idc.hashCode()) {
            com.tencent.mm.sdk.platformtools.w.d("MicroMsg.SceneVoiceInputAddr", "onSceneEnd scene.hashCode() != mVoiceRecogScene.hashCode()");
        } else if (this.idf == null) {
        } else {
            if (i2 == 0 && i == 0) {
                this.idf.a(LH, LJ);
                if ((kVar instanceof b) && this.icV == 0 && ((b) kVar).icB.LX()) {
                    this.idf.LU();
                    bx(false);
                    return;
                }
                return;
            }
            if (str != null && str.equalsIgnoreCase("SecurityCheckError")) {
                this.idf.u(13, 132, -1);
            } else if (str == null || !str.equalsIgnoreCase("ReadFileLengthError")) {
                this.idf.u(11, i, i2);
            } else {
                this.idf.u(13, com.tencent.mm.plugin.appbrand.jsapi.map.e.CTRL_INDEX, -1);
            }
            bx(false);
        }
    }

    public final void be(int i, int i2) {
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.SceneVoiceInputAddr", "error localCode = %s,errType = %s,errCode = %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(-1));
        if (this.idf != null) {
            this.idf.u(i, i2, -1);
        }
        d(false, true);
    }

    public final void ap(boolean z) {
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.SceneVoiceInputAddr", "stop fromUI = %s", Boolean.valueOf(z));
        if (!(z || this.idf == null)) {
            this.idf.LP();
        }
        d(true, true);
    }

    public final void bx(boolean z) {
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.SceneVoiceInputAddr", "cancel fromUI = %s", Boolean.valueOf(z));
        this.idf = null;
        d(false, z);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void d(boolean r7, boolean r8) {
        /*
        r6 = this;
        r5 = 1;
        r4 = 0;
        r0 = "MicroMsg.SceneVoiceInputAddr";
        r1 = "reset keepNetScene = %s,sendLastScene = %s";
        r2 = 2;
        r2 = new java.lang.Object[r2];
        r3 = java.lang.Boolean.valueOf(r7);
        r2[r4] = r3;
        r3 = java.lang.Boolean.valueOf(r8);
        r2[r5] = r3;
        com.tencent.mm.sdk.platformtools.w.i(r0, r1, r2);
        monitor-enter(r6);
        r0 = 1;
        r6.ide = r0;	 Catch:{ all -> 0x0077 }
        r0 = r6.fzv;	 Catch:{ all -> 0x0077 }
        if (r0 == 0) goto L_0x002a;
    L_0x0022:
        r0 = r6.fzv;	 Catch:{ all -> 0x0077 }
        r0.oX();	 Catch:{ all -> 0x0077 }
        r0 = 0;
        r6.fzv = r0;	 Catch:{ all -> 0x0077 }
    L_0x002a:
        r0 = r6.ida;	 Catch:{ all -> 0x0077 }
        if (r0 == 0) goto L_0x0036;
    L_0x002e:
        r0 = r6.ida;	 Catch:{ all -> 0x0077 }
        r0.ps();	 Catch:{ all -> 0x0077 }
        r0 = 0;
        r6.ida = r0;	 Catch:{ all -> 0x0077 }
    L_0x0036:
        r0 = r6.idg;	 Catch:{ all -> 0x0077 }
        if (r0 == 0) goto L_0x0042;
    L_0x003a:
        r0 = r6.idg;	 Catch:{ Exception -> 0x0069 }
        r0.release();	 Catch:{ Exception -> 0x0069 }
        r0 = 0;
        r6.idg = r0;	 Catch:{ Exception -> 0x0069 }
    L_0x0042:
        r0 = 0;
        r6.icV = r0;	 Catch:{ all -> 0x0077 }
        r0 = r6.idc;	 Catch:{ all -> 0x0077 }
        if (r0 == 0) goto L_0x0061;
    L_0x0049:
        r0 = r6.idc;	 Catch:{ all -> 0x0077 }
        r0 = r0 instanceof com.tencent.mm.aw.b;	 Catch:{ all -> 0x0077 }
        if (r0 == 0) goto L_0x0061;
    L_0x004f:
        r0 = r6.idc;	 Catch:{ all -> 0x0077 }
        r0.LG();	 Catch:{ all -> 0x0077 }
        r0 = icS;	 Catch:{ all -> 0x0077 }
        r1 = com.tencent.mm.a.e.aN(r0);	 Catch:{ all -> 0x0077 }
        r0 = r6.idc;	 Catch:{ Exception -> 0x007a }
        r0 = (com.tencent.mm.aw.b) r0;	 Catch:{ Exception -> 0x007a }
        r0.gS(r1);	 Catch:{ Exception -> 0x007a }
    L_0x0061:
        if (r7 != 0) goto L_0x0067;
    L_0x0063:
        r0 = r6.icW;	 Catch:{ all -> 0x0077 }
        if (r0 != 0) goto L_0x008d;
    L_0x0067:
        monitor-exit(r6);	 Catch:{ all -> 0x0077 }
    L_0x0068:
        return;
    L_0x0069:
        r0 = move-exception;
        r1 = "MicroMsg.SceneVoiceInputAddr";
        r2 = "mVoiceSilentDetectAPI.release error";
        r3 = 0;
        r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x0077 }
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r1, r0, r2, r3);	 Catch:{ all -> 0x0077 }
        goto L_0x0042;
    L_0x0077:
        r0 = move-exception;
        monitor-exit(r6);	 Catch:{ all -> 0x0077 }
        throw r0;
    L_0x007a:
        r0 = move-exception;
        r1 = "MicroMsg.SceneVoiceInputAddr";
        r2 = "reset cutShortSentence error";
        r3 = 0;
        r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x0077 }
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r1, r0, r2, r3);	 Catch:{ all -> 0x0077 }
        r0 = 6;
        r1 = -1;
        r6.be(r0, r1);	 Catch:{ all -> 0x0077 }
        goto L_0x0061;
    L_0x008d:
        r0 = r6.idc;	 Catch:{ all -> 0x0077 }
        if (r0 == 0) goto L_0x00bc;
    L_0x0091:
        r0 = r6.idc;	 Catch:{ all -> 0x0077 }
        r0 = r0 instanceof com.tencent.mm.aw.b;	 Catch:{ all -> 0x0077 }
        if (r0 == 0) goto L_0x00bc;
    L_0x0097:
        r0 = "MicroMsg.SceneVoiceInputAddr";
        r1 = "reset call stop() sendLastScene:%s";
        r2 = 1;
        r2 = new java.lang.Object[r2];	 Catch:{ all -> 0x0077 }
        r3 = 0;
        r4 = java.lang.Boolean.valueOf(r8);	 Catch:{ all -> 0x0077 }
        r2[r3] = r4;	 Catch:{ all -> 0x0077 }
        com.tencent.mm.sdk.platformtools.w.i(r0, r1, r2);	 Catch:{ all -> 0x0077 }
        if (r8 == 0) goto L_0x00b3;
    L_0x00ac:
        r0 = r6.idc;	 Catch:{ all -> 0x0077 }
        r0 = (com.tencent.mm.aw.b) r0;	 Catch:{ all -> 0x0077 }
        r0.LL();	 Catch:{ all -> 0x0077 }
    L_0x00b3:
        r0 = com.tencent.mm.kernel.h.vd();	 Catch:{ all -> 0x0077 }
        r1 = 235; // 0xeb float:3.3E-43 double:1.16E-321;
        r0.b(r1, r6);	 Catch:{ all -> 0x0077 }
    L_0x00bc:
        r0 = 0;
        r6.idc = r0;	 Catch:{ all -> 0x0077 }
        r0 = 0;
        r6.icW = r0;	 Catch:{ all -> 0x0077 }
        monitor-exit(r6);	 Catch:{ all -> 0x0077 }
        goto L_0x0068;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.aw.f.d(boolean, boolean):void");
    }
}
