package com.tencent.mm.plugin.photoedit;

import com.tencent.mm.bj.g;
import com.tencent.mm.e.a.ky;
import com.tencent.mm.plugin.photoedit.cache.ArtistCacheManager;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.u.am;
import java.util.HashMap;

public final class a implements am {
    c<ky> oiN = new c<ky>(this) {
        final /* synthetic */ a oiO;

        {
            this.oiO = r2;
            this.usg = ky.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            if (((ky) bVar).fRF.fEG == 0) {
                ArtistCacheManager.aSf().aSg();
            }
            return false;
        }
    };

    public final HashMap<Integer, g.c> uh() {
        return null;
    }

    public final void eD(int i) {
    }

    public final void aM(boolean z) {
        this.oiN.bIy();
    }

    public final void aN(boolean z) {
    }

    public final void onAccountRelease() {
        this.oiN.dead();
        ArtistCacheManager.aSf().aSg();
    }
}
