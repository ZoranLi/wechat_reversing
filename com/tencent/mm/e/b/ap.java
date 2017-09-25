package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ap extends c {
    public static final String[] gaK = new String[0];
    private static final int gaT = "rowid".hashCode();
    private static final int gmR = "lang".hashCode();
    private static final int gnD = "groupId".hashCode();
    private static final int gnT = "md5_lang".hashCode();
    private static final int gnU = "desc".hashCode();
    private static final int gnV = "click_flag".hashCode();
    private static final int gnW = "download_flag".hashCode();
    private static final int gns = "md5".hashCode();
    public int field_click_flag;
    public String field_desc;
    public int field_download_flag;
    public String field_groupId;
    public String field_lang;
    public String field_md5;
    public String field_md5_lang;
    private boolean gmV = true;
    private boolean gmr = true;
    private boolean gnP = true;
    private boolean gnQ = true;
    private boolean gnR = true;
    private boolean gnS = true;
    private boolean gng = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gnT == hashCode) {
                    this.field_md5_lang = cursor.getString(i);
                    this.gnP = true;
                } else if (gns == hashCode) {
                    this.field_md5 = cursor.getString(i);
                } else if (gmR == hashCode) {
                    this.field_lang = cursor.getString(i);
                } else if (gnU == hashCode) {
                    this.field_desc = cursor.getString(i);
                } else if (gnD == hashCode) {
                    this.field_groupId = cursor.getString(i);
                } else if (gnV == hashCode) {
                    this.field_click_flag = cursor.getInt(i);
                } else if (gnW == hashCode) {
                    this.field_download_flag = cursor.getInt(i);
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.gnP) {
            contentValues.put("md5_lang", this.field_md5_lang);
        }
        if (this.gmV) {
            contentValues.put("md5", this.field_md5);
        }
        if (this.gmr) {
            contentValues.put("lang", this.field_lang);
        }
        if (this.gnQ) {
            contentValues.put("desc", this.field_desc);
        }
        if (this.field_groupId == null) {
            this.field_groupId = "";
        }
        if (this.gng) {
            contentValues.put("groupId", this.field_groupId);
        }
        if (this.gnR) {
            contentValues.put("click_flag", Integer.valueOf(this.field_click_flag));
        }
        if (this.gnS) {
            contentValues.put("download_flag", Integer.valueOf(this.field_download_flag));
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
