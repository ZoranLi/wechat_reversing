package com.tencent.mm.plugin.favorite.ui.c;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.favorite.b.j;
import com.tencent.mm.plugin.favorite.c.g;
import com.tencent.mm.plugin.favorite.ui.c.a.b;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.protocal.c.rs;
import com.tencent.mm.sdk.platformtools.bg;

public final class f extends a {

    public static class a extends b {
        TextView ipw;
        TextView ipx;
        ImageView jbU;
    }

    public f(g gVar) {
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
        bVar.jbU.setImageResource(R.k.dwL);
        rs rsVar = jVar.field_favProto.tyw;
        CharSequence charSequence = jVar.field_favProto.iBi;
        if (!bg.mA(charSequence)) {
            bVar.ipw.setText(h.b(bVar.ipw.getContext(), charSequence, bVar.ipw.getTextSize()));
            if (bg.mA(rsVar.fRX)) {
                bVar.ipx.setText(rsVar.label);
            } else {
                bVar.ipx.setText(rsVar.fRX);
            }
        } else if (bg.mA(rsVar.fRX)) {
            bVar.ipw.setText(rsVar.label);
            bVar.ipx.setText(R.l.eiF);
        } else {
            bVar.ipw.setText(rsVar.fRX);
            bVar.ipx.setText(rsVar.label);
        }
        return view;
    }

    public final void cg(View view) {
        e.b(view.getContext(), ((a) view.getTag()).lFt);
    }
}
