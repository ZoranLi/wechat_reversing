package com.tencent.mm.plugin.wallet_core.b;

import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mm.plugin.wallet_core.id_verify.model.Profession;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.m;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.wallet_core.c.n;
import com.tencent.mm.wallet_core.f.a.h;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class k extends h {
    public String kcJ;
    public String mTimeStamp;
    public List<ElementQuery> rBV;
    public ElementQuery rBW;
    public String rBX;
    private int rBY;
    private int rBZ;
    private int rCa;
    public Profession[] rCb;

    public k(String str, String str2, PayInfo payInfo) {
        this(3, str, str2, payInfo, null, -1, -1);
    }

    public k(String str, String str2, PayInfo payInfo, int i) {
        this(3, str, str2, payInfo, null, -1, i);
    }

    public k(String str, String str2, PayInfo payInfo, String str3, int i, int i2) {
        this(3, str, str2, payInfo, str3, i, i2);
    }

    public k() {
        this(3, null, null, null, null, -1, -1);
    }

    private k(int i, String str, String str2, PayInfo payInfo, String str3, int i2, int i3) {
        this.rBV = null;
        this.rBW = null;
        this.mTimeStamp = null;
        this.kcJ = null;
        this.rBX = null;
        this.rBY = 3;
        this.rCb = null;
        this.kcJ = str2;
        this.rBY = 3;
        Map hashMap = new HashMap();
        Map hashMap2 = new HashMap();
        a(payInfo, hashMap, hashMap2);
        hashMap.put("req_key", str);
        hashMap.put("flag", "4");
        hashMap.put("card_id", str2);
        if (i3 > 0) {
            hashMap.put("realname_scene", String.valueOf(i3));
            w.i("MicroMsg.NetSenceTenPayBase", "realname_scene=%d", new Object[]{Integer.valueOf(i3)});
        }
        if (i2 == 8) {
            hashMap.put("scene", "1003");
        }
        hashMap.put("bank_card_tag", new StringBuilder(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL).toString());
        hashMap.put("token", str3);
        x(hashMap);
        if (n.ccc()) {
            hashMap2.put("uuid_for_bindcard", n.cce());
            hashMap2.put("bindcard_scene", n.ccd());
        }
        am(hashMap2);
    }

    public final int aki() {
        return 73;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        this.rBV = new ArrayList();
        try {
            String str2;
            int i2;
            JSONObject jSONObject2;
            this.mTimeStamp = jSONObject.optString("time_stamp");
            String optString = jSONObject.optString("bank_type");
            if (bg.mA(this.rBX)) {
                str2 = optString;
            } else {
                str2 = this.rBX;
            }
            JSONArray jSONArray = jSONObject.getJSONArray("Array");
            int length = jSONArray.length();
            for (i2 = 0; i2 < length; i2++) {
                jSONObject2 = jSONArray.getJSONObject(i2);
                ElementQuery elementQuery = new ElementQuery();
                elementQuery.hux = jSONObject2;
                elementQuery.mMa = jSONObject2.optString("bank_name");
                elementQuery.ofd = jSONObject2.optString("bank_type");
                elementQuery.rET = jSONObject2.optString("bankacc_type_name");
                elementQuery.rEV = jSONObject2.optString("bank_phone");
                elementQuery.rEY = jSONObject2.optString("forbid_word");
                elementQuery.rEX = jSONObject2.optString("bank_recommend_desc");
                elementQuery.rEW = jSONObject2.optString("bank_app_user_name");
                elementQuery.rES = jSONObject2.optInt("bankacc_type", 1);
                elementQuery.rEL = e.f(jSONObject2, "canModifyName");
                elementQuery.rEM = e.f(jSONObject2, "canModifyCreID");
                elementQuery.rEQ = "0".equals(jSONObject2.optString("is_sure"));
                elementQuery.rEN = "1".equals(jSONObject2.optString("needCVV"));
                elementQuery.rEO = "1".equals(jSONObject2.optString("needValiDate"));
                elementQuery.rEK = jSONObject2.optString("time_stamp");
                elementQuery.rEP = jSONObject2.optString("uesr_name");
                elementQuery.rEU = jSONObject2.optString("bank_flag");
                elementQuery.rEZ = e.f(jSONObject2, "needFirstName");
                elementQuery.rFa = e.f(jSONObject2, "needLastName");
                elementQuery.rFb = e.f(jSONObject2, "needCountry");
                elementQuery.rFc = e.f(jSONObject2, "needArea");
                elementQuery.rFd = e.f(jSONObject2, "needCity");
                elementQuery.rFe = e.f(jSONObject2, "needAddress");
                elementQuery.rFf = e.f(jSONObject2, "needZip");
                elementQuery.rFg = e.f(jSONObject2, "needPhone");
                elementQuery.rFh = e.f(jSONObject2, "needEmail");
                elementQuery.rFk = e.f(jSONObject2, "needShowProtocol");
                elementQuery.rFi = jSONObject2.optString("support_cre_type");
                elementQuery.rBY = jSONObject2.optInt("bank_card_tag", 1);
                if (elementQuery.rBY == 1) {
                    if (!e.f(jSONObject2, "IsSaveYfq")) {
                        elementQuery.rER = 0;
                    } else if (e.f(jSONObject2, "canReturnYfq")) {
                        elementQuery.rER = 4;
                    } else {
                        elementQuery.rER = 3;
                    }
                } else if (jSONObject2.optInt("auth_mode") == 1) {
                    elementQuery.rER = 1;
                } else {
                    elementQuery.rER = 2;
                }
                CharSequence optString2 = jSONObject2.optString("support_micropay");
                if (TextUtils.isEmpty(optString2)) {
                    elementQuery.rFl = true;
                } else if ("1".equals(optString2)) {
                    elementQuery.rFl = true;
                } else if ("0".equals(optString2)) {
                    elementQuery.rFl = false;
                }
                elementQuery.rDK = jSONObject2.optString("arrive_type");
                if (Bankcard.ds(this.rBY, elementQuery.rBY)) {
                    this.rBV.add(elementQuery);
                }
                if (str2 != null && str2.equals(elementQuery.ofd)) {
                    this.rBW = elementQuery;
                }
            }
            SparseArray sparseArray = new SparseArray();
            jSONArray = jSONObject.getJSONArray("cre_type_map");
            length = jSONArray.length();
            for (i2 = 0; i2 < length; i2++) {
                jSONObject2 = jSONArray.getJSONObject(i2);
                int optInt = jSONObject2.optInt("key", 0);
                if (optInt > 0) {
                    sparseArray.put(optInt, jSONObject2.getString("val"));
                }
            }
            o bua = m.bua();
            List list = this.rBV;
            bua.rHA = sparseArray;
            bua.rBV = list;
            this.rBZ = jSONObject.optInt("need_area");
            this.rCa = jSONObject.optInt("need_profession");
            if (!(this.rBW == null || this.rBW.rBY == 1)) {
                w.i("MicroMsg.NetSenceTenPayBase", "oversea card, no need area and profession");
                this.rBZ = 0;
                this.rCa = 0;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("profession_array");
            if (optJSONArray != null) {
                this.rCb = new Profession[optJSONArray.length()];
                for (i2 = 0; i2 < optJSONArray.length(); i2++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                    if (optJSONObject != null) {
                        String optString3 = optJSONObject.optString("profession_name");
                        int optInt2 = optJSONObject.optInt("profession_type");
                        if (bg.mA(optString3)) {
                            w.i("MicroMsg.NetSenceTenPayBase", "empty profession_name!");
                        } else {
                            this.rCb[i2] = new Profession(optString3, optInt2);
                        }
                    }
                }
            }
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.NetSenceTenPayBase", e, "", new Object[0]);
        }
    }

    public final int zi() {
        return 1505;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/elementquerynew";
    }

    public final boolean btu() {
        return this.rBZ == 1;
    }

    public final boolean btv() {
        return this.rCa == 1;
    }
}
