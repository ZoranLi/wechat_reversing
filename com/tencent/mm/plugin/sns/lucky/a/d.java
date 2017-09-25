package com.tencent.mm.plugin.sns.lucky.a;

import com.tencent.mm.kernel.h;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.bp.a;
import java.util.Map;

public final class d implements a {
    public final void a(com.tencent.mm.y.d.a aVar) {
        w.i("MicroMsg.NewYearSNSAmountLevelCtrl2016NotifyLsn", "receivemsg NewYearSNSAmountLevelCtrl2016NotifyLsn");
        b.mN(67);
        if (aVar == null || aVar.hst == null) {
            w.e("MicroMsg.NewYearSNSAmountLevelCtrl2016NotifyLsn", "onPreAddMessage cmdAM is null");
            return;
        }
        e eVar = new e();
        String a = n.a(aVar.hst.tff);
        eVar.jGf = new StringBuffer();
        Map q = bh.q(a, "sysmsg");
        eVar.level = 0;
        if (q == null) {
            w.i("MicroMsg.NewYearSnsAmountLevel", "errr for paser %s", new Object[]{a});
            b.mN(68);
        } else {
            eVar.level = bg.PY((String) q.get(".sysmsg.NewYearSNSAmountLevelCtrl2016.Level"));
            w.i("MicroMsg.NewYearSnsAmountLevel", "get level %d", new Object[]{Integer.valueOf(eVar.level)});
            if (eVar.level == 0) {
                b.mN(69);
            } else if (eVar.level == 1) {
                b.mN(70);
            } else if (eVar.level == 2) {
                b.mN(71);
            } else if (eVar.level == 3) {
                b.mN(72);
            } else if (eVar.level == 4) {
                b.mN(73);
            }
        }
        w.i("MicroMsg.NewYearSnsAmountLevel", "dump NewYearSnsAmountLevel " + eVar.jGf.toString());
        h.vJ();
        h.vI().vr().a(com.tencent.mm.storage.w.a.uDk, a);
        h.vJ();
        h.vI().vr().jY(true);
    }
}
