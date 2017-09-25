package com.tencent.mm.plugin.ipcall.a.d;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiGetOpenDeviceId;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.ipcall.b.c;
import com.tencent.mm.protocal.c.arw;
import com.tencent.mm.protocal.c.arx;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class l extends k implements j {
    private b gUA = null;
    private e gUD;
    private arw mQa = null;
    private arx mQb = null;

    public l(int i, long j, boolean z) {
        a aVar = new a();
        aVar.hsm = new arw();
        aVar.hsn = new arx();
        aVar.hsl = GameJsApiGetOpenDeviceId.CTRL_BYTE;
        aVar.uri = "/cgi-bin/micromsg-bin/pstnreport";
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        this.mQa = (arw) this.gUA.hsj.hsr;
        this.mQa.tvL = i;
        this.mQa.tVZ = j;
        this.mQa.tWs = z ? 1 : 0;
        w.d("MicroMsg.NetSceneIPCallReport", "NetSceneIPCallReport, roomId: %d, callseq: %d, gotAnswer: %d", new Object[]{Integer.valueOf(this.mQa.tvL), Long.valueOf(this.mQa.tVZ), Integer.valueOf(this.mQa.tWs)});
        arw com_tencent_mm_protocal_c_arw = this.mQa;
        com.tencent.mm.plugin.ipcall.a.c.b aEj = i.aEj();
        w.i("MicroMsg.IPCallReportHelper", "getPstnClientReportString, result: %s", new Object[]{aEj.mNL + "," + aEj.mNM + "," + aEj.mPm + "," + aEj.isg + "," + aEj.mPn + "," + aEj.mPc + "," + aEj.mPd + "," + aEj.mPe + "," + aEj.mPf + "," + aEj.mPg + "," + aEj.mPh + "," + aEj.mPi + "," + aEj.mPj + "," + aEj.mPk + "," + aEj.mPl + "," + aEj.mPo + "," + c.aFx() + "," + aEj.mPx + "," + aEj.countryCode + "," + aEj.mPy + "," + aEj.mPz + "," + aEj.mPA + aEj.mPv + "," + aEj.mPC});
        com_tencent_mm_protocal_c_arw.tWp = n.mw(r3);
        com_tencent_mm_protocal_c_arw = this.mQa;
        aEj = i.aEj();
        w.i("MicroMsg.IPCallReportHelper", "getPstnChannelReportString, result: %s", new Object[]{aEj.mNL + "," + aEj.mNM + "," + aEj.mPm + aEj.mPu});
        com_tencent_mm_protocal_c_arw.tWq = n.mw(r3);
        com_tencent_mm_protocal_c_arw = this.mQa;
        aEj = i.aEj();
        w.i("MicroMsg.IPCallReportHelper", "getPstnEngineReport, result: %s", new Object[]{aEj.mNL + "," + aEj.mNM + "," + aEj.mPm + aEj.mPt});
        com_tencent_mm_protocal_c_arw.tWr = n.mw(r3);
    }

    public final int getType() {
        return GameJsApiGetOpenDeviceId.CTRL_BYTE;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneIPCallReport", "onGYNetEnd, errType: %d, errCode: %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.mQb = (arx) ((b) pVar).hsk.hsr;
        if (this.gUD != null) {
            this.gUD.a(i2, i3, str, this);
        }
    }
}
