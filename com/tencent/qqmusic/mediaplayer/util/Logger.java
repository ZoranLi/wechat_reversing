package com.tencent.qqmusic.mediaplayer.util;

import com.tencent.qqmusic.mediaplayer.ILog;

public class Logger {
    private static ILog mILog = null;

    public static void setLog(ILog iLog) {
        mILog = iLog;
    }

    public static void d(String str, String str2) {
        if (mILog != null) {
            mILog.d(str, str2);
        }
    }

    public static void w(String str, String str2) {
        if (mILog != null) {
            mILog.w(str, str2);
        }
    }

    public static void e(String str, String str2) {
        if (mILog != null) {
            mILog.e(str, str2);
        }
    }

    public static void i(String str, String str2) {
        if (mILog != null) {
            mILog.i(str, str2);
        }
    }

    public static void e(String str, Throwable th) {
        if (mILog != null) {
            mILog.e(str, th);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        if (mILog != null) {
            mILog.e(str, str2, th);
        }
    }

    public static void e(String str, String str2, Object... objArr) {
        if (mILog != null) {
            mILog.e(str, str2, objArr);
        }
    }

    public static void i(String str, String str2, Throwable th) {
        if (mILog != null) {
            mILog.i(str, str2, th);
        }
    }
}
