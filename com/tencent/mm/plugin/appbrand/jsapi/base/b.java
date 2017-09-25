package com.tencent.mm.plugin.appbrand.jsapi.base;

import android.view.View;
import com.tencent.mm.plugin.appbrand.g.m;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.sdk.platformtools.w;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class b extends d {
    public final void a(m mVar, JSONObject jSONObject, int i) {
        super.a(mVar, jSONObject, i);
        a(mVar, i, mVar, jSONObject);
    }

    public final void a(com.tencent.mm.plugin.appbrand.m mVar, JSONObject jSONObject, int i) {
        super.a(mVar, jSONObject, i);
        m b = d.b(mVar);
        if (b == null) {
            w.w("MicroMsg.BaseRemoveViewJsApi", "Remove view failed, AppBrandPageView is null.");
            mVar.x(i, d("fail:page is null", null));
            return;
        }
        a(mVar, i, b, jSONObject);
    }

    private void a(c cVar, int i, m mVar, JSONObject jSONObject) {
        try {
            boolean ii;
            int h = h(jSONObject);
            View il = mVar.jdc.il(h);
            if (mVar.jdc.ik(h)) {
                ii = mVar.jdc.ii(h);
                if (ii) {
                    ii = c(mVar, h, il, jSONObject);
                }
            } else {
                ii = false;
            }
            if (ii) {
                mVar.jdc.im(h);
            }
            w.i("MicroMsg.BaseRemoveViewJsApi", "remove view(parentId : %s, viewId : %s, r : %s)", new Object[]{Integer.valueOf(jSONObject.optInt("parentId", 0)), Integer.valueOf(h), Boolean.valueOf(ii)});
            cVar.x(i, d(ii ? "ok" : "fail", null));
        } catch (JSONException e) {
            w.e("MicroMsg.BaseRemoveViewJsApi", "get viewId error. exception : %s", new Object[]{e});
            cVar.x(i, d("fail:view id do not exist", null));
        }
    }

    public boolean c(m mVar, int i, View view, JSONObject jSONObject) {
        return true;
    }
}
