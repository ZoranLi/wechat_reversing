package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;

public abstract class bx extends c {
    public static final String[] gaK = new String[0];
    private static final int gaT = "rowid".hashCode();
    private static final int gaZ = DownloadInfo.STATUS.hashCode();
    private static final int guO = "phonenumber".hashCode();
    private static final int guP = "calltime".hashCode();
    private static final int guQ = FFmpegMetadataRetriever.METADATA_KEY_DURATION.hashCode();
    private static final int guR = "addressId".hashCode();
    private static final int guS = "phoneType".hashCode();
    public long field_addressId;
    public long field_calltime;
    public long field_duration;
    public int field_phoneType;
    public String field_phonenumber;
    public int field_status;
    private boolean gaW = true;
    private boolean guJ = true;
    private boolean guK = true;
    private boolean guL = true;
    private boolean guM = true;
    private boolean guN = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (guO == hashCode) {
                    this.field_phonenumber = cursor.getString(i);
                } else if (guP == hashCode) {
                    this.field_calltime = cursor.getLong(i);
                } else if (guQ == hashCode) {
                    this.field_duration = cursor.getLong(i);
                } else if (gaZ == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (guR == hashCode) {
                    this.field_addressId = cursor.getLong(i);
                } else if (guS == hashCode) {
                    this.field_phoneType = cursor.getInt(i);
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.guJ) {
            contentValues.put("phonenumber", this.field_phonenumber);
        }
        if (this.guK) {
            contentValues.put("calltime", Long.valueOf(this.field_calltime));
        }
        if (this.guL) {
            contentValues.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, Long.valueOf(this.field_duration));
        }
        if (this.gaW) {
            contentValues.put(DownloadInfo.STATUS, Integer.valueOf(this.field_status));
        }
        if (this.guM) {
            contentValues.put("addressId", Long.valueOf(this.field_addressId));
        }
        if (this.guN) {
            contentValues.put("phoneType", Integer.valueOf(this.field_phoneType));
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
