package com.google.android.gms.common.data;

import java.util.Iterator;

public abstract class a<T> implements b<T> {
    public final DataHolder aoy;

    protected a(DataHolder dataHolder) {
        this.aoy = dataHolder;
        if (this.aoy != null) {
            this.aoy.aoK = this;
        }
    }

    public int getCount() {
        return this.aoy == null ? 0 : this.aoy.aoJ;
    }

    public Iterator<T> iterator() {
        return new e(this);
    }

    public final void release() {
        if (this.aoy != null) {
            this.aoy.close();
        }
    }
}
