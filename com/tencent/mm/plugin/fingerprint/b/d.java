package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.fingerprint.a;
import com.tencent.mm.plugin.fingerprint.a.e;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.soter.c.b;
import com.tencent.mm.plugin.soter.c.c;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.wallet_core.f.a.h;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class d extends h implements j {
    public d() {
        Map hashMap = new HashMap();
        c blU = b.blU();
        String str = blU.qPZ;
        String str2 = blU.qQa;
        hashMap.put("cpu_id", str);
        hashMap.put("uid", str2);
        x(hashMap);
    }

    public final int aki() {
        return 116;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        if (i == 0) {
            int optInt;
            if (jSONObject != null) {
                optInt = jSONObject.optInt("clear_rsa_key_level", 0);
            } else {
                optInt = 0;
            }
            a.auQ();
            a.auR();
            new Object[1][0] = Integer.valueOf(optInt);
            l.a.sBC.avg();
            return;
        }
        w.e("MicroMsg.NetSceneTenpayCloseTouchPay", "do close fingerprint cgi failed!");
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        super.a(i, i2, i3, str, pVar, bArr);
        g.oUh.i(13686, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i2 == 0 && i3 == 0) {
            e.el(false);
            w.e("MicroMsg.NetSceneTenpayCloseTouchPay", "hy: do close fingerprint cgi success!");
            return;
        }
        w.e("MicroMsg.NetSceneTenpayCloseTouchPay", "hy: do close fingerprint cgi failed!");
    }

    public final int zi() {
        return 1597;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/closetouchpay";
    }
}
