package com.tencent.tinker.lib.e;

import android.util.Log;

public final class a {
    private static a xgP;
    private static a xgQ;

    public interface a {
        void d(String str, String str2, Object... objArr);

        void e(String str, String str2, Object... objArr);

        void i(String str, String str2, Object... objArr);

        void printErrStackTrace(String str, Throwable th, String str2, Object... objArr);

        void w(String str, String str2, Object... objArr);
    }

    static {
        a anonymousClass1 = new a() {
            public final void i(String str, String str2, Object... objArr) {
                if (objArr != null && objArr.length != 0) {
                    String.format(str2, objArr);
                }
            }

            public final void d(String str, String str2, Object... objArr) {
                if (objArr != null && objArr.length != 0) {
                    String.format(str2, objArr);
                }
            }

            public final void w(String str, String str2, Object... objArr) {
                if (objArr != null && objArr.length != 0) {
                    String.format(str2, objArr);
                }
            }

            public final void e(String str, String str2, Object... objArr) {
                if (objArr != null && objArr.length != 0) {
                    String.format(str2, objArr);
                }
            }

            public final void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
                String format = (objArr == null || objArr.length == 0) ? str2 : String.format(str2, objArr);
                if (format == null) {
                    format = "";
                }
                new StringBuilder().append(format).append("  ").append(Log.getStackTraceString(th));
            }
        };
        xgP = anonymousClass1;
        xgQ = anonymousClass1;
    }

    public static void a(a aVar) {
        xgQ = aVar;
    }

    public static void e(String str, String str2, Object... objArr) {
        if (xgQ != null) {
            xgQ.e(str, str2, objArr);
        }
    }

    public static void w(String str, String str2, Object... objArr) {
        if (xgQ != null) {
            xgQ.w(str, str2, objArr);
        }
    }

    public static void i(String str, String str2, Object... objArr) {
        if (xgQ != null) {
            xgQ.i(str, str2, objArr);
        }
    }

    public static void d(String str, String str2, Object... objArr) {
        if (xgQ != null) {
            xgQ.d(str, str2, objArr);
        }
    }

    public static void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
        if (xgQ != null) {
            xgQ.printErrStackTrace(str, th, str2, objArr);
        }
    }
}
