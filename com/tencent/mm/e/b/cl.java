package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class cl extends c {
    public static final String[] gaK = new String[0];
    private static final int gaT = "rowid".hashCode();
    private static final int gzC = "cardUserId".hashCode();
    private static final int gzD = "retryCount".hashCode();
    public String field_cardUserId;
    public int field_retryCount;
    private boolean gzA = true;
    private boolean gzB = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gzC == hashCode) {
                    this.field_cardUserId = cursor.getString(i);
                    this.gzA = true;
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
        if (this.gzA) {
            contentValues.put("cardUserId", this.field_cardUserId);
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
