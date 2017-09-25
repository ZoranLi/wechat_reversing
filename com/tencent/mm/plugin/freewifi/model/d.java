package com.tencent.mm.plugin.freewifi.model;

import android.content.Intent;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class d {
    private static Map<Integer, String> lTh = new HashMap<Integer, String>() {
        {
            put(Integer.valueOf(-1), "CONNECT_STATE_NOT_CONNECT");
            put(Integer.valueOf(0), "CONNECT_STATE_NOT_WECHAT_WIFI");
            put(Integer.valueOf(1), "CONNECT_STATE_CONNECTING");
            put(Integer.valueOf(2), "CONNECT_STATE_CONNECT_SUCCESS");
            put(Integer.valueOf(3), "CONNECT_STATE_CONNECT_FAILED");
            put(Integer.valueOf(4), "CONNECT_STATE_WAIT_START");
        }
    };

    public static int wF(String str) {
        if (bg.mA(str)) {
            w.d("MicroMsg.FreeWifi.FreeWifiManager", "Illegal SSID");
            return 0;
        }
        c wP = j.awC().wP(str);
        if (wP == null || !str.equalsIgnoreCase(wP.field_ssid)) {
            return 0;
        }
        if (wP.field_connectState == 2 && wP.field_expiredTime > 0 && wP.field_expiredTime - bg.Ny() <= 0) {
            wP.field_connectState = 1;
            boolean c = j.awC().c(wP, new String[0]);
            w.i("MicroMsg.FreeWifi.FreeWifiManager", "Expired, re-auth, expired time : %d, current time : %d, ret : %b", new Object[]{Long.valueOf(wP.field_expiredTime), Long.valueOf(bg.Ny()), Boolean.valueOf(c)});
        }
        return wP.field_connectState;
    }

    public static void release() {
    }

    public static boolean wG(String str) {
        w.i("MicroMsg.FreeWifi.FreeWifiManager", "check is wechat free wifi, ssid : %s", new Object[]{str});
        if (bg.mA(str)) {
            w.e("MicroMsg.FreeWifi.FreeWifiManager", "ssid is null or nil");
            return false;
        }
        String awt = awt();
        if (bg.mA(awt) || !awt.equals(str)) {
            return false;
        }
        return true;
    }

    public static int wH(String str) {
        WifiManager wifiManager = (WifiManager) ab.getContext().getSystemService("wifi");
        if (wifiManager == null) {
            w.e("MicroMsg.FreeWifi.FreeWifiManager", "addWifiNetWork, get wifi manager failed");
            return -11;
        }
        int wJ = wJ(str);
        if (wJ > 0) {
            w.i("MicroMsg.FreeWifi.FreeWifiManager", "addWifiNetWork, the network has exsited, just enable it");
        } else {
            WifiConfiguration wifiConfiguration = new WifiConfiguration();
            wifiConfiguration.allowedAuthAlgorithms.clear();
            wifiConfiguration.allowedGroupCiphers.clear();
            wifiConfiguration.allowedKeyManagement.clear();
            wifiConfiguration.allowedPairwiseCiphers.clear();
            wifiConfiguration.allowedProtocols.clear();
            wifiConfiguration.SSID = "\"" + str + "\"";
            w.i("MicroMsg.FreeWifi.FreeWifiManager", "check is the same ssid is exist, %b", new Object[]{Boolean.valueOf(wI(str))});
            wifiConfiguration.allowedKeyManagement.set(0);
            wifiConfiguration.wepTxKeyIndex = 0;
            wJ = wifiManager.addNetwork(wifiConfiguration);
        }
        w.i("MicroMsg.FreeWifi.FreeWifiManager", "addWifiNetWork netid : %d, result : %b", new Object[]{Integer.valueOf(wJ), Boolean.valueOf(wifiManager.enableNetwork(wJ, true))});
        if (wifiManager.enableNetwork(wJ, true)) {
            return 0;
        }
        return -14;
    }

    public static int d(String str, String str2, int i, boolean z) {
        w.i("MicroMsg.FreeWifi.FreeWifiManager", "addWifiNetWork by encrypt, ssid is : %s, password : %s, cryptType :%d, hideSSID = %b", new Object[]{str, str2, Integer.valueOf(i), Boolean.valueOf(z)});
        if (bg.mA(str)) {
            w.e("MicroMsg.FreeWifi.FreeWifiManager", "addWifiNetWork by encrypt alg failed, ssid is null");
            return -12;
        } else if (i == 0) {
            return wH(str);
        } else {
            if (bg.mA(str2)) {
                w.e("MicroMsg.FreeWifi.FreeWifiManager", "encrypt type is not none, while password is null");
                return -15;
            }
            WifiManager wifiManager = (WifiManager) ab.getContext().getSystemService("wifi");
            if (wifiManager == null) {
                w.e("MicroMsg.FreeWifi.FreeWifiManager", "addWifiNetWork by encrypt alg, get wifi manager failed");
                return -11;
            }
            int addNetwork;
            WifiConfiguration wifiConfiguration;
            if (f.eo(21)) {
                if (!bg.mA(str)) {
                    List<WifiConfiguration> configuredNetworks = ((WifiManager) ab.getContext().getSystemService("wifi")).getConfiguredNetworks();
                    if (configuredNetworks != null) {
                        w.i("MicroMsg.FreeWifi.FreeWifiManager", "get wificonfiguration list size : %d", new Object[]{Integer.valueOf(configuredNetworks.size())});
                        for (WifiConfiguration wifiConfiguration2 : configuredNetworks) {
                            if (wifiConfiguration2.SSID.equals("\"" + str + "\"")) {
                                break;
                            }
                        }
                    }
                    w.e("MicroMsg.FreeWifi.FreeWifiManager", "get wifi list is null");
                } else {
                    w.e("MicroMsg.FreeWifi.FreeWifiManager", "null or nill ssid");
                }
                wifiConfiguration2 = null;
                if (wifiConfiguration2 == null) {
                    wifiConfiguration2 = s(str, str2, i);
                    wifiConfiguration2.hiddenSSID = z;
                    addNetwork = wifiManager.addNetwork(wifiConfiguration2);
                } else {
                    if (wifiConfiguration2 != null) {
                        wifiConfiguration2.SSID = "\"" + str + "\"";
                        wifiConfiguration2.status = 2;
                        switch (i) {
                            case 1:
                                wifiConfiguration2.wepKeys = new String[]{"\"" + str2 + "\""};
                                wifiConfiguration2.allowedKeyManagement.set(0);
                                break;
                            case 2:
                            case 3:
                                wifiConfiguration2.preSharedKey = "\"" + str2 + "\"";
                                wifiConfiguration2.allowedKeyManagement.set(1);
                                break;
                            default:
                                w.e("MicroMsg.FreeWifi.FreeWifiManager", "unsupport encrypt type : %d", new Object[]{Integer.valueOf(i)});
                                break;
                        }
                    }
                    wifiConfiguration2.hiddenSSID = z;
                    addNetwork = wifiConfiguration2.networkId;
                }
                wifiManager.saveConfiguration();
            } else {
                addNetwork = wJ(str);
                if (addNetwork > 0) {
                    boolean removeNetwork = wifiManager.removeNetwork(addNetwork);
                    w.i("MicroMsg.FreeWifi.FreeWifiManager", "this network has exist : %s, try to remove it : %b", new Object[]{str, Boolean.valueOf(removeNetwork)});
                }
                wifiConfiguration2 = s(str, str2, i);
                wifiConfiguration2.hiddenSSID = z;
                addNetwork = wifiManager.addNetwork(wifiConfiguration2);
                wifiManager.saveConfiguration();
            }
            w.i("MicroMsg.FreeWifi.FreeWifiManager", "addWifiNetWork by encrypt alg, netid : %d, result : %b", new Object[]{Integer.valueOf(addNetwork), Boolean.valueOf(wifiManager.enableNetwork(addNetwork, true))});
            if (wifiManager.enableNetwork(addNetwork, true)) {
                return 0;
            }
            return -14;
        }
    }

    private static WifiConfiguration s(String str, String str2, int i) {
        WifiConfiguration wifiConfiguration = new WifiConfiguration();
        wifiConfiguration.SSID = "\"" + str + "\"";
        wifiConfiguration.status = 2;
        switch (i) {
            case 1:
                wifiConfiguration.wepKeys = new String[]{"\"" + str2 + "\""};
                wifiConfiguration.allowedKeyManagement.set(0);
                break;
            case 2:
            case 3:
                wifiConfiguration.preSharedKey = "\"" + str2 + "\"";
                wifiConfiguration.allowedKeyManagement.set(1);
                break;
            default:
                w.e("MicroMsg.FreeWifi.FreeWifiManager", "unsupport encrypt type : %d", new Object[]{Integer.valueOf(i)});
                break;
        }
        return wifiConfiguration;
    }

    public static boolean isWifiEnabled() {
        WifiManager wifiManager = (WifiManager) ab.getContext().getSystemService("wifi");
        if (wifiManager == null) {
            w.e("MicroMsg.FreeWifi.FreeWifiManager", "get wifi manager failed");
            return false;
        }
        w.i("MicroMsg.FreeWifi.FreeWifiManager", "is wifi enalbe now : %b", new Object[]{Boolean.valueOf(wifiManager.isWifiEnabled())});
        return wifiManager.isWifiEnabled();
    }

    public static boolean awq() {
        WifiManager wifiManager = (WifiManager) ab.getContext().getSystemService("wifi");
        if (wifiManager != null) {
            return wifiManager.setWifiEnabled(true);
        }
        w.e("MicroMsg.FreeWifi.FreeWifiManager", "get wifi manager failed");
        return false;
    }

    public static boolean wI(String str) {
        int wJ = wJ(str);
        w.i("MicroMsg.FreeWifi.FreeWifiManager", "get network id by ssid :%s, netid is %d", new Object[]{str, Integer.valueOf(wJ)});
        if (wJ == -1) {
            w.i("MicroMsg.FreeWifi.FreeWifiManager", "ssid is not exist : %s", new Object[]{str});
            return false;
        }
        WifiManager wifiManager = (WifiManager) ab.getContext().getSystemService("wifi");
        boolean removeNetwork = wifiManager.removeNetwork(wJ);
        wifiManager.saveConfiguration();
        w.i("MicroMsg.FreeWifi.FreeWifiManager", "remove ssid : %s, ret = %b", new Object[]{str, Boolean.valueOf(removeNetwork)});
        return removeNetwork;
    }

    private static int wJ(String str) {
        if (bg.mA(str)) {
            w.e("MicroMsg.FreeWifi.FreeWifiManager", "null or nill ssid");
            return -1;
        }
        List<WifiConfiguration> configuredNetworks = ((WifiManager) ab.getContext().getSystemService("wifi")).getConfiguredNetworks();
        if (configuredNetworks == null) {
            w.e("MicroMsg.FreeWifi.FreeWifiManager", "get wifi list is null");
            return -1;
        }
        w.i("MicroMsg.FreeWifi.FreeWifiManager", "get wificonfiguration list size : %d", new Object[]{Integer.valueOf(configuredNetworks.size())});
        for (WifiConfiguration wifiConfiguration : configuredNetworks) {
            if (wifiConfiguration.SSID.equals("\"" + str + "\"")) {
                return wifiConfiguration.networkId;
            }
        }
        return -1;
    }

    public static String mL(int i) {
        String str = (String) lTh.get(Integer.valueOf(i));
        if (str == null) {
            return "";
        }
        return str;
    }

    public static void a(String str, int i, Intent intent) {
        w.i("MicroMsg.FreeWifi.FreeWifiManager", "sessionKey=%s, step=%d, method=FreeWifiManager.updateConnectState, desc=it changes the connect state of the model to %s. state=%d", new Object[]{m.y(intent), Integer.valueOf(m.z(intent)), mL(i), Integer.valueOf(i)});
        c wP = j.awC().wP(str);
        if (wP != null) {
            wP.field_connectState = i;
            boolean c = j.awC().c(wP, new String[0]);
            w.i("MicroMsg.FreeWifi.FreeWifiManager", "update %s, connect state : %d, return : %b", new Object[]{str, Integer.valueOf(i), Boolean.valueOf(c)});
        }
    }

    public static String awr() {
        if (am.getNetType(ab.getContext()) == 0) {
            WifiInfo awu = awu();
            if (!(awu == null || awu.getBSSID() == null)) {
                w.i("MicroMsg.FreeWifi.FreeWifiManager", "getConnectWifiMacAddress, get bssid now : %s", new Object[]{awu.getBSSID()});
                return awu.getBSSID();
            }
        }
        return null;
    }

    public static int aws() {
        if (am.getNetType(ab.getContext()) == 0) {
            WifiInfo awu = awu();
            if (awu != null) {
                w.i("MicroMsg.FreeWifi.FreeWifiManager", "getConnectWifiSignal, get rssi now : %d", new Object[]{Integer.valueOf(awu.getRssi())});
                return awu.getRssi();
            }
        }
        return 0;
    }

    public static String awt() {
        w.i("MicroMsg.FreeWifi.FreeWifiManager", "networkType = %d", new Object[]{Integer.valueOf(am.getNetType(ab.getContext()))});
        if (am.getNetType(ab.getContext()) == 0) {
            WifiInfo awu = awu();
            if (!(awu == null || awu.getSSID() == null)) {
                w.i("MicroMsg.FreeWifi.FreeWifiManager", "get ssid now : %s", new Object[]{awu.getSSID().replace("\"", "")});
                return awu.getSSID().replace("\"", "");
            }
        }
        return null;
    }

    public static WifiInfo awu() {
        WifiManager wifiManager = (WifiManager) ab.getContext().getSystemService("wifi");
        if (wifiManager == null) {
            w.e("MicroMsg.FreeWifi.FreeWifiManager", "get wifi manager failed");
            return null;
        }
        try {
            return wifiManager.getConnectionInfo();
        } catch (Exception e) {
            w.e("MicroMsg.FreeWifi.FreeWifiManager", "getConnectionInfo failed : %s", new Object[]{e.getMessage()});
            return null;
        }
    }

    public static String awv() {
        WifiManager wifiManager = (WifiManager) ab.getContext().getSystemService("wifi");
        if (wifiManager == null) {
            w.e("MicroMsg.FreeWifi.FreeWifiManager", "get wifi manager failed");
            return "";
        }
        try {
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            if (connectionInfo == null) {
                return "";
            }
            String bssid = connectionInfo.getBSSID();
            if (bssid == null) {
                return "";
            }
            return bssid;
        } catch (Exception e) {
            w.e("MicroMsg.FreeWifi.FreeWifiManager", "getConnectWifiBssid failed : %s", new Object[]{e.getMessage()});
            return "";
        }
    }

    public static String aww() {
        WifiManager wifiManager = (WifiManager) ab.getContext().getSystemService("wifi");
        if (wifiManager == null) {
            w.e("MicroMsg.FreeWifi.FreeWifiManager", "get wifi manager failed");
            return "";
        }
        try {
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            if (connectionInfo == null) {
                return "";
            }
            String ssid = connectionInfo.getSSID();
            if (ssid == null) {
                return "";
            }
            return m.wy(ssid);
        } catch (Exception e) {
            w.e("MicroMsg.FreeWifi.FreeWifiManager", "getConnectWifiBssid failed : %s", new Object[]{e.getMessage()});
            return "";
        }
    }

    public static int getNetworkType() {
        return am.getNetType(ab.getContext());
    }
}
