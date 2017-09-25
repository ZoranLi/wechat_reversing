package com.tencent.c.d.b;

import android.os.Build.VERSION;
import java.lang.reflect.Method;

public final class c {
    private static Object wSk;
    private static Method wSl;
    private static boolean wSm;

    static {
        wSk = null;
        wSl = null;
        if (VERSION.SDK_INT >= 14) {
            try {
                wSk = e.fd("libcore.io.Libcore", "os");
                wSl = e.a("libcore.io.Os", "stat", String.class);
                wSm = true;
                return;
            } catch (Throwable th) {
            }
        }
        wSm = false;
    }

    public static boolean isAvailable() {
        return wSm;
    }

    public static int Vf(String str) {
        if (!wSm) {
            return 0;
        }
        Object invoke = wSl.invoke(wSk, new Object[]{str});
        if (invoke != null) {
            return ((Integer) e.b(invoke.getClass(), "st_mode", invoke)).intValue();
        }
        return 0;
    }
}
