package com.tencent.mm.plugin.gcm.modelgcm;

import com.tencent.mm.bj.g.c;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.am;
import java.util.HashMap;

public final class b implements am {
    public final HashMap<Integer, c> uh() {
        return null;
    }

    public final void eD(int i) {
    }

    public final void aM(boolean z) {
        w.i("MicroMsg.GcmSubCore", "GcmSubCore onAccountPostReset!");
    }

    public final void aN(boolean z) {
    }

    public final void onAccountRelease() {
        w.i("MicroMsg.GcmSubCore", "GcmSubCore onAccountRelease!");
    }
}
