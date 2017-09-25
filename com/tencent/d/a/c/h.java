package com.tencent.d.a.c;

import org.json.JSONException;
import org.json.JSONObject;

public final class h {
    public String signature = "";
    private long wZC = -1;
    private String wZF = null;
    private String wZG = null;
    private String wZH = "";
    private String wZI = "";
    private String wZJ = "";
    private String wZK = "";
    private String wZL = "";
    public int wZM = 20;
    public String wZN = "";

    public final String toString() {
        return "SoterSignatureResult{rawValue='" + this.wZF + '\'' + ", fid='" + this.wZG + '\'' + ", counter=" + this.wZC + ", TEEName='" + this.wZH + '\'' + ", TEEVersion='" + this.wZI + '\'' + ", FpName='" + this.wZJ + '\'' + ", FpVersion='" + this.wZK + '\'' + ", cpuId='" + this.wZL + '\'' + ", saltLen=" + this.wZM + ", jsonValue='" + this.wZN + '\'' + ", signature='" + this.signature + '\'' + '}';
    }

    public static h VJ(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            h hVar = new h();
            hVar.wZN = str;
            hVar.wZF = jSONObject.optString("raw");
            hVar.wZG = jSONObject.optString("fid");
            hVar.wZC = jSONObject.optLong("counter");
            hVar.wZH = jSONObject.optString("tee_n");
            hVar.wZI = jSONObject.optString("tee_v");
            hVar.wZJ = jSONObject.optString("fp_n");
            hVar.wZK = jSONObject.optString("fp_v");
            hVar.wZL = jSONObject.optString("cpu_id");
            hVar.wZM = jSONObject.optInt("rsa_pss_saltlen", 20);
            return hVar;
        } catch (JSONException e) {
            c.e("Soter.SoterSignatureResult", "soter: convert from json failed." + e.toString(), new Object[0]);
            return null;
        }
    }
}
