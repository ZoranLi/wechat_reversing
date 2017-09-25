package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class dq extends c {
    private static final int gGV = "wallet_grey_item_buf".hashCode();
    private static final int gGn = "wallet_region".hashCode();
    public static final String[] gaK = new String[0];
    private static final int gaT = "rowid".hashCode();
    public byte[] field_wallet_grey_item_buf;
    public int field_wallet_region;
    private boolean gGU = true;
    private boolean gGi = true;

    public void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gGn == hashCode) {
                    this.field_wallet_region = cursor.getInt(i);
                    this.gGi = true;
                } else if (gGV == hashCode) {
                    this.field_wallet_grey_item_buf = cursor.getBlob(i);
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.gGi) {
            contentValues.put("wallet_region", Integer.valueOf(this.field_wallet_region));
        }
        if (this.gGU) {
            contentValues.put("wallet_grey_item_buf", this.field_wallet_grey_item_buf);
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
