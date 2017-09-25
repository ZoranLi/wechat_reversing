package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.smtt.utils.TbsLog;
import java.io.File;

class TbsLinuxToolsJni {
    private static boolean wVs = false;
    private static boolean wVt = false;

    public TbsLinuxToolsJni(Context context) {
        synchronized (TbsLinuxToolsJni.class) {
            if (wVt) {
                return;
            }
            wVt = true;
            try {
                File file;
                if (t.gu(context)) {
                    file = new File(t.ceO());
                } else {
                    p.ceA();
                    file = p.gk(context);
                }
                if (file != null) {
                    if (!(new File(file.getAbsolutePath() + File.separator + "liblinuxtoolsfortbssdk_jni.so").exists() || t.gu(context))) {
                        p.ceA();
                        file = p.gj(context);
                    }
                    if (file != null) {
                        System.load(file.getAbsolutePath() + File.separator + "liblinuxtoolsfortbssdk_jni.so");
                        wVs = true;
                    }
                }
                ChmodInner("/checkChmodeExists", "700");
            } catch (Throwable th) {
                wVs = false;
            }
        }
    }

    private native int ChmodInner(String str, String str2);

    public final int ff(String str, String str2) {
        if (wVs) {
            return ChmodInner(str, str2);
        }
        TbsLog.e("TbsLinuxToolsJni", "jni not loaded!", true);
        return -1;
    }
}
