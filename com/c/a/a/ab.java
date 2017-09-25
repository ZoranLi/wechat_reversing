package com.c.a.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Handler;
import java.util.List;

final class ab extends c {
    private static ab aPF;
    WifiManager aJq;
    private final BroadcastReceiver aPG = new BroadcastReceiver(this) {
        final /* synthetic */ ab aPK;

        {
            this.aPK = r1;
        }

        public final void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.net.wifi.SCAN_RESULTS")) {
                ab abVar = this.aPK;
                try {
                    List scanResults = abVar.aJq.getScanResults();
                    if (scanResults == null || scanResults.isEmpty()) {
                        throw new Exception("WifiScanMsg: null or empty scan result list");
                    }
                    abVar.c(new a(scanResults));
                } catch (Exception e) {
                }
            }
        }
    };
    private final IntentFilter aPH = new IntentFilter("android.net.wifi.SCAN_RESULTS");
    private ac aPI;
    private long aPJ = 10000;

    static class a extends p {
        final List<ScanResult> aPL;

        a(List<ScanResult> list) {
            super(101);
            this.aPL = list;
        }
    }

    private ab() {
    }

    static ab nJ() {
        if (aPF == null) {
            aPF = new ab();
        }
        return aPF;
    }

    private boolean isAvailable() {
        return this.aJq != null;
    }

    final synchronized void a(Handler handler, a aVar) {
        if (aVar == null) {
            aVar = new a(10000);
        }
        super.a(handler, aVar);
    }

    final void O(Context context) {
        this.aJq = (WifiManager) context.getSystemService("wifi");
    }

    final void a(Context context, Handler handler, a aVar) {
        if (isAvailable()) {
            context.registerReceiver(this.aPG, this.aPH, null, handler);
            this.aPJ = aVar.aJl;
            WifiManager wifiManager = this.aJq;
            if (handler == null) {
                handler = new Handler(context.getMainLooper());
            }
            this.aPI = new ac(wifiManager, handler);
            this.aPI.b(this.aPJ, 0);
        }
    }

    final void P(Context context) {
        if (isAvailable()) {
            context.unregisterReceiver(this.aPG);
            this.aPI.stop();
        }
    }

    final void ne() {
    }

    final void nf() {
        if (isAvailable() && this.aJi && this.aPJ < 90000) {
            this.aPI.b(90000, 0);
        }
    }

    final void ng() {
        if (isAvailable() && this.aJi && this.aPJ < 90000) {
            this.aPI.b(this.aPJ, 0);
        }
    }
}
