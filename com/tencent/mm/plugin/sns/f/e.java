package com.tencent.mm.plugin.sns.f;

import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.c;

public final class e {
    public static void FN(String str) {
        w.i("MicroMsg.SnsABTestStrategy", "dump id " + str);
        c dX = com.tencent.mm.u.c.c.Az().dX(str);
        if (!dX.isValid()) {
            w.i("MicroMsg.SnsABTestStrategy", "abtest is invalid");
        }
        if (dX.bKK() != null) {
            w.i("MicroMsg.SnsABTestStrategy", "dump feed abtest " + dX.field_rawXML);
        }
    }
}
