package com.tencent.mm.plugin.fts.d.a;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.fts.d.j.d;
import com.tencent.mm.plugin.fts.d.j.e;
import com.tencent.mm.plugin.fts.d.j.f;
import com.tencent.mm.plugin.fts.d.j.g;
import com.tencent.mm.sdk.platformtools.w;

public final class c extends a {
    public String mdt;
    private b mdu;
    private a mdv;

    public class a extends com.tencent.mm.plugin.fts.d.a.a.a {
        public View ipu;
        public ImageView jbU;
        public TextView mdw;
        final /* synthetic */ c mdx;

        public a(c cVar) {
            this.mdx = cVar;
            super(cVar);
        }
    }

    public class b extends com.tencent.mm.plugin.fts.d.a.a.b {
        final /* synthetic */ c mdx;

        public b(c cVar) {
            this.mdx = cVar;
            super(cVar);
        }

        public final View a(Context context, ViewGroup viewGroup) {
            View inflate = LayoutInflater.from(context).inflate(e.ddV, viewGroup, false);
            a aVar = new a(this.mdx);
            aVar.mdw = (TextView) inflate.findViewById(d.cIJ);
            aVar.jbU = (ImageView) inflate.findViewById(d.bWx);
            aVar.ipu = inflate.findViewById(d.cAN);
            inflate.setTag(aVar);
            return inflate;
        }

        public final void a(Context context, com.tencent.mm.plugin.fts.d.a.a.a aVar, a aVar2) {
            a aVar3 = (a) aVar;
            c cVar = (c) aVar2;
            ch(aVar3.ipu);
            aVar3.mdw.setText(cVar.mdt);
            aVar3.jbU.setImageResource(f.dxo);
        }

        public final boolean a(Context context, a aVar) {
            Intent intent = new Intent();
            intent.putExtra("detail_query", this.mdx.fRM);
            intent.putExtra("detail_type", this.mdx.mde);
            intent.putExtra("Search_Scene", this.mdx.mcx);
            com.tencent.mm.bb.d.b(context, "search", ".ui.FTSDetailUI", intent);
            return true;
        }
    }

    public c(int i) {
        super(12, i);
        this.mdu = new b(this);
        this.mdv = new a(this);
        this.mdd = true;
    }

    public final void a(Context context, com.tencent.mm.plugin.fts.d.a.a.a aVar, Object... objArr) {
        if (com.tencent.mm.plugin.fts.d.e.mU(this.mde) == null) {
            this.mdt = "";
        } else {
            this.mdt = context.getResources().getString(g.mdb, new Object[]{r0});
        }
        w.i("MicroMsg.FTS.FTSMoreButtonDataItem", "fillDataItem: tip=%s", new Object[]{this.mdt});
    }

    public final com.tencent.mm.plugin.fts.d.a.a.b Sr() {
        return this.mdu;
    }

    protected final com.tencent.mm.plugin.fts.d.a.a.a Ss() {
        return this.mdv;
    }
}
