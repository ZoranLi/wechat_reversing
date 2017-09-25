package com.tencent.mm.plugin.collect.b;

import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.wallet_core.b.a.a;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class j extends a {
    public String desc;
    public long fZT;
    public int kAC;
    public String kAD;
    public String kAE;
    public int kAF;
    public String kAG;
    public String kAH;
    public String kAI;
    public String kAJ;
    public String kAK;
    public String kAL;
    public int kAM;
    public String kAN;
    public String kAO;
    public String kAP;
    public String kAQ;
    public int kAR;

    public j(int i) {
        Map hashMap = new HashMap();
        hashMap.put("set_amount", "0");
        hashMap.put("wallet_type", String.valueOf(i));
        x(hashMap);
        w.i("MicroMsg.NetSceneH5F2fTransferGetQrCode", "setAmount: %s, walletType: %s", new Object[]{Integer.valueOf(0), Integer.valueOf(i)});
    }

    public j(long j, String str, int i) {
        Map hashMap = new HashMap();
        hashMap.put("amount", String.valueOf(j));
        hashMap.put("set_amount", "1");
        try {
            if (!bg.mA(str)) {
                hashMap.put("desc", URLEncoder.encode(str, "UTF-8"));
            }
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.NetSceneH5F2fTransferGetQrCode", e, "", new Object[0]);
        }
        hashMap.put("wallet_type", String.valueOf(i));
        x(hashMap);
        this.fZT = j;
        this.desc = str;
        w.i("MicroMsg.NetSceneH5F2fTransferGetQrCode", "amount: %d, setAmount: %s, desc: %s, walletType: %s", new Object[]{Long.valueOf(j), Integer.valueOf(1), str, Integer.valueOf(i)});
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        this.kAC = jSONObject.optInt("retcode", 0);
        this.kAD = jSONObject.optString("retmsg", "");
        this.kAE = jSONObject.optString("qrcode_url", "");
        this.kAF = jSONObject.optInt("alert_type", 0);
        this.kAG = jSONObject.optString("alert_title", "");
        this.kAH = jSONObject.optString("left_button_text", "");
        this.kAI = jSONObject.optString("right_button_text", "");
        this.kAJ = jSONObject.optString("right_button_url", "");
        this.kAK = jSONObject.optString("bottom_text", "");
        this.kAL = jSONObject.optString("bottom_url", "");
        this.kAM = jSONObject.optInt("currency", 0);
        this.kAN = jSONObject.optString("currencyunit", "");
        this.kAO = jSONObject.optString("notice", "");
        this.kAP = jSONObject.optString("notice_url", "");
        this.kAQ = jSONObject.optString("recv_realname", "");
        this.kAR = jSONObject.optInt("set_amount", 0);
        if (this.kAR == 0) {
            ap.yY();
            c.vr().a(com.tencent.mm.storage.w.a.uHG, this.kAE);
            w.i("MicroMsg.NetSceneH5F2fTransferGetQrCode", "set payurl: %s", new Object[]{this.kAE});
        }
        w.d("MicroMsg.NetSceneH5F2fTransferGetQrCode", "url: %s, currency: %s", new Object[]{this.kAE, Integer.valueOf(this.kAM)});
    }

    public final String akf() {
        return "/cgi-bin/mmpay-bin/h5f2ftransfergetqrcode";
    }

    public final int getType() {
        return 1335;
    }

    public final int akg() {
        return 1335;
    }

    public final boolean akh() {
        return true;
    }
}
