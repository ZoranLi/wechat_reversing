package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.modelsns.d;
import com.tencent.mm.plugin.webview.model.ai;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.smtt.utils.i;

public final class g {
    public static g scG = new g();
    private String fFF;
    boolean hoD = false;
    private int networkType;
    String qdW;
    String scH;

    private g() {
    }

    public final void dT(String str, String str2) {
        w.i("MicroMsg.WebViewReportUtil", "setting traceid " + str + ",usename " + str2);
        this.qdW = str;
        this.networkType = ai.bwu();
        this.fFF = i.aV(str2 + bg.Nz());
        this.hoD = false;
    }

    public final void wn(int i) {
        if (!bg.mA(this.qdW)) {
            c(3, "", i);
        }
    }

    public final void close() {
        this.hoD = true;
        if (!bg.mA(this.qdW)) {
            mN(4);
            this.qdW = null;
        }
    }

    final void mN(int i) {
        c(i, "", 0);
    }

    final void c(int i, String str, int i2) {
        d dVar = new d();
        dVar.n("20adInfo", this.qdW + ",");
        dVar.n("21optype", i + ",");
        dVar.n("22sessionId", this.fFF + ",");
        dVar.n("23currURL", this.scH + ",");
        dVar.n("24referURL", str + ",");
        dVar.n("25errCode", i2 + ",");
        dVar.n("26networkType", this.networkType + ",");
        dVar.n("27timeStamp", bg.Nz() + ",");
        w.i("MicroMsg.WebViewReportUtil", "report logbuffer adPageOp(13791): optype:%d, sessionId:%s, currUrl:%s, referUrl:%s, errCode:%d, networkType:%d", new Object[]{Integer.valueOf(i), this.fFF, this.scH, str, Integer.valueOf(i2), Integer.valueOf(this.networkType)});
        com.tencent.mm.plugin.report.service.g.oUh.i(13791, new Object[]{dVar});
    }
}
