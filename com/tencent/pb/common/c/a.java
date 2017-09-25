package com.tencent.pb.common.c;

import java.io.File;

public final class a {
    static final byte[] wOR = "pbphonebook".getBytes();
    public static final String wOS = ("Tencent/" + e.rof.getPackageName());

    public static boolean deleteFile(String str) {
        boolean z = false;
        if (str != null) {
            try {
                z = new File(str).delete();
            } catch (Exception e) {
            }
        }
        return z;
    }
}
