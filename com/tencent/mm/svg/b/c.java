package com.tencent.mm.svg.b;

public final class c {
    private static a uNy = null;

    public interface a {
        void d(String str, String str2, Object... objArr);

        void e(String str, String str2, Object... objArr);

        void i(String str, String str2, Object... objArr);

        void printErrStackTrace(String str, Throwable th, String str2, Object... objArr);
    }

    public static void b(a aVar) {
        uNy = aVar;
    }

    public static void e(String str, String str2, Object... objArr) {
        if (uNy != null) {
            uNy.e(str, str2, objArr);
        }
    }

    public static void i(String str, String str2, Object... objArr) {
        if (uNy != null) {
            uNy.i(str, str2, objArr);
        }
    }

    public static void d(String str, String str2, Object... objArr) {
        if (uNy != null) {
            uNy.d(str, str2, objArr);
        }
    }

    public static void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
        if (uNy != null) {
            uNy.printErrStackTrace(str, th, str2, objArr);
        }
    }
}
