package com.tencent.mm.pluginsdk.k.a.d;

import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.e.b.cq;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.lang.reflect.Field;

public final class q extends cq {
    public static final a gTP;

    static {
        a aVar = new a();
        aVar.hXH = new Field[34];
        aVar.columns = new String[35];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "urlKey_hashcode";
        aVar.uxd.put("urlKey_hashcode", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" urlKey_hashcode INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.uxc = "urlKey_hashcode";
        aVar.columns[1] = "urlKey";
        aVar.uxd.put("urlKey", "TEXT");
        stringBuilder.append(" urlKey TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = SlookSmartClipMetaTag.TAG_TYPE_URL;
        aVar.uxd.put(SlookSmartClipMetaTag.TAG_TYPE_URL, "TEXT");
        stringBuilder.append(" url TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "fileVersion";
        aVar.uxd.put("fileVersion", "TEXT");
        stringBuilder.append(" fileVersion TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "networkType";
        aVar.uxd.put("networkType", "INTEGER default '2' ");
        stringBuilder.append(" networkType INTEGER default '2' ");
        stringBuilder.append(", ");
        aVar.columns[5] = "maxRetryTimes";
        aVar.uxd.put("maxRetryTimes", "INTEGER default '3' ");
        stringBuilder.append(" maxRetryTimes INTEGER default '3' ");
        stringBuilder.append(", ");
        aVar.columns[6] = "retryTimes";
        aVar.uxd.put("retryTimes", "INTEGER default '3' ");
        stringBuilder.append(" retryTimes INTEGER default '3' ");
        stringBuilder.append(", ");
        aVar.columns[7] = DownloadInfoColumns.FILEPATH;
        aVar.uxd.put(DownloadInfoColumns.FILEPATH, "TEXT");
        stringBuilder.append(" filePath TEXT");
        stringBuilder.append(", ");
        aVar.columns[8] = DownloadInfo.STATUS;
        aVar.uxd.put(DownloadInfo.STATUS, "INTEGER default '0' ");
        stringBuilder.append(" status INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[9] = "contentLength";
        aVar.uxd.put("contentLength", "LONG default '0' ");
        stringBuilder.append(" contentLength LONG default '0' ");
        stringBuilder.append(", ");
        aVar.columns[10] = DownloadInfo.CONTENTTYPE;
        aVar.uxd.put(DownloadInfo.CONTENTTYPE, "TEXT");
        stringBuilder.append(" contentType TEXT");
        stringBuilder.append(", ");
        aVar.columns[11] = "expireTime";
        aVar.uxd.put("expireTime", "LONG default '0' ");
        stringBuilder.append(" expireTime LONG default '0' ");
        stringBuilder.append(", ");
        aVar.columns[12] = "md5";
        aVar.uxd.put("md5", "TEXT");
        stringBuilder.append(" md5 TEXT");
        stringBuilder.append(", ");
        aVar.columns[13] = "groupId1";
        aVar.uxd.put("groupId1", "TEXT");
        stringBuilder.append(" groupId1 TEXT");
        stringBuilder.append(", ");
        aVar.columns[14] = "groupId2";
        aVar.uxd.put("groupId2", "TEXT");
        stringBuilder.append(" groupId2 TEXT");
        stringBuilder.append(", ");
        aVar.columns[15] = DownloadInfo.PRIORITY;
        aVar.uxd.put(DownloadInfo.PRIORITY, "INTEGER default '0' ");
        stringBuilder.append(" priority INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[16] = "fileUpdated";
        aVar.uxd.put("fileUpdated", "INTEGER");
        stringBuilder.append(" fileUpdated INTEGER");
        stringBuilder.append(", ");
        aVar.columns[17] = "deleted";
        aVar.uxd.put("deleted", "INTEGER default 'false' ");
        stringBuilder.append(" deleted INTEGER default 'false' ");
        stringBuilder.append(", ");
        aVar.columns[18] = "resType";
        aVar.uxd.put("resType", "INTEGER");
        stringBuilder.append(" resType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[19] = "subType";
        aVar.uxd.put("subType", "INTEGER");
        stringBuilder.append(" subType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[20] = "reportId";
        aVar.uxd.put("reportId", "LONG");
        stringBuilder.append(" reportId LONG");
        stringBuilder.append(", ");
        aVar.columns[21] = "sampleId";
        aVar.uxd.put("sampleId", "TEXT");
        stringBuilder.append(" sampleId TEXT");
        stringBuilder.append(", ");
        aVar.columns[22] = "eccSignature";
        aVar.uxd.put("eccSignature", "BLOB");
        stringBuilder.append(" eccSignature BLOB");
        stringBuilder.append(", ");
        aVar.columns[23] = "originalMd5";
        aVar.uxd.put("originalMd5", "TEXT");
        stringBuilder.append(" originalMd5 TEXT");
        stringBuilder.append(", ");
        aVar.columns[24] = "fileCompress";
        aVar.uxd.put("fileCompress", "INTEGER default 'false' ");
        stringBuilder.append(" fileCompress INTEGER default 'false' ");
        stringBuilder.append(", ");
        aVar.columns[25] = "fileEncrypt";
        aVar.uxd.put("fileEncrypt", "INTEGER default 'false' ");
        stringBuilder.append(" fileEncrypt INTEGER default 'false' ");
        stringBuilder.append(", ");
        aVar.columns[26] = "encryptKey";
        aVar.uxd.put("encryptKey", "TEXT");
        stringBuilder.append(" encryptKey TEXT");
        stringBuilder.append(", ");
        aVar.columns[27] = "keyVersion";
        aVar.uxd.put("keyVersion", "INTEGER default '0' ");
        stringBuilder.append(" keyVersion INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[28] = "EID";
        aVar.uxd.put("EID", "INTEGER");
        stringBuilder.append(" EID INTEGER");
        stringBuilder.append(", ");
        aVar.columns[29] = "fileSize";
        aVar.uxd.put("fileSize", "LONG");
        stringBuilder.append(" fileSize LONG");
        stringBuilder.append(", ");
        aVar.columns[30] = "needRetry";
        aVar.uxd.put("needRetry", "INTEGER default '1' ");
        stringBuilder.append(" needRetry INTEGER default '1' ");
        stringBuilder.append(", ");
        aVar.columns[31] = "appId";
        aVar.uxd.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        aVar.columns[32] = "wvCacheType";
        aVar.uxd.put("wvCacheType", "INTEGER");
        stringBuilder.append(" wvCacheType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[33] = "packageId";
        aVar.uxd.put("packageId", "TEXT");
        stringBuilder.append(" packageId TEXT");
        aVar.columns[34] = "rowid";
        aVar.uxe = stringBuilder.toString();
        gTP = aVar;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("ResDownloaderRecord {");
        try {
            for (Field field : getClass().getSuperclass().getDeclaredFields()) {
                if (field.getName().startsWith("field_")) {
                    field.setAccessible(true);
                    stringBuilder.append(field.getName().replaceFirst("field_", "")).append(" = ").append(field.get(this)).append(", ");
                }
            }
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.ResDownloaderRecord", e, "", new Object[0]);
        }
        try {
            Field field2 = getClass().getSuperclass().getSuperclass().getField("systemRowid");
            field2.setAccessible(true);
            stringBuilder.append("systemRowid = ").append(field2.get(this));
        } catch (Throwable e2) {
            w.printErrStackTrace("MicroMsg.ResDownloaderRecord", e2, "", new Object[0]);
        } catch (Throwable e22) {
            w.printErrStackTrace("MicroMsg.ResDownloaderRecord", e22, "", new Object[0]);
        }
        return stringBuilder.append(" }").toString();
    }

    protected final a sY() {
        return gTP;
    }
}
