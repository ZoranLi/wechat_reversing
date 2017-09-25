package com.tencent.mm.modelfriend;

import com.tencent.mm.R;
import com.tencent.mm.e.a.rb;
import com.tencent.mm.e.a.rc;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.gd;
import com.tencent.mm.protocal.c.ge;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class t extends k implements j {
    private String fMK;
    private String fMM;
    public final b gUA;
    private e gUD;

    public t(String str, int i, String str2, String str3, String str4, String str5) {
        this(str, i, str2, 0, str3);
        this.fMK = str4;
        this.fMM = str5;
        gd gdVar = (gd) this.gUA.hsj.hsr;
        gdVar.tjD = str4;
        gdVar.tjE = str5;
    }

    public t(String str, int i, String str2, int i2, String str3) {
        this.gUD = null;
        this.fMK = null;
        this.fMM = null;
        a aVar = new a();
        aVar.hsm = new gd();
        aVar.hsn = new ge();
        aVar.uri = "/cgi-bin/micromsg-bin/bindopmobile";
        aVar.hsl = 132;
        aVar.hso = 45;
        aVar.hsp = 1000000045;
        this.gUA = aVar.BE();
        gd gdVar = (gd) this.gUA.hsj.hsr;
        gdVar.thO = i;
        gdVar.tjA = i2;
        gdVar.tjB = str3;
        if (bg.mA(this.fMK) && bg.mA(this.fMM)) {
            gdVar.tjD = f.usw ? ab.getContext().getString(R.l.eNL) : ab.getContext().getString(R.l.eNK);
            gdVar.tjE = d.sYL;
        }
        if (str != null && str.length() > 0 && (i == 1 || i == 4 || i == 18)) {
            ap.yY();
            c.vr().set(4097, str);
        } else if (i == 2 || i == 19) {
            ap.yY();
            str = (String) c.vr().get(4097, null);
        } else if (i == 3) {
            ap.yY();
            str = (String) c.vr().get(6, null);
        }
        w.d("MicroMsg.NetSceneBindOpMobile", "Get mobile:" + str + " opcode:" + i + " verifyCode:" + str2);
        gdVar.tjy = str;
        gdVar.tjz = str2;
        gdVar.leO = v.bIN();
    }

    public final int AJ() {
        return ((gd) this.gUA.hsj.hsr).thO;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        gd gdVar = (gd) this.gUA.hsj.hsr;
        if (gdVar.tjy == null || gdVar.tjy.length() <= 0) {
            w.e("MicroMsg.NetSceneBindOpMobile", "doScene getMobile Error: " + gdVar.tjy);
            return -1;
        } else if ((gdVar.thO != 2 && gdVar.thO != 19) || (gdVar.tjz != null && gdVar.tjz.length() > 0)) {
            return a(eVar, this.gUA, this);
        } else {
            w.e("MicroMsg.NetSceneBindOpMobile", "doScene getVerifyCode Error: " + gdVar.tjy);
            return -1;
        }
    }

    public final int getType() {
        return 132;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        if (i2 == 0 && i3 == 0) {
            gd gdVar = (gd) this.gUA.hsj.hsr;
            ge geVar = (ge) this.gUA.hsk.hsr;
            w.d("MicroMsg.NetSceneBindOpMobile", "onGYNetEnd  errType:" + i2 + " errCode:" + i3 + " sms:" + geVar.tjI + "safedevice status = " + geVar.tdE);
            if (gdVar.thO == 2 || gdVar.thO == 4 || gdVar.thO == 11 || gdVar.thO == 19) {
                ap.yY();
                c.vr().set(4097, "");
                ap.yY();
                c.vr().set(6, gdVar.tjy);
                if (bg.mA(this.fMK) || bg.mA(this.fMM)) {
                    m.Fi();
                }
                if (!(bg.mA(this.fMK) || bg.mA(this.fMM))) {
                    com.tencent.mm.sdk.b.b rbVar = new rb();
                    rbVar.fYa.fYb = geVar;
                    com.tencent.mm.sdk.b.a.urY.m(rbVar);
                    ap.yY();
                    c.vr().set(64, Integer.valueOf(geVar.tdE));
                    com.tencent.mm.sdk.b.b rcVar = new rc();
                    rcVar.fYc.fYd = true;
                    rcVar.fYc.fYe = true;
                    com.tencent.mm.sdk.b.a.urY.m(rcVar);
                }
                if (gdVar.thO == 19) {
                    ap.yY();
                    c.vr().set(12322, null);
                }
                w.d("MicroMsg.NetSceneBindOpMobile", "onGYNetEnd  mobile binded");
            } else if (gdVar.thO == 3) {
                ap.yY();
                c.vr().set(4097, "");
                ap.yY();
                c.vr().set(6, "");
                ap.yY();
                c.vr().set(12322, null);
                ap.yY();
                c.vr().set(64, Integer.valueOf(geVar.tdE));
                com.tencent.mm.sdk.b.b rcVar2 = new rc();
                rcVar2.fYc.fYd = false;
                rcVar2.fYc.fYe = true;
                com.tencent.mm.sdk.b.a.urY.m(rcVar2);
                m.Fp();
                m.Fq();
                w.d("MicroMsg.NetSceneBindOpMobile", "onGYNetEnd  mobile unbinded");
            }
            this.gUD.a(i2, i3, str, this);
            return;
        }
        w.e("MicroMsg.NetSceneBindOpMobile", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        this.gUD.a(i2, i3, str, this);
    }
}
