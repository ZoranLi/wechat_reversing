package com.google.android.gms.c;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

abstract class p<K, V> {
    b aAh;
    c aAi;
    e aAj;

    final class a<T> implements Iterator<T> {
        final /* synthetic */ p aAk;
        int hP;
        int mIndex;
        final int wa;
        boolean wb = false;

        a(p pVar, int i) {
            this.aAk = pVar;
            this.wa = i;
            this.hP = pVar.bA();
        }

        public final boolean hasNext() {
            return this.mIndex < this.hP;
        }

        public final T next() {
            T k = this.aAk.k(this.mIndex, this.wa);
            this.mIndex++;
            this.wb = true;
            return k;
        }

        public final void remove() {
            if (this.wb) {
                this.mIndex--;
                this.hP--;
                this.wb = false;
                this.aAk.O(this.mIndex);
                return;
            }
            throw new IllegalStateException();
        }
    }

    final class b implements Set<Entry<K, V>> {
        final /* synthetic */ p aAk;

        b(p pVar) {
            this.aAk = pVar;
        }

        public final /* synthetic */ boolean add(Object obj) {
            throw new UnsupportedOperationException();
        }

        public final boolean addAll(Collection<? extends Entry<K, V>> collection) {
            int bA = this.aAk.bA();
            for (Entry entry : collection) {
                this.aAk.c(entry.getKey(), entry.getValue());
            }
            return bA != this.aAk.bA();
        }

        public final void clear() {
            this.aAk.bC();
        }

        public final boolean contains(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            int g = this.aAk.g(entry.getKey());
            return g >= 0 ? n.d(this.aAk.k(g, 1), entry.getValue()) : false;
        }

        public final boolean containsAll(Collection<?> collection) {
            for (Object contains : collection) {
                if (!contains(contains)) {
                    return false;
                }
            }
            return true;
        }

        public final boolean equals(Object obj) {
            return p.a((Set) this, obj);
        }

        public final int hashCode() {
            int bA = this.aAk.bA() - 1;
            int i = 0;
            while (bA >= 0) {
                Object k = this.aAk.k(bA, 0);
                Object k2 = this.aAk.k(bA, 1);
                bA--;
                i += (k2 == null ? 0 : k2.hashCode()) ^ (k == null ? 0 : k.hashCode());
            }
            return i;
        }

        public final boolean isEmpty() {
            return this.aAk.bA() == 0;
        }

        public final Iterator<Entry<K, V>> iterator() {
            return new d(this.aAk);
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
            return this.aAk.bA();
        }

        public final Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        public final <T> T[] toArray(T[] tArr) {
            throw new UnsupportedOperationException();
        }
    }

    final class c implements Set<K> {
        final /* synthetic */ p aAk;

        c(p pVar) {
            this.aAk = pVar;
        }

        public final boolean add(K k) {
            throw new UnsupportedOperationException();
        }

        public final boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        public final void clear() {
            this.aAk.bC();
        }

        public final boolean contains(Object obj) {
            return this.aAk.g(obj) >= 0;
        }

        public final boolean containsAll(Collection<?> collection) {
            Map bB = this.aAk.bB();
            for (Object containsKey : collection) {
                if (!bB.containsKey(containsKey)) {
                    return false;
                }
            }
            return true;
        }

        public final boolean equals(Object obj) {
            return p.a((Set) this, obj);
        }

        public final int hashCode() {
            int i = 0;
            for (int bA = this.aAk.bA() - 1; bA >= 0; bA--) {
                Object k = this.aAk.k(bA, 0);
                i += k == null ? 0 : k.hashCode();
            }
            return i;
        }

        public final boolean isEmpty() {
            return this.aAk.bA() == 0;
        }

        public final Iterator<K> iterator() {
            return new a(this.aAk, 0);
        }

        public final boolean remove(Object obj) {
            int g = this.aAk.g(obj);
            if (g < 0) {
                return false;
            }
            this.aAk.O(g);
            return true;
        }

        public final boolean removeAll(Collection<?> collection) {
            Map bB = this.aAk.bB();
            int size = bB.size();
            for (Object remove : collection) {
                bB.remove(remove);
            }
            return size != bB.size();
        }

        public final boolean retainAll(Collection<?> collection) {
            Map bB = this.aAk.bB();
            int size = bB.size();
            Iterator it = bB.keySet().iterator();
            while (it.hasNext()) {
                if (!collection.contains(it.next())) {
                    it.remove();
                }
            }
            return size != bB.size();
        }

        public final int size() {
            return this.aAk.bA();
        }

        public final Object[] toArray() {
            return this.aAk.S(0);
        }

        public final <T> T[] toArray(T[] tArr) {
            return this.aAk.a((Object[]) tArr, 0);
        }
    }

    final class d implements Iterator<Entry<K, V>>, Entry<K, V> {
        final /* synthetic */ p aAk;
        int mIndex;
        int wd;
        boolean we = false;

        d(p pVar) {
            this.aAk = pVar;
            this.wd = pVar.bA() - 1;
            this.mIndex = -1;
        }

        public final boolean equals(Object obj) {
            if (!this.we) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            } else if (!(obj instanceof Entry)) {
                return false;
            } else {
                Entry entry = (Entry) obj;
                return n.d(entry.getKey(), this.aAk.k(this.mIndex, 0)) && n.d(entry.getValue(), this.aAk.k(this.mIndex, 1));
            }
        }

        public final K getKey() {
            if (this.we) {
                return this.aAk.k(this.mIndex, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final V getValue() {
            if (this.we) {
                return this.aAk.k(this.mIndex, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final boolean hasNext() {
            return this.mIndex < this.wd;
        }

        public final int hashCode() {
            int i = 0;
            if (this.we) {
                Object k = this.aAk.k(this.mIndex, 0);
                Object k2 = this.aAk.k(this.mIndex, 1);
                int hashCode = k == null ? 0 : k.hashCode();
                if (k2 != null) {
                    i = k2.hashCode();
                }
                return i ^ hashCode;
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final /* bridge */ /* synthetic */ Object next() {
            this.mIndex++;
            this.we = true;
            return this;
        }

        public final void remove() {
            if (this.we) {
                this.aAk.O(this.mIndex);
                this.mIndex--;
                this.wd--;
                this.we = false;
                return;
            }
            throw new IllegalStateException();
        }

        public final V setValue(V v) {
            if (this.we) {
                return this.aAk.a(this.mIndex, (Object) v);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final String toString() {
            return getKey() + "=" + getValue();
        }
    }

    final class e implements Collection<V> {
        final /* synthetic */ p aAk;

        e(p pVar) {
            this.aAk = pVar;
        }

        public final boolean add(V v) {
            throw new UnsupportedOperationException();
        }

        public final boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        public final void clear() {
            this.aAk.bC();
        }

        public final boolean contains(Object obj) {
            return this.aAk.h(obj) >= 0;
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
            return this.aAk.bA() == 0;
        }

        public final Iterator<V> iterator() {
            return new a(this.aAk, 1);
        }

        public final boolean remove(Object obj) {
            int h = this.aAk.h(obj);
            if (h < 0) {
                return false;
            }
            this.aAk.O(h);
            return true;
        }

        public final boolean removeAll(Collection<?> collection) {
            int i = 0;
            int bA = this.aAk.bA();
            boolean z = false;
            while (i < bA) {
                if (collection.contains(this.aAk.k(i, 1))) {
                    this.aAk.O(i);
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
            int bA = this.aAk.bA();
            boolean z = false;
            while (i < bA) {
                if (!collection.contains(this.aAk.k(i, 1))) {
                    this.aAk.O(i);
                    i--;
                    bA--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        public final int size() {
            return this.aAk.bA();
        }

        public final Object[] toArray() {
            return this.aAk.S(1);
        }

        public final <T> T[] toArray(T[] tArr) {
            return this.aAk.a((Object[]) tArr, 1);
        }
    }

    p() {
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
            return set.size() == set2.size() && set.containsAll(set2);
        } catch (NullPointerException e) {
            return false;
        } catch (ClassCastException e2) {
            return false;
        }
    }

    protected abstract void O(int i);

    public final Object[] S(int i) {
        int bA = bA();
        Object[] objArr = new Object[bA];
        for (int i2 = 0; i2 < bA; i2++) {
            objArr[i2] = k(i2, i);
        }
        return objArr;
    }

    protected abstract V a(int i, V v);

    public final <T> T[] a(T[] tArr, int i) {
        int bA = bA();
        T[] tArr2 = tArr.length < bA ? (Object[]) Array.newInstance(tArr.getClass().getComponentType(), bA) : tArr;
        for (int i2 = 0; i2 < bA; i2++) {
            tArr2[i2] = k(i2, i);
        }
        if (tArr2.length > bA) {
            tArr2[bA] = null;
        }
        return tArr2;
    }

    protected abstract int bA();

    protected abstract Map<K, V> bB();

    protected abstract void bC();

    protected abstract void c(K k, V v);

    protected abstract int g(Object obj);

    protected abstract int h(Object obj);

    protected abstract Object k(int i, int i2);
}
