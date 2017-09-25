package android.support.v4.e;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class g<K, V> {
    b vX;
    c vY;
    e vZ;

    final class a<T> implements Iterator<T> {
        int hP;
        int mIndex;
        final int wa;
        boolean wb = false;
        final /* synthetic */ g wc;

        a(g gVar, int i) {
            this.wc = gVar;
            this.wa = i;
            this.hP = gVar.bA();
        }

        public final boolean hasNext() {
            return this.mIndex < this.hP;
        }

        public final T next() {
            T k = this.wc.k(this.mIndex, this.wa);
            this.mIndex++;
            this.wb = true;
            return k;
        }

        public final void remove() {
            if (this.wb) {
                this.mIndex--;
                this.hP--;
                this.wb = false;
                this.wc.O(this.mIndex);
                return;
            }
            throw new IllegalStateException();
        }
    }

    final class b implements Set<Entry<K, V>> {
        final /* synthetic */ g wc;

        b(g gVar) {
            this.wc = gVar;
        }

        public final /* synthetic */ boolean add(Object obj) {
            throw new UnsupportedOperationException();
        }

        public final boolean addAll(Collection<? extends Entry<K, V>> collection) {
            int bA = this.wc.bA();
            for (Entry entry : collection) {
                this.wc.c(entry.getKey(), entry.getValue());
            }
            return bA != this.wc.bA();
        }

        public final void clear() {
            this.wc.bC();
        }

        public final boolean contains(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            int g = this.wc.g(entry.getKey());
            if (g >= 0) {
                return b.d(this.wc.k(g, 1), entry.getValue());
            }
            return false;
        }

        public final boolean containsAll(Collection<?> collection) {
            for (Object contains : collection) {
                if (!contains(contains)) {
                    return false;
                }
            }
            return true;
        }

        public final boolean isEmpty() {
            return this.wc.bA() == 0;
        }

        public final Iterator<Entry<K, V>> iterator() {
            return new d(this.wc);
        }

        public final boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        public final boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public final boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public final int size() {
            return this.wc.bA();
        }

        public final Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        public final <T> T[] toArray(T[] tArr) {
            throw new UnsupportedOperationException();
        }

        public final boolean equals(Object obj) {
            return g.a((Set) this, obj);
        }

        public final int hashCode() {
            int bA = this.wc.bA() - 1;
            int i = 0;
            while (bA >= 0) {
                Object k = this.wc.k(bA, 0);
                Object k2 = this.wc.k(bA, 1);
                bA--;
                i += (k2 == null ? 0 : k2.hashCode()) ^ (k == null ? 0 : k.hashCode());
            }
            return i;
        }
    }

    final class c implements Set<K> {
        final /* synthetic */ g wc;

        c(g gVar) {
            this.wc = gVar;
        }

        public final boolean add(K k) {
            throw new UnsupportedOperationException();
        }

        public final boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        public final void clear() {
            this.wc.bC();
        }

        public final boolean contains(Object obj) {
            return this.wc.g(obj) >= 0;
        }

        public final boolean containsAll(Collection<?> collection) {
            Map bB = this.wc.bB();
            for (Object containsKey : collection) {
                if (!bB.containsKey(containsKey)) {
                    return false;
                }
            }
            return true;
        }

        public final boolean isEmpty() {
            return this.wc.bA() == 0;
        }

        public final Iterator<K> iterator() {
            return new a(this.wc, 0);
        }

        public final boolean remove(Object obj) {
            int g = this.wc.g(obj);
            if (g < 0) {
                return false;
            }
            this.wc.O(g);
            return true;
        }

        public final boolean removeAll(Collection<?> collection) {
            Map bB = this.wc.bB();
            int size = bB.size();
            for (Object remove : collection) {
                bB.remove(remove);
            }
            return size != bB.size();
        }

        public final boolean retainAll(Collection<?> collection) {
            return g.a(this.wc.bB(), (Collection) collection);
        }

        public final int size() {
            return this.wc.bA();
        }

        public final Object[] toArray() {
            return this.wc.S(0);
        }

        public final <T> T[] toArray(T[] tArr) {
            return this.wc.a((Object[]) tArr, 0);
        }

        public final boolean equals(Object obj) {
            return g.a((Set) this, obj);
        }

        public final int hashCode() {
            int i = 0;
            for (int bA = this.wc.bA() - 1; bA >= 0; bA--) {
                Object k = this.wc.k(bA, 0);
                i += k == null ? 0 : k.hashCode();
            }
            return i;
        }
    }

    final class d implements Iterator<Entry<K, V>>, Entry<K, V> {
        int mIndex;
        final /* synthetic */ g wc;
        int wd;
        boolean we = false;

        public final /* bridge */ /* synthetic */ Object next() {
            this.mIndex++;
            this.we = true;
            return this;
        }

        d(g gVar) {
            this.wc = gVar;
            this.wd = gVar.bA() - 1;
            this.mIndex = -1;
        }

        public final boolean hasNext() {
            return this.mIndex < this.wd;
        }

        public final void remove() {
            if (this.we) {
                this.wc.O(this.mIndex);
                this.mIndex--;
                this.wd--;
                this.we = false;
                return;
            }
            throw new IllegalStateException();
        }

        public final K getKey() {
            if (this.we) {
                return this.wc.k(this.mIndex, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final V getValue() {
            if (this.we) {
                return this.wc.k(this.mIndex, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final V setValue(V v) {
            if (this.we) {
                return this.wc.a(this.mIndex, (Object) v);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final boolean equals(Object obj) {
            if (!this.we) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            } else if (!(obj instanceof Entry)) {
                return false;
            } else {
                Entry entry = (Entry) obj;
                if (b.d(entry.getKey(), this.wc.k(this.mIndex, 0)) && b.d(entry.getValue(), this.wc.k(this.mIndex, 1))) {
                    return true;
                }
                return false;
            }
        }

        public final int hashCode() {
            int i = 0;
            if (this.we) {
                Object k = this.wc.k(this.mIndex, 0);
                Object k2 = this.wc.k(this.mIndex, 1);
                int hashCode = k == null ? 0 : k.hashCode();
                if (k2 != null) {
                    i = k2.hashCode();
                }
                return i ^ hashCode;
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final String toString() {
            return getKey() + "=" + getValue();
        }
    }

    final class e implements Collection<V> {
        final /* synthetic */ g wc;

        e(g gVar) {
            this.wc = gVar;
        }

        public final boolean add(V v) {
            throw new UnsupportedOperationException();
        }

        public final boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        public final void clear() {
            this.wc.bC();
        }

        public final boolean contains(Object obj) {
            return this.wc.h(obj) >= 0;
        }

        public final boolean containsAll(Collection<?> collection) {
            for (Object contains : collection) {
                if (!contains(contains)) {
                    return false;
                }
            }
            return true;
        }

        public final boolean isEmpty() {
            return this.wc.bA() == 0;
        }

        public final Iterator<V> iterator() {
            return new a(this.wc, 1);
        }

        public final boolean remove(Object obj) {
            int h = this.wc.h(obj);
            if (h < 0) {
                return false;
            }
            this.wc.O(h);
            return true;
        }

        public final boolean removeAll(Collection<?> collection) {
            int i = 0;
            int bA = this.wc.bA();
            boolean z = false;
            while (i < bA) {
                if (collection.contains(this.wc.k(i, 1))) {
                    this.wc.O(i);
                    i--;
                    bA--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        public final boolean retainAll(Collection<?> collection) {
            int i = 0;
            int bA = this.wc.bA();
            boolean z = false;
            while (i < bA) {
                if (!collection.contains(this.wc.k(i, 1))) {
                    this.wc.O(i);
                    i--;
                    bA--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        public final int size() {
            return this.wc.bA();
        }

        public final Object[] toArray() {
            return this.wc.S(1);
        }

        public final <T> T[] toArray(T[] tArr) {
            return this.wc.a((Object[]) tArr, 1);
        }
    }

    protected abstract void O(int i);

    protected abstract V a(int i, V v);

    protected abstract int bA();

    protected abstract Map<K, V> bB();

    protected abstract void bC();

    protected abstract void c(K k, V v);

    protected abstract int g(Object obj);

    protected abstract int h(Object obj);

    protected abstract Object k(int i, int i2);

    g() {
    }

    public static <K, V> boolean a(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    public final Object[] S(int i) {
        int bA = bA();
        Object[] objArr = new Object[bA];
        for (int i2 = 0; i2 < bA; i2++) {
            objArr[i2] = k(i2, i);
        }
        return objArr;
    }

    public final <T> T[] a(T[] tArr, int i) {
        T[] tArr2;
        int bA = bA();
        if (tArr.length < bA) {
            tArr2 = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), bA);
        } else {
            tArr2 = tArr;
        }
        for (int i2 = 0; i2 < bA; i2++) {
            tArr2[i2] = k(i2, i);
        }
        if (tArr2.length > bA) {
            tArr2[bA] = null;
        }
        return tArr2;
    }

    public static <T> boolean a(Set<T> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set2 = (Set) obj;
        try {
            if (set.size() == set2.size() && set.containsAll(set2)) {
                return true;
            }
            return false;
        } catch (NullPointerException e) {
            return false;
        } catch (ClassCastException e2) {
            return false;
        }
    }
}
