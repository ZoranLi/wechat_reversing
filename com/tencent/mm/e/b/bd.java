package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;

public abstract class bd extends c {
    public static final String[] gaK = new String[0];
    private static final int gaT = "rowid".hashCode();
    private static final int gaZ = DownloadInfo.STATUS.hashCode();
    private static final int gbn = "startTime".hashCode();
    private static final int gcL = "appId".hashCode();
    private static final int gcs = "scene".hashCode();
    private static final int geJ = DownloadInfoColumns.PACKAGENAME.hashCode();
    private static final int gns = "md5".hashCode();
    private static final int gqI = "downloadId".hashCode();
    private static final int gqJ = "downloadUrl".hashCode();
    private static final int gqK = DownloadInfo.SECONDARYURL.hashCode();
    private static final int gqL = "fileSize".hashCode();
    private static final int gqM = DownloadInfo.FILENAME.hashCode();
    private static final int gqN = DownloadInfoColumns.FILEPATH.hashCode();
    private static final int gqO = "fileType".hashCode();
    private static final int gqP = "autoInstall".hashCode();
    private static final int gqQ = "showNotification".hashCode();
    private static final int gqR = "sysDownloadId".hashCode();
    private static final int gqS = "downloaderType".hashCode();
    private static final int gqT = "downloadUrlHashCode".hashCode();
    private static final int gqU = "downloadedSize".hashCode();
    private static final int gqV = "totalSize".hashCode();
    private static final int gqW = "autoDownload".hashCode();
    private static final int gqX = DownloadInfoColumns.CHANNELID.hashCode();
    private static final int gqY = "errCode".hashCode();
    private static final int gqZ = "startSize".hashCode();
    private static final int gra = "startState".hashCode();
    public String field_appId;
    public boolean field_autoDownload;
    public boolean field_autoInstall;
    public String field_channelId;
    public long field_downloadId;
    public String field_downloadUrl;
    public int field_downloadUrlHashCode;
    public long field_downloadedSize;
    public int field_downloaderType;
    public int field_errCode;
    public String field_fileName;
    public String field_filePath;
    public long field_fileSize;
    public int field_fileType;
    public String field_md5;
    public String field_packageName;
    public int field_scene;
    public String field_secondaryUrl;
    public boolean field_showNotification;
    public long field_startSize;
    public int field_startState;
    public long field_startTime;
    public int field_status;
    public long field_sysDownloadId;
    public long field_totalSize;
    private boolean gaW = true;
    private boolean gbf = true;
    private boolean gcq = true;
    private boolean gcu = true;
    private boolean gen = true;
    private boolean gmV = true;
    private boolean gqA = true;
    private boolean gqB = true;
    private boolean gqC = true;
    private boolean gqD = true;
    private boolean gqE = true;
    private boolean gqF = true;
    private boolean gqG = true;
    private boolean gqH = true;
    private boolean gqp = true;
    private boolean gqq = true;
    private boolean gqr = true;
    private boolean gqs = true;
    private boolean gqt = true;
    private boolean gqu = true;
    private boolean gqv = true;
    private boolean gqw = true;
    private boolean gqx = true;
    private boolean gqy = true;
    private boolean gqz = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gqI == hashCode) {
                    this.field_downloadId = cursor.getLong(i);
                    this.gqp = true;
                } else if (gqJ == hashCode) {
                    this.field_downloadUrl = cursor.getString(i);
                } else if (gqK == hashCode) {
                    this.field_secondaryUrl = cursor.getString(i);
                } else if (gqL == hashCode) {
                    this.field_fileSize = cursor.getLong(i);
                } else if (gqM == hashCode) {
                    this.field_fileName = cursor.getString(i);
                } else if (gqN == hashCode) {
                    this.field_filePath = cursor.getString(i);
                } else if (gqO == hashCode) {
                    this.field_fileType = cursor.getInt(i);
                } else if (gaZ == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (gns == hashCode) {
                    this.field_md5 = cursor.getString(i);
                } else if (gqP == hashCode) {
                    this.field_autoInstall = cursor.getInt(i) != 0;
                } else if (gqQ == hashCode) {
                    this.field_showNotification = cursor.getInt(i) != 0;
                } else if (gqR == hashCode) {
                    this.field_sysDownloadId = cursor.getLong(i);
                } else if (gqS == hashCode) {
                    this.field_downloaderType = cursor.getInt(i);
                } else if (gcL == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (gqT == hashCode) {
                    this.field_downloadUrlHashCode = cursor.getInt(i);
                } else if (geJ == hashCode) {
                    this.field_packageName = cursor.getString(i);
                } else if (gqU == hashCode) {
                    this.field_downloadedSize = cursor.getLong(i);
                } else if (gqV == hashCode) {
                    this.field_totalSize = cursor.getLong(i);
                } else if (gqW == hashCode) {
                    this.field_autoDownload = cursor.getInt(i) != 0;
                } else if (gqX == hashCode) {
                    this.field_channelId = cursor.getString(i);
                } else if (gcs == hashCode) {
                    this.field_scene = cursor.getInt(i);
                } else if (gqY == hashCode) {
                    this.field_errCode = cursor.getInt(i);
                } else if (gbn == hashCode) {
                    this.field_startTime = cursor.getLong(i);
                } else if (gqZ == hashCode) {
                    this.field_startSize = cursor.getLong(i);
                } else if (gra == hashCode) {
                    this.field_startState = cursor.getInt(i);
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.gqp) {
            contentValues.put("downloadId", Long.valueOf(this.field_downloadId));
        }
        if (this.field_downloadUrl == null) {
            this.field_downloadUrl = "";
        }
        if (this.gqq) {
            contentValues.put("downloadUrl", this.field_downloadUrl);
        }
        if (this.field_secondaryUrl == null) {
            this.field_secondaryUrl = "";
        }
        if (this.gqr) {
            contentValues.put(DownloadInfo.SECONDARYURL, this.field_secondaryUrl);
        }
        if (this.gqs) {
            contentValues.put("fileSize", Long.valueOf(this.field_fileSize));
        }
        if (this.field_fileName == null) {
            this.field_fileName = "";
        }
        if (this.gqt) {
            contentValues.put(DownloadInfo.FILENAME, this.field_fileName);
        }
        if (this.field_filePath == null) {
            this.field_filePath = "";
        }
        if (this.gqu) {
            contentValues.put(DownloadInfoColumns.FILEPATH, this.field_filePath);
        }
        if (this.gqv) {
            contentValues.put("fileType", Integer.valueOf(this.field_fileType));
        }
        if (this.gaW) {
            contentValues.put(DownloadInfo.STATUS, Integer.valueOf(this.field_status));
        }
        if (this.field_md5 == null) {
            this.field_md5 = "";
        }
        if (this.gmV) {
            contentValues.put("md5", this.field_md5);
        }
        if (this.gqw) {
            contentValues.put("autoInstall", Boolean.valueOf(this.field_autoInstall));
        }
        if (this.gqx) {
            contentValues.put("showNotification", Boolean.valueOf(this.field_showNotification));
        }
        if (this.gqy) {
            contentValues.put("sysDownloadId", Long.valueOf(this.field_sysDownloadId));
        }
        if (this.gqz) {
            contentValues.put("downloaderType", Integer.valueOf(this.field_downloaderType));
        }
        if (this.field_appId == null) {
            this.field_appId = "";
        }
        if (this.gcu) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.gqA) {
            contentValues.put("downloadUrlHashCode", Integer.valueOf(this.field_downloadUrlHashCode));
        }
        if (this.field_packageName == null) {
            this.field_packageName = "";
        }
        if (this.gen) {
            contentValues.put(DownloadInfoColumns.PACKAGENAME, this.field_packageName);
        }
        if (this.gqB) {
            contentValues.put("downloadedSize", Long.valueOf(this.field_downloadedSize));
        }
        if (this.gqC) {
            contentValues.put("totalSize", Long.valueOf(this.field_totalSize));
        }
        if (this.gqD) {
            contentValues.put("autoDownload", Boolean.valueOf(this.field_autoDownload));
        }
        if (this.field_channelId == null) {
            this.field_channelId = "";
        }
        if (this.gqE) {
            contentValues.put(DownloadInfoColumns.CHANNELID, this.field_channelId);
        }
        if (this.gcq) {
            contentValues.put("scene", Integer.valueOf(this.field_scene));
        }
        if (this.gqF) {
            contentValues.put("errCode", Integer.valueOf(this.field_errCode));
        }
        if (this.gbf) {
            contentValues.put("startTime", Long.valueOf(this.field_startTime));
        }
        if (this.gqG) {
            contentValues.put("startSize", Long.valueOf(this.field_startSize));
        }
        if (this.gqH) {
            contentValues.put("startState", Integer.valueOf(this.field_startState));
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
