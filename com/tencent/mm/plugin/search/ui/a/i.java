package com.tencent.mm.plugin.search.ui.a;

import android.content.Context;
import com.tencent.mm.e.b.af;
import com.tencent.mm.plugin.fts.d.e;
import com.tencent.mm.plugin.search.ui.a.f.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.storage.q;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.n;

public final class i extends f {
    public q phm;
    public String phn;
    private a pho = new a(this);

    public class a extends b {
        final /* synthetic */ i php;

        public a(i iVar) {
            this.php = iVar;
            super(iVar);
        }

        public final void a(Context context, com.tencent.mm.plugin.fts.d.a.a.a aVar, com.tencent.mm.plugin.fts.d.a.a aVar2) {
            i iVar = (i) aVar2;
            com.tencent.mm.plugin.search.ui.a.f.a aVar3 = (com.tencent.mm.plugin.search.ui.a.f.a) aVar;
            ch(aVar3.ipu);
            if (bg.mA(iVar.iJC.fJL)) {
                com.tencent.mm.pluginsdk.ui.a.b.a(aVar3.ipv, iVar.iJC.lZO);
            } else {
                com.tencent.mm.pluginsdk.ui.a.b.a(aVar3.ipv, iVar.iJC.fJL);
            }
            e.a(iVar.phn, aVar3.jWd);
            e.a(iVar.ipr, aVar3.kxh);
        }
    }

    public i(int i) {
        super(i);
    }

    public final com.tencent.mm.plugin.fts.d.a.a.b Sr() {
        return this.pho;
    }

    public final void a(Context context, com.tencent.mm.plugin.fts.d.a.a.a aVar, Object... objArr) {
        super.a(context, aVar, objArr);
        ap.yY();
        af Rc = c.wR().Rc(this.iJC.fJL);
        if (Rc == null) {
            this.phn = n.eK(this.iJC.lZO);
        } else if (!bg.mA(Rc.field_conRemark)) {
            this.phn = Rc.field_conRemark;
        } else if (this.phm != null) {
            String eK = this.phm.eK(this.iJC.fJL);
            if (bg.mA(eK)) {
                this.phn = n.eJ(this.iJC.fJL);
            } else {
                this.phn = eK;
            }
        } else {
            this.phn = n.eJ(this.iJC.fJL);
        }
    }
}
