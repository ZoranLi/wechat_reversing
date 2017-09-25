package com.tencent.mm.plugin.freewifi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.wifi.SupplicantState;
import com.tencent.mm.plugin.freewifi.c.AnonymousClass2;
import com.tencent.mm.sdk.platformtools.w;

class ConnectSsidPasswordHelper$2 extends BroadcastReceiver {
    final /* synthetic */ c lRe;

    public ConnectSsidPasswordHelper$2(c cVar) {
        this.lRe = cVar;
    }

    public final void onReceive(Context context, Intent intent) {
        if ("android.net.wifi.STATE_CHANGE".equals(intent.getAction())) {
            NetworkInfo networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
            if (networkInfo != null) {
                w.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "WifiManager.NETWORK_STATE_CHANGED_ACTION broadcastReceiver, targetssid=%s, Utils.getConnectedWifiSsid(TAG)=%s, networkInfo.isConnected()=%b, networkInfo.isConnectedOrConnecting()=%b, networkInfo.getExtraInfo()=%s, networkInfo.getType()=%d, networkInfo.toString()=%s", new Object[]{this.lRe.ssid, m.wA("MicroMsg.FreeWifi.ConnectSsidPasswordHelper"), Boolean.valueOf(networkInfo.isConnected()), Boolean.valueOf(networkInfo.isConnectedOrConnecting()), networkInfo.getExtraInfo(), Integer.valueOf(networkInfo.getType()), networkInfo.toString()});
            }
            if (networkInfo != null && networkInfo.isConnected() && networkInfo.getType() == 1 && this.lRe.ssid.equals(m.wy(networkInfo.getExtraInfo()))) {
                try {
                    this.lRe.lQU.lock();
                    this.lRe.connected = true;
                    this.lRe.lRb = false;
                    this.lRe.fuI.signalAll();
                    w.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "WifiManager connect successs! signal success!");
                } finally {
                    this.lRe.avP();
                    this.lRe.lQU.unlock();
                }
            }
        } else if ("android.net.wifi.supplicant.STATE_CHANGE".equals(intent.getAction())) {
            switch (AnonymousClass2.lRf[((SupplicantState) intent.getParcelableExtra("newState")).ordinal()]) {
                case 1:
                    w.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, ASSOCIATED");
                    break;
                case 2:
                    w.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, ASSOCIATING");
                    break;
                case 3:
                    w.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, Authenticating...");
                    break;
                case 4:
                    w.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, Connected");
                    break;
                case 5:
                    w.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, Disconnected");
                    break;
                case 6:
                    w.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, DORMANT");
                    break;
                case 7:
                    w.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, FOUR_WAY_HANDSHAKE");
                    break;
                case 8:
                    w.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, GROUP_HANDSHAKE");
                    break;
                case 9:
                    w.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, INACTIVE");
                    break;
                case 10:
                    w.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, INTERFACE_DISABLED");
                    break;
                case 11:
                    w.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, INVALID");
                    break;
                case 12:
                    w.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, SCANNING");
                    break;
                case 13:
                    w.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, UNINITIALIZED");
                    break;
                default:
                    w.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, Unknown");
                    break;
            }
            if (intent.getIntExtra("supplicantError", -1) == 1) {
                try {
                    this.lRe.lQU.lock();
                    this.lRe.connected = false;
                    this.lRe.lRb = true;
                    this.lRe.fuI.signalAll();
                    w.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "WifiManager connect AUTHENTICATING error! signal error!");
                    w.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "ERROR_AUTHENTICATING!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                } finally {
                    this.lRe.avP();
                    this.lRe.lQU.unlock();
                }
            }
        }
    }
}
