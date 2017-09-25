package com.tencent.mm.plugin.appbrand.m;

public final class f {
    private long jnU;
    private long jnV;
    private a jnW;

    public interface a {
        boolean f(Object... objArr);
    }

    public f(long j, a aVar) {
        this.jnU = j;
        this.jnW = aVar;
    }

    public final boolean h(Object... objArr) {
        boolean z = false;
        if (!((System.currentTimeMillis() - this.jnV < this.jnU) || this.jnW == null)) {
            z = this.jnW.f(objArr);
            if (z) {
                this.jnV = System.currentTimeMillis();
            }
        }
        return z;
    }
}
