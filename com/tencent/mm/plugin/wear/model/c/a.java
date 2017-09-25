package com.tencent.mm.plugin.wear.model.c;

import com.tencent.mars.smc.IDKey;
import com.tencent.mm.plugin.appbrand.jsapi.bx;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;

public final class a {
    public static final void dv(int i, int i2) {
        if (com.tencent.mm.plugin.wear.model.a.bvG().rTo.rTF.rUt != null) {
            w.v("MicroMsg.Wear.ReportKVUtil", "report kv operation=%d scene=%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            g.oUh.i(11632, new Object[]{Integer.valueOf(i), r0.jNo, r0.umB, Integer.valueOf(i2)});
        }
    }

    public static final void vJ(int i) {
        g.oUh.a(249, (long) i, 1, false);
    }

    public static final void iM(boolean z) {
        ArrayList arrayList = new ArrayList();
        IDKey iDKey = new IDKey();
        iDKey.SetID(bx.CTRL_INDEX);
        iDKey.SetKey(12);
        iDKey.SetValue(1);
        arrayList.add(iDKey);
        if (z) {
            iDKey = new IDKey();
            iDKey.SetID(bx.CTRL_INDEX);
            iDKey.SetKey(13);
            iDKey.SetValue(1);
            arrayList.add(iDKey);
        }
        g.oUh.b(arrayList, false);
    }
}
