package com.tencent.mm.plugin.favorite.ui.c;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.cs;
import com.tencent.mm.plugin.favorite.b.j;
import com.tencent.mm.plugin.favorite.b.u;
import com.tencent.mm.plugin.favorite.b.x;
import com.tencent.mm.plugin.favorite.c.g;
import com.tencent.mm.plugin.favorite.ui.c.a.b;
import com.tencent.mm.protocal.c.rm;
import com.tencent.mm.ui.MMImageView;
import java.util.LinkedList;

public final class p extends a {
    final int lMV;
    final int lMW;

    public static class a extends b {
        MMImageView lNu;
        TextView lNv;
    }

    public p(g gVar) {
        super(gVar);
        this.lMW = com.tencent.mm.bg.a.fromDPToPix(gVar.context, 138);
        this.lMV = com.tencent.mm.bg.a.fromDPToPix(gVar.context, cs.CTRL_INDEX);
    }

    public final View a(View view, ViewGroup viewGroup, j jVar) {
        b aVar;
        Context context = viewGroup.getContext();
        if (view == null) {
            aVar = new a();
            view = a(View.inflate(context, R.i.dcs, null), aVar, jVar);
            aVar.lNu = (MMImageView) view.findViewById(R.h.bOC);
            aVar.lNv = (TextView) view.findViewById(R.h.bPd);
        } else {
            aVar = (a) view.getTag();
        }
        view.findViewById(R.h.bOO).setVisibility(8);
        aVar.lNv.setVisibility(0);
        LinkedList linkedList = jVar.field_favProto.tzn;
        if (linkedList.size() > 0) {
            aVar.lNv.setText(u.s(context, ((rm) linkedList.getFirst()).duration));
        } else {
            aVar.lNv.setText("");
        }
        a(aVar, jVar);
        this.lDs.a(aVar.lNu, x.n(jVar), jVar, R.k.dwS, this.lMV, this.lMW);
        return view;
    }

    public final void cg(View view) {
        e.b(view.getContext(), ((a) view.getTag()).lFt);
    }
}
