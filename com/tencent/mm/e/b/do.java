package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class do extends c {
    private static final int gGI = "mNativeUrl".hashCode();
    private static final int gGJ = "hbType".hashCode();
    private static final int gGK = "receiveAmount".hashCode();
    private static final int gGL = "hbStatus".hashCode();
    public static final String[] gaK = new String[0];
    private static final int gaT = "rowid".hashCode();
    private static final int gsu = "receiveTime".hashCode();
    private static final int gzZ = "receiveStatus".hashCode();
    public int field_hbStatus;
    public int field_hbType;
    public String field_mNativeUrl;
    public long field_receiveAmount;
    public int field_receiveStatus;
    public long field_receiveTime;
    private boolean gGE = true;
    private boolean gGF = true;
    private boolean gGG = true;
    private boolean gGH = true;
    private boolean gsl = true;
    private boolean gzX = true;

    public void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gGI == hashCode) {
                    this.field_mNativeUrl = cursor.getString(i);
                    this.gGE = true;
                } else if (gGJ == hashCode) {
                    this.field_hbType = cursor.getInt(i);
                } else if (gGK == hashCode) {
                    this.field_receiveAmount = cursor.getLong(i);
                } else if (gsu == hashCode) {
                    this.field_receiveTime = cursor.getLong(i);
                } else if (gzZ == hashCode) {
                    this.field_receiveStatus = cursor.getInt(i);
                } else if (gGL == hashCode) {
                    this.field_hbStatus = cursor.getInt(i);
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.gGE) {
            contentValues.put("mNativeUrl", this.field_mNativeUrl);
        }
        if (this.gGF) {
            contentValues.put("hbType", Integer.valueOf(this.field_hbType));
        }
        if (this.gGG) {
            contentValues.put("receiveAmount", Long.valueOf(this.field_receiveAmount));
        }
        if (this.gsl) {
            contentValues.put("receiveTime", Long.valueOf(this.field_receiveTime));
        }
        if (this.gzX) {
            contentValues.put("receiveStatus", Integer.valueOf(this.field_receiveStatus));
        }
        if (this.gGH) {
            contentValues.put("hbStatus", Integer.valueOf(this.field_hbStatus));
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
