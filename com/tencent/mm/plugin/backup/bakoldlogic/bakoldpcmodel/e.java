package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.e.a.ks;
import com.tencent.mm.e.b.aj;
import com.tencent.mm.plugin.backup.bakoldlogic.c.b;
import com.tencent.mm.plugin.backup.g.a;
import com.tencent.mm.plugin.backup.h.ab;
import com.tencent.mm.plugin.backup.h.ac;
import com.tencent.mm.plugin.backup.h.q;
import com.tencent.mm.plugin.backup.h.r;
import com.tencent.mm.plugin.backup.h.s;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.m;
import com.tencent.mm.x.n;
import com.tencent.mm.y.k;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.util.List;

public final class e implements com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.a.a, com.tencent.mm.plugin.backup.f.b.c {
    private String errStr = "";
    public com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.a jJZ;
    public d jLG;
    public c jLJ;
    public a jLK;
    public e jLL;
    public d jLM = new d();
    public f jLN = new f();
    public com.tencent.mm.plugin.backup.bakoldlogic.c.d jLO;
    public int jLP = -1;
    public String jLQ;
    public String jLR;
    public int jLS = com.tencent.mm.plugin.backup.bakoldlogic.a.c.jJh;
    public int jLT = com.tencent.mm.plugin.backup.bakoldlogic.a.c.jJa;
    private boolean jLU = false;

    class AnonymousClass3 implements com.tencent.mm.y.e {
        final /* synthetic */ e jLV;
        final /* synthetic */ Runnable jLY;
        final /* synthetic */ Runnable jLZ;

        AnonymousClass3(e eVar, Runnable runnable, Runnable runnable2) {
            this.jLV = eVar;
            this.jLY = runnable;
            this.jLZ = runnable2;
        }

        public final void a(int i, int i2, String str, k kVar) {
            if (kVar != this.jLV.jLO) {
                w.w("MicroMsg.BakPcProcessMgr", "last canceded scene");
                return;
            }
            if (i == 0 && i2 == 0) {
                w.i("MicroMsg.BakPcProcessMgr", "getPcPwd OK");
                com.tencent.mm.plugin.backup.bakoldlogic.c.d dVar = (com.tencent.mm.plugin.backup.bakoldlogic.c.d) kVar;
                a.acg().jBs = dVar.jMp;
                this.jLY.run();
            } else {
                this.jLV.F(10010, new String("getPcPwd Fail"));
                w.i("MicroMsg.BakPcProcessMgr", "getPcPwd Fail");
                this.jLZ.run();
            }
            ap.vd().b(596, this);
        }
    }

    public interface b {
        void onError(int i);
    }

    public interface a extends b {
        void acs();
    }

    public interface c extends b {
        void jA(int i);

        void jz(int i);
    }

    public interface d extends b {
        void aac();

        void abW();

        void act();

        void jB(int i);

        void jC(int i);

        void jD(int i);
    }

    public interface e extends b {
        void acu();
    }

    public final void bn(String str, String str2) {
        this.jLQ = str;
        this.jLR = str2;
    }

    public final synchronized void cO(boolean z) {
        this.jLU = z;
    }

    public final synchronized boolean acn() {
        return this.jLU;
    }

    public final synchronized void aco() {
        this.jLG = null;
        this.jLM.jLG = null;
        this.jLN.jLG = null;
    }

    public final synchronized void a(d dVar) {
        if (dVar == null) {
            if (this.jLG instanceof com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.a) {
                w.d("MicroMsg.BakPcProcessMgr", "setOperatorCallbck BakchatBannerView null ilegal, fking return");
            }
        }
        w.d("MicroMsg.BakPcProcessMgr", "setOperatorCallbck:%s", new Object[]{dVar});
        this.jLG = dVar;
        this.jLM.jLG = dVar;
        this.jLN.jLG = dVar;
    }

    public final void aas() {
        if (this.jLN.jMc) {
            f fVar = this.jLN;
            w.i("MicroMsg.RecoverPCServer", "startMerge");
            if (fVar.jCK) {
                w.i("MicroMsg.RecoverPCServer", "hasStartMerge , return");
                return;
            }
            fVar.jLH = 0;
            a.acg().ach().jLT = com.tencent.mm.plugin.backup.bakoldlogic.a.c.jJf;
            fVar.jCK = true;
            com.tencent.mm.plugin.backup.g.a.abC().a(new com.tencent.mm.plugin.backup.g.a.a(fVar) {
                final /* synthetic */ f jMg;

                {
                    this.jMg = r1;
                }

                public final void run() {
                    f fVar = this.jMg;
                    int V = f.V(fVar.jKq);
                    w.i("MicroMsg.RecoverPCServer", "all msg item Count : " + V);
                    System.currentTimeMillis();
                    w.d("MicroMsg.RecoverPCServer", "readFromSdcard start");
                    e.d(new AnonymousClass5(fVar, V), "RecoverPCServer_recoverFromSdcard", 1).start();
                }
            }, false, -1);
            return;
        }
        w.e("MicroMsg.BakPcProcessMgr", "startMerge err state");
    }

    public final void pause() {
        if (this.jLP == 1) {
            this.jLM.pause();
        } else if (this.jLP == 6) {
            this.jLN.pause();
        }
    }

    public final synchronized void F(int i, String str) {
        w.e("MicroMsg.BakPcProcessMgr", "callbackErr type:%d,  %s", new Object[]{Integer.valueOf(i), str});
        if (i == 10006 || i == 10008) {
            w.e("MicroMsg.BakPcProcessMgr", "callbackErr socketClose");
            this.jLS = com.tencent.mm.plugin.backup.bakoldlogic.a.c.jJh;
            this.jLT = com.tencent.mm.plugin.backup.bakoldlogic.a.c.jJa;
            acr();
            a.acg().aci().jLA = 2;
            a.acg().aci().zO();
            if (this.jLJ != null) {
                this.jLJ.onError(i);
            }
            if (this.jLK != null) {
                this.jLK.onError(i);
            }
            if (this.jLG != null) {
                this.jLG.onError(i);
            }
            if (this.jLL != null) {
                this.jLL.onError(i);
            }
        }
        if (i == 10009 || i == 10004) {
            w.e("MicroMsg.BakPcProcessMgr", "callbackErr ip not match or connect failed: %d", new Object[]{Integer.valueOf(i)});
            a.acg().aci().jLA = 2;
            a.acg().aci().zO();
            acp();
        } else {
            w.d("MicroMsg.BakPcProcessMgr", "summerbak errtype:%d, authcallback[%s], operatorcallback[%s], eventCallback[%s]", new Object[]{Integer.valueOf(i), this.jLK, this.jLG, this.jLJ});
            if (i == 15) {
                if (this.jLK != null) {
                    this.jLK.onError(i);
                }
                if (this.jLG != null) {
                    this.jLG.onError(i);
                }
                if (this.jLJ != null) {
                    this.jLJ.jA(i);
                }
            }
            if (i == -1) {
                if (this.jLK != null) {
                    this.jLK.onError(i);
                } else if (this.jLG != null) {
                    this.jLG.onError(i);
                } else if (this.jLJ != null) {
                    this.jLJ.jA(i);
                }
            }
        }
    }

    public final void a(boolean z, int i, byte[] bArr, int i2) {
        if (z && bArr != null) {
            F(i, new String(bArr));
        }
        if (i == CdnLogic.MediaType_FAVORITE_FILE || i == CdnLogic.MediaType_FAVORITE_VIDEO) {
            a.acg().aci().jLA = 1;
            new com.tencent.mm.plugin.backup.bakoldlogic.b.a(a.acg().jBn, a.acg().jBo, com.tencent.mm.plugin.backup.a.e.aai(), a.acg().jBm, 0, -1).abt();
        }
        if (i == 3) {
            this.jLP = -1;
            ab abVar = new ab();
            try {
                abVar.aD(bArr);
                w.i("MicroMsg.BakPcProcessMgr", "recv cmd:%d (%s)", new Object[]{Integer.valueOf(abVar.jMP), jy(abVar.jMP)});
                switch (abVar.jMP) {
                    case 0:
                        if (ap.zb()) {
                            this.jLP = abVar.jMP;
                            if (this.jLK != null) {
                                this.jLK.acs();
                            } else {
                                w.i("MicroMsg.BakPcProcessMgr", "authCallback is null");
                                Intent className = new Intent().setClassName(com.tencent.mm.sdk.platformtools.ab.getContext(), "com.tencent.mm.ui.LauncherUI");
                                className.addFlags(335544320);
                                className.putExtra("nofification_type", "back_to_pcmgr_notification");
                                className.putExtra("newPCBackup", false);
                                com.tencent.mm.sdk.platformtools.ab.getContext().startActivity(className);
                            }
                            this.jLS = com.tencent.mm.plugin.backup.bakoldlogic.a.c.jJi;
                            this.jLT = com.tencent.mm.plugin.backup.bakoldlogic.a.c.jJa;
                            return;
                        }
                        w.w("MicroMsg.BakPcProcessMgr", "acc is not ready, not support pcmgr's auth");
                        a(abVar.jMP, 1, null);
                        return;
                    case 1:
                        a.acg().acj().ack();
                        a.acg().aci().zO();
                        F(-1, null);
                        w.e("MicroMsg.BakPcProcessMgr", "summerback new version not support old pc backup request toast upgrade pc");
                        return;
                    case 3:
                        this.jLT = com.tencent.mm.plugin.backup.bakoldlogic.a.c.jJb;
                        this.jLS = com.tencent.mm.plugin.backup.bakoldlogic.a.c.jJl;
                        acr();
                        a(abVar.jMP, 0, null);
                        com.tencent.mm.sdk.f.e.b(new Runnable(this.jLM) {
                            final /* synthetic */ d jLI;

                            {
                                this.jLI = r1;
                            }

                            public final void run() {
                                d dVar = this.jLI;
                                dVar.jLH = 0;
                                dVar.jJN = new com.tencent.mm.y.e(dVar) {
                                    final /* synthetic */ d jLI;

                                    {
                                        this.jLI = r1;
                                    }

                                    public final void a(int i, int i2, String str, k kVar) {
                                        w.i("MicroMsg.BakPCServer", "onSceneEnd %s, %d, %d", new Object[]{((b) kVar).jHw.jOf, Integer.valueOf(i), Integer.valueOf(i2)});
                                        synchronized (this.jLI.lock) {
                                            this.jLI.jJL.remove(r14.jHw.jOf);
                                            w.i("MicroMsg.BakPCServer", "onSceneEnd left: size:%d", new Object[]{Integer.valueOf(this.jLI.jJL.size())});
                                            if (this.jLI.jJL.size() <= 10) {
                                                this.jLI.lock.notifyAll();
                                            }
                                        }
                                        d dVar = this.jLI;
                                        dVar.jLH++;
                                        if (this.jLI.jLH % 100 == 0) {
                                            dVar = this.jLI;
                                            System.gc();
                                            long freeMemory = Runtime.getRuntime().freeMemory() / 1000;
                                            long totalMemory = Runtime.getRuntime().totalMemory() / 1000;
                                            w.i("MicroMsg.BakPCServer", "memoryInfo avail/total, dalvik[%dk, %dk, user:%dk], recoverCnt:%d", new Object[]{Long.valueOf(freeMemory), Long.valueOf(totalMemory), Long.valueOf(totalMemory - freeMemory), Integer.valueOf(dVar.jLH)});
                                        }
                                        this.jLI.abV();
                                    }
                                };
                                com.tencent.mm.plugin.backup.f.b.a(5, dVar.jJN);
                                String str = (String) a.abC().abD().vr().get(2, null);
                                for (String str2 : dVar.jJK) {
                                    aj Rm = a.abC().abD().wW().Rm(str2);
                                    w.i("MicroMsg.BakPCServer", "backupImp convName:%s, unReadCount:%d", new Object[]{str2, Integer.valueOf(Rm != null ? Rm.field_unReadCount : 0)});
                                    if (!dVar.l(str2, str, Rm != null ? Rm.field_unReadCount : 0)) {
                                        w.i("MicroMsg.BakPCServer", "backupImp.backupChatMsg canceled");
                                        return;
                                    }
                                }
                                dVar.jJO = true;
                                w.i("MicroMsg.BakPCServer", "send conplete waiting to send finishCmd");
                                dVar.abV();
                            }
                        }, "BakPCServer_startBak").start();
                        return;
                    case 4:
                        this.jLS = com.tencent.mm.plugin.backup.bakoldlogic.a.c.jJh;
                        this.jLT = com.tencent.mm.plugin.backup.bakoldlogic.a.c.jJa;
                        acr();
                        a(abVar.jMP, 0, null);
                        if (this.jLO != null) {
                            this.jLO.cancel();
                            this.jLO = null;
                        }
                        if (this.jLM != null) {
                            this.jLM.cancel();
                        }
                        if (this.jJZ != null) {
                            this.jJZ.cancel();
                            this.jJZ = null;
                        }
                        if (this.jLG != null) {
                            this.jLG.act();
                            return;
                        }
                        return;
                    case 6:
                        this.jLS = com.tencent.mm.plugin.backup.bakoldlogic.a.c.jJn;
                        this.jLT = com.tencent.mm.plugin.backup.bakoldlogic.a.c.jJd;
                        acr();
                        this.jLP = abVar.jMP;
                        if (this.jLJ != null) {
                            this.jLJ.jz(abVar.jMP);
                        } else {
                            w.i("MicroMsg.BakPcProcessMgr", "callback is null");
                        }
                        c aci = a.acg().aci();
                        aci.jLD++;
                        com.tencent.mm.plugin.backup.g.a.abC().a(new com.tencent.mm.plugin.backup.g.a.a(this) {
                            final /* synthetic */ e jLV;

                            {
                                this.jLV = r1;
                            }

                            public final void run() {
                                s sVar = new s();
                                if (this.jIp) {
                                    sVar.jNx = this.dbSize;
                                    sVar.jNV = this.jIr - this.dbSize;
                                    sVar.jNU = this.jIq;
                                    e eVar = this.jLV;
                                    e.a(6, 0, sVar);
                                    com.tencent.mm.plugin.backup.f.b.a(3, new com.tencent.mm.y.e(eVar) {
                                        final /* synthetic */ e jLV;

                                        {
                                            this.jLV = r1;
                                        }

                                        public final void a(int i, int i2, String str, k kVar) {
                                            com.tencent.mm.plugin.backup.f.b bVar = (com.tencent.mm.plugin.backup.f.b) kVar;
                                            if (i == 0 && i2 == 0) {
                                                if (kVar.getType() == 3) {
                                                    ac acVar = (ac) bVar.abn();
                                                    if (acVar.jMP == 2) {
                                                        final r rVar = acVar.jOv;
                                                        Runnable anonymousClass1 = new Runnable(this) {
                                                            final /* synthetic */ AnonymousClass2 jLX;

                                                            public final void run() {
                                                                this.jLX.jLV.a(rVar);
                                                            }
                                                        };
                                                        Runnable anonymousClass2 = new Runnable(this) {
                                                            final /* synthetic */ AnonymousClass2 jLX;

                                                            {
                                                                this.jLX = r1;
                                                            }

                                                            public final void run() {
                                                                e.jx(7);
                                                            }
                                                        };
                                                        e eVar = this.jLV;
                                                        w.i("MicroMsg.BakPcProcessMgr", "doGetBakchatKey id: %s", new Object[]{rVar.ID});
                                                        ap.vd().a(596, new AnonymousClass3(eVar, anonymousClass1, anonymousClass2));
                                                        if (eVar.jLO != null) {
                                                            eVar.jLO.cancel();
                                                        }
                                                        eVar.jLO = new com.tencent.mm.plugin.backup.bakoldlogic.c.d(r0);
                                                        ap.vd().a(eVar.jLO, 0);
                                                    }
                                                }
                                                com.tencent.mm.plugin.backup.f.b.b(3, this);
                                                return;
                                            }
                                            w.e("MicroMsg.BakPcProcessMgr", "onSceneEnd:%d  err  [%d,%d]", new Object[]{Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2)});
                                        }
                                    });
                                    w.i("MicroMsg.BakPcProcessMgr", "send restore info cmd");
                                    new com.tencent.mm.plugin.backup.bakoldlogic.c.a(2).abt();
                                    return;
                                }
                                if (this.dbSize > this.jIr && this.jIr > 0) {
                                    sVar.jNx = this.dbSize;
                                    sVar.jNV = this.jIr - this.dbSize;
                                }
                                e.a(6, 14, sVar);
                                w.e("MicroMsg.BakPcProcessMgr", "init TempDB error");
                            }
                        }, false, 1);
                        return;
                    case 7:
                        this.jLS = com.tencent.mm.plugin.backup.bakoldlogic.a.c.jJh;
                        this.jLT = com.tencent.mm.plugin.backup.bakoldlogic.a.c.jJa;
                        acr();
                        a(abVar.jMP, 0, null);
                        if (this.jLO != null) {
                            this.jLO.cancel();
                            this.jLO = null;
                        }
                        if (this.jLN != null) {
                            this.jLN.cancel();
                        }
                        if (this.jLG != null) {
                            this.jLG.act();
                            return;
                        }
                        return;
                    case 9:
                        a(abVar.jMP, 0, null);
                        if (this.jLM != null) {
                            this.jLM.pause();
                            return;
                        }
                        return;
                    case 10:
                        a(abVar.jMP, 0, null);
                        if (this.jLN != null) {
                            this.jLN.pause();
                            return;
                        }
                        return;
                    case 11:
                        a(abVar.jMP, 0, null);
                        if (this.jLM != null) {
                            this.jLM.resume();
                            return;
                        }
                        return;
                    case 12:
                        a(abVar.jMP, 0, null);
                        if (this.jLN != null) {
                            this.jLN.resume();
                            return;
                        }
                        return;
                    case 15:
                        a.acg().acj().ack();
                        a.acg().aci().zO();
                        F(15, null);
                        return;
                    case 16:
                        a(abVar.jMP, 0, null);
                        if (this.jLL != null) {
                            this.jLL.acu();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.BakPcProcessMgr", e, "buf to PacketCommandReq error", new Object[0]);
            }
            w.printErrStackTrace("MicroMsg.BakPcProcessMgr", e, "buf to PacketCommandReq error", new Object[0]);
        }
    }

    public static void acp() {
        Intent className = new Intent().setClassName(com.tencent.mm.sdk.platformtools.ab.getContext(), "com.tencent.mm.ui.LauncherUI");
        className.addFlags(335544320);
        className.putExtra("nofification_type", "back_to_pcmgr_error_notification");
        com.tencent.mm.sdk.platformtools.ab.getContext().startActivity(className);
    }

    public final int acq() {
        w.i("MicroMsg.BakPcProcessMgr", "getPCProgressPercent now progress:%d", new Object[]{Integer.valueOf(this.jLT)});
        if (this.jLT == com.tencent.mm.plugin.backup.bakoldlogic.a.c.jJb || this.jLT == com.tencent.mm.plugin.backup.bakoldlogic.a.c.jJc) {
            return this.jLM.jJR;
        }
        if (this.jLT == com.tencent.mm.plugin.backup.bakoldlogic.a.c.jJd || this.jLT == com.tencent.mm.plugin.backup.bakoldlogic.a.c.jJe) {
            return this.jLN.jMf;
        }
        if (this.jLT == com.tencent.mm.plugin.backup.bakoldlogic.a.c.jJf || this.jLT == com.tencent.mm.plugin.backup.bakoldlogic.a.c.jJg) {
            return this.jLN.jMb;
        }
        w.w("MicroMsg.BakPcProcessMgr", "wrong operatorStatus");
        return 0;
    }

    public final void jw(int i) {
        if (i == 0) {
            this.jLS = com.tencent.mm.plugin.backup.bakoldlogic.a.c.jJj;
        } else {
            this.jLS = com.tencent.mm.plugin.backup.bakoldlogic.a.c.jJh;
        }
        ac acVar;
        if (i == 1) {
            acVar = new ac();
            acVar.jMP = 0;
            acVar.jNB = i;
            try {
                w.i("MicroMsg.BakPcProcessMgr", "send auth cmd resp, status:%d", new Object[]{Integer.valueOf(acVar.jNB)});
                com.tencent.mm.plugin.backup.f.b.r(acVar.toByteArray(), 4);
                return;
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.BakPcProcessMgr", e, "buf to PacketCommandResponse err", new Object[0]);
                return;
            }
        }
        q qVar = new q();
        qVar.jNM = 0;
        qVar.jNO = Build.MANUFACTURER;
        qVar.jNo = Build.MODEL;
        qVar.jNN = 0;
        qVar.jNP = VERSION.RELEASE;
        String str = com.tencent.mm.storage.w.hgq;
        if (new File(com.tencent.mm.compatible.util.e.hgs).exists() && f.rZ()) {
            File file = new File(com.tencent.mm.compatible.util.e.hgu);
            if (file.exists() || file.mkdirs()) {
                str = com.tencent.mm.compatible.util.e.hgu;
            }
        }
        qVar.jNL = str;
        qVar.jNK = m.xN();
        qVar.jNJ = m.xL();
        qVar.jNI = com.tencent.mm.protocal.d.sYN;
        try {
            PackageInfo packageInfo = com.tencent.mm.sdk.platformtools.ab.getContext().getPackageManager().getPackageInfo(com.tencent.mm.sdk.platformtools.ab.getContext().getPackageName(), 0);
            qVar.jNI = packageInfo.versionName + ";" + packageInfo.versionCode + ";" + com.tencent.mm.protocal.d.sYN;
        } catch (Throwable e2) {
            w.printErrStackTrace("MicroMsg.BakPcProcessMgr", e2, "get packageInfo failed", new Object[0]);
        }
        n.Bl();
        Bitmap hk = com.tencent.mm.x.d.hk(qVar.jNJ);
        byte[] bArr = null;
        if (hk != null) {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            hk.compress(CompressFormat.PNG, 0, byteArrayOutputStream);
            bArr = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable e3) {
                w.printErrStackTrace("MicroMsg.BakPcProcessMgr", e3, "close", new Object[0]);
            }
        }
        n.Bl();
        String r = com.tencent.mm.x.d.r(qVar.jNJ, true);
        String str2 = "MicroMsg.BakPcProcessMgr";
        String str3 = ", bmHDPath:%s, bm.buf.len:%d";
        Object[] objArr = new Object[2];
        objArr[0] = r;
        objArr[1] = Integer.valueOf(bArr == null ? 0 : bArr.length);
        w.i(str2, str3, objArr);
        if (!bg.bm(bArr)) {
            qVar.jNQ = new com.tencent.mm.bd.b(bArr);
        }
        bArr = com.tencent.mm.a.e.d(r, 0, -1);
        if (!bg.bm(bArr)) {
            qVar.jNR = new com.tencent.mm.bd.b(bArr);
        }
        acVar = new ac();
        acVar.jMP = 0;
        acVar.jNB = i;
        acVar.jOt = qVar;
        try {
            w.i("MicroMsg.BakPcProcessMgr", "send auth cmd resp, status:%d", new Object[]{Integer.valueOf(acVar.jNB)});
            com.tencent.mm.plugin.backup.f.b.r(acVar.toByteArray(), 4);
        } catch (Throwable e22) {
            w.printErrStackTrace("MicroMsg.BakPcProcessMgr", e22, "buf to PacketCommandResponse err", new Object[0]);
        }
    }

    public static void a(int i, int i2, s sVar) {
        ac acVar = new ac();
        acVar.jMP = i;
        acVar.jNB = i2;
        acVar.jOw = sVar;
        try {
            w.i("MicroMsg.BakPcProcessMgr", "send cmd resp, status:%d, cmd:%d (%s)", new Object[]{Integer.valueOf(i2), Integer.valueOf(i), jy(i)});
            com.tencent.mm.plugin.backup.f.b.r(acVar.toByteArray(), 4);
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.BakPcProcessMgr", e, "buf to PacketCommandResponse err", new Object[0]);
        }
    }

    public static void jx(int i) {
        ab abVar = new ab();
        abVar.jMP = i;
        try {
            w.i("MicroMsg.BakPcProcessMgr", "sendNormalReq cmd :%d (%s)", new Object[]{Integer.valueOf(i), jy(i)});
            com.tencent.mm.plugin.backup.f.b.r(abVar.toByteArray(), 3);
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.BakPcProcessMgr", e, "buf to PacketCommandRequest err", new Object[0]);
        }
    }

    public final synchronized void a(r rVar) {
        if (this.jLN != null) {
            this.jLN.cancel();
        }
        this.jLN = new f();
        f fVar = this.jLN;
        List list = rVar.jNS;
        List list2 = rVar.jNT;
        long j = rVar.jNA;
        fVar.jKq = list;
        fVar.jMa = list2;
        fVar.fKF = false;
        fVar.htv = false;
        fVar.jJL.clear();
        fVar.jJO = false;
        fVar.jMc = false;
        fVar.jCK = false;
        fVar.jMb = 0;
        fVar.jMe = 0;
        fVar.jMd = j;
        com.tencent.mm.plugin.backup.bakoldlogic.c.c.setProgress(0);
        this.jLN.jLG = this.jLG;
        w.i("MicroMsg.BakPcProcessMgr", "reve textList:%d,  mediaList:%d, convDataSize:%d", new Object[]{Integer.valueOf(rVar.jNS.size()), Integer.valueOf(rVar.jNT.size()), Long.valueOf(rVar.jNA)});
        fVar = this.jLN;
        fVar.jLH = 0;
        if (fVar.jMa.size() < rVar.jNF || fVar.jKq.size() < rVar.jNE) {
            com.tencent.mm.plugin.backup.f.b.a(3, new com.tencent.mm.y.e(fVar) {
                final /* synthetic */ f jMg;

                {
                    this.jMg = r1;
                }

                public final void a(int i, int i2, String str, k kVar) {
                    ac acVar = (ac) ((com.tencent.mm.plugin.backup.f.b) kVar).abn();
                    if (acVar.jMP == 2) {
                        r rVar = acVar.jOv;
                        this.jMg.jMa.addAll(rVar.jNT);
                        this.jMg.jKq.addAll(rVar.jNS);
                        w.i("MicroMsg.RecoverPCServer", "MediaSize:[%d / %d], digestSize: [%d / %d]", new Object[]{Integer.valueOf(this.jMg.jMa.size()), Integer.valueOf(this.jMg.jKq.size()), Integer.valueOf(rVar.jNF), Integer.valueOf(rVar.jNE)});
                        if (this.jMg.jMa.size() < rVar.jNF || this.jMg.jKq.size() < rVar.jNE) {
                            w.i("MicroMsg.RecoverPCServer", "send restore info cmd again~");
                            new com.tencent.mm.plugin.backup.bakoldlogic.c.a(2).abt();
                            return;
                        }
                        this.jMg.jMd = rVar.jNA;
                        w.i("MicroMsg.RecoverPCServer", "down RestoreInfo complete, convDataSize:%d", new Object[]{Long.valueOf(this.jMg.jMd)});
                        com.tencent.mm.plugin.backup.f.b.b(3, this);
                        e.post(new Runnable(this) {
                            final /* synthetic */ AnonymousClass2 jMh;

                            {
                                this.jMh = r1;
                            }

                            public final void run() {
                                this.jMh.jMg.acv();
                            }
                        }, "RecoverPCServer_recover_getIDList");
                    }
                }
            });
            w.i("MicroMsg.RecoverPCServer", "send restore info cmd");
            new com.tencent.mm.plugin.backup.bakoldlogic.c.a(2).abt();
        } else {
            w.i("MicroMsg.RecoverPCServer", "startRecover start directly");
            com.tencent.mm.sdk.f.e.post(new Runnable(fVar) {
                final /* synthetic */ f jMg;

                {
                    this.jMg = r1;
                }

                public final void run() {
                    this.jMg.acv();
                }
            }, "RecoverPCServer_recover");
        }
    }

    public static void acr() {
        com.tencent.mm.sdk.b.a.urY.m(new ks());
    }

    private static String jy(int i) {
        switch (i) {
            case -1:
                return "COMMAND_NOT_SUPPORT";
            case 0:
                return "AUTHORIZE";
            case 1:
                return "BACKUP_INFO";
            case 2:
                return "RESTORE_INFO";
            case 3:
                return "BACKUP_START";
            case 4:
                return "BACKUP_CANCEL";
            case 5:
                return "BACKUP_FINISH";
            case 6:
                return "RESTORE_START";
            case 7:
                return "RESTORE_CANCE";
            case 8:
                return "RESTORE_FINISH";
            case 9:
                return "BACKUP_PAUSE";
            case 10:
                return "RESTORE_PAUSE";
            case 11:
                return "BACKUP_RESUME";
            case 12:
                return "RESTORE_RESUME";
            case 13:
                return "MERGE_PROGRESS";
            case 14:
                return "LOGOFF";
            case 15:
                return "EXIT";
            case 16:
                return "SHOW_BACKUP_RESTORE";
            case 17:
                return "COMMAND_WECHAT_LEAVE";
            default:
                return String.valueOf(i);
        }
    }

    public final void m(int i, long j) {
        if (this.jLG != null) {
            this.jLG.jB(i);
        }
        ab abVar = new ab();
        abVar.jMP = 19;
        abVar.jOq = 0;
        abVar.jOr = i;
        abVar.jOs = j;
        try {
            w.i("MicroMsg.BakPcProcessMgr", "sendCalcuProcess cmd, progress :%d", new Object[]{Integer.valueOf(i)});
            com.tencent.mm.plugin.backup.f.b.r(abVar.toByteArray(), 3);
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.BakPcProcessMgr", e, "buf to PacketCommandRequest err", new Object[0]);
        }
    }
}
