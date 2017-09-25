package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Looper;
import com.tencent.mm.bj.g;
import com.tencent.mm.e.b.aj;
import com.tencent.mm.plugin.messenger.foundation.a.a.c.c;
import com.tencent.mm.plugin.messenger.foundation.a.d;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.as.b;
import com.tencent.mm.u.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public final class af extends m implements com.tencent.mm.plugin.messenger.foundation.a.a.c.a, as {
    public static final String[] gUx = new String[]{i.a(com.tencent.mm.k.a.gTP, "rconversation"), i.a(com.tencent.mm.k.a.gTP, "rbottleconversation"), "CREATE TABLE IF NOT EXISTS conversation ( unReadCount INTEGER, status INT, isSend INT, createTime LONG, username VARCHAR(40), content TEXT, reserved TEXT );", "CREATE TABLE IF NOT EXISTS bottleconversation ( unReadCount INTEGER, status INT, isSend INT, createTime LONG, username VARCHAR(40), content TEXT, reserved TEXT );", "DROP INDEX IF EXISTS rconversation_unreadcount_index ", "DROP INDEX IF EXISTS multi_index ", "CREATE INDEX IF NOT EXISTS rconversation_multi_index ON  rconversation ( unReadCount,parentRef )", "CREATE INDEX IF NOT EXISTS rbottleconversation_unreadcount_index ON  rbottleconversation ( unReadCount )"};
    private final e gUz;
    private b uIV;
    private d uIW;
    private a uIX = new a();
    private k<com.tencent.mm.storage.as.a, ae> uIY = new k<com.tencent.mm.storage.as.a, ae>(this) {
        final /* synthetic */ af uJa;

        {
            this.uJa = r1;
        }

        protected final /* synthetic */ void o(Object obj, Object obj2) {
            ((com.tencent.mm.storage.as.a) obj).a((ae) obj2, this.uJa);
        }
    };
    private k<com.tencent.mm.storage.as.a, ae> uIZ = new k<com.tencent.mm.storage.as.a, ae>(this) {
        final /* synthetic */ af uJa;

        {
            this.uJa = r1;
        }

        protected final /* synthetic */ void o(Object obj, Object obj2) {
            ((com.tencent.mm.storage.as.a) obj).a((ae) obj2, this.uJa);
        }
    };

    private static class a extends com.tencent.mm.bn.a<com.tencent.mm.plugin.messenger.foundation.a.e> implements com.tencent.mm.plugin.messenger.foundation.a.e {
        public final void a(au auVar, ae aeVar, boolean z, c cVar) {
            final au auVar2 = auVar;
            final ae aeVar2 = aeVar;
            final boolean z2 = z;
            final c cVar2 = cVar;
            a(new com.tencent.mm.bn.a.a<com.tencent.mm.plugin.messenger.foundation.a.e>(this) {
                final /* synthetic */ a uJf;

                public final /* synthetic */ void ao(Object obj) {
                    ((com.tencent.mm.plugin.messenger.foundation.a.e) obj).a(auVar2, aeVar2, z2, cVar2);
                }
            });
        }

        public final void b(au auVar, ae aeVar, boolean z, c cVar) {
            final au auVar2 = auVar;
            final ae aeVar2 = aeVar;
            final boolean z2 = z;
            final c cVar2 = cVar;
            a(new com.tencent.mm.bn.a.a<com.tencent.mm.plugin.messenger.foundation.a.e>(this) {
                final /* synthetic */ a uJf;

                public final /* synthetic */ void ao(Object obj) {
                    ((com.tencent.mm.plugin.messenger.foundation.a.e) obj).b(auVar2, aeVar2, z2, cVar2);
                }
            });
        }
    }

    public af(e eVar) {
        Object obj;
        Assert.assertTrue(eVar instanceof g);
        Cursor a = eVar.a("PRAGMA table_info( rconversation)", null, 2);
        int columnIndex = a.getColumnIndex("name");
        while (a.moveToNext()) {
            if (columnIndex >= 0) {
                if ("flag".equalsIgnoreCase(a.getString(columnIndex))) {
                    obj = 1;
                    break;
                }
            }
        }
        obj = null;
        a.close();
        List<String> a2 = i.a(com.tencent.mm.k.a.gTP, "rconversation", eVar);
        a2.addAll(i.a(com.tencent.mm.k.a.gTP, "rbottleconversation", eVar));
        for (String eE : a2) {
            eVar.eE("rconversation", eE);
        }
        if (obj == null) {
            eVar.eE("rconversation", "update rconversation set flag = conversationTime");
        }
        this.gUz = eVar;
    }

    private static String Rk(String str) {
        w.v("MicroMsg.ConversationStorage", "talker :" + str);
        if (x.eO(str)) {
            return "rbottleconversation";
        }
        return "rconversation";
    }

    public final void a(b bVar) {
        this.uIV = bVar;
    }

    public final b oG() {
        return this.uIV;
    }

    public final void a(d dVar) {
        this.uIW = dVar;
    }

    public final com.tencent.mm.vending.b.b a(com.tencent.mm.plugin.messenger.foundation.a.e eVar) {
        return this.uIX.bI(eVar);
    }

    public final void a(com.tencent.mm.storage.as.a aVar, Looper looper) {
        this.uIZ.a(aVar, looper);
    }

    public final void a(com.tencent.mm.storage.as.a aVar) {
        this.uIZ.remove(aVar);
    }

    public final void b(com.tencent.mm.storage.as.a aVar) {
        this.uIY.a(aVar, null);
    }

    public final void c(com.tencent.mm.storage.as.a aVar) {
        this.uIY.remove(aVar);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.tencent.mm.plugin.messenger.foundation.a.a.c r18, com.tencent.mm.plugin.messenger.foundation.a.a.c.c r19) {
        /*
        r17 = this;
        if (r19 != 0) goto L_0x000c;
    L_0x0002:
        r2 = "MicroMsg.ConversationStorage";
        r3 = "null notifyInfo";
        com.tencent.mm.sdk.platformtools.w.f(r2, r3);
    L_0x000b:
        return;
    L_0x000c:
        r0 = r19;
        r5 = r0.fJL;
        r4 = 0;
        r0 = r17;
        r2 = r0.Rm(r5);
        r0 = r18;
        r3 = r0.Ai(r5);
        if (r2 != 0) goto L_0x04d6;
    L_0x001f:
        r2 = new com.tencent.mm.storage.ae;
        r2.<init>(r5);
        r4 = com.tencent.mm.storage.x.eO(r5);
        if (r4 == 0) goto L_0x002e;
    L_0x002a:
        r4 = 1;
        r2.du(r4);
    L_0x002e:
        r4 = 1;
        r8 = r2;
        r9 = r4;
    L_0x0031:
        r0 = r17;
        r2 = r0.uIX;
        r0 = r19;
        r2.a(r3, r8, r9, r0);
        r2 = "MicroMsg.ConversationStorage";
        r4 = "dkevent user:%s func:%s cnt:%d ";
        r5 = 3;
        r5 = new java.lang.Object[r5];
        r6 = 0;
        r0 = r19;
        r7 = r0.fJL;
        r5[r6] = r7;
        r6 = 1;
        r0 = r19;
        r7 = r0.nyO;
        r5[r6] = r7;
        r6 = 2;
        r0 = r19;
        r7 = r0.nyQ;
        r7 = java.lang.Integer.valueOf(r7);
        r5[r6] = r7;
        com.tencent.mm.sdk.platformtools.w.i(r2, r4, r5);
        if (r3 == 0) goto L_0x016b;
    L_0x0061:
        r4 = r3.field_msgId;
        r6 = 0;
        r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r2 == 0) goto L_0x016b;
    L_0x0069:
        r0 = r19;
        r2 = r0.nyQ;
        r4 = 1;
        if (r2 != r4) goto L_0x00ac;
    L_0x0070:
        r0 = r19;
        r2 = r0.nyP;
        r4 = 0;
        r2 = r2.get(r4);
        r2 = (com.tencent.mm.storage.au) r2;
        r4 = r2.field_msgId;
        r6 = r3.field_msgId;
        r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r2 == 0) goto L_0x00ac;
    L_0x0083:
        r4 = "MicroMsg.ConversationStorage";
        r5 = "Warning ! getLastMsg may wrong , lastid:%d  insertlist:%d";
        r2 = 2;
        r6 = new java.lang.Object[r2];
        r2 = 0;
        r10 = r3.field_msgId;
        r7 = java.lang.Long.valueOf(r10);
        r6[r2] = r7;
        r7 = 1;
        r0 = r19;
        r2 = r0.nyP;
        r10 = 0;
        r2 = r2.get(r10);
        r2 = (com.tencent.mm.storage.au) r2;
        r10 = r2.field_msgId;
        r2 = java.lang.Long.valueOf(r10);
        r6[r7] = r2;
        com.tencent.mm.sdk.platformtools.w.w(r4, r5, r6);
    L_0x00ac:
        r2 = r3.field_flag;
        r4 = r8.field_lastSeq;
        r6 = r3.field_msgSeq;
        r10 = r8.field_UnDeliverCount;
        r10 = (long) r10;
        r12 = "MicroMsg.ConversationStorage";
        r13 = "summerbadcr check last message flag[%d], newseq[%d] oldseq[%d], undeliverCount[%d]";
        r14 = 4;
        r14 = new java.lang.Object[r14];
        r15 = 0;
        r16 = java.lang.Integer.valueOf(r2);
        r14[r15] = r16;
        r15 = 1;
        r16 = java.lang.Long.valueOf(r6);
        r14[r15] = r16;
        r15 = 2;
        r16 = java.lang.Long.valueOf(r4);
        r14[r15] = r16;
        r15 = 3;
        r16 = java.lang.Long.valueOf(r10);
        r14[r15] = r16;
        com.tencent.mm.sdk.platformtools.w.i(r12, r13, r14);
        r0 = r19;
        r12 = r0.nyO;
        r13 = "insert";
        r12 = r12.equals(r13);
        if (r12 == 0) goto L_0x00f0;
    L_0x00ea:
        r0 = r19;
        r12 = r0.nyQ;
        if (r12 > 0) goto L_0x0106;
    L_0x00f0:
        r0 = r19;
        r12 = r0.nyO;
        r13 = "update";
        r12 = r12.equals(r13);
        if (r12 == 0) goto L_0x01e2;
    L_0x00fd:
        r12 = r8.field_unReadCount;
        r0 = r19;
        r13 = r0.nyQ;
        r12 = r12 + r13;
        if (r12 < 0) goto L_0x01e2;
    L_0x0106:
        r12 = r8.field_unReadCount;
        r0 = r19;
        r13 = r0.nyQ;
        r12 = r12 + r13;
        r8.dt(r12);
        r12 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1));
        if (r12 <= 0) goto L_0x0159;
    L_0x0114:
        r12 = "MicroMsg.ConversationStorage";
        r13 = "summerbadcr insert or update reset lastseq[%d]";
        r14 = 1;
        r14 = new java.lang.Object[r14];
        r15 = 0;
        r16 = java.lang.Long.valueOf(r6);
        r14[r15] = r16;
        com.tencent.mm.sdk.platformtools.w.i(r12, r13, r14);
        r12 = 0;
        r12 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1));
        if (r12 <= 0) goto L_0x01dd;
    L_0x012d:
        r12 = r2 & 2;
        if (r12 != 0) goto L_0x01dd;
    L_0x0131:
        r12 = "MicroMsg.ConversationStorage";
        r13 = "summerbadcr insert or update reset lastseq but undeliver flag not match[%d, %d, %d, %d]";
        r14 = 4;
        r14 = new java.lang.Object[r14];
        r15 = 0;
        r6 = java.lang.Long.valueOf(r6);
        r14[r15] = r6;
        r6 = 1;
        r4 = java.lang.Long.valueOf(r4);
        r14[r6] = r4;
        r4 = 2;
        r5 = java.lang.Long.valueOf(r10);
        r14[r4] = r5;
        r4 = 3;
        r2 = java.lang.Integer.valueOf(r2);
        r14[r4] = r2;
        com.tencent.mm.sdk.platformtools.w.i(r12, r13, r14);
    L_0x0159:
        r2 = r3.bMm();
        if (r2 == 0) goto L_0x016b;
    L_0x015f:
        r2 = r3.field_isSend;
        r4 = 1;
        if (r2 != r4) goto L_0x016b;
    L_0x0164:
        r4 = r3.field_createTime;
        r8.field_sightTime = r4;
        r2 = 1;
        r8.glq = r2;
    L_0x016b:
        r0 = r19;
        r2 = r0.nyO;
        r4 = "insert";
        r2 = r2.equals(r4);
        if (r2 == 0) goto L_0x0274;
    L_0x0178:
        r0 = r19;
        r2 = r0.nyP;
        r2 = r2.size();
        if (r2 <= 0) goto L_0x0274;
    L_0x0182:
        r0 = r19;
        r2 = r0.fJL;
        r2 = com.tencent.mm.u.o.dH(r2);
        if (r2 == 0) goto L_0x0274;
    L_0x018c:
        r5 = com.tencent.mm.u.m.xL();
        r0 = r19;
        r2 = r0.nyP;
        r6 = r2.iterator();
    L_0x0198:
        r2 = r6.hasNext();
        if (r2 == 0) goto L_0x0274;
    L_0x019e:
        r2 = r6.next();
        r2 = (com.tencent.mm.storage.au) r2;
        r4 = r2.field_isSend;
        r7 = 1;
        if (r4 == r7) goto L_0x01c6;
    L_0x01a9:
        r4 = r2.bMk();
        if (r4 != 0) goto L_0x01b9;
    L_0x01af:
        r4 = r2.field_type;
        r7 = 503316529; // 0x1e000031 float:6.776303E-21 double:2.48671406E-315;
        if (r4 != r7) goto L_0x0253;
    L_0x01b6:
        r4 = 1;
    L_0x01b7:
        if (r4 == 0) goto L_0x01c6;
    L_0x01b9:
        r4 = r2.RE(r5);
        if (r4 == 0) goto L_0x0256;
    L_0x01bf:
        r4 = r8.field_atCount;
        r4 = r4 + 1;
        r8.dz(r4);
    L_0x01c6:
        r2 = r2.field_content;
        r4 = "sysmsg";
        r2 = com.tencent.mm.b.f.q(r2, r4);
        r4 = com.tencent.mm.storage.au.af(r2);
        if (r4 == 0) goto L_0x0265;
    L_0x01d5:
        r2 = r8.field_UnReadInvite;
        r2 = r2 + 1;
        r8.dC(r2);
        goto L_0x0198;
    L_0x01dd:
        r8.u(r6);
        goto L_0x0159;
    L_0x01e2:
        r0 = r19;
        r2 = r0.nyS;
        if (r2 <= 0) goto L_0x0159;
    L_0x01e8:
        r2 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1));
        if (r2 >= 0) goto L_0x0159;
    L_0x01ec:
        r2 = com.tencent.mm.plugin.messenger.foundation.a.h.class;
        r2 = com.tencent.mm.kernel.h.h(r2);
        r2 = (com.tencent.mm.plugin.messenger.foundation.a.h) r2;
        r2 = r2.aJX();
        r10 = r8.field_username;
        r2 = r2.y(r10, r4);
        r10 = r2.field_msgId;
        r12 = 0;
        r2 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1));
        if (r2 != 0) goto L_0x0159;
    L_0x0206:
        r2 = com.tencent.mm.plugin.messenger.foundation.a.h.class;
        r2 = com.tencent.mm.kernel.h.h(r2);
        r2 = (com.tencent.mm.plugin.messenger.foundation.a.h) r2;
        r2 = r2.aJX();
        r10 = r8.field_username;
        r10 = r2.AE(r10);
        r2 = "MicroMsg.ConversationStorage";
        r12 = "summerbadcr delete reset lastseq[%d, %d], lastMsgSeq[%d]";
        r13 = 3;
        r13 = new java.lang.Object[r13];
        r14 = 0;
        r15 = java.lang.Long.valueOf(r4);
        r13[r14] = r15;
        r14 = 1;
        r15 = java.lang.Long.valueOf(r6);
        r13[r14] = r15;
        r14 = 2;
        r15 = java.lang.Long.valueOf(r10);
        r13[r14] = r15;
        com.tencent.mm.sdk.platformtools.w.i(r2, r12, r13);
        r8.u(r6);
        r2 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1));
        if (r2 <= 0) goto L_0x0159;
    L_0x0240:
        r2 = com.tencent.mm.plugin.messenger.foundation.a.h.class;
        r2 = com.tencent.mm.kernel.h.h(r2);
        r2 = (com.tencent.mm.plugin.messenger.foundation.a.h) r2;
        r2 = r2.xC();
        r4 = r8.field_username;
        r2.v(r4, r10);
        goto L_0x0159;
    L_0x0253:
        r4 = 0;
        goto L_0x01b7;
    L_0x0256:
        r4 = r2.bMB();
        if (r4 == 0) goto L_0x01c6;
    L_0x025c:
        r4 = r8.field_atCount;
        r4 = r4 + 4096;
        r8.dz(r4);
        goto L_0x01c6;
    L_0x0265:
        r2 = com.tencent.mm.storage.au.ag(r2);
        if (r2 == 0) goto L_0x0198;
    L_0x026b:
        r2 = r8.field_UnReadInvite;
        r2 = r2 + 4096;
        r8.dC(r2);
        goto L_0x0198;
    L_0x0274:
        r4 = 0;
        r2 = 0;
        r0 = r19;
        r12 = r0.fJL;
        if (r19 == 0) goto L_0x02aa;
    L_0x027c:
        r0 = r19;
        r5 = r0.nyO;
        r6 = "delete";
        r5 = r5.equals(r6);
        if (r5 == 0) goto L_0x02aa;
    L_0x0289:
        r0 = r19;
        r5 = r0.nyS;
        if (r5 <= 0) goto L_0x0293;
    L_0x028f:
        r0 = r19;
        r2 = r0.nyS;
    L_0x0293:
        r5 = "MicroMsg.ConversationStorage";
        r6 = "notify delete count %d ";
        r7 = 1;
        r7 = new java.lang.Object[r7];
        r10 = 0;
        r0 = r19;
        r11 = r0.nyS;
        r11 = java.lang.Integer.valueOf(r11);
        r7[r10] = r11;
        com.tencent.mm.sdk.platformtools.w.i(r5, r6, r7);
    L_0x02aa:
        r11 = r2;
        if (r19 == 0) goto L_0x04d3;
    L_0x02ad:
        r0 = r19;
        r2 = r0.nyO;
        r5 = "insert";
        r2 = r2.equals(r5);
        if (r2 == 0) goto L_0x04d3;
    L_0x02ba:
        r0 = r19;
        r2 = r0.nyR;
        if (r2 <= 0) goto L_0x04d0;
    L_0x02c0:
        r0 = r19;
        r2 = r0.nyR;
    L_0x02c4:
        r4 = "MicroMsg.ConversationStorage";
        r5 = "notify insert all count %d ";
        r6 = 1;
        r6 = new java.lang.Object[r6];
        r7 = 0;
        r0 = r19;
        r10 = r0.nyR;
        r10 = java.lang.Integer.valueOf(r10);
        r6[r7] = r10;
        com.tencent.mm.sdk.platformtools.w.i(r4, r5, r6);
        r10 = r2;
    L_0x02dc:
        r2 = "MicroMsg.ConversationStorage";
        r6 = "summerbadcr updateConversation talker[%s] msgseq[%d],newConv[%b],newMsgInsertCount[%d], deleteCount[%d], tid[%d]";
        r4 = 6;
        r7 = new java.lang.Object[r4];
        r4 = 0;
        r7[r4] = r12;
        r13 = 1;
        if (r3 == 0) goto L_0x0335;
    L_0x02eb:
        r4 = r3.field_msgSeq;
    L_0x02ed:
        r4 = java.lang.Long.valueOf(r4);
        r7[r13] = r4;
        r4 = 2;
        r5 = java.lang.Boolean.valueOf(r9);
        r7[r4] = r5;
        r4 = 3;
        r5 = java.lang.Integer.valueOf(r10);
        r7[r4] = r5;
        r4 = 4;
        r5 = java.lang.Integer.valueOf(r11);
        r7[r4] = r5;
        r4 = 5;
        r5 = java.lang.Thread.currentThread();
        r14 = r5.getId();
        r5 = java.lang.Long.valueOf(r14);
        r7[r4] = r5;
        com.tencent.mm.sdk.platformtools.w.i(r2, r6, r7);
        r0 = r17;
        r2 = r0.uIY;
        r2.by(r8);
        r0 = r17;
        r2 = r0.uIY;
        r2.doNotify();
        if (r12 != 0) goto L_0x0338;
    L_0x032a:
        r2 = "MicroMsg.ConversationStorage";
        r3 = "talker == null";
        com.tencent.mm.sdk.platformtools.w.e(r2, r3);
        goto L_0x000b;
    L_0x0335:
        r4 = -1;
        goto L_0x02ed;
    L_0x0338:
        r2 = r8.field_username;
        r2 = r12.equals(r2);
        if (r2 != 0) goto L_0x034b;
    L_0x0340:
        r2 = "MicroMsg.ConversationStorage";
        r3 = "process message for conversation failed: inconsist username";
        com.tencent.mm.sdk.platformtools.w.e(r2, r3);
        goto L_0x000b;
    L_0x034b:
        if (r3 == 0) goto L_0x0477;
    L_0x034d:
        r4 = r3.field_msgId;
        r6 = 0;
        r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r2 == 0) goto L_0x0477;
    L_0x0355:
        r2 = "MicroMsg.ConversationStorage";
        r4 = new java.lang.StringBuilder;
        r5 = "onNotifyChange   msgId:";
        r4.<init>(r5);
        r6 = r3.field_msgId;
        r4 = r4.append(r6);
        r4 = r4.toString();
        com.tencent.mm.sdk.platformtools.w.v(r2, r4);
        r8.W(r3);
        r0 = r17;
        r2 = r0.uIV;
        if (r2 == 0) goto L_0x042c;
    L_0x0376:
        r4 = new com.tencent.mm.pointers.PString;
        r4.<init>();
        r5 = new com.tencent.mm.pointers.PString;
        r5.<init>();
        r6 = new com.tencent.mm.pointers.PInt;
        r6.<init>();
        r0 = r17;
        r2 = r0.uIV;
        r7 = 2097152; // 0x200000 float:2.938736E-39 double:1.0361308E-317;
        r7 = r8.eC(r7);
        r2.a(r3, r4, r5, r6, r7);
        r2 = "MicroMsg.ConversationStorage";
        r7 = "oreh onNotifyChange genDigest: pDigestUser.value=%s";
        r13 = 1;
        r13 = new java.lang.Object[r13];
        r14 = 0;
        r15 = r5.value;
        r13[r14] = r15;
        com.tencent.mm.sdk.platformtools.w.d(r2, r7, r13);
        r2 = r4.value;
        r8.cu(r2);
        r2 = r5.value;
        r8.cv(r2);
        r2 = r6.value;
        r8.dx(r2);
    L_0x03b2:
        r2 = r3.field_type;
        r2 = java.lang.Integer.toString(r2);
        r8.ct(r2);
        r0 = r17;
        r2 = r0.uIW;
        if (r2 == 0) goto L_0x03c8;
    L_0x03c1:
        r0 = r17;
        r2 = r0.uIW;
        r2.a(r3, r8);
    L_0x03c8:
        r2 = 1;
        r4 = r3.field_createTime;
        r4 = com.tencent.mm.plugin.messenger.foundation.a.a.a.a(r8, r2, r4);
        r8.t(r4);
        if (r9 == 0) goto L_0x046b;
    L_0x03d4:
        r2 = com.tencent.mm.plugin.messenger.foundation.a.h.class;
        r2 = com.tencent.mm.kernel.h.h(r2);
        r2 = (com.tencent.mm.plugin.messenger.foundation.a.h) r2;
        r2 = r2.wR();
        r2 = r2.Rc(r12);
        if (r2 == 0) goto L_0x03fe;
    L_0x03e6:
        r4 = r2.field_username;
        r4 = com.tencent.mm.sdk.platformtools.bg.mA(r4);
        if (r4 != 0) goto L_0x03fe;
    L_0x03ee:
        r2 = r2.tG();
        if (r2 == 0) goto L_0x03fe;
    L_0x03f4:
        r2 = 2;
        r4 = 0;
        r4 = com.tencent.mm.plugin.messenger.foundation.a.a.a.a(r8, r2, r4);
        r8.t(r4);
    L_0x03fe:
        r0 = r17;
        r0.a(r8, r11, r10);
        r2 = r3.bMm();
        if (r2 == 0) goto L_0x0463;
    L_0x0409:
        r4 = r3.field_createTime;
        r8.s(r4);
    L_0x040e:
        r0 = r17;
        r0.d(r8);
    L_0x0413:
        r0 = r17;
        r2 = r0.uIZ;
        r2.by(r8);
        r0 = r17;
        r2 = r0.uIZ;
        r2.doNotify();
        r0 = r17;
        r2 = r0.uIX;
        r0 = r19;
        r2.b(r3, r8, r9, r0);
        goto L_0x000b;
    L_0x042c:
        r2 = r3.field_type;
        r4 = r8.field_content;
        r0 = r17;
        r2 = r0.aA(r2, r4);
        r4 = r8.field_digest;
        r4 = com.tencent.mm.sdk.platformtools.bg.mz(r4);
        r5 = com.tencent.mm.sdk.platformtools.bg.mA(r2);
        if (r5 == 0) goto L_0x044e;
    L_0x0442:
        r2 = "";
    L_0x0445:
        r2 = r4.concat(r2);
        r8.cu(r2);
        goto L_0x03b2;
    L_0x044e:
        r5 = new java.lang.StringBuilder;
        r6 = " ";
        r5.<init>(r6);
        r2 = com.tencent.mm.sdk.platformtools.bg.mz(r2);
        r2 = r5.append(r2);
        r2 = r2.toString();
        goto L_0x0445;
    L_0x0463:
        r4 = com.tencent.mm.sdk.platformtools.bg.Nz();
        r8.s(r4);
        goto L_0x040e;
    L_0x046b:
        r0 = r17;
        r0.a(r8, r11, r10);
        r2 = 1;
        r0 = r17;
        r0.a(r8, r12, r2);
        goto L_0x0413;
    L_0x0477:
        r2 = "MicroMsg.ConversationStorage";
        r4 = new java.lang.StringBuilder;
        r5 = "update null conversation with talker ";
        r4.<init>(r5);
        r4 = r4.append(r12);
        r4 = r4.toString();
        com.tencent.mm.sdk.platformtools.w.i(r2, r4);
        if (r9 != 0) goto L_0x049f;
    L_0x048f:
        r8.bLB();
        r0 = r17;
        r0.a(r8, r11, r10);
        r2 = 1;
        r0 = r17;
        r0.a(r8, r12, r2);
        goto L_0x0413;
    L_0x049f:
        r2 = com.tencent.mm.plugin.messenger.foundation.a.h.class;
        r2 = com.tencent.mm.kernel.h.h(r2);
        r2 = (com.tencent.mm.plugin.messenger.foundation.a.h) r2;
        r2 = r2.aJX();
        r2 = r2.Ax(r12);
        if (r2 <= 0) goto L_0x0413;
    L_0x04b1:
        r2 = r3.bMm();
        if (r2 == 0) goto L_0x04c8;
    L_0x04b7:
        r4 = r3.field_createTime;
        r8.s(r4);
    L_0x04bc:
        r0 = r17;
        r0.a(r8, r11, r10);
        r0 = r17;
        r0.d(r8);
        goto L_0x0413;
    L_0x04c8:
        r4 = com.tencent.mm.sdk.platformtools.bg.Nz();
        r8.s(r4);
        goto L_0x04bc;
    L_0x04d0:
        r2 = r4;
        goto L_0x02c4;
    L_0x04d3:
        r10 = r4;
        goto L_0x02dc;
    L_0x04d6:
        r8 = r2;
        r9 = r4;
        goto L_0x0031;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.af.a(com.tencent.mm.plugin.messenger.foundation.a.a.c, com.tencent.mm.plugin.messenger.foundation.a.a.c$c):void");
    }

    private static long c(ae aeVar) {
        if (aeVar != null) {
            return com.tencent.mm.plugin.messenger.foundation.a.a.a.a(aeVar, aeVar.field_conversationTime);
        }
        return bg.Nz() & 72057594037927935L;
    }

    public final void Rl(String str) {
        w.w("MicroMsg.ConversationStorage", "delChatContact username:%s  stack:%s", str, ah.bJo());
        if (this.gUz.delete(Rk(str), "username=?", new String[]{str}) != 0) {
            b(5, this, str);
        }
    }

    public final boolean bLC() {
        boolean z = this.gUz.eE("rconversation", "delete from rconversation") || this.gUz.eE("rconversation", "delete from rbottleconversation");
        if (z) {
            b(5, this, "");
        }
        return z;
    }

    public final boolean bLD() {
        w.w("MicroMsg.ConversationStorage", "deleteBottleConversation stack:%s", ah.bJo());
        boolean eE = this.gUz.eE("rconversation", "delete from rbottleconversation");
        if (eE) {
            b(5, this, "");
        }
        return eE;
    }

    public final boolean Ap(String str) {
        w.w("MicroMsg.ConversationStorage", "deleteMessageEndByName nameTag:%s  stack:%s", str, ah.bJo());
        boolean eE = this.gUz.eE("rconversation", "delete from " + Rk(str) + " where username like '%" + str + "'");
        if (eE) {
            b(5, this, str);
        }
        return eE;
    }

    public final ae Rm(String str) {
        Cursor a = this.gUz.a(Rk(str), null, "username=?", new String[]{str}, null, null, null, 2);
        if (a.moveToFirst()) {
            ae aeVar = new ae();
            aeVar.b(a);
            a.close();
            return aeVar;
        }
        w.w("MicroMsg.ConversationStorage", "get null with username:" + str);
        a.close();
        return null;
    }

    public final void X(au auVar) {
        String str = auVar.field_talker;
        boolean z = false;
        ae Rm = Rm(str);
        if (Rm == null || Rm.field_conversationTime <= auVar.field_createTime || Rm.field_conversationTime == Long.MAX_VALUE) {
            if (Rm == null) {
                Rm = new ae(str);
                z = true;
            }
            Rm.dw(auVar.field_isSend);
            Rm.dt(Rm.field_unReadCount);
            Rm.W(auVar);
            Rm.ct(Integer.toString(auVar.field_type));
            Rm.t((Rm.field_flag & 4611686018427387904L) | (auVar.field_createTime & 72057594037927935L));
            if (z) {
                d(Rm);
                return;
            } else {
                a(Rm, str, true);
                return;
            }
        }
        w.i("MicroMsg.ConversationStorage", "updateConvFromLastMsg ignore(maybe the system time is bigger than normal)");
    }

    public final HashMap<String, Long> bLE() {
        long currentTimeMillis = System.currentTimeMillis();
        HashMap<String, Long> hashMap = new HashMap();
        Cursor a = this.gUz.a("rconversation", new String[]{"username", "conversationTime"}, null, null, null, null, null, 2);
        if (a.moveToFirst()) {
            while (true) {
                int i = a == null ? 0 : (a.isClosed() || a.isBeforeFirst() || a.isAfterLast()) ? 0 : 1;
                if (i != 0) {
                    hashMap.put(a.getString(0), Long.valueOf(a.getLong(1)));
                    a.moveToNext();
                } else {
                    a.close();
                    w.d("MicroMsg.ConversationStorage", "kevin getALLTimeIndex:" + (System.currentTimeMillis() - currentTimeMillis));
                    return hashMap;
                }
            }
        }
        a.close();
        return hashMap;
    }

    public final long d(ae aeVar) {
        String mz = bg.mz(aeVar.field_username);
        if (mz.length() <= 0) {
            w.e("MicroMsg.ConversationStorage", "insert conversation failed, username empty");
            return -1;
        }
        aeVar.t(c(aeVar));
        e(aeVar);
        long insert = this.gUz.insert(Rk(mz), null, aeVar.pv());
        if (insert != -1) {
            b(2, this, aeVar.field_username);
        } else {
            w.e("MicroMsg.ConversationStorage", "insert failed return -1, table:%s", Rk(mz));
        }
        return insert;
    }

    public final void a(ae aeVar, int i, int i2) {
        if (!((h) com.tencent.mm.kernel.h.h(h.class)).aJX().Ay(aeVar.field_username)) {
            return;
        }
        if (bg.mz(aeVar.field_username).length() <= 0) {
            w.e("MicroMsg.ConversationStorage", "countMsg conversation failed, username empty");
            return;
        }
        if (aeVar.field_msgCount == 0) {
            aeVar.ds(((h) com.tencent.mm.kernel.h.h(h.class)).aJX().Az(aeVar.field_username));
            w.i("MicroMsg.ConversationStorage", "getMsgCount from message table");
        } else if (i > 0) {
            aeVar.ds(aeVar.field_msgCount - i);
            if (aeVar.field_msgCount < 0) {
                w.e("MicroMsg.ConversationStorage", "msg < 0 ,some path must be ignore!");
                aeVar.ds(0);
            }
        } else if (i2 > 0) {
            aeVar.ds(aeVar.field_msgCount + i2);
        }
        w.i("MicroMsg.ConversationStorage", "countMsg %d talker :%s deleteCount:%d insertCount:%d", Integer.valueOf(aeVar.field_msgCount), aeVar.field_username, Integer.valueOf(i), Integer.valueOf(i2));
    }

    public final void bLF() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("msgCount", Integer.valueOf(0));
        this.gUz.update("rconversation", contentValues, null, null);
    }

    public final void Rn(String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("msgCount", Integer.valueOf(0));
        this.gUz.update("rconversation", contentValues, "username=?", new String[]{str});
    }

    public final boolean Ro(String str) {
        if (str == null || str.length() <= 0) {
            w.e("MicroMsg.ConversationStorage", "update conversation failed");
            return false;
        }
        aj Rm = Rm(str);
        if (Rm == null) {
            return true;
        }
        if (Rm.field_unReadCount == 0 && Rm.field_unReadMuteCount == 0 && str.equals(Rm.field_username)) {
            b(str, 1048576, false, Rm.field_attrflag);
            ContentValues contentValues = new ContentValues();
            contentValues.put("UnReadInvite", Integer.valueOf(0));
            if (this.gUz.update(Rk(str), contentValues, "username= ?", new String[]{bg.my(str)}) <= 0) {
                return true;
            }
            b(3, this, str);
            return true;
        }
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put("unReadCount", Integer.valueOf(0));
        contentValues2.put("unReadMuteCount", Integer.valueOf(0));
        contentValues2.put("UnReadInvite", Integer.valueOf(0));
        contentValues2.put("atCount", Integer.valueOf(0));
        contentValues2.put("attrflag", Integer.valueOf(Rm.field_attrflag & -1048577));
        int update = this.gUz.update(Rk(str), contentValues2, "username= ?", new String[]{bg.my(str)});
        if (update > 0) {
            b(3, this, str);
        }
        if (update <= 0) {
            return false;
        }
        return true;
    }

    public final boolean Rp(String str) {
        if (str == null || str.length() <= 0) {
            w.e("MicroMsg.ConversationStorage", "update conversation failed");
            return false;
        }
        aj Rm = Rm(str);
        if (Rm == null || (Rm.field_unReadCount > 0 && str.equals(Rm.field_username))) {
            return true;
        }
        boolean eE = this.gUz.eE("rconversation", "update " + Rk(str) + " set unReadCount = 1, atCount" + " = 0, attrflag = " + (Rm.field_attrflag | 1048576) + " where username = \"" + bg.my(str) + "\"");
        if (!eE) {
            return eE;
        }
        b(3, this, str);
        return eE;
    }

    public final boolean b(String str, int i, boolean z, int i2) {
        if (bg.mA(str)) {
            return false;
        }
        if (Rm(str) == null) {
            return true;
        }
        int i3;
        if (z) {
            i3 = i2 | i;
        } else {
            i3 = (i ^ -1) & i2;
        }
        if (i3 == i2) {
            return false;
        }
        boolean eE = this.gUz.eE("rconversation", "update " + Rk(str) + " set attrflag = " + i3 + " where username = \"" + bg.my(str) + "\"");
        if (!eE) {
            return eE;
        }
        b(3, this, str);
        return eE;
    }

    public final int a(ae aeVar, String str) {
        return a(aeVar, str, true);
    }

    public final int a(ae aeVar, String str, boolean z) {
        if (str == null || str.length() <= 0) {
            w.e("MicroMsg.ConversationStorage", "update conversation failed");
            return 0;
        }
        if (z) {
            aeVar.t(c(aeVar));
        }
        e(aeVar);
        int update = this.gUz.update(Rk(str), aeVar.pv(), "username=?", new String[]{str});
        if (update != 0) {
            b(3, this, str);
            return update;
        }
        w.e("MicroMsg.ConversationStorage", "update failed return 0,  table:%s", Rk(str));
        return update;
    }

    private static void e(ae aeVar) {
        if (aeVar != null && aeVar.field_unReadCount > 0) {
            w.d("MicroMsg.ConversationStorage", "jacks check attrFlag & cancel mark");
            if ((aeVar.field_attrflag & 1048576) != 0) {
                aeVar.dt(aeVar.field_unReadCount - 1);
                aeVar.dy(aeVar.field_attrflag & -1048577);
            }
        }
    }

    private long bLG() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = 0;
        Cursor a = this.gUz.a("select max(conversationTime) as conversationTime from rconversation", null, 2);
        while (a.moveToNext()) {
            j = a.getLong(0);
        }
        a.close();
        w.d("MicroMsg.ConversationStorage", "latestConversationTime = %s, cost = %d", Long.valueOf(j), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        return j;
    }

    public final boolean Rq(String str) {
        boolean z = false;
        if (str == null || str.length() <= 0) {
            w.e("MicroMsg.ConversationStorage", "setMoveUp conversation failed");
        } else {
            aj Rm = Rm(str);
            if (Rm == null) {
                w.e("MicroMsg.ConversationStorage", "setMoveUp conv == null");
            } else {
                z = this.gUz.eE("rconversation", "update " + Rk(Rm.field_username) + " set flag = " + com.tencent.mm.plugin.messenger.foundation.a.a.a.a(Rm, 1, bLG() + 1) + " where username = \"" + bg.my(Rm.field_username) + "\"");
                if (z) {
                    b(3, this, Rm.field_username);
                }
            }
        }
        return z;
    }

    public final boolean Rr(String str) {
        boolean z = false;
        if (str == null || str.length() <= 0) {
            w.e("MicroMsg.ConversationStorage", "setPlacedTop conversation failed");
        } else {
            if (Rm(str) == null) {
                ae aeVar = new ae(str);
                aeVar.s(System.currentTimeMillis());
                d(aeVar);
                w.i("MicroMsg.ConversationStorage", "setPlacedTop username = " + str);
            }
            aj Rm = Rm(str);
            if (Rm != null) {
                z = this.gUz.eE("rconversation", "update " + Rk(Rm.field_username) + " set flag = " + com.tencent.mm.plugin.messenger.foundation.a.a.a.a(Rm, 2, 0) + " where username = \"" + bg.my(Rm.field_username) + "\"");
                if (z) {
                    b(3, this, Rm.field_username);
                }
            }
        }
        return z;
    }

    public final boolean Rs(String str) {
        if (str != null && str.length() > 0) {
            return f(Rm(str));
        }
        w.e("MicroMsg.ConversationStorage", "unSetPlacedTop conversation failed");
        return false;
    }

    public final boolean f(ae aeVar) {
        if (aeVar == null) {
            w.e("MicroMsg.ConversationStorage", "unSetPlacedTop conversation null");
            return false;
        }
        boolean eE = this.gUz.eE("rconversation", "update " + Rk(aeVar.field_username) + " set flag = " + com.tencent.mm.plugin.messenger.foundation.a.a.a.a(aeVar, 3, aeVar.field_conversationTime) + " where username = \"" + bg.my(aeVar.field_username) + "\"");
        if (!eE) {
            return eE;
        }
        b(3, this, aeVar.field_username);
        return eE;
    }

    public final boolean Rt(String str) {
        if (str != null && str.length() > 0) {
            return g(Rm(str));
        }
        w.e("MicroMsg.ConversationStorage", "isPlacedTop failed");
        return false;
    }

    public final boolean g(ae aeVar) {
        if (aeVar == null) {
            w.e("MicroMsg.ConversationStorage", "isPlacedTop failed, conversation null");
            return false;
        } else if (com.tencent.mm.plugin.messenger.foundation.a.a.a.a(aeVar, 4, 0) != 0) {
            return true;
        } else {
            return false;
        }
    }

    public final Cursor c(String str, List<String> list, String str2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select * from rconversation where ");
        if (com.tencent.mm.k.a.gTS == str2) {
            stringBuilder.append(" ( parentRef is null  or ").append("parentRef = '' ) ");
        } else if ("*".equals(str2)) {
            stringBuilder.append(" 1 = 1 ");
        } else {
            stringBuilder.append("parentRef = '").append(bg.my(str2)).append("' ");
        }
        stringBuilder.append(bg.mz(str));
        if (list != null && list.size() > 0) {
            for (String append : list) {
                stringBuilder.append(" and rconversation.username").append(" != '").append(append).append("'");
            }
        }
        stringBuilder.append(" order by flag desc, conversationTime").append(" desc");
        return this.gUz.rawQuery(stringBuilder.toString(), null);
    }

    public final List<String> bLH() {
        List arrayList = new ArrayList();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select rconversation.username from rconversation").append(",rcontact where ");
        stringBuilder.append("rconversation.username = rcontact.username");
        stringBuilder.append(bg.mz(bg.mz(o.hlr)));
        stringBuilder.append(" and ( verifyFlag & 8 ) = 0");
        stringBuilder.append(" and ( rconversation.parentRef is null  or ").append("rconversation.parentRef = '' ) ");
        for (String append : o.hly) {
            stringBuilder.append(" and rconversation.username != '").append(append).append("'");
        }
        stringBuilder.append(" order by sightTime desc, flag").append(" desc, conversationTime desc");
        Cursor a = this.gUz.a(stringBuilder.toString(), null, 2);
        if (a != null) {
            if (a.moveToFirst()) {
                do {
                    arrayList.add(a.getString(0));
                } while (a.moveToNext());
            }
            a.close();
        }
        w.d("MicroMsg.ConversationStorage", "user list:%s", arrayList);
        return arrayList;
    }

    public final Cursor a(String str, List<String> list, String str2, boolean z) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select unReadCount, status, isSend, conversationTime, username, content, msgType, flag, digest, digestUser, attrflag, editingMsg, atCount, unReadMuteCount, UnReadInvite");
        stringBuilder.append(" from rconversation where ");
        if (com.tencent.mm.k.a.gTS == str2) {
            stringBuilder.append(" ( parentRef is null  or ").append("parentRef = '' ) ");
        } else if ("*".equals(str2)) {
            stringBuilder.append(" 1 = 1 ");
        } else {
            stringBuilder.append("parentRef = '").append(bg.my(str2)).append("' ");
        }
        stringBuilder.append(bg.mz(str));
        if (list != null && list.size() > 0) {
            for (String append : list) {
                stringBuilder.append(" and rconversation.username").append(" != '").append(append).append("'");
            }
        }
        stringBuilder.append(" order by flag desc");
        w.d("MicroMsg.ConversationStorage", "getNecessaryCursor sql " + stringBuilder.toString());
        return this.gUz.a(stringBuilder.toString(), null, z ? 4 : 0);
    }

    public final Cursor a(ArrayList<String> arrayList, String str, List<String> list, String str2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select unReadCount, status, isSend, conversationTime, username, content, msgType,flag, digest, digestUser, attrflag, editingMsg, atCount, unReadMuteCount, UnReadInvite");
        stringBuilder.append(" from rconversation where (");
        for (int i = 0; i < arrayList.size(); i++) {
            if (i != arrayList.size() - 1) {
                stringBuilder.append("username = '" + ((String) arrayList.get(i)) + "' OR ");
            } else {
                stringBuilder.append("username = '" + ((String) arrayList.get(i)) + "'");
            }
        }
        stringBuilder.append(") and ");
        if (com.tencent.mm.k.a.gTS == str2) {
            stringBuilder.append(" ( parentRef is null  or ").append("parentRef = '' ) ");
        } else if ("*".equals(str2)) {
            stringBuilder.append(" 1 = 1 ");
        } else {
            stringBuilder.append("parentRef = '").append(bg.my(str2)).append("' ");
        }
        stringBuilder.append(bg.mz(str));
        if (list != null && list.size() > 0) {
            for (String append : list) {
                stringBuilder.append(" and rconversation.username").append(" != '").append(append).append("'");
            }
        }
        w.d("MicroMsg.ConversationStorage", "getNecessaryCursorByNames sql " + stringBuilder.toString());
        return this.gUz.rawQuery(stringBuilder.toString(), null);
    }

    public final Cursor b(String str, List<String> list, boolean z, String str2) {
        String str3 = " ";
        String str4 = " ";
        if (str2 != null && str2.length() > 0) {
            str4 = " and rconversation.username = rcontact.username ";
        }
        String str5 = "select unReadCount, status, isSend, conversationTime, rconversation.username, content, rconversation.msgType, rconversation.flag, rconversation.digest, rconversation.digestUser, rconversation.hasTrunc, rcontact.nickname from rconversation,rcontact" + str3 + " where rconversation.username" + " = rcontact.username" + str4 + bg.mz(str);
        str4 = "";
        if (list != null && list.size() > 0) {
            str3 = str4;
            for (String str42 : list) {
                str3 = str3 + " and rconversation.username != '" + str42 + "'";
            }
            str42 = str3;
        }
        str42 = str5 + str42;
        if (z) {
            str42 = str42 + " and ( verifyFlag & 8 ) = 0";
        }
        if (str2 != null && str2.length() > 0) {
            str42 = str42 + (" and ( rconversation.username like '%" + str2 + "%' or content like '%" + str2 + "%' or rcontact.nickname" + " like '%" + str2 + "%' or rcontact.alias" + " like '%" + str2 + "%' or rcontact.pyInitial" + " like '%" + str2 + "%' or rcontact.quanPin" + " like '%" + str2 + "%' or rcontact.conRemark" + " like '%" + str2 + "%'  ) ");
        }
        if (str2 == null || str2.equals("")) {
            str42 = str42 + " order by flag desc, conversationTime desc";
        } else {
            str42 = str42 + " order by rconversation.username like \"%@chatroom\" asc";
        }
        w.d("MicroMsg.ConversationStorage", "getSearchCursor sql " + str42);
        return this.gUz.rawQuery(str42, null);
    }

    public final Cursor Ru(String str) {
        return this.gUz.rawQuery("select unReadCount, status, isSend, conversationTime, rconversation.username, content, rconversation.msgType, nickname from rconversation,rcontact where rconversation.username = rcontact.username" + bg.mz(str) + " order by flag desc, conversationTime" + " desc", null);
    }

    public final void aw(LinkedList<String> linkedList) {
        w.w("MicroMsg.ConversationStorage", "deleteConversations   stack:%s", ah.bJo());
        if (linkedList.isEmpty()) {
            w.w("MicroMsg.ConversationStorage", "deleteConversation:namelist is null");
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        String str = (String) linkedList.poll();
        stringBuilder.append("delete from rconversation where ");
        stringBuilder.append("username='").append(str).append('\'');
        while (!linkedList.isEmpty()) {
            stringBuilder.append(" or username='").append((String) linkedList.poll()).append('\'');
        }
        w.i("MicroMsg.ConversationStorage", "deleteConversations:sql is %s", stringBuilder.toString());
        this.gUz.eE("rconversation", stringBuilder.toString());
    }

    public final List<String> bLI() {
        List arrayList = new ArrayList();
        List<String> arrayList2 = new ArrayList();
        String str = "select username from rconversation";
        int i = 0;
        while (i < arrayList.size()) {
            String str2 = str + (i > 0 ? " and " : " where ") + "username != \"" + bg.my((String) arrayList.get(i)) + "\"";
            i++;
            str = str2;
        }
        Cursor rawQuery = this.gUz.rawQuery(str + " order by flag desc, conversationTime desc", null);
        i = rawQuery.getColumnIndex("username");
        while (rawQuery.moveToNext()) {
            arrayList2.add(rawQuery.getString(i));
        }
        rawQuery.close();
        return arrayList2;
    }

    public final Cursor j(List<String> list, int i) {
        String str = "select username from rconversation";
        int i2 = 0;
        while (i2 < list.size()) {
            String str2 = str + (i2 > 0 ? " and " : " where ") + "username != \"" + bg.my((String) list.get(i2)) + "\"";
            i2++;
            str = str2;
        }
        return this.gUz.rawQuery(str + " order by flag desc, conversationTime desc limit 50 offset " + i, null);
    }

    public final Cursor bLJ() {
        return this.gUz.rawQuery("select * from rbottleconversation order by flag desc, conversationTime desc", null);
    }

    public final boolean wV(String str) {
        boolean z;
        Cursor a = this.gUz.a(Rk(str), null, "username=?", new String[]{str}, null, null, null, 2);
        if (a.moveToFirst()) {
            z = true;
        } else {
            z = false;
        }
        a.close();
        return z;
    }

    public final Cursor Rv(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT username, unReadCount");
        stringBuilder.append(" FROM rconversation");
        stringBuilder.append(" WHERE username LIKE '%@chatroom' ");
        stringBuilder.append(bg.mz(str));
        stringBuilder.append(" AND unReadCount > 0");
        return this.gUz.rawQuery(stringBuilder.toString(), null);
    }

    public final Cursor eK(String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select unReadCount");
        stringBuilder.append(" from rconversation where username").append(" = '").append(str).append("' AND ( parentRef is ").append(com.tencent.mm.k.a.gTS).append(" or parentRef = '' ) ").append(bg.mz(str2));
        return this.gUz.rawQuery(stringBuilder.toString(), null);
    }

    public final Cursor o(String str, List<String> list) {
        w.i("MicroMsg.ConversationStorage", "getTotalUnreadCursor filter[%s] [%s]", str, bg.bJZ());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select sum(unReadCount) from rconversation").append(", rcontact");
        stringBuilder.append(" where rconversation.unReadCount").append(" > 0 AND (rconversation.parentRef").append(" is ").append(com.tencent.mm.k.a.gTS).append(" or parentRef = '' ) AND ").append("rconversation.username = ").append("rcontact.username").append(bg.mz(str)).append(" AND ( type & 512").append(" ) == 0 AND rcontact.").append("username != 'officialaccounts'");
        if (!(list == null || list.isEmpty())) {
            for (String append : list) {
                stringBuilder.append(" AND rconversation.username").append(" != '").append(append).append("'");
            }
        }
        w.v("MicroMsg.ConversationStorage", "get total unread with black list, sql is %s", stringBuilder.toString());
        return this.gUz.rawQuery(stringBuilder.toString(), null);
    }

    public final Cursor p(String str, List<String> list) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT COUNT(rconversation.username)");
        stringBuilder.append(" FROM rconversation, rcontact");
        stringBuilder.append(" WHERE unReadCount > 0");
        stringBuilder.append(" AND rconversation.username = rcontact.username");
        stringBuilder.append(bg.mz(str));
        stringBuilder.append(" AND ( type & 512").append(" ) == 0");
        stringBuilder.append(" AND ( attrflag & 2097152 ) == 0");
        stringBuilder.append(" AND ( ( parentRef is ").append(com.tencent.mm.k.a.gTS).append(" or parentRef = '' ) ");
        stringBuilder.append(" AND rcontact.username").append(" != 'officialaccounts')");
        w.i("MicroMsg.ConversationStorage", "get total unread talker, sql is %s", stringBuilder.toString());
        return this.gUz.rawQuery(stringBuilder.toString(), null);
    }

    public final Cursor cG(String str, int i) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT rconversation.username");
        stringBuilder.append(" FROM rconversation, rcontact");
        stringBuilder.append(" WHERE unReadCount > 0");
        stringBuilder.append(" AND rconversation.username = rcontact.username");
        stringBuilder.append(bg.mz(str));
        stringBuilder.append(" AND ( type & 512").append(" ) == 0");
        stringBuilder.append(" AND ( ( parentRef is ").append(com.tencent.mm.k.a.gTS).append(" or parentRef = '' ) ");
        stringBuilder.append(" AND rcontact.username").append(" != 'officialaccounts')");
        stringBuilder.append(" ORDER BY flag DESC, conversationTime").append(" DESC ");
        if (i > 0) {
            stringBuilder.append(" LIMIT ").append(String.valueOf(i));
        }
        w.i("MicroMsg.ConversationStorage", "get total unread talker, sql is %s", stringBuilder.toString());
        return this.gUz.rawQuery(stringBuilder.toString(), null);
    }

    public final int bLK() {
        int i = 0;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT SUM(rconversation.unReadCount").append(")");
        stringBuilder.append(" FROM rconversation");
        stringBuilder.append(" WHERE parentRef = 'officialaccounts").append("'");
        w.d("MicroMsg.ConversationStorage", "getTotalUnreadBizCount sql %s", stringBuilder.toString());
        Cursor a = this.gUz.a(r1, null, 2);
        if (a != null) {
            if (a.moveToFirst()) {
                i = a.getInt(0);
            }
            a.close();
        }
        return i;
    }

    public final String bLL() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT rconversation.username");
        stringBuilder.append(" FROM rconversation");
        stringBuilder.append(" WHERE parentRef = 'officialaccounts").append("'");
        stringBuilder.append(" ORDER BY flag DESC, conversationTime").append(" DESC ");
        stringBuilder.append(" LIMIT 1 ");
        w.i("MicroMsg.ConversationStorage", "get last conversation user, sql is %s", stringBuilder.toString());
        Cursor a = this.gUz.a(r1, null, 2);
        if (a == null) {
            return null;
        }
        if (a.moveToFirst()) {
            String string = a.getString(0);
            a.close();
            return string;
        }
        a.close();
        return null;
    }

    public final int Rw(String str) {
        int i = 0;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT COUNT(*) FROM rconversation");
        stringBuilder.append(" WHERE parentRef = '").append(str).append("'");
        w.i("MicroMsg.ConversationStorage", "get enterprise conversation count, sql is %s", stringBuilder.toString());
        Cursor a = this.gUz.a(r1, null, 2);
        if (a != null) {
            if (a.moveToFirst()) {
                i = a.getInt(0);
            }
            a.close();
        }
        return i;
    }

    public final String Rx(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT rconversation.username");
        stringBuilder.append(" FROM rconversation");
        stringBuilder.append(" WHERE parentRef = '").append(str).append("'");
        stringBuilder.append(" ORDER BY conversationTime DESC, conversationTime").append(" DESC ");
        stringBuilder.append(" LIMIT 1 ");
        w.i("MicroMsg.ConversationStorage", "get last enterprise conversation user, sql is %s", stringBuilder.toString());
        Cursor a = this.gUz.a(r1, null, 2);
        if (a == null) {
            return null;
        }
        if (a.moveToFirst()) {
            String string = a.getString(0);
            a.close();
            return string;
        }
        a.close();
        return null;
    }

    public final Cursor bLM() {
        w.i("MicroMsg.ConversationStorage", "get bottle total conversation unread sql is %s", "select count(*) from rbottleconversation where unReadCount > 0");
        return this.gUz.rawQuery("select count(*) from rbottleconversation where unReadCount > 0", null);
    }

    public final int fM(String str) {
        int i = 0;
        Cursor a = this.gUz.a("select sum(unReadCount) from rconversation,rcontact where rconversation.username = rcontact.username" + bg.mz(str), null, 2);
        if (a.moveToFirst()) {
            i = a.getInt(0);
        }
        a.close();
        return i;
    }

    public final ae bLN() {
        Cursor c = ((h) com.tencent.mm.kernel.h.h(h.class)).wW().c(o.hlr, null, "officialaccounts");
        if (c == null) {
            return null;
        }
        ae aeVar;
        if (c.getCount() <= 0 || !c.moveToFirst()) {
            aeVar = null;
        } else {
            aeVar = new ae();
            aeVar.b(c);
        }
        c.close();
        return aeVar;
    }

    public final ae Ry(String str) {
        Cursor c = ((h) com.tencent.mm.kernel.h.h(h.class)).wW().c(o.hlr, null, str);
        if (c == null) {
            return null;
        }
        ae aeVar;
        if (c.getCount() <= 0 || !c.moveToFirst()) {
            aeVar = null;
        } else {
            aeVar = new ae();
            aeVar.b(c);
        }
        c.close();
        return aeVar;
    }

    public final void e(String[] strArr, String str) {
        int i;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Update rconversation");
        stringBuilder.append(" set parentRef = '").append(bg.mz(str)).append("' where 1 != 1 ");
        for (i = 0; i <= 0; i++) {
            stringBuilder.append(" or username = '").append(strArr[0]).append("'");
        }
        w.d("MicroMsg.ConversationStorage", "update sql: %s", stringBuilder.toString());
        if (this.gUz.eE("rconversation", stringBuilder.toString())) {
            for (i = 0; i <= 0; i++) {
                b(3, this, strArr[0]);
            }
        }
    }

    public final int Rz(String str) {
        int i = 0;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select sum(atCount) from rconversation");
        stringBuilder.append(" where unReadCount > 0");
        if (!bg.mA(str)) {
            stringBuilder.append(" and username = '").append(str).append("'");
        }
        w.d("MicroMsg.ConversationStorage", "query sql: %s", stringBuilder.toString());
        Cursor a = this.gUz.a(r1, null, 2);
        if (a != null) {
            if (a.moveToFirst()) {
                i = a.getInt(0);
            }
            a.close();
        }
        return i;
    }

    public final String aA(int i, String str) {
        if (bg.mA(str)) {
            return null;
        }
        switch (i) {
            case 49:
                Map q = bh.q(str, "msg");
                if (q == null) {
                    return null;
                }
                w.d("MicroMsg.ConversationStorage", "[oneliang][parseConversationMsgContentTitle] title:%s", (String) q.get(".msg.appmsg.title"));
                return (String) q.get(".msg.appmsg.title");
            default:
                return null;
        }
    }

    protected final boolean Fc() {
        if (this.gUz != null && !this.gUz.bKn()) {
            return true;
        }
        String str = "MicroMsg.ConversationStorage";
        String str2 = "shouldProcessEvent db is close :%s";
        Object[] objArr = new Object[1];
        objArr[0] = this.gUz == null ? "null" : Boolean.valueOf(this.gUz.bKn());
        w.w(str, str2, objArr);
        return false;
    }

    public final void RA(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Update rconversation");
        stringBuilder.append(" set parentRef = '', unReadCount = 0").append(" where username = \"" + bg.my(str) + "\"");
        w.d("MicroMsg.ConversationStorage", "removeParentRefAndUnread sql: %s", stringBuilder.toString());
        if (this.gUz.eE("rconversation", stringBuilder.toString())) {
            b(3, this, str);
        }
    }

    public final void RB(String str) {
        w.d("MicroMsg.ConversationStorage", "delEnterpriseFatherAndChildConv %s %d", str, Integer.valueOf(this.gUz.delete(Rk(str), "username=? or parentRef =?", new String[]{str, str})));
        if (this.gUz.delete(Rk(str), "username=? or parentRef =?", new String[]{str, str}) != 0) {
            b(5, this, str);
        }
    }

    public final int RC(String str) {
        int i = -1;
        if (str != null && str.length() > 0) {
            Cursor a = this.gUz.a("select msgCount from rconversation where username=" + g.dP(str), null, 2);
            if (a.moveToFirst()) {
                i = a.getInt(0);
            }
            a.close();
        }
        return i;
    }
}
