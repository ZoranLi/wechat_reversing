package com.tencent.mm.plugin.search.ui.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.e.a.gh;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.f;
import java.util.List;

public final class e extends com.tencent.mm.plugin.fts.d.a.a {
    public i iJC;
    public List<String> iJD;
    public String iMn;
    public String lMF;
    public f mxk;
    public CharSequence pgW;
    public String pgX;
    private b pgY = new b(this);
    a pgZ = new a(this);

    public class a extends com.tencent.mm.plugin.fts.d.a.a.a {
        public View ipu;
        public ImageView ipv;
        public TextView ipw;
        public TextView ipx;
        final /* synthetic */ e pha;

        public a(e eVar) {
            this.pha = eVar;
            super(eVar);
        }
    }

    public class b extends com.tencent.mm.plugin.fts.d.a.a.b {
        final /* synthetic */ e pha;

        public b(e eVar) {
            this.pha = eVar;
            super(eVar);
        }

        public final View a(Context context, ViewGroup viewGroup) {
            View inflate = LayoutInflater.from(context).inflate(R.i.ddK, viewGroup, false);
            a aVar = this.pha.pgZ;
            aVar.ipv = (ImageView) inflate.findViewById(R.h.bqM);
            aVar.ipw = (TextView) inflate.findViewById(R.h.cJh);
            aVar.ipx = (TextView) inflate.findViewById(R.h.bIb);
            aVar.ipu = inflate.findViewById(R.h.cAN);
            inflate.setTag(aVar);
            return inflate;
        }

        public final void a(Context context, com.tencent.mm.plugin.fts.d.a.a.a aVar, com.tencent.mm.plugin.fts.d.a.a aVar2) {
            e eVar = (e) aVar2;
            a aVar3 = (a) aVar;
            aVar3.ipw.setText(this.pha.pgW);
            com.tencent.mm.plugin.fts.d.e.a(this.pha.pgX, aVar3.ipx);
            com.tencent.mm.plugin.fts.d.e.a(context, aVar3.ipv, eVar.iMn, eVar.lMF, R.k.dxn, 0, 0);
        }

        public final boolean a(Context context, com.tencent.mm.plugin.fts.d.a.a aVar) {
            e eVar = (e) aVar;
            com.tencent.mm.sdk.b.b ghVar = new gh();
            ghVar.fLB.context = context;
            ghVar.fLB.actionCode = 2;
            ghVar.fLB.appId = eVar.mxk.field_appId;
            ghVar.fLB.extMsg = "search_src=40";
            ghVar.fLB.scene = 4;
            com.tencent.mm.sdk.b.a.urY.m(ghVar);
            return true;
        }
    }

    public e(int i) {
        super(5, i);
    }

    public final void a(Context context, com.tencent.mm.plugin.fts.d.a.a.a aVar, Object... objArr) {
        this.mxk = an.aRr().Me(this.iJC.lZO);
        this.pgW = com.tencent.mm.plugin.fts.d.f.b(com.tencent.mm.plugin.fts.d.b.a.a(this.mxk.field_appName, this.fRM, this.iJD)).mdL;
        this.pgX = this.mxk.gff;
        an.aRr();
        this.lMF = com.tencent.mm.pluginsdk.model.app.i.cw(this.mxk.field_appId, 1);
        this.iMn = this.mxk.field_appIconUrl;
    }

    public final com.tencent.mm.plugin.fts.d.a.a.b Sr() {
        return this.pgY;
    }

    protected final com.tencent.mm.plugin.fts.d.a.a.a Ss() {
        return this.pgZ;
    }

    public final String St() {
        return this.mxk.field_appName;
    }

    public final int Su() {
        return this.iJC.maw;
    }
}
