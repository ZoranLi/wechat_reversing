package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class dh extends c {
    public static final String[] gaK = new String[0];
    private static final int gaT = "rowid".hashCode();
    private static final int gcL = "appId".hashCode();
    private static final int gdt = "username".hashCode();
    private static final int geR = "openId".hashCode();
    public String field_appId;
    public String field_openId;
    public String field_username;
    private boolean gcu = true;
    private boolean gds = true;
    private boolean gev = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (geR == hashCode) {
                    this.field_openId = cursor.getString(i);
                    this.gev = true;
                } else if (gcL == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (gdt == hashCode) {
                    this.field_username = cursor.getString(i);
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.gev) {
            contentValues.put("openId", this.field_openId);
        }
        if (this.gcu) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.gds) {
            contentValues.put("username", this.field_username);
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
