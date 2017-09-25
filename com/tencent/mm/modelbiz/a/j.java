package com.tencent.mm.modelbiz.a;

import com.tencent.mm.e.b.w;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bg;
import java.lang.reflect.Field;

public final class j extends w {
    protected static a gTP;

    static {
        a aVar = new a();
        aVar.hXH = new Field[10];
        aVar.columns = new String[11];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "userId";
        aVar.uxd.put("userId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" userId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.uxc = "userId";
        aVar.columns[1] = "userName";
        aVar.uxd.put("userName", "TEXT default '' ");
        stringBuilder.append(" userName TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[2] = "userNamePY";
        aVar.uxd.put("userNamePY", "TEXT default '' ");
        stringBuilder.append(" userNamePY TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[3] = "brandUserName";
        aVar.uxd.put("brandUserName", "TEXT default '' ");
        stringBuilder.append(" brandUserName TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[4] = "UserVersion";
        aVar.uxd.put("UserVersion", "INTEGER default '-1' ");
        stringBuilder.append(" UserVersion INTEGER default '-1' ");
        stringBuilder.append(", ");
        aVar.columns[5] = "needToUpdate";
        aVar.uxd.put("needToUpdate", "INTEGER default 'true' ");
        stringBuilder.append(" needToUpdate INTEGER default 'true' ");
        stringBuilder.append(", ");
        aVar.columns[6] = "headImageUrl";
        aVar.uxd.put("headImageUrl", "TEXT");
        stringBuilder.append(" headImageUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[7] = "profileUrl";
        aVar.uxd.put("profileUrl", "TEXT");
        stringBuilder.append(" profileUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[8] = "bitFlag";
        aVar.uxd.put("bitFlag", "INTEGER default '0' ");
        stringBuilder.append(" bitFlag INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[9] = "addMemberUrl";
        aVar.uxd.put("addMemberUrl", "TEXT");
        stringBuilder.append(" addMemberUrl TEXT");
        aVar.columns[10] = "rowid";
        aVar.uxe = stringBuilder.toString();
        gTP = aVar;
    }

    protected final a sY() {
        return gTP;
    }

    public final boolean fu(int i) {
        return (this.field_bitFlag & i) != 0;
    }

    public final boolean DW() {
        if (this.field_needToUpdate) {
            return true;
        }
        if (bg.mA(this.field_profileUrl) && bg.mA(this.field_headImageUrl)) {
            return true;
        }
        if (!bg.mA(this.field_userNamePY) || bg.mA(this.field_userName)) {
            return false;
        }
        return true;
    }
}
