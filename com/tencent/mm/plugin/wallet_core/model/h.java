package com.tencent.mm.plugin.wallet_core.model;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.wifi.WifiInfo;
import android.util.Base64;
import com.tencent.mm.R;
import com.tencent.mm.jniinterface.AesEcb;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.protocal.c.at;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.base.g;
import java.lang.ref.WeakReference;
import org.json.JSONArray;
import org.json.JSONObject;

public final class h {
    public static c nio;
    private static a rFs;
    private static h rFt;
    public static at rFu = null;
    public JSONArray rFv;

    private static class a implements com.tencent.mm.modelgeo.a.a {
        int hqX = 0;
        WeakReference<Activity> rFw;

        public a(Activity activity) {
            this.rFw = new WeakReference(activity);
        }

        public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            if (z) {
                if (h.rFu == null) {
                    h.rFu = new at();
                }
                String xL = m.xL();
                ap.yY();
                x Rc = com.tencent.mm.u.c.wR().Rc(xL);
                h.rFu.gkC = Rc.getCityCode();
                h.rFu.gkB = Rc.bLi();
                long j = h.Gk().hDd;
                WifiInfo wifiInfo = am.getWifiInfo(ab.getContext());
                String str = "";
                String str2 = "";
                xL = "";
                if (wifiInfo != null) {
                    str = wifiInfo.getSSID();
                    str2 = System.currentTimeMillis();
                    xL = wifiInfo.getBSSID();
                }
                h.HR(String.format("latitude=%.6f&longitude=%.6f&location_timestamp=%s&wifissid=%s&wifibssid=%s&ssid_timestamp=%s", new Object[]{Float.valueOf(f2), Float.valueOf(f), Long.valueOf(j), str, xL, str2}));
                w.i("MicroMsg.GpsReportHelper", "fLongitude=" + f + ";fLatitude=" + f2 + " tryCount: " + this.hqX);
                this.hqX++;
                if (this.hqX > 3) {
                    h.nio.c(this);
                }
                return true;
            }
            w.e("MicroMsg.GpsReportHelper", "get Location fail;isOk=" + z);
            h.nio.c(this);
            if (!(this.rFw == null || this.rFw.get() == null)) {
                MMAppMgr.aj((Context) this.rFw.get());
            }
            return false;
        }
    }

    private h() {
        init();
    }

    private void init() {
        ap.yY();
        String str = (String) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.uDO, "");
        w.i("MicroMsg.GpsReportHelper", "GpsReportHelper " + str);
        if (!bg.mA(str)) {
            try {
                this.rFv = new JSONArray(str);
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.GpsReportHelper", e, "", new Object[0]);
                w.e("MicroMsg.GpsReportHelper", "parse lbs config error", new Object[]{e});
            }
        }
    }

    public static h btJ() {
        if (rFt == null) {
            rFt = new h();
        }
        return rFt;
    }

    protected static void HR(String str) {
        if (rFu == null) {
            rFu = new at();
        }
        w.d("MicroMsg.GpsReportHelper", "encrpydata %s", new Object[]{str});
        byte[] bArr = new byte[16];
        byte[] bytes = com.tencent.mm.wallet_core.c.m.ccb().getBytes();
        if (bytes == null || bytes.length <= 0) {
            bytes = (System.currentTimeMillis()).getBytes();
        }
        int i = 0;
        int i2 = 0;
        do {
            bArr[i2] = bytes[i];
            i2++;
            i++;
            if (i >= bytes.length) {
                i = 0;
                continue;
            }
        } while (i2 < 16);
        bytes = Base64.encode(bArr, 0);
        at atVar = rFu;
        if (k.rFx == null) {
            k.rFx = new k();
        }
        atVar.tea = k.rFx.aN(bytes);
        w.d("MicroMsg.GpsReportHelper", "mLocationInfo.encrypt_key %s", new Object[]{rFu.tea});
        bytes = Base64.encode(AesEcb.aesCryptEcb(str.getBytes(), bArr, true, true), 0);
        rFu.tdZ = new String(bytes);
        w.d("MicroMsg.GpsReportHelper", "mLocationInfo.encrypt_userinfo %s", new Object[]{new String(bytes)});
    }

    public static c Gk() {
        if (nio == null) {
            nio = c.Gk();
        }
        return nio;
    }

    public static void h(final Activity activity, final int i) {
        int i2 = 1;
        w.i("MicroMsg.GpsReportHelper", "reflashLocationInfo " + i);
        w.i("MicroMsg.WalletSwitchConfig", "isReportLocation, ret = %s switchBit %s", new Object[]{Boolean.valueOf((m.btS().buq().rIi & 8192) > 0), Integer.valueOf(m.btS().buq().rIi)});
        String str;
        if (!((m.btS().buq().rIi & 8192) > 0)) {
            rFs = null;
            w.i("MicroMsg.WalletSwitchConfig", "isReportWifiSSid, ret = %s switchBit %s", new Object[]{Boolean.valueOf((m.btS().buq().rIi & 262144) > 0), Integer.valueOf(m.btS().buq().rIi)});
            if ((m.btS().buq().rIi & 262144) > 0) {
                WifiInfo wifiInfo = am.getWifiInfo(ab.getContext());
                String str2 = "";
                str = "";
                String str3 = "";
                if (wifiInfo != null) {
                    str2 = wifiInfo.getSSID();
                    str = System.currentTimeMillis();
                    str3 = wifiInfo.getBSSID();
                }
                HR(String.format("wifissid=%s&wifibssid=%s&ssid_timestamp=%s", new Object[]{str2, str3, str}));
            }
        } else if (c.Gl() || c.Gm()) {
            w.i("MicroMsg.GpsReportHelper", "reflashLocationInfo scene:%d", new Object[]{Integer.valueOf(i)});
            if (activity != null) {
                c Gk = Gk();
                if (rFs == null) {
                    rFs = new a(activity);
                } else {
                    a aVar = rFs;
                    if (activity == null || aVar.rFw == null || !activity.equals(aVar.rFw.get())) {
                        i2 = 0;
                    }
                    if (i2 == 0) {
                        rFs = new a(activity);
                    }
                }
                if (rFs != null) {
                    rFs.hqX = 0;
                }
                Gk.a(rFs, false);
                return;
            }
            rFs = null;
        } else if (btJ().vx(i)) {
            w.i("MicroMsg.GpsReportHelper", "should show lbs dialog,scene:%d", new Object[]{Integer.valueOf(i)});
            ap.yY();
            str = (String) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.uDP, activity.getString(R.l.fjV));
            ap.yY();
            String str4 = (String) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.uDQ, activity.getString(R.l.fjU));
            ap.yY();
            com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uDN, Long.valueOf(bg.Ny()));
            g.a(activity, str4, str, activity.getString(R.l.evw), activity.getString(R.l.dGs), false, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    activity.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
                    com.tencent.mm.plugin.report.service.g.oUh.i(13446, new Object[]{Integer.valueOf(i), Integer.valueOf(2), Long.valueOf(bg.Ny())});
                    dialogInterface.dismiss();
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            }, R.e.aWu);
        } else {
            w.i("MicroMsg.GpsReportHelper", "should'n show lbs dialog,scene:%d", new Object[]{Integer.valueOf(i)});
        }
    }

    public static at btK() {
        return rFu;
    }

    private boolean vx(int i) {
        if (i == 5 || i == 6) {
            return false;
        }
        boolean z;
        ap.yY();
        long longValue = ((Long) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.uDN, Long.valueOf(0))).longValue();
        if (this.rFv == null) {
            init();
        }
        if (this.rFv != null) {
            z = false;
            for (int i2 = 0; i2 < this.rFv.length(); i2++) {
                JSONObject optJSONObject = this.rFv.optJSONObject(i2);
                if (optJSONObject != null && optJSONObject.optInt("scene") == i) {
                    int i3;
                    if (optJSONObject.optInt("is_show_tips", 0) == 1) {
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    int optInt = optJSONObject.optInt("show_interval", 0);
                    long Ny = bg.Ny();
                    if (i3 != 0 && Ny - longValue > ((long) optInt)) {
                        z = true;
                    }
                }
            }
        } else {
            z = false;
        }
        w.i("MicroMsg.GpsReportHelper", "shouldShow? %s mLbsConfig: %s ", new Object[]{Boolean.valueOf(z), this.rFv});
        return z;
    }
}
