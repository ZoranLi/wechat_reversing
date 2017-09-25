package com.tencent.mm.plugin.q;

import com.tencent.mm.protocal.c.avw;
import java.util.List;

public final class a {
    private static List<a> njb;
    private static String njc;

    public static class a {
        public String jia;
        public int njd;
        public avw nje;
    }

    public static synchronized void h(String str, List<a> list) {
        synchronized (a.class) {
            njc = str;
            njb = list;
        }
    }

    public static synchronized List<a> zI(String str) {
        List<a> list;
        synchronized (a.class) {
            if (str != null) {
                if (str.equals(njc)) {
                    list = njb;
                }
            }
            list = null;
        }
        return list;
    }
}
