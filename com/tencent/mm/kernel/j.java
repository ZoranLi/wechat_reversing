package com.tencent.mm.kernel;

public final class j {
    private static volatile a gZk = null;

    public interface a {
        void e(String str, String str2, Object... objArr);

        void i(String str, String str2, Object... objArr);

        void printErrStackTrace(String str, Throwable th, String str2, Object... objArr);

        void w(String str, String str2, Object... objArr);
    }

    public static void a(a aVar) {
        gZk = aVar;
    }

    public static void e(String str, String str2, Object... objArr) {
        if (gZk != null) {
            gZk.e(str, str2, objArr);
        }
    }

    public static void w(String str, String str2, Object... objArr) {
        if (gZk != null) {
            gZk.w(str, str2, objArr);
        }
    }

    public static void i(String str, String str2, Object... objArr) {
        if (gZk != null) {
            gZk.i(str, str2, objArr);
        }
    }

    public static void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
        if (gZk != null) {
            gZk.printErrStackTrace(str, th, str2, objArr);
        }
    }
}
