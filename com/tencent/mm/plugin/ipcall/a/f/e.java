package com.tencent.mm.plugin.ipcall.a.f;

import com.tencent.mm.plugin.ipcall.a.a.a;
import com.tencent.mm.plugin.ipcall.a.a.c;
import com.tencent.mm.plugin.ipcall.a.h;
import com.tencent.mm.protocal.c.art;
import com.tencent.mm.y.k;

public final class e extends a implements h.a {
    private h mQO = null;

    public final int[] aEt() {
        return new int[0];
    }

    public final int De() {
        return 8;
    }

    public final void oo() {
        this.mQO = new h();
        this.mQO.mNi = this;
        com.tencent.mm.sdk.b.a.urY.b(this.mQO);
    }

    public final void onDestroy() {
        com.tencent.mm.sdk.b.a.urY.c(this.mQO);
    }

    public final void b(c cVar) {
    }

    public final void a(int i, int i2, String str, k kVar) {
    }

    public final void a(art com_tencent_mm_protocal_c_art) {
        this.mNH.a(8, com_tencent_mm_protocal_c_art, 0, 0);
    }
}
