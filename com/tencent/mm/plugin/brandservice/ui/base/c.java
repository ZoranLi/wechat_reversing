package com.tencent.mm.plugin.brandservice.ui.base;

import com.tencent.mm.plugin.brandservice.ui.c.b;
import java.util.List;

public abstract class c extends a {
    public List<String> iJD;
    protected b jZX;
    protected int kbP;
    protected int position;

    public c(int i, Object obj) {
        super(i, obj);
    }

    public final void a(b bVar) {
        this.jZX = bVar;
    }

    public final b aev() {
        return this.jZX;
    }

    public final void ki(int i) {
        this.kbP = i;
    }

    public final int aew() {
        return this.kbP;
    }

    public final void kj(int i) {
        this.position = i;
    }

    public final int getPosition() {
        return this.position;
    }
}
