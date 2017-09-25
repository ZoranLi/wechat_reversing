package com.tencent.mm.plugin.freewifi;

import com.tencent.mm.plugin.report.service.g;

public final class l {
    public static void p(String str, String str2, int i) {
        g.oUh.i(12651, new Object[]{Integer.valueOf(1), str, Integer.valueOf(0), str2, Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i)});
    }

    public static void q(String str, String str2, int i) {
        g.oUh.i(12651, new Object[]{Integer.valueOf(2), str, Integer.valueOf(0), str2, Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i)});
    }

    public static void r(String str, String str2, int i) {
        g.oUh.i(12651, new Object[]{Integer.valueOf(3), str, Integer.valueOf(0), str2, Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i)});
    }

    public static void b(String str, String str2, int i, boolean z) {
        if (z) {
            g.oUh.i(12651, new Object[]{Integer.valueOf(4), str, Integer.valueOf(1), str2, Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i)});
            return;
        }
        g.oUh.i(12651, new Object[]{Integer.valueOf(4), str, Integer.valueOf(0), str2, Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i)});
    }

    public static void c(String str, String str2, int i, boolean z) {
        if (z) {
            g.oUh.i(12651, new Object[]{Integer.valueOf(5), str, Integer.valueOf(1), str2, Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i)});
            return;
        }
        g.oUh.i(12651, new Object[]{Integer.valueOf(5), str, Integer.valueOf(0), str2, Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i)});
    }
}
