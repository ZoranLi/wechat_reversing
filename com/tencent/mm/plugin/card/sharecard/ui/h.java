package com.tencent.mm.plugin.card.sharecard.ui;

import com.tencent.mm.plugin.card.base.a;
import com.tencent.mm.plugin.card.base.b;

public final class h implements a {
    private g kiG;

    public h(g gVar) {
        this.kiG = gVar;
    }

    public final void onCreate() {
        this.kiG.notifyDataSetChanged();
    }

    public final void onDestroy() {
        if (this.kiG != null) {
            g gVar = this.kiG;
            gVar.kiu.release();
            gVar.kiu = null;
            gVar.kiF.clear();
            gVar.mContext = null;
            this.kiG = null;
        }
    }

    public final void zm() {
        if (this.kiG != null) {
            this.kiG.notifyDataSetChanged();
        }
    }

    public final b kl(int i) {
        if (this.kiG != null) {
            return this.kiG.kl(i);
        }
        return null;
    }
}
