package com.tencent.mm.plugin.wallet.pay.a.b;

import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.wallet.pay.a.c;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.aa;
import com.tencent.mm.pluginsdk.l.a;
import com.tencent.mm.pluginsdk.l.d;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.wallet_core.c.m;
import com.tencent.mm.wallet_core.f.a.h;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class e extends h {
    private int fRv = 0;
    public String fZb;
    public String fZc;
    public String fZd;
    public String fZe;
    public String fZf;
    public Orders oSJ = null;
    private String ryT = null;
    public c ryU = null;
    private int scene = 0;

    public e(PayInfo payInfo, int i) {
        if (payInfo == null) {
            w.e("MicroMsg.NetSceneTenpayQueryOrderInfoByQRCode", "error payinfo is null %s", new Object[]{bg.bJZ().toString()});
            this.ryT = "";
        } else {
            this.ryT = payInfo.fJH;
        }
        this.scene = i;
        Map hashMap = new HashMap();
        Map hashMap2 = new HashMap();
        hashMap.put("support_cardtag3", "1");
        hashMap.put("req_key", this.ryT);
        hashMap.put("bind_query_scene", String.valueOf(i));
        hashMap.put("is_merge", "1");
        d dVar = a.sBC;
        hashMap.put("is_root", "0");
        if (dVar == null || !dVar.auT()) {
            hashMap.put("is_device_open_touch", "0");
            w.i("MicroMsg.NetSceneTenpayQueryOrderInfoByQRCode", "is_device_open_touch is false");
        } else {
            hashMap.put("is_device_open_touch", "1");
            Map avh = dVar.avh();
            if (avh != null) {
                hashMap.putAll(avh);
            }
            w.i("MicroMsg.NetSceneTenpayQueryOrderInfoByQRCode", "is_device_open_touch is true");
        }
        if (payInfo != null) {
            this.fRv = payInfo.fRv;
        }
        a(payInfo, hashMap, hashMap2);
        x(hashMap);
        am(hashMap2);
    }

    public final int aki() {
        return MMGIFException.D_GIF_ERR_IMAGE_DEFECT;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        c cVar = null;
        try {
            this.oSJ = Orders.L(jSONObject);
            if (this.oSJ != null) {
                this.oSJ.fJH = this.ryT;
            }
            long optLong = jSONObject.optJSONObject("bindqueryresp").optLong("time_stamp");
            if (optLong > 0) {
                m.setTimeStamp(String.valueOf(optLong));
            } else {
                w.w("MicroMsg.NetSceneTenpayQueryOrderInfoByQRCode", "no time_stamp in qrcodeusebindquery.");
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("query_order_info");
            if (optJSONObject != null) {
                w.i("MicroMsg.NetSceneTenpayQueryOrderInfoByQRCode", "get query_order_info");
                com.tencent.mm.plugin.wallet_core.model.m.btS().rIu = optJSONObject.optInt("query_order_time", 5) * 1000;
                com.tencent.mm.plugin.wallet_core.model.m.btS().aMo = optJSONObject.optInt("query_order_count", 0);
                com.tencent.mm.plugin.wallet_core.model.m.btS().rIv = optJSONObject.optString("default_query_order_wording", "");
            }
            com.tencent.mm.plugin.wallet_core.model.m.btS().rIw = jSONObject.optString("pay_remind_wording");
            aa.a(jSONObject.optJSONObject("bindqueryresp"), this.fRv);
            d dVar = a.sBC;
            if (dVar != null) {
                w.i("MicroMsg.NetSceneTenpayQueryOrderInfoByQRCode", "IFingerPrintMgr is not null");
                dVar.avb();
            } else {
                w.e("MicroMsg.NetSceneTenpayQueryOrderInfoByQRCode", "IFingerPrintMgr is null");
            }
            if (jSONObject.has("real_name_info")) {
                optJSONObject = jSONObject.optJSONObject("real_name_info");
                this.fZb = optJSONObject.optString("guide_flag");
                this.fZc = optJSONObject.optString("guide_wording");
                this.fZd = optJSONObject.optString("left_button_wording");
                this.fZe = optJSONObject.optString("right_button_wording");
                this.fZf = optJSONObject.optString("upload_credit_url");
            }
            if (jSONObject.has("user_notify_info")) {
                optJSONObject = jSONObject.optJSONObject("user_notify_info");
                if (optJSONObject != null) {
                    int optInt = optJSONObject.optInt("notify_flag", 0);
                    String optString = optJSONObject.optString("notify_wording", "");
                    String optString2 = optJSONObject.optString("left_button_wording", "");
                    String optString3 = optJSONObject.optString("right_button_wording", "");
                    String optString4 = optJSONObject.optString("confirm_button_wording", "");
                    if (optInt != 0) {
                        cVar = new c();
                        cVar.ryG = optInt;
                        cVar.ryH = optString;
                        cVar.nnP = optString2;
                        cVar.nnQ = optString3;
                        cVar.ryI = optString4;
                    }
                }
                this.ryU = cVar;
            }
        } catch (Exception e) {
            w.e("MicroMsg.NetSceneTenpayQueryOrderInfoByQRCode", "hy: " + e.toString());
        }
    }

    public int zi() {
        return 1593;
    }

    public String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/qrcodeusebindquery";
    }
}
