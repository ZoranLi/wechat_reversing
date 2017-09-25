package com.tencent.mm.plugin.wallet.pay.a.a;

import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.pluginsdk.l.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.wallet_core.c.n;
import com.tencent.mm.wallet_core.f.a.i;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class b extends i {
    private Map<String, String> ryJ;
    private Map<String, String> ryK;
    public boolean ryL;
    public Orders ryM;
    public Authen ryN;
    public String ryO;
    public String ryP;
    public String token;

    public b(Authen authen, Orders orders) {
        this(authen, orders, false);
    }

    public b(Authen authen, Orders orders, boolean z) {
        this(authen, orders, z, (byte) 0);
    }

    private b(Authen authen, Orders orders, boolean z, byte b) {
        String str = null;
        this.ryL = false;
        this.ryM = null;
        this.token = null;
        this.ryO = null;
        this.ryP = null;
        this.ryN = authen;
        this.ryM = orders;
        if (authen == null) {
            throw new IllegalArgumentException("authen == null");
        }
        List list = orders.rGe;
        if (list.size() > 0) {
            str = ((Commodity) list.get(0)).fTA;
        }
        a(orders.fJH, str, authen.oLz.fRv, authen.oLz.fRr, authen.ofd, authen.ofe);
        if (authen.oLz == null) {
            throw new IllegalArgumentException("authen.payInfo == null");
        }
        w.i("MicroMsg.NetSceneTenpayAuthen", "pay channel :" + authen.oLz.fRr);
        this.ryJ = new HashMap();
        this.ryK = new HashMap();
        boolean z2 = (z || bg.mA(this.ryN.rDC)) ? false : true;
        w.i("MicroMsg.NetSceneTenpayAuthen", "hy: has pwd: %b", new Object[]{Boolean.valueOf(z2)});
        a(authen.oLz, this.ryJ, this.ryK, z2);
        if (z) {
            this.ryJ.put("brief_reg", "1");
        } else {
            this.ryJ.put("passwd", authen.rDC);
        }
        this.rGn = orders.rGn;
        this.ryJ.put("default_favorcomposedid", authen.rDN);
        this.ryJ.put("favorcomposedid", authen.rDO);
        this.ryJ.put("arrive_type", authen.rDK);
        this.ryJ.put("sms_flag", authen.rDP);
        this.ryJ.put("ban_sms_bind_serial", authen.rDQ);
        this.ryJ.put("ban_sms_bank_type", authen.rDR);
        this.ryJ.put("busi_sms_flag", authen.rDS);
        this.ryJ.put("buttontype", authen.oLz.sYm);
        w.i("MicroMsg.NetSceneTenpayAuthen", "buttontype %s not_support_retry %s", new Object[]{Integer.valueOf(authen.oLz.sYm), Integer.valueOf(this.rGn)});
        switch (authen.fRW) {
            case 1:
                this.ryJ.put("flag", "1");
                this.ryJ.put("bank_type", authen.ofd);
                this.ryJ.put("true_name", authen.rDD);
                this.ryJ.put("identify_card", authen.rDE);
                if (authen.rDF > 0) {
                    this.ryJ.put("cre_type", authen.rDF);
                }
                this.ryJ.put("mobile_no", authen.rBT);
                this.ryJ.put("bank_card_id", authen.rDG);
                if (!bg.mA(authen.rDH)) {
                    this.ryJ.put("cvv2", authen.rDH);
                }
                if (!bg.mA(authen.rDI)) {
                    this.ryJ.put("valid_thru", authen.rDI);
                    break;
                }
                break;
            case 2:
                this.ryJ.put("flag", "2");
                this.ryJ.put("bank_type", authen.ofd);
                this.ryJ.put("h_bind_serial", authen.ofe);
                this.ryJ.put("card_tail", authen.rDJ);
                if (!bg.mA(authen.rDD)) {
                    this.ryJ.put("true_name", authen.rDD);
                }
                if (!bg.mA(authen.rDE)) {
                    this.ryJ.put("identify_card", authen.rDE);
                }
                this.ryJ.put("cre_type", authen.rDF);
                this.ryJ.put("mobile_no", authen.rBT);
                this.ryJ.put("bank_card_id", authen.rDG);
                if (!bg.mA(authen.rDH)) {
                    this.ryJ.put("cvv2", authen.rDH);
                }
                if (!bg.mA(authen.rDI)) {
                    this.ryJ.put("valid_thru", authen.rDI);
                    break;
                }
                break;
            case 3:
                if (authen.rDB == 1) {
                    this.ryJ.put("reset_flag", "1");
                    if (!bg.mA(authen.rBT)) {
                        this.ryJ.put("mobile_no", authen.rBT);
                    }
                    if (!bg.mA(authen.rDH)) {
                        this.ryJ.put("cvv2", authen.rDH);
                    }
                    if (!bg.mA(authen.rDI)) {
                        this.ryJ.put("valid_thru", authen.rDI);
                    }
                }
                this.ryJ.put("flag", TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
                this.ryJ.put("bank_type", authen.ofd);
                this.ryJ.put("bind_serial", authen.ofe);
                break;
            case 4:
                this.ryJ.put("flag", "4");
                this.ryJ.put("bank_type", authen.ofd);
                this.ryJ.put("first_name", authen.rDL);
                this.ryJ.put("last_name", authen.rDM);
                this.ryJ.put("country", authen.country);
                this.ryJ.put("area", authen.gkB);
                this.ryJ.put("city", authen.gkC);
                this.ryJ.put("address", authen.hCE);
                this.ryJ.put("phone_number", authen.mMc);
                this.ryJ.put("zip_code", authen.itg);
                this.ryJ.put("email", authen.gku);
                this.ryJ.put("bank_card_id", authen.rDG);
                if (!bg.mA(authen.rDH)) {
                    this.ryJ.put("cvv2", authen.rDH);
                }
                if (!bg.mA(authen.rDI)) {
                    this.ryJ.put("valid_thru", authen.rDI);
                    break;
                }
                break;
            case 5:
                this.ryJ.put("flag", "5");
                this.ryJ.put("bank_type", authen.ofd);
                this.ryJ.put("first_name", authen.rDL);
                this.ryJ.put("last_name", authen.rDM);
                this.ryJ.put("country", authen.country);
                this.ryJ.put("area", authen.gkB);
                this.ryJ.put("city", authen.gkC);
                this.ryJ.put("address", authen.hCE);
                this.ryJ.put("phone_number", authen.mMc);
                this.ryJ.put("zip_code", authen.itg);
                this.ryJ.put("email", authen.gku);
                this.ryJ.put("bank_card_id", authen.rDG);
                if (!bg.mA(authen.rDH)) {
                    this.ryJ.put("cvv2", authen.rDH);
                }
                if (!bg.mA(authen.rDI)) {
                    this.ryJ.put("valid_thru", authen.rDI);
                }
                this.ryJ.put("h_bind_serial", authen.ofe);
                this.ryJ.put("card_tail", authen.rDJ);
                break;
            case 6:
                if (authen.rDB == 1) {
                    this.ryJ.put("reset_flag", "1");
                    if (!bg.mA(authen.rDH)) {
                        this.ryJ.put("cvv2", authen.rDH);
                    }
                    if (!bg.mA(authen.rDI)) {
                        this.ryJ.put("valid_thru", authen.rDI);
                    }
                }
                this.ryJ.put("phone_number", authen.rBT);
                this.ryJ.put("flag", "6");
                this.ryJ.put("bank_type", authen.ofd);
                this.ryJ.put("bind_serial", authen.ofe);
                break;
        }
        x(this.ryJ);
        Map avj = a.sBC.avj();
        if (avj != null) {
            this.ryK.putAll(avj);
        }
        if (n.ccc()) {
            this.ryK.put("uuid_for_bindcard", n.cce());
            this.ryK.put("bindcard_scene", n.ccd());
        }
        am(this.ryK);
    }

    public final boolean aQi() {
        super.aQi();
        this.ryJ.put("is_repeat_send", "1");
        x(this.ryJ);
        return true;
    }

    public int aki() {
        return 0;
    }

    public void a(int i, String str, JSONObject jSONObject) {
        super.a(i, str, jSONObject);
        w.i("MicroMsg.NetSceneTenpayAuthen", " errCode: " + i + " errMsg :" + str);
        w.d("MicroMsg.NetSceneTenpayAuthen", "banlance_mobile: %s", new Object[]{this.ryO});
        this.ryL = "1".equals(jSONObject.optString("is_free_sms"));
        this.token = jSONObject.optString("token");
        this.ryO = jSONObject.optString("balance_mobile");
        this.ryP = jSONObject.optString("balance_help_url");
        String optString = jSONObject.optString("bind_serial");
        if (!bg.mA(optString)) {
            w.i("MicroMsg.NetSceneTenpayAuthen", "Pay Success! saving bind_serial:" + optString);
        }
        if ("1".equals(jSONObject.optString("pay_flag"))) {
            this.rzL = true;
            this.ryM = Orders.a(jSONObject, this.ryM);
        } else {
            this.rzL = false;
        }
        w.i("MicroMsg.NetSceneTenpayAuthen", "pay_scene:" + this.ryN.oLz.fRv);
        if (i == 0 && this.ryN.oLz.fRv == 39) {
            w.i("MicroMsg.NetSceneTenpayAuthen", "it's the sns scene, parse the sns pay data");
            com.tencent.mm.plugin.wallet_core.d.b.Q(jSONObject);
            return;
        }
        w.i("MicroMsg.NetSceneTenpayAuthen", "it's not the sns scene or occurs error,  errCode:" + i);
    }

    public final String aQZ() {
        return this.token;
    }

    public String getUri() {
        if (this.ryN.oLz.fRv == 11) {
            return "/cgi-bin/mmpay-bin/tenpay/saveauthen";
        }
        if (this.ryN.oLz.fRv == 21) {
            return "/cgi-bin/mmpay-bin/tenpay/fetchauthen";
        }
        return "/cgi-bin/mmpay-bin/tenpay/authen";
    }

    public int zi() {
        if (this.ryN.oLz.fRv == 11) {
            return 1610;
        }
        if (this.ryN.oLz.fRv == 21) {
            return 1605;
        }
        return 461;
    }

    public final boolean bsH() {
        return this.ryN.oLz.sYf == 1;
    }

    public final boolean bsI() {
        if (this.ryN.oLz.fRv == 11 || this.ryN.oLz.fRv == 21) {
            return true;
        }
        return false;
    }
}
