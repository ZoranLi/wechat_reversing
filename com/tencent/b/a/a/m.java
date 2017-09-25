package com.tencent.b.a.a;

import android.content.Context;
import org.json.JSONArray;
import org.json.JSONObject;

final class m {
    private int aQx = 0;
    private JSONObject aQy = null;
    protected Context context = null;

    m(Context context, JSONObject jSONObject) {
        this.context = context;
        this.aQx = (int) (System.currentTimeMillis() / 1000);
        this.aQy = jSONObject;
    }

    final JSONObject nQ() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ky", "AVF4T76RVR81");
            jSONObject.put("et", 2);
            jSONObject.put("ts", this.aQx);
            jSONObject.put("si", this.aQx);
            s.a(jSONObject, "ui", s.V(this.context));
            s.a(jSONObject, "mc", s.W(this.context));
            String nP = i.R(this.context).nP();
            if (s.aK(nP)) {
                jSONObject.put("mid", nP);
            } else {
                jSONObject.put("mid", "0");
            }
            b bVar = new b(this.context);
            JSONObject jSONObject2 = new JSONObject();
            try {
                if (b.aPV != null) {
                    a aVar = b.aPV;
                    jSONObject2.put("sr", new StringBuilder(String.valueOf(aVar.aQa.widthPixels)).append("*").append(aVar.aQa.heightPixels).toString());
                    s.a(jSONObject2, "av", aVar.aPY);
                    s.a(jSONObject2, "ch", aVar.aQe);
                    s.a(jSONObject2, "mf", aVar.aQc);
                    s.a(jSONObject2, "sv", aVar.aPZ);
                    s.a(jSONObject2, "ov", Integer.toString(aVar.aQb));
                    jSONObject2.put("os", 1);
                    s.a(jSONObject2, "op", aVar.aQf);
                    s.a(jSONObject2, "lg", aVar.aQd);
                    s.a(jSONObject2, "md", aVar.model);
                    s.a(jSONObject2, "tz", aVar.timezone);
                    if (aVar.aQh != 0) {
                        jSONObject2.put("jb", aVar.aQh);
                    }
                    s.a(jSONObject2, "sd", aVar.aQg);
                    s.a(jSONObject2, "apn", aVar.packageName);
                    if (s.U(aVar.ctx)) {
                        JSONObject jSONObject3 = new JSONObject();
                        s.a(jSONObject3, "bs", s.X(aVar.ctx));
                        s.a(jSONObject3, "ss", s.Y(aVar.ctx));
                        if (jSONObject3.length() > 0) {
                            s.a(jSONObject2, "wf", jSONObject3.toString());
                        }
                    }
                    JSONArray Z = s.Z(aVar.ctx);
                    if (Z != null && Z.length() > 0) {
                        s.a(jSONObject2, "wflist", Z.toString());
                    }
                    s.a(jSONObject2, "ram", aVar.aQi);
                    s.a(jSONObject2, "rom", aVar.aQj);
                    s.a(jSONObject2, "im", aVar.imsi);
                }
                s.a(jSONObject2, "cn", bVar.aPX);
                if (bVar.aPW != null) {
                    jSONObject2.put("tn", bVar.aPW);
                }
                jSONObject.put("ev", jSONObject2);
            } catch (Throwable th) {
            }
            if (this.aQy != null) {
                jSONObject.put("ext", this.aQy);
            }
        } catch (Throwable th2) {
        }
        return jSONObject;
    }
}
