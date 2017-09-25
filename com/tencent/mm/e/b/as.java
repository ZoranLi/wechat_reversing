package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class as extends c {
    public static final String[] gaK = new String[0];
    private static final int gaT = "rowid".hashCode();
    private static final int gcf = "content".hashCode();
    private static final int gmv = "productID".hashCode();
    private static final int goc = "lan".hashCode();
    public byte[] field_content;
    public String field_lan;
    public String field_productID;
    private boolean gbJ = true;
    private boolean glV = true;
    private boolean gob = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gmv == hashCode) {
                    this.field_productID = cursor.getString(i);
                    this.glV = true;
                } else if (gcf == hashCode) {
                    this.field_content = cursor.getBlob(i);
                } else if (goc == hashCode) {
                    this.field_lan = cursor.getString(i);
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.glV) {
            contentValues.put("productID", this.field_productID);
        }
        if (this.gbJ) {
            contentValues.put("content", this.field_content);
        }
        if (this.field_lan == null) {
            this.field_lan = "";
        }
        if (this.gob) {
            contentValues.put("lan", this.field_lan);
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
