package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ai extends c {
    public static final String[] gaK = new String[0];
    private static final int gaT = "rowid".hashCode();
    private static final int glh = "labelId".hashCode();
    private static final int gli = "contactName".hashCode();
    public String field_contactName;
    public String field_labelId;
    private boolean glf;
    private boolean glg;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (glh == hashCode) {
                    this.field_labelId = cursor.getString(i);
                } else if (gli == hashCode) {
                    this.field_contactName = cursor.getString(i);
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.glf) {
            contentValues.put("labelId", this.field_labelId);
        }
        if (this.glg) {
            contentValues.put("contactName", this.field_contactName);
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
