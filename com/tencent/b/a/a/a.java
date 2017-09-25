package com.tencent.b.a.a;

import org.json.JSONException;
import org.json.JSONObject;

final class a {
    public static String aPR = "ts";
    public static String aPS = "times";
    public static String aPT = "mfreq";
    public static String aPU = "mdays";
    long aPN = 0;
    int aPO = 0;
    int aPP = 100;
    int aPQ = 3;

    a() {
    }

    a(String str) {
        if (s.aJ(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (!jSONObject.isNull(aPR)) {
                    this.aPN = jSONObject.getLong(aPR);
                }
                if (!jSONObject.isNull(aPT)) {
                    this.aPP = jSONObject.getInt(aPT);
                }
                if (!jSONObject.isNull(aPS)) {
                    this.aPO = jSONObject.getInt(aPS);
                }
                if (!jSONObject.isNull(aPU)) {
                    this.aPQ = jSONObject.getInt(aPU);
                }
            } catch (JSONException e) {
            }
        }
    }

    public final String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(aPR, this.aPN);
            jSONObject.put(aPS, this.aPO);
            jSONObject.put(aPT, this.aPP);
            jSONObject.put(aPU, this.aPQ);
        } catch (JSONException e) {
        }
        return jSONObject.toString();
    }
}
