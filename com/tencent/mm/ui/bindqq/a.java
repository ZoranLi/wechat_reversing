package com.tencent.mm.ui.bindqq;

import com.tencent.mm.e.a.jd;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

public final class a extends c<jd> implements com.tencent.mm.ui.bindqq.b.a {
    private jd vuL;

    public a() {
        this.usg = jd.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        jd jdVar = (jd) bVar;
        if (jdVar instanceof jd) {
            this.vuL = jdVar;
            new b(this.vuL.fPg.fPi, this).bTm();
        }
        return false;
    }

    public final boolean t(int i, int i2, String str) {
        if (this.vuL == null) {
            return false;
        }
        if (this.vuL.fPg.fPj == null) {
            this.vuL = null;
            return false;
        } else if (i == 0 && i2 == 0) {
            this.vuL.fPh.fFj = true;
            this.vuL.fPg.fPj.run();
            this.vuL = null;
            return true;
        } else {
            this.vuL.fPh.fFj = false;
            this.vuL.fPg.fPj.run();
            this.vuL = null;
            return false;
        }
    }

    public final void bTl() {
        if (this.vuL != null && this.vuL.fPg.fPj != null) {
            this.vuL.fPh.fFj = false;
            this.vuL.fPg.fPj.run();
            this.vuL = null;
        }
    }
}
