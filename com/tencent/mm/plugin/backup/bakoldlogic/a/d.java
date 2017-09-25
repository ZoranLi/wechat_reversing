package com.tencent.mm.plugin.backup.bakoldlogic.a;

import android.content.Context;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tencent.mm.a.g;
import com.tencent.mm.opensdk.constants.ConstantsAPI.AppSupportContentFlag;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.o;
import java.util.LinkedList;
import java.util.List;

public final class d {
    private static List<String> jBA = null;

    public static List<String> aap() {
        if (jBA != null) {
            return jBA;
        }
        jBA = new LinkedList();
        for (Object add : o.hly) {
            jBA.add(add);
        }
        jBA.add("weixin");
        jBA.add("weibo");
        jBA.add("qqmail");
        jBA.add("fmessage");
        jBA.add("tmessage");
        jBA.add("qmessage");
        jBA.add("qqsync");
        jBA.add("floatbottle");
        jBA.add("lbsapp");
        jBA.add("shakeapp");
        jBA.add("medianote");
        jBA.add("qqfriend");
        jBA.add("readerapp");
        jBA.add("newsapp");
        jBA.add("blogapp");
        jBA.add("facebookapp");
        jBA.add("masssendapp");
        jBA.add("meishiapp");
        jBA.add("feedsapp");
        jBA.add("voipapp");
        jBA.add("officialaccounts");
        jBA.add("helper_entry");
        jBA.add("pc_share");
        jBA.add("cardpackage");
        jBA.add("voicevoipapp");
        jBA.add("voiceinputapp");
        jBA.add("linkedinplugin");
        jBA.add("appbrandcustomerservicemsg");
        return jBA;
    }

    public static String rD(String str) {
        if (str == null) {
            return "";
        }
        String n = g.n(str.getBytes());
        String str2 = "";
        String str3 = "";
        if (n.length() > 0) {
            str2 = n.charAt(0) + "/";
        }
        if (n.length() >= 2) {
            str3 = n.charAt(1) + "/";
        }
        return str2 + str3;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(long r14, com.tencent.mm.pointers.PLong r16, com.tencent.mm.pointers.PLong r17, java.lang.String r18) {
        /*
        r2 = com.tencent.mm.compatible.util.h.getExternalStorageDirectory();
        r3 = new android.os.StatFs;
        r2 = r2.getPath();
        r3.<init>(r2);
        r2 = r3.getBlockSize();
        r4 = (long) r2;
        r2 = r3.getAvailableBlocks();
        r2 = (long) r2;
        r2 = r2 * r4;
        r0 = r16;
        r0.value = r2;
        r2 = com.tencent.mm.compatible.util.h.getDataDirectory();
        r3 = new android.os.StatFs;
        r4 = r2.getPath();
        r3.<init>(r4);
        r4 = r3.getBlockCount();
        r4 = (long) r4;
        r6 = r3.getAvailableBlocks();
        r6 = (long) r6;
        r8 = r3.getBlockSize();
        r8 = (long) r8;
        r3 = r3.getAvailableBlocks();
        r10 = (long) r3;
        r8 = r8 * r10;
        r0 = r17;
        r0.value = r8;
        r3 = "MicroMsg.BakUtil";
        r8 = "checkDataFull, SDAvailSize:%d, DataAvailSize%d, dbSize:%d";
        r9 = 3;
        r9 = new java.lang.Object[r9];
        r10 = 0;
        r0 = r16;
        r12 = r0.value;
        r11 = java.lang.Long.valueOf(r12);
        r9[r10] = r11;
        r10 = 1;
        r0 = r17;
        r12 = r0.value;
        r11 = java.lang.Long.valueOf(r12);
        r9[r10] = r11;
        r10 = 2;
        r11 = java.lang.Long.valueOf(r14);
        r9[r10] = r11;
        com.tencent.mm.sdk.platformtools.w.i(r3, r8, r9);
        r8 = 0;
        r3 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1));
        if (r3 > 0) goto L_0x0073;
    L_0x0071:
        r2 = 0;
    L_0x0072:
        return r2;
    L_0x0073:
        r4 = r4 - r6;
        r6 = 0;
        r3 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r3 >= 0) goto L_0x007c;
    L_0x007a:
        r2 = 0;
        goto L_0x0072;
    L_0x007c:
        r0 = r16;
        r4 = r0.value;
        r0 = r17;
        r6 = r0.value;
        r3 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r3 == 0) goto L_0x0094;
    L_0x0088:
        r2 = r2.getPath();
        r0 = r18;
        r2 = r0.startsWith(r2);
        if (r2 == 0) goto L_0x009a;
    L_0x0094:
        r2 = 0;
        r0 = r16;
        r0.value = r2;
    L_0x009a:
        r0 = r17;
        r2 = r0.value;
        r2 = (r14 > r2 ? 1 : (r14 == r2 ? 0 : -1));
        if (r2 <= 0) goto L_0x00a4;
    L_0x00a2:
        r2 = 0;
        goto L_0x0072;
    L_0x00a4:
        r2 = 1;
        goto L_0x0072;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.backup.bakoldlogic.a.d.a(long, com.tencent.mm.pointers.PLong, com.tencent.mm.pointers.PLong, java.lang.String):boolean");
    }

    public static String bH(Context context) {
        WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
        if (wifiManager.getWifiState() == 3) {
            String ssid;
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            if (connectionInfo != null) {
                try {
                    ssid = connectionInfo.getSSID();
                } catch (Throwable e) {
                    w.e("MicroMsg.BakUtil", "getConnectionInfo %s", new Object[]{e});
                    w.printErrStackTrace("MicroMsg.BakUtil", e, "", new Object[0]);
                    return "";
                }
            }
            ssid = "wifi";
            if (ssid.length() < 2 || !ssid.startsWith("\"") || !ssid.endsWith("\"")) {
                return ssid;
            }
            w.i("MicroMsg.BakUtil", "start and end with \", and trunk it");
            return ssid.substring(1, ssid.length() - 1);
        }
        int intValue;
        int i = 13;
        try {
            i = ((Integer) wifiManager.getClass().getField("WIFI_AP_STATE_ENABLED").get(wifiManager)).intValue();
            intValue = ((Integer) wifiManager.getClass().getMethod("getWifiApState", new Class[0]).invoke(wifiManager, new Object[0])).intValue();
        } catch (Throwable e2) {
            w.e("MicroMsg.BakUtil", "getWifiApState %s", new Object[]{e2});
            w.printErrStackTrace("MicroMsg.BakUtil", e2, "", new Object[0]);
            intValue = 0;
        }
        if (intValue == i) {
            w.i("MicroMsg.BakUtil", "getWifiName apmode");
            try {
                return ((WifiConfiguration) wifiManager.getClass().getMethod("getWifiApConfiguration", new Class[0]).invoke(wifiManager, new Object[0])).SSID;
            } catch (Throwable e3) {
                w.e("MicroMsg.BakUtil", "getWifiApConfiguration %s", new Object[]{e3});
                w.printErrStackTrace("MicroMsg.BakUtil", e3, "", new Object[0]);
            }
        }
        return "";
    }

    public static boolean abN() {
        int intValue;
        int intValue2;
        Throwable e;
        WifiManager wifiManager = (WifiManager) ab.getContext().getSystemService("wifi");
        try {
            intValue = ((Integer) wifiManager.getClass().getField("WIFI_AP_STATE_ENABLED").get(wifiManager)).intValue();
            try {
                intValue2 = ((Integer) wifiManager.getClass().getMethod("getWifiApState", new Class[0]).invoke(wifiManager, new Object[0])).intValue();
            } catch (Exception e2) {
                e = e2;
                w.e("MicroMsg.BakUtil", "getWifiApState %s", new Object[]{e});
                w.printErrStackTrace("MicroMsg.BakUtil", e, "", new Object[0]);
                intValue2 = 0;
                if (intValue2 == intValue) {
                    return false;
                }
                return true;
            }
        } catch (Exception e3) {
            e = e3;
            intValue = 13;
            w.e("MicroMsg.BakUtil", "getWifiApState %s", new Object[]{e});
            w.printErrStackTrace("MicroMsg.BakUtil", e, "", new Object[0]);
            intValue2 = 0;
            if (intValue2 == intValue) {
                return true;
            }
            return false;
        }
        if (intValue2 == intValue) {
            return true;
        }
        return false;
    }

    public static String aI(long j) {
        long j2 = j / AppSupportContentFlag.MMAPP_SUPPORT_XLS;
        long j3 = j2 / AppSupportContentFlag.MMAPP_SUPPORT_XLS;
        long j4 = j3 / AppSupportContentFlag.MMAPP_SUPPORT_XLS;
        if (j4 > 0) {
            return j4 + "." + (((j3 - (j4 * AppSupportContentFlag.MMAPP_SUPPORT_XLS)) * 10) / AppSupportContentFlag.MMAPP_SUPPORT_XLS) + "G";
        }
        if (j3 > 0) {
            return j3 + "." + (((j2 - (j3 * AppSupportContentFlag.MMAPP_SUPPORT_XLS)) * 10) / AppSupportContentFlag.MMAPP_SUPPORT_XLS) + "M";
        }
        if (j2 == 0) {
            j2 = 1;
        }
        return j2 + "K";
    }
}
