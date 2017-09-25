package com.tencent.mm.plugin.appbrand.g;

import com.tencent.mm.plugin.appbrand.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.e;

public final class f extends e {
    private static final int CTRL_INDEX = -2;
    private static final String NAME = "onAppRunningStatusChange";

    static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] ivJ = new int[a.values().length];

        static {
            try {
                ivJ[a.BACKGROUND.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                ivJ[a.FOREGROUND.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                ivJ[a.SUSPEND.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                ivJ[a.DESTROYED.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }
}
