package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class m extends c {
    public static final String[] gaK = new String[]{"CREATE INDEX IF NOT EXISTS AppBrandWxaPkgManifestRecordPkgPathIndex ON AppBrandWxaPkgManifestRecord(pkgPath)"};
    private static final int gaT = "rowid".hashCode();
    private static final int gbX = "createTime".hashCode();
    private static final int gbn = "startTime".hashCode();
    private static final int gbo = "endTime".hashCode();
    private static final int gcL = "appId".hashCode();
    private static final int geb = "version".hashCode();
    private static final int gec = "versionMd5".hashCode();
    private static final int ged = "versionState".hashCode();
    private static final int gee = "pkgPath".hashCode();
    private static final int gef = "resourceCount".hashCode();
    private static final int geg = "debugType".hashCode();
    private static final int geh = "downloadURL".hashCode();
    public String field_appId;
    public long field_createTime;
    public int field_debugType;
    public String field_downloadURL;
    public long field_endTime;
    public String field_pkgPath;
    public int field_resourceCount;
    public long field_startTime;
    public int field_version;
    public String field_versionMd5;
    public int field_versionState;
    private boolean gbB = true;
    private boolean gbf = true;
    private boolean gbg = true;
    private boolean gcu = true;
    private boolean gdU = true;
    private boolean gdV = true;
    private boolean gdW = true;
    private boolean gdX = true;
    private boolean gdY = true;
    private boolean gdZ = true;
    private boolean gea = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gcL == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (geb == hashCode) {
                    this.field_version = cursor.getInt(i);
                } else if (gec == hashCode) {
                    this.field_versionMd5 = cursor.getString(i);
                } else if (ged == hashCode) {
                    this.field_versionState = cursor.getInt(i);
                } else if (gee == hashCode) {
                    this.field_pkgPath = cursor.getString(i);
                } else if (gbX == hashCode) {
                    this.field_createTime = cursor.getLong(i);
                } else if (gef == hashCode) {
                    this.field_resourceCount = cursor.getInt(i);
                } else if (geg == hashCode) {
                    this.field_debugType = cursor.getInt(i);
                } else if (geh == hashCode) {
                    this.field_downloadURL = cursor.getString(i);
                } else if (gbn == hashCode) {
                    this.field_startTime = cursor.getLong(i);
                } else if (gbo == hashCode) {
                    this.field_endTime = cursor.getLong(i);
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.gcu) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.gdU) {
            contentValues.put("version", Integer.valueOf(this.field_version));
        }
        if (this.gdV) {
            contentValues.put("versionMd5", this.field_versionMd5);
        }
        if (this.gdW) {
            contentValues.put("versionState", Integer.valueOf(this.field_versionState));
        }
        if (this.gdX) {
            contentValues.put("pkgPath", this.field_pkgPath);
        }
        if (this.gbB) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.gdY) {
            contentValues.put("resourceCount", Integer.valueOf(this.field_resourceCount));
        }
        if (this.gdZ) {
            contentValues.put("debugType", Integer.valueOf(this.field_debugType));
        }
        if (this.gea) {
            contentValues.put("downloadURL", this.field_downloadURL);
        }
        if (this.gbf) {
            contentValues.put("startTime", Long.valueOf(this.field_startTime));
        }
        if (this.gbg) {
            contentValues.put("endTime", Long.valueOf(this.field_endTime));
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
