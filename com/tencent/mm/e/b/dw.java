package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;

public abstract class dw extends c {
    private static final int gIh = "domin".hashCode();
    public static final String[] gaK = new String[0];
    private static final int gaT = "rowid".hashCode();
    private static final int gbj = Columns.VALUE.hashCode();
    private static final int gcL = "appId".hashCode();
    private static final int gdd = "key".hashCode();
    private static final int gdo = "recordId".hashCode();
    public String field_appId;
    public String field_domin;
    public String field_key;
    public int field_recordId;
    public String field_value;
    private boolean gIg = true;
    private boolean gbb = true;
    private boolean gcu = true;
    private boolean gdc = true;
    private boolean gdk = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gdo == hashCode) {
                    this.field_recordId = cursor.getInt(i);
                    this.gdk = true;
                } else if (gcL == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (gIh == hashCode) {
                    this.field_domin = cursor.getString(i);
                } else if (gdd == hashCode) {
                    this.field_key = cursor.getString(i);
                } else if (gbj == hashCode) {
                    this.field_value = cursor.getString(i);
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.gdk) {
            contentValues.put("recordId", Integer.valueOf(this.field_recordId));
        }
        if (this.gcu) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.gIg) {
            contentValues.put("domin", this.field_domin);
        }
        if (this.gdc) {
            contentValues.put("key", this.field_key);
        }
        if (this.gbb) {
            contentValues.put(Columns.VALUE, this.field_value);
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
