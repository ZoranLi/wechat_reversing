package com.tencent.mm.plugin.appbrand.f;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class e {
    private static AtomicInteger jaW = new AtomicInteger(1);
    private HashMap<String, c> jaX = new HashMap();

    private static class a {
        public static e jbl = new e();
    }

    public static int Vl() {
        return jaW.incrementAndGet();
    }

    public static e Vo() {
        return a.jbl;
    }

    public final c pV(String str) {
        if (this.jaX.containsKey(str)) {
            return (c) this.jaX.get(str);
        }
        return null;
    }

    public final boolean a(String str, c cVar) {
        if (this.jaX.containsKey(str)) {
            return false;
        }
        this.jaX.put(str, cVar);
        return true;
    }
}
