package com.tencent.e;

public abstract class d<T extends e> {
    public final Object mLock = new Object();
    public int puT;
    public T[] xjb = Eb(20);

    public abstract T[] Eb(int i);

    public abstract T chb();

    public d(int i) {
    }

    public T chc() {
        T t = null;
        synchronized (this.mLock) {
            if (this.puT > 0) {
                this.puT--;
                t = this.xjb[this.puT];
                this.xjb[this.puT] = null;
            }
        }
        return t;
    }
}
