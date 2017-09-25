package com.tencent.mm.plugin.appbrand.jsapi.g;

import android.content.Intent;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.pluginsdk.wallet.d;
import com.tencent.mm.pluginsdk.wallet.e;
import com.tencent.mm.ui.MMActivity;
import org.json.JSONObject;

public final class a extends com.tencent.mm.plugin.appbrand.jsapi.a {
    public static final int CTRL_INDEX = 86;
    public static final String NAME = "bindPaymentCard";

    public final void a(final m mVar, JSONObject jSONObject, final int i) {
        if (jSONObject == null) {
            mVar.x(i, d("fail", null));
            return;
        }
        MMActivity a = a(mVar);
        if (a == null) {
            mVar.x(i, d("fail", null));
            return;
        }
        com.tencent.mm.ui.MMActivity.a anonymousClass1 = new com.tencent.mm.ui.MMActivity.a(this) {
            final /* synthetic */ a iTV;

            public final void a(int i, int i2, Intent intent) {
                if (i == (this.iTV.hashCode() & 65535)) {
                    if (i2 == -1) {
                        mVar.x(i, this.iTV.d("ok", null));
                    } else {
                        mVar.x(i, this.iTV.d("fail", null));
                    }
                }
            }
        };
        d dVar = new d(jSONObject);
        dVar.appId = mVar.ivH;
        dVar.fRw = 4;
        e.b(a, dVar, hashCode() & 65535, anonymousClass1);
    }
}
