package com.tencent.mm.plugin.product.b;

import android.content.Context;
import com.tencent.mm.R;
import com.tencent.mm.protocal.c.qe;
import com.tencent.mm.sdk.platformtools.bg;

public final class b {
    public static String m(int i, int i2, String str) {
        if (i == i2) {
            return c((double) i, str);
        }
        return String.format("%s~%s", new Object[]{c((double) i2, str), c((double) i, str)});
    }

    public static String c(double d, String str) {
        if ("CNY".equals(str) || "1".equals(str) || bg.mA(str)) {
            return String.format("¥%.2f", new Object[]{Double.valueOf(d / 100.0d)});
        }
        return String.format("%s%.2f", new Object[]{str, Double.valueOf(d / 100.0d)});
    }

    public static String a(Context context, qe qeVar) {
        if (qeVar.tmm > 0) {
            return qeVar.msj + " " + c((double) qeVar.tmm, qeVar.tvh);
        }
        return context.getString(R.l.eAg);
    }
}
