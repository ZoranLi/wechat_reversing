package com.tencent.mm.compatible.d;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import com.tencent.mm.a.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.regex.Pattern;

public final class p {
    public static n gRb = new n();
    public static b gRc = new b();
    public static a gRd = new a();
    public static u gRe = new u();
    public static y gRf = new y();
    public static r gRg = new r();
    public static t gRh = new t();
    public static w gRi = new w();
    public static s gRj = new s();
    private static int gRk = -1;
    public static j gRl = new j();
    public static o gRm = new o();
    private static String gRn = null;

    class a implements FileFilter {
        a() {
        }

        public final boolean accept(File file) {
            if (Pattern.matches("cpu[0-9]+", file.getName())) {
                return true;
            }
            return false;
        }
    }

    public static String rA() {
        String str = (String) k.rj().get(258);
        if (str == null) {
            str = getDeviceID(ab.getContext());
            if (str == null) {
                str = "1234567890ABCDEF";
            }
            k.rj().set(258, str);
        }
        return str;
    }

    public static String getDeviceID(Context context) {
        if (context == null) {
            return null;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                return null;
            }
            String deviceId = telephonyManager.getDeviceId();
            return deviceId == null ? null : deviceId.trim();
        } catch (SecurityException e) {
            w.e("MicroMsg.DeviceInfo", "getDeviceId failed, security exception");
            return null;
        } catch (Throwable e2) {
            w.printErrStackTrace("MicroMsg.DeviceInfo", e2, "", new Object[0]);
            return null;
        }
    }

    public static String rB() {
        if (gRn == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(Secure.getString(ab.getContext().getContentResolver(), "android_id"));
            String str = (String) k.rj().get(256);
            if (str == null) {
                str = rE();
                k.rj().set(256, str);
            }
            stringBuilder.append(str);
            str = (String) k.rj().get(259);
            if (str != null) {
                w.d("MicroMsg.DeviceInfo", "getHardWareId from file " + str);
            } else {
                str = Build.MANUFACTURER + Build.MODEL + m.rq();
                k.rj().set(259, str);
                w.d("MicroMsg.DeviceInfo", "getHardWareId " + str);
            }
            stringBuilder.append(str);
            gRn = "A" + g.n(stringBuilder.toString().getBytes()).substring(0, 15);
            w.w("MicroMsg.DeviceInfo", "guid:%s, dev=%s", gRn, str);
        }
        return gRn;
    }

    public static String rC() {
        WifiManager wifiManager = (WifiManager) ab.getContext().getSystemService("wifi");
        WifiInfo connectionInfo = wifiManager == null ? null : wifiManager.getConnectionInfo();
        return connectionInfo != null ? connectionInfo.getMacAddress() : null;
    }

    public static String rD() {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter != null) {
            return defaultAdapter.getAddress();
        }
        return null;
    }

    private static String rE() {
        String str;
        String em = bg.em(ab.getContext());
        if (em == null || em.length() <= 0) {
            Random random = new Random();
            random.setSeed(System.currentTimeMillis());
            str = "A";
            int i = 0;
            while (i < 15) {
                i++;
                str = str + ((char) (random.nextInt(25) + 65));
            }
        } else {
            str = ("A" + em + "123456789ABCDEF").substring(0, 15);
        }
        w.w("MicroMsg.DeviceInfo", "generated deviceId=" + str);
        return str;
    }

    public static void du(String str) {
        w.i("MicroMsg.DeviceInfo", "update deviceInfo %s", str);
        if (str != null && str.length() > 0 && str.hashCode() != gRk) {
            gRk = str.hashCode();
            gRb.reset();
            gRc.reset();
            gRd.reset();
            gRl.reset();
            gRe.reset();
            gRf.reset();
            r rVar = gRg;
            rVar.gRo = 0;
            rVar.gRp = 0;
            t tVar = gRh;
            tVar.gRz = "";
            tVar.gRA = null;
            gRi.fXh = false;
            gRj.reset();
            q qVar = new q();
            if (q.a(str, gRb, gRc, gRd, gRl, gRe, gRf, gRg, gRh, gRi, gRj)) {
                w.d("MicroMsg.DeviceInfo", "steve: mCameraInfo.mNeedEnhance = " + gRc.gPy);
            }
        }
    }

    public static String rF() {
        return Build.MODEL;
    }

    public static String aw(Context context) {
        try {
            w.i("MicroMsg.DeviceInfo", "lm: getManufacturer CurrentLanguage is %s", v.ea(context));
            if (gRh == null || gRh.gRA == null || gRh.gRA.size() == 0) {
                w.i("MicroMsg.DeviceInfo", "lm: getManufacturer return is %s", Build.MANUFACTURER);
                return Build.MANUFACTURER;
            }
            String str = (String) gRh.gRA.get(".manufacturerName." + v.ea(context));
            w.i("MicroMsg.DeviceInfo", "lm: getManufacturer is %s", str);
            if (!bg.mA(str)) {
                return str;
            }
            str = (String) gRh.gRA.get(".manufacturerName.en");
            w.i("MicroMsg.DeviceInfo", "lm: getManufacturer is %s", str);
            if (bg.mA(str)) {
                return Build.MANUFACTURER;
            }
            return str;
        } catch (Exception e) {
            return Build.MANUFACTURER;
        }
    }

    public static String ax(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getSimOperatorName();
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.DeviceInfo", e, "getMobileSPType", new Object[0]);
            return "";
        }
    }

    public static String getSimCountryIso() {
        TelephonyManager telephonyManager = (TelephonyManager) ab.getContext().getSystemService("phone");
        if (telephonyManager == null) {
            return null;
        }
        w.i("MicroMsg.DeviceInfo", "get isoCode:[%s]", telephonyManager.getSimCountryIso());
        return telephonyManager.getSimCountryIso();
    }

    public static String[] rG() {
        BufferedReader bufferedReader;
        Throwable th;
        String[] strArr = new String[]{"", "0"};
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/cpuinfo"), 8192);
            try {
                String[] split = bg.mz(bufferedReader.readLine()).split("\\s+");
                for (int i = 2; i < split.length; i++) {
                    strArr[0] = strArr[0] + split[i] + " ";
                }
                strArr[1] = bg.mz(bufferedReader.readLine()).split("\\s+")[2];
                try {
                    bufferedReader.close();
                } catch (Exception e) {
                }
            } catch (IOException e2) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception e3) {
                    }
                }
                return strArr;
            } catch (Throwable th2) {
                Throwable th3 = th2;
                bufferedReader2 = bufferedReader;
                th = th3;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (Exception e4) {
                    }
                }
                throw th;
            }
        } catch (IOException e5) {
            bufferedReader = null;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            return strArr;
        } catch (Throwable th4) {
            th = th4;
            if (bufferedReader2 != null) {
                bufferedReader2.close();
            }
            throw th;
        }
        return strArr;
    }

    public static String getAndroidId() {
        w.i("MicroMsg.DeviceInfo", "androidid:[%s]", Secure.getString(ab.getContext().getContentResolver(), "android_id"));
        return Secure.getString(ab.getContext().getContentResolver(), "android_id");
    }

    public static String rH() {
        String str = null;
        try {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (defaultAdapter != null && defaultAdapter.isEnabled()) {
                str = defaultAdapter.getAddress();
            }
            return bg.mz(str);
        } catch (Throwable e) {
            w.e("MicroMsg.DeviceInfo", "getBlueToothAddress failed: %s", bg.g(e));
            return "";
        }
    }

    @SuppressLint({"NewApi"})
    public static String rI() {
        String str = null;
        try {
            if (VERSION.SDK_INT >= 14) {
                str = Build.getRadioVersion();
            } else {
                str = Build.RADIO;
            }
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.Crash", e, "May cause dvmFindCatchBlock crash!", new Object[0]);
            throw ((IncompatibleClassChangeError) new IncompatibleClassChangeError("May cause dvmFindCatchBlock crash!").initCause(e));
        } catch (Throwable th) {
        }
        return bg.mz(str);
    }

    public static String rJ() {
        return VERSION.RELEASE;
    }

    public static String rK() {
        try {
            return bg.mz(((TelephonyManager) ab.getContext().getSystemService("phone")).getSubscriberId());
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.DeviceInfo", e, "getPhoneIMSI", new Object[0]);
            return "";
        }
    }

    public static String rL() {
        try {
            return bg.mz(((TelephonyManager) ab.getContext().getSystemService("phone")).getSimSerialNumber());
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.DeviceInfo", e, "getPhoneICCID", new Object[0]);
            return "";
        }
    }

    @SuppressLint({"NewApi"})
    public static String rM() {
        String str = null;
        if (VERSION.SDK_INT >= 9) {
            str = Build.SERIAL;
        }
        return bg.mz(str);
    }

    public static Map<String, String> rN() {
        Map<String, String> hashMap = new HashMap();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ProcessBuilder(new String[]{"/system/bin/cat", "/proc/cpuinfo"}).start().getInputStream()));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                } else if (!readLine.trim().equals("")) {
                    String[] split = readLine.split(":");
                    if (split.length > 1) {
                        hashMap.put(split[0].trim().toLowerCase(), split[1].trim());
                    }
                }
            }
            bufferedReader.close();
        } catch (IOException e) {
        }
        return hashMap;
    }

    public static int rO() {
        try {
            return new File("/sys/devices/system/cpu").listFiles(new a()).length;
        } catch (Exception e) {
            return 1;
        }
    }

    public static String rP() {
        return "android-" + Build.MODEL + "-" + VERSION.SDK_INT;
    }
}
