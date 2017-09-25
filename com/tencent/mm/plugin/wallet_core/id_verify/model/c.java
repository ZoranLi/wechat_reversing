package com.tencent.mm.plugin.wallet_core.id_verify.model;

import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.wallet_core.f.a.h;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class c extends h {
    public c(String str, String str2, int i) {
        this(str, str2, i, (byte) 0);
    }

    private c(String str, String str2, int i, byte b) {
        Map hashMap = new HashMap();
        hashMap.put("flag", "1");
        hashMap.put("passwd", str);
        hashMap.put("token", str2);
        hashMap.put("realname_scene", String.valueOf(i));
        w.i("MicroMsg.NetSceneRealNameReg", "realname_scene=%d", new Object[]{Integer.valueOf(i)});
        x(hashMap);
    }

    public final int aki() {
        return 1648;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        w.i("MicroMsg.NetSceneRealNameReg", "errCode=" + str + ";errMsg=" + str);
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/realnamereg";
    }

    public final int zi() {
        return 1648;
    }
}
