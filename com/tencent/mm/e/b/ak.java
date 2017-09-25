package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ak extends c {
    public static final String[] gaK = new String[0];
    private static final int gaS = "msgId".hashCode();
    private static final int gaT = "rowid".hashCode();
    private static final int glK = "transferId".hashCode();
    public long field_msgId;
    public String field_transferId;
    private boolean gaO = true;
    private boolean glJ = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gaS == hashCode) {
                    this.field_msgId = cursor.getLong(i);
                    this.gaO = true;
                } else if (glK == hashCode) {
                    this.field_transferId = cursor.getString(i);
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.gaO) {
            contentValues.put("msgId", Long.valueOf(this.field_msgId));
        }
        if (this.glJ) {
            contentValues.put("transferId", this.field_transferId);
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
