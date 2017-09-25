package com.c.a.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.hardware.SensorManager;
import android.location.LocationManager;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.util.Base64;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class f {
    int aJA = 0;
    int aJB = 0;
    int aJC = 0;
    int aJD = 0;
    private String aJE = "203";
    private final WifiManager aJq;
    private final LocationManager aJr;
    final SensorManager aJs;
    final PackageManager aJt;
    PackageInfo aJu;
    String aJv;
    String aJw;
    String aJx;
    private int aJy = 0;
    private int aJz = 0;
    String imei;
    final Context mContext;
    private String version = "2.0.1";
    String versionName;

    public f(Context context) {
        this.mContext = context;
        this.aJq = (WifiManager) this.mContext.getSystemService("wifi");
        this.aJr = (LocationManager) this.mContext.getSystemService("location");
        this.aJs = (SensorManager) this.mContext.getSystemService("sensor");
        this.aJt = this.mContext.getPackageManager();
        this.aJu = new PackageInfo();
        try {
            this.aJu = this.aJt.getPackageInfo(this.mContext.getPackageName(), 0);
        } catch (NameNotFoundException e) {
        }
    }

    public final String k(byte[] bArr) {
        int i;
        int i2 = 1;
        Object hashMap = new HashMap();
        hashMap.put("version", this.version);
        hashMap.put("app_name", ay(this.versionName));
        if (this.aJv != null) {
            hashMap.put("app_label", ay(Base64.encodeToString(this.aJv.getBytes(), 0)));
        } else {
            hashMap.put("app_label", "");
        }
        String str = "chips";
        if (nj()) {
            i = 1;
        } else {
            i = 0;
        }
        this.aJz = i;
        i = (this.aJq == null || !this.aJq.isWifiEnabled()) ? 0 : 1;
        if ((i | nk()) == 0) {
            i2 = 0;
        }
        this.aJy = i2;
        hashMap.put(str, Integer.toBinaryString((((((this.aJD | 0) | (this.aJC << 1)) | (this.aJB << 2)) | (this.aJA << 3)) | (this.aJz << 4)) | (this.aJy << 5)));
        hashMap.put("source", this.aJE);
        hashMap.put("query", new String(bArr));
        try {
            Map hashMap2 = new HashMap();
            hashMap2.put("model", ay(Base64.encodeToString(this.aJw.getBytes(), 0)));
            hashMap2.put("version", ay(this.aJx));
            hashMap2.put("imei", ay(this.imei));
            return new JSONObject(hashMap).put("attribute", new JSONObject(hashMap2)).toString();
        } catch (JSONException e) {
            return null;
        }
    }

    private static String ay(String str) {
        if (str == null) {
            return "";
        }
        return str;
    }

    private boolean nj() {
        boolean z = false;
        try {
            z = this.aJr.isProviderEnabled("gps");
        } catch (Exception e) {
        }
        return z;
    }

    @SuppressLint({"NewApi"})
    private boolean nk() {
        boolean z = false;
        if (this.aJq != null) {
            z = this.aJq.isWifiEnabled();
            if (!z) {
                try {
                    if (VERSION.SDK_INT >= 18) {
                        z = this.aJq.isScanAlwaysAvailable();
                    }
                } catch (Exception e) {
                } catch (Error e2) {
                }
            }
        }
        return z;
    }
}
