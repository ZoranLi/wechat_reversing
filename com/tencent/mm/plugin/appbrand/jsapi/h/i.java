package com.tencent.mm.plugin.appbrand.jsapi.h;

import com.tencent.mm.plugin.appbrand.m.d;
import com.tencent.mm.plugin.appbrand.widget.picker.b;
import com.tencent.mm.plugin.appbrand.widget.picker.g;
import com.tencent.mm.plugin.appbrand.widget.picker.g.a;
import com.tencent.mm.plugin.appbrand.widget.picker.h;
import com.tencent.mm.plugin.appbrand.widget.picker.j;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

final class i extends c {
    int iUB = -1;
    int iUC = -1;
    int iUD = -1;
    int iUE = -1;
    int iUF = -1;
    int iUG = -1;

    i() {
    }

    final void k(JSONObject jSONObject) {
        int[] rw;
        JSONObject optJSONObject = jSONObject.optJSONObject("range");
        if (optJSONObject != null) {
            String optString = optJSONObject.optString("start");
            String optString2 = optJSONObject.optString("end");
            int[] rw2 = j.rw(optString);
            if (rw2 != null) {
                this.iUB = rw2[0];
                this.iUC = rw2[1];
            }
            rw = j.rw(optString2);
            if (rw != null) {
                this.iUD = rw[0];
                this.iUE = rw[1];
            }
        }
        rw = j.rw(jSONObject.optString("current"));
        if (rw != null) {
            this.iUF = rw[0];
            this.iUG = rw[1];
        }
        d.runOnUiThread(new Runnable(this) {
            final /* synthetic */ i iUH;

            {
                this.iUH = r1;
            }

            public final void run() {
                b bVar = this.iUH;
                h hVar = (h) bVar.q(h.class);
                if (hVar == null) {
                    bVar.e("fail cant init view", null);
                    return;
                }
                g gVar = bVar.jyg;
                int i = bVar.iUB;
                int i2 = bVar.iUC;
                hVar.iUB = i;
                hVar.iUC = i2;
                if (j.jc(hVar.iUB) && hVar.jyL != null) {
                    hVar.jyL.setMinValue(hVar.iUB);
                }
                i = bVar.iUD;
                i2 = bVar.iUE;
                hVar.iUD = i;
                hVar.iUE = i2;
                if (j.jc(hVar.iUD) && hVar.jyL != null) {
                    hVar.jyL.setMaxValue(hVar.iUD);
                }
                i = bVar.iUF;
                i2 = bVar.iUG;
                if (j.jc(i) && j.jb(i2)) {
                    hVar.setCurrentHour(Integer.valueOf(i));
                    hVar.setCurrentMinute(Integer.valueOf(i2));
                }
                hVar.ZJ();
                gVar.jyG = new a<String>(bVar) {
                    final /* synthetic */ i iUH;

                    {
                        this.iUH = r1;
                    }

                    public final /* synthetic */ void c(boolean z, Object obj) {
                        String str = (String) obj;
                        b bVar = this.iUH;
                        if (bVar.jyg != null) {
                            bVar.jyg.hide();
                        }
                        if (!z) {
                            bVar.e("cancel", null);
                        } else if (bg.mA(str)) {
                            bVar.e("fail", null);
                        } else {
                            Map hashMap = new HashMap(1);
                            hashMap.put(Columns.VALUE, str);
                            bVar.e("ok", hashMap);
                        }
                    }
                };
                gVar.show();
            }
        });
    }
}
