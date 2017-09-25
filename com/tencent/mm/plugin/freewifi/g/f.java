package com.tencent.mm.plugin.freewifi.g;

import android.database.Cursor;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.protocal.c.sn;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.w;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public final class f extends i<e> {
    public static final String[] gUx = new String[]{i.a(e.gTP, "FreeWifiLog"), "CREATE INDEX IF NOT EXISTS idx_FreeWifiLog_key  on FreeWifiLog  (  id )"};
    public static LinkedHashMap<String, Class> lVm = new LinkedHashMap<String, Class>() {
        {
            put(SlookAirButtonFrequentContactAdapter.ID, String.class);
            put("protocolNumber", Integer.TYPE);
            put("logContent", String.class);
            put("createTime", Long.TYPE);
        }
    };

    public f(e eVar) {
        super(eVar, e.gTP, "FreeWifiLog", null);
    }

    public final LinkedList<sn> axf() {
        Cursor rawQuery = rawQuery("select id, protocolNumber, logContent, createTime from FreeWifiLog", new String[0]);
        LinkedList<sn> linkedList = new LinkedList();
        while (rawQuery != null && rawQuery.moveToNext()) {
            sn snVar = new sn();
            snVar.id = rawQuery.getString(0);
            snVar.lUf = rawQuery.getInt(1);
            snVar.tAx = rawQuery.getString(2);
            snVar.tAy = rawQuery.getLong(3);
            linkedList.add(snVar);
        }
        if (rawQuery != null) {
            rawQuery.close();
        }
        return linkedList;
    }

    public final boolean a(String str, int i, String str2, long j) {
        boolean b;
        w.i("MicroMsg.FreeWifi.FreeWifiLogStorage", "save. id=%s, protocolNumber=%d, logContent=%s, createTime=%d", new Object[]{str, Integer.valueOf(i), str2, Long.valueOf(j)});
        if (m.wx(str)) {
            return false;
        }
        Cursor rawQuery = rawQuery("select * from FreeWifiLog where id = '" + str + "'", new String[0]);
        try {
            c eVar = new e();
            eVar.field_id = str;
            eVar.field_protocolNumber = i;
            eVar.field_logContent = str2;
            eVar.field_createTime = j;
            if (rawQuery.getCount() == 0) {
                b = b(eVar);
                w.i("MicroMsg.FreeWifi.FreeWifiLogStorage", "insert ret" + b);
                return b;
            }
            b = c(eVar, new String[0]);
            w.i("MicroMsg.FreeWifi.FreeWifiLogStorage", "update ret" + b);
            rawQuery.close();
            return b;
        } catch (Exception e) {
            b = e;
            b = m.f(b);
            w.e("MicroMsg.FreeWifi.FreeWifiLogStorage", b);
            return false;
        } finally {
            rawQuery.close();
        }
    }
}
