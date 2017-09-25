package com.tencent.mm.plugin.wallet_core.id_verify.model;

import com.tencent.mm.network.e;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.protocal.c.bey;
import com.tencent.mm.protocal.c.bez;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.wallet_core.c.g;
import com.tencent.mm.wallet_core.c.l;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tenpay.android.wechat.TenpayUtil;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class d extends g {
    public String token;

    public d(String str, String str2, int i) {
        Map hashMap = new HashMap();
        hashMap.put("flag", "1");
        hashMap.put("true_name", str);
        hashMap.put("identify_card", str2);
        hashMap.put("cre_type", "1");
        hashMap.put("realname_scene", String.valueOf(i));
        w.i("MicroMsg.NetSceneRealNameVerify", "realname_scene=%d", new Object[]{Integer.valueOf(i)});
        x(hashMap);
    }

    public final int bti() {
        return 0;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        if (i == 0) {
            this.token = jSONObject.optString("token");
        }
    }

    public final void y(boolean z, boolean z2) {
        b bVar = this.gUA;
        if (bVar == null) {
            a aVar = new a();
            aVar.hsm = new bey();
            aVar.hsn = new bez();
            aVar.uri = "/cgi-bin/mmpay-bin/tenpay/realnameauthen";
            aVar.hsl = 1616;
            aVar.hso = 185;
            aVar.hsp = 1000000185;
            bVar = aVar.BE();
            bVar.hsA = true;
        }
        b bVar2 = bVar;
        bey com_tencent_mm_protocal_c_bey = (bey) bVar2.hsj.hsr;
        if (z2) {
            com_tencent_mm_protocal_c_bey.tKl = 1;
        }
        this.gUA = bVar2;
    }

    public final String HP(String str) {
        return TenpayUtil.signWith3Des(str);
    }

    public final void a(b bVar, avw com_tencent_mm_protocal_c_avw) {
        ((bey) bVar.hsj.hsr).tKm = com_tencent_mm_protocal_c_avw;
    }

    public final void b(b bVar, avw com_tencent_mm_protocal_c_avw) {
        ((bey) bVar.hsj.hsr).tUZ = com_tencent_mm_protocal_c_avw;
    }

    public final l c(b bVar) {
        bez com_tencent_mm_protocal_c_bez = (bez) bVar.hsk.hsr;
        l lVar = new l();
        lVar.tKq = com_tencent_mm_protocal_c_bez.tKq;
        lVar.tKp = com_tencent_mm_protocal_c_bez.tKp;
        lVar.tKo = com_tencent_mm_protocal_c_bez.tKo;
        lVar.tKn = com_tencent_mm_protocal_c_bez.tKn;
        lVar.leS = com_tencent_mm_protocal_c_bez.tVb;
        lVar.wEg = com_tencent_mm_protocal_c_bez.tVa;
        return lVar;
    }

    public final int getType() {
        return 1616;
    }

    public final int a(e eVar, com.tencent.mm.y.e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }
}
