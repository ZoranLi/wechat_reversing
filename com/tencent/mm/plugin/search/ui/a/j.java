package com.tencent.mm.plugin.search.ui.a;

import android.content.Context;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fts.d.e;
import com.tencent.mm.plugin.fts.d.j.c;
import com.tencent.mm.plugin.fts.d.j.d;
import com.tencent.mm.u.n;

public final class j extends com.tencent.mm.plugin.fts.d.a.b {
    public int count;
    public String fJL;
    private a phq = new a(this);
    b phr = new b(this);

    public class a extends com.tencent.mm.plugin.fts.d.a.a.b {
        final /* synthetic */ j phs;

        public a(j jVar) {
            this.phs = jVar;
            super(jVar);
        }

        public final View a(Context context, ViewGroup viewGroup) {
            View inflate = LayoutInflater.from(context).inflate(R.i.ddX, viewGroup, false);
            b bVar = this.phs.phr;
            bVar.kze = (TextView) inflate.findViewById(d.bWg);
            bVar.ipu = inflate.findViewById(d.cAN);
            bVar.ipv = (ImageView) inflate.findViewById(R.h.bqM);
            inflate.setTag(bVar);
            return inflate;
        }

        public final void a(Context context, com.tencent.mm.plugin.fts.d.a.a.a aVar, com.tencent.mm.plugin.fts.d.a.a aVar2) {
            b bVar = (b) aVar;
            e.a(this.phs.mdo, bVar.kze);
            bVar.ipu.setBackgroundResource(c.bgi);
            com.tencent.mm.pluginsdk.ui.a.b.a(bVar.ipv, this.phs.fJL);
        }

        public final boolean a(Context context, com.tencent.mm.plugin.fts.d.a.a aVar) {
            return false;
        }
    }

    public class b extends com.tencent.mm.plugin.fts.d.a.a.a {
        public View ipu;
        public ImageView ipv;
        public TextView kze;
        final /* synthetic */ j phs;

        public b(j jVar) {
            this.phs = jVar;
            super(jVar);
        }
    }

    public j(int i) {
        super(i);
    }

    public final void a(Context context, com.tencent.mm.plugin.fts.d.a.a.a aVar, Object... objArr) {
        CharSequence ellipsize = TextUtils.ellipsize(n.eK(this.fJL), com.tencent.mm.plugin.fts.d.d.b.mcF, 500.0f, TruncateAt.MIDDLE);
        this.mdo = context.getString(R.l.eQi, new Object[]{ellipsize});
    }

    public final com.tencent.mm.plugin.fts.d.a.a.b Sr() {
        return this.phq;
    }

    protected final com.tencent.mm.plugin.fts.d.a.a.a Ss() {
        return this.phr;
    }
}
