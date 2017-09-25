package com.tencent.mm.plugin.offline.a;

import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.wallet_core.f.a.h;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class o extends h {
    public o(int i, int i2, int i3, String str) {
        this(i, i2, i3, str, (byte) 0);
    }

    public o(int i, int i2) {
        this(i, i2, 0, "", (byte) 0);
    }

    private o(int i, int i2, int i3, String str, byte b) {
        Map hashMap = new HashMap();
        hashMap.put("residue_num", String.valueOf(i));
        hashMap.put("entry_scene", String.valueOf(i2));
        hashMap.put("is_snapshot", String.valueOf(i3));
        hashMap.put("user_view_digit", "0");
        StringBuilder stringBuilder = new StringBuilder();
        ap.yY();
        hashMap.put("code_ver", stringBuilder.append(c.vr().get(a.uzn, "")).toString());
        hashMap.put("card_id", com.tencent.mm.plugin.offline.c.a.kcJ);
        hashMap.put("user_card_id", com.tencent.mm.plugin.offline.c.a.oeY);
        hashMap.put("card_code", com.tencent.mm.plugin.offline.c.a.oeZ);
        hashMap.put("ext_business_attach", str);
        x(hashMap);
        w.i("MicroMsg.NetSceneTenpayWxOfflineShowCode", "hy: residue_num == %d, entryscene = %d,is_snapshot = %d, user_view_digit: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(0)});
        w.d("MicroMsg.NetSceneTenpayWxOfflineShowCode", "card_id=%s,  user_card_id=%s,  card_code:%s ", new Object[]{com.tencent.mm.plugin.offline.c.a.kcJ, com.tencent.mm.plugin.offline.c.a.oeY, com.tencent.mm.plugin.offline.c.a.oeZ});
    }

    public final int aki() {
        return 102;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
    }

    public final int zi() {
        return 572;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/offlineshowcode";
    }
}
