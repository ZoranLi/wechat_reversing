package com.tencent.mm.plugin.wallet_core.b;

import com.tencent.mm.plugin.wallet_core.model.m;
import com.tencent.mm.plugin.wallet_core.model.v;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.wallet_core.f.a.h;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public final class e extends h {
    public e() {
        x(new HashMap());
    }

    public final int aki() {
        return 1631;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        w.i("MicroMsg.NetSceneQueryUserWallet", "errCode is : " + i);
        if (i == 0) {
            m.btV().gUz.eE("WalletKindInfo", "delete from WalletKindInfo");
            if (jSONObject != null) {
                w.i("MicroMsg.NetSceneQueryUserWallet", "resp json " + jSONObject.toString());
                JSONArray optJSONArray = jSONObject.optJSONArray("UserWalletInfoList");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i2 = 0; i2 < length; i2++) {
                        c O = v.O(optJSONArray.optJSONObject(i2));
                        if (O != null) {
                            m.btV().b(O);
                        }
                    }
                    return;
                }
                w.e("MicroMsg.NetSceneQueryUserWallet", "wallet array is null");
                return;
            }
            w.e("MicroMsg.NetSceneQueryUserWallet", "response json is null");
        }
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/queryuserwallet";
    }

    public final int zi() {
        return 1631;
    }
}
