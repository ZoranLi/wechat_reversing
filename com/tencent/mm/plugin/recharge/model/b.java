package com.tencent.mm.plugin.recharge.model;

import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b {
    public static ArrayList<MallRechargeProduct> a(String str, JSONArray jSONArray) {
        ArrayList<MallRechargeProduct> arrayList;
        if (jSONArray != null) {
            try {
                arrayList = new ArrayList();
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    arrayList.add(a(str, jSONArray.getJSONObject(i)));
                }
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.MallLogic", e, "", new Object[0]);
                return null;
            }
        }
        arrayList = null;
        return arrayList;
    }

    public static MallRechargeProduct a(String str, JSONObject jSONObject) {
        boolean z;
        MallRechargeProduct mallRechargeProduct = new MallRechargeProduct(jSONObject.optInt("need_getlatestinfo", 1) == 1);
        mallRechargeProduct.oKW = str;
        mallRechargeProduct.fGa = jSONObject.getString("product_id");
        mallRechargeProduct.kSV = jSONObject.getString("product_name");
        mallRechargeProduct.oKX = jSONObject.optString("product_desc");
        mallRechargeProduct.oKY = ((float) jSONObject.getInt("product_min_price")) / 100.0f;
        mallRechargeProduct.oKZ = ((float) jSONObject.getInt("product_max_price")) / 100.0f;
        mallRechargeProduct.appId = jSONObject.optString("app_id");
        if (jSONObject.getInt("is_infinite") == 1) {
            z = true;
        } else {
            z = false;
        }
        mallRechargeProduct.oLa = z;
        mallRechargeProduct.oLb = jSONObject.getInt("left_count");
        mallRechargeProduct.oLc = jSONObject.getInt("discount");
        if (jSONObject.optInt("is_default_choose", 0) == 1) {
            z = true;
        } else {
            z = false;
        }
        mallRechargeProduct.isDefault = z;
        mallRechargeProduct.oLf = true;
        mallRechargeProduct.oLd = jSONObject.optInt("product_type", 0);
        return mallRechargeProduct;
    }

    public static String Di(String str) {
        if (str == null) {
            return null;
        }
        String replaceAll = str.replaceAll("\\D", "");
        if (replaceAll.startsWith("86")) {
            return replaceAll.substring(2);
        }
        return replaceAll;
    }

    public static String Dj(String str) {
        if (str == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder(str.replaceAll(" ", ""));
        int length = stringBuilder.length();
        if (length < 4) {
            return stringBuilder.toString();
        }
        stringBuilder.insert(3, ' ');
        if (length >= 8) {
            stringBuilder.insert(8, ' ');
        }
        return stringBuilder.toString();
    }
}
