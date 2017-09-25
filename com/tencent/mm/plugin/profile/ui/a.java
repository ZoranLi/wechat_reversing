package com.tencent.mm.plugin.profile.ui;

import android.os.Looper;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.contact.a.e;
import com.tencent.mm.ui.contact.l;
import com.tencent.mm.ui.contact.o;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public final class a extends o implements j {
    ae handler = new ae(Looper.getMainLooper());
    x jiL;
    private List<i> mcR;

    private class a implements Comparator<i> {
        final /* synthetic */ a osI;

        public a(a aVar) {
            this.osI = aVar;
        }

        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            i iVar = (i) obj;
            i iVar2 = (i) obj2;
            if (iVar2.timestamp > iVar.timestamp) {
                return 1;
            }
            return iVar2.timestamp < iVar.timestamp ? -1 : 0;
        }
    }

    public a(l lVar, int i, x xVar) {
        super(lVar, new ArrayList(), true, false, i);
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

    public final void a(g gVar) {
        if (gVar.aMA == 0) {
            this.mcR = gVar.maj;
        }
        notifyDataSetChanged();
    }
}
