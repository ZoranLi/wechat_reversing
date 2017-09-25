package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import com.tencent.mm.bj.g;
import com.tencent.mm.e.b.da;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class j extends i<i> implements c {
    public static final String[] gUx = new String[]{i.a(i.gTP, "SnsComment")};
    public g hnH;

    public j(g gVar) {
        super(gVar, i.gTP, "SnsComment", da.gaK);
        this.hnH = gVar;
    }

    public static String bhi() {
        return "select *, rowid from SnsComment";
    }

    public final int Kr() {
        int i = 0;
        Cursor a = this.hnH.a(" select count(*) from SnsComment where isRead = ? and isSilence != ? ", new String[]{"0", "1"}, 2);
        if (a != null) {
            if (a.moveToFirst()) {
                i = a.getInt(0);
            }
            a.close();
        }
        return i;
    }

    public final Cursor bhj() {
        String stringBuilder = new StringBuilder("select *, rowid from SnsComment where isRead = ?  and isSilence != ?  order by createTime desc").toString();
        return this.hnH.a(stringBuilder, new String[]{"0", "1"}, 0);
    }

    public final boolean a(long j, String str, int i, String str2) {
        String str3;
        if (bg.mA(str2)) {
            str3 = "select count(*) from SnsComment where snsID = " + j + " and createTime = " + i + " and talker = '" + str + "'";
        } else {
            str3 = "select count(*) from SnsComment where snsID = " + j + " and clientId = '" + str2 + "'";
        }
        Cursor rawQuery = rawQuery(str3, new String[0]);
        if (rawQuery == null) {
            return false;
        }
        rawQuery.moveToFirst();
        int i2 = rawQuery.getInt(0);
        rawQuery.close();
        if (i2 > 0) {
            return true;
        }
        return false;
    }

    public final int bhk() {
        Cursor rawQuery = rawQuery(new StringBuilder("select count(*) from SnsComment where isSend = 0").toString(), new String[0]);
        if (rawQuery == null) {
            return 0;
        }
        rawQuery.moveToFirst();
        int i = rawQuery.getInt(0);
        rawQuery.close();
        return i;
    }

    public final i d(long j, long j2, int i) {
        int i2;
        if (i == 9) {
            i2 = 2;
        } else {
            i2 = i;
        }
        if (i2 == 10) {
            i2 = 8;
        }
        Cursor rawQuery = rawQuery("select *, rowid from SnsComment where snsID = " + j + " and commentSvrID = " + j2 + " and type = " + i2, new String[0]);
        if (rawQuery == null) {
            return null;
        }
        i iVar;
        if (rawQuery.moveToFirst()) {
            iVar = new i();
            iVar.b(rawQuery);
        } else {
            iVar = null;
        }
        rawQuery.close();
        return iVar;
    }

    public final boolean dB(long j) {
        return this.hnH.eE("SnsComment", "delete from SnsComment where snsID = " + j);
    }

    public final boolean e(long j, long j2, int i) {
        int i2;
        if (i == 9) {
            i2 = 2;
        } else {
            i2 = i;
        }
        if (i2 == 10) {
            i2 = 8;
        }
        return this.hnH.eE("SnsComment", "delete from SnsComment where snsID = " + j + " and commentSvrID = " + j2 + " and type = " + i2);
    }

    public final boolean afV() {
        return this.hnH.eE("SnsComment", " update SnsComment set isRead = 1 where isRead = 0");
    }

    public final boolean m(long j, boolean z) {
        int i = z ? 1 : 0;
        String str = " update SnsComment set isSilence = " + i + " where isSilence != " + i + " and  snsID = " + j;
        w.i("MicroMsg.SnsCommentStorage", "updateIsSilence " + str);
        return this.hnH.eE("SnsComment", str);
    }

    public final void bhl() {
        this.hnH.Sv("SnsComment");
    }
}
