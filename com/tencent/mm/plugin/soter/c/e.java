package com.tencent.mm.plugin.soter.c;

import com.tencent.d.a.c.b;
import com.tencent.mm.sdk.platformtools.w;

public final class e implements b {
    public final void v(String str, String str2, Object... objArr) {
        w.v(str, str2, objArr);
    }

    public final void d(String str, String str2, Object... objArr) {
        w.d(str, str2, objArr);
    }

    public final void i(String str, String str2, Object... objArr) {
        w.i(str, str2, objArr);
    }

    public final void w(String str, String str2, Object... objArr) {
        w.w(str, str2, objArr);
    }

    public final void e(String str, String str2, Object... objArr) {
        w.e(str, str2, objArr);
    }

    public final void a(String str, Exception exception, String str2) {
        w.printErrStackTrace(str, exception, str2, new Object[0]);
    }
}
