package com.tencent.mm.plugin.record.a;

import com.tencent.mm.e.b.cn;
import com.tencent.mm.plugin.record.a.f.a;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.lang.reflect.Field;

public final class g extends cn implements a {
    protected static c.a gTP;

    static {
        c.a aVar = new c.a();
        aVar.hXH = new Field[15];
        aVar.columns = new String[16];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "localId";
        aVar.uxd.put("localId", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" localId INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.uxc = "localId";
        aVar.columns[1] = "recordLocalId";
        aVar.uxd.put("recordLocalId", "INTEGER");
        stringBuilder.append(" recordLocalId INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "toUser";
        aVar.uxd.put("toUser", "TEXT default '' ");
        stringBuilder.append(" toUser TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[3] = "dataId";
        aVar.uxd.put("dataId", "TEXT");
        stringBuilder.append(" dataId TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "mediaId";
        aVar.uxd.put("mediaId", "TEXT");
        stringBuilder.append(" mediaId TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "path";
        aVar.uxd.put("path", "TEXT");
        stringBuilder.append(" path TEXT");
        stringBuilder.append(", ");
        aVar.columns[6] = "cdnUrl";
        aVar.uxd.put("cdnUrl", "TEXT");
        stringBuilder.append(" cdnUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[7] = "cdnKey";
        aVar.uxd.put("cdnKey", "TEXT");
        stringBuilder.append(" cdnKey TEXT");
        stringBuilder.append(", ");
        aVar.columns[8] = "totalLen";
        aVar.uxd.put("totalLen", "INTEGER default '0' ");
        stringBuilder.append(" totalLen INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[9] = "isThumb";
        aVar.uxd.put("isThumb", "INTEGER default 'false' ");
        stringBuilder.append(" isThumb INTEGER default 'false' ");
        stringBuilder.append(", ");
        aVar.columns[10] = "offset";
        aVar.uxd.put("offset", "INTEGER default '0' ");
        stringBuilder.append(" offset INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[11] = Columns.TYPE;
        aVar.uxd.put(Columns.TYPE, "INTEGER default '0' ");
        stringBuilder.append(" type INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[12] = "fileType";
        aVar.uxd.put("fileType", "INTEGER default '5' ");
        stringBuilder.append(" fileType INTEGER default '5' ");
        stringBuilder.append(", ");
        aVar.columns[13] = DownloadInfo.STATUS;
        aVar.uxd.put(DownloadInfo.STATUS, "INTEGER default '0' ");
        stringBuilder.append(" status INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[14] = "errCode";
        aVar.uxd.put("errCode", "INTEGER default '0' ");
        stringBuilder.append(" errCode INTEGER default '0' ");
        aVar.columns[15] = "rowid";
        aVar.uxe = stringBuilder.toString();
        gTP = aVar;
    }

    protected final c.a sY() {
        return gTP;
    }

    public final int aWC() {
        return this.field_localId;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("localid[").append(this.field_localId).append("]\n");
        stringBuilder.append("recordId[").append(this.field_recordLocalId).append("]\n");
        stringBuilder.append("mediaId[").append(this.field_mediaId).append("]\n");
        stringBuilder.append("dataId[").append(this.field_dataId).append("]\n");
        stringBuilder.append("path[").append(this.field_path).append("]\n");
        stringBuilder.append("cdnurl[").append(this.field_cdnUrl).append("]\n");
        stringBuilder.append("cdnkey[").append(this.field_cdnKey).append("]\n");
        stringBuilder.append("type[").append(this.field_type).append("]\n");
        stringBuilder.append("errCode[").append(this.field_errCode).append("]\n");
        stringBuilder.append("fileType[").append(this.field_fileType).append("]\n");
        stringBuilder.append("isThumb[").append(this.field_isThumb).append("]\n");
        stringBuilder.append("status[").append(this.field_status).append("]\n");
        stringBuilder.append("totalLen[").append(this.field_totalLen).append("]\n");
        stringBuilder.append("offset[").append(this.field_offset).append("]\n");
        stringBuilder.append("toUser[").append(this.field_toUser).append("]\n");
        return stringBuilder.toString();
    }
}
