package com.tencent.mm.compatible.d;

import com.tencent.mm.sdk.platformtools.w;
import java.lang.reflect.Method;

public final class x {
    private static Class<?> gRN;
    private static Method gRO;
    private static Method gRP;

    static {
        gRN = null;
        gRO = null;
        gRP = null;
        try {
            Class cls = Class.forName("android.os.SystemProperties");
            gRN = cls;
            gRO = cls.getDeclaredMethod("get", new Class[]{String.class});
            gRP = gRN.getDeclaredMethod("getInt", new Class[]{String.class, Integer.TYPE});
            gRO.setAccessible(true);
            gRP.setAccessible(true);
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.SystemProperties", e, "", new Object[0]);
        }
    }

    public static String get(String str) {
        try {
            return (String) gRO.invoke(null, new Object[]{str});
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.SystemProperties", e, "", new Object[0]);
            return null;
        }
    }
}
