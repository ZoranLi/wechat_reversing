package com.tencent.mm.plugin.freewifi.b;

import android.content.Intent;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.a.ep;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiManufacturerLoadingUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.wcdb.database.SQLiteDatabase;

public final class b {

    private static class a {
        public static b lSG = new b();
    }

    public final synchronized void a(ep epVar) {
        w.i("MicroMsg.FreeWifi.FreeWifiManufacturerConnectWifiHelper", "Method connectWifi gets called");
        final String wy = m.wy(epVar.fIv.ssid);
        final String str = epVar.fIv.bssid;
        if (m.wx(wy)) {
            a(epVar, 1141, "Ssid is empty.");
        } else if (m.wx(str)) {
            a(epVar, 1142, "Bssid is empty.");
        } else {
            w.i("MicroMsg.FreeWifi.FreeWifiManufacturerConnectWifiHelper", "args: ssid=" + epVar.fIv.ssid + "; bssid=" + epVar.fIv.bssid + "; version=" + epVar.fIv.version);
            w.i("MicroMsg.FreeWifi.FreeWifiManufacturerConnectWifiHelper", "Try to get connect info from cache");
            com.tencent.mm.plugin.freewifi.b.a.b ce = a.lSC.ce(wy, str);
            w.i("MicroMsg.FreeWifi.FreeWifiManufacturerConnectWifiHelper", "read cache done.");
            if (ce != null) {
                final String str2 = ce.fEN;
                int i = ce.lRB;
                if (i == 4) {
                    w.i("MicroMsg.FreeWifi.FreeWifiManufacturerConnectWifiHelper", "Ready to start up password ap connect page.");
                    af.v(new Runnable(this) {
                        final /* synthetic */ b lSD;

                        public final void run() {
                            Intent intent = new Intent();
                            intent.putExtra("free_wifi_ap_key", str2);
                            intent.putExtra("free_wifi_sessionkey", m.awd());
                            intent.putExtra("free_wifi_source", 6);
                            intent.addFlags(67108864);
                            d.b(ab.getContext(), "freewifi", ".ui.FreeWifiEntryUI", intent);
                        }
                    });
                    a(epVar, 1, null);
                } else if (i == 31) {
                    w.i("MicroMsg.FreeWifi.FreeWifiManufacturerConnectWifiHelper", "Ready to connect 31 page.");
                    af.v(new Runnable(this) {
                        final /* synthetic */ b lSD;

                        public final void run() {
                            Intent intent = new Intent();
                            intent.putExtra("ConstantsFreeWifi.FreeWifiManufacturerConnectWifiHelper_Ssid", wy);
                            intent.putExtra("ConstantsFreeWifi.FreeWifiManufacturerConnectWifiHelper_Bssid", str);
                            intent.setClass(ab.getContext(), FreeWifiManufacturerLoadingUI.class);
                            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                            ab.getContext().startActivity(intent);
                        }
                    });
                    a(epVar, 1, null);
                } else {
                    a(epVar, 1143, "Wechant installed Currently doesn't support connect protocol " + i);
                }
            } else if (a.lSC.size() == 0) {
                a(epVar, 1145, "Ap connect info cache in wechat is empty. It may be wechat got killed before.");
            } else {
                a(epVar, 1144, "Ap connect info cache in wechat is not empty but the ap tried to connect to is not contained in the cache.");
            }
        }
    }

    private static void a(ep epVar, int i, String str) {
        epVar.fIw.fIz = i;
        epVar.fIw.fIA = str;
        epVar.fIw.fIy = 1;
        w.i("MicroMsg.FreeWifi.FreeWifiManufacturerConnectWifiHelper", "FreeWifiManufacturerConnectWifiHelper setResult. errorcode=%d, errmsg=%s", new Object[]{Integer.valueOf(i), str});
        if (epVar.nFq != null) {
            epVar.nFq.run();
        }
    }
}
