package com.tencent.mm.kernel;

import android.content.Context;
import com.tencent.mm.sdk.platformtools.w;

public final class k {
    public static void e(Context context, boolean z) {
        if (context == null) {
            w.e("MicroMsg.WeChatAppStatus", "editFullExitStatus context == null");
            return;
        }
        context.getSharedPreferences("system_config_prefs", 4).edit().putBoolean("settings_fully_exit", z).commit();
        w.i("MicroMsg.WeChatAppStatus", "editFullExitStatus to " + z);
    }

    public static boolean aK(Context context) {
        if (context != null) {
            return context.getSharedPreferences("system_config_prefs", 4).getBoolean("settings_fully_exit", true);
        }
        w.e("MicroMsg.WeChatAppStatus", "getFullExitStatus context == null");
        return false;
    }

    public static void f(Context context, boolean z) {
        if (context == null) {
            w.e("MicroMsg.WeChatAppStatus", "editShutDownWxStatus context == null");
            return;
        }
        context.getSharedPreferences("system_config_prefs_showdown", 4).edit().putBoolean("shut_down_weixin", z).commit();
        w.i("MicroMsg.WeChatAppStatus", "editShutDownWxStatus to " + z);
    }

    public static boolean aL(Context context) {
        if (context != null) {
            return context.getSharedPreferences("system_config_prefs_showdown", 4).getBoolean("shut_down_weixin", false);
        }
        w.e("MicroMsg.WeChatAppStatus", "getShutDownWxStatus context == null");
        return false;
    }
}
