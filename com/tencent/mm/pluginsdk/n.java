package com.tencent.mm.pluginsdk;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.ComponentName;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.ui.d.g;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public final class n {
    private static final AtomicInteger sBI = new AtomicInteger(0);

    public static boolean isLocked() {
        return sBI.get() > 0;
    }

    public static void bCu() {
        if (ab.bJd()) {
            sBI.getAndSet(0);
        }
    }

    public static void lock() {
        if (ab.bJd()) {
            sBI.incrementAndGet();
            return;
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(g.uOD, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
        intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_LOCK_TOOLS_PROCESS");
        ab.getContext().sendBroadcast(intent);
    }

    public static void unlock() {
        if (ab.getContext() != null) {
            ActivityManager activityManager = (ActivityManager) ab.getContext().getSystemService("activity");
            if (activityManager != null) {
                List<RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
                if (!bg.bV(runningAppProcesses)) {
                    Object obj;
                    for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                        if ("com.tencent.mm:tools".equals(runningAppProcessInfo.processName)) {
                            obj = 1;
                            break;
                        }
                    }
                    obj = null;
                    if (obj == null) {
                        return;
                    }
                    if (ab.bJd()) {
                        sBI.decrementAndGet();
                        return;
                    }
                    Intent intent = new Intent();
                    intent.setComponent(new ComponentName(g.uOD, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
                    intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_UNLOCK_TOOLS_PROCESS");
                    ab.getContext().sendBroadcast(intent);
                }
            }
        }
    }
}
