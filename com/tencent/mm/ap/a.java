package com.tencent.mm.ap;

import android.content.ContentValues;
import android.database.Cursor;

public final class a {
    int fRW = -1;
    public int hNQ = 0;
    private String hrv = "";
    private String hrw = "";
    private int hrx = 0;
    private int hry = 0;
    private String path = "";
    public String username = "";

    public final void b(Cursor cursor) {
        this.username = cursor.getString(0);
        this.hNQ = cursor.getInt(1);
        this.path = cursor.getString(2);
        this.hrv = cursor.getString(3);
        this.hrw = cursor.getString(4);
        this.hrx = cursor.getInt(5);
        this.hry = cursor.getInt(6);
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if ((this.fRW & 1) != 0) {
            contentValues.put("username", getUsername());
        }
        if ((this.fRW & 2) != 0) {
            contentValues.put("bgflag", Integer.valueOf(this.hNQ));
        }
        if ((this.fRW & 4) != 0) {
            contentValues.put("path", this.path == null ? "" : this.path);
        }
        if ((this.fRW & 8) != 0) {
            contentValues.put("reserved1", this.hrv == null ? "" : this.hrv);
        }
        if ((this.fRW & 16) != 0) {
            contentValues.put("reserved2", this.hrw == null ? "" : this.hrw);
        }
        if ((this.fRW & 32) != 0) {
            contentValues.put("reserved3", Integer.valueOf(this.hrx));
        }
        if ((this.fRW & 64) != 0) {
            contentValues.put("reserved4", Integer.valueOf(this.hry));
        }
        return contentValues;
    }

    public final String getUsername() {
        return this.username == null ? "" : this.username;
    }
}
