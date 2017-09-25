package com.tencent.mm.plugin.freewifi.g;

import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.e.b.bf;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class c extends bf {
    protected static a gTP;

    static {
        a aVar = new a();
        aVar.hXH = new Field[14];
        aVar.columns = new String[15];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "ssidmd5";
        aVar.uxd.put("ssidmd5", "TEXT PRIMARY KEY ");
        stringBuilder.append(" ssidmd5 TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.uxc = "ssidmd5";
        aVar.columns[1] = "ssid";
        aVar.uxd.put("ssid", "TEXT");
        stringBuilder.append(" ssid TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "mid";
        aVar.uxd.put("mid", "TEXT");
        stringBuilder.append(" mid TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = SlookSmartClipMetaTag.TAG_TYPE_URL;
        aVar.uxd.put(SlookSmartClipMetaTag.TAG_TYPE_URL, "TEXT");
        stringBuilder.append(" url TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "connectState";
        aVar.uxd.put("connectState", "INTEGER default '-1' ");
        stringBuilder.append(" connectState INTEGER default '-1' ");
        stringBuilder.append(", ");
        aVar.columns[5] = "expiredTime";
        aVar.uxd.put("expiredTime", "LONG");
        stringBuilder.append(" expiredTime LONG");
        stringBuilder.append(", ");
        aVar.columns[6] = "wifiType";
        aVar.uxd.put("wifiType", "INTEGER default '1' ");
        stringBuilder.append(" wifiType INTEGER default '1' ");
        stringBuilder.append(", ");
        aVar.columns[7] = "action";
        aVar.uxd.put("action", "INTEGER default '0' ");
        stringBuilder.append(" action INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[8] = "showUrl";
        aVar.uxd.put("showUrl", "TEXT");
        stringBuilder.append(" showUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[9] = "showWordEn";
        aVar.uxd.put("showWordEn", "TEXT");
        stringBuilder.append(" showWordEn TEXT");
        stringBuilder.append(", ");
        aVar.columns[10] = "showWordCn";
        aVar.uxd.put("showWordCn", "TEXT");
        stringBuilder.append(" showWordCn TEXT");
        stringBuilder.append(", ");
        aVar.columns[11] = "showWordTw";
        aVar.uxd.put("showWordTw", "TEXT");
        stringBuilder.append(" showWordTw TEXT");
        stringBuilder.append(", ");
        aVar.columns[12] = "mac";
        aVar.uxd.put("mac", "TEXT");
        stringBuilder.append(" mac TEXT");
        stringBuilder.append(", ");
        aVar.columns[13] = "verifyResult";
        aVar.uxd.put("verifyResult", "INTEGER default '1' ");
        stringBuilder.append(" verifyResult INTEGER default '1' ");
        aVar.columns[14] = "rowid";
        aVar.uxe = stringBuilder.toString();
        gTP = aVar;
    }

    protected final a sY() {
        return gTP;
    }
}
