package com.tencent.mm.plugin.search.ui.a;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fts.a.a.c;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.d.e;
import com.tencent.mm.plugin.fts.d.f;
import java.util.List;

public final class d extends com.tencent.mm.plugin.fts.d.a.a {
    public int actionType = -1;
    public i iJC;
    public List<String> iJD;
    public CharSequence lMC;
    public String lMF;
    public CharSequence pgQ;
    public String pgR;
    public c pgS;
    private b pgT = new b(this);
    a pgU = new a(this);

    public class a extends com.tencent.mm.plugin.fts.d.a.a.a {
        public View ipu;
        public ImageView ipv;
        public TextView ipw;
        public TextView ipx;
        final /* synthetic */ d pgV;

        public a(d dVar) {
            this.pgV = dVar;
            super(dVar);
        }
    }

    public class b extends com.tencent.mm.plugin.fts.d.a.a.b {
        final /* synthetic */ d pgV;

        public b(d dVar) {
            this.pgV = dVar;
            super(dVar);
        }

        public final View a(Context context, ViewGroup viewGroup) {
            View inflate = LayoutInflater.from(context).inflate(R.i.ddF, viewGroup, false);
            inflate.measure(ViewGroup.getChildMeasureSpec(MeasureSpec.makeMeasureSpec(viewGroup.getWidth(), 1073741824), viewGroup.getPaddingLeft() + viewGroup.getPaddingRight(), -1), MeasureSpec.makeMeasureSpec(-2, 1073741824));
            a aVar = this.pgV.pgU;
            aVar.ipv = (ImageView) inflate.findViewById(R.h.bqM);
            aVar.ipw = (TextView) inflate.findViewById(R.h.cJh);
            aVar.ipx = (TextView) inflate.findViewById(R.h.bIb);
            aVar.ipu = inflate.findViewById(R.h.cAN);
            inflate.setTag(aVar);
            return inflate;
        }

        public final void a(Context context, com.tencent.mm.plugin.fts.d.a.a.a aVar, com.tencent.mm.plugin.fts.d.a.a aVar2) {
            a aVar3 = (a) aVar;
            d dVar = (d) aVar2;
            ch(aVar3.ipu);
            e.a(this.pgV.lMC, aVar3.ipw);
            e.a(this.pgV.pgQ, aVar3.ipx);
            e.a(context, aVar3.ipv, null, dVar.lMF, R.k.dxn);
        }

        public final boolean a(Context context, com.tencent.mm.plugin.fts.d.a.a aVar) {
            d dVar = (d) aVar;
            a(this.pgV.fRM, dVar.iJC);
            if (!(((com.tencent.mm.plugin.appbrand.i.d) h.h(com.tencent.mm.plugin.appbrand.i.d.class)).pM(dVar.pgS.field_url) || com.tencent.mm.plugin.search.a.a.E(context, dVar.pgS.field_featureId))) {
                Intent intent = new Intent();
                intent.putExtra("rawUrl", dVar.pgS.field_updateUrl);
                com.tencent.mm.bb.d.b(context, "webview", ".ui.tools.WebViewUI", intent);
            }
            return true;
        }
    }

    public d(int i) {
        super(3, i);
    }

    public final void a(Context context, com.tencent.mm.plugin.fts.d.a.a.a aVar, Object... objArr) {
        boolean z = true;
        this.pgS = (c) this.iJC.userData;
        if (this.pgS != null) {
            boolean z2;
            this.lMC = this.pgS.field_title;
            this.pgQ = this.pgS.field_tag;
            this.lMF = this.pgS.field_iconPath;
            this.pgR = this.pgS.field_androidUrl;
            this.actionType = this.pgS.field_actionType;
            switch (this.iJC.hPr) {
                case 1:
                    z = false;
                    z2 = false;
                    break;
                case 2:
                    z2 = false;
                    break;
                case 3:
                    z2 = true;
                    break;
                case 4:
                    this.pgQ = f.b(com.tencent.mm.plugin.fts.d.b.a.a(this.pgQ, this.fRM, this.iJD)).mdL;
                    return;
                default:
                    return;
            }
            this.lMC = f.b(com.tencent.mm.plugin.fts.d.b.a.a(this.lMC, this.fRM, this.iJD, z, z2)).mdL;
        }
    }

    public final com.tencent.mm.plugin.fts.d.a.a.b Sr() {
        return this.pgT;
    }

    protected final com.tencent.mm.plugin.fts.d.a.a.a Ss() {
        return this.pgU;
    }

    public final String St() {
        return this.pgS.field_title;
    }

    public final int Su() {
        return this.iJC.maw;
    }
}
