package com.tencent.mm.plugin.sns.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.w;

public final class f extends i<e> {
    public static final String[] gUx = new String[]{i.a(e.gTP, "adsnsinfo")};
    public static final String[] gaK = new String[]{"CREATE INDEX IF NOT EXISTS serverAdSnsNameIndex ON AdSnsInfo ( snsId )", "CREATE INDEX IF NOT EXISTS serverAdSnsTimeHeadIndex ON AdSnsInfo ( head )", "DROP INDEX IF EXISTS serverAdSnsTimeIndex", "DROP INDEX IF EXISTS serverAdSnsTimeSourceTypeIndex", "CREATE INDEX IF NOT EXISTS adsnsMultiIndex1 ON AdSnsInfo ( createTime,snsId,sourceType,type)", "CREATE INDEX IF NOT EXISTS adsnsMultiIndex2 ON AdSnsInfo ( sourceType,type,userName)"};
    private static final String qnn = String.format("select  %s %s,rowid from AdSnsInfo ", new Object[]{"snsId", "createTime"});
    public e gUz;

    public final /* synthetic */ boolean a(long j, c cVar) {
        return b(j, (e) cVar);
    }

    public f(e eVar) {
        super(eVar, e.gTP, "adsnsinfo", gaK);
        this.gUz = eVar;
    }

    public final e dz(long j) {
        e eVar = new e();
        Cursor a = this.gUz.a("select *,rowid from AdSnsInfo  where AdSnsInfo.snsId=" + j, null, 2);
        if (a.moveToFirst()) {
            eVar.b(a);
            a.close();
            return eVar;
        }
        a.close();
        return null;
    }

    public final e tD(int i) {
        e eVar = new e();
        Cursor a = this.gUz.a("select *,rowid from AdSnsInfo  where AdSnsInfo.rowid=" + i, null, 2);
        if (a.moveToFirst()) {
            eVar.b(a);
            a.close();
            return eVar;
        }
        a.close();
        return null;
    }

    public final boolean a(long j, e eVar) {
        if (dA(j)) {
            return b(j, eVar);
        }
        int i;
        w.d("MicroMsg.AdSnsInfoStorage", "added PcId " + j);
        w.d("MicroMsg.AdSnsInfoStorage", "SnsInfo Insert");
        if (eVar == null) {
            i = -1;
        } else {
            i = (int) this.gUz.insert("AdSnsInfo", "", eVar.pv());
            w.d("MicroMsg.AdSnsInfoStorage", "SnsInfo Insert result" + i);
        }
        return i != -1;
    }

    public final boolean b(long j, e eVar) {
        ContentValues pv = eVar.pv();
        pv.remove("rowid");
        if (this.gUz.update("AdSnsInfo", pv, "snsId=?", new String[]{String.valueOf(j)}) > 0) {
            return true;
        }
        return false;
    }

    public final boolean dA(long j) {
        Cursor a = this.gUz.a("select *,rowid from AdSnsInfo  where AdSnsInfo.snsId=" + j, null, 2);
        boolean moveToFirst = a.moveToFirst();
        a.close();
        return moveToFirst;
    }

    public final boolean delete(long j) {
        int delete = this.gUz.delete("AdSnsInfo", "snsId=?", new String[]{String.valueOf(j)});
        w.i("MicroMsg.AdSnsInfoStorage", "del msg " + j + " res " + delete);
        if (delete > 0) {
            return true;
        }
        return false;
    }
}
