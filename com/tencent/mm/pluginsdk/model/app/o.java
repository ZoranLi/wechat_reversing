package com.tencent.mm.pluginsdk.model.app;

import android.database.Cursor;
import com.tencent.mm.e.b.p;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.List;

public final class o extends i<p> {
    public static final String[] gUx = new String[]{i.a(n.gTP, "AppSort")};
    public e gUz;

    public o(e eVar) {
        super(eVar, n.gTP, "AppSort", null);
        this.gUz = eVar;
        eVar.eE("AppSort", "CREATE INDEX IF NOT EXISTS flagIdIndex ON AppSort ( flag )");
        eVar.eE("AppSort", "CREATE INDEX IF NOT EXISTS flagIdIndex ON AppSort ( sortId )");
    }

    public final List<String> ef(long j) {
        List<String> arrayList = new ArrayList();
        StringBuilder stringBuilder = new StringBuilder(256);
        stringBuilder.append("select * from AppSort");
        stringBuilder.append(" where ");
        stringBuilder.append("flag = ").append(j);
        stringBuilder.append(" order by sortId desc ");
        Cursor rawQuery = rawQuery(stringBuilder.toString(), new String[0]);
        if (rawQuery == null) {
            w.e("MicroMsg.AppSortStorage", "getAppListByFlag : cursor is null");
            return null;
        }
        w.d("MicroMsg.AppSortStorage", "getAppListByFlag count = %d", Integer.valueOf(rawQuery.getCount()));
        int columnIndex = rawQuery.getColumnIndex("appId");
        while (rawQuery.moveToNext()) {
            arrayList.add(rawQuery.getString(columnIndex));
        }
        rawQuery.close();
        return arrayList;
    }

    public final boolean a(n nVar) {
        return super.b((c) nVar);
    }
}
