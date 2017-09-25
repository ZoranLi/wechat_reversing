package com.tencent.mm.plugin.favorite.ui.c;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.cs;
import com.tencent.mm.plugin.favorite.b.j;
import com.tencent.mm.plugin.favorite.b.x;
import com.tencent.mm.plugin.favorite.c.g;
import com.tencent.mm.plugin.favorite.ui.c.a.b;

public final class d extends a {
    private static int lMV;
    private static int lMW;

    public static class a extends b {
        ImageView lMX;
        TextView lMY;
    }

    public d(g gVar) {
        super(gVar);
        lMW = com.tencent.mm.bg.a.fromDPToPix(gVar.context, 138);
        lMV = com.tencent.mm.bg.a.fromDPToPix(gVar.context, cs.CTRL_INDEX);
    }

    public final View a(View view, ViewGroup viewGroup, j jVar) {
        b bVar;
        Context context = viewGroup.getContext();
        if (view == null) {
            b aVar = new a();
            view = a(View.inflate(context, R.i.dcq, null), aVar, jVar);
            aVar.lMX = (ImageView) view.findViewById(R.h.bOC);
            aVar.lMY = (TextView) view.findViewById(R.h.bOK);
            aVar.lMY.setVisibility(8);
            bVar = aVar;
        } else {
            a aVar2 = (a) view.getTag();
        }
        a(bVar, jVar);
        g.a(bVar.lMX, R.k.dwW, x.n(jVar), jVar, false, lMV, lMW);
        return view;
    }

    public final void cg(View view) {
        e.b(view.getContext(), ((a) view.getTag()).lFt);
    }
}
