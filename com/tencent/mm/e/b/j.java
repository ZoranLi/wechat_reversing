package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class j extends c {
    public static final String[] gaK = new String[]{"CREATE INDEX IF NOT EXISTS AppBrandLauncherLayoutItemUpdateTimeIndex ON AppBrandLauncherLayoutItem(updateTime)", "CREATE INDEX IF NOT EXISTS AppBrandLauncherLayoutItemSceneIndex ON AppBrandLauncherLayoutItem(scene)"};
    private static final int gaT = "rowid".hashCode();
    private static final int gcs = "scene".hashCode();
    private static final int gdo = "recordId".hashCode();
    private static final int gdp = "brandId".hashCode();
    private static final int gdq = "versionType".hashCode();
    private static final int gdr = "updateTime".hashCode();
    public String field_brandId;
    public int field_recordId;
    public int field_scene;
    public long field_updateTime;
    public int field_versionType;
    private boolean gcq = true;
    private boolean gdk = true;
    private boolean gdl = true;
    private boolean gdm = true;
    private boolean gdn = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gdo == hashCode) {
                    this.field_recordId = cursor.getInt(i);
                    this.gdk = true;
                } else if (gdp == hashCode) {
                    this.field_brandId = cursor.getString(i);
                } else if (gdq == hashCode) {
                    this.field_versionType = cursor.getInt(i);
                } else if (gdr == hashCode) {
                    this.field_updateTime = cursor.getLong(i);
                } else if (gcs == hashCode) {
                    this.field_scene = cursor.getInt(i);
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.gdk) {
            contentValues.put("recordId", Integer.valueOf(this.field_recordId));
        }
        if (this.gdl) {
            contentValues.put("brandId", this.field_brandId);
        }
        if (this.gdm) {
            contentValues.put("versionType", Integer.valueOf(this.field_versionType));
        }
        if (this.gdn) {
            contentValues.put("updateTime", Long.valueOf(this.field_updateTime));
        }
        if (this.gcq) {
            contentValues.put("scene", Integer.valueOf(this.field_scene));
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
