package com.tencent.tinker.a.b.a;

public final class h extends a {
    public short[] xdt;

    public h(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("initSize < 0");
        }
        this.xdt = new short[i];
    }

    public final void c(short s) {
        int i = this.xdl;
        if (this.xdt.length - i <= 0) {
            Object obj = new short[(this.xdt.length + (this.xdt.length >> 1))];
            System.arraycopy(this.xdt, 0, obj, 0, i);
            this.xdt = obj;
        }
        this.xdt[this.xdl] = s;
        cgI();
    }

    public final void b(short s, short s2) {
        c(s);
        c(s2);
    }

    public final void a(short s, short s2, short s3) {
        c(s);
        c(s2);
        c(s3);
    }

    public final void writeInt(int i) {
        c((short) i);
        c((short) (i >> 16));
    }
}
