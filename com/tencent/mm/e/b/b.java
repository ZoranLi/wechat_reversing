package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;

public abstract class b extends c {
    public static final String[] gaK = new String[0];
    private static final int gaQ = "insertmsg".hashCode();
    private static final int gaT = "rowid".hashCode();
    private static final int gaX = "billNo".hashCode();
    private static final int gaY = "localMsgId".hashCode();
    private static final int gaZ = DownloadInfo.STATUS.hashCode();
    public String field_billNo;
    public boolean field_insertmsg;
    public long field_localMsgId;
    public int field_status;
    private boolean gaM = true;
    private boolean gaU = true;
    private boolean gaV = true;
    private boolean gaW = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gaX == hashCode) {
                    this.field_billNo = cursor.getString(i);
                    this.gaU = true;
                } else if (gaQ == hashCode) {
                    this.field_insertmsg = cursor.getInt(i) != 0;
                } else if (gaY == hashCode) {
                    this.field_localMsgId = cursor.getLong(i);
                } else if (gaZ == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.gaU) {
            contentValues.put("billNo", this.field_billNo);
        }
        if (this.gaM) {
            contentValues.put("insertmsg", Boolean.valueOf(this.field_insertmsg));
        }
        if (this.gaV) {
            contentValues.put("localMsgId", Long.valueOf(this.field_localMsgId));
        }
        if (this.gaW) {
            contentValues.put(DownloadInfo.STATUS, Integer.valueOf(this.field_status));
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
