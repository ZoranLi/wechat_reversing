package com.tencent.mm.performance.d;

public abstract class a {
    protected long igJ = -1;
    public long igK = -1;

    public abstract String Nb();

    public abstract void Nc();

    public final boolean Nd() {
        if (this.igK == -1) {
            return true;
        }
        if (this.igJ == -1) {
            this.igJ = System.currentTimeMillis();
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.igJ < this.igK) {
            return false;
        }
        this.igJ = currentTimeMillis;
        return true;
    }
}
