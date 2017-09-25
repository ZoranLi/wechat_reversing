package com.tencent.mm.plugin.search.ui.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.d.e;
import com.tencent.mm.storage.x;
import java.util.List;

public abstract class b extends com.tencent.mm.plugin.fts.d.a.a {
    public i iJC;
    public List<String> iJD;
    public x jiL;
    public CharSequence kcm;
    public CharSequence kcn;
    a pgK = new a(this);
    public String username;

    public class a extends com.tencent.mm.plugin.fts.d.a.a.a {
        public View ipu;
        public ImageView ipv;
        public TextView ipw;
        public TextView ipx;
        final /* synthetic */ b pgL;

        public a(b bVar) {
            this.pgL = bVar;
            super(bVar);
        }
    }

    public abstract class b extends com.tencent.mm.plugin.fts.d.a.a.b {
        final /* synthetic */ b pgL;

        public b(b bVar) {
            this.pgL = bVar;
            super(bVar);
        }

        public final View a(Context context, ViewGroup viewGroup) {
            View inflate = LayoutInflater.from(context).inflate(R.i.ddF, viewGroup, false);
            a aVar = this.pgL.pgK;
            aVar.ipv = (ImageView) inflate.findViewById(R.h.bqM);
            aVar.ipw = (TextView) inflate.findViewById(R.h.cJh);
            aVar.ipx = (TextView) inflate.findViewById(R.h.bIb);
            aVar.ipu = inflate.findViewById(R.h.cAN);
            inflate.setTag(aVar);
            return inflate;
        }

        public final void a(Context context, com.tencent.mm.plugin.fts.d.a.a.a aVar, com.tencent.mm.plugin.fts.d.a.a aVar2) {
            a aVar3 = (a) aVar;
            b bVar = (b) aVar2;
            ch(aVar3.ipu);
            com.tencent.mm.pluginsdk.ui.a.b.a(aVar3.ipv, bVar.username);
            e.a(bVar.kcm, aVar3.ipw);
            e.a(bVar.kcn, aVar3.ipx);
        }
    }

    public b(int i) {
        super(1, i);
    }

    protected final com.tencent.mm.plugin.fts.d.a.a.a Ss() {
        return this.pgK;
    }

    public final int Su() {
        return this.iJC.maw;
    }
}
