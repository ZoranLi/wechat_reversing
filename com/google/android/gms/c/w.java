package com.google.android.gms.c;

import android.os.SystemClock;

public final class w implements v {
    private static w aAm;

    public static synchronized v kV() {
        v vVar;
        synchronized (w.class) {
            if (aAm == null) {
                aAm = new w();
            }
            vVar = aAm;
        }
        return vVar;
    }

    public final long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    public final long elapsedRealtime() {
        return SystemClock.elapsedRealtime();
    }
}
