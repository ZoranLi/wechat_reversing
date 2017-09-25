package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;

public abstract class dd extends c {
    private static final int gDJ = "logtime".hashCode();
    private static final int gDK = "logsize".hashCode();
    private static final int gDL = "errorcount".hashCode();
    public static final String[] gaK = new String[]{"CREATE INDEX IF NOT EXISTS snsreport_kv_logtime ON SnsReportKv(logtime)"};
    private static final int gaT = "rowid".hashCode();
    private static final int gbj = Columns.VALUE.hashCode();
    private static final int gcR = "offset".hashCode();
    public int field_errorcount;
    public int field_logsize;
    public long field_logtime;
    public int field_offset;
    public byte[] field_value;
    private boolean gDG = true;
    private boolean gDH = true;
    private boolean gDI = true;
    private boolean gbb = true;
    private boolean gcA = true;

    public void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gDJ == hashCode) {
                    this.field_logtime = cursor.getLong(i);
                } else if (gcR == hashCode) {
                    this.field_offset = cursor.getInt(i);
                } else if (gDK == hashCode) {
                    this.field_logsize = cursor.getInt(i);
                } else if (gDL == hashCode) {
                    this.field_errorcount = cursor.getInt(i);
                } else if (gbj == hashCode) {
                    this.field_value = cursor.getBlob(i);
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.gDG) {
            contentValues.put("logtime", Long.valueOf(this.field_logtime));
        }
        if (this.gcA) {
            contentValues.put("offset", Integer.valueOf(this.field_offset));
        }
        if (this.gDH) {
            contentValues.put("logsize", Integer.valueOf(this.field_logsize));
        }
        if (this.gDI) {
            contentValues.put("errorcount", Integer.valueOf(this.field_errorcount));
        }
        if (this.gbb) {
            contentValues.put(Columns.VALUE, this.field_value);
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
