package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import java.io.InputStream;

public final class e {
    private static Boolean iyG = null;

    public static InputStream openRead(String str) {
        InputStream nB;
        String nA = a.nA(str);
        if (iyG == null) {
            ab.bIY();
            iyG = Boolean.valueOf(false);
        }
        if (iyG.booleanValue()) {
            nB = nB("wxa_library/local" + nA);
            if (nB != null) {
                return nB;
            }
            nB = nB("wxa_library/develop" + nA);
            if (nB != null) {
                return nB;
            }
        }
        nB = nB("wxa_library" + nA);
        return nB == null ? null : nB;
    }

    private static InputStream nB(String str) {
        try {
            return ab.getContext().getAssets().open(str);
        } catch (Exception e) {
            w.v("MicroMsg.AppBrand.WxaLocalLibPkg", "openRead file( %s ) failed, exp = %s", new Object[]{str, e});
            return null;
        }
    }

    public static WxaPkgWrappingInfo Qf() {
        WxaPkgWrappingInfo wxaPkgWrappingInfo = new WxaPkgWrappingInfo();
        wxaPkgWrappingInfo.iAd = true;
        wxaPkgWrappingInfo.izW = 48;
        wxaPkgWrappingInfo.izY = true;
        return wxaPkgWrappingInfo;
    }
}
