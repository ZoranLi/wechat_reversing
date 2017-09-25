package com.tencent.mm.app.plugin;

import com.tencent.mm.bb.d;
import com.tencent.mm.i.g;
import com.tencent.mm.sdk.platformtools.bg;

public final class c {
    public static boolean oL() {
        if (!d.Jt("translate")) {
            return false;
        }
        String value = g.sV().getValue("TranslateMsgOff");
        if (bg.mA(value)) {
            return true;
        }
        if (bg.PY(value) == 0) {
            return true;
        }
        return false;
    }
}
