package android.support.v4.e;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class a<K, V> extends i<K, V> implements Map<K, V> {
    g<K, V> vO;

    public a(int i) {
        super(i);
    }

    private g<K, V> bz() {
        if (this.vO == null) {
            this.vO = new g<K, V>(this) {
                final /* synthetic */ a vP;

                {
                    this.vP = r1;
                }

                protected final int bA() {
                    return this.vP.hP;
                }

                protected final Object k(int i, int i2) {
                    return this.vP.wm[(i << 1) + i2];
                }

                protected final int g(Object obj) {
                    return this.vP.indexOfKey(obj);
                }

                protected final int h(Object obj) {
                    return this.vP.indexOfValue(obj);
                }

                protected final Map<K, V> bB() {
                    return this.vP;
                }

                protected final void c(K k, V v) {
                    this.vP.put(k, v);
                }

                protected final V a(int i, V v) {
                    return this.vP.setValueAt(i, v);
                }

                protected final void O(int i) {
                    this.vP.removeAt(i);
                }

                protected final void bC() {
                    this.vP.clear();
                }
            };
        }
        return this.vO;
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        int size = this.hP + map.size();
        if (this.wl.length < size) {
            Object obj = this.wl;
            Object obj2 = this.wm;
            super.T(size);
            if (this.hP > 0) {
                System.arraycopy(obj, 0, this.wl, 0, this.hP);
                System.arraycopy(obj2, 0, this.wm, 0, this.hP << 1);
            }
            i.a(obj, obj2, this.hP);
        }
        for (Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public Set<Entry<K, V>> entrySet() {
        g bz = bz();
        if (bz.vX == null) {
            bz.vX = new b(bz);
        }
        return bz.vX;
    }

    public Set<K> keySet() {
        g bz = bz();
        if (bz.vY == null) {
            bz.vY = new c(bz);
        }
        return bz.vY;
    }

    public Collection<V> values() {
        g bz = bz();
        if (bz.vZ == null) {
            bz.vZ = new e(bz);
        }
        return bz.vZ;
    }
}
