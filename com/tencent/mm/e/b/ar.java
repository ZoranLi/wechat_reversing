package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ar extends c {
    public static final String[] gaK = new String[0];
    private static final int gaT = "rowid".hashCode();
    private static final int gcf = "content".hashCode();
    private static final int goa = "designerIDAndType".hashCode();
    public byte[] field_content;
    public String field_designerIDAndType;
    private boolean gbJ = true;
    private boolean gnZ = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (goa == hashCode) {
                    this.field_designerIDAndType = cursor.getString(i);
                    this.gnZ = true;
                } else if (gcf == hashCode) {
                    this.field_content = cursor.getBlob(i);
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.gnZ) {
            contentValues.put("designerIDAndType", this.field_designerIDAndType);
        }
        if (this.gbJ) {
            contentValues.put("content", this.field_content);
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
