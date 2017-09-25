package com.tencent.recovery.wx.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetUtil {
    public static String fv(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return "NOT_NETWORK";
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return "NOT_NETWORK";
        }
        if (!activeNetworkInfo.isConnected()) {
            return "NOT_NETWORK";
        }
        if (activeNetworkInfo.getType() == 1) {
            return "WIFI";
        }
        if (activeNetworkInfo.getSubtype() >= 13) {
            return "4G";
        }
        if (activeNetworkInfo.getSubtype() < 5 || activeNetworkInfo.getSubtype() >= 13) {
            return "other";
        }
        return "3G";
    }

    public static boolean isConnected(Context context) {
        return !fv(context).equals("NOT_NETWORK");
    }
}
