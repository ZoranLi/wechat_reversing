package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class aq extends c {
    public static final String[] gaK = new String[0];
    private static final int gaT = "rowid".hashCode();
    private static final int gnU = "desc".hashCode();
    private static final int gnY = "groupID".hashCode();
    public String field_desc;
    public String field_groupID;
    private boolean gnQ = true;
    private boolean gnX = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gnY == hashCode) {
                    this.field_groupID = cursor.getString(i);
                } else if (gnU == hashCode) {
                    this.field_desc = cursor.getString(i);
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.gnX) {
            contentValues.put("groupID", this.field_groupID);
        }
        if (this.gnQ) {
            contentValues.put("desc", this.field_desc);
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
