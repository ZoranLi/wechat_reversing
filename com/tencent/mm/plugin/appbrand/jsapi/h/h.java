package com.tencent.mm.plugin.appbrand.jsapi.h;

import android.view.View;
import com.tencent.mm.plugin.appbrand.m.d;
import com.tencent.mm.plugin.appbrand.widget.picker.a;
import com.tencent.mm.plugin.appbrand.widget.picker.b;
import com.tencent.mm.plugin.appbrand.widget.picker.e;
import com.tencent.mm.plugin.appbrand.widget.picker.g;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

final class h extends c {

    class AnonymousClass2 implements Runnable {
        final /* synthetic */ h iUy;
        final /* synthetic */ a iUz;

        AnonymousClass2(h hVar, a aVar) {
            this.iUy = hVar;
            this.iUz = aVar;
        }

        public final void run() {
            if (this.iUz.jyE != null && (this.iUz.jyE instanceof View)) {
                ((View) this.iUz.jyE).requestLayout();
            }
        }
    }

    class AnonymousClass3 implements g.a<String> {
        final /* synthetic */ e iUA;
        final /* synthetic */ h iUy;
        final /* synthetic */ a iUz;

        AnonymousClass3(h hVar, a aVar, e eVar) {
            this.iUy = hVar;
            this.iUz = aVar;
            this.iUA = eVar;
        }

        public final /* synthetic */ void c(boolean z, Object obj) {
            this.iUz.hide();
            if (z) {
                Map hashMap = new HashMap(2);
                hashMap.put(Columns.VALUE, this.iUA.ZH());
                hashMap.put("index", Integer.valueOf(this.iUA.getValue()));
                this.iUy.e("ok", hashMap);
                return;
            }
            this.iUy.e("cancel", null);
        }
    }

    h() {
    }

    final void k(JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("array");
        final int optInt = jSONObject.optInt("current", 0);
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            e("fail:invalid data", null);
            return;
        }
        final String[] strArr = new String[optJSONArray.length()];
        int i = 0;
        while (i < optJSONArray.length()) {
            try {
                strArr[i] = optJSONArray.getString(i);
                i++;
            } catch (Throwable e) {
                w.e("MicroMsg.AppBrand.JsApi.OptionsPickerHandler", "opt data.array, exp = %s", new Object[]{bg.g(e)});
                e("fail", null);
                return;
            }
        }
        d.runOnUiThread(new Runnable(this) {
            final /* synthetic */ h iUy;

            public final void run() {
                b bVar = this.iUy;
                String[] strArr = strArr;
                int i = optInt;
                e eVar = (e) bVar.q(e.class);
                if (eVar == null) {
                    bVar.e("fail cant init view", null);
                    return;
                }
                g gVar = bVar.jyg;
                gVar.post(new AnonymousClass2(bVar, gVar));
                eVar.h(strArr);
                eVar.setValue(i);
                gVar.jyG = new AnonymousClass3(bVar, gVar, eVar);
                gVar.show();
            }
        });
    }
}
