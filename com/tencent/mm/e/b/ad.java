package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;

public abstract class ad extends c {
    public static final String[] gaK = new String[]{"CREATE INDEX IF NOT EXISTS CardQrCodeDataInfo_card_id_index ON CardQrCodeDataInfo(card_id)"};
    private static final int gaT = "rowid".hashCode();
    private static final int gaZ = DownloadInfo.STATUS.hashCode();
    private static final int giw = "card_id".hashCode();
    private static final int gja = "code_id".hashCode();
    private static final int gjb = TMQQDownloaderOpenSDKConst.UINTYPE_CODE.hashCode();
    public String field_card_id;
    public String field_code;
    public String field_code_id;
    public int field_status;
    private boolean gaW = true;
    private boolean giY = true;
    private boolean giZ = true;
    private boolean gid = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gja == hashCode) {
                    this.field_code_id = cursor.getString(i);
                } else if (giw == hashCode) {
                    this.field_card_id = cursor.getString(i);
                } else if (gjb == hashCode) {
                    this.field_code = cursor.getString(i);
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
        if (this.giY) {
            contentValues.put("code_id", this.field_code_id);
        }
        if (this.gid) {
            contentValues.put("card_id", this.field_card_id);
        }
        if (this.giZ) {
            contentValues.put(TMQQDownloaderOpenSDKConst.UINTYPE_CODE, this.field_code);
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
