package com.tencent.mm.plugin.hp;

import com.tencent.mm.app.MMApplicationLike;
import com.tencent.mm.e.a.bb;
import com.tencent.mm.e.a.bc;
import com.tencent.mm.plugin.hp.b.c;
import com.tencent.mm.plugin.hp.tinker.d;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.pluginsdk.i;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.w;

public final class a implements k {
    public c mKV = new c();
    private com.tencent.mm.sdk.b.c<bc> mKW = new com.tencent.mm.sdk.b.c<bc>(this) {
        final /* synthetic */ a mKY;

        {
            this.mKY = r2;
            this.usg = bc.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            bc bcVar = (bc) bVar;
            if (29 == bcVar.fEF.fEB && bcVar.fEF.fEG == 0) {
                w.d("Tinker.HotPatchApplication", "hp_res received new hotpatch cache request");
                com.tencent.mm.plugin.hp.b.b.nX(0);
            }
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c<bb> mKX = new com.tencent.mm.sdk.b.c<bb>(this) {
        final /* synthetic */ a mKY;

        {
            this.mKY = r2;
            this.usg = bb.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            bb bbVar = (bb) bVar;
            if (29 == bbVar.fEA.fEB && bbVar.fEA.fEE) {
                w.d("Tinker.HotPatchApplication", "hp_res received new/updated download resource, path=%s", new Object[]{bbVar.fEA.filePath});
                com.tencent.mm.plugin.hp.b.b.nY(0);
                c.yn(bbVar.fEA.filePath);
            }
            return false;
        }
    };

    public a() {
        d.aDk();
        d.a(MMApplicationLike.getTinkerApplicationLike());
        com.tencent.mm.sdk.b.a.urY.b(this.mKV);
        com.tencent.mm.sdk.b.a.urY.b(this.mKX);
        com.tencent.mm.sdk.b.a.urY.b(this.mKW);
    }

    public final void a(i iVar) {
    }

    public final void a(h hVar) {
    }
}
