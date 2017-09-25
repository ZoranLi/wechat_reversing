package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fts.d.e;
import com.tencent.mm.plugin.fts.d.f;

public final class h extends a {
    public CharSequence waI;
    private b waJ = new b(this);
    com.tencent.mm.ui.contact.a.a.a waK = new a(this);

    public class a extends com.tencent.mm.ui.contact.a.a.a {
        public TextView oCS;
        final /* synthetic */ h waL;

        public a(h hVar) {
            this.waL = hVar;
            super(hVar);
        }
    }

    public class b extends com.tencent.mm.ui.contact.a.a.b {
        final /* synthetic */ h waL;

        public b(h hVar) {
            this.waL = hVar;
            super(hVar);
        }

        public final View a(Context context, ViewGroup viewGroup) {
            View inflate = LayoutInflater.from(context).inflate(R.i.dnL, viewGroup, false);
            a aVar = (a) this.waL.waK;
            aVar.oCS = (TextView) inflate.findViewById(R.h.bXD);
            inflate.setTag(aVar);
            return inflate;
        }

        public final void a(Context context, com.tencent.mm.ui.contact.a.a.a aVar, a aVar2, boolean z, boolean z2) {
            e.a(this.waL.waI, ((a) aVar).oCS);
        }

        public final boolean Od() {
            return false;
        }
    }

    public h(int i) {
        super(6, i);
    }

    public final void br(Context context) {
        this.waI = f.a(context.getString(R.l.ePC), context.getString(R.l.ePB), com.tencent.mm.plugin.fts.d.b.a.d(this.fRM, this.fRM)).mdL;
    }

    public final com.tencent.mm.ui.contact.a.a.b Ob() {
        return this.waJ;
    }

    protected final com.tencent.mm.ui.contact.a.a.a Oc() {
        return this.waK;
    }
}
