package com.tencent.mm.plugin.product.ui;

import com.tencent.mm.sdk.platformtools.w;

public final class e {
    int oqP;
    int oqQ;

    public e(int i, int i2) {
        this.oqQ = i;
        this.oqP = i2;
    }

    public final boolean aTp() {
        boolean z = (this.oqQ & 1) > 0;
        w.d("MicroMsg.MallProductConfig", "isFreePost, ret = " + z);
        return z;
    }
}
