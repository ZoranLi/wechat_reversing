package com.tencent.mm.plugin.subapp.c;

import com.tencent.mm.e.b.di;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.lang.reflect.Field;

public final class g extends di {
    protected static a gTP;
    int fRW = -1;

    static {
        a aVar = new a();
        aVar.hXH = new Field[17];
        aVar.columns = new String[18];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = FFmpegMetadataRetriever.METADATA_KEY_FILENAME;
        aVar.uxd.put(FFmpegMetadataRetriever.METADATA_KEY_FILENAME, "TEXT");
        stringBuilder.append(" filename TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "user";
        aVar.uxd.put("user", "TEXT");
        stringBuilder.append(" user TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "msgid";
        aVar.uxd.put("msgid", "LONG");
        stringBuilder.append(" msgid LONG");
        stringBuilder.append(", ");
        aVar.columns[3] = "offset";
        aVar.uxd.put("offset", "INTEGER");
        stringBuilder.append(" offset INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "filenowsize";
        aVar.uxd.put("filenowsize", "INTEGER");
        stringBuilder.append(" filenowsize INTEGER");
        stringBuilder.append(", ");
        aVar.columns[5] = "totallen";
        aVar.uxd.put("totallen", "INTEGER");
        stringBuilder.append(" totallen INTEGER");
        stringBuilder.append(", ");
        aVar.columns[6] = DownloadInfo.STATUS;
        aVar.uxd.put(DownloadInfo.STATUS, "INTEGER");
        stringBuilder.append(" status INTEGER");
        stringBuilder.append(", ");
        aVar.columns[7] = "createtime";
        aVar.uxd.put("createtime", "LONG");
        stringBuilder.append(" createtime LONG");
        stringBuilder.append(", ");
        aVar.columns[8] = "lastmodifytime";
        aVar.uxd.put("lastmodifytime", "LONG");
        stringBuilder.append(" lastmodifytime LONG");
        stringBuilder.append(", ");
        aVar.columns[9] = "clientid";
        aVar.uxd.put("clientid", "TEXT");
        stringBuilder.append(" clientid TEXT");
        stringBuilder.append(", ");
        aVar.columns[10] = "voicelenght";
        aVar.uxd.put("voicelenght", "INTEGER");
        stringBuilder.append(" voicelenght INTEGER");
        stringBuilder.append(", ");
        aVar.columns[11] = "msglocalid";
        aVar.uxd.put("msglocalid", "INTEGER");
        stringBuilder.append(" msglocalid INTEGER");
        stringBuilder.append(", ");
        aVar.columns[12] = "human";
        aVar.uxd.put("human", "TEXT");
        stringBuilder.append(" human TEXT");
        stringBuilder.append(", ");
        aVar.columns[13] = "voiceformat";
        aVar.uxd.put("voiceformat", "INTEGER");
        stringBuilder.append(" voiceformat INTEGER");
        stringBuilder.append(", ");
        aVar.columns[14] = "nettimes";
        aVar.uxd.put("nettimes", "INTEGER");
        stringBuilder.append(" nettimes INTEGER");
        stringBuilder.append(", ");
        aVar.columns[15] = "reserved1";
        aVar.uxd.put("reserved1", "INTEGER");
        stringBuilder.append(" reserved1 INTEGER");
        stringBuilder.append(", ");
        aVar.columns[16] = "reserved2";
        aVar.uxd.put("reserved2", "TEXT");
        stringBuilder.append(" reserved2 TEXT");
        aVar.columns[17] = "rowid";
        aVar.uxe = stringBuilder.toString();
        gTP = aVar;
    }

    protected final a sY() {
        return gTP;
    }

    public final boolean LC() {
        if ((this.field_status <= 1 || this.field_status > 3) && this.field_status != 8) {
            return false;
        }
        return true;
    }
}
