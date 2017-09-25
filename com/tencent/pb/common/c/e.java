package com.tencent.pb.common.c;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.wcdb.FileUtils;

public final class e {
    private static boolean DEBUG = false;
    public static int pPh = 320;
    public static Context rof = null;
    private static final Uri roh = Uri.parse("content://com.lbe.security.miui.permmgr/active");
    private static String sImei = null;
    private static String sYK = null;
    public static boolean wOV = false;
    public static long wOW = 0;
    public static String wOX = null;
    private static int wOY = -1;
    public static int wOZ = 480;

    public static int cdf() {
        if (wOY < 0) {
            wOY = VERSION.SDK_INT;
        }
        return wOY;
    }

    public static String cdg() {
        if (sYK == null) {
            sYK = VERSION.RELEASE;
        }
        return sYK;
    }

    public static String getModel() {
        return Build.MODEL;
    }

    public static String cdh() {
        return VERSION.INCREMENTAL;
    }

    public static String cdi() {
        String str;
        String str2 = "UNKNOW";
        if (cdf() > 8) {
            try {
                str = (String) ((Build) Class.forName("android.os.Build").newInstance()).getClass().getField("HARDWARE").get(str2);
            } catch (SecurityException e) {
                str = str2;
            } catch (ClassNotFoundException e2) {
                str = str2;
            } catch (IllegalAccessException e3) {
                str = str2;
            } catch (InstantiationException e4) {
                str = str2;
            } catch (NoSuchFieldException e5) {
            }
            d.d("", "hardware:" + str);
            return str;
        }
        str = str2;
        d.d("", "hardware:" + str);
        return str;
    }

    public static boolean isApkExist(String str) {
        if ("".equals(str)) {
            return false;
        }
        try {
            if (rof.getPackageManager().getApplicationInfo(str, FileUtils.S_IWUSR) != null) {
                return true;
            }
            return false;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    public static String cdj() {
        String str = Build.MANUFACTURER;
        if (str == null) {
            return "UNKNOWN";
        }
        return str;
    }
}
