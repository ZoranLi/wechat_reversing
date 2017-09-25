package com.tencent.pb.common.b;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.pb.common.c.d;
import com.tencent.pb.common.c.e;

public final class h {
    public static boolean wLu = true;
    private static long wLv = -1;
    public static int wLw = a.wLy;
    private static int wLx = a.wLy;

    public enum a {
        ;

        static {
            wLy = 1;
            wLz = 2;
            wLA = 3;
            wLB = new int[]{wLy, wLz, wLA};
        }
    }

    private static NetworkInfo getNetworkInfo() {
        ConnectivityManager connectivityManager;
        try {
            connectivityManager = (ConnectivityManager) e.rof.getSystemService("connectivity");
        } catch (Exception e) {
            connectivityManager = null;
        }
        if (connectivityManager == null) {
            d.k("getSystemService(Context.CONNECTIVITY_SERVICE) null", new Object[0]);
            return null;
        }
        NetworkInfo activeNetworkInfo;
        try {
            activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        } catch (Throwable th) {
            d.k("getActiveNetworkInfo exception:", th);
            activeNetworkInfo = null;
        }
        return activeNetworkInfo;
    }

    public static boolean isNetworkConnected() {
        try {
            NetworkInfo networkInfo = getNetworkInfo();
            if (networkInfo == null) {
                return false;
            }
            return networkInfo.isConnected();
        } catch (Exception e) {
            return true;
        }
    }
}
