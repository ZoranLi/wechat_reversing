package com.tencent.mm.plugin.appbrand.jsapi;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.plugin.appbrand.g.m;
import com.tencent.mm.plugin.appbrand.jsapi.k.d;
import com.tencent.mm.plugin.appbrand.widget.g;
import com.tencent.mm.u.q.b;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class au extends com.tencent.mm.plugin.appbrand.jsapi.base.a {
    private static final int CTRL_INDEX = 253;
    public static final String NAME = "insertTextView";

    private static class a extends e {
        private static final int CTRL_INDEX = 256;
        private static final String NAME = "onTextViewClick";
    }

    protected final View a(m mVar, JSONObject jSONObject) {
        return new g(mVar.mContext);
    }

    protected final int h(JSONObject jSONObject) {
        return jSONObject.getInt("viewId");
    }

    protected final void b(final m mVar, int i, View view, JSONObject jSONObject) {
        boolean optBoolean = jSONObject.optBoolean("clickable");
        boolean optBoolean2 = jSONObject.optBoolean("transEvt");
        String optString = jSONObject.optString("sendTo", "appservice");
        String optString2 = jSONObject.optString(SlookAirButtonFrequentContactAdapter.DATA, "");
        com.tencent.mm.plugin.appbrand.jsapi.k.a.a((TextView) view, jSONObject.optJSONObject("label"));
        d.a(view, jSONObject.optJSONObject("style"));
        final b B = mVar.jdc.B(i, true);
        B.l(SlookAirButtonFrequentContactAdapter.DATA, optString2);
        B.l("sendTo", optString);
        B.l("transEvt", Boolean.valueOf(optBoolean2));
        B.l("clickable", Boolean.valueOf(optBoolean));
        view.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ au iOn;

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
