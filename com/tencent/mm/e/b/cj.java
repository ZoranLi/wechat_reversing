package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;

public abstract class cj extends c {
    public static final String[] gaK = new String[0];
    private static final int gaT = "rowid".hashCode();
    private static final int gaZ = DownloadInfo.STATUS.hashCode();
    private static final int gcL = "appId".hashCode();
    private static final int geJ = DownloadInfoColumns.PACKAGENAME.hashCode();
    private static final int gzv = "sceneFlag".hashCode();
    private static final int gzw = "msgTypeFlag".hashCode();
    private static final int gzx = "msgState".hashCode();
    public String field_appId;
    public int field_msgState;
    public int field_msgTypeFlag;
    public String field_packageName;
    public int field_sceneFlag;
    public int field_status;
    private boolean gaW = true;
    private boolean gcu = true;
    private boolean gen = true;
    private boolean gzs = true;
    private boolean gzt = true;
    private boolean gzu = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gcL == hashCode) {
                    this.field_appId = cursor.getString(i);
                    this.gcu = true;
                } else if (geJ == hashCode) {
                    this.field_packageName = cursor.getString(i);
                } else if (gaZ == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (gzv == hashCode) {
                    this.field_sceneFlag = cursor.getInt(i);
                } else if (gzw == hashCode) {
                    this.field_msgTypeFlag = cursor.getInt(i);
                } else if (gzx == hashCode) {
                    this.field_msgState = cursor.getInt(i);
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.gcu) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.gen) {
            contentValues.put(DownloadInfoColumns.PACKAGENAME, this.field_packageName);
        }
        if (this.gaW) {
            contentValues.put(DownloadInfo.STATUS, Integer.valueOf(this.field_status));
        }
        if (this.gzs) {
            contentValues.put("sceneFlag", Integer.valueOf(this.field_sceneFlag));
        }
        if (this.gzt) {
            contentValues.put("msgTypeFlag", Integer.valueOf(this.field_msgTypeFlag));
        }
        if (this.gzu) {
            contentValues.put("msgState", Integer.valueOf(this.field_msgState));
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
