package com.tencent.mm.plugin.appbrand.canvas.c;

import android.graphics.Path;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class d {
    private static d iDq;
    private Map<String, a> iDr = new HashMap();

    public static d Rv() {
        if (iDq == null) {
            synchronized (d.class) {
                if (iDq == null) {
                    iDq = new d();
                }
            }
        }
        return iDq;
    }

    public d() {
        a(new g());
        a(new e());
        a(new f());
        a(new h());
        a(new c());
        a(new b());
        a(new i());
    }

    public final Path f(JSONArray jSONArray) {
        Path path = new Path();
        if (jSONArray == null || jSONArray.length() == 0) {
            return path;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("method");
                JSONArray optJSONArray = optJSONObject.optJSONArray(SlookAirButtonFrequentContactAdapter.DATA);
                a aVar = (a) this.iDr.get(optString);
                if (aVar != null) {
                    aVar.a(path, optJSONArray);
                }
            }
        }
        return path;
    }

    private void a(a aVar) {
        this.iDr.put(aVar.getMethod(), aVar);
    }
}
