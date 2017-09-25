package com.tencent.mm.storage;

import com.tencent.mm.e.b.cj;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.lang.reflect.Field;

public final class aw extends cj {
    protected static a gTP;

    static {
        a aVar = new a();
        aVar.hXH = new Field[6];
        aVar.columns = new String[7];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "appId";
        aVar.uxd.put("appId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" appId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.uxc = "appId";
        aVar.columns[1] = DownloadInfoColumns.PACKAGENAME;
        aVar.uxd.put(DownloadInfoColumns.PACKAGENAME, "TEXT");
        stringBuilder.append(" packageName TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = DownloadInfo.STATUS;
        aVar.uxd.put(DownloadInfo.STATUS, "INTEGER default '0' ");
        stringBuilder.append(" status INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[3] = "sceneFlag";
        aVar.uxd.put("sceneFlag", "INTEGER default '0' ");
        stringBuilder.append(" sceneFlag INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[4] = "msgTypeFlag";
        aVar.uxd.put("msgTypeFlag", "INTEGER default '0' ");
        stringBuilder.append(" msgTypeFlag INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[5] = "msgState";
        aVar.uxd.put("msgState", "INTEGER default '0' ");
        stringBuilder.append(" msgState INTEGER default '0' ");
        aVar.columns[6] = "rowid";
        aVar.uxe = stringBuilder.toString();
        gTP = aVar;
    }

    protected final a sY() {
        return gTP;
    }
}
