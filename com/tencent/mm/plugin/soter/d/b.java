package com.tencent.mm.plugin.soter.d;

import com.tencent.mm.plugin.soter.c.a;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.vending.g.g;

public final class b {
    public static void blZ() {
        w.v("MicroMsg.SoterInitManager", "alvinluo isNeedPrepareAsk: %b, isNeedSaveDeviceInfo: %b", new Object[]{Boolean.valueOf(false), Boolean.valueOf(false)});
        try {
            g.s(Boolean.valueOf(false), Boolean.valueOf(false)).b(new a()).b(new c()).b(new d());
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.SoterInitManager", e, "", new Object[0]);
            a.dj(4, MMBitmapFactory.ERROR_ALLOCATE_STRUCT_FAILED);
        }
    }
}
