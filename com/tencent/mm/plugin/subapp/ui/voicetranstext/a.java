package com.tencent.mm.plugin.subapp.ui.voicetranstext;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.asw;
import com.tencent.mm.protocal.c.bif;
import com.tencent.mm.protocal.c.bjo;
import com.tencent.mm.protocal.c.bjt;
import com.tencent.mm.protocal.c.lg;
import com.tencent.mm.protocal.c.lh;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class a extends k implements j {
    public static int qVI = 1;
    public static int qVJ = 2;
    public static int qVK = 3;
    private b hse;
    private String mFileName;
    public int mState = -1;
    private e nXi;
    private String qVE;
    private int qVF;
    private bjo qVG;
    private long qVH;
    public bjt qVL;
    public bif qVM;
    public asw qVN;
    int qVO;

    public a(String str, int i, String str2) {
        a(str, i, -1, -1, str2);
    }

    public a(String str, int i, int i2, long j, String str2) {
        a(str, i, i2, j, str2);
    }

    private void a(String str, int i, int i2, long j, String str2) {
        com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
        aVar.hsm = new lg();
        aVar.hsn = new lh();
        aVar.uri = "/cgi-bin/micromsg-bin/checkvoicetrans";
        aVar.hsl = 546;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.mFileName = str2;
        this.hse = aVar.BE();
        w.i("MicroMsg.NetSceneCheckVoiceTrans", "voiceId:%s, totalLen:%d, encodeType: %d, svrMsgId: %s", str, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j));
        if (i2 >= 0) {
            this.qVG = d.ar(i2, str2);
        }
        if (j > 0) {
            this.qVH = j;
        }
        this.qVE = str;
        this.qVF = i;
    }

    public final int getType() {
        return 546;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.nXi = eVar2;
        lg lgVar = (lg) this.hse.hsj.hsr;
        lgVar.trv = this.qVE;
        lgVar.tgJ = this.qVF;
        lgVar.trw = this.qVG;
        lgVar.tfk = this.qVH;
        return a(eVar, this.hse, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        if (i2 == 0 && i3 == 0) {
            lh lhVar = (lh) this.hse.hsk.hsr;
            if (lhVar != null) {
                this.qVL = lhVar.trx;
                this.mState = lhVar.jNB;
                this.qVM = lhVar.try;
                this.qVN = lhVar.trz;
                this.qVO = lhVar.trA;
            } else {
                return;
            }
        }
        w.i("MicroMsg.NetSceneCheckVoiceTrans", "end checkVoiceTrans, & errType:%d, errCode:%d, voiceId: %s ", Integer.valueOf(i2), Integer.valueOf(i3), this.qVE);
        this.nXi.a(i2, i3, str, this);
    }

    public final boolean bnj() {
        return (this.qVL == null || bg.mA(this.qVL.uji)) ? false : true;
    }
}
