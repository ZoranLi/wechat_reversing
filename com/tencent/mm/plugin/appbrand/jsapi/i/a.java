package com.tencent.mm.plugin.appbrand.jsapi.i;

import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.u.q;
import com.tencent.mm.u.q.b;
import org.json.JSONObject;

public final class a extends com.tencent.mm.plugin.appbrand.jsapi.a {
    private static final int CTRL_INDEX = 106;
    private static final String NAME = "hideToast";

    public final void a(final m mVar, JSONObject jSONObject, final int i) {
        af.v(new Runnable(this) {
            final /* synthetic */ a iUI;

            public final void run() {
                d dVar = this.iUI;
                m mVar = mVar;
                int i = i;
                b fP = q.yC().fP(mVar.hashCode() + "toast_name");
                if (fP != null) {
                    View view = (View) fP.fS("toast_view");
                    if (view != null) {
                        view.setVisibility(8);
                        mVar.x(i, dVar.d("ok", null));
                        return;
                    }
                }
                mVar.x(i, dVar.d("fail", null));
            }
        });
    }
}
