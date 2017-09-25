package com.tencent.wework.api.utils;

public class Log {
    private static int wOT = 8;
    private static ILogger xme = new WWAPILogger(new LogcatLogger());

    public interface ILogger {
        void a(int i, String str, String str2, Throwable th);
    }

    private static class LogcatLogger implements ILogger {
        public final void a(int i, String str, String str2, Throwable th) {
        }
    }

    private static class WWAPILogger implements ILogger {
        ILogger xmf;

        WWAPILogger(ILogger iLogger) {
            this.xmf = iLogger;
        }

        public final void a(int i, String str, String str2, Throwable th) {
            this.xmf.a(i, "WWAPI-" + str, str2, th);
        }
    }

    public static void d(String str, String str2) {
        if (wOT <= 3) {
            xme.a(3, str, str2, null);
        }
    }

    public static void i(String str, String str2) {
        if (wOT <= 4) {
            xme.a(4, str, str2, null);
        }
    }

    public static void w(String str, String str2) {
        if (wOT <= 5) {
            xme.a(5, str, str2, null);
        }
    }

    public static void b(String str, String str2, Throwable th) {
        if (wOT <= 5) {
            xme.a(5, str, str2, th);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        if (wOT <= 6) {
            xme.a(6, str, str2, th);
        }
    }
}
