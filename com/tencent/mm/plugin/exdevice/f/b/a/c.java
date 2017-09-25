package com.tencent.mm.plugin.exdevice.f.b.a;

import com.tencent.mm.e.b.bs;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class c extends bs {
    public static a gTP;

    static {
        a aVar = new a();
        aVar.hXH = new Field[5];
        aVar.columns = new String[6];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "appusername";
        aVar.uxd.put("appusername", "TEXT");
        stringBuilder.append(" appusername TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "rankID";
        aVar.uxd.put("rankID", "TEXT");
        stringBuilder.append(" rankID TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "username";
        aVar.uxd.put("username", "TEXT");
        stringBuilder.append(" username TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "step";
        aVar.uxd.put("step", "INTEGER");
        stringBuilder.append(" step INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "sort";
        aVar.uxd.put("sort", "INTEGER default '0' ");
        stringBuilder.append(" sort INTEGER default '0' ");
        aVar.columns[5] = "rowid";
        aVar.uxe = stringBuilder.toString();
        gTP = aVar;
    }

    protected final a sY() {
        return gTP;
    }

    public final String toString() {
        return ("{" + "username: " + this.field_username + " step: " + this.field_step + " rankId: " + this.field_rankID + " appname: " + this.field_appusername) + "}";
    }
}
