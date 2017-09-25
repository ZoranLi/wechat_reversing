package com.tencent.mm.plugin.appbrand.dynamic.f;

import com.tencent.mm.plugin.appbrand.dynamic.core.c;
import com.tencent.mm.plugin.appbrand.m.h;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class a extends c {
    public Map<String, String> iHX;
    public String iHY;
    public int iHZ;
    public int iIa;
    public String path;
    public String title;

    public a() {
        super("onCanvasInsert");
    }

    public final JSONObject nQ() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("title", this.title);
            jSONObject.put("path", this.path);
            jSONObject.put("query", new JSONObject(this.iHX == null ? new HashMap() : this.iHX));
            jSONObject.put("cacheKey", this.iHY);
            jSONObject.put("width", h.iC(this.iHZ));
            jSONObject.put("height", h.iC(this.iIa));
        } catch (JSONException e) {
        }
        return jSONObject;
    }
}
