package com.tencent.mm.ui.chatting;

import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnLongClickListener;
import com.tencent.mm.ui.chatting.En_5b8fbb1e.a;

class cz implements OnLongClickListener {
    public int kaQ;
    public int kaR;
    private OnCreateContextMenuListener oKJ;
    public a vCd;
    public View vya;

    public cz(OnCreateContextMenuListener onCreateContextMenuListener, a aVar) {
        this.vCd = aVar;
        this.oKJ = onCreateContextMenuListener;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onLongClick(android.view.View r10) {
        /*
        r9 = this;
        r8 = 10976; // 0x2ae0 float:1.538E-41 double:5.423E-320;
        r4 = 3;
        r5 = 2;
        r7 = 0;
        r6 = 1;
        r0 = r10.getTag();
        r0 = r0 instanceof com.tencent.mm.ui.chatting.dt;
        if (r0 == 0) goto L_0x018f;
    L_0x000e:
        r0 = r10.getTag();
        r0 = (com.tencent.mm.ui.chatting.dt) r0;
        r1 = r9.vCd;
        r1 = r1.nxh;
        r1 = r1.nuP;
        r2 = r1.getSelectionStart();
        r1 = r0.knu;
        if (r1 != r6) goto L_0x0189;
    L_0x0022:
        r1 = r9.vCd;
        r1 = r1.vJh;
        if (r1 != 0) goto L_0x0032;
    L_0x0028:
        r0 = "MicroMsg.ChattingListLongClickListener";
        r1 = "ChattingUI disable Touch NOW!!!";
        com.tencent.mm.sdk.platformtools.w.w(r0, r1);
    L_0x0031:
        return r6;
    L_0x0032:
        r1 = r0.userName;
        r3 = com.tencent.mm.u.m.xL();
        r1 = r1.equals(r3);
        if (r1 != 0) goto L_0x0031;
    L_0x003e:
        r1 = r9.vCd;
        r1 = r1.nxh;
        r1 = r1.sKI;
        if (r1 == 0) goto L_0x0050;
    L_0x0046:
        r0 = "MicroMsg.ChattingListLongClickListener";
        r1 = "ChatFooter VoiceInputPanel Show NOW!!!";
        com.tencent.mm.sdk.platformtools.w.i(r0, r1);
        goto L_0x0031;
    L_0x0050:
        r1 = r9.vCd;
        r1 = r1.bUg();
        r1 = com.tencent.mm.u.o.dH(r1);
        if (r1 != 0) goto L_0x0062;
    L_0x005c:
        r1 = r9.vCd;
        r1 = r1.vJa;
        if (r1 == 0) goto L_0x0103;
    L_0x0062:
        r1 = com.tencent.mm.plugin.report.service.g.oUh;
        r3 = new java.lang.Object[r4];
        r4 = java.lang.Integer.valueOf(r7);
        r3[r7] = r4;
        r4 = java.lang.Integer.valueOf(r6);
        r3[r6] = r4;
        r4 = java.lang.Integer.valueOf(r7);
        r3[r5] = r4;
        r1.i(r8, r3);
        com.tencent.mm.u.ap.yY();
        r1 = com.tencent.mm.u.c.xa();
        r3 = r0.chatroomName;
        r1 = r1.fV(r3);
        r3 = r9.vCd;
        r3 = r3.vJa;
        if (r3 == 0) goto L_0x00f0;
    L_0x008e:
        r1 = r9.vCd;
        r3 = r0.userName;
        r1 = r1.eK(r3);
    L_0x0096:
        r3 = new java.lang.StringBuffer;
        r4 = r9.vCd;
        r4 = r4.nxh;
        r4 = r4.bFu();
        r3.<init>(r4);
        r4 = new java.lang.StringBuilder;
        r5 = "@";
        r4.<init>(r5);
        r4 = r4.append(r1);
        r5 = 8197; // 0x2005 float:1.1486E-41 double:4.05E-320;
        r4 = r4.append(r5);
        r4 = r4.toString();
        r3.insert(r2, r4);
        r4 = r9.vCd;
        r4 = r4.nxh;
        r3 = r3.toString();
        r5 = r1.length();
        r2 = r2 + r5;
        r2 = r2 + 2;
        r4.p(r3, r2, r6);
        r2 = r9.vCd;
        r2 = r2.nxh;
        r3 = r0.chatroomName;
        r0 = r0.userName;
        r2.X(r3, r0, r1);
        r0 = r9.vCd;
        r0.vJh = r7;
        r0 = r9.vCd;
        r0 = r0.nxh;
        r0.ab(r6, r6);
        r0 = new com.tencent.mm.ui.chatting.cz$1;
        r0.<init>(r9);
        r2 = 2000; // 0x7d0 float:2.803E-42 double:9.88E-321;
        r10.postDelayed(r0, r2);
        goto L_0x0031;
    L_0x00f0:
        r3 = r0.userName;
        r1 = com.tencent.mm.ui.chatting.AtSomeoneUI.a(r1, r3);
        r3 = com.tencent.mm.platformtools.u.mA(r1);
        if (r3 == 0) goto L_0x0096;
    L_0x00fc:
        r1 = r0.userName;
        r1 = com.tencent.mm.u.n.eI(r1);
        goto L_0x0096;
    L_0x0103:
        r1 = r9.vCd;
        r1 = r1.bUg();
        r1 = com.tencent.mm.u.o.eU(r1);
        if (r1 == 0) goto L_0x0031;
    L_0x010f:
        r1 = r9.vCd;
        r1 = r1.bUg();
        r3 = "@";
        r1 = r1.contains(r3);
        if (r1 != 0) goto L_0x0031;
    L_0x011e:
        r1 = com.tencent.mm.plugin.report.service.g.oUh;
        r3 = new java.lang.Object[r4];
        r4 = java.lang.Integer.valueOf(r7);
        r3[r7] = r4;
        r4 = java.lang.Integer.valueOf(r6);
        r3[r6] = r4;
        r4 = java.lang.Integer.valueOf(r6);
        r3[r5] = r4;
        r1.i(r8, r3);
        r1 = r9.vCd;
        r1 = r1.sMK;
        if (r1 == 0) goto L_0x0182;
    L_0x013d:
        r1 = r9.vCd;
        r1 = r1.vJa;
        if (r1 != 0) goto L_0x0182;
    L_0x0143:
        r1 = r9.vCd;
        r0 = r0.userName;
        r0 = r1.eK(r0);
    L_0x014b:
        r1 = new java.lang.StringBuffer;
        r3 = r9.vCd;
        r3 = r3.nxh;
        r3 = r3.bFu();
        r1.<init>(r3);
        r1.insert(r2, r0);
        r3 = r9.vCd;
        r3 = r3.nxh;
        r1 = r1.toString();
        r0 = r0.length();
        r0 = r0 + r2;
        r3.p(r1, r0, r6);
        r0 = r9.vCd;
        r0.vJh = r7;
        r0 = r9.vCd;
        r0 = r0.nxh;
        r0.ab(r6, r6);
        r0 = new com.tencent.mm.ui.chatting.cz$2;
        r0.<init>(r9);
        r2 = 2000; // 0x7d0 float:2.803E-42 double:9.88E-321;
        r10.postDelayed(r0, r2);
        goto L_0x0031;
    L_0x0182:
        r0 = r0.userName;
        r0 = com.tencent.mm.u.n.eI(r0);
        goto L_0x014b;
    L_0x0189:
        r0 = r0.knu;
        r1 = 9;
        if (r0 == r1) goto L_0x0031;
    L_0x018f:
        r0 = com.tencent.mm.R.h.cJw;
        r0 = r10.getTag(r0);
        r0 = r0 instanceof int[];
        if (r0 == 0) goto L_0x01ae;
    L_0x0199:
        r0 = com.tencent.mm.R.h.cJw;
        r0 = r10.getTag(r0);
        r0 = (int[]) r0;
        r0 = (int[]) r0;
        r1 = r9.vCd;
        r2 = r0[r7];
        r0 = r0[r6];
        r1.j(r10, r2, r0);
        goto L_0x0031;
    L_0x01ae:
        r0 = r9.kaQ;
        if (r0 != 0) goto L_0x01b6;
    L_0x01b2:
        r0 = r9.kaR;
        if (r0 == 0) goto L_0x01be;
    L_0x01b6:
        r0 = r9.vya;
        r0 = r0.equals(r10);
        if (r0 != 0) goto L_0x01c8;
    L_0x01be:
        r0 = new com.tencent.mm.ui.chatting.cz$3;
        r0.<init>(r9);
        r10.setOnTouchListener(r0);
        goto L_0x0031;
    L_0x01c8:
        r0 = r9.vCd;
        r1 = r9.kaQ;
        r2 = r9.kaR;
        r0.j(r10, r1, r2);
        goto L_0x0031;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.cz.onLongClick(android.view.View):boolean");
    }
}
