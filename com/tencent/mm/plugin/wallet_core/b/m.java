package com.tencent.mm.plugin.wallet_core.b;

import com.tencent.mm.plugin.wallet_core.model.aa;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.pluginsdk.l.a;
import com.tencent.mm.pluginsdk.l.d;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.wallet_core.f.a.h;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class m extends h {
    public String fZb;
    public String fZc;
    public String fZd;
    public String fZe;
    public String fZf;
    public String fZg;
    public int fZh;
    public String fZi;
    public String fZj;
    public String fZk;
    public String fZl;
    public String fZm;
    public LinkedList<String> fZn;
    private int scene;
    public String title;

    public m(String str) {
        this(str, 0);
    }

    public m(String str, int i) {
        this.fZg = "";
        this.fZh = 0;
        this.fZi = "";
        this.fZj = "";
        this.fZk = "";
        this.fZl = "";
        this.fZm = "";
        this.title = "";
        this.fZn = new LinkedList();
        this.scene = 0;
        Map hashMap = new HashMap();
        this.scene = i;
        hashMap.put("req_key", str);
        hashMap.put("bind_query_scene", String.valueOf(i));
        d dVar = a.sBC;
        hashMap.put("is_root", "0");
        if (dVar != null) {
            hashMap.put("is_device_open_touch", "1");
            Map avh = dVar.avh();
            if (avh != null) {
                hashMap.putAll(avh);
            }
            w.i("MicroMsg.NetSceneTenpayQueryBindBankcard", "is_device_open_touch is true");
        } else {
            hashMap.put("is_device_open_touch", "0");
            w.i("MicroMsg.NetSceneTenpayQueryBindBankcard", "is_device_open_touch is false");
        }
        x(hashMap);
        Map hashMap2 = new HashMap();
        ap.yY();
        String str2 = (String) c.vr().get(196612, null);
        ap.yY();
        String str3 = (String) c.vr().get(196613, null);
        hashMap2.put("bind_serial", str2);
        hashMap2.put("last_bind_serial", str3);
        am(hashMap2);
    }

    public final int aki() {
        return 72;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        if (i == 0) {
            JSONObject optJSONObject;
            if (jSONObject.has("real_name_info")) {
                optJSONObject = jSONObject.optJSONObject("real_name_info");
                w.i("MicroMsg.NetSceneTenpayQueryBindBankcard", "get real_name_info %s", new Object[]{optJSONObject.toString()});
                this.fZb = optJSONObject.optString("guide_flag");
                this.fZc = optJSONObject.optString("guide_wording");
                this.fZd = optJSONObject.optString("left_button_wording");
                this.fZe = optJSONObject.optString("right_button_wording");
                this.fZf = optJSONObject.optString("upload_credit_url");
                this.fZg = optJSONObject.optString("done_button_wording");
                this.fZh = optJSONObject.optInt("is_show_protocol", 0);
                this.fZi = optJSONObject.optString("left_protocol_wording");
                this.fZj = optJSONObject.optString("new_upload_credit_url");
                this.fZk = optJSONObject.optString("protocol_url");
                this.fZl = optJSONObject.optString("right_protocol_wording");
                this.fZm = optJSONObject.optString("subtitle");
                this.title = optJSONObject.optString("title");
                JSONArray optJSONArray = optJSONObject.optJSONArray("upload_reasons");
                this.fZn.clear();
                if (optJSONArray != null) {
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        this.fZn.add(optJSONArray.optString(i2));
                    }
                }
            }
            if (jSONObject.has("paymenu_array") && this.scene == 1) {
                JSONArray optJSONArray2 = jSONObject.optJSONArray("paymenu_array");
                if (optJSONArray2 != null) {
                    u.HV(optJSONArray2.toString());
                }
            }
            long optLong = jSONObject.optLong("time_stamp");
            if (optLong > 0) {
                com.tencent.mm.wallet_core.c.m.setTimeStamp(String.valueOf(optLong));
            } else {
                w.w("MicroMsg.NetSceneTenpayQueryBindBankcard", "no time_stamp in bindquerynew.");
            }
            aa.a(jSONObject, this.scene);
            if (this.scene == 0 || this.scene == 1) {
                optJSONObject = jSONObject.optJSONObject("bind_card_menu");
                if (optJSONObject != null) {
                    w.d("MicroMsg.NetSceneTenpayQueryBindBankcard", "bind card menu: %s", new Object[]{optJSONObject.toString()});
                    ap.yY();
                    c.vr().a(com.tencent.mm.storage.w.a.uIB, optJSONObject.toString());
                } else {
                    ap.yY();
                    c.vr().a(com.tencent.mm.storage.w.a.uIB, "");
                }
            }
            d dVar = a.sBC;
            if (dVar != null) {
                w.i("MicroMsg.NetSceneTenpayQueryBindBankcard", "IFingerPrintMgr is not null");
                dVar.avb();
                dVar.ek(com.tencent.mm.plugin.wallet_core.model.m.btS().buo());
                return;
            }
            w.e("MicroMsg.NetSceneTenpayQueryBindBankcard", "IFingerPrintMgr is null");
        }
    }

    public final int zi() {
        return 1501;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/bindquerynew";
    }
}
