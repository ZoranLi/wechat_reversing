package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bs extends c {
    public static final String[] gaK = new String[0];
    private static final int gaT = "rowid".hashCode();
    private static final int gdt = "username".hashCode();
    private static final int gmI = "sort".hashCode();
    private static final int gue = "rankID".hashCode();
    private static final int guf = "appusername".hashCode();
    private static final int guk = "step".hashCode();
    public String field_appusername;
    public String field_rankID;
    public int field_sort;
    public int field_step;
    public String field_username;
    private boolean gds = true;
    private boolean gmi = true;
    private boolean gub = true;
    private boolean guc = true;
    private boolean guj = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (guf == hashCode) {
                    this.field_appusername = cursor.getString(i);
                } else if (gue == hashCode) {
                    this.field_rankID = cursor.getString(i);
                } else if (gdt == hashCode) {
                    this.field_username = cursor.getString(i);
                } else if (guk == hashCode) {
                    this.field_step = cursor.getInt(i);
                } else if (gmI == hashCode) {
                    this.field_sort = cursor.getInt(i);
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
        if (this.gub) {
            contentValues.put("rankID", this.field_rankID);
        }
        if (this.gds) {
            contentValues.put("username", this.field_username);
        }
        if (this.guj) {
            contentValues.put("step", Integer.valueOf(this.field_step));
        }
        if (this.gmi) {
            contentValues.put("sort", Integer.valueOf(this.field_sort));
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
