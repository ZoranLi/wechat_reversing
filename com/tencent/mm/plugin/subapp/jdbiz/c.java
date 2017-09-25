package com.tencent.mm.plugin.subapp.jdbiz;

import android.os.Looper;
import com.tencent.mm.e.a.hf;
import com.tencent.mm.e.a.ia;
import com.tencent.mm.i.g;
import com.tencent.mm.kernel.h;
import com.tencent.mm.pluginsdk.l.aa;
import com.tencent.mm.pluginsdk.l.e;
import com.tencent.mm.pluginsdk.l.l;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.am;
import com.tencent.mm.u.ap;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.HashMap;
import java.util.Map;

public class c implements l, am {
    private com.tencent.mm.sdk.b.c gKr = new com.tencent.mm.sdk.b.c<hf>(this) {
        final /* synthetic */ c qSN;

        {
            this.qSN = r2;
            this.usg = hf.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            hf hfVar = (hf) bVar;
            if (hfVar != null && (hfVar instanceof hf)) {
                hfVar.fMG.url = this.qSN.bmV();
            }
            return false;
        }
    };
    private a qSK = null;
    private b qSL = null;
    Map<String, Integer> qSM = new HashMap();

    public final /* synthetic */ e bmW() {
        return bmR();
    }

    public c() {
        w.i("MicroMsg.SubCoreJdIP6", "new SubCoreJDBiz this: " + hashCode() + " stack: " + bg.bJZ());
    }

    public static c bmM() {
        c cVar = (c) aa.sBG;
        if (cVar != null) {
            return cVar;
        }
        Object cVar2 = new c();
        aa.sBG = cVar2;
        return cVar2;
    }

    public final HashMap<Integer, com.tencent.mm.bj.g.c> uh() {
        return null;
    }

    public final void eD(int i) {
    }

    public final void aM(boolean z) {
        w.i("MicroMsg.SubCoreJdIP6", "onAccountPostReset");
        if (this.qSK == null) {
            this.qSK = new a();
        }
        ap.getSysCmdMsgExtension().a("jd", this.qSK, true);
        a.urY.b(this.gKr);
    }

    public final void aN(boolean z) {
    }

    public final void onAccountRelease() {
        w.i("MicroMsg.SubCoreJdIP6", "onAccountRelease");
        if (this.qSK != null) {
            a.urY.c(this.qSK.qSt);
            ap.getSysCmdMsgExtension().b("jd", this.qSK, true);
        }
        this.qSM.clear();
        this.qSK = null;
        a.urY.c(this.gKr);
    }

    public final boolean bmN() {
        ap.yY();
        return "1".equals((String) com.tencent.mm.u.c.vr().get(327939, (Object) ""));
    }

    public final boolean bmO() {
        ap.yY();
        return "1".equals((String) com.tencent.mm.u.c.vr().get(327938, (Object) ""));
    }

    public final void bmP() {
        ap.yY();
        com.tencent.mm.u.c.vr().set(327938, "");
    }

    public final void bmQ() {
        ap.yY();
        com.tencent.mm.u.c.vr().set(327939, "");
    }

    public final b bmR() {
        if (this.qSL == null) {
            this.qSL = b.bmE();
        }
        return this.qSL;
    }

    public static void b(b bVar) {
        h.vG().uQ();
        c bmM = bmM();
        if (bmM.qSL == null) {
            bmM.qSL = b.bmE();
        }
        w.i("MicroMsg.SubCoreJdIP6", "updatejdMsgContent old: %s new: %s", bmM.qSL.bmG(), bVar.bmG());
        if (bVar.a(bmM.qSL)) {
            if (!bg.mA(bVar.qSA) || bVar.qSz) {
                ap.yY();
                com.tencent.mm.u.c.vr().set(327939, "1");
            }
            if (bVar.qSy) {
                ap.yY();
                com.tencent.mm.u.c.vr().set(327938, "1");
            } else {
                ap.yY();
                com.tencent.mm.u.c.vr().set(327938, "");
            }
            bmM.qSL = bVar;
            ap.yY();
            com.tencent.mm.u.c.vr().set(327942, bVar.fSs);
            bmM.bmS();
            return;
        }
        w.i("MicroMsg.SubCoreJdIP6", "fo zu baoyou! the activityid is same");
    }

    private void bmS() {
        new ae(Looper.getMainLooper()).post(new Runnable(this) {
            final /* synthetic */ c qSN;

            {
                this.qSN = r1;
            }

            public final void run() {
                a.urY.m(new ia());
            }
        });
    }

    public final void bmT() {
        if (!ap.zb()) {
            return;
        }
        if (bmM().bmN() || bmM().bmO()) {
            b bmR = bmM().bmR();
            if ((!bg.mA(bmR.qSA) || bmR.qSz) && bmR.bmF()) {
                w.i("MicroMsg.SubCoreJdIP6", "clear red dot/friend dot");
                bmM().bmP();
                bmM().bmQ();
                bmM().bmS();
            }
        }
    }

    public static String bQ(String str, int i) {
        if (-1 != str.indexOf(35)) {
            return str;
        }
        if (-1 == str.indexOf(63)) {
            return str + "?wc_scene=" + i;
        }
        return str + "&wc_scene=" + i;
    }

    public static boolean bmU() {
        return (bg.mA(g.sV().getValue("JDEntranceConfigName")) || bg.mA(g.sV().getValue("JDEntranceConfigIconUrl")) || bg.mA(g.sV().getValue("JDEntranceConfigJumpUrl"))) ? false : true;
    }

    public final String bmV() {
        int i = 1;
        String value = g.sV().getValue("JDEntranceConfigJumpUrl");
        if (bg.mA(value)) {
            return null;
        }
        int i2;
        int i3;
        b bmR = bmR();
        if (bmN()) {
            if (!bmR.bmF() && TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL.equals(bmR.qSw) && !bg.mA(bmR.jumpUrl)) {
                w.i("MicroMsg.SubCoreJdIP6", "jumpUrl update %s", bmR.jumpUrl);
                value = bmR.jumpUrl;
                i2 = 6;
                if (bmR.qSC < System.currentTimeMillis() / 1000) {
                    i3 = 0;
                } else {
                    i3 = 1;
                }
                if (i3 != 0) {
                    i = 0;
                    if (i == 0) {
                        value = bmR.jumpUrl;
                        i2 = 3;
                    }
                }
                return bQ(value, i2);
            } else if (bmR.qSz) {
                i2 = 2;
                if ("2".equals(bmR.qSw) && !bg.mA(bmR.jumpUrl)) {
                    if (bmR.qSC < System.currentTimeMillis() / 1000) {
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    if (i3 != 0) {
                        if (bmR.qSD == 0 || bmR.qSD >= System.currentTimeMillis() / 1000) {
                            i = 0;
                        }
                        if (i == 0) {
                            value = bmR.jumpUrl;
                            i2 = 3;
                        }
                    }
                }
                return bQ(value, i2);
            }
        }
        i2 = 1;
        if (bmR.qSC < System.currentTimeMillis() / 1000) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        if (i3 != 0) {
            i = 0;
            if (i == 0) {
                value = bmR.jumpUrl;
                i2 = 3;
            }
        }
        return bQ(value, i2);
    }
}
