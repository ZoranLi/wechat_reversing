package com.tencent.mm.plugin.appbrand.jsapi;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.plugin.appbrand.g.m;
import com.tencent.mm.plugin.appbrand.widget.d;
import com.tencent.mm.u.q.b;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class at extends com.tencent.mm.plugin.appbrand.jsapi.base.a {
    private static final int CTRL_INDEX = 253;
    public static final String NAME = "insertImageView";

    private static class a extends e {
        private static final int CTRL_INDEX = 256;
        private static final String NAME = "onImageViewClick";
    }

    protected final View a(m mVar, JSONObject jSONObject) {
        View dVar = new d(mVar.mContext);
        dVar.setScaleType(ScaleType.FIT_XY);
        return dVar;
    }

    protected final int h(JSONObject jSONObject) {
        return jSONObject.getInt("viewId");
    }

    protected final void b(final m mVar, int i, View view, JSONObject jSONObject) {
        boolean optBoolean = jSONObject.optBoolean("clickable");
        boolean optBoolean2 = jSONObject.optBoolean("transEvt");
        String optString = jSONObject.optString("sendTo", "appservice");
        String optString2 = jSONObject.optString(SlookAirButtonFrequentContactAdapter.DATA, "");
        com.tencent.mm.plugin.appbrand.jsapi.k.d.a(view, jSONObject.optJSONObject("style"));
        com.tencent.mm.plugin.appbrand.jsapi.k.a.a(mVar, (ImageView) view, jSONObject);
        final b B = mVar.jdc.B(i, true);
        B.l(SlookAirButtonFrequentContactAdapter.DATA, optString2);
        B.l("sendTo", optString);
        B.l("transEvt", Boolean.valueOf(optBoolean2));
        B.l("clickable", Boolean.valueOf(optBoolean));
        view.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ at iOm;

            public final void onClick(View view) {
                if (B.fR("clickable")) {
                    a aVar = new a();
                    Map hashMap = new HashMap();
                    hashMap.put(SlookAirButtonFrequentContactAdapter.DATA, B.getString(SlookAirButtonFrequentContactAdapter.DATA, ""));
                    aVar.a(mVar);
                    aVar.q(hashMap);
                    if ("webview".equals(B.getString("sendTo", null))) {
                        aVar.g(new int[]{mVar.hashCode()});
                        return;
                    }
                    aVar.SR();
                }
            }
        });
        view.setClickable(optBoolean);
    }
}
