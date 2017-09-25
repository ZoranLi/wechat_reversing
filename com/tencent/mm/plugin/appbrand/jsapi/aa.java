package com.tencent.mm.plugin.appbrand.jsapi;

import android.app.Activity;
import android.content.Context;
import com.tencent.mm.plugin.appbrand.m;
import org.json.JSONObject;

final class aa extends a {
    static final int CTRL_INDEX = 191;
    static final String NAME = "exitMiniProgram";

    aa() {
    }

    public final void a(m mVar, JSONObject jSONObject, int i) {
        Context context = mVar.mContext;
        if (context == null || !(context instanceof Activity)) {
            mVar.x(i, d("fail", null));
            return;
        }
        ((Activity) context).finish();
        mVar.x(i, d("ok", null));
    }
}
