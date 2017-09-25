package com.tencent.mm.plugin.appbrand.jsapi.d;

import com.tencent.mm.plugin.appbrand.g.m;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.m.d;
import org.json.JSONObject;

public final class b extends a {
    public static final int CTRL_INDEX = 70;
    public static final String NAME = "hideKeyboard";

    public final void a(m mVar, JSONObject jSONObject, int i) {
        b(mVar, jSONObject, i);
    }

    public final void a(com.tencent.mm.plugin.appbrand.m mVar, JSONObject jSONObject, int i) {
        b(mVar, jSONObject, i);
    }

    private void b(final c cVar, JSONObject jSONObject, final int i) {
        final String optString = jSONObject.optString("inputId");
        d.runOnUiThread(new Runnable(this) {
            final /* synthetic */ b iSx;

            public final void run() {
                if (cVar.isRunning()) {
                    c cVar = cVar;
                    cVar.x(i, this.iSx.d(com.tencent.mm.plugin.appbrand.widget.input.m.c(cVar instanceof m ? (m) cVar : com.tencent.mm.plugin.appbrand.jsapi.d.b((com.tencent.mm.plugin.appbrand.m) cVar), optString) ? "ok" : "fail:input not exists", null));
                }
            }
        });
    }
}
