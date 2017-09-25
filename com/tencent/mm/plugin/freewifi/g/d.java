package com.tencent.mm.plugin.freewifi.g;

import android.database.Cursor;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class d extends i<c> {
    public static final String[] gUx = new String[]{i.a(c.gTP, "FreeWifiInfo"), "CREATE INDEX IF NOT EXISTS freewifi_md5_ssid  on FreeWifiInfo  (  ssidmd5 )"};

    public d(e eVar) {
        super(eVar, c.gTP, "FreeWifiInfo", null);
    }

    public final c wO(String str) {
        if (bg.mA(str)) {
            w.e("MicroMsg.FreeWifi.FreeWifiInfoStorage", "ssid is null");
            return null;
        }
        w.d("MicroMsg.FreeWifi.FreeWifiInfoStorage", "getFreeWifiInfoBySSID, sql : %s", new Object[]{"select * from FreeWifiInfo where ssidmd5 = '" + aa.Pq(str) + "' and wifiType = 1"});
        Cursor rawQuery = rawQuery(r1, new String[0]);
        if (rawQuery == null) {
            w.e("MicroMsg.FreeWifi.FreeWifiInfoStorage", "cursor is null");
            return null;
        } else if (rawQuery.moveToFirst()) {
            c cVar = new c();
            cVar.b(rawQuery);
            rawQuery.close();
            return cVar;
        } else {
            rawQuery.close();
            return null;
        }
    }

    public final c wP(String str) {
        if (bg.mA(str)) {
            w.e("MicroMsg.FreeWifi.FreeWifiInfoStorage", "ssid is null");
            return null;
        }
        w.d("MicroMsg.FreeWifi.FreeWifiInfoStorage", "getFreeWifiInfoBySSID, sql : %s", new Object[]{"select * from FreeWifiInfo where ssidmd5 = '" + aa.Pq(str) + "'"});
        Cursor rawQuery = rawQuery(r1, new String[0]);
        if (rawQuery == null) {
            w.e("MicroMsg.FreeWifi.FreeWifiInfoStorage", "cursor is null");
            return null;
        } else if (rawQuery.moveToFirst()) {
            c cVar = new c();
            cVar.b(rawQuery);
            rawQuery.close();
            return cVar;
        } else {
            rawQuery.close();
            return null;
        }
    }

    public final c axe() {
        w.d("MicroMsg.FreeWifi.FreeWifiInfoStorage", "getLastConnectSuccessWifiInfo, sql : %s", new Object[]{"select * from FreeWifiInfo where connectState = 2"});
        Cursor rawQuery = rawQuery("select * from FreeWifiInfo where connectState = 2", new String[0]);
        if (rawQuery == null) {
            w.e("MicroMsg.FreeWifi.FreeWifiInfoStorage", "no connected sucess wifi info");
            return null;
        } else if (rawQuery.moveToFirst()) {
            c cVar = new c();
            cVar.b(rawQuery);
            rawQuery.close();
            return cVar;
        } else {
            rawQuery.close();
            return null;
        }
    }

    public final void wQ(String str) {
        w.d("MicroMsg.FreeWifi.FreeWifiInfoStorage", "updateOtherAp : %s", new Object[]{"update FreeWifiInfo set connectState = -1 where ssidmd5 !='" + aa.Pq(str) + "'"});
        boolean eE = eE("FreeWifiInfo", r0);
        w.d("MicroMsg.FreeWifi.FreeWifiInfoStorage", "update other ap  ret = %b", new Object[]{Boolean.valueOf(eE)});
    }
}
