package com.tencent.mm.plugin.remittance.c;

import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.wallet_core.f.a.h;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class e extends h {
    public e(String str, String str2) {
        Map hashMap = new HashMap();
        hashMap.put("receiver_user_name", str);
        hashMap.put("transfer_qrcode_id", str2);
        x(hashMap);
    }

    public final int aki() {
        return 0;
    }

    public final int zi() {
        return 1535;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/transfersendcancelf2f";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        w.d("MicroMsg.NetSenceTenPayBase", "errCode " + i + " errMsg: " + str);
        if (i == 0) {
        }
    }
}
