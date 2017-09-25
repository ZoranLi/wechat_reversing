package com.tencent.mm.plugin.backup.a;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.a.n;
import com.tencent.mm.bd.a;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.plugin.backup.h.m;
import com.tencent.mm.plugin.backup.h.x;
import com.tencent.mm.protocal.c.avx;
import com.tencent.mm.protocal.c.avy;
import com.tencent.mm.protocal.c.eh;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.o;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.io.File;
import java.io.RandomAccessFile;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.apache.http.conn.util.InetAddressUtils;

public final class h {
    private static List<String> jBA = null;

    public static <T extends a> T a(T t, byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        try {
            t.aD(bArr);
            return t;
        } catch (Throwable e) {
            w.e("MicroMsg.BackupUtil", "ERROR: parseProBuf [%s] [%s]", new Object[]{e.getMessage(), bg.g(e)});
            return null;
        }
    }

    public static void a(String str, x xVar) {
        Throwable e;
        RandomAccessFile randomAccessFile = null;
        try {
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
            String str2 = str + xVar.jOf;
            File file2 = new File(str2);
            if (!file2.exists()) {
                file2.createNewFile();
            }
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(str2, "rw");
            try {
                randomAccessFile2.setLength((long) xVar.jOh);
                randomAccessFile2.seek((long) xVar.jOi);
                randomAccessFile2.write(xVar.jMQ.sYA);
                try {
                    randomAccessFile2.close();
                } catch (Exception e2) {
                }
            } catch (Exception e3) {
                e = e3;
                randomAccessFile = randomAccessFile2;
                try {
                    w.printErrStackTrace("MicroMsg.BackupUtil", e, "summerbak writeMediaToFile fail with exception", new Object[0]);
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (Exception e4) {
                        }
                    }
                } catch (Throwable th) {
                    e = th;
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (Exception e5) {
                        }
                    }
                    throw e;
                }
            } catch (Throwable th2) {
                e = th2;
                randomAccessFile = randomAccessFile2;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                throw e;
            }
        } catch (Exception e6) {
            e = e6;
            w.printErrStackTrace("MicroMsg.BackupUtil", e, "summerbak writeMediaToFile fail with exception", new Object[0]);
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
        }
    }

    public static long ry(String str) {
        File file = new File(str);
        if (!file.exists()) {
            return -1;
        }
        if (!file.canRead()) {
            return -2;
        }
        if (file.canWrite()) {
            return file.length();
        }
        return -3;
    }

    public static void b(String str, x xVar) {
        if (TextUtils.isEmpty(str) || xVar == null) {
            w.e("MicroMsg.BackupUtil", "appendFile dir:%s req:%s ", new Object[]{str, xVar});
        } else if (TextUtils.isEmpty(xVar.jOf) || xVar.jMQ == null || bg.bn(xVar.jMQ.sYA) <= 0) {
            String str2;
            String str3 = "MicroMsg.BackupUtil";
            String str4 = "appendFile dataid:%s data:%s  %s";
            Object[] objArr = new Object[3];
            objArr[0] = xVar.jOf;
            objArr[1] = xVar.jMQ;
            if (xVar.jMQ == null) {
                str2 = "null";
            } else {
                str2 = Integer.valueOf(bg.bn(xVar.jMQ.sYA));
            }
            objArr[2] = str2;
            w.e(str3, str4, objArr);
        } else {
            int i = 3;
            while (true) {
                int i2 = i - 1;
                if (i > 0) {
                    long ry = ry(str + xVar.jOf);
                    File file = new File(str + xVar.jOf);
                    long length = file.exists() ? file.length() : 0;
                    int a = e.a(str, xVar.jOf, xVar.jMQ.sYA);
                    File file2 = new File(str + xVar.jOf);
                    if (length == (file2.exists() ? file2.length() : 0)) {
                        w.e("MicroMsg.BackupUtil", "append failed and try again:%s", new Object[]{str + xVar.jOf});
                        i = e.a(str, xVar.jOf, xVar.jMQ.sYA) * 10000;
                    } else {
                        i = a;
                    }
                    long ry2 = ry(str + xVar.jOf);
                    if (i != 0 || ry2 < ((long) xVar.jMQ.sYA.length)) {
                        w.e("MicroMsg.BackupUtil", "appendFile retry:%d append:%d  old:%d  new:%d  data:%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i), Long.valueOf(ry), Long.valueOf(ry2), Integer.valueOf(xVar.jMQ.sYA.length)});
                        i = i2;
                    } else {
                        w.d("MicroMsg.BackupUtil", "appendFile retry:%d append:%d  old:%d  new:%d  data:%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i), Long.valueOf(ry), Long.valueOf(ry2), Integer.valueOf(xVar.jMQ.sYA.length)});
                        return;
                    }
                }
                return;
            }
        }
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
                    w.e("MicroMsg.BackupUtil", "getConnectionInfo %s", new Object[]{e});
                    w.printErrStackTrace("MicroMsg.BackupUtil", e, "", new Object[0]);
                    return "";
                }
            }
            ssid = "wifi";
            if (ssid.length() < 2 || !ssid.startsWith("\"") || !ssid.endsWith("\"")) {
                return ssid;
            }
            w.i("MicroMsg.BackupUtil", "start and end with \", and trunk it");
            return ssid.substring(1, ssid.length() - 1);
        }
        int intValue;
        int i = 13;
        try {
            i = ((Integer) wifiManager.getClass().getField("WIFI_AP_STATE_ENABLED").get(wifiManager)).intValue();
            intValue = ((Integer) wifiManager.getClass().getMethod("getWifiApState", new Class[0]).invoke(wifiManager, new Object[0])).intValue();
        } catch (Throwable e2) {
            w.e("MicroMsg.BackupUtil", "getWifiApState %s", new Object[]{e2});
            w.printErrStackTrace("MicroMsg.BackupUtil", e2, "", new Object[0]);
            intValue = 0;
        }
        if (intValue == i) {
            w.i("MicroMsg.BackupUtil", "getWifiName apmode");
            try {
                return ((WifiConfiguration) wifiManager.getClass().getMethod("getWifiApConfiguration", new Class[0]).invoke(wifiManager, new Object[0])).SSID;
            } catch (Throwable e3) {
                w.e("MicroMsg.BackupUtil", "getWifiApConfiguration %s", new Object[]{e3});
                w.printErrStackTrace("MicroMsg.BackupUtil", e3, "", new Object[0]);
            }
        }
        return "";
    }

    public static String aan() {
        StringBuilder stringBuilder = new StringBuilder();
        ap.yY();
        return stringBuilder.append(c.xv()).append("backup/").toString();
    }

    public static void rz(String str) {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        file = new File(str + "backupItem/");
        if (!file.exists()) {
            file.mkdirs();
        }
        file = new File(str + "backupMeida/");
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    public static int aao() {
        Intent registerReceiver = ab.getContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            return 100;
        }
        int intExtra = registerReceiver.getIntExtra(DownloadInfo.STATUS, -1);
        boolean z = intExtra == 2 || intExtra == 5;
        w.i("MicroMsg.BackupUtil", "Battery mCharging: %b", new Object[]{Boolean.valueOf(z)});
        if (z) {
            return 100;
        }
        intExtra = registerReceiver.getIntExtra("level", -1);
        int intExtra2 = registerReceiver.getIntExtra("scale", -1);
        if (intExtra < 0 || intExtra2 <= 0) {
            intExtra = 100;
        } else {
            intExtra = (intExtra * 100) / intExtra2;
        }
        w.i("MicroMsg.BackupUtil", "Battery Level Remaining: %d", new Object[]{Integer.valueOf(intExtra)});
        return intExtra;
    }

    private static boolean bD(int i, int i2) {
        try {
            for (NetworkInterface inetAddresses : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                for (InetAddress inetAddress : Collections.list(inetAddresses.getInetAddresses())) {
                    if (!inetAddress.isLoopbackAddress()) {
                        String toUpperCase = inetAddress.getHostAddress().toUpperCase();
                        w.i("MicroMsg.BackupUtil", "check ip:%s, isIPv4:%b", new Object[]{toUpperCase, Boolean.valueOf(InetAddressUtils.isIPv4Address(toUpperCase))});
                        if (InetAddressUtils.isIPv4Address(toUpperCase)) {
                            String[] split = toUpperCase.split("\\.");
                            if ((i & i2) == (n.p(new byte[]{(byte) (bg.getInt(split[0], 0) & 255), (byte) (bg.getInt(split[1], 0) & 255), (byte) (bg.getInt(split[2], 0) & 255), (byte) (bg.getInt(split[3], 0) & 255)}) & i)) {
                                return true;
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
        } catch (Exception e) {
        }
        return false;
    }

    public static boolean rA(String str) {
        int intValue;
        Throwable e;
        String[] split = str.split("\\.");
        int p = n.p(new byte[]{(byte) (bg.getInt(split[0], 0) & 255), (byte) (bg.getInt(split[1], 0) & 255), (byte) (bg.getInt(split[2], 0) & 255), (byte) (bg.getInt(split[3], 0) & 255)});
        int p2 = n.p(new byte[]{(byte) -1, (byte) -1, (byte) -1, (byte) 0});
        WifiManager wifiManager = (WifiManager) ab.getContext().getSystemService("wifi");
        int ipAddress;
        if (wifiManager.getWifiState() == 3) {
            ipAddress = wifiManager.getConnectionInfo().getIpAddress();
            String str2 = (ipAddress & 255) + "." + ((ipAddress >> 8) & 255) + "." + ((ipAddress >> 16) & 255) + "." + ((ipAddress >> 24) & 255);
            w.i("MicroMsg.BackupUtil", "oldIpStr:%s, localIp:%s", new Object[]{str, str2});
            if ((p2 & p) == (ipAddress & p2)) {
                return true;
            }
            return false;
        }
        try {
            intValue = ((Integer) wifiManager.getClass().getField("WIFI_AP_STATE_ENABLED").get(wifiManager)).intValue();
            try {
                ipAddress = ((Integer) wifiManager.getClass().getMethod("getWifiApState", new Class[0]).invoke(wifiManager, new Object[0])).intValue();
            } catch (Exception e2) {
                e = e2;
                w.e("MicroMsg.BackupUtil", "getWifiApState %s", new Object[]{e});
                w.printErrStackTrace("MicroMsg.BackupUtil", e, "", new Object[0]);
                ipAddress = 0;
                if (ipAddress == intValue) {
                    w.i("MicroMsg.BackupUtil", "matchip in apmode");
                    return bD(p2, p);
                }
                w.i("MicroMsg.BackupUtil", "apState:%d", new Object[]{Integer.valueOf(ipAddress)});
                return false;
            }
        } catch (Exception e3) {
            e = e3;
            intValue = 13;
            w.e("MicroMsg.BackupUtil", "getWifiApState %s", new Object[]{e});
            w.printErrStackTrace("MicroMsg.BackupUtil", e, "", new Object[0]);
            ipAddress = 0;
            if (ipAddress == intValue) {
                w.i("MicroMsg.BackupUtil", "apState:%d", new Object[]{Integer.valueOf(ipAddress)});
                return false;
            }
            w.i("MicroMsg.BackupUtil", "matchip in apmode");
            return bD(p2, p);
        }
        if (ipAddress == intValue) {
            w.i("MicroMsg.BackupUtil", "matchip in apmode");
            return bD(p2, p);
        }
        w.i("MicroMsg.BackupUtil", "apState:%d", new Object[]{Integer.valueOf(ipAddress)});
        return false;
    }

    public static boolean rB(String str) {
        if (str == null) {
            return false;
        }
        int indexOf = str.indexOf(60);
        if (indexOf > 0) {
            str = str.substring(indexOf);
        }
        if (bh.q(str, "msg") != null) {
            return true;
        }
        return false;
    }

    public static String a(eh ehVar, int i) {
        return a(ehVar, i, null);
    }

    public static String a(eh ehVar, int i, String str) {
        if (ehVar.til == i && ehVar.tij != null) {
            return g.n(ehVar.tij.tZp.sYA);
        }
        Iterator it = ehVar.tii.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            if (((avy) it.next()).tZt == i) {
                String str2 = ((avx) ehVar.tih.get(i2)).tZr;
                if (!bg.mA(str) && !str2.endsWith(str)) {
                    i2++;
                } else if (e.aO(rC(str2))) {
                    return str2;
                } else {
                    return null;
                }
            }
            i2++;
        }
        return null;
    }

    public static String rC(String str) {
        if (str == null || str.equals("")) {
            return "";
        }
        return aan() + "backupMeida/" + rD(str) + str;
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

    public static int au(String str, int i) {
        if (!bg.mA(str)) {
            try {
                i = Integer.valueOf(str).intValue();
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.BackupUtil", e, "", new Object[0]);
            }
        }
        return i;
    }

    public static boolean b(eh ehVar, int i, String str) {
        if (ehVar.til == i) {
            byte[] bArr = ehVar.tij.tZp.sYA;
            if (bArr.length <= 0) {
                return false;
            }
            e.b(str, bArr, bArr.length);
            return true;
        }
        String a = a(ehVar, i, null);
        if (bg.mA(a)) {
            return false;
        }
        j.p(rC(a), str, false);
        return true;
    }

    public static byte[] b(eh ehVar, int i) {
        if (ehVar.til == i) {
            return ehVar.tij.tZp.sYA;
        }
        Iterator it = ehVar.tii.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            if (((avy) it.next()).tZt == i) {
                String rC = rC(((avx) ehVar.tih.get(i2)).tZr);
                i2 = e.aN(rC);
                if (i2 != 0 && i2 <= 1048576) {
                    return e.d(rC, 0, -1);
                }
                w.e("MicroMsg.BackupUtil", "thumb not exist or  too big!");
                return null;
            }
            i2++;
        }
        return null;
    }

    public static int c(eh ehVar, int i) {
        if (ehVar.til == i) {
            return ehVar.tij.tZp.sYA.length;
        }
        Iterator it = ehVar.tii.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            if (((avy) it.next()).tZt == i) {
                return e.aN(rC(((avx) ehVar.tih.get(i2)).tZr));
            }
            i2++;
        }
        return 0;
    }

    public static boolean d(eh ehVar, int i) {
        if (ehVar.til == i && ehVar.tij != null) {
            return true;
        }
        Iterator it = ehVar.tii.iterator();
        while (it.hasNext()) {
            if (((avy) it.next()).tZt == i) {
                return true;
            }
        }
        return false;
    }

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
        r3 = "MicroMsg.BackupUtil";
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
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.backup.a.h.a(long, com.tencent.mm.pointers.PLong, com.tencent.mm.pointers.PLong, java.lang.String):boolean");
    }

    public static long rE(String str) {
        long j = 0;
        try {
            j = new SimpleDateFormat("yyyyMMddHHmmss").parse(str).getTime();
        } catch (ParseException e) {
            w.e("MicroMsg.BackupUtil", "dateToTimeStamp failed. date:%s, stack:%s", new Object[]{str, bg.bJZ()});
        }
        return j;
    }

    public static LinkedList<String> r(LinkedList<d> linkedList) {
        LinkedList<String> linkedList2 = new LinkedList();
        if (linkedList != null) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                linkedList2.add(((d) it.next()).jBh);
            }
        }
        return linkedList2;
    }

    public static String a(String str, String str2, String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return str;
        }
        StringBuilder stringBuilder;
        int i;
        if (str.equals("")) {
            stringBuilder = new StringBuilder(strArr[0]);
            i = 1;
        } else {
            stringBuilder = new StringBuilder(str);
            i = 0;
        }
        for (String str3 : strArr) {
            if (i != 0) {
                i = 0;
            } else {
                stringBuilder.append(str2).append(str3);
            }
        }
        return stringBuilder.toString();
    }

    public static String[] bl(String str, String str2) {
        return str.split(str2);
    }

    public static m aG(long j) {
        m mVar = new m();
        String deviceID = p.getDeviceID(ab.getContext());
        if (deviceID == null) {
            deviceID = p.rB();
        }
        mVar.jNm = deviceID;
        mVar.jNn = Build.MANUFACTURER;
        mVar.jNo = Build.MODEL;
        mVar.jNp = "Android";
        mVar.jNq = VERSION.RELEASE;
        mVar.jNr = d.sYN;
        mVar.jNs = j;
        w.i("MicroMsg.BackupUtil", "getBackupStartGeneralInfo WechatVersion[%s], freespace[%d], deviceId[%s]", new Object[]{Integer.valueOf(d.sYN), Long.valueOf(j), mVar.jNm});
        return mVar;
    }
}
