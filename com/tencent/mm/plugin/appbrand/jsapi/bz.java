package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.m;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import org.json.JSONObject;

final class bz extends a {
    private static final int CTRL_INDEX = 77;
    private static final String NAME = "setKeyboardValue";

    bz() {
    }

    public final void a(m mVar, JSONObject jSONObject, int i) {
        com.tencent.mm.plugin.appbrand.g.m b = d.b(mVar);
        if (b != null) {
            try {
                Integer valueOf;
                String string = jSONObject.getString(Columns.VALUE);
                try {
                    valueOf = Integer.valueOf(jSONObject.getInt("cursor"));
                } catch (Exception e) {
                    valueOf = null;
                }
                com.tencent.mm.plugin.appbrand.widget.input.m.a(b, string, valueOf);
                mVar.x(i, d("ok", null));
            } catch (Exception e2) {
                mVar.x(i, d("fail:invalid data", null));
            }
        }
    }
}
