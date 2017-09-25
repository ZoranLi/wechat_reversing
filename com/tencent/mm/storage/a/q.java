package com.tencent.mm.storage.a;

import android.database.Cursor;
import com.tencent.mm.e.b.bl;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class q extends bl {
    protected static a gTP;

    protected final a sY() {
        return null;
    }

    public q(String str, byte[] bArr) {
        this.field_reqType = str;
        this.field_cache = bArr;
    }

    public q(Cursor cursor) {
        if (cursor != null) {
            b(cursor);
        }
    }

    static {
        a aVar = new a();
        aVar.hXH = new Field[2];
        aVar.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "reqType";
        aVar.uxd.put("reqType", "TEXT PRIMARY KEY ");
        stringBuilder.append(" reqType TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.uxc = "reqType";
        aVar.columns[1] = "cache";
        aVar.uxd.put("cache", "BLOB default '' ");
        stringBuilder.append(" cache BLOB default '' ");
        aVar.columns[2] = "rowid";
        aVar.uxe = stringBuilder.toString();
        gTP = aVar;
    }
}
