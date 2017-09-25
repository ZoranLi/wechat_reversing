package com.tencent.mm.plugin.downloader.b;

import com.tencent.mm.e.b.bd;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.lang.reflect.Field;

public final class a extends bd {
    protected static com.tencent.mm.sdk.e.c.a gTP;

    static {
        com.tencent.mm.sdk.e.c.a aVar = new com.tencent.mm.sdk.e.c.a();
        aVar.hXH = new Field[25];
        aVar.columns = new String[26];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "downloadId";
        aVar.uxd.put("downloadId", "LONG default '-1'  PRIMARY KEY ");
        stringBuilder.append(" downloadId LONG default '-1'  PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.uxc = "downloadId";
        aVar.columns[1] = "downloadUrl";
        aVar.uxd.put("downloadUrl", "TEXT default '' ");
        stringBuilder.append(" downloadUrl TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[2] = DownloadInfo.SECONDARYURL;
        aVar.uxd.put(DownloadInfo.SECONDARYURL, "TEXT default '' ");
        stringBuilder.append(" secondaryUrl TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[3] = "fileSize";
        aVar.uxd.put("fileSize", "LONG default '0' ");
        stringBuilder.append(" fileSize LONG default '0' ");
        stringBuilder.append(", ");
        aVar.columns[4] = DownloadInfo.FILENAME;
        aVar.uxd.put(DownloadInfo.FILENAME, "TEXT default '' ");
        stringBuilder.append(" fileName TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[5] = DownloadInfoColumns.FILEPATH;
        aVar.uxd.put(DownloadInfoColumns.FILEPATH, "TEXT default '' ");
        stringBuilder.append(" filePath TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[6] = "fileType";
        aVar.uxd.put("fileType", "INTEGER default '0' ");
        stringBuilder.append(" fileType INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[7] = DownloadInfo.STATUS;
        aVar.uxd.put(DownloadInfo.STATUS, "INTEGER default '0' ");
        stringBuilder.append(" status INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[8] = "md5";
        aVar.uxd.put("md5", "TEXT default '' ");
        stringBuilder.append(" md5 TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[9] = "autoInstall";
        aVar.uxd.put("autoInstall", "INTEGER default 'false' ");
        stringBuilder.append(" autoInstall INTEGER default 'false' ");
        stringBuilder.append(", ");
        aVar.columns[10] = "showNotification";
        aVar.uxd.put("showNotification", "INTEGER default 'false' ");
        stringBuilder.append(" showNotification INTEGER default 'false' ");
        stringBuilder.append(", ");
        aVar.columns[11] = "sysDownloadId";
        aVar.uxd.put("sysDownloadId", "LONG default '-1' ");
        stringBuilder.append(" sysDownloadId LONG default '-1' ");
        stringBuilder.append(", ");
        aVar.columns[12] = "downloaderType";
        aVar.uxd.put("downloaderType", "INTEGER default '0' ");
        stringBuilder.append(" downloaderType INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[13] = "appId";
        aVar.uxd.put("appId", "TEXT default '' ");
        stringBuilder.append(" appId TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[14] = "downloadUrlHashCode";
        aVar.uxd.put("downloadUrlHashCode", "INTEGER default '0' ");
        stringBuilder.append(" downloadUrlHashCode INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[15] = DownloadInfoColumns.PACKAGENAME;
        aVar.uxd.put(DownloadInfoColumns.PACKAGENAME, "TEXT default '' ");
        stringBuilder.append(" packageName TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[16] = "downloadedSize";
        aVar.uxd.put("downloadedSize", "LONG default '0' ");
        stringBuilder.append(" downloadedSize LONG default '0' ");
        stringBuilder.append(", ");
        aVar.columns[17] = "totalSize";
        aVar.uxd.put("totalSize", "LONG default '0' ");
        stringBuilder.append(" totalSize LONG default '0' ");
        stringBuilder.append(", ");
        aVar.columns[18] = "autoDownload";
        aVar.uxd.put("autoDownload", "INTEGER default 'false' ");
        stringBuilder.append(" autoDownload INTEGER default 'false' ");
        stringBuilder.append(", ");
        aVar.columns[19] = DownloadInfoColumns.CHANNELID;
        aVar.uxd.put(DownloadInfoColumns.CHANNELID, "TEXT default '' ");
        stringBuilder.append(" channelId TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[20] = "scene";
        aVar.uxd.put("scene", "INTEGER default '0' ");
        stringBuilder.append(" scene INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[21] = "errCode";
        aVar.uxd.put("errCode", "INTEGER default '0' ");
        stringBuilder.append(" errCode INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[22] = "startTime";
        aVar.uxd.put("startTime", "LONG default '0' ");
        stringBuilder.append(" startTime LONG default '0' ");
        stringBuilder.append(", ");
        aVar.columns[23] = "startSize";
        aVar.uxd.put("startSize", "LONG default '0' ");
        stringBuilder.append(" startSize LONG default '0' ");
        stringBuilder.append(", ");
        aVar.columns[24] = "startState";
        aVar.uxd.put("startState", "INTEGER default '0' ");
        stringBuilder.append(" startState INTEGER default '0' ");
        aVar.columns[25] = "rowid";
        aVar.uxe = stringBuilder.toString();
        gTP = aVar;
    }

    protected final com.tencent.mm.sdk.e.c.a sY() {
        return gTP;
    }
}