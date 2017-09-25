package com.tencent.mm.plugin.exdevice.h;

import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.e.b.bp;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class b extends bp {
    protected static a gTP;

    static {
        a aVar = new a();
        aVar.hXH = new Field[14];
        aVar.columns = new String[15];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "deviceID";
        aVar.uxd.put("deviceID", "TEXT PRIMARY KEY ");
        stringBuilder.append(" deviceID TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.uxc = "deviceID";
        aVar.columns[1] = "brandName";
        aVar.uxd.put("brandName", "TEXT");
        stringBuilder.append(" brandName TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "mac";
        aVar.uxd.put("mac", "LONG");
        stringBuilder.append(" mac LONG");
        stringBuilder.append(", ");
        aVar.columns[3] = "deviceType";
        aVar.uxd.put("deviceType", "TEXT");
        stringBuilder.append(" deviceType TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "connProto";
        aVar.uxd.put("connProto", "TEXT");
        stringBuilder.append(" connProto TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "connStrategy";
        aVar.uxd.put("connStrategy", "INTEGER");
        stringBuilder.append(" connStrategy INTEGER");
        stringBuilder.append(", ");
        aVar.columns[6] = "closeStrategy";
        aVar.uxd.put("closeStrategy", "INTEGER");
        stringBuilder.append(" closeStrategy INTEGER");
        stringBuilder.append(", ");
        aVar.columns[7] = "md5Str";
        aVar.uxd.put("md5Str", "TEXT");
        stringBuilder.append(" md5Str TEXT");
        stringBuilder.append(", ");
        aVar.columns[8] = "authKey";
        aVar.uxd.put("authKey", "TEXT");
        stringBuilder.append(" authKey TEXT");
        stringBuilder.append(", ");
        aVar.columns[9] = SlookSmartClipMetaTag.TAG_TYPE_URL;
        aVar.uxd.put(SlookSmartClipMetaTag.TAG_TYPE_URL, "TEXT");
        stringBuilder.append(" url TEXT");
        stringBuilder.append(", ");
        aVar.columns[10] = "sessionKey";
        aVar.uxd.put("sessionKey", "BLOB");
        stringBuilder.append(" sessionKey BLOB");
        stringBuilder.append(", ");
        aVar.columns[11] = "sessionBuf";
        aVar.uxd.put("sessionBuf", "BLOB");
        stringBuilder.append(" sessionBuf BLOB");
        stringBuilder.append(", ");
        aVar.columns[12] = "authBuf";
        aVar.uxd.put("authBuf", "BLOB");
        stringBuilder.append(" authBuf BLOB");
        stringBuilder.append(", ");
        aVar.columns[13] = "lvbuffer";
        aVar.uxd.put("lvbuffer", "BLOB");
        stringBuilder.append(" lvbuffer BLOB");
        aVar.columns[14] = "rowid";
        aVar.uxe = stringBuilder.toString();
        gTP = aVar;
    }

    protected final a sY() {
        return gTP;
    }
}
