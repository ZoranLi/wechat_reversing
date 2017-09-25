package com.tencent.mm.plugin.appbrand.jsapi.video;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.plugin.appbrand.g.m;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.w;
import org.json.JSONObject;

public final class e implements com.tencent.mm.plugin.appbrand.g.m.c {
    public AppBrandVideoView iXl;
    private m iXm;
    aj iXn;
    public int iXo;

    private static final class a extends com.tencent.mm.plugin.appbrand.jsapi.e {
        private static final int CTRL_INDEX = 131;
        private static final String NAME = "onVideoClickDanmuBtn";
    }

    private static final class b extends com.tencent.mm.plugin.appbrand.jsapi.e {
        private static final int CTRL_INDEX = 138;
        private static final String NAME = "onVideoEnded";
    }

    private static final class c extends com.tencent.mm.plugin.appbrand.jsapi.e {
        private static final int CTRL_INDEX = 130;
        private static final String NAME = "onVideoFullScreenChange";
    }

    private static final class d extends com.tencent.mm.plugin.appbrand.jsapi.e {
        private static final int CTRL_INDEX = 128;
        private static final String NAME = "onVideoPause";
    }

    private static final class e extends com.tencent.mm.plugin.appbrand.jsapi.e {
        private static final int CTRL_INDEX = 127;
        private static final String NAME = "onVideoPlay";
    }

    private static final class f extends com.tencent.mm.plugin.appbrand.jsapi.e {
        private static final int CTRL_INDEX = 127;
        private static final String NAME = "onVideoTimeUpdate";
    }

    public e(AppBrandVideoView appBrandVideoView, m mVar) {
        this.iXl = appBrandVideoView;
        this.iXm = mVar;
        this.iXm.a((com.tencent.mm.plugin.appbrand.g.m.c) this);
    }

    public final void onDestroy() {
        w.d("MicroMsg.JsApiVideoCallback", "onDestroy clean");
        clean();
        this.iXl.iWv = null;
    }

    public final void clean() {
        this.iXm.b((com.tencent.mm.plugin.appbrand.g.m.c) this);
        UC();
    }

    public final void a(com.tencent.mm.plugin.appbrand.jsapi.e eVar, JSONObject jSONObject) {
        if (!(eVar instanceof f)) {
            w.i("MicroMsg.JsApiVideoCallback", "dispatchEvent event %s", new Object[]{eVar.getName()});
        }
        com.tencent.mm.plugin.appbrand.jsapi.e ad = eVar.ad(this.iXm.ivH, this.iXm.hashCode());
        ad.mData = jSONObject.toString();
        ad.SR();
    }

    public final JSONObject UB() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(SlookAirButtonFrequentContactAdapter.DATA, this.iXl.iWr);
        return jSONObject;
    }

    final void UC() {
        if (this.iXn != null) {
            this.iXn.KH();
        }
    }
}
