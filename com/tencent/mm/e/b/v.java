package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class v extends c {
    public static final String[] gaK = new String[0];
    private static final int gaT = "rowid".hashCode();
    private static final int ggT = "userId".hashCode();
    private static final int ggh = "brandUserName".hashCode();
    public String field_brandUserName;
    public String field_userId;
    private boolean gfT = true;
    private boolean ggS = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (ggh == hashCode) {
                    this.field_brandUserName = cursor.getString(i);
                    this.gfT = true;
                } else if (ggT == hashCode) {
                    this.field_userId = cursor.getString(i);
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.gfT) {
            contentValues.put("brandUserName", this.field_brandUserName);
        }
        if (this.ggS) {
            contentValues.put("userId", this.field_userId);
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
