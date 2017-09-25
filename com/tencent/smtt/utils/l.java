package com.tencent.smtt.utils;

import android.text.TextUtils;
import java.lang.reflect.Method;

public final class l {
    private static Class wYe;
    private static Method wYf;

    static {
        try {
            Class cls = Class.forName("android.os.SystemProperties");
            wYe = cls;
            wYf = cls.getDeclaredMethod("get", new Class[]{String.class, String.class});
        } catch (Throwable th) {
        }
    }

    public static String fj(String str, String str2) {
        return TextUtils.isEmpty(str) ? str2 : fk(str, str2);
    }

    private static String fk(String str, String str2) {
        if (wYe == null || wYf == null) {
            return str2;
        }
        try {
            return (String) wYf.invoke(wYe, new Object[]{str, str2});
        } catch (Throwable th) {
            return str2;
        }
    }
}
