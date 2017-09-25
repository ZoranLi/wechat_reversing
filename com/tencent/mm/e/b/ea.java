package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ea extends c {
    private static final int gJp = "openDebug".hashCode();
    public static final String[] gaK = new String[0];
    private static final int gaT = "rowid".hashCode();
    private static final int gcL = "appId".hashCode();
    private static final int gwO = "appIdHash".hashCode();
    public String field_appId;
    public int field_appIdHash;
    public boolean field_openDebug;
    private boolean gJo = true;
    private boolean gcu = true;
    private boolean gwJ = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gwO == hashCode) {
                    this.field_appIdHash = cursor.getInt(i);
                    this.gwJ = true;
                } else if (gcL == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (gJp == hashCode) {
                    this.field_openDebug = cursor.getInt(i) != 0;
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.gwJ) {
            contentValues.put("appIdHash", Integer.valueOf(this.field_appIdHash));
        }
        if (this.gcu) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.gJo) {
            contentValues.put("openDebug", Boolean.valueOf(this.field_openDebug));
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
