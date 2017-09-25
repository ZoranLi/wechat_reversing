package com.tencent.c.d.a;

import android.text.TextUtils;
import com.tencent.c.e.g;
import java.io.File;

public final class e {
    public static boolean cdH() {
        try {
            Object obj = System.getenv("PATH");
            if (TextUtils.isEmpty(obj)) {
                for (String file : obj.split(":")) {
                    File file2 = new File(file, "su");
                    if (file2.exists()) {
                        g.Vi("SuFile found : " + file2.toString());
                        return true;
                    }
                }
            } else if (new File("/system/bin/su").exists()) {
                g.Vi("SuFile found : /system/bin/su");
                return true;
            } else if (new File("/system/xbin/su").exists()) {
                g.Vi("SuFile found : /system/xbin/su");
                return true;
            }
        } catch (Throwable th) {
            g.i(th);
        }
        g.Vi("SuFile not found");
        return false;
    }
}
