package com.tencent.mm.plugin.appbrand.jsapi.h;

import com.tencent.mm.plugin.appbrand.g.m;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import org.json.JSONObject;

public final class d extends a {
    public static final int CTRL_INDEX = 84;
    public static final String NAME = "showDatePickerView";

    public final void a(m mVar, JSONObject jSONObject, int i) {
        super.a(mVar, jSONObject, i);
        String optString = jSONObject.optString("mode");
        if (FFmpegMetadataRetriever.METADATA_KEY_DATE.equals(optString)) {
            new a().a(this, mVar, jSONObject, i);
        } else if ("time".equals(optString)) {
            new i().a(this, mVar, jSONObject, i);
        } else {
            mVar.x(i, d("fail:invalid data", null));
        }
    }
}
