package com.tencent.mm.modelsimple;

import com.tencent.mm.kernel.h;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.aj;
import com.tencent.mm.protocal.c.bdk;
import com.tencent.mm.protocal.c.bdl;
import com.tencent.mm.protocal.c.bdm;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.m;
import com.tencent.mm.u.o;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class ag extends k implements j {
    private final b gUA;
    private e gUD;
    private final String toUserName;

    public static void C(String str, int i) {
        if (bg.mA(str) || !h.vG().uV()) {
            return;
        }
        if (!o.fE(str) || o.eZ(str)) {
            h.vH().gXC.a(new ag(str, i), 0);
        }
    }

    public static void a(String str, int i, String str2, String str3) {
        if (!bg.mA(str) && !o.fE(str) && h.vG().uV()) {
            h.vH().gXC.a(new ag(str, i, str2, str3), 0);
        }
    }

    public ag(String str, int i) {
        this.toUserName = str;
        a aVar = new a();
        aVar.hsm = new bdl();
        aVar.hsn = new bdm();
        aVar.uri = "/cgi-bin/micromsg-bin/statusnotify";
        aVar.hsl = aj.CTRL_BYTE;
        this.gUA = aVar.BE();
        bdl com_tencent_mm_protocal_c_bdl = (bdl) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_bdl.mvV = m.xL();
        com_tencent_mm_protocal_c_bdl.ueH = i;
        com_tencent_mm_protocal_c_bdl.mvU = str;
        com_tencent_mm_protocal_c_bdl.tfU = System.currentTimeMillis();
        w.d("MicroMsg.NetSceneStatusNotify", "toUserName = " + str);
    }

    private ag(String str, int i, String str2, String str3) {
        this.toUserName = str;
        a aVar = new a();
        aVar.hsm = new bdl();
        aVar.hsn = new bdm();
        aVar.uri = "/cgi-bin/micromsg-bin/statusnotify";
        aVar.hsl = aj.CTRL_BYTE;
        this.gUA = aVar.BE();
        bdl com_tencent_mm_protocal_c_bdl = (bdl) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_bdl.mvV = m.xL();
        com_tencent_mm_protocal_c_bdl.ueH = i;
        com_tencent_mm_protocal_c_bdl.mvU = str;
        com_tencent_mm_protocal_c_bdl.tfU = System.currentTimeMillis();
        com_tencent_mm_protocal_c_bdl.ueK = new bdk();
        com_tencent_mm_protocal_c_bdl.ueK.msj = str2;
        com_tencent_mm_protocal_c_bdl.ueK.ueG = str3;
    }

    public final int getType() {
        return aj.CTRL_BYTE;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        if (!(i2 == 0 && i3 == 0)) {
            w.d("MicroMsg.NetSceneStatusNotify", "StatusNotify Error. userName=" + this.toUserName);
        }
        this.gUD.a(i2, i3, str, this);
    }
}
