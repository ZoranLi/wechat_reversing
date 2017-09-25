package com.tencent.mm.sdk.platformtools;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;

public final class ab {
    private static Resources Cu = null;
    private static Context context = null;
    private static String fwP = "com.tencent.mm";
    private static String processName = fwP;
    private static String usV = "com.tencent.mm";
    private static String usW = "com.tencent.mm.ui.LauncherUI";
    private static boolean usX = false;
    public static boolean usY = false;
    private static ActivityManager usZ = null;

    public static void jR(boolean z) {
        usX = z;
    }

    public static boolean bIU() {
        return usX;
    }

    public static String bIV() {
        return usW;
    }

    public static void setContext(Context context) {
        context = context;
        fwP = context.getPackageName();
        w.d("MicroMsg.MMApplicationContext", "setup application context for package: " + fwP);
    }

    public static Context getContext() {
        return context;
    }

    public static String getPackageName() {
        return fwP;
    }

    public static String bIW() {
        return usV;
    }

    public static String bIX() {
        return fwP + "_preferences";
    }

    public static SharedPreferences bIY() {
        if (context != null) {
            return context.getSharedPreferences(bIX(), 0);
        }
        return null;
    }

    public static SharedPreferences bIZ() {
        if (context != null) {
            return context.getSharedPreferences(fwP + "_preferences_tools", 0);
        }
        return null;
    }

    public static String bJa() {
        return fwP + "_tmp_preferences";
    }

    public static String um() {
        return processName;
    }

    public static void Pr(String str) {
        processName = str;
    }

    public static boolean bJb() {
        Object obj = processName;
        if (obj == null || obj.length() == 0) {
            obj = fwP;
        }
        return fwP.equals(obj);
    }

    public static boolean bJc() {
        String str = processName;
        if (str == null || str.length() == 0) {
            str = fwP;
        }
        return "com.tencent.mm:push".equalsIgnoreCase(str);
    }

    public static boolean bJd() {
        String str = processName;
        if (str == null || str.length() == 0) {
            str = fwP;
        }
        return "com.tencent.mm:tools".equalsIgnoreCase(str);
    }

    public static boolean bJe() {
        String str = processName;
        if (str == null || str.length() == 0) {
            str = fwP;
        }
        return "com.tencent.mm:exdevice".equalsIgnoreCase(str);
    }

    public static boolean bJf() {
        return Ps(fwP);
    }

    private static boolean Ps(String str) {
        if (context == null || fwP == null) {
            return false;
        }
        if (usZ == null) {
            usZ = (ActivityManager) context.getSystemService("activity");
        }
        try {
            for (RunningAppProcessInfo runningAppProcessInfo : usZ.getRunningAppProcesses()) {
                if (runningAppProcessInfo.processName.equals(str)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            w.e("MicroMsg.MMApplicationContext", "isMMProcessExist Exception: " + e.toString());
            return false;
        } catch (Error e2) {
            w.e("MicroMsg.MMApplicationContext", "isMMProcessExist Error: " + e2.toString());
            return false;
        }
    }

    public static Resources getResources() {
        return Cu;
    }

    public static void a(Resources resources) {
        Cu = resources;
    }
}
