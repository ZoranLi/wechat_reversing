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
import com.tencent.mm.protocal.c.rm;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;

public final class b extends a {
    private final int lMT;

    public static class a extends com.tencent.mm.plugin.favorite.ui.c.a.b {
        TextView ipw;
        TextView ipx;
        ImageView jbU;
        TextView lMU;
    }

    public b(g gVar) {
        super(gVar);
        this.lMT = com.tencent.mm.bg.a.fromDPToPix(gVar.context, 60);
    }

    public final View a(View view, ViewGroup viewGroup, j jVar) {
        com.tencent.mm.plugin.favorite.ui.c.a.b bVar;
        Context context = viewGroup.getContext();
        if (view == null) {
            com.tencent.mm.plugin.favorite.ui.c.a.b aVar = new a();
            view = a(View.inflate(context, R.i.dco, null), aVar, jVar);
            aVar.jbU = (ImageView) view.findViewById(R.h.bOx);
            aVar.ipw = (TextView) view.findViewById(R.h.bOY);
            aVar.ipw.setSingleLine(false);
            aVar.ipw.setMaxLines(2);
            aVar.ipx = (TextView) view.findViewById(R.h.bOj);
            aVar.lMU = (TextView) view.findViewById(R.h.bOP);
            bVar = aVar;
        } else {
            a aVar2 = (a) view.getTag();
        }
        a(bVar, jVar);
        rm n = x.n(jVar);
        ap.yY();
        com.tencent.mm.storage.au.a Av = c.wT().Av(n.desc);
        if (Av.rUK == null || Av.rUK.length() <= 0) {
            w.e("MicroMsg.FavCardListItem", "parse possible friend msg failed");
        }
        if (bg.mA(a(Av))) {
            bVar.ipx.setVisibility(8);
        } else {
            bVar.ipx.setText(a(Av));
        }
        bVar.lMU.setText(R.l.eiu);
        bVar.lMU.setVisibility(0);
        ImageView imageView = bVar.jbU;
        String str = Av.rUK;
        if (bg.mA(str)) {
            imageView.setImageResource(R.g.bes);
        } else {
            com.tencent.mm.pluginsdk.ui.a.b.a(imageView, str);
        }
        return view;
    }

    public final void cg(View view) {
        e.b(view.getContext(), ((a) view.getTag()).lFt);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String a(com.tencent.mm.storage.au.a r4) {
        /*
        r1 = 1;
        r0 = 0;
        r2 = r4.gtR;
        r3 = com.tencent.mm.sdk.platformtools.bg.mA(r2);
        if (r3 == 0) goto L_0x0019;
    L_0x000a:
        r2 = r4.rUK;
        r3 = com.tencent.mm.storage.x.QQ(r2);
        if (r3 != 0) goto L_0x0018;
    L_0x0012:
        r3 = com.tencent.mm.u.o.eT(r2);
        if (r3 == 0) goto L_0x0019;
    L_0x0018:
        r0 = r1;
    L_0x0019:
        if (r0 != 0) goto L_0x0038;
    L_0x001b:
        com.tencent.mm.u.ap.yY();
        r3 = com.tencent.mm.u.c.wR();
        r3 = r3.QY(r2);
        if (r3 != 0) goto L_0x0038;
    L_0x0028:
        r0 = r4.rWg;
        r0 = com.tencent.mm.u.o.eW(r0);
        if (r1 != 0) goto L_0x0032;
    L_0x0030:
        if (r0 == 0) goto L_0x0036;
    L_0x0032:
        r0 = "";
    L_0x0035:
        return r0;
    L_0x0036:
        r0 = r2;
        goto L_0x0035;
    L_0x0038:
        r1 = r0;
        goto L_0x0028;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.favorite.ui.c.b.a(com.tencent.mm.storage.au$a):java.lang.String");
    }
}
