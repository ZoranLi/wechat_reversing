package com.tencent.mm.ui.chatting;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.a.dd;
import com.tencent.mm.e.a.hq;
import com.tencent.mm.e.a.lz;
import com.tencent.mm.modelbiz.e;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.storage.au;
import com.tencent.mm.t.f;
import com.tencent.mm.u.ay;
import com.tencent.mm.ui.chatting.En_5b8fbb1e.a;
import com.tencent.mm.ui.chatting.ah.c;
import com.tencent.wcdb.FileUtils;

final class ba extends c {
    public a vCd;
    private com.tencent.mm.ah.a.a.c vCn;

    public ba(int i) {
        super(i);
        com.tencent.mm.ah.a.a.c.a aVar = new com.tencent.mm.ah.a.a.c.a();
        aVar.hJa = R.k.dtz;
        this.vCn = aVar.Hg();
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null && (view.getTag() instanceof n) && ((ah.a) view.getTag()).type == this.knu) {
            return view;
        }
        view = new bj(layoutInflater, R.i.cYk);
        view.setTag(new n(this.knu).q(view, false));
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
        r29.aI(r30);
        r21.reset();
        r0 = r30;
        r0 = r0.field_content;
        r25 = r0;
        r29.aG(r30);
        r7 = 0;
        r6 = 0;
        if (r25 == 0) goto L_0x13d4;
    L_0x001d:
        r0 = r30;
        r6 = r0.field_reserved;
        r0 = r25;
        r7 = com.tencent.mm.t.f.a.B(r0, r6);
        r6 = com.tencent.mm.t.j.eo(r25);
        r14 = r6;
        r22 = r7;
    L_0x002e:
        r6 = new com.tencent.mm.ui.chatting.dt;
        r0 = r29;
        r8 = r0.vxp;
        r10 = 0;
        r11 = 0;
        r12 = 0;
        r7 = r30;
        r9 = r28;
        r6.<init>(r7, r8, r9, r10, r11, r12);
        if (r22 == 0) goto L_0x02f9;
    L_0x0040:
        r0 = r22;
        r7 = r0.appId;
        r0 = r22;
        r8 = r0.fWF;
        r9 = com.tencent.mm.pluginsdk.model.app.g.cv(r7, r8);
        r0 = r21;
        r7 = r0.ipw;
        r0 = r22;
        r8 = r0.title;
        r7.setText(r8);
        r0 = r21;
        r7 = r0.ipx;
        r0 = r22;
        r8 = r0.description;
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
        r10 = com.tencent.mm.R.e.aVo;
        r8 = r8.getColor(r10);
        r7.setTextColor(r8);
        r0 = r21;
        r7 = r0.ipx;
        r0 = r29;
        r8 = r0.uSU;
        r8 = r8.uTo;
        r8 = r8.getResources();
        r10 = com.tencent.mm.R.e.aUo;
        r8 = r8.getColor(r10);
        r7.setTextColor(r8);
        r0 = r21;
        r7 = r0.vzc;
        r8 = com.tencent.mm.R.g.bdR;
        r7.setBackgroundResource(r8);
        r0 = r21;
        r7 = r0.vzc;
        r8 = 0;
        r0 = r29;
        r10 = r0.uSU;
        r10 = r10.uTo;
        r10 = r10.getResources();
        r11 = com.tencent.mm.R.f.aXz;
        r10 = r10.getDimensionPixelSize(r11);
        r11 = 0;
        r12 = 0;
        r7.setPadding(r8, r10, r11, r12);
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
        r7 = r0.vze;
        r8 = 8;
        r7.setVisibility(r8);
        r0 = r21;
        r7 = r0.vzf;
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
        r7 = r0.vyP;
        r8 = 8;
        r7.setVisibility(r8);
        r0 = r21;
        r7 = r0.vyN;
        r8 = 8;
        r7.setVisibility(r8);
        r0 = r21;
        r7 = r0.vyM;
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
        if (r9 == 0) goto L_0x0149;
    L_0x0139:
        r7 = r9.field_appName;
        if (r7 == 0) goto L_0x0149;
    L_0x013d:
        r7 = r9.field_appName;
        r7 = r7.trim();
        r7 = r7.length();
        if (r7 > 0) goto L_0x0347;
    L_0x0149:
        r0 = r22;
        r7 = r0.appName;
    L_0x014d:
        r8 = 1;
        r0 = r29;
        r10 = r0.uSU;
        r10 = r10.uTo;
        r11 = 12;
        com.tencent.mm.bg.a.fromDPToPix(r10, r11);
        r0 = r22;
        r10 = r0.type;
        r11 = 20;
        if (r10 == r11) goto L_0x016e;
    L_0x0161:
        r10 = "wxaf060266bfa9a35c";
        r0 = r22;
        r11 = r0.appId;
        r10 = r10.equals(r11);
        if (r10 == 0) goto L_0x0176;
    L_0x016e:
        r8 = com.tencent.mm.pluginsdk.l.a.bCn();
        r8 = r8.baQ();
    L_0x0176:
        if (r8 == 0) goto L_0x035a;
    L_0x0178:
        r0 = r22;
        r8 = r0.appId;
        if (r8 == 0) goto L_0x035a;
    L_0x017e:
        r0 = r22;
        r8 = r0.appId;
        r8 = r8.length();
        if (r8 <= 0) goto L_0x035a;
    L_0x0188:
        r8 = com.tencent.mm.pluginsdk.model.app.g.bn(r7);
        if (r8 == 0) goto L_0x035a;
    L_0x018e:
        r0 = r21;
        r8 = r0.lMU;
        r0 = r29;
        r10 = r0.uSU;
        r10 = r10.uTo;
        r7 = com.tencent.mm.pluginsdk.model.app.g.a(r10, r9, r7);
        r8.setText(r7);
        r0 = r21;
        r7 = r0.vyO;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r21;
        r7 = r0.lMU;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r21;
        r7 = r0.lMU;
        r8 = 0;
        r10 = 0;
        r11 = 0;
        r12 = 0;
        r7.setCompoundDrawables(r8, r10, r11, r12);
        r0 = r21;
        r7 = r0.vyL;
        r8 = 0;
        r7.setVisibility(r8);
        if (r9 == 0) goto L_0x034b;
    L_0x01c4:
        r7 = r9.bCU();
        if (r7 == 0) goto L_0x034b;
    L_0x01ca:
        r0 = r21;
        r8 = r0.lMU;
        r11 = r9.field_packageName;
        r0 = r30;
        r12 = r0.field_msgSvrId;
        r7 = r29;
        r9 = r30;
        r10 = r22;
        com.tencent.mm.ui.chatting.ah.a(r7, r8, r9, r10, r11, r12);
    L_0x01dd:
        r0 = r21;
        r7 = r0.vyL;
        r0 = r22;
        r8 = r0.appId;
        r0 = r29;
        com.tencent.mm.ui.chatting.ah.a(r0, r7, r8);
    L_0x01ea:
        r7 = 0;
        r0 = r21;
        r8 = r0.vyp;
        r9 = 0;
        r8.setVisibility(r9);
        r0 = r26;
        r8 = r0.sXW;
        if (r8 == 0) goto L_0x03e8;
    L_0x01f9:
        r8 = 0;
        r0 = r22;
        r9 = r0.type;
        r10 = 33;
        if (r9 == r10) goto L_0x0221;
    L_0x0202:
        r0 = r22;
        r9 = r0.type;
        r10 = 36;
        if (r9 == r10) goto L_0x0221;
    L_0x020a:
        r8 = com.tencent.mm.ah.n.GS();
        r0 = r30;
        r9 = r0.field_imgPath;
        r0 = r29;
        r10 = r0.uSU;
        r10 = r10.uTo;
        r10 = com.tencent.mm.bg.a.getDensity(r10);
        r11 = 0;
        r8 = r8.a(r9, r10, r11);
    L_0x0221:
        if (r8 == 0) goto L_0x03e5;
    L_0x0223:
        r9 = r8.isRecycled();
        if (r9 != 0) goto L_0x03e5;
    L_0x0229:
        r0 = r21;
        r9 = r0.vyp;
        r9.setImageBitmap(r8);
    L_0x0230:
        r0 = r22;
        r9 = r0.type;
        r10 = 3;
        if (r9 != r10) goto L_0x024d;
    L_0x0237:
        r0 = r21;
        r9 = r0.vzc;
        r9 = r9.getViewTreeObserver();
        r10 = new com.tencent.mm.ui.chatting.ba$1;
        r0 = r26;
        r1 = r21;
        r2 = r29;
        r10.<init>(r0, r1, r2, r8);
        r9.addOnPreDrawListener(r10);
    L_0x024d:
        r23 = r7;
    L_0x024f:
        r24 = 0;
        r0 = r21;
        r7 = r0.vyT;
        r8 = 0;
        r7.setOnClickListener(r8);
        r0 = r22;
        r7 = r0.type;
        switch(r7) {
            case 0: goto L_0x0c8e;
            case 1: goto L_0x0260;
            case 2: goto L_0x0260;
            case 3: goto L_0x03fd;
            case 4: goto L_0x05d2;
            case 5: goto L_0x0769;
            case 6: goto L_0x052c;
            case 7: goto L_0x0a22;
            case 8: goto L_0x0260;
            case 9: goto L_0x0260;
            case 10: goto L_0x0adc;
            case 11: goto L_0x0260;
            case 12: goto L_0x0260;
            case 13: goto L_0x0b98;
            case 14: goto L_0x0260;
            case 15: goto L_0x0d11;
            case 16: goto L_0x0fc4;
            case 17: goto L_0x0260;
            case 18: goto L_0x0260;
            case 19: goto L_0x113d;
            case 20: goto L_0x0c0f;
            case 21: goto L_0x0260;
            case 22: goto L_0x0260;
            case 23: goto L_0x0260;
            case 24: goto L_0x105c;
            case 25: goto L_0x0dcd;
            case 26: goto L_0x0e87;
            case 27: goto L_0x0e87;
            case 28: goto L_0x0260;
            case 29: goto L_0x0260;
            case 30: goto L_0x0260;
            case 31: goto L_0x0260;
            case 32: goto L_0x0260;
            case 33: goto L_0x086f;
            case 34: goto L_0x1190;
            case 35: goto L_0x0260;
            case 36: goto L_0x0662;
            case 37: goto L_0x0260;
            case 38: goto L_0x0260;
            case 39: goto L_0x0260;
            case 40: goto L_0x1359;
            default: goto L_0x0260;
        };
    L_0x0260:
        r7 = 1;
        r12 = r6;
        r6 = r7;
    L_0x0263:
        if (r6 == 0) goto L_0x02ed;
    L_0x0265:
        r0 = r22;
        r6 = r0.title;
        if (r6 == 0) goto L_0x136f;
    L_0x026b:
        r0 = r22;
        r6 = r0.title;
        r6 = r6.length();
        if (r6 <= 0) goto L_0x136f;
    L_0x0275:
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
    L_0x0290:
        r0 = r21;
        r6 = r0.ipw;
        r7 = 8;
        r6.setVisibility(r7);
        if (r23 == 0) goto L_0x02ed;
    L_0x029b:
        r0 = r22;
        r6 = r0.type;
        r7 = 33;
        if (r6 == r7) goto L_0x02ab;
    L_0x02a3:
        r0 = r22;
        r6 = r0.type;
        r7 = 36;
        if (r6 != r7) goto L_0x137a;
    L_0x02ab:
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
    L_0x02ed:
        r0 = r22;
        r6 = r0.hhq;
        r0 = r21;
        r1 = r25;
        com.tencent.mm.ui.chatting.n.a(r0, r1, r6);
        r6 = r12;
    L_0x02f9:
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
        if (r6 == 0) goto L_0x032d;
    L_0x0313:
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
    L_0x032d:
        r0 = r29;
        r6 = r0.vBD;
        r9 = r6.hrM;
        r0 = r29;
        r10 = r0.vxp;
        r0 = r29;
        r6 = r0.vBD;
        r11 = r6.vEW;
        r6 = r28;
        r7 = r21;
        r8 = r30;
        com.tencent.mm.ui.chatting.ah.a(r6, r7, r8, r9, r10, r11);
        return;
    L_0x0347:
        r7 = r9.field_appName;
        goto L_0x014d;
    L_0x034b:
        r0 = r21;
        r7 = r0.lMU;
        r0 = r22;
        r8 = r0.appId;
        r0 = r29;
        com.tencent.mm.ui.chatting.ah.a(r0, r7, r8);
        goto L_0x01dd;
    L_0x035a:
        r0 = r22;
        r7 = r0.type;
        r8 = 24;
        if (r7 != r8) goto L_0x038e;
    L_0x0362:
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
        goto L_0x01ea;
    L_0x038e:
        r0 = r22;
        r7 = r0.type;
        r8 = 19;
        if (r7 == r8) goto L_0x039c;
    L_0x0396:
        r7 = r14.hkp;
        r8 = 19;
        if (r7 != r8) goto L_0x03c8;
    L_0x039c:
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
        goto L_0x01ea;
    L_0x03c8:
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
        goto L_0x01ea;
    L_0x03e5:
        r7 = 1;
        goto L_0x0230;
    L_0x03e8:
        r0 = r21;
        r8 = r0.vyp;
        r9 = r29.getResources();
        r10 = com.tencent.mm.R.g.bhO;
        r9 = android.graphics.BitmapFactory.decodeResource(r9, r10);
        r8.setImageBitmap(r9);
        r23 = r7;
        goto L_0x024f;
    L_0x03fd:
        r0 = r22;
        r7 = r0.title;
        if (r7 == 0) goto L_0x04ec;
    L_0x0403:
        r0 = r22;
        r7 = r0.title;
        r7 = r7.length();
        if (r7 <= 0) goto L_0x04ec;
    L_0x040d:
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
    L_0x042c:
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
        r7 = r0.ipx;
        r8 = 2;
        r7.setMaxLines(r8);
        r0 = r21;
        r7 = r0.vyT;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r27;
        r8 = r0.vCb;
        r0 = r30;
        r10 = r0.field_msgId;
        r7 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));
        if (r7 != 0) goto L_0x04f7;
    L_0x0478:
        r0 = r21;
        r7 = r0.vyT;
        r8 = com.tencent.mm.R.g.bho;
        r7.setImageResource(r8);
    L_0x0481:
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
        if (r23 == 0) goto L_0x04d2;
    L_0x04ae:
        r0 = r22;
        r7 = r0.appId;
        r8 = 1;
        r0 = r29;
        r9 = r0.uSU;
        r9 = r9.uTo;
        r9 = com.tencent.mm.bg.a.getDensity(r9);
        r7 = com.tencent.mm.pluginsdk.model.app.g.b(r7, r8, r9);
        if (r7 == 0) goto L_0x04c9;
    L_0x04c3:
        r8 = r7.isRecycled();
        if (r8 == 0) goto L_0x0501;
    L_0x04c9:
        r0 = r21;
        r7 = r0.vyp;
        r8 = com.tencent.mm.R.k.dtg;
        r7.setImageResource(r8);
    L_0x04d2:
        r7 = com.tencent.mm.ui.chatting.ah.bUq();
        if (r7 == 0) goto L_0x0509;
    L_0x04d8:
        r0 = r21;
        r7 = r0.oDJ;
        if (r7 == 0) goto L_0x13cb;
    L_0x04de:
        r0 = r21;
        r7 = r0.oDJ;
        r8 = 8;
        r7.setVisibility(r8);
        r12 = r6;
        r6 = r24;
        goto L_0x0263;
    L_0x04ec:
        r0 = r21;
        r7 = r0.ipw;
        r8 = 8;
        r7.setVisibility(r8);
        goto L_0x042c;
    L_0x04f7:
        r0 = r21;
        r7 = r0.vyT;
        r8 = com.tencent.mm.R.g.bhp;
        r7.setImageResource(r8);
        goto L_0x0481;
    L_0x0501:
        r0 = r21;
        r8 = r0.vyp;
        r8.setImageBitmap(r7);
        goto L_0x04d2;
    L_0x0509:
        r0 = r21;
        r7 = r0.oDJ;
        if (r7 == 0) goto L_0x13cb;
    L_0x050f:
        r0 = r21;
        r7 = r0.oDJ;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r30;
        r7 = r0.field_status;
        r8 = 2;
        if (r7 < r8) goto L_0x13cb;
    L_0x051e:
        r0 = r21;
        r7 = r0.oDJ;
        r8 = 8;
        r7.setVisibility(r8);
        r12 = r6;
        r6 = r24;
        goto L_0x0263;
    L_0x052c:
        r0 = r22;
        r7 = r0.title;
        if (r7 == 0) goto L_0x05b4;
    L_0x0532:
        r0 = r22;
        r7 = r0.title;
        r7 = r7.length();
        if (r7 <= 0) goto L_0x05b4;
    L_0x053c:
        r0 = r21;
        r7 = r0.ipw;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r21;
        r7 = r0.ipw;
        r8 = 2;
        r7.setMaxLines(r8);
    L_0x054c:
        r0 = r21;
        r7 = r0.ipx;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r21;
        r7 = r0.mys;
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
        r0 = r21;
        r7 = r0.vyT;
        r8 = 8;
        r7.setVisibility(r8);
        r7 = 0;
        r7 = java.lang.Boolean.valueOf(r7);
        r0 = r22;
        r8 = r0.fCW;
        r0 = r22;
        r9 = r0.title;
        r0 = r21;
        r1 = r30;
        com.tencent.mm.ui.chatting.n.a(r0, r7, r1, r8, r9);
        if (r23 == 0) goto L_0x13cb;
    L_0x059c:
        r0 = r22;
        r7 = r0.hhr;
        r7 = com.tencent.mm.sdk.platformtools.bg.Qm(r7);
        if (r7 == 0) goto L_0x05be;
    L_0x05a6:
        r0 = r21;
        r7 = r0.vyp;
        r8 = com.tencent.mm.R.g.bch;
        r7.setImageResource(r8);
        r12 = r6;
        r6 = r24;
        goto L_0x0263;
    L_0x05b4:
        r0 = r21;
        r7 = r0.ipw;
        r8 = 8;
        r7.setVisibility(r8);
        goto L_0x054c;
    L_0x05be:
        r0 = r21;
        r7 = r0.vyp;
        r0 = r22;
        r8 = r0.hhr;
        r8 = com.tencent.mm.pluginsdk.model.q.LV(r8);
        r7.setImageResource(r8);
        r12 = r6;
        r6 = r24;
        goto L_0x0263;
    L_0x05d2:
        r0 = r22;
        r7 = r0.title;
        if (r7 == 0) goto L_0x0650;
    L_0x05d8:
        r0 = r22;
        r7 = r0.title;
        r7 = r7.length();
        if (r7 <= 0) goto L_0x0650;
    L_0x05e2:
        r0 = r21;
        r7 = r0.ipw;
        r8 = 0;
        r7.setVisibility(r8);
    L_0x05ea:
        r0 = r21;
        r7 = r0.ipx;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r21;
        r7 = r0.mys;
        r8 = 8;
        r7.setVisibility(r8);
        r0 = r21;
        r7 = r0.ipx;
        r8 = 2;
        r7.setMaxLines(r8);
        r0 = r21;
        r7 = r0.vyP;
        r8 = 4;
        r7.setVisibility(r8);
        r0 = r21;
        r7 = r0.vyT;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r21;
        r7 = r0.vyT;
        r8 = com.tencent.mm.R.g.bkW;
        r7.setImageResource(r8);
        if (r23 == 0) goto L_0x13cb;
    L_0x061e:
        r0 = r22;
        r7 = r0.appId;
        r8 = 1;
        r0 = r29;
        r9 = r0.uSU;
        r9 = r9.uTo;
        r9 = com.tencent.mm.bg.a.getDensity(r9);
        r7 = com.tencent.mm.pluginsdk.model.app.g.b(r7, r8, r9);
        if (r7 == 0) goto L_0x0639;
    L_0x0633:
        r8 = r7.isRecycled();
        if (r8 == 0) goto L_0x065a;
    L_0x0639:
        r0 = r21;
        r7 = r0.vyp;
        r8 = com.tencent.mm.R.k.dtr;
        r7.setImageResource(r8);
    L_0x0642:
        r0 = r21;
        r7 = r0.vyT;
        r8 = 8;
        r7.setVisibility(r8);
        r12 = r6;
        r6 = r24;
        goto L_0x0263;
    L_0x0650:
        r0 = r21;
        r7 = r0.ipw;
        r8 = 8;
        r7.setVisibility(r8);
        goto L_0x05ea;
    L_0x065a:
        r0 = r21;
        r8 = r0.vyp;
        r8.setImageBitmap(r7);
        goto L_0x0642;
    L_0x0662:
        r7 = com.tencent.mm.plugin.appbrand.i.b.class;
        r7 = com.tencent.mm.kernel.h.h(r7);
        r7 = (com.tencent.mm.plugin.appbrand.i.b) r7;
        r0 = r22;
        r8 = r0.hjM;
        r9 = r7.og(r8);
        if (r9 == 0) goto L_0x0739;
    L_0x0674:
        r7 = r9.field_nickname;
        r8 = r7;
    L_0x0677:
        if (r9 == 0) goto L_0x0740;
    L_0x0679:
        r7 = r9.field_brandIconURL;
    L_0x067b:
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
        r7 = com.tencent.mm.ui.chatting.ah.bUq();
        if (r7 == 0) goto L_0x0746;
    L_0x071a:
        r0 = r29;
        r7 = r0.vBD;
        r0 = r21;
        r1 = r30;
        a(r0, r7, r1);
        r0 = r21;
        r7 = r0.oDJ;
        if (r7 == 0) goto L_0x13cb;
    L_0x072b:
        r0 = r21;
        r7 = r0.oDJ;
        r8 = 8;
        r7.setVisibility(r8);
        r12 = r6;
        r6 = r24;
        goto L_0x0263;
    L_0x0739:
        r0 = r22;
        r7 = r0.fUS;
        r8 = r7;
        goto L_0x0677;
    L_0x0740:
        r0 = r22;
        r7 = r0.hjV;
        goto L_0x067b;
    L_0x0746:
        r0 = r21;
        r7 = r0.oDJ;
        if (r7 == 0) goto L_0x13cb;
    L_0x074c:
        r0 = r21;
        r7 = r0.oDJ;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r30;
        r7 = r0.field_status;
        r8 = 2;
        if (r7 < r8) goto L_0x13cb;
    L_0x075b:
        r0 = r21;
        r7 = r0.oDJ;
        r8 = 8;
        r7.setVisibility(r8);
        r12 = r6;
        r6 = r24;
        goto L_0x0263;
    L_0x0769:
        r0 = r21;
        r7 = r0.ipw;
        r8 = 8;
        r7.setVisibility(r8);
        r0 = r22;
        r7 = r0.title;
        if (r7 == 0) goto L_0x0829;
    L_0x0778:
        r0 = r22;
        r7 = r0.title;
        r7 = r7.length();
        if (r7 <= 0) goto L_0x0829;
    L_0x0782:
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
        r0 = r22;
        r8 = r0.title;
        r7.setText(r8);
    L_0x079d:
        r0 = r21;
        r7 = r0.ipx;
        r8 = 3;
        r7.setMaxLines(r8);
        r0 = r21;
        r7 = r0.vyP;
        r8 = 4;
        r7.setVisibility(r8);
        r0 = r21;
        r7 = r0.vyT;
        r8 = 8;
        r7.setVisibility(r8);
        if (r23 == 0) goto L_0x0804;
    L_0x07b8:
        r0 = r22;
        r7 = r0.appId;
        r8 = 1;
        r0 = r29;
        r9 = r0.uSU;
        r9 = r9.uTo;
        r9 = com.tencent.mm.bg.a.getDensity(r9);
        r7 = com.tencent.mm.pluginsdk.model.app.g.b(r7, r8, r9);
        if (r7 != 0) goto L_0x0834;
    L_0x07cd:
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
    L_0x0804:
        r7 = com.tencent.mm.ui.chatting.ah.bUq();
        if (r7 == 0) goto L_0x084c;
    L_0x080a:
        r0 = r29;
        r7 = r0.vBD;
        r0 = r21;
        r1 = r30;
        a(r0, r7, r1);
        r0 = r21;
        r7 = r0.oDJ;
        if (r7 == 0) goto L_0x13cb;
    L_0x081b:
        r0 = r21;
        r7 = r0.oDJ;
        r8 = 8;
        r7.setVisibility(r8);
        r12 = r6;
        r6 = r24;
        goto L_0x0263;
    L_0x0829:
        r0 = r21;
        r7 = r0.mys;
        r8 = 8;
        r7.setVisibility(r8);
        goto L_0x079d;
    L_0x0834:
        r8 = r7.isRecycled();
        if (r8 == 0) goto L_0x0844;
    L_0x083a:
        r0 = r21;
        r7 = r0.vyp;
        r8 = com.tencent.mm.R.k.dtu;
        r7.setImageResource(r8);
        goto L_0x0804;
    L_0x0844:
        r0 = r21;
        r8 = r0.vyp;
        r8.setImageBitmap(r7);
        goto L_0x0804;
    L_0x084c:
        r0 = r21;
        r7 = r0.oDJ;
        if (r7 == 0) goto L_0x13cb;
    L_0x0852:
        r0 = r21;
        r7 = r0.oDJ;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r30;
        r7 = r0.field_status;
        r8 = 2;
        if (r7 < r8) goto L_0x13cb;
    L_0x0861:
        r0 = r21;
        r7 = r0.oDJ;
        r8 = 8;
        r7.setVisibility(r8);
        r12 = r6;
        r6 = r24;
        goto L_0x0263;
    L_0x086f:
        r7 = com.tencent.mm.plugin.appbrand.i.b.class;
        r7 = com.tencent.mm.kernel.h.h(r7);
        r7 = (com.tencent.mm.plugin.appbrand.i.b) r7;
        r0 = r22;
        r8 = r0.hjM;
        r9 = r7.og(r8);
        r0 = r22;
        r7 = r0.hjO;
        switch(r7) {
            case 1: goto L_0x0982;
            case 2: goto L_0x08b0;
            case 3: goto L_0x08b0;
            default: goto L_0x0886;
        };
    L_0x0886:
        r24 = 1;
        r7 = r24;
    L_0x088a:
        if (r7 != 0) goto L_0x13d0;
    L_0x088c:
        r8 = com.tencent.mm.ui.chatting.ah.bUq();
        if (r8 == 0) goto L_0x0a00;
    L_0x0892:
        r0 = r29;
        r8 = r0.vBD;
        r0 = r21;
        r1 = r30;
        a(r0, r8, r1);
        r0 = r21;
        r8 = r0.oDJ;
        if (r8 == 0) goto L_0x13d0;
    L_0x08a3:
        r0 = r21;
        r8 = r0.oDJ;
        r9 = 8;
        r8.setVisibility(r9);
        r12 = r6;
        r6 = r7;
        goto L_0x0263;
    L_0x08b0:
        if (r9 == 0) goto L_0x0961;
    L_0x08b2:
        r7 = r9.field_nickname;
        r8 = r7;
    L_0x08b5:
        if (r9 == 0) goto L_0x0968;
    L_0x08b7:
        r7 = r9.field_brandIconURL;
    L_0x08b9:
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
            case 1: goto L_0x096e;
            case 2: goto L_0x0978;
            default: goto L_0x0900;
        };
    L_0x0900:
        r0 = r21;
        r8 = r0.vzm;
        r9 = com.tencent.mm.R.l.dDY;
        r8.setText(r9);
    L_0x0909:
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
        r8 = com.tencent.mm.modelappbrand.a.b.AY();
        r9 = new com.tencent.mm.ui.chatting.ba$2;
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
        r7 = r24;
        goto L_0x088a;
    L_0x0961:
        r0 = r22;
        r7 = r0.fUS;
        r8 = r7;
        goto L_0x08b5;
    L_0x0968:
        r0 = r22;
        r7 = r0.hjV;
        goto L_0x08b9;
    L_0x096e:
        r0 = r21;
        r8 = r0.vzm;
        r9 = com.tencent.mm.R.l.dGc;
        r8.setText(r9);
        goto L_0x0909;
    L_0x0978:
        r0 = r21;
        r8 = r0.vzm;
        r9 = com.tencent.mm.R.l.dGb;
        r8.setText(r9);
        goto L_0x0909;
    L_0x0982:
        if (r9 == 0) goto L_0x09e3;
    L_0x0984:
        r7 = r9.field_nickname;
        r8 = r7;
    L_0x0987:
        if (r9 == 0) goto L_0x09e9;
    L_0x0989:
        r7 = r9.field_brandIconURL;
    L_0x098b:
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
        if (r8 == 0) goto L_0x09eb;
    L_0x09b2:
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
        r7 = r24;
        goto L_0x088a;
    L_0x09e3:
        r0 = r22;
        r7 = r0.title;
        r8 = r7;
        goto L_0x0987;
    L_0x09e9:
        r7 = 0;
        goto L_0x098b;
    L_0x09eb:
        r8 = com.tencent.mm.modelappbrand.a.b.AY();
        r0 = r21;
        r9 = r0.vzh;
        r10 = com.tencent.mm.modelappbrand.a.a.AX();
        r11 = com.tencent.mm.modelappbrand.a.e.hqF;
        r8.a(r9, r7, r10, r11);
        r7 = r24;
        goto L_0x088a;
    L_0x0a00:
        r0 = r21;
        r8 = r0.oDJ;
        if (r8 == 0) goto L_0x13d0;
    L_0x0a06:
        r0 = r21;
        r8 = r0.oDJ;
        r9 = 0;
        r8.setVisibility(r9);
        r0 = r30;
        r8 = r0.field_status;
        r9 = 2;
        if (r8 < r9) goto L_0x13d0;
    L_0x0a15:
        r0 = r21;
        r8 = r0.oDJ;
        r9 = 8;
        r8.setVisibility(r9);
        r12 = r6;
        r6 = r7;
        goto L_0x0263;
    L_0x0a22:
        r0 = r21;
        r7 = r0.ipw;
        r8 = 8;
        r7.setVisibility(r8);
        r0 = r22;
        r7 = r0.title;
        if (r7 == 0) goto L_0x0aa7;
    L_0x0a31:
        r0 = r22;
        r7 = r0.title;
        r7 = r7.length();
        if (r7 <= 0) goto L_0x0aa7;
    L_0x0a3b:
        r0 = r21;
        r7 = r0.mys;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r21;
        r7 = r0.mys;
        r0 = r22;
        r8 = r0.title;
        r7.setText(r8);
    L_0x0a4e:
        r0 = r21;
        r7 = r0.ipx;
        r8 = 3;
        r7.setMaxLines(r8);
        r0 = r21;
        r7 = r0.vyP;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r21;
        r7 = r0.vyT;
        r8 = 8;
        r7.setVisibility(r8);
        if (r23 == 0) goto L_0x0a8d;
    L_0x0a69:
        r0 = r22;
        r7 = r0.appId;
        r8 = 1;
        r0 = r29;
        r9 = r0.uSU;
        r9 = r9.uTo;
        r9 = com.tencent.mm.bg.a.getDensity(r9);
        r7 = com.tencent.mm.pluginsdk.model.app.g.b(r7, r8, r9);
        if (r7 == 0) goto L_0x0a84;
    L_0x0a7e:
        r8 = r7.isRecycled();
        if (r8 == 0) goto L_0x0ab1;
    L_0x0a84:
        r0 = r21;
        r7 = r0.vyp;
        r8 = com.tencent.mm.R.k.dtu;
        r7.setImageResource(r8);
    L_0x0a8d:
        r7 = com.tencent.mm.ui.chatting.ah.bUq();
        if (r7 == 0) goto L_0x0ab9;
    L_0x0a93:
        r0 = r21;
        r7 = r0.oDJ;
        if (r7 == 0) goto L_0x13cb;
    L_0x0a99:
        r0 = r21;
        r7 = r0.oDJ;
        r8 = 8;
        r7.setVisibility(r8);
        r12 = r6;
        r6 = r24;
        goto L_0x0263;
    L_0x0aa7:
        r0 = r21;
        r7 = r0.mys;
        r8 = 8;
        r7.setVisibility(r8);
        goto L_0x0a4e;
    L_0x0ab1:
        r0 = r21;
        r8 = r0.vyp;
        r8.setImageBitmap(r7);
        goto L_0x0a8d;
    L_0x0ab9:
        r0 = r21;
        r7 = r0.oDJ;
        if (r7 == 0) goto L_0x13cb;
    L_0x0abf:
        r0 = r21;
        r7 = r0.oDJ;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r30;
        r7 = r0.field_status;
        r8 = 2;
        if (r7 < r8) goto L_0x13cb;
    L_0x0ace:
        r0 = r21;
        r7 = r0.oDJ;
        r8 = 8;
        r7.setVisibility(r8);
        r12 = r6;
        r6 = r24;
        goto L_0x0263;
    L_0x0adc:
        r0 = r21;
        r7 = r0.mys;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r22;
        r7 = r0.hhL;
        r8 = 1;
        if (r7 != r8) goto L_0x0b5c;
    L_0x0aeb:
        r0 = r21;
        r7 = r0.mys;
        r8 = com.tencent.mm.R.l.ePa;
        r7.setText(r8);
    L_0x0af4:
        r0 = r22;
        r7 = r0.title;
        if (r7 == 0) goto L_0x0b17;
    L_0x0afa:
        r0 = r22;
        r7 = r0.title;
        r7 = r7.length();
        if (r7 <= 0) goto L_0x0b17;
    L_0x0b04:
        r0 = r21;
        r7 = r0.ipw;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r21;
        r7 = r0.ipw;
        r0 = r22;
        r8 = r0.title;
        r7.setText(r8);
    L_0x0b17:
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
        if (r23 == 0) goto L_0x13cb;
    L_0x0b32:
        r7 = com.tencent.mm.ah.n.GS();
        r0 = r30;
        r8 = r0.field_imgPath;
        r0 = r29;
        r9 = r0.uSU;
        r9 = r9.uTo;
        r9 = com.tencent.mm.bg.a.getDensity(r9);
        r7 = r7.a(r8, r9);
        if (r7 == 0) goto L_0x0b8a;
    L_0x0b4a:
        r8 = r7.isRecycled();
        if (r8 != 0) goto L_0x0b8a;
    L_0x0b50:
        r0 = r21;
        r8 = r0.vyp;
        r8.setImageBitmap(r7);
        r12 = r6;
        r6 = r24;
        goto L_0x0263;
    L_0x0b5c:
        r0 = r22;
        r7 = r0.hhL;
        r8 = 2;
        if (r7 != r8) goto L_0x0b6d;
    L_0x0b63:
        r0 = r21;
        r7 = r0.mys;
        r8 = com.tencent.mm.R.l.ePc;
        r7.setText(r8);
        goto L_0x0af4;
    L_0x0b6d:
        r0 = r22;
        r7 = r0.hhL;
        r8 = 3;
        if (r7 != r8) goto L_0x0b7f;
    L_0x0b74:
        r0 = r21;
        r7 = r0.mys;
        r8 = com.tencent.mm.R.l.ePb;
        r7.setText(r8);
        goto L_0x0af4;
    L_0x0b7f:
        r0 = r21;
        r7 = r0.mys;
        r8 = com.tencent.mm.R.l.ePd;
        r7.setText(r8);
        goto L_0x0af4;
    L_0x0b8a:
        r0 = r21;
        r7 = r0.vyp;
        r8 = com.tencent.mm.R.k.dtu;
        r7.setImageResource(r8);
        r12 = r6;
        r6 = r24;
        goto L_0x0263;
    L_0x0b98:
        r0 = r21;
        r7 = r0.ipw;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r21;
        r7 = r0.ipw;
        r0 = r22;
        r8 = r0.title;
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
        if (r23 == 0) goto L_0x13cb;
    L_0x0bd7:
        r7 = com.tencent.mm.ah.n.GS();
        r0 = r30;
        r8 = r0.field_imgPath;
        r0 = r29;
        r9 = r0.uSU;
        r9 = r9.uTo;
        r9 = com.tencent.mm.bg.a.getDensity(r9);
        r7 = r7.a(r8, r9);
        if (r7 == 0) goto L_0x0c01;
    L_0x0bef:
        r8 = r7.isRecycled();
        if (r8 != 0) goto L_0x0c01;
    L_0x0bf5:
        r0 = r21;
        r8 = r0.vyp;
        r8.setImageBitmap(r7);
        r12 = r6;
        r6 = r24;
        goto L_0x0263;
    L_0x0c01:
        r0 = r21;
        r7 = r0.vyp;
        r8 = com.tencent.mm.R.k.dtu;
        r7.setImageResource(r8);
        r12 = r6;
        r6 = r24;
        goto L_0x0263;
    L_0x0c0f:
        r0 = r22;
        r7 = r0.title;
        if (r7 == 0) goto L_0x0c3b;
    L_0x0c15:
        r0 = r22;
        r7 = r0.title;
        r7 = r7.length();
        if (r7 <= 0) goto L_0x0c3b;
    L_0x0c1f:
        r0 = r21;
        r7 = r0.ipw;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r21;
        r7 = r0.ipw;
        r0 = r22;
        r8 = r0.title;
        r7.setText(r8);
        r0 = r21;
        r7 = r0.mys;
        r8 = 8;
        r7.setVisibility(r8);
    L_0x0c3b:
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
        if (r23 == 0) goto L_0x13cb;
    L_0x0c56:
        r7 = com.tencent.mm.ah.n.GS();
        r0 = r30;
        r8 = r0.field_imgPath;
        r0 = r29;
        r9 = r0.uSU;
        r9 = r9.uTo;
        r9 = com.tencent.mm.bg.a.getDensity(r9);
        r7 = r7.a(r8, r9);
        if (r7 == 0) goto L_0x0c80;
    L_0x0c6e:
        r8 = r7.isRecycled();
        if (r8 != 0) goto L_0x0c80;
    L_0x0c74:
        r0 = r21;
        r8 = r0.vyp;
        r8.setImageBitmap(r7);
        r12 = r6;
        r6 = r24;
        goto L_0x0263;
    L_0x0c80:
        r0 = r21;
        r7 = r0.vyp;
        r8 = com.tencent.mm.R.k.dtu;
        r7.setImageResource(r8);
        r12 = r6;
        r6 = r24;
        goto L_0x0263;
    L_0x0c8e:
        r0 = r22;
        r7 = r0.title;
        if (r7 == 0) goto L_0x0cfb;
    L_0x0c94:
        r0 = r22;
        r7 = r0.title;
        r7 = r7.length();
        if (r7 <= 0) goto L_0x0cfb;
    L_0x0c9e:
        r0 = r21;
        r7 = r0.ipw;
        r8 = 0;
        r7.setVisibility(r8);
    L_0x0ca6:
        r0 = r21;
        r7 = r0.ipx;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r21;
        r7 = r0.mys;
        r8 = 8;
        r7.setVisibility(r8);
        r0 = r21;
        r7 = r0.vyP;
        r8 = 8;
        r7.setVisibility(r8);
        r0 = r21;
        r7 = r0.vyT;
        r8 = 4;
        r7.setVisibility(r8);
        r0 = r21;
        r7 = r0.ipx;
        r8 = 2;
        r7.setMaxLines(r8);
        if (r23 == 0) goto L_0x13cb;
    L_0x0cd2:
        r0 = r22;
        r7 = r0.appId;
        r8 = 1;
        r0 = r29;
        r9 = r0.uSU;
        r9 = r9.uTo;
        r9 = com.tencent.mm.bg.a.getDensity(r9);
        r7 = com.tencent.mm.pluginsdk.model.app.g.b(r7, r8, r9);
        if (r7 == 0) goto L_0x0ced;
    L_0x0ce7:
        r8 = r7.isRecycled();
        if (r8 == 0) goto L_0x0d05;
    L_0x0ced:
        r0 = r21;
        r7 = r0.vyp;
        r8 = com.tencent.mm.R.k.dtu;
        r7.setImageResource(r8);
        r12 = r6;
        r6 = r24;
        goto L_0x0263;
    L_0x0cfb:
        r0 = r21;
        r7 = r0.ipw;
        r8 = 8;
        r7.setVisibility(r8);
        goto L_0x0ca6;
    L_0x0d05:
        r0 = r21;
        r8 = r0.vyp;
        r8.setImageBitmap(r7);
        r12 = r6;
        r6 = r24;
        goto L_0x0263;
    L_0x0d11:
        r0 = r22;
        r6 = r0.title;
        if (r6 == 0) goto L_0x0dba;
    L_0x0d17:
        r0 = r22;
        r6 = r0.title;
        r6 = r6.length();
        if (r6 <= 0) goto L_0x0dba;
    L_0x0d21:
        r0 = r21;
        r6 = r0.ipw;
        r7 = 0;
        r6.setVisibility(r7);
    L_0x0d29:
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
        if (r23 == 0) goto L_0x0d7c;
    L_0x0d55:
        r6 = com.tencent.mm.ah.n.GS();
        r0 = r30;
        r7 = r0.field_imgPath;
        r0 = r29;
        r8 = r0.uSU;
        r8 = r8.uTo;
        r8 = com.tencent.mm.bg.a.getDensity(r8);
        r6 = r6.a(r7, r8);
        if (r6 == 0) goto L_0x0d73;
    L_0x0d6d:
        r7 = r6.isRecycled();
        if (r7 == 0) goto L_0x0dc5;
    L_0x0d73:
        r0 = r21;
        r6 = r0.vyp;
        r7 = com.tencent.mm.R.k.dtu;
        r6.setImageResource(r7);
    L_0x0d7c:
        r6 = new com.tencent.mm.ui.chatting.dt;
        r8 = 0;
        r10 = "";
        r11 = 8;
        r12 = 0;
        r13 = r29.bVS();
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
        goto L_0x0263;
    L_0x0dba:
        r0 = r21;
        r6 = r0.ipw;
        r7 = 8;
        r6.setVisibility(r7);
        goto L_0x0d29;
    L_0x0dc5:
        r0 = r21;
        r7 = r0.vyp;
        r7.setImageBitmap(r6);
        goto L_0x0d7c;
    L_0x0dcd:
        r0 = r22;
        r6 = r0.title;
        if (r6 == 0) goto L_0x0e74;
    L_0x0dd3:
        r0 = r22;
        r6 = r0.title;
        r6 = r6.length();
        if (r6 <= 0) goto L_0x0e74;
    L_0x0ddd:
        r0 = r21;
        r6 = r0.ipw;
        r7 = 0;
        r6.setVisibility(r7);
    L_0x0de5:
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
        if (r23 == 0) goto L_0x0e38;
    L_0x0e11:
        r6 = com.tencent.mm.ah.n.GS();
        r0 = r30;
        r7 = r0.field_imgPath;
        r0 = r29;
        r8 = r0.uSU;
        r8 = r8.uTo;
        r8 = com.tencent.mm.bg.a.getDensity(r8);
        r6 = r6.a(r7, r8);
        if (r6 == 0) goto L_0x0e2f;
    L_0x0e29:
        r7 = r6.isRecycled();
        if (r7 == 0) goto L_0x0e7f;
    L_0x0e2f:
        r0 = r21;
        r6 = r0.vyp;
        r7 = com.tencent.mm.R.k.dtu;
        r6.setImageResource(r7);
    L_0x0e38:
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
        goto L_0x0263;
    L_0x0e74:
        r0 = r21;
        r6 = r0.ipw;
        r7 = 8;
        r6.setVisibility(r7);
        goto L_0x0de5;
    L_0x0e7f:
        r0 = r21;
        r7 = r0.vyp;
        r7.setImageBitmap(r6);
        goto L_0x0e38;
    L_0x0e87:
        r0 = r22;
        r6 = r0.title;
        if (r6 == 0) goto L_0x0f4b;
    L_0x0e8d:
        r0 = r22;
        r6 = r0.title;
        r6 = r6.length();
        if (r6 <= 0) goto L_0x0f4b;
    L_0x0e97:
        r0 = r21;
        r6 = r0.ipw;
        r7 = 0;
        r6.setVisibility(r7);
    L_0x0e9f:
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
        if (r23 == 0) goto L_0x0ee4;
    L_0x0ecb:
        r0 = r30;
        r6 = r0.field_imgPath;
        r6 = com.tencent.mm.sdk.platformtools.bg.mA(r6);
        if (r6 == 0) goto L_0x0f56;
    L_0x0ed5:
        r6 = com.tencent.mm.ah.n.GW();
        r0 = r22;
        r7 = r0.thumburl;
        r0 = r21;
        r8 = r0.vyp;
        r6.a(r7, r8);
    L_0x0ee4:
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
        if (r7 != r8) goto L_0x0f88;
    L_0x0f17:
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
    L_0x0f3f:
        r0 = r21;
        r7 = r0.vzb;
        r7.setTag(r6);
        r12 = r6;
        r6 = r24;
        goto L_0x0263;
    L_0x0f4b:
        r0 = r21;
        r6 = r0.ipw;
        r7 = 8;
        r6.setVisibility(r7);
        goto L_0x0e9f;
    L_0x0f56:
        r6 = com.tencent.mm.ah.n.GS();
        r0 = r30;
        r7 = r0.field_imgPath;
        r0 = r29;
        r8 = r0.uSU;
        r8 = r8.uTo;
        r8 = com.tencent.mm.bg.a.getDensity(r8);
        r6 = r6.a(r7, r8);
        if (r6 == 0) goto L_0x0f74;
    L_0x0f6e:
        r7 = r6.isRecycled();
        if (r7 == 0) goto L_0x0f7f;
    L_0x0f74:
        r0 = r21;
        r6 = r0.vyp;
        r7 = com.tencent.mm.R.k.dtu;
        r6.setImageResource(r7);
        goto L_0x0ee4;
    L_0x0f7f:
        r0 = r21;
        r7 = r0.vyp;
        r7.setImageBitmap(r6);
        goto L_0x0ee4;
    L_0x0f88:
        r0 = r22;
        r7 = r0.type;
        r8 = 27;
        if (r7 != r8) goto L_0x0fb9;
    L_0x0f90:
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
        goto L_0x0f3f;
    L_0x0fb9:
        r7 = "MicroMsg.ChattingItemAppMsgTo";
        r8 = "unknow view type";
        com.tencent.mm.sdk.platformtools.w.i(r7, r8);
        goto L_0x0f3f;
    L_0x0fc4:
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
        if (r7 == 0) goto L_0x1044;
    L_0x0fe8:
        r0 = r22;
        r7 = r0.title;
        r7 = r7.length();
        if (r7 <= 0) goto L_0x1044;
    L_0x0ff2:
        r0 = r21;
        r7 = r0.mys;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r21;
        r7 = r0.mys;
        r0 = r22;
        r8 = r0.title;
        r7.setText(r8);
    L_0x1005:
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
        if (r23 == 0) goto L_0x13cb;
    L_0x1020:
        r7 = com.tencent.mm.ah.n.GS();
        r0 = r30;
        r8 = r0.field_imgPath;
        r0 = r29;
        r9 = r0.uSU;
        r9 = r9.uTo;
        r9 = com.tencent.mm.bg.a.getDensity(r9);
        r7 = r7.a(r8, r9);
        if (r7 == 0) goto L_0x104e;
    L_0x1038:
        r0 = r21;
        r8 = r0.vyp;
        r8.setImageBitmap(r7);
        r12 = r6;
        r6 = r24;
        goto L_0x0263;
    L_0x1044:
        r0 = r21;
        r7 = r0.mys;
        r8 = 8;
        r7.setVisibility(r8);
        goto L_0x1005;
    L_0x104e:
        r0 = r21;
        r7 = r0.vyp;
        r8 = com.tencent.mm.R.k.dtu;
        r7.setImageResource(r8);
        r12 = r6;
        r6 = r24;
        goto L_0x0263;
    L_0x105c:
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
        if (r7 == 0) goto L_0x10f3;
    L_0x1073:
        r0 = r22;
        r7 = r0.title;
        r7 = r7.length();
        if (r7 <= 0) goto L_0x10f3;
    L_0x107d:
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
        r10 = (int) r10;
        r8 = com.tencent.mm.pluginsdk.ui.d.h.c(r8, r9, r10);
        r7.setText(r8);
    L_0x109d:
        r0 = r21;
        r7 = r0.ipx;
        r8 = 3;
        r7.setMaxLines(r8);
        r0 = r21;
        r7 = r0.vyP;
        r8 = 4;
        r7.setVisibility(r8);
        r0 = r21;
        r7 = r0.vyT;
        r8 = 8;
        r7.setVisibility(r8);
        if (r23 == 0) goto L_0x10c1;
    L_0x10b8:
        r0 = r21;
        r7 = r0.vyp;
        r8 = 8;
        r7.setVisibility(r8);
    L_0x10c1:
        r0 = r29;
        r1 = r21;
        r2 = r22;
        r3 = r30;
        r4 = r23;
        com.tencent.mm.ui.chatting.n.a(r0, r1, r2, r3, r4);
        r7 = com.tencent.mm.ui.chatting.ah.bUq();
        if (r7 == 0) goto L_0x111a;
    L_0x10d4:
        r0 = r29;
        r7 = r0.vBD;
        r0 = r21;
        r1 = r30;
        a(r0, r7, r1);
        r0 = r21;
        r7 = r0.oDJ;
        if (r7 == 0) goto L_0x13cb;
    L_0x10e5:
        r0 = r21;
        r7 = r0.oDJ;
        r8 = 8;
        r7.setVisibility(r8);
        r12 = r6;
        r6 = r24;
        goto L_0x0263;
    L_0x10f3:
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
        r10 = (int) r10;
        r8 = com.tencent.mm.pluginsdk.ui.d.h.c(r8, r9, r10);
        r7.setText(r8);
        goto L_0x109d;
    L_0x111a:
        r0 = r21;
        r7 = r0.oDJ;
        if (r7 == 0) goto L_0x13cb;
    L_0x1120:
        r0 = r21;
        r7 = r0.oDJ;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r30;
        r7 = r0.field_status;
        r8 = 2;
        if (r7 < r8) goto L_0x13cb;
    L_0x112f:
        r0 = r21;
        r7 = r0.oDJ;
        r8 = 8;
        r7.setVisibility(r8);
        r12 = r6;
        r6 = r24;
        goto L_0x0263;
    L_0x113d:
        r0 = r29;
        r1 = r21;
        r2 = r22;
        r3 = r23;
        com.tencent.mm.ui.chatting.n.a(r0, r1, r2, r3);
        r7 = com.tencent.mm.ui.chatting.ah.bUq();
        if (r7 == 0) goto L_0x116d;
    L_0x114e:
        r0 = r29;
        r7 = r0.vBD;
        r0 = r21;
        r1 = r30;
        a(r0, r7, r1);
        r0 = r21;
        r7 = r0.oDJ;
        if (r7 == 0) goto L_0x13cb;
    L_0x115f:
        r0 = r21;
        r7 = r0.oDJ;
        r8 = 8;
        r7.setVisibility(r8);
        r12 = r6;
        r6 = r24;
        goto L_0x0263;
    L_0x116d:
        r0 = r21;
        r7 = r0.oDJ;
        if (r7 == 0) goto L_0x13cb;
    L_0x1173:
        r0 = r21;
        r7 = r0.oDJ;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r30;
        r7 = r0.field_status;
        r8 = 2;
        if (r7 < r8) goto L_0x13cb;
    L_0x1182:
        r0 = r21;
        r7 = r0.oDJ;
        r8 = 8;
        r7.setVisibility(r8);
        r12 = r6;
        r6 = r24;
        goto L_0x0263;
    L_0x1190:
        r0 = r22;
        r7 = r0.title;
        if (r7 == 0) goto L_0x12f9;
    L_0x1196:
        r0 = r22;
        r7 = r0.title;
        r7 = r7.length();
        if (r7 <= 0) goto L_0x12f9;
    L_0x11a0:
        r0 = r21;
        r7 = r0.ipw;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r22;
        r7 = r0.hiI;
        r7 = com.tencent.mm.sdk.platformtools.bg.mA(r7);
        if (r7 != 0) goto L_0x12e0;
    L_0x11b2:
        r0 = r22;
        r7 = r0.hiI;
        r7 = com.tencent.mm.sdk.platformtools.bg.mA(r7);
        if (r7 != 0) goto L_0x12c7;
    L_0x11bc:
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
    L_0x11db:
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
        if (r7 != 0) goto L_0x1304;
    L_0x11f5:
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
    L_0x1214:
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
        if (r7 != 0) goto L_0x131d;
    L_0x1248:
        r0 = r21;
        r7 = r0.lMU;
        r0 = r22;
        r8 = r0.hiE;
        r7.setText(r8);
    L_0x1253:
        r0 = r26;
        r7 = r0.sXW;
        if (r7 == 0) goto L_0x1343;
    L_0x1259:
        r7 = com.tencent.mm.ah.n.GS();
        r0 = r30;
        r8 = r0.field_imgPath;
        r0 = r29;
        r9 = r0.uSU;
        r9 = r9.uTo;
        r9 = com.tencent.mm.bg.a.getDensity(r9);
        r10 = 0;
        r7 = r7.a(r8, r9, r10);
        if (r7 == 0) goto L_0x128b;
    L_0x1272:
        r8 = r7.isRecycled();
        if (r8 != 0) goto L_0x128b;
    L_0x1278:
        r8 = 0;
        r9 = r7.getWidth();
        r9 = r9 / 2;
        r9 = (float) r9;
        r8 = com.tencent.mm.sdk.platformtools.d.a(r7, r8, r9);
        r0 = r21;
        r9 = r0.vyp;
        r9.setImageBitmap(r8);
    L_0x128b:
        r0 = r22;
        r8 = r0.hiH;
        r8 = com.tencent.mm.sdk.platformtools.bg.mA(r8);
        if (r8 != 0) goto L_0x1328;
    L_0x1295:
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
        r11 = new com.tencent.mm.ui.chatting.ba$3;
        r0 = r26;
        r1 = r21;
        r2 = r29;
        r11.<init>(r0, r1, r2);
        r7.a(r8, r9, r10, r11);
        r12 = r6;
        r6 = r24;
        goto L_0x0263;
    L_0x12c7:
        r0 = r21;
        r7 = r0.ipw;
        r0 = r29;
        r8 = r0.uSU;
        r8 = r8.uTo;
        r8 = r8.getResources();
        r9 = com.tencent.mm.R.e.black;
        r8 = r8.getColor(r9);
        r7.setTextColor(r8);
        goto L_0x11db;
    L_0x12e0:
        r0 = r21;
        r7 = r0.ipw;
        r0 = r29;
        r8 = r0.uSU;
        r8 = r8.uTo;
        r8 = r8.getResources();
        r9 = com.tencent.mm.R.e.black;
        r8 = r8.getColor(r9);
        r7.setTextColor(r8);
        goto L_0x11db;
    L_0x12f9:
        r0 = r21;
        r7 = r0.ipw;
        r8 = 8;
        r7.setVisibility(r8);
        goto L_0x11db;
    L_0x1304:
        r0 = r21;
        r7 = r0.ipx;
        r0 = r29;
        r8 = r0.uSU;
        r8 = r8.uTo;
        r8 = r8.getResources();
        r9 = com.tencent.mm.R.e.aUf;
        r8 = r8.getColor(r9);
        r7.setTextColor(r8);
        goto L_0x1214;
    L_0x131d:
        r0 = r21;
        r7 = r0.lMU;
        r8 = com.tencent.mm.R.l.dUb;
        r7.setText(r8);
        goto L_0x1253;
    L_0x1328:
        r0 = r21;
        r8 = r0.vzc;
        r8 = r8.getViewTreeObserver();
        r9 = new com.tencent.mm.ui.chatting.ba$4;
        r0 = r26;
        r1 = r21;
        r2 = r29;
        r9.<init>(r0, r1, r2, r7);
        r8.addOnPreDrawListener(r9);
        r12 = r6;
        r6 = r24;
        goto L_0x0263;
    L_0x1343:
        r0 = r21;
        r7 = r0.vyp;
        r8 = r29.getResources();
        r9 = com.tencent.mm.R.g.bhO;
        r8 = android.graphics.BitmapFactory.decodeResource(r8, r9);
        r7.setImageBitmap(r8);
        r12 = r6;
        r6 = r24;
        goto L_0x0263;
    L_0x1359:
        r7 = r14.hkp;
        r8 = 19;
        if (r7 != r8) goto L_0x13cb;
    L_0x135f:
        r0 = r29;
        r1 = r21;
        r2 = r22;
        r3 = r23;
        com.tencent.mm.ui.chatting.n.a(r0, r1, r2, r3);
        r12 = r6;
        r6 = r24;
        goto L_0x0263;
    L_0x136f:
        r0 = r21;
        r6 = r0.mys;
        r7 = 8;
        r6.setVisibility(r7);
        goto L_0x0290;
    L_0x137a:
        r6 = com.tencent.mm.ah.n.GS();
        r0 = r30;
        r7 = r0.field_imgPath;
        r0 = r29;
        r8 = r0.uSU;
        r8 = r8.uTo;
        r8 = com.tencent.mm.bg.a.getDensity(r8);
        r6 = r6.a(r7, r8);
        if (r6 == 0) goto L_0x1398;
    L_0x1392:
        r7 = r6.isRecycled();
        if (r7 == 0) goto L_0x13af;
    L_0x1398:
        r6 = com.tencent.mm.ah.n.GS();
        r0 = r30;
        r7 = r0.field_imgPath;
        r0 = r29;
        r8 = r0.uSU;
        r8 = r8.uTo;
        r8 = com.tencent.mm.bg.a.getDensity(r8);
        r9 = 0;
        r6 = r6.a(r7, r8, r9);
    L_0x13af:
        if (r6 == 0) goto L_0x13c0;
    L_0x13b1:
        r7 = r6.isRecycled();
        if (r7 != 0) goto L_0x13c0;
    L_0x13b7:
        r0 = r21;
        r7 = r0.vyp;
        r7.setImageBitmap(r6);
        goto L_0x02ed;
    L_0x13c0:
        r0 = r21;
        r6 = r0.vyp;
        r7 = com.tencent.mm.R.g.bch;
        r6.setImageResource(r7);
        goto L_0x02ed;
    L_0x13cb:
        r12 = r6;
        r6 = r24;
        goto L_0x0263;
    L_0x13d0:
        r12 = r6;
        r6 = r7;
        goto L_0x0263;
    L_0x13d4:
        r14 = r6;
        r22 = r7;
        goto L_0x002e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.ba.a(com.tencent.mm.ui.chatting.ah$a, int, com.tencent.mm.ui.chatting.En_5b8fbb1e$a, com.tencent.mm.storage.au, java.lang.String):void");
    }

    private static void a(n nVar, cw cwVar, au auVar) {
        if (auVar.field_status == 2 && ah.a(cwVar, auVar.field_msgId)) {
            if (nVar.vyy != null) {
                nVar.vyy.setVisibility(0);
            }
        } else if (nVar.vyy != null) {
            nVar.vyy.setVisibility(8);
        }
    }

    public final boolean a(ContextMenu contextMenu, View view, au auVar) {
        int i = ((dt) view.getTag()).position;
        String str = auVar.field_content;
        if (str == null) {
            return true;
        }
        f.a ek = f.a.ek(this.vCd.cQ(str, auVar.field_isSend));
        if (ek == null) {
            return true;
        }
        boolean Dn;
        com.tencent.mm.pluginsdk.model.app.f aJ = g.aJ(ek.appId, false);
        if (g.h(aJ) && !aa.ah(auVar)) {
            contextMenu.add(i, 111, 0, this.vCd.getString(R.l.eLH));
        }
        if ((auVar.field_status == 2 || auVar.gxJ == 1) && ah.ao(auVar) && ah.Tn(auVar.field_talker)) {
            contextMenu.add(i, 123, 0, view.getContext().getString(R.l.dUx));
        }
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
        b ddVar = new dd();
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
        b lzVar;
        String str;
        switch (menuItem.getItemId()) {
            case 100:
                String str2 = auVar.field_content;
                aVar2 = null;
                if (str2 != null) {
                    aVar2 = f.a.ek(str2);
                }
                if (aVar2 != null && 19 == aVar2.type) {
                    lzVar = new lz();
                    lzVar.fTf.type = 3;
                    lzVar.fTf.fGM = auVar.field_msgId;
                    com.tencent.mm.sdk.b.a.urY.m(lzVar);
                }
                ay.L(auVar.field_msgId);
                if (aVar2 != null) {
                    com.tencent.mm.pluginsdk.model.app.f aJ = g.aJ(aVar2.appId, false);
                    if (aJ != null && aJ.bCU()) {
                        ah.a(aVar, aVar2, auVar, aJ);
                        break;
                    }
                }
                break;
            case 103:
                str = auVar.field_content;
                if (str != null) {
                    aVar2 = f.a.ek(str);
                    if (aVar2 != null) {
                        switch (aVar2.type) {
                            case 16:
                                lzVar = new hq();
                                lzVar.fNf.fNg = aVar2.fNg;
                                lzVar.fNf.fEU = auVar.field_msgId;
                                lzVar.fNf.fNh = auVar.field_talker;
                                com.tencent.mm.sdk.b.a.urY.m(lzVar);
                                break;
                            default:
                                break;
                        }
                    }
                }
                break;
            case 111:
                d.a(aVar, auVar, a(aVar, auVar));
                break;
            case 114:
                str = auVar.field_content;
                if (str != null) {
                    aVar2 = f.a.ek(str);
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
        r2 = r16.getTag();
        r2 = (com.tencent.mm.ui.chatting.dt) r2;
        r2 = r2.knu;
        r3 = 5;
        if (r2 != r3) goto L_0x0046;
    L_0x000b:
        r0 = r18;
        r2 = r0.field_isSend;
        r3 = 1;
        if (r2 != r3) goto L_0x0046;
    L_0x0012:
        if (r18 == 0) goto L_0x0044;
    L_0x0014:
        r2 = r15.vCd;
        r2 = r2.uSU;
        r2 = r2.uTo;
        r3 = r15.vCd;
        r4 = com.tencent.mm.R.l.dVl;
        r3 = r3.getString(r4);
        r4 = "";
        r5 = r15.vCd;
        r6 = com.tencent.mm.R.l.dIv;
        r5 = r5.getString(r6);
        r6 = r15.vCd;
        r7 = com.tencent.mm.R.l.dGs;
        r6 = r6.getString(r7);
        r7 = new com.tencent.mm.ui.chatting.ba$5;
        r0 = r18;
        r7.<init>(r15, r0);
        r8 = new com.tencent.mm.ui.chatting.ba$6;
        r8.<init>(r15);
        com.tencent.mm.ui.base.g.a(r2, r3, r4, r5, r6, r7, r8);
    L_0x0044:
        r2 = 1;
    L_0x0045:
        return r2;
    L_0x0046:
        r0 = r18;
        r2 = r0.field_content;
        if (r2 != 0) goto L_0x004e;
    L_0x004c:
        r2 = 0;
        goto L_0x0045;
    L_0x004e:
        r3 = com.tencent.mm.t.f.a.ek(r2);
        if (r3 != 0) goto L_0x0056;
    L_0x0054:
        r2 = 0;
        goto L_0x0045;
    L_0x0056:
        r2 = r3.appId;
        r4 = 1;
        r5 = com.tencent.mm.pluginsdk.model.app.g.aJ(r2, r4);
        if (r5 == 0) goto L_0x007a;
    L_0x005f:
        r2 = r5.field_appId;
        r2 = com.tencent.mm.sdk.platformtools.bg.mA(r2);
        if (r2 != 0) goto L_0x007a;
    L_0x0067:
        r2 = r5.bCU();
        if (r2 == 0) goto L_0x007a;
    L_0x006d:
        r4 = com.tencent.mm.u.m.xL();
        r0 = r18;
        r6 = r0.field_msgSvrId;
        r2 = r17;
        com.tencent.mm.ui.chatting.ah.a(r2, r3, r4, r5, r6);
    L_0x007a:
        r7 = 0;
        r2 = r3.type;
        switch(r2) {
            case 3: goto L_0x01b0;
            case 4: goto L_0x01cc;
            case 5: goto L_0x0219;
            case 6: goto L_0x00d6;
            case 7: goto L_0x0660;
            case 8: goto L_0x0080;
            case 9: goto L_0x0080;
            case 10: goto L_0x0679;
            case 11: goto L_0x0080;
            case 12: goto L_0x0080;
            case 13: goto L_0x0705;
            case 14: goto L_0x0080;
            case 15: goto L_0x0080;
            case 16: goto L_0x073b;
            case 17: goto L_0x0080;
            case 18: goto L_0x0080;
            case 19: goto L_0x0772;
            case 20: goto L_0x06bf;
            case 21: goto L_0x0080;
            case 22: goto L_0x0080;
            case 23: goto L_0x0080;
            case 24: goto L_0x07a2;
            case 25: goto L_0x0080;
            case 26: goto L_0x0080;
            case 27: goto L_0x0080;
            case 28: goto L_0x0080;
            case 29: goto L_0x0080;
            case 30: goto L_0x0080;
            case 31: goto L_0x0080;
            case 32: goto L_0x0080;
            case 33: goto L_0x0425;
            case 34: goto L_0x07c7;
            case 35: goto L_0x0080;
            case 36: goto L_0x0573;
            default: goto L_0x0080;
        };
    L_0x0080:
        r2 = r3.url;
        if (r2 == 0) goto L_0x09d0;
    L_0x0084:
        r2 = r3.url;
        r4 = "";
        r2 = r2.equals(r4);
        if (r2 != 0) goto L_0x09d0;
    L_0x008f:
        r2 = r3.canvasPageXml;
        r2 = com.tencent.mm.sdk.platformtools.bg.mA(r2);
        if (r2 != 0) goto L_0x0818;
    L_0x0097:
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
        goto L_0x0045;
    L_0x00d6:
        com.tencent.mm.u.ap.yY();
        r2 = com.tencent.mm.u.c.isSDCardAvailable();
        if (r2 != 0) goto L_0x00eb;
    L_0x00df:
        r0 = r17;
        r2 = r0.uSU;
        r2 = r2.uTo;
        com.tencent.mm.ui.base.s.eP(r2);
        r2 = 1;
        goto L_0x0045;
    L_0x00eb:
        r2 = r3.hhr;
        r2 = com.tencent.mm.sdk.platformtools.bg.Qm(r2);
        if (r2 == 0) goto L_0x018d;
    L_0x00f3:
        r0 = r18;
        r4 = r0.field_msgId;
        r2 = r3.fCW;
        r3 = com.tencent.mm.pluginsdk.model.app.an.abL();
        r3 = r3.LW(r2);
        if (r3 == 0) goto L_0x0109;
    L_0x0103:
        r6 = r3.azf();
        if (r6 != 0) goto L_0x010f;
    L_0x0109:
        r2 = 0;
    L_0x010a:
        if (r2 == 0) goto L_0x018d;
    L_0x010c:
        r2 = 1;
        goto L_0x0045;
    L_0x010f:
        com.tencent.mm.u.ap.yY();
        r6 = com.tencent.mm.u.c.wT();
        r6 = r6.cA(r4);
        r7 = r6.bMt();
        if (r7 == 0) goto L_0x0163;
    L_0x0120:
        r3 = "MicroMsg.ChattingItemAppMsgTo";
        r7 = "openImg:: msg is clean, attachId %s, msgId: %d, msgSvrId: %d, imgPath: %s";
        r8 = 4;
        r8 = new java.lang.Object[r8];
        r9 = 0;
        r8[r9] = r2;
        r2 = 1;
        r4 = java.lang.Long.valueOf(r4);
        r8[r2] = r4;
        r2 = 2;
        r4 = r6.field_msgSvrId;
        r4 = java.lang.Long.valueOf(r4);
        r8[r2] = r4;
        r2 = 3;
        r4 = r6.field_imgPath;
        r8[r2] = r4;
        com.tencent.mm.sdk.platformtools.w.i(r3, r7, r8);
        r2 = new android.content.Intent;
        r2.<init>();
        r3 = r15.vCd;
        r3 = r3.uSU;
        r3 = r3.uTo;
        r4 = "com.tencent.mm.ui.chatting.ResourcesExceedUI";
        r2.setClassName(r3, r4);
        r3 = "clean_view_type";
        r4 = 1;
        r2.putExtra(r3, r4);
        r3 = r15.vCd;
        r3.startActivity(r2);
        r2 = 1;
        goto L_0x010a;
    L_0x0163:
        r2 = new android.content.Intent;
        r6 = r15.vCd;
        r6 = r6.uSU;
        r6 = r6.uTo;
        r7 = com.tencent.mm.ui.tools.ShowImageUI.class;
        r2.<init>(r6, r7);
        r6 = "key_image_path";
        r3 = r3.field_fileFullPath;
        r2.putExtra(r6, r3);
        r3 = "key_message_id";
        r2.putExtra(r3, r4);
        r3 = "key_favorite";
        r4 = 1;
        r2.putExtra(r3, r4);
        r3 = r15.vCd;
        r3.startActivity(r2);
        r2 = 1;
        goto L_0x010a;
    L_0x018d:
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
        goto L_0x0045;
    L_0x01b0:
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
    L_0x01cc:
        r0 = r17;
        r1 = r18;
        r2 = r15.a(r0, r3, r1);
        if (r2 == 0) goto L_0x01d9;
    L_0x01d6:
        r2 = 1;
        goto L_0x0045;
    L_0x01d9:
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
        if (r2 != 0) goto L_0x0213;
    L_0x01f9:
        r6 = 0;
    L_0x01fa:
        if (r2 != 0) goto L_0x0216;
    L_0x01fc:
        r7 = 0;
    L_0x01fd:
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
        goto L_0x0045;
    L_0x0213:
        r6 = r2.versionName;
        goto L_0x01fa;
    L_0x0216:
        r7 = r2.versionCode;
        goto L_0x01fd;
    L_0x0219:
        r2 = r3.canvasPageXml;
        r2 = com.tencent.mm.sdk.platformtools.bg.mA(r2);
        if (r2 != 0) goto L_0x0260;
    L_0x0221:
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
        goto L_0x0045;
    L_0x0260:
        r2 = r3.url;
        if (r2 == 0) goto L_0x0405;
    L_0x0264:
        r2 = r3.url;
        r4 = "";
        r2 = r2.equals(r4);
        if (r2 != 0) goto L_0x0405;
    L_0x026f:
        r4 = r3.url;
        r0 = r17;
        r2 = r0.vBH;
        if (r2 == 0) goto L_0x0408;
    L_0x0277:
        r2 = "groupmessage";
    L_0x027a:
        r2 = com.tencent.mm.pluginsdk.model.app.p.s(r4, r2);
        r4 = r3.hhp;
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
        r2 = new android.os.Bundle;
        r2.<init>();
        r7 = "key_snsad_statextstr";
        r8 = r3.fUY;
        r2.putString(r7, r8);
        r7 = r3.appId;
        if (r7 == 0) goto L_0x02d9;
    L_0x02b0:
        r7 = "wx751a1acca5688ba3";
        r8 = r3.appId;
        r7 = r7.equals(r8);
        if (r7 != 0) goto L_0x02d1;
    L_0x02bb:
        r7 = "wxfbc915ff7c30e335";
        r8 = r3.appId;
        r7 = r7.equals(r8);
        if (r7 != 0) goto L_0x02d1;
    L_0x02c6:
        r7 = "wx482a4001c37e2b74";
        r8 = r3.appId;
        r7 = r7.equals(r8);
        if (r7 == 0) goto L_0x02d9;
    L_0x02d1:
        r7 = "jsapi_args_appid";
        r8 = r3.appId;
        r2.putString(r7, r8);
    L_0x02d9:
        r7 = "jsapiargs";
        r6.putExtra(r7, r2);
        r2 = com.tencent.mm.sdk.platformtools.bg.mA(r4);
        if (r2 != 0) goto L_0x040d;
    L_0x02e5:
        r2 = "shortUrl";
        r6.putExtra(r2, r4);
    L_0x02eb:
        r4 = "version_name";
        if (r5 != 0) goto L_0x0417;
    L_0x02f0:
        r2 = 0;
    L_0x02f1:
        r6.putExtra(r4, r2);
        r4 = "version_code";
        if (r5 != 0) goto L_0x041b;
    L_0x02f9:
        r2 = 0;
    L_0x02fa:
        r6.putExtra(r4, r2);
        r2 = r3.fUR;
        r2 = com.tencent.mm.sdk.platformtools.bg.mA(r2);
        if (r2 != 0) goto L_0x0315;
    L_0x0305:
        r2 = "srcUsername";
        r4 = r3.fUR;
        r6.putExtra(r2, r4);
        r2 = "srcDisplayname";
        r4 = r3.fUS;
        r6.putExtra(r2, r4);
    L_0x0315:
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
            case 1: goto L_0x0421;
            case 2: goto L_0x041f;
            case 3: goto L_0x03ba;
            case 4: goto L_0x03ba;
            case 5: goto L_0x03ba;
            case 6: goto L_0x0423;
            case 7: goto L_0x0423;
            default: goto L_0x03ba;
        };
    L_0x03ba:
        r2 = 0;
    L_0x03bb:
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
        if (r2 != r3) goto L_0x03f6;
    L_0x03ec:
        r2 = "share_report_biz_username";
        r3 = r17.bUg();
        r6.putExtra(r2, r3);
    L_0x03f6:
        r0 = r17;
        r2 = r0.uSU;
        r2 = r2.uTo;
        r3 = "webview";
        r4 = ".ui.tools.WebViewUI";
        com.tencent.mm.bb.d.b(r2, r3, r4, r6);
    L_0x0405:
        r2 = 1;
        goto L_0x0045;
    L_0x0408:
        r2 = "singlemessage";
        goto L_0x027a;
    L_0x040d:
        r2 = "shortUrl";
        r4 = r3.url;
        r6.putExtra(r2, r4);
        goto L_0x02eb;
    L_0x0417:
        r2 = r5.versionName;
        goto L_0x02f1;
    L_0x041b:
        r2 = r5.versionCode;
        goto L_0x02fa;
    L_0x041f:
        r2 = 2;
        goto L_0x03bb;
    L_0x0421:
        r2 = 3;
        goto L_0x03bb;
    L_0x0423:
        r2 = 5;
        goto L_0x03bb;
    L_0x0425:
        r2 = "MicroMsg.ChattingItemAppMsgTo";
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
        if (r2 == 0) goto L_0x04a8;
    L_0x046a:
        r4 = "stat_scene";
        r2 = 10;
        r5 = r6;
    L_0x0470:
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
            case 1: goto L_0x04c3;
            case 2: goto L_0x0543;
            case 3: goto L_0x0569;
            default: goto L_0x04a2;
        };
    L_0x04a2:
        r2 = 1;
    L_0x04a3:
        if (r2 != 0) goto L_0x0080;
    L_0x04a5:
        r2 = 1;
        goto L_0x0045;
    L_0x04a8:
        r0 = r17;
        r2 = r0.vBH;
        if (r2 == 0) goto L_0x04b4;
    L_0x04ae:
        r4 = "stat_scene";
        r2 = 2;
        r5 = r6;
        goto L_0x0470;
    L_0x04b4:
        r4 = "stat_scene";
        r2 = com.tencent.mm.u.o.eV(r8);
        if (r2 == 0) goto L_0x04c0;
    L_0x04bd:
        r2 = 7;
        r5 = r6;
        goto L_0x0470;
    L_0x04c0:
        r2 = 1;
        r5 = r6;
        goto L_0x0470;
    L_0x04c3:
        r2 = new android.content.Intent;
        r2.<init>();
        r4 = "key_username";
        r5 = r3.hjM;
        r2.putExtra(r4, r5);
        r0 = r17;
        r4 = r0.vBH;
        if (r4 == 0) goto L_0x0535;
    L_0x04d6:
        r4 = "key_from_scene";
        r5 = 1;
        r2.putExtra(r4, r5);
        r4 = "key_scene_note";
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r8 = r17.bUg();
        r5 = r5.append(r8);
        r8 = ":";
        r5 = r5.append(r8);
        r5 = r5.append(r9);
        r5 = r5.toString();
        r2.putExtra(r4, r5);
    L_0x04ff:
        r4 = "_stat_obj";
        r2.putExtra(r4, r6);
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
        r0 = r17;
        r4 = r0.uSU;
        r4 = r4.uTo;
        r5 = "appbrand";
        r6 = ".ui.AppBrandProfileUI";
        com.tencent.mm.bb.d.b(r4, r5, r6, r2);
        r2 = r7;
        goto L_0x04a3;
    L_0x0535:
        r4 = "key_from_scene";
        r5 = 2;
        r2.putExtra(r4, r5);
        r4 = "key_scene_note";
        r2.putExtra(r4, r8);
        goto L_0x04ff;
    L_0x0543:
        r0 = r17;
        r2 = r0 instanceof com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.a;
        if (r2 == 0) goto L_0x0551;
    L_0x0549:
        r2 = 1073; // 0x431 float:1.504E-42 double:5.3E-321;
        com.tencent.mm.modelappbrand.a.a(r8, r2, r3, r6);
        r2 = r7;
        goto L_0x04a3;
    L_0x0551:
        r2 = com.tencent.mm.u.o.eV(r8);
        if (r2 == 0) goto L_0x055f;
    L_0x0557:
        r2 = 1074; // 0x432 float:1.505E-42 double:5.306E-321;
        com.tencent.mm.modelappbrand.a.a(r8, r2, r3, r6);
        r2 = r7;
        goto L_0x04a3;
    L_0x055f:
        r0 = r17;
        r2 = r0.vBH;
        com.tencent.mm.modelappbrand.a.c(r8, r9, r2, r3, r6);
        r2 = r7;
        goto L_0x04a3;
    L_0x0569:
        r0 = r17;
        r2 = r0.vBH;
        com.tencent.mm.modelappbrand.a.d(r8, r9, r2, r3, r6);
        r2 = r7;
        goto L_0x04a3;
    L_0x0573:
        r2 = r3.hjN;
        r2 = com.tencent.mm.sdk.platformtools.bg.mA(r2);
        if (r2 == 0) goto L_0x05c3;
    L_0x057b:
        r2 = r3.hjM;
        r2 = com.tencent.mm.sdk.platformtools.bg.mA(r2);
        if (r2 == 0) goto L_0x05c3;
    L_0x0583:
        r4 = r3.url;
        r0 = r17;
        r2 = r0.vBH;
        if (r2 == 0) goto L_0x05bf;
    L_0x058b:
        r2 = "groupmessage";
    L_0x058e:
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
        goto L_0x0045;
    L_0x05bf:
        r2 = "singlemessage";
        goto L_0x058e;
    L_0x05c3:
        r7 = r17.bUg();
        r0 = r17;
        r1 = r18;
        r8 = r15.a(r0, r1);
        r6 = new android.os.Bundle;
        r6.<init>();
        r0 = r17;
        r2 = r0.vBH;
        if (r2 == 0) goto L_0x063d;
    L_0x05da:
        r4 = "stat_scene";
        r2 = 2;
        r5 = r6;
    L_0x05df:
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
        r4 = "MicroMsg.ChattingItemAppMsgTo";
        r5 = "withShareTicket = %b";
        r7 = 1;
        r7 = new java.lang.Object[r7];
        r8 = 0;
        r9 = java.lang.Boolean.valueOf(r2);
        r7[r8] = r9;
        com.tencent.mm.sdk.platformtools.w.i(r4, r5, r7);
        if (r2 == 0) goto L_0x064c;
    L_0x0627:
        r2 = r17.bUg();
        r0 = r17;
        r1 = r18;
        r4 = r15.a(r0, r1);
        r0 = r17;
        r5 = r0.vBH;
        com.tencent.mm.modelappbrand.a.b(r2, r4, r5, r3, r6);
    L_0x063a:
        r2 = 1;
        goto L_0x0045;
    L_0x063d:
        r4 = "stat_scene";
        r2 = com.tencent.mm.u.o.eV(r7);
        if (r2 == 0) goto L_0x0649;
    L_0x0646:
        r2 = 7;
        r5 = r6;
        goto L_0x05df;
    L_0x0649:
        r2 = 1;
        r5 = r6;
        goto L_0x05df;
    L_0x064c:
        r2 = r17.bUg();
        r0 = r17;
        r1 = r18;
        r4 = r15.a(r0, r1);
        r0 = r17;
        r5 = r0.vBH;
        com.tencent.mm.modelappbrand.a.a(r2, r4, r5, r3, r6);
        goto L_0x063a;
    L_0x0660:
        if (r5 == 0) goto L_0x0673;
    L_0x0662:
        r2 = r5.bCU();
        if (r2 == 0) goto L_0x0673;
    L_0x0668:
        r0 = r17;
        r2 = com.tencent.mm.ui.chatting.ah.a(r0, r5);
        if (r2 == 0) goto L_0x0673;
    L_0x0670:
        r2 = 1;
        goto L_0x0045;
    L_0x0673:
        r17.aw(r18);
        r2 = 1;
        goto L_0x0045;
    L_0x0679:
        r2 = r3.hhM;
        r2 = com.tencent.mm.sdk.platformtools.bg.mA(r2);
        if (r2 == 0) goto L_0x0684;
    L_0x0681:
        r2 = 0;
        goto L_0x0045;
    L_0x0684:
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
        if (r3 != 0) goto L_0x06ad;
    L_0x06a3:
        r3 = "key_ProductUI_chatting_msgId";
        r0 = r18;
        r4 = r0.field_msgId;
        r2.putExtra(r3, r4);
    L_0x06ad:
        r0 = r17;
        r3 = r0.uSU;
        r3 = r3.uTo;
        r4 = "scanner";
        r5 = ".ui.ProductUI";
        com.tencent.mm.bb.d.b(r3, r4, r5, r2);
        r2 = 1;
        goto L_0x0045;
    L_0x06bf:
        r2 = r3.hhP;
        r2 = com.tencent.mm.sdk.platformtools.bg.mA(r2);
        if (r2 == 0) goto L_0x06ca;
    L_0x06c7:
        r2 = 0;
        goto L_0x0045;
    L_0x06ca:
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
        if (r3 != 0) goto L_0x06f3;
    L_0x06e9:
        r3 = "key_TVInfoUI_chatting_msgId";
        r0 = r18;
        r4 = r0.field_msgId;
        r2.putExtra(r3, r4);
    L_0x06f3:
        r0 = r17;
        r3 = r0.uSU;
        r3 = r3.uTo;
        r4 = "shake";
        r5 = ".ui.TVInfoUI";
        com.tencent.mm.bb.d.b(r3, r4, r5, r2);
        r2 = 1;
        goto L_0x0045;
    L_0x0705:
        r2 = r3.hhS;
        r2 = com.tencent.mm.sdk.platformtools.bg.mA(r2);
        if (r2 == 0) goto L_0x0710;
    L_0x070d:
        r2 = 0;
        goto L_0x0045;
    L_0x0710:
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
        goto L_0x0045;
    L_0x073b:
        r2 = r3.fNg;
        r2 = com.tencent.mm.sdk.platformtools.bg.mA(r2);
        if (r2 == 0) goto L_0x0746;
    L_0x0743:
        r2 = 0;
        goto L_0x0045;
    L_0x0746:
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
        goto L_0x0045;
    L_0x0772:
        r2 = new android.content.Intent;
        r2.<init>();
        r4 = "message_id";
        r0 = r18;
        r6 = r0.field_msgId;
        r2.putExtra(r4, r6);
        r4 = "record_xml";
        r3 = r3.hhQ;
        r2.putExtra(r4, r3);
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
        goto L_0x0045;
    L_0x07a2:
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
        goto L_0x0045;
    L_0x07c7:
        r2 = new android.content.Intent;
        r2.<init>();
        r4 = "key_biz_uin";
        r5 = r3.hiC;
        r2.putExtra(r4, r5);
        r4 = "key_order_id";
        r3 = r3.hiD;
        r2.putExtra(r4, r3);
        r0 = r18;
        r3 = r0.field_talker;
        if (r3 == 0) goto L_0x0806;
    L_0x07e2:
        r0 = r18;
        r3 = r0.field_talker;
        r4 = "";
        r3 = r3.equals(r4);
        if (r3 != 0) goto L_0x0806;
    L_0x07ef:
        r0 = r18;
        r3 = r0.field_talker;
        r4 = "@chatroom";
        r3 = r3.endsWith(r4);
        if (r3 == 0) goto L_0x0806;
    L_0x07fc:
        r3 = "key_chatroom_name";
        r0 = r18;
        r4 = r0.field_talker;
        r2.putExtra(r3, r4);
    L_0x0806:
        r0 = r17;
        r3 = r0.uSU;
        r3 = r3.uTo;
        r4 = "card";
        r5 = ".ui.CardGiftAcceptUI";
        com.tencent.mm.bb.d.b(r3, r4, r5, r2);
        r2 = 1;
        goto L_0x0045;
    L_0x0818:
        r4 = r3.url;
        r0 = r17;
        r2 = r0.vBH;
        if (r2 == 0) goto L_0x09b3;
    L_0x0820:
        r2 = "groupmessage";
    L_0x0823:
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
        if (r2 == 0) goto L_0x0880;
    L_0x084c:
        r2 = "wx751a1acca5688ba3";
        r7 = r3.appId;
        r2 = r2.equals(r7);
        if (r2 != 0) goto L_0x086d;
    L_0x0857:
        r2 = "wxfbc915ff7c30e335";
        r7 = r3.appId;
        r2 = r2.equals(r7);
        if (r2 != 0) goto L_0x086d;
    L_0x0862:
        r2 = "wx482a4001c37e2b74";
        r7 = r3.appId;
        r2 = r2.equals(r7);
        if (r2 == 0) goto L_0x0880;
    L_0x086d:
        r2 = new android.os.Bundle;
        r2.<init>();
        r7 = "jsapi_args_appid";
        r8 = r3.appId;
        r2.putString(r7, r8);
        r7 = "jsapiargs";
        r6.putExtra(r7, r2);
    L_0x0880:
        r2 = com.tencent.mm.sdk.platformtools.bg.mA(r4);
        if (r2 != 0) goto L_0x09b8;
    L_0x0886:
        r2 = "shortUrl";
        r6.putExtra(r2, r4);
    L_0x088c:
        r4 = "version_name";
        if (r5 != 0) goto L_0x09c2;
    L_0x0891:
        r2 = 0;
    L_0x0892:
        r6.putExtra(r4, r2);
        r4 = "version_code";
        if (r5 != 0) goto L_0x09c6;
    L_0x089a:
        r2 = 0;
    L_0x089b:
        r6.putExtra(r4, r2);
        r2 = r3.fUR;
        r2 = com.tencent.mm.sdk.platformtools.bg.mA(r2);
        if (r2 != 0) goto L_0x08b6;
    L_0x08a6:
        r2 = "srcUsername";
        r4 = r3.fUR;
        r6.putExtra(r2, r4);
        r2 = "srcDisplayname";
        r4 = r3.fUS;
        r6.putExtra(r2, r4);
    L_0x08b6:
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
            case 1: goto L_0x09cc;
            case 2: goto L_0x09ca;
            case 3: goto L_0x0965;
            case 4: goto L_0x0965;
            case 5: goto L_0x0965;
            case 6: goto L_0x09ce;
            case 7: goto L_0x09ce;
            default: goto L_0x0965;
        };
    L_0x0965:
        r2 = 0;
    L_0x0966:
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
        if (r2 != r3) goto L_0x09a1;
    L_0x0997:
        r2 = "share_report_biz_username";
        r3 = r17.bUg();
        r6.putExtra(r2, r3);
    L_0x09a1:
        r0 = r17;
        r2 = r0.uSU;
        r2 = r2.uTo;
        r3 = "webview";
        r4 = ".ui.tools.WebViewUI";
        com.tencent.mm.bb.d.b(r2, r3, r4, r6);
        r2 = 1;
        goto L_0x0045;
    L_0x09b3:
        r2 = "singlemessage";
        goto L_0x0823;
    L_0x09b8:
        r2 = "shortUrl";
        r4 = r3.url;
        r6.putExtra(r2, r4);
        goto L_0x088c;
    L_0x09c2:
        r2 = r5.versionName;
        goto L_0x0892;
    L_0x09c6:
        r2 = r5.versionCode;
        goto L_0x089b;
    L_0x09ca:
        r2 = 2;
        goto L_0x0966;
    L_0x09cc:
        r2 = 3;
        goto L_0x0966;
    L_0x09ce:
        r2 = 5;
        goto L_0x0966;
    L_0x09d0:
        r2 = 0;
        goto L_0x0045;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.ba.a(android.view.View, com.tencent.mm.ui.chatting.En_5b8fbb1e$a, com.tencent.mm.storage.au):boolean");
    }
}
