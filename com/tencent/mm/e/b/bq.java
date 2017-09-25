package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bq extends c {
    public static final String[] gaK = new String[0];
    private static final int gaT = "rowid".hashCode();
    private static final int gdt = "username".hashCode();
    private static final int gqo = "timestamp".hashCode();
    private static final int gue = "rankID".hashCode();
    private static final int guf = "appusername".hashCode();
    private static final int gug = "liketips".hashCode();
    public String field_appusername;
    public String field_liketips;
    public String field_rankID;
    public int field_timestamp;
    public String field_username;
    private boolean gds = true;
    private boolean gqe = true;
    private boolean gub = true;
    private boolean guc = true;
    private boolean gud = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gue == hashCode) {
                    this.field_rankID = cursor.getString(i);
                } else if (guf == hashCode) {
                    this.field_appusername = cursor.getString(i);
                } else if (gdt == hashCode) {
                    this.field_username = cursor.getString(i);
                } else if (gqo == hashCode) {
                    this.field_timestamp = cursor.getInt(i);
                } else if (gug == hashCode) {
                    this.field_liketips = cursor.getString(i);
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.gub) {
            contentValues.put("rankID", this.field_rankID);
        }
        if (this.guc) {
            contentValues.put("appusername", this.field_appusername);
        }
        if (this.gds) {
            contentValues.put("username", this.field_username);
        }
        if (this.gqe) {
            contentValues.put("timestamp", Integer.valueOf(this.field_timestamp));
        }
        if (this.field_liketips == null) {
            this.field_liketips = "";
        }
        if (this.gud) {
            contentValues.put("liketips", this.field_liketips);
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
