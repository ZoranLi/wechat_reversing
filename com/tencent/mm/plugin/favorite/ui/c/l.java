package com.tencent.mm.plugin.favorite.ui.c;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.favorite.b.j;
import com.tencent.mm.plugin.favorite.c;
import com.tencent.mm.plugin.favorite.c.g;
import com.tencent.mm.plugin.favorite.ui.c.a.b;
import com.tencent.mm.protocal.c.rz;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.ui.MMImageView;

public final class l extends a {
    private final int lMT;
    private final String lNd = "";

    public static class a extends b {
        TextView ipw;
        TextView ipx;
        MMImageView lKO;
        TextView lMU;
    }

    public l(g gVar) {
        super(gVar);
        this.lMT = com.tencent.mm.bg.a.fromDPToPix(gVar.context, 60);
    }

    public final View a(View view, ViewGroup viewGroup, j jVar) {
        b aVar;
        Context context = viewGroup.getContext();
        if (view == null) {
            aVar = new a();
            view = a(View.inflate(context, R.i.dco, null), aVar, jVar);
            aVar.lKO = (MMImageView) view.findViewById(R.h.bOx);
            aVar.ipw = (TextView) view.findViewById(R.h.bOY);
            aVar.ipx = (TextView) view.findViewById(R.h.bOj);
            aVar.lMU = (TextView) view.findViewById(R.h.bOP);
            aVar.lMU.setVisibility(0);
        } else {
            aVar = (a) view.getTag();
        }
        a(aVar, jVar);
        rz rzVar = jVar.field_favProto.tyC;
        if (rzVar != null) {
            aVar.ipw.setText(bg.mz(rzVar.title));
            aVar.ipx.setText(bg.mz(rzVar.desc));
        } else {
            aVar.ipw.setText("");
            aVar.ipx.setText("");
        }
        aVar.lMU.setText(bg.ap(c.getAppName(context, jVar.field_favProto.tzl.appId), this.lNd));
        this.lDs.a(aVar.lKO, null, jVar, R.k.dto, this.lMT, this.lMT);
        return view;
    }

    public final void cg(View view) {
        e.b(view.getContext(), ((a) view.getTag()).lFt);
    }
}
