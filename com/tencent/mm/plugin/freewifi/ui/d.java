package com.tencent.mm.plugin.freewifi.ui;

import android.os.Looper;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.plugin.freewifi.ui.c.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;

public final class d {
    public static void qg() {
        try {
            c axs = c.axs();
            a anonymousClass1 = new a() {
                public final void p(float f, float f2) {
                    try {
                        String valueOf = String.valueOf(f);
                        String valueOf2 = String.valueOf(f2);
                        if (j.awC().wP(com.tencent.mm.plugin.freewifi.model.d.awt()) != null) {
                            g.oUh.i(12073, new Object[]{r2.field_ssid, r2.field_mac, r2.field_url, r2.field_url, valueOf2, valueOf});
                            w.i("MicroMsg.FreeWifi.FreeWifiLocationReporter", "report location. ssid=%s, mac=%s, mp_url=%s, qrcode=%s, longtitued=%s, latitude=%s", new Object[]{r2.field_ssid, r2.field_mac, r2.field_url, r2.field_url, valueOf, valueOf2});
                        }
                    } catch (Exception e) {
                        w.e("MicroMsg.FreeWifi.FreeWifiLocationReporter", "report location exception. " + e.getMessage() + m.f(e));
                    }
                }
            };
            if (!axs.aJi) {
                axs.aJi = true;
                axs.lWL = c.Gk();
                if (axs.lWL == null) {
                    w.e(c.TAG, "doGeoLocation fail, iGetLocation is null");
                    return;
                }
                if (axs.iNl == null) {
                    axs.iNl = new com.tencent.mm.plugin.freewifi.ui.c.AnonymousClass1(axs, anonymousClass1);
                }
                if (axs.iNm == null) {
                    axs.iNm = new ae(Looper.myLooper());
                }
                axs.iNm.postDelayed(new Runnable(axs) {
                    final /* synthetic */ c lWN;

                    {
                        this.lWN = r1;
                    }

                    public final void run() {
                        this.lWN.aJi = false;
                        if (this.lWN.lWL != null) {
                            this.lWN.lWL.c(this.lWN.iNl);
                        }
                        if (this.lWN.iNl == null) {
                            w.w(c.TAG, "already callback");
                        } else {
                            this.lWN.iNl = null;
                        }
                    }
                }, 20000);
                axs.lWL.a(axs.iNl);
            }
        } catch (Exception e) {
            w.e("MicroMsg.FreeWifi.FreeWifiLocationReporter", "report location error. " + e.getMessage());
        }
    }
}
