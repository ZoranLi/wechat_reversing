package com.tencent.mm.av;

import com.tencent.mm.e.b.cu;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.lang.reflect.Field;

public class j extends cu {
    protected static a gTP;
    protected static Field[] hXH = c.u(j.class).hXH;

    static {
        a aVar = new a();
        aVar.hXH = new Field[11];
        aVar.columns = new String[12];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "svrid";
        aVar.uxd.put("svrid", "LONG default '0'  PRIMARY KEY ");
        stringBuilder.append(" svrid LONG default '0'  PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.uxc = "svrid";
        aVar.columns[1] = DownloadInfo.STATUS;
        aVar.uxd.put(DownloadInfo.STATUS, "INTEGER");
        stringBuilder.append(" status INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = Columns.TYPE;
        aVar.uxd.put(Columns.TYPE, "INTEGER");
        stringBuilder.append(" type INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = "scene";
        aVar.uxd.put("scene", "INTEGER");
        stringBuilder.append(" scene INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "createtime";
        aVar.uxd.put("createtime", "LONG");
        stringBuilder.append(" createtime LONG");
        stringBuilder.append(", ");
        aVar.columns[5] = "talker";
        aVar.uxd.put("talker", "TEXT");
        stringBuilder.append(" talker TEXT");
        stringBuilder.append(", ");
        aVar.columns[6] = "content";
        aVar.uxd.put("content", "TEXT");
        stringBuilder.append(" content TEXT");
        stringBuilder.append(", ");
        aVar.columns[7] = "sayhiuser";
        aVar.uxd.put("sayhiuser", "TEXT");
        stringBuilder.append(" sayhiuser TEXT");
        stringBuilder.append(", ");
        aVar.columns[8] = "sayhicontent";
        aVar.uxd.put("sayhicontent", "TEXT");
        stringBuilder.append(" sayhicontent TEXT");
        stringBuilder.append(", ");
        aVar.columns[9] = "imgpath";
        aVar.uxd.put("imgpath", "TEXT");
        stringBuilder.append(" imgpath TEXT");
        stringBuilder.append(", ");
        aVar.columns[10] = "isSend";
        aVar.uxd.put("isSend", "INTEGER");
        stringBuilder.append(" isSend INTEGER");
        aVar.columns[11] = "rowid";
        aVar.uxe = stringBuilder.toString();
        gTP = aVar;
    }

    protected final a sY() {
        return gTP;
    }
}
