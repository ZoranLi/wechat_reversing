package com.tencent.mm.plugin.card.model;

import com.tencent.mm.e.b.ac;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class i extends ac {
    public static a gTP;

    static {
        a aVar = new a();
        aVar.hXH = new Field[7];
        aVar.columns = new String[8];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "card_id";
        aVar.uxd.put("card_id", "TEXT PRIMARY KEY ");
        stringBuilder.append(" card_id TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.uxc = "card_id";
        aVar.columns[1] = "lower_bound";
        aVar.uxd.put("lower_bound", "INTEGER");
        stringBuilder.append(" lower_bound INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "need_insert_show_timestamp";
        aVar.uxd.put("need_insert_show_timestamp", "INTEGER default 'false' ");
        stringBuilder.append(" need_insert_show_timestamp INTEGER default 'false' ");
        stringBuilder.append(", ");
        aVar.columns[3] = "show_timestamp_encrypt_key";
        aVar.uxd.put("show_timestamp_encrypt_key", "TEXT");
        stringBuilder.append(" show_timestamp_encrypt_key TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "expire_time_interval";
        aVar.uxd.put("expire_time_interval", "INTEGER");
        stringBuilder.append(" expire_time_interval INTEGER");
        stringBuilder.append(", ");
        aVar.columns[5] = "show_expire_interval";
        aVar.uxd.put("show_expire_interval", "INTEGER");
        stringBuilder.append(" show_expire_interval INTEGER");
        stringBuilder.append(", ");
        aVar.columns[6] = "fetch_time";
        aVar.uxd.put("fetch_time", "LONG");
        stringBuilder.append(" fetch_time LONG");
        aVar.columns[7] = "rowid";
        aVar.uxe = stringBuilder.toString();
        gTP = aVar;
    }

    protected final a sY() {
        return gTP;
    }
}
