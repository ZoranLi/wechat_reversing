package com.tencent.mm.plugin.wallet_payu.remittance.a;

import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class g extends a {
    public g(String str, String str2) {
        Map hashMap = new HashMap();
        hashMap.put("receiver_user_name", str);
        hashMap.put("transfer_qrcode_id", str2);
        x(hashMap);
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        w.d("MicroMsg.NetScenePayURemittanceSendCancelMsg", "errCode " + i + " errMsg: " + str);
        if (i == 0) {
        }
    }

    public final int btw() {
        return 27;
    }
}
