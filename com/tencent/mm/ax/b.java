package com.tencent.mm.ax;

import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;

public enum b {
    ;

    private b(String str) {
    }

    public static boolean LZ() {
        return !bg.mA(Mc());
    }

    public static String Mc() {
        ap.yY();
        w.i("MicroMsg.WebviewKeepManager", "getLastPage : %s", new Object[]{(String) c.vr().get(a.uFS, String.valueOf(""))});
        return (String) c.vr().get(a.uFS, String.valueOf(""));
    }

    public static String Mb() {
        ap.yY();
        w.i("MicroMsg.WebviewKeepManager", "getLastPageTitle : %s", new Object[]{(String) c.vr().get(a.uFT, String.valueOf(""))});
        return (String) c.vr().get(a.uFT, String.valueOf(""));
    }

    public static int Md() {
        ap.yY();
        w.i("MicroMsg.WebviewKeepManager", "getLastPageKeepTopScene : %d", new Object[]{Integer.valueOf(bg.a((Integer) c.vr().get(a.uGe, null), 0))});
        return bg.a((Integer) c.vr().get(a.uGe, null), 0);
    }

    public static void d(String str, String str2, int i) {
        w.i("MicroMsg.WebviewKeepManager", "saveLastPage : url=%s title=%s scene=%d", new Object[]{str, str2, Integer.valueOf(i)});
        ap.yY();
        c.vr().a(a.uFS, bg.mz(str));
        ap.yY();
        c.vr().a(a.uFT, bg.mz(str2));
        ap.yY();
        c.vr().a(a.uGe, Integer.valueOf(i));
    }
}
