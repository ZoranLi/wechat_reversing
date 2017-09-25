package com.tencent.mm.plugin.favorite.ui.c;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.favorite.b.j;
import com.tencent.mm.plugin.favorite.b.x;
import com.tencent.mm.plugin.favorite.c.g;
import com.tencent.mm.plugin.favorite.ui.c.a.b;
import com.tencent.mm.protocal.c.rm;
import com.tencent.mm.protocal.c.rw;
import com.tencent.mm.sdk.platformtools.bg;

public final class c extends a {

    public static class a extends b {
        TextView ipw;
        TextView ipx;
        ImageView jbU;
    }

    public c(g gVar) {
        super(gVar);
    }

    public final View a(View view, ViewGroup viewGroup, j jVar) {
        b bVar;
        Context context = viewGroup.getContext();
        if (view == null) {
            b aVar = new a();
            view = a(View.inflate(context, R.i.dcp, null), aVar, jVar);
            aVar.jbU = (ImageView) view.findViewById(R.h.bOx);
            aVar.ipw = (TextView) view.findViewById(R.h.bOY);
            aVar.ipx = (TextView) view.findViewById(R.h.bOm);
            bVar = aVar;
        } else {
            a aVar2 = (a) view.getTag();
        }
        a(bVar, jVar);
        rm n = x.n(jVar);
        rw rwVar = jVar.field_favProto.tzl;
        CharSequence charSequence = jVar.field_favProto.title;
        if (bg.mA(charSequence)) {
            charSequence = n.title;
        }
        bVar.ipw.setText(charSequence);
        bVar.ipx.setText(x.U((float) n.txD));
        if (n.tyq == 2) {
            bVar.ipx.setText(">25MB");
        }
        bVar.jbU.setImageResource(com.tencent.mm.pluginsdk.model.c.LO(n.txx));
        return view;
    }

    public final void cg(View view) {
        e.b(view.getContext(), ((a) view.getTag()).lFt);
    }
}
