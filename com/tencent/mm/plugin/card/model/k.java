package com.tencent.mm.plugin.card.model;

import com.tencent.mm.e.b.ad;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.lang.reflect.Field;

public final class k extends ad {
    public static a gTP;

    static {
        a aVar = new a();
        aVar.hXH = new Field[4];
        aVar.columns = new String[5];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "code_id";
        aVar.uxd.put("code_id", "TEXT");
        stringBuilder.append(" code_id TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "card_id";
        aVar.uxd.put("card_id", "TEXT");
        stringBuilder.append(" card_id TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = TMQQDownloaderOpenSDKConst.UINTYPE_CODE;
        aVar.uxd.put(TMQQDownloaderOpenSDKConst.UINTYPE_CODE, "TEXT");
        stringBuilder.append(" code TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = DownloadInfo.STATUS;
        aVar.uxd.put(DownloadInfo.STATUS, "INTEGER");
        stringBuilder.append(" status INTEGER");
        aVar.columns[4] = "rowid";
        aVar.uxe = stringBuilder.toString();
        gTP = aVar;
    }

    protected final a sY() {
        return gTP;
    }
}
