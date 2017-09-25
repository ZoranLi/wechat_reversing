package com.tencent.mm.plugin.multitalk.b;

import com.tencent.mm.e.b.cg;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.lang.reflect.Field;

public final class b extends cg {
    protected static a gTP;

    static {
        a aVar = new a();
        aVar.hXH = new Field[7];
        aVar.columns = new String[8];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "memberUuid";
        aVar.uxd.put("memberUuid", "LONG");
        stringBuilder.append(" memberUuid LONG");
        stringBuilder.append(", ");
        aVar.columns[1] = "wxGroupId";
        aVar.uxd.put("wxGroupId", "TEXT");
        stringBuilder.append(" wxGroupId TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "userName";
        aVar.uxd.put("userName", "TEXT");
        stringBuilder.append(" userName TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "inviteUserName";
        aVar.uxd.put("inviteUserName", "TEXT");
        stringBuilder.append(" inviteUserName TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "memberId";
        aVar.uxd.put("memberId", "LONG");
        stringBuilder.append(" memberId LONG");
        stringBuilder.append(", ");
        aVar.columns[5] = DownloadInfo.STATUS;
        aVar.uxd.put(DownloadInfo.STATUS, "INTEGER");
        stringBuilder.append(" status INTEGER");
        stringBuilder.append(", ");
        aVar.columns[6] = "createTime";
        aVar.uxd.put("createTime", "LONG");
        stringBuilder.append(" createTime LONG");
        aVar.columns[7] = "rowid";
        aVar.uxe = stringBuilder.toString();
        gTP = aVar;
    }

    protected final a sY() {
        return gTP;
    }
}
