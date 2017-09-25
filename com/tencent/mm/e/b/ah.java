package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ah extends c {
    public static final String[] gaK = new String[0];
    private static final int gaT = "rowid".hashCode();
    private static final int gbX = "createTime".hashCode();
    private static final int gla = "labelID".hashCode();
    private static final int glb = "labelName".hashCode();
    private static final int glc = "labelPYFull".hashCode();
    private static final int gld = "labelPYShort".hashCode();
    private static final int gle = "isTemporary".hashCode();
    public long field_createTime;
    public boolean field_isTemporary;
    public int field_labelID;
    public String field_labelName;
    public String field_labelPYFull;
    public String field_labelPYShort;
    private boolean gbB = true;
    private boolean gkV = true;
    private boolean gkW = true;
    private boolean gkX = true;
    private boolean gkY = true;
    private boolean gkZ = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gla == hashCode) {
                    this.field_labelID = cursor.getInt(i);
                    this.gkV = true;
                } else if (glb == hashCode) {
                    this.field_labelName = cursor.getString(i);
                } else if (glc == hashCode) {
                    this.field_labelPYFull = cursor.getString(i);
                } else if (gld == hashCode) {
                    this.field_labelPYShort = cursor.getString(i);
                } else if (gbX == hashCode) {
                    this.field_createTime = cursor.getLong(i);
                } else if (gle == hashCode) {
                    this.field_isTemporary = cursor.getInt(i) != 0;
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.gkV) {
            contentValues.put("labelID", Integer.valueOf(this.field_labelID));
        }
        if (this.gkW) {
            contentValues.put("labelName", this.field_labelName);
        }
        if (this.gkX) {
            contentValues.put("labelPYFull", this.field_labelPYFull);
        }
        if (this.gkY) {
            contentValues.put("labelPYShort", this.field_labelPYShort);
        }
        if (this.gbB) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.gkZ) {
            contentValues.put("isTemporary", Boolean.valueOf(this.field_isTemporary));
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
