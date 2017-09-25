package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import com.tencent.mm.R;
import com.tencent.mm.e.a.cb;
import com.tencent.mm.i.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelbiz.a.j;
import com.tencent.mm.modelbiz.e;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.biz.a.a;
import com.tencent.mm.protocal.c.bdu;
import com.tencent.mm.protocal.c.rm;
import com.tencent.mm.protocal.c.rn;
import com.tencent.mm.protocal.c.ro;
import com.tencent.mm.protocal.c.rp;
import com.tencent.mm.protocal.c.rs;
import com.tencent.mm.protocal.c.rv;
import com.tencent.mm.protocal.c.rw;
import com.tencent.mm.protocal.c.se;
import com.tencent.mm.protocal.c.sf;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.t.f;
import com.tencent.mm.t.k;
import com.tencent.mm.t.l;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.m;
import com.tencent.mm.u.n;
import com.tencent.mm.u.o;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public final class g {
    private static final SimpleDateFormat saY = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static boolean a(Context context, cb cbVar, String str, List<au> list, boolean z) {
        if (list == null || list.isEmpty()) {
            w.w("MicroMsg.GetFavRecordDataSource", "fill favorite event fail, event or msgs is null");
            cbVar.fFA.fFG = R.l.eib;
            return false;
        }
        boolean dr = e.dr(str);
        au auVar;
        if (list.size() == 1) {
            auVar = (au) list.get(0);
            if (!auVar.bLX() && !auVar.bLY()) {
                return e.a(cbVar, auVar);
            }
            k rV = ((a) h.h(a.class)).rV(auVar.field_content);
            if (rV.hkm != null && rV.hkm.size() == 1) {
                return e.a(cbVar, auVar);
            }
            cbVar.fFA.fFC = new rv();
            cbVar.fFA.fFD = new se();
            cbVar.fFA.fFC.a(LQ(str));
            cbVar.fFA.type = 14;
            return a(context, cbVar, auVar, z);
        }
        cbVar.fFA.fFC = new rv();
        cbVar.fFA.fFD = new se();
        if (context != null) {
            if (dr) {
                if (com.tencent.mm.modelbiz.a.e.is(com.tencent.mm.modelbiz.a.e.ad(((au) list.get(0)).field_bizChatId))) {
                    cbVar.fFA.fFC.OB(context.getString(R.l.eIF));
                } else {
                    j iv = com.tencent.mm.modelbiz.a.e.iv(str);
                    cbVar.fFA.fFC.OB(context.getString(R.l.ejb, new Object[]{iv.field_userName, com.tencent.mm.modelbiz.a.e.it(r0)}));
                }
            } else if (o.dH(str)) {
                cbVar.fFA.fFC.OB(context.getString(R.l.eIF));
            } else {
                if (m.xN().equals(n.eJ(str))) {
                    cbVar.fFA.fFC.OB(context.getString(R.l.ejc, new Object[]{r0}));
                } else {
                    cbVar.fFA.fFC.OB(context.getString(R.l.ejb, new Object[]{m.xN(), n.eJ(str)}));
                }
            }
            w.d("MicroMsg.GetFavRecordDataSource", "title %s", cbVar.fFA.fFC.title);
        }
        cbVar.fFA.fFC.a(LQ(str));
        cbVar.fFA.type = 14;
        int i = 0;
        boolean z2 = true;
        for (au auVar2 : list) {
            if (a(context, cbVar, auVar2, z)) {
                i = 1;
            } else {
                z2 = false;
            }
        }
        if (i == 0 || cbVar.fFA.fFG <= 0) {
            return z2;
        }
        cbVar.fFA.fFG = 0;
        return z2;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean a(android.content.Context r12, com.tencent.mm.e.a.cb r13, com.tencent.mm.storage.au r14, boolean r15) {
        /*
        r10 = 0;
        r6 = 3;
        r9 = 2;
        r1 = 0;
        r2 = 1;
        if (r13 == 0) goto L_0x000a;
    L_0x0008:
        if (r14 != 0) goto L_0x001c;
    L_0x000a:
        r0 = "MicroMsg.GetFavRecordDataSource";
        r2 = "fill favorite event fail, event or msg is null";
        com.tencent.mm.sdk.platformtools.w.w(r0, r2);
        if (r13 == 0) goto L_0x001b;
    L_0x0015:
        r0 = r13.fFA;
        r2 = com.tencent.mm.R.l.eib;
        r0.fFG = r2;
    L_0x001b:
        return r1;
    L_0x001c:
        r4 = com.tencent.mm.storage.au.Y(r14);
        r0 = r4.bMk();
        if (r0 == 0) goto L_0x00a1;
    L_0x0026:
        r0 = new com.tencent.mm.protocal.c.rn;
        r0.<init>();
        r1 = T(r4);
        r0.c(r1);
        r1 = new com.tencent.mm.protocal.c.rm;
        r1.<init>();
        r3 = U(r4);
        r1.Od(r3);
        r1.yb(r2);
        r3 = r4.bMw();
        if (r3 != 0) goto L_0x0081;
    L_0x0047:
        r3 = r4.field_content;
        r1.NM(r3);
    L_0x004c:
        r1.jK(r2);
        r1.jJ(r2);
        r1.a(r0);
        r3 = r0.tyu;
        r3 = a(r3);
        r1.Og(r3);
        r0 = r0.tyu;
        r0 = b(r0);
        r1.Oh(r0);
        r0 = r13.fFA;
        r0 = r0.fFC;
        r0 = r0.tzn;
        r0.add(r1);
        r0 = r13.fFA;
        r0 = r0.fFD;
        r1 = r0.tzy;
        r1 = r1 + 1;
        r0.tzy = r1;
        r1 = r2;
    L_0x007b:
        if (r15 != 0) goto L_0x001b;
    L_0x007d:
        com.tencent.mm.pluginsdk.model.c.a(r4, r13, r1);
        goto L_0x001b;
    L_0x0081:
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r5 = r4.field_content;
        r3 = r3.append(r5);
        r5 = "\n\n";
        r3 = r3.append(r5);
        r5 = r4.field_transContent;
        r3 = r3.append(r5);
        r3 = r3.toString();
        r1.NM(r3);
        goto L_0x004c;
    L_0x00a1:
        r0 = r4.bLZ();
        if (r0 == 0) goto L_0x0154;
    L_0x00a7:
        r3 = new com.tencent.mm.protocal.c.rn;
        r3.<init>();
        r0 = T(r4);
        r3.c(r0);
        r5 = new com.tencent.mm.protocal.c.rm;
        r5.<init>();
        r0 = U(r4);
        r5.Od(r0);
        r5.yb(r6);
        if (r15 == 0) goto L_0x00f5;
    L_0x00c4:
        r5.jK(r2);
        r5.jJ(r2);
    L_0x00ca:
        r5.a(r3);
        r0 = r3.tyu;
        r0 = a(r0);
        r5.Og(r0);
        r0 = r3.tyu;
        r0 = b(r0);
        r5.Oh(r0);
        r0 = r13.fFA;
        r0 = r0.fFC;
        r0 = r0.tzn;
        r0.add(r5);
        r0 = r13.fFA;
        r0 = r0.fFD;
        r1 = r0.tzA;
        r1 = r1 + 1;
        r0.tzA = r1;
        r0 = r2;
    L_0x00f3:
        r1 = r0;
        goto L_0x007b;
    L_0x00f5:
        r0 = r4.field_talker;
        r0 = com.tencent.mm.u.o.fq(r0);
        if (r0 == 0) goto L_0x0130;
    L_0x00fd:
        r0 = r4.field_imgPath;
        com.tencent.mm.u.ap.yY();
        r6 = com.tencent.mm.u.c.xg();
        r7 = "recbiz_";
        r8 = ".rec";
        r0 = com.tencent.mm.sdk.platformtools.h.a(r6, r7, r0, r8, r9);
        r6 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
        if (r6 == 0) goto L_0x0127;
    L_0x0116:
        r0 = 0;
    L_0x0117:
        r5.NZ(r0);
    L_0x011a:
        r5.jK(r2);
        r0 = r4.field_imgPath;
        r0 = com.tencent.mm.modelvoice.q.lV(r0);
        if (r0 != 0) goto L_0x013a;
    L_0x0125:
        r0 = r1;
        goto L_0x00f3;
    L_0x0127:
        r6 = new java.io.File;
        r6.<init>(r0);
        r6.exists();
        goto L_0x0117;
    L_0x0130:
        r0 = r4.field_imgPath;
        r0 = com.tencent.mm.modelvoice.q.js(r0);
        r5.NZ(r0);
        goto L_0x011a;
    L_0x013a:
        r0 = r0.getFormat();
        r0 = com.tencent.mm.pluginsdk.model.e.wV(r0);
        r5.NV(r0);
        r0 = new com.tencent.mm.modelvoice.n;
        r1 = r4.field_content;
        r0.<init>(r1);
        r0 = r0.time;
        r0 = (int) r0;
        r5.ya(r0);
        goto L_0x00ca;
    L_0x0154:
        r0 = r4.bMj();
        if (r0 == 0) goto L_0x0160;
    L_0x015a:
        r1 = b(r13, r4);
        goto L_0x007b;
    L_0x0160:
        r0 = r4.bMh();
        if (r0 == 0) goto L_0x02d9;
    L_0x0166:
        r0 = 0;
        r6 = r4.field_msgId;
        r3 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1));
        if (r3 <= 0) goto L_0x0179;
    L_0x016d:
        r0 = com.tencent.mm.ah.n.GS();
        r6 = r4.field_msgId;
        r3 = (int) r6;
        r6 = (long) r3;
        r0 = r0.aj(r6);
    L_0x0179:
        if (r0 == 0) goto L_0x0181;
    L_0x017b:
        r6 = r0.hEY;
        r3 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1));
        if (r3 > 0) goto L_0x0191;
    L_0x0181:
        r6 = r4.field_msgSvrId;
        r3 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1));
        if (r3 <= 0) goto L_0x0191;
    L_0x0187:
        r0 = com.tencent.mm.ah.n.GS();
        r6 = r4.field_msgSvrId;
        r0 = r0.ai(r6);
    L_0x0191:
        if (r0 != 0) goto L_0x01a4;
    L_0x0193:
        r0 = "MicroMsg.GetFavRecordDataSource";
        r2 = "getImgDataPath: try get imgInfo fail";
        com.tencent.mm.sdk.platformtools.w.w(r0, r2);
        r0 = r13.fFA;
        r2 = com.tencent.mm.R.l.eih;
        r0.fFG = r2;
        goto L_0x007b;
    L_0x01a4:
        r3 = new com.tencent.mm.protocal.c.rn;
        r3.<init>();
        r5 = T(r4);
        r3.c(r5);
        r5 = new com.tencent.mm.protocal.c.rm;
        r5.<init>();
        r6 = U(r4);
        r5.Od(r6);
        r5.yb(r9);
        r6 = com.tencent.mm.ah.n.GS();
        r7 = com.tencent.mm.ah.e.c(r0);
        r8 = "";
        r9 = "";
        r6 = r6.m(r7, r8, r9);
        r5.NZ(r6);
        r6 = r0.GB();
        if (r6 == 0) goto L_0x020d;
    L_0x01da:
        r6 = com.tencent.mm.ah.n.GS();
        r7 = r0.hFi;
        r6 = r6.fT(r7);
        r7 = r6.hrs;
        r6 = r6.offset;
        if (r7 <= r6) goto L_0x020d;
    L_0x01ea:
        r6 = com.tencent.mm.ah.n.GS();
        r7 = new java.lang.StringBuilder;
        r8 = "SERVERID://";
        r7.<init>(r8);
        r8 = r4.field_msgSvrId;
        r7 = r7.append(r8);
        r7 = r7.toString();
        r8 = "";
        r9 = "";
        r6 = r6.m(r7, r8, r9);
        r5.NZ(r6);
    L_0x020d:
        r6 = com.tencent.mm.ah.n.GS();
        r7 = r4.field_imgPath;
        r6 = r6.v(r7, r2);
        r5.Oa(r6);
        r5.a(r3);
        r6 = r3.tyu;
        r6 = a(r6);
        r5.Og(r6);
        r3 = r3.tyu;
        r3 = b(r3);
        r5.Oh(r3);
        r6 = r4.field_msgId;
        r5.el(r6);
        if (r15 == 0) goto L_0x028b;
    L_0x0236:
        r3 = r0.GB();
        if (r3 == 0) goto L_0x024a;
    L_0x023c:
        r3 = r0.hrs;
        if (r3 != 0) goto L_0x024a;
    L_0x0240:
        r3 = com.tencent.mm.ah.n.GS();
        r0 = r0.hFi;
        r0 = r3.fT(r0);
    L_0x024a:
        r3 = r4.field_isSend;
        if (r3 != r2) goto L_0x02a3;
    L_0x024e:
        r3 = r0.GB();
        if (r3 == 0) goto L_0x02a1;
    L_0x0254:
        r3 = r2;
    L_0x0255:
        r6 = r0.hFj;
        r7 = "msg";
        r6 = com.tencent.mm.sdk.platformtools.bh.q(r6, r7);
        if (r6 == 0) goto L_0x02c9;
    L_0x0260:
        if (r3 != r2) goto L_0x028b;
    L_0x0262:
        r0 = ".msg.img.$cdnbigimgurl";
        r0 = r6.get(r0);
        r0 = (java.lang.String) r0;
        r5.NP(r0);
        r0 = ".msg.img.$length";
        r0 = r6.get(r0);
        r0 = (java.lang.String) r0;
        r0 = com.tencent.mm.sdk.platformtools.bg.getInt(r0, r1);
        r0 = (long) r0;
        r5.ej(r0);
        r0 = ".msg.img.$aeskey";
        r0 = r6.get(r0);
        r0 = (java.lang.String) r0;
        r5.NQ(r0);
    L_0x028b:
        r0 = r13.fFA;
        r0 = r0.fFC;
        r0 = r0.tzn;
        r0.add(r5);
        r0 = r13.fFA;
        r0 = r0.fFD;
        r1 = r0.tzz;
        r1 = r1 + 1;
        r0.tzz = r1;
        r1 = r2;
        goto L_0x007b;
    L_0x02a1:
        r3 = r1;
        goto L_0x0255;
    L_0x02a3:
        r3 = r0.GB();
        if (r3 != 0) goto L_0x02ab;
    L_0x02a9:
        r3 = r1;
        goto L_0x0255;
    L_0x02ab:
        r3 = com.tencent.mm.ah.e.a(r0);
        r6 = com.tencent.mm.ah.n.GS();
        r3 = r3.hEZ;
        r7 = "";
        r8 = "";
        r3 = r6.m(r3, r7, r8);
        r3 = com.tencent.mm.a.e.aO(r3);
        if (r3 != 0) goto L_0x02c7;
    L_0x02c5:
        r3 = r1;
        goto L_0x0255;
    L_0x02c7:
        r3 = r2;
        goto L_0x0255;
    L_0x02c9:
        r3 = "MicroMsg.GetFavRecordDataSource";
        r6 = "parse cdnInfo failed. [%s]";
        r7 = new java.lang.Object[r2];
        r0 = r0.hFj;
        r7[r1] = r0;
        com.tencent.mm.sdk.platformtools.w.i(r3, r6, r7);
        goto L_0x028b;
    L_0x02d9:
        r0 = r4.bMl();
        if (r0 == 0) goto L_0x02e5;
    L_0x02df:
        r1 = a(r13, r4, r15);
        goto L_0x007b;
    L_0x02e5:
        r0 = r4.bMm();
        if (r0 == 0) goto L_0x02f1;
    L_0x02eb:
        r1 = a(r13, r4, r15);
        goto L_0x007b;
    L_0x02f1:
        if (r15 == 0) goto L_0x0300;
    L_0x02f3:
        r0 = r4.field_type;
        r3 = 318767153; // 0x13000031 float:1.6155966E-27 double:1.574918993E-315;
        if (r0 != r3) goto L_0x0300;
    L_0x02fa:
        r1 = a(r12, r13, r4, r6);
        goto L_0x001b;
    L_0x0300:
        r0 = r4.bLX();
        if (r0 != 0) goto L_0x030c;
    L_0x0306:
        r0 = r4.bLY();
        if (r0 == 0) goto L_0x0312;
    L_0x030c:
        r1 = c(r13, r4);
        goto L_0x007b;
    L_0x0312:
        if (r15 == 0) goto L_0x0326;
    L_0x0314:
        r0 = r4.bMn();
        if (r0 != 0) goto L_0x0320;
    L_0x031a:
        r0 = r4.bMo();
        if (r0 == 0) goto L_0x0326;
    L_0x0320:
        r1 = a(r12, r13, r4, r2);
        goto L_0x007b;
    L_0x0326:
        if (r15 == 0) goto L_0x0335;
    L_0x0328:
        r0 = r4.field_type;
        r3 = 419430449; // 0x19000031 float:6.6174836E-24 double:2.072261757E-315;
        if (r0 != r3) goto L_0x0335;
    L_0x032f:
        r1 = a(r12, r13, r4, r9);
        goto L_0x007b;
    L_0x0335:
        r0 = r4.bMi();
        if (r0 == 0) goto L_0x03b0;
    L_0x033b:
        com.tencent.mm.u.ap.yY();
        r0 = com.tencent.mm.u.c.wT();
        r1 = r4.field_content;
        r0 = r0.Av(r1);
        r1 = new com.tencent.mm.protocal.c.rn;
        r1.<init>();
        r3 = T(r4);
        r1.c(r3);
        if (r0 == 0) goto L_0x03a5;
    L_0x0356:
        r0 = r0.rWg;
        r0 = com.tencent.mm.u.o.eW(r0);
        if (r0 == 0) goto L_0x03a5;
    L_0x035e:
        r0 = new com.tencent.mm.protocal.c.rm;
        r0.<init>();
        r3 = U(r4);
        r0.Od(r3);
        r3 = 16;
        r0.yb(r3);
        r3 = r4.field_content;
        r0.NM(r3);
        r0.jK(r2);
        r0.jJ(r2);
        r0.a(r1);
        r3 = r1.tyu;
        r3 = a(r3);
        r0.Og(r3);
        r1 = r1.tyu;
        r1 = b(r1);
        r0.Oh(r1);
    L_0x038f:
        r1 = r13.fFA;
        r1 = r1.fFC;
        r1 = r1.tzn;
        r1.add(r0);
        r0 = r13.fFA;
        r0 = r0.fFD;
        r1 = r0.tzM;
        r1 = r1 + 1;
        r0.tzM = r1;
        r1 = r2;
        goto L_0x007b;
    L_0x03a5:
        r0 = com.tencent.mm.R.l.dHt;
        r0 = r12.getString(r0);
        r0 = a(r4, r0, r1);
        goto L_0x038f;
    L_0x03b0:
        r0 = r4.axO();
        if (r0 == 0) goto L_0x089f;
    L_0x03b6:
        r0 = r4.bMo();
        if (r0 == 0) goto L_0x03c4;
    L_0x03bc:
        r0 = r13.fFA;
        r2 = com.tencent.mm.R.l.eij;
        r0.fFG = r2;
        goto L_0x007b;
    L_0x03c4:
        r3 = new com.tencent.mm.protocal.c.rn;
        r3.<init>();
        r0 = T(r4);
        r3.c(r0);
        r0 = r4.field_content;
        if (r0 != 0) goto L_0x03de;
    L_0x03d4:
        r0 = r13.fFA;
        r2 = com.tencent.mm.R.l.eik;
        r0.fFG = r2;
        r2 = r1;
    L_0x03db:
        r1 = r2;
        goto L_0x007b;
    L_0x03de:
        r5 = com.tencent.mm.t.f.a.ek(r0);
        if (r5 != 0) goto L_0x03ec;
    L_0x03e4:
        r0 = r13.fFA;
        r2 = com.tencent.mm.R.l.eik;
        r0.fFG = r2;
        r2 = r1;
        goto L_0x03db;
    L_0x03ec:
        r0 = r3.tyu;
        r6 = r5.appId;
        r0.Or(r6);
        r0 = r3.tyu;
        r6 = r5.fUR;
        r0.Ot(r6);
        r0 = r5.appId;
        r0 = com.tencent.mm.pluginsdk.model.app.g.aJ(r0, r2);
        if (r0 == 0) goto L_0x041e;
    L_0x0402:
        r0 = r0.bCU();
        if (r0 == 0) goto L_0x041e;
    L_0x0408:
        if (r15 == 0) goto L_0x041e;
    L_0x040a:
        r0 = com.tencent.mm.R.l.dHu;
        r0 = r12.getString(r0);
        r0 = a(r4, r0, r3);
        r1 = r13.fFA;
        r1 = r1.fFC;
        r1 = r1.tzn;
        r1.add(r0);
        goto L_0x03db;
    L_0x041e:
        r0 = r5.type;
        switch(r0) {
            case 1: goto L_0x0439;
            case 2: goto L_0x047d;
            case 3: goto L_0x04fb;
            case 4: goto L_0x052a;
            case 5: goto L_0x055e;
            case 6: goto L_0x0608;
            case 7: goto L_0x06a2;
            case 8: goto L_0x0423;
            case 9: goto L_0x0423;
            case 10: goto L_0x06cf;
            case 11: goto L_0x0423;
            case 12: goto L_0x0423;
            case 13: goto L_0x078e;
            case 14: goto L_0x0423;
            case 15: goto L_0x0423;
            case 16: goto L_0x087f;
            case 17: goto L_0x0423;
            case 18: goto L_0x0423;
            case 19: goto L_0x07f0;
            case 20: goto L_0x0731;
            case 21: goto L_0x0423;
            case 22: goto L_0x0423;
            case 23: goto L_0x0423;
            case 24: goto L_0x0868;
            default: goto L_0x0423;
        };
    L_0x0423:
        if (r15 == 0) goto L_0x0896;
    L_0x0425:
        r0 = com.tencent.mm.R.l.dIJ;
        r0 = r12.getString(r0);
        r0 = a(r4, r0, r3);
        r1 = r13.fFA;
        r1 = r1.fFC;
        r1 = r1.tzn;
        r1.add(r0);
        goto L_0x03db;
    L_0x0439:
        r0 = new com.tencent.mm.protocal.c.rm;
        r0.<init>();
        r1 = U(r4);
        r0.Od(r1);
        r0.yb(r2);
        r1 = r5.title;
        r0.NM(r1);
        r0.jK(r2);
        r0.jJ(r2);
        r0.a(r3);
        r1 = r3.tyu;
        r1 = a(r1);
        r0.Og(r1);
        r1 = r3.tyu;
        r1 = b(r1);
        r0.Oh(r1);
        r1 = r13.fFA;
        r1 = r1.fFC;
        r1 = r1.tzn;
        r1.add(r0);
        r0 = r13.fFA;
        r0 = r0.fFD;
        r1 = r0.tzy;
        r1 = r1 + 1;
        r0.tzy = r1;
        goto L_0x03db;
    L_0x047d:
        com.tencent.mm.u.ap.yY();
        r0 = com.tencent.mm.u.c.isSDCardAvailable();
        if (r0 != 0) goto L_0x048f;
    L_0x0486:
        r0 = r13.fFA;
        r2 = com.tencent.mm.R.l.eiq;
        r0.fFG = r2;
        r2 = r1;
        goto L_0x03db;
    L_0x048f:
        r0 = com.tencent.mm.pluginsdk.model.app.an.abL();
        r1 = r5.fCW;
        r0 = r0.LW(r1);
        r1 = new com.tencent.mm.protocal.c.rm;
        r1.<init>();
        r6 = U(r4);
        r1.Od(r6);
        if (r0 == 0) goto L_0x04ac;
    L_0x04a7:
        r0 = r0.field_fileFullPath;
        r1.NZ(r0);
    L_0x04ac:
        r0 = com.tencent.mm.ah.n.GS();
        r6 = r4.field_imgPath;
        r0 = r0.v(r6, r2);
        r6 = com.tencent.mm.a.e.aO(r0);
        if (r6 == 0) goto L_0x04bf;
    L_0x04bc:
        r1.Oa(r0);
    L_0x04bf:
        r1.yb(r9);
        r0 = r5.title;
        r1.NL(r0);
        r0 = r5.description;
        r1.NM(r0);
        r1.a(r3);
        r0 = r3.tyu;
        r0 = a(r0);
        r1.Og(r0);
        r0 = r3.tyu;
        r0 = b(r0);
        r1.Oh(r0);
        r6 = r4.field_msgId;
        r1.el(r6);
        r0 = r13.fFA;
        r0 = r0.fFC;
        r0 = r0.tzn;
        r0.add(r1);
        r0 = r13.fFA;
        r0 = r0.fFD;
        r1 = r0.tzz;
        r1 = r1 + 1;
        r0.tzz = r1;
        goto L_0x03db;
    L_0x04fb:
        r0 = 7;
        r0 = a(r4, r5, r0);
        r0.a(r3);
        r1 = r3.tyu;
        r1 = a(r1);
        r0.Og(r1);
        r1 = r3.tyu;
        r1 = b(r1);
        r0.Oh(r1);
        r1 = r13.fFA;
        r1 = r1.fFC;
        r1 = r1.tzn;
        r1.add(r0);
        r0 = r13.fFA;
        r0 = r0.fFD;
        r1 = r0.tzE;
        r1 = r1 + 1;
        r0.tzE = r1;
        goto L_0x03db;
    L_0x052a:
        r0 = 4;
        r0 = a(r4, r5, r0);
        r0.a(r3);
        r1 = r3.tyu;
        r1 = a(r1);
        r0.Og(r1);
        r1 = r3.tyu;
        r1 = b(r1);
        r0.Oh(r1);
        r6 = r4.field_msgId;
        r0.el(r6);
        r1 = r13.fFA;
        r1 = r1.fFC;
        r1 = r1.tzn;
        r1.add(r0);
        r0 = r13.fFA;
        r0 = r0.fFD;
        r1 = r0.tzB;
        r1 = r1 + 1;
        r0.tzB = r1;
        goto L_0x03db;
    L_0x055e:
        r0 = r5.url;
        if (r0 == 0) goto L_0x05e8;
    L_0x0562:
        r0 = r5.url;
        r6 = "";
        r0 = r0.equals(r6);
        if (r0 != 0) goto L_0x05e8;
    L_0x056d:
        r0 = r3.tyu;
        r1 = r5.url;
        r0.Os(r1);
        r0 = 5;
        r0 = a(r4, r5, r0);
        r0.a(r3);
        r1 = r3.tyu;
        r1 = a(r1);
        r0.Og(r1);
        r1 = r3.tyu;
        r1 = b(r1);
        r0.Oh(r1);
        r1 = new com.tencent.mm.protocal.c.sf;
        r1.<init>();
        r6 = r5.title;
        r6 = com.tencent.mm.sdk.platformtools.bg.mA(r6);
        if (r6 != 0) goto L_0x05a0;
    L_0x059b:
        r6 = r5.title;
        r1.OQ(r6);
    L_0x05a0:
        r6 = r5.description;
        r6 = com.tencent.mm.sdk.platformtools.bg.mA(r6);
        if (r6 != 0) goto L_0x05ad;
    L_0x05a8:
        r6 = r5.description;
        r1.OR(r6);
    L_0x05ad:
        r6 = r5.thumburl;
        r6 = com.tencent.mm.sdk.platformtools.bg.mA(r6);
        if (r6 != 0) goto L_0x05ba;
    L_0x05b5:
        r6 = r5.thumburl;
        r1.OT(r6);
    L_0x05ba:
        r6 = r5.canvasPageXml;
        r6 = com.tencent.mm.sdk.platformtools.bg.mA(r6);
        if (r6 != 0) goto L_0x05c7;
    L_0x05c2:
        r5 = r5.canvasPageXml;
        r1.OU(r5);
    L_0x05c7:
        r5 = r1.aUk();
        if (r5 <= 0) goto L_0x05d3;
    L_0x05cd:
        r1.yk(r2);
        r3.a(r1);
    L_0x05d3:
        r1 = r13.fFA;
        r1 = r1.fFC;
        r1 = r1.tzn;
        r1.add(r0);
        r0 = r13.fFA;
        r0 = r0.fFD;
        r1 = r0.tzC;
        r1 = r1 + 1;
        r0.tzC = r1;
        goto L_0x03db;
    L_0x05e8:
        r0 = r13.fFA;
        r5 = com.tencent.mm.R.l.eif;
        r0.fFG = r5;
        if (r15 == 0) goto L_0x0605;
    L_0x05f0:
        r0 = com.tencent.mm.R.l.dIJ;
        r0 = r12.getString(r0);
        r0 = a(r4, r0, r3);
        r1 = r13.fFA;
        r1 = r1.fFC;
        r1 = r1.tzn;
        r1.add(r0);
        goto L_0x03db;
    L_0x0605:
        r2 = r1;
        goto L_0x03db;
    L_0x0608:
        com.tencent.mm.u.ap.yY();
        r0 = com.tencent.mm.u.c.isSDCardAvailable();
        if (r0 != 0) goto L_0x061a;
    L_0x0611:
        r0 = r13.fFA;
        r2 = com.tencent.mm.R.l.eiq;
        r0.fFG = r2;
        r2 = r1;
        goto L_0x03db;
    L_0x061a:
        r0 = com.tencent.mm.pluginsdk.model.app.an.abL();
        r1 = r5.fCW;
        r0 = r0.LW(r1);
        r1 = new com.tencent.mm.protocal.c.rm;
        r1.<init>();
        if (r0 == 0) goto L_0x0630;
    L_0x062b:
        r0 = r0.field_fileFullPath;
        r1.NZ(r0);
    L_0x0630:
        r0 = U(r4);
        r1.Od(r0);
        r0 = 8;
        r1.yb(r0);
        r0 = r5.hhr;
        r1.NV(r0);
        r0 = com.tencent.mm.ah.n.GS();
        r6 = r4.field_imgPath;
        r0 = r0.v(r6, r2);
        r6 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
        if (r6 == 0) goto L_0x0654;
    L_0x0651:
        r1.jK(r2);
    L_0x0654:
        r6 = com.tencent.mm.a.e.aO(r0);
        if (r6 == 0) goto L_0x065d;
    L_0x065a:
        r1.Oa(r0);
    L_0x065d:
        r0 = r5.title;
        r1.NL(r0);
        r0 = r5.description;
        r1.NM(r0);
        r1.a(r3);
        r0 = r3.tyu;
        r0 = a(r0);
        r1.Og(r0);
        r0 = r3.tyu;
        r0 = b(r0);
        r1.Oh(r0);
        r6 = r4.field_msgId;
        r1.el(r6);
        if (r15 == 0) goto L_0x068d;
    L_0x0683:
        r0 = r5.hhx;
        r1.NP(r0);
        r0 = r5.hhE;
        r1.NQ(r0);
    L_0x068d:
        r0 = r13.fFA;
        r0 = r0.fFC;
        r0 = r0.tzn;
        r0.add(r1);
        r0 = r13.fFA;
        r0 = r0.fFD;
        r1 = r0.tzF;
        r1 = r1 + 1;
        r0.tzF = r1;
        goto L_0x03db;
    L_0x06a2:
        r0 = r5.fCW;
        if (r0 == 0) goto L_0x06ae;
    L_0x06a6:
        r0 = r5.fCW;
        r0 = r0.length();
        if (r0 != 0) goto L_0x06bd;
    L_0x06ae:
        r0 = r13.fFA;
        r2 = com.tencent.mm.R.l.eic;
        r0.fFG = r2;
    L_0x06b4:
        r0 = r13.fFA;
        r2 = com.tencent.mm.R.l.eij;
        r0.fFG = r2;
        r2 = r1;
        goto L_0x03db;
    L_0x06bd:
        com.tencent.mm.u.ap.yY();
        r0 = com.tencent.mm.u.c.isSDCardAvailable();
        if (r0 != 0) goto L_0x06b4;
    L_0x06c6:
        r0 = r13.fFA;
        r2 = com.tencent.mm.R.l.eiq;
        r0.fFG = r2;
        r2 = r1;
        goto L_0x03db;
    L_0x06cf:
        r0 = new com.tencent.mm.protocal.c.ru;
        r0.<init>();
        r1 = r5.title;
        r0.Ow(r1);
        r1 = r5.description;
        r0.Ox(r1);
        r1 = r5.hhL;
        r0.yg(r1);
        r1 = r5.hhM;
        r0.Oz(r1);
        r1 = r5.thumburl;
        r0.Oy(r1);
        r3.a(r0);
        r0 = new com.tencent.mm.protocal.c.rm;
        r0.<init>();
        r1 = U(r4);
        r0.Od(r1);
        r1 = 10;
        r0.yb(r1);
        r0.jK(r2);
        r0.jJ(r2);
        r0.a(r3);
        r1 = r3.tyu;
        r1 = a(r1);
        r0.Og(r1);
        r1 = r3.tyu;
        r1 = b(r1);
        r0.Oh(r1);
        r1 = r13.fFA;
        r1 = r1.fFC;
        r1 = r1.tzn;
        r1.add(r0);
        r0 = r13.fFA;
        r0 = r0.fFD;
        r1 = r0.tzH;
        r1 = r1 + 1;
        r0.tzH = r1;
        goto L_0x03db;
    L_0x0731:
        r0 = new com.tencent.mm.protocal.c.rz;
        r0.<init>();
        r1 = r5.title;
        r0.OM(r1);
        r1 = r5.description;
        r0.ON(r1);
        r1 = r5.hhP;
        r0.OP(r1);
        r1 = r5.thumburl;
        r0.OO(r1);
        r3.a(r0);
        r0 = new com.tencent.mm.protocal.c.rm;
        r0.<init>();
        r1 = U(r4);
        r0.Od(r1);
        r1 = 14;
        r0.yb(r1);
        r0.jK(r2);
        r0.jJ(r2);
        r0.a(r3);
        r1 = r3.tyu;
        r1 = a(r1);
        r0.Og(r1);
        r1 = r3.tyu;
        r1 = b(r1);
        r0.Oh(r1);
        r1 = r13.fFA;
        r1 = r1.fFC;
        r1 = r1.tzn;
        r1.add(r0);
        r0 = r13.fFA;
        r0 = r0.fFD;
        r1 = r0.tzL;
        r1 = r1 + 1;
        r0.tzL = r1;
        goto L_0x03db;
    L_0x078e:
        r0 = new com.tencent.mm.protocal.c.ru;
        r0.<init>();
        r1 = r5.title;
        r0.Ow(r1);
        r1 = r5.description;
        r0.Ox(r1);
        r1 = r5.hhR;
        r0.yg(r1);
        r1 = r5.hhS;
        r0.Oz(r1);
        r1 = r5.thumburl;
        r0.Oy(r1);
        r3.a(r0);
        r0 = new com.tencent.mm.protocal.c.rm;
        r0.<init>();
        r1 = U(r4);
        r0.Od(r1);
        r1 = 11;
        r0.yb(r1);
        r0.jK(r2);
        r0.jJ(r2);
        r0.a(r3);
        r1 = r3.tyu;
        r1 = a(r1);
        r0.Og(r1);
        r1 = r3.tyu;
        r1 = b(r1);
        r0.Oh(r1);
        r1 = r13.fFA;
        r1 = r1.fFC;
        r1 = r1.tzn;
        r1.add(r0);
        r0 = r13.fFA;
        r0 = r0.fFD;
        r1 = r0.tzI;
        r1 = r1 + 1;
        r0.tzI = r1;
        goto L_0x03db;
    L_0x07f0:
        r0 = r5.hhQ;
        if (r0 == 0) goto L_0x0866;
    L_0x07f4:
        r0 = r5.hhQ;
        r6 = "<recordxml>";
        r0 = r0.contains(r6);
        if (r0 == 0) goto L_0x0866;
    L_0x07ff:
        r0 = r2;
    L_0x0800:
        if (r0 != 0) goto L_0x0868;
    L_0x0802:
        r6 = new com.tencent.mm.protocal.c.rm;
        r6.<init>();
        r0 = U(r4);
        r6.Od(r0);
        r0 = 17;
        r6.yb(r0);
        r6.jK(r2);
        r0 = r5.title;
        r6.NL(r0);
        r0 = r5.hhQ;
        r6.Ol(r0);
        r0 = r5.description;
        r7 = new com.tencent.mm.e.a.lz;
        r7.<init>();
        r8 = r7.fTf;
        r8.type = r1;
        r1 = r7.fTf;
        r5 = r5.hhQ;
        r1.fTh = r5;
        r1 = com.tencent.mm.sdk.b.a.urY;
        r1.m(r7);
        r1 = r7.fTg;
        r1 = r1.fTp;
        if (r1 == 0) goto L_0x083e;
    L_0x083c:
        r0 = r1.desc;
    L_0x083e:
        r6.NM(r0);
        r6.a(r3);
        r0 = r3.tyu;
        r0 = a(r0);
        r6.Og(r0);
        r0 = r3.tyu;
        r0 = b(r0);
        r6.Oh(r0);
        r0 = r4.field_msgId;
        r6.el(r0);
        r0 = r13.fFA;
        r0 = r0.fFC;
        r0 = r0.tzn;
        r0.add(r6);
        goto L_0x03db;
    L_0x0866:
        r0 = r1;
        goto L_0x0800;
    L_0x0868:
        if (r15 == 0) goto L_0x087f;
    L_0x086a:
        r0 = com.tencent.mm.R.l.ejR;
        r0 = r12.getString(r0);
        r0 = a(r4, r0, r3);
        r1 = r13.fFA;
        r1 = r1.fFC;
        r1 = r1.tzn;
        r1.add(r0);
        goto L_0x03db;
    L_0x087f:
        if (r15 == 0) goto L_0x0423;
    L_0x0881:
        r0 = com.tencent.mm.R.l.dIm;
        r0 = r12.getString(r0);
        r0 = a(r4, r0, r3);
        r1 = r13.fFA;
        r1 = r1.fFC;
        r1 = r1.tzn;
        r1.add(r0);
        goto L_0x03db;
    L_0x0896:
        r0 = r13.fFA;
        r2 = com.tencent.mm.R.l.eij;
        r0.fFG = r2;
        r2 = r1;
        goto L_0x03db;
    L_0x089f:
        r0 = r13.fFA;
        r2 = com.tencent.mm.R.l.eij;
        r0.fFG = r2;
        if (r15 == 0) goto L_0x007b;
    L_0x08a7:
        r1 = a(r12, r13, r4, r6);
        goto L_0x007b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.pluginsdk.model.g.a(android.content.Context, com.tencent.mm.e.a.cb, com.tencent.mm.storage.au, boolean):boolean");
    }

    private static boolean a(Context context, cb cbVar, au auVar, int i) {
        rn rnVar = new rn();
        rnVar.c(T(auVar));
        String str = null;
        if (i == 1) {
            str = context.getString(R.l.dGL);
        } else if (i == 2) {
            str = context.getString(R.l.dHV);
        } else if (i == 3) {
            str = context.getString(R.l.dIJ);
        }
        cbVar.fFA.fFC.tzn.add(a(auVar, str, rnVar));
        return true;
    }

    private static rw LQ(String str) {
        rw rwVar = new rw();
        rwVar.OD(str);
        rwVar.yj(1);
        rwVar.ep(bg.Nz());
        rwVar.OF("");
        return rwVar;
    }

    private static ro T(au auVar) {
        ro roVar = new ro();
        if (auVar.field_isSend == 1 || auVar.field_content.startsWith("<msg>")) {
            roVar.Om(m.xL());
            roVar.On(auVar.field_talker);
            if (o.dH(auVar.field_talker)) {
                roVar.Op(roVar.fOu);
            }
        } else {
            roVar.Om(auVar.field_talker);
            roVar.On(m.xL());
            if (o.dH(auVar.field_talker)) {
                roVar.Op(auVar.field_content != null ? auVar.field_content.substring(0, Math.max(0, auVar.field_content.indexOf(58))) : "");
                if (!(bg.mA(roVar.tyQ) || auVar.bLZ())) {
                    auVar.setContent(auVar.field_content.substring(roVar.tyQ.length() + 1));
                    if (auVar.field_content.length() > 0 && '\n' == auVar.field_content.charAt(0)) {
                        auVar.setContent(auVar.field_content.substring(1));
                    }
                    if (auVar.bMs()) {
                        auVar.cK(auVar.field_transContent.substring(roVar.tyQ.length() + 1));
                        if (auVar.field_transContent.length() > 0 && '\n' == auVar.field_transContent.charAt(0)) {
                            auVar.cK(auVar.field_transContent.substring(1));
                        }
                    }
                }
            }
        }
        if (e.dr(auVar.field_talker)) {
            String str = auVar.field_bizChatUserId;
            if (str == null) {
                str = ay.gm(auVar.gxF).userId;
            }
            roVar.Op(str);
        }
        roVar.ye(1);
        roVar.em(auVar.field_createTime);
        roVar.Oq(auVar.field_msgSvrId);
        if (auVar.field_msgSvrId > 0) {
            roVar.Oo(auVar.field_msgSvrId);
        }
        return roVar;
    }

    private static String a(ro roVar) {
        String str = roVar.tyQ;
        if (bg.mA(str)) {
            str = roVar.fOu;
        }
        if (com.tencent.mm.modelbiz.a.e.ir(str)) {
            return com.tencent.mm.modelbiz.a.e.it(str);
        }
        return n.eJ(str);
    }

    private static String b(ro roVar) {
        return saY.format(new Date(roVar.iam));
    }

    private static String U(au auVar) {
        if (auVar.field_isSend != 1) {
            return String.valueOf(auVar.field_msgSvrId);
        }
        if (o.dH(auVar.field_talker) || auVar.field_talker.equals("filehelper")) {
            return String.format("%d", new Object[]{Long.valueOf(auVar.field_msgSvrId)});
        }
        return String.format("%s#%d", new Object[]{auVar.field_talker, Long.valueOf(auVar.field_msgSvrId)});
    }

    private static boolean b(cb cbVar, au auVar) {
        rn rnVar = new rn();
        rnVar.c(T(auVar));
        Map q = bh.q(auVar.field_content, "msg");
        if (q != null) {
            try {
                rs rsVar = new rs();
                rsVar.Ou((String) q.get(".msg.location.$label"));
                rsVar.m(Double.parseDouble((String) q.get(".msg.location.$x")));
                rsVar.l(Double.parseDouble((String) q.get(".msg.location.$y")));
                rsVar.yf(Integer.valueOf((String) q.get(".msg.location.$scale")).intValue());
                rsVar.Ov((String) q.get(".msg.location.$poiname"));
                rnVar.a(rsVar);
                rm rmVar = new rm();
                rmVar.Od(U(auVar));
                rmVar.yb(6);
                rmVar.jK(true);
                rmVar.jJ(true);
                rmVar.a(rnVar);
                rmVar.Og(a(rnVar.tyu));
                rmVar.Oh(b(rnVar.tyu));
                cbVar.fFA.fFC.tzn.add(rmVar);
                se seVar = cbVar.fFA.fFD;
                seVar.tzD++;
                return true;
            } catch (Exception e) {
                w.e("MicroMsg.GetFavRecordDataSource", "parse failed, %s", e.getStackTrace().toString());
            }
        }
        cbVar.fFA.fFG = R.l.eik;
        return false;
    }

    private static boolean a(cb cbVar, au auVar, boolean z) {
        rn rnVar = new rn();
        rnVar.c(T(auVar));
        rm rmVar = new rm();
        rmVar.Od(U(auVar));
        com.tencent.mm.modelvideo.o.KV();
        rmVar.NZ(s.lv(auVar.field_imgPath));
        com.tencent.mm.modelvideo.o.KV();
        rmVar.Oa(s.lw(auVar.field_imgPath));
        rmVar.NV(com.tencent.mm.a.e.aQ(rmVar.txG));
        if (auVar.bMm()) {
            rmVar.yb(15);
        } else {
            rmVar.yb(4);
        }
        r lH = t.lH(auVar.field_imgPath);
        w.i("MicroMsg.GetFavRecordDataSource", "video length is %d", Integer.valueOf(lH.hrs));
        if (lH.hrs > b.sD()) {
            cbVar.fFA.fFG = R.l.ejH;
            return false;
        } else if (auVar.bMm() && t.lJ(lH.getFileName())) {
            cbVar.fFA.fFG = R.l.eia;
            return false;
        } else {
            rmVar.ya(lH.iap);
            rmVar.a(rnVar);
            rmVar.Og(a(rnVar.tyu));
            rmVar.Oh(b(rnVar.tyu));
            rmVar.el(auVar.field_msgId);
            rmVar.ej((long) lH.hrs);
            if (z) {
                Map q = bh.q(lH.Lh(), "msg");
                if (q != null) {
                    rmVar.NP((String) q.get(".msg.videomsg.$cdnvideourl"));
                    rmVar.NQ((String) q.get(".msg.videomsg.$aeskey"));
                } else {
                    w.i("MicroMsg.GetFavRecordDataSource", "cdntra parse video recv xml failed");
                }
            }
            cbVar.fFA.fFC.tzn.add(rmVar);
            se seVar = cbVar.fFA.fFD;
            seVar.tzB++;
            r lH2 = t.lH(auVar.field_imgPath);
            rmVar.Oj(lH2.fUY);
            bdu com_tencent_mm_protocal_c_bdu = lH2.iay;
            if (!(com_tencent_mm_protocal_c_bdu == null || bg.mA(com_tencent_mm_protocal_c_bdu.hjJ))) {
                rp rpVar = new rp();
                rpVar.hjD = com_tencent_mm_protocal_c_bdu.hjD;
                rpVar.tyZ = com_tencent_mm_protocal_c_bdu.tyZ;
                rpVar.hjG = com_tencent_mm_protocal_c_bdu.hjG;
                rpVar.hjH = com_tencent_mm_protocal_c_bdu.hjH;
                rpVar.hjF = com_tencent_mm_protocal_c_bdu.hjF;
                rpVar.hjI = com_tencent_mm_protocal_c_bdu.hjI;
                rpVar.hjJ = com_tencent_mm_protocal_c_bdu.hjJ;
                rpVar.hjK = com_tencent_mm_protocal_c_bdu.hjK;
                rmVar.a(rpVar);
            }
            return true;
        }
    }

    private static rm a(au auVar, f.a aVar, int i) {
        rm rmVar = new rm();
        rmVar.Od(U(auVar));
        rmVar.NS(aVar.hhH);
        rmVar.NT(aVar.hhI);
        rmVar.NR(aVar.url);
        rmVar.jJ(true);
        File file = new File(bg.ap(com.tencent.mm.ah.n.GS().v(auVar.field_imgPath, true), ""));
        if (file.exists()) {
            rmVar.Oa(file.getAbsolutePath());
        } else {
            rmVar.jK(true);
        }
        rmVar.NL(aVar.title);
        rmVar.NM(aVar.description);
        rmVar.yb(i);
        rmVar.Ok(aVar.canvasPageXml);
        return rmVar;
    }

    private static rm a(au auVar, String str, rn rnVar) {
        rm rmVar = new rm();
        rmVar.Od(U(auVar));
        rmVar.yb(1);
        rmVar.NM(str);
        rmVar.jK(true);
        rmVar.jJ(true);
        rmVar.a(rnVar);
        rmVar.Og(a(rnVar.tyu));
        rmVar.Oh(b(rnVar.tyu));
        return rmVar;
    }

    private static boolean c(cb cbVar, au auVar) {
        try {
            k rV = ((a) h.h(a.class)).rV(auVar.field_content);
            List<l> list = rV.hkm;
            if (list != null) {
                int i = 0;
                for (l lVar : list) {
                    if (!com.tencent.mm.t.h.em(lVar.hkx)) {
                        rn rnVar = new rn();
                        rnVar.c(T(auVar));
                        rnVar.tyu.Ot(rV.fUR);
                        rnVar.tyu.Os(lVar.url);
                        rm rmVar = new rm();
                        rmVar.NL(lVar.title);
                        rmVar.NM(lVar.hku);
                        rmVar.Od(U(auVar));
                        if (bg.mA(lVar.hks)) {
                            rmVar.jK(true);
                        } else {
                            rmVar.Oa(s.n(lVar.hks, auVar.field_type, i == 0 ? "@T" : "@S"));
                        }
                        rmVar.jJ(true);
                        sf sfVar = new sf();
                        if (!bg.mA(lVar.title)) {
                            sfVar.OQ(lVar.title);
                        }
                        if (!bg.mA(lVar.hku)) {
                            sfVar.OR(lVar.hku);
                        }
                        if (!bg.mA(lVar.hks)) {
                            sfVar.OT(lVar.hks);
                        }
                        if (sfVar.aUk() > 0) {
                            sfVar.yk(1);
                            rnVar.a(sfVar);
                        }
                        rmVar.yb(5);
                        rmVar.a(rnVar);
                        rmVar.Og(a(rnVar.tyu));
                        rmVar.Oh(b(rnVar.tyu));
                        cbVar.fFA.fFC.tzn.add(rmVar);
                        se seVar = cbVar.fFA.fFD;
                        seVar.tzC++;
                        i++;
                    }
                }
                if (i != 0) {
                    return true;
                }
                cbVar.fFA.fFG = R.l.eij;
                return false;
            }
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.GetFavRecordDataSource", e, "", new Object[0]);
            w.e("MicroMsg.GetFavRecordDataSource", "retransmit app msg error : %s", e.getLocalizedMessage());
        }
        cbVar.fFA.fFG = R.l.eik;
        return false;
    }
}
