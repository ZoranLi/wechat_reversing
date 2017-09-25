package com.tencent.mm.app;

import android.graphics.Bitmap;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.j;
import com.tencent.mm.pluginsdk.ui.j.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.x.d;
import com.tencent.mm.x.n;

final class b implements a {
    private Bitmap fvM;
    d fvN;

    public b() {
        this.fvM = null;
        this.fvM = com.tencent.mm.compatible.f.a.decodeResource(ab.getContext().getResources(), R.k.bes);
    }

    public final void a(j jVar) {
        if (jVar instanceof d.a) {
            n.Bl().a((d.a) jVar);
        }
    }

    public final Bitmap bf(String str) {
        return com.tencent.mm.x.b.a(str, false, -1);
    }

    public final Bitmap nZ() {
        return this.fvM;
    }

    public final Bitmap bg(String str) {
        if (this.fvN == null) {
            this.fvN = n.Bl();
        }
        return d.hj(str);
    }

    public final Bitmap a(String str, int i, int i2, int i3) {
        return com.tencent.mm.x.b.b(str, i, i2, i3);
    }
}
