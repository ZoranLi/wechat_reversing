package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class dt extends c {
    private static final int gHJ = "disable".hashCode();
    private static final int gHK = "configUrl".hashCode();
    private static final int gHL = "configResources".hashCode();
    private static final int gHM = "configCrc32".hashCode();
    private static final int gHN = "isFromXml".hashCode();
    public static final String[] gaK = new String[0];
    private static final int gaT = "rowid".hashCode();
    private static final int gpk = "configId".hashCode();
    public long field_configCrc32;
    public String field_configId;
    public String field_configResources;
    public String field_configUrl;
    public boolean field_disable;
    public boolean field_isFromXml;
    private boolean gHE = true;
    private boolean gHF = true;
    private boolean gHG = true;
    private boolean gHH = true;
    private boolean gHI = true;
    private boolean gpj = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gHJ == hashCode) {
                    boolean z;
                    if (cursor.getInt(i) != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    this.field_disable = z;
                } else if (gpk == hashCode) {
                    this.field_configId = cursor.getString(i);
                    this.gpj = true;
                } else if (gHK == hashCode) {
                    this.field_configUrl = cursor.getString(i);
                } else if (gHL == hashCode) {
                    this.field_configResources = cursor.getString(i);
                } else if (gHM == hashCode) {
                    this.field_configCrc32 = cursor.getLong(i);
                } else if (gHN == hashCode) {
                    this.field_isFromXml = cursor.getInt(i) != 0;
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.gHE) {
            contentValues.put("disable", Boolean.valueOf(this.field_disable));
        }
        if (this.gpj) {
            contentValues.put("configId", this.field_configId);
        }
        if (this.gHF) {
            contentValues.put("configUrl", this.field_configUrl);
        }
        if (this.gHG) {
            contentValues.put("configResources", this.field_configResources);
        }
        if (this.gHH) {
            contentValues.put("configCrc32", Long.valueOf(this.field_configCrc32));
        }
        if (this.gHI) {
            contentValues.put("isFromXml", Boolean.valueOf(this.field_isFromXml));
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
