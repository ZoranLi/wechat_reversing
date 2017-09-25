package com.tencent.mm.plugin.multitalk.ui.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fts.d.e;
import com.tencent.mm.ui.contact.a.d;
import com.tencent.mm.ui.contact.a.d.b;

public final class a extends d {
    private a nQU = new a(this);

    public class a extends b {
        final /* synthetic */ a nQV;

        public a(a aVar) {
            this.nQV = aVar;
            super(aVar);
        }

        public final View a(Context context, ViewGroup viewGroup) {
            View inflate = LayoutInflater.from(context).inflate(R.i.djH, viewGroup, false);
            com.tencent.mm.ui.contact.a.d.a aVar = (com.tencent.mm.ui.contact.a.d.a) this.nQV.Oc();
            aVar.ipv = (ImageView) inflate.findViewById(R.h.bqM);
            aVar.ipw = (TextView) inflate.findViewById(R.h.cJh);
            aVar.ipx = (TextView) inflate.findViewById(R.h.bIb);
            aVar.ipu = inflate.findViewById(R.h.cBS);
            aVar.ipy = (CheckBox) inflate.findViewById(R.h.cBH);
            inflate.setTag(aVar);
            return inflate;
        }

        public final void a(Context context, com.tencent.mm.ui.contact.a.a.a aVar, com.tencent.mm.ui.contact.a.a aVar2, boolean z, boolean z2) {
            com.tencent.mm.ui.contact.a.d.a aVar3 = (com.tencent.mm.ui.contact.a.d.a) aVar;
            d dVar = (d) aVar2;
            if (dVar.username == null || dVar.username.length() <= 0) {
                aVar3.ipv.setImageResource(R.g.bes);
            } else {
                com.tencent.mm.pluginsdk.ui.a.b.a(aVar3.ipv, dVar.username);
            }
            e.a(dVar.ipq, aVar3.ipw);
            if (this.nQV.vYg) {
                if (z) {
                    aVar3.ipy.setChecked(true);
                    aVar3.ipy.setEnabled(false);
                } else {
                    aVar3.ipy.setChecked(z2);
                    aVar3.ipy.setEnabled(true);
                }
                aVar3.ipy.setVisibility(0);
                return;
            }
            aVar3.ipy.setVisibility(8);
        }
    }

    public a(int i) {
        super(i);
    }

    public final com.tencent.mm.ui.contact.a.a.b Ob() {
        return this.nQU;
    }
}
