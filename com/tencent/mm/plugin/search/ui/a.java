package com.tencent.mm.plugin.search.ui;

import android.os.Looper;
import com.tencent.mm.plugin.fts.d.i;
import com.tencent.mm.plugin.fts.d.i.b;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.HashSet;

public final class a extends b implements b {
    private com.tencent.mm.plugin.search.ui.c.a peJ;
    protected boolean peK;
    private ae peL = new ae(Looper.getMainLooper());

    public a(c cVar) {
        super(cVar);
        this.peJ = new com.tencent.mm.plugin.search.ui.c.a(cVar.getContext(), this, 0);
    }

    protected final com.tencent.mm.plugin.fts.d.a.a mT(int i) {
        return this.peJ.mT(i);
    }

    protected final void aZo() {
        this.peK = false;
        this.peJ.a(this.fRM, this.peL, new HashSet());
    }

    protected final boolean a(com.tencent.mm.plugin.fts.d.a.a aVar) {
        return false;
    }

    public final void a(i iVar, String str) {
        int mS = this.peJ.mS(0);
        sn(mS);
        notifyDataSetChanged();
        L(mS, true);
    }
}
