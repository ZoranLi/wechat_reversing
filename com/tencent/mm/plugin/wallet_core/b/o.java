package com.tencent.mm.plugin.wallet_core.b;

import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.wallet_core.f.a.h;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class o extends h {
    public JSONObject nBw;
    public String rCd = "";

    public o(String str, String str2, String str3, String str4, String str5, String str6, long j) {
        this.rCd = str;
        Map hashMap = new HashMap();
        hashMap.put("activity_id", str);
        hashMap.put("award_id", str2);
        hashMap.put("send_record_id", str3);
        hashMap.put("user_record_id", str4);
        hashMap.put("req_key", str5);
        hashMap.put("transaction_id", str6);
        hashMap.put("activity_mch_id", String.valueOf(j));
        x(hashMap);
    }

    public final int aki() {
        return 1979;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/querypayaward";
    }

    public final int zi() {
        return 1979;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        w.i("MicroMsg.NetSceneTenpayQueryPayaward", "errcode %s errmsg %s json %s", new Object[]{Integer.valueOf(i), str, jSONObject});
        this.nBw = jSONObject;
    }

    public final boolean aQj() {
        return false;
    }
}
