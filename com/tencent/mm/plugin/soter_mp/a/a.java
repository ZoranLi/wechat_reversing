package com.tencent.mm.plugin.soter_mp.a;

import android.app.Activity;
import com.tencent.mm.plugin.soter_mp.b.c;
import com.tencent.mm.plugin.soter_mp.b.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import java.lang.ref.WeakReference;

public final class a {
    public static final int qQF = 1;
    private static final /* synthetic */ int[] qQG = new int[]{qQF};

    public static c a(Activity activity, c cVar, d dVar) {
        if ((cVar.qQX & 1) != 0 && com.tencent.d.a.a.hc(ab.getContext())) {
            return new b(new WeakReference(activity), cVar, dVar);
        }
        w.e("MicroMsg.SoterControllerFactory", "hy: no matching: %d", new Object[]{Byte.valueOf(cVar.qQX)});
        return null;
    }
}
