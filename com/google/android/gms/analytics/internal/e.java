package com.google.android.gms.analytics.internal;

import com.google.android.gms.analytics.b;

@Deprecated
public final class e {
    private static volatile b ahF = new ad();

    public static void c(String str, Object obj) {
        Object obj2 = null;
        f hC = f.hC();
        if (hC != null) {
            hC.g(str, obj);
        } else {
            if (ahF != null && ahF.getLogLevel() <= 3) {
                obj2 = 1;
            }
            if (obj2 != null) {
                if (obj != null) {
                    new StringBuilder().append(str).append(":").append(obj);
                }
                aj.ajQ.get();
            }
        }
        b bVar = ahF;
    }

    public static b hB() {
        return ahF;
    }
}
