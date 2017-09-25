package com.tencent.mm.modelstat;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.mm.compatible.d.v;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.aub;
import com.tencent.mm.protocal.c.auc;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.k;
import com.tencent.mm.y.u;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class n {
    private static aj fyI = new aj(h.vL().nJF.getLooper(), new com.tencent.mm.sdk.platformtools.aj.a() {
        public final boolean oQ() {
            try {
                n.hXf = Long.MAX_VALUE;
                if (n.hXg >= MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN || n.hXg <= 1000) {
                    n.a(n.hXg, 0.0f, 0.0f, 0, 0);
                    return false;
                }
                n.gH(n.hXg);
                return false;
            } catch (Throwable e) {
                w.e("MicroMsg.NetTypeReporter", "run :%s", bg.g(e));
            }
        }
    }, false);
    private static final byte[] hAl = new byte[0];
    private static long hXc = 86400000;
    private static HashMap<String, Long> hXd = new HashMap();
    private static String hXe = null;
    public static long hXf = Long.MAX_VALUE;
    public static int hXg = 0;
    public static long hXh = 0;
    private static long hXi = 0;
    private static float hXj = 0.0f;
    private static float hXk = 0.0f;
    private static int hXl = 0;
    private static int hXm = 0;
    private static long hXn = 0;
    private static String hXo = "";

    private static class a extends BroadcastReceiver {
        private a() {
        }

        public final void onReceive(Context context, Intent intent) {
            try {
                if (h.vG().uV()) {
                    h.vG();
                    if (!com.tencent.mm.kernel.a.uP()) {
                        String str;
                        if (intent == null || bg.mA(intent.getAction())) {
                            String str2 = "MicroMsg.NetTypeReporter";
                            String str3 = "onReceive %s  ";
                            Object[] objArr = new Object[1];
                            if (intent == null) {
                                str = "intent is null";
                            } else {
                                str = "action is null";
                            }
                            objArr[0] = str;
                            w.e(str2, str3, objArr);
                            return;
                        }
                        str = intent.getAction();
                        w.i("MicroMsg.NetTypeReporter", "onReceive action:%s foreground:%b", str, Boolean.valueOf(b.foreground));
                        if (!b.foreground) {
                            return;
                        }
                        if (str.equals("android.net.wifi.supplicant.CONNECTION_CHANGE")) {
                            n.gI(MMBitmapFactory.ERROR_ALLOCATE_STRUCT_FAILED);
                            return;
                        } else if (str.equals("android.net.wifi.supplicant.STATE_CHANGE")) {
                            n.gI(MMBitmapFactory.ERROR_LOCK_BITMAP_FAILED);
                            return;
                        } else if (str.equals("android.net.wifi.STATE_CHANGE")) {
                            n.gI(MMBitmapFactory.ERROR_GET_PIXEL_FORMAT_FAILED);
                            return;
                        } else if (str.equals("android.net.wifi.WIFI_STATE_CHANGED")) {
                            n.gI(MMBitmapFactory.ERROR_BEGIN_SAMPLE_FAILED);
                            return;
                        } else if (str.equals("android.net.wifi.SCAN_RESULTS")) {
                            n.gI(MMBitmapFactory.ERROR_IO_FAILED);
                            return;
                        } else if (str.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                            n.gI(MMBitmapFactory.ERROR_UNSUPPORT_IMAGE_FORMAT);
                            return;
                        } else {
                            return;
                        }
                    }
                }
                Object[] objArr2 = new Object[2];
                objArr2[0] = Boolean.valueOf(h.vG().uV());
                h.vG();
                objArr2[1] = Boolean.valueOf(com.tencent.mm.kernel.a.uP());
                w.e("MicroMsg.NetTypeReporter", "onReceive acc not ready .%b %b", objArr2);
            } catch (Throwable th) {
                w.e("MicroMsg.NetTypeReporter", "onReceive : %s", bg.g(th));
            }
        }
    }

    public static void bl(Context context) {
        if (context == null) {
            try {
                w.e("MicroMsg.NetTypeReporter", "registerReceiver ctx == null");
                return;
            } catch (Throwable th) {
                w.e("MicroMsg.NetTypeReporter", "registerReceiver : %s", bg.g(th));
                return;
            }
        }
        BroadcastReceiver aVar = new a();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.supplicant.CONNECTION_CHANGE");
        intentFilter.addAction("android.net.wifi.supplicant.STATE_CHANGE");
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        intentFilter.addAction("android.net.wifi.SCAN_RESULTS");
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        context.registerReceiver(aVar, intentFilter);
        w.i("MicroMsg.NetTypeReporter", "registerReceiver finish");
    }

    private static boolean h(ArrayList<String> arrayList) {
        Throwable e;
        Iterator it;
        boolean z;
        String str;
        long aA;
        boolean z2;
        FileOutputStream fileOutputStream;
        ObjectOutputStream objectOutputStream;
        FileOutputStream fileOutputStream2;
        ObjectOutputStream objectOutputStream2 = null;
        if (arrayList.size() == 0) {
            w.w("MicroMsg.NetTypeReporter", "checkBssidShouldReport no value in list.");
            return false;
        }
        if (bg.mA(hXe)) {
            hXe = h.vI().cachePath + "bssidcache.bin";
        }
        if (hXd.size() == 0) {
            FileInputStream fileInputStream;
            ObjectInputStream objectInputStream;
            try {
                fileInputStream = new FileInputStream(hXe);
                try {
                    objectInputStream = new ObjectInputStream(fileInputStream);
                    try {
                        hXd = (HashMap) objectInputStream.readObject();
                        w.i("MicroMsg.NetTypeReporter", "checkBssidShouldReport read file size:%d", Integer.valueOf(hXd.size()));
                        try {
                            objectInputStream.close();
                            fileInputStream.close();
                        } catch (Throwable e2) {
                            w.e("MicroMsg.NetTypeReporter", "checkBssidShouldReport read err:%s", bg.g(e2));
                            hXd = new HashMap();
                        }
                    } catch (Exception e3) {
                        e2 = e3;
                        try {
                            w.e("MicroMsg.NetTypeReporter", "checkBssidShouldReport read err:%s", bg.g(e2));
                            hXd = new HashMap();
                            if (objectInputStream != null) {
                                try {
                                    objectInputStream.close();
                                } catch (Throwable e22) {
                                    w.e("MicroMsg.NetTypeReporter", "checkBssidShouldReport read err:%s", bg.g(e22));
                                    hXd = new HashMap();
                                }
                            }
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            w.i("MicroMsg.NetTypeReporter", "checkBssidShouldReport remove size:%d  file:%s", Integer.valueOf(hXd.size()), hXe);
                            com.tencent.mm.loader.stub.b.deleteFile(hXe);
                            it = arrayList.iterator();
                            z = false;
                            while (it.hasNext()) {
                                str = (String) it.next();
                                aA = bg.aA(bg.bx(hXd.get(str)));
                                w.d("MicroMsg.NetTypeReporter", "checkBssidShouldReport report bssid:%s diff:%d", str, Long.valueOf(aA));
                                if (aA > 0) {
                                }
                                hXd.put(str, Long.valueOf(bg.Nz()));
                                z2 = true;
                                z = z2;
                            }
                            try {
                                fileOutputStream = new FileOutputStream(hXe);
                                try {
                                    objectOutputStream = new ObjectOutputStream(fileOutputStream);
                                    try {
                                        objectOutputStream.writeObject(hXd);
                                        fileOutputStream.flush();
                                        w.i("MicroMsg.NetTypeReporter", "checkBssidShouldReport write file size:%d", Integer.valueOf(hXd.size()));
                                        try {
                                            objectOutputStream.close();
                                            fileOutputStream.close();
                                        } catch (Throwable e222) {
                                            w.e("MicroMsg.NetTypeReporter", "checkBssidShouldReport write err:%s", bg.g(e222));
                                        }
                                    } catch (Exception e4) {
                                        e222 = e4;
                                        objectOutputStream2 = objectOutputStream;
                                        fileOutputStream2 = fileOutputStream;
                                        try {
                                            w.e("MicroMsg.NetTypeReporter", "checkBssidShouldReport write err:%s", bg.g(e222));
                                            if (objectOutputStream2 != null) {
                                                try {
                                                    objectOutputStream2.close();
                                                } catch (Throwable e2222) {
                                                    w.e("MicroMsg.NetTypeReporter", "checkBssidShouldReport write err:%s", bg.g(e2222));
                                                }
                                            }
                                            if (fileOutputStream2 != null) {
                                                fileOutputStream2.close();
                                            }
                                            return z;
                                        } catch (Throwable th) {
                                            e2222 = th;
                                            fileOutputStream = fileOutputStream2;
                                            objectOutputStream = objectOutputStream2;
                                            if (objectOutputStream != null) {
                                                try {
                                                    objectOutputStream.close();
                                                } catch (Throwable e5) {
                                                    w.e("MicroMsg.NetTypeReporter", "checkBssidShouldReport write err:%s", bg.g(e5));
                                                    throw e2222;
                                                }
                                            }
                                            if (fileOutputStream != null) {
                                                fileOutputStream.close();
                                            }
                                            throw e2222;
                                        }
                                    } catch (Throwable th2) {
                                        e2222 = th2;
                                        if (objectOutputStream != null) {
                                            objectOutputStream.close();
                                        }
                                        if (fileOutputStream != null) {
                                            fileOutputStream.close();
                                        }
                                        throw e2222;
                                    }
                                } catch (Exception e6) {
                                    e2222 = e6;
                                    fileOutputStream2 = fileOutputStream;
                                    w.e("MicroMsg.NetTypeReporter", "checkBssidShouldReport write err:%s", bg.g(e2222));
                                    if (objectOutputStream2 != null) {
                                        objectOutputStream2.close();
                                    }
                                    if (fileOutputStream2 != null) {
                                        fileOutputStream2.close();
                                    }
                                    return z;
                                } catch (Throwable th3) {
                                    e2222 = th3;
                                    objectOutputStream = null;
                                    if (objectOutputStream != null) {
                                        objectOutputStream.close();
                                    }
                                    if (fileOutputStream != null) {
                                        fileOutputStream.close();
                                    }
                                    throw e2222;
                                }
                            } catch (Exception e7) {
                                e2222 = e7;
                                fileOutputStream2 = null;
                                w.e("MicroMsg.NetTypeReporter", "checkBssidShouldReport write err:%s", bg.g(e2222));
                                if (objectOutputStream2 != null) {
                                    objectOutputStream2.close();
                                }
                                if (fileOutputStream2 != null) {
                                    fileOutputStream2.close();
                                }
                                return z;
                            } catch (Throwable th4) {
                                e2222 = th4;
                                objectOutputStream = null;
                                fileOutputStream = null;
                                if (objectOutputStream != null) {
                                    objectOutputStream.close();
                                }
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                                throw e2222;
                            }
                            return z;
                        } catch (Throwable th5) {
                            e2222 = th5;
                            if (objectInputStream != null) {
                                try {
                                    objectInputStream.close();
                                } catch (Throwable e52) {
                                    w.e("MicroMsg.NetTypeReporter", "checkBssidShouldReport read err:%s", bg.g(e52));
                                    hXd = new HashMap();
                                    throw e2222;
                                }
                            }
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            throw e2222;
                        }
                    }
                } catch (Exception e8) {
                    e2222 = e8;
                    objectInputStream = null;
                    w.e("MicroMsg.NetTypeReporter", "checkBssidShouldReport read err:%s", bg.g(e2222));
                    hXd = new HashMap();
                    if (objectInputStream != null) {
                        objectInputStream.close();
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    w.i("MicroMsg.NetTypeReporter", "checkBssidShouldReport remove size:%d  file:%s", Integer.valueOf(hXd.size()), hXe);
                    com.tencent.mm.loader.stub.b.deleteFile(hXe);
                    it = arrayList.iterator();
                    z = false;
                    while (it.hasNext()) {
                        str = (String) it.next();
                        aA = bg.aA(bg.bx(hXd.get(str)));
                        w.d("MicroMsg.NetTypeReporter", "checkBssidShouldReport report bssid:%s diff:%d", str, Long.valueOf(aA));
                        if (aA > 0) {
                        }
                        hXd.put(str, Long.valueOf(bg.Nz()));
                        z2 = true;
                        z = z2;
                    }
                    fileOutputStream = new FileOutputStream(hXe);
                    objectOutputStream = new ObjectOutputStream(fileOutputStream);
                    objectOutputStream.writeObject(hXd);
                    fileOutputStream.flush();
                    w.i("MicroMsg.NetTypeReporter", "checkBssidShouldReport write file size:%d", Integer.valueOf(hXd.size()));
                    objectOutputStream.close();
                    fileOutputStream.close();
                    return z;
                } catch (Throwable th6) {
                    e2222 = th6;
                    objectInputStream = null;
                    if (objectInputStream != null) {
                        objectInputStream.close();
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    throw e2222;
                }
            } catch (Exception e9) {
                e2222 = e9;
                objectInputStream = null;
                fileInputStream = null;
                w.e("MicroMsg.NetTypeReporter", "checkBssidShouldReport read err:%s", bg.g(e2222));
                hXd = new HashMap();
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                w.i("MicroMsg.NetTypeReporter", "checkBssidShouldReport remove size:%d  file:%s", Integer.valueOf(hXd.size()), hXe);
                com.tencent.mm.loader.stub.b.deleteFile(hXe);
                it = arrayList.iterator();
                z = false;
                while (it.hasNext()) {
                    str = (String) it.next();
                    aA = bg.aA(bg.bx(hXd.get(str)));
                    w.d("MicroMsg.NetTypeReporter", "checkBssidShouldReport report bssid:%s diff:%d", str, Long.valueOf(aA));
                    if (aA > 0) {
                    }
                    hXd.put(str, Long.valueOf(bg.Nz()));
                    z2 = true;
                    z = z2;
                }
                fileOutputStream = new FileOutputStream(hXe);
                objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(hXd);
                fileOutputStream.flush();
                w.i("MicroMsg.NetTypeReporter", "checkBssidShouldReport write file size:%d", Integer.valueOf(hXd.size()));
                objectOutputStream.close();
                fileOutputStream.close();
                return z;
            } catch (Throwable th7) {
                e2222 = th7;
                objectInputStream = null;
                fileInputStream = null;
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw e2222;
            }
            if (hXd.size() <= 0 || hXd.size() > 1000) {
                w.i("MicroMsg.NetTypeReporter", "checkBssidShouldReport remove size:%d  file:%s", Integer.valueOf(hXd.size()), hXe);
                com.tencent.mm.loader.stub.b.deleteFile(hXe);
            }
        }
        it = arrayList.iterator();
        z = false;
        while (it.hasNext()) {
            str = (String) it.next();
            aA = bg.aA(bg.bx(hXd.get(str)));
            w.d("MicroMsg.NetTypeReporter", "checkBssidShouldReport report bssid:%s diff:%d", str, Long.valueOf(aA));
            if (aA > 0 || aA > hXc) {
                hXd.put(str, Long.valueOf(bg.Nz()));
                z2 = true;
            } else {
                z2 = z;
            }
            z = z2;
        }
        if (z && hXd.size() > 0) {
            fileOutputStream = new FileOutputStream(hXe);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(hXd);
            fileOutputStream.flush();
            w.i("MicroMsg.NetTypeReporter", "checkBssidShouldReport write file size:%d", Integer.valueOf(hXd.size()));
            objectOutputStream.close();
            fileOutputStream.close();
        }
        return z;
    }

    private static String[] gG(int i) {
        String networkOperatorName;
        Throwable th;
        w.i("MicroMsg.NetTypeReporter", "dkNetTypeRead scene:%d fg:%b time:%d diff:%d", Integer.valueOf(i), Boolean.valueOf(b.foreground), Long.valueOf(hXh), Long.valueOf(bg.aA(hXh)));
        if (i <= 0) {
            w.e("MicroMsg.NetTypeReporter", "ERROR PARAM: scene:%d", Integer.valueOf(i));
            return null;
        }
        Context context = ab.getContext();
        if (context == null) {
            w.e("MicroMsg.NetTypeReporter", "ERROR Context is null scene:%d", Integer.valueOf(i));
            return null;
        }
        int rR;
        w.i("MicroMsg.NetTypeReporter", "read scene:%d foreground:%b", Integer.valueOf(i), Boolean.valueOf(b.foreground));
        int i2 = 0;
        try {
            rR = v.rR();
        } catch (Throwable e) {
            w.e("MicroMsg.NetTypeReporter", "getNetType : %s", bg.g(e));
            rR = i2;
        }
        w.i("MicroMsg.NetTypeReporter", "get netType :%d", Integer.valueOf(rR));
        String str = "";
        String str2 = "";
        String str3 = "";
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            StringBuffer stringBuffer = new StringBuffer();
            StringBuffer stringBuffer2 = new StringBuffer();
            StringBuffer stringBuffer3 = new StringBuffer();
            int i3 = 0;
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
                int i4 = 20;
                for (ScanResult scanResult : scanResults) {
                    if (!(scanResult == null || bg.mA(scanResult.BSSID))) {
                        if (!scanResult.BSSID.equals(bssid)) {
                            int i5 = i4 - 1;
                            if (i4 <= 0) {
                                break;
                            }
                            stringBuffer.append("|");
                            stringBuffer.append(bg.mz(scanResult.SSID).replace("|", "").replace(" ", ""));
                            stringBuffer2.append("|");
                            stringBuffer2.append(bg.mz(scanResult.BSSID).replace("|", "").replace(" ", ""));
                            arrayList.add(scanResult.BSSID);
                            stringBuffer3.append("|");
                            stringBuffer3.append(scanResult.level);
                            i4 = i5;
                        } else {
                            i3 = scanResult.level;
                        }
                    }
                }
            }
            i2 = i3;
            if (i >= 2000 || h(arrayList)) {
                str = stringBuffer.toString();
                str2 = stringBuffer2.toString();
                str3 = i2 + stringBuffer3.toString();
                w.d("MicroMsg.NetTypeReporter", "get wifi :[%s] [%s]", str2, str);
                String str4 = "";
                try {
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    if (telephonyManager != null) {
                        networkOperatorName = telephonyManager.getNetworkOperatorName();
                    } else {
                        networkOperatorName = str4;
                    }
                    str4 = networkOperatorName;
                } catch (Throwable e2) {
                    w.e("MicroMsg.NetTypeReporter", "getNetType : %s", bg.g(e2));
                }
                w.i("MicroMsg.NetTypeReporter", "get ispName: %s", str4);
                String str5 = "";
                String str6 = "";
                String str7 = "";
                String str8 = "";
                String str9 = "";
                try {
                    List ej = am.ej(context);
                    for (int i6 = 0; i6 < ej.size(); i6++) {
                        com.tencent.mm.sdk.platformtools.am.a aVar = (com.tencent.mm.sdk.platformtools.am.a) ej.get(i6);
                        str5 = bg.ap(aVar.uus, "");
                        str6 = bg.ap(aVar.uut, "");
                        if (str7.length() > 0 && !bg.mA(aVar.uuv)) {
                            str7 = str7 + "|";
                        }
                        if (!bg.mA(aVar.uuv)) {
                            str7 = str7 + aVar.uuv;
                        }
                        if (str8.length() > 0 && !bg.mA(aVar.uuu)) {
                            str8 = str8 + "|";
                        }
                        if (!bg.mA(aVar.uuu)) {
                            str8 = str8 + aVar.uuu;
                        }
                        if (str9.length() > 0) {
                            str9 = str9 + "|";
                        }
                        StringBuilder append = new StringBuilder().append(str9);
                        if (bg.mA(aVar.uuy)) {
                            networkOperatorName = "0";
                        } else {
                            networkOperatorName = aVar.uuy;
                        }
                        str9 = append.append(networkOperatorName).toString();
                    }
                    networkOperatorName = str9;
                    str9 = str8;
                    str8 = str7;
                    str7 = str6;
                    str6 = str5;
                } catch (Throwable e22) {
                    th = e22;
                    networkOperatorName = str9;
                    str9 = str8;
                    str8 = str7;
                    str7 = str6;
                    str6 = str5;
                    w.e("MicroMsg.NetTypeReporter", "getNetType : %s", bg.g(th));
                }
                w.d("MicroMsg.NetTypeReporter", "mcc:%s mnc:%s cell:%s", str6, str7, str8);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(bg.Ny()).append(",");
                stringBuilder.append(i).append(",");
                stringBuilder.append(rR).append(",");
                stringBuilder.append(str.replace(",", " ")).append(",");
                stringBuilder.append(kR(str2.replace(",", " "))).append(",");
                stringBuilder.append(str4.replace(",", " ")).append(",");
                stringBuilder.append(kR(str6.replace(",", " "))).append(",");
                stringBuilder.append(kR(str7.replace(",", " "))).append(",");
                stringBuilder.append(kR(str8.replace(",", " "))).append(",");
                if (Ke() < 0) {
                    return null;
                }
                return new String[]{Ke() + "," + stringBuilder.toString(), kR(str3), kR(str9), kR(networkOperatorName)};
            }
            w.w("MicroMsg.NetTypeReporter", "checkBssid: find all report already  , give up. scene:%d ", Integer.valueOf(i));
            return null;
        } catch (Throwable e222) {
            th = e222;
            networkOperatorName = str2;
            str2 = str;
            w.e("MicroMsg.NetTypeReporter", "getWifiInfo : %s", bg.g(th));
            str = str2;
            str2 = networkOperatorName;
        }
    }

    private static String kR(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        for (char c : str.toCharArray()) {
            if ((c < 'a' || c > 'z') && ((c < 'A' || c > 'Z') && ((c < '0' || c > '9') && c != '|' && c != '-' && c != ' ' && c != ':'))) {
                return "";
            }
        }
        return str;
    }

    private static long Ke() {
        long a;
        synchronized (hAl) {
            try {
                a = bg.a((Long) h.vI().vr().get(com.tencent.mm.storage.w.a.USERINFO_REPORTNETTYPE_SEQ_LONG, null), 1);
                h.vI().vr().a(com.tencent.mm.storage.w.a.USERINFO_REPORTNETTYPE_SEQ_LONG, Long.valueOf(1 + a));
                h.vI().vr().jY(true);
                long a2 = bg.a((Long) h.vI().vr().get(com.tencent.mm.storage.w.a.USERINFO_REPORTNETTYPE_SEQ_LONG, null), 1);
                w.i("MicroMsg.NetTypeReporter", "incSeq after write  old:%d new:%d", Long.valueOf(a), Long.valueOf(a2));
            } catch (Throwable e) {
                w.e("MicroMsg.NetTypeReporter", "incSeq :%s", bg.g(e));
                return -1;
            }
        }
        return a;
    }

    public static void a(int i, float f, float f2, int i2, long j) {
        long Nz = bg.Nz();
        if (hXh <= 0 || Nz - hXh <= 5000) {
            final String[] gG = gG(i);
            if (gG == null || gG.length != 4 || bg.mA(gG[0])) {
                w.e("MicroMsg.NetTypeReporter", "report get failed val");
                return;
            }
            w.d("MicroMsg.NetTypeReporter", "report scene:%d time:%d lon:%f lat:%f pre:%d scanuse:%d [%s]", Integer.valueOf(i), Long.valueOf(bg.aA(Nz)), Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i2), Long.valueOf(j), gG[0]);
            com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
            aVar.hsm = new aub();
            aVar.hsn = new auc();
            aVar.uri = "/cgi-bin/micromsg-bin/rtkvreport";
            aVar.hsl = 716;
            com.tencent.mm.y.b BE = aVar.BE();
            final aub com_tencent_mm_protocal_c_aub = (aub) BE.hsj.hsr;
            com_tencent_mm_protocal_c_aub.tlu = d.sYH;
            com_tencent_mm_protocal_c_aub.tlv = d.sYG;
            com_tencent_mm_protocal_c_aub.tlw = d.sYJ;
            com_tencent_mm_protocal_c_aub.tlx = d.sYK;
            com_tencent_mm_protocal_c_aub.tly = com.tencent.mm.sdk.platformtools.v.bIN();
            com_tencent_mm_protocal_c_aub.tMh = 11747;
            Nz = bg.aA(hXh);
            if (Nz > 600000 || Nz < 0) {
                Nz = 0;
            }
            com_tencent_mm_protocal_c_aub.oTN = gG[0] + "0," + f + "," + f2 + "," + i2 + "," + j + "," + (b.foreground ? "1" : String.valueOf(Nz)) + "," + gG[1] + "," + gG[2] + "," + gG[3];
            final long Nz2 = bg.Nz();
            final float f3 = f;
            final float f4 = f2;
            final int i3 = i2;
            final long j2 = j;
            u.a(BE, new com.tencent.mm.y.u.a() {
                public final int a(int i, int i2, String str, com.tencent.mm.y.b bVar, k kVar) {
                    w.d("MicroMsg.NetTypeReporter", "onGYNetEnd errType:%d errCode:%d msg:%s  %d val:%s ", Integer.valueOf(i), Integer.valueOf(i2), str, Long.valueOf(bg.aA(Nz2)), com_tencent_mm_protocal_c_aub.oTN);
                    if (!(i == 0 && i2 == 0)) {
                        long aA = bg.aA(n.hXh);
                        if (aA > 600000 || aA < 0) {
                            aA = 0;
                        }
                        g.oUh.A(11747, gG[0] + "1," + f3 + "," + f4 + "," + i3 + "," + j2 + "," + (b.foreground ? "1" : String.valueOf(aA)) + "," + gG[1] + "," + gG[2] + "," + gG[3]);
                    }
                    h.vI().vr().a(com.tencent.mm.storage.w.a.USERINFO_REPORTNETTYPE_LASTREPORT_LONG, Long.valueOf(bg.Nz()));
                    return 0;
                }
            }, true);
            return;
        }
        w.e("MicroMsg.NetTypeReporter", "never  report  at  background :%d diff:%d", Long.valueOf(hXh), Long.valueOf(Nz - hXh));
    }

    public static void s(int i, String str) {
        com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
        aVar.hsm = new aub();
        aVar.hsn = new auc();
        aVar.uri = "/cgi-bin/micromsg-bin/rtkvreport";
        aVar.hsl = 716;
        com.tencent.mm.y.b BE = aVar.BE();
        final aub com_tencent_mm_protocal_c_aub = (aub) BE.hsj.hsr;
        com_tencent_mm_protocal_c_aub.tlu = d.sYH;
        com_tencent_mm_protocal_c_aub.tlv = d.sYG;
        com_tencent_mm_protocal_c_aub.tlw = d.sYJ;
        com_tencent_mm_protocal_c_aub.tlx = d.sYK;
        com_tencent_mm_protocal_c_aub.tly = com.tencent.mm.sdk.platformtools.v.bIN();
        com_tencent_mm_protocal_c_aub.tMh = i;
        com_tencent_mm_protocal_c_aub.oTN = str;
        w.i("MicroMsg.NetTypeReporter", "reportCgi logId:%d, value:%s", Integer.valueOf(i), str);
        final long Nz = bg.Nz();
        u.a(BE, new com.tencent.mm.y.u.a() {
            public final int a(int i, int i2, String str, com.tencent.mm.y.b bVar, k kVar) {
                w.d("MicroMsg.NetTypeReporter", "onGYNetEnd errType:%d errCode:%d msg:%s  %d val:%s ", Integer.valueOf(i), Integer.valueOf(i2), str, Long.valueOf(bg.aA(Nz)), com_tencent_mm_protocal_c_aub.oTN);
                return 0;
            }
        });
    }

    public static void gH(int i) {
        long Nz = bg.Nz();
        if (hXh <= 0 || Nz - hXh <= 5000) {
            String[] gG = gG(i);
            if (gG == null || gG.length != 4 || bg.mA(gG[0])) {
                w.e("MicroMsg.NetTypeReporter", "report get failed val");
                return;
            }
            w.d("MicroMsg.NetTypeReporter", "report scene:%d time:%d lon:%f lat:%f pre:%d scanuse:%d [%s]", Integer.valueOf(i), Long.valueOf(bg.aA(Nz)), Float.valueOf(0.0f), Float.valueOf(0.0f), Integer.valueOf(0), Long.valueOf(0), gG[0]);
            Nz = bg.aA(hXh);
            if (Nz > 600000 || Nz < 0) {
                Nz = 0;
            }
            g.oUh.A(11747, gG[0] + "1,0.0,0.0" + ",0,0" + "," + (b.foreground ? "1" : String.valueOf(Nz)) + "," + gG[1] + "," + gG[2] + "," + gG[3]);
            h.vI().vr().a(com.tencent.mm.storage.w.a.USERINFO_REPORTNETTYPE_LASTREPORT_LONG, Long.valueOf(bg.Nz()));
            return;
        }
        w.e("MicroMsg.NetTypeReporter", "never  report (reportKV) at  background :%d diff:%d", Long.valueOf(hXh), Long.valueOf(Nz - hXh));
    }

    private static void b(int i, float f, float f2, int i2, long j) {
        try {
            w.i("MicroMsg.NetTypeReporter", "checkTimeReport scene:%d diff:%d  time:%d", Integer.valueOf(i), Long.valueOf(bg.aA(hXf)), Long.valueOf(hXf));
            if (i > MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN || bg.aA(hXf) > 300000) {
                w.i("MicroMsg.NetTypeReporter", "force Run, scene:%d diff:%d time:%d ", Integer.valueOf(i), Long.valueOf(bg.aA(hXf)), Long.valueOf(hXf));
                hXg = i;
                hXf = Long.MAX_VALUE;
                a(i, f, f2, i2, j);
                return;
            }
            if (hXf == Long.MAX_VALUE) {
                hXf = bg.Nz() + 60000;
            }
            hXg = i;
            fyI.v(60000, 60000);
        } catch (Throwable th) {
            w.e("MicroMsg.NetTypeReporter", "checkTimeReport error: %s", bg.g(th));
        }
    }

    public static void bq(boolean z) {
        if (z) {
            hXh = 0;
        } else if (!fyI.bJq()) {
            w.i("MicroMsg.NetTypeReporter", "setToForeground user turn to background run report now");
            hXh = bg.Nz();
            fyI.v(0, 0);
        }
    }

    public static synchronized void a(int i, float f, float f2, int i2) {
        synchronized (n.class) {
            if (i < MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN || f == 0.0f || f2 == 0.0f) {
                w.e("MicroMsg.NetTypeReporter", "reportGps, invalid args, scene = %d, lon = %f, lat = %f, pre = %d", Integer.valueOf(i), Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i2));
            } else if (bg.aA(hXn) < 60000) {
                w.e("MicroMsg.NetTypeReporter", "reportGps, hit lastReportGpsLimit, request dropped, scene = %d, lon = %f, lat = %f, pre = %d", Integer.valueOf(i), Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i2));
            } else {
                w.i("MicroMsg.NetTypeReporter", "reportGps scene:%d lon:%f lat:%f pre:%d last:%d", Integer.valueOf(i), Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i2), Long.valueOf(bg.aA(hXn)));
                hXn = bg.Nz();
                hXm = i;
                hXi = bg.Nz();
                hXl = i2;
                hXj = f2;
                hXk = f;
                try {
                    ((WifiManager) ab.getContext().getSystemService("wifi")).startScan();
                    h.vL().e(new Runnable() {
                        public final void run() {
                            n.gI(MMBitmapFactory.ERROR_IO_FAILED);
                        }
                    }, 5000);
                } catch (Throwable e) {
                    w.e("MicroMsg.NetTypeReporter", "reportGps :%s", bg.g(e));
                }
            }
        }
    }

    public static synchronized void gI(int i) {
        synchronized (n.class) {
            w.i("MicroMsg.NetTypeReporter", "run scene:%d foreground:%b lastGpsTime:%d lastbssid:%s", Integer.valueOf(i), Boolean.valueOf(b.foreground), Long.valueOf(hXi), hXo);
            if (i == MMBitmapFactory.ERROR_IO_FAILED) {
                try {
                    if (hXi > 0) {
                        w.d("MicroMsg.NetTypeReporter", "report gps scene:%d lastscene:%d [%f,%f,%d] lastGpsTime", Integer.valueOf(i), Integer.valueOf(hXm), Float.valueOf(hXk), Float.valueOf(hXj), Integer.valueOf(hXl), Long.valueOf(hXi));
                        long aA = bg.aA(hXi);
                        int i2 = hXm;
                        float f = hXj;
                        float f2 = hXk;
                        int i3 = hXl;
                        hXi = 0;
                        hXj = 0.0f;
                        hXk = 0.0f;
                        hXl = 0;
                        hXm = 0;
                        b(i2, f2, f, i3, aA);
                    }
                } catch (Throwable th) {
                    w.e("MicroMsg.NetTypeReporter", "run :%s", bg.g(th));
                }
            }
            if (!b.foreground) {
                w.w("MicroMsg.NetTypeReporter", "run is not foreground give up %d ", Integer.valueOf(i));
            } else if (i == 3) {
                String bssid = ((WifiManager) ab.getContext().getSystemService("wifi")).getConnectionInfo().getBSSID();
                w.d("MicroMsg.NetTypeReporter", "run scene:%d SCENE_TO_FOREGROUND_BSSID_CHANGE %s %s ", Integer.valueOf(i), bssid, hXo);
                if (!(bg.mA(bssid) || bssid.equals(hXo))) {
                    hXo = bssid;
                    b(i, 0.0f, 0.0f, 0, 0);
                }
            } else if (i == 4) {
                w.i("MicroMsg.NetTypeReporter", "run scene:%d SCENE_TO_FOREGROUND_TIMEOUT  diff:%d", Integer.valueOf(i), Long.valueOf(bg.aA(bg.a((Long) h.vI().vr().get(com.tencent.mm.storage.w.a.USERINFO_REPORTNETTYPE_LASTREPORT_LONG, null), 0))));
                if (bg.aA(bg.a((Long) h.vI().vr().get(com.tencent.mm.storage.w.a.USERINFO_REPORTNETTYPE_LASTREPORT_LONG, null), 0)) >= 21600000) {
                    b(i, 0.0f, 0.0f, 0, 0);
                }
            } else {
                b(i, 0.0f, 0.0f, 0, 0);
            }
        }
    }
}
