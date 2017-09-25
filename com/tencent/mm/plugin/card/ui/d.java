package com.tencent.mm.plugin.card.ui;

import com.tencent.mm.plugin.card.base.a;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.al;

public final class d implements a {
    private c kkf;

    public final /* synthetic */ b kl(int i) {
        return this.kkf != null ? (CardInfo) this.kkf.getItem(i) : null;
    }

    public d(c cVar) {
        this.kkf = cVar;
    }

    public final void onCreate() {
        if (this.kkf != null) {
            al.aga().c(this.kkf);
        }
    }

    public final void onDestroy() {
        if (this.kkf != null) {
            al.aga().f(this.kkf);
            c cVar = this.kkf;
            cVar.aEW();
            cVar.kiu.release();
            cVar.kiu = null;
            this.kkf = null;
        }
    }

    public final void zm() {
        if (this.kkf != null) {
            this.kkf.a(null, null);
        }
    }
}
