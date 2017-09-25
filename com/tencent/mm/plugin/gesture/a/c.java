package com.tencent.mm.plugin.gesture.a;

import java.lang.reflect.Array;

public final class c {
    private static c[][] mHR = ((c[][]) Array.newInstance(c.class, new int[]{3, 3}));
    public int kTI = 0;
    public int kTJ = 0;

    static {
        for (int i = 0; i < 3; i++) {
            for (int i2 = 0; i2 < 3; i2++) {
                mHR[i][i2] = new c(i, i2);
            }
        }
    }

    private c(int i, int i2) {
        this.kTI = i;
        this.kTJ = i2;
    }

    public static synchronized c ch(int i, int i2) {
        c cVar;
        synchronized (c.class) {
            if (i < 0 || i > 2) {
                throw new IllegalArgumentException("row id should be in range [0..2]");
            } else if (i2 < 0 || i2 > 2) {
                throw new IllegalArgumentException("col id should be in range [0..2]");
            } else {
                cVar = mHR[i][i2];
            }
        }
        return cVar;
    }

    public final String toString() {
        return String.format("{row: %d, col: %d}", new Object[]{Integer.valueOf(this.kTI), Integer.valueOf(this.kTJ)});
    }
}
