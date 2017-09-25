package com.tencent.mm.plugin.appbrand.dynamic.performance.collector;

import java.util.HashSet;
import java.util.Set;

public final class c {
    private static b iIr = new h();
    private static boolean iIs;
    private static final Set<String> iIt = new HashSet();

    public static void oL(String str) {
        if (str.length() != 0) {
            iIt.add(str);
        }
    }

    public static void oM(String str) {
        if (str.length() != 0) {
            iIt.remove(str);
        }
    }

    public static boolean oN(String str) {
        if (str.length() == 0) {
            return false;
        }
        return iIt.contains(str);
    }

    public static void bJ(boolean z) {
        iIs = z;
    }

    public static boolean Sm() {
        return iIs;
    }

    private static boolean oO(String str) {
        return iIs && iIt.contains(str);
    }

    private static boolean oP(String str) {
        if (!iIs) {
            return false;
        }
        CollectSession oI = iIr.oI(str);
        if (oI == null || !iIt.contains(oI.groupId)) {
            return false;
        }
        return true;
    }

    public static void clear() {
        if (iIs) {
            iIr.clear();
        }
    }

    public static void c(String str, String str2, String str3, boolean z) {
        if (oO(str)) {
            iIr.c(str, str2, str3, z);
        }
    }

    public static void aR(String str, String str2) {
        if (oP(str)) {
            iIr.aR(str, str2);
        }
    }

    public static void a(CollectSession collectSession) {
        if (collectSession != null && oO(collectSession.groupId)) {
            iIr.a(collectSession);
        }
    }

    public static CollectSession aQ(String str, String str2) {
        if (oP(str)) {
            return iIr.aQ(str, str2);
        }
        return null;
    }

    public static void f(String str, String str2, boolean z) {
        if (oP(str)) {
            iIr.f(str, str2, z);
        }
    }

    public static CollectSession oI(String str) {
        if (oP(str)) {
            return iIr.oI(str);
        }
        return null;
    }

    public static CollectSession oJ(String str) {
        if (iIs) {
            return iIr.oJ(str);
        }
        return null;
    }

    public static void print(String str) {
        if (oP(str)) {
            iIr.print(str);
        }
    }

    public static int aS(String str, String str2) {
        if (oO(str)) {
            return iIr.aS(str, str2);
        }
        return 0;
    }

    public static StringBuilder oK(String str) {
        if (oO(str)) {
            return iIr.oK(str);
        }
        return new StringBuilder();
    }
}
