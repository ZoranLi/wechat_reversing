package com.tencent.mm.plugin.appbrand.n.e;

import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;

public class g implements c {
    private byte[] content;
    private TreeMap<String, String> jpR = new TreeMap(String.CASE_INSENSITIVE_ORDER);

    public final Iterator<String> Yc() {
        return Collections.unmodifiableSet(this.jpR.keySet()).iterator();
    }

    public final String rc(String str) {
        String str2 = (String) this.jpR.get(str);
        if (str2 == null) {
            return "";
        }
        return str2;
    }

    public final byte[] Yd() {
        return this.content;
    }

    public final void put(String str, String str2) {
        this.jpR.put(str, str2);
    }

    public final boolean rd(String str) {
        return this.jpR.containsKey(str);
    }
}
