package com.tencent.mm.plugin.luckymoney.sns.b;

import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.wallet_core.f.a.h;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a extends h {
    public int nqh = 0;

    public a(int i, String str, String str2) {
        Map hashMap = new HashMap();
        hashMap.put("flag", String.valueOf(i));
        hashMap.put("passwd", str);
        hashMap.put("req_key", str2);
        this.nqh = i;
        x(hashMap);
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/snspaymanage";
    }

    public final int zi() {
        return 1697;
    }

    public final int aki() {
        return 1697;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        w.i("MicroMsg.NetSceneSnsPayManage", " errCode: " + i + " errMsg :" + str);
        if (i != 0) {
            w.e("MicroMsg.NetSceneSnsPayManage", "onGYNetEnd() NetSceneSnsPayManage is false!");
        } else if (this.nqh == 1) {
            com.tencent.mm.plugin.luckymoney.sns.c.a.oS(1);
            w.i("MicroMsg.NetSceneSnsPayManage", "onGYNetEnd() setIsOpenSnsPay with 1");
        } else {
            com.tencent.mm.plugin.luckymoney.sns.c.a.oS(0);
            w.i("MicroMsg.NetSceneSnsPayManage", "onGYNetEnd() setIsOpenSnsPay with 0");
        }
    }
}
