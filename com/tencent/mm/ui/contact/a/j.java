package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mm.R;

public final class j extends a {
    private a waR = new a(this);
    b waS = new b(this);

    public class a extends com.tencent.mm.ui.contact.a.a.b {
        final /* synthetic */ j waT;

        public a(j jVar) {
            this.waT = jVar;
            super(jVar);
        }

        public final View a(Context context, ViewGroup viewGroup) {
            View inflate = LayoutInflater.from(context).inflate(R.i.dnN, viewGroup, false);
            b bVar = this.waT.waS;
            bVar.ipw = (TextView) inflate.findViewById(R.h.cJh);
            bVar.ipu = inflate.findViewById(R.h.cBS);
            bVar.ipy = (CheckBox) inflate.findViewById(R.h.cBH);
            inflate.setTag(bVar);
            return inflate;
        }

        public final void a(Context context, com.tencent.mm.ui.contact.a.a.a aVar, a aVar2, boolean z, boolean z2) {
            b bVar = (b) aVar;
            bVar.ipw.setText(R.l.eQn);
            bVar.ipy.setBackgroundResource(R.g.bgW);
            bVar.ipy.setChecked(z2);
            bVar.ipy.setEnabled(true);
            bVar.ipy.setVisibility(0);
            bVar.ipu.setBackgroundResource(R.g.bep);
        }

        public final boolean Od() {
            return false;
        }
    }

    public class b extends com.tencent.mm.ui.contact.a.a.a {
        public View ipu;
        public TextView ipw;
        public CheckBox ipy;
        final /* synthetic */ j waT;

        public b(j jVar) {
            this.waT = jVar;
            super(jVar);
        }
    }

    public j(int i) {
        super(7, i);
    }

    public final void br(Context context) {
    }

    public final com.tencent.mm.ui.contact.a.a.b Ob() {
        return this.waR;
    }

    protected final com.tencent.mm.ui.contact.a.a.a Oc() {
        return this.waS;
    }
}
