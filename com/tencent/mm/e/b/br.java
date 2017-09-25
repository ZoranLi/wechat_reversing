package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class br extends c {
    public static final String[] gaK = new String[0];
    private static final int gaT = "rowid".hashCode();
    private static final int gfD = "title".hashCode();
    private static final int guf = "appusername".hashCode();
    private static final int gui = "score".hashCode();
    public String field_appusername;
    public int field_score;
    public String field_title;
    private boolean gfz;
    private boolean guc;
    private boolean guh;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (guf == hashCode) {
                    this.field_appusername = cursor.getString(i);
                } else if (gfD == hashCode) {
                    this.field_title = cursor.getString(i);
                } else if (gui == hashCode) {
                    this.field_score = cursor.getInt(i);
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.guc) {
            contentValues.put("appusername", this.field_appusername);
        }
        if (this.gfz) {
            contentValues.put("title", this.field_title);
        }
        if (this.guh) {
            contentValues.put("score", Integer.valueOf(this.field_score));
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
