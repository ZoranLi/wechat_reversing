package com.tinkerboots.sdk.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public final class a {
    private static ConnectivityManager xmy = null;

    public static boolean isConnected(Context context) {
        if (xmy == null) {
            xmy = (ConnectivityManager) context.getSystemService("connectivity");
        }
        if (xmy == null) {
            return false;
        }
        boolean z;
        NetworkInfo activeNetworkInfo = xmy.getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            try {
                if (activeNetworkInfo.isConnected()) {
                    z = true;
                    return z;
                }
            } catch (Exception e) {
                return false;
            }
        }
        z = false;
        return z;
    }
}
