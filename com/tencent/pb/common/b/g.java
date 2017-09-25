package com.tencent.pb.common.b;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tencent.pb.common.c.d;
import com.tencent.pb.common.c.e;

public final class g {
    private NetworkInfo gJR = null;
    private WifiInfo gJS = null;
    private int wLt = 1;

    public final synchronized boolean pV() {
        boolean z;
        WifiInfo wifiInfo = null;
        synchronized (this) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) e.rof.getSystemService("connectivity");
                if (connectivityManager == null) {
                    d.k("NetworkChangeMgr", "can't get ConnectivityManager");
                    this.wLt = 1;
                    this.gJS = null;
                    this.gJR = null;
                    z = true;
                } else {
                    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    if (activeNetworkInfo == null) {
                        this.wLt = 1;
                        this.gJS = null;
                        this.gJR = null;
                        z = true;
                    } else {
                        int i;
                        d.d("NetworkChangeMgr", "NetworkChangeMgr ", activeNetworkInfo);
                        if (!activeNetworkInfo.isConnected()) {
                            i = 1;
                        } else if (activeNetworkInfo.getType() == 1) {
                            wifiInfo = ((WifiManager) e.rof.getSystemService("wifi")).getConnectionInfo();
                            i = 2;
                        } else {
                            i = 3;
                        }
                        if (i == this.wLt) {
                            if (i == 1) {
                                z = false;
                            } else if (i == 2) {
                                if (wifiInfo != null && this.gJS != null && this.gJS.getBSSID().equals(wifiInfo.getBSSID()) && this.gJS.getSSID().equals(wifiInfo.getSSID()) && this.gJS.getNetworkId() == wifiInfo.getNetworkId()) {
                                    z = false;
                                } else {
                                    z = true;
                                }
                            } else if (this.gJR != null && this.gJR.getExtraInfo() != null && activeNetworkInfo.getExtraInfo() != null && this.gJR.getExtraInfo().equals(activeNetworkInfo.getExtraInfo()) && this.gJR.getSubtype() == activeNetworkInfo.getSubtype() && this.gJR.getType() == activeNetworkInfo.getType()) {
                                z = false;
                            } else if (this.gJR != null && this.gJR.getExtraInfo() == null && activeNetworkInfo.getExtraInfo() == null && this.gJR.getSubtype() == activeNetworkInfo.getSubtype() && this.gJR.getType() == activeNetworkInfo.getType()) {
                                z = false;
                            }
                            this.wLt = i;
                            this.gJS = wifiInfo;
                            this.gJR = activeNetworkInfo;
                        }
                        z = true;
                        this.wLt = i;
                        this.gJS = wifiInfo;
                        this.gJR = activeNetworkInfo;
                    }
                }
            } catch (Exception e) {
                d.k("NetworkChangeMgr", e);
                this.wLt = 1;
                this.gJS = null;
                this.gJR = null;
                z = true;
            }
        }
        return z;
    }
}
