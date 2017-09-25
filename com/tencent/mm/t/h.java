package com.tencent.mm.t;

import android.util.Base64;
import com.tencent.mm.sdk.platformtools.bg;

public final class h {
    public static boolean em(String str) {
        return str != null && str.endsWith("@app");
    }

    public static k en(String str) {
        try {
            return (k) new k().aD(Base64.decode(str, 0));
        } catch (Exception e) {
            try {
                return (k) new k().aD(bg.PT(str));
            } catch (Exception e2) {
                return new k();
            }
        }
    }
}
