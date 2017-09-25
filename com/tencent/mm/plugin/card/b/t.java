package com.tencent.mm.plugin.card.b;

import android.text.TextUtils;
import com.tencent.mm.protocal.c.iw;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class t {
    public static ArrayList<iw> tn(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONObject(str).getJSONArray("used_store_list");
            if (jSONArray == null || jSONArray.length() == 0) {
                return null;
            }
            ArrayList<iw> arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                Object obj;
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (jSONObject == null) {
                    obj = null;
                } else {
                    obj = new iw();
                    obj.name = jSONObject.optString("name");
                    obj.descriptor = jSONObject.optString("descriptor");
                    obj.kdW = jSONObject.optString("phone");
                    obj.country = jSONObject.optString("country");
                    obj.gkB = jSONObject.optString("province");
                    obj.gkC = jSONObject.optString("city");
                    obj.hCE = jSONObject.optString("address");
                    obj.tnX = (float) jSONObject.optDouble("distance");
                    obj.fPF = (float) jSONObject.optDouble("longitude");
                    obj.fOb = (float) jSONObject.optDouble("latitude");
                    obj.kfu = jSONObject.optString("jump_url");
                    obj.tnY = jSONObject.optString("app_brand_user_name");
                    obj.tnZ = jSONObject.optString("app_brand_pass");
                }
                if (obj != null) {
                    arrayList.add(obj);
                }
            }
            return arrayList;
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.ShopInfoItemParser", e, "", new Object[0]);
            return null;
        }
    }
}
