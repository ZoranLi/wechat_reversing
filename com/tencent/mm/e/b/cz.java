package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class cz extends c {
    private static final int gCN = "position".hashCode();
    public static final String[] gaK = new String[0];
    private static final int gaT = "rowid".hashCode();
    private static final int gdd = "key".hashCode();
    public String field_key;
    public int field_position;
    private boolean gCG = true;
    private boolean gdc = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gdd == hashCode) {
                    this.field_key = cursor.getString(i);
                    this.gdc = true;
                } else if (gCN == hashCode) {
                    this.field_position = cursor.getInt(i);
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.gdc) {
            contentValues.put("key", this.field_key);
        }
        if (this.gCG) {
            contentValues.put("position", Integer.valueOf(this.field_position));
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
