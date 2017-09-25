package com.tencent.mm.plugin.appbrand.jsapi.i;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Color;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.plugin.appbrand.m.h;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class c extends a {
    private static final int CTRL_INDEX = 104;
    private static final String NAME = "showModal";

    public final void a(m mVar, JSONObject jSONObject, int i) {
        com.tencent.mm.plugin.appbrand.g.m b = d.b(mVar);
        if (b == null) {
            w.w("MicroMsg.JsApiShowModal", "invoke JsApi JsApiShowModal failed, current page view is null.");
            mVar.x(i, d("fail", null));
            return;
        }
        com.tencent.mm.plugin.appbrand.widget.input.m.j(b);
        final String optString = jSONObject.optString("title");
        final String optString2 = jSONObject.optString("confirmText", mVar.mContext.getString(R.l.dHT));
        final String optString3 = jSONObject.optString("cancelText", mVar.mContext.getString(R.l.dGs));
        final Boolean valueOf = Boolean.valueOf(jSONObject.optBoolean("showCancel", true));
        final int at = h.at(jSONObject.optString("confirmColor", ""), Color.parseColor("#3CC51F"));
        final int at2 = h.at(jSONObject.optString("cancelColor", ""), Color.parseColor("#000000"));
        final String optString4 = jSONObject.optString("content");
        final m mVar2 = mVar;
        final int i2 = i;
        af.v(new Runnable(this) {
            final /* synthetic */ c iUU;

            public final void run() {
                if (mVar2.aaI) {
                    com.tencent.mm.plugin.appbrand.widget.b.a aVar = new com.tencent.mm.plugin.appbrand.widget.b.a(this.iUU.a(mVar2));
                    if (!bg.mA(optString)) {
                        aVar.setTitle(optString);
                    }
                    aVar.setMessage(optString4);
                    aVar.a(optString2, true, new OnClickListener(this) {
                        final /* synthetic */ AnonymousClass1 iUV;

                        {
                            this.iUV = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            Map hashMap = new HashMap();
                            hashMap.put("confirm", Boolean.valueOf(true));
                            hashMap.put("cancel", Boolean.valueOf(false));
                            mVar2.x(i2, this.iUV.iUU.d("ok", hashMap));
                        }
                    });
                    if (valueOf.booleanValue()) {
                        aVar.b(optString3, false, new OnClickListener(this) {
                            final /* synthetic */ AnonymousClass1 iUV;

                            {
                                this.iUV = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                Map hashMap = new HashMap();
                                hashMap.put("confirm", Boolean.valueOf(false));
                                hashMap.put("cancel", Boolean.valueOf(true));
                                dialogInterface.dismiss();
                                mVar2.x(i2, this.iUV.iUU.d("ok", hashMap));
                            }
                        });
                    }
                    aVar.setOnCancelListener(new OnCancelListener(this) {
                        final /* synthetic */ AnonymousClass1 iUV;

                        {
                            this.iUV = r1;
                        }

                        public final void onCancel(DialogInterface dialogInterface) {
                            Map hashMap = new HashMap();
                            hashMap.put("confirm", Boolean.valueOf(false));
                            hashMap.put("cancel", Boolean.valueOf(false));
                            mVar2.x(i2, this.iUV.iUU.d("ok", hashMap));
                        }
                    });
                    aVar.zU(at);
                    if (valueOf.booleanValue()) {
                        aVar.zV(at2);
                    }
                    mVar2.ixr.a(aVar);
                }
            }
        });
    }
}
