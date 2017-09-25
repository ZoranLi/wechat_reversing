package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bw extends c {
    public static final String[] gaK = new String[0];
    private static final int gaT = "rowid".hashCode();
    private static final int guG = "countryCode".hashCode();
    private static final int guH = "callTimeCount".hashCode();
    private static final int guI = "lastCallTime".hashCode();
    public long field_callTimeCount;
    public int field_countryCode;
    public long field_lastCallTime;
    private boolean guD = true;
    private boolean guE = true;
    private boolean guF = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (guG == hashCode) {
                    this.field_countryCode = cursor.getInt(i);
                    this.guD = true;
                } else if (guH == hashCode) {
                    this.field_callTimeCount = cursor.getLong(i);
                } else if (guI == hashCode) {
                    this.field_lastCallTime = cursor.getLong(i);
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.guD) {
            contentValues.put("countryCode", Integer.valueOf(this.field_countryCode));
        }
        if (this.guE) {
            contentValues.put("callTimeCount", Long.valueOf(this.field_callTimeCount));
        }
        if (this.guF) {
            contentValues.put("lastCallTime", Long.valueOf(this.field_lastCallTime));
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
