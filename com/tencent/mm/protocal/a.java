package com.tencent.mm.protocal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public class a {
    public static int bGY() {
        if (b.foreground) {
            return 1;
        }
        return 2;
    }

    public static int getNetType(Context context) {
        int i;
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return 0;
            }
            int subtype = activeNetworkInfo.getSubtype();
            if (activeNetworkInfo.getType() == 1) {
                i = 1;
            } else if (subtype == 13 || subtype == 15 || subtype == 14) {
                i = 4;
            } else if (subtype == 3 || subtype == 4 || subtype == 5 || subtype == 6 || subtype == 12) {
                i = 3;
            } else if (subtype == 1 || subtype == 2) {
                i = 2;
            } else {
                i = 0;
            }
            return i;
        } catch (Throwable e) {
            w.e("MicroMsg.BgFgBase", "getNetType: %s", bg.g(e));
            i = 1;
        }
    }
}
