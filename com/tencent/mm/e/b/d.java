package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class d extends c {
    public static final String[] gaK = new String[0];
    private static final int gaT = "rowid".hashCode();
    private static final int gbk = "expId".hashCode();
    private static final int gbl = "sequence".hashCode();
    private static final int gbm = "prioritylevel".hashCode();
    private static final int gbn = "startTime".hashCode();
    private static final int gbo = "endTime".hashCode();
    private static final int gbu = "layerId".hashCode();
    private static final int gbv = "business".hashCode();
    private static final int gbw = "needReport".hashCode();
    private static final int gbx = "rawXML".hashCode();
    public String field_business;
    public long field_endTime;
    public String field_expId;
    public String field_layerId;
    public boolean field_needReport;
    public int field_prioritylevel;
    public String field_rawXML;
    public long field_sequence;
    public long field_startTime;
    private boolean gbc = true;
    private boolean gbd = true;
    private boolean gbe = true;
    private boolean gbf = true;
    private boolean gbg = true;
    private boolean gbq = true;
    private boolean gbr = true;
    private boolean gbs = true;
    private boolean gbt = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gbu == hashCode) {
                    this.field_layerId = cursor.getString(i);
                    this.gbq = true;
                } else if (gbv == hashCode) {
                    this.field_business = cursor.getString(i);
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
                } else if (gbw == hashCode) {
                    this.field_needReport = cursor.getInt(i) != 0;
                } else if (gbx == hashCode) {
                    this.field_rawXML = cursor.getString(i);
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.gbq) {
            contentValues.put("layerId", this.field_layerId);
        }
        if (this.gbr) {
            contentValues.put("business", this.field_business);
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
        if (this.gbs) {
            contentValues.put("needReport", Boolean.valueOf(this.field_needReport));
        }
        if (this.field_rawXML == null) {
            this.field_rawXML = "";
        }
        if (this.gbt) {
            contentValues.put("rawXML", this.field_rawXML);
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
