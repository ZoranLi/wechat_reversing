package com.tencent.mm.al;

import com.tencent.mm.e.b.cf;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class b extends cf {
    public static a gTP;

    static {
        a aVar = new a();
        aVar.hXH = new Field[9];
        aVar.columns = new String[10];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "wxGroupId";
        aVar.uxd.put("wxGroupId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" wxGroupId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.uxc = "wxGroupId";
        aVar.columns[1] = "groupId";
        aVar.uxd.put("groupId", "TEXT");
        stringBuilder.append(" groupId TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "roomId";
        aVar.uxd.put("roomId", "INTEGER");
        stringBuilder.append(" roomId INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = "roomKey";
        aVar.uxd.put("roomKey", "LONG");
        stringBuilder.append(" roomKey LONG");
        stringBuilder.append(", ");
        aVar.columns[4] = "routeId";
        aVar.uxd.put("routeId", "INTEGER");
        stringBuilder.append(" routeId INTEGER");
        stringBuilder.append(", ");
        aVar.columns[5] = "inviteUserName";
        aVar.uxd.put("inviteUserName", "TEXT");
        stringBuilder.append(" inviteUserName TEXT");
        stringBuilder.append(", ");
        aVar.columns[6] = "memberCount";
        aVar.uxd.put("memberCount", "INTEGER");
        stringBuilder.append(" memberCount INTEGER");
        stringBuilder.append(", ");
        aVar.columns[7] = "createTime";
        aVar.uxd.put("createTime", "LONG");
        stringBuilder.append(" createTime LONG");
        stringBuilder.append(", ");
        aVar.columns[8] = "state";
        aVar.uxd.put("state", "INTEGER default '0' ");
        stringBuilder.append(" state INTEGER default '0' ");
        aVar.columns[9] = "rowid";
        aVar.uxe = stringBuilder.toString();
        gTP = aVar;
    }

    protected final a sY() {
        return gTP;
    }
}
