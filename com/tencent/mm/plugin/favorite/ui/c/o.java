package com.tencent.mm.plugin.favorite.ui.c;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.e.b.af;
import com.tencent.mm.plugin.favorite.b.j;
import com.tencent.mm.plugin.favorite.b.x;
import com.tencent.mm.plugin.favorite.c;
import com.tencent.mm.plugin.favorite.c.g;
import com.tencent.mm.plugin.favorite.ui.c.a.b;
import com.tencent.mm.protocal.c.rm;
import com.tencent.mm.protocal.c.rw;
import com.tencent.mm.protocal.c.sf;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.u.ap;

public final class o extends a {
    private final int lMT;

    public static class a extends b {
        TextView ipw;
        TextView ipx;
        ImageView jbU;
        TextView lMU;
    }

    public o(g gVar) {
        super(gVar);
        this.lMT = com.tencent.mm.bg.a.fromDPToPix(gVar.context, 60);
    }

    public final View a(View view, ViewGroup viewGroup, j jVar) {
        b aVar;
        Context context = viewGroup.getContext();
        if (view == null) {
            aVar = new a();
            view = a(View.inflate(context, R.i.dco, null), aVar, jVar);
            aVar.jbU = (ImageView) view.findViewById(R.h.bOx);
            aVar.ipw = (TextView) view.findViewById(R.h.bOY);
            aVar.ipw.setSingleLine(false);
            aVar.ipw.setMaxLines(2);
            aVar.ipx = (TextView) view.findViewById(R.h.bOj);
            aVar.lMU = (TextView) view.findViewById(R.h.bOP);
        } else {
            aVar = (a) view.getTag();
        }
        a(aVar, jVar);
        rm n = x.n(jVar);
        sf sfVar = jVar.field_favProto.tyy;
        rw rwVar = jVar.field_favProto.tzl;
        TextView textView = aVar.ipw;
        rm n2 = x.n(jVar);
        CharSequence charSequence = "";
        if (sfVar != null) {
            charSequence = sfVar.title;
        }
        if (bg.mA(charSequence) && n2 != null) {
            charSequence = n2.title;
        }
        if (bg.mA(charSequence)) {
            textView.setVisibility(8);
        } else {
            textView.setText(charSequence);
            textView.setVisibility(0);
        }
        TextView textView2 = aVar.ipx;
        rm n3 = x.n(jVar);
        textView2.setVisibility(8);
        if (!(n3 == null || bg.mA(n3.canvasPageXml))) {
            textView2.setVisibility(0);
            CharSequence charSequence2 = n3.desc;
            if (bg.mA(charSequence2)) {
                textView2.setVisibility(8);
            } else {
                textView2.setText(charSequence2);
                textView2.setVisibility(0);
            }
        }
        textView = aVar.lMU;
        n2 = x.n(jVar);
        charSequence = "";
        if (sfVar != null) {
            charSequence = bg.PV(sfVar.tzN);
        }
        if (rwVar != null) {
            if (!bg.mA(rwVar.appId)) {
                charSequence = bg.ap(c.getAppName(textView.getContext(), rwVar.appId), "");
            } else if (!bg.mA(rwVar.fCJ)) {
                ap.yY();
                af Rc = com.tencent.mm.u.c.wR().Rc(rwVar.fCJ);
                if (Rc == null || !Rc.field_username.equals(rwVar.fCJ)) {
                    com.tencent.mm.u.ag.a.hlS.a(rwVar.fCJ, "", null);
                } else {
                    charSequence = Rc.tL();
                }
            }
            if (bg.mA(charSequence) || charSequence.equals(rwVar.fCJ)) {
                charSequence = bg.PV(rwVar.hSX);
            }
        }
        if (bg.mA(charSequence) || !(n2 == null || bg.mA(n2.canvasPageXml))) {
            textView.setVisibility(8);
        } else {
            textView.setText(charSequence);
            textView.setVisibility(0);
        }
        int LC = com.tencent.mm.pluginsdk.c.LC(n.txx);
        g gVar = this.lDs;
        ImageView imageView = aVar.jbU;
        if (LC == com.tencent.mm.pluginsdk.c.bCm()) {
            LC = R.k.dtu;
        }
        gVar.a(imageView, n, jVar, LC, this.lMT, this.lMT);
        return view;
    }

    public final void cg(View view) {
        e.b(view.getContext(), ((a) view.getTag()).lFt);
    }
}
