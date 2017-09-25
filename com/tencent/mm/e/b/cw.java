package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class cw extends c {
    private static final int gCn = "state_flag".hashCode();
    private static final int gCo = "update_time".hashCode();
    private static final int gCp = "seq".hashCode();
    public static final String[] gaK = new String[0];
    private static final int gaT = "rowid".hashCode();
    private static final int giw = "card_id".hashCode();
    private static final int gzD = "retryCount".hashCode();
    public String field_card_id;
    public int field_retryCount;
    public long field_seq;
    public int field_state_flag;
    public long field_update_time;
    private boolean gCk = true;
    private boolean gCl = true;
    private boolean gCm = true;
    private boolean gid = true;
    private boolean gzB = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (giw == hashCode) {
                    this.field_card_id = cursor.getString(i);
                    this.gid = true;
                } else if (gCn == hashCode) {
                    this.field_state_flag = cursor.getInt(i);
                } else if (gCo == hashCode) {
                    this.field_update_time = cursor.getLong(i);
                } else if (gCp == hashCode) {
                    this.field_seq = cursor.getLong(i);
                } else if (gzD == hashCode) {
                    this.field_retryCount = cursor.getInt(i);
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
        if (this.gCk) {
            contentValues.put("state_flag", Integer.valueOf(this.field_state_flag));
        }
        if (this.gCl) {
            contentValues.put("update_time", Long.valueOf(this.field_update_time));
        }
        if (this.gCm) {
            contentValues.put("seq", Long.valueOf(this.field_seq));
        }
        if (this.gzB) {
            contentValues.put("retryCount", Integer.valueOf(this.field_retryCount));
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
