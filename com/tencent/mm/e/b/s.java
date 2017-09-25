package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class s extends c {
    public static final String[] gaK = new String[0];
    private static final int gaT = "rowid".hashCode();
    private static final int gbn = "startTime".hashCode();
    private static final int gbo = "endTime".hashCode();
    private static final int gfO = "sessionName".hashCode();
    public long field_endTime;
    public String field_sessionName;
    public long field_startTime;
    private boolean gbf = true;
    private boolean gbg = true;
    private boolean gfL = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gfO == hashCode) {
                    this.field_sessionName = cursor.getString(i);
                } else if (gbn == hashCode) {
                    this.field_startTime = cursor.getLong(i);
                } else if (gbo == hashCode) {
                    this.field_endTime = cursor.getLong(i);
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.field_sessionName == null) {
            this.field_sessionName = "";
        }
        if (this.gfL) {
            contentValues.put("sessionName", this.field_sessionName);
        }
        if (this.gbf) {
            contentValues.put("startTime", Long.valueOf(this.field_startTime));
        }
        if (this.gbg) {
            contentValues.put("endTime", Long.valueOf(this.field_endTime));
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
