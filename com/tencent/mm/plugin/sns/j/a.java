package com.tencent.mm.plugin.sns.j;

import android.database.Cursor;
import com.tencent.mm.e.b.af;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.sns.j.c.b;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.storage.i;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.protocal.c.bau;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.ar;
import com.tencent.mm.u.m;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class a extends com.tencent.mm.vending.app.a implements e {
    String jia;
    public volatile av qHY;
    protected volatile com.tencent.mm.plugin.sns.model.al.a qKl;
    private com.tencent.mm.plugin.sns.b.g.a qPE;
    String qrl;
    boolean qrm;
    boolean qrn;
    int qro;

    public final void a(com.tencent.mm.plugin.sns.b.g.a aVar) {
        this.qKl = ae.beB();
        com.tencent.mm.plugin.sns.j.c.a aVar2 = (com.tencent.mm.plugin.sns.j.c.a) y(com.tencent.mm.plugin.sns.j.c.a.class);
        this.qPE = aVar;
        this.qKl.a(1, aVar2.jia, this.qPE);
    }

    public final com.tencent.mm.plugin.sns.model.al.a beB() {
        return this.qKl;
    }

    protected final void onCreate() {
        super.onCreate();
        a(b.class, new com.tencent.mm.vending.app.a.a<b>(this) {
            final /* synthetic */ a qPF;

            {
                this.qPF = r1;
            }

            protected final /* synthetic */ Object NX() {
                w.i("MicroMsg.SnsTimelineInteractor", "SnsTimelineInteractor index %s", new Object[]{b.class});
                return a.blN();
            }
        });
        a(com.tencent.mm.plugin.sns.j.c.a.class, new com.tencent.mm.vending.app.a.a<com.tencent.mm.plugin.sns.j.c.a>(this) {
            final /* synthetic */ a qPF;

            {
                this.qPF = r1;
            }

            protected final /* synthetic */ Object NX() {
                w.i("MicroMsg.SnsTimelineInteractor", "SnsTimelineInteractor index %s", new Object[]{com.tencent.mm.plugin.sns.j.c.a.class});
                com.tencent.mm.vending.app.a aVar = this.qPF;
                com.tencent.mm.plugin.sns.j.c.a aVar2 = new com.tencent.mm.plugin.sns.j.c.a();
                aVar.qro = aVar.wBK.getIntExtra("sns_source", 0);
                aVar.jia = aVar.wBK.getStringExtra("sns_userName");
                if (aVar.jia == null) {
                    aVar.jia = "";
                }
                h.vJ();
                aVar.qrm = ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().QY(aVar.jia);
                aVar.qrl = m.xL();
                aVar.qrn = aVar.qrl.equals(aVar.jia);
                ar bez = ae.bez();
                String ap = bg.ap(aVar.wBK.getStringExtra("sns_signature"), "");
                String ap2 = bg.ap(aVar.wBK.getStringExtra("sns_nickName"), "");
                af Rc = (aVar.jia == null || aVar.jia.equals("")) ? bez.Rc(aVar.qrl) : bez.Rc(aVar.jia);
                if (Rc != null && ((int) Rc.gTQ) > 0) {
                    ap = Rc.signature;
                    ap2 = Rc.tK();
                    w.i("MicroMsg.SnsTimelineInteractor", "contact:user[%s] id[%d] nickname[%s]", new Object[]{Rc.field_username, Integer.valueOf((int) Rc.gTQ), ap2});
                }
                aVar2.jia = aVar.jia;
                aVar2.qrl = aVar.qrl;
                aVar2.qrm = aVar.qrm;
                aVar2.qrn = aVar.qrn;
                aVar2.qro = aVar.qro;
                aVar2.mwO = ap2;
                aVar2.qJM = ap;
                return aVar2;
            }
        });
        w.i("MicroMsg.SnsTimelineInteractor", "SnsTimelineInteractor onCreate %s", new Object[]{this});
        ae.beG().pSD.clear();
        ae.beG();
        com.tencent.mm.plugin.sns.model.b.bdO();
    }

    protected final void onDestroy() {
        w.i("MicroMsg.SnsTimelineInteractor", "SnsTimelineInteractor onDestroy %s", new Object[]{this});
        h.vJ();
        if (!(!h.vG().uV() || this.qKl == null || this.qPE == null)) {
            this.qKl.a(this.qPE, 1);
        }
        super.onDestroy();
    }

    public static b blN() {
        String str;
        b bVar = new b();
        Cursor bhj = ae.beP().bhj();
        int count = bhj.getCount();
        String str2 = "";
        if (count > 0) {
            bhj.moveToFirst();
            i iVar = new i();
            iVar.b(bhj);
            try {
                str = ((bau) new bau().aD(iVar.field_curActionBuf)).tWt;
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.SnsTimelineInteractor", e, "", new Object[0]);
            }
            bhj.close();
            bVar.qPL = count;
            bVar.qPK = str;
            return bVar;
        }
        str = str2;
        bhj.close();
        bVar.qPL = count;
        bVar.qPK = str;
        return bVar;
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.i("MicroMsg.SnsTimelineInteractor", "SnsTimelineInteractor onSceneEnd  errType %d %d %s %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, kVar.toString()});
    }

    public final void g(String str, boolean z, int i) {
        this.qKl.a(1, str, z, i);
    }

    public final void h(String str, boolean z, int i) {
        this.qKl.b(1, str, z, i);
    }
}
