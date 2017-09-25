package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class du extends c {
    private static final int gHP = "host".hashCode();
    public static final String[] gaK = new String[0];
    private static final int gaT = "rowid".hashCode();
    private static final int gso = "expireTime".hashCode();
    public long field_expireTime;
    public String field_host;
    private boolean gHO = true;
    private boolean gsf = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gHP == hashCode) {
                    this.field_host = cursor.getString(i);
                } else if (gso == hashCode) {
                    this.field_expireTime = cursor.getLong(i);
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.gHO) {
            contentValues.put("host", this.field_host);
        }
        if (this.gsf) {
            contentValues.put("expireTime", Long.valueOf(this.field_expireTime));
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
