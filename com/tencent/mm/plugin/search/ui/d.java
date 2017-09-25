package com.tencent.mm.plugin.search.ui;

import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.b.e;
import com.tencent.mm.plugin.fts.a.j;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.search.ui.a.f;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.List;

public final class d extends b implements j {
    private String fJL;
    private List<String> iJD;
    private ae kir = new ae();
    private a mah;
    private List<i> mcR;

    public d(c cVar, String str) {
        super(cVar);
        this.fJL = str;
    }

    protected final com.tencent.mm.plugin.fts.d.a.a mT(int i) {
        com.tencent.mm.plugin.fts.d.a.a fVar = new f(i);
        fVar.iJC = (i) this.mcR.get(i);
        fVar.iJD = this.iJD;
        fVar.mde = -12;
        fVar.fRM = this.fRM;
        fVar.mdf = i;
        if (fVar.position == getCount() - 1) {
            fVar.mdd = true;
        }
        return fVar;
    }

    protected final void aZo() {
        if (this.mah != null) {
            ((l) h.j(l.class)).cancelSearchTask(this.mah);
        }
        com.tencent.mm.plugin.fts.a.a.f fVar = new com.tencent.mm.plugin.fts.a.a.f();
        fVar.fRM = this.fRM;
        fVar.fJL = this.fJL;
        fVar.maf = e.maF;
        fVar.mag = this;
        fVar.handler = this.kir;
        fVar.lZZ = 3;
        this.mah = ((l) h.j(l.class)).search(3, fVar);
        w.i("MicroMSsg.FTS.FTSChattingTalkerAdapter", "do search %s", new Object[]{this.fRM});
    }

    public final void a(g gVar) {
        switch (gVar.aMA) {
            case -3:
            case -2:
            case -1:
                sn(0);
                notifyDataSetChanged();
                L(getCount(), true);
                return;
            case 0:
                this.mcR = gVar.maj;
                this.iJD = bg.f(gVar.mai);
                sn(this.mcR.size());
                notifyDataSetChanged();
                L(getCount(), true);
                return;
            default:
                return;
        }
    }

    protected final boolean a(com.tencent.mm.plugin.fts.d.a.a aVar) {
        return false;
    }
}
