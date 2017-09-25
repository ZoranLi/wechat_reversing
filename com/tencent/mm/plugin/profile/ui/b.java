package com.tencent.mm.plugin.profile.ui;

import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.f;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.contact.a.e;
import com.tencent.mm.ui.contact.l;
import com.tencent.mm.ui.contact.m;
import java.util.List;

public final class b extends m {
    private String fRM;
    private ae handler = new ae();
    private x jiL;
    private a mah;
    private List<i> mcR;
    private j osJ = new j(this) {
        final /* synthetic */ b osK;

        {
            this.osK = r1;
        }

        public final void a(g gVar) {
            if (gVar.aMA == 0) {
                this.osK.mcR = gVar.maj;
                if (this.osK.vYe != null) {
                    this.osK.vYe.r(gVar.lYe.fRM, this.osK.mcR.size(), true);
                }
            }
            this.osK.notifyDataSetChanged();
        }
    };

    public b(l lVar, int i, x xVar) {
        super(lVar, false, i);
        this.jiL = xVar;
    }

    protected final com.tencent.mm.ui.contact.a.a hg(int i) {
        com.tencent.mm.ui.contact.a.a eVar = new e(i);
        ap.yY();
        eVar.jiL = c.wR().Rc(((i) this.mcR.get(i)).lZO);
        return eVar;
    }

    public final int getCount() {
        if (this.mcR == null) {
            return 0;
        }
        return this.mcR.size();
    }

    public final void a(String str, int[] iArr, boolean z) {
        this.fRM = str;
        f fVar = new f();
        fVar.fRM = str;
        fVar.handler = this.handler;
        fVar.mag = this.osJ;
        fVar.fJL = this.jiL.field_username;
        fVar.lZZ = 7;
        this.mah = ((com.tencent.mm.plugin.fts.a.l) h.j(com.tencent.mm.plugin.fts.a.l.class)).search(2, fVar);
    }

    public final void QZ() {
        this.fRM = null;
        if (this.mah != null) {
            ((com.tencent.mm.plugin.fts.a.l) h.j(com.tencent.mm.plugin.fts.a.l.class)).cancelSearchTask(this.mah);
        }
    }
}
