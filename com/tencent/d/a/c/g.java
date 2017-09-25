package com.tencent.d.a.c;

import org.json.JSONException;
import org.json.JSONObject;

public final class g {
    public String qPZ = "";
    public String signature = "";
    public int uid = -1;
    private long wZC = -1;
    private String wZD = "";
    public String wZE = "";

    public final String toString() {
        return "SoterPubKeyModel{counter=" + this.wZC + ", uid=" + this.uid + ", cpu_id='" + this.qPZ + '\'' + ", pub_key_in_x509='" + this.wZD + '\'' + ", rawJson='" + this.wZE + '\'' + ", signature='" + this.signature + '\'' + '}';
    }

    public g(String str, String str2) {
        this.wZE = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.wZC = jSONObject.optLong("counter");
            this.uid = jSONObject.optInt("uid");
            this.qPZ = jSONObject.optString("cpu_id");
            this.wZD = jSONObject.optString("pub_key");
        } catch (JSONException e) {
            c.e("Soter.SoterPubKeyModel", "soter: pub key model failed", new Object[0]);
        }
        this.signature = str2;
    }
}
