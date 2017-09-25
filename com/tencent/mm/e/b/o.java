package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;

public abstract class o extends c {
    public static final String[] gaK = new String[0];
    private static final int gaS = "msgId".hashCode();
    private static final int gaT = "rowid".hashCode();
    private static final int gcL = "appId".hashCode();
    private static final int gca = Columns.TYPE.hashCode();
    private static final int gfC = "xml".hashCode();
    private static final int gfD = "title".hashCode();
    private static final int gfE = "description".hashCode();
    private static final int gfF = "source".hashCode();
    public String field_appId;
    public String field_description;
    public long field_msgId;
    public String field_source;
    public String field_title;
    public int field_type;
    public String field_xml;
    private boolean gaO = true;
    private boolean gbE = true;
    private boolean gcu = true;
    private boolean gfA = true;
    private boolean gfB = true;
    private boolean gfy = true;
    private boolean gfz = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gaS == hashCode) {
                    this.field_msgId = cursor.getLong(i);
                    this.gaO = true;
                } else if (gfC == hashCode) {
                    this.field_xml = cursor.getString(i);
                } else if (gcL == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (gfD == hashCode) {
                    this.field_title = cursor.getString(i);
                } else if (gfE == hashCode) {
                    this.field_description = cursor.getString(i);
                } else if (gfF == hashCode) {
                    this.field_source = cursor.getString(i);
                } else if (gca == hashCode) {
                    this.field_type = cursor.getInt(i);
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
        if (this.gfy) {
            contentValues.put("xml", this.field_xml);
        }
        if (this.gcu) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.gfz) {
            contentValues.put("title", this.field_title);
        }
        if (this.gfA) {
            contentValues.put("description", this.field_description);
        }
        if (this.gfB) {
            contentValues.put("source", this.field_source);
        }
        if (this.gbE) {
            contentValues.put(Columns.TYPE, Integer.valueOf(this.field_type));
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
