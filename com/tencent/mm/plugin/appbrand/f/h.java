package com.tencent.mm.plugin.appbrand.f;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class h {
    private static AtomicInteger jaW = new AtomicInteger(1);
    private HashMap<String, f> jaX = new HashMap();

    private static class a {
        public static h jbs = new h();
    }

    public static int Vl() {
        return jaW.incrementAndGet();
    }

    public static h Vp() {
        return a.jbs;
    }

    public final f pX(String str) {
        if (this.jaX.containsKey(str)) {
            return (f) this.jaX.get(str);
        }
        return null;
    }

    public final boolean a(String str, f fVar) {
        if (this.jaX.containsKey(str)) {
            return false;
        }
        this.jaX.put(str, fVar);
        return true;
    }
}
