package com.tencent.recovery.wx;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.tencent.recovery.log.RecoveryLog;

public class RecoveryTinkerManager {
    public static int bs(Context context, String str) {
        if (bb(context, fu(context))) {
            return -2;
        }
        try {
            Intent intent = new Intent();
            intent.setClassName(context, "com.tencent.tinker.lib.service.TinkerPatchService");
            intent.putExtra("patch_path_extra", str);
            intent.putExtra("patch_result_class", "com.tencent.mm.modelrecovery.RecoveryTinkerResultService");
            context.startService(intent);
            return 0;
        } catch (Throwable th) {
            RecoveryLog.e("Recovery.RecoveryTinkerManager", "start patch service fail, exception:" + th, new Object[0]);
            return -1;
        }
    }

    private static String fu(Context context) {
        try {
            return context.getPackageManager().getServiceInfo(new ComponentName(context, "com.tencent.tinker.lib.service.TinkerPatchService"), 0).processName;
        } catch (Throwable th) {
            return null;
        }
    }

    private static boolean bb(Context context, String str) {
        try {
            for (RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.processName != null && runningAppProcessInfo.processName.equals(str)) {
                    return true;
                }
            }
        } catch (Exception e) {
        }
        return false;
    }
}
