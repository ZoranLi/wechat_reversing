package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.jsapi.map.m;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.fts.d.e;
import java.util.List;
import java.util.regex.Pattern;

public final class c extends a {
    private static final Pattern hPn = Pattern.compile(";");
    public i iJC;
    private List<String> iJD;
    public CharSequence ipq;
    public CharSequence ipr;
    public String[] mai;
    public String username;
    public CharSequence wao;
    private b wap = new b(this);
    a waq = new a(this);

    public class a extends com.tencent.mm.ui.contact.a.a.a {
        public View ipu;
        public ImageView ipv;
        public TextView ipw;
        public TextView ipx;
        public CheckBox ipy;
        public TextView mdw;
        final /* synthetic */ c war;

        public a(c cVar) {
            this.war = cVar;
            super(cVar);
        }
    }

    public class b extends com.tencent.mm.ui.contact.a.a.b {
        final /* synthetic */ c war;

        public b(c cVar) {
            this.war = cVar;
            super(cVar);
        }

        public final View a(Context context, ViewGroup viewGroup) {
            View inflate;
            if (com.tencent.mm.bg.a.dM(context)) {
                inflate = LayoutInflater.from(context).inflate(R.i.dnI, viewGroup, false);
            } else {
                inflate = LayoutInflater.from(context).inflate(R.i.dnH, viewGroup, false);
            }
            a aVar = this.war.waq;
            aVar.ipv = (ImageView) inflate.findViewById(R.h.bqM);
            aVar.ipw = (TextView) inflate.findViewById(R.h.cJh);
            aVar.ipw.setMaxWidth(com.tencent.mm.bg.a.fromDPToPix(context, m.CTRL_INDEX));
            aVar.ipx = (TextView) inflate.findViewById(R.h.bIb);
            aVar.mdw = (TextView) inflate.findViewById(R.h.cIJ);
            aVar.ipu = inflate.findViewById(R.h.cBS);
            aVar.ipy = (CheckBox) inflate.findViewById(R.h.cBH);
            if (this.war.kap) {
                aVar.ipu.setBackgroundResource(R.g.bep);
            }
            inflate.setTag(aVar);
            return inflate;
        }

        public final void a(Context context, com.tencent.mm.ui.contact.a.a.a aVar, a aVar2, boolean z, boolean z2) {
            a aVar3 = (a) aVar;
            c cVar = (c) aVar2;
            if (cVar.username == null || cVar.username.length() <= 0) {
                aVar3.ipv.setImageResource(R.g.bes);
            } else {
                com.tencent.mm.pluginsdk.ui.a.b.a(aVar3.ipv, cVar.username);
            }
            e.a(cVar.ipq, aVar3.ipw);
            e.a(cVar.ipr, aVar3.ipx);
            e.a(cVar.wao, aVar3.mdw);
            if (this.war.vYg) {
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

        public final boolean Od() {
            if (this.war.iJC != null) {
                ((l) h.j(l.class)).updateTopHitsRank(this.war.fRM, this.war.iJC, 1);
            }
            return false;
        }
    }

    public c(int i) {
        super(3, i);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void br(android.content.Context r13) {
        /*
        r12 = this;
        r11 = 2;
        r1 = 0;
        r6 = 1;
        r7 = 0;
        r0 = r12.iJC;
        if (r0 == 0) goto L_0x005e;
    L_0x0008:
        r0 = r12.mai;
        if (r0 == 0) goto L_0x005c;
    L_0x000c:
        r0 = r12.mai;
        r0 = r0.length;
        if (r0 <= 0) goto L_0x005c;
    L_0x0011:
        r0 = r12.mai;
        r0 = com.tencent.mm.sdk.platformtools.bg.f(r0);
        r12.iJD = r0;
        r0 = r6;
    L_0x001a:
        r2 = r12.jiL;
        if (r2 != 0) goto L_0x0044;
    L_0x001e:
        com.tencent.mm.u.ap.yY();
        r2 = com.tencent.mm.u.c.wR();
        r3 = r12.iJC;
        r3 = r3.lZO;
        r2 = r2.QX(r3);
        r12.jiL = r2;
        r2 = r12.jiL;
        if (r2 != 0) goto L_0x0044;
    L_0x0033:
        com.tencent.mm.u.ap.yY();
        r2 = com.tencent.mm.u.c.wR();
        r3 = r12.iJC;
        r3 = r3.lZO;
        r2 = r2.Rb(r3);
        r12.jiL = r2;
    L_0x0044:
        r2 = r12.jiL;
        if (r2 != 0) goto L_0x0060;
    L_0x0048:
        r0 = "MicroMsg.ChatroomDataItem";
        r1 = "filling dataItem Occur Error Contact is null, position=%d";
        r2 = new java.lang.Object[r6];
        r3 = r12.position;
        r3 = java.lang.Integer.valueOf(r3);
        r2[r7] = r3;
        com.tencent.mm.sdk.platformtools.w.i(r0, r1, r2);
    L_0x005b:
        return;
    L_0x005c:
        r0 = r7;
        goto L_0x001a;
    L_0x005e:
        r0 = r7;
        goto L_0x0044;
    L_0x0060:
        r2 = r12.jiL;
        r2 = r2.field_username;
        r12.username = r2;
        if (r0 == 0) goto L_0x0131;
    L_0x0068:
        r3 = r12.iJC;
        r0 = r12.jiL;
        r8 = r12.mai;
        r9 = r13.getResources();
        r2 = r0.field_username;
        r10 = com.tencent.mm.u.n.a(r0, r2);
        r2 = r3.hPr;
        switch(r2) {
            case 1: goto L_0x015c;
            case 2: goto L_0x00a5;
            case 3: goto L_0x00a4;
            case 5: goto L_0x015c;
            case 6: goto L_0x00a5;
            case 7: goto L_0x00a4;
            case 38: goto L_0x00ac;
            default: goto L_0x007d;
        };
    L_0x007d:
        r0 = r7;
        r6 = r7;
    L_0x007f:
        r2 = com.tencent.mm.sdk.platformtools.bg.f(r8);
        if (r6 == 0) goto L_0x0123;
    L_0x0085:
        r3 = com.tencent.mm.R.f.aXs;
        r3 = com.tencent.mm.bg.a.T(r13, r3);
        r3 = com.tencent.mm.pluginsdk.ui.d.h.c(r13, r10, r3);
        r12.ipq = r3;
        r3 = r12.ipq;
        r4 = r12.fRM;
        r0 = com.tencent.mm.plugin.fts.d.b.a.a(r3, r4, r2, r0, r7);
        r0 = com.tencent.mm.plugin.fts.d.f.b(r0);
        r0 = r0.mdL;
        r12.ipq = r0;
    L_0x00a1:
        r12.ipr = r1;
        goto L_0x005b;
    L_0x00a4:
        r7 = r6;
    L_0x00a5:
        r0 = r6;
    L_0x00a6:
        r2 = com.tencent.mm.R.l.ePI;
        r9.getString(r2);
        goto L_0x007f;
    L_0x00ac:
        r2 = "SELECT memberlist FROM chatroom WHERE chatroomname=?;";
        com.tencent.mm.u.ap.yY();
        r4 = com.tencent.mm.u.c.wO();
        r5 = new java.lang.String[r6];
        r0 = r0.field_username;
        r5[r7] = r0;
        r0 = r4.a(r2, r5, r11);
        r2 = r0.moveToFirst();
        if (r2 == 0) goto L_0x011e;
    L_0x00c6:
        r2 = r0.getString(r7);
        r0.close();
        if (r2 != 0) goto L_0x0117;
    L_0x00cf:
        r0 = r1;
    L_0x00d0:
        r2 = r0;
    L_0x00d1:
        if (r2 == 0) goto L_0x00f0;
    L_0x00d3:
        r0 = r2.length;
        if (r0 <= 0) goto L_0x00f0;
    L_0x00d6:
        r0 = new java.lang.StringBuilder;
        r4 = "(";
        r0.<init>(r4);
        r4 = r2.length;
        r0 = r0.append(r4);
        r4 = ")";
        r0 = r0.append(r4);
        r0 = r0.toString();
        r12.wao = r0;
    L_0x00f0:
        if (r2 == 0) goto L_0x007d;
    L_0x00f2:
        r0 = r3.mau;
        if (r0 == 0) goto L_0x007d;
    L_0x00f6:
        r1 = r3.mau;
        r3 = r12.iJD;
        r4 = com.tencent.mm.plugin.fts.d.d.b.mcF;
        r5 = r12.fRM;
        r0 = r13;
        r0 = com.tencent.mm.plugin.fts.d.e.a(r0, r1, r2, r3, r4, r5);
        r1 = com.tencent.mm.R.l.ePG;
        r1 = r9.getString(r1);
        r2 = new java.lang.CharSequence[r11];
        r2[r7] = r1;
        r2[r6] = r0;
        r1 = android.text.TextUtils.concat(r2);
        r0 = r7;
        r6 = r7;
        goto L_0x007f;
    L_0x0117:
        r0 = hPn;
        r0 = r0.split(r2);
        goto L_0x00d0;
    L_0x011e:
        r0.close();
        r2 = r1;
        goto L_0x00d1;
    L_0x0123:
        r0 = com.tencent.mm.R.f.aXs;
        r0 = com.tencent.mm.bg.a.T(r13, r0);
        r0 = com.tencent.mm.pluginsdk.ui.d.h.c(r13, r10, r0);
        r12.ipq = r0;
        goto L_0x00a1;
    L_0x0131:
        r0 = r12.jiL;
        r1 = r12.jiL;
        r1 = r1.field_username;
        r0 = com.tencent.mm.u.n.a(r0, r1);
        r12.ipq = r0;
        r0 = new java.lang.StringBuilder;
        r1 = "(";
        r0.<init>(r1);
        r1 = r12.iJC;
        r2 = r1.mam;
        r0 = r0.append(r2);
        r1 = ")";
        r0 = r0.append(r1);
        r0 = r0.toString();
        r12.wao = r0;
        goto L_0x005b;
    L_0x015c:
        r0 = r7;
        goto L_0x00a6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.contact.a.c.br(android.content.Context):void");
    }

    public final com.tencent.mm.ui.contact.a.a.b Ob() {
        return this.wap;
    }

    protected final com.tencent.mm.ui.contact.a.a.a Oc() {
        return this.waq;
    }

    public final boolean ayg() {
        return this.iJC.may;
    }
}
