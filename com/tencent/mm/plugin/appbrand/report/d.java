package com.tencent.mm.plugin.appbrand.report;

import com.tencent.mm.compatible.util.p;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class d {
    private static String qF(String str) {
        if (bg.mA(str)) {
            return "";
        }
        try {
            return bg.mz(p.encode(str));
        } catch (Exception e) {
            w.e("MicroMsg.AppBrand.ReportUtil", "safeEncode, given %s, e %s", new Object[]{str, e});
            return "";
        }
    }

    public static Object[] g(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return new Object[0];
        }
        Object[] objArr2 = new Object[objArr.length];
        int length = objArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            Object obj = objArr[i];
            if (obj == null) {
                obj = "";
            } else if ((obj instanceof String) && (((String) obj).contains(",") || ((String) obj).contains("/"))) {
                obj = qF((String) obj);
            }
            int i3 = i2 + 1;
            objArr2[i2] = String.valueOf(obj);
            i++;
            i2 = i3;
        }
        return objArr2;
    }
}
