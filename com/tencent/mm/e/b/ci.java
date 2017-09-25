package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;

public abstract class ci extends c {
    public static final String[] gaK = new String[0];
    private static final int gaT = "rowid".hashCode();
    private static final int gaZ = DownloadInfo.STATUS.hashCode();
    private static final int gzp = "reqkey".hashCode();
    private static final int gzq = "ack_key".hashCode();
    private static final int gzr = "receive_time".hashCode();
    public String field_ack_key;
    public long field_receive_time;
    public String field_reqkey;
    public int field_status;
    private boolean gaW = true;
    private boolean gzm = true;
    private boolean gzn = true;
    private boolean gzo = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gzp == hashCode) {
                    this.field_reqkey = cursor.getString(i);
                    this.gzm = true;
                } else if (gzq == hashCode) {
                    this.field_ack_key = cursor.getString(i);
                } else if (gaZ == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (gzr == hashCode) {
                    this.field_receive_time = cursor.getLong(i);
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.gzm) {
            contentValues.put("reqkey", this.field_reqkey);
        }
        if (this.gzn) {
            contentValues.put("ack_key", this.field_ack_key);
        }
        if (this.gaW) {
            contentValues.put(DownloadInfo.STATUS, Integer.valueOf(this.field_status));
        }
        if (this.gzo) {
            contentValues.put("receive_time", Long.valueOf(this.field_receive_time));
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
