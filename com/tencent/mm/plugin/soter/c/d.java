package com.tencent.mm.plugin.soter.c;

import com.tencent.mm.e.a.cg;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.w;

public final class d extends c<cg> {
    private static String TAG = "MicroMsg.SoterDynamicConfigUpdatedEventListener";

    public d() {
        this.usg = cg.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        w.i(TAG, "alvinluo dynamic config updated.");
        g.blV();
        return true;
    }
}
