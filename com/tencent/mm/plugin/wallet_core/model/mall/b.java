package com.tencent.mm.plugin.wallet_core.model.mall;

import android.telephony.TelephonyManager;
import android.util.SparseArray;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b {
    public static int rIF = -256;
    public static int rIG = 621019136;
    public static int rIH = 637534720;

    public static ArrayList<MallNews> t(JSONArray jSONArray) {
        try {
            ArrayList<MallNews> arrayList = new ArrayList();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                MallNews mallNews = new MallNews(jSONObject.optString("activity_jump_funcid"));
                mallNews.rIN = jSONObject.optString("activity_icon_link");
                mallNews.rIL = jSONObject.optString("activity_msg_content");
                mallNews.rIP = jSONObject.optString("activity_tips");
                arrayList.add(mallNews);
            }
            return arrayList;
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.MallLogic", e, "", new Object[0]);
            return null;
        }
    }

    public static ArrayList<a> u(JSONArray jSONArray) {
        try {
            ArrayList<a> arrayList = new ArrayList();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                a aVar = new a();
                aVar.rIy = jSONObject.optInt("banner_id");
                aVar.rIz = jSONObject.optString("banner_title");
                aVar.rIA = jSONObject.optString("banner_link");
                arrayList.add(aVar);
            }
            return arrayList;
        } catch (JSONException e) {
            w.w("MicroMsg.MallLogic", "func[parseBannerActList], exp:" + e.getMessage());
            return null;
        }
    }

    public static SparseArray<String> v(JSONArray jSONArray) {
        try {
            SparseArray<String> sparseArray = new SparseArray();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                int optInt = jSONObject.optInt("type_id", 0);
                if (optInt != 0) {
                    sparseArray.put(optInt, jSONObject.optString("type_name"));
                }
            }
            return sparseArray;
        } catch (JSONException e) {
            w.w("MicroMsg.MallLogic", "func[parseBannerActList], exp:" + e.getMessage());
            return null;
        }
    }

    public static void bI(List<a> list) {
        if (list == null || list.size() <= 0) {
            w.w("MicroMsg.MallLogic", "func[setBannerRedDotClick] actList null or empty");
            return;
        }
        int i = ((a) list.get(0)).rIy;
        w.d("MicroMsg.MallLogic", "func[setBannerRedDotClick], lastClickedListMaxId" + i);
        ap.yY();
        c.vr().set(270342, Integer.valueOf(i));
        ap.yY();
        c.vr().jY(true);
    }

    public static ArrayList<MallFunction> w(JSONArray jSONArray) {
        try {
            ArrayList<MallFunction> arrayList = new ArrayList();
            int length = jSONArray.length();
            w.d("MicroMsg.MallLogic", "functions.jsonArray.length : " + length);
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                MallFunction mallFunction = new MallFunction();
                mallFunction.oKW = jSONObject.getString("func_id");
                mallFunction.fXa = jSONObject.getString("func_name");
                mallFunction.rIB = jSONObject.optString("func_icon_url");
                mallFunction.nvR = jSONObject.optString("hd_icon_url");
                mallFunction.nvS = jSONObject.optString("func_foregroud_icon_url");
                mallFunction.fZF = jSONObject.optString("native_url");
                mallFunction.mER = jSONObject.optString("h5_url");
                mallFunction.type = jSONObject.optInt("property_type", 0);
                mallFunction.rIE = jSONObject.optString("third_party_disclaimer");
                JSONArray optJSONArray = jSONObject.optJSONArray("remark_name_list");
                if (optJSONArray != null) {
                    mallFunction.rIC = new ArrayList();
                    int length2 = optJSONArray.length();
                    for (int i2 = 0; i2 < length2; i2++) {
                        mallFunction.rIC.add(optJSONArray.getString(i2));
                    }
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("activity_info_list");
                if (!(optJSONArray2 == null || optJSONArray2.length() == 0)) {
                    String str = mallFunction.oKW;
                    JSONObject jSONObject2 = optJSONArray2.getJSONObject(0);
                    MallNews mallNews = new MallNews(str);
                    mallNews.qSx = jSONObject2.optString("activity_id");
                    mallNews.fGV = jSONObject2.optString("activity_ticket");
                    mallNews.rIL = jSONObject2.optString("activity_msg_content");
                    mallNews.rIM = jSONObject2.optString("activity_link");
                    mallNews.rIN = jSONObject2.optString("activity_icon_link");
                    mallNews.rIO = jSONObject2.optInt("activity_expired_time");
                    mallNews.rIP = jSONObject2.optString("activity_tips");
                    mallNews.rGH = jSONObject2.optInt("activity_type");
                    mallNews.rIS = jSONObject2.optString("activity_url");
                    mallNews.rIQ = jSONObject2.optInt("is_msg_reserved");
                    mallFunction.rID = mallNews;
                }
                arrayList.add(mallFunction);
            }
            return arrayList;
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.MallLogic", e, "", new Object[0]);
            return null;
        }
    }

    public static String buB() {
        TelephonyManager telephonyManager = (TelephonyManager) ab.getContext().getSystemService("phone");
        String str = "";
        if (telephonyManager != null) {
            return telephonyManager.getNetworkCountryIso();
        }
        return str;
    }

    public static void vy(int i) {
        boolean z;
        if ((d.sYN & rIF) == i) {
            ap.yY();
            int intValue = ((Integer) c.vr().get(270343, Integer.valueOf(0))).intValue();
            if (i != intValue) {
                w.d("MicroMsg.MallLogic", "Mall reddot show, targetV=" + i + ", clickedV=" + intValue);
                z = true;
                if (z && m.xU()) {
                    w.d("MicroMsg.MallLogic", "Show mall entry redot");
                    com.tencent.mm.q.c.uk().s(262156, true);
                    ap.yY();
                    c.vr().set(270343, Integer.valueOf(i));
                    ap.yY();
                    c.vr().a(a.uIb, Long.valueOf(System.currentTimeMillis()));
                    return;
                }
            }
        }
        z = false;
        if (z) {
        }
    }
}
