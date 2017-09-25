package com.tencent.mm.ui.chatting;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.ah.a.a.c;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.a.dd;
import com.tencent.mm.e.a.lz;
import com.tencent.mm.modelbiz.e;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.storage.au;
import com.tencent.mm.t.f;
import com.tencent.mm.u.ay;
import com.tencent.mm.ui.chatting.En_5b8fbb1e.a;
import com.tencent.mm.ui.chatting.ah.b;
import com.tencent.wcdb.FileUtils;

final class as extends b {
    private a vCd;
    private boolean vCm;
    private c vCn;

    public as(int i) {
        super(i);
        c.a aVar = new c.a();
        aVar.hJa = R.k.dtz;
        this.vCn = aVar.Hg();
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null && (view.getTag() instanceof n) && ((ah.a) view.getTag()).type == this.knu) {
            return view;
        }
        view = new bj(layoutInflater, R.i.cXF);
        view.setTag(new n(this.knu).q(view, true));
        return view;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.tencent.mm.ui.chatting.ah.a r27, int r28, com.tencent.mm.ui.chatting.En_5b8fbb1e.a r29, com.tencent.mm.storage.au r30, java.lang.String r31) {
        /*
        r26 = this;
        r21 = r27;
        r21 = (com.tencent.mm.ui.chatting.n) r21;
        r0 = r29;
        r1 = r26;
        r1.vCd = r0;
        r21.reset();
        r0 = r30;
        r6 = r0.field_content;
        r29.aG(r30);
        r29.aH(r30);
        r29.aI(r30);
        r0 = r26;
        r7 = r0.vCm;
        if (r7 == 0) goto L_0x1318;
    L_0x0020:
        r0 = r30;
        r7 = r0.field_content;
        r8 = 58;
        r7 = r7.indexOf(r8);
        r8 = -1;
        if (r7 == r8) goto L_0x1318;
    L_0x002d:
        r0 = r30;
        r6 = r0.field_content;
        r7 = r7 + 1;
        r6 = r6.substring(r7);
        r15 = r6;
    L_0x0038:
        r7 = 0;
        r6 = 0;
        if (r15 == 0) goto L_0x040a;
    L_0x003c:
        r0 = r30;
        r6 = r0.field_reserved;
        r7 = com.tencent.mm.t.f.a.B(r15, r6);
        r6 = com.tencent.mm.t.j.eo(r15);
        r14 = r6;
        r22 = r7;
    L_0x004b:
        r6 = new com.tencent.mm.ui.chatting.dt;
        r0 = r29;
        r8 = r0.vxp;
        r10 = 0;
        r11 = 0;
        r12 = 0;
        r7 = r30;
        r9 = r28;
        r6.<init>(r7, r8, r9, r10, r11, r12);
        if (r22 == 0) goto L_0x03d5;
    L_0x005d:
        r0 = r21;
        r7 = r0.ipw;
        r8 = r22.getTitle();
        r7.setText(r8);
        r0 = r21;
        r7 = r0.ipx;
        r8 = r22.getDescription();
        r7.setText(r8);
        r0 = r21;
        r7 = r0.mys;
        r8 = 1;
        r7.setMaxLines(r8);
        r0 = r21;
        r7 = r0.ipw;
        r0 = r29;
        r8 = r0.uSU;
        r8 = r8.uTo;
        r8 = r8.getResources();
        r9 = com.tencent.mm.R.e.aVo;
        r8 = r8.getColor(r9);
        r7.setTextColor(r8);
        r0 = r21;
        r7 = r0.ipx;
        r0 = r29;
        r8 = r0.uSU;
        r8 = r8.uTo;
        r8 = r8.getResources();
        r9 = com.tencent.mm.R.e.aUo;
        r8 = r8.getColor(r9);
        r7.setTextColor(r8);
        r0 = r21;
        r7 = r0.vzc;
        r8 = com.tencent.mm.R.g.bdG;
        r7.setBackgroundResource(r8);
        r0 = r21;
        r7 = r0.vzc;
        r8 = 0;
        r0 = r29;
        r9 = r0.uSU;
        r9 = r9.uTo;
        r9 = r9.getResources();
        r10 = com.tencent.mm.R.f.aXz;
        r9 = r9.getDimensionPixelSize(r10);
        r10 = 0;
        r11 = 0;
        r7.setPadding(r8, r9, r10, r11);
        r0 = r21;
        r7 = r0.vyp;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r21;
        r7 = r0.vza;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r21;
        r7 = r0.ipx;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r21;
        r7 = r0.vyQ;
        r8 = 8;
        r7.setVisibility(r8);
        r0 = r21;
        r7 = r0.vyS;
        r8 = 8;
        r7.setVisibility(r8);
        r0 = r21;
        r7 = r0.vyR;
        r8 = 8;
        r7.setVisibility(r8);
        r0 = r21;
        r7 = r0.vze;
        r8 = 8;
        r7.setVisibility(r8);
        r0 = r21;
        r7 = r0.vzf;
        r8 = 8;
        r7.setVisibility(r8);
        r0 = r21;
        r7 = r0.vyM;
        r8 = 8;
        r7.setVisibility(r8);
        r0 = r21;
        r7 = r0.vyN;
        r8 = 8;
        r7.setVisibility(r8);
        r0 = r21;
        r7 = r0.vzn;
        r8 = 8;
        r7.setVisibility(r8);
        r0 = r21;
        r7 = r0.vzg;
        r8 = 8;
        r7.setVisibility(r8);
        r0 = r21;
        r7 = r0.vzc;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r21;
        r7 = r0.vzb;
        r0 = r21;
        r8 = r0.vym;
        com.tencent.mm.ui.chatting.ah.a.I(r7, r8);
        r7 = com.tencent.mm.t.d.class;
        r0 = r22;
        r7 = r0.n(r7);
        r7 = (com.tencent.mm.t.d) r7;
        r0 = r21;
        r8 = r0.vyU;
        if (r7 != 0) goto L_0x0429;
    L_0x0158:
        r7 = 0;
    L_0x0159:
        r0 = r30;
        r9 = r0.field_talker;
        r10 = 0;
        r7 = r8.b(r7, r9, r10);
        if (r7 == 0) goto L_0x042d;
    L_0x0164:
        r0 = r21;
        r7 = r0.vzb;
        r8 = com.tencent.mm.R.g.bdY;
        r7.setBackgroundResource(r8);
    L_0x016d:
        r0 = r22;
        r7 = r0.appId;
        r0 = r22;
        r8 = r0.fWF;
        r25 = com.tencent.mm.pluginsdk.model.app.g.cv(r7, r8);
        if (r25 == 0) goto L_0x018a;
    L_0x017b:
        r7 = r25.bCU();
        if (r7 == 0) goto L_0x018a;
    L_0x0181:
        r0 = r29;
        r1 = r22;
        r2 = r30;
        com.tencent.mm.ui.chatting.ah.b(r0, r1, r2);
    L_0x018a:
        if (r25 == 0) goto L_0x01a0;
    L_0x018c:
        r0 = r25;
        r7 = r0.field_appName;
        if (r7 == 0) goto L_0x01a0;
    L_0x0192:
        r0 = r25;
        r7 = r0.field_appName;
        r7 = r7.trim();
        r7 = r7.length();
        if (r7 > 0) goto L_0x0438;
    L_0x01a0:
        r0 = r22;
        r7 = r0.appName;
    L_0x01a4:
        r8 = 1;
        r0 = r29;
        r9 = r0.uSU;
        r9 = r9.uTo;
        r10 = 12;
        com.tencent.mm.bg.a.fromDPToPix(r9, r10);
        r0 = r22;
        r9 = r0.type;
        r10 = 20;
        if (r9 == r10) goto L_0x01c5;
    L_0x01b8:
        r9 = "wxaf060266bfa9a35c";
        r0 = r22;
        r10 = r0.appId;
        r9 = r9.equals(r10);
        if (r9 == 0) goto L_0x01cd;
    L_0x01c5:
        r8 = com.tencent.mm.pluginsdk.l.a.bCn();
        r8 = r8.baQ();
    L_0x01cd:
        if (r8 == 0) goto L_0x044d;
    L_0x01cf:
        r0 = r22;
        r8 = r0.appId;
        if (r8 == 0) goto L_0x044d;
    L_0x01d5:
        r0 = r22;
        r8 = r0.appId;
        r8 = r8.length();
        if (r8 <= 0) goto L_0x044d;
    L_0x01df:
        r8 = com.tencent.mm.pluginsdk.model.app.g.bn(r7);
        if (r8 == 0) goto L_0x044d;
    L_0x01e5:
        r0 = r21;
        r8 = r0.lMU;
        r0 = r29;
        r9 = r0.uSU;
        r9 = r9.uTo;
        r0 = r25;
        r7 = com.tencent.mm.pluginsdk.model.app.g.a(r9, r0, r7);
        r8.setText(r7);
        r0 = r21;
        r7 = r0.lMU;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r21;
        r7 = r0.lMU;
        r8 = 0;
        r9 = 0;
        r10 = 0;
        r11 = 0;
        r7.setCompoundDrawables(r8, r9, r10, r11);
        r0 = r21;
        r7 = r0.vyO;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r21;
        r7 = r0.vyL;
        r8 = 0;
        r7.setVisibility(r8);
        if (r25 == 0) goto L_0x043e;
    L_0x021d:
        r7 = r25.bCU();
        if (r7 == 0) goto L_0x043e;
    L_0x0223:
        r0 = r21;
        r8 = r0.lMU;
        r0 = r25;
        r11 = r0.field_packageName;
        r0 = r30;
        r12 = r0.field_msgSvrId;
        r7 = r29;
        r9 = r30;
        r10 = r22;
        com.tencent.mm.ui.chatting.ah.a(r7, r8, r9, r10, r11, r12);
    L_0x0238:
        r0 = r21;
        r7 = r0.vyL;
        r0 = r22;
        r8 = r0.appId;
        r0 = r29;
        com.tencent.mm.ui.chatting.ah.a(r0, r7, r8);
    L_0x0245:
        r0 = r22;
        r7 = r0.hhn;
        if (r7 == 0) goto L_0x04d8;
    L_0x024b:
        r0 = r22;
        r7 = r0.hhn;
        r7 = r7.hkh;
        if (r7 == 0) goto L_0x04d8;
    L_0x0253:
        r7 = 1;
    L_0x0254:
        if (r7 == 0) goto L_0x025f;
    L_0x0256:
        r0 = r21;
        r7 = r0.vyO;
        r8 = 8;
        r7.setVisibility(r8);
    L_0x025f:
        r7 = 0;
        r0 = r21;
        r8 = r0.vyp;
        r9 = 0;
        r8.setVisibility(r9);
        r0 = r22;
        r8 = r0.hhn;
        if (r8 == 0) goto L_0x04db;
    L_0x026e:
        r0 = r22;
        r8 = r0.hhn;
        r8 = r8.hke;
        r9 = 1;
        if (r8 != r9) goto L_0x04db;
    L_0x0277:
        r8 = 1;
    L_0x0278:
        if (r8 != 0) goto L_0x04e1;
    L_0x027a:
        r0 = r26;
        r8 = r0.sXW;
        if (r8 == 0) goto L_0x04e1;
    L_0x0280:
        r8 = 0;
        r0 = r22;
        r9 = r0.type;
        r10 = 33;
        if (r9 == r10) goto L_0x02a8;
    L_0x0289:
        r0 = r22;
        r9 = r0.type;
        r10 = 36;
        if (r9 == r10) goto L_0x02a8;
    L_0x0291:
        r8 = com.tencent.mm.ah.n.GS();
        r0 = r30;
        r9 = r0.field_imgPath;
        r0 = r29;
        r10 = r0.uSU;
        r10 = r10.uTo;
        r10 = com.tencent.mm.bg.a.getDensity(r10);
        r11 = 0;
        r8 = r8.a(r9, r10, r11);
    L_0x02a8:
        if (r8 == 0) goto L_0x04de;
    L_0x02aa:
        r9 = r8.isRecycled();
        if (r9 != 0) goto L_0x04de;
    L_0x02b0:
        r0 = r21;
        r9 = r0.vyp;
        r9.setImageBitmap(r8);
    L_0x02b7:
        r0 = r22;
        r9 = r0.type;
        r10 = 3;
        if (r9 != r10) goto L_0x02d4;
    L_0x02be:
        r0 = r21;
        r9 = r0.vzc;
        r9 = r9.getViewTreeObserver();
        r10 = new com.tencent.mm.ui.chatting.as$1;
        r0 = r26;
        r1 = r21;
        r2 = r29;
        r10.<init>(r0, r1, r2, r8);
        r9.addOnPreDrawListener(r10);
    L_0x02d4:
        r23 = r7;
    L_0x02d6:
        r0 = r22;
        r7 = r0.gxD;
        if (r7 == 0) goto L_0x02e6;
    L_0x02dc:
        r0 = r22;
        r7 = r0.gxD;
        r7 = r7.length();
        if (r7 != 0) goto L_0x04f6;
    L_0x02e6:
        r0 = r21;
        r7 = r0.vyE;
        r8 = 8;
        r7.setVisibility(r8);
    L_0x02ef:
        r0 = r21;
        r7 = r0.vyT;
        r8 = 0;
        r7.setOnClickListener(r8);
        r0 = r21;
        r7 = r0.vyW;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r21;
        r7 = r0.vyP;
        r8 = 8;
        r7.setVisibility(r8);
        r0 = r21;
        r7 = r0.vyZ;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r21;
        r7 = r0.vyX;
        r8 = 8;
        r7.setVisibility(r8);
        r24 = 0;
        r0 = r22;
        r7 = r0.type;
        switch(r7) {
            case 0: goto L_0x0c83;
            case 1: goto L_0x0322;
            case 2: goto L_0x0322;
            case 3: goto L_0x0511;
            case 4: goto L_0x06b7;
            case 5: goto L_0x0747;
            case 6: goto L_0x0608;
            case 7: goto L_0x0a47;
            case 8: goto L_0x0322;
            case 9: goto L_0x0322;
            case 10: goto L_0x0ad1;
            case 11: goto L_0x0322;
            case 12: goto L_0x0322;
            case 13: goto L_0x0b8d;
            case 14: goto L_0x0322;
            case 15: goto L_0x0d06;
            case 16: goto L_0x0f92;
            case 17: goto L_0x0322;
            case 18: goto L_0x0322;
            case 19: goto L_0x10d3;
            case 20: goto L_0x0c04;
            case 21: goto L_0x0322;
            case 22: goto L_0x0322;
            case 23: goto L_0x0322;
            case 24: goto L_0x102a;
            case 25: goto L_0x0dc2;
            case 26: goto L_0x0e7c;
            case 27: goto L_0x0e7c;
            case 28: goto L_0x0322;
            case 29: goto L_0x0322;
            case 30: goto L_0x0322;
            case 31: goto L_0x0322;
            case 32: goto L_0x0322;
            case 33: goto L_0x08c7;
            case 34: goto L_0x10e3;
            case 35: goto L_0x0322;
            case 36: goto L_0x0803;
            case 37: goto L_0x0322;
            case 38: goto L_0x0322;
            case 39: goto L_0x0322;
            case 40: goto L_0x1289;
            default: goto L_0x0322;
        };
    L_0x0322:
        r7 = 1;
        r12 = r6;
        r6 = r7;
    L_0x0325:
        if (r6 == 0) goto L_0x03af;
    L_0x0327:
        r0 = r22;
        r6 = r0.title;
        if (r6 == 0) goto L_0x129f;
    L_0x032d:
        r0 = r22;
        r6 = r0.title;
        r6 = r6.length();
        if (r6 <= 0) goto L_0x129f;
    L_0x0337:
        r0 = r21;
        r6 = r0.mys;
        r7 = 0;
        r6.setVisibility(r7);
        r0 = r21;
        r6 = r0.mys;
        r7 = 2;
        r6.setMaxLines(r7);
        r0 = r21;
        r6 = r0.mys;
        r0 = r22;
        r7 = r0.title;
        r6.setText(r7);
    L_0x0352:
        r0 = r21;
        r6 = r0.ipw;
        r7 = 8;
        r6.setVisibility(r7);
        if (r23 == 0) goto L_0x03af;
    L_0x035d:
        r0 = r22;
        r6 = r0.type;
        r7 = 33;
        if (r6 == r7) goto L_0x036d;
    L_0x0365:
        r0 = r22;
        r6 = r0.type;
        r7 = 36;
        if (r6 != r7) goto L_0x12aa;
    L_0x036d:
        r6 = com.tencent.mm.ah.n.GS();
        r0 = r30;
        r7 = r0.field_imgPath;
        r8 = r6.jv(r7);
        r0 = r21;
        r6 = r0.vyp;
        r7 = com.tencent.mm.R.k.dtu;
        r6.setImageResource(r7);
        r6 = com.tencent.mm.modelappbrand.a.b.AY();
        r0 = r21;
        r7 = r0.vyp;
        r9 = new java.lang.StringBuilder;
        r10 = "file://";
        r9.<init>(r10);
        r8 = r9.append(r8);
        r8 = r8.toString();
        r9 = 0;
        r10 = 0;
        r11 = com.tencent.mm.modelappbrand.h.class;
        r11 = com.tencent.mm.kernel.h.h(r11);
        r11 = (com.tencent.mm.modelappbrand.h) r11;
        r13 = 50;
        r14 = 50;
        r11 = r11.aL(r13, r14);
        r6.a(r7, r8, r9, r10, r11);
    L_0x03af:
        r0 = r29;
        r6 = r0.vxp;
        if (r6 != 0) goto L_0x1307;
    L_0x03b5:
        r6 = com.tencent.mm.pluginsdk.model.app.g.g(r25);
        if (r6 == 0) goto L_0x12fb;
    L_0x03bb:
        r0 = r21;
        r6 = r0.vyV;
        r7 = 0;
        r6.setVisibility(r7);
        r0 = r21;
        r6 = r0.vyV;
        r0 = r22;
        r1 = r30;
        r7 = com.tencent.mm.ui.chatting.dt.a(r0, r1);
        r0 = r29;
        com.tencent.mm.ui.chatting.ah.c(r0, r6, r7);
        r6 = r12;
    L_0x03d5:
        r0 = r21;
        r7 = r0.vzb;
        r7.setTag(r6);
        r0 = r21;
        r6 = r0.vzb;
        r0 = r29;
        r7 = r0.vBD;
        r7 = r7.vEW;
        r6.setOnClickListener(r7);
        r0 = r26;
        r6 = r0.sXW;
        if (r6 == 0) goto L_0x0409;
    L_0x03ef:
        r0 = r21;
        r6 = r0.vzb;
        r0 = r29;
        r7 = r0.vBD;
        r7 = r7.vEY;
        r6.setOnLongClickListener(r7);
        r0 = r21;
        r6 = r0.vzb;
        r0 = r29;
        r7 = r0.vBD;
        r7 = r7.vFa;
        r6.setOnTouchListener(r7);
    L_0x0409:
        return;
    L_0x040a:
        r8 = "MicroMsg.ChattingItemAppMsgFrom";
        r9 = "amessage, msgid:%s, user:%s";
        r10 = 2;
        r10 = new java.lang.Object[r10];
        r11 = 0;
        r0 = r30;
        r12 = r0.field_msgId;
        r12 = java.lang.Long.valueOf(r12);
        r10[r11] = r12;
        r11 = 1;
        r10[r11] = r31;
        com.tencent.mm.sdk.platformtools.w.e(r8, r9, r10);
        r14 = r6;
        r22 = r7;
        goto L_0x004b;
    L_0x0429:
        r7 = r7.hhm;
        goto L_0x0159;
    L_0x042d:
        r0 = r21;
        r7 = r0.vzb;
        r8 = com.tencent.mm.R.g.bdU;
        r7.setBackgroundResource(r8);
        goto L_0x016d;
    L_0x0438:
        r0 = r25;
        r7 = r0.field_appName;
        goto L_0x01a4;
    L_0x043e:
        r0 = r21;
        r7 = r0.lMU;
        r0 = r22;
        r8 = r0.appId;
        r0 = r29;
        com.tencent.mm.ui.chatting.ah.a(r0, r7, r8);
        goto L_0x0238;
    L_0x044d:
        r0 = r22;
        r7 = r0.type;
        r8 = 24;
        if (r7 != r8) goto L_0x0481;
    L_0x0455:
        r0 = r21;
        r7 = r0.lMU;
        r8 = com.tencent.mm.sdk.platformtools.ab.getContext();
        r9 = com.tencent.mm.R.l.ehy;
        r8 = r8.getString(r9);
        r7.setText(r8);
        r0 = r21;
        r7 = r0.vyO;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r21;
        r7 = r0.lMU;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r21;
        r7 = r0.vyL;
        r8 = 8;
        r7.setVisibility(r8);
        goto L_0x0245;
    L_0x0481:
        r0 = r22;
        r7 = r0.type;
        r8 = 19;
        if (r7 == r8) goto L_0x048f;
    L_0x0489:
        r7 = r14.hkp;
        r8 = 19;
        if (r7 != r8) goto L_0x04bb;
    L_0x048f:
        r0 = r21;
        r7 = r0.lMU;
        r8 = com.tencent.mm.sdk.platformtools.ab.getContext();
        r9 = com.tencent.mm.R.l.dUc;
        r8 = r8.getString(r9);
        r7.setText(r8);
        r0 = r21;
        r7 = r0.vyO;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r21;
        r7 = r0.lMU;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r21;
        r7 = r0.vyL;
        r8 = 8;
        r7.setVisibility(r8);
        goto L_0x0245;
    L_0x04bb:
        r0 = r21;
        r7 = r0.vyO;
        r8 = 8;
        r7.setVisibility(r8);
        r0 = r21;
        r7 = r0.lMU;
        r8 = 8;
        r7.setVisibility(r8);
        r0 = r21;
        r7 = r0.vyL;
        r8 = 8;
        r7.setVisibility(r8);
        goto L_0x0245;
    L_0x04d8:
        r7 = 0;
        goto L_0x0254;
    L_0x04db:
        r8 = 0;
        goto L_0x0278;
    L_0x04de:
        r7 = 1;
        goto L_0x02b7;
    L_0x04e1:
        r0 = r21;
        r8 = r0.vyp;
        r9 = r29.getResources();
        r10 = com.tencent.mm.R.g.bhO;
        r9 = android.graphics.BitmapFactory.decodeResource(r9, r10);
        r8.setImageBitmap(r9);
        r23 = r7;
        goto L_0x02d6;
    L_0x04f6:
        r0 = r21;
        r7 = r0.vyE;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r21;
        r7 = r0.vyE;
        r0 = r22;
        r8 = r0.gxD;
        r8 = com.tencent.mm.ui.chatting.dt.TF(r8);
        r0 = r29;
        com.tencent.mm.ui.chatting.ah.b(r0, r7, r8);
        goto L_0x02ef;
    L_0x0511:
        r0 = r22;
        r7 = r0.title;
        if (r7 == 0) goto L_0x05eb;
    L_0x0517:
        r0 = r22;
        r7 = r0.title;
        r7 = r7.length();
        if (r7 <= 0) goto L_0x05eb;
    L_0x0521:
        r0 = r21;
        r7 = r0.ipw;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r21;
        r7 = r0.ipw;
        r0 = r29;
        r8 = r0.uSU;
        r8 = r8.uTo;
        r8 = r8.getResources();
        r9 = com.tencent.mm.R.e.white;
        r8 = r8.getColor(r9);
        r7.setTextColor(r8);
    L_0x0540:
        r0 = r21;
        r7 = r0.ipx;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r21;
        r7 = r0.ipx;
        r0 = r29;
        r8 = r0.uSU;
        r8 = r8.uTo;
        r8 = r8.getResources();
        r9 = com.tencent.mm.R.e.white;
        r8 = r8.getColor(r9);
        r7.setTextColor(r8);
        r0 = r21;
        r7 = r0.mys;
        r8 = 8;
        r7.setVisibility(r8);
        r0 = r21;
        r7 = r0.vyP;
        r8 = 4;
        r7.setVisibility(r8);
        r0 = r21;
        r7 = r0.vyT;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r27;
        r8 = r0.vCb;
        r0 = r30;
        r10 = r0.field_msgId;
        r7 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));
        if (r7 != 0) goto L_0x05f6;
    L_0x0584:
        r0 = r21;
        r7 = r0.vyT;
        r8 = com.tencent.mm.R.g.bho;
        r7.setImageResource(r8);
    L_0x058d:
        r0 = r21;
        r7 = r0.ipx;
        r8 = 2;
        r7.setMaxLines(r8);
        if (r23 == 0) goto L_0x05bb;
    L_0x0597:
        r0 = r22;
        r7 = r0.appId;
        r8 = 1;
        r0 = r29;
        r9 = r0.uSU;
        r9 = r9.uTo;
        r9 = com.tencent.mm.bg.a.getDensity(r9);
        r7 = com.tencent.mm.pluginsdk.model.app.g.b(r7, r8, r9);
        if (r7 == 0) goto L_0x05b2;
    L_0x05ac:
        r8 = r7.isRecycled();
        if (r8 == 0) goto L_0x0600;
    L_0x05b2:
        r0 = r21;
        r7 = r0.vyp;
        r8 = com.tencent.mm.R.k.dtg;
        r7.setImageResource(r8);
    L_0x05bb:
        r7 = new com.tencent.mm.ui.chatting.cw$b;
        r7.<init>();
        r0 = r30;
        r8 = r0.field_msgId;
        r7.fGM = r8;
        r0 = r30;
        r8 = r0.field_content;
        r7.fQX = r8;
        r0 = r30;
        r8 = r0.field_imgPath;
        r7.fOa = r8;
        r0 = r21;
        r8 = r0.vyT;
        r8.setTag(r7);
        r0 = r21;
        r7 = r0.vyT;
        r0 = r29;
        r8 = r0.vBD;
        r8 = r8.vFg;
        r7.setOnClickListener(r8);
        r12 = r6;
        r6 = r24;
        goto L_0x0325;
    L_0x05eb:
        r0 = r21;
        r7 = r0.ipw;
        r8 = 8;
        r7.setVisibility(r8);
        goto L_0x0540;
    L_0x05f6:
        r0 = r21;
        r7 = r0.vyT;
        r8 = com.tencent.mm.R.g.bhp;
        r7.setImageResource(r8);
        goto L_0x058d;
    L_0x0600:
        r0 = r21;
        r8 = r0.vyp;
        r8.setImageBitmap(r7);
        goto L_0x05bb;
    L_0x0608:
        r0 = r22;
        r7 = r0.title;
        if (r7 == 0) goto L_0x0699;
    L_0x060e:
        r0 = r22;
        r7 = r0.title;
        r7 = r7.length();
        if (r7 <= 0) goto L_0x0699;
    L_0x0618:
        r0 = r21;
        r7 = r0.ipw;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r21;
        r7 = r0.ipw;
        r8 = 2;
        r7.setMaxLines(r8);
    L_0x0628:
        r0 = r21;
        r7 = r0.ipx;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r21;
        r7 = r0.mys;
        r8 = 8;
        r7.setVisibility(r8);
        r0 = r21;
        r7 = r0.vyT;
        r8 = 8;
        r7.setVisibility(r8);
        r0 = r21;
        r7 = r0.vyP;
        r8 = 4;
        r7.setVisibility(r8);
        r0 = r21;
        r7 = r0.ipx;
        r8 = 2;
        r7.setMaxLines(r8);
        r0 = r21;
        r7 = r0.ipx;
        r0 = r22;
        r8 = r0.hhq;
        r8 = (long) r8;
        r8 = com.tencent.mm.sdk.platformtools.bg.ay(r8);
        r7.setText(r8);
        r0 = r22;
        r7 = r0.hhq;
        r0 = r21;
        com.tencent.mm.ui.chatting.n.a(r0, r15, r7);
        r7 = 1;
        r7 = java.lang.Boolean.valueOf(r7);
        r0 = r22;
        r8 = r0.fCW;
        r0 = r22;
        r9 = r0.title;
        r0 = r21;
        r1 = r30;
        com.tencent.mm.ui.chatting.n.a(r0, r7, r1, r8, r9);
        if (r23 == 0) goto L_0x1313;
    L_0x0681:
        r0 = r22;
        r7 = r0.hhr;
        r7 = com.tencent.mm.sdk.platformtools.bg.Qm(r7);
        if (r7 == 0) goto L_0x06a3;
    L_0x068b:
        r0 = r21;
        r7 = r0.vyp;
        r8 = com.tencent.mm.R.g.bch;
        r7.setImageResource(r8);
        r12 = r6;
        r6 = r24;
        goto L_0x0325;
    L_0x0699:
        r0 = r21;
        r7 = r0.ipw;
        r8 = 8;
        r7.setVisibility(r8);
        goto L_0x0628;
    L_0x06a3:
        r0 = r21;
        r7 = r0.vyp;
        r0 = r22;
        r8 = r0.hhr;
        r8 = com.tencent.mm.pluginsdk.model.q.LV(r8);
        r7.setImageResource(r8);
        r12 = r6;
        r6 = r24;
        goto L_0x0325;
    L_0x06b7:
        r0 = r22;
        r7 = r0.title;
        if (r7 == 0) goto L_0x0735;
    L_0x06bd:
        r0 = r22;
        r7 = r0.title;
        r7 = r7.length();
        if (r7 <= 0) goto L_0x0735;
    L_0x06c7:
        r0 = r21;
        r7 = r0.ipw;
        r8 = 0;
        r7.setVisibility(r8);
    L_0x06cf:
        r0 = r21;
        r7 = r0.ipx;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r21;
        r7 = r0.mys;
        r8 = 8;
        r7.setVisibility(r8);
        r0 = r21;
        r7 = r0.vyT;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r21;
        r7 = r0.vyT;
        r8 = com.tencent.mm.R.g.bkW;
        r7.setImageResource(r8);
        r0 = r21;
        r7 = r0.vyP;
        r8 = 4;
        r7.setVisibility(r8);
        r0 = r21;
        r7 = r0.ipx;
        r8 = 2;
        r7.setMaxLines(r8);
        if (r23 == 0) goto L_0x1313;
    L_0x0703:
        r0 = r22;
        r7 = r0.appId;
        r8 = 1;
        r0 = r29;
        r9 = r0.uSU;
        r9 = r9.uTo;
        r9 = com.tencent.mm.bg.a.getDensity(r9);
        r7 = com.tencent.mm.pluginsdk.model.app.g.b(r7, r8, r9);
        if (r7 == 0) goto L_0x071e;
    L_0x0718:
        r8 = r7.isRecycled();
        if (r8 == 0) goto L_0x073f;
    L_0x071e:
        r0 = r21;
        r7 = r0.vyp;
        r8 = com.tencent.mm.R.k.dtr;
        r7.setImageResource(r8);
    L_0x0727:
        r0 = r21;
        r7 = r0.vyT;
        r8 = 8;
        r7.setVisibility(r8);
        r12 = r6;
        r6 = r24;
        goto L_0x0325;
    L_0x0735:
        r0 = r21;
        r7 = r0.ipw;
        r8 = 8;
        r7.setVisibility(r8);
        goto L_0x06cf;
    L_0x073f:
        r0 = r21;
        r8 = r0.vyp;
        r8.setImageBitmap(r7);
        goto L_0x0727;
    L_0x0747:
        r0 = r21;
        r7 = r0.ipw;
        r8 = 8;
        r7.setVisibility(r8);
        r0 = r22;
        r7 = r0.title;
        if (r7 == 0) goto L_0x07ed;
    L_0x0756:
        r0 = r22;
        r7 = r0.title;
        r7 = r7.length();
        if (r7 <= 0) goto L_0x07ed;
    L_0x0760:
        r0 = r21;
        r7 = r0.mys;
        r8 = 2;
        r7.setMaxLines(r8);
        r0 = r21;
        r7 = r0.mys;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r21;
        r7 = r0.mys;
        r8 = r22.getTitle();
        r7.setText(r8);
    L_0x077b:
        r0 = r21;
        r7 = r0.ipx;
        r8 = 3;
        r7.setMaxLines(r8);
        r0 = r21;
        r7 = r0.vyT;
        r8 = 8;
        r7.setVisibility(r8);
        r0 = r21;
        r7 = r0.vyP;
        r8 = 4;
        r7.setVisibility(r8);
        if (r23 == 0) goto L_0x1313;
    L_0x0796:
        r0 = r22;
        r7 = r0.appId;
        r8 = 1;
        r0 = r29;
        r9 = r0.uSU;
        r9 = r9.uTo;
        r9 = com.tencent.mm.bg.a.getDensity(r9);
        r7 = com.tencent.mm.pluginsdk.model.app.g.b(r7, r8, r9);
        if (r7 == 0) goto L_0x07b1;
    L_0x07ab:
        r8 = r7.isRecycled();
        if (r8 == 0) goto L_0x07f7;
    L_0x07b1:
        r7 = new com.tencent.mm.ah.a.a.c$a;
        r7.<init>();
        r8 = com.tencent.mm.R.k.dtu;
        r7.hJa = r8;
        r8 = com.tencent.mm.sdk.platformtools.ab.getContext();
        r9 = 50;
        r8 = com.tencent.mm.bg.a.fromDPToPix(r8, r9);
        r9 = com.tencent.mm.sdk.platformtools.ab.getContext();
        r10 = 50;
        r9 = com.tencent.mm.bg.a.fromDPToPix(r9, r10);
        r8 = r7.aO(r8, r9);
        r9 = 1;
        r8.hIJ = r9;
        r8 = com.tencent.mm.ah.n.GW();
        r0 = r22;
        r9 = r0.thumburl;
        r0 = r21;
        r10 = r0.vyp;
        r7 = r7.Hg();
        r8.a(r9, r10, r7);
        r12 = r6;
        r6 = r24;
        goto L_0x0325;
    L_0x07ed:
        r0 = r21;
        r7 = r0.mys;
        r8 = 8;
        r7.setVisibility(r8);
        goto L_0x077b;
    L_0x07f7:
        r0 = r21;
        r8 = r0.vyp;
        r8.setImageBitmap(r7);
        r12 = r6;
        r6 = r24;
        goto L_0x0325;
    L_0x0803:
        r7 = com.tencent.mm.plugin.appbrand.i.b.class;
        r7 = com.tencent.mm.kernel.h.h(r7);
        r7 = (com.tencent.mm.plugin.appbrand.i.b) r7;
        r0 = r22;
        r8 = r0.hjM;
        r9 = r7.og(r8);
        if (r9 == 0) goto L_0x08ba;
    L_0x0815:
        r7 = r9.field_nickname;
        r8 = r7;
    L_0x0818:
        if (r9 == 0) goto L_0x08c1;
    L_0x081a:
        r7 = r9.field_brandIconURL;
    L_0x081c:
        r0 = r21;
        r9 = r0.vzc;
        r10 = 8;
        r9.setVisibility(r10);
        r0 = r21;
        r9 = r0.vzn;
        r10 = 0;
        r9.setVisibility(r10);
        r0 = r21;
        r9 = r0.vzg;
        r10 = 8;
        r9.setVisibility(r10);
        r0 = r21;
        r9 = r0.vzj;
        r10 = 8;
        r9.setVisibility(r10);
        r0 = r21;
        r9 = r0.vzq;
        r0 = r22;
        r10 = r0.title;
        r9.setText(r10);
        r0 = r21;
        r9 = r0.vzj;
        r0 = r22;
        r10 = r0.description;
        r9.setText(r10);
        r0 = r21;
        r9 = r0.vzl;
        r9.setText(r8);
        r0 = r21;
        r8 = r0.vzm;
        r9 = com.tencent.mm.R.l.dDY;
        r8.setText(r9);
        r8 = com.tencent.mm.ah.n.GW();
        r0 = r21;
        r9 = r0.vzk;
        r0 = r26;
        r10 = r0.vCn;
        r8.a(r7, r9, r10);
        r7 = com.tencent.mm.ah.n.GS();
        r0 = r30;
        r8 = r0.field_imgPath;
        r9 = r7.jv(r8);
        r0 = r21;
        r7 = r0.vzo;
        r8 = 0;
        r7.setImageBitmap(r8);
        r7 = com.tencent.mm.modelappbrand.a.b.AY();
        r0 = r21;
        r8 = r0.vzo;
        r10 = new java.lang.StringBuilder;
        r11 = "file://";
        r10.<init>(r11);
        r9 = r10.append(r9);
        r9 = r9.toString();
        r10 = 0;
        r11 = 0;
        r12 = com.tencent.mm.modelappbrand.h.class;
        r12 = com.tencent.mm.kernel.h.h(r12);
        r12 = (com.tencent.mm.modelappbrand.h) r12;
        r13 = 215; // 0xd7 float:3.01E-43 double:1.06E-321;
        r14 = 168; // 0xa8 float:2.35E-43 double:8.3E-322;
        r12 = r12.aL(r13, r14);
        r7.a(r8, r9, r10, r11, r12);
        r12 = r6;
        r6 = r24;
        goto L_0x0325;
    L_0x08ba:
        r0 = r22;
        r7 = r0.fUS;
        r8 = r7;
        goto L_0x0818;
    L_0x08c1:
        r0 = r22;
        r7 = r0.hjV;
        goto L_0x081c;
    L_0x08c7:
        r7 = com.tencent.mm.plugin.appbrand.i.b.class;
        r7 = com.tencent.mm.kernel.h.h(r7);
        r7 = (com.tencent.mm.plugin.appbrand.i.b) r7;
        r0 = r22;
        r8 = r0.hjM;
        r9 = r7.og(r8);
        r0 = r22;
        r7 = r0.hjO;
        switch(r7) {
            case 1: goto L_0x09c7;
            case 2: goto L_0x08e3;
            case 3: goto L_0x08e3;
            default: goto L_0x08de;
        };
    L_0x08de:
        r7 = 1;
        r12 = r6;
        r6 = r7;
        goto L_0x0325;
    L_0x08e3:
        if (r9 == 0) goto L_0x09a5;
    L_0x08e5:
        r7 = r9.field_nickname;
        r8 = r7;
    L_0x08e8:
        if (r9 == 0) goto L_0x09ac;
    L_0x08ea:
        r7 = r9.field_brandIconURL;
    L_0x08ec:
        r0 = r21;
        r9 = r0.vzc;
        r10 = 8;
        r9.setVisibility(r10);
        r0 = r21;
        r9 = r0.vzn;
        r10 = 0;
        r9.setVisibility(r10);
        r0 = r21;
        r9 = r0.vzg;
        r10 = 8;
        r9.setVisibility(r10);
        r0 = r21;
        r9 = r0.vzj;
        r10 = 8;
        r9.setVisibility(r10);
        r0 = r21;
        r9 = r0.vzq;
        r0 = r22;
        r10 = r0.title;
        r9.setText(r10);
        r0 = r21;
        r9 = r0.vzj;
        r0 = r22;
        r10 = r0.description;
        r9.setText(r10);
        r0 = r21;
        r9 = r0.vzl;
        r9.setText(r8);
        r0 = r22;
        r8 = r0.hjT;
        switch(r8) {
            case 1: goto L_0x09b2;
            case 2: goto L_0x09bc;
            default: goto L_0x0933;
        };
    L_0x0933:
        r0 = r21;
        r8 = r0.vzm;
        r9 = com.tencent.mm.R.l.dDY;
        r8.setText(r9);
    L_0x093c:
        r8 = com.tencent.mm.ah.n.GW();
        r0 = r21;
        r9 = r0.vzk;
        r0 = r26;
        r10 = r0.vCn;
        r8.a(r7, r9, r10);
        r7 = com.tencent.mm.ah.n.GS();
        r0 = r30;
        r8 = r0.field_imgPath;
        r7 = r7.jv(r8);
        r0 = r21;
        r8 = r0.vzo;
        r9 = 0;
        r8.setImageBitmap(r9);
        r0 = r21;
        r8 = r0.vzo;
        r9 = 4;
        r8.setVisibility(r9);
        r0 = r21;
        r8 = r0.vzp;
        r9 = 0;
        r8.setVisibility(r9);
        r8 = com.tencent.mm.modelappbrand.a.b.AY();
        r9 = new com.tencent.mm.ui.chatting.as$2;
        r0 = r26;
        r1 = r21;
        r9.<init>(r0, r1);
        r10 = new java.lang.StringBuilder;
        r11 = "file://";
        r10.<init>(r11);
        r7 = r10.append(r7);
        r10 = r7.toString();
        r11 = 0;
        r7 = com.tencent.mm.modelappbrand.h.class;
        r7 = com.tencent.mm.kernel.h.h(r7);
        r7 = (com.tencent.mm.modelappbrand.h) r7;
        r12 = 215; // 0xd7 float:3.01E-43 double:1.06E-321;
        r13 = 168; // 0xa8 float:2.35E-43 double:8.3E-322;
        r7 = r7.aL(r12, r13);
        r8.a(r9, r10, r11, r7);
        r12 = r6;
        r6 = r24;
        goto L_0x0325;
    L_0x09a5:
        r0 = r22;
        r7 = r0.fUS;
        r8 = r7;
        goto L_0x08e8;
    L_0x09ac:
        r0 = r22;
        r7 = r0.hjV;
        goto L_0x08ec;
    L_0x09b2:
        r0 = r21;
        r8 = r0.vzm;
        r9 = com.tencent.mm.R.l.dGc;
        r8.setText(r9);
        goto L_0x093c;
    L_0x09bc:
        r0 = r21;
        r8 = r0.vzm;
        r9 = com.tencent.mm.R.l.dGb;
        r8.setText(r9);
        goto L_0x093c;
    L_0x09c7:
        if (r9 == 0) goto L_0x0a29;
    L_0x09c9:
        r7 = r9.field_nickname;
        r8 = r7;
    L_0x09cc:
        if (r9 == 0) goto L_0x0a2f;
    L_0x09ce:
        r7 = r9.field_brandIconURL;
    L_0x09d0:
        r0 = r21;
        r9 = r0.vzc;
        r10 = 8;
        r9.setVisibility(r10);
        r0 = r21;
        r9 = r0.vzn;
        r10 = 8;
        r9.setVisibility(r10);
        r0 = r21;
        r9 = r0.vzg;
        r10 = 0;
        r9.setVisibility(r10);
        r0 = r21;
        r9 = r0.vzi;
        r9.setText(r8);
        r8 = com.tencent.mm.sdk.platformtools.bg.mA(r7);
        if (r8 == 0) goto L_0x0a31;
    L_0x09f7:
        r7 = com.tencent.mm.ah.n.GS();
        r0 = r30;
        r8 = r0.field_imgPath;
        r7 = r7.jv(r8);
        r8 = com.tencent.mm.modelappbrand.a.b.AY();
        r0 = r21;
        r9 = r0.vzh;
        r10 = new java.lang.StringBuilder;
        r11 = "file://";
        r10.<init>(r11);
        r7 = r10.append(r7);
        r7 = r7.toString();
        r10 = com.tencent.mm.modelappbrand.a.a.AX();
        r11 = com.tencent.mm.modelappbrand.a.e.hqF;
        r8.a(r9, r7, r10, r11);
        r12 = r6;
        r6 = r24;
        goto L_0x0325;
    L_0x0a29:
        r0 = r22;
        r7 = r0.title;
        r8 = r7;
        goto L_0x09cc;
    L_0x0a2f:
        r7 = 0;
        goto L_0x09d0;
    L_0x0a31:
        r8 = com.tencent.mm.modelappbrand.a.b.AY();
        r0 = r21;
        r9 = r0.vzh;
        r10 = com.tencent.mm.modelappbrand.a.a.AX();
        r11 = com.tencent.mm.modelappbrand.a.e.hqF;
        r8.a(r9, r7, r10, r11);
        r12 = r6;
        r6 = r24;
        goto L_0x0325;
    L_0x0a47:
        r0 = r21;
        r7 = r0.ipw;
        r8 = 8;
        r7.setVisibility(r8);
        r0 = r22;
        r7 = r0.title;
        if (r7 == 0) goto L_0x0abb;
    L_0x0a56:
        r0 = r22;
        r7 = r0.title;
        r7 = r7.trim();
        r7 = r7.length();
        if (r7 <= 0) goto L_0x0abb;
    L_0x0a64:
        r0 = r21;
        r7 = r0.mys;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r21;
        r7 = r0.mys;
        r8 = r22.getTitle();
        r7.setText(r8);
    L_0x0a77:
        r0 = r21;
        r7 = r0.ipx;
        r8 = 3;
        r7.setMaxLines(r8);
        r0 = r21;
        r7 = r0.vyT;
        r8 = 8;
        r7.setVisibility(r8);
        r0 = r21;
        r7 = r0.vyP;
        r8 = 0;
        r7.setVisibility(r8);
        if (r23 == 0) goto L_0x1313;
    L_0x0a92:
        r0 = r22;
        r7 = r0.appId;
        r8 = 1;
        r0 = r29;
        r9 = r0.uSU;
        r9 = r9.uTo;
        r9 = com.tencent.mm.bg.a.getDensity(r9);
        r7 = com.tencent.mm.pluginsdk.model.app.g.b(r7, r8, r9);
        if (r7 == 0) goto L_0x0aad;
    L_0x0aa7:
        r8 = r7.isRecycled();
        if (r8 == 0) goto L_0x0ac5;
    L_0x0aad:
        r0 = r21;
        r7 = r0.vyp;
        r8 = com.tencent.mm.R.k.dtu;
        r7.setImageResource(r8);
        r12 = r6;
        r6 = r24;
        goto L_0x0325;
    L_0x0abb:
        r0 = r21;
        r7 = r0.mys;
        r8 = 8;
        r7.setVisibility(r8);
        goto L_0x0a77;
    L_0x0ac5:
        r0 = r21;
        r8 = r0.vyp;
        r8.setImageBitmap(r7);
        r12 = r6;
        r6 = r24;
        goto L_0x0325;
    L_0x0ad1:
        r0 = r21;
        r7 = r0.mys;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r22;
        r7 = r0.hhL;
        r8 = 1;
        if (r7 != r8) goto L_0x0b51;
    L_0x0ae0:
        r0 = r21;
        r7 = r0.mys;
        r8 = com.tencent.mm.R.l.ePa;
        r7.setText(r8);
    L_0x0ae9:
        r0 = r22;
        r7 = r0.title;
        if (r7 == 0) goto L_0x0b0c;
    L_0x0aef:
        r0 = r22;
        r7 = r0.title;
        r7 = r7.length();
        if (r7 <= 0) goto L_0x0b0c;
    L_0x0af9:
        r0 = r21;
        r7 = r0.ipw;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r21;
        r7 = r0.ipw;
        r8 = r22.getTitle();
        r7.setText(r8);
    L_0x0b0c:
        r0 = r21;
        r7 = r0.ipx;
        r8 = 4;
        r7.setMaxLines(r8);
        r0 = r21;
        r7 = r0.vyP;
        r8 = 4;
        r7.setVisibility(r8);
        r0 = r21;
        r7 = r0.vyT;
        r8 = 8;
        r7.setVisibility(r8);
        if (r23 == 0) goto L_0x1313;
    L_0x0b27:
        r7 = com.tencent.mm.ah.n.GS();
        r0 = r30;
        r8 = r0.field_imgPath;
        r0 = r29;
        r9 = r0.uSU;
        r9 = r9.uTo;
        r9 = com.tencent.mm.bg.a.getDensity(r9);
        r7 = r7.a(r8, r9);
        if (r7 == 0) goto L_0x0b7f;
    L_0x0b3f:
        r8 = r7.isRecycled();
        if (r8 != 0) goto L_0x0b7f;
    L_0x0b45:
        r0 = r21;
        r8 = r0.vyp;
        r8.setImageBitmap(r7);
        r12 = r6;
        r6 = r24;
        goto L_0x0325;
    L_0x0b51:
        r0 = r22;
        r7 = r0.hhL;
        r8 = 2;
        if (r7 != r8) goto L_0x0b62;
    L_0x0b58:
        r0 = r21;
        r7 = r0.mys;
        r8 = com.tencent.mm.R.l.ePc;
        r7.setText(r8);
        goto L_0x0ae9;
    L_0x0b62:
        r0 = r22;
        r7 = r0.hhL;
        r8 = 3;
        if (r7 != r8) goto L_0x0b74;
    L_0x0b69:
        r0 = r21;
        r7 = r0.mys;
        r8 = com.tencent.mm.R.l.ePb;
        r7.setText(r8);
        goto L_0x0ae9;
    L_0x0b74:
        r0 = r21;
        r7 = r0.mys;
        r8 = com.tencent.mm.R.l.ePd;
        r7.setText(r8);
        goto L_0x0ae9;
    L_0x0b7f:
        r0 = r21;
        r7 = r0.vyp;
        r8 = com.tencent.mm.R.k.dtu;
        r7.setImageResource(r8);
        r12 = r6;
        r6 = r24;
        goto L_0x0325;
    L_0x0b8d:
        r0 = r21;
        r7 = r0.ipw;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r21;
        r7 = r0.ipw;
        r8 = r22.getTitle();
        r7.setText(r8);
        r0 = r21;
        r7 = r0.mys;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r21;
        r7 = r0.mys;
        r8 = com.tencent.mm.R.l.ezQ;
        r7.setText(r8);
        r0 = r21;
        r7 = r0.ipx;
        r8 = 4;
        r7.setMaxLines(r8);
        r0 = r21;
        r7 = r0.vyP;
        r8 = 4;
        r7.setVisibility(r8);
        r0 = r21;
        r7 = r0.vyT;
        r8 = 8;
        r7.setVisibility(r8);
        if (r23 == 0) goto L_0x1313;
    L_0x0bcc:
        r7 = com.tencent.mm.ah.n.GS();
        r0 = r30;
        r8 = r0.field_imgPath;
        r0 = r29;
        r9 = r0.uSU;
        r9 = r9.uTo;
        r9 = com.tencent.mm.bg.a.getDensity(r9);
        r7 = r7.a(r8, r9);
        if (r7 == 0) goto L_0x0bf6;
    L_0x0be4:
        r8 = r7.isRecycled();
        if (r8 != 0) goto L_0x0bf6;
    L_0x0bea:
        r0 = r21;
        r8 = r0.vyp;
        r8.setImageBitmap(r7);
        r12 = r6;
        r6 = r24;
        goto L_0x0325;
    L_0x0bf6:
        r0 = r21;
        r7 = r0.vyp;
        r8 = com.tencent.mm.R.k.dtu;
        r7.setImageResource(r8);
        r12 = r6;
        r6 = r24;
        goto L_0x0325;
    L_0x0c04:
        r0 = r22;
        r7 = r0.title;
        if (r7 == 0) goto L_0x0c30;
    L_0x0c0a:
        r0 = r22;
        r7 = r0.title;
        r7 = r7.length();
        if (r7 <= 0) goto L_0x0c30;
    L_0x0c14:
        r0 = r21;
        r7 = r0.ipw;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r21;
        r7 = r0.ipw;
        r8 = r22.getTitle();
        r7.setText(r8);
        r0 = r21;
        r7 = r0.mys;
        r8 = 8;
        r7.setVisibility(r8);
    L_0x0c30:
        r0 = r21;
        r7 = r0.ipx;
        r8 = 4;
        r7.setMaxLines(r8);
        r0 = r21;
        r7 = r0.vyP;
        r8 = 4;
        r7.setVisibility(r8);
        r0 = r21;
        r7 = r0.vyT;
        r8 = 8;
        r7.setVisibility(r8);
        if (r23 == 0) goto L_0x1313;
    L_0x0c4b:
        r7 = com.tencent.mm.ah.n.GS();
        r0 = r30;
        r8 = r0.field_imgPath;
        r0 = r29;
        r9 = r0.uSU;
        r9 = r9.uTo;
        r9 = com.tencent.mm.bg.a.getDensity(r9);
        r7 = r7.a(r8, r9);
        if (r7 == 0) goto L_0x0c75;
    L_0x0c63:
        r8 = r7.isRecycled();
        if (r8 != 0) goto L_0x0c75;
    L_0x0c69:
        r0 = r21;
        r8 = r0.vyp;
        r8.setImageBitmap(r7);
        r12 = r6;
        r6 = r24;
        goto L_0x0325;
    L_0x0c75:
        r0 = r21;
        r7 = r0.vyp;
        r8 = com.tencent.mm.R.k.dtu;
        r7.setImageResource(r8);
        r12 = r6;
        r6 = r24;
        goto L_0x0325;
    L_0x0c83:
        r0 = r22;
        r7 = r0.title;
        if (r7 == 0) goto L_0x0cf0;
    L_0x0c89:
        r0 = r22;
        r7 = r0.title;
        r7 = r7.length();
        if (r7 <= 0) goto L_0x0cf0;
    L_0x0c93:
        r0 = r21;
        r7 = r0.ipw;
        r8 = 0;
        r7.setVisibility(r8);
    L_0x0c9b:
        r0 = r21;
        r7 = r0.ipx;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r21;
        r7 = r0.mys;
        r8 = 8;
        r7.setVisibility(r8);
        r0 = r21;
        r7 = r0.vyT;
        r8 = 8;
        r7.setVisibility(r8);
        r0 = r21;
        r7 = r0.vyP;
        r8 = 4;
        r7.setVisibility(r8);
        r0 = r21;
        r7 = r0.ipx;
        r8 = 2;
        r7.setMaxLines(r8);
        if (r23 == 0) goto L_0x1313;
    L_0x0cc7:
        r0 = r22;
        r7 = r0.appId;
        r8 = 1;
        r0 = r29;
        r9 = r0.uSU;
        r9 = r9.uTo;
        r9 = com.tencent.mm.bg.a.getDensity(r9);
        r7 = com.tencent.mm.pluginsdk.model.app.g.b(r7, r8, r9);
        if (r7 == 0) goto L_0x0ce2;
    L_0x0cdc:
        r8 = r7.isRecycled();
        if (r8 == 0) goto L_0x0cfa;
    L_0x0ce2:
        r0 = r21;
        r7 = r0.vyp;
        r8 = com.tencent.mm.R.k.dtu;
        r7.setImageResource(r8);
        r12 = r6;
        r6 = r24;
        goto L_0x0325;
    L_0x0cf0:
        r0 = r21;
        r7 = r0.ipw;
        r8 = 8;
        r7.setVisibility(r8);
        goto L_0x0c9b;
    L_0x0cfa:
        r0 = r21;
        r8 = r0.vyp;
        r8.setImageBitmap(r7);
        r12 = r6;
        r6 = r24;
        goto L_0x0325;
    L_0x0d06:
        r0 = r22;
        r6 = r0.title;
        if (r6 == 0) goto L_0x0daf;
    L_0x0d0c:
        r0 = r22;
        r6 = r0.title;
        r6 = r6.length();
        if (r6 <= 0) goto L_0x0daf;
    L_0x0d16:
        r0 = r21;
        r6 = r0.ipw;
        r7 = 0;
        r6.setVisibility(r7);
    L_0x0d1e:
        r0 = r21;
        r6 = r0.ipx;
        r7 = 0;
        r6.setVisibility(r7);
        r0 = r21;
        r6 = r0.mys;
        r7 = 8;
        r6.setVisibility(r7);
        r0 = r21;
        r6 = r0.vyT;
        r7 = 8;
        r6.setVisibility(r7);
        r0 = r21;
        r6 = r0.vyP;
        r7 = 4;
        r6.setVisibility(r7);
        r0 = r21;
        r6 = r0.ipx;
        r7 = 2;
        r6.setMaxLines(r7);
        if (r23 == 0) goto L_0x0d71;
    L_0x0d4a:
        r6 = com.tencent.mm.ah.n.GS();
        r0 = r30;
        r7 = r0.field_imgPath;
        r0 = r29;
        r8 = r0.uSU;
        r8 = r8.uTo;
        r8 = com.tencent.mm.bg.a.getDensity(r8);
        r6 = r6.a(r7, r8);
        if (r6 == 0) goto L_0x0d68;
    L_0x0d62:
        r7 = r6.isRecycled();
        if (r7 == 0) goto L_0x0dba;
    L_0x0d68:
        r0 = r21;
        r6 = r0.vyp;
        r7 = com.tencent.mm.R.k.dtu;
        r6.setImageResource(r7);
    L_0x0d71:
        r6 = new com.tencent.mm.ui.chatting.dt;
        r8 = 0;
        r10 = "";
        r11 = 8;
        r12 = 0;
        r0 = r22;
        r13 = r0.title;
        r0 = r22;
        r14 = r0.fUR;
        r0 = r22;
        r15 = r0.fUS;
        r0 = r22;
        r0 = r0.title;
        r16 = r0;
        r0 = r22;
        r0 = r0.hhT;
        r17 = r0;
        r0 = r22;
        r0 = r0.url;
        r18 = r0;
        r19 = 0;
        r20 = 0;
        r7 = r30;
        r9 = r28;
        r6.<init>(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20);
        r0 = r21;
        r7 = r0.vzb;
        r7.setTag(r6);
        r12 = r6;
        r6 = r24;
        goto L_0x0325;
    L_0x0daf:
        r0 = r21;
        r6 = r0.ipw;
        r7 = 8;
        r6.setVisibility(r7);
        goto L_0x0d1e;
    L_0x0dba:
        r0 = r21;
        r7 = r0.vyp;
        r7.setImageBitmap(r6);
        goto L_0x0d71;
    L_0x0dc2:
        r0 = r22;
        r6 = r0.title;
        if (r6 == 0) goto L_0x0e69;
    L_0x0dc8:
        r0 = r22;
        r6 = r0.title;
        r6 = r6.length();
        if (r6 <= 0) goto L_0x0e69;
    L_0x0dd2:
        r0 = r21;
        r6 = r0.ipw;
        r7 = 0;
        r6.setVisibility(r7);
    L_0x0dda:
        r0 = r21;
        r6 = r0.ipx;
        r7 = 0;
        r6.setVisibility(r7);
        r0 = r21;
        r6 = r0.mys;
        r7 = 8;
        r6.setVisibility(r7);
        r0 = r21;
        r6 = r0.vyT;
        r7 = 8;
        r6.setVisibility(r7);
        r0 = r21;
        r6 = r0.vyP;
        r7 = 4;
        r6.setVisibility(r7);
        r0 = r21;
        r6 = r0.ipx;
        r7 = 2;
        r6.setMaxLines(r7);
        if (r23 == 0) goto L_0x0e2d;
    L_0x0e06:
        r6 = com.tencent.mm.ah.n.GS();
        r0 = r30;
        r7 = r0.field_imgPath;
        r0 = r29;
        r8 = r0.uSU;
        r8 = r8.uTo;
        r8 = com.tencent.mm.bg.a.getDensity(r8);
        r6 = r6.a(r7, r8);
        if (r6 == 0) goto L_0x0e24;
    L_0x0e1e:
        r7 = r6.isRecycled();
        if (r7 == 0) goto L_0x0e74;
    L_0x0e24:
        r0 = r21;
        r6 = r0.vyp;
        r7 = com.tencent.mm.R.k.dtu;
        r6.setImageResource(r7);
    L_0x0e2d:
        r6 = new com.tencent.mm.ui.chatting.dt;
        r9 = "";
        r10 = r29.bVS();
        r0 = r22;
        r11 = r0.fUR;
        r0 = r22;
        r12 = r0.fUS;
        r0 = r22;
        r13 = r0.title;
        r0 = r22;
        r14 = r0.hjA;
        r0 = r22;
        r15 = r0.designerName;
        r0 = r22;
        r0 = r0.designerRediretctUrl;
        r16 = r0;
        r0 = r22;
        r0 = r0.url;
        r17 = r0;
        r7 = r30;
        r8 = r28;
        r6.<init>(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17);
        r0 = r21;
        r7 = r0.vzb;
        r7.setTag(r6);
        r12 = r6;
        r6 = r24;
        goto L_0x0325;
    L_0x0e69:
        r0 = r21;
        r6 = r0.ipw;
        r7 = 8;
        r6.setVisibility(r7);
        goto L_0x0dda;
    L_0x0e74:
        r0 = r21;
        r7 = r0.vyp;
        r7.setImageBitmap(r6);
        goto L_0x0e2d;
    L_0x0e7c:
        r0 = r22;
        r6 = r0.title;
        if (r6 == 0) goto L_0x0f4e;
    L_0x0e82:
        r0 = r22;
        r6 = r0.title;
        r6 = r6.length();
        if (r6 <= 0) goto L_0x0f4e;
    L_0x0e8c:
        r0 = r21;
        r6 = r0.ipw;
        r7 = 0;
        r6.setVisibility(r7);
    L_0x0e94:
        r0 = r21;
        r6 = r0.ipx;
        r7 = 0;
        r6.setVisibility(r7);
        r0 = r21;
        r6 = r0.mys;
        r7 = 8;
        r6.setVisibility(r7);
        r0 = r21;
        r6 = r0.vyT;
        r7 = 8;
        r6.setVisibility(r7);
        r0 = r21;
        r6 = r0.vyP;
        r7 = 4;
        r6.setVisibility(r7);
        r0 = r21;
        r6 = r0.ipx;
        r7 = 2;
        r6.setMaxLines(r7);
        if (r23 == 0) goto L_0x0ee7;
    L_0x0ec0:
        r6 = com.tencent.mm.ah.n.GS();
        r0 = r30;
        r7 = r0.field_imgPath;
        r0 = r29;
        r8 = r0.uSU;
        r8 = r8.uTo;
        r8 = com.tencent.mm.bg.a.getDensity(r8);
        r6 = r6.a(r7, r8);
        if (r6 == 0) goto L_0x0ede;
    L_0x0ed8:
        r7 = r6.isRecycled();
        if (r7 == 0) goto L_0x0f59;
    L_0x0ede:
        r0 = r21;
        r6 = r0.vyp;
        r7 = com.tencent.mm.R.k.dtu;
        r6.setImageResource(r7);
    L_0x0ee7:
        r6 = new com.tencent.mm.ui.chatting.dt;
        r6.<init>();
        r0 = r30;
        r6.fTk = r0;
        r7 = 0;
        r6.vxp = r7;
        r0 = r28;
        r6.position = r0;
        r7 = 0;
        r6.vMX = r7;
        r7 = r29.bVS();
        r6.title = r7;
        r0 = r22;
        r7 = r0.fUR;
        r6.fUR = r7;
        r0 = r22;
        r7 = r0.fUS;
        r6.fUS = r7;
        r0 = r22;
        r7 = r0.title;
        r6.vMY = r7;
        r0 = r22;
        r7 = r0.type;
        r8 = 26;
        if (r7 != r8) goto L_0x0f61;
    L_0x0f1a:
        r7 = 12;
        r6.knu = r7;
        r0 = r22;
        r7 = r0.tid;
        r6.tid = r7;
        r0 = r22;
        r7 = r0.hjB;
        r6.hjB = r7;
        r0 = r22;
        r7 = r0.desc;
        r6.desc = r7;
        r0 = r22;
        r7 = r0.iconUrl;
        r6.iconUrl = r7;
        r0 = r22;
        r7 = r0.secondUrl;
        r6.secondUrl = r7;
        r0 = r22;
        r7 = r0.pageType;
        r6.pageType = r7;
    L_0x0f42:
        r0 = r21;
        r7 = r0.vzb;
        r7.setTag(r6);
        r12 = r6;
        r6 = r24;
        goto L_0x0325;
    L_0x0f4e:
        r0 = r21;
        r6 = r0.ipw;
        r7 = 8;
        r6.setVisibility(r7);
        goto L_0x0e94;
    L_0x0f59:
        r0 = r21;
        r7 = r0.vyp;
        r7.setImageBitmap(r6);
        goto L_0x0ee7;
    L_0x0f61:
        r0 = r22;
        r7 = r0.type;
        r8 = 27;
        if (r7 != r8) goto L_0x0f42;
    L_0x0f69:
        r7 = 13;
        r6.knu = r7;
        r0 = r22;
        r7 = r0.tid;
        r6.tid = r7;
        r0 = r22;
        r7 = r0.hjB;
        r6.hjB = r7;
        r0 = r22;
        r7 = r0.desc;
        r6.desc = r7;
        r0 = r22;
        r7 = r0.iconUrl;
        r6.iconUrl = r7;
        r0 = r22;
        r7 = r0.secondUrl;
        r6.secondUrl = r7;
        r0 = r22;
        r7 = r0.pageType;
        r6.pageType = r7;
        goto L_0x0f42;
    L_0x0f92:
        r0 = r21;
        r7 = r0.ipw;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r21;
        r7 = r0.ipw;
        r0 = r22;
        r8 = r0.description;
        r7.setText(r8);
        r0 = r21;
        r7 = r0.ipx;
        r0 = r22;
        r8 = r0.hiz;
        r7.setText(r8);
        r0 = r22;
        r7 = r0.title;
        if (r7 == 0) goto L_0x1012;
    L_0x0fb6:
        r0 = r22;
        r7 = r0.title;
        r7 = r7.length();
        if (r7 <= 0) goto L_0x1012;
    L_0x0fc0:
        r0 = r21;
        r7 = r0.mys;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r21;
        r7 = r0.mys;
        r0 = r22;
        r8 = r0.title;
        r7.setText(r8);
    L_0x0fd3:
        r0 = r21;
        r7 = r0.ipx;
        r8 = 4;
        r7.setMaxLines(r8);
        r0 = r21;
        r7 = r0.vyP;
        r8 = 4;
        r7.setVisibility(r8);
        r0 = r21;
        r7 = r0.vyT;
        r8 = 8;
        r7.setVisibility(r8);
        if (r23 == 0) goto L_0x1313;
    L_0x0fee:
        r7 = com.tencent.mm.ah.n.GS();
        r0 = r30;
        r8 = r0.field_imgPath;
        r0 = r29;
        r9 = r0.uSU;
        r9 = r9.uTo;
        r9 = com.tencent.mm.bg.a.getDensity(r9);
        r7 = r7.a(r8, r9);
        if (r7 == 0) goto L_0x101c;
    L_0x1006:
        r0 = r21;
        r8 = r0.vyp;
        r8.setImageBitmap(r7);
        r12 = r6;
        r6 = r24;
        goto L_0x0325;
    L_0x1012:
        r0 = r21;
        r7 = r0.mys;
        r8 = 8;
        r7.setVisibility(r8);
        goto L_0x0fd3;
    L_0x101c:
        r0 = r21;
        r7 = r0.vyp;
        r8 = com.tencent.mm.R.k.dtu;
        r7.setImageResource(r8);
        r12 = r6;
        r6 = r24;
        goto L_0x0325;
    L_0x102a:
        r0 = r21;
        r7 = r0.ipw;
        r8 = 8;
        r7.setVisibility(r8);
        r0 = r21;
        r7 = r0.mys;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r22;
        r7 = r0.title;
        if (r7 == 0) goto L_0x10ad;
    L_0x1041:
        r0 = r22;
        r7 = r0.title;
        r7 = r7.trim();
        r7 = r7.length();
        if (r7 <= 0) goto L_0x10ad;
    L_0x104f:
        r0 = r21;
        r7 = r0.mys;
        r0 = r21;
        r8 = r0.mys;
        r8 = r8.getContext();
        r0 = r22;
        r9 = r0.title;
        r0 = r21;
        r10 = r0.mys;
        r10 = r10.getTextSize();
        r8 = com.tencent.mm.pluginsdk.ui.d.h.b(r8, r9, r10);
        r7.setText(r8);
    L_0x106e:
        r0 = r21;
        r7 = r0.ipx;
        r8 = 3;
        r7.setMaxLines(r8);
        r0 = r21;
        r7 = r0.vyT;
        r8 = 8;
        r7.setVisibility(r8);
        r0 = r21;
        r7 = r0.vyP;
        r8 = 4;
        r7.setVisibility(r8);
        if (r23 == 0) goto L_0x109b;
    L_0x1089:
        r0 = r21;
        r7 = r0.vyp;
        r8 = 8;
        r7.setVisibility(r8);
        r0 = r21;
        r7 = r0.vza;
        r8 = 8;
        r7.setVisibility(r8);
    L_0x109b:
        r0 = r29;
        r1 = r21;
        r2 = r22;
        r3 = r30;
        r4 = r23;
        com.tencent.mm.ui.chatting.n.a(r0, r1, r2, r3, r4);
        r12 = r6;
        r6 = r24;
        goto L_0x0325;
    L_0x10ad:
        r0 = r21;
        r7 = r0.mys;
        r0 = r21;
        r8 = r0.mys;
        r8 = r8.getContext();
        r9 = com.tencent.mm.sdk.platformtools.ab.getContext();
        r10 = com.tencent.mm.R.l.ejP;
        r9 = r9.getString(r10);
        r0 = r21;
        r10 = r0.mys;
        r10 = r10.getTextSize();
        r8 = com.tencent.mm.pluginsdk.ui.d.h.b(r8, r9, r10);
        r7.setText(r8);
        goto L_0x106e;
    L_0x10d3:
        r0 = r29;
        r1 = r21;
        r2 = r22;
        r3 = r23;
        com.tencent.mm.ui.chatting.n.a(r0, r1, r2, r3);
        r12 = r6;
        r6 = r24;
        goto L_0x0325;
    L_0x10e3:
        r0 = r22;
        r7 = r0.title;
        if (r7 == 0) goto L_0x1229;
    L_0x10e9:
        r0 = r22;
        r7 = r0.title;
        r7 = r7.length();
        if (r7 <= 0) goto L_0x1229;
    L_0x10f3:
        r0 = r21;
        r7 = r0.ipw;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r22;
        r7 = r0.hiI;
        r7 = com.tencent.mm.sdk.platformtools.bg.mA(r7);
        if (r7 != 0) goto L_0x1210;
    L_0x1105:
        r0 = r21;
        r7 = r0.ipw;
        r0 = r22;
        r8 = r0.hiI;
        r0 = r29;
        r9 = r0.uSU;
        r9 = r9.uTo;
        r9 = r9.getResources();
        r10 = com.tencent.mm.R.e.black;
        r9 = r9.getColor(r10);
        r8 = com.tencent.mm.sdk.platformtools.bg.aF(r8, r9);
        r7.setTextColor(r8);
    L_0x1124:
        r0 = r21;
        r7 = r0.ipx;
        r8 = 2;
        r7.setMaxLines(r8);
        r0 = r21;
        r7 = r0.ipx;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r22;
        r7 = r0.hiJ;
        r7 = com.tencent.mm.sdk.platformtools.bg.mA(r7);
        if (r7 != 0) goto L_0x1234;
    L_0x113e:
        r0 = r21;
        r7 = r0.ipx;
        r0 = r22;
        r8 = r0.hiJ;
        r0 = r29;
        r9 = r0.uSU;
        r9 = r9.uTo;
        r9 = r9.getResources();
        r10 = com.tencent.mm.R.e.aUf;
        r9 = r9.getColor(r10);
        r8 = com.tencent.mm.sdk.platformtools.bg.aF(r8, r9);
        r7.setTextColor(r8);
    L_0x115d:
        r0 = r21;
        r7 = r0.mys;
        r8 = 8;
        r7.setVisibility(r8);
        r0 = r21;
        r7 = r0.vyP;
        r8 = 4;
        r7.setVisibility(r8);
        r0 = r21;
        r7 = r0.vyT;
        r8 = 8;
        r7.setVisibility(r8);
        r0 = r21;
        r7 = r0.vyO;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r21;
        r7 = r0.lMU;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r22;
        r7 = r0.hiE;
        r7 = com.tencent.mm.sdk.platformtools.bg.mA(r7);
        if (r7 != 0) goto L_0x124d;
    L_0x1191:
        r0 = r21;
        r7 = r0.lMU;
        r0 = r22;
        r8 = r0.hiE;
        r7.setText(r8);
    L_0x119c:
        r0 = r26;
        r7 = r0.sXW;
        if (r7 == 0) goto L_0x1273;
    L_0x11a2:
        r7 = com.tencent.mm.ah.n.GS();
        r0 = r30;
        r8 = r0.field_imgPath;
        r0 = r29;
        r9 = r0.uSU;
        r9 = r9.uTo;
        r9 = com.tencent.mm.bg.a.getDensity(r9);
        r10 = 0;
        r7 = r7.a(r8, r9, r10);
        if (r7 == 0) goto L_0x11d4;
    L_0x11bb:
        r8 = r7.isRecycled();
        if (r8 != 0) goto L_0x11d4;
    L_0x11c1:
        r8 = 0;
        r9 = r7.getWidth();
        r9 = r9 / 2;
        r9 = (float) r9;
        r8 = com.tencent.mm.sdk.platformtools.d.a(r7, r8, r9);
        r0 = r21;
        r9 = r0.vyp;
        r9.setImageBitmap(r8);
    L_0x11d4:
        r0 = r22;
        r8 = r0.hiH;
        r8 = com.tencent.mm.sdk.platformtools.bg.mA(r8);
        if (r8 != 0) goto L_0x1258;
    L_0x11de:
        r7 = com.tencent.mm.ah.n.GW();
        r0 = r22;
        r8 = r0.hiH;
        r9 = new android.widget.ImageView;
        r0 = r29;
        r10 = r0.uSU;
        r10 = r10.uTo;
        r9.<init>(r10);
        r10 = new com.tencent.mm.ah.a.a.c$a;
        r10.<init>();
        r11 = 1;
        r10.hIL = r11;
        r10 = r10.Hg();
        r11 = new com.tencent.mm.ui.chatting.as$3;
        r0 = r26;
        r1 = r21;
        r2 = r29;
        r11.<init>(r0, r1, r2);
        r7.a(r8, r9, r10, r11);
        r12 = r6;
        r6 = r24;
        goto L_0x0325;
    L_0x1210:
        r0 = r21;
        r7 = r0.ipw;
        r0 = r29;
        r8 = r0.uSU;
        r8 = r8.uTo;
        r8 = r8.getResources();
        r9 = com.tencent.mm.R.e.black;
        r8 = r8.getColor(r9);
        r7.setTextColor(r8);
        goto L_0x1124;
    L_0x1229:
        r0 = r21;
        r7 = r0.ipw;
        r8 = 8;
        r7.setVisibility(r8);
        goto L_0x1124;
    L_0x1234:
        r0 = r21;
        r7 = r0.ipx;
        r0 = r29;
        r8 = r0.uSU;
        r8 = r8.uTo;
        r8 = r8.getResources();
        r9 = com.tencent.mm.R.e.aUf;
        r8 = r8.getColor(r9);
        r7.setTextColor(r8);
        goto L_0x115d;
    L_0x124d:
        r0 = r21;
        r7 = r0.lMU;
        r8 = com.tencent.mm.R.l.dUb;
        r7.setText(r8);
        goto L_0x119c;
    L_0x1258:
        r0 = r21;
        r8 = r0.vzc;
        r8 = r8.getViewTreeObserver();
        r9 = new com.tencent.mm.ui.chatting.as$4;
        r0 = r26;
        r1 = r21;
        r2 = r29;
        r9.<init>(r0, r1, r2, r7);
        r8.addOnPreDrawListener(r9);
        r12 = r6;
        r6 = r24;
        goto L_0x0325;
    L_0x1273:
        r0 = r21;
        r7 = r0.vyp;
        r8 = r29.getResources();
        r9 = com.tencent.mm.R.g.bhO;
        r8 = android.graphics.BitmapFactory.decodeResource(r8, r9);
        r7.setImageBitmap(r8);
        r12 = r6;
        r6 = r24;
        goto L_0x0325;
    L_0x1289:
        r7 = r14.hkp;
        r8 = 19;
        if (r7 != r8) goto L_0x1313;
    L_0x128f:
        r0 = r29;
        r1 = r21;
        r2 = r22;
        r3 = r23;
        com.tencent.mm.ui.chatting.n.a(r0, r1, r2, r3);
        r12 = r6;
        r6 = r24;
        goto L_0x0325;
    L_0x129f:
        r0 = r21;
        r6 = r0.mys;
        r7 = 8;
        r6.setVisibility(r7);
        goto L_0x0352;
    L_0x12aa:
        r6 = com.tencent.mm.ah.n.GS();
        r0 = r30;
        r7 = r0.field_imgPath;
        r0 = r29;
        r8 = r0.uSU;
        r8 = r8.uTo;
        r8 = com.tencent.mm.bg.a.getDensity(r8);
        r6 = r6.a(r7, r8);
        if (r6 == 0) goto L_0x12c8;
    L_0x12c2:
        r7 = r6.isRecycled();
        if (r7 == 0) goto L_0x12df;
    L_0x12c8:
        r6 = com.tencent.mm.ah.n.GS();
        r0 = r30;
        r7 = r0.field_imgPath;
        r0 = r29;
        r8 = r0.uSU;
        r8 = r8.uTo;
        r8 = com.tencent.mm.bg.a.getDensity(r8);
        r9 = 0;
        r6 = r6.a(r7, r8, r9);
    L_0x12df:
        if (r6 == 0) goto L_0x12f0;
    L_0x12e1:
        r7 = r6.isRecycled();
        if (r7 != 0) goto L_0x12f0;
    L_0x12e7:
        r0 = r21;
        r7 = r0.vyp;
        r7.setImageBitmap(r6);
        goto L_0x03af;
    L_0x12f0:
        r0 = r21;
        r6 = r0.vyp;
        r7 = com.tencent.mm.R.g.bch;
        r6.setImageResource(r7);
        goto L_0x03af;
    L_0x12fb:
        r0 = r21;
        r6 = r0.vyV;
        r7 = 8;
        r6.setVisibility(r7);
        r6 = r12;
        goto L_0x03d5;
    L_0x1307:
        r0 = r21;
        r6 = r0.vyV;
        r7 = 8;
        r6.setVisibility(r7);
        r6 = r12;
        goto L_0x03d5;
    L_0x1313:
        r12 = r6;
        r6 = r24;
        goto L_0x0325;
    L_0x1318:
        r15 = r6;
        goto L_0x0038;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.as.a(com.tencent.mm.ui.chatting.ah$a, int, com.tencent.mm.ui.chatting.En_5b8fbb1e$a, com.tencent.mm.storage.au, java.lang.String):void");
    }

    public final boolean a(ContextMenu contextMenu, View view, au auVar) {
        int i = ((dt) view.getTag()).position;
        int Mg = l.Mg(this.vCd.cQ(auVar.field_content, auVar.field_isSend));
        f.a ek = f.a.ek(this.vCd.cQ(auVar.field_content, auVar.field_isSend));
        com.tencent.mm.pluginsdk.model.app.f aJ = g.aJ(ek.appId, false);
        if (g.h(aJ) && !aa.ah(auVar)) {
            if (ek.type == 6) {
                com.tencent.mm.pluginsdk.model.app.b Mh = l.Mh(ek.fCW);
                if ((Mh == null || !d.c(auVar, Mh.field_fileFullPath)) && !auVar.bMt()) {
                    contextMenu.add(i, 111, 0, this.vCd.getString(R.l.eLH));
                }
            } else {
                contextMenu.add(i, 111, 0, this.vCd.getString(R.l.eLH));
            }
        }
        if (ek.hhq <= 0 || (ek.hhq > 0 && Mg >= 100)) {
            boolean Dn;
            switch (ek.type) {
                case 1:
                    Dn = e.Dn();
                    break;
                case 2:
                    Dn = e.Dp();
                    break;
                case 3:
                    Dn = e.Dy();
                    break;
                case 4:
                    Dn = e.Dq();
                    break;
                case 5:
                    Dn = e.Dw();
                    break;
                case 6:
                    Dn = e.Dx();
                    break;
                case 8:
                    Dn = e.Du();
                    break;
                case 16:
                    if (ek.hiA != 5 && ek.hiA != 6 && ek.hiA != 2) {
                        Dn = false;
                        break;
                    }
                    if (ek.hiA != 2) {
                        contextMenu.clear();
                    }
                    contextMenu.add(i, 100, 0, this.vCd.getString(R.l.dUp));
                    return false;
                case 34:
                    contextMenu.clear();
                    contextMenu.add(i, 100, 0, this.vCd.getString(R.l.dUp));
                    return false;
                default:
                    Dn = false;
                    break;
            }
            if (Dn && !this.vCd.bVJ()) {
                contextMenu.add(i, 114, 0, view.getContext().getString(R.l.dUl));
            }
        }
        if (d.Jt("favorite") && (aJ == null || !aJ.bCU())) {
            switch (ek.type) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 10:
                case 13:
                case 19:
                case 20:
                case 24:
                    contextMenu.add(i, 116, 0, view.getContext().getString(R.l.eGa));
                    break;
            }
        }
        com.tencent.mm.sdk.b.b ddVar = new dd();
        ddVar.fGW.fGM = auVar.field_msgId;
        com.tencent.mm.sdk.b.a.urY.m(ddVar);
        if (ddVar.fGX.fGu || d.a(this.vCd.uSU.uTo, ek)) {
            contextMenu.add(i, FileUtils.S_IWUSR, 0, view.getContext().getString(R.l.dUu));
        }
        if (!this.vCd.bVJ()) {
            contextMenu.add(i, 100, 0, this.vCd.getString(R.l.dUp));
        }
        return true;
    }

    public final boolean a(MenuItem menuItem, a aVar, au auVar) {
        f.a aVar2;
        switch (menuItem.getItemId()) {
            case 100:
                String str = auVar.field_content;
                aVar2 = null;
                if (str != null) {
                    aVar2 = f.a.ek(str);
                }
                if (aVar2 != null) {
                    l.ed(auVar.field_msgId);
                    if (19 == aVar2.type) {
                        com.tencent.mm.sdk.b.b lzVar = new lz();
                        lzVar.fTf.type = 3;
                        lzVar.fTf.fGM = auVar.field_msgId;
                        com.tencent.mm.sdk.b.a.urY.m(lzVar);
                    }
                }
                ay.L(auVar.field_msgId);
                com.tencent.mm.pluginsdk.model.app.f aJ = g.aJ(aVar2.appId, false);
                if (aJ != null && aJ.bCU()) {
                    ah.a(aVar, aVar2, auVar, aJ);
                    break;
                }
            case 111:
                d.a(aVar, auVar, a(aVar, auVar));
                break;
            case 114:
                String str2 = auVar.field_content;
                if (str2 != null) {
                    aVar2 = f.a.ek(str2);
                    if (aVar2 != null) {
                        switch (aVar2.type) {
                            case 1:
                                eh.k(aVar.cQ(auVar.field_content, auVar.field_isSend), aVar.uSU.uTo);
                                break;
                            case 2:
                                eh.a(auVar, aVar.uSU.uTo, a(aVar, auVar), aVar.vBH);
                                break;
                            case 3:
                                eh.a(auVar, aVar.cQ(auVar.field_content, auVar.field_isSend), aVar.uSU.uTo);
                                break;
                            case 4:
                                eh.a(auVar, aVar.uSU.uTo);
                                break;
                            case 5:
                                eh.c(auVar, aVar.cQ(auVar.field_content, auVar.field_isSend), aVar.uSU.uTo);
                                break;
                            case 6:
                                eh.b(auVar, aVar.cQ(auVar.field_content, auVar.field_isSend), aVar.uSU.uTo);
                                break;
                            case 8:
                                eh.b(auVar, aVar.uSU.uTo);
                                break;
                            default:
                                break;
                        }
                    }
                }
                break;
        }
        return false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(android.view.View r16, com.tencent.mm.ui.chatting.En_5b8fbb1e.a r17, com.tencent.mm.storage.au r18) {
        /*
        r15 = this;
        r2 = com.tencent.mm.modelstat.a.a.Click;
        r0 = r18;
        com.tencent.mm.modelstat.a.a(r0, r2);
        r0 = r18;
        r4 = r0.field_content;
        r2 = 0;
        r2 = java.lang.Boolean.valueOf(r2);
        if (r4 != 0) goto L_0x0014;
    L_0x0012:
        r2 = 0;
    L_0x0013:
        return r2;
    L_0x0014:
        r0 = r18;
        r3 = r0.field_isSend;
        r0 = r17;
        r3 = r0.cQ(r4, r3);
        r3 = com.tencent.mm.t.f.a.ek(r3);
        r4 = com.tencent.mm.t.j.eo(r4);
        if (r3 != 0) goto L_0x002a;
    L_0x0028:
        r2 = 0;
        goto L_0x0013;
    L_0x002a:
        r5 = r4.hkp;
        if (r5 == 0) goto L_0x0037;
    L_0x002e:
        r2 = 1;
        r2 = java.lang.Boolean.valueOf(r2);
        r4 = r4.hkp;
        r3.type = r4;
    L_0x0037:
        r8 = r2;
        r2 = r3.appId;
        r4 = 0;
        r5 = com.tencent.mm.pluginsdk.model.app.g.aJ(r2, r4);
        if (r5 == 0) goto L_0x0054;
    L_0x0041:
        r2 = r5.bCU();
        if (r2 == 0) goto L_0x0054;
    L_0x0047:
        r4 = com.tencent.mm.ui.chatting.ah.c(r17, r18);
        r0 = r18;
        r6 = r0.field_msgSvrId;
        r2 = r17;
        com.tencent.mm.ui.chatting.ah.a(r2, r3, r4, r5, r6);
    L_0x0054:
        r7 = 0;
        r2 = r3.type;
        switch(r2) {
            case 3: goto L_0x00b3;
            case 4: goto L_0x00cf;
            case 6: goto L_0x0140;
            case 7: goto L_0x0173;
            case 10: goto L_0x01cb;
            case 13: goto L_0x0257;
            case 16: goto L_0x02c3;
            case 19: goto L_0x028d;
            case 20: goto L_0x0211;
            case 24: goto L_0x0531;
            case 33: goto L_0x02fa;
            case 34: goto L_0x0556;
            case 36: goto L_0x0444;
            default: goto L_0x005a;
        };
    L_0x005a:
        r2 = 1;
    L_0x005b:
        if (r2 == 0) goto L_0x076d;
    L_0x005d:
        r2 = r3.url;
        if (r2 == 0) goto L_0x076d;
    L_0x0061:
        r2 = r3.url;
        r4 = "";
        r2 = r2.equals(r4);
        if (r2 != 0) goto L_0x076d;
    L_0x006c:
        r2 = r3.canvasPageXml;
        r2 = com.tencent.mm.sdk.platformtools.bg.mA(r2);
        if (r2 != 0) goto L_0x05b5;
    L_0x0074:
        r2 = new android.content.Intent;
        r2.<init>();
        r4 = "sns_landig_pages_from_source";
        r5 = 5;
        r2.putExtra(r4, r5);
        r4 = "msg_id";
        r0 = r18;
        r6 = r0.field_msgId;
        r2.putExtra(r4, r6);
        r4 = "sns_landing_pages_xml";
        r3 = r3.canvasPageXml;
        r2.putExtra(r4, r3);
        r3 = "sns_landing_pages_share_thumb_url";
        r0 = r18;
        r4 = r0.field_imgPath;
        r2.putExtra(r3, r4);
        r3 = 268435456; // 0x10000000 float:2.5243549E-29 double:1.32624737E-315;
        r2.addFlags(r3);
        r0 = r17;
        r3 = r0.uSU;
        r3 = r3.uTo;
        r4 = "sns";
        r5 = ".ui.SnsAdNativeLandingPagesPreviewUI";
        com.tencent.mm.bb.d.b(r3, r4, r5, r2);
        r2 = 1;
        goto L_0x0013;
    L_0x00b3:
        r2 = com.tencent.mm.plugin.report.service.g.oUh;
        r4 = 13043; // 0x32f3 float:1.8277E-41 double:6.444E-320;
        r5 = 3;
        r5 = new java.lang.Object[r5];
        r6 = 0;
        r7 = 2;
        r7 = java.lang.Integer.valueOf(r7);
        r5[r6] = r7;
        r6 = 1;
        r7 = r3.description;
        r5[r6] = r7;
        r6 = 2;
        r7 = r3.appId;
        r5[r6] = r7;
        r2.i(r4, r5);
    L_0x00cf:
        r0 = r17;
        r2 = r0.uSU;
        r2 = r2.uTo;
        r2 = com.tencent.mm.n.a.aJ(r2);
        if (r2 != 0) goto L_0x00e7;
    L_0x00db:
        r0 = r17;
        r2 = r0.uSU;
        r2 = r2.uTo;
        r2 = com.tencent.mm.n.a.aH(r2);
        if (r2 == 0) goto L_0x00f3;
    L_0x00e7:
        r2 = "MicroMsg.ChattingItemAppMsgFrom";
        r3 = "Voip is running, can't do this";
        com.tencent.mm.sdk.platformtools.w.i(r2, r3);
        r2 = 1;
        goto L_0x0013;
    L_0x00f3:
        r0 = r17;
        r1 = r18;
        r2 = r15.a(r0, r3, r1);
        if (r2 == 0) goto L_0x0100;
    L_0x00fd:
        r2 = 1;
        goto L_0x0013;
    L_0x0100:
        r2 = r3.url;
        r4 = "message";
        r4 = com.tencent.mm.pluginsdk.model.app.p.s(r2, r4);
        r2 = r3.hhp;
        r5 = "message";
        r5 = com.tencent.mm.pluginsdk.model.app.p.s(r2, r5);
        r0 = r17;
        r2 = r0.uSU;
        r2 = r2.uTo;
        r6 = r3.appId;
        r2 = com.tencent.mm.ui.chatting.ah.az(r2, r6);
        if (r2 != 0) goto L_0x013a;
    L_0x0120:
        r6 = 0;
    L_0x0121:
        if (r2 != 0) goto L_0x013d;
    L_0x0123:
        r7 = 0;
    L_0x0124:
        r8 = r3.appId;
        r9 = 1;
        r0 = r18;
        r10 = r0.field_msgId;
        r0 = r18;
        r12 = r0.field_msgSvrId;
        r2 = r15;
        r3 = r17;
        r14 = r18;
        r2.a(r3, r4, r5, r6, r7, r8, r9, r10, r12, r14);
        r2 = 1;
        goto L_0x0013;
    L_0x013a:
        r6 = r2.versionName;
        goto L_0x0121;
    L_0x013d:
        r7 = r2.versionCode;
        goto L_0x0124;
    L_0x0140:
        r2 = r15.sXW;
        if (r2 != 0) goto L_0x0150;
    L_0x0144:
        r0 = r17;
        r2 = r0.uSU;
        r2 = r2.uTo;
        com.tencent.mm.ui.base.s.eP(r2);
        r2 = 1;
        goto L_0x0013;
    L_0x0150:
        r2 = new android.content.Intent;
        r2.<init>();
        r0 = r17;
        r3 = r0.uSU;
        r3 = r3.uTo;
        r4 = "com.tencent.mm.ui.chatting.AppAttachDownloadUI";
        r2.setClassName(r3, r4);
        r3 = "app_msg_id";
        r0 = r18;
        r4 = r0.field_msgId;
        r2.putExtra(r3, r4);
        r0 = r17;
        r0.startActivity(r2);
        r2 = 1;
        goto L_0x0013;
    L_0x0173:
        if (r5 == 0) goto L_0x0186;
    L_0x0175:
        r2 = r5.bCU();
        if (r2 == 0) goto L_0x0186;
    L_0x017b:
        r0 = r17;
        r2 = com.tencent.mm.ui.chatting.ah.a(r0, r5);
        if (r2 == 0) goto L_0x0186;
    L_0x0183:
        r2 = 1;
        goto L_0x0013;
    L_0x0186:
        r2 = r3.fCW;
        if (r2 == 0) goto L_0x0192;
    L_0x018a:
        r2 = r3.fCW;
        r2 = r2.length();
        if (r2 != 0) goto L_0x0198;
    L_0x0192:
        r17.aw(r18);
    L_0x0195:
        r2 = 1;
        goto L_0x0013;
    L_0x0198:
        r2 = r15.sXW;
        if (r2 != 0) goto L_0x01a8;
    L_0x019c:
        r0 = r17;
        r2 = r0.uSU;
        r2 = r2.uTo;
        com.tencent.mm.ui.base.s.eP(r2);
        r2 = 1;
        goto L_0x0013;
    L_0x01a8:
        r2 = new android.content.Intent;
        r2.<init>();
        r0 = r17;
        r3 = r0.uSU;
        r3 = r3.uTo;
        r4 = "com.tencent.mm.ui.chatting.AppAttachDownloadUI";
        r2.setClassName(r3, r4);
        r3 = "app_msg_id";
        r0 = r18;
        r4 = r0.field_msgId;
        r2.putExtra(r3, r4);
        r3 = 210; // 0xd2 float:2.94E-43 double:1.04E-321;
        r0 = r17;
        r0.startActivityForResult(r2, r3);
        goto L_0x0195;
    L_0x01cb:
        r2 = r3.hhM;
        r2 = com.tencent.mm.sdk.platformtools.bg.mA(r2);
        if (r2 == 0) goto L_0x01d6;
    L_0x01d3:
        r2 = 0;
        goto L_0x0013;
    L_0x01d6:
        r2 = new android.content.Intent;
        r2.<init>();
        r4 = 65536; // 0x10000 float:9.18355E-41 double:3.2379E-319;
        r2.setFlags(r4);
        r4 = "key_Product_xml";
        r3 = r3.hhM;
        r2.putExtra(r4, r3);
        r3 = "key_ProductUI_getProductInfoScene";
        r4 = 1;
        r2.putExtra(r3, r4);
        r0 = r18;
        r3 = r0.field_imgPath;
        if (r3 != 0) goto L_0x01ff;
    L_0x01f5:
        r3 = "key_ProductUI_chatting_msgId";
        r0 = r18;
        r4 = r0.field_msgId;
        r2.putExtra(r3, r4);
    L_0x01ff:
        r0 = r17;
        r3 = r0.uSU;
        r3 = r3.uTo;
        r4 = "scanner";
        r5 = ".ui.ProductUI";
        com.tencent.mm.bb.d.b(r3, r4, r5, r2);
        r2 = 1;
        goto L_0x0013;
    L_0x0211:
        r2 = r3.hhP;
        r2 = com.tencent.mm.sdk.platformtools.bg.mA(r2);
        if (r2 == 0) goto L_0x021c;
    L_0x0219:
        r2 = 0;
        goto L_0x0013;
    L_0x021c:
        r2 = new android.content.Intent;
        r2.<init>();
        r4 = 65536; // 0x10000 float:9.18355E-41 double:3.2379E-319;
        r2.setFlags(r4);
        r4 = "key_TV_xml";
        r3 = r3.hhP;
        r2.putExtra(r4, r3);
        r3 = "key_TV_getProductInfoScene";
        r4 = 1;
        r2.putExtra(r3, r4);
        r0 = r18;
        r3 = r0.field_imgPath;
        if (r3 != 0) goto L_0x0245;
    L_0x023b:
        r3 = "key_TVInfoUI_chatting_msgId";
        r0 = r18;
        r4 = r0.field_msgId;
        r2.putExtra(r3, r4);
    L_0x0245:
        r0 = r17;
        r3 = r0.uSU;
        r3 = r3.uTo;
        r4 = "shake";
        r5 = ".ui.TVInfoUI";
        com.tencent.mm.bb.d.b(r3, r4, r5, r2);
        r2 = 1;
        goto L_0x0013;
    L_0x0257:
        r2 = r3.hhS;
        r2 = com.tencent.mm.sdk.platformtools.bg.mA(r2);
        if (r2 == 0) goto L_0x0262;
    L_0x025f:
        r2 = 0;
        goto L_0x0013;
    L_0x0262:
        r2 = new android.content.Intent;
        r2.<init>();
        r4 = 65536; // 0x10000 float:9.18355E-41 double:3.2379E-319;
        r2.setFlags(r4);
        r4 = "key_product_info";
        r3 = r3.hhS;
        r2.putExtra(r4, r3);
        r3 = "key_product_scene";
        r4 = 1;
        r2.putExtra(r3, r4);
        r0 = r17;
        r3 = r0.uSU;
        r3 = r3.uTo;
        r4 = "product";
        r5 = ".ui.MallProductUI";
        com.tencent.mm.bb.d.b(r3, r4, r5, r2);
        r2 = 1;
        goto L_0x0013;
    L_0x028d:
        r2 = new android.content.Intent;
        r2.<init>();
        r4 = "message_id";
        r0 = r18;
        r6 = r0.field_msgId;
        r2.putExtra(r4, r6);
        r4 = "record_xml";
        r3 = r3.hhQ;
        r2.putExtra(r4, r3);
        r3 = "big_appmsg";
        r2.putExtra(r3, r8);
        r0 = r17;
        r1 = r18;
        com.tencent.mm.ui.chatting.b.a(r2, r0, r1, r15);
        r0 = r17;
        r3 = r0.uSU;
        r3 = r3.uTo;
        r4 = "record";
        r5 = ".ui.RecordMsgDetailUI";
        com.tencent.mm.bb.d.b(r3, r4, r5, r2);
        r2 = 1;
        goto L_0x0013;
    L_0x02c3:
        r2 = r3.fNg;
        r2 = com.tencent.mm.sdk.platformtools.bg.mA(r2);
        if (r2 == 0) goto L_0x02ce;
    L_0x02cb:
        r2 = 0;
        goto L_0x0013;
    L_0x02ce:
        r2 = new android.content.Intent;
        r2.<init>();
        r4 = 65536; // 0x10000 float:9.18355E-41 double:3.2379E-319;
        r2.setFlags(r4);
        r4 = "key_card_app_msg";
        r5 = r3.fNg;
        r2.putExtra(r4, r5);
        r4 = "key_from_scene";
        r3 = r3.hiA;
        r2.putExtra(r4, r3);
        r0 = r17;
        r3 = r0.uSU;
        r3 = r3.uTo;
        r4 = "card";
        r5 = ".ui.CardDetailUI";
        com.tencent.mm.bb.d.b(r3, r4, r5, r2);
        r2 = 1;
        goto L_0x0013;
    L_0x02fa:
        r2 = "MicroMsg.ChattingItemAppMsgFrom";
        r4 = "username: %s , path: %s ,appid %s ,url : %s, pkgType : %s, md5 : %s";
        r5 = 6;
        r5 = new java.lang.Object[r5];
        r6 = 0;
        r8 = r3.hjM;
        r5[r6] = r8;
        r6 = 1;
        r8 = r3.hjL;
        r5[r6] = r8;
        r6 = 2;
        r8 = r3.hjN;
        r5[r6] = r8;
        r6 = 3;
        r8 = r3.url;
        r5[r6] = r8;
        r6 = 4;
        r8 = r3.hjT;
        r8 = java.lang.Integer.valueOf(r8);
        r5[r6] = r8;
        r6 = 5;
        r8 = r3.hjP;
        r5[r6] = r8;
        com.tencent.mm.sdk.platformtools.w.i(r2, r4, r5);
        r8 = r17.bUg();
        r0 = r17;
        r1 = r18;
        r9 = r15.a(r0, r1);
        r6 = new android.os.Bundle;
        r6.<init>();
        r0 = r17;
        r2 = r0 instanceof com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.a;
        if (r2 == 0) goto L_0x037d;
    L_0x033f:
        r4 = "stat_scene";
        r2 = 10;
        r5 = r6;
    L_0x0345:
        r5.putInt(r4, r2);
        r2 = "stat_msg_id";
        r4 = new java.lang.StringBuilder;
        r5 = "msg_";
        r4.<init>(r5);
        r0 = r18;
        r10 = r0.field_msgSvrId;
        r5 = java.lang.Long.toString(r10);
        r4 = r4.append(r5);
        r4 = r4.toString();
        r6.putString(r2, r4);
        r2 = "stat_chat_talker_username";
        r6.putString(r2, r8);
        r2 = "stat_send_msg_user";
        r6.putString(r2, r9);
        r2 = r3.hjO;
        switch(r2) {
            case 1: goto L_0x0398;
            case 2: goto L_0x0414;
            case 3: goto L_0x043a;
            default: goto L_0x0377;
        };
    L_0x0377:
        r2 = 1;
    L_0x0378:
        if (r2 != 0) goto L_0x005b;
    L_0x037a:
        r2 = 1;
        goto L_0x0013;
    L_0x037d:
        r0 = r17;
        r2 = r0.vBH;
        if (r2 == 0) goto L_0x0389;
    L_0x0383:
        r4 = "stat_scene";
        r2 = 2;
        r5 = r6;
        goto L_0x0345;
    L_0x0389:
        r4 = "stat_scene";
        r2 = com.tencent.mm.u.o.eV(r8);
        if (r2 == 0) goto L_0x0395;
    L_0x0392:
        r2 = 7;
        r5 = r6;
        goto L_0x0345;
    L_0x0395:
        r2 = 1;
        r5 = r6;
        goto L_0x0345;
    L_0x0398:
        r2 = new android.content.Intent;
        r2.<init>();
        r4 = "key_username";
        r5 = r3.hjM;
        r2.putExtra(r4, r5);
        r0 = r17;
        r4 = r0.vBH;
        if (r4 == 0) goto L_0x0406;
    L_0x03ab:
        r4 = "key_from_scene";
        r5 = 1;
        r2.putExtra(r4, r5);
        r4 = "key_scene_note";
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r5 = r5.append(r8);
        r8 = ":";
        r5 = r5.append(r8);
        r5 = r5.append(r9);
        r5 = r5.toString();
        r2.putExtra(r4, r5);
    L_0x03d0:
        r4 = new com.tencent.mm.plugin.appbrand.config.WxaExposedParams$a;
        r4.<init>();
        r5 = r3.hjN;
        r4.appId = r5;
        r5 = 6;
        r4.fFr = r5;
        r5 = r3.hjT;
        r4.izV = r5;
        r5 = r3.hjQ;
        r4.izW = r5;
        r5 = "key_scene_exposed_params";
        r4 = r4.RL();
        r2.putExtra(r5, r4);
        r4 = "_stat_obj";
        r2.putExtra(r4, r6);
        r0 = r17;
        r4 = r0.uSU;
        r4 = r4.uTo;
        r5 = "appbrand";
        r6 = ".ui.AppBrandProfileUI";
        com.tencent.mm.bb.d.b(r4, r5, r6, r2);
        r2 = r7;
        goto L_0x0378;
    L_0x0406:
        r4 = "key_from_scene";
        r5 = 2;
        r2.putExtra(r4, r5);
        r4 = "key_scene_note";
        r2.putExtra(r4, r8);
        goto L_0x03d0;
    L_0x0414:
        r0 = r17;
        r2 = r0 instanceof com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.a;
        if (r2 == 0) goto L_0x0422;
    L_0x041a:
        r2 = 1073; // 0x431 float:1.504E-42 double:5.3E-321;
        com.tencent.mm.modelappbrand.a.a(r8, r2, r3, r6);
        r2 = r7;
        goto L_0x0378;
    L_0x0422:
        r2 = com.tencent.mm.u.o.eV(r8);
        if (r2 == 0) goto L_0x0430;
    L_0x0428:
        r2 = 1074; // 0x432 float:1.505E-42 double:5.306E-321;
        com.tencent.mm.modelappbrand.a.a(r8, r2, r3, r6);
        r2 = r7;
        goto L_0x0378;
    L_0x0430:
        r0 = r17;
        r2 = r0.vBH;
        com.tencent.mm.modelappbrand.a.c(r8, r9, r2, r3, r6);
        r2 = r7;
        goto L_0x0378;
    L_0x043a:
        r0 = r17;
        r2 = r0.vBH;
        com.tencent.mm.modelappbrand.a.d(r8, r9, r2, r3, r6);
        r2 = r7;
        goto L_0x0378;
    L_0x0444:
        r2 = r3.hjN;
        r2 = com.tencent.mm.sdk.platformtools.bg.mA(r2);
        if (r2 == 0) goto L_0x0494;
    L_0x044c:
        r2 = r3.hjM;
        r2 = com.tencent.mm.sdk.platformtools.bg.mA(r2);
        if (r2 == 0) goto L_0x0494;
    L_0x0454:
        r4 = r3.url;
        r0 = r17;
        r2 = r0.vBH;
        if (r2 == 0) goto L_0x0490;
    L_0x045c:
        r2 = "groupmessage";
    L_0x045f:
        r2 = com.tencent.mm.pluginsdk.model.app.p.s(r4, r2);
        r4 = new android.content.Intent;
        r4.<init>();
        r5 = "rawUrl";
        r4.putExtra(r5, r2);
        r2 = "webpageTitle";
        r5 = r3.title;
        r4.putExtra(r2, r5);
        r2 = "shortUrl";
        r3 = r3.url;
        r4.putExtra(r2, r3);
        r0 = r17;
        r2 = r0.uSU;
        r2 = r2.uTo;
        r3 = "webview";
        r5 = ".ui.tools.WebViewUI";
        com.tencent.mm.bb.d.b(r2, r3, r5, r4);
        r2 = 1;
        goto L_0x0013;
    L_0x0490:
        r2 = "singlemessage";
        goto L_0x045f;
    L_0x0494:
        r7 = r17.bUg();
        r0 = r17;
        r1 = r18;
        r8 = r15.a(r0, r1);
        r6 = new android.os.Bundle;
        r6.<init>();
        r0 = r17;
        r2 = r0.vBH;
        if (r2 == 0) goto L_0x050e;
    L_0x04ab:
        r4 = "stat_scene";
        r2 = 2;
        r5 = r6;
    L_0x04b0:
        r5.putInt(r4, r2);
        r2 = "stat_msg_id";
        r4 = new java.lang.StringBuilder;
        r5 = "msg_";
        r4.<init>(r5);
        r0 = r18;
        r10 = r0.field_msgSvrId;
        r5 = java.lang.Long.toString(r10);
        r4 = r4.append(r5);
        r4 = r4.toString();
        r6.putString(r2, r4);
        r2 = "stat_chat_talker_username";
        r6.putString(r2, r7);
        r2 = "stat_send_msg_user";
        r6.putString(r2, r8);
        r2 = r3.hjS;
        r2 = com.tencent.mm.sdk.platformtools.bg.mA(r2);
        r4 = "MicroMsg.ChattingItemAppMsgFrom";
        r5 = "withShareTicket = %b";
        r7 = 1;
        r7 = new java.lang.Object[r7];
        r8 = 0;
        r9 = java.lang.Boolean.valueOf(r2);
        r7[r8] = r9;
        com.tencent.mm.sdk.platformtools.w.i(r4, r5, r7);
        if (r2 == 0) goto L_0x051d;
    L_0x04f8:
        r2 = r17.bUg();
        r0 = r17;
        r1 = r18;
        r4 = r15.a(r0, r1);
        r0 = r17;
        r5 = r0.vBH;
        com.tencent.mm.modelappbrand.a.b(r2, r4, r5, r3, r6);
    L_0x050b:
        r2 = 1;
        goto L_0x0013;
    L_0x050e:
        r4 = "stat_scene";
        r2 = com.tencent.mm.u.o.eV(r7);
        if (r2 == 0) goto L_0x051a;
    L_0x0517:
        r2 = 7;
        r5 = r6;
        goto L_0x04b0;
    L_0x051a:
        r2 = 1;
        r5 = r6;
        goto L_0x04b0;
    L_0x051d:
        r2 = r17.bUg();
        r0 = r17;
        r1 = r18;
        r4 = r15.a(r0, r1);
        r0 = r17;
        r5 = r0.vBH;
        com.tencent.mm.modelappbrand.a.a(r2, r4, r5, r3, r6);
        goto L_0x050b;
    L_0x0531:
        r2 = new com.tencent.mm.e.a.kq;
        r2.<init>();
        r4 = r2.fRi;
        r0 = r17;
        r5 = r0.uSU;
        r5 = r5.uTo;
        r4.context = r5;
        r4 = r2.fRi;
        r0 = r18;
        r6 = r0.field_msgId;
        r4.fGM = r6;
        r4 = r2.fRi;
        r3 = r3.hhQ;
        r4.fRj = r3;
        r3 = com.tencent.mm.sdk.b.a.urY;
        r3.m(r2);
        r2 = 1;
        goto L_0x0013;
    L_0x0556:
        r2 = new android.content.Intent;
        r2.<init>();
        r4 = "key_from_user_name";
        r0 = r17;
        r1 = r18;
        r5 = r15.a(r0, r1);
        r2.putExtra(r4, r5);
        r4 = "key_biz_uin";
        r5 = r3.hiC;
        r2.putExtra(r4, r5);
        r4 = "key_order_id";
        r3 = r3.hiD;
        r2.putExtra(r4, r3);
        r0 = r18;
        r3 = r0.field_talker;
        if (r3 == 0) goto L_0x05a3;
    L_0x057f:
        r0 = r18;
        r3 = r0.field_talker;
        r4 = "";
        r3 = r3.equals(r4);
        if (r3 != 0) goto L_0x05a3;
    L_0x058c:
        r0 = r18;
        r3 = r0.field_talker;
        r4 = "@chatroom";
        r3 = r3.endsWith(r4);
        if (r3 == 0) goto L_0x05a3;
    L_0x0599:
        r3 = "key_chatroom_name";
        r0 = r18;
        r4 = r0.field_talker;
        r2.putExtra(r3, r4);
    L_0x05a3:
        r0 = r17;
        r3 = r0.uSU;
        r3 = r3.uTo;
        r4 = "card";
        r5 = ".ui.CardGiftAcceptUI";
        com.tencent.mm.bb.d.b(r3, r4, r5, r2);
        r2 = 1;
        goto L_0x0013;
    L_0x05b5:
        r4 = r3.url;
        r0 = r17;
        r2 = r0.vBH;
        if (r2 == 0) goto L_0x0750;
    L_0x05bd:
        r2 = "groupmessage";
    L_0x05c0:
        r2 = com.tencent.mm.pluginsdk.model.app.p.s(r4, r2);
        r4 = r3.url;
        r0 = r17;
        r5 = r0.uSU;
        r5 = r5.uTo;
        r6 = r3.appId;
        r5 = com.tencent.mm.ui.chatting.ah.az(r5, r6);
        r6 = new android.content.Intent;
        r6.<init>();
        r7 = "rawUrl";
        r6.putExtra(r7, r2);
        r2 = "webpageTitle";
        r7 = r3.title;
        r6.putExtra(r2, r7);
        r2 = r3.appId;
        if (r2 == 0) goto L_0x061d;
    L_0x05e9:
        r2 = "wx751a1acca5688ba3";
        r7 = r3.appId;
        r2 = r2.equals(r7);
        if (r2 != 0) goto L_0x060a;
    L_0x05f4:
        r2 = "wxfbc915ff7c30e335";
        r7 = r3.appId;
        r2 = r2.equals(r7);
        if (r2 != 0) goto L_0x060a;
    L_0x05ff:
        r2 = "wx482a4001c37e2b74";
        r7 = r3.appId;
        r2 = r2.equals(r7);
        if (r2 == 0) goto L_0x061d;
    L_0x060a:
        r2 = new android.os.Bundle;
        r2.<init>();
        r7 = "jsapi_args_appid";
        r8 = r3.appId;
        r2.putString(r7, r8);
        r7 = "jsapiargs";
        r6.putExtra(r7, r2);
    L_0x061d:
        r2 = com.tencent.mm.sdk.platformtools.bg.mA(r4);
        if (r2 != 0) goto L_0x0755;
    L_0x0623:
        r2 = "shortUrl";
        r6.putExtra(r2, r4);
    L_0x0629:
        r4 = "version_name";
        if (r5 != 0) goto L_0x075f;
    L_0x062e:
        r2 = 0;
    L_0x062f:
        r6.putExtra(r4, r2);
        r4 = "version_code";
        if (r5 != 0) goto L_0x0763;
    L_0x0637:
        r2 = 0;
    L_0x0638:
        r6.putExtra(r4, r2);
        r2 = r3.fUR;
        r2 = com.tencent.mm.sdk.platformtools.bg.mA(r2);
        if (r2 != 0) goto L_0x0653;
    L_0x0643:
        r2 = "srcUsername";
        r4 = r3.fUR;
        r6.putExtra(r2, r4);
        r2 = "srcDisplayname";
        r4 = r3.fUS;
        r6.putExtra(r2, r4);
    L_0x0653:
        r2 = "msg_id";
        r0 = r18;
        r4 = r0.field_msgId;
        r6.putExtra(r2, r4);
        r2 = "KPublisherId";
        r4 = new java.lang.StringBuilder;
        r5 = "msg_";
        r4.<init>(r5);
        r0 = r18;
        r8 = r0.field_msgSvrId;
        r5 = java.lang.Long.toString(r8);
        r4 = r4.append(r5);
        r4 = r4.toString();
        r6.putExtra(r2, r4);
        r2 = "KAppId";
        r4 = r3.appId;
        r6.putExtra(r2, r4);
        r2 = "geta8key_username";
        r4 = r17.bUg();
        r6.putExtra(r2, r4);
        r2 = "pre_username";
        r0 = r17;
        r1 = r18;
        r4 = r15.a(r0, r1);
        r6.putExtra(r2, r4);
        r2 = "from_scence";
        r4 = 2;
        r6.putExtra(r2, r4);
        r2 = "expid_str";
        r0 = r18;
        r4 = r0.gxO;
        r6.putExtra(r2, r4);
        r0 = r17;
        r1 = r18;
        r2 = r15.a(r0, r1);
        r4 = r17.bUg();
        r2 = com.tencent.mm.u.p.G(r2, r4);
        r4 = "prePublishId";
        r5 = new java.lang.StringBuilder;
        r7 = "msg_";
        r5.<init>(r7);
        r0 = r18;
        r8 = r0.field_msgSvrId;
        r7 = java.lang.Long.toString(r8);
        r5 = r5.append(r7);
        r5 = r5.toString();
        r6.putExtra(r4, r5);
        r4 = "preUsername";
        r0 = r17;
        r1 = r18;
        r5 = r15.a(r0, r1);
        r6.putExtra(r4, r5);
        r4 = "preChatName";
        r5 = r17.bUg();
        r6.putExtra(r4, r5);
        r4 = "preChatTYPE";
        r6.putExtra(r4, r2);
        r4 = "preMsgIndex";
        r5 = 0;
        r6.putExtra(r4, r5);
        switch(r2) {
            case 1: goto L_0x0769;
            case 2: goto L_0x0767;
            case 3: goto L_0x0702;
            case 4: goto L_0x0702;
            case 5: goto L_0x0702;
            case 6: goto L_0x076b;
            case 7: goto L_0x076b;
            default: goto L_0x0702;
        };
    L_0x0702:
        r2 = 0;
    L_0x0703:
        r4 = "share_report_pre_msg_url";
        r5 = r3.url;
        r6.putExtra(r4, r5);
        r4 = "share_report_pre_msg_title";
        r5 = r3.title;
        r6.putExtra(r4, r5);
        r4 = "share_report_pre_msg_desc";
        r5 = r3.description;
        r6.putExtra(r4, r5);
        r4 = "share_report_pre_msg_icon_url";
        r5 = r3.thumburl;
        r6.putExtra(r4, r5);
        r4 = "share_report_pre_msg_appid";
        r3 = r3.appId;
        r6.putExtra(r4, r3);
        r3 = "share_report_from_scene";
        r6.putExtra(r3, r2);
        r3 = 5;
        if (r2 != r3) goto L_0x073e;
    L_0x0734:
        r2 = "share_report_biz_username";
        r3 = r17.bUg();
        r6.putExtra(r2, r3);
    L_0x073e:
        r0 = r17;
        r2 = r0.uSU;
        r2 = r2.uTo;
        r3 = "webview";
        r4 = ".ui.tools.WebViewUI";
        com.tencent.mm.bb.d.b(r2, r3, r4, r6);
        r2 = 1;
        goto L_0x0013;
    L_0x0750:
        r2 = "singlemessage";
        goto L_0x05c0;
    L_0x0755:
        r2 = "shortUrl";
        r4 = r3.url;
        r6.putExtra(r2, r4);
        goto L_0x0629;
    L_0x075f:
        r2 = r5.versionName;
        goto L_0x062f;
    L_0x0763:
        r2 = r5.versionCode;
        goto L_0x0638;
    L_0x0767:
        r2 = 2;
        goto L_0x0703;
    L_0x0769:
        r2 = 3;
        goto L_0x0703;
    L_0x076b:
        r2 = 5;
        goto L_0x0703;
    L_0x076d:
        r2 = 0;
        goto L_0x0013;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.as.a(android.view.View, com.tencent.mm.ui.chatting.En_5b8fbb1e$a, com.tencent.mm.storage.au):boolean");
    }
}
