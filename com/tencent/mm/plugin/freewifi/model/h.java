package com.tencent.mm.plugin.freewifi.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final class h {
    boolean jQt = false;
    public a lTx;
    public BroadcastReceiver lTy = new BroadcastReceiver(this) {
        final /* synthetic */ h lTz;

        {
            this.lTz = r1;
        }

        public final void onReceive(Context context, Intent intent) {
            int i = 0;
            if (context == null || intent == null) {
                w.e("MicroMsg.FreeWifi.WifiScanReceiver", "context is null or intent null");
                return;
            }
            this.lTz.jQt = false;
            context.unregisterReceiver(this.lTz.lTy);
            if ("android.net.wifi.SCAN_RESULTS".equals(intent.getAction())) {
                WifiManager wifiManager = (WifiManager) ab.getContext().getSystemService("wifi");
                if (wifiManager == null) {
                    w.e("MicroMsg.FreeWifi.WifiScanReceiver", "bran, WifiScanReceiver onReceive, get wifi manager failed");
                    return;
                }
                List scanResults;
                try {
                    scanResults = wifiManager.getScanResults();
                } catch (SecurityException e) {
                    scanResults = new ArrayList(0);
                    w.e("MicroMsg.FreeWifi.WifiScanReceiver", "wifiManager.getScanResults() throws security exception. " + e.getMessage());
                }
                h hVar = this.lTz;
                if (scanResults != null && scanResults.size() > 20) {
                    Collections.sort(scanResults, new Comparator<ScanResult>(hVar) {
                        final /* synthetic */ h lTz;

                        {
                            this.lTz = r1;
                        }

                        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                            ScanResult scanResult = (ScanResult) obj;
                            ScanResult scanResult2 = (ScanResult) obj2;
                            if (scanResult.level < scanResult2.level) {
                                return 1;
                            }
                            return scanResult.level == scanResult2.level ? 0 : -1;
                        }
                    });
                    scanResults = scanResults.subList(0, 20);
                }
                String str = "MicroMsg.FreeWifi.WifiScanReceiver";
                StringBuilder stringBuilder = new StringBuilder("wifiManager scanResults size = ");
                if (scanResults != null) {
                    i = scanResults.size();
                }
                w.i(str, stringBuilder.append(i).toString());
                if (this.lTz.lTx != null) {
                    this.lTz.lTx.aB(scanResults);
                }
            }
        }
    };

    public interface a {
        void aB(List<ScanResult> list);
    }

    private static class b {
        public static h lTA = new h();
    }

    public final boolean a(a aVar) {
        if (this.jQt) {
            return false;
        }
        this.jQt = true;
        this.lTx = aVar;
        WifiManager wifiManager = (WifiManager) ab.getContext().getSystemService("wifi");
        if (wifiManager == null) {
            w.e("MicroMsg.FreeWifi.WifiScanReceiver", "wifiDetectingTask, get wifi manager failed");
            return false;
        }
        ab.getContext().registerReceiver(this.lTy, new IntentFilter("android.net.wifi.SCAN_RESULTS"));
        wifiManager.startScan();
        return true;
    }
}
