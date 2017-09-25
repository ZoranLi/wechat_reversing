package com.tencent.mm.modelvideo;

import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.bg;

public final class k {
    public static final String KR() {
        return h.vI().gYf + "draft/";
    }

    public static final String lm(String str) {
        if (bg.mA(str)) {
            return null;
        }
        return KR() + str;
    }

    public static final String ln(String str) {
        if (bg.mA(str)) {
            return null;
        }
        return KR() + str + ".thumb";
    }
}
