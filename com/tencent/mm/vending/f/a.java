package com.tencent.mm.vending.f;

public final class a {
    private static a wCJ = null;

    public interface a {
        void d(String str, String str2, Object... objArr);

        void e(String str, String str2, Object... objArr);

        void i(String str, String str2, Object... objArr);

        void printErrStackTrace(String str, Throwable th, String str2, Object... objArr);

        void w(String str, String str2, Object... objArr);
    }

    public static void a(a aVar) {
        wCJ = aVar;
    }

    public static void e(String str, String str2, Object... objArr) {
        if (wCJ != null) {
            wCJ.e(str, str2, objArr);
        }
    }

    public static void w(String str, String str2, Object... objArr) {
        if (wCJ != null) {
            wCJ.w(str, str2, objArr);
        }
    }

    public static void i(String str, String str2, Object... objArr) {
        if (wCJ != null) {
            wCJ.i(str, str2, objArr);
        }
    }

    public static void d(String str, String str2, Object... objArr) {
        if (wCJ != null) {
            wCJ.d(str, str2, objArr);
        }
    }

    public static void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
        if (wCJ != null) {
            wCJ.printErrStackTrace(str, th, str2, objArr);
        }
    }
}
