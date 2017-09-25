package com.tencent.mm.sdk.platformtools;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.util.Log;

public final class w {
    public static int level = 6;
    private static final String rog;
    private static a usI;
    private static a usJ;

    public interface a {
        void appenderClose();

        void appenderFlush(boolean z);

        int getLogLevel();

        void logD(String str, String str2, String str3, int i, int i2, long j, long j2, String str4);

        void logE(String str, String str2, String str3, int i, int i2, long j, long j2, String str4);

        void logF(String str, String str2, String str3, int i, int i2, long j, long j2, String str4);

        void logI(String str, String str2, String str3, int i, int i2, long j, long j2, String str4);

        void logV(String str, String str2, String str3, int i, int i2, long j, long j2, String str4);

        void logW(String str, String str2, String str3, int i, int i2, long j, long j2, String str4);
    }

    static {
        a anonymousClass1 = new a() {
            private Handler handler = new Handler(Looper.getMainLooper());

            public final void logV(String str, String str2, String str3, int i, int i2, long j, long j2, String str4) {
                int i3 = w.level;
            }

            public final void logI(String str, String str2, String str3, int i, int i2, long j, long j2, String str4) {
                int i3 = w.level;
            }

            public final void logD(String str, String str2, String str3, int i, int i2, long j, long j2, String str4) {
                int i3 = w.level;
            }

            public final void logW(String str, String str2, String str3, int i, int i2, long j, long j2, String str4) {
                int i3 = w.level;
            }

            public final void logE(String str, String str2, String str3, int i, int i2, long j, long j2, String str4) {
                int i3 = w.level;
            }

            public final void logF(String str, String str2, String str3, int i, int i2, long j, long j2, String str4) {
                if (w.level <= 5) {
                }
            }

            public final int getLogLevel() {
                return w.level;
            }

            public final void appenderClose() {
            }

            public final void appenderFlush(boolean z) {
            }
        };
        usI = anonymousClass1;
        usJ = anonymousClass1;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            stringBuilder.append("VERSION.RELEASE:[" + VERSION.RELEASE);
            stringBuilder.append("] VERSION.CODENAME:[" + VERSION.CODENAME);
            stringBuilder.append("] VERSION.INCREMENTAL:[" + VERSION.INCREMENTAL);
            stringBuilder.append("] BOARD:[" + Build.BOARD);
            stringBuilder.append("] DEVICE:[" + Build.DEVICE);
            stringBuilder.append("] DISPLAY:[" + Build.DISPLAY);
            stringBuilder.append("] FINGERPRINT:[" + Build.FINGERPRINT);
            stringBuilder.append("] HOST:[" + Build.HOST);
            stringBuilder.append("] MANUFACTURER:[" + Build.MANUFACTURER);
            stringBuilder.append("] MODEL:[" + Build.MODEL);
            stringBuilder.append("] PRODUCT:[" + Build.PRODUCT);
            stringBuilder.append("] TAGS:[" + Build.TAGS);
            stringBuilder.append("] TYPE:[" + Build.TYPE);
            stringBuilder.append("] USER:[" + Build.USER + "]");
        } catch (Throwable th) {
            printErrStackTrace("MicroMsg.SDK.Log", th, "", new Object[0]);
        }
        rog = stringBuilder.toString();
    }

    public static void a(a aVar) {
        usJ = aVar;
    }

    public static a bIO() {
        return usJ;
    }

    public static void appenderClose() {
        if (usJ != null) {
            usJ.appenderClose();
        }
    }

    public static void bIP() {
        if (usJ != null) {
            usJ.appenderFlush(false);
        }
    }

    public static void bIQ() {
        if (usJ != null) {
            usJ.appenderFlush(true);
        }
    }

    public static int getLogLevel() {
        if (usJ != null) {
            return usJ.getLogLevel();
        }
        return 6;
    }

    public static void yu(int i) {
        level = i;
    }

    public static void f(String str, String str2) {
        f(str, str2, null);
    }

    public static void e(String str, String str2) {
        e(str, str2, null);
    }

    public static void w(String str, String str2) {
        w(str, str2, null);
    }

    public static void i(String str, String str2) {
        i(str, str2, null);
    }

    public static void d(String str, String str2) {
        d(str, str2, null);
    }

    public static void v(String str, String str2) {
        v(str, str2, null);
    }

    public static void f(String str, String str2, Object... objArr) {
        if (usJ != null && usJ.getLogLevel() <= 5) {
            usJ.logF(str, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), objArr == null ? str2 : String.format(str2, objArr));
        }
    }

    public static void e(String str, String str2, Object... objArr) {
        if (usJ != null && usJ.getLogLevel() <= 4) {
            String format = objArr == null ? str2 : String.format(str2, objArr);
            if (format == null) {
                format = "";
            }
            usJ.logE(str, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), format);
        }
    }

    public static void w(String str, String str2, Object... objArr) {
        if (usJ != null && usJ.getLogLevel() <= 3) {
            String format = objArr == null ? str2 : String.format(str2, objArr);
            if (format == null) {
                format = "";
            }
            usJ.logW(str, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), format);
        }
    }

    public static void i(String str, String str2, Object... objArr) {
        if (usJ != null && usJ.getLogLevel() <= 2) {
            String format = objArr == null ? str2 : String.format(str2, objArr);
            if (format == null) {
                format = "";
            }
            usJ.logI(str, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), format);
        }
    }

    public static void d(String str, String str2, Object... objArr) {
        if (usJ != null && usJ.getLogLevel() <= 1) {
            String format = objArr == null ? str2 : String.format(str2, objArr);
            if (format == null) {
                format = "";
            }
            usJ.logD(str, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), format);
        }
    }

    public static void v(String str, String str2, Object... objArr) {
        if (usJ != null && usJ.getLogLevel() <= 0) {
            String format = objArr == null ? str2 : String.format(str2, objArr);
            if (format == null) {
                format = "";
            }
            usJ.logV(str, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), format);
        }
    }

    public static void h(String str, String str2, Object... objArr) {
        if (usJ != null && usJ.getLogLevel() <= 1) {
            String format = String.format(str2, objArr);
            if (format == null) {
                format = "";
            }
            String str3 = format + "  " + new ah();
            String str4 = str;
            usJ.logI(str4, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), str3);
        }
    }

    public static void j(String str, String str2, Object... objArr) {
        if (usJ != null && usJ.getLogLevel() <= 2) {
            String format = String.format(str2, objArr);
            if (format == null) {
                format = "";
            }
            String str3 = format + "  " + new ah();
            String str4 = str;
            usJ.logI(str4, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), str3);
        }
    }

    public static void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
        if (usJ != null && usJ.getLogLevel() <= 4) {
            String format = objArr == null ? str2 : String.format(str2, objArr);
            if (format == null) {
                format = "";
            }
            String str3 = format + "  " + Log.getStackTraceString(th);
            usJ.logE(str, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), str3);
        }
    }

    public static String bIR() {
        return rog;
    }
}
