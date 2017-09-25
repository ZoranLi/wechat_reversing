package com.tencent.mm.plugin.voip_cs.b.a;

import com.tencent.mm.R;
import com.tencent.mm.plugin.voip.video.h;
import com.tencent.mm.sdk.platformtools.ab;

public final class a {
    private static a rsz;
    public h riY = new h(ab.getContext());

    private a() {
    }

    public static a brU() {
        if (rsz == null) {
            rsz = new a();
        }
        return rsz;
    }

    public static a brV() {
        if (rsz == null) {
            rsz = brU();
        }
        return rsz;
    }

    public final void brW() {
        if (this.riY != null) {
            this.riY.o(R.k.dyQ, 0, true);
        }
    }

    public final void aMX() {
        if (this.riY != null) {
            this.riY.stop();
        }
    }

    public final boolean bqn() {
        if (this.riY != null) {
            return this.riY.brA();
        }
        return true;
    }
}
