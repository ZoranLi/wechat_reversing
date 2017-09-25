package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class cr extends c {
    private static final int gBc = "uid".hashCode();
    private static final int gBd = "devicetype".hashCode();
    public static final String[] gaK = new String[0];
    private static final int gaT = "rowid".hashCode();
    private static final int gnx = "name".hashCode();
    private static final int gva = "createtime".hashCode();
    public long field_createtime;
    public String field_devicetype;
    public String field_name;
    public String field_uid;
    private boolean gBa = true;
    private boolean gBb = true;
    private boolean gna = true;
    private boolean guV = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gBc == hashCode) {
                    this.field_uid = cursor.getString(i);
                    this.gBa = true;
                } else if (gnx == hashCode) {
                    this.field_name = cursor.getString(i);
                } else if (gBd == hashCode) {
                    this.field_devicetype = cursor.getString(i);
                } else if (gva == hashCode) {
                    this.field_createtime = cursor.getLong(i);
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.field_uid == null) {
            this.field_uid = "";
        }
        if (this.gBa) {
            contentValues.put("uid", this.field_uid);
        }
        if (this.field_name == null) {
            this.field_name = "";
        }
        if (this.gna) {
            contentValues.put("name", this.field_name);
        }
        if (this.field_devicetype == null) {
            this.field_devicetype = "";
        }
        if (this.gBb) {
            contentValues.put("devicetype", this.field_devicetype);
        }
        if (this.guV) {
            contentValues.put("createtime", Long.valueOf(this.field_createtime));
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
