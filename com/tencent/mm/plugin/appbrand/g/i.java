package com.tencent.mm.plugin.appbrand.g;

import android.content.Context;
import android.view.MenuItem;
import com.tencent.mm.plugin.appbrand.menu.j;
import com.tencent.mm.plugin.appbrand.menu.k;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.e;
import java.util.List;

final class i {
    public m iYE;
    public String ivH;
    public e jcm;
    public List<j> jcn;

    i(Context context, String str, m mVar, List<j> list) {
        this.ivH = str;
        this.iYE = mVar;
        this.jcn = list;
        this.jcm = new e(context, e.wuP, false);
        this.jcm.qJf = new c(this) {
            final /* synthetic */ i jco;

            {
                this.jco = r1;
            }

            public final void a(l lVar) {
                for (j jVar : this.jco.jcn) {
                    if (!(jVar == null || jVar.jax)) {
                        com.tencent.mm.plugin.appbrand.menu.l.a(this.jco.iYE.mContext, this.jco.iYE, lVar, this.jco.ivH, jVar);
                    }
                }
            }
        };
        this.jcm.qJg = new d(this) {
            final /* synthetic */ i jco;

            {
                this.jco = r1;
            }

            public final void c(MenuItem menuItem, int i) {
                int hZ = k.hZ(menuItem.getItemId());
                if (hZ != 0) {
                    if (com.tencent.mm.plugin.appbrand.menu.l.b(this.jco.iYE.mContext, this.jco.iYE, this.jco.ivH, com.tencent.mm.plugin.appbrand.menu.l.c(this.jco.jcn, hZ - 1))) {
                        this.jco.jcm.bzi();
                    }
                }
            }
        };
        this.jcm.bzh();
    }
}
