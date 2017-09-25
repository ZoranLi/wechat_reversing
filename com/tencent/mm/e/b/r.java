package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class r extends c {
    public static final String[] gaK = new String[0];
    private static final int gaT = "rowid".hashCode();
    private static final int gfO = "sessionName".hashCode();
    private static final int gfR = "msgListDataId".hashCode();
    public String field_msgListDataId;
    public String field_sessionName;
    private boolean gfL = true;
    private boolean gfQ = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gfR == hashCode) {
                    this.field_msgListDataId = cursor.getString(i);
                    this.gfQ = true;
                } else if (gfO == hashCode) {
                    this.field_sessionName = cursor.getString(i);
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.gfQ) {
            contentValues.put("msgListDataId", this.field_msgListDataId);
        }
        if (this.field_sessionName == null) {
            this.field_sessionName = "";
        }
        if (this.gfL) {
            contentValues.put("sessionName", this.field_sessionName);
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
