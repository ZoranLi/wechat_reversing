package com.tencent.mm.plugin.appbrand.jsapi.d;

import android.graphics.Rect;
import android.view.View;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.plugin.appbrand.g.m;
import com.tencent.mm.plugin.appbrand.m.d;
import com.tencent.mm.plugin.appbrand.widget.input.a.h;
import com.tencent.mm.plugin.appbrand.widget.input.b;
import com.tencent.mm.plugin.appbrand.widget.input.e;
import com.tencent.mm.sdk.platformtools.bg;
import org.json.JSONObject;

public class f extends a<h> {
    private static final int CTRL_INDEX = 112;
    private static final String NAME = "updateInput";

    public void a(m mVar, JSONObject jSONObject, int i) {
        final com.tencent.mm.plugin.appbrand.widget.input.a.f hVar = new h();
        if (a(hVar, jSONObject, mVar, i)) {
            final String optString = jSONObject.optString("inputId", "");
            if (bg.mA(optString)) {
                mVar.x(i, d("fail:invalid data", null));
                return;
            }
            if (hVar.jwY != null && hVar.jwY.intValue() < 0) {
                hVar.jwY = Integer.valueOf(0);
            }
            if (hVar.jwZ != null && hVar.jwZ.intValue() < 0) {
                hVar.jwZ = Integer.valueOf(0);
            }
            String optString2 = jSONObject.optString(SlookAirButtonFrequentContactAdapter.DATA, null);
            if (optString2 != null) {
                a.aW(optString, optString2);
            }
            final m mVar2 = mVar;
            final int i2 = i;
            d.runOnUiThread(new Runnable(this) {
                final /* synthetic */ f iSJ;

                public final void run() {
                    Object obj;
                    com.tencent.mm.plugin.appbrand.widget.input.h hVar = a.jtq;
                    String str = optString;
                    h hVar2 = hVar;
                    b bVar = bg.mA(str) ? null : (b) hVar.jtl.get(str);
                    if (bVar != null) {
                        if (hVar2.jwX != null) {
                            bVar.rk(hVar2.jwX);
                        }
                        bVar.a(hVar2);
                        View Yj = bVar.Yj();
                        if (Yj != null) {
                            m mVar = (m) bVar.jsp.get();
                            if (!(mVar == null || mVar.jde == null)) {
                                e eVar = mVar.jdd;
                                if (eVar != null) {
                                    Rect Yk = bVar.Yk();
                                    eVar.b(mVar.jde, Yj, Yk.width(), Yk.height(), Yk.left, Yk.top);
                                }
                            }
                        }
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        mVar2.x(i2, this.iSJ.d("ok", null));
                    } else if (com.tencent.mm.plugin.appbrand.widget.input.m.a(hVar, optString)) {
                        mVar2.x(i2, this.iSJ.d("ok", null));
                    } else {
                        mVar2.x(i2, this.iSJ.d("fail", null));
                    }
                }
            });
        }
    }

    protected final boolean TF() {
        return true;
    }
}
