package com.tencent.mm.plugin.recharge.model;

import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import org.json.JSONObject;

public final class a {
    public static final int[] oKR = new int[]{-1, -1};
    public static final int[] oKS = new int[]{-2, -2};
    public int fFq;
    public String name;
    public String oKT;
    public String oKU;
    public int[] oKV;

    public a(String str, String str2, int i) {
        this(str, str2, "", i);
    }

    public a(String str, String str2, String str3, int i) {
        this.oKV = oKR;
        this.oKT = str;
        this.name = str2;
        this.oKU = str3;
        this.fFq = i;
    }

    public final JSONObject aWg() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("record", bg.ap(this.oKT, ""));
            jSONObject.put("name", bg.ap(this.name, ""));
            jSONObject.put("location", bg.ap(this.oKU, ""));
            return jSONObject;
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.MallInputRecord", e, "", new Object[0]);
            return null;
        }
    }

    public static a I(JSONObject jSONObject) {
        String optString = jSONObject.optString("name");
        String optString2 = jSONObject.optString("record");
        String optString3 = jSONObject.optString("location");
        if (bg.mA(optString2)) {
            return null;
        }
        return new a(optString2, optString, optString3, 2);
    }
}
