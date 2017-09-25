package com.tencent.mm.plugin.search.ui.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fts.d.e;
import com.tencent.mm.plugin.fts.d.f;
import java.util.List;

public final class a extends com.tencent.mm.plugin.fts.d.a.a {
    public List<String> iJD;
    public CharSequence pgG;
    private b pgH = new b(this);
    private a pgI = new a(this);

    public class a extends com.tencent.mm.plugin.fts.d.a.a.a {
        public View ipu;
        public ImageView jbU;
        public TextView mdw;
        final /* synthetic */ a pgJ;

        public a(a aVar) {
            this.pgJ = aVar;
            super(aVar);
        }
    }

    public class b extends com.tencent.mm.plugin.fts.d.a.a.b {
        final /* synthetic */ a pgJ;

        public b(a aVar) {
            this.pgJ = aVar;
            super(aVar);
        }

        public final View a(Context context, ViewGroup viewGroup) {
            View inflate = LayoutInflater.from(context).inflate(R.i.ddW, viewGroup, false);
            a aVar = new a(this.pgJ);
            aVar.jbU = (ImageView) inflate.findViewById(R.h.bWx);
            aVar.mdw = (TextView) inflate.findViewById(R.h.cIJ);
            aVar.ipu = inflate.findViewById(R.h.cAN);
            inflate.setTag(aVar);
            return inflate;
        }

        public final void a(Context context, com.tencent.mm.plugin.fts.d.a.a.a aVar, com.tencent.mm.plugin.fts.d.a.a aVar2) {
            a aVar3 = (a) aVar;
            ch(aVar3.ipu);
            e.a(this.pgJ.pgG, aVar3.mdw);
            aVar3.jbU.setImageResource(R.k.dta);
        }

        public final boolean a(Context context, com.tencent.mm.plugin.fts.d.a.a aVar) {
            return false;
        }
    }

    public a(int i) {
        super(10, i);
    }

    public final void a(Context context, com.tencent.mm.plugin.fts.d.a.a.a aVar, Object... objArr) {
        this.pgG = f.a(context.getResources().getString(R.l.emZ), "", com.tencent.mm.plugin.fts.d.b.a.d(this.fRM, this.fRM)).mdL;
    }

    public final com.tencent.mm.plugin.fts.d.a.a.b Sr() {
        return this.pgH;
    }

    protected final com.tencent.mm.plugin.fts.d.a.a.a Ss() {
        return this.pgI;
    }
}
