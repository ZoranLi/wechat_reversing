package com.tencent.mm.plugin.appbrand.dynamic.performance.collector;

import java.util.concurrent.ConcurrentHashMap;

final class a<K, V> extends ConcurrentHashMap<K, V> {
    a() {
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
