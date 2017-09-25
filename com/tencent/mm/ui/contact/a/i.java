package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fts.d.e;

public final class i extends a {
    public int rqp;
    com.tencent.mm.ui.contact.a.a.a waK = new a(this);
    public boolean waM;
    private b waN = new b(this);

    public class a extends com.tencent.mm.ui.contact.a.a.a {
        public TextView waO;
        public ImageView waP;
        final /* synthetic */ i waQ;

        public a(i iVar) {
            this.waQ = iVar;
            super(iVar);
        }
    }

    public class b extends com.tencent.mm.ui.contact.a.a.b {
        final /* synthetic */ i waQ;

        public b(i iVar) {
            this.waQ = iVar;
            super(iVar);
        }

        public final View a(Context context, ViewGroup viewGroup) {
            View inflate = LayoutInflater.from(context).inflate(R.i.dnM, viewGroup, false);
            a aVar = (a) this.waQ.waK;
            aVar.waO = (TextView) inflate.findViewById(R.h.cln);
            aVar.waP = (ImageView) inflate.findViewById(R.h.clf);
            inflate.setTag(aVar);
            return inflate;
        }

        public final void a(Context context, com.tencent.mm.ui.contact.a.a.a aVar, a aVar2, boolean z, boolean z2) {
            a aVar3 = (a) aVar;
            i iVar = (i) aVar2;
            Resources resources = context.getResources();
            if (this.waQ.waM) {
                e.a(resources.getString(R.l.eQe, new Object[]{resources.getString(iVar.rqp)}), aVar3.waO);
                aVar3.waP.setRotation(0.0f);
                return;
            }
            e.a(resources.getString(R.l.eQf), aVar3.waO);
            aVar3.waP.setRotation(180.0f);
        }

        public final boolean Od() {
            return false;
        }
    }

    public i(int i) {
        super(1, i);
    }

    public final void br(Context context) {
    }

    public final com.tencent.mm.ui.contact.a.a.b Ob() {
        return this.waN;
    }

    protected final com.tencent.mm.ui.contact.a.a.a Oc() {
        return this.waK;
    }
}
