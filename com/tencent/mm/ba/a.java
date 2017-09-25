package com.tencent.mm.ba;

import android.os.Build.VERSION;
import com.tencent.mm.s.a.f;

public final class a {
    public static int bCk() {
        if (VERSION.SDK_INT < 19) {
            return f.bhU;
        }
        return f.bhV;
    }
}
