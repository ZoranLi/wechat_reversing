package com.tencent.mm.plugin.offline.a;

import android.text.TextUtils;
import com.tencent.gmtrace.Constants;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.offline.k;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class m extends h {
    public String ocJ;
    public String ocK;
    public String ocL;
    public String ocN;
    public int ocO;
    public String ocP;
    public String ocQ;
    public String ocR;
    private String ocT;
    private int ocU;
    public String ocV;
    public int ocW;
    public String token;

    public m(String str, int i) {
        this(str, i, i);
    }

    public m(String str, int i, int i2) {
        int i3;
        CharSequence genUserSig;
        this.token = "";
        this.ocJ = "";
        this.ocK = "";
        this.ocL = "";
        this.ocN = "";
        this.ocO = 0;
        this.ocP = "";
        this.ocQ = "";
        this.ocR = "";
        this.ocW = 0;
        w.v("MicroMsg.NetSceneTenpayWxOfflineGetToken", "scene %s stack %s ", new Object[]{Integer.valueOf(i), bg.bJZ().toString()});
        Object aQZ = a.aQZ();
        k.aQd();
        String qL = k.qL(196628);
        if (TextUtils.isEmpty(qL)) {
            qL = p.rB();
        }
        if (TextUtils.isEmpty(aQZ)) {
            qL = qL + "&" + str + "&" + (((int) (Math.random() * 1000000.0d)) + Constants.MAX_BUFFER_SIZE);
        } else {
            qL = qL + "&" + str + "&" + (((int) (Math.random() * 1000000.0d)) + Constants.MAX_BUFFER_SIZE) + "&" + aQZ;
        }
        Map hashMap = new HashMap();
        hashMap.put("token_src", qL);
        String str2 = "";
        k.aQd();
        String qL2 = k.qL(196617);
        switch (i2) {
            case 0:
                i3 = 12;
                break;
            case 1:
                i3 = 13;
                break;
            case 2:
                i3 = 14;
                break;
            case 3:
                i3 = 15;
                break;
            case 4:
                i3 = 16;
                break;
            case 5:
                i3 = 17;
                break;
            case 6:
                i3 = 18;
                break;
            case 7:
                i3 = 19;
                break;
            case 8:
                i3 = 20;
                break;
            case 9:
                i3 = 24;
                break;
            case 10:
                i3 = 72;
                break;
            default:
                i3 = 12;
                break;
        }
        g.oUh.a(135, (long) i3, 1, true);
        com.tencent.mm.wallet_core.c.a.cbV();
        if (com.tencent.mm.wallet_core.c.a.isCertExist(qL2)) {
            com.tencent.mm.wallet_core.c.a.cbV();
            genUserSig = com.tencent.mm.wallet_core.c.a.genUserSig(qL2, qL);
            w.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", "CertUtil.getInstance().isCertExist(cn) true");
        } else {
            StringBuilder stringBuilder = new StringBuilder("NetSceneTenpayWxOfflineGetToken CertUtil.getInstance().getLastError():");
            com.tencent.mm.wallet_core.c.a.cbV();
            w.e("MicroMsg.NetSceneTenpayWxOfflineGetToken", stringBuilder.append(com.tencent.mm.wallet_core.c.a.getLastError()).toString());
            g.oUh.a(135, 6, 1, true);
            ap.yY();
            qL = (String) c.vr().get(com.tencent.mm.storage.w.a.uzm, "");
            if (qL == null || !qL.equals(p.rA())) {
                w.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", " NetSceneTenpayWxOfflineGetToken iemi is diff between create and getToken");
                g.oUh.a(135, 5, 1, true);
            } else {
                w.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", " NetSceneTenpayWxOfflineGetToken iemi is same between create and getToken");
            }
            w.e("MicroMsg.NetSceneTenpayWxOfflineGetToken", " NetSceneTenpayWxOfflineGetToken CertUtil.getInstance().isCertExist return false! cn: " + qL2);
            Object obj = str2;
        }
        if (TextUtils.isEmpty(genUserSig)) {
            w.e("MicroMsg.NetSceneTenpayWxOfflineGetToken", " NetSceneTenpayWxOfflineGetToken sign is empty!");
            g.oUh.a(135, 4, 1, true);
        } else {
            w.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", "sign is valid");
        }
        hashMap.put("sign", genUserSig);
        hashMap.put("cert_no", qL2);
        hashMap.put(Columns.TYPE, k.ocM);
        hashMap.put("version_number", k.ocM);
        if (a.aQY() == 2) {
            hashMap.put("last_token", a.aRa());
        } else {
            hashMap.put("last_token", a.aQZ());
        }
        hashMap.put("scene", String.valueOf(i));
        w.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", "inOfflineUI: %B", new Object[]{Boolean.valueOf(k.oci)});
        if (k.oci) {
            hashMap.put("fetch_tag", "1");
        } else {
            hashMap.put("fetch_tag", "0");
        }
        x(hashMap);
    }

    public final int aki() {
        return 52;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        w.d("MicroMsg.NetSceneTenpayWxOfflineGetToken", "errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), str});
        if (i == 0) {
            this.token = jSONObject.optString("token");
            this.ocJ = jSONObject.optString("valid_end");
            this.ocK = jSONObject.optString("encrypt_str");
            this.ocL = jSONObject.optString("deviceid");
            this.ocN = jSONObject.optString("token_v2");
            this.ocO = jSONObject.optInt("algorithm_type");
            this.ocP = jSONObject.optString("card_list");
            this.ocQ = jSONObject.optString("key_list");
            this.ocR = jSONObject.optString("token_pin");
            this.ocT = jSONObject.optString("auth_codes");
            this.ocU = jSONObject.optInt("update_interval");
            this.ocV = jSONObject.optString("code_ver");
            this.ocW = jSONObject.optInt("reget_token_num", 0);
            if (this.ocW > 0) {
                k.ocj = this.ocW;
            } else {
                k.ocj = 10;
            }
            w.d("MicroMsg.NetSceneTenpayWxOfflineGetToken", "json: %s", new Object[]{jSONObject.toString()});
        }
    }

    public final void aQk() {
        w.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", "do save token");
        k.aQd();
        k.af(196626, this.ocJ);
        k.aQd();
        k.af(196627, this.ocK);
        k.aQd();
        k.af(196628, this.ocL);
        k.aQd();
        k.af(196632, (System.currentTimeMillis() / 1000));
        a.i(this.token, this.ocN, this.ocP, this.ocQ);
        a.qR(this.ocO);
        k.aQd();
        k.af(196647, this.ocR);
        k.aQd();
        String qL = k.qL(196617);
        com.tencent.mm.wallet_core.c.a.cbV();
        com.tencent.mm.wallet_core.c.a.clearToken(qL);
        com.tencent.mm.wallet_core.c.a.cbV();
        if (com.tencent.mm.wallet_core.c.a.setTokens(qL, this.ocT)) {
            w.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", "CertUtil.getInstance().setTokens success!");
        } else {
            w.e("MicroMsg.NetSceneTenpayWxOfflineGetToken", "CertUtil.getInstance().setTokens failed!");
            StringBuilder stringBuilder = new StringBuilder("WalletOfflineEntranceUI CertUtil.getInstance().getLastError():");
            com.tencent.mm.wallet_core.c.a.cbV();
            w.e("MicroMsg.NetSceneTenpayWxOfflineGetToken", stringBuilder.append(com.tencent.mm.wallet_core.c.a.getLastError()).toString());
        }
        k.aQd();
        k.af(196649, this.ocU);
        ap.yY();
        c.vr().a(com.tencent.mm.storage.w.a.uzn, this.ocV);
    }

    public final int zi() {
        return 571;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/offlinegettoken";
    }
}
