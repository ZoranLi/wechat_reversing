package com.tencent.mm.plugin.appbrand.dynamic.b;

import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class a {
    private static a iGY;
    private Map<String, SoftReference<WxaPkgWrappingInfo>> iGX = new ConcurrentHashMap();

    private static a RS() {
        if (iGY == null) {
            synchronized (a.class) {
                if (iGY == null) {
                    iGY = new a();
                }
            }
        }
        return iGY;
    }

    private a() {
    }

    public static boolean a(String str, WxaPkgWrappingInfo wxaPkgWrappingInfo) {
        if (str == null || str.length() == 0 || wxaPkgWrappingInfo == null) {
            return false;
        }
        RS().iGX.put(str, new SoftReference(wxaPkgWrappingInfo));
        return true;
    }

    public static WxaPkgWrappingInfo oA(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        SoftReference softReference = (SoftReference) RS().iGX.get(str);
        return softReference != null ? (WxaPkgWrappingInfo) softReference.get() : null;
    }

    public static void removeAll() {
        RS().iGX.clear();
    }
}
