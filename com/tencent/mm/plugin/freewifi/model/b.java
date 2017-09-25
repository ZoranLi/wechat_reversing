package com.tencent.mm.plugin.freewifi.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.DetailedState;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;

public final class b {
    public a lSZ = new a();
    BroadcastReceiver lTa = new BroadcastReceiver(this) {
        final /* synthetic */ b lTb;

        {
            this.lTb = r1;
        }

        public final void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                try {
                    w.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "connChangedBroadcastReceiver");
                    NetworkInfo networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
                    if (networkInfo == null) {
                        w.e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "networkInfo is null");
                        return;
                    }
                    w.v("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "networkInfo=" + networkInfo.toString() + "; networkInfo.isConnected()=%b, networkInfo.getState()=%s, networkInfo.getDetailedState()=%s, networkInfo.getExtraInfo()=%s, networkInfo.isConnectedOrConnecting()=%b, networkInfo.isAvailable()=%b, ", new Object[]{Boolean.valueOf(networkInfo.isConnected()), networkInfo.getState(), networkInfo.getDetailedState(), networkInfo.getExtraInfo(), Boolean.valueOf(networkInfo.isConnectedOrConnecting()), Boolean.valueOf(networkInfo.isAvailable())});
                    if (!networkInfo.isConnected()) {
                        w.v("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "network is not connected.");
                    } else if (networkInfo.getType() != 0 && networkInfo.getType() != 1) {
                        w.v("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "network type is not wifi or mobile.");
                    } else if (context == null) {
                        w.e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "context is null.");
                    } else if (networkInfo.getType() == 1) {
                        WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                        if (wifiManager == null) {
                            w.e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "wifiManager is null.");
                            return;
                        }
                        WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                        if (connectionInfo == null) {
                            w.e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "wifiInfo is null.");
                            return;
                        }
                        String wy = m.wy(connectionInfo.getSSID());
                        String toLowerCase = m.wz(connectionInfo.getBSSID()).toLowerCase();
                        w.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "networkInfo.getExtraInfo()=%s, wifiInfo.getSsid()=%s, wifiInfo.getBssid=%s", new Object[]{m.wy(m.wz(networkInfo.getExtraInfo())), wy, toLowerCase});
                        if (!m.wz(m.wy(m.wz(networkInfo.getExtraInfo()))).equals(wy)) {
                            w.e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "wifiManage ssid is not equal to networkInfo.getExtraInfo(). networkwork might changed. return.");
                        } else if (this.lTb.lSZ.type == 1 && m.wz(this.lTb.lSZ.ssid).equals(wy) && m.wz(this.lTb.lSZ.bssid).equals(toLowerCase)) {
                            w.e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "Dulplicated intent.");
                        } else {
                            a aVar = new a();
                            aVar.lTc = System.currentTimeMillis();
                            aVar.type = 1;
                            aVar.ssid = wy;
                            aVar.bssid = toLowerCase;
                            aVar.lTd = "";
                            b.b(this.lTb.lSZ.awo(), aVar);
                            this.lTb.lSZ = aVar;
                        }
                    } else if (networkInfo.getType() != 0) {
                    } else {
                        if (this.lTb.lSZ.type == 0 && m.wz(this.lTb.lSZ.lTd).equals(m.wz(networkInfo.getExtraInfo()))) {
                            w.e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "Dulplicated intent.");
                            return;
                        }
                        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                        if (connectivityManager == null) {
                            w.e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "connManager is null.");
                            return;
                        }
                        NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(1);
                        if (networkInfo2 == null) {
                            w.e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "networkInfoWifi is null.");
                            return;
                        }
                        w.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "networkInfoWifi.getState()=%s, networkInfoWifi.getDetailedState()=%s", new Object[]{networkInfo2.getState(), networkInfo2.getDetailedState()});
                        if (networkInfo2.getDetailedState() != DetailedState.DISCONNECTED) {
                            w.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "It receives a type mobile connected event, but wifi network is not disconnected, so in fact user is probably switching wifi among ssids, not trying to connect to mobile network. ");
                            return;
                        }
                        a aVar2 = new a();
                        aVar2.lTc = System.currentTimeMillis();
                        aVar2.type = 0;
                        aVar2.ssid = "";
                        aVar2.bssid = "";
                        aVar2.lTd = m.wz(networkInfo.getExtraInfo());
                        b.a(this.lTb.lSZ.awo(), aVar2);
                        this.lTb.lSZ = aVar2;
                    }
                } catch (Exception e) {
                    com.tencent.mm.plugin.freewifi.k.a avZ = k.avZ();
                    avZ.fEN = "UnExpectedException";
                    avZ.result = -1;
                    avZ.ksO = m.e(e);
                    avZ.awb().awa();
                    w.e("MicroMsg.FreeWifi.UnExcepctedException", m.f(e));
                }
            }
        }
    };

    private static class a {
        String bssid = "";
        long lTc;
        String lTd = "";
        String ssid = "";
        int type;

        public final a awo() {
            a aVar = new a();
            aVar.lTc = this.lTc;
            aVar.type = this.type;
            aVar.ssid = this.ssid;
            aVar.bssid = this.bssid;
            aVar.lTd = this.lTd;
            return aVar;
        }

        public final String toString() {
            return String.format("NetworkInfoConnectedRecord(timeMillis=%d, type=%d, ssid=%s, bssid=%s, mobileNetworkType=%s)", new Object[]{Long.valueOf(this.lTc), Integer.valueOf(this.type), this.ssid, this.bssid, this.lTd});
        }
    }

    private static class b {
        public static b lTe = new b();
    }

    public final void avP() {
        try {
            ab.getContext().unregisterReceiver(this.lTa);
        } catch (IllegalArgumentException e) {
        }
    }

    public static void a(a aVar, a aVar2) {
        m.wD("on mobile connected.");
        w.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "onMobileConnected. lastRecord=%s, newRecord=%s", new Object[]{aVar.toString(), aVar2.toString()});
        com.tencent.mm.plugin.freewifi.f.b.mN(0);
    }

    public static void b(a aVar, a aVar2) {
        m.wD("on wifi connected.");
        w.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "onWifiConnected. lastRecord=%s, newRecord=%s", new Object[]{aVar.toString(), aVar2.toString()});
        if (aVar.type == 1 && aVar.ssid.equals(aVar2.ssid) && !aVar.bssid.equals(aVar2.bssid)) {
            String str = aVar.ssid;
            String str2 = aVar.bssid;
            String str3 = aVar2.bssid;
            m.wD("on wifi roaming.");
            w.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "WifiRoaming. ssid=%s, fromBssid=%s, toBssid=%s", new Object[]{str, str2, str3});
        }
        com.tencent.mm.plugin.freewifi.f.b.mN(1);
    }
}
