package com.tencent.mm.plugin.appbrand.jsapi.l;

import android.view.View;
import com.tencent.mm.plugin.appbrand.g.m;
import com.tencent.mm.plugin.appbrand.jsapi.base.a;
import org.json.JSONObject;

public final class c extends a {
    public static final int CTRL_INDEX = 298;
    public static final String NAME = "insertHTMLWebView";

    protected final View a(m mVar, JSONObject jSONObject) {
        if (mVar.VT() != null) {
            return null;
        }
        final View aVar = new a(mVar.mContext, mVar.ixr, mVar);
        mVar.jda.add(new m.a(this) {
            final /* synthetic */ c iZc;

            public final boolean UQ() {
                if (!aVar.iYA.canGoBack()) {
                    return false;
                }
                aVar.iYA.goBack();
                return true;
            }
        });
        return aVar;
    }

    protected final int h(JSONObject jSONObject) {
        return jSONObject.getInt("htmlId");
    }

    protected final void b(m mVar, int i, View view, JSONObject jSONObject) {
    }
}
