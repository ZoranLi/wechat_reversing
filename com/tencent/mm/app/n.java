package com.tencent.mm.app;

import android.os.Build;
import com.tencent.tinker.lib.d.b;
import com.tencent.tinker.lib.e.a;
import com.tencent.tinker.loader.app.ApplicationLike;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import org.xmlpull.v1.XmlPullParserException;

public final class n {
    public static boolean a(StackTraceElement[] stackTraceElementArr) {
        for (StackTraceElement className : stackTraceElementArr) {
            String className2 = className.getClassName();
            if (className2 != null && (className2.contains("de.robv.android.xposed.XposedBridge") || className2.contains("com.zte.heartyservice.SCC.FrameworkBridge"))) {
                return true;
            }
        }
        return false;
    }

    public static void c(Throwable th) {
        ApplicationLike tinkerApplicationLike = MMApplicationLike.getTinkerApplicationLike();
        if (tinkerApplicationLike == null || tinkerApplicationLike.getApplication() == null) {
            a.w("TinkerCrashProtect", "applicationlike is null", new Object[0]);
        } else if (b.b(tinkerApplicationLike)) {
            int i = (Build.MODEL.contains("ZUK") || Build.MODEL.contains("zuk")) ? 1 : 0;
            boolean z = false;
            while (th != null) {
                boolean z2;
                if (z) {
                    z2 = z;
                } else {
                    z2 = a(th.getStackTrace());
                }
                if (z2) {
                    int i2;
                    if ((th instanceof IllegalAccessError) && th.getMessage().contains("Class ref in pre-verified class resolved to unexpected implementation")) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    if (i2 != 0) {
                        a.e("TinkerCrashProtect", "have xposed: just clean tinker", new Object[0]);
                        ShareTinkerInternals.hG(tinkerApplicationLike.getApplication());
                        b.d(tinkerApplicationLike);
                        ShareTinkerInternals.hC(tinkerApplicationLike.getApplication());
                        return;
                    }
                }
                if (i != 0) {
                    a.w("TinkerCrashProtect", "it is zuk model here, crash:" + th.getMessage(), new Object[0]);
                    if ((th instanceof XmlPullParserException) && th.getMessage().contains("tag requires a 'drawable' attribute or child tag defining a drawable")) {
                        a.e("TinkerCrashProtect", "have zuk parse error: just clean tinker", new Object[0]);
                        ShareTinkerInternals.hG(tinkerApplicationLike.getApplication());
                        b.d(tinkerApplicationLike);
                        ShareTinkerInternals.hC(tinkerApplicationLike.getApplication());
                        return;
                    }
                }
                th = th.getCause();
                z = z2;
            }
        } else {
            a.w("TinkerCrashProtect", "tinker is not loaded", new Object[0]);
        }
    }
}
