package com.tencent.mm.modelvideo;

import com.tencent.mm.e.b.cx;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.lang.reflect.Field;

public final class j extends cx {
    protected static a gTP;

    static {
        a aVar = new a();
        aVar.hXH = new Field[8];
        aVar.columns = new String[9];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "localId";
        aVar.uxd.put("localId", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" localId INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.uxc = "localId";
        aVar.columns[1] = DownloadInfo.FILENAME;
        aVar.uxd.put(DownloadInfo.FILENAME, "TEXT");
        stringBuilder.append(" fileName TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "fileNameHash";
        aVar.uxd.put("fileNameHash", "INTEGER");
        stringBuilder.append(" fileNameHash INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = "fileMd5";
        aVar.uxd.put("fileMd5", "TEXT default '' ");
        stringBuilder.append(" fileMd5 TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[4] = "fileLength";
        aVar.uxd.put("fileLength", "LONG default '0' ");
        stringBuilder.append(" fileLength LONG default '0' ");
        stringBuilder.append(", ");
        aVar.columns[5] = "fileStatus";
        aVar.uxd.put("fileStatus", "INTEGER default '0' ");
        stringBuilder.append(" fileStatus INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[6] = "fileDuration";
        aVar.uxd.put("fileDuration", "INTEGER default '0' ");
        stringBuilder.append(" fileDuration INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[7] = "createTime";
        aVar.uxd.put("createTime", "LONG default '0' ");
        stringBuilder.append(" createTime LONG default '0' ");
        aVar.columns[8] = "rowid";
        aVar.uxe = stringBuilder.toString();
        gTP = aVar;
    }

    protected final a sY() {
        return gTP;
    }
}
