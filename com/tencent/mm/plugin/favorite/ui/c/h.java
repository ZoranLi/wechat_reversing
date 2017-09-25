package com.tencent.mm.plugin.favorite.ui.c;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.am.b;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.plugin.favorite.b.j;
import com.tencent.mm.plugin.favorite.b.x;
import com.tencent.mm.protocal.c.rm;
import com.tencent.mm.protocal.c.rw;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.s;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

public final class h extends a {
    private final int lMT;
    private Set<ImageView> lNe;
    private OnClickListener lNf = new OnClickListener(this) {
        final /* synthetic */ h lNg;

        {
            this.lNg = r1;
        }

        public final void onClick(View view) {
            if (!f.rZ()) {
                s.eP(this.lNg.lDs.context);
            } else if (view.getTag() instanceof j) {
                j jVar = (j) view.getTag();
                rw rwVar = jVar.field_favProto.tzl;
                rm n = x.n(jVar);
                if (n == null) {
                    w.w("MicroMsg.FavBaseListItem", "data item is null");
                } else if (e.l(n)) {
                    w.i("MicroMsg.FavBaseListItem", "same song, do release");
                    b.HH();
                    this.lNg.d(null);
                } else {
                    String absolutePath;
                    File file = new File(x.h(n));
                    if (file.exists()) {
                        absolutePath = file.getAbsolutePath();
                    } else if (n.fFs == null) {
                        absolutePath = "";
                    } else {
                        file = new File(x.aty() + g.n(n.fFs.getBytes()));
                        absolutePath = file.exists() ? file.getAbsolutePath() : "";
                    }
                    b.b(((com.tencent.mm.am.a.a) com.tencent.mm.kernel.h.h(com.tencent.mm.am.a.a.class)).a(6, null, n.title, n.desc, n.txp, n.txt, n.txr, n.lKv, x.atA(), absolutePath, "", rwVar.appId));
                    this.lNg.d((ImageView) view);
                }
            }
        }
    };

    public static class a extends a.b {
        TextView ipw;
        TextView ipx;
        MMImageView lKO;
        TextView lMU;
        ImageView lNh;
    }

    public h(com.tencent.mm.plugin.favorite.c.g gVar) {
        super(gVar);
        this.lMT = com.tencent.mm.bg.a.fromDPToPix(gVar.context, 60);
        this.lNe = new HashSet();
    }

    public final void d(ImageView imageView) {
        w.i("MicroMsg.FavBaseListItem", "mask iv set size is %d", new Object[]{Integer.valueOf(this.lNe.size())});
        for (ImageView imageView2 : this.lNe) {
            if (imageView2 == imageView) {
                imageView2.setImageResource(R.g.bho);
            } else {
                imageView2.setImageResource(R.g.bhp);
            }
        }
    }

    public final View a(View view, ViewGroup viewGroup, j jVar) {
        a.b bVar;
        Context context = viewGroup.getContext();
        if (view == null) {
            a.b aVar = new a();
            view = a(View.inflate(context, R.i.dco, null), aVar, jVar);
            aVar.lKO = (MMImageView) view.findViewById(R.h.bOx);
            aVar.ipw = (TextView) view.findViewById(R.h.bOY);
            aVar.ipx = (TextView) view.findViewById(R.h.bOj);
            aVar.lNh = (ImageView) view.findViewById(R.h.bOz);
            aVar.lMU = (TextView) view.findViewById(R.h.bOP);
            aVar.lMU.setVisibility(8);
            aVar.lNh.setOnClickListener(this.lNf);
            aVar.lNh.setVisibility(0);
            this.lNe.add(aVar.lNh);
            bVar = aVar;
        } else {
            bVar = (a) view.getTag();
        }
        a(bVar, jVar);
        rw rwVar = jVar.field_favProto.tzl;
        rm n = x.n(jVar);
        bVar.ipw.setText(n.title);
        bVar.ipx.setText(n.desc);
        this.lDs.a(bVar.lKO, n, jVar, R.k.dwM, this.lMT, this.lMT);
        bVar.lNh.setTag(jVar);
        if (e.l(n)) {
            bVar.lNh.setImageResource(R.g.bho);
        } else {
            bVar.lNh.setImageResource(R.g.bhp);
        }
        return view;
    }

    public final void cg(View view) {
        e.b(view.getContext(), ((a) view.getTag()).lFt);
    }
}
