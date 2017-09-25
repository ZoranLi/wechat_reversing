package com.tencent.mm.plugin.exdevice.f.b.a;

import com.tencent.mm.e.b.bt;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class d extends bt {
    public static a gTP;

    static {
        a aVar = new a();
        aVar.hXH = new Field[7];
        aVar.columns = new String[8];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "rankID";
        aVar.uxd.put("rankID", "TEXT");
        stringBuilder.append(" rankID TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "appusername";
        aVar.uxd.put("appusername", "TEXT");
        stringBuilder.append(" appusername TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "username";
        aVar.uxd.put("username", "TEXT");
        stringBuilder.append(" username TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "ranknum";
        aVar.uxd.put("ranknum", "INTEGER");
        stringBuilder.append(" ranknum INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "score";
        aVar.uxd.put("score", "INTEGER");
        stringBuilder.append(" score INTEGER");
        stringBuilder.append(", ");
        aVar.columns[5] = "likecount";
        aVar.uxd.put("likecount", "INTEGER default '0' ");
        stringBuilder.append(" likecount INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[6] = "selfLikeState";
        aVar.uxd.put("selfLikeState", "INTEGER default '3' ");
        stringBuilder.append(" selfLikeState INTEGER default '3' ");
        aVar.columns[7] = "rowid";
        aVar.uxe = stringBuilder.toString();
        gTP = aVar;
    }

    protected final a sY() {
        return gTP;
    }

    public final String toString() {
        return (("{" + "username: " + this.field_username + " ranknum: " + this.field_ranknum + " score: " + this.field_score) + " likeCount:" + this.field_likecount + " selfLikeState:" + this.field_selfLikeState) + "}";
    }
}
