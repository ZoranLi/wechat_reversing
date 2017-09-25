package com.tencent.mm.modelsimple;

import android.os.Build.VERSION;
import android.provider.Settings.System;
import com.tencent.mm.e.a.qz;
import com.tencent.mm.e.a.rb;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.aak;
import com.tencent.mm.protocal.c.aal;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ao;
import com.tencent.mm.u.m;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class r extends k implements j {
    private b gUA;
    private e gUD;
    private String hSs;

    public r(String str) {
        this.hSs = str;
        a aVar = new a();
        aVar.hsm = new aak();
        aVar.hsn = new aal();
        aVar.uri = "/cgi-bin/micromsg-bin/getprofile";
        this.gUA = aVar.BE();
        ((aak) this.gUA.hsj.hsr).jNj = str;
    }

    public final int getType() {
        return 302;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        if (bg.mA(this.hSs)) {
            w.e("MicroMsg.NetSceneGetProfile", "null or empty username");
            return -1;
        }
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneGetProfile", "get profile ret: errType=" + i2 + " errCode=" + i3 + " errMsg=" + str);
        if (i2 == 0 && i3 == 0) {
            aal com_tencent_mm_protocal_c_aal = (aal) this.gUA.hsk.hsr;
            com.tencent.mm.sdk.b.b rbVar = new rb();
            rbVar.fYa.fYb = com_tencent_mm_protocal_c_aal;
            com.tencent.mm.sdk.b.a.urY.m(rbVar);
            rbVar = new qz();
            rbVar.fXY.fXZ = com_tencent_mm_protocal_c_aal.tGp.uil;
            com.tencent.mm.sdk.b.a.urY.m(rbVar);
            if (m.xL().equals(com_tencent_mm_protocal_c_aal.tGo.ttp.toString()) && !bg.mA(com_tencent_mm_protocal_c_aal.tGp.tqc)) {
                h.vI().vr().a(com.tencent.mm.storage.w.a.USERINFO_SELFINFO_SMALLIMGURL_STRING, com_tencent_mm_protocal_c_aal.tGp.tqc);
            }
            w.d("MicroMsg.NetSceneGetProfile", "summersafecdn resp.UserInfo.PluginSwitch[%d], GrayscaleFlag[%d]", Integer.valueOf(com_tencent_mm_protocal_c_aal.tGo.tRy), Integer.valueOf(com_tencent_mm_protocal_c_aal.tGp.uif));
            h.vI().vr().set(64, Integer.valueOf(com_tencent_mm_protocal_c_aal.tGp.tdE));
            h.vI().vr().set(144385, Integer.valueOf(com_tencent_mm_protocal_c_aal.tGp.uif));
            h.vI().vr().set(40, Integer.valueOf(com_tencent_mm_protocal_c_aal.tGo.tRy));
            h.vI().vr().set(339975, Integer.valueOf(com_tencent_mm_protocal_c_aal.tGp.uio));
            w.i("MicroMsg.NetSceneGetProfile", "hy: getprofile pay wallet type: %d", Integer.valueOf(com_tencent_mm_protocal_c_aal.tGp.uio));
            h.vI().vr().a(com.tencent.mm.storage.w.a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, Integer.valueOf(com_tencent_mm_protocal_c_aal.tGp.uip));
            w.i("MicroMsg.NetSceneGetProfile", "hy: getprofile pay wallet type: %d %d", Integer.valueOf(com_tencent_mm_protocal_c_aal.tGp.uio), Integer.valueOf(com_tencent_mm_protocal_c_aal.tGp.uip));
            h.vI().vr().set(208903, com_tencent_mm_protocal_c_aal.tGp.tjl);
            h.vI().vr().set(274433, com_tencent_mm_protocal_c_aal.tGp.tQN);
            h.vI().vr().set(274434, com_tencent_mm_protocal_c_aal.tGp.tQM);
            h.vI().vr().set(274436, com_tencent_mm_protocal_c_aal.tGp.uig);
            h.vI().vr().a(com.tencent.mm.storage.w.a.USERINFO_PROFILE_WEIDIANINFO_STRING, bg.ap(com_tencent_mm_protocal_c_aal.tGp.gkP, ""));
            h.vI().vr().a(com.tencent.mm.storage.w.a.USERINFO_F2F_RING_TONE_STRING, com_tencent_mm_protocal_c_aal.tGp.uir);
            w.d("MicroMsg.NetSceneGetProfile", "weidianInfo:%s", com_tencent_mm_protocal_c_aal.tGp.gkP);
            ao.hlW.L("last_login_use_voice", com_tencent_mm_protocal_c_aal.tGo.tRy);
            if (VERSION.SDK_INT < 23) {
                System.putString(ab.getContext().getContentResolver(), "89884a87498ef44f", com_tencent_mm_protocal_c_aal.tGp.uim);
            }
        }
        this.gUD.a(i2, i3, str, this);
    }
}
