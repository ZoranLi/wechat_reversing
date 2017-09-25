package com.tencent.mm.plugin.secinforeport.a;

import com.tencent.mm.sdk.platformtools.w;

public enum b implements a {
    ;
    
    private static a phJ;

    private static class a implements a {
        public final boolean aZL() {
            w.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
            return false;
        }

        public final void Ea(String str) {
            w.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
        }

        public final void bC(String str, int i) {
            w.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
        }
    }

    private b(String str) {
    }

    static {
        phJ = new a();
    }

    public static void a(a aVar) {
        if (aVar != null) {
            phJ = aVar;
        }
    }

    public final boolean aZL() {
        return phJ.aZL();
    }

    public final void Ea(String str) {
        phJ.Ea(str);
    }

    public final void bC(String str, int i) {
        phJ.bC(str, i);
    }
}
