package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class aa extends c {
    public static final String[] gaK = new String[0];
    private static final int gaT = "rowid".hashCode();
    private static final int gbX = "createTime".hashCode();
    private static final int ghY = "canvasId".hashCode();
    private static final int ghZ = "canvasXml".hashCode();
    public long field_canvasId;
    public String field_canvasXml;
    public long field_createTime;
    private boolean gbB = true;
    private boolean ghW = true;
    private boolean ghX = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (ghY == hashCode) {
                    this.field_canvasId = cursor.getLong(i);
                    this.ghW = true;
                } else if (ghZ == hashCode) {
                    this.field_canvasXml = cursor.getString(i);
                } else if (gbX == hashCode) {
                    this.field_createTime = cursor.getLong(i);
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.ghW) {
            contentValues.put("canvasId", Long.valueOf(this.field_canvasId));
        }
        if (this.ghX) {
            contentValues.put("canvasXml", this.field_canvasXml);
        }
        if (this.gbB) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
