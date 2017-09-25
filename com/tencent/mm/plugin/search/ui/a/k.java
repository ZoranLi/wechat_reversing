package com.tencent.mm.plugin.search.ui.a;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.map.m;
import com.tencent.mm.plugin.fts.a.a.d;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.d.e;
import com.tencent.mm.storage.x;
import java.util.List;

public final class k extends com.tencent.mm.plugin.fts.d.a.a {
    public i iJC;
    public List<String> iJD;
    public x jiL;
    public CharSequence kcm;
    public CharSequence kcn;
    public CharSequence pht;
    private b phu = new b(this);
    a phv = new a(this);
    public String username;

    public class a extends com.tencent.mm.plugin.fts.d.a.a.a {
        public View ipu;
        public ImageView ipv;
        public TextView ipw;
        public TextView ipx;
        final /* synthetic */ k phw;

        public a(k kVar) {
            this.phw = kVar;
            super(kVar);
        }
    }

    public class b extends com.tencent.mm.plugin.fts.d.a.a.b {
        final /* synthetic */ k phw;

        public b(k kVar) {
            this.phw = kVar;
            super(kVar);
        }

        public final View a(Context context, ViewGroup viewGroup) {
            View inflate = LayoutInflater.from(context).inflate(R.i.ddF, viewGroup, false);
            a aVar = this.phw.phv;
            aVar.ipv = (ImageView) inflate.findViewById(R.h.bqM);
            aVar.ipw = (TextView) inflate.findViewById(R.h.cJh);
            aVar.ipx = (TextView) inflate.findViewById(R.h.bIb);
            aVar.ipu = inflate.findViewById(R.h.cAN);
            inflate.setTag(aVar);
            return inflate;
        }

        public final void a(Context context, com.tencent.mm.plugin.fts.d.a.a.a aVar, com.tencent.mm.plugin.fts.d.a.a aVar2) {
            a aVar3 = (a) aVar;
            k kVar = (k) aVar2;
            ch(aVar3.ipu);
            if (kVar.username == null || kVar.username.length() <= 0) {
                aVar3.ipv.setImageResource(R.g.bes);
            } else {
                com.tencent.mm.pluginsdk.ui.a.b.a(aVar3.ipv, kVar.username);
            }
            aVar3.ipw.setText(kVar.kcm);
            aVar3.ipw.setMaxWidth(com.tencent.mm.bg.a.fromDPToPix(context, m.CTRL_INDEX));
            e.a(kVar.kcn, aVar3.ipx);
        }

        public final boolean a(Context context, com.tencent.mm.plugin.fts.d.a.a aVar) {
            k kVar = (k) aVar;
            a(this.phw.fRM, kVar.iJC);
            com.tencent.mm.plugin.search.a.imv.e(new Intent().putExtra("Chat_User", kVar.username).putExtra("finish_direct", true), context);
            return true;
        }
    }

    public k(int i) {
        super(2, i);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.content.Context r12, com.tencent.mm.plugin.fts.d.a.a.a r13, java.lang.Object... r14) {
        /*
        r11 = this;
        r4 = 0;
        r10 = 2;
        r6 = 1;
        r7 = 0;
        r0 = r11.iJC;
        r0 = r0.lZO;
        r11.username = r0;
        com.tencent.mm.u.ap.yY();
        r0 = com.tencent.mm.u.c.wR();
        r1 = r11.username;
        r0 = r0.Rc(r1);
        r11.jiL = r0;
        r3 = r11.iJD;
        r8 = r12.getResources();
        r2 = r11.jiL;
        r0 = r2.field_username;
        r9 = com.tencent.mm.u.n.a(r2, r0);
        r0 = r11.iJC;
        r0 = r0.hPr;
        switch(r0) {
            case 1: goto L_0x0109;
            case 2: goto L_0x0106;
            case 3: goto L_0x0054;
            case 5: goto L_0x0109;
            case 6: goto L_0x0106;
            case 7: goto L_0x0054;
            case 38: goto L_0x005f;
            default: goto L_0x002e;
        };
    L_0x002e:
        r5 = r7;
        r0 = r7;
        r8 = r4;
        r4 = r7;
    L_0x0032:
        if (r0 == 0) goto L_0x00d5;
    L_0x0034:
        r0 = com.tencent.mm.plugin.fts.d.d.b.mcC;
        r0 = com.tencent.mm.pluginsdk.ui.d.h.c(r12, r9, r0);
        r11.kcm = r0;
        r1 = r11.kcm;
        r2 = r11.fRM;
        r0 = com.tencent.mm.plugin.fts.d.f.a.mcJ;
        r6 = (float) r0;
        r7 = com.tencent.mm.plugin.fts.d.d.b.mcD;
        r0 = com.tencent.mm.plugin.fts.d.b.a.a(r1, r2, r3, r4, r5, r6, r7);
        r0 = com.tencent.mm.plugin.fts.d.f.b(r0);
        r0 = r0.mdL;
        r11.kcm = r0;
    L_0x0051:
        r11.kcn = r8;
        return;
    L_0x0054:
        r0 = r6;
    L_0x0055:
        r1 = r6;
    L_0x0056:
        r2 = r2.field_nickname;
        r11.kcn = r2;
        r5 = r0;
        r8 = r4;
        r0 = r6;
        r4 = r1;
        goto L_0x0032;
    L_0x005f:
        r0 = "SELECT memberlist FROM chatroom WHERE chatroomname=?;";
        com.tencent.mm.u.ap.yY();
        r1 = com.tencent.mm.u.c.wO();
        r5 = new java.lang.String[r6];
        r2 = r2.field_username;
        r5[r7] = r2;
        r1 = r1.a(r0, r5, r10);
        r0 = r1.moveToFirst();
        if (r0 == 0) goto L_0x0103;
    L_0x0079:
        r0 = r1.getString(r7);
        if (r0 != 0) goto L_0x00ce;
    L_0x007f:
        r0 = r4;
    L_0x0080:
        r2 = r0;
    L_0x0081:
        r1.close();
        if (r2 == 0) goto L_0x00a3;
    L_0x0086:
        r0 = r2.length;
        if (r0 <= 0) goto L_0x00a3;
    L_0x0089:
        r0 = new java.lang.StringBuilder;
        r1 = "(";
        r0.<init>(r1);
        r1 = r2.length;
        r0 = r0.append(r1);
        r1 = ")";
        r0 = r0.append(r1);
        r0 = r0.toString();
        r11.pht = r0;
    L_0x00a3:
        if (r2 == 0) goto L_0x002e;
    L_0x00a5:
        r0 = r11.iJC;
        r0 = r0.mau;
        if (r0 == 0) goto L_0x002e;
    L_0x00ab:
        r0 = r11.iJC;
        r1 = r0.mau;
        r4 = com.tencent.mm.plugin.fts.d.d.b.mcF;
        r5 = r11.fRM;
        r0 = r12;
        r0 = com.tencent.mm.plugin.fts.d.e.a(r0, r1, r2, r3, r4, r5);
        r1 = com.tencent.mm.R.l.ePG;
        r1 = r8.getString(r1);
        r2 = new java.lang.CharSequence[r10];
        r2[r7] = r1;
        r2[r6] = r0;
        r4 = android.text.TextUtils.concat(r2);
        r5 = r7;
        r0 = r7;
        r8 = r4;
        r4 = r7;
        goto L_0x0032;
    L_0x00ce:
        r2 = com.tencent.mm.plugin.fts.a.c.a.lZx;
        r0 = r2.split(r0);
        goto L_0x0080;
    L_0x00d5:
        r0 = com.tencent.mm.plugin.fts.d.d.b.mcC;
        r0 = com.tencent.mm.pluginsdk.ui.d.h.c(r12, r9, r0);
        r11.kcm = r0;
        r0 = r11.kcm;
        r1 = r11.pht;
        r2 = com.tencent.mm.plugin.fts.d.f.a.mcJ;
        r2 = (float) r2;
        r3 = com.tencent.mm.plugin.fts.d.d.b.mcD;
        r4 = android.text.TextUtils.TruncateAt.END;
        r5 = r1.toString();
        r5 = r3.measureText(r5);
        r2 = r2 - r5;
        r5 = new java.lang.CharSequence[r10];
        r0 = android.text.TextUtils.ellipsize(r0, r3, r2, r4);
        r5[r7] = r0;
        r5[r6] = r1;
        r0 = android.text.TextUtils.concat(r5);
        r11.kcm = r0;
        goto L_0x0051;
    L_0x0103:
        r2 = r4;
        goto L_0x0081;
    L_0x0106:
        r0 = r7;
        goto L_0x0055;
    L_0x0109:
        r0 = r7;
        r1 = r7;
        goto L_0x0056;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.search.ui.a.k.a(android.content.Context, com.tencent.mm.plugin.fts.d.a.a$a, java.lang.Object[]):void");
    }

    public final com.tencent.mm.plugin.fts.d.a.a.b Sr() {
        return this.phu;
    }

    protected final com.tencent.mm.plugin.fts.d.a.a.a Ss() {
        return this.phv;
    }

    public final int Su() {
        return this.iJC.maw;
    }

    public final int ayf() {
        if (this.iJC.hPr == 38) {
            List list = this.iJC.mau;
            if (list != null && list.size() > 0) {
                return ((d) list.get(0)).hPr;
            }
        }
        return super.ayf();
    }

    public final boolean ayg() {
        return this.iJC.may;
    }
}
