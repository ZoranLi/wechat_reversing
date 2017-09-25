package com.tencent.mm.plugin.freewifi.c;

import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import java.util.Map;

public final class a {
    public String bssid;
    public String lSR;
    public String lSS;
    public long lST;
    public String lSU;
    public long lSV;
    public String ssid;
    public String type;
    public long uin;

    private a() {
    }

    public static a wE(String str) {
        w.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "It starts to parse msgContent for FreeWifiSchemaMsg. msgContent=%s", new Object[]{str});
        if (m.wx(str)) {
            w.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "msgCoentent is empty. return.");
            return null;
        }
        w.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "Shorten msgContent into one line. msgContent=%s", new Object[]{str});
        Map q = bh.q(str, "sysmsg");
        if (q == null || q.size() == 0) {
            w.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "Parsing xml failed");
            return null;
        }
        w.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "Parsed values = " + q.toString());
        if ("freewifi".equalsIgnoreCase((String) q.get(".sysmsg.$type"))) {
            a aVar = new a();
            aVar.type = (String) q.get(".sysmsg.type");
            w.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.type=" + aVar.type);
            if ("schemamsg".equals(aVar.type)) {
                boolean i = m.i(q, "MicroMsg.FreeWifi.FreeWifiSchemaMsg");
                w.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "checkMsgPushedVersion=" + i);
                if (i) {
                    aVar.uin = bg.getLong((String) q.get(".sysmsg.uin"), 0);
                    w.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.uin=" + aVar.uin);
                    aVar.ssid = (String) q.get(".sysmsg.schemamsg.ssid");
                    w.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.ssid=" + aVar.ssid);
                    if (m.wx(aVar.ssid)) {
                        w.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "scemaMsg.ssid is empty. return.");
                        return null;
                    }
                    aVar.bssid = m.wz((String) q.get(".sysmsg.schemamsg.bssid"));
                    w.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.bssid=" + aVar.bssid);
                    aVar.lSR = (String) q.get(".sysmsg.schemamsg.mobilemac");
                    w.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.mobilemac=" + aVar.lSR);
                    if (m.wx(aVar.lSR)) {
                        w.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "scemaMsg.mobilemac is empty. return.");
                        return null;
                    }
                    aVar.lSS = (String) q.get(".sysmsg.schemamsg.mpappid");
                    w.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.mpappid=" + aVar.lSS);
                    aVar.lST = bg.getLong((String) q.get(".sysmsg.schemamsg.mpshopid"), 0);
                    w.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.mpshopid=" + aVar.lST);
                    aVar.lSU = (String) q.get(".sysmsg.schemamsg.schemaurl");
                    w.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.schemaurl=" + aVar.lSU);
                    if (m.wx(aVar.lSU)) {
                        w.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "scemaMsg.schemaurl is empty. return.");
                        return null;
                    }
                    aVar.lSV = bg.getLong((String) q.get(".sysmsg.schemamsg.expiredseconds"), 0);
                    w.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schema.expiredseconds=" + aVar.lSV);
                    return aVar;
                }
                w.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "version not matched. return.");
                return null;
            }
            w.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.type is not schemamsg. return.");
            return null;
        }
        w.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "sysmsg type is not freewifi. return.");
        return null;
    }
}
