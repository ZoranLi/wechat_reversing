package com.tencent.mm.plugin.freewifi.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Parcelable;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public class FreeWifiNetworkReceiver extends BroadcastReceiver {
    public b lTv;
    public a lTw;

    public interface a {
        void a(State state);
    }

    public interface b {
        void mM(int i);
    }

    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            w.e("MicroMsg.FreeWifi.WifiStateChangedReceiver", "intent is null");
            return;
        }
        String action = intent.getAction();
        w.i("MicroMsg.FreeWifi.WifiStateChangedReceiver", "FreeWifiNetworkReceiver action : %s", new Object[]{action});
        if (bg.mA(action)) {
            w.e("MicroMsg.FreeWifi.WifiStateChangedReceiver", "action is null");
        } else if (action.equals("android.net.wifi.WIFI_STATE_CHANGED")) {
            w.i("MicroMsg.FreeWifi.WifiStateChangedReceiver", "now wifi state : %d", new Object[]{Integer.valueOf(intent.getIntExtra("wifi_state", 0))});
            if (this.lTv != null) {
                this.lTv.mM(r0);
            }
        } else if (action.equals("android.net.wifi.STATE_CHANGE")) {
            Parcelable parcelableExtra = intent.getParcelableExtra("networkInfo");
            if (parcelableExtra != null) {
                NetworkInfo networkInfo = (NetworkInfo) parcelableExtra;
                if (networkInfo != null && this.lTw != null) {
                    this.lTw.a(networkInfo.getState());
                }
            }
        }
    }
}
