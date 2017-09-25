package com.tencent.mm.plugin.bottle.a;

import com.tencent.mm.a.g;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.modelvoice.a;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.modelvoice.u;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.aor;
import com.tencent.mm.protocal.c.aos;
import com.tencent.mm.protocal.c.mj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.y.b;
import com.tencent.mm.y.k;

public final class e extends k implements j {
    private String fyF = "";
    private b gUA;
    private com.tencent.mm.y.e gUD;
    private String jVe = "";
    private int jVf = 0;
    private a jVg = null;
    private int msgType = 0;

    public e(String str, int i) {
        b.a aVar = new b.a();
        aVar.hsm = new aor();
        aVar.hsn = new aos();
        aVar.uri = "/cgi-bin/micromsg-bin/openbottle";
        aVar.hsl = 156;
        aVar.hso = 55;
        aVar.hsp = 1000000055;
        this.gUA = aVar.BE();
        this.jVe = str;
        this.msgType = i;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.y.e eVar2) {
        this.gUD = eVar2;
        aor com_tencent_mm_protocal_c_aor = (aor) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_aor.mtd = this.msgType;
        com_tencent_mm_protocal_c_aor.tTL = this.jVe;
        if (com_tencent_mm_protocal_c_aor.tTM == null) {
            com_tencent_mm_protocal_c_aor.tTM = new mj();
        }
        if (com_tencent_mm_protocal_c_aor.tTN == null) {
            com_tencent_mm_protocal_c_aor.tTN = new mj();
        }
        if (this.msgType == 1) {
            com_tencent_mm_protocal_c_aor.tTM.tgK = 0;
            com_tencent_mm_protocal_c_aor.tTM.tsL = 0;
        } else if (this.msgType != 3) {
            w.e("MicroMsg.NetSceneOpenBottle", "doScene Error Msg type" + this.msgType);
            return -1;
        }
        return a(eVar, this.gUA, this);
    }

    protected final int a(p pVar) {
        aor com_tencent_mm_protocal_c_aor = (aor) ((b) pVar).hsj.hsr;
        if (com_tencent_mm_protocal_c_aor.mtd == 1) {
            return k.b.hsT;
        }
        if (com_tencent_mm_protocal_c_aor.mtd != 3) {
            return k.b.hsU;
        }
        if (com_tencent_mm_protocal_c_aor.tTM == null) {
            w.d("MicroMsg.NetSceneOpenBottle", "ERR: securityVerificationChecked errtype: rImpl.getBigContentInfo() == null");
            return k.b.hsU;
        } else if (com_tencent_mm_protocal_c_aor.tTM.tsL == 0 && com_tencent_mm_protocal_c_aor.tTM.tgK == 0) {
            return k.b.hsT;
        } else {
            if (com_tencent_mm_protocal_c_aor.tTM.tsL <= com_tencent_mm_protocal_c_aor.tTM.tgK) {
                return k.b.hsU;
            }
            return k.b.hsT;
        }
    }

    protected final int ub() {
        return 10;
    }

    private int ads() {
        aor com_tencent_mm_protocal_c_aor = (aor) this.gUA.hsj.hsr;
        aos com_tencent_mm_protocal_c_aos = (aos) this.gUA.hsk.hsr;
        a aVar = new a();
        aVar.msgType = com_tencent_mm_protocal_c_aor.mtd;
        aVar.jUX = 0;
        aVar.jUZ = 2;
        aVar.jUY = c.rX(com_tencent_mm_protocal_c_aor.tTL);
        aVar.jVb = bg.Nz();
        aVar.jUW = g.n(com_tencent_mm_protocal_c_aor.tTL.getBytes());
        if (this.msgType == 3) {
            aVar.content = this.fyF;
            aVar.jVa = com_tencent_mm_protocal_c_aos.tue;
        } else {
            aVar.content = new String(com_tencent_mm_protocal_c_aos.tTP.tsM.tZp.sYA);
        }
        i.adw().a(aVar);
        return 0;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneOpenBottle", "onGYNetEnd errtype:" + i2 + " errCode:" + i3);
        if (i2 == 0 && i3 == 0) {
            aor com_tencent_mm_protocal_c_aor = (aor) this.gUA.hsj.hsr;
            aos com_tencent_mm_protocal_c_aos = (aos) this.gUA.hsk.hsr;
            if (this.msgType == 1) {
                ads();
                ce auVar = new au();
                auVar.cH(com_tencent_mm_protocal_c_aor.tTL);
                auVar.setContent(n.b(com_tencent_mm_protocal_c_aos.tTP.tsM));
                auVar.z(bg.Nz());
                auVar.dw(0);
                auVar.dv(3);
                auVar.setType(c.jQ(com_tencent_mm_protocal_c_aor.mtd));
                ap.yY();
                c.wT().L(auVar);
                w.d("MicroMsg.NetSceneOpenBottle", "onGYNetEnd :" + auVar.field_content);
                this.gUD.a(i2, i3, str, this);
                return;
            }
            if (bg.mA(this.fyF)) {
                this.fyF = u.mf(this.jVe);
                this.jVg = new a(q.js(this.fyF));
                this.jVf = 0;
            }
            if (com_tencent_mm_protocal_c_aos.tTP.tsL < com_tencent_mm_protocal_c_aos.tTP.tgK + com_tencent_mm_protocal_c_aos.tTP.tsM.tZn) {
                w.e("MicroMsg.NetSceneOpenBottle", "onGYNetEnd tot:" + com_tencent_mm_protocal_c_aos.tTP.tsL + " start:" + com_tencent_mm_protocal_c_aos.tTP.tgK + " len:" + com_tencent_mm_protocal_c_aos.tTP.tsM.tZn);
                this.gUD.a(3, -1, str, this);
                return;
            } else if (com_tencent_mm_protocal_c_aos.tTP.tgK != this.jVf) {
                w.e("MicroMsg.NetSceneOpenBottle", "onGYNetEnd start:" + com_tencent_mm_protocal_c_aos.tTP.tgK + " off:" + this.jVf);
                this.gUD.a(3, -1, str, this);
                return;
            } else {
                int write = this.jVg.write(com_tencent_mm_protocal_c_aos.tTP.tsM.tZp.sYA, com_tencent_mm_protocal_c_aos.tTP.tsM.tZn, com_tencent_mm_protocal_c_aos.tTP.tgK);
                if (write != com_tencent_mm_protocal_c_aos.tTP.tsM.tZn + com_tencent_mm_protocal_c_aos.tTP.tgK) {
                    w.e("MicroMsg.NetSceneOpenBottle", "onGYNetEnd start:" + com_tencent_mm_protocal_c_aos.tTP.tgK + " len:" + com_tencent_mm_protocal_c_aos.tTP.tsM.tZn + " writeRet:" + write);
                    this.gUD.a(3, -1, str, this);
                    return;
                }
                this.jVf = write;
                if (com_tencent_mm_protocal_c_aos.tTP.tsL <= this.jVf) {
                    ads();
                    au auVar2 = new au();
                    auVar2.cH(com_tencent_mm_protocal_c_aor.tTL);
                    auVar2.setContent(com.tencent.mm.modelvoice.n.b("bottle", (long) com_tencent_mm_protocal_c_aos.tue, false));
                    auVar2.cI(this.fyF);
                    auVar2.z(bg.Nz());
                    auVar2.dw(0);
                    auVar2.dv(3);
                    auVar2.setType(c.jQ(com_tencent_mm_protocal_c_aor.mtd));
                    ap.yY();
                    c.wT().L(auVar2);
                    w.d("MicroMsg.NetSceneOpenBottle", "voice :" + com_tencent_mm_protocal_c_aos.tue + " file:" + this.fyF);
                    this.gUD.a(i2, i3, str, this);
                    return;
                } else if (a(this.hsD, this.gUD) == -1) {
                    this.gUD.a(3, -1, "doScene failed", this);
                    return;
                } else {
                    return;
                }
            }
        }
        w.d("MicroMsg.NetSceneOpenBottle", "ERR: onGYNetEnd errtype:" + i2 + " errCode:" + i3);
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 156;
    }
}
