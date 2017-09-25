package com.tencent.mm.plugin.wallet_core.b;

import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.Orders.DiscountInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.wallet_core.f.a.h;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class n extends h {
    public Orders rCc;

    public n(String str) {
        Map hashMap = new HashMap();
        hashMap.put("trans_id", str);
        x(hashMap);
    }

    public n(String str, int i) {
        Map hashMap = new HashMap();
        hashMap.put("trans_id", str);
        hashMap.put("pay_type", String.valueOf(i));
        x(hashMap);
    }

    public final int aki() {
        return 3;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                JSONObject jSONObject2;
                this.rCc = new Orders();
                Commodity commodity = new Commodity();
                commodity.ofM = jSONObject.getString("buy_uin");
                commodity.ofN = jSONObject.getString("buy_name");
                commodity.ofO = jSONObject.optString("sale_uin");
                commodity.ofP = jSONObject.optString("sale_name");
                commodity.fTA = jSONObject.getString("trans_id");
                commodity.desc = jSONObject.optString("goods_name");
                commodity.kBc = jSONObject.optDouble("pay_num") / 100.0d;
                commodity.ofT = jSONObject.getString("trade_state");
                commodity.ofU = jSONObject.getString("trade_state_name");
                commodity.ofY = jSONObject.getString("buy_bank_name");
                commodity.ogf = jSONObject.optString("discount", "");
                commodity.ofW = jSONObject.optInt("modify_timestamp");
                commodity.oga = jSONObject.optString("fee_type");
                commodity.ogb = jSONObject.optString("appusername");
                commodity.ofD = jSONObject.optString("app_telephone");
                commodity.rGs = jSONObject.optDouble("original_total_fee", -1.0d) / 100.0d;
                commodity.oga = jSONObject.optString("fee_type", "");
                int i2 = 1;
                JSONObject optJSONObject = jSONObject.optJSONObject("subscribe_biz_info");
                if (optJSONObject != null) {
                    b bVar = new b();
                    bVar.type = Orders.rGq;
                    bVar.name = optJSONObject.optString("nickname");
                    bVar.ogb = optJSONObject.optString("username");
                    commodity.rGt = bVar.ogb;
                    bVar.oqk = optJSONObject.optString("logo_round_url");
                    bVar.url = optJSONObject.optString("subscribe_biz_url");
                    i2 = optJSONObject.optInt("recommend_level");
                    commodity.rFV = i2;
                    if (!bg.mA(bVar.name)) {
                        commodity.rGz.add(bVar);
                    }
                }
                int i3 = i2;
                JSONArray jSONArray = jSONObject.getJSONArray("activity_info");
                int length = jSONArray.length();
                for (i2 = 0; i2 < length; i2++) {
                    jSONObject2 = jSONArray.getJSONObject(i2);
                    b bVar2 = new b();
                    bVar2.type = Orders.rGr;
                    bVar2.oqk = jSONObject2.optString("icon");
                    bVar2.name = jSONObject2.optString("wording");
                    bVar2.url = jSONObject2.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                    bVar2.rGG = jSONObject2.optString("btn_text");
                    bVar2.rGH = jSONObject2.optInt(Columns.TYPE);
                    bVar2.title = jSONObject2.optString("title");
                    bVar2.rGI = jSONObject2.optLong("activity_id");
                    bVar2.rGJ = jSONObject2.optInt("activity_type", 0);
                    bVar2.rGK = jSONObject2.optInt("award_id");
                    bVar2.rGL = jSONObject2.optInt("send_record_id");
                    bVar2.rGM = jSONObject2.optInt("user_record_id");
                    bVar2.rGO = jSONObject2.optString("activity_tinyapp_username");
                    bVar2.rGP = jSONObject2.optString("activity_tinyapp_path");
                    bVar2.rGQ = jSONObject2.optLong("activity_mch_id");
                    commodity.rGz.add(bVar2);
                }
                jSONArray = jSONObject.optJSONArray("discount_array");
                if (jSONArray != null && jSONArray.length() > 0) {
                    length = jSONArray.length();
                    commodity.rGv = new ArrayList();
                    for (i2 = 0; i2 < length; i2++) {
                        jSONObject2 = jSONArray.optJSONObject(i2);
                        DiscountInfo discountInfo = new DiscountInfo();
                        discountInfo.rGF = jSONObject2.optDouble("payment_amount");
                        discountInfo.rxH = jSONObject2.optString("favor_desc");
                        commodity.rGv.add(discountInfo);
                    }
                }
                commodity.rGw = jSONObject.optString("rateinfo");
                commodity.rGx = jSONObject.optString("original_feeinfo");
                this.rCc.rGe = new ArrayList();
                this.rCc.rGe.add(commodity);
                this.rCc.rFX = jSONObject.optString("trade_state_name");
                this.rCc.rFV = i3;
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.NetSceneTenpayQueryOrderInfo", e, "", new Object[0]);
            } catch (Throwable e2) {
                w.printErrStackTrace("MicroMsg.NetSceneTenpayQueryOrderInfo", e2, "", new Object[0]);
            }
        }
    }
}
