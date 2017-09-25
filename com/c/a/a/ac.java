package com.c.a.a;

import android.net.wifi.WifiManager;
import android.os.Handler;

final class ac extends e {
    private final WifiManager aPM;

    ac(WifiManager wifiManager, Handler handler) {
        super(handler);
        this.aPM = wifiManager;
    }

    final void ni() {
        this.aPM.startScan();
    }
}
