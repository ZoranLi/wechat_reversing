package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ag extends c {
    public static final String[] gaK = new String[0];
    private static final int gaT = "rowid".hashCode();
    private static final int gdt = "username".hashCode();
    private static final int gkU = "cmdbuf".hashCode();
    public byte[] field_cmdbuf;
    public String field_username;
    private boolean gds = true;
    private boolean gkT = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gdt == hashCode) {
                    this.field_username = cursor.getString(i);
                    this.gds = true;
                } else if (gkU == hashCode) {
                    this.field_cmdbuf = cursor.getBlob(i);
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.field_username == null) {
            this.field_username = "";
        }
        if (this.gds) {
            contentValues.put("username", this.field_username);
        }
        if (this.gkT) {
            contentValues.put("cmdbuf", this.field_cmdbuf);
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
