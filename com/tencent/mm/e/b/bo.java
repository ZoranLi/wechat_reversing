package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bo extends c {
    public static final String[] gaK = new String[0];
    private static final int gaT = "rowid".hashCode();
    private static final int gdt = "username".hashCode();
    private static final int gtn = "championUrl".hashCode();
    private static final int gto = "championMotto".hashCode();
    public String field_championMotto;
    public String field_championUrl;
    public String field_username;
    private boolean gds = true;
    private boolean gtl = true;
    private boolean gtm = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gdt == hashCode) {
                    this.field_username = cursor.getString(i);
                } else if (gtn == hashCode) {
                    this.field_championUrl = cursor.getString(i);
                } else if (gto == hashCode) {
                    this.field_championMotto = cursor.getString(i);
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.gds) {
            contentValues.put("username", this.field_username);
        }
        if (this.gtl) {
            contentValues.put("championUrl", this.field_championUrl);
        }
        if (this.gtm) {
            contentValues.put("championMotto", this.field_championMotto);
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
