package com.tencent.mm.booter;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tencent.mm.network.z;
import com.tencent.mm.sdk.platformtools.w;

public final class e {
    NetworkInfo gJR = null;
    WifiInfo gJS = null;

    final boolean pV() {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) z.getContext().getSystemService("connectivity");
            if (connectivityManager == null) {
                w.w("MicroMsg.NetworkChangeMgr", "can't get ConnectivityManager");
                this.gJR = null;
                this.gJS = null;
                return false;
            }
            NetworkInfo activeNetworkInfo;
            try {
                activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            } catch (Exception e) {
                w.e("MicroMsg.NetworkChangeMgr", "getActiveNetworkInfo failed.");
                activeNetworkInfo = null;
            }
            if (activeNetworkInfo == null) {
                w.w("MicroMsg.NetworkChangeMgr", "ActiveNetwork is null, has no network");
                this.gJR = null;
                this.gJS = null;
                return false;
            }
            WifiInfo connectionInfo;
            int i = activeNetworkInfo.getType() == 1 ? 1 : 0;
            if (i != 0) {
                connectionInfo = ((WifiManager) z.getContext().getSystemService("wifi")).getConnectionInfo();
                if (connectionInfo != null && this.gJS != null && this.gJS.getBSSID().equals(connectionInfo.getBSSID()) && this.gJS.getSSID().equals(connectionInfo.getSSID()) && this.gJS.getNetworkId() == connectionInfo.getNetworkId()) {
                    w.w("MicroMsg.NetworkChangeMgr", "Same Wifi, do not NetworkChanged");
                    return false;
                }
                w.d("MicroMsg.NetworkChangeMgr", "New Wifi Info:%s", connectionInfo);
                w.d("MicroMsg.NetworkChangeMgr", "OldWifi Info:%s", this.gJS);
            } else if (this.gJR != null && this.gJR.getExtraInfo() != null && activeNetworkInfo.getExtraInfo() != null && this.gJR.getExtraInfo().equals(activeNetworkInfo.getExtraInfo()) && this.gJR.getSubtype() == activeNetworkInfo.getSubtype() && this.gJR.getType() == activeNetworkInfo.getType()) {
                w.w("MicroMsg.NetworkChangeMgr", "Same Network, do not NetworkChanged");
                return false;
            } else if (this.gJR != null && this.gJR.getExtraInfo() == null && activeNetworkInfo.getExtraInfo() == null && this.gJR.getSubtype() == activeNetworkInfo.getSubtype() && this.gJR.getType() == activeNetworkInfo.getType()) {
                w.w("MicroMsg.NetworkChangeMgr", "Same Network, do not NetworkChanged");
                return false;
            } else {
                connectionInfo = null;
            }
            if (i == 0) {
                w.d("MicroMsg.NetworkChangeMgr", "New NetworkInfo:%s", activeNetworkInfo);
                if (this.gJR != null) {
                    w.d("MicroMsg.NetworkChangeMgr", "Old NetworkInfo:%s", this.gJR);
                }
            }
            this.gJR = activeNetworkInfo;
            this.gJS = connectionInfo;
            return true;
        } catch (Throwable e2) {
            w.printErrStackTrace("MicroMsg.NetworkChangeMgr", e2, "", new Object[0]);
        }
    }
}
