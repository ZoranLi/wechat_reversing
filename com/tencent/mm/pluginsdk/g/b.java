package com.tencent.mm.pluginsdk.g;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import com.tencent.mm.pluginsdk.g.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;

public final class b implements a {
    private static b sBP = null;

    public final boolean U(Activity activity) {
        ComponentName componentName = ((RunningTaskInfo) ((ActivityManager) ab.getContext().getSystemService("activity")).getRunningTasks(1).get(0)).topActivity;
        String className = componentName != null ? componentName.getClassName() : "";
        w.d("MicroMsg.WalletGuardFilter", "coveredPage: " + className);
        if (className == null || className.equals(activity.getClass().getName()) || !className.contains(ab.bIW()) || (!className.contains("plugin.mall") && !className.contains("plugin.card") && !className.contains("plugin.wallet") && !className.contains("plugin.wallet_index") && !className.contains("plugin.webview") && !className.contains("plugin.offline"))) {
            return true;
        }
        return false;
    }

    public static b bCz() {
        if (sBP == null) {
            sBP = new b();
        }
        return sBP;
    }

    private b() {
    }
}
