package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class al extends c {
    public static final String[] gaK = new String[0];
    private static final int gaT = "rowid".hashCode();
    private static final int glN = "bakLogId".hashCode();
    private static final int glO = "valueStr".hashCode();
    public int field_bakLogId;
    public String field_valueStr;
    private boolean glL;
    private boolean glM;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (glN == hashCode) {
                    this.field_bakLogId = cursor.getInt(i);
                } else if (glO == hashCode) {
                    this.field_valueStr = cursor.getString(i);
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.glL) {
            contentValues.put("bakLogId", Integer.valueOf(this.field_bakLogId));
        }
        if (this.glM) {
            contentValues.put("valueStr", this.field_valueStr);
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
