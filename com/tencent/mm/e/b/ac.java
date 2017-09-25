package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ac extends c {
    public static final String[] gaK = new String[0];
    private static final int gaT = "rowid".hashCode();
    private static final int giS = "lower_bound".hashCode();
    private static final int giT = "need_insert_show_timestamp".hashCode();
    private static final int giU = "show_timestamp_encrypt_key".hashCode();
    private static final int giV = "expire_time_interval".hashCode();
    private static final int giW = "show_expire_interval".hashCode();
    private static final int giX = "fetch_time".hashCode();
    private static final int giw = "card_id".hashCode();
    public String field_card_id;
    public int field_expire_time_interval;
    public long field_fetch_time;
    public int field_lower_bound;
    public boolean field_need_insert_show_timestamp;
    public int field_show_expire_interval;
    public String field_show_timestamp_encrypt_key;
    private boolean giM = true;
    private boolean giN = true;
    private boolean giO = true;
    private boolean giP = true;
    private boolean giQ = true;
    private boolean giR = true;
    private boolean gid = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (giw == hashCode) {
                    this.field_card_id = cursor.getString(i);
                    this.gid = true;
                } else if (giS == hashCode) {
                    this.field_lower_bound = cursor.getInt(i);
                } else if (giT == hashCode) {
                    this.field_need_insert_show_timestamp = cursor.getInt(i) != 0;
                } else if (giU == hashCode) {
                    this.field_show_timestamp_encrypt_key = cursor.getString(i);
                } else if (giV == hashCode) {
                    this.field_expire_time_interval = cursor.getInt(i);
                } else if (giW == hashCode) {
                    this.field_show_expire_interval = cursor.getInt(i);
                } else if (giX == hashCode) {
                    this.field_fetch_time = cursor.getLong(i);
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.gid) {
            contentValues.put("card_id", this.field_card_id);
        }
        if (this.giM) {
            contentValues.put("lower_bound", Integer.valueOf(this.field_lower_bound));
        }
        if (this.giN) {
            contentValues.put("need_insert_show_timestamp", Boolean.valueOf(this.field_need_insert_show_timestamp));
        }
        if (this.giO) {
            contentValues.put("show_timestamp_encrypt_key", this.field_show_timestamp_encrypt_key);
        }
        if (this.giP) {
            contentValues.put("expire_time_interval", Integer.valueOf(this.field_expire_time_interval));
        }
        if (this.giQ) {
            contentValues.put("show_expire_interval", Integer.valueOf(this.field_show_expire_interval));
        }
        if (this.giR) {
            contentValues.put("fetch_time", Long.valueOf(this.field_fetch_time));
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
