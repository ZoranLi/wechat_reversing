package com.tencent.mm.plugin.card.ui.a;

import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.ui.MMActivity;

public final class e extends a {
    public e(MMActivity mMActivity) {
        super(mMActivity);
    }

    public final boolean aig() {
        if (!this.kcX.aeP() || l.kH(this.kkZ.jZM) || !this.kcX.afe() || this.kpB) {
            return true;
        }
        return false;
    }

    public final boolean aik() {
        return this.kcX.aeP() && !l.kH(this.kkZ.jZM) && this.kcX.afe() && !this.kpB;
    }

    public final boolean ail() {
        return this.kpB;
    }

    public final boolean aio() {
        return super.aio() || (this.kcX.afe() && !this.kpB && (ahV() || ahW()));
    }

    public final boolean aix() {
        return (!this.kcX.aeP() || this.kcX.afi().toC == null || !this.kcX.afe() || this.kpB || ahV() || ahW()) ? false : true;
    }

    public final boolean ait() {
        return this.kcX.afe() && super.ait() && !ain();
    }

    public final boolean ahY() {
        return (!super.ahY() || !this.kcX.afe() || this.kpB || ahV() || ahW()) ? false : true;
    }

    public final boolean ain() {
        return this.kcX.afi() != null && this.kcX.afi().toQ;
    }
}
