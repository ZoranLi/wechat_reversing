package com.tencent.mm.plugin.remittance.c;

import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.wallet_core.b.a.a;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class d extends a {
    public String desc;
    public long fZT;
    public int kAM;
    public String kAN;
    public String kAO;
    public String kAP;
    public String kAQ;
    public int kAR;
    public String oQl;
    public String oQm;
    public String oQn;

    public d(String str) {
        Map hashMap = new HashMap();
        try {
            if (!bg.mA(str)) {
                hashMap.put("qrcode_url", URLEncoder.encode(str, "UTF-8"));
            }
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.NetSceneH5F2fTransferScanQrCode", e, "", new Object[0]);
        }
        x(hashMap);
        w.i("MicroMsg.NetSceneH5F2fTransferScanQrCode", "qrcode_url: %s", new Object[]{str});
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        this.oQl = jSONObject.optString("recv_username", "");
        this.kAQ = jSONObject.optString("recv_realname", "");
        this.oQm = jSONObject.optString("recv_nickname", "");
        this.desc = jSONObject.optString("desc", "");
        this.fZT = jSONObject.optLong("amount", 0);
        this.kAR = jSONObject.optInt("set_amount", 0);
        this.kAM = jSONObject.optInt("currency", 0);
        this.kAN = jSONObject.optString("currencyunit", "");
        this.oQn = jSONObject.optString("qrcodeid", "");
        this.kAO = jSONObject.optString("notice", "");
        this.kAP = jSONObject.optString("notice_url", "");
        w.i("MicroMsg.NetSceneH5F2fTransferScanQrCode", "recv_username: %s, recv_nickname: %s, desc: %s, amount: %s, setAmount: %s, currencyunit: %s", new Object[]{this.oQl, this.oQm, this.desc, Long.valueOf(this.fZT), Integer.valueOf(this.kAR), this.kAN});
        w.d("MicroMsg.NetSceneH5F2fTransferScanQrCode", "recv_realname: %s", new Object[]{this.kAQ});
    }

    public final String akf() {
        return "/cgi-bin/mmpay-bin/h5f2ftransferscanqrcode";
    }

    public final int getType() {
        return 1301;
    }

    public final int akg() {
        return 1301;
    }
}
