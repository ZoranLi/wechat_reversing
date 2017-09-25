package com.tencent.mm.h;

import com.tencent.mm.storage.au;

public interface a {

    public static class a {
        private static a gNa = null;

        public static void a(a aVar) {
            gNa = aVar;
        }

        public static a qB() {
            return gNa;
        }
    }

    void b(au auVar);

    String c(au auVar);

    boolean dr(String str);

    String p(String str, int i);
}
