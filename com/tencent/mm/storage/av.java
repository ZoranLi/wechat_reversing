package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Looper;
import com.tencent.mm.a.f;
import com.tencent.mm.bj.g;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.c.b;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au.a;
import com.tencent.mm.storage.au.d;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.o;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import junit.framework.Assert;

public final class av extends j implements c {
    public static final String[] gUx;
    private final g hnH;
    private final long uJn = 86400;
    private Map<String, c.c> uKA = new HashMap();
    private boolean uKB = false;
    private String uKC = "";
    private long uKD = 0;
    private boolean uKn = false;
    private as uKo;
    private ar uKp;
    private final List<e> uKq = new CopyOnWriteArrayList();
    private List<b> uKr;
    private final f<Integer, au.c> uKs = new f(100);
    private final f<Integer, d> uKt = new f(100);
    private final f<Integer, a> uKu = new f(100);
    private final f<Integer, au.b> uKv = new f(100);
    private final f<Integer, Object> uKw = new f(100);
    private final f<String, Long> uKx = new f(100);
    private ah uKy = new ah();
    private final k<c.a, c.c> uKz = new k<c.a, c.c>(this) {
        final /* synthetic */ av uKE;

        {
            this.uKE = r1;
        }

        protected final /* synthetic */ void o(Object obj, Object obj2) {
            ((c.a) obj).a(this.uKE, (c.c) obj2);
        }
    };

    public final int AG(java.lang.String r9) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.ssa.SSATransform.placePhi(SSATransform.java:82)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:50)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r8 = this;
        r7 = 2;
        r1 = 0;
        r0 = new java.lang.StringBuilder;
        r2 = " SELECT COUNT(*) FROM ";
        r0.<init>(r2);
        r2 = r8.AB(r9);
        r0 = r0.append(r2);
        r2 = " WHERE";
        r0 = r0.append(r2);
        r2 = r8.RJ(r9);
        r0 = r0.append(r2);
        r2 = "AND isSend=1";
        r0 = r0.append(r2);
        r2 = r0.toString();
        r0 = r8.hnH;
        r3 = 0;
        r3 = r0.a(r2, r3, r7);
        r0 = r3.moveToFirst();	 Catch:{ Exception -> 0x0059, all -> 0x006b }
        if (r0 == 0) goto L_0x0070;	 Catch:{ Exception -> 0x0059, all -> 0x006b }
    L_0x0039:
        r0 = 0;	 Catch:{ Exception -> 0x0059, all -> 0x006b }
        r0 = r3.getInt(r0);	 Catch:{ Exception -> 0x0059, all -> 0x006b }
    L_0x003e:
        r3.close();
    L_0x0041:
        r3 = "MicroMsg.MsgInfoStorage";
        r4 = "[getMsgCountBySelf] getCursor talk:%s,count:%s,[%s]";
        r5 = 3;
        r5 = new java.lang.Object[r5];
        r5[r1] = r9;
        r1 = 1;
        r6 = java.lang.Integer.valueOf(r0);
        r5[r1] = r6;
        r5[r7] = r2;
        com.tencent.mm.sdk.platformtools.w.d(r3, r4, r5);
        return r0;
    L_0x0059:
        r0 = move-exception;
        r4 = "MicroMsg.MsgInfoStorage";	 Catch:{ Exception -> 0x0059, all -> 0x006b }
        r5 = "";	 Catch:{ Exception -> 0x0059, all -> 0x006b }
        r6 = 0;	 Catch:{ Exception -> 0x0059, all -> 0x006b }
        r6 = new java.lang.Object[r6];	 Catch:{ Exception -> 0x0059, all -> 0x006b }
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r4, r0, r5, r6);	 Catch:{ Exception -> 0x0059, all -> 0x006b }
        r3.close();
        r0 = r1;
        goto L_0x0041;
    L_0x006b:
        r0 = move-exception;
        r3.close();
        throw r0;
    L_0x0070:
        r0 = r1;
        goto L_0x003e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.av.AG(java.lang.String):int");
    }

    public final int cP(java.lang.String r9, java.lang.String r10) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.ssa.SSATransform.placePhi(SSATransform.java:82)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:50)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r8 = this;
        r7 = 2;
        r1 = 0;
        r0 = new java.lang.StringBuilder;
        r2 = " SELECT COUNT(*) FROM ";
        r0.<init>(r2);
        r2 = r8.AB(r9);
        r0 = r0.append(r2);
        r2 = " WHERE";
        r0 = r0.append(r2);
        r2 = r8.RJ(r9);
        r0 = r0.append(r2);
        r2 = "AND content LIKE '";
        r0 = r0.append(r2);
        r0 = r0.append(r10);
        r2 = "%' ";
        r0 = r0.append(r2);
        r2 = r0.toString();
        r0 = r8.hnH;
        r3 = 0;
        r3 = r0.a(r2, r3, r7);
        r0 = r3.moveToFirst();	 Catch:{ Exception -> 0x0067, all -> 0x0079 }
        if (r0 == 0) goto L_0x007e;	 Catch:{ Exception -> 0x0067, all -> 0x0079 }
    L_0x0044:
        r0 = 0;	 Catch:{ Exception -> 0x0067, all -> 0x0079 }
        r0 = r3.getInt(r0);	 Catch:{ Exception -> 0x0067, all -> 0x0079 }
    L_0x0049:
        r3.close();
    L_0x004c:
        r3 = "MicroMsg.MsgInfoStorage";
        r4 = "getMsgCountByMember getCursor talk:%s member:%s,count:%s,[%s]";
        r5 = 4;
        r5 = new java.lang.Object[r5];
        r5[r1] = r9;
        r1 = 1;
        r5[r1] = r10;
        r1 = java.lang.Integer.valueOf(r0);
        r5[r7] = r1;
        r1 = 3;
        r5[r1] = r2;
        com.tencent.mm.sdk.platformtools.w.d(r3, r4, r5);
        return r0;
    L_0x0067:
        r0 = move-exception;
        r4 = "MicroMsg.MsgInfoStorage";	 Catch:{ Exception -> 0x0067, all -> 0x0079 }
        r5 = "";	 Catch:{ Exception -> 0x0067, all -> 0x0079 }
        r6 = 0;	 Catch:{ Exception -> 0x0067, all -> 0x0079 }
        r6 = new java.lang.Object[r6];	 Catch:{ Exception -> 0x0067, all -> 0x0079 }
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r4, r0, r5, r6);	 Catch:{ Exception -> 0x0067, all -> 0x0079 }
        r3.close();
        r0 = r1;
        goto L_0x004c;
    L_0x0079:
        r0 = move-exception;
        r3.close();
        throw r0;
    L_0x007e:
        r0 = r1;
        goto L_0x0049;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.av.cP(java.lang.String, java.lang.String):int");
    }

    public final void a(e eVar) {
        if (!this.uKq.contains(eVar)) {
            this.uKq.add(eVar);
        }
    }

    public final g aJZ() {
        return this.hnH;
    }

    static {
        String[] strArr = new String[1];
        strArr[0] = "CREATE TABLE IF NOT EXISTS " + "message" + " ( msgId INTEGER PRIMARY KEY, msgSvrId" + " INTEGER , type INT, status" + " INT, isSend INT, isShowTimer" + " INTEGER, createTime INTEGER, talker" + " TEXT, content TEXT, imgPath" + " TEXT, reserved TEXT, lvbuffer" + " BLOB, transContent TEXT,transBrandWording" + " TEXT ,talkerId INTEGER, bizClientMsgId" + " TEXT, bizChatId INTEGER DEFAULT -1, bizChatUserId" + " TEXT, msgSeq INTEGER, flag" + " INT) ";
        gUx = strArr;
    }

    public final void a(c.c cVar) {
        if (this.uKz.by(cVar)) {
            this.uKz.doNotify();
        }
    }

    public final void a(c.a aVar, Looper looper) {
        this.uKz.a(aVar, looper);
    }

    public final void a(c.a aVar) {
        this.uKz.remove(aVar);
    }

    public final void lock() {
        Assert.assertTrue("lock deprecated, use lockForSync instead.", false);
    }

    public final void unlock() {
        Assert.assertTrue("unlock deprecated, use lockForSync instead.", false);
    }

    public final void Ae(String str) {
        w.i("MicroMsg.MsgInfoStorage", "lockForSync tag:%s islock:%b lockCnt[%d,%d] notifyCnt:%d last:[%s,%d]", str, Boolean.valueOf(this.uKB), Integer.valueOf(this.uxh.uxk), Integer.valueOf(this.uKz.uxk), Integer.valueOf(this.uKA.size()), this.uKC, Long.valueOf(bg.aA(this.uKD)));
        if (bg.mA(str)) {
            Assert.assertTrue("lockForSync, do not call me by null tag.", false);
        }
        if (this.uKB) {
            w.w("MicroMsg.MsgInfoStorage", "lockForSync, has been locked by :%s  time:%d", this.uKC, Long.valueOf(bg.aA(this.uKD)));
            return;
        }
        this.uKC = str;
        this.uKD = bg.Nz();
        this.uKB = true;
        super.lock();
        this.uKz.lock();
    }

    public final void Af(String str) {
        w.i("MicroMsg.MsgInfoStorage", "unlockForSync tag:%s islock:%b lockCnt[%d,%d] notifyCnt:%d last:[%s,%d]", str, Boolean.valueOf(this.uKB), Integer.valueOf(this.uxh.uxk), Integer.valueOf(this.uKz.uxk), Integer.valueOf(this.uKA.size()), this.uKC, Long.valueOf(bg.aA(this.uKD)));
        if (bg.mA(str)) {
            Assert.assertTrue("lockForSync, do not call me by null tag.", false);
        }
        if (!this.uKB) {
            w.w("MicroMsg.MsgInfoStorage", "unlockForSync, No one Locking Now , why this fucking tag:%s call it ! [%s]", str, bg.bJZ());
        } else if (str.equals(this.uKC)) {
            this.uKB = false;
            this.uKD = 0;
            this.uKC = "";
            for (String str2 : this.uKA.keySet()) {
                a((c.c) this.uKA.get(str2));
            }
            this.uKA.clear();
            super.unlock();
            this.uKz.unlock();
            doNotify();
        } else {
            w.w("MicroMsg.MsgInfoStorage", "unlockForSync locking[%s] diff:%d, but unlock[%s] , Ignore this call.", this.uKC, Long.valueOf(bg.aA(this.uKD)), str);
        }
    }

    public final void a(g gVar, String str) {
        Object obj = null;
        Object obj2 = null;
        Object obj3 = null;
        Object obj4 = null;
        Object obj5 = null;
        Object obj6 = null;
        Object obj7 = null;
        Object obj8 = null;
        Object obj9 = null;
        Cursor a = gVar.a("PRAGMA table_info( " + str + " )", null, 2);
        int columnIndex = a.getColumnIndex("name");
        while (a.moveToNext()) {
            if (columnIndex >= 0) {
                String string = a.getString(columnIndex);
                if ("lvbuffer".equalsIgnoreCase(string)) {
                    obj = 1;
                } else if ("transContent".equalsIgnoreCase(string)) {
                    obj2 = 1;
                } else if ("transBrandWording".equalsIgnoreCase(string)) {
                    obj3 = 1;
                } else if ("talkerId".equalsIgnoreCase(string)) {
                    obj4 = 1;
                } else if ("bizClientMsgId".equalsIgnoreCase(string)) {
                    obj5 = 1;
                } else if ("bizChatId".equalsIgnoreCase(string)) {
                    obj6 = 1;
                } else if ("bizChatUserId".equalsIgnoreCase(string)) {
                    obj7 = 1;
                } else if ("msgSeq".equalsIgnoreCase(string)) {
                    obj8 = 1;
                } else if ("flag".equalsIgnoreCase(string)) {
                    obj9 = 1;
                }
            }
        }
        a.close();
        long cs = gVar.cs(Thread.currentThread().getId());
        if (obj == null) {
            gVar.eE(str, "Alter table " + str + " add lvbuffer BLOB ");
        }
        if (obj2 == null) {
            gVar.eE(str, "Alter table " + str + " add transContent TEXT ");
        }
        if (obj3 == null) {
            gVar.eE(str, "Alter table " + str + " add transBrandWording TEXT ");
        }
        if (obj4 == null) {
            gVar.eE(str, "Alter table " + str + " add talkerId INTEGER ");
        }
        if (obj5 == null) {
            gVar.eE(str, "Alter table " + str + " add bizClientMsgId TEXT ");
        }
        if (obj6 == null) {
            gVar.eE(str, "Alter table " + str + " add bizChatId INTEGER DEFAULT -1");
        }
        if (obj7 == null) {
            gVar.eE(str, "Alter table " + str + " add bizChatUserId TEXT ");
        }
        if (obj8 == null) {
            gVar.eE(str, "Alter table " + str + " add msgSeq INTEGER ");
        }
        if (obj9 == null) {
            gVar.eE(str, "Alter table " + str + " add flag INT DEFAULT 0 ");
        }
        gVar.aD(cs);
    }

    public final void w(String str, long j) {
        b RO = RO(str);
        long j2 = RO.hFg;
        Random random = new Random();
        this.hnH.eE("message", "BEGIN;");
        ce auVar = new au(str);
        for (int i = 0; ((long) i) < j; i++) {
            auVar.z(System.currentTimeMillis());
            auVar.setType(1);
            auVar.setContent("纵观目前国内手游市场，大量同质类手游充斥玩家的视野，而在主机和PC平台上经久不衰的体育类游戏，却鲜有佳作。在获得了NBA官方认可以后。" + bg.bKa());
            auVar.x(j2);
            auVar.dv(random.nextInt(4));
            auVar.dw(random.nextInt(1));
            j2++;
            RO.hFg++;
            auVar.y(System.currentTimeMillis() + ((long) bg.bKa()));
            this.hnH.eE("message", "INSERT INTO " + AB(auVar.field_talker) + " (msgid,msgSvrid,type,status,createTime,talker,content,talkerid)  VALUES(" + auVar.field_msgId + "," + auVar.field_msgSvrId + "," + auVar.field_type + "," + auVar.field_status + "," + auVar.field_createTime + ",'" + auVar.field_talker + "','" + auVar.field_content + "'," + RK(str) + ");");
            if (i % 10000 == 0) {
                this.hnH.eE("message", "COMMIT;");
                this.hnH.eE("message", "BEGIN;");
            }
        }
        this.hnH.eE("message", "COMMIT;");
        this.uKo.Rn(str);
        auVar.x(1 + j2);
        L(auVar);
    }

    private void bMN() {
        long currentTimeMillis = System.currentTimeMillis();
        long cs = this.hnH.cs(Thread.currentThread().getId());
        long currentTimeMillis2 = System.currentTimeMillis();
        List arrayList = new ArrayList();
        String str = "message";
        String[] strArr = new String[]{"CREATE INDEX IF NOT EXISTS " + str + "IdIndex ON message ( msgId" + " )", "CREATE INDEX IF NOT EXISTS " + str + "SvrIdIndex ON message ( msgSvrId" + " )", "CREATE INDEX IF NOT EXISTS " + str + "SendCreateTimeIndex ON message ( status" + ",isSend,createTime" + " )", "CREATE INDEX IF NOT EXISTS " + str + "CreateTimeIndex ON message ( createTime" + " )", "CREATE INDEX IF NOT EXISTS " + str + "TaklerIdTypeCreateTimeIndex ON message ( talkerId" + ",type,createTime" + " )", "CREATE INDEX IF NOT EXISTS " + str + "TalkerIdStatusIndex ON message ( talkerId" + ",status )", "CREATE INDEX IF NOT EXISTS " + str + "TalkerIdCreateTimeIsSendIndex ON message ( talkerId" + ",isSend,createTime" + " )", "CREATE INDEX IF NOT EXISTS " + str + "TalkerIdCreateTimeIndex ON message ( talkerId" + ",createTime )", "CREATE INDEX IF NOT EXISTS " + str + "TalkerIdSvrIdIndex ON message ( talkerId" + ",msgSvrId )", "CREATE INDEX IF NOT EXISTS " + str + "TalkerIdTypeIndex ON message ( talkerId" + ",type )", "CREATE INDEX IF NOT EXISTS " + str + "TalkerTypeIndex ON message ( talker" + ",type )", "CREATE INDEX IF NOT EXISTS " + str + "messageTalkerMsgSeqIndex ON message ( talker" + ",msgSeq )", "CREATE INDEX IF NOT EXISTS " + str + "messageTalkerFlagMsgSeqIndex ON message ( talker" + ",flag,msgSeq" + " )"};
        if (!this.uKn) {
            strArr[4] = "CREATE INDEX IF NOT EXISTS  messageCreateTaklerTypeTimeIndex ON message ( talker,type,createTime )";
            strArr[5] = "CREATE INDEX IF NOT EXISTS  messageTalkerStatusIndex ON message ( talker,status )";
            strArr[6] = "CREATE INDEX IF NOT EXISTS  messageTalkerCreateTimeIsSendIndex ON message ( talker,isSend,createTime )";
            strArr[7] = "CREATE INDEX IF NOT EXISTS  messageCreateTaklerTimeIndex ON message ( talker,createTime )";
            strArr[8] = "CREATE INDEX IF NOT EXISTS  messageTalkerSvrIdIndex ON message ( talker,msgSvrId )";
        }
        arrayList.addAll(Arrays.asList(strArr));
        for (int i = 0; i < arrayList.size(); i++) {
            this.hnH.eE("message", (String) arrayList.get(i));
        }
        w.i("MicroMsg.MsgInfoStorage", "build new index last %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
        this.hnH.aD(cs);
        w.i("MicroMsg.MsgInfoStorage", "executeMsgInitSQL last %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
    }

    public final void aKa() {
        h.vJ();
        h.vI().vr().set(348167, Integer.valueOf(1));
    }

    public av(g gVar, ar arVar, as asVar) {
        this.hnH = gVar;
        this.uKp = arVar;
        this.uKo = asVar;
        h.vJ();
        if (((Integer) h.vI().vr().get(348169, Integer.valueOf(0))).intValue() == 0) {
            int delete = this.hnH.delete("message", "msgId> ? ", new String[]{"80000000"});
            w.i("MicroMsg.MsgInfoStorage", "deleted dirty msg ,count is %d", Integer.valueOf(delete));
            h.vJ();
            h.vI().vr().set(348169, Integer.valueOf(1));
        }
        a(gVar, "message");
        bMN();
        if (this.uKr == null) {
            this.uKr = new LinkedList();
        }
        this.uKr.clear();
        a(new b(1, "message", b.a(1, 1000000, 10000000, 90000000)));
    }

    public final void a(b bVar) {
        this.uKr.add(bVar);
        b(bVar);
    }

    public final void aKb() {
        for (int i = 0; i < this.uKr.size(); i++) {
            b((b) this.uKr.get(i));
        }
    }

    private void b(b bVar) {
        Cursor a = this.hnH.a("select max(msgid) from " + bVar.name, null, 2);
        if (a.moveToFirst()) {
            int i = a.getInt(0);
            w.i("MicroMsg.MsgInfoStorage", "id count is %d, now id:%d", Integer.valueOf(i), Long.valueOf(bVar.hFg));
            if (((long) i) >= bVar.hFg) {
                w.i("MicroMsg.MsgTable", "summermsg setMsgLocalId [%d, %d]  regions[%d, %d] stack[%s]", Long.valueOf(bVar.hFg), Integer.valueOf(i), Long.valueOf(bVar.nyK[0].nyN), Long.valueOf(bVar.nyK[1].nyM), bg.bJZ());
                if (((long) i) <= bVar.nyK[0].nyN || ((long) i) >= bVar.nyK[1].nyM) {
                    bVar.hFg = (long) i;
                } else {
                    w.i("MicroMsg.MsgTable", "summermsg setMsgLocalId revised msgLocalId to %d", Long.valueOf(bVar.nyK[1].nyM));
                    bVar.hFg = bVar.nyK[1].nyM;
                    com.tencent.mm.plugin.report.c.oTb.a(111, 169, 1, false);
                }
            }
        }
        a.close();
        w.w("MicroMsg.MsgInfoStorage", "loading new msg id:" + bVar.hFg);
    }

    public final void aKc() {
        if (this.uKn) {
            String str = "message";
            Cursor a = this.hnH.a("select count(*) from " + str + " where talkerId ISNULL ", null, 2);
            if (a != null) {
                int i = a.moveToFirst() ? a.getInt(0) : 0;
                a.close();
                if (i > 0) {
                    w.i("MicroMsg.MsgInfoStorage", " msg table exists null talkerid ,start translate tableName %s ", str);
                    long currentTimeMillis = System.currentTimeMillis();
                    w.i("MicroMsg.MsgInfoStorage", "update result :%b last %d", Boolean.valueOf(this.hnH.eE(str, "update " + str + " set talkerId=(select rowid from rcontact" + " where rcontact.username" + " = " + str + ".talker)")), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    if (this.hnH.eE(str, "update " + str + " set talkerId=(select rowid from rcontact" + " where rcontact.username" + " = " + str + ".talker)") && this.uKn) {
                        this.hnH.eE("message", "DROP INDEX messageCreateTaklerTypeTimeIndex IF EXISTS");
                        this.hnH.eE("message", "DROP INDEX messageTalkerStatusIndex IF EXISTS");
                        this.hnH.eE("message", "DROP INDEX messageTalkerCreateTimeIsSendIndex IF EXISTS");
                        this.hnH.eE("message", "DROP INDEX messageCreateTaklerTimeIndex IF EXISTS");
                        this.hnH.eE("message", "DROP INDEX messageTalkerSvrIdIndex IF EXISTS");
                        w.i("MicroMsg.MsgInfoStorage", "clear talker Name index");
                    }
                }
            }
        }
    }

    public final au cA(long j) {
        au auVar = new au();
        Cursor a = this.hnH.a(eC(j), null, "msgId=?", new String[]{String.valueOf(j)}, null, null, null, 2);
        if (a.moveToFirst()) {
            auVar.b(a);
        }
        a.close();
        return auVar;
    }

    public final au x(String str, long j) {
        au auVar = new au();
        Cursor a = this.hnH.a(AB(str), null, "msgSvrId=?", new String[]{String.valueOf(j)}, null, null, null, 2);
        if (a.moveToFirst()) {
            auVar.b(a);
        }
        a.close();
        return auVar;
    }

    public final au y(String str, long j) {
        au auVar = new au();
        Cursor a = this.hnH.a(AB(str), null, RJ(str) + " AND msgSeq=?", new String[]{String.valueOf(j)}, null, null, null, 2);
        if (a.moveToFirst()) {
            auVar.b(a);
        }
        a.close();
        return auVar;
    }

    public final au z(String str, long j) {
        au auVar = new au();
        Cursor a = this.hnH.a(AB(str), null, "createTime=? AND" + RJ(str), new String[]{String.valueOf(j)}, null, null, null, 2);
        if (a.moveToFirst()) {
            auVar.b(a);
        }
        a.close();
        return auVar;
    }

    public final Cursor Ag(String str) {
        return this.hnH.query(AB(str), new String[]{"createTime", "msgId"}, RJ(str), null, "createTime", null, "createTime ASC");
    }

    public final List<au> A(String str, long j) {
        List<au> arrayList = new ArrayList();
        String str2 = "Select * From " + AB(str) + " Where " + RJ(str) + " AND createTime < ? and not ( type = 10000 and isSend != 2 ) " + " Order By createTime Desc Limit 11";
        Cursor a = this.hnH.a(str2, new String[]{String.valueOf(j)}, 2);
        while (a.moveToNext()) {
            au auVar = new au();
            auVar.b(a);
            arrayList.add(auVar);
        }
        a.close();
        return arrayList;
    }

    public final List<au> B(String str, long j) {
        List<au> arrayList = new ArrayList();
        String str2 = "Select * From " + AB(str) + " Where " + RJ(str) + " AND createTime > ? and not ( type = 10000 and isSend != 2 ) " + " Order By createTime Desc Limit 11" + ";";
        Cursor a = this.hnH.a(str2, new String[]{String.valueOf(j)}, 2);
        while (a.moveToNext()) {
            au auVar = new au();
            auVar.b(a);
            arrayList.add(auVar);
        }
        a.close();
        return arrayList;
    }

    private String RJ(String str) {
        String AB = AB(str);
        if (this.uKn && AB.equals("message")) {
            return " talkerId=" + RK(str) + " ";
        }
        return " talker= '" + bg.my(str) + "' ";
    }

    private long RK(String str) {
        long Rd = this.uKp.Rd(str);
        if (Rd < 0) {
            x xVar = new x(str);
            xVar.setType(2);
            this.uKp.R(xVar);
            Rd = this.uKp.Rd(str);
        }
        if (!com.tencent.mm.sdk.a.b.bIw()) {
            w.i("MicroMsg.MsgInfoStorage", "getTalkerIdByTalkerName:%s id:%s needinsert:%s [%s]", str, Long.valueOf(Rd), Boolean.valueOf(r2), bg.bJZ());
        }
        return Rd;
    }

    public final ArrayList<au> aKd() {
        ArrayList<au> arrayList = new ArrayList();
        Cursor a = this.hnH.a("message", null, "createTime>=? AND status=? AND isSend=?", new String[]{String.valueOf(System.currentTimeMillis() - 172800000), "5", "1"}, null, null, "createTime ASC", 2);
        while (a.moveToNext()) {
            ce auVar = new au();
            auVar.b(a);
            if (!(((!auVar.bMv() ? 1 : 0) & 1) == 0 || x.QM(auVar.field_talker) || x.QO(auVar.field_talker) || x.eO(auVar.field_talker))) {
                arrayList.add(auVar);
            }
        }
        a.close();
        return arrayList;
    }

    public final void J(ArrayList<Long> arrayList) {
        long cs = this.hnH.cs(-1);
        try {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                long longValue = ((Long) it.next()).longValue();
                au cA = cA(longValue);
                cA.dG(cA.gxE | 32);
                w.d("MicroMsg.MsgInfoStorage", "msgId:%d, setOmitFailResend", Long.valueOf(longValue));
                a(longValue, cA);
            }
        } finally {
            this.hnH.aD(cs);
        }
    }

    public final boolean C(String str, long j) {
        return z(str, j).field_msgId > 0;
    }

    public final int c(String str, long j, int i) {
        String str2 = "SELECT * FROM " + AB(str) + " WHERE" + RJ(str) + "AND createTime < " + j + " ORDER BY createTime ASC LIMIT -1 OFFSET " + i;
        Cursor a = this.hnH.a(str2, null, 0);
        int count = a.getCount();
        a.close();
        w.d("MicroMsg.MsgInfoStorage", "getPositionByCreateTime talk:" + str + " time:" + j + " count " + count + " [" + str2 + "]");
        return count;
    }

    public final au Ah(String str) {
        au auVar = new au();
        Cursor a = this.hnH.a(AB(str), null, RJ(str), null, null, null, "msgSvrId  DESC limit 1 ", 2);
        if (a.moveToFirst()) {
            auVar.b(a);
        }
        a.close();
        return auVar;
    }

    public final au Ai(String str) {
        if (bg.mA(str)) {
            return null;
        }
        au auVar = new au();
        Cursor a = this.hnH.a("select * from " + AB(str) + " where" + RJ(str) + "order by createTime DESC limit 1", null, 2);
        if (a.moveToFirst()) {
            auVar.b(a);
        }
        a.close();
        return auVar;
    }

    public final au cN(String str, String str2) {
        if (bg.mA(str)) {
            w.e("MicroMsg.MsgInfoStorage", "getLastMsg failed : talker:%s", str);
            return null;
        }
        ce auVar = new au();
        Cursor a = this.hnH.a("select * from " + AB(str) + " where" + RJ(str) + str2 + " order by createTime DESC limit 1", null, 2);
        if (a.moveToFirst()) {
            auVar.b(a);
        }
        a.close();
        w.i("MicroMsg.MsgInfoStorage", "getLastMsg talker:%s msgid:%d", str, Long.valueOf(auVar.field_msgId));
        return auVar;
    }

    public final au Aj(String str) {
        if (bg.mA(str)) {
            return null;
        }
        au auVar = new au();
        Cursor a = this.hnH.a("select * from " + AB(str) + " where" + RJ(str) + "and isSend = 0" + "  order by createTime DESC limit 1", null, 2);
        if (a.moveToFirst()) {
            auVar.b(a);
        }
        a.close();
        return auVar;
    }

    public final List<au> bd(String str, int i) {
        List<au> arrayList = new ArrayList();
        Assert.assertTrue(this.uKr != null);
        Cursor a = this.hnH.a("SELECT * FROM " + AB(str) + " WHERE" + RJ(str) + "AND status = 3" + " AND type <> 10000" + " ORDER BY createTime DESC LIMIT " + i, null, 2);
        while (a.moveToNext()) {
            au auVar = new au();
            auVar.b(a);
            arrayList.add(auVar);
        }
        a.close();
        return arrayList;
    }

    public final au pl(int i) {
        if (this.uKr == null) {
            w.e("MicroMsg.MsgInfoStorage", "getLastMsg failed lstTable is null");
            return null;
        }
        au auVar = new au();
        long j = 0;
        for (int i2 = 0; i2 < this.uKr.size(); i2++) {
            if ((((b) this.uKr.get(i2)).nyL & i) != 0) {
                Cursor a = this.hnH.a("select * from " + ((b) this.uKr.get(i2)).name + "  order by createTime DESC limit 1", null, 2);
                if (a.moveToFirst()) {
                    long j2 = a.getLong(a.getColumnIndex("createTime"));
                    if (j < j2) {
                        auVar.b(a);
                        j = j2;
                    }
                }
                a.close();
            }
        }
        return auVar;
    }

    public final au Ak(String str) {
        if (this.uKr == null) {
            w.e("MicroMsg.MsgInfoStorage", "getLastMsg failed lstTable is null");
            return null;
        }
        String str2;
        au auVar = new au();
        long j = 0;
        if (bg.mA(str)) {
            str2 = "";
        } else {
            str2 = str.replaceFirst("and", "where");
        }
        for (int i = 0; i < this.uKr.size(); i++) {
            if ((((b) this.uKr.get(i)).nyL & 8) != 0) {
                Cursor a = this.hnH.a("select * from " + ((b) this.uKr.get(i)).name + str2 + "  order by createTime DESC limit 1", null, 2);
                if (a.moveToFirst()) {
                    long j2 = a.getLong(a.getColumnIndex("createTime"));
                    if (j < j2) {
                        auVar.b(a);
                        j = j2;
                    }
                }
                a.close();
            }
        }
        return auVar;
    }

    public final List<au> aKe() {
        List<au> arrayList = new ArrayList();
        Assert.assertTrue(this.uKr != null);
        List<au> arrayList2 = new ArrayList();
        for (int i = 0; i < this.uKr.size(); i++) {
            Cursor a = this.hnH.a(((b) this.uKr.get(i)).name, null, "status=1 and isSend=1", null, null, null, "createTime DESC ", 2);
            while (a.moveToNext()) {
                ce auVar = new au();
                auVar.b(a);
                if (auVar.bMk() || auVar.bMi() || auVar.bMj() || auVar.bMr()) {
                    if (ay.zn() - auVar.field_createTime > 600000) {
                        arrayList2.add(auVar);
                    } else {
                        arrayList.add(auVar);
                    }
                }
            }
            a.close();
        }
        if (arrayList2.size() > 0) {
            long cs = this.hnH.cs(-1);
            for (au auVar2 : arrayList2) {
                w.i("MicroMsg.MsgInfoStorage", "Set msg timtout : id:%d time:%d talker:%s content:%s", Long.valueOf(auVar2.field_msgId), Long.valueOf(auVar2.field_createTime), auVar2.field_talker, bg.Qj(auVar2.field_content));
                auVar2.dv(5);
                a(auVar2.field_msgId, auVar2);
            }
            this.hnH.aD(cs);
        }
        return arrayList;
    }

    public final List<au> be(String str, int i) {
        List<au> arrayList = new ArrayList();
        Assert.assertTrue(this.uKr != null);
        Cursor a = this.hnH.a("SELECT * FROM " + AB(str) + " WHERE" + RJ(str) + "AND isSend = 0" + " ORDER BY createTime DESC LIMIT " + i, null, 2);
        while (a.moveToNext()) {
            au auVar = new au();
            auVar.b(a);
            if (auVar.bMk()) {
                arrayList.add(auVar);
            }
        }
        a.close();
        return arrayList;
    }

    public final List<au> D(String str, int i, int i2) {
        List<au> arrayList = new ArrayList();
        w.d("MicroMsg.MsgInfoStorage", "getAppMsgTypeList sql=%s", "SELECT * FROM " + AB(str) + " WHERE type = 49 ORDER BY createTime" + " DESC LIMIT " + i + " , " + i2);
        Cursor a = this.hnH.a(r1, null, 2);
        while (a.moveToNext()) {
            au auVar = new au();
            auVar.b(a);
            if (auVar.axO()) {
                arrayList.add(auVar);
            }
        }
        a.close();
        return arrayList;
    }

    public final int K(au auVar) {
        int i = 0;
        if (!(auVar == null || bg.mA(auVar.field_talker))) {
            Cursor a = this.hnH.a("SELECT count(msgId) FROM " + AB(auVar.field_talker) + " WHERE" + RJ(auVar.field_talker) + "AND isSend = 0" + " AND msgId >= " + auVar.field_msgId + " ORDER BY createTime DESC", null, 2);
            if (a.moveToFirst()) {
                i = a.getInt(0);
            }
            a.close();
        }
        return i;
    }

    private static String RL(String str) {
        if (bg.mA(str)) {
            return null;
        }
        try {
            Map q = bh.q(str, "msgsource");
            if (q == null || q.isEmpty()) {
                return null;
            }
            return (String) q.get(".msgsource.bizmsg.msgcluster");
        } catch (Throwable e) {
            w.e("MicroMsg.MsgInfoStorage", "exception:%s", bg.g(e));
            w.e("MicroMsg.MsgInfoStorage", "Exception in getMsgcluster, %s", e.getMessage());
            return null;
        }
    }

    private static void Z(au auVar) {
        if (auVar != null && auVar.axO()) {
            try {
                String str = auVar.field_content;
                int indexOf = str.indexOf("<msg>");
                if (indexOf > 0 && indexOf < str.length()) {
                    str = str.substring(indexOf).trim();
                }
                Map q = bh.q(str, "msg");
                if (q != null && q.size() > 0) {
                    auVar.cJ(aw.ae(q));
                }
            } catch (Exception e) {
                w.e("MicroMsg.MsgInfoStorage", e.getMessage());
            }
        }
    }

    public final long L(au auVar) {
        return b(auVar, false);
    }

    public final long b(au auVar, boolean z) {
        if (auVar == null || bg.mA(auVar.field_talker)) {
            com.tencent.mm.plugin.report.c.oTb.a(111, 250, 1, false);
            String str = "MicroMsg.MsgInfoStorage";
            String str2 = "Error insert message msg:%s talker:%s";
            Object[] objArr = new Object[2];
            objArr[0] = auVar;
            objArr[1] = auVar == null ? "-1" : auVar.field_talker;
            w.e(str, str2, objArr);
            return -1;
        }
        w.d("MicroMsg.MsgInfoStorage", "insert lockForSync[%b], message seq[%d]", Boolean.valueOf(this.uKB), Long.valueOf(auVar.field_msgSeq));
        String str3 = null;
        ay.b gm = ay.gm(auVar.gxF);
        if (gm != null) {
            str3 = gm.hmO;
        }
        if (o.fA(str3)) {
            w.d("MicroMsg.MsgInfoStorage", "msgCluster = %s", str3);
            if (auVar.field_type == 436207665) {
                w.w("MicroMsg.MsgInfoStorage", "protect:c2c msg should not here");
                return -1;
            }
            auVar.cH("notifymessage");
        }
        b RO = RO(auVar.field_talker);
        if (RO == null) {
            com.tencent.mm.plugin.report.c.oTb.a(111, 249, 1, false);
            w.e("MicroMsg.MsgInfoStorage", "Error insert message getTableByTalker failed. talker:%s", auVar.field_talker);
            return -1;
        }
        RO.aKj();
        auVar.x(RO.hFg);
        Assert.assertTrue(String.format("check table name from id:%d table:%s getTableNameByLocalId:%s", new Object[]{Long.valueOf(auVar.field_msgId), RO, eC(auVar.field_msgId)}), RO.name.equals(eC(auVar.field_msgId)));
        if (auVar.field_msgSvrId != 0) {
            auVar.gxJ = 1;
            auVar.gtA = true;
        }
        for (e a : this.uKq) {
            if (!a.a(auVar, gm)) {
                w.e("MicroMsg.MsgInfoStorage", "Error dealMsgSource. talker:%s ,msgSouce:%s", auVar.field_talker, auVar.gxF);
                return -1;
            }
        }
        Z(auVar);
        if (RO.name.equals("message")) {
            auVar.field_talkerId = (int) RK(auVar.field_talker);
            auVar.gxp = true;
        }
        w.i("MicroMsg.MsgInfoStorage", "insert:%d talker:%s id:%d type:%d status:%d svrid:%d msgseq:%d flag:%d create:%d issend:%d lockforsync[%s,%d]", Long.valueOf(this.hnH.a(RO.name, "msgId", auVar.pv(), z)), auVar.field_talker, Long.valueOf(auVar.field_msgId), Integer.valueOf(auVar.field_type), Integer.valueOf(auVar.field_status), Long.valueOf(auVar.field_msgSvrId), Long.valueOf(auVar.field_msgSeq), Integer.valueOf(auVar.field_flag), Long.valueOf(auVar.field_createTime), Integer.valueOf(auVar.field_isSend), this.uKC, Long.valueOf(bg.aA(this.uKD)));
        if (this.hnH.a(RO.name, "msgId", auVar.pv(), z) == -1) {
            com.tencent.mm.plugin.report.c.oTb.a(111, 248, 1, false);
            w.e("MicroMsg.MsgInfoStorage", "insert failed svrid:%d ret:%d", Long.valueOf(auVar.field_msgSvrId), Long.valueOf(r10));
            return -1;
        }
        if (this.uKB && bg.aA(this.uKD) > 2000 && auVar.field_isSend == 1 && auVar.field_status == 1) {
            w.w("MicroMsg.MsgInfoStorage", "insert this fucking tag[%s] lockForSync too long:%d force to release Now.", this.uKC, Long.valueOf(bg.aA(this.uKD)));
            Af(this.uKC);
        }
        c.c cVar;
        if (this.uKB) {
            Object obj;
            str3 = null;
            if (e.uyR != null) {
                str3 = e.uyR.F(auVar);
            }
            if (bg.mA(str3)) {
                obj = auVar.field_talker;
            } else {
                str = str3;
            }
            cVar = null;
            if (this.uKA.containsKey(obj)) {
                cVar = (c.c) this.uKA.get(obj);
            }
            if (cVar == null) {
                cVar = new c.c(auVar.field_talker, "insert", auVar);
            } else {
                cVar.nyP.add(auVar);
            }
            if (c.c.O(auVar)) {
                cVar.nyQ++;
            }
            cVar.nyR++;
            this.uKA.put(obj, cVar);
        } else {
            cVar = new c.c(auVar.field_talker, "insert", auVar);
            if (c.c.O(auVar)) {
                cVar.nyQ = 1;
            }
            cVar.nyR = 1;
            doNotify();
            a(cVar);
        }
        return auVar.field_msgId;
    }

    public final int cB(long j) {
        ce cA = cA(j);
        String str = cA.field_talker;
        this.uKy.e((int) (bg.Ny() / 86400), cA.field_msgSvrId, cA.field_createTime / 1000);
        int delete = this.hnH.delete(eC(j), "msgId=?", new String[]{String.valueOf(j)});
        if (delete != 0) {
            Qr("delete_id " + j);
            c.c cVar = new c.c(str, "delete", 1);
            cVar.nyT = j;
            cVar.kbc = cA.field_bizChatId;
            a(cVar);
        } else {
            com.tencent.mm.plugin.report.c.oTb.a(111, 245, 1, false);
        }
        return delete;
    }

    public final List<au> Al(String str) {
        List<au> list = null;
        Cursor a = this.hnH.a("select * from " + str, null, 2);
        if (a != null) {
            if (a.moveToFirst()) {
                list = new ArrayList();
                do {
                    au auVar = new au();
                    auVar.b(a);
                    list.add(auVar);
                } while (a.moveToNext());
            }
            a.close();
        }
        return list;
    }

    public final long D(String str, long j) {
        String str2 = "select createTime from " + AB(str) + " where msgId = " + j;
        long j2 = 0;
        Cursor a = this.hnH.a(str2, null, 2);
        if (a.moveToFirst()) {
            j2 = a.getLong(0);
        }
        a.close();
        return j2;
    }

    public final List<au> c(String str, long j, boolean z) {
        if (str == null || str.length() == 0) {
            w.e("MicroMsg.MsgInfoStorage", new StringBuilder("getImgMessage fail, argument is invalid, limit = 10").toString());
            return null;
        }
        long D = D(str, j);
        if (D == 0) {
            w.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, msg is null");
            return null;
        }
        String str2;
        List<au> arrayList = new ArrayList();
        if (z) {
            str2 = "select * from " + AB(str) + " where" + RJ(str) + "AND type IN (3,39,13,43,62,44,268435505) AND " + "createTime > " + D + "  order by createTime ASC limit 10";
        } else {
            str2 = "select * from " + AB(str) + " where" + RJ(str) + "AND type IN (3,39,13,43,62,44,268435505) AND " + "createTime < " + D + "  order by createTime DESC limit 10";
        }
        Cursor a = this.hnH.a(str2, null, 2);
        while (a.moveToNext()) {
            au auVar = new au();
            auVar.b(a);
            arrayList.add(auVar);
        }
        if (!z) {
            Collections.reverse(arrayList);
        }
        a.close();
        return arrayList;
    }

    public final Cursor E(String str, int i, int i2) {
        if (str == null || str.length() == 0) {
            w.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid");
            return null;
        }
        return this.hnH.a("select * from ( select * from " + AB(str) + " where" + RJ(str) + " AND type IN (3,39,13,43,62,44,268435505)  order by " + "createTime DESC limit " + i2 + " OFFSET " + i + ") order by createTime ASC ", null, 2);
    }

    public final Cursor e(String str, long j, long j2) {
        if (str == null || str.length() == 0) {
            w.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid");
            return null;
        }
        return this.hnH.a("select * from " + AB(str) + " where" + RJ(str) + "AND type IN (3,39,13,43,62,44,268435505) AND " + "createTime >= " + j + " AND createTime< " + j2 + " order by createTime ASC", null, 2);
    }

    public final Cursor Am(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (str == null || str.length() == 0) {
            w.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid");
            return null;
        }
        String AB = AB(str);
        Cursor a = this.hnH.a("select * from " + AB + " " + RM(AB) + " where" + RJ(str) + "AND type IN (3,39,13,43,62,44,49,268435505)  order by " + "createTime", null, 0);
        w.d("MicroMsg.MsgInfoStorage", "all time: %d, sql: %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), AB);
        return a;
    }

    public final Cursor bf(String str, int i) {
        if (str == null || str.length() == 0) {
            w.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid");
            return null;
        }
        return this.hnH.a("select * from " + AB(str) + " where" + RJ(str) + " AND type = 49  order by createTime" + " DESC limit " + i + " OFFSET 0", null, 2);
    }

    public final Cursor bg(String str, int i) {
        if (str == null || str.length() == 0) {
            w.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid");
            return null;
        }
        StringBuilder append = new StringBuilder("select * from ").append(AB(str)).append(" where").append(RJ(str)).append(" AND ");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" (type = 49");
        stringBuilder.append(" or type = 553648177").append(") ");
        return this.hnH.a(append.append(stringBuilder.toString()).append("  order by createTime DESC limit ").append(i).append(" OFFSET 0").toString(), null, 2);
    }

    public final void b(String str, String str2, String[] strArr) {
        String str3 = "SELECT msgSvrId,createTime FROM " + str + " WHERE createTime > " + ((bg.Ny() - 172800) * 1000);
        if (!bg.mA(str2)) {
            str3 = str3 + " AND " + str2;
        }
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        Cursor a = this.hnH.a(str3, strArr, 2);
        if (a.moveToFirst()) {
            do {
                long j = a.getLong(1) / 1000;
                arrayList.add(Integer.valueOf(a.getInt(0)));
                arrayList2.add(Long.valueOf(j));
            } while (a.moveToNext());
            this.uKy.i(arrayList, arrayList2);
        }
        a.close();
    }

    public final boolean cC(long j) {
        return this.uKy.eA(j);
    }

    public final void An(String str) {
        b(str, "", null);
        if (this.hnH.eE(str, "delete from " + str)) {
            Qr("delete_all " + str);
        } else {
            com.tencent.mm.plugin.report.c.oTb.a(111, 247, 1, false);
        }
    }

    public final int E(String str, long j) {
        ce x = x(str, j);
        this.uKy.e((int) (bg.Ny() / 86400), x.field_msgSvrId, x.field_createTime / 1000);
        int delete = this.hnH.delete(AB(str), "msgSvrId=?", new String[]{String.valueOf(j)});
        if (delete != 0) {
            doNotify();
            a(new c.c(str, "delete", 1));
        } else {
            com.tencent.mm.plugin.report.c.oTb.a(111, 246, 1, false);
        }
        return delete;
    }

    public final int Ao(String str) {
        w.w("MicroMsg.MsgInfoStorage", "deleteByTalker :%s  stack:%s", str, ah.bJo());
        b(AB(str), RJ(str), null);
        int delete = this.hnH.delete(AB(str), RJ(str), null);
        if (delete != 0) {
            Qr("delete_talker " + str);
            c.c cVar = new c.c(str, "delete", delete);
            cVar.nyT = -1;
            a(cVar);
        }
        return delete;
    }

    public final int F(String str, long j) {
        String str2 = RJ(str) + " and createTime <= " + j;
        b(AB(str), str2, null);
        int delete = this.hnH.delete(AB(str), str2, null);
        if (delete != 0) {
            Qr("delete_talker " + str);
            c.c cVar = new c.c(str, "delete", delete);
            cVar.nyT = -1;
            a(cVar);
        }
        return delete;
    }

    public final int bh(String str, int i) {
        w.w("MicroMsg.MsgInfoStorage", "deleteByTalkerFrom :%s  :%d stack:%s", str, Integer.valueOf(i), ah.bJo());
        Assert.assertTrue(str.equals(x(str, (long) i).field_talker));
        b(AB(str), "createTime<=? AND" + RJ(str), new String[]{r0.field_createTime});
        int delete = this.hnH.delete(AB(str), "createTime<=? AND" + RJ(str), new String[]{r0.field_createTime});
        if (delete != 0) {
            doNotify();
            a(new c.c(str, "delete", delete));
        }
        return delete;
    }

    public final boolean Ap(String str) {
        w.w("MicroMsg.MsgInfoStorage", "deleteMessageEndByName nameTag:%s  stack:%s", str, ah.bJo());
        b(AB(str), " talker like '%" + str + "'", null);
        boolean eE = this.hnH.eE(AB(str), "delete from " + AB(str) + " where talker like '%" + str + "'");
        if (eE) {
            doNotify();
        }
        return eE;
    }

    public final Cursor bi(String str, int i) {
        Assert.assertTrue(str.equals(x(str, (long) i).field_talker));
        return this.hnH.query(AB(str), null, "createTime<=? AND" + RJ(str), new String[]{r5.field_createTime}, null, null, null);
    }

    public final void a(long j, au auVar) {
        if (auVar.bMf()) {
            if (o.fA(RL(auVar.gxF))) {
                w.d("MicroMsg.MsgInfoStorage", "msgCluster = %s", RL(auVar.gxF));
                auVar.cH("notifymessage");
            }
        }
        Z(auVar);
        if (this.hnH.update(eC(j), auVar.pv(), "msgId=?", new String[]{String.valueOf(j)}) != 0) {
            doNotify();
            a(new c.c(auVar.field_talker, "update", auVar));
            return;
        }
        com.tencent.mm.plugin.report.c.oTb.a(111, 244, 1, false);
    }

    public final void M(au auVar) {
        if (auVar != null && auVar.field_status != 4) {
            auVar.dv(4);
            String eC = eC(auVar.field_msgId);
            if (eC != null && eC.length() > 0) {
                if (this.hnH.update(eC, auVar.pv(), "msgId=?", new String[]{auVar.field_msgId}) != 0) {
                    doNotify();
                    a(new c.c(auVar.field_talker, "update", auVar, -1));
                }
            }
        }
    }

    public final void b(long j, au auVar) {
        Assert.assertTrue("no talker set when update by svrid", bg.mz(auVar.field_talker).length() > 0);
        if (auVar.bMf()) {
            if (o.fA(RL(auVar.gxF))) {
                w.d("MicroMsg.MsgInfoStorage", "msgCluster = %s", RL(auVar.gxF));
                auVar.cH("notifymessage");
            }
        }
        Z(auVar);
        if (this.hnH.update(AB(auVar.field_talker), auVar.pv(), "msgSvrId=?", new String[]{String.valueOf(j)}) != 0) {
            doNotify();
            a(new c.c(auVar.field_talker, "update", auVar));
            return;
        }
        com.tencent.mm.plugin.report.c.oTb.a(111, 243, 1, false);
    }

    public final int Aq(String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadInfo.STATUS, Integer.valueOf(4));
        int update = this.hnH.update(AB(str), contentValues, RJ(str) + "AND isSend=? AND status" + "!=? ", new String[]{str, "0", "4"});
        if (update != 0) {
            doNotify();
            a(new c.c(str, "update", null));
        }
        return update;
    }

    public final int N(au auVar) {
        int i = 0;
        if (auVar != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("content", auVar.field_content);
            contentValues.put(DownloadInfo.STATUS, Integer.valueOf(auVar.field_status));
            i = this.hnH.update(eC(auVar.field_msgId), contentValues, "msgId=?", new String[]{String.valueOf(auVar.field_msgId)});
            if (i != 0) {
                doNotify();
                a(new c.c(auVar.field_talker, "update", auVar));
            }
        }
        return i;
    }

    public final Cursor Ar(String str) {
        return this.hnH.query(AB(str), null, RJ(str), null, null, null, "createTime ASC ");
    }

    public final Cursor f(String str, int i, long j) {
        return this.hnH.a("SELECT * FROM " + AB(str) + " WHERE" + RJ(str) + " AND createTime <= " + j + " order by createTime ASC limit " + i, null, 0);
    }

    public final Cursor cO(String str, String str2) {
        return this.hnH.a(("SELECT * FROM " + AB(str) + " WHERE" + RJ(str) + "AND content LIKE '%" + str2 + "%' AND type = 1") + " ORDER BY createTime DESC", null, 0);
    }

    public final Cursor bj(String str, int i) {
        w.i("MicroMsg.MsgInfoStorage", "summerbadcr getInitCursor1 getCursor talk:%s limitCount:%d [%s]", str, Integer.valueOf(i), "SELECT * FROM ( SELECT * FROM " + AB(str) + " WHERE" + RJ(str) + "ORDER BY createTime DESC LIMIT " + i + ") ORDER BY createTime ASC");
        return this.hnH.a("SELECT * FROM ( SELECT * FROM " + AB(str) + " WHERE" + RJ(str) + "ORDER BY createTime DESC LIMIT " + i + ") ORDER BY createTime ASC", null, 0);
    }

    public final Cursor g(String str, int i, long j) {
        w.i("MicroMsg.MsgInfoStorage", "summerbadcr getInitCursor2 getCursor talk:%s limitCount:%d [%s]", str, Integer.valueOf(i), "SELECT * FROM ( SELECT * FROM ( SELECT * FROM " + AB(str) + " WHERE" + RJ(str) + "ORDER BY createTime DESC LIMIT " + i + ") ORDER BY createTime ASC ) WHERE createTime" + " <= " + j);
        return this.hnH.a("SELECT * FROM ( SELECT * FROM ( SELECT * FROM " + AB(str) + " WHERE" + RJ(str) + "ORDER BY createTime DESC LIMIT " + i + ") ORDER BY createTime ASC ) WHERE createTime" + " <= " + j, null, 0);
    }

    public final Cursor As(String str) {
        return this.hnH.query(AB(str), null, "isSend=? AND" + RJ(str) + "AND status!=?", new String[]{"0", "4"}, null, null, null);
    }

    public final Cursor bk(String str, int i) {
        return this.hnH.query(AB(str), null, "isSend=? AND" + RJ(str) + "AND status!=?  order by msgId" + " DESC limit " + i, new String[]{"0", "4"}, null, null, null);
    }

    public final Cursor aKf() {
        return this.hnH.query("message", new String[]{"talker", "count(*) as unReadCount"}, "isSend=? AND status!=?", new String[]{"0", "4"}, "talker", null, null);
    }

    public final au.c At(String str) {
        au.c cVar = (au.c) this.uKs.get(Integer.valueOf(str.hashCode()));
        if (cVar != null) {
            return cVar;
        }
        cVar = au.c.RH(str);
        this.uKs.k(Integer.valueOf(str.hashCode()), cVar);
        return cVar;
    }

    public final d Au(String str) {
        d dVar = (d) this.uKt.get(Integer.valueOf(str.hashCode()));
        if (dVar != null) {
            return dVar;
        }
        dVar = d.RI(str);
        this.uKt.k(Integer.valueOf(str.hashCode()), dVar);
        return dVar;
    }

    public final a Av(String str) {
        a aVar = null;
        if (bg.mA(str) || this.uKu == null) {
            w.e("MicroMsg.MsgInfoStorage", "input text null ???? %B", Boolean.valueOf(bg.mA(str)));
            w.e("MicroMsg.MsgInfoStorage", "[arthurdan.FriendContentCrash] Fatal error!!! cachesForFriend is null!");
        } else {
            aVar = (a) this.uKu.get(Integer.valueOf(str.hashCode()));
        }
        if (aVar == null) {
            aVar = a.RF(str);
            if (this.uKu != null) {
                this.uKu.k(Integer.valueOf(bg.ap(str, "").hashCode()), aVar);
            }
        }
        return aVar;
    }

    public final au.b Aw(String str) {
        au.b bVar = (au.b) this.uKv.get(Integer.valueOf(str.hashCode()));
        if (bVar != null) {
            return bVar;
        }
        bVar = au.b.RG(str);
        this.uKv.k(Integer.valueOf(str.hashCode()), bVar);
        return bVar;
    }

    public final Cursor aKg() {
        boolean z;
        if (this.uKr.size() > 0) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        return this.hnH.query(((b) this.uKr.get(0)).name, null, "msgId=?", new String[]{"-1"}, null, null, null);
    }

    public final int Ax(String str) {
        int i = 0;
        if (Ay(str)) {
            int RC = this.uKo.RC(str);
            if (RC > 0) {
                w.i("MicroMsg.MsgInfoStorage", "getMsgCount conversationStorage.getMsgCountByUsername count:%d", Integer.valueOf(RC));
                return RC;
            }
            w.i("MicroMsg.MsgInfoStorage", "getMsgCount contactMsgCount is 0 ,go normal %s", str);
        } else {
            if ("appbrandmessage".equals(AB(str))) {
                Cursor a = this.hnH.a("SELECT COUNT(*) FROM " + AB(str) + " WHERE" + RJ(str), null, 0);
                if (a.moveToLast()) {
                    i = a.getInt(0);
                }
                a.close();
                return i;
            }
        }
        return Az(str);
    }

    public final boolean Ay(String str) {
        return "message".equals(AB(str));
    }

    public final int Az(String str) {
        int i;
        Cursor a = this.hnH.a("SELECT COUNT(*) FROM " + AB(str) + " " + (this.uKn ? "INDEXED BY messageTalkerIdStatusIndex" : "INDEXED BY messageTalkerStatusIndex") + " WHERE" + RJ(str), null, 2);
        if (a.moveToFirst()) {
            i = a.getInt(0);
        } else {
            i = 0;
        }
        a.close();
        return i;
    }

    private String RM(String str) {
        if (str == null || !str.equals("message")) {
            return "";
        }
        if (this.uKn) {
            return "INDEXED BY messageTaklerIdTypeCreateTimeIndex";
        }
        return "INDEXED BY messageCreateTaklerTypeTimeIndex";
    }

    public final int bl(String str, int i) {
        int i2 = 0;
        Cursor a = this.hnH.a("SELECT COUNT(*) FROM " + AB(str) + " WHERE" + RJ(str) + "AND type = " + i, null, 2);
        if (a.moveToFirst()) {
            i2 = a.getInt(0);
        }
        a.close();
        return i2;
    }

    public final int f(String str, long j, long j2) {
        int i = 0;
        Cursor a = this.hnH.a("SELECT COUNT(*) FROM " + AB(str) + " WHERE" + RJ(str) + "AND type = 50" + " AND createTime >= " + j + " AND createTime <= " + j2 + " LIMIT 1", null, 2);
        if (a.moveToFirst()) {
            i = a.getInt(0);
        }
        a.close();
        return i;
    }

    public final int AA(String str) {
        int i = 0;
        StringBuilder stringBuilder = new StringBuilder("SELECT COUNT(*) FROM ");
        String str2 = "username == null";
        boolean z = str != null && str.length() > 0;
        Assert.assertTrue(str2, z);
        String str3 = RO(str).name;
        Cursor a = this.hnH.a(stringBuilder.append(str3 + "  indexed by  " + str3 + "TalkerTypeIndex ").append(" WHERE talker= '").append(bg.my(str)).append("' AND type IN (3,39,13,43,62,44,268435505)").toString(), null, 2);
        if (a.moveToFirst()) {
            i = a.getInt(0);
        }
        a.close();
        return i;
    }

    public final int G(String str, long j) {
        int i = 0;
        ce cA = cA(j);
        if (cA.field_msgId == 0) {
            w.e("MicroMsg.MsgInfoStorage", "getCountEarlyThan fail, msg does not exist");
        } else {
            String AB = AB(str);
            Cursor a = this.hnH.a("SELECT COUNT(*) FROM " + AB + " " + RM(AB) + " WHERE " + RJ(str) + "AND type IN (3,39,13,43,62,44,268435505) AND " + "createTime < " + cA.field_createTime, null, 2);
            if (a.moveToFirst()) {
                i = a.getInt(0);
            }
            a.close();
        }
        return i;
    }

    public final String H(String str, long j) {
        String str2 = null;
        int i = 0;
        ce cA = cA(j);
        if (cA.field_msgId == 0) {
            w.e("MicroMsg.MsgInfoStorage", "getCountEarlyThan fail, msg does not exist");
        } else {
            String AB = AB(str);
            Cursor a = this.hnH.a("EXPLAIN QUERY PLAN SELECT COUNT(*) FROM " + AB + " " + RM(AB) + " WHERE" + RJ(str) + "AND type IN (3,39,13,43,62,44,268435505) AND " + "createTime < " + cA.field_createTime, null, 0);
            str2 = "";
            if (a.moveToFirst()) {
                while (i < a.getColumnCount()) {
                    str2 = str2 + a.getString(i) + " ";
                    i++;
                }
            }
            a.close();
        }
        return str2;
    }

    public final String aKh() {
        return "type IN (3,39,13,43,62,44,268435505)";
    }

    public final String aKi() {
        return "type IN (3,39,13,43,62,44,49,268435505)";
    }

    public final String AB(String str) {
        String str2 = "username == null";
        boolean z = str != null && str.length() > 0;
        Assert.assertTrue(str2, z);
        return RO(str).name;
    }

    private String RN(String str) {
        boolean z = str != null && str.length() > 0;
        Assert.assertTrue(z);
        for (e QE : this.uKq) {
            String QE2 = QE.QE(str);
            if (!bg.mA(QE2)) {
                return QE2;
            }
        }
        return "message";
    }

    private b RO(String str) {
        boolean z;
        boolean z2 = true;
        String str2 = "username == null";
        if (str == null || str.length() <= 0) {
            z = false;
        } else {
            z = true;
        }
        Assert.assertTrue(str2, z);
        str2 = RN(str);
        String str3 = "tableName == null";
        if (str2 == null || str2.length() <= 0) {
            z2 = false;
        }
        Assert.assertTrue(str3, z2);
        for (int i = 0; i < this.uKr.size(); i++) {
            if (str2.equals(((b) this.uKr.get(i)).name)) {
                return (b) this.uKr.get(i);
            }
        }
        Assert.assertTrue("no table match", false);
        return null;
    }

    public final boolean cD(long j) {
        for (int i = 0; i < this.uKr.size(); i++) {
            if (((b) this.uKr.get(i)).cF(j)) {
                return true;
            }
        }
        return false;
    }

    private String eC(long j) {
        if (j == 0 || j == -1) {
            return null;
        }
        au.eB(j);
        for (int i = 0; i < this.uKr.size(); i++) {
            if (((b) this.uKr.get(i)).cF(j)) {
                return ((b) this.uKr.get(i)).name;
            }
        }
        Assert.assertTrue(String.format("getTableNameByLocalId failed:%d", new Object[]{Long.valueOf(j)}), false);
        return null;
    }

    public final long AC(String str) {
        String str2 = "select createTime from message where" + RJ(str) + "order by createTime LIMIT 1 OFFSET 0";
        w.d("MicroMsg.MsgInfoStorage", "get first message create time: " + str2);
        Cursor a = this.hnH.a(str2, null, 2);
        if (a == null) {
            w.e("MicroMsg.MsgInfoStorage", "get first message create time failed: " + str);
            return -1;
        } else if (a.moveToFirst()) {
            long j = a.getLong(0);
            a.close();
            return j;
        } else {
            a.close();
            return -1;
        }
    }

    public final long AD(String str) {
        String str2 = "select createTime from message where" + RJ(str) + "order by createTime DESC LIMIT 1 ";
        w.d("MicroMsg.MsgInfoStorage", "get last message create time: " + str2);
        Cursor a = this.hnH.a(str2, null, 2);
        if (a == null) {
            w.e("MicroMsg.MsgInfoStorage", "get last message create time failed " + str);
            return -1;
        } else if (a.moveToFirst()) {
            long j = a.getLong(0);
            a.close();
            return j;
        } else {
            a.close();
            return -1;
        }
    }

    public final long AE(String str) {
        if (bg.mA(str)) {
            return 0;
        }
        String str2 = "select msgSeq from message where" + RJ(str) + "order by msgSeq DESC LIMIT 1 ";
        w.i("MicroMsg.MsgInfoStorage", "summerbadcr get last message msgseq: " + str2);
        Cursor a = this.hnH.a(str2, null, 2);
        if (a == null) {
            w.e("MicroMsg.MsgInfoStorage", "summerbadcr get last message msgseq failed " + str);
            return 0;
        } else if (a.moveToFirst()) {
            long j = a.getLong(0);
            a.close();
            return j;
        } else {
            a.close();
            return 0;
        }
    }

    public final au I(String str, long j) {
        if (bg.mA(str)) {
            return null;
        }
        String str2 = "select * from message where" + RJ(str) + " and msgSeq > " + j + " order by msgSeq ASC LIMIT 1 ";
        w.i("MicroMsg.MsgInfoStorage", "summerbadcr getNewerMsgByMsgSeq: " + str2);
        Cursor a = this.hnH.a(str2, null, 0);
        if (a == null) {
            w.e("MicroMsg.MsgInfoStorage", "summerbadcr getNewerMsgByMsgSeq failed " + str);
            return null;
        } else if (a.moveToFirst()) {
            au auVar = new au();
            auVar.b(a);
            return auVar;
        } else {
            a.close();
            return null;
        }
    }

    public final au AF(String str) {
        if (bg.mA(str)) {
            return null;
        }
        w.i("MicroMsg.MsgInfoStorage", "summerbadcr getLastFaultMsg talker[%s], onlyCache[%b]", str, Boolean.valueOf(false));
        Long l = (Long) this.uKx.get(str);
        au auVar;
        if (l == null || l.longValue() <= 0) {
            w.i("MicroMsg.MsgInfoStorage", "summerbadcr getLastFaultMsg not hit cache");
            auVar = new au();
            long currentTimeMillis = System.currentTimeMillis();
            Cursor a = this.hnH.a("SELECT * FROM " + AB(str) + " WHERE" + RJ(str) + "AND flag %2 = 1  ORDER BY msgSeq" + " DESC LIMIT 1 ", null, 2);
            w.d("MicroMsg.MsgInfoStorage", "summerbadcr getLastFaultMsg take %dms, tid[%d]", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Long.valueOf(Thread.currentThread().getId()));
            if (a == null) {
                w.e("MicroMsg.MsgInfoStorage", "summerbadcr getLastFaultMsg failed " + str);
                return auVar;
            }
            if (a.moveToFirst()) {
                auVar.b(a);
            }
            a.close();
            this.uKx.k(str, Long.valueOf(auVar.field_msgId));
            return auVar;
        }
        w.i("MicroMsg.MsgInfoStorage", "summerbadcr getLastFaultMsg hit cache msgid[%d]", Long.valueOf(l.longValue()));
        auVar = cA(l.longValue());
        if ((auVar.field_flag & 1) != 0) {
            return auVar;
        }
        this.uKx.remove(str);
        return null;
    }

    public final int g(String str, long j, long j2) {
        if (j2 >= j) {
            long j3 = j2;
            j2 = j;
            j = j3;
        }
        w.d("MicroMsg.MsgInfoStorage", "talker %s, get count fromCreateTime %d, toCreateTime %d", str, Long.valueOf(j2), Long.valueOf(j));
        String str2 = "SELECT COUNT(msgId) FROM " + AB(str) + " WHERE" + RJ(str) + "AND createTime >= " + j2 + " AND createTime <= " + j;
        w.d("MicroMsg.MsgInfoStorage", "get count sql: " + str2);
        Cursor a = this.hnH.a(str2, null, 2);
        if (a == null) {
            w.w("MicroMsg.MsgInfoStorage", "get count error, cursor is null");
            return 0;
        } else if (a.moveToFirst()) {
            w.d("MicroMsg.MsgInfoStorage", "result msg count %d", Integer.valueOf(a.getInt(0)));
            a.close();
            return a.getInt(0);
        } else {
            a.close();
            return 0;
        }
    }

    public final Cursor a(String str, long j, long j2, boolean z) {
        int i;
        if (j2 >= j) {
            long j3 = j2;
            j2 = j;
            j = j3;
        }
        StringBuilder append = new StringBuilder("SELECT * FROM ").append(AB(str)).append(" WHERE").append(RJ(str)).append("AND createTime >= ").append(j2).append(" AND createTime <= ").append(j).append(" AND isSend=");
        if (z) {
            i = 1;
        } else {
            i = 0;
        }
        String stringBuilder = append.append(i).append(" LIMIT 1").toString();
        w.d("MicroMsg.MsgInfoStorage", "get cursor: " + stringBuilder);
        return this.hnH.a(stringBuilder, null, 0);
    }

    public final Cursor h(String str, long j, long j2) {
        if (j2 >= j) {
            long j3 = j2;
            j2 = j;
            j = j3;
        }
        String str2 = "SELECT * FROM " + AB(str) + " WHERE" + RJ(str) + "AND createTime >= " + j2 + " AND createTime <= " + j + " ORDER BY createTime ASC ";
        w.d("MicroMsg.MsgInfoStorage", "get cursor: " + str2);
        return this.hnH.a(str2, null, 0);
    }

    public final Cursor a(String str, long j, long j2, int i) {
        if (j2 == 0) {
            String str2 = "SELECT * FROM " + AB(str) + " WHERE" + RJ(str) + "AND createTime > " + j + " ORDER BY createTime ASC  LIMIT 50" + " OFFSET " + i;
            w.d("MicroMsg.MsgInfoStorage", "get cursor: " + str2);
            return this.hnH.a(str2, null, 0);
        }
        if (j2 >= j) {
            long j3 = j2;
            j2 = j;
            j = j3;
        }
        str2 = "SELECT * FROM " + AB(str) + " WHERE" + RJ(str) + "AND createTime > " + j2 + " AND createTime < " + j + " ORDER BY createTime ASC  LIMIT 50" + " OFFSET " + i;
        w.d("MicroMsg.MsgInfoStorage", "get cursor: " + str2);
        return this.hnH.a(str2, null, 0);
    }

    public final int i(String str, long j, long j2) {
        int i = 0;
        if (j2 >= j) {
            long j3 = j2;
            j2 = j;
            j = j3;
        }
        Cursor a = this.hnH.a("SELECT * FROM " + AB(str) + " WHERE" + RJ(str) + "AND createTime > " + j2 + " AND createTime < " + j, null, 2);
        if (a.moveToFirst()) {
            i = a.getInt(0);
        }
        a.close();
        return i;
    }

    public final Cursor j(String str, long j, long j2) {
        if (j2 >= j) {
            long j3 = j2;
            j2 = j;
            j = j3;
        }
        String str2 = "SELECT * FROM " + AB(str) + " WHERE" + RJ(str) + "AND createTime >= " + j2 + " AND createTime <= " + j;
        w.d("MicroMsg.MsgInfoStorage", "get cursor: " + str2);
        return this.hnH.a(str2, null, 0);
    }

    public final Cursor B(String str, String str2, int i) {
        w.d("MicroMsg.MsgInfoStorage", "getInitCursorByMember getCursor talk:%s member:%s,limitCount:%d [%s]", str, str2, Integer.valueOf(i), " SELECT * FROM " + AB(str) + " WHERE" + RJ(str) + "AND content LIKE '" + str2 + "%' ORDER BY createTime DESC LIMIT " + i);
        return this.hnH.a(" SELECT * FROM " + AB(str) + " WHERE" + RJ(str) + "AND content LIKE '" + str2 + "%' ORDER BY createTime DESC LIMIT " + i, null, 0);
    }

    public final Cursor bm(String str, int i) {
        w.d("MicroMsg.MsgInfoStorage", "[getInitCursorBySelf] getCursor talk:%s,limitCount:%d [%s]", str, Integer.valueOf(i), " SELECT * FROM " + AB(str) + " WHERE" + RJ(str) + "AND isSend=1" + " ORDER BY createTime DESC LIMIT " + i);
        return this.hnH.a(" SELECT * FROM " + AB(str) + " WHERE" + RJ(str) + "AND isSend=1" + " ORDER BY createTime DESC LIMIT " + i, null, 0);
    }

    public final long J(String str, long j) {
        w.d("MicroMsg.MsgInfoStorage", "get up inc create time, talker %s, fromCreateTime %d, targetIncCount %d", str, Long.valueOf(j), Integer.valueOf(18));
        w.d("MicroMsg.MsgInfoStorage", "get up inc msg create time sql: %s", "SELECT createTime FROM " + AB(str) + " WHERE" + RJ(str) + "AND createTime < " + j + " ORDER BY createTime DESC  LIMIT 18");
        Cursor a = this.hnH.a(r0, null, 0);
        if (a == null) {
            w.w("MicroMsg.MsgInfoStorage", "get inc msg create time error, cursor is null");
            return j;
        } else if (a.moveToLast()) {
            w.d("MicroMsg.MsgInfoStorage", "result msg create time %d", Long.valueOf(a.getLong(0)));
            a.close();
            return a.getLong(0);
        } else {
            a.close();
            w.w("MicroMsg.MsgInfoStorage", "get result fail");
            return j;
        }
    }

    public final boolean a(long j, String str, String str2, String str3) {
        return this.hnH.eE(null, "UPDATE " + RN(str) + " SET transContent = '" + bg.my(str2) + "', transBrandWording = '" + bg.my(bg.mz(str3)) + "' WHERE msgId = " + j);
    }

    public final long K(String str, long j) {
        w.d("MicroMsg.MsgInfoStorage", "get down inc create time, talker %s, fromCreateTime %d, targetIncCount %d", str, Long.valueOf(j), Integer.valueOf(18));
        w.d("MicroMsg.MsgInfoStorage", "get down inc msg create time sql: %s", "SELECT createTime FROM " + AB(str) + " WHERE" + RJ(str) + "AND createTime > " + j + " ORDER BY createTime ASC  LIMIT 18");
        Cursor a = this.hnH.a(r0, null, 0);
        if (a == null) {
            w.w("MicroMsg.MsgInfoStorage", "get down inc msg create time error, cursor is null");
            return j;
        } else if (a.moveToLast()) {
            w.d("MicroMsg.MsgInfoStorage", "result msg create time %d", Long.valueOf(a.getLong(0)));
            a.close();
            return a.getLong(0);
        } else {
            a.close();
            w.w("MicroMsg.MsgInfoStorage", "get result fail");
            return j;
        }
    }

    public final au[] bn(String str, int i) {
        if (str == null || str.length() == 0 || i <= 0) {
            w.e("MicroMsg.MsgInfoStorage", "getLastMsgList, invalid argument, talker = " + str + ", limit = " + i);
            return null;
        }
        Cursor a = this.hnH.a("select * from " + AB(str) + " where" + RJ(str) + "order by createTime DESC limit " + i, null, 2);
        if (a.moveToFirst()) {
            ArrayList arrayList = new ArrayList();
            do {
                au auVar = new au();
                auVar.b(a);
                arrayList.add(auVar);
            } while (a.moveToNext());
            a.close();
            w.d("MicroMsg.MsgInfoStorage", "getLastMsgList, talker = " + str + ", limit = " + i + ", count = " + arrayList.size());
            Collections.reverse(arrayList);
            return (au[]) arrayList.toArray(new au[arrayList.size()]);
        }
        w.w("MicroMsg.MsgInfoStorage", "getLastMsgList, cursor is empty");
        a.close();
        return null;
    }

    public final LinkedList<au> cQ(String str, String str2) {
        LinkedList<au> linkedList = null;
        Cursor a = this.hnH.a("message", null, "talker=? AND bizClientMsgId=?", new String[]{str, str2}, null, null, null, 2);
        if (a == null || !a.moveToFirst()) {
            w.e("MicroMsg.MsgInfoStorage", "getByBizClientMsgId fail");
        } else {
            linkedList = new LinkedList();
            do {
                au auVar = new au();
                auVar.b(a);
                linkedList.add(auVar);
            } while (a.moveToNext());
            a.close();
        }
        return linkedList;
    }

    public final void cE(long j) {
        this.uKy.a(0, j, 0, false);
    }
}
