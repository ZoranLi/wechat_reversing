package com.tencent.mm.plugin.pwdgroup;

import android.graphics.Bitmap;
import com.tencent.mm.a.f;
import com.tencent.mm.plugin.pwdgroup.b.a;
import com.tencent.mm.pluginsdk.ui.j;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.am;
import com.tencent.mm.x.d;
import com.tencent.mm.x.n;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public final class c implements am {
    public final HashMap<Integer, com.tencent.mm.bj.g.c> uh() {
        return null;
    }

    public final void eD(int i) {
    }

    public final void aM(boolean z) {
        a.owB = new j.a(this) {
            private Bitmap fvM = null;
            private f<String, WeakReference<Bitmap>> owC;
            final /* synthetic */ c owD;

            {
                this.owD = r5;
                try {
                    this.fvM = b.a(ab.getContext().getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.bg.a.getDensity(null));
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.Facing.SubCorePwdGroup", e, "", new Object[0]);
                }
                this.owC = new f(15);
            }

            public final void a(j jVar) {
                if (jVar instanceof d.a) {
                    n.Bl().a((d.a) jVar);
                }
            }

            public final Bitmap bf(String str) {
                WeakReference weakReference = (WeakReference) this.owC.get(str);
                if (weakReference != null && weakReference.get() != null && !((Bitmap) weakReference.get()).isRecycled() && weakReference.get() == this.fvM) {
                    return (Bitmap) weakReference.get();
                }
                Bitmap a = com.tencent.mm.x.b.a(str, false, -1);
                if (a == null || a.isRecycled()) {
                    return this.fvM;
                }
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

    public final void aN(boolean z) {
    }

    public final void onAccountRelease() {
    }
}
