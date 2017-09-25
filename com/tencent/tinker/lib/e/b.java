package com.tencent.tinker.lib.e;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.os.Process;
import com.tencent.tinker.lib.service.TinkerPatchService;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.util.List;

public final class b extends ShareTinkerInternals {
    private static String xgR = null;

    public static void hq(Context context) {
        String hs = hs(context);
        if (hs != null) {
            List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
            if (runningAppProcesses != null) {
                for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo.processName.equals(hs)) {
                        Process.killProcess(runningAppProcessInfo.pid);
                    }
                }
            }
        }
    }

    public static boolean hr(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        String hs = hs(context);
        if (hs == null) {
            return false;
        }
        try {
            List<RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses == null) {
                return false;
            }
            for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.processName.equals(hs)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            new StringBuilder("isTinkerPatchServiceRunning Exception: ").append(e.toString());
            return false;
        } catch (Error e2) {
            new StringBuilder("isTinkerPatchServiceRunning Error: ").append(e2.toString());
            return false;
        }
    }

    private static String hs(Context context) {
        if (xgR != null) {
            return xgR;
        }
        String b = b(context, TinkerPatchService.class);
        if (b == null) {
            return null;
        }
        xgR = b;
        return b;
    }

    public static boolean ht(Context context) {
        String hH = hH(context);
        String hs = hs(context);
        if (hs == null || hs.length() == 0) {
            return false;
        }
        return hH.equals(hs);
    }

    private static String b(Context context, Class<? extends Service> cls) {
        try {
            return context.getPackageManager().getServiceInfo(new ComponentName(context, cls), 0).processName;
        } catch (Throwable th) {
            return null;
        }
    }
}
