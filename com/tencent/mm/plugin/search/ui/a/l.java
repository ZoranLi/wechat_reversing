package com.tencent.mm.plugin.search.ui.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.bb.d;
import com.tencent.mm.plugin.search.ui.a.b.b;

public final class l extends b {
    private a phx = new a(this);

    public class a extends b {
        final /* synthetic */ l phy;

        public a(l lVar) {
            this.phy = lVar;
            super(lVar);
        }

        public final boolean a(Context context, com.tencent.mm.plugin.fts.d.a.a aVar) {
            l lVar = (l) aVar;
            a(this.phy.fRM, lVar.iJC);
            d.a(context, ".ui.chatting.En_5b8fbb1e", new Intent().putExtra("Chat_User", lVar.username).putExtra("finish_direct", true));
            return true;
        }
    }

    public l(int i) {
        super(i);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.content.Context r13, com.tencent.mm.plugin.fts.d.a.a.a r14, java.lang.Object... r15) {
        /*
        r12 = this;
        r2 = 0;
        r8 = 0;
        r7 = 1;
        r0 = r12.iJC;
        r0 = r0.lZO;
        r12.username = r0;
        com.tencent.mm.u.ap.yY();
        r0 = com.tencent.mm.u.c.wR();
        r1 = r12.username;
        r0 = r0.Rc(r1);
        r12.jiL = r0;
        r0 = r12.username;
        r5 = com.tencent.mm.u.n.eK(r0);
        r0 = r12.iJC;
        r0 = r0.hPr;
        switch(r0) {
            case 1: goto L_0x014b;
            case 2: goto L_0x0148;
            case 3: goto L_0x0085;
            case 4: goto L_0x00a1;
            case 5: goto L_0x0152;
            case 6: goto L_0x014f;
            case 7: goto L_0x008e;
            case 8: goto L_0x0025;
            case 9: goto L_0x0025;
            case 10: goto L_0x0025;
            case 11: goto L_0x0126;
            case 12: goto L_0x0025;
            case 13: goto L_0x0025;
            case 14: goto L_0x0025;
            case 15: goto L_0x00b3;
            case 16: goto L_0x00d1;
            case 17: goto L_0x0114;
            case 18: goto L_0x0102;
            default: goto L_0x0025;
        };
    L_0x0025:
        r4 = r8;
        r3 = r8;
        r9 = r8;
        r0 = r8;
        r10 = r2;
        r11 = r2;
    L_0x002b:
        if (r0 == 0) goto L_0x0138;
    L_0x002d:
        r0 = com.tencent.mm.R.f.aXI;
        r0 = com.tencent.mm.bg.a.T(r13, r0);
        r0 = com.tencent.mm.pluginsdk.ui.d.h.c(r13, r5, r0);
        r12.kcm = r0;
        r0 = r12.kcm;
        r1 = r12.fRM;
        r2 = r12.iJD;
        r5 = com.tencent.mm.plugin.fts.d.f.a.mcJ;
        r5 = (float) r5;
        r6 = com.tencent.mm.plugin.fts.d.d.b.mcD;
        r0 = com.tencent.mm.plugin.fts.d.b.a.a(r0, r1, r2, r3, r4, r5, r6);
        r0 = com.tencent.mm.plugin.fts.d.f.b(r0);
        r0 = r0.mdL;
        r12.kcm = r0;
    L_0x0050:
        if (r9 == 0) goto L_0x0084;
    L_0x0052:
        r0 = com.tencent.mm.R.f.aXI;
        r0 = com.tencent.mm.bg.a.T(r13, r0);
        r0 = com.tencent.mm.pluginsdk.ui.d.h.c(r13, r10, r0);
        r12.kcn = r0;
        r0 = r12.kcn;
        r1 = r12.fRM;
        r2 = r12.iJD;
        r5 = com.tencent.mm.plugin.fts.d.f.a.mcJ;
        r5 = (float) r5;
        r6 = com.tencent.mm.plugin.fts.d.d.b.mcF;
        r0 = com.tencent.mm.plugin.fts.d.b.a.a(r0, r1, r2, r3, r4, r5, r6);
        r0 = com.tencent.mm.plugin.fts.d.f.b(r0);
        r0 = r0.mdL;
        r12.kcn = r0;
        r0 = 2;
        r0 = new java.lang.CharSequence[r0];
        r0[r8] = r11;
        r1 = r12.kcn;
        r0[r7] = r1;
        r0 = android.text.TextUtils.concat(r0);
        r12.kcn = r0;
    L_0x0084:
        return;
    L_0x0085:
        r0 = r7;
    L_0x0086:
        r1 = r7;
    L_0x0087:
        r4 = r0;
        r3 = r1;
        r9 = r8;
        r10 = r2;
        r11 = r2;
        r0 = r7;
        goto L_0x002b;
    L_0x008e:
        r0 = r7;
    L_0x008f:
        r1 = r7;
    L_0x0090:
        r2 = r12.jiL;
        r2 = r2.field_nickname;
        r3 = com.tencent.mm.R.l.ePI;
        r3 = r13.getString(r3);
        r4 = r0;
        r9 = r7;
        r10 = r2;
        r11 = r3;
        r3 = r1;
        r0 = r8;
        goto L_0x002b;
    L_0x00a1:
        r0 = r12.jiL;
        r0 = r0.gkK;
        r1 = com.tencent.mm.R.l.ePE;
        r2 = r13.getString(r1);
        r4 = r8;
        r3 = r8;
        r9 = r7;
        r10 = r0;
        r11 = r2;
        r0 = r8;
        goto L_0x002b;
    L_0x00b3:
        r0 = r12.jiL;
        r0 = r0.pA();
        r1 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
        if (r1 == 0) goto L_0x00c3;
    L_0x00bf:
        r0 = r12.jiL;
        r0 = r0.field_username;
    L_0x00c3:
        r1 = com.tencent.mm.R.l.ePM;
        r2 = r13.getString(r1);
        r4 = r8;
        r3 = r8;
        r9 = r7;
        r10 = r0;
        r11 = r2;
        r0 = r8;
        goto L_0x002b;
    L_0x00d1:
        r0 = r12.iJC;
        r1 = r0.content;
        r0 = com.tencent.mm.sdk.platformtools.bg.mA(r1);
        if (r0 != 0) goto L_0x0146;
    L_0x00db:
        r0 = "​";
        r3 = r1.split(r0);
        r4 = r3.length;
        r2 = r8;
    L_0x00e4:
        if (r2 >= r4) goto L_0x0146;
    L_0x00e6:
        r0 = r3[r2];
        r6 = r12.fRM;
        r6 = r0.startsWith(r6);
        if (r6 == 0) goto L_0x00fe;
    L_0x00f0:
        r1 = com.tencent.mm.R.l.ePH;
        r2 = r13.getString(r1);
        r4 = r8;
        r3 = r8;
        r9 = r7;
        r10 = r0;
        r11 = r2;
        r0 = r8;
        goto L_0x002b;
    L_0x00fe:
        r0 = r2 + 1;
        r2 = r0;
        goto L_0x00e4;
    L_0x0102:
        r0 = r12.iJC;
        r0 = r0.content;
        r1 = com.tencent.mm.R.l.ePJ;
        r2 = r13.getString(r1);
        r4 = r8;
        r3 = r8;
        r9 = r7;
        r10 = r0;
        r11 = r2;
        r0 = r8;
        goto L_0x002b;
    L_0x0114:
        r0 = r12.iJC;
        r0 = r0.content;
        r1 = com.tencent.mm.R.l.ePD;
        r2 = r13.getString(r1);
        r4 = r8;
        r3 = r8;
        r9 = r7;
        r10 = r0;
        r11 = r2;
        r0 = r8;
        goto L_0x002b;
    L_0x0126:
        r0 = r12.iJC;
        r0 = r0.mar;
        r1 = com.tencent.mm.R.l.ePL;
        r2 = r13.getString(r1);
        r4 = r8;
        r3 = r8;
        r9 = r7;
        r10 = r0;
        r11 = r2;
        r0 = r8;
        goto L_0x002b;
    L_0x0138:
        r0 = com.tencent.mm.R.f.aXI;
        r0 = com.tencent.mm.bg.a.T(r13, r0);
        r0 = com.tencent.mm.pluginsdk.ui.d.h.c(r13, r5, r0);
        r12.kcm = r0;
        goto L_0x0050;
    L_0x0146:
        r0 = r1;
        goto L_0x00f0;
    L_0x0148:
        r0 = r8;
        goto L_0x0086;
    L_0x014b:
        r0 = r8;
        r1 = r8;
        goto L_0x0087;
    L_0x014f:
        r0 = r8;
        goto L_0x008f;
    L_0x0152:
        r0 = r8;
        r1 = r8;
        goto L_0x0090;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.search.ui.a.l.a(android.content.Context, com.tencent.mm.plugin.fts.d.a.a$a, java.lang.Object[]):void");
    }

    public final com.tencent.mm.plugin.fts.d.a.a.b Sr() {
        return this.phx;
    }
}
