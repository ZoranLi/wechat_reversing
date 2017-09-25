package com.tencent.mm.plugin.luckymoney.sns.c;

import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;

public final class a {
    public static int aIj() {
        ap.yY();
        return ((Integer) c.vr().get(com.tencent.mm.storage.w.a.uDn, Integer.valueOf(0))).intValue();
    }

    public static void oS(int i) {
        ap.yY();
        c.vr().a(com.tencent.mm.storage.w.a.uDn, Integer.valueOf(i));
        ap.yY();
        c.vr().jY(true);
    }

    public static String aIk() {
        ap.yY();
        return (String) c.vr().get(com.tencent.mm.storage.w.a.uDs, "");
    }

    public static String aIl() {
        ap.yY();
        return (String) c.vr().get(com.tencent.mm.storage.w.a.uDt, "");
    }
}
