package com.tencent.mm.plugin.favorite;

import com.tencent.mm.a.g;
import com.tencent.mm.e.a.fp;
import com.tencent.mm.plugin.favorite.b.x;
import com.tencent.mm.protocal.c.rm;
import com.tencent.mm.sdk.b.c;
import java.io.File;

public final class f extends c<fp> {
    public f() {
        this.usg = fp.class.getName().hashCode();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b r21) {
        /*
        r20 = this;
        r21 = (com.tencent.mm.e.a.fp) r21;
        r0 = r21;
        r2 = r0.fKp;
        r2 = r2.type;
        switch(r2) {
            case 2: goto L_0x003c;
            case 3: goto L_0x000b;
            case 4: goto L_0x000d;
            case 5: goto L_0x000b;
            case 6: goto L_0x0083;
            case 7: goto L_0x009e;
            case 8: goto L_0x00b0;
            case 9: goto L_0x00c1;
            case 10: goto L_0x00e4;
            case 11: goto L_0x0100;
            case 12: goto L_0x0130;
            case 13: goto L_0x0141;
            case 14: goto L_0x016c;
            case 15: goto L_0x0185;
            case 16: goto L_0x0198;
            case 17: goto L_0x01ab;
            case 18: goto L_0x01bd;
            case 19: goto L_0x027f;
            case 20: goto L_0x04b8;
            case 21: goto L_0x050f;
            case 22: goto L_0x052b;
            case 23: goto L_0x0537;
            case 24: goto L_0x0543;
            case 25: goto L_0x0568;
            case 26: goto L_0x0574;
            case 27: goto L_0x05c9;
            case 28: goto L_0x0605;
            case 29: goto L_0x000b;
            case 30: goto L_0x0637;
            case 31: goto L_0x0654;
            case 32: goto L_0x0669;
            case 33: goto L_0x06b0;
            case 34: goto L_0x06df;
            case 35: goto L_0x06ff;
            case 36: goto L_0x0704;
            default: goto L_0x000b;
        };
    L_0x000b:
        r2 = 0;
        return r2;
    L_0x000d:
        r2 = com.tencent.mm.plugin.favorite.h.ata();
        r0 = r21;
        r3 = r0.fKp;
        r4 = r3.fFx;
        r2 = r2.bT(r4);
        if (r2 == 0) goto L_0x000b;
    L_0x001d:
        r3 = r2.field_tagProto;
        r3 = r3.tzx;
        if (r3 == 0) goto L_0x000b;
    L_0x0023:
        r0 = r21;
        r3 = r0.fKq;
        r4 = new java.util.ArrayList;
        r4.<init>();
        r3.fKy = r4;
        r0 = r21;
        r3 = r0.fKq;
        r3 = r3.fKy;
        r2 = r2.field_tagProto;
        r2 = r2.tzx;
        r3.addAll(r2);
        goto L_0x000b;
    L_0x003c:
        r0 = r21;
        r2 = r0.fKp;
        r2 = r2.fKr;
        if (r2 == 0) goto L_0x000b;
    L_0x0044:
        r2 = new java.io.File;
        r0 = r21;
        r3 = r0.fKp;
        r3 = r3.fKr;
        r3 = com.tencent.mm.plugin.favorite.b.x.g(r3);
        r2.<init>(r3);
        r3 = r2.exists();
        if (r3 == 0) goto L_0x0063;
    L_0x0059:
        r0 = r21;
        r3 = r0.fKq;
        r2 = r2.getAbsolutePath();
        r3.path = r2;
    L_0x0063:
        r2 = new java.io.File;
        r0 = r21;
        r3 = r0.fKp;
        r3 = r3.fKr;
        r3 = com.tencent.mm.plugin.favorite.b.x.h(r3);
        r2.<init>(r3);
        r3 = r2.exists();
        if (r3 == 0) goto L_0x000b;
    L_0x0078:
        r0 = r21;
        r3 = r0.fKq;
        r2 = r2.getAbsolutePath();
        r3.fKz = r2;
        goto L_0x000b;
    L_0x0083:
        r2 = com.tencent.mm.plugin.favorite.h.ata();
        r0 = r21;
        r3 = r0.fKp;
        r3 = r3.fKt;
        r2.c(r3);
        r0 = r21;
        r2 = r0.fKq;
    L_0x0094:
        r3 = 0;
        r19 = r3;
        r3 = r2;
        r2 = r19;
    L_0x009a:
        r3.ret = r2;
        goto L_0x000b;
    L_0x009e:
        r2 = com.tencent.mm.plugin.favorite.h.ata();
        r0 = r21;
        r3 = r0.fKp;
        r3 = r3.fKt;
        r2.f(r3);
        r0 = r21;
        r2 = r0.fKq;
        goto L_0x0094;
    L_0x00b0:
        r0 = r21;
        r2 = r0.fKq;
        r3 = com.tencent.mm.plugin.favorite.h.ata();
        r3 = r3.gUz;
        r2.fKB = r3;
        r0 = r21;
        r2 = r0.fKq;
        goto L_0x0094;
    L_0x00c1:
        r2 = com.tencent.mm.plugin.favorite.h.ata();
        r0 = r21;
        r3 = r0.fKp;
        r4 = r3.fFx;
        r2 = r2.bT(r4);
        r0 = r21;
        r3 = r0.fKq;
        r4 = r2.field_type;
        r5 = r2.field_favProto;
        r2 = r2.field_tagProto;
        r2 = com.tencent.mm.pluginsdk.model.c.a(r4, r5, r2);
        r3.fKA = r2;
        r0 = r21;
        r2 = r0.fKq;
        goto L_0x0094;
    L_0x00e4:
        r2 = com.tencent.mm.plugin.favorite.h.ata();
        r0 = r21;
        r3 = r0.fKp;
        r4 = r3.fFx;
        r2 = r2.bT(r4);
        r0 = r21;
        r3 = r0.fKp;
        r3 = r3.context;
        com.tencent.mm.plugin.favorite.ui.c.e.b(r3, r2);
        r0 = r21;
        r2 = r0.fKq;
        goto L_0x0094;
    L_0x0100:
        r2 = com.tencent.mm.plugin.favorite.h.ata();
        r0 = r21;
        r3 = r0.fKp;
        r4 = r3.fFx;
        r2 = r2.bT(r4);
        r0 = r21;
        r3 = r0.fKp;
        r3 = r3.handler;
        r2 = com.tencent.mm.plugin.favorite.ui.c.e.a(r2, r3);
        r0 = r21;
        r3 = r0.fKq;
        r4 = 0;
        r4 = r2[r4];
        r3.fKz = r4;
        r0 = r21;
        r3 = r0.fKq;
        r4 = 1;
        r2 = r2[r4];
        r3.thumbUrl = r2;
        r0 = r21;
        r2 = r0.fKq;
        goto L_0x0094;
    L_0x0130:
        r0 = r21;
        r2 = r0.fKp;
        r2 = r2.fFx;
        r0 = r21;
        r4 = r0.fKp;
        r4 = r4.fKu;
        com.tencent.mm.plugin.favorite.b.x.a(r2, r4);
        goto L_0x000b;
    L_0x0141:
        r2 = com.tencent.mm.plugin.favorite.h.ata();
        r0 = r21;
        r3 = r0.fKp;
        r4 = r3.fFx;
        r2 = r2.bT(r4);
        r0 = r21;
        r3 = r0.fKp;
        r3 = r3.context;
        r0 = r21;
        r4 = r0.fKp;
        r4 = r4.toUser;
        r0 = r21;
        r5 = r0.fKp;
        r5 = r5.fKv;
        r0 = r21;
        r6 = r0.fKp;
        r6 = r6.fKu;
        com.tencent.mm.plugin.favorite.b.r.a(r3, r4, r5, r2, r6);
        goto L_0x000b;
    L_0x016c:
        r0 = r21;
        r2 = r0.fKp;
        r2 = r2.fKr;
        r2 = com.tencent.mm.plugin.favorite.b.x.d(r2);
        if (r2 == 0) goto L_0x017f;
    L_0x0178:
        r0 = r21;
        r3 = r0.fKq;
        r2 = 1;
        goto L_0x009a;
    L_0x017f:
        r0 = r21;
        r2 = r0.fKq;
        goto L_0x0094;
    L_0x0185:
        r2 = com.tencent.mm.plugin.favorite.h.ata();
        r0 = r21;
        r3 = r0.fKp;
        r4 = r3.fFx;
        r2 = r2.bT(r4);
        com.tencent.mm.plugin.favorite.b.x.l(r2);
        goto L_0x000b;
    L_0x0198:
        r2 = com.tencent.mm.plugin.favorite.h.ata();
        r0 = r21;
        r3 = r0.fKp;
        r4 = r3.fFx;
        r2 = r2.bT(r4);
        com.tencent.mm.plugin.favorite.b.x.m(r2);
        goto L_0x000b;
    L_0x01ab:
        r0 = r21;
        r3 = r0.fKq;
        r0 = r21;
        r2 = r0.fKp;
        r2 = r2.fKr;
        r2 = r2.txx;
        r2 = com.tencent.mm.plugin.favorite.b.x.wb(r2);
        goto L_0x009a;
    L_0x01bd:
        r4 = new java.util.ArrayList;
        r4.<init>();
        r2 = 7;
        r2 = java.lang.Integer.valueOf(r2);
        r4.add(r2);
        r2 = 0;
        r3 = 0;
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r2 = com.tencent.mm.plugin.favorite.b.x.a(r2, r3, r4, r5, r6, r7);
        r15 = new java.util.ArrayList;
        r15.<init>();
        r16 = r2.iterator();
    L_0x01dc:
        r2 = r16.hasNext();
        if (r2 == 0) goto L_0x0277;
    L_0x01e2:
        r2 = r16.next();
        r2 = (com.tencent.mm.plugin.favorite.b.j) r2;
        r3 = r2.field_favProto;
        r0 = r3.tzl;
        r17 = r0;
        r3 = r2.field_type;
        r4 = 7;
        if (r3 != r4) goto L_0x0224;
    L_0x01f3:
        r10 = com.tencent.mm.plugin.favorite.b.x.n(r2);
        r12 = a(r10);
        r2 = com.tencent.mm.am.a.a.class;
        r2 = com.tencent.mm.kernel.h.h(r2);
        r2 = (com.tencent.mm.am.a.a) r2;
        r3 = 6;
        r4 = 0;
        r5 = r10.title;
        r6 = r10.desc;
        r7 = r10.txp;
        r8 = r10.txt;
        r9 = r10.txr;
        r10 = r10.lKv;
        r11 = com.tencent.mm.plugin.favorite.b.x.atA();
        r13 = "";
        r0 = r17;
        r14 = r0.appId;
        r2 = r2.a(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14);
        r15.add(r2);
        goto L_0x01dc;
    L_0x0224:
        r3 = r2.field_type;
        r4 = 14;
        if (r3 != r4) goto L_0x01dc;
    L_0x022a:
        r3 = r2.field_favProto;
        r3 = r3.tzn;
        if (r3 == 0) goto L_0x01dc;
    L_0x0230:
        r2 = r2.field_favProto;
        r2 = r2.tzn;
        r18 = r2.iterator();
    L_0x0238:
        r2 = r18.hasNext();
        if (r2 == 0) goto L_0x01dc;
    L_0x023e:
        r2 = r18.next();
        r10 = r2;
        r10 = (com.tencent.mm.protocal.c.rm) r10;
        r2 = r10.aMw;
        r3 = 7;
        if (r2 != r3) goto L_0x0238;
    L_0x024a:
        r12 = a(r10);
        r2 = com.tencent.mm.am.a.a.class;
        r2 = com.tencent.mm.kernel.h.h(r2);
        r2 = (com.tencent.mm.am.a.a) r2;
        r3 = 6;
        r4 = 0;
        r5 = r10.title;
        r6 = r10.desc;
        r7 = r10.txp;
        r8 = r10.txt;
        r9 = r10.txr;
        r10 = r10.lKv;
        r11 = com.tencent.mm.plugin.favorite.b.x.atA();
        r13 = "";
        r0 = r17;
        r14 = r0.appId;
        r2 = r2.a(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14);
        r15.add(r2);
        goto L_0x0238;
    L_0x0277:
        r0 = r21;
        r2 = r0.fKq;
        r2.fKC = r15;
        goto L_0x000b;
    L_0x027f:
        r0 = r21;
        r2 = r0.fKp;
        r2 = r2.fFx;
        r4 = -1;
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 != 0) goto L_0x02a0;
    L_0x028b:
        r0 = r21;
        r2 = r0.fKp;
        r2 = r2.title;
        r0 = r21;
        r3 = r0.fKp;
        r3 = r3.fFC;
        r3 = r3.tzn;
        r4 = -1;
        com.tencent.mm.plugin.favorite.b.m.a(r2, r3, r4);
        goto L_0x000b;
    L_0x02a0:
        r0 = r21;
        r2 = r0.fKp;
        r2 = r2.fKw;
        r3 = -1;
        if (r2 != r3) goto L_0x02e1;
    L_0x02a9:
        r2 = com.tencent.mm.plugin.favorite.h.ata();
        r0 = r21;
        r3 = r0.fKp;
        r4 = r3.fFx;
        r2 = r2.bT(r4);
        if (r2 == 0) goto L_0x000b;
    L_0x02b9:
        r3 = r2.field_favProto;
        if (r3 == 0) goto L_0x000b;
    L_0x02bd:
        r3 = r2.field_favProto;
        r3 = r3.tzn;
        r3 = r3.size();
        r4 = 1;
        if (r3 <= r4) goto L_0x000b;
    L_0x02c8:
        r2 = r2.field_favProto;
        r2 = r2.tzn;
        r3 = 0;
        r2 = r2.get(r3);
        r2 = (com.tencent.mm.protocal.c.rm) r2;
        r0 = r21;
        r3 = r0.fKq;
        r2 = r2.txi;
        r2 = com.tencent.mm.sdk.platformtools.bg.mA(r2);
        r3.fKF = r2;
        goto L_0x000b;
    L_0x02e1:
        r0 = r21;
        r2 = r0.fKp;
        r2 = r2.fKw;
        r3 = -3;
        if (r2 != r3) goto L_0x034a;
    L_0x02ea:
        r0 = r21;
        r2 = r0.fKp;
        r2 = r2.fFx;
        r4 = 0;
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 <= 0) goto L_0x034a;
    L_0x02f6:
        r2 = com.tencent.mm.plugin.favorite.h.ata();
        r0 = r21;
        r3 = r0.fKp;
        r4 = r3.fFx;
        r2 = r2.bT(r4);
        if (r2 == 0) goto L_0x000b;
    L_0x0306:
        r0 = r21;
        r3 = r0.fKp;
        r3 = r3.fKs;
        r4 = "fav_note_item_status";
        r5 = r2.field_itemStatus;
        r3 = r3.getIntExtra(r4, r5);
        r2.field_itemStatus = r3;
        r0 = r21;
        r3 = r0.fKp;
        r3 = r3.fKs;
        r4 = "fav_note_item_updatetime";
        r6 = r2.field_updateTime;
        r4 = r3.getLongExtra(r4, r6);
        r2.field_updateTime = r4;
        r0 = r21;
        r3 = r0.fKp;
        r3 = r3.fKs;
        r4 = "fav_note_xml";
        r3 = r3.getStringExtra(r4);
        r2.vO(r3);
        r3 = com.tencent.mm.plugin.favorite.h.ata();
        r4 = 1;
        r4 = new java.lang.String[r4];
        r5 = 0;
        r6 = "localId";
        r4[r5] = r6;
        r3.a(r2, r4);
        goto L_0x000b;
    L_0x034a:
        r0 = r21;
        r2 = r0.fKp;
        r2 = r2.fKw;
        r3 = -2;
        if (r2 != r3) goto L_0x03be;
    L_0x0353:
        r0 = r21;
        r2 = r0.fKp;
        r2 = r2.fFx;
        r4 = 0;
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 <= 0) goto L_0x03be;
    L_0x035f:
        r2 = com.tencent.mm.plugin.favorite.h.ata();
        r0 = r21;
        r3 = r0.fKp;
        r4 = r3.fFx;
        r3 = r2.bT(r4);
        if (r3 == 0) goto L_0x03be;
    L_0x036f:
        r2 = r3.field_itemStatus;
        r4 = 10;
        if (r2 != r4) goto L_0x03be;
    L_0x0375:
        r2 = r3.field_xml;
        r2 = com.tencent.mm.sdk.platformtools.bg.mA(r2);
        if (r2 != 0) goto L_0x03be;
    L_0x037d:
        r2 = r3.field_xml;
        r3.vO(r2);
        r2 = r3.field_favProto;
        if (r2 == 0) goto L_0x03be;
    L_0x0386:
        r2 = r3.field_favProto;
        r2 = r2.tzn;
        r2 = r2.size();
        r4 = 1;
        if (r2 <= r4) goto L_0x03be;
    L_0x0391:
        r2 = r3.field_favProto;
        r2 = r2.tzn;
        r4 = 0;
        r2 = r2.get(r4);
        r2 = (com.tencent.mm.protocal.c.rm) r2;
        r4 = r2.txi;
        r4 = com.tencent.mm.sdk.platformtools.bg.mA(r4);
        if (r4 != 0) goto L_0x03be;
    L_0x03a4:
        r2 = r2.txk;
        r2 = com.tencent.mm.sdk.platformtools.bg.mA(r2);
        if (r2 != 0) goto L_0x03be;
    L_0x03ac:
        r2 = com.tencent.mm.plugin.favorite.h.ata();
        r4 = 1;
        r4 = new java.lang.String[r4];
        r5 = 0;
        r6 = "localId";
        r4[r5] = r6;
        r2.a(r3, r4);
        goto L_0x000b;
    L_0x03be:
        r2 = new android.content.Intent;
        r2.<init>();
        r0 = r21;
        r3 = r0.fKp;
        r4 = r3.fFx;
        r6 = 0;
        r3 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r3 <= 0) goto L_0x0405;
    L_0x03cf:
        r0 = r21;
        r3 = r0.fKp;
        r3 = r3.desc;
        r3 = com.tencent.mm.sdk.platformtools.bg.mA(r3);
        if (r3 != 0) goto L_0x0405;
    L_0x03db:
        r0 = r21;
        r3 = r0.fKp;
        r3 = r3.fKw;
        if (r3 <= 0) goto L_0x0405;
    L_0x03e3:
        r3 = com.tencent.mm.plugin.favorite.h.ata();
        r0 = r21;
        r4 = r0.fKp;
        r4 = r4.fFx;
        r3 = r3.bT(r4);
        if (r3 == 0) goto L_0x0405;
    L_0x03f3:
        r4 = "fav_note_xml";
        r5 = com.tencent.mm.plugin.favorite.b.j.b(r3);
        r2.putExtra(r4, r5);
        r4 = "fav_note_item_updatetime";
        r6 = r3.field_updateTime;
        r2.putExtra(r4, r6);
    L_0x0405:
        r0 = r21;
        r3 = r0.fKp;
        r3 = r3.fFC;
        r3 = r3.tzn;
        r0 = r21;
        r4 = r0.fKp;
        r4 = r4.fFx;
        r3 = com.tencent.mm.plugin.favorite.b.m.a(r3, r4);
        r0 = r21;
        r4 = r0.fKp;
        r4 = r4.desc;
        r4 = com.tencent.mm.sdk.platformtools.bg.mA(r4);
        if (r4 != 0) goto L_0x047f;
    L_0x0423:
        r0 = r21;
        r4 = r0.fKp;
        r4 = r4.fKw;
        if (r4 <= 0) goto L_0x0444;
    L_0x042b:
        r4 = "fav_note_item_status";
        r5 = r3.field_itemStatus;
        r2.putExtra(r4, r5);
        r0 = r21;
        r4 = r0.fKp;
        r4.fKs = r2;
        r2 = r3.field_favProto;
        r4 = r3.field_favProto;
        r4 = r4.version;
        r4 = r4 + 1;
        r2.yi(r4);
    L_0x0444:
        r2 = 1;
        r3.field_itemStatus = r2;
        r2 = com.tencent.mm.plugin.favorite.h.ata();
        r4 = 1;
        r4 = new java.lang.String[r4];
        r5 = 0;
        r6 = "localId";
        r4[r5] = r6;
        r2.a(r3, r4);
        r0 = r21;
        r2 = r0.fKp;
        r2 = r2.desc;
        r3 = "fav_add_new_note";
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x000b;
    L_0x0466:
        r0 = r21;
        r2 = r0.fKp;
        r2 = r2.title;
        r0 = r21;
        r3 = r0.fKp;
        r3 = r3.fFC;
        r3 = r3.tzn;
        r0 = r21;
        r4 = r0.fKp;
        r4 = r4.fFx;
        com.tencent.mm.plugin.favorite.b.m.a(r2, r3, r4);
        goto L_0x000b;
    L_0x047f:
        r2 = r3.field_favProto;
        r2 = r2.version;
        if (r2 == 0) goto L_0x04ac;
    L_0x0485:
        r2 = r3.field_favProto;
        r4 = r3.field_favProto;
        r4 = r4.version;
        r4 = r4 + 1;
        r2.yi(r4);
    L_0x0490:
        r2 = 1;
        r3.field_itemStatus = r2;
        r2 = com.tencent.mm.plugin.favorite.h.ata();
        r4 = 1;
        r4 = new java.lang.String[r4];
        r5 = 0;
        r6 = "localId";
        r4[r5] = r6;
        r2.a(r3, r4);
        r2 = com.tencent.mm.plugin.favorite.h.asR();
        r2.run();
        goto L_0x000b;
    L_0x04ac:
        r2 = r3.field_favProto;
        r4 = r3.field_favProto;
        r4 = r4.version;
        r4 = r4 + 2;
        r2.yi(r4);
        goto L_0x0490;
    L_0x04b8:
        r2 = com.tencent.mm.plugin.favorite.b.ah.atU();
        r3 = com.tencent.mm.plugin.favorite.b.ah.atV();
        com.tencent.mm.plugin.favorite.b.ah.lFN = r3;
        r3.a(r2);
        r2 = com.tencent.mm.plugin.favorite.b.ah.lFN;
        r3 = 1;
        r2.lFa = r3;
        r2 = com.tencent.mm.plugin.favorite.b.ah.lFN;
        r3 = com.tencent.mm.plugin.favorite.b.w.jXn;
        if (r3 != 0) goto L_0x04db;
    L_0x04d0:
        r3 = new com.tencent.mm.sdk.platformtools.SensorController;
        r4 = com.tencent.mm.sdk.platformtools.ab.getContext();
        r3.<init>(r4);
        com.tencent.mm.plugin.favorite.b.w.jXn = r3;
    L_0x04db:
        r3 = r2.jXr;
        if (r3 != 0) goto L_0x04ea;
    L_0x04df:
        r3 = new com.tencent.mm.sdk.platformtools.ax;
        r4 = com.tencent.mm.sdk.platformtools.ab.getContext();
        r3.<init>(r4);
        r2.jXr = r3;
    L_0x04ea:
        r2 = com.tencent.mm.plugin.favorite.b.ah.atU();
        r0 = r21;
        r3 = r0.fKp;
        r3 = r3.title;
        r0 = r21;
        r4 = r0.fKp;
        r4 = r4.fKw;
        r0 = r21;
        r5 = r0.fKp;
        r5 = r5.fKx;
        r6 = "";
        r3 = com.tencent.mm.sdk.platformtools.bg.ap(r3, r6);
        r2.path = r3;
        r2.fKw = r4;
        r2.duration = r5;
        goto L_0x000b;
    L_0x050f:
        r0 = r21;
        r2 = r0.fKq;
        r0 = r21;
        r3 = r0.fKp;
        r3 = r3.context;
        r0 = r21;
        r4 = r0.fKp;
        r4 = r4.fKx;
        r3 = com.tencent.mm.plugin.favorite.b.u.s(r3, r4);
        r3 = r3.toString();
        r2.path = r3;
        goto L_0x000b;
    L_0x052b:
        com.tencent.mm.plugin.favorite.b.ah.atU();
        r2 = com.tencent.mm.plugin.favorite.b.ah.atW();
        r2.destroy();
        goto L_0x000b;
    L_0x0537:
        com.tencent.mm.plugin.favorite.b.ah.atU();
        r2 = com.tencent.mm.plugin.favorite.b.ah.atW();
        r2.atw();
        goto L_0x000b;
    L_0x0543:
        r0 = r21;
        r2 = r0.fKq;
        com.tencent.mm.plugin.favorite.b.ah.atU();
        r3 = com.tencent.mm.plugin.favorite.b.ah.atW();
        r0 = r21;
        r4 = r0.fKp;
        r4 = r4.path;
        r0 = r21;
        r5 = r0.fKp;
        r5 = r5.fKw;
        r0 = r21;
        r6 = r0.fKp;
        r6 = r6.fKx;
        r3 = r3.z(r4, r5, r6);
        r2.fKD = r3;
        goto L_0x000b;
    L_0x0568:
        com.tencent.mm.plugin.favorite.b.ah.atU();
        r2 = com.tencent.mm.plugin.favorite.b.ah.atW();
        r2.adL();
        goto L_0x000b;
    L_0x0574:
        r0 = r21;
        r2 = r0.fKq;
        com.tencent.mm.plugin.favorite.b.ah.atU();
        r3 = com.tencent.mm.plugin.favorite.b.ah.atW();
        r3 = r3.path;
        r2.path = r3;
        r0 = r21;
        r2 = r0.fKq;
        com.tencent.mm.plugin.favorite.b.ah.atU();
        r3 = com.tencent.mm.plugin.favorite.b.ah.atW();
        r3 = r3.atu();
        r2.fKD = r3;
        r0 = r21;
        r2 = r0.fKq;
        com.tencent.mm.plugin.favorite.b.ah.atU();
        r3 = com.tencent.mm.plugin.favorite.b.ah.atW();
        r3 = r3.atv();
        r2.fKE = r3;
        r0 = r21;
        r2 = r0.fKq;
        com.tencent.mm.plugin.favorite.b.ah.atU();
        r3 = com.tencent.mm.plugin.favorite.b.ah.atW();
        r3 = r3.oV();
        r2.fKF = r3;
        r0 = r21;
        r2 = r0.fKq;
        com.tencent.mm.plugin.favorite.b.ah.atU();
        r3 = com.tencent.mm.plugin.favorite.b.ah.atW();
        r4 = r3.oU();
        r2.fKG = r4;
        goto L_0x000b;
    L_0x05c9:
        r0 = r21;
        r2 = r0.fKp;
        r2 = r2.fKr;
        if (r2 == 0) goto L_0x000b;
    L_0x05d1:
        r2 = new java.io.File;
        r0 = r21;
        r3 = r0.fKp;
        r3 = r3.fKr;
        r3 = com.tencent.mm.plugin.favorite.b.x.g(r3);
        r2.<init>(r3);
        r0 = r21;
        r3 = r0.fKq;
        r2 = r2.getAbsolutePath();
        r3.path = r2;
        r2 = new java.io.File;
        r0 = r21;
        r3 = r0.fKp;
        r3 = r3.fKr;
        r3 = com.tencent.mm.plugin.favorite.b.x.h(r3);
        r2.<init>(r3);
        r0 = r21;
        r3 = r0.fKq;
        r2 = r2.getAbsolutePath();
        r3.fKz = r2;
        goto L_0x000b;
    L_0x0605:
        r2 = com.tencent.mm.plugin.favorite.h.ata();
        r0 = r21;
        r3 = r0.fKp;
        r4 = r3.fFx;
        r2 = r2.bT(r4);
        r0 = r21;
        r3 = r0.fKp;
        r3 = r3.path;
        r3 = com.tencent.mm.sdk.platformtools.bg.mA(r3);
        if (r3 == 0) goto L_0x062b;
    L_0x061f:
        r0 = r21;
        r3 = r0.fKp;
        r3 = r3.fKr;
        r4 = 1;
        com.tencent.mm.plugin.favorite.b.x.a(r2, r3, r4);
        goto L_0x000b;
    L_0x062b:
        r0 = r21;
        r3 = r0.fKp;
        r3 = r3.fKr;
        r4 = 1;
        com.tencent.mm.plugin.favorite.b.x.b(r2, r3, r4);
        goto L_0x000b;
    L_0x0637:
        r2 = new com.tencent.mm.plugin.favorite.b.j;
        r2.<init>();
        r3 = 18;
        r2.field_type = r3;
        r0 = r21;
        r3 = r0.fKp;
        r3 = r3.fFC;
        r2.field_favProto = r3;
        r0 = r21;
        r3 = r0.fKq;
        r2 = com.tencent.mm.plugin.favorite.b.j.b(r2);
        r3.path = r2;
        goto L_0x000b;
    L_0x0654:
        r0 = r21;
        r2 = r0.fKp;
        r2 = r2.fGg;
        r2 = (com.tencent.mm.plugin.favorite.b.af) r2;
        r0 = r21;
        r3 = r0.fKq;
        r4 = r2.lFJ;
        r3.path = r4;
        com.tencent.mm.plugin.favorite.b.x.a(r2);
        goto L_0x000b;
    L_0x0669:
        r2 = com.tencent.mm.plugin.favorite.h.ata();
        r0 = r21;
        r3 = r0.fKp;
        r4 = r3.fFx;
        r3 = r2.bT(r4);
        r2 = new com.tencent.mm.plugin.favorite.b.q;
        r2.<init>();
        r0 = r21;
        r4 = r0.fKq;
        r2 = r2.g(r3);
        if (r2 == 0) goto L_0x06ae;
    L_0x0686:
        r2 = 1;
    L_0x0687:
        r4.ret = r2;
        r0 = r21;
        r2 = r0.fKq;
        r4 = com.tencent.mm.plugin.favorite.b.q.h(r3);
        r2.fKF = r4;
        r0 = r21;
        r2 = r0.fKq;
        r4 = "";
        r2.path = r4;
        if (r3 != 0) goto L_0x000b;
    L_0x069e:
        r0 = r21;
        r2 = r0.fKq;
        r3 = 1;
        r2.fKF = r3;
        r0 = r21;
        r2 = r0.fKq;
        r3 = 0;
        r2.path = r3;
        goto L_0x000b;
    L_0x06ae:
        r2 = 0;
        goto L_0x0687;
    L_0x06b0:
        r2 = com.tencent.mm.plugin.favorite.h.ata();
        r0 = r21;
        r3 = r0.fKp;
        r4 = r3.fFx;
        r2 = r2.bT(r4);
        if (r2 == 0) goto L_0x000b;
    L_0x06c0:
        r3 = r2.field_favProto;
        r0 = r21;
        r4 = r0.fKp;
        r4 = r4.fFC;
        r4 = r4.tzn;
        r3.av(r4);
        r3 = com.tencent.mm.plugin.favorite.h.ata();
        r4 = 1;
        r4 = new java.lang.String[r4];
        r5 = 0;
        r6 = "localId";
        r4[r5] = r6;
        r3.b(r2, r4);
        goto L_0x000b;
    L_0x06df:
        r2 = com.tencent.mm.plugin.favorite.h.ata();
        r0 = r21;
        r3 = r0.fKp;
        r4 = r3.fFx;
        r2 = r2.bT(r4);
        if (r2 == 0) goto L_0x000b;
    L_0x06ef:
        r3 = r2.field_type;
        r4 = 18;
        if (r3 != r4) goto L_0x000b;
    L_0x06f5:
        r0 = r21;
        r3 = r0.fKp;
        r2 = r2.field_favProto;
        r3.fFC = r2;
        goto L_0x000b;
    L_0x06ff:
        com.tencent.mm.plugin.favorite.b.x.atL();
        goto L_0x000b;
    L_0x0704:
        r0 = r21;
        r2 = r0.fKq;
        r3 = com.tencent.mm.plugin.favorite.b.x.atH();
        if (r3 == 0) goto L_0x0094;
    L_0x070e:
        r3 = 1;
        r19 = r3;
        r3 = r2;
        r2 = r19;
        goto L_0x009a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.favorite.f.a(com.tencent.mm.sdk.b.b):boolean");
    }

    private static String a(rm rmVar) {
        File file = new File(x.h(rmVar));
        if (file.exists()) {
            return file.getAbsolutePath();
        }
        if (rmVar.fFs == null) {
            return "";
        }
        file = new File(x.aty() + g.n(rmVar.fFs.getBytes()));
        return file.exists() ? file.getAbsolutePath() : "";
    }
}
