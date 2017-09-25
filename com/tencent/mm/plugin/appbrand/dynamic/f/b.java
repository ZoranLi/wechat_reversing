package com.tencent.mm.plugin.appbrand.dynamic.f;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.plugin.appbrand.dynamic.core.c;
import com.tencent.mm.sdk.platformtools.bg;
import org.json.JSONException;
import org.json.JSONObject;

public final class b extends c {
    public String data;

    public b() {
        super("onDataPush");
    }

    public final JSONObject nQ() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(SlookAirButtonFrequentContactAdapter.DATA, bg.mz(this.data));
        } catch (JSONException e) {
        }
        return jSONObject;
    }
}
