package com.tencent.mm.plugin.webview.wepkg.a;

import com.tencent.mm.e.b.dx;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.lang.reflect.Field;

public final class a extends dx {
    public static final com.tencent.mm.sdk.e.c.a izp;

    static {
        com.tencent.mm.sdk.e.c.a aVar = new com.tencent.mm.sdk.e.c.a();
        aVar.hXH = new Field[14];
        aVar.columns = new String[15];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "key";
        aVar.uxd.put("key", "TEXT PRIMARY KEY ");
        stringBuilder.append(" key TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.uxc = "key";
        aVar.columns[1] = "pkgId";
        aVar.uxd.put("pkgId", "TEXT");
        stringBuilder.append(" pkgId TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "version";
        aVar.uxd.put("version", "TEXT");
        stringBuilder.append(" version TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = DownloadInfoColumns.FILEPATH;
        aVar.uxd.put(DownloadInfoColumns.FILEPATH, "TEXT");
        stringBuilder.append(" filePath TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "rid";
        aVar.uxd.put("rid", "TEXT");
        stringBuilder.append(" rid TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "mimeType";
        aVar.uxd.put("mimeType", "TEXT");
        stringBuilder.append(" mimeType TEXT");
        stringBuilder.append(", ");
        aVar.columns[6] = "md5";
        aVar.uxd.put("md5", "TEXT");
        stringBuilder.append(" md5 TEXT");
        stringBuilder.append(", ");
        aVar.columns[7] = "downloadUrl";
        aVar.uxd.put("downloadUrl", "TEXT");
        stringBuilder.append(" downloadUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[8] = "size";
        aVar.uxd.put("size", "INTEGER");
        stringBuilder.append(" size INTEGER");
        stringBuilder.append(", ");
        aVar.columns[9] = "downloadNetType";
        aVar.uxd.put("downloadNetType", "INTEGER");
        stringBuilder.append(" downloadNetType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[10] = "completeDownload";
        aVar.uxd.put("completeDownload", "INTEGER default 'false' ");
        stringBuilder.append(" completeDownload INTEGER default 'false' ");
        stringBuilder.append(", ");
        aVar.columns[11] = "createTime";
        aVar.uxd.put("createTime", "LONG");
        stringBuilder.append(" createTime LONG");
        stringBuilder.append(", ");
        aVar.columns[12] = "autoDownloadCount";
        aVar.uxd.put("autoDownloadCount", "INTEGER default '0' ");
        stringBuilder.append(" autoDownloadCount INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[13] = "fileDownloadCount";
        aVar.uxd.put("fileDownloadCount", "INTEGER default '0' ");
        stringBuilder.append(" fileDownloadCount INTEGER default '0' ");
        aVar.columns[14] = "rowid";
        aVar.uxe = stringBuilder.toString();
        izp = aVar;
    }

    protected final com.tencent.mm.sdk.e.c.a sY() {
        return izp;
    }
}
