package com.tencent.mm.plugin.offline.a;

import com.tencent.mars.smc.IDKey;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.plugin.appbrand.jsapi.map.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.wallet_core.c.a;
import com.tencent.mm.wallet_core.f.a.h;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class k extends h {
    public static String ocM = TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL;
    public String ocH = "";
    public String ocI = "";
    public String ocJ = "";
    public String ocK = "";
    public String ocL = "";
    public String ocN = "";
    public int ocO = 0;
    public String ocP = "";
    public String ocQ = "";
    public String ocR = "";
    public int ocS = 20000;
    public String token = "";

    public k(Bankcard bankcard, String str, int i) {
        Map hashMap = new HashMap();
        hashMap.put("passwd", str);
        hashMap.put("device_id", p.rB());
        hashMap.put("weixin_ver", "0x" + Integer.toHexString(d.sYN));
        hashMap.put("bind_serialno", bankcard.field_bindSerial);
        hashMap.put("bank_type", bankcard.field_bankcardType);
        hashMap.put("card_tail", bankcard.field_bankcardTail);
        hashMap.put("open_limitfee", String.valueOf(i));
        this.ocS = i;
        String Pq = aa.Pq(aa.Pq(e.getUsername()) + aa.Pq(p.rB()));
        hashMap.put("user_id", Pq);
        hashMap.put("crt_csr", a.cbV().getCertApplyCSR(Pq));
        hashMap.put(Columns.TYPE, ocM);
        hashMap.put("version_number", ocM);
        x(hashMap);
    }

    public final int aki() {
        return 46;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        if (jSONObject != null) {
            this.ocI = jSONObject.optString("crt_crt");
            this.ocH = jSONObject.optString("cn");
            this.token = jSONObject.optString("token");
            this.ocJ = jSONObject.optString("valid_end");
            this.ocK = jSONObject.optString("encrypt_str");
            this.ocL = jSONObject.optString("deviceid");
            if (a.cbV().importCert(this.ocH, this.ocI)) {
                w.i("MicroMsg.NetSceneTenpayWxOfflineCreate", "importCert crt_crt success");
            } else {
                w.e("MicroMsg.NetSceneTenpayWxOfflineCreate", "importCert crt_crt fail");
            }
            this.ocN = jSONObject.optString("token_v2");
            this.ocO = jSONObject.optInt("algorithm_type");
            this.ocP = jSONObject.optString("card_list");
            this.ocQ = jSONObject.optString("key_list");
            this.ocR = jSONObject.optString("token_pin");
            String optString = jSONObject.optString("notice_url");
            String optString2 = jSONObject.optString("auth_codes");
            int optInt = jSONObject.optInt("update_interval");
            String optString3 = jSONObject.optString("code_ver");
            com.tencent.mm.plugin.offline.k.aQd();
            com.tencent.mm.plugin.offline.k.af(196617, this.ocH);
            com.tencent.mm.plugin.offline.k.aQd();
            com.tencent.mm.plugin.offline.k.af(196626, this.ocJ);
            com.tencent.mm.plugin.offline.k.aQd();
            com.tencent.mm.plugin.offline.k.af(196627, this.ocK);
            com.tencent.mm.plugin.offline.k.aQd();
            com.tencent.mm.plugin.offline.k.af(196628, this.ocL);
            com.tencent.mm.plugin.offline.k.aQd();
            com.tencent.mm.plugin.offline.k.af(196630, "1");
            com.tencent.mm.plugin.offline.k.aQd();
            com.tencent.mm.plugin.offline.k.af(196632, (System.currentTimeMillis() / 1000));
            com.tencent.mm.plugin.offline.c.a.i(this.token, this.ocN, this.ocP, this.ocQ);
            com.tencent.mm.plugin.offline.c.a.qR(this.ocO);
            com.tencent.mm.plugin.offline.k.aQd();
            com.tencent.mm.plugin.offline.k.af(196647, this.ocR);
            com.tencent.mm.plugin.offline.c.a.Cd(optString);
            com.tencent.mm.plugin.offline.k.aQd();
            optString = com.tencent.mm.plugin.offline.k.qL(196617);
            a.cbV();
            a.clearToken(optString);
            a.cbV();
            w.i("MicroMsg.NetSceneTenpayWxOfflineCreate", "offlinecreate isOk %s cn: %s", new Object[]{Boolean.valueOf(a.setTokens(this.ocH, optString2)), this.ocH});
            if (a.setTokens(this.ocH, optString2)) {
                w.i("MicroMsg.NetSceneTenpayWxOfflineCreate", "CertUtil.getInstance().setTokens success!");
            } else {
                w.e("MicroMsg.NetSceneTenpayWxOfflineCreate", "CertUtil.getInstance().setTokens failed!");
                StringBuilder stringBuilder = new StringBuilder("WalletOfflineEntranceUI CertUtil.getInstance().getLastError():");
                a.cbV();
                w.e("MicroMsg.NetSceneTenpayWxOfflineCreate", stringBuilder.append(a.getLastError()).toString());
            }
            com.tencent.mm.plugin.offline.k.aQd();
            com.tencent.mm.plugin.offline.k.af(196649, String.valueOf(optInt));
            ap.yY();
            c.vr().a(com.tencent.mm.storage.w.a.uzm, p.rA());
            ap.yY();
            c.vr().a(com.tencent.mm.storage.w.a.uzn, optString3);
        }
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.p pVar, byte[] bArr) {
        super.a(i, i2, i3, str, pVar, bArr);
        if (!(i2 == 0 && i3 == 0)) {
            com.tencent.mm.plugin.offline.k.aQd();
            com.tencent.mm.plugin.offline.k.af(196630, "0");
        }
        ArrayList arrayList = new ArrayList();
        IDKey iDKey = new IDKey();
        iDKey.SetID(b.CTRL_INDEX);
        iDKey.SetValue(1);
        iDKey.SetKey(11);
        IDKey iDKey2 = new IDKey();
        iDKey2.SetID(b.CTRL_INDEX);
        iDKey2.SetValue(1);
        if (i3 == 0 && i3 == 0) {
            iDKey2.SetKey(9);
        } else {
            iDKey2.SetKey(10);
        }
        arrayList.add(iDKey);
        arrayList.add(iDKey2);
        g.oUh.b(arrayList, true);
    }

    public final void a(com.tencent.mm.wallet_core.c.c cVar, JSONObject jSONObject) {
        a.cbV().cbW();
    }

    public final int zi() {
        return 565;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/offlinecreate";
    }
}
