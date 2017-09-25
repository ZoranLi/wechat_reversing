package com.tencent.mm.booter.notification.a;

import com.tencent.mm.R;
import com.tencent.mm.ba.a;
import com.tencent.mm.i.f;

public final class c {
    public int gLU = -1;

    public final int o(String str, int i) {
        this.gLU = a.bCk();
        if (f.eu(i)) {
            if (f.dD(str)) {
                try {
                    this.gLU = R.g.blz;
                } catch (Exception e) {
                }
            } else if (f.dE(str)) {
                try {
                    this.gLU = R.g.blz;
                } catch (Exception e2) {
                }
            }
        }
        if (this.gLU < 0) {
            this.gLU = a.bCk();
        }
        return this.gLU;
    }
}
