package com.tencent.mm.ah.a.d;

import com.tencent.mm.a.f;
import java.util.Map;

public final class a<K, V> {
    private f<K, V> hJq;

    public a(int i) {
        this.hJq = new f(i);
    }

    public final void clear() {
        if (this.hJq == null) {
            throw new NullPointerException("mData == null");
        }
        this.hJq.trimToSize(-1);
    }

    public final V get(K k) {
        if (this.hJq != null) {
            return this.hJq.get(k);
        }
        throw new NullPointerException("mData == null");
    }

    public final V put(K k, V v) {
        if (this.hJq != null) {
            return this.hJq.put(k, v);
        }
        throw new NullPointerException("mData == null");
    }

    public final synchronized Map<K, V> snapshot() {
        if (this.hJq == null) {
            throw new NullPointerException("mData == null");
        }
        return this.hJq.snapshot();
    }

    public final synchronized String toString() {
        if (this.hJq == null) {
            throw new NullPointerException("mData == null");
        }
        return this.hJq.toString();
    }
}
