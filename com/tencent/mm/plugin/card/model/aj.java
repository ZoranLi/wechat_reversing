package com.tencent.mm.plugin.card.model;

import com.tencent.mm.e.b.cl;
import com.tencent.mm.protocal.c.jd;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class aj extends cl {
    protected static a gTP;

    static {
        a aVar = new a();
        aVar.hXH = new Field[2];
        aVar.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "cardUserId";
        aVar.uxd.put("cardUserId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" cardUserId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.uxc = "cardUserId";
        aVar.columns[1] = "retryCount";
        aVar.uxd.put("retryCount", "INTEGER");
        stringBuilder.append(" retryCount INTEGER");
        aVar.columns[2] = "rowid";
        aVar.uxe = stringBuilder.toString();
        gTP = aVar;
    }

    protected final a sY() {
        return gTP;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof aj)) {
            return false;
        }
        if (this.field_cardUserId == ((aj) obj).field_cardUserId) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.field_cardUserId == null ? 0 : this.field_cardUserId.hashCode();
    }

    public static aj a(jd jdVar) {
        aj ajVar = new aj();
        ajVar.field_cardUserId = jdVar.toT;
        return ajVar;
    }
}
