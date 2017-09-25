package com.tencent.mm.plugin.sns.model;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.protocal.c.alh;
import com.tencent.mm.protocal.c.ali;
import com.tencent.mm.protocal.c.bca;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final class aj {
    private static String bfg() {
        Context context = ab.getContext();
        if (context == null) {
            w.e("MicroMsg.SnsItemReportHelper", "ERROR Context is null scene");
            return null;
        }
        String str;
        int i = 0;
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            int subtype = activeNetworkInfo.getSubtype();
            if (activeNetworkInfo.getType() == 1) {
                i = 1;
            } else if (subtype == 13 || subtype == 15 || subtype == 14) {
                i = 4;
            } else if (subtype == 3 || subtype == 4 || subtype == 5 || subtype == 6 || subtype == 12) {
                i = 3;
            } else if (subtype == 1 || subtype == 2) {
                i = 2;
            } else {
                i = 0;
            }
        } catch (Throwable e) {
            w.e("MicroMsg.SnsItemReportHelper", "getNetType : %s", new Object[]{bg.g(e)});
        }
        w.i("MicroMsg.SnsItemReportHelper", "get netType :%d", new Object[]{Integer.valueOf(i)});
        String str2 = "";
        String str3 = "";
        String str4 = "";
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            StringBuffer stringBuffer = new StringBuffer();
            StringBuffer stringBuffer2 = new StringBuffer();
            StringBuffer stringBuffer3 = new StringBuffer();
            int i2 = 0;
            ArrayList arrayList = new ArrayList();
            stringBuffer.append(connectionInfo.getSSID());
            stringBuffer2.append(connectionInfo.getBSSID());
            String bssid = connectionInfo.getBSSID();
            arrayList.add(bssid);
            List<ScanResult> scanResults = wifiManager.getScanResults();
            if (scanResults != null) {
                Collections.sort(scanResults, new Comparator<ScanResult>() {
                    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                        return ((ScanResult) obj2).level - ((ScanResult) obj).level;
                    }
                });
                int i3 = 20;
                for (ScanResult scanResult : scanResults) {
                    if (!(scanResult == null || bg.mA(scanResult.BSSID))) {
                        if (!scanResult.BSSID.equals(bssid)) {
                            int i4 = i3 - 1;
                            if (i3 <= 0) {
                                break;
                            }
                            stringBuffer.append("|");
                            stringBuffer.append(bg.mz(scanResult.SSID).replace("|", "").replace(" ", ""));
                            stringBuffer2.append("|");
                            stringBuffer2.append(bg.mz(scanResult.BSSID).replace("|", "").replace(" ", ""));
                            arrayList.add(scanResult.BSSID);
                            stringBuffer3.append("|");
                            stringBuffer3.append(scanResult.level);
                            i3 = i4;
                        } else {
                            i2 = scanResult.level;
                        }
                    }
                }
            }
            int i5 = i2;
            str2 = stringBuffer.toString();
            str3 = stringBuffer2.toString();
            str4 = i5 + stringBuffer3.toString();
        } catch (Throwable e2) {
            Throwable th = e2;
            str = str3;
            str3 = str2;
            w.e("MicroMsg.SnsItemReportHelper", "getWifiInfo : %s", new Object[]{bg.g(th)});
            str2 = str3;
            str3 = str;
        }
        w.d("MicroMsg.SnsItemReportHelper", "get wifi :[%s] [%s] [%s]", new Object[]{str3, str2, str4});
        String str5 = "";
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                str = telephonyManager.getNetworkOperatorName();
            } else {
                str = str5;
            }
            str5 = str;
        } catch (Throwable e22) {
            w.e("MicroMsg.SnsItemReportHelper", "getNetType : %s", new Object[]{bg.g(e22)});
        }
        w.i("MicroMsg.SnsItemReportHelper", "get ispName: %s", new Object[]{str5});
        String str6 = "";
        String str7 = "";
        String str8 = "";
        String str9 = "";
        try {
            List ej = am.ej(context);
            int i6 = 0;
            while (i6 < ej.size()) {
                a aVar = (a) ej.get(i6);
                str6 = bg.ap(aVar.uus, "");
                str7 = bg.ap(aVar.uut, "");
                if (str8.length() > 0 && !bg.mA(aVar.uuv)) {
                    str8 = str8 + "|";
                }
                if (!bg.mA(aVar.uuv)) {
                    str8 = str8 + aVar.uuv;
                }
                if (str9.length() > 0 && !bg.mA(aVar.uuu)) {
                    str9 = str9 + "|";
                }
                if (bg.mA(aVar.uuu)) {
                    str = str9;
                } else {
                    str = str9 + aVar.uuu;
                }
                i6++;
                str9 = str;
            }
            str = str9;
            str9 = str8;
            str8 = str7;
            str7 = str6;
        } catch (Throwable e222) {
            th = e222;
            str = str9;
            str9 = str8;
            str8 = str7;
            str7 = str6;
            w.e("MicroMsg.SnsItemReportHelper", "getNetType : %s", new Object[]{bg.g(th)});
        }
        w.d("MicroMsg.SnsItemReportHelper", "mcc:%s mnc:%s cell:%s lac:%s", new Object[]{str7, str8, str9, str});
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(i).append(",");
        stringBuilder.append(str2.replace(",", " ")).append(",");
        stringBuilder.append(str3.replace(",", " ")).append(",");
        stringBuilder.append(str4.replace(",", " ")).append(",");
        stringBuilder.append(str5.replace(",", " ")).append(",");
        stringBuilder.append(str7.replace(",", " ")).append(",");
        stringBuilder.append(str8.replace(",", " ")).append(",");
        stringBuilder.append(str9.replace(",", " ")).append(",");
        stringBuilder.append(str.replace(",", " "));
        return stringBuilder.toString();
    }

    public static void dw(long j) {
        if (j != 0) {
            m dG = ae.beL().dG(j);
            if (dG != null && dG.field_type == 1) {
                ali bhq = dG.bhq();
                if (bhq != null) {
                    List list = bhq.tPS;
                    List list2 = dG.bhd().ufB.tsO;
                    int min = Math.min(list.size(), list2.size());
                    String str = "";
                    if (min > 0) {
                        str = bfg();
                        if (bg.mA(str)) {
                            return;
                        }
                    }
                    String str2 = str;
                    for (int i = 0; i < min; i++) {
                        bca com_tencent_mm_protocal_c_bca = (bca) list.get(i);
                        StringBuffer stringBuffer = new StringBuffer();
                        alh com_tencent_mm_protocal_c_alh = (alh) list2.get(i);
                        stringBuffer.append("||index: " + i);
                        stringBuffer.append("||item poi lat " + com_tencent_mm_protocal_c_bca.udj + " " + com_tencent_mm_protocal_c_bca.udk);
                        stringBuffer.append("||item poi accuracy loctype " + com_tencent_mm_protocal_c_bca.aLh + " " + com_tencent_mm_protocal_c_bca.quO);
                        stringBuffer.append("||item pic lat " + com_tencent_mm_protocal_c_bca.udh + " " + com_tencent_mm_protocal_c_bca.udi);
                        stringBuffer.append("||item exitime:" + com_tencent_mm_protocal_c_bca.udm + " filetime: " + com_tencent_mm_protocal_c_bca.udn);
                        stringBuffer.append("||item source: " + com_tencent_mm_protocal_c_bca.udl);
                        stringBuffer.append("||url" + com_tencent_mm_protocal_c_alh.msN);
                        String str3 = com_tencent_mm_protocal_c_alh.msN;
                        if (str3.startsWith("http://mmsns.qpic.cn/mmsns/")) {
                            int lastIndexOf = str3.lastIndexOf("/");
                            if (lastIndexOf > 27 && lastIndexOf < str3.length()) {
                                str3 = str3.substring(27, lastIndexOf);
                            }
                        }
                        w.d("MicroMsg.SnsItemReportHelper", "report:%s", new Object[]{str3 + "," + i.df(j) + "," + i + "," + bg.Ny() + "," + com_tencent_mm_protocal_c_bca.udl + "," + com_tencent_mm_protocal_c_bca.udn + "," + com_tencent_mm_protocal_c_bca.udm + "," + com_tencent_mm_protocal_c_bca.udi + "," + com_tencent_mm_protocal_c_bca.udh + "," + com_tencent_mm_protocal_c_bca.udk + "," + com_tencent_mm_protocal_c_bca.udj + "," + str2 + "," + com_tencent_mm_protocal_c_bca.aLh + "," + com_tencent_mm_protocal_c_bca.quO});
                        g.oUh.A(11985, str);
                    }
                }
            }
        }
    }
}
