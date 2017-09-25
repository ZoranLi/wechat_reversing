package com.tencent.mm.plugin.shake.a.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;

public abstract class a extends c {
    public static final String[] gaK = new String[0];
    private static final int gaT = "rowid".hashCode();
    private static final int gaZ = DownloadInfo.STATUS.hashCode();
    private static final int gca = Columns.TYPE.hashCode();
    private static final int gfD = "title".hashCode();
    private static final int gnA = "reserved3".hashCode();
    private static final int gnU = "desc".hashCode();
    private static final int gnt = "svrid".hashCode();
    private static final int gny = "reserved1".hashCode();
    private static final int gnz = "reserved2".hashCode();
    private static final int gpU = "subtype".hashCode();
    private static final int gqi = "tag".hashCode();
    private static final int gva = "createtime".hashCode();
    private static final int pnR = "thumburl".hashCode();
    private static final int pnS = "reservedBuf".hashCode();
    public long field_createtime;
    public String field_desc;
    public String field_reserved1;
    public String field_reserved2;
    public int field_reserved3;
    public byte[] field_reservedBuf;
    public int field_status;
    public int field_subtype;
    public long field_svrid;
    public String field_tag;
    public String field_thumburl;
    public String field_title;
    public int field_type;
    private boolean gaW = true;
    private boolean gbE = true;
    private boolean gfz = true;
    private boolean gmW = true;
    private boolean gnQ = true;
    private boolean gnb = true;
    private boolean gnc = true;
    private boolean gnd = true;
    private boolean gpS = true;
    private boolean gpY = true;
    private boolean guV = true;
    private boolean pnP = true;
    private boolean pnQ = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gnt == hashCode) {
                    this.field_svrid = cursor.getLong(i);
                    this.gmW = true;
                } else if (gca == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (gpU == hashCode) {
                    this.field_subtype = cursor.getInt(i);
                } else if (gva == hashCode) {
                    this.field_createtime = cursor.getLong(i);
                } else if (gqi == hashCode) {
                    this.field_tag = cursor.getString(i);
                } else if (gaZ == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (gfD == hashCode) {
                    this.field_title = cursor.getString(i);
                } else if (gnU == hashCode) {
                    this.field_desc = cursor.getString(i);
                } else if (pnR == hashCode) {
                    this.field_thumburl = cursor.getString(i);
                } else if (gny == hashCode) {
                    this.field_reserved1 = cursor.getString(i);
                } else if (gnz == hashCode) {
                    this.field_reserved2 = cursor.getString(i);
                } else if (gnA == hashCode) {
                    this.field_reserved3 = cursor.getInt(i);
                } else if (pnS == hashCode) {
                    this.field_reservedBuf = cursor.getBlob(i);
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.gmW) {
            contentValues.put("svrid", Long.valueOf(this.field_svrid));
        }
        if (this.gbE) {
            contentValues.put(Columns.TYPE, Integer.valueOf(this.field_type));
        }
        if (this.gpS) {
            contentValues.put("subtype", Integer.valueOf(this.field_subtype));
        }
        if (this.guV) {
            contentValues.put("createtime", Long.valueOf(this.field_createtime));
        }
        if (this.gpY) {
            contentValues.put("tag", this.field_tag);
        }
        if (this.gaW) {
            contentValues.put(DownloadInfo.STATUS, Integer.valueOf(this.field_status));
        }
        if (this.gfz) {
            contentValues.put("title", this.field_title);
        }
        if (this.gnQ) {
            contentValues.put("desc", this.field_desc);
        }
        if (this.pnP) {
            contentValues.put("thumburl", this.field_thumburl);
        }
        if (this.gnb) {
            contentValues.put("reserved1", this.field_reserved1);
        }
        if (this.gnc) {
            contentValues.put("reserved2", this.field_reserved2);
        }
        if (this.gnd) {
            contentValues.put("reserved3", Integer.valueOf(this.field_reserved3));
        }
        if (this.pnQ) {
            contentValues.put("reservedBuf", this.field_reservedBuf);
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
