package com.tencent.mm.plugin.appbrand.f;

import java.util.HashMap;

public final class k {
    public HashMap<String, j> jaX = new HashMap();

    private static class a {
        public static k jbC = new k();
    }

    public final j qd(String str) {
        if (this.jaX.containsKey(str)) {
            return (j) this.jaX.get(str);
        }
        return null;
    }

    public final boolean qe(String str) {
        if (!this.jaX.containsKey(str)) {
            return false;
        }
        j jVar = (j) this.jaX.remove(str);
        if (jVar != null) {
            jVar.Vq();
        }
        return true;
    }
}
