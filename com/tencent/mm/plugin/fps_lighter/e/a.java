package com.tencent.mm.plugin.fps_lighter.e;

import java.util.concurrent.TimeUnit;

public final class a {

    public enum a {
        GOOD,
        SLIGHT,
        BAD,
        MEDIUM,
        BEST
    }

    public static int b(long j, float f) {
        long convert = TimeUnit.MILLISECONDS.convert(j, TimeUnit.NANOSECONDS);
        if (((float) convert) > f) {
            return (int) Math.floor((double) (((float) convert) / f));
        }
        return 0;
    }

    public static a mE(int i) {
        a aVar = a.BEST;
        if (i >= 16) {
            return a.BAD;
        }
        if (i >= 8) {
            return a.MEDIUM;
        }
        if (i >= 4) {
            return a.SLIGHT;
        }
        if (i > 1) {
            return a.GOOD;
        }
        return aVar;
    }
}
