package com.tencent.mm.plugin.brandservice;

import com.tencent.mm.bj.g;
import com.tencent.mm.e.a.oa;
import com.tencent.mm.plugin.brandservice.a.l;
import com.tencent.mm.plugin.brandservice.ui.a.d;
import com.tencent.mm.plugin.fts.d.h;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.am;
import com.tencent.mm.u.ap;
import java.util.HashMap;

public final class b implements am {
    private a jZb;

    public static class a extends c<oa> {
        public a() {
            this.usg = oa.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            oa oaVar = (oa) bVar;
            if (oaVar instanceof oa) {
                if (!(oaVar.fVh == null || bg.mA(oaVar.fVh.fTJ) || oaVar.fVh.fVi == null)) {
                    ap.vd().a(new l(oaVar.fVh.fTJ, oaVar.fVh.fVi), 0);
                }
                return true;
            }
            w.f("MicroMsg.BrandService.SubCoreBrandService", "mismatched event");
            return false;
        }
    }

    public final HashMap<Integer, g.c> uh() {
        return null;
    }

    public final void eD(int i) {
    }

    public final void aN(boolean z) {
    }

    public final void aM(boolean z) {
        w.d("MicroMsg.BrandService.SubCoreBrandService", "on sub core brand service reset");
        if (this.jZb == null) {
            this.jZb = new a();
        }
        com.tencent.mm.sdk.b.a.urY.b(this.jZb);
        h.a(new d());
        h.a(new com.tencent.mm.plugin.brandservice.ui.a.b());
    }

    public final void onAccountRelease() {
        if (this.jZb != null) {
            com.tencent.mm.sdk.b.a.urY.c(this.jZb);
        }
        h.mV(96);
        h.mV(4192);
    }
}
