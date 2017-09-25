package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.m;
import org.json.JSONObject;

public final class ch extends a {
    public static final int CTRL_INDEX = 284;
    public static final String NAME = "startPullDownRefresh";

    public final void a(m mVar, JSONObject jSONObject, int i) {
        com.tencent.mm.plugin.appbrand.g.m b = d.b(mVar);
        if (b == null) {
            mVar.x(i, d("fail", null));
            return;
        }
        b.runOnUiThread(new Runnable(b) {
            final /* synthetic */ m jdm;

            {
                this.jdm = r1;
            }

            public final void run() {
                this.jdm.jdf.ca(true);
                this.jdm.jdf.VW();
            }
        });
        mVar.x(i, d("ok", null));
    }
}
