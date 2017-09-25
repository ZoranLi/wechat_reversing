package com.tencent.mm.app;

import android.app.Application;
import com.tencent.mm.R;
import com.tencent.mm.kiss.a.b;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.svg.a.e;
import com.tencent.mm.svg.b.c.a;

public final class m {
    private static Class<?> fwX = null;
    private static String fwY = null;

    public static void d(Class<?> cls) {
        fwX = cls;
    }

    public static void bl(String str) {
        fwY = str;
    }

    public static void a(Application application) {
        boolean z = true;
        w.i("MicroMsg.SVGInit", "SVG initSVGPreload");
        e.a(new a() {
            public final void i(String str, String str2, Object... objArr) {
                w.i(str, str2, objArr);
            }

            public final void e(String str, String str2, Object... objArr) {
                w.e(str, str2, objArr);
            }

            public final void d(String str, String str2, Object... objArr) {
                w.d(str, str2, objArr);
            }

            public final void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
                w.printErrStackTrace(str, th, str2, objArr);
            }
        });
        e.d(fwX);
        e.b(application, fwY);
        try {
            boolean z2 = application.getBaseContext().getResources().getDrawable(R.k.dsO) != null;
            b vS = b.vS();
            if (z2) {
                z = false;
            }
            vS.gZO = z;
        } catch (Throwable th) {
            w.printErrStackTrace("MicroMsg.SVGInit", th, "not support get svg from application context", new Object[0]);
        } finally {
            b.vS().gZO = true;
        }
    }
}
