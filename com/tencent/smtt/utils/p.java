package com.tencent.smtt.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiSetBackgroundAudioState;
import com.tencent.smtt.sdk.WebView;

public final class p {
    private static String wYj = null;
    private static String wYk = "GA";
    private static String wYl = "GE";
    private static String wYm = "9422";
    private static String wYn = "0";
    private static String wYo = "";
    private static boolean wYp = false;
    private static boolean wYq = false;
    private static boolean wYr = false;

    private static String a(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, boolean z) {
        String str8;
        String str9 = null;
        String str10 = "PHONE";
        StringBuilder stringBuilder = new StringBuilder();
        String str11 = gX(context) + "*" + gY(context);
        try {
            ApplicationInfo applicationInfo = context.getApplicationContext().getApplicationInfo();
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(applicationInfo.packageName, 0);
            str9 = applicationInfo.packageName;
            if (TextUtils.isEmpty(str7)) {
                str7 = packageInfo.versionName;
            }
        } catch (NameNotFoundException e) {
            str7 = null;
        }
        String str12 = str9.equals("com.tencent.mm") ? "WX" : str9.equals("com.tencent.mobileqq") ? "QQ" : str9.equals("com.qzone") ? "QZ" : str9.equals("com.tencent.mtt") ? "QB" : "TRD";
        if ("QB".equals(str12)) {
            if (z) {
                str8 = "PAD";
            }
            str8 = str10;
        } else {
            boolean z2;
            if (wYq) {
                z2 = wYr;
            } else {
                int i;
                int min = Math.min(gX(context), gY(context)) * JsApiSetBackgroundAudioState.CTRL_INDEX;
                WindowManager windowManager = (WindowManager) context.getSystemService("window");
                DisplayMetrics displayMetrics = new DisplayMetrics();
                Display defaultDisplay = windowManager.getDefaultDisplay();
                if (defaultDisplay != null) {
                    defaultDisplay.getMetrics(displayMetrics);
                    i = displayMetrics.densityDpi;
                } else {
                    i = JsApiSetBackgroundAudioState.CTRL_INDEX;
                }
                wYr = min / i >= 700;
                wYq = true;
                z2 = wYr;
            }
            if (z2) {
                str8 = "PAD";
            }
            str8 = str10;
        }
        stringBuilder.append("QV=3");
        b(stringBuilder, "PL", "ADR");
        b(stringBuilder, "PR", str12);
        b(stringBuilder, "PP", str9);
        b(stringBuilder, "PPVN", str7);
        if (!TextUtils.isEmpty(str)) {
            b(stringBuilder, "TBSVC", str);
        }
        b(stringBuilder, "CO", "SYS");
        if (!TextUtils.isEmpty(str2)) {
            b(stringBuilder, "COVC", str2);
        }
        b(stringBuilder, "PB", str4);
        b(stringBuilder, "VE", str3);
        b(stringBuilder, "DE", str8);
        str8 = "CHID";
        if (TextUtils.isEmpty(str6)) {
            str6 = "0";
        }
        b(stringBuilder, str8, str6);
        b(stringBuilder, "LCID", str5);
        str9 = " " + Build.MODEL.replaceAll("[ |\\/|\\_|\\&|\\|]", "") + " ";
        try {
            Object str13 = new String(str9.getBytes("UTF-8"), "ISO8859-1");
        } catch (Exception e2) {
            str8 = str9;
        }
        if (!TextUtils.isEmpty(str13)) {
            b(stringBuilder, "MO", str13);
        }
        b(stringBuilder, "RL", str11);
        str9 = VERSION.RELEASE;
        try {
            str13 = new String(str9.getBytes("UTF-8"), "ISO8859-1");
        } catch (Exception e3) {
            str8 = str9;
        }
        if (!TextUtils.isEmpty(str13)) {
            b(stringBuilder, "OS", str13);
        }
        b(stringBuilder, "API", VERSION.SDK_INT);
        return stringBuilder.toString();
    }

    private static void b(StringBuilder stringBuilder, String str, String str2) {
        stringBuilder.append("&").append(str).append("=").append(str2);
    }

    public static String gW(Context context) {
        if (!TextUtils.isEmpty(wYj)) {
            return wYj;
        }
        String a = a(context, String.valueOf(WebView.getTbsSDKVersion(context)), "0", wYk, wYl, wYm, wYn, wYo, wYp);
        wYj = a;
        return a;
    }

    private static int gX(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        return defaultDisplay != null ? defaultDisplay.getWidth() : -1;
    }

    private static int gY(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        return defaultDisplay != null ? defaultDisplay.getHeight() : -1;
    }
}
