package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.modelbiz.a.a;
import com.tencent.mm.modelbiz.a.j;
import com.tencent.mm.modelbiz.e;
import com.tencent.mm.plugin.messenger.foundation.a.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.c.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ay;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

public final class o extends e {
    public static final String[] gUx = new String[]{"CREATE TABLE IF NOT EXISTS bizchatmessage ( msgId INTEGER PRIMARY KEY, msgSvrId INTEGER , type INT, status INT, isSend INT, isShowTimer INTEGER, createTime INTEGER, talker TEXT, content TEXT, imgPath TEXT, reserved TEXT, lvbuffer BLOB, transContent TEXT, transBrandWording TEXT, bizChatId INTEGER DEFAULT -1, bizChatUserId TEXT ) ", "CREATE INDEX IF NOT EXISTS  bizmessageChatIdIndex ON bizchatmessage ( bizChatId )", "CREATE INDEX IF NOT EXISTS  bizmessageSvrIdIndex ON bizchatmessage ( msgSvrId )", "CREATE INDEX IF NOT EXISTS  bizmessageTalkerIndex ON bizchatmessage ( talker )", "CREATE INDEX IF NOT EXISTS  bizmessageTalerStatusIndex ON bizchatmessage ( talker,status )", "CREATE INDEX IF NOT EXISTS  bizmessageCreateTimeIndex ON bizchatmessage ( createTime )", "CREATE INDEX IF NOT EXISTS  bizmessageCreateTaklerTimeIndex ON bizchatmessage ( talker,createTime )", "CREATE INDEX IF NOT EXISTS  bizmessageBizChatIdTypeCreateTimeIndex ON bizchatmessage ( bizChatId,type,createTime )", "CREATE INDEX IF NOT EXISTS  bizmessageSendCreateTimeIndex ON bizchatmessage ( status,isSend,createTime )", "CREATE INDEX IF NOT EXISTS  bizchatmessageTalkerTypeIndex ON bizchatmessage ( talker,type )"};

    public o(c cVar) {
        super(cVar);
        a(aJZ(), "bizchatmessage");
        a(new b(16, "bizchatmessage", b.a(2500001, 3000000, 99000001, 102000000)));
    }

    public final String QE(String str) {
        boolean z = str != null && str.length() > 0;
        Assert.assertTrue(z);
        if (e.dr(str)) {
            return "bizchatmessage";
        }
        return null;
    }

    private static String ey(long j) {
        return " bizChatId= " + j + " ";
    }

    public final au ac(String str, long j) {
        if (bg.mA(str)) {
            return null;
        }
        au auVar = new au();
        Cursor a = aJZ().a("select * from " + AB(str) + " where" + ey(j) + "order by createTime DESC limit 1", null, 0);
        if (a.getCount() != 0) {
            a.moveToFirst();
            auVar.b(a);
        }
        a.close();
        return auVar;
    }

    public final List<au> g(String str, long j, int i) {
        List<au> arrayList = new ArrayList();
        Cursor a = aJZ().a("SELECT * FROM " + AB(str) + " WHERE" + ey(j) + "AND isSend = 0" + " ORDER BY createTime DESC LIMIT " + i, null, 0);
        if (a.moveToFirst()) {
            while (!a.isAfterLast()) {
                au auVar = new au();
                auVar.b(a);
                a.moveToNext();
                if (auVar.bMk()) {
                    arrayList.add(auVar);
                }
            }
        }
        a.close();
        return arrayList;
    }

    protected final boolean a(au auVar, ay.b bVar) {
        if (auVar == null) {
            w.w("MicroMsg.BizChatMessageStorage", "dealMsgSourceValue:message == null");
            return false;
        }
        auVar.A(-1);
        if (bVar != null) {
            if (e.dr(auVar.field_talker)) {
                if (bg.mA(bVar.hmT)) {
                    w.w("MicroMsg.BizChatMessageStorage", "EnterpriseChat msgSourceValue error: %s", auVar.gxF);
                    return false;
                }
                com.tencent.mm.modelbiz.a.c cVar = new com.tencent.mm.modelbiz.a.c();
                cVar.field_bizChatServId = bVar.hmT;
                cVar.field_brandUserName = auVar.field_talker;
                if (!bg.mA(bVar.hmU)) {
                    cVar.field_chatVersion = bg.getInt(bVar.hmU, -1);
                }
                if (!bg.mA(bVar.hmS)) {
                    cVar.field_chatType = bg.getInt(bVar.hmS, -1);
                }
                w.d("MicroMsg.BizChatMessageStorage", "bizchatId:%s,userId:%s", bVar.hmT, bVar.userId);
                cVar = com.tencent.mm.modelbiz.a.e.e(cVar);
                if (cVar != null) {
                    auVar.A(cVar.field_bizChatLocalId);
                    auVar.field_bizChatUserId = bg.mz(bVar.userId);
                    auVar.gxt = true;
                    if (bVar.hmW.equals("1")) {
                        auVar.dw(1);
                    }
                    if (!(auVar.field_isSend == 1 || bVar.userId == null)) {
                        if (bVar.userId.equals(com.tencent.mm.modelbiz.w.DL().iF(auVar.field_talker))) {
                            auVar.dw(1);
                        }
                    }
                    if (!bg.mA(bVar.userId)) {
                        j jVar = new j();
                        jVar.field_userId = bVar.userId;
                        jVar.field_userName = bVar.hmV;
                        jVar.field_brandUserName = auVar.field_talker;
                        com.tencent.mm.modelbiz.w.DL().c(jVar);
                    }
                } else {
                    w.w("MicroMsg.BizChatMessageStorage", "dealMsgSourceValue:bizChatInfo == null!");
                    return false;
                }
            } else if (!bg.mA(bVar.hmT)) {
                w.i("MicroMsg.BizChatMessageStorage", "is EnterpriseChat but contact not ready");
                return false;
            }
        }
        return true;
    }

    public final List<au> b(String str, long j, long j2, boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        if (str == null || str.length() == 0) {
            w.e("MicroMsg.BizChatMessageStorage", new StringBuilder("getImgMessage fail, argument is invalid, limit = 10").toString());
            return null;
        }
        long D = this.uyQ.D(str, j2);
        if (D == 0) {
            w.e("MicroMsg.BizChatMessageStorage", "getImgMessage fail, msg is null");
            return null;
        }
        String str2;
        List<au> arrayList = new ArrayList();
        if (z) {
            str2 = "select * from " + AB(str) + " INDEXED BY bizmessageBizChatIdTypeCreateTimeIndex  where" + ey(j) + "AND " + this.uyQ.aKh() + " AND createTime > " + D + "  order by createTime ASC limit 10";
        } else {
            str2 = "select * from " + AB(str) + " INDEXED BY bizmessageBizChatIdTypeCreateTimeIndex  where" + ey(j) + "AND " + this.uyQ.aKh() + " AND createTime < " + D + "  order by createTime DESC limit 10";
        }
        Cursor a = aJZ().a(str2, null, 0);
        if (a.moveToFirst()) {
            while (!a.isAfterLast()) {
                au auVar = new au();
                auVar.b(a);
                a.moveToNext();
                if (z) {
                    arrayList.add(auVar);
                } else {
                    arrayList.add(0, auVar);
                }
            }
        }
        a.close();
        w.i("MicroMsg.BizChatMessageStorage", "getBizChatImgVideoMessage spent : %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        return arrayList;
    }

    public final Cursor ad(String str, long j) {
        long currentTimeMillis = System.currentTimeMillis();
        if (str == null || str.length() == 0) {
            w.e("MicroMsg.BizChatMessageStorage", "getImgMessage fail, argument is invalid");
            return null;
        }
        Cursor a = aJZ().a("select * from " + AB(str) + "  INDEXED BY bizmessageBizChatIdTypeCreateTimeIndex  where" + ey(j) + "AND " + this.uyQ.aKi() + "  order by createTime", null, 0);
        w.d("MicroMsg.BizChatMessageStorage", "all time: %d, sql: %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), r1);
        return a;
    }

    public final Cursor b(String str, long j, int i, int i2) {
        System.currentTimeMillis();
        if (str == null || str.length() == 0) {
            w.e("MicroMsg.BizChatMessageStorage", "getImgMessage fail, argument is invalid");
            return null;
        }
        return aJZ().a("select * from ( select * from " + AB(str) + "  INDEXED BY bizmessageBizChatIdTypeCreateTimeIndex  where" + ey(j) + "AND " + this.uyQ.aKh() + " order by createTime DESC limit " + i2 + " OFFSET " + i + ") order by createTime ASC ", null, 0);
    }

    public final Cursor a(String str, long j, long j2, long j3) {
        if (str == null || str.length() == 0) {
            w.e("MicroMsg.BizChatMessageStorage", "getImgMessage fail, argument is invalid");
            return null;
        }
        return aJZ().a("select * from " + AB(str) + "  INDEXED BY bizmessageBizChatIdTypeCreateTimeIndex  where" + ey(j) + "AND " + this.uyQ.aKh() + " AND createTime >= " + j2 + " AND createTime< " + j3 + " order by createTime ASC", null, 0);
    }

    public final int ae(String str, long j) {
        w.w("MicroMsg.BizChatMessageStorage", "deleteByTalker :%s  stack:%s", str, ah.bJo());
        eH(AB(str), ey(j));
        int delete = aJZ().delete(AB(str), ey(j), null);
        if (delete != 0) {
            this.uyQ.Qr("delete_talker " + str);
            c.c cVar = new c.c(str, "delete", delete);
            cVar.nyT = -1;
            a(cVar);
        }
        return delete;
    }

    public final Cursor af(String str, long j) {
        return aJZ().query(AB(str), null, ey(j), null, null, null, "createTime ASC ");
    }

    public final Cursor h(String str, long j, int i) {
        w.d("MicroMsg.BizChatMessageStorage", "getBizInitCursor talker:%s, bizChatId:%s, limitCount:%s, sql:[%s]", str, Long.valueOf(j), Integer.valueOf(i), "SELECT * FROM ( SELECT * FROM " + AB(str) + " WHERE" + ey(j) + "ORDER BY createTime DESC LIMIT " + i + ") ORDER BY createTime ASC");
        return aJZ().a("SELECT * FROM ( SELECT * FROM " + AB(str) + " WHERE" + ey(j) + "ORDER BY createTime DESC LIMIT " + i + ") ORDER BY createTime ASC", null, 0);
    }

    public final int ag(String str, long j) {
        if (str == null) {
            w.w("MicroMsg.BizChatMessageStorage", "getBizMsgCountFromMsgTable talker:%s,bizChatId:%s", str, Long.valueOf(j));
            return -1;
        }
        a U = com.tencent.mm.modelbiz.w.DK().U(j);
        if (U.field_msgCount != 0) {
            return U.field_msgCount;
        }
        w.i("MicroMsg.BizChatMessageStorage", "geBiztMsgCount contactMsgCount is 0 ,go normal %s", str);
        return ah(str, j);
    }

    public final int ah(String str, long j) {
        int i = 0;
        w.v("MicroMsg.BizChatMessageStorage", "getBizMsgCountFromMsgTable sql:[%s]", "SELECT COUNT(*) FROM " + AB(str) + " WHERE " + ey(j));
        Cursor a = aJZ().a(r1, null, 0);
        if (a.moveToLast()) {
            i = a.getInt(0);
        }
        a.close();
        return i;
    }

    public final int ai(String str, long j) {
        int i = 0;
        Cursor a = aJZ().a("SELECT COUNT(*) FROM " + this.uyQ.AB(str) + " WHERE " + ey(j) + "AND " + this.uyQ.aKh(), null, 0);
        if (a.moveToLast()) {
            i = a.getInt(0);
        }
        a.close();
        return i;
    }

    public final int m(String str, long j, long j2) {
        int i = 0;
        ce cA = this.uyQ.cA(j2);
        if (cA.field_msgId == 0) {
            w.e("MicroMsg.BizChatMessageStorage", "getCountEarlyThan fail, msg does not exist");
        } else {
            Cursor a = aJZ().a("SELECT COUNT(*) FROM " + AB(str) + " INDEXED BY bizmessageBizChatIdTypeCreateTimeIndex  WHERE " + ey(j) + "AND " + this.uyQ.aKh() + " AND createTime < " + cA.field_createTime, null, 0);
            if (a.moveToLast()) {
                i = a.getInt(0);
            }
            a.close();
        }
        return i;
    }

    public final long aj(String str, long j) {
        String str2 = "select createTime from " + AB(str) + " where" + ey(j) + "order by createTime DESC LIMIT 1 ";
        w.d("MicroMsg.BizChatMessageStorage", "get last message create time: " + str2);
        Cursor a = aJZ().a(str2, null, 0);
        if (a == null) {
            w.e("MicroMsg.BizChatMessageStorage", "get last message create time failed " + str);
            return -1;
        } else if (a.moveToFirst()) {
            long j2 = a.getLong(0);
            a.close();
            return j2;
        } else {
            a.close();
            return -1;
        }
    }

    public final int b(String str, long j, long j2, long j3) {
        if (j3 >= j2) {
            long j4 = j3;
            j3 = j2;
            j2 = j4;
        }
        w.d("MicroMsg.BizChatMessageStorage", "talker %s, get count fromCreateTime %d, toCreateTime %d", str, Long.valueOf(j3), Long.valueOf(j2));
        String str2 = "SELECT COUNT(msgId) FROM " + AB(str) + " WHERE" + ey(j) + "AND createTime >= " + j3 + " AND createTime <= " + j2;
        w.d("MicroMsg.BizChatMessageStorage", "get count sql: " + str2);
        Cursor a = aJZ().a(str2, null, 0);
        if (a == null) {
            w.w("MicroMsg.BizChatMessageStorage", "get count error, cursor is null");
            return 0;
        } else if (a.moveToFirst()) {
            w.d("MicroMsg.BizChatMessageStorage", "result msg count %d", Integer.valueOf(a.getInt(0)));
            a.close();
            return a.getInt(0);
        } else {
            a.close();
            return 0;
        }
    }

    public final Cursor c(String str, long j, long j2, long j3) {
        if (j3 >= j2) {
            long j4 = j3;
            j3 = j2;
            j2 = j4;
        }
        String str2 = "SELECT * FROM " + AB(str) + " WHERE" + ey(j) + "AND createTime >= " + j3 + " AND createTime <= " + j2 + " ORDER BY createTime ASC ";
        w.d("MicroMsg.BizChatMessageStorage", "get cursor: " + str2);
        return aJZ().a(str2, null, 0);
    }

    public final long n(String str, long j, long j2) {
        w.d("MicroMsg.BizChatMessageStorage", "get up inc create time, talker %s, fromCreateTime %d, targetIncCount %d", str, Long.valueOf(j2), Integer.valueOf(18));
        w.d("MicroMsg.BizChatMessageStorage", "get up inc msg create time sql: %s", "SELECT createTime FROM " + AB(str) + " WHERE" + ey(j) + "AND createTime < " + j2 + " ORDER BY createTime DESC  LIMIT 18");
        Cursor a = aJZ().a(r0, null, 0);
        if (a == null) {
            w.w("MicroMsg.BizChatMessageStorage", "get inc msg create time error, cursor is null");
            return j2;
        } else if (a.moveToLast()) {
            w.d("MicroMsg.BizChatMessageStorage", "result msg create time %d", Long.valueOf(a.getLong(0)));
            a.close();
            return a.getLong(0);
        } else {
            a.close();
            w.w("MicroMsg.BizChatMessageStorage", "get result fail");
            return j2;
        }
    }

    public final long o(String str, long j, long j2) {
        w.d("MicroMsg.BizChatMessageStorage", "get down inc create time, talker %s, fromCreateTime %d, targetIncCount %d", str, Long.valueOf(j2), Integer.valueOf(18));
        w.d("MicroMsg.BizChatMessageStorage", "get down inc msg create time sql: %s", "SELECT createTime FROM " + AB(str) + " WHERE" + ey(j) + "AND createTime > " + j2 + " ORDER BY createTime ASC  LIMIT 18");
        Cursor a = aJZ().a(r0, null, 0);
        if (a == null) {
            w.w("MicroMsg.BizChatMessageStorage", "get down inc msg create time error, cursor is null");
            return j2;
        } else if (a.moveToLast()) {
            w.d("MicroMsg.BizChatMessageStorage", "result msg create time %d", Long.valueOf(a.getLong(0)));
            a.close();
            return a.getLong(0);
        } else {
            a.close();
            w.w("MicroMsg.BizChatMessageStorage", "get result fail");
            return j2;
        }
    }
}
