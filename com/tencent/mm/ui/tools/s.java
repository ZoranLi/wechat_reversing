package com.tencent.mm.ui.tools;

import android.content.Context;
import com.tencent.mm.bg.a;
import com.tencent.mm.s.a.f;

public final class s {
    public static int fg(Context context) {
        if (Float.compare(a.dI(context), 1.125f) > 0) {
            return f.hbW;
        }
        return f.bkU;
    }
}
