package com.tencent.mm.plugin.radar;

import android.graphics.Bitmap;
import com.tencent.mm.a.f;
import com.tencent.mm.bj.g.c;
import com.tencent.mm.plugin.radar.ui.b.a;
import com.tencent.mm.pluginsdk.ui.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.am;
import com.tencent.mm.x.n;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public final class b implements am {
    public final HashMap<Integer, c> uh() {
        return null;
    }

    public final void eD(int i) {
    }

    public final void aN(boolean z) {
    }

    public final void aM(boolean z) {
        a.owB = new j.a(this) {
            private Bitmap fvM = null;
            private Bitmap oGt = null;
            final /* synthetic */ b oGu;
            private f<String, WeakReference<Bitmap>> owC;

            {
                this.oGu = r5;
                try {
                    this.fvM = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(ab.getContext().getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.bg.a.getDensity(null));
                    this.oGt = d.a(this.fvM, false, (float) (this.fvM.getWidth() / 2));
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.SubCoreRadar", e, "", new Object[0]);
                }
                this.owC = new f(15);
            }

            public final void a(j jVar) {
                if (jVar instanceof com.tencent.mm.x.d.a) {
                    n.Bl().a((com.tencent.mm.x.d.a) jVar);
                }
            }

            public final Bitmap bf(String str) {
                WeakReference weakReference = (WeakReference) this.owC.get(str);
                if (weakReference != null && weakReference.get() != null && !((Bitmap) weakReference.get()).isRecycled() && weakReference.get() == this.fvM) {
                    return (Bitmap) weakReference.get();
                }
                Bitmap a = com.tencent.mm.x.b.a(str, false, -1);
                if (a == null || a.isRecycled()) {
                    return this.oGt;
                }
                a = d.a(a, false, (float) (a.getWidth() / 2));
                this.owC.k(str, new WeakReference(a));
                return a;
            }

            public final Bitmap nZ() {
                return this.fvM;
            }

            public final Bitmap bg(String str) {
                return null;
            }

            public final Bitmap a(String str, int i, int i2, int i3) {
                return null;
            }
        };
    }

    public final void onAccountRelease() {
    }
}
