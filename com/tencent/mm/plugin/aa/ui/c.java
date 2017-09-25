package com.tencent.mm.plugin.aa.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.m;
import com.tencent.mm.u.n;
import java.util.regex.Pattern;

public final class c extends com.tencent.mm.ui.contact.a.a {
    private static final Pattern ipp = Pattern.compile(",");
    public CharSequence ipq;
    public CharSequence ipr;
    private b ips = new b(this);
    a ipt = new a(this);
    public String username;

    public class a extends com.tencent.mm.ui.contact.a.a.a {
        public View ipu;
        public ImageView ipv;
        public TextView ipw;
        public TextView ipx;
        public CheckBox ipy;
        final /* synthetic */ c ipz;

        public a(c cVar) {
            this.ipz = cVar;
            super(cVar);
        }
    }

    public class b extends com.tencent.mm.ui.contact.a.a.b {
        final /* synthetic */ c ipz;

        public b(c cVar) {
            this.ipz = cVar;
            super(cVar);
        }

        public final View a(Context context, ViewGroup viewGroup) {
            View inflate;
            if (com.tencent.mm.bg.a.dM(context)) {
                inflate = LayoutInflater.from(context).inflate(R.i.dnI, viewGroup, false);
            } else {
                inflate = LayoutInflater.from(context).inflate(R.i.dnH, viewGroup, false);
            }
            a aVar = this.ipz.ipt;
            aVar.ipv = (ImageView) inflate.findViewById(R.h.bqM);
            aVar.ipw = (TextView) inflate.findViewById(R.h.cJh);
            aVar.ipx = (TextView) inflate.findViewById(R.h.bIb);
            aVar.ipu = inflate.findViewById(R.h.cBS);
            aVar.ipy = (CheckBox) inflate.findViewById(R.h.cBH);
            LayoutParams layoutParams = (LayoutParams) aVar.ipy.getLayoutParams();
            layoutParams.leftMargin = context.getResources().getDimensionPixelSize(R.f.aYb);
            layoutParams.rightMargin = context.getResources().getDimensionPixelSize(R.f.aYc);
            aVar.ipy.setLayoutParams(layoutParams);
            inflate.setTag(aVar);
            return inflate;
        }

        public final void a(Context context, com.tencent.mm.ui.contact.a.a.a aVar, com.tencent.mm.ui.contact.a.a aVar2, boolean z, boolean z2) {
            a aVar3 = (a) aVar;
            c cVar = (c) aVar2;
            if (cVar.username == null || cVar.username.length() <= 0) {
                aVar3.ipv.setImageResource(R.g.bes);
            } else {
                com.tencent.mm.pluginsdk.ui.a.b.a(aVar3.ipv, cVar.username);
            }
            if (bg.J(cVar.ipq)) {
                aVar3.ipw.setVisibility(8);
            } else {
                aVar3.ipw.setText(cVar.ipq);
                aVar3.ipw.setVisibility(0);
            }
            if (bg.J(cVar.ipr)) {
                aVar3.ipx.setVisibility(8);
            } else {
                aVar3.ipx.setText(cVar.ipr);
                aVar3.ipx.setVisibility(0);
            }
            if (this.ipz.vYg) {
                if (z) {
                    aVar3.ipy.setChecked(true);
                    aVar3.ipy.setEnabled(false);
                } else {
                    aVar3.ipy.setChecked(z2);
                    aVar3.ipy.setEnabled(true);
                }
                aVar3.ipy.setVisibility(0);
            } else {
                aVar3.ipy.setVisibility(8);
            }
            if (this.ipz.kap) {
                aVar3.ipu.setBackgroundResource(R.g.bep);
            } else {
                aVar3.ipu.setBackgroundResource(R.g.beo);
            }
            if (cVar.jiL.field_deleteFlag == 1) {
                aVar3.ipx.setVisibility(0);
                aVar3.ipx.setText(context.getString(R.l.dCj));
            }
        }

        public final boolean Od() {
            return false;
        }
    }

    public c(int i) {
        super(2, i);
    }

    public final void br(Context context) {
        if (this.jiL == null) {
            w.i("MicroMsg.ContactDataItem", "filling dataItem Occur Error Contact is null, position=%d", new Object[]{Integer.valueOf(this.position)});
            return;
        }
        CharSequence c;
        this.username = this.jiL.field_username;
        if (bg.mA(this.fET)) {
            c = n.c(this.jiL);
        } else {
            c = n.E(this.jiL.field_username, this.fET);
        }
        if (m.xL().equals(this.username)) {
            c = c + context.getString(R.l.dBs);
        }
        this.ipq = h.c(context, c, com.tencent.mm.bg.a.T(context, R.f.aXI));
    }

    public final com.tencent.mm.ui.contact.a.a.b Ob() {
        return this.ips;
    }

    protected final com.tencent.mm.ui.contact.a.a.a Oc() {
        return this.ipt;
    }
}
