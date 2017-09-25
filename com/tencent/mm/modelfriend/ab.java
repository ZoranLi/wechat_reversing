package com.tencent.mm.modelfriend;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.wcdb.FileUtils;

public final class ab {
    int fRW = -1;
    int hBT = 0;
    int hBU = 0;
    int hBV = 0;
    int hBW = 0;
    int hBX = 0;
    int hBY = 0;
    String hBZ = "";
    String hCa = "";

    public final void b(Cursor cursor) {
        this.hBT = cursor.getInt(0);
        this.hBU = cursor.getInt(1);
        this.hBV = cursor.getInt(2);
        this.hBW = cursor.getInt(3);
        this.hBX = cursor.getInt(4);
        this.hBY = cursor.getInt(5);
        this.hBZ = cursor.getString(6);
        this.hCa = cursor.getString(7);
    }

    public final ContentValues FL() {
        ContentValues contentValues = new ContentValues();
        if ((this.fRW & 1) != 0) {
            contentValues.put("grouopid", Integer.valueOf(this.hBT));
        }
        if ((this.fRW & 2) != 0) {
            contentValues.put("membernum", Integer.valueOf(this.hBU));
        }
        if ((this.fRW & 4) != 0) {
            contentValues.put("weixinnum", Integer.valueOf(this.hBV));
        }
        if ((this.fRW & 8) != 0) {
            contentValues.put("insert_time", Integer.valueOf(this.hBW));
        }
        if ((this.fRW & 16) != 0) {
            contentValues.put("lastupdate_time", Integer.valueOf(this.hBX));
        }
        if ((this.fRW & 32) != 0) {
            contentValues.put("needupdate", Integer.valueOf(this.hBY));
        }
        if ((this.fRW & 64) != 0) {
            contentValues.put("updatekey", FM());
        }
        if ((this.fRW & FileUtils.S_IWUSR) != 0) {
            contentValues.put("groupname", FN());
        }
        return contentValues;
    }

    public final String FM() {
        return this.hBZ == null ? "" : this.hBZ;
    }

    public final String FN() {
        return this.hCa == null ? "" : this.hCa;
    }
}
