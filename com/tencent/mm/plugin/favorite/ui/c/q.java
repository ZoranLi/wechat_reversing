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

public final class q extends a {

    public static class a extends b {
        TextView ipw;
        ImageView jbU;
        TextView lNw;
    }

    public q(g gVar) {
        super(gVar);
    }

    public final View a(View view, ViewGroup viewGroup, j jVar) {
        b bVar;
        CharSequence string;
        Context context = viewGroup.getContext();
        if (view == null) {
            b aVar = new a();
            view = a(View.inflate(context, R.i.dcp, null), aVar, jVar);
            aVar.ipw = (TextView) view.findViewById(R.h.bOY);
            aVar.lNw = (TextView) view.findViewById(R.h.bOm);
            aVar.jbU = (ImageView) view.findViewById(R.h.bOx);
            bVar = aVar;
        } else {
            a aVar2 = (a) view.getTag();
        }
        a(bVar, jVar);
        bVar.ipw.setText(context.getString(R.l.dIZ));
        int aw = (int) x.aw((long) x.n(jVar).duration);
        TextView textView = bVar.lNw;
        Context context2 = this.lDs.context;
        if (aw <= 0) {
            string = context2.getString(R.l.ejN, new Object[]{Integer.valueOf(0)});
        } else {
            string = context2.getString(R.l.ejN, new Object[]{Integer.valueOf(aw)});
        }
        textView.setText(string);
        bVar.jbU.setImageResource(R.k.dwP);
        return view;
    }

    public final void cg(View view) {
        e.b(view.getContext(), ((a) view.getTag()).lFt);
    }
}
