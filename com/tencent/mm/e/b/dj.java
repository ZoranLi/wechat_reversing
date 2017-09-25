package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class dj extends c {
    private static final int gEL = "cmsgId".hashCode();
    public static final String[] gaK = new String[0];
    private static final int gaS = "msgId".hashCode();
    private static final int gaT = "rowid".hashCode();
    private static final int gcf = "content".hashCode();
    public String field_cmsgId;
    public String field_content;
    public long field_msgId;
    private boolean gEK = true;
    private boolean gaO = true;
    private boolean gbJ = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gaS == hashCode) {
                    this.field_msgId = cursor.getLong(i);
                    this.gaO = true;
                } else if (gEL == hashCode) {
                    this.field_cmsgId = cursor.getString(i);
                } else if (gcf == hashCode) {
                    this.field_content = cursor.getString(i);
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.gaO) {
            contentValues.put("msgId", Long.valueOf(this.field_msgId));
        }
        if (this.gEK) {
            contentValues.put("cmsgId", this.field_cmsgId);
        }
        if (this.field_content == null) {
            this.field_content = "";
        }
        if (this.gbJ) {
            contentValues.put("content", this.field_content);
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
