package com.tencent.c.e;

import android.content.Context;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;

public final class d {

    public enum a {
        ;

        static {
            wSr = 1;
            wSs = 2;
            wSt = 3;
            wSu = 4;
            wSv = new int[]{wSr, wSs, wSt, wSu};
        }
    }

    public static String fz(Context context) {
        String str = "";
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
        } catch (Throwable th) {
            g.bS("getIMEI: " + th);
            return str;
        }
    }

    public static String fA(Context context) {
        String str = "";
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getSubscriberId();
        } catch (Throwable th) {
            g.bS("getIMSI: " + th);
            return str;
        }
    }

    public static int cdf() {
        try {
            return Integer.parseInt(VERSION.SDK);
        } catch (Throwable th) {
            g.bS("getSDKVersion: " + th);
            return 0;
        }
    }

    public static String fB(Context context) {
        try {
            return Secure.getString(context.getContentResolver(), "android_id");
        } catch (Throwable th) {
            g.bS("getAndroidId: " + th);
            return "";
        }
    }

    public static String ma(boolean z) {
        String str;
        Object obj;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        Throwable th;
        BufferedReader bufferedReader3 = null;
        if (z) {
            str = "/sys/block/mmcblk0/device/";
            obj = "MMC";
        } else {
            str = "/sys/block/mmcblk1/device/";
            obj = "SD";
        }
        try {
            bufferedReader = new BufferedReader(new FileReader(str + Columns.TYPE));
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null && readLine.toUpperCase().equals(r0)) {
                    BufferedReader bufferedReader4 = new BufferedReader(new FileReader(str + "cid"));
                    try {
                        String readLine2 = bufferedReader4.readLine();
                        if (readLine2 != null) {
                            readLine2 = readLine2.trim();
                            try {
                                bufferedReader.close();
                            } catch (IOException e) {
                            }
                            try {
                                bufferedReader4.close();
                                return readLine2;
                            } catch (IOException e2) {
                                return readLine2;
                            }
                        }
                        bufferedReader3 = bufferedReader4;
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader3 = bufferedReader4;
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        if (bufferedReader3 != null) {
                            bufferedReader3.close();
                        }
                        throw th;
                    }
                }
                try {
                    bufferedReader.close();
                } catch (IOException e3) {
                }
                if (bufferedReader3 != null) {
                    try {
                        bufferedReader3.close();
                    } catch (IOException e4) {
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (bufferedReader3 != null) {
                    bufferedReader3.close();
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (bufferedReader3 != null) {
                bufferedReader3.close();
            }
            throw th;
        }
        return "";
    }

    public static String cdM() {
        String str = "";
        try {
            InputStream fileInputStream = new FileInputStream("/proc/version");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream), 8192);
            StringBuilder stringBuilder = new StringBuilder("");
            while (true) {
                try {
                    str = bufferedReader.readLine();
                    if (str != null) {
                        stringBuilder.append(str);
                    } else {
                        try {
                            break;
                        } catch (Throwable th) {
                            g.bT(th);
                        }
                    }
                } catch (Throwable th2) {
                    g.bT(th2);
                }
            }
            bufferedReader.close();
            try {
                fileInputStream.close();
            } catch (Throwable th22) {
                g.bT(th22);
            }
            return stringBuilder.toString();
            fileInputStream.close();
            return stringBuilder.toString();
            return stringBuilder.toString();
        } catch (Throwable th3) {
            g.bT(th3);
            return str;
        }
    }

    public static String Vh(String str) {
        Object th;
        String str2 = "";
        String str3;
        try {
            Method method = Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class});
            method.setAccessible(true);
            str3 = (String) method.invoke(null, new Object[]{str});
            if (str3 != null) {
                return str3;
            }
            try {
                return "";
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            Throwable th4 = th3;
            str3 = str2;
            th = th4;
            g.bS(" getBuildPropByReflect: " + th);
            return str3;
        }
    }
}
