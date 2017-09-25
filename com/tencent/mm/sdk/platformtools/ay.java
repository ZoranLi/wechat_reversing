package com.tencent.mm.sdk.platformtools;

public class ay<T> {
    public Object[] wf = new Object[20];
    public int wg;

    public ay(int i) {
    }

    public T bF() {
        if (this.wf == null || this.wg <= 0) {
            return null;
        }
        int i = this.wg - 1;
        T t = this.wf[i];
        this.wf[i] = null;
        this.wg--;
        return t;
    }

    public boolean i(T t) {
        if (this.wf == null) {
            return false;
        }
        int i;
        if (this.wf != null) {
            for (i = 0; i < this.wg; i++) {
                if (this.wf[i] == t) {
                    i = 1;
                    break;
                }
            }
        }
        boolean z = false;
        if (i != 0) {
            return false;
        }
        if (this.wg >= this.wf.length || this.wg < 0) {
            w.e("MicroMsg.SimpleObjectPool", "error index %d %d", Integer.valueOf(this.wg), Integer.valueOf(this.wf.length));
            return false;
        }
        this.wf[this.wg] = t;
        this.wg++;
        return true;
    }
}
