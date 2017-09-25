package com.tencent.c.d.a;

import com.tencent.c.e.g;
import java.io.File;

public final class a {
    public static boolean Vc(String str) {
        if (!new File(str).exists()) {
            return true;
        }
        try {
            boolean Vc = com.tencent.c.d.b.a.Vc(str);
            if (!Vc) {
                g.Vi("BootScriptChecker found no-elf file : " + str);
            }
            return Vc;
        } catch (Throwable e) {
            g.i(e);
            return true;
        }
    }

    public static boolean Vd(String str) {
        boolean z = true;
        File file = new File(str);
        if (file.exists() && file.length() <= 51200) {
            try {
                String str2 = new String(com.tencent.c.d.b.a.Ve(file.getAbsolutePath()));
                z = str2.contains("applypatch ");
                g.d("BootScriptChecker script (" + str + ") content : \n" + str2);
                if (!z) {
                    g.Vi("BootScriptChecker found unofficial file : " + str);
                }
            } catch (Throwable e) {
                g.i(e);
            }
        }
        return z;
    }
}
