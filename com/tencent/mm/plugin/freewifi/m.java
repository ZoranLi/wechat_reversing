package com.tencent.mm.plugin.freewifi;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import com.tencent.mm.R;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.d;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.protocal.c.dy;
import com.tencent.mm.protocal.c.oc;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.bindmobile.BindMContactUI;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.net.ConnectException;
import java.net.NetworkInterface;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

public final class m {
    private static SimpleDateFormat jFf = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");

    public interface a {
        void h(int i, int i2, String str, k kVar);
    }

    public static boolean wx(String str) {
        return str == null || str.length() == 0;
    }

    public static String wy(String str) {
        if (wx(str)) {
            return "";
        }
        if (str.startsWith("\"") && str.endsWith("\"")) {
            return str.substring(1, str.length() - 1);
        }
        return str;
    }

    public static boolean awc() {
        String bk = bg.bk(ab.getContext());
        return bk != null && bk.toLowerCase().startsWith(ab.getPackageName());
    }

    public static void x(Intent intent) {
        if (wx(intent.getStringExtra("free_wifi_sessionkey"))) {
            d(intent, awd());
        }
    }

    public static String awd() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static void d(Intent intent, String str) {
        intent.putExtra("free_wifi_sessionkey", str);
        intent.putExtra("ConstantsFreeWifi.FREE_WIFI_LOG_STEP_ID", 0);
    }

    public static String y(Intent intent) {
        return wz(intent.getStringExtra("free_wifi_sessionkey"));
    }

    public static int z(Intent intent) {
        int intExtra = intent.getIntExtra("ConstantsFreeWifi.FREE_WIFI_LOG_STEP_ID", 0) + 1;
        intent.putExtra("ConstantsFreeWifi.FREE_WIFI_LOG_STEP_ID", intExtra);
        return intExtra;
    }

    public static int A(Intent intent) {
        return intent.getIntExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 0);
    }

    public static int B(Intent intent) {
        return intent.getIntExtra("free_wifi_channel_id", 0);
    }

    public static String C(Intent intent) {
        return intent.getStringExtra("free_wifi_ap_key");
    }

    public static String wz(String str) {
        return str == null ? "" : str;
    }

    public static String wA(String str) {
        if (awg()) {
            WifiManager wifiManager = (WifiManager) ab.getContext().getSystemService("wifi");
            if (wifiManager == null) {
                return "";
            }
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            if (connectionInfo == null) {
                return "";
            }
            String ssid = connectionInfo.getSSID();
            if (wx(ssid)) {
                w.i(str, "getConnectedWifiSsid() is empty");
                return "";
            }
            w.i(str, "getConnectedWifiSsid()=" + wy(ssid));
            return wy(ssid);
        }
        w.i(str, "wifi not connected. getConnectedWifiSsid() is empty");
        return "";
    }

    public static String wB(String str) {
        if (awg()) {
            WifiManager wifiManager = (WifiManager) ab.getContext().getSystemService("wifi");
            if (wifiManager == null) {
                return "";
            }
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            if (connectionInfo == null) {
                return "";
            }
            String toLowerCase = wz(connectionInfo.getBSSID()).toLowerCase();
            w.i(str, "getConnectedWifiBssid()=" + toLowerCase);
            return toLowerCase;
        }
        w.i(str, "wifi not connected. getConnectedWifiBssid() is empty");
        return "";
    }

    public static String wC(String str) {
        WifiManager wifiManager = (WifiManager) ab.getContext().getSystemService("wifi");
        if (wifiManager == null) {
            w.e(str, "error wifiManager is null!!");
            return "";
        }
        WifiInfo connectionInfo = wifiManager.getConnectionInfo();
        if (connectionInfo == null) {
            w.e(str, "error wifiInfo is null!!");
            return "";
        }
        String macAddress = connectionInfo.getMacAddress();
        if (VERSION.SDK_INT > 22 && (macAddress == null || macAddress.equals("02:00:00:00:00:00"))) {
            macAddress = awe();
        }
        macAddress = wz(macAddress).toLowerCase();
        w.i(str, "getConnectedWifiClientMac()=" + macAddress);
        return macAddress;
    }

    public static String awe() {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            String str = "wlan0";
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if (networkInterface.getName().equalsIgnoreCase(str)) {
                    byte[] hardwareAddress = networkInterface.getHardwareAddress();
                    if (hardwareAddress == null) {
                        w.d("MicroMsg.FreeWifi.Utils", "et mobile mac from net time cost :" + (System.currentTimeMillis() - currentTimeMillis));
                        return "02:00:00:00:00:00";
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    int length = hardwareAddress.length;
                    for (int i = 0; i < length; i++) {
                        stringBuilder.append(String.format("%02X:", new Object[]{Byte.valueOf(hardwareAddress[i])}));
                    }
                    if (stringBuilder.length() > 0) {
                        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                    }
                    w.d("MicroMsg.FreeWifi.Utils", "et mobile mac from net time cost :" + (System.currentTimeMillis() - currentTimeMillis));
                    return stringBuilder.toString();
                }
            }
        } catch (Exception e) {
            w.e("MicroMsg.FreeWifi.Utils", "get mobile mac from net fail!" + e);
        }
        w.d("MicroMsg.FreeWifi.Utils", "et mobile mac from net time cost :" + (System.currentTimeMillis() - currentTimeMillis));
        return "02:00:00:00:00:00";
    }

    public static String e(Exception exception) {
        Writer stringWriter = new StringWriter();
        exception.printStackTrace(new PrintWriter(stringWriter));
        String wz = wz(stringWriter.toString());
        if (wz.length() > WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
            return wz.substring(0, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        }
        return wz;
    }

    public static String f(Exception exception) {
        Writer stringWriter = new StringWriter();
        exception.printStackTrace(new PrintWriter(stringWriter));
        return wz(stringWriter.toString());
    }

    public static String a(int i, b bVar, int i2) {
        Object format;
        w.i("MicroMsg.FreeWifi.Utils", "getUiErrorCode, protocol=%d, stageName=%s, stageCode=%d, errocode=%d", new Object[]{Integer.valueOf(i), bVar.name, Long.valueOf(bVar.lSn), Integer.valueOf(i2)});
        int abs = Math.abs(i2);
        StringBuilder append = new StringBuilder().append(String.format("%02d", new Object[]{Integer.valueOf(i)})).append(String.format("%03d", new Object[]{Long.valueOf(bVar.lSn)}));
        if (abs <= 999) {
            format = String.format("%03d", new Object[]{Integer.valueOf(abs)});
        } else {
            format = Integer.valueOf(abs);
        }
        return append.append(format).toString();
    }

    public static void a(Intent intent, String str, final int i, int i2, final FreeWifiFrontPageUI freeWifiFrontPageUI, final String str2) {
        a(intent, str, i, i2, new a() {
            public final void h(int i, int i2, String str, k kVar) {
                FreeWifiFrontPageUI freeWifiFrontPageUI;
                d dVar;
                com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.a aVar;
                if (i == 0 && i2 == 0) {
                    if (kVar instanceof com.tencent.mm.plugin.freewifi.d.a) {
                        dy awQ = ((com.tencent.mm.plugin.freewifi.d.a) kVar).awQ();
                        if (awQ != null) {
                            w.i(str2, "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s, qingHuaiPageUrl: %s", new Object[]{awQ.teQ, awQ.jOp, awQ.jNj, Integer.valueOf(awQ.thK), awQ.thL, awQ.hAG, awQ.thM});
                            FreeWifiFrontPageUI freeWifiFrontPageUI2 = freeWifiFrontPageUI;
                            d dVar2 = d.SUCCESS;
                            FreeWifiFrontPageUI.b bVar = new FreeWifiFrontPageUI.b();
                            bVar.lWF = awQ;
                            freeWifiFrontPageUI2.a(dVar2, bVar);
                            return;
                        }
                        w.i(str2, "backPageInfo is null");
                        freeWifiFrontPageUI = freeWifiFrontPageUI;
                        dVar = d.FAIL;
                        aVar = new com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.a();
                        aVar.lWh = m.a(i, b.GetBackPageReturn, 21);
                        freeWifiFrontPageUI.a(dVar, aVar);
                    }
                } else if (!m.ca(i, i2) || m.wx(str)) {
                    freeWifiFrontPageUI = freeWifiFrontPageUI;
                    dVar = d.FAIL;
                    aVar = new com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.a();
                    aVar.lWh = m.a(i, b.GetBackPageReturn, i2);
                    freeWifiFrontPageUI.a(dVar, aVar);
                } else {
                    freeWifiFrontPageUI = freeWifiFrontPageUI;
                    dVar = d.FAIL;
                    aVar = new com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.a();
                    aVar.text = str;
                    aVar.lWh = m.a(i, b.GetBackPageReturn, i2);
                    freeWifiFrontPageUI.a(dVar, aVar);
                }
            }
        }, str2);
    }

    public static void a(Intent intent, String str, int i, int i2, a aVar, String str2) {
        final String str3 = str2;
        final String str4 = str;
        final Intent intent2 = intent;
        final int i3 = i;
        final int i4 = i2;
        final a aVar2 = aVar;
        j.awF().awp().post(new Runnable() {
            public final void run() {
                com.tencent.mm.plugin.freewifi.k.a avZ = k.avZ();
                avZ.ssid = m.wA(str3);
                avZ.bssid = m.wB(str3);
                avZ.fEO = m.wC(str3);
                avZ.fEN = str4;
                avZ.lRA = m.y(intent2);
                avZ.lRB = i3;
                avZ.lRC = b.GetBackPage.lSn;
                avZ.lRD = b.GetBackPage.name;
                avZ.fRr = m.B(intent2);
                avZ.result = 0;
                avZ.awb().awa();
                String wB = m.wB(str3);
                String wA = m.wA(str3);
                int aws = com.tencent.mm.plugin.freewifi.model.d.aws();
                w.i(str3, "NetStatusUtil.getNetType(MMApplicationContext.getContext()) = " + am.getNetType(ab.getContext()));
                w.i(str3, "sessionKey=%s, step=%d, method=getBackPageInfoAfterConnectSuccess, desc=it starts net request [apauth.getBackPage]  for backpage info. fullUrl=%s, nowApMac=%s, nowNetworkSSID=%s, rssi=%d", new Object[]{m.y(intent2), Integer.valueOf(m.z(intent2)), str4, wB, wA, Integer.valueOf(aws)});
                new com.tencent.mm.plugin.freewifi.d.a(str4, wB, wA, aws, i4, m.y(intent2)).b(new e(this) {
                    final /* synthetic */ AnonymousClass2 lSv;

                    {
                        this.lSv = r1;
                    }

                    public final void a(int i, int i2, String str, k kVar) {
                        w.i(str3, "sessionKey=%s, step=%d, desc=net request [apauth.getBackPage] returns. errType=%d, errCode=%d, errMsg=%s", new Object[]{m.y(intent2), Integer.valueOf(m.z(intent2)), Integer.valueOf(i), Integer.valueOf(i2), str});
                        com.tencent.mm.plugin.freewifi.k.a avZ = k.avZ();
                        avZ.ssid = m.wA(str3);
                        avZ.bssid = m.wB(str3);
                        avZ.fEO = m.wC(str3);
                        avZ.fEN = str4;
                        avZ.lRA = m.y(intent2);
                        avZ.lRB = m.A(intent2);
                        avZ.lRC = b.GetBackPage33Return.lSn;
                        avZ.lRD = b.GetBackPage33Return.name;
                        avZ.fRr = m.B(intent2);
                        avZ.result = i2;
                        avZ.ksO = str;
                        avZ.awb().b(intent2, true).awa();
                        aVar2.h(i, i2, str, kVar);
                    }
                });
            }
        });
    }

    public static int awf() {
        com.tencent.mm.modelfriend.m.a Fl = com.tencent.mm.modelfriend.m.Fl();
        if (Fl == com.tencent.mm.modelfriend.m.a.hBq || Fl == com.tencent.mm.modelfriend.m.a.hBr) {
            return 1;
        }
        ap.yY();
        String str = (String) c.vr().get(6, null);
        if (wx(str)) {
            return 1;
        }
        Object yU;
        if (str.startsWith("+")) {
            yU = an.yU(str);
        } else {
            yU = "86";
        }
        if ("86".equals(yU)) {
            return 2;
        }
        return 3;
    }

    public static void ce(Context context) {
        Intent intent = new Intent(context, BindMContactUI.class);
        intent.putExtra("is_bind_for_safe_device", false);
        intent.putExtra("is_bind_for_change_mobile", false);
        String simCountryIso = ((TelephonyManager) context.getSystemService("phone")).getSimCountryIso();
        if (!bg.mA(simCountryIso)) {
            com.tencent.mm.ai.b.a g = com.tencent.mm.ai.b.g(context, simCountryIso, context.getString(R.l.bGO));
            if (g != null) {
                intent.putExtra("country_name", g.hJF);
                intent.putExtra("couttry_code", g.hJE);
            }
        }
        MMWizardActivity.z(context, intent);
    }

    public static boolean bZ(int i, int i2) {
        if (i == 0 && i2 == 0) {
            return true;
        }
        return false;
    }

    public static boolean ca(int i, int i2) {
        if (i != 4 || i2 > -30000 || i2 <= -31000) {
            return false;
        }
        return true;
    }

    public static int g(Exception exception) {
        if (exception instanceof SocketTimeoutException) {
            String f = f(exception);
            if (f.indexOf(".read") != -1) {
                return MMGIFException.D_GIF_ERR_NO_IMAG_DSCR;
            }
            if (f.indexOf(".connect") != -1) {
                return 104;
            }
            return 101;
        } else if (exception instanceof ConnectException) {
            return MMGIFException.D_GIF_ERR_NO_COLOR_MAP;
        } else {
            if (exception instanceof UnknownHostException) {
                return 102;
            }
            return 101;
        }
    }

    public static boolean i(Map<String, String> map, String str) {
        w.i(str, "CLIENT_VERSION=" + com.tencent.mm.protocal.d.sYN);
        String str2 = (String) map.get(".sysmsg.apply_versions.version_desc.$minInclude");
        String str3 = (String) map.get(".sysmsg.apply_versions.version_desc.$maxInclude");
        w.i(str, "checkMsgPushedVersion. min0=%s,max0=%s", new Object[]{str2, str3});
        if (wx(str2) && wx(str3)) {
            return false;
        }
        if (cc(str2, str3)) {
            return true;
        }
        int i = 1;
        while (true) {
            str2 = (String) map.get(".sysmsg.apply_versions.version_desc#" + i + ".$minInclude");
            str3 = (String) map.get(".sysmsg.apply_versions.version_desc#" + i + ".$maxInclude");
            w.i(str, "checkMsgPushedVersion. min" + i + "=%s,max" + i + "=%s", new Object[]{str2, str3});
            if (wx(str2) && wx(str3)) {
                return false;
            }
            if (cc(str2, str3)) {
                return true;
            }
            i++;
        }
    }

    private static boolean cc(String str, String str2) {
        int i = bg.getInt(str, 0);
        int i2 = bg.getInt(str2, 0);
        if (i == 0 && i2 != 0 && com.tencent.mm.protocal.d.sYN <= i2) {
            return true;
        }
        if (i != 0 && i2 == 0 && com.tencent.mm.protocal.d.sYN >= i) {
            return true;
        }
        if (i == 0 || i2 == 0 || com.tencent.mm.protocal.d.sYN < i || com.tencent.mm.protocal.d.sYN > i2) {
            return false;
        }
        return true;
    }

    public static boolean awg() {
        if (((ConnectivityManager) ab.getContext().getSystemService("connectivity")).getNetworkInfo(1).isConnected()) {
            w.i("TAG", "isWifiConnected()=true");
            return true;
        }
        w.i("TAG", "isWifiConnected()=false");
        return false;
    }

    public static oc awh() {
        oc ocVar = new oc();
        ocVar.deviceBrand = com.tencent.mm.protocal.d.sYG;
        if (d.lRg == null || d.lRg.equals("")) {
            ocVar.ttK = wC("MicroMsg.FreeWifi.Utils");
        } else {
            ocVar.ttK = d.lRg;
        }
        ocVar.deviceModel = com.tencent.mm.protocal.d.sYH;
        ocVar.osName = com.tencent.mm.protocal.d.sYJ;
        ocVar.osVersion = com.tencent.mm.protocal.d.sYK;
        return ocVar;
    }

    public static String a(String str, LinkedHashMap<String, Class> linkedHashMap, i iVar, String str2) {
        String str3;
        if (linkedHashMap.size() == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str).append("\r\n");
        StringBuilder stringBuilder2 = new StringBuilder();
        for (Entry key : linkedHashMap.entrySet()) {
            stringBuilder2.append((String) key.getKey()).append(",");
        }
        if (stringBuilder2.length() > 0) {
            stringBuilder2.delete(stringBuilder2.length() - 1, stringBuilder2.length());
        }
        String str4 = "select " + stringBuilder2.toString() + " from " + str;
        for (Entry key2 : linkedHashMap.entrySet()) {
            stringBuilder.append((String) key2.getKey()).append("\t");
        }
        stringBuilder.append("\r\n");
        Cursor rawQuery = iVar.rawQuery(str4, new String[0]);
        while (rawQuery.moveToNext()) {
            int i = 0;
            for (Entry key22 : linkedHashMap.entrySet()) {
                Class cls = (Class) key22.getValue();
                if (cls == String.class) {
                    stringBuilder.append(rawQuery.getString(i));
                } else if (cls == Integer.TYPE) {
                    stringBuilder.append(rawQuery.getInt(i));
                } else {
                    try {
                        if (cls == Long.TYPE) {
                            stringBuilder.append(rawQuery.getLong(i));
                        } else if (cls == Float.TYPE) {
                            stringBuilder.append(rawQuery.getFloat(i));
                        } else if (cls == Double.TYPE) {
                            stringBuilder.append(rawQuery.getDouble(i));
                        } else {
                            w.e(str2, "unkonwn type " + cls.toString());
                            stringBuilder.append(rawQuery.getString(i));
                        }
                    } catch (Exception e) {
                        w.i(str2, "print " + str + "error." + e.getMessage());
                        str3 = "";
                        return str3;
                    } finally {
                        rawQuery.close();
                    }
                }
                stringBuilder.append("\t");
                i++;
            }
            stringBuilder.append("\r\n");
        }
        w.i(str2, stringBuilder.toString());
        str3 = stringBuilder.toString();
        return str3;
    }

    public static void wD(String str) {
        w.i("FreeWifi", str);
    }
}
