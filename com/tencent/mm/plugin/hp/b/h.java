package com.tencent.mm.plugin.hp.b;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.bu;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.bp.a;
import com.tencent.mm.y.d;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.util.Map;

public final class h implements a {
    public final void a(d.a aVar) {
        bu buVar = aVar.hst;
        if (buVar.mtd == CdnLogic.MediaType_FAVORITE_VIDEO) {
            String a = n.a(buVar.tff);
            if (bg.mA(a)) {
                w.w("MicroMsg.Tinker.TinkerBootsSysCmdMsgListener", "msg content is null");
                return;
            }
            Map q = bh.q(a, "sysmsg");
            if (q != null && q.size() > 0) {
                a = (String) q.get(".sysmsg.$type");
                if (!bg.mA(a) && a.equalsIgnoreCase("checktinkerupdate")) {
                    w.i("MicroMsg.Tinker.TinkerBootsSysCmdMsgListener", "ignore:%s start checkout tinker update. try to do update.", new Object[]{Integer.valueOf(bg.PY((String) q.get(".sysmsg.tinkerboots.ignorenetwork")))});
                    com.tinkerboots.sdk.a fo = com.tinkerboots.sdk.a.chU().fo(OpenSDKTool4Assistant.EXTRA_UIN, String.valueOf(((long) com.tencent.mm.kernel.a.uX()) & 4294967295L));
                    String str = TencentLocation.NETWORK_PROVIDER;
                    int i = (am.isWifi(ab.getContext()) || bg.PY((String) q.get(".sysmsg.tinkerboots.ignorenetwork")) == 1) ? 3 : 2;
                    fo.fo(str, String.valueOf(i));
                    com.tinkerboots.sdk.a.chU().mm(true);
                }
            }
        }
    }
}
