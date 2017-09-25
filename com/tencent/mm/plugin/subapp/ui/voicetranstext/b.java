package com.tencent.mm.plugin.subapp.ui.voicetranstext;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.acs;
import com.tencent.mm.protocal.c.act;
import com.tencent.mm.protocal.c.bjt;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import junit.framework.Assert;

public final class b extends k implements j {
    private final String TAG = "MicroMsg.NetSceneGetVoiceTransRes";
    private com.tencent.mm.y.b hse;
    private e nXi;
    private String qVE;
    public bjt qVL;
    public int qVP = -1;

    public b(String str) {
        Assert.assertTrue(!bg.mA(str));
        this.qVE = str;
        a aVar = new a();
        aVar.hsm = new acs();
        aVar.hsn = new act();
        aVar.uri = "/cgi-bin/micromsg-bin/getvoicetransres";
        aVar.hsl = 548;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.hse = aVar.BE();
    }

    public final int getType() {
        return 548;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.nXi = eVar2;
        ((acs) this.hse.hsj.hsr).trv = this.qVE;
        return a(eVar, this.hse, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        if (i2 == 0 && i3 == 0) {
            act com_tencent_mm_protocal_c_act = (act) this.hse.hsk.hsr;
            if (com_tencent_mm_protocal_c_act.trz != null) {
                this.qVP = com_tencent_mm_protocal_c_act.trz.tXl;
            }
            this.qVL = com_tencent_mm_protocal_c_act.trx;
        } else {
            w.i("MicroMsg.NetSceneGetVoiceTransRes", "error get: errType:%d, errCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
        }
        this.nXi.a(i2, i3, str, this);
    }

    public final boolean isComplete() {
        return this.qVL != null && this.qVL.tiL == 1;
    }

    public final boolean bnj() {
        return (this.qVL == null || bg.mA(this.qVL.uji)) ? false : true;
    }
}
