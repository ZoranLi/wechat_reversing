package com.tencent.mm.plugin.appbrand.jsapi.d;

import com.tencent.mm.plugin.appbrand.g.m;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.ui.MMActivity;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public final class d extends a {
    private static final int CTRL_INDEX = 119;
    private static final String NAME = "removeTextArea";

    public final void a(m mVar, JSONObject jSONObject, final int i) {
        final String optString = jSONObject.optString("inputId", "");
        if (bg.mA(optString)) {
            mVar.x(i, d("fail:invalid data", null));
            return;
        }
        final WeakReference weakReference = new WeakReference(mVar);
        com.tencent.mm.plugin.appbrand.m.d.runOnUiThread(new Runnable(this) {
            final /* synthetic */ d iSB;

            public final void run() {
                if (((m) weakReference.get()).mContext instanceof MMActivity) {
                    ((MMActivity) ((m) weakReference.get()).mContext).aHf();
                }
                String str = com.tencent.mm.plugin.appbrand.widget.input.m.rn(optString) ? "ok" : "fail";
                if (weakReference.get() != null) {
                    ((m) weakReference.get()).x(i, this.iSB.d(str, null));
                }
            }
        });
    }
}
