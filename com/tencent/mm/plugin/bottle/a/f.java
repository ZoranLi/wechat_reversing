package com.tencent.mm.plugin.bottle.a;

import com.tencent.mm.e.b.af;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.aqn;
import com.tencent.mm.protocal.c.aqo;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.x.h;
import com.tencent.mm.x.n;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.Map;

public final class f extends k implements j {
    private final b gUA;
    private e gUD;
    boolean jVh = false;

    public f() {
        a aVar = new a();
        aVar.hsm = new aqn();
        aVar.hsn = new aqo();
        aVar.uri = "/cgi-bin/micromsg-bin/pickbottle";
        aVar.hsl = 155;
        aVar.hso = 54;
        aVar.hsp = 1000000054;
        this.gUA = aVar.BE();
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final int getType() {
        return 155;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetScenePickBottle", "onGYNetEnd type:" + i2 + " code:" + i3);
        if (i2 == 4 && (i3 == -2002 || i3 == -56)) {
            c.jO(0);
            c.jP(0);
        }
        aqo com_tencent_mm_protocal_c_aqo = (aqo) this.gUA.hsk.hsr;
        if (i2 == 4) {
            switch (i3) {
                case -56:
                    break;
                default:
                    c.jP(com_tencent_mm_protocal_c_aqo.tCT);
                    c.jO(com_tencent_mm_protocal_c_aqo.tCS);
                    break;
            }
        }
        if (i2 == 0 && i3 == 0) {
            this.jVh = true;
            w.d("MicroMsg.NetScenePickBottle", "bottle pack:pack:" + com_tencent_mm_protocal_c_aqo.tCT + " throw:" + com_tencent_mm_protocal_c_aqo.tCS);
            String[] strArr = null;
            if (com_tencent_mm_protocal_c_aqo.tTL != null) {
                strArr = com_tencent_mm_protocal_c_aqo.tTL.split(":");
            }
            if (strArr != null && strArr.length >= 2) {
                String str2 = strArr[0];
                ap.yY();
                af Rc = c.wR().Rc(str2);
                if (Rc == null || !Rc.field_username.equals(str2)) {
                    af xVar = new x();
                    xVar.setUsername(str2);
                    xVar.bR(com_tencent_mm_protocal_c_aqo.jOp == null ? "" : com_tencent_mm_protocal_c_aqo.jOp);
                    xVar.dh(3);
                    h hVar = new h();
                    hVar.username = str2;
                    hVar.gkq = 3;
                    hVar.aV(true);
                    hVar.fRW = -1;
                    try {
                        Map q = bh.q(com_tencent_mm_protocal_c_aqo.tEP, "userinfo");
                        if (q != null) {
                            xVar.di(bg.getInt((String) q.get(".userinfo.$sex"), 0));
                            xVar.ce((String) q.get(".userinfo.$signature"));
                            xVar.ck(RegionCodeDecoder.ab((String) q.get(".userinfo.$country"), (String) q.get(".userinfo.$province"), (String) q.get(".userinfo.$city")));
                            w.d("MicroMsg.NetScenePickBottle", "user:" + str2 + " sig:" + xVar.signature + " sex" + xVar.gkr + " city:" + xVar.getCity() + " prov:" + xVar.getProvince());
                            hVar.hrB = (String) q.get(".userinfo.$bigheadimgurl");
                            hVar.hrA = (String) q.get(".userinfo.$smallheadimgurl");
                            hVar.fRW = -1;
                            w.d("MicroMsg.NetScenePickBottle", "dkhurl user:[%s] big:[%s] sm:[%s]", new Object[]{str2, hVar.Bs(), hVar.Bt()});
                        }
                    } catch (Exception e) {
                        w.e("MicroMsg.NetScenePickBottle", "Set Contact failed " + e.getMessage() + " user:" + str2);
                    }
                    ap.yY();
                    c.wR().P(xVar);
                    n.Bm().a(hVar);
                }
            }
            w.d("MicroMsg.NetScenePickBottle", "getBottleType " + com_tencent_mm_protocal_c_aqo.tVg);
            w.d("MicroMsg.NetScenePickBottle", "getMsgType " + com_tencent_mm_protocal_c_aqo.mtd);
            w.d("MicroMsg.NetScenePickBottle", "getBottleInfo " + com_tencent_mm_protocal_c_aqo.tTL);
            w.d("MicroMsg.NetScenePickBottle", "getUserInfo " + com_tencent_mm_protocal_c_aqo.tEP);
            w.d("MicroMsg.NetScenePickBottle", "getNickName " + com_tencent_mm_protocal_c_aqo.jOp);
            w.d("MicroMsg.NetScenePickBottle", "getUserStatus " + com_tencent_mm_protocal_c_aqo.tVh);
            w.d("MicroMsg.NetScenePickBottle", "getThrowCount " + com_tencent_mm_protocal_c_aqo.tCS);
            w.d("MicroMsg.NetScenePickBottle", "getPickCount " + com_tencent_mm_protocal_c_aqo.tCT);
            w.d("MicroMsg.NetScenePickBottle", "getDistance " + com_tencent_mm_protocal_c_aqo.tVi);
        } else if (i3 == -56) {
            c.jP(com_tencent_mm_protocal_c_aqo.tCT);
            c.jP(com_tencent_mm_protocal_c_aqo.tCS);
        }
        this.gUD.a(i2, i3, str, this);
    }

    final aqo adt() {
        return (aqo) this.gUA.hsk.hsr;
    }
}
