package com.tencent.mm.u;

import android.text.TextUtils;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class q {
    private static q hlA;
    private Map<String, c> hlB = new a();

    private static class a<K, V> extends ConcurrentHashMap<K, V> {
        private a() {
        }

        public final V get(Object obj) {
            return obj == null ? null : super.get(obj);
        }

        public final V put(K k, V v) {
            if (k == null) {
                return null;
            }
            if (v == null) {
                return super.remove(k);
            }
            return super.put(k, v);
        }

        public final V remove(Object obj) {
            return obj == null ? null : super.remove(obj);
        }

        public final boolean containsValue(Object obj) {
            return obj == null ? false : super.containsValue(obj);
        }
    }

    public static class b {
        public Map<String, Object> hlC = new a();

        public final Set<String> yD() {
            return this.hlC.keySet();
        }

        public final boolean containsKey(String str) {
            return this.hlC.containsKey(str);
        }

        public final b l(String str, Object obj) {
            if (!TextUtils.isEmpty(str)) {
                this.hlC.put(str, obj);
            }
            return this;
        }

        public final b o(String str, boolean z) {
            if (!TextUtils.isEmpty(str)) {
                this.hlC.put(str, Boolean.valueOf(z));
            }
            return this;
        }

        public final b H(String str, String str2) {
            if (!TextUtils.isEmpty(str)) {
                this.hlC.put(str, str2);
            }
            return this;
        }

        public final boolean fR(String str) {
            if (!TextUtils.isEmpty(str)) {
                Object obj = this.hlC.get(str);
                if (obj instanceof Boolean) {
                    return ((Boolean) obj).booleanValue();
                }
            }
            return false;
        }

        public final Object get(String str) {
            return this.hlC.get(str);
        }

        public final int getInt(String str, int i) {
            if (TextUtils.isEmpty(str)) {
                return i;
            }
            Object obj = this.hlC.get(str);
            if (obj instanceof Integer) {
                return ((Integer) obj).intValue();
            }
            return i;
        }

        public final boolean getBoolean(String str, boolean z) {
            if (TextUtils.isEmpty(str)) {
                return z;
            }
            Object obj = this.hlC.get(str);
            if (obj instanceof Boolean) {
                return ((Boolean) obj).booleanValue();
            }
            return z;
        }

        public final String getString(String str, String str2) {
            if (TextUtils.isEmpty(str)) {
                return str2;
            }
            Object obj = this.hlC.get(str);
            if (obj instanceof String) {
                return (String) obj;
            }
            return str2;
        }

        public final <T> T fS(String str) {
            T t = get(str);
            return t != null ? t : null;
        }

        public final void recycle() {
            this.hlC.clear();
        }
    }

    private static final class c {
        b hlD = new b();
        long hlE = System.currentTimeMillis();

        c() {
        }
    }

    public static q yC() {
        if (hlA == null) {
            synchronized (q.class) {
                if (hlA == null) {
                    hlA = new q();
                }
            }
        }
        return hlA;
    }

    private q() {
    }

    public final b fO(String str) {
        c cVar = (c) this.hlB.get(str);
        if (cVar != null) {
            return cVar.hlD;
        }
        return null;
    }

    public final b n(String str, boolean z) {
        c cVar = (c) this.hlB.get(str);
        if (cVar == null) {
            if (!z) {
                return null;
            }
            cVar = new c();
            this.hlB.put(str, cVar);
        }
        return cVar.hlD;
    }

    public final b fP(String str) {
        c cVar = (c) this.hlB.remove(str);
        if (cVar != null) {
            return cVar.hlD;
        }
        return null;
    }

    public static String fQ(String str) {
        return "SessionId@" + str + "#" + System.nanoTime();
    }

    public String toString() {
        long currentTimeMillis = System.currentTimeMillis();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DataCenter \nDataStore size : ").append(this.hlB.size());
        Set<Entry> linkedHashSet = new LinkedHashSet(this.hlB.entrySet());
        for (Entry entry : linkedHashSet) {
            if (entry != null) {
                c cVar = (c) entry.getValue();
                if (cVar != null) {
                    stringBuilder.append("\nDataStore id : ").append((String) entry.getKey());
                    stringBuilder.append(", CT : ").append(cVar.hlE).append("ms");
                    stringBuilder.append(", TTL : ").append((currentTimeMillis - cVar.hlE) / 1000).append("s");
                }
            }
        }
        linkedHashSet.clear();
        return stringBuilder.toString();
    }
}
