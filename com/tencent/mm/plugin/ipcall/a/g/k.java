package com.tencent.mm.plugin.ipcall.a.g;

import com.tencent.mm.e.b.bx;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.lang.reflect.Field;

public final class k extends bx {
    public static a gTP;

    static {
        a aVar = new a();
        aVar.hXH = new Field[6];
        aVar.columns = new String[7];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "phonenumber";
        aVar.uxd.put("phonenumber", "TEXT");
        stringBuilder.append(" phonenumber TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "calltime";
        aVar.uxd.put("calltime", "LONG");
        stringBuilder.append(" calltime LONG");
        stringBuilder.append(", ");
        aVar.columns[2] = FFmpegMetadataRetriever.METADATA_KEY_DURATION;
        aVar.uxd.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, "LONG");
        stringBuilder.append(" duration LONG");
        stringBuilder.append(", ");
        aVar.columns[3] = DownloadInfo.STATUS;
        aVar.uxd.put(DownloadInfo.STATUS, "INTEGER");
        stringBuilder.append(" status INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "addressId";
        aVar.uxd.put("addressId", "LONG default '-1' ");
        stringBuilder.append(" addressId LONG default '-1' ");
        stringBuilder.append(", ");
        aVar.columns[5] = "phoneType";
        aVar.uxd.put("phoneType", "INTEGER default '-1' ");
        stringBuilder.append(" phoneType INTEGER default '-1' ");
        aVar.columns[6] = "rowid";
        aVar.uxe = stringBuilder.toString();
        gTP = aVar;
    }

    protected final a sY() {
        return gTP;
    }
}
