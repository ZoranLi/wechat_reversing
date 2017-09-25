package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;

public abstract class dx extends c {
    private static final int gIp = "pkgId".hashCode();
    private static final int gIq = "rid".hashCode();
    private static final int gIr = "mimeType".hashCode();
    private static final int gIs = "downloadNetType".hashCode();
    private static final int gIt = "completeDownload".hashCode();
    private static final int gIu = "autoDownloadCount".hashCode();
    private static final int gIv = "fileDownloadCount".hashCode();
    public static final String[] gaK = new String[0];
    private static final int gaT = "rowid".hashCode();
    private static final int gbX = "createTime".hashCode();
    private static final int gdd = "key".hashCode();
    private static final int gdj = "size".hashCode();
    private static final int geb = "version".hashCode();
    private static final int gns = "md5".hashCode();
    private static final int gqJ = "downloadUrl".hashCode();
    private static final int gqN = DownloadInfoColumns.FILEPATH.hashCode();
    public int field_autoDownloadCount;
    public boolean field_completeDownload;
    public long field_createTime;
    public int field_downloadNetType;
    public String field_downloadUrl;
    public int field_fileDownloadCount;
    public String field_filePath;
    public String field_key;
    public String field_md5;
    public String field_mimeType;
    public String field_pkgId;
    public String field_rid;
    public int field_size;
    public String field_version;
    private boolean gIi = true;
    private boolean gIj = true;
    private boolean gIk = true;
    private boolean gIl = true;
    private boolean gIm = true;
    private boolean gIn = true;
    private boolean gIo = true;
    private boolean gbB = true;
    private boolean gdU = true;
    private boolean gdc = true;
    private boolean gdg = true;
    private boolean gmV = true;
    private boolean gqq = true;
    private boolean gqu = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gdd == hashCode) {
                    this.field_key = cursor.getString(i);
                    this.gdc = true;
                } else if (gIp == hashCode) {
                    this.field_pkgId = cursor.getString(i);
                } else if (geb == hashCode) {
                    this.field_version = cursor.getString(i);
                } else if (gqN == hashCode) {
                    this.field_filePath = cursor.getString(i);
                } else if (gIq == hashCode) {
                    this.field_rid = cursor.getString(i);
                } else if (gIr == hashCode) {
                    this.field_mimeType = cursor.getString(i);
                } else if (gns == hashCode) {
                    this.field_md5 = cursor.getString(i);
                } else if (gqJ == hashCode) {
                    this.field_downloadUrl = cursor.getString(i);
                } else if (gdj == hashCode) {
                    this.field_size = cursor.getInt(i);
                } else if (gIs == hashCode) {
                    this.field_downloadNetType = cursor.getInt(i);
                } else if (gIt == hashCode) {
                    this.field_completeDownload = cursor.getInt(i) != 0;
                } else if (gbX == hashCode) {
                    this.field_createTime = cursor.getLong(i);
                } else if (gIu == hashCode) {
                    this.field_autoDownloadCount = cursor.getInt(i);
                } else if (gIv == hashCode) {
                    this.field_fileDownloadCount = cursor.getInt(i);
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.gdc) {
            contentValues.put("key", this.field_key);
        }
        if (this.gIi) {
            contentValues.put("pkgId", this.field_pkgId);
        }
        if (this.gdU) {
            contentValues.put("version", this.field_version);
        }
        if (this.gqu) {
            contentValues.put(DownloadInfoColumns.FILEPATH, this.field_filePath);
        }
        if (this.gIj) {
            contentValues.put("rid", this.field_rid);
        }
        if (this.gIk) {
            contentValues.put("mimeType", this.field_mimeType);
        }
        if (this.gmV) {
            contentValues.put("md5", this.field_md5);
        }
        if (this.gqq) {
            contentValues.put("downloadUrl", this.field_downloadUrl);
        }
        if (this.gdg) {
            contentValues.put("size", Integer.valueOf(this.field_size));
        }
        if (this.gIl) {
            contentValues.put("downloadNetType", Integer.valueOf(this.field_downloadNetType));
        }
        if (this.gIm) {
            contentValues.put("completeDownload", Boolean.valueOf(this.field_completeDownload));
        }
        if (this.gbB) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.gIn) {
            contentValues.put("autoDownloadCount", Integer.valueOf(this.field_autoDownloadCount));
        }
        if (this.gIo) {
            contentValues.put("fileDownloadCount", Integer.valueOf(this.field_fileDownloadCount));
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
