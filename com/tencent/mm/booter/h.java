package com.tencent.mm.booter;

import com.tencent.mm.platformtools.u;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;

public final class h {
    public static boolean qf() {
        try {
            ap.yY();
            u.d((Long) c.vr().get(66817, null));
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.PostTaskMediaNoteStat", e, "", new Object[0]);
        }
        if (u.az(0) * 1000 > 1800000) {
            return true;
        }
        return false;
    }
}
