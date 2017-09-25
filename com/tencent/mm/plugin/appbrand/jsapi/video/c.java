package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.view.View;
import com.tencent.mm.plugin.appbrand.g.m;
import com.tencent.mm.plugin.appbrand.jsapi.base.b;
import com.tencent.mm.sdk.platformtools.w;
import org.json.JSONObject;

public final class c extends b {
    private static final int CTRL_INDEX = 7;
    public static final String NAME = "removeVideoPlayer";

    protected final int h(JSONObject jSONObject) {
        return jSONObject.optInt("videoPlayerId", 0);
    }

    protected final boolean c(m mVar, int i, View view, JSONObject jSONObject) {
        super.c(mVar, i, view, jSONObject);
        w.i("MicroMsg.JsApiRemoveVideoPlayer", "onRemoveView videoPlayerId=%d", new Object[]{Integer.valueOf(i)});
        final AppBrandVideoView appBrandVideoView = (AppBrandVideoView) view;
        appBrandVideoView.post(new Runnable(this) {
            final /* synthetic */ c iXk;

            public final void run() {
                appBrandVideoView.clean();
            }
        });
        return true;
    }
}
