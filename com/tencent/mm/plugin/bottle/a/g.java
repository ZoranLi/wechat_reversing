package com.tencent.mm.plugin.bottle.a;

import com.tencent.mm.modelvoice.o;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiMakeVoIPCall;
import com.tencent.mm.protocal.c.avx;
import com.tencent.mm.protocal.c.bfa;
import com.tencent.mm.protocal.c.bfb;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class g extends k implements j {
    private b gUA;
    private e gUD;
    int jVf = 0;
    private com.tencent.mm.modelvoice.b jVi;
    int msgType = -1;

    public g(String str) {
        a aVar = new a();
        aVar.hsm = new bfa();
        aVar.hsn = new bfb();
        aVar.uri = "/cgi-bin/micromsg-bin/throwbottle";
        aVar.hsl = JsApiMakeVoIPCall.CTRL_INDEX;
        aVar.hso = 53;
        aVar.hsp = 1000000053;
        this.gUA = aVar.BE();
        if (!bg.mA(str)) {
            this.msgType = 1;
            bfa com_tencent_mm_protocal_c_bfa = (bfa) this.gUA.hsj.hsr;
            com_tencent_mm_protocal_c_bfa.tVg = 0;
            com_tencent_mm_protocal_c_bfa.mtd = this.msgType;
            com_tencent_mm_protocal_c_bfa.tgK = 0;
            com_tencent_mm_protocal_c_bfa.tgJ = str.getBytes().length;
            com_tencent_mm_protocal_c_bfa.tue = 0;
            com_tencent_mm_protocal_c_bfa.tsM = n.G(str.getBytes());
            com_tencent_mm_protocal_c_bfa.tON = com.tencent.mm.a.g.n((str + bg.Nz()).getBytes());
        }
    }

    public g(String str, int i) {
        a aVar = new a();
        aVar.hsm = new bfa();
        aVar.hsn = new bfb();
        aVar.uri = "/cgi-bin/micromsg-bin/throwbottle";
        aVar.hsl = JsApiMakeVoIPCall.CTRL_INDEX;
        aVar.hso = 53;
        aVar.hsp = 1000000053;
        this.gUA = aVar.BE();
        if (!bg.mA(str) && i > 0) {
            this.msgType = 3;
            bfa com_tencent_mm_protocal_c_bfa = (bfa) this.gUA.hsj.hsr;
            com_tencent_mm_protocal_c_bfa.tue = i;
            com_tencent_mm_protocal_c_bfa.tON = str;
            com_tencent_mm_protocal_c_bfa.tVg = 0;
            com_tencent_mm_protocal_c_bfa.mtd = this.msgType;
        }
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        if (this.msgType == 1) {
            this.msgType = 0 - this.msgType;
        } else if (this.msgType == 3) {
            bfa com_tencent_mm_protocal_c_bfa = (bfa) this.gUA.hsj.hsr;
            com_tencent_mm_protocal_c_bfa.mtd = 3;
            com_tencent_mm_protocal_c_bfa.tVg = 0;
            if (this.jVi == null) {
                this.jVi = q.lV(com_tencent_mm_protocal_c_bfa.tON);
                this.jVf = 0;
                com_tencent_mm_protocal_c_bfa.tgJ = o.lx(com_tencent_mm_protocal_c_bfa.tON);
            }
            com.tencent.mm.modelvoice.g bd = this.jVi.bd(this.jVf, 6000);
            w.d("MicroMsg.NetSceneThrowBottle", "doScene READ file[" + com_tencent_mm_protocal_c_bfa.tON + "] read ret:" + bd.ret + " readlen:" + bd.fAK + " newOff:" + bd.iaP + " netOff:" + this.jVf + " line:" + com.tencent.mm.compatible.util.g.sb());
            if (bd.ret < 0 || bd.fAK == 0) {
                w.e("MicroMsg.NetSceneThrowBottle", "Err doScene READ file[" + com_tencent_mm_protocal_c_bfa.tON + "] read ret:" + bd.ret + " readlen:" + bd.fAK + " newOff:" + bd.iaP + " netOff:" + this.jVf);
                q.lW(com_tencent_mm_protocal_c_bfa.tON);
                return -1;
            }
            Object obj = new byte[bd.fAK];
            System.arraycopy(bd.buf, 0, obj, 0, bd.fAK);
            com_tencent_mm_protocal_c_bfa.tsM = n.G(obj);
            com_tencent_mm_protocal_c_bfa.tgK = this.jVf;
        } else {
            w.e("MicroMsg.NetSceneThrowBottle", "doScene Error Msg type: " + this.msgType);
            return -1;
        }
        return a(eVar, this.gUA, this);
    }

    protected final int a(p pVar) {
        bfa com_tencent_mm_protocal_c_bfa = (bfa) ((b) pVar).hsj.hsr;
        if (com_tencent_mm_protocal_c_bfa.mtd == 1) {
            return k.b.hsT;
        }
        if (com_tencent_mm_protocal_c_bfa.mtd != 3) {
            return k.b.hsU;
        }
        if (com_tencent_mm_protocal_c_bfa.tgJ == 0 || com_tencent_mm_protocal_c_bfa.tgJ <= com_tencent_mm_protocal_c_bfa.tgK || bg.mA(com_tencent_mm_protocal_c_bfa.tON) || bg.bm(n.a(com_tencent_mm_protocal_c_bfa.tsM))) {
            return k.b.hsU;
        }
        return k.b.hsT;
    }

    protected final int ub() {
        return 10;
    }

    protected final void a(k.a aVar) {
        w.e("MicroMsg.NetSceneThrowBottle", "setSecurityCheckError:" + aVar + " type:" + this.msgType);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneThrowBottle", "onGYNetEnd errtype:" + i2 + " errCode:" + i3);
        bfa com_tencent_mm_protocal_c_bfa = (bfa) this.gUA.hsj.hsr;
        bfb com_tencent_mm_protocal_c_bfb = (bfb) this.gUA.hsk.hsr;
        if (i2 == 4) {
            switch (i3) {
                case -56:
                    break;
                default:
                    c.jP(com_tencent_mm_protocal_c_bfb.tCT);
                    c.jO(com_tencent_mm_protocal_c_bfb.tCS);
                    break;
            }
        }
        if (i2 == 0 && i3 == 0) {
            w.d("MicroMsg.NetSceneThrowBottle", "getStartPos " + com_tencent_mm_protocal_c_bfb.tgK);
            w.d("MicroMsg.NetSceneThrowBottle", "getTotalLen " + com_tencent_mm_protocal_c_bfb.tgJ);
            w.d("MicroMsg.NetSceneThrowBottle", "getThrowCount " + com_tencent_mm_protocal_c_bfb.tCS);
            w.d("MicroMsg.NetSceneThrowBottle", "getPickCount " + com_tencent_mm_protocal_c_bfb.tCT);
            w.d("MicroMsg.NetSceneThrowBottle", "getDistance " + com_tencent_mm_protocal_c_bfb.tVi);
            w.d("MicroMsg.NetSceneThrowBottle", "getBottleList " + com_tencent_mm_protocal_c_bfb.ufx.size());
            for (int i4 = 0; i4 < com_tencent_mm_protocal_c_bfb.ufx.size(); i4++) {
                w.d("MicroMsg.NetSceneThrowBottle", "bott id:" + com_tencent_mm_protocal_c_bfb.ufx.get(i4));
            }
            if (com_tencent_mm_protocal_c_bfa.mtd == 1) {
                this.gUD.a(i2, i3, str, this);
                jR(1);
                return;
            }
            this.jVf += com_tencent_mm_protocal_c_bfa.tsM.tZn;
            if (this.jVf >= com_tencent_mm_protocal_c_bfa.tgJ) {
                c.jP(com_tencent_mm_protocal_c_bfb.tCT);
                c.jO(com_tencent_mm_protocal_c_bfb.tCS);
                jR(3);
                q.lW(com_tencent_mm_protocal_c_bfa.tON);
                this.gUD.a(i2, i3, str, this);
                return;
            } else if (a(this.hsD, this.gUD) == -1) {
                this.gUD.a(3, -1, "doScene failed", this);
                return;
            } else {
                return;
            }
        }
        w.d("MicroMsg.NetSceneThrowBottle", "ERR: onGYNetEnd errtype:" + i2 + " errCode:" + i3);
        q.lW(com_tencent_mm_protocal_c_bfa.tON);
        this.gUD.a(i2, i3, str, this);
    }

    public final int adu() {
        return ((bfb) this.gUA.hsk.hsr).tVi;
    }

    private int jR(int i) {
        a aVar = new a();
        aVar.msgType = i;
        bfa com_tencent_mm_protocal_c_bfa = (bfa) this.gUA.hsj.hsr;
        bfb com_tencent_mm_protocal_c_bfb = (bfb) this.gUA.hsk.hsr;
        aVar.jUX = com_tencent_mm_protocal_c_bfb.ufx.size();
        aVar.jUZ = 1;
        if (i == 3) {
            aVar.content = com_tencent_mm_protocal_c_bfa.tON;
            aVar.jVa = com_tencent_mm_protocal_c_bfa.tue;
        } else {
            aVar.content = new String(n.a(com_tencent_mm_protocal_c_bfa.tsM));
        }
        String str = "";
        for (int i2 = 0; i2 < com_tencent_mm_protocal_c_bfb.ufx.size(); i2++) {
            str = str + com_tencent_mm_protocal_c_bfb.ufx.get(i2);
        }
        aVar.jUW = com.tencent.mm.a.g.n(str.getBytes());
        aVar.jVb = bg.Nz();
        for (int i3 = 0; i3 < com_tencent_mm_protocal_c_bfb.ufx.size(); i3++) {
            String rX = c.rX(n.a((avx) com_tencent_mm_protocal_c_bfb.ufx.get(i3)));
            if (!bg.mA(rX)) {
                aVar.jUY = rX;
                i.adw().a(aVar);
            }
        }
        return 0;
    }

    public final int getType() {
        return JsApiMakeVoIPCall.CTRL_INDEX;
    }
}
