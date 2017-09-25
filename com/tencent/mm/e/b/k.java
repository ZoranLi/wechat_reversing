package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class k extends c {
    public static final String[] gaK = new String[]{"CREATE INDEX IF NOT EXISTS AppBrandStarAppUpdateTimeIndex ON AppBrandStarApp(updateTime)"};
    private static final int gaT = "rowid".hashCode();
    private static final int gdq = "versionType".hashCode();
    private static final int gdr = "updateTime".hashCode();
    private static final int gdt = "username".hashCode();
    public long field_updateTime;
    public String field_username;
    public int field_versionType;
    private boolean gdm = true;
    private boolean gdn = true;
    private boolean gds = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gdt == hashCode) {
                    this.field_username = cursor.getString(i);
                } else if (gdq == hashCode) {
                    this.field_versionType = cursor.getInt(i);
                } else if (gdr == hashCode) {
                    this.field_updateTime = cursor.getLong(i);
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.gds) {
            contentValues.put("username", this.field_username);
        }
        if (this.gdm) {
            contentValues.put("versionType", Integer.valueOf(this.field_versionType));
        }
        if (this.gdn) {
            contentValues.put("updateTime", Long.valueOf(this.field_updateTime));
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
