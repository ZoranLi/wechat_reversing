package com.tencent.mm.plugin.shake.a.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class b extends c {
    public static final String[] gaK = new String[0];
    private static final int gaT = "rowid".hashCode();
    private static final int gdt = "username".hashCode();
    private static final int pnV = "lastshaketime".hashCode();
    private static final int pnW = "isshowed".hashCode();
    public boolean field_isshowed;
    public int field_lastshaketime;
    public String field_username;
    private boolean gds;
    private boolean pnT;
    private boolean pnU;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gdt == hashCode) {
                    this.field_username = cursor.getString(i);
                    this.gds = true;
                } else if (pnV == hashCode) {
                    this.field_lastshaketime = cursor.getInt(i);
                } else if (pnW == hashCode) {
                    this.field_isshowed = cursor.getInt(i) != 0;
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
        if (this.pnT) {
            contentValues.put("lastshaketime", Integer.valueOf(this.field_lastshaketime));
        }
        if (this.pnU) {
            contentValues.put("isshowed", Boolean.valueOf(this.field_isshowed));
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
