package com.tencent.mm.plugin.card.ui;

import com.tencent.mm.plugin.card.base.a;
import com.tencent.mm.plugin.card.base.b;

public final class h implements a {
    private g knB;

    public final /* synthetic */ b kl(int i) {
        return this.knB != null ? this.knB.kx(i) : null;
    }

    public h(g gVar) {
        this.knB = gVar;
    }

    public final void onCreate() {
        this.knB.notifyDataSetChanged();
    }

    public final void onDestroy() {
        if (this.knB != null) {
            g gVar = this.knB;
            gVar.kiu.release();
            gVar.kiu = null;
            gVar.kiF.clear();
            gVar.mContext = null;
            gVar.knz = null;
            this.knB = null;
        }
    }

    public final void zm() {
        if (this.knB != null) {
            this.knB.notifyDataSetChanged();
        }
    }
}
