package com.tencent.mm.plugin.favorite.ui.c;

import android.text.SpannableString;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.jsapi.cs;
import com.tencent.mm.plugin.favorite.c.g;
import com.tencent.mm.plugin.favorite.ui.c.a.b;
import java.util.HashMap;

public final class r extends a {
    private static int lMV;
    private static int lMW;
    private final int lMT;
    private final String lNi;
    private final SparseIntArray lNj = new SparseIntArray();
    private HashMap<String, SpannableString> lNk = new HashMap();

    public static class a extends b {
        ImageView jbU;
        ImageView lNA;
        TextView lNB;
        TextView lNC;
        LinearLayout lND;
        ImageView lNl;
        ImageView lNm;
        TextView lNn;
        TextView lNo;
        FrameLayout lNr;
        TextView lNy;
        LinearLayout lNz;
    }

    public r(g gVar) {
        super(gVar);
        this.lMT = com.tencent.mm.bg.a.fromDPToPix(gVar.context, 60);
        this.lNi = " ";
        lMW = com.tencent.mm.bg.a.fromDPToPix(gVar.context, 138);
        lMV = com.tencent.mm.bg.a.fromDPToPix(gVar.context, cs.CTRL_INDEX);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View a(android.view.View r26, android.view.ViewGroup r27, com.tencent.mm.plugin.favorite.b.j r28) {
        /*
        r25 = this;
        r17 = r27.getContext();
        if (r26 != 0) goto L_0x0101;
    L_0x0006:
        r5 = new com.tencent.mm.plugin.favorite.ui.c.r$a;
        r5.<init>();
        r4 = com.tencent.mm.R.i.dcu;
        r6 = 0;
        r0 = r17;
        r4 = android.view.View.inflate(r0, r4, r6);
        r0 = r25;
        r1 = r28;
        r26 = r0.a(r4, r5, r1);
        r4 = com.tencent.mm.R.h.bOx;
        r0 = r26;
        r4 = r0.findViewById(r4);
        r4 = (android.widget.ImageView) r4;
        r5.jbU = r4;
        r4 = com.tencent.mm.R.h.bOy;
        r0 = r26;
        r4 = r0.findViewById(r4);
        r4 = (android.widget.FrameLayout) r4;
        r5.lNr = r4;
        r4 = com.tencent.mm.R.h.bOZ;
        r0 = r26;
        r4 = r0.findViewById(r4);
        r4 = (android.widget.TextView) r4;
        r5.lNn = r4;
        r4 = com.tencent.mm.R.h.bOk;
        r0 = r26;
        r4 = r0.findViewById(r4);
        r4 = (android.widget.TextView) r4;
        r5.lNo = r4;
        r4 = com.tencent.mm.R.h.bOW;
        r0 = r26;
        r4 = r0.findViewById(r4);
        r4 = (android.widget.LinearLayout) r4;
        r5.lNz = r4;
        r4 = com.tencent.mm.R.h.bOB;
        r0 = r26;
        r4 = r0.findViewById(r4);
        r4 = (android.widget.ImageView) r4;
        r5.lNl = r4;
        r4 = com.tencent.mm.R.h.bOA;
        r0 = r26;
        r4 = r0.findViewById(r4);
        r4 = (android.widget.ImageView) r4;
        r5.lNm = r4;
        r4 = com.tencent.mm.R.h.bPd;
        r0 = r26;
        r4 = r0.findViewById(r4);
        r4 = (android.widget.TextView) r4;
        r5.lNy = r4;
        r4 = com.tencent.mm.R.h.bOG;
        r0 = r26;
        r4 = r0.findViewById(r4);
        r4 = (android.widget.ImageView) r4;
        r5.lNA = r4;
        r4 = com.tencent.mm.R.h.bOH;
        r0 = r26;
        r4 = r0.findViewById(r4);
        r4 = (android.widget.TextView) r4;
        r5.lNB = r4;
        r4 = com.tencent.mm.R.h.bOF;
        r0 = r26;
        r4 = r0.findViewById(r4);
        r4 = (android.widget.TextView) r4;
        r5.lNC = r4;
        r4 = com.tencent.mm.R.h.bND;
        r0 = r26;
        r4 = r0.findViewById(r4);
        r4 = (android.widget.LinearLayout) r4;
        r5.lND = r4;
        r12 = r5;
    L_0x00ad:
        r0 = r25;
        r1 = r28;
        r0.a(r12, r1);
        r15 = 0;
        r14 = 0;
        r13 = 0;
        r11 = 0;
        r10 = 0;
        r9 = 0;
        r8 = 0;
        r7 = 0;
        r6 = 0;
        r5 = 0;
        r4 = 0;
        r0 = r28;
        r0 = r0.field_favProto;
        r16 = r0;
        r0 = r16;
        r0 = r0.tzn;
        r18 = r0;
        r19 = r18.iterator();
        r16 = r15;
        r15 = r14;
        r14 = r13;
        r13 = r11;
        r11 = r10;
        r10 = r9;
        r9 = r8;
        r8 = r7;
        r7 = r6;
        r6 = r5;
        r5 = r4;
    L_0x00db:
        r4 = r19.hasNext();
        if (r4 == 0) goto L_0x01d3;
    L_0x00e1:
        r4 = r19.next();
        r4 = (com.tencent.mm.protocal.c.rm) r4;
        if (r14 != 0) goto L_0x0144;
    L_0x00e9:
        r20 = new java.io.File;
        r21 = com.tencent.mm.plugin.favorite.b.x.g(r4);
        r20.<init>(r21);
        r21 = r20.exists();
        if (r21 != 0) goto L_0x0109;
    L_0x00f8:
        r0 = r28;
        com.tencent.mm.plugin.favorite.c.g.a(r0, r4);
    L_0x00fd:
        r4 = r14 + 1;
        r14 = r4;
        goto L_0x00db;
    L_0x0101:
        r4 = r26.getTag();
        r4 = (com.tencent.mm.plugin.favorite.ui.c.r.a) r4;
        r12 = r4;
        goto L_0x00ad;
    L_0x0109:
        r4 = r4.tyk;
        if (r4 != 0) goto L_0x00fd;
    L_0x010d:
        r4 = new com.tencent.mm.e.a.ka;
        r4.<init>();
        r0 = r4.fQo;
        r21 = r0;
        r22 = 10;
        r0 = r22;
        r1 = r21;
        r1.type = r0;
        r0 = r4.fQo;
        r21 = r0;
        r0 = r28;
        r0 = r0.field_localId;
        r22 = r0;
        r0 = r22;
        r2 = r21;
        r2.field_localId = r0;
        r0 = r4.fQo;
        r21 = r0;
        r20 = r20.getAbsolutePath();
        r0 = r20;
        r1 = r21;
        r1.path = r0;
        r20 = com.tencent.mm.sdk.b.a.urY;
        r0 = r20;
        r0.m(r4);
        goto L_0x00fd;
    L_0x0144:
        r0 = r4.aMw;
        r20 = r0;
        switch(r20) {
            case 1: goto L_0x016d;
            case 2: goto L_0x0160;
            case 3: goto L_0x01a5;
            case 4: goto L_0x0160;
            case 5: goto L_0x0199;
            case 6: goto L_0x01b1;
            case 7: goto L_0x0199;
            case 8: goto L_0x0199;
            case 9: goto L_0x014b;
            case 10: goto L_0x0199;
            case 11: goto L_0x0199;
            case 12: goto L_0x014b;
            case 13: goto L_0x014b;
            case 14: goto L_0x0199;
            case 15: goto L_0x014b;
            case 16: goto L_0x0199;
            default: goto L_0x014b;
        };
    L_0x014b:
        r4 = r5;
        r5 = r6;
        r6 = r7;
        r7 = r8;
        r8 = r9;
        r9 = r10;
        r10 = r11;
        r11 = r13;
    L_0x0153:
        r13 = r14 + 1;
        r14 = r13;
        r13 = r11;
        r11 = r10;
        r10 = r9;
        r9 = r8;
        r8 = r7;
        r7 = r6;
        r6 = r5;
        r5 = r4;
        goto L_0x00db;
    L_0x0160:
        if (r9 != 0) goto L_0x014b;
    L_0x0162:
        r9 = 1;
        r4 = r5;
        r15 = r14;
        r5 = r6;
        r6 = r7;
        r7 = r8;
        r8 = r9;
        r9 = r10;
        r10 = r11;
        r11 = r13;
        goto L_0x0153;
    L_0x016d:
        if (r5 != 0) goto L_0x014b;
    L_0x016f:
        r4 = r4.desc;
        r20 = com.tencent.mm.sdk.platformtools.bg.mA(r4);
        if (r20 != 0) goto L_0x014b;
    L_0x0177:
        r20 = "\n";
        r21 = "";
        r0 = r20;
        r1 = r21;
        r4 = r4.replaceAll(r0, r1);
        r4 = r4.trim();
        r4 = com.tencent.mm.sdk.platformtools.bg.mA(r4);
        if (r4 != 0) goto L_0x014b;
    L_0x018f:
        r5 = 1;
        r4 = r5;
        r10 = r11;
        r5 = r6;
        r11 = r13;
        r6 = r7;
        r7 = r8;
        r8 = r9;
        r9 = r14;
        goto L_0x0153;
    L_0x0199:
        if (r8 != 0) goto L_0x014b;
    L_0x019b:
        r8 = 1;
        r4 = r5;
        r11 = r13;
        r5 = r6;
        r6 = r7;
        r7 = r8;
        r8 = r9;
        r9 = r10;
        r10 = r14;
        goto L_0x0153;
    L_0x01a5:
        if (r6 != 0) goto L_0x014b;
    L_0x01a7:
        r6 = 1;
        r4 = r5;
        r5 = r6;
        r6 = r7;
        r7 = r8;
        r8 = r9;
        r9 = r10;
        r10 = r11;
        r11 = r14;
        goto L_0x0153;
    L_0x01b1:
        r20 = com.tencent.mm.pluginsdk.model.c.sCd;
        if (r20 != 0) goto L_0x01c5;
    L_0x01b5:
        r20 = com.tencent.mm.u.ap.vL();
        r21 = new com.tencent.mm.plugin.favorite.ui.c.r$1;
        r0 = r21;
        r1 = r25;
        r0.<init>(r1, r4);
        r20.D(r21);
    L_0x01c5:
        if (r7 != 0) goto L_0x014b;
    L_0x01c7:
        r7 = 1;
        r4 = r5;
        r16 = r14;
        r5 = r6;
        r6 = r7;
        r7 = r8;
        r8 = r9;
        r9 = r10;
        r10 = r11;
        r11 = r13;
        goto L_0x0153;
    L_0x01d3:
        r4 = "MicroMsg.FavWNNoteListItem";
        r14 = "hasThumb %s, firstRemarkIndex %d";
        r19 = 2;
        r0 = r19;
        r0 = new java.lang.Object[r0];
        r19 = r0;
        r20 = 0;
        r21 = java.lang.Boolean.valueOf(r9);
        r19[r20] = r21;
        r20 = 1;
        r21 = 0;
        r21 = java.lang.Integer.valueOf(r21);
        r19[r20] = r21;
        r0 = r19;
        com.tencent.mm.sdk.platformtools.w.d(r4, r14, r0);
        r4 = r12.lNr;
        r14 = 8;
        r4.setVisibility(r14);
        r4 = r12.lNz;
        r14 = 8;
        r4.setVisibility(r14);
        r4 = r12.lND;
        r14 = 8;
        r4.setVisibility(r14);
        r4 = r12.lNn;
        r14 = 8;
        r4.setVisibility(r14);
        r4 = r12.lNo;
        r14 = 8;
        r4.setVisibility(r14);
        r4 = r12.lNl;
        r14 = 8;
        r4.setVisibility(r14);
        r4 = r12.lNy;
        r14 = 8;
        r4.setVisibility(r14);
        r4 = r18.size();
        r14 = 2;
        if (r4 >= r14) goto L_0x023a;
    L_0x0230:
        r4 = "MicroMsg.FavWNNoteListItem";
        r5 = "dataList size is null";
        com.tencent.mm.sdk.platformtools.w.w(r4, r5);
    L_0x0239:
        return r26;
    L_0x023a:
        if (r5 == 0) goto L_0x0331;
    L_0x023c:
        r4 = r12.lNz;
        r5 = 0;
        r4.setVisibility(r5);
        r0 = r18;
        r4 = r0.get(r10);
        r4 = (com.tencent.mm.protocal.c.rm) r4;
        r4 = r4.desc;
        r5 = r4.length();
        r10 = 100;
        if (r5 <= r10) goto L_0x025b;
    L_0x0254:
        r5 = 0;
        r10 = 100;
        r4 = r4.substring(r5, r10);
    L_0x025b:
        r5 = 0;
        r10 = com.tencent.mm.sdk.platformtools.bg.mA(r4);
        if (r10 != 0) goto L_0x04ee;
    L_0x0262:
        r5 = "&lt;";
        r10 = "<";
        r4 = r4.replaceAll(r5, r10);
        r5 = "&gt;";
        r10 = ">";
        r4 = r4.replaceAll(r5, r10);
        r5 = "\n";
        r4 = r4.split(r5);
        r10 = r4;
    L_0x027e:
        if (r10 == 0) goto L_0x0331;
    L_0x0280:
        r4 = r10.length;
        if (r4 <= 0) goto L_0x0331;
    L_0x0283:
        r14 = new java.util.ArrayList;
        r14.<init>();
        r5 = 0;
        r4 = 0;
    L_0x028a:
        r0 = r10.length;
        r19 = r0;
        r0 = r19;
        if (r4 >= r0) goto L_0x04eb;
    L_0x0291:
        r19 = r10[r4];
        r19 = com.tencent.mm.sdk.platformtools.bg.mA(r19);
        if (r19 != 0) goto L_0x02d2;
    L_0x0299:
        r5 = r10[r4];
        r14.add(r5);
    L_0x029e:
        r5 = "";
        r4 = r4 + 1;
        r24 = r5;
        r5 = r4;
        r4 = r24;
    L_0x02a8:
        r0 = r10.length;
        r19 = r0;
        r0 = r19;
        if (r5 >= r0) goto L_0x02d5;
    L_0x02af:
        r19 = new java.lang.StringBuilder;
        r19.<init>();
        r0 = r19;
        r4 = r0.append(r4);
        r19 = r10[r5];
        r0 = r19;
        r4 = r4.append(r0);
        r19 = " ";
        r0 = r19;
        r4 = r4.append(r0);
        r4 = r4.toString();
        r5 = r5 + 1;
        goto L_0x02a8;
    L_0x02d2:
        r4 = r4 + 1;
        goto L_0x028a;
    L_0x02d5:
        r4 = r4.trim();
        r5 = r4.length();
        if (r5 <= 0) goto L_0x02e2;
    L_0x02df:
        r14.add(r4);
    L_0x02e2:
        r4 = r14.size();
        r5 = 1;
        if (r4 <= r5) goto L_0x036b;
    L_0x02e9:
        r4 = r12.lNo;
        r5 = 0;
        r4.setVisibility(r5);
        r4 = r12.lNn;
        r5 = 0;
        r4.setVisibility(r5);
        r5 = r12.lNn;
        r4 = r12.lNn;
        r10 = r4.getContext();
        r4 = 0;
        r4 = r14.get(r4);
        r4 = (java.lang.CharSequence) r4;
        r0 = r12.lNn;
        r19 = r0;
        r19 = r19.getTextSize();
        r0 = r19;
        r4 = com.tencent.mm.pluginsdk.ui.d.h.b(r10, r4, r0);
        r5.setText(r4);
        r5 = r12.lNo;
        r4 = r12.lNo;
        r10 = r4.getContext();
        r4 = 1;
        r4 = r14.get(r4);
        r4 = (java.lang.CharSequence) r4;
        r14 = r12.lNo;
        r14 = r14.getTextSize();
        r4 = com.tencent.mm.pluginsdk.ui.d.h.b(r10, r4, r14);
        r5.setText(r4);
    L_0x0331:
        if (r9 == 0) goto L_0x03e2;
    L_0x0333:
        r4 = r12.lND;
        r5 = 8;
        r4.setVisibility(r5);
        r4 = r12.lNr;
        r5 = 0;
        r4.setVisibility(r5);
        r4 = r12.jbU;
        r5 = 0;
        r4.setVisibility(r5);
        r0 = r18;
        r4 = r0.get(r15);
        r4 = (com.tencent.mm.protocal.c.rm) r4;
        r4 = r4.aMw;
        r5 = 2;
        if (r4 != r5) goto L_0x039c;
    L_0x0353:
        r4 = r12.jbU;
        r5 = com.tencent.mm.R.k.dwW;
        r0 = r18;
        r6 = r0.get(r15);
        r6 = (com.tencent.mm.protocal.c.rm) r6;
        r8 = 1;
        r9 = lMV;
        r10 = lMW;
        r7 = r28;
        com.tencent.mm.plugin.favorite.c.g.a(r4, r5, r6, r7, r8, r9, r10);
        goto L_0x0239;
    L_0x036b:
        r4 = r14.size();
        r5 = 1;
        if (r4 != r5) goto L_0x0331;
    L_0x0372:
        r4 = r12.lNo;
        r5 = 8;
        r4.setVisibility(r5);
        r4 = r12.lNn;
        r5 = 0;
        r4.setVisibility(r5);
        r5 = r12.lNn;
        r4 = r12.lNn;
        r10 = r4.getContext();
        r4 = 0;
        r4 = r14.get(r4);
        r4 = (java.lang.CharSequence) r4;
        r14 = r12.lNn;
        r14 = r14.getTextSize();
        r4 = com.tencent.mm.pluginsdk.ui.d.h.b(r10, r4, r14);
        r5.setText(r4);
        goto L_0x0331;
    L_0x039c:
        r4 = r12.lNl;
        r5 = 0;
        r4.setVisibility(r5);
        r4 = r12.lNy;
        r5 = 0;
        r4.setVisibility(r5);
        r0 = r25;
        r4 = r0.lDs;
        r5 = r12.jbU;
        r0 = r18;
        r6 = r0.get(r15);
        r6 = (com.tencent.mm.protocal.c.rm) r6;
        r0 = r18;
        r7 = r0.get(r15);
        r7 = (com.tencent.mm.protocal.c.rm) r7;
        r8 = r7.fFs;
        r9 = com.tencent.mm.R.k.dwS;
        r10 = lMV;
        r11 = lMW;
        r7 = r28;
        r4.a(r5, r6, r7, r8, r9, r10, r11);
        r5 = r12.lNy;
        r0 = r18;
        r4 = r0.get(r15);
        r4 = (com.tencent.mm.protocal.c.rm) r4;
        r4 = r4.duration;
        r0 = r17;
        r4 = com.tencent.mm.plugin.favorite.b.u.s(r0, r4);
        r5.setText(r4);
        goto L_0x0239;
    L_0x03e2:
        if (r7 == 0) goto L_0x045e;
    L_0x03e4:
        r0 = r18;
        r1 = r16;
        r4 = r0.get(r1);
        r4 = (com.tencent.mm.protocal.c.rm) r4;
        r5 = r12.lNr;
        r6 = 8;
        r5.setVisibility(r6);
        r5 = r12.jbU;
        r6 = 8;
        r5.setVisibility(r6);
        r5 = r12.lND;
        r6 = 0;
        r5.setVisibility(r6);
        r5 = r12.lNA;
        r6 = com.tencent.mm.R.k.dwL;
        r5.setImageResource(r6);
        r5 = r4.tyc;
        r5 = r5.tyw;
        r4 = r4.tyc;
        r4 = r4.iBi;
        r6 = com.tencent.mm.sdk.platformtools.bg.mA(r4);
        if (r6 == 0) goto L_0x043f;
    L_0x0417:
        r4 = r5.fRX;
        r4 = com.tencent.mm.sdk.platformtools.bg.mA(r4);
        if (r4 == 0) goto L_0x042f;
    L_0x041f:
        r4 = r12.lNB;
        r5 = r5.label;
        r4.setText(r5);
        r4 = r12.lNC;
        r5 = com.tencent.mm.R.l.eiF;
        r4.setText(r5);
        goto L_0x0239;
    L_0x042f:
        r4 = r12.lNB;
        r6 = r5.fRX;
        r4.setText(r6);
        r4 = r12.lNC;
        r5 = r5.label;
        r4.setText(r5);
        goto L_0x0239;
    L_0x043f:
        r6 = r12.lNB;
        r6.setText(r4);
        r4 = r5.fRX;
        r4 = com.tencent.mm.sdk.platformtools.bg.mA(r4);
        if (r4 == 0) goto L_0x0455;
    L_0x044c:
        r4 = r12.lNC;
        r5 = r5.label;
        r4.setText(r5);
        goto L_0x0239;
    L_0x0455:
        r4 = r12.lNC;
        r5 = r5.fRX;
        r4.setText(r5);
        goto L_0x0239;
    L_0x045e:
        if (r8 == 0) goto L_0x04a4;
    L_0x0460:
        r0 = r18;
        r4 = r0.get(r11);
        r4 = (com.tencent.mm.protocal.c.rm) r4;
        r5 = r12.lNr;
        r6 = 8;
        r5.setVisibility(r6);
        r5 = r12.jbU;
        r6 = 8;
        r5.setVisibility(r6);
        r5 = r12.lND;
        r6 = 0;
        r5.setVisibility(r6);
        r5 = r12.lNA;
        r6 = r4.txx;
        r6 = com.tencent.mm.pluginsdk.model.c.LO(r6);
        r5.setImageResource(r6);
        r5 = r12.lNB;
        r6 = r4.title;
        r5.setText(r6);
        r5 = r4.desc;
        r6 = com.tencent.mm.sdk.platformtools.bg.mA(r5);
        if (r6 == 0) goto L_0x04e9;
    L_0x0496:
        r4 = r4.txD;
        r4 = (float) r4;
        r4 = com.tencent.mm.plugin.favorite.b.x.U(r4);
    L_0x049d:
        r5 = r12.lNC;
        r5.setText(r4);
        goto L_0x0239;
    L_0x04a4:
        if (r6 == 0) goto L_0x0239;
    L_0x04a6:
        r0 = r18;
        r4 = r0.get(r13);
        r4 = (com.tencent.mm.protocal.c.rm) r4;
        r5 = r12.lNr;
        r6 = 8;
        r5.setVisibility(r6);
        r5 = r12.jbU;
        r6 = 8;
        r5.setVisibility(r6);
        r5 = r12.lND;
        r6 = 0;
        r5.setVisibility(r6);
        r5 = r12.lNA;
        r6 = com.tencent.mm.R.k.dwP;
        r5.setImageResource(r6);
        r5 = r12.lNB;
        r6 = com.tencent.mm.R.l.dIZ;
        r0 = r17;
        r6 = r0.getString(r6);
        r5.setText(r6);
        r5 = r12.lNC;
        r0 = r25;
        r6 = r0.lDs;
        r6 = r6.context;
        r4 = r4.duration;
        r4 = com.tencent.mm.plugin.favorite.b.x.s(r6, r4);
        r5.setText(r4);
        goto L_0x0239;
    L_0x04e9:
        r4 = r5;
        goto L_0x049d;
    L_0x04eb:
        r4 = r5;
        goto L_0x029e;
    L_0x04ee:
        r10 = r5;
        goto L_0x027e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.favorite.ui.c.r.a(android.view.View, android.view.ViewGroup, com.tencent.mm.plugin.favorite.b.j):android.view.View");
    }

    public final void cg(View view) {
        e.b(view.getContext(), ((a) view.getTag()).lFt);
    }
}
