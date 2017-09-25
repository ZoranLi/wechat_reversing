package com.tencent.mm.plugin.record.ui;

import android.content.Context;
import com.tencent.mm.plugin.record.a.g;
import com.tencent.mm.plugin.record.a.i.a;
import com.tencent.mm.plugin.record.ui.a.b;

public final class e extends h implements a {
    public e(Context context, h.a aVar) {
        super(context, aVar);
    }

    public final void a(a aVar) {
        this.oPi = aVar;
        this.oOQ.clear();
        this.oOQ.addAll(aVar.oOQ);
        notifyDataSetChanged();
    }

    public final void d(b bVar) {
        bVar.aMw = 0;
        bVar.fGM = ((f) this.oPi).fGM;
        bVar.fTh = ((f) this.oPi).fTh;
    }

    public final void a(int i, g gVar) {
        aWR();
    }
}
