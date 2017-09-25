package com.google.android.gms.common.data;

import com.google.android.gms.common.internal.w;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class e<T> implements Iterator<T> {
    protected final b<T> aoS;
    protected int aoT = -1;

    public e(b<T> bVar) {
        this.aoS = (b) w.Z(bVar);
    }

    public final boolean hasNext() {
        return this.aoT < this.aoS.getCount() + -1;
    }

    public final T next() {
        if (hasNext()) {
            b bVar = this.aoS;
            int i = this.aoT + 1;
            this.aoT = i;
            return bVar.get(i);
        }
        throw new NoSuchElementException("Cannot advance the iterator beyond " + this.aoT);
    }

    public final void remove() {
        throw new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
    }
}
