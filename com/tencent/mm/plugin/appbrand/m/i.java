package com.tencent.mm.plugin.appbrand.m;

public final class i implements k {
    final k jnZ;
    int joa = 0;
    int job = -1;
    int joc = -1;
    Object jod = null;

    public i(k kVar) {
        this.jnZ = kVar;
    }

    public final void XL() {
        if (this.joa != 0) {
            switch (this.joa) {
                case 1:
                    this.jnZ.bs(this.job, this.joc);
                    break;
                case 2:
                    this.jnZ.bt(this.job, this.joc);
                    break;
                case 3:
                    this.jnZ.d(this.job, this.joc, this.jod);
                    break;
            }
            this.jod = null;
            this.joa = 0;
        }
    }

    public final void bs(int i, int i2) {
        if (this.joa != 1 || i < this.job || i > this.job + this.joc) {
            XL();
            this.job = i;
            this.joc = i2;
            this.joa = 1;
            return;
        }
        this.joc += i2;
        this.job = Math.min(i, this.job);
    }

    public final void bt(int i, int i2) {
        if (this.joa != 2 || this.job < i || this.job > i + i2) {
            XL();
            this.job = i;
            this.joc = i2;
            this.joa = 2;
            return;
        }
        this.joc += i2;
        this.job = i;
    }

    public final void bu(int i, int i2) {
        XL();
        this.jnZ.bu(i, i2);
    }

    public final void d(int i, int i2, Object obj) {
        if (this.joa != 3 || i > this.job + this.joc || i + i2 < this.job || this.jod != obj) {
            XL();
            this.job = i;
            this.joc = i2;
            this.jod = obj;
            this.joa = 3;
            return;
        }
        int i3 = this.job + this.joc;
        this.job = Math.min(i, this.job);
        this.joc = Math.max(i3, i + i2) - this.job;
    }
}
