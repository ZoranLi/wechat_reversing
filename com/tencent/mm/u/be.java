package com.tencent.mm.u;

import android.content.ContentValues;
import android.database.Cursor;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.bj.g;
import com.tencent.mm.e.b.aj;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.ae;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import com.tencent.wcdb.FileUtils;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

public final class be extends j {
    public static final String[] gUx = new String[]{"CREATE TABLE IF NOT EXISTS readerappnews1 ( tweetid text  PRIMARY KEY , time long  , type int  , name text  , title text  , url text  , shorturl text  , longurl text  , pubtime long  , sourcename text  , sourceicon text  , istop int  , cover text  , digest text  , reserved1 int  , reserved2 long  , reserved3 text  , reserved4 text  ) ", "CREATE TABLE IF NOT EXISTS readerappweibo ( tweetid text  PRIMARY KEY , time long  , type int  , name text  , title text  , url text  , shorturl text  , longurl text  , pubtime long  , sourcename text  , sourceicon text  , istop int  , cover text  , digest text  , reserved1 int  , reserved2 long  , reserved3 text  , reserved4 text  ) ", "CREATE INDEX IF NOT EXISTS  readerapptime ON readerappnews1 ( time )", "CREATE INDEX IF NOT EXISTS  readerapptime ON readerappweibo ( time )"};
    public g hnH;

    public final java.util.List<com.tencent.mm.u.bd> t(java.lang.String r10, int r11) {
        /* JADX: method processing error */
/*
Error: java.util.NoSuchElementException
	at java.util.HashMap$HashIterator.nextNode(HashMap.java:1431)
	at java.util.HashMap$KeyIterator.next(HashMap.java:1453)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.applyRemove(BlockFinallyExtract.java:535)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.extractFinally(BlockFinallyExtract.java:175)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.processExceptionHandler(BlockFinallyExtract.java:79)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:51)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r9 = this;
        r4 = 1;
        r6 = 0;
        r5 = 0;
        r0 = r9.hnH;
        r1 = fe(r11);
        r2 = new java.lang.String[r4];
        r3 = "*";
        r2[r6] = r3;
        r3 = "reserved3=?";
        r4 = new java.lang.String[r4];
        r4[r6] = r10;
        r8 = 2;
        r6 = r5;
        r7 = r5;
        r1 = r0.a(r1, r2, r3, r4, r5, r6, r7, r8);
        if (r1 == 0) goto L_0x0043;
    L_0x0020:
        r0 = r1.moveToFirst();	 Catch:{ Exception -> 0x0049, all -> 0x0063 }
        if (r0 == 0) goto L_0x0043;	 Catch:{ Exception -> 0x0049, all -> 0x0063 }
    L_0x0026:
        r0 = new java.util.ArrayList;	 Catch:{ Exception -> 0x0049, all -> 0x0063 }
        r0.<init>();	 Catch:{ Exception -> 0x0049, all -> 0x0063 }
    L_0x002b:
        r2 = new com.tencent.mm.u.bd;	 Catch:{ Exception -> 0x0049, all -> 0x0063 }
        r2.<init>();	 Catch:{ Exception -> 0x0049, all -> 0x0063 }
        r2.b(r1);	 Catch:{ Exception -> 0x0049, all -> 0x0063 }
        r0.add(r2);	 Catch:{ Exception -> 0x0049, all -> 0x0063 }
        r2 = r1.moveToNext();	 Catch:{ Exception -> 0x0049, all -> 0x0063 }
        if (r2 != 0) goto L_0x002b;
    L_0x003c:
        if (r1 == 0) goto L_0x0041;
    L_0x003e:
        r1.close();
    L_0x0041:
        r5 = r0;
    L_0x0042:
        return r5;
    L_0x0043:
        if (r1 == 0) goto L_0x0042;
    L_0x0045:
        r1.close();
        goto L_0x0042;
    L_0x0049:
        r0 = move-exception;
        r2 = "MicroMsg.ReaderAppInfoStorage";	 Catch:{ Exception -> 0x0049, all -> 0x0063 }
        r3 = "getByFunctionMsgId, error: %s";	 Catch:{ Exception -> 0x0049, all -> 0x0063 }
        r4 = 1;	 Catch:{ Exception -> 0x0049, all -> 0x0063 }
        r4 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x0049, all -> 0x0063 }
        r6 = 0;	 Catch:{ Exception -> 0x0049, all -> 0x0063 }
        r0 = r0.getMessage();	 Catch:{ Exception -> 0x0049, all -> 0x0063 }
        r4[r6] = r0;	 Catch:{ Exception -> 0x0049, all -> 0x0063 }
        com.tencent.mm.sdk.platformtools.w.e(r2, r3, r4);	 Catch:{ Exception -> 0x0049, all -> 0x0063 }
        if (r1 == 0) goto L_0x0042;
    L_0x005f:
        r1.close();
        goto L_0x0042;
    L_0x0063:
        r0 = move-exception;
        if (r1 == 0) goto L_0x0069;
    L_0x0066:
        r1.close();
    L_0x0069:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.u.be.t(java.lang.String, int):java.util.List<com.tencent.mm.u.bd>");
    }

    private static String gq(String str) {
        return "select tweetid,time,type,name,title,url,shorturl,longurl,pubtime,sourcename,sourceicon,istop,cover,digest,reserved1,reserved2,reserved3,reserved4 from " + str + "  ";
    }

    public static String fe(int i) {
        if (i == 20) {
            return "readerappnews1";
        }
        if (i == 11) {
            return "readerappweibo";
        }
        Assert.assertTrue("INFO TYPE NEITHER NEWS NOR WEIBO", false);
        return null;
    }

    public be(g gVar) {
        this.hnH = gVar;
    }

    public final boolean a(bd bdVar) {
        if (bdVar == null) {
            return false;
        }
        bdVar.fRW = -1;
        ContentValues contentValues = new ContentValues();
        if ((bdVar.fRW & 1) != 0) {
            contentValues.put("tweetid", bdVar.zD());
        }
        if ((bdVar.fRW & 2) != 0) {
            contentValues.put("time", Long.valueOf(bdVar.time));
        }
        if ((bdVar.fRW & 4) != 0) {
            contentValues.put(Columns.TYPE, Integer.valueOf(bdVar.type));
        }
        if ((bdVar.fRW & 8) != 0) {
            contentValues.put("name", bdVar.getName());
        }
        if ((bdVar.fRW & 16) != 0) {
            contentValues.put("title", bdVar.getTitle());
        }
        if ((bdVar.fRW & 32) != 0) {
            contentValues.put(SlookSmartClipMetaTag.TAG_TYPE_URL, bdVar.getUrl());
        }
        if ((bdVar.fRW & 64) != 0) {
            contentValues.put("shorturl", bdVar.zE());
        }
        if ((bdVar.fRW & FileUtils.S_IWUSR) != 0) {
            contentValues.put("longurl", bdVar.hny == null ? "" : bdVar.hny);
        }
        if ((bdVar.fRW & 256) != 0) {
            contentValues.put("pubtime", Long.valueOf(bdVar.hnz));
        }
        if ((bdVar.fRW & 512) != 0) {
            contentValues.put("sourcename", bdVar.zF());
        }
        if ((bdVar.fRW & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
            contentValues.put("sourceicon", bdVar.zG());
        }
        if ((bdVar.fRW & 2048) != 0) {
            contentValues.put("istop", Integer.valueOf(bdVar.hnC));
        }
        if ((bdVar.fRW & Downloads.RECV_BUFFER_SIZE) != 0) {
            contentValues.put("cover", bdVar.zH());
        }
        if ((bdVar.fRW & 8192) != 0) {
            contentValues.put("digest", bdVar.zI());
        }
        if ((bdVar.fRW & 16384) != 0) {
            contentValues.put("reserved1", Integer.valueOf(bdVar.hnD));
        }
        if ((bdVar.fRW & WXMediaMessage.THUMB_LENGTH_LIMIT) != 0) {
            contentValues.put("reserved2", Long.valueOf(bdVar.hnE));
        }
        if ((bdVar.fRW & 65536) != 0) {
            contentValues.put("reserved3", bdVar.zJ());
        }
        if ((bdVar.fRW & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) != 0) {
            contentValues.put("reserved4", bdVar.hnG == null ? "" : bdVar.hnG);
        }
        if (((int) this.hnH.insert(fe(bdVar.type), "tweetid", contentValues)) != -1) {
            return true;
        }
        return false;
    }

    public final Cursor aK(int i, int i2) {
        return this.hnH.a("SELECT time from " + fe(i2) + " GROUP BY time ORDER BY time" + " ASC  LIMIT " + i + " offset (SELECT COUNT(*) FROM (SELECT COUNT(*) FROM " + fe(i2) + " GROUP BY time)) -" + i, null, 0);
    }

    public final int ff(int i) {
        int i2 = 0;
        Cursor a = this.hnH.a("select count(*) from (SELECT count(*) FROM " + fe(i) + " group by time)", null, 2);
        if (a.moveToFirst()) {
            i2 = a.getInt(0);
        }
        a.close();
        return i2;
    }

    public final List<bd> b(long j, int i) {
        List<bd> arrayList = new ArrayList();
        String str = gq(fe(20)) + " where reserved2 = " + j;
        w.d("MicroMsg.ReaderAppInfoStorage", "getInfoListByMsgSvrID :" + str);
        Cursor a = this.hnH.a(str, null, 2);
        while (a.moveToNext()) {
            bd bdVar = new bd();
            bdVar.b(a);
            arrayList.add(bdVar);
        }
        a.close();
        return arrayList;
    }

    public final List<bd> c(long j, int i) {
        List<bd> arrayList = new ArrayList();
        String str = gq(fe(i)) + " where time = " + j + " order by istop desc , tweetid" + " asc ";
        w.d("MicroMsg.ReaderAppInfoStorage", "getInfobyGroup :" + str);
        Cursor a = this.hnH.a(str, null, 2);
        while (a.moveToNext()) {
            bd bdVar = new bd();
            bdVar.b(a);
            arrayList.add(bdVar);
        }
        a.close();
        return arrayList;
    }

    public final void N(long j) {
        w.d("MicroMsg.ReaderAppInfoStorage", "deleteGroupByMsgSvrID:%s", new Object[]{"delete from " + fe(20) + " where reserved2 = " + j});
        if (this.hnH.eE(fe(20), "delete from " + fe(20) + " where reserved2 = " + j)) {
            fh(20);
            doNotify();
        }
    }

    public final void a(String str, int i, boolean z, boolean z2) {
        List<bd> t = t(str, i);
        if (t != null && t.size() != 0) {
            bd bdVar = (bd) t.get(0);
            bd bdVar2 = bdVar;
            for (bd bdVar3 : t) {
                if (bdVar3.hnC != 1) {
                    bdVar3 = bdVar2;
                }
                bdVar2 = bdVar3;
            }
            if (this.hnH.delete(fe(i), "reserved3=?", new String[]{str}) >= 0 && z) {
                doNotify();
            }
            if (z2) {
                w.i("MicroMsg.ReaderAppInfoStorage", "processConversationAfterDeleteInfo, sql is %s", new Object[]{gq(fe(i)) + " where istop = 1  group by time" + " ORDER BY time DESC  limit 2"});
                Cursor a = this.hnH.a(r0, null, 2);
                ae aeVar;
                if (a.moveToFirst()) {
                    ap.yY();
                    aj Rm = c.wW().Rm(bd.fd(i));
                    bd bdVar4 = new bd();
                    bdVar4.b(a);
                    a.close();
                    aeVar = new ae();
                    aeVar.setUsername(bd.fd(i));
                    aeVar.setContent(bdVar4.getTitle());
                    aeVar.s(bdVar4.time);
                    aeVar.dw(0);
                    if (Rm.field_unReadCount <= 0 || bdVar2 == null || !Rm.field_content.equals(bdVar2.getTitle())) {
                        aeVar.dt(0);
                    } else {
                        aeVar.dt(Rm.field_unReadCount - 1);
                    }
                    ap.yY();
                    c.wW().a(aeVar, bd.fd(i));
                    return;
                }
                a.close();
                aeVar = new ae();
                aeVar.setUsername(bd.fd(i));
                aeVar.setContent("");
                aeVar.s(0);
                aeVar.dw(0);
                aeVar.dt(0);
                ap.yY();
                c.wW().a(aeVar, bd.fd(i));
            }
        }
    }

    public final void fg(int i) {
        ap.yY();
        aj Rm = c.wW().Rm(bd.fd(i));
        if (Rm != null && Rm.field_username.equals(bd.fd(i))) {
            Rm.setUsername(bd.fd(i));
            Rm.setContent("");
            Rm.dw(0);
            Rm.dt(0);
            ap.yY();
            c.wW().a(Rm, bd.fd(i));
            if (this.hnH.eE(fe(i), "delete from " + fe(i))) {
                doNotify();
            }
        }
    }

    public final void fh(int i) {
        w.i("MicroMsg.ReaderAppInfoStorage", "reset conversation, sql is %s", new Object[]{gq(fe(i)) + " where istop = 1  group by time" + " ORDER BY time DESC  limit 2"});
        Cursor a = this.hnH.a(r0, null, 2);
        if (a.moveToFirst()) {
            bd bdVar = new bd();
            bdVar.b(a);
            a.close();
            ae aeVar = new ae();
            aeVar.setUsername(bd.fd(i));
            aeVar.setContent(bdVar.getTitle());
            aeVar.s(bdVar.time);
            aeVar.dw(0);
            aeVar.dt(0);
            ap.yY();
            c.wW().a(aeVar, bd.fd(i));
            return;
        }
        a.close();
        aeVar = new ae();
        aeVar.setUsername(bd.fd(i));
        aeVar.setContent("");
        aeVar.s(0);
        aeVar.dw(0);
        aeVar.dt(0);
        ap.yY();
        c.wW().a(aeVar, bd.fd(i));
    }
}
