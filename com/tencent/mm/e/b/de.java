package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class de extends c {
    private static final int gDP = "tagId".hashCode();
    private static final int gDQ = "tagName".hashCode();
    private static final int gDR = "memberList".hashCode();
    public static final String[] gaK = new String[0];
    private static final int gaT = "rowid".hashCode();
    private static final int gmU = "count".hashCode();
    public int field_count;
    public String field_memberList;
    public long field_tagId;
    public String field_tagName;
    private boolean gDM = true;
    private boolean gDN = true;
    private boolean gDO = true;
    private boolean gmu = true;

    public void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gDP == hashCode) {
                    this.field_tagId = cursor.getLong(i);
                } else if (gDQ == hashCode) {
                    this.field_tagName = cursor.getString(i);
                } else if (gmU == hashCode) {
                    this.field_count = cursor.getInt(i);
                } else if (gDR == hashCode) {
                    this.field_memberList = cursor.getString(i);
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.gDM) {
            contentValues.put("tagId", Long.valueOf(this.field_tagId));
        }
        if (this.field_tagName == null) {
            this.field_tagName = "";
        }
        if (this.gDN) {
            contentValues.put("tagName", this.field_tagName);
        }
        if (this.gmu) {
            contentValues.put("count", Integer.valueOf(this.field_count));
        }
        if (this.field_memberList == null) {
            this.field_memberList = "";
        }
        if (this.gDO) {
            contentValues.put("memberList", this.field_memberList);
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
