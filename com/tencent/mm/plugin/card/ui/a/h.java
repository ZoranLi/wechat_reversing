package com.tencent.mm.plugin.card.ui.a;

import android.text.TextUtils;
import com.tencent.mm.plugin.card.sharecard.a.b;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;

public final class h extends a {
    public h(MMActivity mMActivity) {
        super(mMActivity);
    }

    protected final void ahX() {
        super.ahX();
    }

    public final boolean aih() {
        ArrayList sA = b.sA(this.kcX.afn());
        if ((!this.kkZ.kdR || this.kkZ.jZM == 4) && !TextUtils.isEmpty(this.kcX.afo())) {
            return true;
        }
        if (this.kkZ.kdR && sA != null && sA.size() > 0) {
            return true;
        }
        if (TextUtils.isEmpty(this.kcX.afo()) || !aii()) {
            return false;
        }
        return true;
    }

    public final boolean aii() {
        return this.kkZ.jZM == 3;
    }

    public final boolean aij() {
        return false;
    }

    public final boolean ail() {
        return this.kpB;
    }

    public final boolean aio() {
        return false;
    }

    public final boolean aip() {
        return this.kpB && super.aip();
    }

    public final boolean ait() {
        return false;
    }

    public final boolean aiu() {
        return false;
    }

    public final boolean aim() {
        return false;
    }

    public final boolean aiv() {
        if (super.aiv() || aiw()) {
            return true;
        }
        if (this.kcX.aeO() && this.kpB) {
            return true;
        }
        return false;
    }

    public final boolean aiw() {
        return !this.kpB && this.kcX.afi().toH == 1;
    }
}
