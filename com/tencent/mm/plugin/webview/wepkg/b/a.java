package com.tencent.mm.plugin.webview.wepkg.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.mm.e.a.ss;
import com.tencent.mm.i.g;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.webview.wepkg.downloader.d;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;

public final class a {
    public static int moY = -1;
    private static a spe;

    private static class a extends BroadcastReceiver {
        private a() {
        }

        public final void onReceive(Context context, Intent intent) {
            if (!ap.zb() || ap.uP()) {
                w.e("MicroMsg.Wepkg.WepkgAutoDownloader", "acc has not ready");
                return;
            }
            int netType = am.getNetType(ab.getContext());
            if (netType != a.moY) {
                a.moY = netType;
                w.i("MicroMsg.Wepkg.WepkgAutoDownloader", "onNetStateChange, netState = " + netType);
                if (netType == 0) {
                    boolean sG = g.sW().sG();
                    if (bg.az(Long.valueOf(bg.c((Long) h.vI().vr().get(com.tencent.mm.storage.w.a.uIh, Long.valueOf(0)))).longValue()) > 1800) {
                        netType = 1;
                    } else {
                        netType = 0;
                    }
                    if (netType == 0) {
                        w.i("MicroMsg.Wepkg.WepkgAutoDownloader", "dont auto download in wifi, because from the last time is not enough for %s s", new Object[]{Long.valueOf(1800)});
                    }
                    if (!sG && netType != 0) {
                        h.vI().vr().a(com.tencent.mm.storage.w.a.uIh, Long.valueOf(bg.Ny()));
                        b ssVar = new ss();
                        ssVar.gaE.fEG = 0;
                        com.tencent.mm.sdk.b.a.urY.m(ssVar);
                        return;
                    }
                    return;
                }
                d.bAt().bAu();
            }
        }
    }

    public static void aAz() {
        if (spe == null) {
            spe = new a();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        try {
            ab.getContext().registerReceiver(spe, intentFilter);
        } catch (Exception e) {
        }
        w.i("MicroMsg.Wepkg.WepkgAutoDownloader", "WepkgAutoDownloader startListen");
    }

    public static void aAA() {
        if (spe != null) {
            try {
                ab.getContext().unregisterReceiver(spe);
            } catch (Exception e) {
            }
        }
        spe = null;
        w.i("MicroMsg.Wepkg.WepkgAutoDownloader", "WepkgAutoDownloader stopListen");
    }
}
