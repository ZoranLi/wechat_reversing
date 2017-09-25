package com.tencent.mm.modelsfs;

import com.tencent.mm.sdk.platformtools.bg;

public final class f {
    public static boolean kp(String str) {
        if (str.lastIndexOf(";?enc=") > 0) {
            return true;
        }
        return false;
    }

    public static String l(String str, long j) {
        if (j == 0) {
            return String.format(str + ";?enc=%d", new Object[]{Long.valueOf(314159265)});
        }
        return String.format(str + ";?enc=%d", new Object[]{Long.valueOf(j)});
    }

    public static String kq(String str) {
        int lastIndexOf = str.lastIndexOf(";?enc=");
        if (lastIndexOf > 0) {
            return str.substring(0, lastIndexOf);
        }
        return str;
    }

    public static long kr(String str) {
        int lastIndexOf = str.lastIndexOf(";?enc=");
        if (lastIndexOf > 0) {
            return bg.PZ(str.substring(lastIndexOf + 6));
        }
        return 0;
    }

    public static String ks(String str) {
        int lastIndexOf = str.lastIndexOf(";?enc=");
        if (lastIndexOf > 0) {
            return str.substring(lastIndexOf + 6).trim();
        }
        return "";
    }
}
