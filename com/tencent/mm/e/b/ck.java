package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ck extends c {
    public static final String[] gaK = new String[0];
    private static final int gaS = "msgId".hashCode();
    private static final int gaT = "rowid".hashCode();
    private static final int gsq = "isRead".hashCode();
    private static final int gzz = "msgContentXml".hashCode();
    public String field_isRead;
    public String field_msgContentXml;
    public String field_msgId;
    private boolean gaO = true;
    private boolean gsh = true;
    private boolean gzy = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gaS == hashCode) {
                    this.field_msgId = cursor.getString(i);
                    this.gaO = true;
                } else if (gzz == hashCode) {
                    this.field_msgContentXml = cursor.getString(i);
                } else if (gsq == hashCode) {
                    this.field_isRead = cursor.getString(i);
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.gaO) {
            contentValues.put("msgId", this.field_msgId);
        }
        if (this.gzy) {
            contentValues.put("msgContentXml", this.field_msgContentXml);
        }
        if (this.gsh) {
            contentValues.put("isRead", this.field_isRead);
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
