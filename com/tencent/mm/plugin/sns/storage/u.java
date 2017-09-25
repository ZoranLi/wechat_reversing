package com.tencent.mm.plugin.sns.storage;

import com.tencent.mm.sdk.platformtools.bg;

public final class u {
    public static String S(String str, long j) {
        return str + j;
    }

    public static String T(String str, long j) {
        return str + j;
    }

    public static boolean Gz(String str) {
        return str != null && str.startsWith("ad_table_");
    }

    public static boolean Eu(String str) {
        return str != null && str.startsWith("sns_table_");
    }

    public static long GA(String str) {
        if (bg.mA(str)) {
            return 0;
        }
        if (str.startsWith("ad_table_")) {
            return bg.PZ(str.substring(9));
        }
        return bg.PZ(str.substring(10));
    }

    public static int GB(String str) {
        if (bg.mA(str)) {
            return 0;
        }
        if (str.startsWith("ad_table_")) {
            return bg.PY(str.substring(9));
        }
        return bg.PY(str.substring(10));
    }

    public static boolean GC(String str) {
        if (str.startsWith("ad_table_")) {
            if (bg.PZ(str.substring(9)) != 0) {
                return true;
            }
            return false;
        } else if (bg.PZ(str.substring(10)) == 0) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean GD(String str) {
        return !GC(str);
    }
}
