package com.tencent.tinker.a.b.a;

import com.tencent.tinker.a.c.b;

public abstract class a {
    final b xdk = new b();
    public int xdl = 0;

    public final int cgH() {
        int indexOfKey = this.xdk.indexOfKey(this.xdl);
        if (indexOfKey < 0) {
            return this.xdl;
        }
        return this.xdk.xdw[indexOfKey];
    }

    public final void eF(int i, int i2) {
        this.xdk.put(i, i2);
    }

    protected final void cgI() {
        this.xdl++;
    }
}
