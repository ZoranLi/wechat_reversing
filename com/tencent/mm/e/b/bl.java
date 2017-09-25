package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bl extends c {
    public static final String[] gaK = new String[0];
    private static final int gaT = "rowid".hashCode();
    private static final int gsx = "reqType".hashCode();
    private static final int gsy = "cache".hashCode();
    public byte[] field_cache;
    public String field_reqType;
    private boolean gsv = true;
    private boolean gsw = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gsx == hashCode) {
                    this.field_reqType = cursor.getString(i);
                    this.gsv = true;
                } else if (gsy == hashCode) {
                    this.field_cache = cursor.getBlob(i);
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.gsv) {
            contentValues.put("reqType", this.field_reqType);
        }
        if (this.gsw) {
            contentValues.put("cache", this.field_cache);
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
