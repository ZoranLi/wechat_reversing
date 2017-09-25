package com.tencent.mm.plugin.freewifi;

import android.net.Uri;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.protocal.c.ac;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;

public final class h {
    private com.tencent.mm.plugin.freewifi.g.b lRk = j.awD();
    private String lRl;

    enum a {
        version("version", "2"),
        httpConnectTimeoutMillis("httpConnectTimeoutMillis", "5000"),
        httpReadTimeoutMillis("httpReadTimeoutMillis", "5000"),
        pingEnabled("pingEnabled", "1"),
        pingUrl("pingUrl", "http://o2o.gtimg.com/wifi/echo"),
        threeTwoBlackUrl("threeTwoBlackUrl", "http://o2o.gtimg.com/wifi/echo.html");
        
        String arH;
        String lRs;

        private a(String str, String str2) {
            this.arH = str;
            this.lRs = str2;
        }
    }

    private static class b {
        public static h lRu = new h();
    }

    public final synchronized void a(ac acVar) {
        avS();
        if (acVar == null || acVar.tcA == null) {
            w.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config is null.");
        } else {
            this.lRk.axd();
            if (acVar.tcA.version == -1) {
                this.lRk.Ku();
                w.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "all local config data deleted.");
                this.lRk.axd();
            } else if (acVar.tcA.version > avT()) {
                w.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config.version is %d, local version is %d.", new Object[]{Integer.valueOf(acVar.tcA.version), Integer.valueOf(avT())});
                w.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config.version = %d " + acVar.tcA.version);
                w.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config.httpConnectTimeoutMillis = %d " + acVar.tcA.tso);
                w.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config.httpReadTimeoutMillis = %d " + acVar.tcA.tsp);
                w.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config.pingUrl = %s " + acVar.tcA.fEM);
                w.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config.pingEnabled = %s " + acVar.tcA.fEL);
                w.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config.ThreeTwoBlackUrl = %s " + acVar.tcA.tsq);
                mH(acVar.tcA.tso);
                mI(acVar.tcA.tsp);
                wu(acVar.tcA.fEM);
                wt(acVar.tcA.fEL);
                wv(acVar.tcA.tsq);
                mG(acVar.tcA.version);
                w.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "local config data changed.");
                this.lRk.axd();
            }
        }
    }

    private synchronized void avS() {
        try {
            String wN = this.lRk.wN(a.version.arH);
            if (!m.wx(wN) && Integer.valueOf(wN).intValue() < Integer.valueOf(a.version.lRs).intValue()) {
                mH(Integer.valueOf(a.httpConnectTimeoutMillis.lRs).intValue());
                mI(Integer.valueOf(a.httpReadTimeoutMillis.lRs).intValue());
                wu(a.pingUrl.lRs);
                wt(a.pingEnabled.lRs);
                wv(a.threeTwoBlackUrl.lRs);
                mG(Integer.valueOf(a.version.lRs).intValue());
            }
        } catch (Exception e) {
            w.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "updateDiskDbCacheIfLowerThanDefault exception. " + m.f(e));
        }
    }

    public final synchronized int avT() {
        int intValue;
        avS();
        try {
            String wN = this.lRk.wN(a.version.arH);
            if (m.wx(wN)) {
                intValue = Integer.valueOf(a.version.lRs).intValue();
            } else {
                intValue = Integer.valueOf(wN).intValue();
            }
        } catch (Exception e) {
            intValue = Integer.valueOf(a.version.lRs).intValue();
        }
        return intValue;
    }

    private synchronized void mG(int i) {
        if (i > Integer.valueOf(a.version.lRs).intValue()) {
            j.awD().cg(a.version.arH, String.valueOf(i));
        }
    }

    public final int avU() {
        avS();
        try {
            String wN = this.lRk.wN(a.httpConnectTimeoutMillis.arH);
            if (m.wx(wN)) {
                return Integer.valueOf(a.httpConnectTimeoutMillis.lRs).intValue();
            }
            return Integer.valueOf(wN).intValue();
        } catch (Exception e) {
            return Integer.valueOf(a.httpConnectTimeoutMillis.lRs).intValue();
        }
    }

    private static void mH(int i) {
        if (i > 0) {
            j.awD().cg(a.httpConnectTimeoutMillis.arH, String.valueOf(i));
        }
    }

    public final int avV() {
        avS();
        try {
            String wN = this.lRk.wN(a.httpReadTimeoutMillis.arH);
            if (m.wx(wN)) {
                return Integer.valueOf(a.httpReadTimeoutMillis.lRs).intValue();
            }
            return Integer.valueOf(wN).intValue();
        } catch (Exception e) {
            return Integer.valueOf(a.httpReadTimeoutMillis.lRs).intValue();
        }
    }

    private void mI(int i) {
        if (i > 0) {
            this.lRk.cg(a.httpReadTimeoutMillis.arH, String.valueOf(i));
        }
    }

    public final String avW() {
        avS();
        try {
            if ("0".equals(this.lRk.wN(a.pingEnabled.arH))) {
                return "0";
            }
            return "1";
        } catch (Exception e) {
            return a.pingEnabled.lRs;
        }
    }

    private void wt(String str) {
        if ("0".equals(str) || "1".equals(str)) {
            try {
                this.lRk.cg(a.pingEnabled.arH, str);
            } catch (Exception e) {
            }
        }
    }

    public final String avX() {
        avS();
        try {
            String wN = this.lRk.wN(a.pingUrl.arH);
            if (m.wx(wN)) {
                return a.pingUrl.lRs;
            }
            Uri.parse(wN);
            return wN;
        } catch (Exception e) {
            return a.pingUrl.lRs;
        }
    }

    private void wu(String str) {
        if (!m.wx(str)) {
            try {
                Uri.parse(str);
                this.lRk.cg(a.pingUrl.arH, str);
            } catch (Exception e) {
            }
        }
    }

    public final String avY() {
        avS();
        try {
            String wN = this.lRk.wN(a.threeTwoBlackUrl.arH);
            if (m.wx(wN)) {
                return a.threeTwoBlackUrl.lRs;
            }
            Uri.parse(wN);
            return wN;
        } catch (Exception e) {
            return a.threeTwoBlackUrl.lRs;
        }
    }

    private void wv(String str) {
        if (!m.wx(str)) {
            try {
                Uri.parse(str);
                this.lRk.cg(a.threeTwoBlackUrl.arH, str);
            } catch (Exception e) {
            }
        }
    }

    public final String getUserAgent() {
        if (m.wx(this.lRl)) {
            this.lRl = s.aZ(ab.getContext(), null).toLowerCase();
        }
        return this.lRl;
    }
}
