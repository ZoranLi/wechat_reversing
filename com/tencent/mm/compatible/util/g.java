package com.tencent.mm.compatible.util;

import android.os.SystemClock;

public final class g {

    public static class a {
        public long gSO = SystemClock.elapsedRealtime();

        public final long se() {
            return SystemClock.elapsedRealtime() - this.gSO;
        }
    }

    public static int sb() {
        return new Throwable().getStackTrace()[1].getLineNumber();
    }

    public static String sc() {
        return new Throwable().getStackTrace()[1].toString();
    }

    public static String sd() {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        return stackTraceElement.getMethodName().substring(stackTraceElement.getMethodName().lastIndexOf(46) + 1) + "(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ")";
    }
}
