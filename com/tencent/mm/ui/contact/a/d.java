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
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.fts.d.e;
import java.util.regex.Pattern;

public class d extends a {
    private static final Pattern ipp = Pattern.compile(",");
    public i iJC;
    public CharSequence ipq;
    public CharSequence ipr;
    public String[] mai;
    public String username;
    private b was = new b(this);
    private a wat = new a(this);

    public class a extends com.tencent.mm.ui.contact.a.a.a {
        public View ipu;
        public ImageView ipv;
        public TextView ipw;
        public TextView ipx;
        public CheckBox ipy;
        public CheckBox wau;
        final /* synthetic */ d wav;

        public a(d dVar) {
            this.wav = dVar;
            super(dVar);
        }
    }

    public class b extends com.tencent.mm.ui.contact.a.a.b {
        final /* synthetic */ d wav;

        public b(d dVar) {
            this.wav = dVar;
            super(dVar);
        }

        public View a(Context context, ViewGroup viewGroup) {
            View inflate;
            if (com.tencent.mm.bg.a.dM(context)) {
                inflate = LayoutInflater.from(context).inflate(R.i.dnI, viewGroup, false);
            } else {
                inflate = LayoutInflater.from(context).inflate(R.i.dnH, viewGroup, false);
            }
            a aVar = (a) this.wav.Oc();
            aVar.ipv = (ImageView) inflate.findViewById(R.h.bqM);
            aVar.ipw = (TextView) inflate.findViewById(R.h.cJh);
            aVar.ipx = (TextView) inflate.findViewById(R.h.bIb);
            aVar.ipu = inflate.findViewById(R.h.cBS);
            aVar.ipy = (CheckBox) inflate.findViewById(R.h.cBH);
            aVar.wau = (CheckBox) inflate.findViewById(R.h.cCj);
            inflate.setTag(aVar);
            return inflate;
        }

        public void a(Context context, com.tencent.mm.ui.contact.a.a.a aVar, a aVar2, boolean z, boolean z2) {
            a aVar3 = (a) aVar;
            d dVar = (d) aVar2;
            if (dVar.username == null || dVar.username.length() <= 0) {
                aVar3.ipv.setImageResource(R.g.bes);
            } else {
                com.tencent.mm.pluginsdk.ui.a.b.a(aVar3.ipv, dVar.username);
            }
            e.a(dVar.ipq, aVar3.ipw);
            e.a(dVar.ipr, aVar3.ipx);
            if (this.wav.vYg) {
                aVar3.ipy.setBackgroundResource(R.g.bgV);
                if (z) {
                    aVar3.ipy.setChecked(true);
                    aVar3.ipy.setEnabled(false);
                } else {
                    aVar3.ipy.setChecked(z2);
                    aVar3.ipy.setEnabled(true);
                }
                aVar3.ipy.setVisibility(0);
            } else if (this.wav.vYh) {
                aVar3.ipy.setVisibility(8);
                aVar3.wau.setChecked(z2);
                aVar3.wau.setEnabled(true);
                aVar3.wau.setVisibility(0);
            } else {
                aVar3.ipy.setVisibility(8);
            }
            if (this.wav.kap) {
                aVar3.ipu.setBackgroundResource(R.g.bep);
            } else {
                aVar3.ipu.setBackgroundResource(R.g.beo);
            }
            if (dVar.jiL.field_deleteFlag == 1) {
                aVar3.ipx.setVisibility(0);
                aVar3.ipx.setText(context.getString(R.l.dCj));
            }
        }

        public final boolean Od() {
            if (this.wav.iJC != null) {
                ((l) h.j(l.class)).updateTopHitsRank(this.wav.fRM, this.wav.iJC, 1);
            }
            return false;
        }
    }

    public d(int i) {
        super(2, i);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void br(android.content.Context r12) {
        /*
        r11 = this;
        r4 = 0;
        r2 = 0;
        r1 = 1;
        r0 = r11.iJC;
        if (r0 == 0) goto L_0x0055;
    L_0x0007:
        r0 = r11.mai;
        if (r0 == 0) goto L_0x0053;
    L_0x000b:
        r0 = r11.mai;
        r0 = r0.length;
        if (r0 <= 0) goto L_0x0053;
    L_0x0010:
        r0 = r1;
    L_0x0011:
        r3 = r11.jiL;
        if (r3 != 0) goto L_0x003b;
    L_0x0015:
        com.tencent.mm.u.ap.yY();
        r3 = com.tencent.mm.u.c.wR();
        r5 = r11.iJC;
        r5 = r5.lZO;
        r3 = r3.QX(r5);
        r11.jiL = r3;
        r3 = r11.jiL;
        if (r3 != 0) goto L_0x003b;
    L_0x002a:
        com.tencent.mm.u.ap.yY();
        r3 = com.tencent.mm.u.c.wR();
        r5 = r11.iJC;
        r5 = r5.lZO;
        r3 = r3.Rb(r5);
        r11.jiL = r3;
    L_0x003b:
        r3 = r11.jiL;
        if (r3 != 0) goto L_0x0057;
    L_0x003f:
        r0 = "MicroMsg.ContactDataItem";
        r3 = "filling dataItem Occur Error Contact is null, position=%d";
        r1 = new java.lang.Object[r1];
        r4 = r11.position;
        r4 = java.lang.Integer.valueOf(r4);
        r1[r2] = r4;
        com.tencent.mm.sdk.platformtools.w.i(r0, r3, r1);
    L_0x0052:
        return;
    L_0x0053:
        r0 = r2;
        goto L_0x0011;
    L_0x0055:
        r0 = r2;
        goto L_0x003b;
    L_0x0057:
        r3 = r11.jiL;
        r3 = r3.field_username;
        r11.username = r3;
        if (r0 == 0) goto L_0x019d;
    L_0x005f:
        r0 = r11.iJC;
        r5 = r11.jiL;
        r9 = r11.mai;
        r7 = r12.getResources();
        if (r5 == 0) goto L_0x01d4;
    L_0x006b:
        r3 = r5.field_username;
        r6 = com.tencent.mm.u.n.a(r5, r3);
        r3 = r0.hPr;
        switch(r3) {
            case 1: goto L_0x01c9;
            case 2: goto L_0x01c6;
            case 3: goto L_0x00ea;
            case 4: goto L_0x0103;
            case 5: goto L_0x01d0;
            case 6: goto L_0x01cd;
            case 7: goto L_0x00f2;
            case 8: goto L_0x0076;
            case 9: goto L_0x0076;
            case 10: goto L_0x0076;
            case 11: goto L_0x0170;
            case 12: goto L_0x0076;
            case 13: goto L_0x0076;
            case 14: goto L_0x0076;
            case 15: goto L_0x0114;
            case 16: goto L_0x012f;
            case 17: goto L_0x015f;
            case 18: goto L_0x015f;
            default: goto L_0x0076;
        };
    L_0x0076:
        r0 = r2;
        r3 = r2;
        r5 = r2;
        r7 = r4;
        r8 = r6;
        r6 = r4;
        r4 = r2;
    L_0x007d:
        r9 = com.tencent.mm.sdk.platformtools.bg.f(r9);
        if (r5 == 0) goto L_0x0181;
    L_0x0083:
        r5 = "MicroMsg.ContactDataItem";
        r10 = "highlight first line";
        com.tencent.mm.sdk.platformtools.w.d(r5, r10);
        r5 = com.tencent.mm.R.f.aXI;
        r5 = com.tencent.mm.bg.a.T(r12, r5);
        r5 = com.tencent.mm.pluginsdk.ui.d.h.c(r12, r8, r5);
        r11.ipq = r5;
        r5 = r11.ipq;
        r8 = r11.fRM;
        r5 = com.tencent.mm.plugin.fts.d.b.a.a(r5, r8, r9, r3, r0);
        r5 = com.tencent.mm.plugin.fts.d.f.b(r5);
        r5 = r5.mdL;
        r11.ipq = r5;
    L_0x00a8:
        if (r4 == 0) goto L_0x018f;
    L_0x00aa:
        r4 = "MicroMsg.ContactDataItem";
        r5 = "highlight second line";
        com.tencent.mm.sdk.platformtools.w.d(r4, r5);
        r4 = com.tencent.mm.R.f.aXs;
        r4 = com.tencent.mm.bg.a.T(r12, r4);
        r4 = com.tencent.mm.pluginsdk.ui.d.h.c(r12, r6, r4);
        r11.ipr = r4;
        r4 = r11.ipr;
        r5 = r11.fRM;
        r0 = com.tencent.mm.plugin.fts.d.b.a.a(r4, r5, r9, r3, r0);
        r0 = com.tencent.mm.plugin.fts.d.f.b(r0);
        r0 = r0.mdL;
        r11.ipr = r0;
    L_0x00cf:
        r0 = com.tencent.mm.sdk.platformtools.bg.mA(r7);
        if (r0 != 0) goto L_0x0052;
    L_0x00d5:
        r0 = r11.ipr;
        if (r0 == 0) goto L_0x0052;
    L_0x00d9:
        r0 = 2;
        r0 = new java.lang.CharSequence[r0];
        r0[r2] = r7;
        r2 = r11.ipr;
        r0[r1] = r2;
        r0 = android.text.TextUtils.concat(r0);
        r11.ipr = r0;
        goto L_0x0052;
    L_0x00ea:
        r0 = r1;
    L_0x00eb:
        r3 = r1;
    L_0x00ec:
        r5 = r1;
        r7 = r4;
        r8 = r6;
        r6 = r4;
        r4 = r2;
        goto L_0x007d;
    L_0x00f2:
        r0 = r1;
    L_0x00f3:
        r3 = r1;
    L_0x00f4:
        r4 = r5.field_nickname;
        r5 = com.tencent.mm.R.l.ePI;
        r5 = r7.getString(r5);
        r7 = r5;
        r8 = r6;
        r6 = r4;
        r5 = r2;
        r4 = r1;
        goto L_0x007d;
    L_0x0103:
        r0 = r5.gkK;
        r3 = com.tencent.mm.R.l.ePE;
        r4 = r7.getString(r3);
        r3 = r2;
        r5 = r2;
        r7 = r4;
        r8 = r6;
        r6 = r0;
        r4 = r1;
        r0 = r2;
        goto L_0x007d;
    L_0x0114:
        r0 = r5.pA();
        r3 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
        if (r3 == 0) goto L_0x0120;
    L_0x011e:
        r0 = r5.field_username;
    L_0x0120:
        r3 = com.tencent.mm.R.l.ePM;
        r4 = r7.getString(r3);
        r3 = r2;
        r5 = r2;
        r7 = r4;
        r8 = r6;
        r6 = r0;
        r4 = r1;
        r0 = r2;
        goto L_0x007d;
    L_0x012f:
        r3 = r0.content;
        r0 = com.tencent.mm.sdk.platformtools.bg.mA(r3);
        if (r0 != 0) goto L_0x01c4;
    L_0x0137:
        r0 = "​";
        r5 = r3.split(r0);
        r8 = r5.length;
        r4 = r2;
    L_0x0140:
        if (r4 >= r8) goto L_0x01c4;
    L_0x0142:
        r0 = r5[r4];
        r10 = r11.fRM;
        r10 = r0.startsWith(r10);
        if (r10 == 0) goto L_0x015b;
    L_0x014c:
        r3 = com.tencent.mm.R.l.ePH;
        r4 = r7.getString(r3);
        r3 = r2;
        r5 = r2;
        r7 = r4;
        r8 = r6;
        r6 = r0;
        r4 = r1;
        r0 = r2;
        goto L_0x007d;
    L_0x015b:
        r0 = r4 + 1;
        r4 = r0;
        goto L_0x0140;
    L_0x015f:
        r0 = r0.content;
        r3 = com.tencent.mm.R.l.ePF;
        r4 = r7.getString(r3);
        r3 = r2;
        r5 = r2;
        r7 = r4;
        r8 = r6;
        r6 = r0;
        r4 = r1;
        r0 = r2;
        goto L_0x007d;
    L_0x0170:
        r0 = r0.mar;
        r3 = com.tencent.mm.R.l.ePL;
        r4 = r7.getString(r3);
        r3 = r2;
        r5 = r2;
        r7 = r4;
        r8 = r6;
        r6 = r0;
        r4 = r1;
        r0 = r2;
        goto L_0x007d;
    L_0x0181:
        r5 = com.tencent.mm.R.f.aXI;
        r5 = com.tencent.mm.bg.a.T(r12, r5);
        r5 = com.tencent.mm.pluginsdk.ui.d.h.c(r12, r8, r5);
        r11.ipq = r5;
        goto L_0x00a8;
    L_0x018f:
        r0 = com.tencent.mm.R.f.aXs;
        r0 = com.tencent.mm.bg.a.T(r12, r0);
        r0 = com.tencent.mm.pluginsdk.ui.d.h.c(r12, r6, r0);
        r11.ipr = r0;
        goto L_0x00cf;
    L_0x019d:
        r0 = r11.fET;
        r0 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
        if (r0 == 0) goto L_0x01b9;
    L_0x01a5:
        r0 = r11.jiL;
        r0 = com.tencent.mm.u.n.c(r0);
    L_0x01ab:
        r1 = com.tencent.mm.R.f.aXI;
        r1 = com.tencent.mm.bg.a.T(r12, r1);
        r0 = com.tencent.mm.pluginsdk.ui.d.h.c(r12, r0, r1);
        r11.ipq = r0;
        goto L_0x0052;
    L_0x01b9:
        r0 = r11.jiL;
        r0 = r0.field_username;
        r1 = r11.fET;
        r0 = com.tencent.mm.u.n.E(r0, r1);
        goto L_0x01ab;
    L_0x01c4:
        r0 = r3;
        goto L_0x014c;
    L_0x01c6:
        r0 = r2;
        goto L_0x00eb;
    L_0x01c9:
        r0 = r2;
        r3 = r2;
        goto L_0x00ec;
    L_0x01cd:
        r0 = r2;
        goto L_0x00f3;
    L_0x01d0:
        r0 = r2;
        r3 = r2;
        goto L_0x00f4;
    L_0x01d4:
        r0 = r2;
        r3 = r2;
        r5 = r2;
        r6 = r4;
        r7 = r4;
        r8 = r4;
        r4 = r2;
        goto L_0x007d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.contact.a.d.br(android.content.Context):void");
    }

    public com.tencent.mm.ui.contact.a.a.b Ob() {
        return this.was;
    }

    public com.tencent.mm.ui.contact.a.a.a Oc() {
        return this.wat;
    }
}
