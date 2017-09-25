package com.tencent.mm.ax;

import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public enum a {
    ;

    private a(String str) {
    }

    public static boolean LZ() {
        return !bg.mA(Ma());
    }

    public static String Ma() {
        h.vJ();
        w.i("MicroMsg.WebviewKeepManager", "getLastPageUrl : %s", new Object[]{(String) h.vI().vr().get(com.tencent.mm.storage.w.a.uGh, String.valueOf(""))});
        return (String) h.vI().vr().get(com.tencent.mm.storage.w.a.uGh, String.valueOf(""));
    }

    public static String Mb() {
        h.vJ();
        w.i("MicroMsg.WebviewKeepManager", "getLastPageTitle : %s", new Object[]{(String) h.vI().vr().get(com.tencent.mm.storage.w.a.uGj, String.valueOf(""))});
        return (String) h.vI().vr().get(com.tencent.mm.storage.w.a.uGj, String.valueOf(""));
    }

    public static void p(String str, String str2, String str3) {
        h.vJ();
        h.vI().vr().a(com.tencent.mm.storage.w.a.uGh, str);
        h.vJ();
        h.vI().vr().a(com.tencent.mm.storage.w.a.uGj, str2);
        h.vJ();
        h.vI().vr().a(com.tencent.mm.storage.w.a.uGi, str3);
    }
}
