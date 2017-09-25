package com.tencent.mm.plugin.remittance.c;

import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.wallet_core.b.a.a;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class c extends a {
    public String oQk;

    public c(long j, String str, String str2, String str3, String str4, String str5, int i, int i2) {
        Map hashMap = new HashMap();
        hashMap.put("amount", String.valueOf(j));
        hashMap.put("recv_username", str);
        hashMap.put("recv_nickname", str2);
        hashMap.put("qrcodeid", str5);
        try {
            if (!bg.mA(str3)) {
                hashMap.put("desc", URLEncoder.encode(str3, "UTF-8"));
            }
            if (!bg.mA(str4)) {
                hashMap.put("message", URLEncoder.encode(str4, "UTF-8"));
            }
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.NetSceneH5F2fTransferPay", e, "", new Object[0]);
        }
        hashMap.put("currency", String.valueOf(i));
        hashMap.put("set_amount", String.valueOf(i2));
        x(hashMap);
        w.i("MicroMsg.NetSceneH5F2fTransferPay", "username: %s, nickname: %s, amount: %s, desc: %s, msg: %s, currency: %s", new Object[]{str, str2, Long.valueOf(j), str3, str4, Integer.valueOf(i)});
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        this.oQk = jSONObject.optString("payurl", "");
        w.i("MicroMsg.NetSceneH5F2fTransferPay", "payurl: %s", new Object[]{this.oQk});
    }

    public final String akf() {
        return "/cgi-bin/mmpay-bin/h5f2ftransferpay";
    }

    public final int getType() {
        return 1529;
    }

    public final int akg() {
        return 1529;
    }
}
