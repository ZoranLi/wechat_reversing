package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;

public abstract class cy extends c {
    private static final int gCH = "cnValue".hashCode();
    private static final int gCI = "qqValue".hashCode();
    private static final int gCJ = "twValue".hashCode();
    private static final int gCK = "enValue".hashCode();
    private static final int gCL = "thValue".hashCode();
    private static final int gCM = "eggIndex".hashCode();
    private static final int gCN = "position".hashCode();
    public static final String[] gaK = new String[0];
    private static final int gaT = "rowid".hashCode();
    private static final int gdd = "key".hashCode();
    private static final int gfI = "flag".hashCode();
    private static final int gqM = DownloadInfo.FILENAME.hashCode();
    public String field_cnValue;
    public int field_eggIndex;
    public String field_enValue;
    public String field_fileName;
    public int field_flag;
    public String field_key;
    public int field_position;
    public String field_qqValue;
    public String field_thValue;
    public String field_twValue;
    private boolean gCA = true;
    private boolean gCB = true;
    private boolean gCC = true;
    private boolean gCD = true;
    private boolean gCE = true;
    private boolean gCF = true;
    private boolean gCG = true;
    private boolean gdc = true;
    private boolean gfG = true;
    private boolean gqt = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gdd == hashCode) {
                    this.field_key = cursor.getString(i);
                    this.gdc = true;
                } else if (gCH == hashCode) {
                    this.field_cnValue = cursor.getString(i);
                } else if (gCI == hashCode) {
                    this.field_qqValue = cursor.getString(i);
                } else if (gCJ == hashCode) {
                    this.field_twValue = cursor.getString(i);
                } else if (gCK == hashCode) {
                    this.field_enValue = cursor.getString(i);
                } else if (gCL == hashCode) {
                    this.field_thValue = cursor.getString(i);
                } else if (gqM == hashCode) {
                    this.field_fileName = cursor.getString(i);
                } else if (gCM == hashCode) {
                    this.field_eggIndex = cursor.getInt(i);
                } else if (gCN == hashCode) {
                    this.field_position = cursor.getInt(i);
                } else if (gfI == hashCode) {
                    this.field_flag = cursor.getInt(i);
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.gdc) {
            contentValues.put("key", this.field_key);
        }
        if (this.gCA) {
            contentValues.put("cnValue", this.field_cnValue);
        }
        if (this.gCB) {
            contentValues.put("qqValue", this.field_qqValue);
        }
        if (this.gCC) {
            contentValues.put("twValue", this.field_twValue);
        }
        if (this.gCD) {
            contentValues.put("enValue", this.field_enValue);
        }
        if (this.gCE) {
            contentValues.put("thValue", this.field_thValue);
        }
        if (this.gqt) {
            contentValues.put(DownloadInfo.FILENAME, this.field_fileName);
        }
        if (this.gCF) {
            contentValues.put("eggIndex", Integer.valueOf(this.field_eggIndex));
        }
        if (this.gCG) {
            contentValues.put("position", Integer.valueOf(this.field_position));
        }
        if (this.gfG) {
            contentValues.put("flag", Integer.valueOf(this.field_flag));
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
