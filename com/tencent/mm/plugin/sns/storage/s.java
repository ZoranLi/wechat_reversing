package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import com.tencent.mm.e.b.de;
import com.tencent.mm.protocal.c.avx;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.List;

public final class s extends de {
    protected static a gTP;
    public int qod;

    static {
        a aVar = new a();
        aVar.hXH = new Field[4];
        aVar.columns = new String[5];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "tagId";
        aVar.uxd.put("tagId", "LONG default '0' ");
        stringBuilder.append(" tagId LONG default '0' ");
        stringBuilder.append(", ");
        aVar.columns[1] = "tagName";
        aVar.uxd.put("tagName", "TEXT default '' ");
        stringBuilder.append(" tagName TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[2] = "count";
        aVar.uxd.put("count", "INTEGER default '0' ");
        stringBuilder.append(" count INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[3] = "memberList";
        aVar.uxd.put("memberList", "TEXT default '' ");
        stringBuilder.append(" memberList TEXT default '' ");
        aVar.columns[4] = "rowid";
        aVar.uxe = stringBuilder.toString();
        gTP = aVar;
    }

    protected final a sY() {
        return gTP;
    }

    public final void bw(List<avx> list) {
        this.field_memberList = "";
        for (avx com_tencent_mm_protocal_c_avx : list) {
            this.field_memberList += com_tencent_mm_protocal_c_avx.tZr + ",";
        }
    }

    public final void b(Cursor cursor) {
        super.b(cursor);
        this.qod = (int) this.uxb;
    }
}
