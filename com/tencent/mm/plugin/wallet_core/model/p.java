package com.tencent.mm.plugin.wallet_core.model;

import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.e.b.dl;
import com.tencent.mm.plugin.wallet_core.c.d;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class p extends dl {
    public static a gTP;

    static {
        a aVar = new a();
        aVar.hXH = new Field[3];
        aVar.columns = new String[4];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "bulletin_scene";
        aVar.uxd.put("bulletin_scene", "TEXT PRIMARY KEY ");
        stringBuilder.append(" bulletin_scene TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.uxc = "bulletin_scene";
        aVar.columns[1] = "bulletin_content";
        aVar.uxd.put("bulletin_content", "TEXT");
        stringBuilder.append(" bulletin_content TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "bulletin_url";
        aVar.uxd.put("bulletin_url", "TEXT");
        stringBuilder.append(" bulletin_url TEXT");
        aVar.columns[3] = "rowid";
        aVar.uxe = stringBuilder.toString();
        gTP = aVar;
    }

    protected final a sY() {
        return gTP;
    }

    public static void N(JSONObject jSONObject) {
        boolean z = true;
        int i = 0;
        d btW = m.btW();
        if (jSONObject == null || btW == null) {
            String str = "MicroMsg.WalletBulletin";
            StringBuilder append = new StringBuilder("json==null?").append(jSONObject == null).append("  stg==null?");
            if (btW != null) {
                z = false;
            }
            w.e(str, append.append(z).toString());
            return;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("banner_map");
        JSONArray optJSONArray2 = jSONObject.optJSONArray("banner_content_array");
        Map hashMap = new HashMap();
        Map hashMap2 = new HashMap();
        if (optJSONArray == null || optJSONArray2 == null) {
            String str2 = "MicroMsg.WalletBulletin";
            append = new StringBuilder("scenes==null?").append(optJSONArray == null).append("  contents==null?");
            if (optJSONArray2 != null) {
                z = false;
            }
            w.e(str2, append.append(z).toString());
            return;
        }
        int i2;
        int length = optJSONArray.length();
        for (i2 = 0; i2 < length; i2++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("banner_type");
                String optString2 = optJSONObject.optString("banner_template_id");
                w.i("MicroMsg.WalletBulletin", "sceneid=" + optString + "; contentid=" + optString2);
                if (!(bg.mA(optString) || bg.mA(optString2))) {
                    hashMap.put(optString, optString2);
                    w.i("MicroMsg.WalletBulletin", "sceneid:" + optString + " map contentid:" + optString2);
                }
            }
        }
        i2 = optJSONArray2.length();
        while (i < i2) {
            JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i);
            if (optJSONObject2 != null) {
                hashMap2.put(optJSONObject2.optString("banner_template_id"), Integer.valueOf(i));
            }
            i++;
        }
        if (hashMap.size() > 0) {
            for (String str3 : hashMap.keySet()) {
                String str4 = (String) hashMap.get(str3);
                if (hashMap2.containsKey(str4)) {
                    w.i("MicroMsg.WalletBulletin", "find contentid:" + str4 + "in contentMap");
                    optJSONObject2 = optJSONArray2.optJSONObject(((Integer) hashMap2.get(str4)).intValue());
                    c pVar = new p();
                    pVar.field_bulletin_scene = str3;
                    pVar.field_bulletin_content = optJSONObject2.optString("content");
                    pVar.field_bulletin_url = optJSONObject2.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                    btW.b(pVar);
                } else {
                    w.e("MicroMsg.WalletBulletin", "can not find contentid:" + str4 + "in contentMap");
                }
            }
        }
    }
}
