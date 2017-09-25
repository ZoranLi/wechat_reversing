package com.tencent.mm.modelcdntran;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.mm.a.g;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.m;

public final class d {
    public static int hyA = 2;
    public static int hyB = 3;
    public static int hyC = -1;
    public static int hyD = 3;
    public static int hyE = 4;
    public static int hyF = 5;
    public static int hyG = 1;
    public static int hyH = 2;
    public static int hyI = -10001;
    public static int hyJ = -10002;
    public static int hyK = -10003;
    public static int hyL = -10004;
    public static int hyz = 1;

    public static void a(byte[] bArr, String str, int i) {
        if (bg.bm(bArr)) {
            bArr = new byte[0];
        }
        String str2 = new String(bArr);
        if (i == 4) {
            w.e(str, str2);
        } else if (i == 3) {
            w.w(str, str2);
        } else if (i == 2) {
            w.i(str, str2);
        } else if (i == 1) {
            w.d(str, str2);
        } else if (i == 0) {
            w.v(str, str2);
        }
    }

    private static String iQ(String str) {
        if (bg.mA(str)) {
            return str;
        }
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (!bg.j(charAt) && !bg.k(charAt)) {
                return null;
            }
        }
        return str;
    }

    public static String a(String str, long j, String str2, String str3) {
        w.d("MicroMsg.CdnUtil", "cdntra genClientId prefix[%s] createtime:%d talker[%s] suffix:[%s] stack[%s]", str, Long.valueOf(j), str2, str3, bg.bJZ());
        if (bg.mA(iQ(str)) || bg.mA(str2) || j <= 0) {
            return null;
        }
        String mz = bg.mz(iQ(str3));
        String str4 = "a" + str + "_" + g.n((m.xL() + "-" + str2).getBytes()).substring(0, 16) + "_" + j;
        if (bg.mA(mz)) {
            return str4;
        }
        return str4 + "_" + mz;
    }

    public static int aT(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return hyz;
            }
            if (activeNetworkInfo.getType() == 1) {
                return hyB;
            }
            if (activeNetworkInfo.getSubtype() == 1) {
                return hyz;
            }
            if (activeNetworkInfo.getSubtype() == 2) {
                return hyz;
            }
            if (activeNetworkInfo.getSubtype() >= 3) {
                return hyA;
            }
            return hyz;
        } catch (Throwable e) {
            w.e("MicroMsg.CdnUtil", "exception:%s", bg.g(e));
            return hyz;
        }
    }

    public static int aU(Context context) {
        int netType = am.getNetType(context);
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return hyC;
        }
        if (activeNetworkInfo.getType() == 1) {
            return hyG;
        }
        if (activeNetworkInfo.getSubtype() == 1 || activeNetworkInfo.getSubtype() == 2) {
            return hyD;
        }
        if (activeNetworkInfo.getSubtype() >= 13) {
            return hyF;
        }
        if (activeNetworkInfo.getSubtype() >= 3) {
            return hyE;
        }
        if (am.isWap(netType)) {
            return hyH;
        }
        return hyD;
    }
}
