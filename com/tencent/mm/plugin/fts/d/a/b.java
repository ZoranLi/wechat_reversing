package com.tencent.mm.plugin.fts.d.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.plugin.fts.d.j.c;
import com.tencent.mm.plugin.fts.d.j.d;
import com.tencent.mm.plugin.fts.d.j.e;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public class b extends a {
    public String mdo;
    private b mdp = new b(this);
    private a mdq = new a(this);

    public class a extends com.tencent.mm.plugin.fts.d.a.a.a {
        public View ipu;
        public TextView kze;
        public View mdr;
        final /* synthetic */ b mds;

        public a(b bVar) {
            this.mds = bVar;
            super(bVar);
        }
    }

    public class b extends com.tencent.mm.plugin.fts.d.a.a.b {
        final /* synthetic */ b mds;

        public b(b bVar) {
            this.mds = bVar;
            super(bVar);
        }

        public final View a(Context context, ViewGroup viewGroup) {
            View inflate = LayoutInflater.from(context).inflate(e.ddL, viewGroup, false);
            a aVar = (a) this.mds.Ss();
            aVar.kze = (TextView) inflate.findViewById(d.bWg);
            aVar.mdr = inflate.findViewById(d.cqD);
            aVar.ipu = inflate.findViewById(d.cAN);
            inflate.setTag(aVar);
            return inflate;
        }

        public final void a(Context context, com.tencent.mm.plugin.fts.d.a.a.a aVar, a aVar2) {
            a aVar3 = (a) aVar;
            com.tencent.mm.plugin.fts.d.e.a(this.mds.mdo, aVar3.kze);
            if (this.mds.position == 0) {
                aVar3.mdr.setVisibility(8);
            } else {
                aVar3.mdr.setVisibility(0);
            }
            aVar3.ipu.setBackgroundResource(c.bgi);
        }

        public final boolean a(Context context, a aVar) {
            return false;
        }
    }

    public b(int i) {
        super(0, i);
    }

    public void a(Context context, com.tencent.mm.plugin.fts.d.a.a.a aVar, Object... objArr) {
        this.mdo = bg.ap(com.tencent.mm.plugin.fts.d.e.mU(this.mde), "");
        w.i("MicroMsg.FTS.FTSHeaderDataItem", "fillingDataItem: header=%s", new Object[]{this.mdo});
    }

    public com.tencent.mm.plugin.fts.d.a.a.b Sr() {
        return this.mdp;
    }

    public com.tencent.mm.plugin.fts.d.a.a.a Ss() {
        return this.mdq;
    }
}
