package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class p extends c {
    public static final String[] gaK = new String[0];
    private static final int gaT = "rowid".hashCode();
    private static final int gcL = "appId".hashCode();
    private static final int gfI = "flag".hashCode();
    private static final int gfJ = "sortId".hashCode();
    public String field_appId;
    public long field_flag;
    public int field_sortId;
    private boolean gcu = true;
    private boolean gfG = true;
    private boolean gfH = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gfI == hashCode) {
                    this.field_flag = cursor.getLong(i);
                } else if (gcL == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (gfJ == hashCode) {
                    this.field_sortId = cursor.getInt(i);
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.gfG) {
            contentValues.put("flag", Long.valueOf(this.field_flag));
        }
        if (this.field_appId == null) {
            this.field_appId = "";
        }
        if (this.gcu) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.gfH) {
            contentValues.put("sortId", Integer.valueOf(this.field_sortId));
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
