package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class cd extends c {
    public static final String[] gaK = new String[0];
    private static final int gaT = "rowid".hashCode();
    private static final int gfD = "title".hashCode();
    private static final int gxf = "loan_jump_url".hashCode();
    private static final int gxg = "red_dot_index".hashCode();
    private static final int gxh = "is_show_entry".hashCode();
    private static final int gxi = "tips".hashCode();
    private static final int gxj = "is_overdue".hashCode();
    private static final int gxk = "available_otb".hashCode();
    public String field_available_otb;
    public int field_is_overdue;
    public int field_is_show_entry;
    public String field_loan_jump_url;
    public int field_red_dot_index;
    public String field_tips;
    public String field_title;
    private boolean gfz = true;
    private boolean gwZ = true;
    private boolean gxa = true;
    private boolean gxb = true;
    private boolean gxc = true;
    private boolean gxd = true;
    private boolean gxe = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gfD == hashCode) {
                    this.field_title = cursor.getString(i);
                    this.gfz = true;
                } else if (gxf == hashCode) {
                    this.field_loan_jump_url = cursor.getString(i);
                } else if (gxg == hashCode) {
                    this.field_red_dot_index = cursor.getInt(i);
                } else if (gxh == hashCode) {
                    this.field_is_show_entry = cursor.getInt(i);
                } else if (gxi == hashCode) {
                    this.field_tips = cursor.getString(i);
                } else if (gxj == hashCode) {
                    this.field_is_overdue = cursor.getInt(i);
                } else if (gxk == hashCode) {
                    this.field_available_otb = cursor.getString(i);
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.gfz) {
            contentValues.put("title", this.field_title);
        }
        if (this.gwZ) {
            contentValues.put("loan_jump_url", this.field_loan_jump_url);
        }
        if (this.gxa) {
            contentValues.put("red_dot_index", Integer.valueOf(this.field_red_dot_index));
        }
        if (this.gxb) {
            contentValues.put("is_show_entry", Integer.valueOf(this.field_is_show_entry));
        }
        if (this.gxc) {
            contentValues.put("tips", this.field_tips);
        }
        if (this.gxd) {
            contentValues.put("is_overdue", Integer.valueOf(this.field_is_overdue));
        }
        if (this.gxe) {
            contentValues.put("available_otb", this.field_available_otb);
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
