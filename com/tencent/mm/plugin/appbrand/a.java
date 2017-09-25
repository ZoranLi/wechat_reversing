package com.tencent.mm.plugin.appbrand;

import com.tencent.mm.plugin.appbrand.e.c;
import java.util.HashMap;
import java.util.Map;

@Deprecated
public final class a {
    private static Map<String, a> ivG = new HashMap();
    public String ivH;

    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] ivI = new int[c.values().length];

        static {
            ivJ = new int[com.tencent.mm.plugin.appbrand.a.a.values().length];
            try {
                ivJ[com.tencent.mm.plugin.appbrand.a.a.SUSPEND.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                ivJ[com.tencent.mm.plugin.appbrand.a.a.DESTROYED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                ivI[c.BACK.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                ivI[c.CLOSE.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public static a mV(String str) {
        a aVar = (a) ivG.get(str);
        if (aVar == null) {
            synchronized (ivG) {
                aVar = (a) ivG.get(str);
                if (aVar == null) {
                    aVar = new a(str);
                    ivG.put(str, aVar);
                }
            }
        }
        return aVar;
    }

    private a(String str) {
        this.ivH = str;
    }

    public static boolean Pm() {
        return true;
    }

    public final boolean Pn() {
        h mW = b.mW(this.ivH);
        if (mW == null) {
            return true;
        }
        switch (mW.iwC.iAk.QD()) {
            case SUSPEND:
            case DESTROYED:
                return true;
            default:
                return false;
        }
    }
}
