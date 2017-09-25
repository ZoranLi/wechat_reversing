package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.m;
import org.json.JSONObject;

public class a extends d {
    public void a(c cVar, JSONObject jSONObject, int i) {
        if (cVar instanceof m) {
            a((m) cVar, jSONObject, i);
        } else if (cVar instanceof com.tencent.mm.plugin.appbrand.g.m) {
            a((com.tencent.mm.plugin.appbrand.g.m) cVar, jSONObject, i);
        }
    }

    public void a(m mVar, JSONObject jSONObject, int i) {
    }

    public void a(com.tencent.mm.plugin.appbrand.g.m mVar, JSONObject jSONObject, int i) {
    }
}
