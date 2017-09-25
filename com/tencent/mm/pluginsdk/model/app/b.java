package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.e.b.g;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.lang.reflect.Field;

public final class b extends g {
    protected static a gTP;

    static {
        a aVar = new a();
        aVar.hXH = new Field[20];
        aVar.columns = new String[21];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "appId";
        aVar.uxd.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "sdkVer";
        aVar.uxd.put("sdkVer", "LONG");
        stringBuilder.append(" sdkVer LONG");
        stringBuilder.append(", ");
        aVar.columns[2] = "mediaSvrId";
        aVar.uxd.put("mediaSvrId", "TEXT");
        stringBuilder.append(" mediaSvrId TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "mediaId";
        aVar.uxd.put("mediaId", "TEXT");
        stringBuilder.append(" mediaId TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "clientAppDataId";
        aVar.uxd.put("clientAppDataId", "TEXT");
        stringBuilder.append(" clientAppDataId TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = Columns.TYPE;
        aVar.uxd.put(Columns.TYPE, "LONG");
        stringBuilder.append(" type LONG");
        stringBuilder.append(", ");
        aVar.columns[6] = "totalLen";
        aVar.uxd.put("totalLen", "LONG");
        stringBuilder.append(" totalLen LONG");
        stringBuilder.append(", ");
        aVar.columns[7] = "offset";
        aVar.uxd.put("offset", "LONG");
        stringBuilder.append(" offset LONG");
        stringBuilder.append(", ");
        aVar.columns[8] = DownloadInfo.STATUS;
        aVar.uxd.put(DownloadInfo.STATUS, "LONG");
        stringBuilder.append(" status LONG");
        stringBuilder.append(", ");
        aVar.columns[9] = "isUpload";
        aVar.uxd.put("isUpload", "INTEGER");
        stringBuilder.append(" isUpload INTEGER");
        stringBuilder.append(", ");
        aVar.columns[10] = "createTime";
        aVar.uxd.put("createTime", "LONG");
        stringBuilder.append(" createTime LONG");
        stringBuilder.append(", ");
        aVar.columns[11] = "lastModifyTime";
        aVar.uxd.put("lastModifyTime", "LONG");
        stringBuilder.append(" lastModifyTime LONG");
        stringBuilder.append(", ");
        aVar.columns[12] = "fileFullPath";
        aVar.uxd.put("fileFullPath", "TEXT");
        stringBuilder.append(" fileFullPath TEXT");
        stringBuilder.append(", ");
        aVar.columns[13] = "fullXml";
        aVar.uxd.put("fullXml", "TEXT");
        stringBuilder.append(" fullXml TEXT");
        stringBuilder.append(", ");
        aVar.columns[14] = "msgInfoId";
        aVar.uxd.put("msgInfoId", "LONG");
        stringBuilder.append(" msgInfoId LONG");
        stringBuilder.append(", ");
        aVar.columns[15] = "netTimes";
        aVar.uxd.put("netTimes", "LONG");
        stringBuilder.append(" netTimes LONG");
        stringBuilder.append(", ");
        aVar.columns[16] = "isUseCdn";
        aVar.uxd.put("isUseCdn", "INTEGER");
        stringBuilder.append(" isUseCdn INTEGER");
        stringBuilder.append(", ");
        aVar.columns[17] = "signature";
        aVar.uxd.put("signature", "TEXT");
        stringBuilder.append(" signature TEXT");
        stringBuilder.append(", ");
        aVar.columns[18] = "fakeAeskey";
        aVar.uxd.put("fakeAeskey", "TEXT");
        stringBuilder.append(" fakeAeskey TEXT");
        stringBuilder.append(", ");
        aVar.columns[19] = "fakeSignature";
        aVar.uxd.put("fakeSignature", "TEXT");
        stringBuilder.append(" fakeSignature TEXT");
        aVar.columns[20] = "rowid";
        aVar.uxe = stringBuilder.toString();
        gTP = aVar;
    }

    protected final a sY() {
        return gTP;
    }

    public b() {
        this.field_netTimes = 0;
    }

    public final boolean azf() {
        if (this.field_totalLen > 0 && this.field_offset == this.field_totalLen) {
            return true;
        }
        return false;
    }
}
