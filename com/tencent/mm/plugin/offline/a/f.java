package com.tencent.mm.plugin.offline.a;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.wallet_core.c.c;
import com.tencent.mm.wallet_core.f.a.h;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class f extends h {
    private boolean fVM = true;

    public f(String str, String str2) {
        Map hashMap = new HashMap();
        hashMap.put("code_ver", str);
        hashMap.put("cn", str2);
        w.i("MicroMsg.NetSceneOfflineVerifyToken", "reqtoken ver %s cn: %s", new Object[]{str, str2});
        x(hashMap);
    }

    public final int aki() {
        return 1686;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/offlineverifytoken";
    }

    public final int zi() {
        return 1686;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        w.i("MicroMsg.NetSceneOfflineVerifyToken", "respone %d errMsg: %s", new Object[]{Integer.valueOf(i), str});
        if (i == 0) {
            w.i("MicroMsg.NetSceneOfflineVerifyToken", "NetSceneOfflineVerifyToken succ");
            g.oUh.a(135, 22, 1, true);
            return;
        }
        w.i("MicroMsg.NetSceneOfflineVerifyToken", "NetSceneOfflineVerifyToken fail.errCode = %d ;errMsg = ", new Object[]{Integer.valueOf(i), str});
        g.oUh.a(135, 23, 1, true);
    }

    public final void a(c cVar, JSONObject jSONObject) {
        if (cVar.wDU != 0 || cVar.errType == 0) {
            this.fVM = true;
        } else {
            this.fVM = false;
        }
        w.i("MicroMsg.NetSceneOfflineVerifyToken", "onGYNetEnd2 isBlock %s", new Object[]{Boolean.valueOf(this.fVM)});
    }

    public final boolean aQj() {
        return this.fVM;
    }
}
