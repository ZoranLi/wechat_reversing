package com.tencent.mm.plugin.remittance.c;

import android.text.TextUtils;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.plugin.wallet_core.model.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.wallet_core.f.a.h;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class g extends h {
    public int boy;
    public String fLT = null;
    public a fVx;
    public String kAj;
    public String oQA;
    public String oQB;
    public String oQC;
    public String oQD;
    public double oQE = 0.0d;
    public int oQp = 0;
    public String oQq;
    public String oQr;
    public double oQs;
    public double oQt;
    public String oQu;
    public boolean oQv;
    public double oQw;
    public String oQx;
    public double oQy;
    public double oQz;
    private int ofL;

    public g(double d, String str, String str2, int i, int i2, String str3, String str4, String str5, int i3) {
        w.i("Micromsg.NetSceneTenpayRemittanceGen", "payScene: %s, channel: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i3)});
        this.oQE = d;
        this.ofL = i;
        Map hashMap = new HashMap();
        hashMap.put("scene", String.valueOf(i));
        hashMap.put("transfer_scene", String.valueOf(i2));
        hashMap.put("fee", Math.round(100.0d * d));
        hashMap.put("fee_type", str);
        hashMap.put("receiver_name", str2);
        try {
            long longValue;
            int i4;
            Map hashMap2;
            if (this.ofL == 33 || this.ofL == 32) {
                w.d("Micromsg.NetSceneTenpayRemittanceGen", "f2f desc: %s, recvDesc: %s", new Object[]{str3, str4});
                if (!bg.mA(str3)) {
                    hashMap.put("f2f_payer_desc", p.encode(str3, "UTF-8"));
                }
                if (!bg.mA(str4)) {
                    hashMap.put("desc", p.encode(str4, "UTF-8"));
                }
                hashMap.put("transfer_qrcode_id", str5);
                if (i2 == 0 || i2 == 2) {
                    ap.yY();
                    longValue = ((Long) c.vr().get(147457, Long.valueOf(0))).longValue();
                    i4 = 0;
                    if ((16 & longValue) != 0) {
                        i4 = 2;
                    } else if ((longValue & 32) != 0) {
                        i4 = 1;
                    }
                    hashMap.put("delay_confirm_flag", String.valueOf(i4));
                    w.d("Micromsg.NetSceneTenpayRemittanceGen", "delay flag: %d", new Object[]{Integer.valueOf(i4)});
                }
                x(hashMap);
                if (this.ofL != 32 || this.ofL == 33) {
                    hashMap2 = new HashMap();
                    hashMap2.put("channel", String.valueOf(i3));
                    am(hashMap2);
                }
                return;
            }
            if (!bg.mA(str3)) {
                hashMap.put("desc", p.encode(str3, "UTF-8"));
            }
            hashMap.put("transfer_qrcode_id", str5);
            ap.yY();
            longValue = ((Long) c.vr().get(147457, Long.valueOf(0))).longValue();
            i4 = 0;
            if ((16 & longValue) != 0) {
                i4 = 2;
            } else if ((longValue & 32) != 0) {
                i4 = 1;
            }
            hashMap.put("delay_confirm_flag", String.valueOf(i4));
            w.d("Micromsg.NetSceneTenpayRemittanceGen", "delay flag: %d", new Object[]{Integer.valueOf(i4)});
            x(hashMap);
            if (this.ofL != 32) {
            }
            hashMap2 = new HashMap();
            hashMap2.put("channel", String.valueOf(i3));
            am(hashMap2);
        } catch (UnsupportedEncodingException e) {
            w.e("Micromsg.NetSceneTenpayRemittanceGen", e.getMessage(), new Object[]{e});
        }
    }

    public final int zi() {
        if (this.ofL == 32 || this.ofL == 33) {
            return 1582;
        }
        return 1544;
    }

    public final int aki() {
        return 0;
    }

    public final String getUri() {
        if (this.ofL == 32 || this.ofL == 33) {
            return "/cgi-bin/mmpay-bin/f2fplaceorder";
        }
        return "/cgi-bin/mmpay-bin/transferplaceorder";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        boolean z = true;
        w.d("Micromsg.NetSceneTenpayRemittanceGen", "errCode " + i + " errMsg: " + str);
        if (i == 0 || i == 2) {
            if (jSONObject.has("used_fee")) {
                this.oQz = jSONObject.optDouble("used_fee");
            } else {
                w.e("Micromsg.NetSceneTenpayRemittanceGen", "remain_fee is null");
            }
            this.fLT = jSONObject.optString("req_key");
            this.oQp = jSONObject.optInt("tansfering_num", 0);
            this.oQq = jSONObject.optString("transfer_interrupt_desc");
            this.oQr = jSONObject.optString("appmsgcontent");
            this.oQu = jSONObject.optString("transfer_interrupt_charge_desc");
            if (jSONObject.optInt("is_show_charge") != 1) {
                z = false;
            }
            this.oQv = z;
            this.oQA = jSONObject.optString("receiver_true_name");
            this.oQB = jSONObject.optString("f2f_id", "");
            this.kAj = jSONObject.optString("trans_id", "");
            this.oQC = jSONObject.optString("extend_str", "");
            this.oQD = jSONObject.optString("receiver_open_id", "");
            this.boy = jSONObject.optInt("amount", 0);
            if (bg.mA(this.oQA)) {
                w.e("Micromsg.NetSceneTenpayRemittanceGen", "receiver_true_name is null");
            }
            if (jSONObject.has("remain_fee")) {
                this.oQw = jSONObject.optDouble("remain_fee");
            } else {
                w.e("Micromsg.NetSceneTenpayRemittanceGen", "remain_fee is null");
            }
            if (jSONObject.has("exceed_fee")) {
                this.oQy = jSONObject.optDouble("exceed_fee");
            } else {
                w.e("Micromsg.NetSceneTenpayRemittanceGen", "exceed_fee is null");
            }
            if (jSONObject.has("charge_fee")) {
                this.oQs = jSONObject.optDouble("charge_fee");
            } else {
                w.e("Micromsg.NetSceneTenpayRemittanceGen", "charge_fee is null");
            }
            if (jSONObject.has("free_limit")) {
                this.oQt = jSONObject.optDouble("free_limit");
            } else {
                w.e("Micromsg.NetSceneTenpayRemittanceGen", "free_limit is null");
            }
            if (jSONObject.has("showmessage")) {
                w.i("Micromsg.NetSceneTenpayRemittanceGen", "has alert item");
                a aVar = new a();
                JSONObject optJSONObject = jSONObject.optJSONObject("showmessage");
                aVar.nnP = optJSONObject.optString("left_button_wording");
                aVar.nnQ = optJSONObject.optString("right_button_wording");
                aVar.kAJ = optJSONObject.optString("right_button_url");
                this.fVx = aVar;
                this.fVx.fNG = str;
            }
            if (TextUtils.isEmpty(this.oQr)) {
                w.e("Micromsg.NetSceneTenpayRemittanceGen", "appmsgcontent is null");
            }
        }
    }

    public final boolean aXd() {
        return true;
    }
}
