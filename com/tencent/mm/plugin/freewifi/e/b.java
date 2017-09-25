package com.tencent.mm.plugin.freewifi.e;

import android.content.Intent;
import com.tencent.mm.bb.d;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiNetCheckUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;

public final class b {
    private static String TAG = "MicroMsg.FreeWifi.Protocol31Entry";

    private static class a {
        public static b lTX = new b();
    }

    public static b awY() {
        return a.lTX;
    }

    public static void D(Intent intent) {
        boolean z = true;
        if (intent != null) {
            String stringExtra = intent.getStringExtra("free_wifi_ap_key");
            if (!m.wx(stringExtra)) {
                int intExtra = intent.getIntExtra("free_wifi_threeone_startup_type", 0);
                if (2 == intExtra) {
                    intExtra = 11;
                } else if (3 == intExtra) {
                    intExtra = 12;
                } else if (4 == intExtra) {
                    intExtra = 13;
                } else {
                    intExtra = 1;
                }
                intent.putExtra("free_wifi_channel_id", intExtra);
                intent.putExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 31);
                m.d(intent, intent.getStringExtra("free_wifi_schema_ticket"));
                intent.putExtra("ConstantsFreeWifi.FREE_WIFI_REPORT_WIFI_SERVER_ID", m.y(intent) + "_" + m.A(intent) + "_" + m.B(intent) + "_" + System.currentTimeMillis());
                boolean j = a.lUc.j(intent.getIntExtra("free_wifi_threeone_startup_type", 0), intent.getStringExtra("free_wifi_ap_key"), intent.getStringExtra("free_wifi_schema_ticket"));
                com.tencent.mm.plugin.freewifi.k.a avZ = k.avZ();
                avZ.ssid = m.wA(TAG);
                avZ.bssid = m.wB(TAG);
                avZ.fEN = stringExtra;
                avZ.lRA = intent.getStringExtra("free_wifi_schema_ticket");
                avZ.lRB = m.A(intent);
                avZ.lRC = com.tencent.mm.plugin.freewifi.k.b.GetThreeOneLock.lSn;
                avZ.lRD = com.tencent.mm.plugin.freewifi.k.b.GetThreeOneLock.name;
                avZ.fRr = m.B(intent);
                avZ.result = j ? 0 : -1;
                k awb = avZ.awb();
                if (j) {
                    z = false;
                }
                awb.b(intent, z).awa();
                w.i(TAG, "getLock = " + j);
                m.wD("type=" + intent.getIntExtra("free_wifi_threeone_startup_type", 0) + ";getLock=" + j);
                if (j) {
                    m.d(intent, intent.getStringExtra("free_wifi_schema_ticket"));
                    intent.setClass(ab.getContext(), FreeWifiNetCheckUI.class);
                    intent.addFlags(67108864);
                    d.b(ab.getContext(), "freewifi", ".ui.FreeWifiEntryUI", intent);
                }
            }
        }
    }
}
