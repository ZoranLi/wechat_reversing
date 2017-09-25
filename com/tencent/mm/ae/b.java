package com.tencent.mm.ae;

import android.content.ContentValues;
import com.tencent.mm.bj.g;
import com.tencent.mm.sdk.e.j;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import com.tencent.wcdb.FileUtils;

public final class b extends j {
    public static final String[] gUx = new String[]{"CREATE TABLE IF NOT EXISTS getcontactinfov2 ( username text  PRIMARY KEY , inserttime long  , type int  , lastgettime int  , reserved1 int  , reserved2 int  , reserved3 text  , reserved4 text  ) "};
    g hnH;

    public b(g gVar) {
        this.hnH = gVar;
    }

    public final boolean a(a aVar) {
        aVar.fRW = -1;
        ContentValues contentValues = new ContentValues();
        if ((aVar.fRW & 1) != 0) {
            contentValues.put("username", aVar.getUsername());
        }
        if ((aVar.fRW & 2) != 0) {
            contentValues.put("inserttime", Long.valueOf(aVar.hDC));
        }
        if ((aVar.fRW & 4) != 0) {
            contentValues.put(Columns.TYPE, Integer.valueOf(aVar.type));
        }
        if ((aVar.fRW & 8) != 0) {
            contentValues.put("lastgettime", Integer.valueOf(aVar.hDD));
        }
        if ((aVar.fRW & 16) != 0) {
            contentValues.put("reserved1", Integer.valueOf(aVar.hnD));
        }
        if ((aVar.fRW & 32) != 0) {
            contentValues.put("reserved2", Integer.valueOf(aVar.hBy));
        }
        if ((aVar.fRW & 64) != 0) {
            contentValues.put("reserved3", aVar.zJ());
        }
        if ((aVar.fRW & FileUtils.S_IWUSR) != 0) {
            contentValues.put("reserved4", aVar.Gp());
        }
        if (((int) this.hnH.replace("getcontactinfov2", "username", contentValues)) == -1) {
            return false;
        }
        Qr(aVar.getUsername());
        return true;
    }

    public final boolean jl(String str) {
        if (this.hnH.delete("getcontactinfov2", "username= ?", new String[]{str}) <= 0) {
            return false;
        }
        Qr(str);
        return true;
    }
}
