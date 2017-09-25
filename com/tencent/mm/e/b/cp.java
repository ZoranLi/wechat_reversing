package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class cp extends c {
    public static final String[] gaK = new String[0];
    private static final int gaT = "rowid".hashCode();
    private static final int ggr = "isSend".hashCode();
    private static final int glK = "transferId".hashCode();
    private static final int gzY = "locaMsgId".hashCode();
    private static final int gzZ = "receiveStatus".hashCode();
    public boolean field_isSend;
    public long field_locaMsgId;
    public int field_receiveStatus;
    public String field_transferId;
    private boolean ggd = true;
    private boolean glJ = true;
    private boolean gzW = true;
    private boolean gzX = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (glK == hashCode) {
                    this.field_transferId = cursor.getString(i);
                    this.glJ = true;
                } else if (gzY == hashCode) {
                    this.field_locaMsgId = cursor.getLong(i);
                } else if (gzZ == hashCode) {
                    this.field_receiveStatus = cursor.getInt(i);
                } else if (ggr == hashCode) {
                    this.field_isSend = cursor.getInt(i) != 0;
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.glJ) {
            contentValues.put("transferId", this.field_transferId);
        }
        if (this.gzW) {
            contentValues.put("locaMsgId", Long.valueOf(this.field_locaMsgId));
        }
        if (this.gzX) {
            contentValues.put("receiveStatus", Integer.valueOf(this.field_receiveStatus));
        }
        if (this.ggd) {
            contentValues.put("isSend", Boolean.valueOf(this.field_isSend));
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
