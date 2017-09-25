package com.google.android.gms.c;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class m<K, V> extends q<K, V> implements Map<K, V> {
    p<K, V> azZ;

    private p<K, V> kT() {
        if (this.azZ == null) {
            this.azZ = new p<K, V>(this) {
                final /* synthetic */ m aAa;

                {
                    this.aAa = r1;
                }

                protected final void O(int i) {
                    this.aAa.removeAt(i);
                }

                protected final V a(int i, V v) {
                    q qVar = this.aAa;
                    int i2 = (i << 1) + 1;
                    V v2 = qVar.wm[i2];
                    qVar.wm[i2] = v;
                    return v2;
                }

                protected final int bA() {
                    return this.aAa.hP;
                }

                protected final Map<K, V> bB() {
                    return this.aAa;
                }

                protected final void bC() {
                    this.aAa.clear();
                }

                protected final void c(K k, V v) {
                    this.aAa.put(k, v);
                }

                protected final int g(Object obj) {
                    return obj == null ? this.aAa.bG() : this.aAa.indexOf(obj, obj.hashCode());
                }

                protected final int h(Object obj) {
                    return this.aAa.indexOfValue(obj);
                }

                protected final Object k(int i, int i2) {
                    return this.aAa.wm[(i << 1) + i2];
                }
            };
        }
        return this.azZ;
    }

    public Set<Entry<K, V>> entrySet() {
        p kT = kT();
        if (kT.aAh == null) {
            kT.aAh = new b(kT);
        }
        return kT.aAh;
    }

    public Set<K> keySet() {
        p kT = kT();
        if (kT.aAi == null) {
            kT.aAi = new c(kT);
        }
        return kT.aAi;
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        int size = this.hP + map.size();
        if (this.wl.length < size) {
            Object obj = this.wl;
            Object obj2 = this.wm;
            super.bZ(size);
            if (this.hP > 0) {
                System.arraycopy(obj, 0, this.wl, 0, this.hP);
                System.arraycopy(obj2, 0, this.wm, 0, this.hP << 1);
            }
            q.b(obj, obj2, this.hP);
        }
        for (Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public Collection<V> values() {
        p kT = kT();
        if (kT.aAj == null) {
            kT.aAj = new e(kT);
        }
        return kT.aAj;
    }
}
