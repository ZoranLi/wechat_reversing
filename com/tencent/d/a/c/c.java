package com.tencent.d.a.c;

import junit.framework.Assert;

public final class c {
    private static b wZz = new a();

    private static class a implements b {
        public final void v(String str, String str2, Object... objArr) {
            try {
                String.format(str2, objArr);
            } catch (Exception e) {
            }
        }

        public final void d(String str, String str2, Object... objArr) {
            try {
                String.format(str2, objArr);
            } catch (Exception e) {
            }
        }

        public final void i(String str, String str2, Object... objArr) {
            try {
                String.format(str2, objArr);
            } catch (Exception e) {
            }
        }

        public final void w(String str, String str2, Object... objArr) {
            try {
                String.format(str2, objArr);
            } catch (Exception e) {
            }
        }

        public final void e(String str, String str2, Object... objArr) {
            try {
                String.format(str2, objArr);
            } catch (Exception e) {
            }
        }

        public final void a(String str, Exception exception, String str2) {
        }
    }

    public static void a(b bVar) {
        Assert.assertTrue(bVar != null);
        wZz = bVar;
    }

    public static void v(String str, String str2, Object... objArr) {
        wZz.v(str, str2, objArr);
    }

    public static void d(String str, String str2, Object... objArr) {
        wZz.d(str, str2, objArr);
    }

    public static void i(String str, String str2, Object... objArr) {
        wZz.i(str, str2, objArr);
    }

    public static void w(String str, String str2, Object... objArr) {
        wZz.w(str, str2, objArr);
    }

    public static void e(String str, String str2, Object... objArr) {
        wZz.e(str, str2, objArr);
    }

    public static void a(String str, Exception exception, String str2) {
        wZz.a(str, exception, str2);
    }
}
