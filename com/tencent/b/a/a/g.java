package com.tencent.b.a.a;

import org.json.JSONException;
import org.json.JSONObject;

final class g {
    String aMq = null;
    String aQl = null;
    String aQm = "0";
    long aQn = 0;

    g() {
    }

    static g aI(String str) {
        g gVar = new g();
        if (s.aJ(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (!jSONObject.isNull("ui")) {
                    gVar.aMq = jSONObject.getString("ui");
                }
                if (!jSONObject.isNull("mc")) {
                    gVar.aQl = jSONObject.getString("mc");
                }
                if (!jSONObject.isNull("mid")) {
                    gVar.aQm = jSONObject.getString("mid");
                }
                if (!jSONObject.isNull("ts")) {
                    gVar.aQn = jSONObject.getLong("ts");
                }
            } catch (JSONException e) {
            }
        }
        return gVar;
    }

    final int a(g gVar) {
        if (gVar == null) {
            return 1;
        }
        if (s.aK(this.aQm) && s.aK(gVar.aQm)) {
            if (this.aQm.equals(gVar.aQm)) {
                return 0;
            }
            if (this.aQn < gVar.aQn) {
                return -1;
            }
            return 1;
        } else if (s.aK(this.aQm)) {
            return 1;
        } else {
            return -1;
        }
    }

    public final String toString() {
        return nN().toString();
    }

    private JSONObject nN() {
        JSONObject jSONObject = new JSONObject();
        try {
            s.a(jSONObject, "ui", this.aMq);
            s.a(jSONObject, "mc", this.aQl);
            s.a(jSONObject, "mid", this.aQm);
            jSONObject.put("ts", this.aQn);
        } catch (JSONException e) {
        }
        return jSONObject;
    }
}
