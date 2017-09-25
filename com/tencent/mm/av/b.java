package com.tencent.mm.av;

import com.tencent.mm.e.b.av;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class b extends av {
    protected static a gTP;

    static {
        a aVar = new a();
        aVar.hXH = new Field[17];
        aVar.columns = new String[18];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "talker";
        aVar.uxd.put("talker", "TEXT default '0'  PRIMARY KEY ");
        stringBuilder.append(" talker TEXT default '0'  PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.uxc = "talker";
        aVar.columns[1] = "encryptTalker";
        aVar.uxd.put("encryptTalker", "TEXT default '' ");
        stringBuilder.append(" encryptTalker TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[2] = "displayName";
        aVar.uxd.put("displayName", "TEXT default '' ");
        stringBuilder.append(" displayName TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[3] = "state";
        aVar.uxd.put("state", "INTEGER default '0' ");
        stringBuilder.append(" state INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[4] = "lastModifiedTime";
        aVar.uxd.put("lastModifiedTime", "LONG default '0' ");
        stringBuilder.append(" lastModifiedTime LONG default '0' ");
        stringBuilder.append(", ");
        aVar.columns[5] = "isNew";
        aVar.uxd.put("isNew", "INTEGER default '0' ");
        stringBuilder.append(" isNew INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[6] = "addScene";
        aVar.uxd.put("addScene", "INTEGER default '0' ");
        stringBuilder.append(" addScene INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[7] = "fmsgSysRowId";
        aVar.uxd.put("fmsgSysRowId", "LONG default '0' ");
        stringBuilder.append(" fmsgSysRowId LONG default '0' ");
        stringBuilder.append(", ");
        aVar.columns[8] = "fmsgIsSend";
        aVar.uxd.put("fmsgIsSend", "INTEGER default '0' ");
        stringBuilder.append(" fmsgIsSend INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[9] = "fmsgType";
        aVar.uxd.put("fmsgType", "INTEGER default '0' ");
        stringBuilder.append(" fmsgType INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[10] = "fmsgContent";
        aVar.uxd.put("fmsgContent", "TEXT default '' ");
        stringBuilder.append(" fmsgContent TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[11] = "recvFmsgType";
        aVar.uxd.put("recvFmsgType", "INTEGER default '0' ");
        stringBuilder.append(" recvFmsgType INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[12] = "contentFromUsername";
        aVar.uxd.put("contentFromUsername", "TEXT default '' ");
        stringBuilder.append(" contentFromUsername TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[13] = "contentNickname";
        aVar.uxd.put("contentNickname", "TEXT default '' ");
        stringBuilder.append(" contentNickname TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[14] = "contentPhoneNumMD5";
        aVar.uxd.put("contentPhoneNumMD5", "TEXT default '' ");
        stringBuilder.append(" contentPhoneNumMD5 TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[15] = "contentFullPhoneNumMD5";
        aVar.uxd.put("contentFullPhoneNumMD5", "TEXT default '' ");
        stringBuilder.append(" contentFullPhoneNumMD5 TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[16] = "contentVerifyContent";
        aVar.uxd.put("contentVerifyContent", "TEXT default '' ");
        stringBuilder.append(" contentVerifyContent TEXT default '' ");
        aVar.columns[17] = "rowid";
        aVar.uxe = stringBuilder.toString();
        gTP = aVar;
    }

    protected final a sY() {
        return gTP;
    }
}
