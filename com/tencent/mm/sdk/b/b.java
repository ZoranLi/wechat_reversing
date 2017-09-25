package com.tencent.mm.sdk.b;

public abstract class b {
    public Runnable nFq = null;
    public boolean use;
    private int usf = 0;

    final int bIx() {
        if (this.usf == 0) {
            this.usf = getClass().getName().hashCode();
        }
        return this.usf;
    }
}
