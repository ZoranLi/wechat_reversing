package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import com.tencent.wcdb.FileUtils;
import java.util.Map;

public final class f {
    public static int fuV = 0;
    public static String fuW = (VERSION.SDK_INT);
    public static int fuX = 0;
    public static int fvb = 0;
    public static int usq = 0;
    public static int usr = 0;
    public static String uss = ("market://details?id=" + ab.getPackageName());
    public static boolean ust = false;
    public static boolean usu = true;
    public static boolean usv = false;
    public static boolean usw = false;

    public static void dW(Context context) {
        try {
            fuV = Integer.parseInt((String) q.Pl(bg.convertStreamToString(context.getAssets().open("channel.ini"))).get("CHANNEL"));
        } catch (Throwable e) {
            w.e("MicroMsg.SDK.ChannelUtil", "setup channel id from channel.ini failed");
            w.printErrStackTrace("MicroMsg.SDK.ChannelUtil", e, "", new Object[0]);
        }
    }

    public static void dX(Context context) {
        try {
            Map Pl = q.Pl(bg.convertStreamToString(context.getAssets().open("profile.ini")));
            String mz = bg.mz((String) Pl.get("PROFILE_DEVICE_TYPE"));
            fuW = mz;
            if (mz.length() <= 0) {
                fuW = VERSION.SDK_INT;
            }
            fuX = parseInt((String) Pl.get("UPDATE_MODE"));
            usr = parseInt((String) Pl.get("BUILD_REVISION"));
            usv = parseBoolean((String) Pl.get("GPRS_ALERT"));
            fvb = parseInt((String) Pl.get("AUTO_ADD_ACOUNT"));
            usw = parseBoolean((String) Pl.get("NOKIA_AOL"));
            w.w("MicroMsg.SDK.ChannelUtil", "profileDeviceType=" + fuW);
            w.w("MicroMsg.SDK.ChannelUtil", "updateMode=" + fuX);
            w.w("MicroMsg.SDK.ChannelUtil", "shouldShowGprsAlert=" + usv);
            w.w("MicroMsg.SDK.ChannelUtil", "autoAddAccount=" + fvb);
            w.w("MicroMsg.SDK.ChannelUtil", "isNokiaol=" + usw);
            mz = (String) Pl.get("MARKET_URL");
            if (!(mz == null || mz.trim().length() == 0 || Uri.parse(mz) == null)) {
                uss = mz;
            }
            w.w("MicroMsg.SDK.ChannelUtil", "marketURL=" + uss);
        } catch (Throwable e) {
            w.e("MicroMsg.SDK.ChannelUtil", "setup profile from profile.ini failed");
            w.printErrStackTrace("MicroMsg.SDK.ChannelUtil", e, "", new Object[0]);
        }
    }

    private static int parseInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Exception e) {
            w.w("MicroMsg.SDK.ChannelUtil", e.getMessage());
            return 0;
        }
    }

    private static boolean parseBoolean(String str) {
        boolean z = false;
        try {
            z = Boolean.parseBoolean(str);
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.SDK.ChannelUtil", e, "", new Object[z]);
            w.w("MicroMsg.SDK.ChannelUtil", e.getMessage());
        }
        return z;
    }

    public static String Z(Context context, int i) {
        return b(context, i, ust);
    }

    public static String b(Context context, int i, boolean z) {
        String str;
        int i2 = (i >> 8) & 255;
        if (i2 == 0) {
            str = ((i >> 24) & 15) + "." + ((i >> 16) & 255);
        } else {
            str = ((i >> 24) & 15) + "." + ((i >> 16) & 255) + "." + i2;
        }
        w.d("MicroMsg.SDK.ChannelUtil", "minminor " + i2);
        i2 = 268435455 & i;
        if (context != null) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), FileUtils.S_IWUSR);
                if (packageInfo != null) {
                    i2 = packageInfo.versionCode;
                    str = packageInfo.versionName;
                }
            } catch (Throwable e) {
                Throwable th = e;
                int i3 = i2;
                w.printErrStackTrace("MicroMsg.SDK.ChannelUtil", th, "", new Object[0]);
                i2 = i3;
            }
        }
        if (z) {
            str = str + "_" + i2;
            w.d("MicroMsg.SDK.ChannelUtil", "full version: " + str);
            return str;
        }
        String[] split = str.split("\\.");
        if (split == null || split.length < 4) {
            return str;
        }
        str = split[0] + "." + split[1];
        return !split[2].trim().equals("0") ? str + "." + split[2] : str;
    }

    public static boolean bIA() {
        return fuV == MMBitmapFactory.ERROR_ALLOCATE_STRUCT_FAILED;
    }
}
