package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mm.bb.d;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class s extends a {
    public static final int CTRL_INDEX = 103;
    public static final String NAME = "chooseLocation";
    public int iLf = 0;

    public final void a(final m mVar, JSONObject jSONObject, int i) {
        Intent intent = new Intent();
        intent.putExtra("map_view_type", 8);
        Context a = a(mVar);
        if (a == null) {
            mVar.x(i, d("fail", null));
            w.e("MicroMsg.JsApiChooseLocation", "mmActivity is null, invoke fail!");
            return;
        }
        this.iLf = i;
        a.uSV = new a(this) {
            final /* synthetic */ s iLJ;

            public final void a(int i, int i2, Intent intent) {
                if (i != 1) {
                    return;
                }
                if (i2 == -1) {
                    if (intent == null) {
                        mVar.x(this.iLJ.iLf, this.iLJ.d("fail", null));
                        w.e("MicroMsg.JsApiChooseLocation", "location result is empty!");
                        return;
                    }
                    Addr addr = (Addr) intent.getParcelableExtra("key_pick_addr");
                    Map hashMap = new HashMap();
                    if (addr != null) {
                        w.i("MicroMsg.JsApiChooseLocation", "addr: " + addr.toString());
                        StringBuilder stringBuilder = new StringBuilder();
                        if (TextUtils.isEmpty(addr.hCE)) {
                            stringBuilder.append(addr.Gh());
                        } else {
                            stringBuilder.append(addr.hCE);
                        }
                        hashMap.put("address", stringBuilder.toString());
                        if (TextUtils.isEmpty(addr.hCN)) {
                            hashMap.put("name", stringBuilder.toString());
                        } else {
                            hashMap.put("name", addr.hCN);
                        }
                        hashMap.put("latitude", Float.valueOf(addr.hCP));
                        hashMap.put("longitude", Float.valueOf(addr.hCQ));
                        mVar.x(this.iLJ.iLf, this.iLJ.d("ok", hashMap));
                        return;
                    }
                    mVar.x(this.iLJ.iLf, this.iLJ.d("fail", null));
                    w.e("MicroMsg.JsApiChooseLocation", "location result is empty!");
                } else if (i2 == 0) {
                    mVar.x(this.iLJ.iLf, this.iLJ.d("cancel", null));
                    w.e("MicroMsg.JsApiChooseLocation", "location result is cancel!");
                } else {
                    mVar.x(this.iLJ.iLf, this.iLJ.d("fail", null));
                    w.e("MicroMsg.JsApiChooseLocation", "location result is fail!");
                }
            }
        };
        d.b(a, "location", ".ui.RedirectUI", intent, 1);
    }
}
