package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.u.n;

public class e extends a {
    public CharSequence ipq;
    public String username;
    public CharSequence waw;
    public int wax = 0;
    private b way = new b(this);
    a waz = new a(this);

    public class a extends com.tencent.mm.ui.contact.a.a.a {
        public ImageView ipv;
        public TextView ipx;
        public CheckBox ipy;
        public TextView jWd;
        final /* synthetic */ e waA;

        public a(e eVar) {
            this.waA = eVar;
            super(eVar);
        }
    }

    public class b extends com.tencent.mm.ui.contact.a.a.b {
        final /* synthetic */ e waA;

        public b(e eVar) {
            this.waA = eVar;
            super(eVar);
        }

        public final View a(Context context, ViewGroup viewGroup) {
            View inflate;
            if (com.tencent.mm.bg.a.dM(context)) {
                inflate = LayoutInflater.from(context).inflate(R.i.dnI, viewGroup, false);
            } else {
                inflate = LayoutInflater.from(context).inflate(R.i.dnH, viewGroup, false);
            }
            a aVar = this.waA.waz;
            aVar.ipv = (ImageView) inflate.findViewById(R.h.bqM);
            aVar.jWd = (TextView) inflate.findViewById(R.h.cJh);
            aVar.ipx = (TextView) inflate.findViewById(R.h.bIb);
            aVar.ipx.setVisibility(8);
            aVar.ipy = (CheckBox) inflate.findViewById(R.h.cBH);
            inflate.setTag(aVar);
            return inflate;
        }

        public final void a(Context context, com.tencent.mm.ui.contact.a.a.a aVar, a aVar2, boolean z, boolean z2) {
            e eVar = (e) aVar2;
            a aVar3 = (a) aVar;
            if (this.waA.wax == 0 || this.waA.waw == null) {
                com.tencent.mm.plugin.fts.d.e.a(eVar.ipq, aVar3.jWd);
                com.tencent.mm.pluginsdk.ui.a.b.a(aVar3.ipv, eVar.username);
                if (this.waA.vYg) {
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
                return;
            }
            aVar3.ipv.setImageResource(this.waA.wax);
            aVar3.jWd.setText(this.waA.waw);
        }

        public final boolean Od() {
            return false;
        }
    }

    public e(int i) {
        super(4, i);
    }

    public void br(Context context) {
        if (this.wax != 0 && this.waw != null) {
            return;
        }
        if (this.jiL == null) {
            this.ipq = "";
            this.username = "";
            return;
        }
        this.ipq = h.c(context, n.c(this.jiL), com.tencent.mm.bg.a.T(context, R.f.aXI));
        this.username = this.jiL.field_username;
    }

    public final com.tencent.mm.ui.contact.a.a.b Ob() {
        return this.way;
    }

    protected final com.tencent.mm.ui.contact.a.a.a Oc() {
        return this.waz;
    }
}
