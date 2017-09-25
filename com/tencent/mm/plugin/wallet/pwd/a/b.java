package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.mm.compatible.d.p;
import com.tencent.mm.plugin.wallet_core.model.m;
import com.tencent.mm.plugin.wallet_core.model.y;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.wallet_core.c.q;
import com.tencent.mm.wallet_core.f.a.h;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class b extends h {
    public int rAF;
    public String rAG;
    public int rAH;
    public String rAI;
    public String rAJ;

    public b() {
        Map hashMap = new HashMap();
        hashMap.put("deviceid", p.getDeviceID(ab.getContext()));
        x(hashMap);
    }

    public final int aki() {
        return 0;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        w.i("MicroMsg.NetSceneTenpayPayManager", "errCode:" + i + ";errMsg:" + str);
        w.d("MicroMsg.NetSceneTenpayPayManager", "json: %s", new Object[]{jSONObject.toString()});
        if (i == 0) {
            String optString = jSONObject.optString("is_show_deduct", "0");
            if (!tb(optString)) {
                optString = "0";
            }
            this.rAF = Integer.valueOf(optString).intValue();
            this.rAG = jSONObject.optString("deduct_show_url", "");
            optString = jSONObject.optString("deduct_cache_time", "");
            if (!tb(optString)) {
                optString = "84600";
            }
            this.rAH = Integer.valueOf(optString).intValue();
            this.rAI = jSONObject.optString("deduct_title", "");
            this.rAJ = jSONObject.optString("realname_url", "");
            optString = jSONObject.optString("payway_select_wording", "");
            String optString2 = jSONObject.optString("payway_change_wording", "");
            c yVar = new y();
            yVar.field_is_show = this.rAF;
            yVar.field_pref_key = "wallet_open_auto_pay";
            yVar.field_pref_title = this.rAI;
            yVar.field_pref_url = this.rAG;
            com.tencent.mm.plugin.wallet_core.c.h btR = m.btR();
            String str2 = "wallet_open_auto_pay";
            if (!bg.mA(str2)) {
                btR.gUz.eE("WalletPrefInfo", "delete from WalletPrefInfo where pref_key='" + str2 + "'");
            }
            w.i("MicroMsg.NetSceneTenpayPayManager", "deductCacheTime %s", new Object[]{Integer.valueOf(this.rAH)});
            m.btR().b(yVar);
            ap.yY();
            com.tencent.mm.u.c.vr().a(a.uDF, Long.valueOf(new Date().getTime() / 1000));
            ap.yY();
            com.tencent.mm.u.c.vr().a(a.uDG, Integer.valueOf(this.rAH));
            ap.yY();
            com.tencent.mm.u.c.vr().a(a.uDM, this.rAJ);
            if (!bg.mA(optString)) {
                ap.yY();
                com.tencent.mm.u.c.vr().a(a.uDT, optString);
            }
            if (!bg.mA(optString2)) {
                ap.yY();
                com.tencent.mm.u.c.vr().a(a.uDU, optString2);
            }
            ap.yY();
            com.tencent.mm.u.c.vr().jY(true);
            q.ccj().W(jSONObject);
        }
    }

    public static boolean bmF() {
        ap.yY();
        long longValue = ((Long) com.tencent.mm.u.c.vr().get(a.uDF, Long.valueOf(0))).longValue();
        ap.yY();
        w.i("MicroMsg.NetSceneTenpayPayManager", "check isExpire %s %s %s", new Object[]{Long.valueOf(longValue), Integer.valueOf(r0), Long.valueOf(((long) ((Integer) com.tencent.mm.u.c.vr().get(a.uDG, Integer.valueOf(0))).intValue()) + longValue)});
        if (longValue <= 0) {
            return true;
        }
        if (Long.valueOf(new Date().getTime() / 1000).longValue() > longValue + ((long) r0)) {
            return true;
        }
        return false;
    }

    private static boolean tb(String str) {
        if (bg.mA(str)) {
            return false;
        }
        int length = str.length();
        char charAt;
        do {
            length--;
            if (length < 0) {
                return true;
            }
            charAt = str.charAt(length);
            if (charAt < '0') {
                return false;
            }
        } while (charAt <= '9');
        return false;
    }

    public final int zi() {
        return 1654;
    }

    public final int bti() {
        return 100000;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/paymanage";
    }
}
