package com.tencent.mm.plugin.messenger.foundation;

import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.messenger.foundation.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.protocal.c.ame;
import com.tencent.mm.protocal.c.lu;
import com.tencent.mm.protocal.c.ne;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.o;

public final class a implements p {
    private static final a nyk = new a();

    private static final class a extends com.tencent.mm.bn.a<b> implements b {
        public final void a(x xVar, x xVar2, ame com_tencent_mm_protocal_c_ame, byte[] bArr, boolean z) {
            final x xVar3 = xVar;
            final x xVar4 = xVar2;
            final ame com_tencent_mm_protocal_c_ame2 = com_tencent_mm_protocal_c_ame;
            final byte[] bArr2 = bArr;
            final boolean z2 = z;
            a(new com.tencent.mm.bn.a.a<b>(this) {
                final /* synthetic */ a nyq;

                public final /* synthetic */ void ao(Object obj) {
                    ((b) obj).a(xVar3, xVar4, com_tencent_mm_protocal_c_ame2, bArr2, z2);
                }
            });
        }

        public final void b(x xVar, x xVar2, ame com_tencent_mm_protocal_c_ame, byte[] bArr, boolean z) {
            final x xVar3 = xVar;
            final x xVar4 = xVar2;
            final ame com_tencent_mm_protocal_c_ame2 = com_tencent_mm_protocal_c_ame;
            final byte[] bArr2 = bArr;
            final boolean z2 = z;
            a(new com.tencent.mm.bn.a.a<b>(this) {
                final /* synthetic */ a nyq;

                public final /* synthetic */ void ao(Object obj) {
                    ((b) obj).b(xVar3, xVar4, com_tencent_mm_protocal_c_ame2, bArr2, z2);
                }
            });
        }
    }

    public static com.tencent.mm.vending.b.b a(b bVar) {
        return nyk.bI(bVar);
    }

    public final void a(lu luVar, byte[] bArr, boolean z, r rVar) {
        switch (luVar.tsa) {
            case 2:
            case 17:
                ame com_tencent_mm_protocal_c_ame = (ame) new ame().aD(bArr);
                String str = "";
                if (!z) {
                    bArr = null;
                }
                a(com_tencent_mm_protocal_c_ame, str, bArr, false, z);
                return;
            case 4:
                com.tencent.mm.bd.a aVar = (ne) new ne().aD(bArr);
                String a = n.a(aVar.ttp);
                w.i("MicroMsg.ContactSyncExtension", "processDelContact user:%s", a);
                ((h) com.tencent.mm.kernel.h.h(h.class)).wW().Rl(a);
                o.eX(a);
                s.a(4, aVar);
                return;
            default:
                return;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(com.tencent.mm.protocal.c.ame r10, java.lang.String r11, byte[] r12, boolean r13, boolean r14) {
        /*
        if (r10 != 0) goto L_0x000c;
    L_0x0002:
        r0 = "MicroMsg.ContactSyncExtension";
        r1 = "unable to parse mod contact";
        com.tencent.mm.sdk.platformtools.w.f(r0, r1);
    L_0x000b:
        return;
    L_0x000c:
        r0 = r10.ttp;
        r3 = com.tencent.mm.platformtools.n.a(r0);
        r0 = r10.tQL;
        r6 = com.tencent.mm.sdk.platformtools.bg.mz(r0);
        r0 = com.tencent.mm.sdk.platformtools.bg.mA(r3);
        if (r0 == 0) goto L_0x0037;
    L_0x001e:
        r0 = com.tencent.mm.sdk.platformtools.bg.mA(r6);
        if (r0 == 0) goto L_0x0037;
    L_0x0024:
        r0 = "MicroMsg.ContactSyncExtension";
        r1 = "processModContact user is null user:%s enuser:%s";
        r2 = 2;
        r2 = new java.lang.Object[r2];
        r4 = 0;
        r2[r4] = r3;
        r3 = 1;
        r2[r3] = r6;
        com.tencent.mm.sdk.platformtools.w.e(r0, r1, r2);
        goto L_0x000b;
    L_0x0037:
        r0 = "MicroMsg.ContactSyncExtension";
        r1 = "username %s mobileHash %s mobileFullHash %s";
        r2 = 3;
        r2 = new java.lang.Object[r2];
        r4 = 0;
        r5 = r10.ttp;
        r2[r4] = r5;
        r4 = 1;
        r5 = r10.tQO;
        r2[r4] = r5;
        r4 = 2;
        r5 = r10.tQP;
        r2[r4] = r5;
        com.tencent.mm.sdk.platformtools.w.i(r0, r1, r2);
        r0 = com.tencent.mm.plugin.messenger.foundation.a.h.class;
        r0 = com.tencent.mm.kernel.h.h(r0);
        r0 = (com.tencent.mm.plugin.messenger.foundation.a.h) r0;
        r0 = r0.wR();
        r1 = r0.Rc(r3);
        if (r1 == 0) goto L_0x007c;
    L_0x0064:
        r0 = r1.field_encryptUsername;
        r0 = r3.equals(r0);
        if (r0 == 0) goto L_0x007c;
    L_0x006c:
        r0 = "MicroMsg.ContactSyncExtension";
        r1 = "cat's replace user with stranger  user:%s";
        r2 = 1;
        r2 = new java.lang.Object[r2];
        r4 = 0;
        r2[r4] = r3;
        com.tencent.mm.sdk.platformtools.w.w(r0, r1, r2);
        goto L_0x000b;
    L_0x007c:
        r0 = 0;
        if (r1 == 0) goto L_0x035c;
    L_0x007f:
        r2 = r1.bLk();
        if (r2 == 0) goto L_0x035c;
    L_0x0085:
        if (r1 != 0) goto L_0x008c;
    L_0x0087:
        r1 = new com.tencent.mm.storage.x;
        r1.<init>(r3);
    L_0x008c:
        r1.setUsername(r3);
        r0 = r10.hAI;
        r1.bO(r0);
        r0 = r10.tsx;
        r4 = r10.tsy;
        r0 = r0 & r4;
        r1.setType(r0);
        if (r13 == 0) goto L_0x00ce;
    L_0x009e:
        if (r2 == 0) goto L_0x00ce;
    L_0x00a0:
        r4 = r2.gTQ;
        r0 = (int) r4;
        if (r0 <= 0) goto L_0x00ce;
    L_0x00a5:
        r0 = "MicroMsg.ContactSyncExtension";
        r4 = "processModContact Fuck GETCONTACT can't give the REAL_TYPE (mariohuang), user:%s old:%d get:%d";
        r5 = 3;
        r5 = new java.lang.Object[r5];
        r7 = 0;
        r5[r7] = r3;
        r7 = 1;
        r8 = r2.field_type;
        r8 = java.lang.Integer.valueOf(r8);
        r5[r7] = r8;
        r7 = 2;
        r8 = r1.field_type;
        r8 = java.lang.Integer.valueOf(r8);
        r5[r7] = r8;
        com.tencent.mm.sdk.platformtools.w.w(r0, r4, r5);
        r0 = r1.field_type;
        r4 = r2.field_type;
        r0 = r0 | r4;
        r1.setType(r0);
    L_0x00ce:
        r0 = com.tencent.mm.sdk.platformtools.bg.mA(r6);
        if (r0 != 0) goto L_0x02f5;
    L_0x00d4:
        r1.bX(r6);
    L_0x00d7:
        if (r2 != 0) goto L_0x0303;
    L_0x00d9:
        r4 = 0;
    L_0x00db:
        r1.gTQ = r4;
        r0 = r10.tLj;
        r0 = com.tencent.mm.platformtools.n.a(r0);
        r1.bR(r0);
        r0 = r10.ttf;
        r0 = com.tencent.mm.platformtools.n.a(r0);
        r1.bS(r0);
        r0 = r10.ttg;
        r0 = com.tencent.mm.platformtools.n.a(r0);
        r1.bT(r0);
        r0 = r10.hAD;
        r1.di(r0);
        r0 = r10.tsD;
        r1.dl(r0);
        r0 = r10.tQF;
        r0 = com.tencent.mm.platformtools.n.a(r0);
        r1.bQ(r0);
        r0 = r10.tsH;
        r1.dm(r0);
        r0 = r10.hAH;
        r1.dn(r0);
        r0 = r10.hAM;
        r4 = r10.hAE;
        r5 = r10.hAF;
        r0 = com.tencent.mm.storage.RegionCodeDecoder.ab(r0, r4, r5);
        r1.ck(r0);
        r0 = r10.hAG;
        r1.ce(r0);
        r0 = r10.tMP;
        r1.de(r0);
        r0 = r10.tMQ;
        r1.cj(r0);
        r0 = r10.tfW;
        r1.setSource(r0);
        r0 = r10.tMT;
        r1.dd(r0);
        r0 = r10.tMS;
        r1.bU(r0);
        r0 = r10.tMR;
        r0 = com.tencent.mm.u.o.fK(r0);
        if (r0 == 0) goto L_0x014d;
    L_0x0148:
        r0 = r10.tMR;
        r1.ci(r0);
    L_0x014d:
        r0 = r1.bLh();
        if (r0 == 0) goto L_0x015b;
    L_0x0153:
        r4 = com.tencent.mm.sdk.platformtools.bg.Ny();
        r0 = (int) r4;
        r1.dp(r0);
    L_0x015b:
        r0 = android.text.TextUtils.isEmpty(r11);
        if (r0 != 0) goto L_0x0164;
    L_0x0161:
        r1.cs(r11);
    L_0x0164:
        r0 = r10.tQl;
        r0 = com.tencent.mm.platformtools.n.a(r0);
        r1.bP(r0);
        r0 = r10.tQn;
        r0 = com.tencent.mm.platformtools.n.a(r0);
        r1.bV(r0);
        r0 = r10.tQm;
        r0 = com.tencent.mm.platformtools.n.a(r0);
        r1.bW(r0);
        r0 = r10.tts;
        r1.bY(r0);
        r0 = r10.tgT;
        r1.cl(r0);
        r0 = r10.tQV;
        r1.cm(r0);
        r0 = com.tencent.mm.sdk.platformtools.bg.bm(r12);
        if (r0 != 0) goto L_0x0309;
    L_0x0194:
        r0 = com.tencent.mm.plugin.messenger.foundation.a.h.class;
        r0 = com.tencent.mm.kernel.h.h(r0);
        r0 = (com.tencent.mm.plugin.messenger.foundation.a.h) r0;
        r0 = r0.wR();
        r0.x(r3, r12);
    L_0x01a3:
        r0 = r10.tQU;
        r1.dg(r0);
        r0 = r10.tQQ;
        if (r0 == 0) goto L_0x01cd;
    L_0x01ac:
        r0 = r10.tQQ;
        r0 = r0.tfr;
        if (r0 == 0) goto L_0x01cd;
    L_0x01b2:
        r0 = r10.tQQ;
        r0 = r0.tfr;
        r0 = r0.tjr;
        r1.cn(r0);
        r0 = r10.tQQ;
        r0 = r0.tfr;
        r0 = r0.tjs;
        r1.co(r0);
        r0 = r10.tQQ;
        r0 = r0.tfr;
        r0 = r0.tjt;
        r1.cp(r0);
    L_0x01cd:
        if (r2 == 0) goto L_0x01dc;
    L_0x01cf:
        r0 = r2.field_type;
        r0 = com.tencent.mm.j.a.ez(r0);
        if (r0 != 0) goto L_0x01dc;
    L_0x01d7:
        r0 = r1.field_type;
        com.tencent.mm.j.a.ez(r0);
    L_0x01dc:
        r0 = com.tencent.mm.u.o.fE(r3);
        if (r0 == 0) goto L_0x01e5;
    L_0x01e2:
        r1.tl();
    L_0x01e5:
        r0 = r1.bLe();
        if (r0 == 0) goto L_0x01ee;
    L_0x01eb:
        r1.to();
    L_0x01ee:
        r0 = r10.gkP;
        r1.cq(r0);
        r0 = r10.tQZ;
        r1.dr(r0);
        r4 = "MicroMsg.ContactSyncExtension";
        r5 = "processModContact:user[%s,%s] id:%d nick:%s pin:%s delflag:%d type:%d [%d,%d] contype:%d notify:%d region[%s,%s,%s] src:%d LabelIDList:%s fromGetContactService:%b remark_Description:(%s,%s,%s)";
        r0 = 20;
        r7 = new java.lang.Object[r0];
        r0 = 0;
        r7[r0] = r3;
        r0 = 1;
        r7[r0] = r6;
        r0 = 2;
        r8 = r1.gTQ;
        r3 = (int) r8;
        r3 = java.lang.Integer.valueOf(r3);
        r7[r0] = r3;
        r0 = 3;
        r3 = r1.field_nickname;
        r7[r0] = r3;
        r0 = 4;
        r3 = r1.pC();
        r7[r0] = r3;
        r0 = 5;
        r3 = r1.field_deleteFlag;
        r3 = java.lang.Integer.valueOf(r3);
        r7[r0] = r3;
        r0 = 6;
        r3 = r1.field_type;
        r3 = java.lang.Integer.valueOf(r3);
        r7[r0] = r3;
        r0 = 7;
        r3 = r10.tsx;
        r3 = java.lang.Integer.valueOf(r3);
        r7[r0] = r3;
        r0 = 8;
        r3 = r10.tsy;
        r3 = java.lang.Integer.valueOf(r3);
        r7[r0] = r3;
        r0 = 9;
        r3 = r1.gkw;
        r3 = java.lang.Integer.valueOf(r3);
        r7[r0] = r3;
        r0 = 10;
        r3 = r1.gkz;
        r3 = java.lang.Integer.valueOf(r3);
        r7[r0] = r3;
        r0 = 11;
        r3 = r10.hAM;
        r7[r0] = r3;
        r0 = 12;
        r3 = r10.hAE;
        r7[r0] = r3;
        r0 = 13;
        r3 = r10.hAF;
        r7[r0] = r3;
        r0 = 14;
        r3 = r1.getSource();
        r3 = java.lang.Integer.valueOf(r3);
        r7[r0] = r3;
        r0 = 15;
        r3 = r1.field_contactLabelIds;
        r7[r0] = r3;
        r0 = 16;
        r3 = java.lang.Boolean.valueOf(r13);
        r7[r0] = r3;
        r3 = 17;
        r0 = r10.tgT;
        if (r0 != 0) goto L_0x031a;
    L_0x0289:
        r0 = 1;
    L_0x028a:
        r0 = java.lang.Boolean.valueOf(r0);
        r7[r3] = r0;
        r3 = 18;
        r0 = r10.tgT;
        if (r0 != 0) goto L_0x031d;
    L_0x0296:
        r0 = 0;
    L_0x0297:
        r0 = java.lang.Integer.valueOf(r0);
        r7[r3] = r0;
        r3 = 19;
        r0 = r10.tgT;
        if (r0 != 0) goto L_0x0325;
    L_0x02a3:
        r0 = "";
    L_0x02a6:
        r7[r3] = r0;
        com.tencent.mm.sdk.platformtools.w.i(r4, r5, r7);
        r0 = nyk;
        r3 = r10;
        r4 = r12;
        r5 = r14;
        r0.a(r1, r2, r3, r4, r5);
        r0 = com.tencent.mm.sdk.platformtools.bg.mA(r6);
        if (r0 != 0) goto L_0x032d;
    L_0x02b9:
        r0 = com.tencent.mm.plugin.messenger.foundation.a.h.class;
        r0 = com.tencent.mm.kernel.h.h(r0);
        r0 = (com.tencent.mm.plugin.messenger.foundation.a.h) r0;
        r0 = r0.wR();
        r0.b(r6, r1);
    L_0x02c8:
        r0 = nyk;
        r3 = r10;
        r4 = r12;
        r5 = r14;
        r0.b(r1, r2, r3, r4, r5);
        r0 = r1.field_type;
        r0 = r0 & 2048;
        if (r0 == 0) goto L_0x033d;
    L_0x02d6:
        if (r2 == 0) goto L_0x02e2;
    L_0x02d8:
        r0 = r2.field_type;
        r0 = r0 & 2048;
        r2 = r1.field_type;
        r2 = r2 & 2048;
        if (r0 == r2) goto L_0x000b;
    L_0x02e2:
        r0 = com.tencent.mm.plugin.messenger.foundation.a.h.class;
        r0 = com.tencent.mm.kernel.h.h(r0);
        r0 = (com.tencent.mm.plugin.messenger.foundation.a.h) r0;
        r0 = r0.wW();
        r1 = r1.field_username;
        r0.Rr(r1);
        goto L_0x000b;
    L_0x02f5:
        if (r2 == 0) goto L_0x00d7;
    L_0x02f7:
        r4 = r2.gTQ;
        r0 = (int) r4;
        if (r0 <= 0) goto L_0x00d7;
    L_0x02fc:
        r0 = r2.field_encryptUsername;
        r1.bX(r0);
        goto L_0x00d7;
    L_0x0303:
        r4 = r2.gTQ;
        r0 = (int) r4;
        r4 = (long) r0;
        goto L_0x00db;
    L_0x0309:
        r0 = com.tencent.mm.plugin.messenger.foundation.a.h.class;
        r0 = com.tencent.mm.kernel.h.h(r0);
        r0 = (com.tencent.mm.plugin.messenger.foundation.a.h) r0;
        r0 = r0.wR();
        r0.Rh(r3);
        goto L_0x01a3;
    L_0x031a:
        r0 = 0;
        goto L_0x028a;
    L_0x031d:
        r0 = r10.tgT;
        r0 = r0.length();
        goto L_0x0297;
    L_0x0325:
        r0 = r10.tgT;
        r0 = com.tencent.mm.sdk.platformtools.bg.Qj(r0);
        goto L_0x02a6;
    L_0x032d:
        r0 = com.tencent.mm.plugin.messenger.foundation.a.h.class;
        r0 = com.tencent.mm.kernel.h.h(r0);
        r0 = (com.tencent.mm.plugin.messenger.foundation.a.h) r0;
        r0 = r0.wR();
        r0.Q(r1);
        goto L_0x02c8;
    L_0x033d:
        if (r2 == 0) goto L_0x0349;
    L_0x033f:
        r0 = r2.field_type;
        r0 = r0 & 2048;
        r2 = r1.field_type;
        r2 = r2 & 2048;
        if (r0 == r2) goto L_0x000b;
    L_0x0349:
        r0 = com.tencent.mm.plugin.messenger.foundation.a.h.class;
        r0 = com.tencent.mm.kernel.h.h(r0);
        r0 = (com.tencent.mm.plugin.messenger.foundation.a.h) r0;
        r0 = r0.wW();
        r1 = r1.field_username;
        r0.Rs(r1);
        goto L_0x000b;
    L_0x035c:
        r2 = r1;
        r1 = r0;
        goto L_0x0085;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.messenger.foundation.a.a(com.tencent.mm.protocal.c.ame, java.lang.String, byte[], boolean, boolean):void");
    }
}
