package com.tencent.mm.plugin.appbrand.jsapi;

import android.view.WindowManager.LayoutParams;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.e.b;
import com.tencent.mm.plugin.appbrand.e.c;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import org.json.JSONObject;

public final class cc extends a {
    public static final int CTRL_INDEX = 229;
    public static final String NAME = "setScreenBrightness";
    public float iPN = Float.NaN;
    public float iPO;

    public final void a(final m mVar, final JSONObject jSONObject, final int i) {
        w.d("MicroMsg.JsApiSetScreenBrightness", "JsApiSetScreenBrightness!");
        if (jSONObject == null) {
            mVar.x(i, d("fail:data is null", null));
            w.e("MicroMsg.JsApiSetScreenBrightness", "data is null");
            return;
        }
        af.v(new Runnable(this) {
            final /* synthetic */ cc iPP;

            public final void run() {
                float f = 0.01f;
                this.iPP.iPO = (float) jSONObject.optDouble(Columns.VALUE);
                if (Float.isNaN(this.iPP.iPO) || this.iPP.iPO < 0.0f || this.iPP.iPO > 1.0f) {
                    mVar.x(i, this.iPP.d("fail:value invalid", null));
                    w.e("MicroMsg.JsApiSetScreenBrightness", "value invalid");
                    return;
                }
                final MMActivity a = this.iPP.a(mVar);
                if (a == null) {
                    mVar.x(i, this.iPP.d("fail", null));
                    w.e("MicroMsg.JsApiSetScreenBrightness", "context is null, invoke fail!");
                    return;
                }
                final LayoutParams attributes = a.getWindow().getAttributes();
                if (Float.isNaN(this.iPP.iPN)) {
                    this.iPP.iPN = attributes.screenBrightness;
                    e.a(mVar.ivH, new b(this) {
                        final /* synthetic */ AnonymousClass1 iPR;

                        public final void a(c cVar) {
                            attributes.screenBrightness = this.iPR.iPP.iPN;
                            a.getWindow().setAttributes(attributes);
                        }

                        public final void onResume() {
                            attributes.screenBrightness = this.iPR.iPP.iPO;
                            a.getWindow().setAttributes(attributes);
                        }
                    });
                }
                if (this.iPP.iPO >= 0.01f) {
                    f = this.iPP.iPO;
                }
                attributes.screenBrightness = f;
                a.getWindow().setAttributes(attributes);
                mVar.x(i, this.iPP.d("ok", null));
            }
        });
    }
}
