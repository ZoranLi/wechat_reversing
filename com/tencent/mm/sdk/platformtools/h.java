package com.tencent.mm.sdk.platformtools;

import com.tencent.mm.a.g;
import java.io.File;

public final class h {
    private static String Ph(String str) {
        if (!bg.mA(str) && str.length() > 4) {
            return str.substring(0, 2) + "/" + str.substring(2, 4) + "/";
        }
        return null;
    }

    public static boolean KS(String str) {
        try {
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
                file = new File(str + ".nomedia");
                if (!file.exists()) {
                    try {
                        file.createNewFile();
                    } catch (Throwable e) {
                        w.printErrStackTrace("MicroMsg.FilePathGenerator", e, "", new Object[0]);
                    }
                }
            }
            return true;
        } catch (Exception e2) {
            return false;
        }
    }

    public static String a(String str, String str2, String str3, String str4, int i, boolean z) {
        if (bg.mA(str) || !str.endsWith("/")) {
            return null;
        }
        String str5 = "";
        if (i == 1) {
            str5 = Ph(str3);
        } else if (i == 2) {
            str5 = bg.mA(str3) ? null : Ph(g.n(str3.getBytes()));
        }
        if (bg.mA(str5)) {
            return null;
        }
        str5 = str + str5;
        if (!z || KS(str5)) {
            return str5 + bg.mz(str2) + str3 + bg.mz(str4);
        }
        return null;
    }

    public static String a(String str, String str2, String str3, String str4, int i) {
        return a(str, str2, str3, str4, i, true);
    }

    public static String a(String str, String str2, String str3, String str4, String str5, int i, boolean z) {
        String str6 = str + str3 + str4 + str5;
        String a = a(str2, str3, str4, str5, 1, z);
        if (bg.mA(str6) || bg.mA(a)) {
            return null;
        }
        File file = new File(a);
        File file2 = new File(str6);
        if (file.exists() || !file2.exists()) {
            return a;
        }
        j.p(str6, a, false);
        return a;
    }

    public static String f(String str, String str2, String str3, String str4, String str5) {
        return a(str, str2, str3, str4, str5, 1, true);
    }
}
