package com.tencent.mm.ui.chatting;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.ah.a;
import com.tencent.mm.ui.chatting.ah.b;

final class bo extends b {
    public bo() {
        super(9);
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null && ((a) view.getTag()).type == this.knu) {
            return view;
        }
        view = new bj(layoutInflater, R.i.cXR);
        view.setTag(new dq(this.knu).du(view));
        return view;
    }

    protected final boolean bUp() {
        return false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.tencent.mm.ui.chatting.ah.a r9, int r10, com.tencent.mm.ui.chatting.En_5b8fbb1e.a r11, com.tencent.mm.storage.au r12, java.lang.String r13) {
        /*
        r8 = this;
        r3 = 16777215; // 0xffffff float:2.3509886E-38 double:8.2890456E-317;
        r6 = 1;
        r4 = 8;
        r5 = 0;
        r9 = (com.tencent.mm.ui.chatting.dq) r9;
        r0 = r12.field_type;
        r1 = 37;
        if (r0 != r1) goto L_0x016a;
    L_0x000f:
        com.tencent.mm.u.ap.yY();
        r0 = com.tencent.mm.u.c.wT();
        r1 = r12.field_content;
        r0 = r0.Au(r1);
        if (r0 == 0) goto L_0x002a;
    L_0x001e:
        r1 = r0.rUK;
        if (r1 == 0) goto L_0x002a;
    L_0x0022:
        r1 = r0.rUK;
        r1 = r1.length();
        if (r1 > 0) goto L_0x0034;
    L_0x002a:
        r0 = "MicroMsg.ChattingItemFMessageFrom";
        r1 = "getView : parse verify msg failed";
        com.tencent.mm.sdk.platformtools.w.e(r0, r1);
    L_0x0033:
        return;
    L_0x0034:
        r1 = r0.rUK;
        r2 = r0.uJW;
        com.tencent.mm.x.b.u(r1, r2);
        r1 = r0.rUK;
        r1 = com.tencent.mm.u.o.eU(r1);
        if (r1 == 0) goto L_0x00d8;
    L_0x0043:
        r1 = r9.vMO;
        r1.setVisibility(r4);
        r1 = r9.vMP;
        r1.setVisibility(r4);
        r1 = r9.vMQ;
        r1.setVisibility(r5);
        r1 = r9.vMN;
        r1.setBackgroundColor(r3);
        r1 = r9.vMQ;
        r2 = com.tencent.mm.R.l.emR;
        r2 = r11.getString(r2);
        r1.setText(r2);
    L_0x0062:
        r1 = r0.scene;
        switch(r1) {
            case 13: goto L_0x011f;
            case 14: goto L_0x0067;
            case 15: goto L_0x0067;
            case 16: goto L_0x0067;
            case 17: goto L_0x0067;
            case 18: goto L_0x00fb;
            case 19: goto L_0x0067;
            case 20: goto L_0x0067;
            case 21: goto L_0x0067;
            case 22: goto L_0x0104;
            case 23: goto L_0x0104;
            case 24: goto L_0x0104;
            case 25: goto L_0x0116;
            case 26: goto L_0x0104;
            case 27: goto L_0x0104;
            case 28: goto L_0x0104;
            case 29: goto L_0x0104;
            case 30: goto L_0x010d;
            default: goto L_0x0067;
        };
    L_0x0067:
        r1 = r9.vAg;
        r2 = com.tencent.mm.R.l.dTD;
        r1.setText(r2);
    L_0x006e:
        r1 = r9.pkN;
        r2 = r11.uSU;
        r2 = r2.uTo;
        r3 = r0.getDisplayName();
        r4 = r9.pkN;
        r4 = r4.getTextSize();
        r2 = com.tencent.mm.pluginsdk.ui.d.h.b(r2, r3, r4);
        r1.setText(r2);
        r1 = r9.ipv;
        r2 = r0.rUK;
        com.tencent.mm.ui.chatting.ah.o(r1, r2);
        r1 = r9.suV;
        r1.setVisibility(r5);
        r1 = r0.content;
        if (r1 == 0) goto L_0x015d;
    L_0x0095:
        r1 = r0.content;
        r1 = r1.trim();
        r2 = "";
        r1 = r1.equals(r2);
        if (r1 != 0) goto L_0x015d;
    L_0x00a4:
        r1 = r9.suV;
        r0 = r0.content;
        r1.setText(r0);
    L_0x00ab:
        r7 = r9.vBZ;
        r0 = new com.tencent.mm.ui.chatting.dt;
        r2 = r11.vxp;
        r4 = 0;
        r1 = r12;
        r3 = r10;
        r6 = r5;
        r0.<init>(r1, r2, r3, r4, r5, r6);
        r7.setTag(r0);
        r0 = r9.vBZ;
        r1 = r11.vBD;
        r1 = r1.vEW;
        r0.setOnClickListener(r1);
        r0 = r9.vBZ;
        r1 = r11.vBD;
        r1 = r1.vEY;
        r0.setOnLongClickListener(r1);
        r0 = r9.vBZ;
        r1 = r11.vBD;
        r1 = r1.vFa;
        r0.setOnTouchListener(r1);
        goto L_0x0033;
    L_0x00d8:
        r1 = r9.vMO;
        r1.setVisibility(r5);
        r1 = r9.vMP;
        r1.setVisibility(r5);
        r1 = r9.vMQ;
        r1.setVisibility(r5);
        r1 = r9.vMN;
        r2 = com.tencent.mm.R.g.biQ;
        r1.setBackgroundResource(r2);
        r1 = r9.vMQ;
        r2 = com.tencent.mm.R.l.emQ;
        r2 = r11.getString(r2);
        r1.setText(r2);
        goto L_0x0062;
    L_0x00fb:
        r1 = r9.vAg;
        r2 = com.tencent.mm.R.l.dTH;
        r1.setText(r2);
        goto L_0x006e;
    L_0x0104:
        r1 = r9.vAg;
        r2 = com.tencent.mm.R.l.dTJ;
        r1.setText(r2);
        goto L_0x006e;
    L_0x010d:
        r1 = r9.vAg;
        r2 = com.tencent.mm.R.l.eHu;
        r1.setText(r2);
        goto L_0x006e;
    L_0x0116:
        r1 = r9.vAg;
        r2 = com.tencent.mm.R.l.dTC;
        r1.setText(r2);
        goto L_0x006e;
    L_0x011f:
        r1 = com.tencent.mm.modelfriend.af.FY();
        r2 = r0.rUK;
        r1 = r1.iZ(r2);
        r2 = r1.ER();
        if (r2 == 0) goto L_0x0156;
    L_0x012f:
        r2 = r1.ER();
        r3 = "";
        r2 = r2.equals(r3);
        if (r2 != 0) goto L_0x0156;
    L_0x013c:
        r2 = r9.vMR;
        r2.setVisibility(r5);
        r2 = r9.vMR;
        r3 = com.tencent.mm.R.l.dTx;
        r4 = new java.lang.Object[r6];
        r1 = r1.ER();
        r4[r5] = r1;
        r1 = r11.getString(r3, r4);
        r2.setText(r1);
        goto L_0x0067;
    L_0x0156:
        r1 = r9.vMR;
        r1.setVisibility(r4);
        goto L_0x0067;
    L_0x015d:
        r0 = r9.suV;
        r1 = com.tencent.mm.R.l.dTI;
        r1 = r11.getString(r1);
        r0.setText(r1);
        goto L_0x00ab;
    L_0x016a:
        r0 = r12.field_type;
        r1 = 40;
        if (r0 != r1) goto L_0x02e7;
    L_0x0170:
        com.tencent.mm.u.ap.yY();
        r0 = com.tencent.mm.u.c.wT();
        r1 = r12.field_content;
        r1 = r0.Av(r1);
        if (r1 == 0) goto L_0x018b;
    L_0x017f:
        r0 = r1.rUK;
        if (r0 == 0) goto L_0x018b;
    L_0x0183:
        r0 = r1.rUK;
        r0 = r0.length();
        if (r0 > 0) goto L_0x0196;
    L_0x018b:
        r0 = "MicroMsg.ChattingItemFMessageFrom";
        r1 = "getView : parse possible friend msg failed";
        com.tencent.mm.sdk.platformtools.w.e(r0, r1);
        goto L_0x0033;
    L_0x0196:
        r0 = r1.rUK;
        r2 = r1.uJW;
        com.tencent.mm.x.b.u(r0, r2);
        r0 = r1.rUK;
        r0 = com.tencent.mm.u.o.eU(r0);
        if (r0 == 0) goto L_0x020a;
    L_0x01a5:
        r0 = r9.vMO;
        r0.setVisibility(r4);
        r0 = r9.vMP;
        r0.setVisibility(r4);
        r0 = r9.vMQ;
        r0.setVisibility(r5);
        r0 = r9.vMN;
        r0.setBackgroundColor(r3);
        r0 = r9.vMQ;
        r2 = com.tencent.mm.R.l.emR;
        r2 = r11.getString(r2);
        r0.setText(r2);
    L_0x01c4:
        r0 = r1.scene;
        switch(r0) {
            case 4: goto L_0x022c;
            case 10: goto L_0x0258;
            case 11: goto L_0x0258;
            case 31: goto L_0x0299;
            case 32: goto L_0x02c0;
            default: goto L_0x01c9;
        };
    L_0x01c9:
        r0 = "MicroMsg.ChattingItemFMessageFrom";
        r2 = "prossible friend sceneType:%d";
        r3 = new java.lang.Object[r6];
        r4 = r1.scene;
        r4 = java.lang.Integer.valueOf(r4);
        r3[r5] = r4;
        com.tencent.mm.sdk.platformtools.w.d(r0, r2, r3);
        r0 = r9.vAg;
        r2 = com.tencent.mm.R.l.dTy;
        r0.setText(r2);
        r0 = r9.suV;
        r2 = com.tencent.mm.R.l.dTz;
        r0.setText(r2);
        r0 = r9.pkN;
        r2 = r11.uSU;
        r2 = r2.uTo;
        r3 = r1.getDisplayName();
        r4 = r9.pkN;
        r4 = r4.getTextSize();
        r2 = com.tencent.mm.pluginsdk.ui.d.h.b(r2, r3, r4);
        r0.setText(r2);
    L_0x0201:
        r0 = r9.ipv;
        r1 = r1.rUK;
        com.tencent.mm.ui.chatting.ah.o(r0, r1);
        goto L_0x00ab;
    L_0x020a:
        r0 = r9.vMO;
        r0.setVisibility(r5);
        r0 = r9.vMP;
        r0.setVisibility(r5);
        r0 = r9.vMQ;
        r0.setVisibility(r5);
        r0 = r9.vMN;
        r2 = com.tencent.mm.R.g.biQ;
        r0.setBackgroundResource(r2);
        r0 = r9.vMQ;
        r2 = com.tencent.mm.R.l.emQ;
        r2 = r11.getString(r2);
        r0.setText(r2);
        goto L_0x01c4;
    L_0x022c:
        r0 = r9.vAg;
        r2 = com.tencent.mm.R.l.dTt;
        r0.setText(r2);
        r0 = r9.suV;
        r2 = com.tencent.mm.R.l.dTu;
        r0.setText(r2);
        r0 = r1.bMH();
        if (r0 != 0) goto L_0x0244;
    L_0x0240:
        r0 = r1.getDisplayName();
    L_0x0244:
        r2 = r9.pkN;
        r3 = r11.uSU;
        r3 = r3.uTo;
        r4 = r9.pkN;
        r4 = r4.getTextSize();
        r0 = com.tencent.mm.pluginsdk.ui.d.h.b(r3, r0, r4);
        r2.setText(r0);
        goto L_0x0201;
    L_0x0258:
        r0 = r9.vAg;
        r2 = com.tencent.mm.R.l.dTw;
        r0.setText(r2);
        r0 = r1.uJX;
        r0 = com.tencent.mm.modelfriend.m.jh(r0);
        r2 = com.tencent.mm.platformtools.u.mA(r0);
        if (r2 == 0) goto L_0x0271;
    L_0x026b:
        r0 = r1.uJY;
        r0 = com.tencent.mm.modelfriend.m.jh(r0);
    L_0x0271:
        r2 = r9.suV;
        r3 = com.tencent.mm.R.l.dTx;
        r4 = new java.lang.Object[r6];
        r4[r5] = r0;
        r0 = r11.getString(r3, r4);
        r2.setText(r0);
        r0 = r9.pkN;
        r2 = r11.uSU;
        r2 = r2.uTo;
        r3 = r1.getDisplayName();
        r4 = r9.pkN;
        r4 = r4.getTextSize();
        r2 = com.tencent.mm.pluginsdk.ui.d.h.b(r2, r3, r4);
        r0.setText(r2);
        goto L_0x0201;
    L_0x0299:
        r0 = r9.vAg;
        r2 = com.tencent.mm.R.l.dTF;
        r0.setText(r2);
        r0 = r9.suV;
        r2 = com.tencent.mm.R.l.dTG;
        r0.setText(r2);
        r0 = r9.pkN;
        r2 = r11.uSU;
        r2 = r2.uTo;
        r3 = r1.getDisplayName();
        r4 = r9.pkN;
        r4 = r4.getTextSize();
        r2 = com.tencent.mm.pluginsdk.ui.d.h.b(r2, r3, r4);
        r0.setText(r2);
        goto L_0x0201;
    L_0x02c0:
        r0 = r9.vAg;
        r2 = com.tencent.mm.R.l.dTB;
        r0.setText(r2);
        r0 = r9.suV;
        r2 = com.tencent.mm.R.l.dTA;
        r0.setText(r2);
        r0 = r9.pkN;
        r2 = r11.uSU;
        r2 = r2.uTo;
        r3 = r1.getDisplayName();
        r4 = r9.pkN;
        r4 = r4.getTextSize();
        r2 = com.tencent.mm.pluginsdk.ui.d.h.b(r2, r3, r4);
        r0.setText(r2);
        goto L_0x0201;
    L_0x02e7:
        r0 = "MicroMsg.ChattingItemFMessageFrom";
        r1 = new java.lang.StringBuilder;
        r2 = "FROM_FMESSAGE did not include this type, msgType = ";
        r1.<init>(r2);
        r2 = r12.field_type;
        r1 = r1.append(r2);
        r1 = r1.toString();
        com.tencent.mm.sdk.platformtools.w.w(r0, r1);
        goto L_0x00ab;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.bo.a(com.tencent.mm.ui.chatting.ah$a, int, com.tencent.mm.ui.chatting.En_5b8fbb1e$a, com.tencent.mm.storage.au, java.lang.String):void");
    }

    public final boolean a(ContextMenu contextMenu, View view, au auVar) {
        return false;
    }

    public final boolean a(MenuItem menuItem, En_5b8fbb1e.a aVar, au auVar) {
        return false;
    }

    public final boolean a(View view, En_5b8fbb1e.a aVar, au auVar) {
        return false;
    }
}
