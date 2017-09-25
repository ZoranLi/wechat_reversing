package com.tencent.mm.plugin.remittance.c;

import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.wallet_core.b.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class b extends a {
    public b(String str, String str2, int i, long j, int i2) {
        Map hashMap = new HashMap();
        hashMap.put("recv_username", str);
        hashMap.put("qrcodeid", str2);
        hashMap.put("currency", String.valueOf(i));
        hashMap.put("amount", String.valueOf(j));
        hashMap.put("set_amount", String.valueOf(i2));
        x(hashMap);
        w.i("MicroMsg.NetSceneH5F2fTransferCancelPay", "qrcodeId: %s, currency: %s", new Object[]{str2, Integer.valueOf(i)});
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        w.d("MicroMsg.NetSceneH5F2fTransferCancelPay", "json: %s", new Object[]{jSONObject.toString()});
        w.i("MicroMsg.NetSceneH5F2fTransferCancelPay", "errCode: %s, errMsg: %s", new Object[]{Integer.valueOf(i), str});
    }

    public final String akf() {
        return "/cgi-bin/mmpay-bin/h5f2ftransfercancelpay";
    }

    public final int getType() {
        return 1257;
    }

    public final int akg() {
        return 1257;
    }
}
