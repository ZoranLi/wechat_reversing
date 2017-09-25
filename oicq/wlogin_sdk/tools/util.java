package oicq.wlogin_sdk.tools;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import com.tencent.wcdb.FileUtils;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.security.Key;
import java.security.KeyFactory;
import java.security.SecureRandom;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import oicq.wlogin_sdk.request.i;

public class util {
    public static int xoP = 65535;
    public static int xoQ = FileUtils.S_IWUSR;
    public static int xoR = 0;
    public static int xoS = 1;
    public static int xoT = 2;
    public static int xoU = 3;
    public static int xoV = 4;
    public static int xoW = 5;
    public static int xoX = 6;
    public static int xoY = 7;
    public static int xoZ = 8;
    public static int xpa = 9;
    public static int xpb = 10;
    public static int xpc = 11;
    public static int xpd = 12;
    public static int xpe = 13;
    public static int xpf = 14;
    public static int xpg = 1;
    public static b xph = null;
    public static boolean xpi = false;
    public static int xpj = 5;

    public static byte[] cit() {
        return new String("android").getBytes();
    }

    public static byte[] ciu() {
        return VERSION.RELEASE.getBytes();
    }

    public static void o(byte[] bArr, int i, int i2) {
        bArr[i + 0] = (byte) (i2 >> 0);
    }

    public static void p(byte[] bArr, int i, int i2) {
        bArr[i + 1] = (byte) (i2 >> 0);
        bArr[i + 0] = (byte) (i2 >> 8);
    }

    public static void q(byte[] bArr, int i, int i2) {
        bArr[i + 3] = (byte) (i2 >> 0);
        bArr[i + 2] = (byte) (i2 >> 8);
        bArr[i + 1] = (byte) (i2 >> 16);
        bArr[i + 0] = (byte) (i2 >> 24);
    }

    public static void b(byte[] bArr, int i, long j) {
        bArr[i + 7] = (byte) ((int) (j >> null));
        bArr[i + 6] = (byte) ((int) (j >> 8));
        bArr[i + 5] = (byte) ((int) (j >> 16));
        bArr[i + 4] = (byte) ((int) (j >> 24));
        bArr[i + 3] = (byte) ((int) (j >> 32));
        bArr[i + 2] = (byte) ((int) (j >> 40));
        bArr[i + 1] = (byte) ((int) (j >> 48));
        bArr[i + 0] = (byte) ((int) (j >> 56));
    }

    public static void c(byte[] bArr, int i, long j) {
        bArr[i + 3] = (byte) ((int) (j >> null));
        bArr[i + 2] = (byte) ((int) (j >> 8));
        bArr[i + 1] = (byte) ((int) (j >> 16));
        bArr[i + 0] = (byte) ((int) (j >> 24));
    }

    public static int J(byte[] bArr, int i) {
        return bArr[i] & 255;
    }

    public static int K(byte[] bArr, int i) {
        return ((bArr[i] << 8) & 65280) + ((bArr[i + 1] << 0) & 255);
    }

    public static int L(byte[] bArr, int i) {
        return ((((bArr[i] << 24) & WebView.NIGHT_MODE_COLOR) + ((bArr[i + 1] << 16) & 16711680)) + ((bArr[i + 2] << 8) & 65280)) + ((bArr[i + 3] << 0) & 255);
    }

    public static int civ() {
        return (int) (Math.random() * 2.147483647E9d);
    }

    public static byte[] ciw() {
        return SecureRandom.getSeed(16);
    }

    public static byte[] bT(byte[] bArr) {
        Object seed = SecureRandom.getSeed(16);
        Object obj = new byte[(seed.length + bArr.length)];
        System.arraycopy(seed, 0, obj, 0, seed.length);
        System.arraycopy(bArr, 0, obj, seed.length, bArr.length);
        return c.bS(obj);
    }

    public static long cix() {
        return i.cin();
    }

    public static String bU(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        String str = "";
        for (int i = 0; i < bArr.length; i++) {
            str = new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(str)).append(Integer.toHexString((bArr[i] >> 4) & 15)).toString())).append(Integer.toHexString(bArr[i] & 15)).toString();
        }
        return str;
    }

    public static long bV(byte[] bArr) {
        if (bArr == null) {
            return 0;
        }
        return (long) bArr.length;
    }

    private static byte b(byte b) {
        if (b >= (byte) 48 && b <= (byte) 57) {
            return (byte) (b - 48);
        }
        if (b >= (byte) 97 && b <= (byte) 102) {
            return (byte) ((b - 97) + 10);
        }
        if (b < (byte) 65 || b > (byte) 70) {
            return (byte) 0;
        }
        return (byte) ((b - 65) + 10);
    }

    private static byte[] Ws(String str) {
        int i = 0;
        if (str == null) {
            return new byte[0];
        }
        byte[] bArr = new byte[(str.length() / 2)];
        while (i < str.length() / 2) {
            bArr[i] = (byte) ((b((byte) str.charAt(i * 2)) << 4) + b((byte) str.charAt((i * 2) + 1)));
            i++;
        }
        return bArr;
    }

    public static byte[] hN(Context context) {
        WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
        if (wifiManager != null) {
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            if (connectionInfo != null) {
                String macAddress = connectionInfo.getMacAddress();
                if (macAddress != null) {
                    return macAddress.getBytes();
                }
            }
        }
        return new byte[0];
    }

    public static byte[] hO(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager != null) {
            String deviceId = telephonyManager.getDeviceId();
            if (deviceId != null) {
                return deviceId.getBytes();
            }
        }
        return new byte[0];
    }

    public static byte[] hP(Context context) {
        String deviceId;
        String str = null;
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager != null) {
            deviceId = telephonyManager.getDeviceId();
        } else {
            deviceId = null;
        }
        WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
        if (wifiManager != null) {
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            if (connectionInfo != null) {
                str = connectionInfo.getMacAddress();
            }
        }
        String str2 = "";
        if (deviceId != null) {
            str2 = new StringBuilder(String.valueOf(str2)).append(deviceId).toString();
        }
        if (str != null) {
            str2 = new StringBuilder(String.valueOf(str2)).append(str).toString();
        }
        if (str2.length() <= 0) {
            return new byte[0];
        }
        return c.bS(str2.getBytes());
    }

    public static byte[] hQ(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager.getSimState() == 5) {
                return telephonyManager.getSimOperatorName().getBytes();
            }
            return new byte[0];
        } catch (Throwable th) {
            return new byte[0];
        }
    }

    public static int hR(Context context) {
        int type;
        try {
            type = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo().getType();
        } catch (Exception e) {
            type = 0;
        }
        if (type == 0) {
            return 1;
        }
        return type == 1 ? 2 : 0;
    }

    public static int hS(Context context) {
        return context.getSharedPreferences("WLOGIN_SERVER_INFO", 0).getInt("network_type", 0);
    }

    public static void an(Context context, int i) {
        Editor edit = context.getSharedPreferences("WLOGIN_SERVER_INFO", 0).edit();
        edit.putInt("network_type", i);
        edit.commit();
    }

    public static void hT(Context context) {
        Editor edit = context.getSharedPreferences("WLOGIN_NET_RETRY_TYPE", 0).edit();
        edit.putInt(Columns.TYPE, 0);
        edit.commit();
    }

    public static String hU(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo.getType() != 0) {
                return "wifi";
            }
            String extraInfo = activeNetworkInfo.getExtraInfo();
            if (extraInfo != null) {
                return extraInfo;
            }
            return "wifi";
        } catch (Exception e) {
        }
    }

    public static void a(Context context, byte[] bArr) {
        byte[] hV = hV(context);
        if (hV == null || hV.length <= 0) {
            Editor edit = context.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).edit();
            edit.putString("ksid", bU(bArr));
            edit.commit();
        }
    }

    public static byte[] hV(Context context) {
        byte[] Ws;
        byte[] bytes = new String("").getBytes();
        try {
            Ws = Ws(context.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).getString("ksid", new String("")));
        } catch (Exception e) {
            Writer stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter, true);
            e.printStackTrace(printWriter);
            printWriter.flush();
            stringWriter.flush();
            fq("exception", stringWriter.toString());
            Ws = bytes;
        }
        if (Ws == null || Ws.length <= 0) {
            Qs("get_ksid:null");
        } else {
            Qs("get_ksid:" + bU(Ws));
        }
        return Ws;
    }

    public static void b(Context context, byte[] bArr) {
        if (bArr != null && bArr.length > 0) {
            Editor edit = context.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).edit();
            edit.putString("imei", bU(bArr));
            edit.commit();
        }
    }

    public static byte[] hW(Context context) {
        byte[] bArr = new byte[0];
        try {
            bArr = Ws(context.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).getString("imei", new String("")));
        } catch (Exception e) {
            Writer stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter, true);
            e.printStackTrace(printWriter);
            printWriter.flush();
            stringWriter.flush();
            fq("exception", stringWriter.toString());
        }
        if (bArr.length <= 0) {
            return new byte[0];
        }
        Qs("get_imei:" + bU(bArr));
        return bArr;
    }

    public static byte[] hX(Context context) {
        return context.getPackageName().getBytes();
    }

    public static byte[] bO(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0).versionName.getBytes();
        } catch (Exception e) {
            return new byte[0];
        }
    }

    public static byte[] bP(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            if (packageInfo.signatures == null || packageInfo.signatures.length <= 0 || packageInfo.signatures[0] == null) {
                return null;
            }
            return c.bS(packageInfo.signatures[0].toByteArray());
        } catch (Throwable th) {
            return new byte[0];
        }
    }

    private static String ciy() {
        try {
            StackTraceElement stackTraceElement = new Throwable().getStackTrace()[2];
            return "[" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + "]";
        } catch (Exception e) {
            return "";
        }
    }

    public static void Wt(String str) {
        try {
            if (xpg <= 0) {
                return;
            }
            if (xph != null) {
                xph.o(1, str);
            } else if (xpi) {
                new StringBuilder("wlogin_sdk").append(ciy());
            }
        } catch (Exception e) {
        }
    }

    public static void Qs(String str) {
        try {
            if (xpg < 2) {
                return;
            }
            if (xph != null) {
                xph.o(2, str);
            } else if (xpi) {
                new StringBuilder("wlogin_sdk").append(ciy());
            }
        } catch (Exception e) {
        }
    }

    public static void fp(String str, String str2) {
        try {
            if (xpg < 2) {
                return;
            }
            if (xph != null) {
                xph.e(2, str, str2);
            } else if (xpi) {
                new StringBuilder("wlogin_sdk").append(ciy());
                new StringBuilder(String.valueOf(str)).append(":").append(str2);
            }
        } catch (Exception e) {
        }
    }

    public static void fq(String str, String str2) {
        try {
            if (xpg < 0) {
                return;
            }
            if (xph != null) {
                xph.e(0, str, str2);
            } else if (xpi) {
                new StringBuilder("wlogin_sdk").append(ciy());
                new StringBuilder(String.valueOf(str)).append(":").append(str2);
            }
        } catch (Exception e) {
        }
    }

    public static void j(Exception exception) {
        Writer stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter, true);
        exception.printStackTrace(printWriter);
        printWriter.flush();
        stringWriter.flush();
        fq("exception:", stringWriter.toString());
    }

    public static boolean isFileExist(String str) {
        try {
            return new File(str).exists();
        } catch (Exception e) {
            return false;
        }
    }

    public static String ciz() {
        return new String("2014/02/28 14:20");
    }

    public static Key RSAPubKeyFromJNI(byte[] bArr) {
        byte b = (byte) 1;
        if (bArr == null) {
            return null;
        }
        Object obj = new byte[22];
        obj[0] = (byte) 48;
        obj[1] = -127;
        obj[2] = (byte) -97;
        obj[3] = (byte) 48;
        obj[4] = 13;
        obj[5] = (byte) 6;
        obj[6] = (byte) 9;
        obj[7] = (byte) 42;
        obj[8] = (byte) -122;
        obj[9] = (byte) 72;
        obj[10] = (byte) -122;
        obj[11] = (byte) -9;
        obj[12] = 13;
        obj[13] = 1;
        obj[14] = 1;
        obj[15] = 1;
        obj[16] = (byte) 5;
        obj[18] = (byte) 3;
        obj[19] = -127;
        obj[20] = (byte) -115;
        Object obj2 = new byte[(bArr.length + 22)];
        if (bArr.length >= 22) {
            for (int i = 0; i < 22; i++) {
                if (obj[i] != bArr[i]) {
                    b = (byte) 0;
                    break;
                }
            }
        }
        if (b == (byte) 0) {
            System.arraycopy(obj, 0, obj2, 0, 22);
            System.arraycopy(bArr, 0, obj2, 22, bArr.length);
            Object obj3 = obj2;
        }
        try {
            return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(bArr));
        } catch (Exception e) {
            j(e);
            return null;
        }
    }

    public static Key RSAPrivKeyFromJNI(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        r0 = new byte[26];
        int length = bArr.length - 607;
        r0[3] = (byte) (r0[3] + length);
        r0[25] = (byte) (length + r0[25]);
        Object obj = new byte[(bArr.length + 26)];
        System.arraycopy(r0, 0, obj, 0, 26);
        System.arraycopy(bArr, 0, obj, 26, bArr.length);
        try {
            return KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(obj));
        } catch (Exception e) {
            j(e);
            return null;
        }
    }
}
