package com.tencent.mm.plugin.shake.a.a;

import android.content.ContentValues;
import android.database.Cursor;

public abstract class c extends com.tencent.mm.sdk.e.c {
    public static final String[] gaK = new String[0];
    private static final int gaT = "rowid".hashCode();
    private static final int gdt = "username".hashCode();
    private static final int gfD = "title".hashCode();
    private static final int gva = "createtime".hashCode();
    private static final int pnZ = "deeplink".hashCode();
    private static final int poa = "iconurl".hashCode();
    public long field_createtime;
    public String field_deeplink;
    public String field_iconurl;
    public String field_title;
    public String field_username;
    private boolean gds = true;
    private boolean gfz = true;
    private boolean guV = true;
    private boolean pnX = true;
    private boolean pnY = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gdt == hashCode) {
                    this.field_username = cursor.getString(i);
                    this.gds = true;
                } else if (pnZ == hashCode) {
                    this.field_deeplink = cursor.getString(i);
                } else if (gfD == hashCode) {
                    this.field_title = cursor.getString(i);
                } else if (poa == hashCode) {
                    this.field_iconurl = cursor.getString(i);
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
        if (this.field_username == null) {
            this.field_username = "";
        }
        if (this.gds) {
            contentValues.put("username", this.field_username);
        }
        if (this.field_deeplink == null) {
            this.field_deeplink = "";
        }
        if (this.pnX) {
            contentValues.put("deeplink", this.field_deeplink);
        }
        if (this.field_title == null) {
            this.field_title = "";
        }
        if (this.gfz) {
            contentValues.put("title", this.field_title);
        }
        if (this.field_iconurl == null) {
            this.field_iconurl = "";
        }
        if (this.pnY) {
            contentValues.put("iconurl", this.field_iconurl);
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
