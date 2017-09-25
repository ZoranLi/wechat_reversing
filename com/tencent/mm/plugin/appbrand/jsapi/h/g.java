package com.tencent.mm.plugin.appbrand.jsapi.h;

import com.tencent.mm.plugin.appbrand.g.m;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.widget.picker.d;
import com.tencent.mm.plugin.appbrand.widget.picker.i;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import org.json.JSONArray;
import org.json.JSONObject;

public final class g extends a {
    private static final int CTRL_INDEX = 258;
    private static final String NAME = "updateMultiPickerView";

    public final void a(m mVar, JSONObject jSONObject, int i) {
        new c(this) {
            final /* synthetic */ g iUs;

            {
                this.iUs = r1;
            }

            static /* synthetic */ i a(AnonymousClass1 anonymousClass1, Class cls) {
                com.tencent.mm.plugin.appbrand.widget.picker.g cB = super.cB(false);
                return (cB == null || !cls.isInstance(cB.jyE)) ? null : cB.jyE;
            }

            final void k(JSONObject jSONObject) {
                final int optInt = jSONObject.optInt("column", -1);
                JSONArray optJSONArray = jSONObject.optJSONArray("array");
                if (optInt < 0 || optJSONArray == null || optJSONArray.length() < 0) {
                    e("fail:invalid data", null);
                    return;
                }
                try {
                    String[] strArr = new String[optJSONArray.length()];
                    for (int i = 0; i < strArr.length; i++) {
                        strArr[i] = optJSONArray.getString(i);
                    }
                    final d.a aVar = new d.a(strArr, jSONObject.optInt("current", 0));
                    com.tencent.mm.plugin.appbrand.m.d.runOnUiThread(new Runnable(this) {
                        final /* synthetic */ AnonymousClass1 iUv;

                        public final void run() {
                            d dVar = (d) AnonymousClass1.a(this.iUv, d.class);
                            if (dVar == null) {
                                this.iUv.e("fail picker not exists", null);
                                return;
                            }
                            int i = optInt;
                            d.a aVar = aVar;
                            if (i >= 0 && i < dVar.ZG() && aVar != null) {
                                dVar.S(true);
                                dVar.iZ(i).h(aVar.jyx);
                                if (!bg.D(aVar.jyx)) {
                                    dVar.iZ(i).setValue(aVar.jyy);
                                }
                                dVar.S(false);
                            }
                            this.iUv.e("ok", null);
                        }
                    });
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.AppBrand.JsApiUpdateMultiPickerView", e, "opt params", new Object[0]);
                    e("fail:invalid data", null);
                }
            }
        }.a(this, mVar, jSONObject, i);
    }
}
