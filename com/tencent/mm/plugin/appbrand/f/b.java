package com.tencent.mm.plugin.appbrand.f;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class b {
    private static AtomicInteger jaW = new AtomicInteger(1);
    private HashMap<String, a> jaX = new HashMap();

    private static class a {
        public static b jaY = new b();
    }

    public static int Vl() {
        return jaW.incrementAndGet();
    }

    public static b Vm() {
        return a.jaY;
    }

    public final a pS(String str) {
        if (this.jaX.containsKey(str)) {
            return (a) this.jaX.get(str);
        }
        return null;
    }

    public final boolean a(String str, a aVar) {
        if (this.jaX.containsKey(str)) {
            return false;
        }
        this.jaX.put(str, aVar);
        return true;
    }
}
