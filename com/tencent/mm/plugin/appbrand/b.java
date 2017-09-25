package com.tencent.mm.plugin.appbrand;

import android.support.v4.app.a.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.ui.e;
import com.tencent.mm.sdk.platformtools.bg;
import java.util.HashMap;
import java.util.Map;

public final class b {
    private static final Map<String, h> ivK = new HashMap();
    private static Map<String, a> ivL = new HashMap();
    private static Map<String, AppBrandStatObject> ivM = new HashMap();
    private static Map<String, e> ivN = new HashMap();

    public static void a(String str, h hVar) {
        if (!bg.mA(str)) {
            synchronized (ivK) {
                ivK.put(str, hVar);
            }
        }
    }

    public static h mW(String str) {
        if (bg.mA(str)) {
            return null;
        }
        h hVar;
        synchronized (ivK) {
            hVar = (h) ivK.get(str);
        }
        return hVar;
    }

    public static void a(String str, a aVar) {
        ivL.put(str, aVar);
    }

    public static void a(String str, int i, String[] strArr, int[] iArr) {
        if (ivL.containsKey(str)) {
            ((a) ivL.get(str)).onRequestPermissionsResult(i, strArr, iArr);
            ivL.remove(str);
        }
    }

    public static void mX(String str) {
        ivL.remove(str);
    }

    public static AppBrandSysConfig mY(String str) {
        return mW(str) == null ? null : mW(str).iwo;
    }

    public static void a(AppBrandStatObject appBrandStatObject) {
        ivM.put(appBrandStatObject.appId, appBrandStatObject);
    }

    public static AppBrandStatObject mZ(String str) {
        return (AppBrandStatObject) ivM.get(str);
    }

    public static void a(String str, e eVar) {
        ivN.put(str, eVar);
    }

    public static e na(String str) {
        return (e) ivN.get(str);
    }

    public static void nb(String str) {
        ivN.remove(str);
    }
}
