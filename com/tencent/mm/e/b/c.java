package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;

public abstract class c extends com.tencent.mm.sdk.e.c {
    public static final String[] gaK = new String[0];
    private static final int gaT = "rowid".hashCode();
    private static final int gbi = "abtestkey".hashCode();
    private static final int gbj = Columns.VALUE.hashCode();
    private static final int gbk = "expId".hashCode();
    private static final int gbl = "sequence".hashCode();
    private static final int gbm = "prioritylevel".hashCode();
    private static final int gbn = "startTime".hashCode();
    private static final int gbo = "endTime".hashCode();
    private static final int gbp = "noReport".hashCode();
    public String field_abtestkey;
    public long field_endTime;
    public String field_expId;
    public boolean field_noReport;
    public int field_prioritylevel;
    public long field_sequence;
    public long field_startTime;
    public String field_value;
    private boolean gba = true;
    private boolean gbb = true;
    private boolean gbc = true;
    private boolean gbd = true;
    private boolean gbe = true;
    private boolean gbf = true;
    private boolean gbg = true;
    private boolean gbh = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gbi == hashCode) {
                    this.field_abtestkey = cursor.getString(i);
                    this.gba = true;
                } else if (gbj == hashCode) {
                    this.field_value = cursor.getString(i);
                } else if (gbk == hashCode) {
                    this.field_expId = cursor.getString(i);
                } else if (gbl == hashCode) {
                    this.field_sequence = cursor.getLong(i);
                } else if (gbm == hashCode) {
                    this.field_prioritylevel = cursor.getInt(i);
                } else if (gbn == hashCode) {
                    this.field_startTime = cursor.getLong(i);
                } else if (gbo == hashCode) {
                    this.field_endTime = cursor.getLong(i);
                } else if (gbp == hashCode) {
                    this.field_noReport = cursor.getInt(i) != 0;
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.gba) {
            contentValues.put("abtestkey", this.field_abtestkey);
        }
        if (this.gbb) {
            contentValues.put(Columns.VALUE, this.field_value);
        }
        if (this.gbc) {
            contentValues.put("expId", this.field_expId);
        }
        if (this.gbd) {
            contentValues.put("sequence", Long.valueOf(this.field_sequence));
        }
        if (this.gbe) {
            contentValues.put("prioritylevel", Integer.valueOf(this.field_prioritylevel));
        }
        if (this.gbf) {
            contentValues.put("startTime", Long.valueOf(this.field_startTime));
        }
        if (this.gbg) {
            contentValues.put("endTime", Long.valueOf(this.field_endTime));
        }
        if (this.gbh) {
            contentValues.put("noReport", Boolean.valueOf(this.field_noReport));
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
