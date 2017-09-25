package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.Locale;

final class o extends d {
    private static String c(String str, String str2, int i, int i2) {
        return String.format(Locale.US, "WxaPage_%s_%d_%d_%d", new Object[]{str2, Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(str.hashCode())});
    }

    o(String str, String str2, int i, int i2) {
        String c = c(str, str2, i, i2);
        String c2 = c(str, str2, i, i2);
        super(c, g.Qj() + String.format("_%s.wxapkg", new Object[]{c2}), str, str2, i, i2);
    }

    public final int Qk() {
        return 640;
    }

    public final boolean Ql() {
        return false;
    }

    public final boolean Qm() {
        return true;
    }

    public final void hw(int i) {
        int i2;
        if (i <= 1000) {
            i2 = 0;
        } else if (i <= MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN) {
            i2 = 1;
        } else if (i <= 3000) {
            i2 = 2;
        } else if (i <= 4000) {
            i2 = 3;
        } else if (i <= Downloads.MIN_RETYR_AFTER) {
            i2 = 4;
        } else {
            i2 = 5;
        }
        g.oUh.a(665, (long) i2, 1, false);
    }
}
