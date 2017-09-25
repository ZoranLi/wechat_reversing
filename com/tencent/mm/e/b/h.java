package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;

public abstract class h extends c {
    public static final String[] gaK = new String[0];
    private static final int gaT = "rowid".hashCode();
    private static final int gbj = Columns.VALUE.hashCode();
    private static final int gdd = "key".hashCode();
    public String field_key;
    public String field_value;
    private boolean gbb = true;
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
                } else if (gbj == hashCode) {
                    this.field_value = cursor.getString(i);
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
        if (this.gbb) {
            contentValues.put(Columns.VALUE, this.field_value);
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
