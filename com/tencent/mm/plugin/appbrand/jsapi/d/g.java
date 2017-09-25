package com.tencent.mm.plugin.appbrand.jsapi.d;

import com.tencent.mm.plugin.appbrand.g.m;
import com.tencent.mm.plugin.appbrand.widget.input.a.f;
import com.tencent.mm.plugin.appbrand.widget.input.a.h;
import org.json.JSONObject;

public final class g extends f {
    private static final int CTRL_INDEX = 111;
    private static final String NAME = "updateTextArea";

    protected final /* synthetic */ boolean a(f fVar, JSONObject jSONObject, m mVar, int i) {
        h hVar = (h) fVar;
        boolean a = super.a(hVar, jSONObject, mVar, i);
        hVar.jxr = Boolean.valueOf(true);
        hVar.jxx = Boolean.valueOf(false);
        hVar.jxs = Boolean.valueOf(true);
        return a;
    }

    public final void a(m mVar, JSONObject jSONObject, int i) {
        super.a(mVar, jSONObject, i);
    }
}
