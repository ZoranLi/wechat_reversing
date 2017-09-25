package com.tencent.mm.plugin.subapp.jdbiz;

import com.tencent.mm.pluginsdk.l.e;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import java.util.Map;

public final class b implements e {
    public String fSs = "";
    public long hVj = 0;
    public String iconUrl = "";
    public String jumpUrl = "";
    public String qSA = "";
    public String qSB = "";
    public long qSC;
    public long qSD;
    public long qSE;
    public long qSF;
    public String qSG = "";
    public String qSH = "";
    public String qSI = "";
    public String qSJ = "";
    public String qSw = "";
    public String qSx = "";
    public boolean qSy = false;
    public boolean qSz = false;
    public long startTime;
    public String title = "";

    public static b bmE() {
        ap.yY();
        String str = (String) c.vr().get(327942, (Object) "");
        b bVar = new b();
        w.i("MicroMsg.JdMsgContent", " create xml : " + str);
        bVar.FU(str);
        return bVar;
    }

    public final void FU(String str) {
        this.qSw = "";
        this.qSx = "";
        this.hVj = 0;
        this.qSA = "";
        this.qSy = false;
        this.qSz = false;
        this.qSH = "";
        this.qSI = "";
        this.qSJ = "";
        this.qSG = "";
        this.jumpUrl = "";
        this.fSs = "";
        this.fSs = str;
        if (!bg.mA(str)) {
            w.i("MicroMsg.JdMsgContent", "feed xml %s", str);
            Map q = bh.q(str, "sysmsg");
            if (q != null) {
                this.qSw = bg.ap((String) q.get(".sysmsg.biztype"), "");
                this.qSG = bg.ap((String) q.get(".sysmsg.alert"), "");
                this.qSx = bg.ap((String) q.get(".sysmsg.activityid"), "");
                this.startTime = bg.PZ((String) q.get(".sysmsg.starttime"));
                this.hVj = bg.PZ((String) q.get(".sysmsg.expiretime"));
                this.title = bg.ap((String) q.get(".sysmsg.content.title"), "");
                this.iconUrl = bg.ap((String) q.get(".sysmsg.content.icon"), "");
                this.jumpUrl = bg.ap((String) q.get(".sysmsg.content.jumpurl"), "");
                this.qSC = bg.PZ((String) q.get(".sysmsg.content.urlstarttime"));
                this.qSD = bg.PZ((String) q.get(".sysmsg.content.urlexpiretime"));
                this.qSA = bg.ap((String) q.get(".sysmsg.content.jdcelltitle"), "");
                this.qSB = bg.ap((String) q.get(".sysmsg.content.jdcellicon"), "");
                this.qSE = bg.PZ((String) q.get(".sysmsg.content.titlestarttime"));
                this.qSF = bg.PZ((String) q.get(".sysmsg.content.titleexpiretime"));
                this.qSy = "1".equals(q.get(".sysmsg.content.findshowreddot"));
                this.qSz = "1".equals(q.get(".sysmsg.content.jdcellshowred"));
                this.qSH = bg.ap((String) q.get(".sysmsg.content.alertviewtitle"), "");
                this.qSI = bg.ap((String) q.get(".sysmsg.content.alertviewconfirm"), "");
                this.qSJ = bg.ap((String) q.get(".sysmsg.content.alertviewcancel"), "");
            }
        }
    }

    public final boolean axD() {
        return this.startTime < System.currentTimeMillis() / 1000;
    }

    public final boolean bmF() {
        return this.hVj != 0 && this.hVj < System.currentTimeMillis() / 1000;
    }

    public final boolean a(b bVar) {
        if (bVar != null && bg.ap(this.qSx, "").equals(bg.ap(bVar.qSx, ""))) {
            return false;
        }
        return true;
    }

    public final String bmG() {
        return bg.ap(this.fSs, "");
    }

    public final String bmH() {
        return this.qSx;
    }

    public final String bmI() {
        return this.qSA;
    }

    public final boolean bmJ() {
        return this.qSz;
    }

    public final String bmK() {
        return this.qSw;
    }

    public final String bmL() {
        return this.jumpUrl;
    }
}
