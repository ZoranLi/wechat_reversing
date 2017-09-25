package com.tencent.mm.plugin.freewifi.b;

import com.tencent.mm.plugin.freewifi.m;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class a {
    private Map<String, b> lSA = new LinkedHashMap<String, b>(this) {
        final /* synthetic */ a lSB;

        {
            this.lSB = r1;
        }

        protected final boolean removeEldestEntry(Entry entry) {
            return size() > 512;
        }
    };
    private boolean lSz = false;

    private static class a {
        public static a lSC = new a();
    }

    public static class b {
        String fEN;
        int lRB;
    }

    private static String cd(String str, String str2) {
        return str + "-" + str2;
    }

    public final synchronized void c(String str, String str2, String str3, int i) {
        if (!(m.wx(str) || m.wx(str2) || m.wx(str3) || (i != 4 && i != 31))) {
            b bVar = new b();
            bVar.fEN = str3;
            bVar.lRB = i;
            this.lSA.put(cd(str, str2), bVar);
        }
    }

    public final synchronized b ce(String str, String str2) {
        b bVar;
        if (m.wx(str) || m.wx(str2)) {
            bVar = null;
        } else {
            bVar = (b) this.lSA.get(cd(str, str2));
        }
        return bVar;
    }

    public final synchronized int size() {
        return this.lSA.size();
    }
}
