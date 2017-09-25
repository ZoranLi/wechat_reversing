package com.tencent.mm.plugin.fts.a.a;

import android.database.Cursor;

public final class h {
    public String fRM = "";
    public int hPr = 0;
    public long hoE = 0;
    public String lZO = "";
    public long mak = 0;
    public long mal = 0;
    public long mam = 0;
    public String man = "";
    public long timestamp = 0;
    public int type = 0;

    public final void b(Cursor cursor) {
        this.mak = cursor.getLong(0);
        this.fRM = cursor.getString(1);
        this.mal = cursor.getLong(2);
        this.hoE = cursor.getLong(3);
        this.lZO = cursor.getString(4);
        this.mam = cursor.getLong(5);
        this.type = cursor.getInt(6);
        this.hPr = cursor.getInt(7);
        this.timestamp = cursor.getLong(8);
        this.man = cursor.getString(9);
    }
}
