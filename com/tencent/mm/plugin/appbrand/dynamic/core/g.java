package com.tencent.mm.plugin.appbrand.dynamic.core;

import com.tencent.mm.sdk.platformtools.bg;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class g {
    private static final Map<String, MiniJsApiFwContext> iHC = new ConcurrentHashMap();

    public static boolean a(String str, MiniJsApiFwContext miniJsApiFwContext) {
        if (bg.mA(str) || miniJsApiFwContext == null) {
            return false;
        }
        iHC.put(str, miniJsApiFwContext);
        return true;
    }

    public static MiniJsApiFwContext oC(String str) {
        if (bg.mA(str)) {
            return null;
        }
        return (MiniJsApiFwContext) iHC.get(str);
    }

    public static MiniJsApiFwContext oD(String str) {
        if (bg.mA(str)) {
            return null;
        }
        return (MiniJsApiFwContext) iHC.remove(str);
    }
}
