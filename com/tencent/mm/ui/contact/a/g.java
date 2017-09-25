package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fts.d.e;

public final class g extends a {
    public String mdo;
    private b waF = new b(this);
    a waG = new a(this);

    public class a extends com.tencent.mm.ui.contact.a.a.a {
        public TextView kze;
        final /* synthetic */ g waH;

        public a(g gVar) {
            this.waH = gVar;
            super(gVar);
        }
    }

    public class b extends com.tencent.mm.ui.contact.a.a.b {
        final /* synthetic */ g waH;

        public b(g gVar) {
            this.waH = gVar;
            super(gVar);
        }

        public final View a(Context context, ViewGroup viewGroup) {
            View inflate = LayoutInflater.from(context).inflate(R.i.dnK, viewGroup, false);
            a aVar = this.waH.waG;
            aVar.kze = (TextView) inflate.findViewById(R.h.bWg);
            inflate.setTag(aVar);
            return inflate;
        }

        public final void a(Context context, com.tencent.mm.ui.contact.a.a.a aVar, a aVar2, boolean z, boolean z2) {
            e.a(((g) aVar2).mdo, ((a) aVar).kze);
        }

        public final boolean Od() {
            return false;
        }
    }

    public g(int i) {
        super(0, i);
    }

    public final void br(Context context) {
    }

    public final com.tencent.mm.ui.contact.a.a.b Ob() {
        return this.waF;
    }

    protected final com.tencent.mm.ui.contact.a.a.a Oc() {
        return this.waG;
    }
}
