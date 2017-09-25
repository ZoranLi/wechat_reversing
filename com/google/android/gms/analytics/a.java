package com.google.android.gms.analytics;

import com.google.android.gms.analytics.internal.q;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class a extends c {
    private static List<Runnable> ahd = new ArrayList();
    public boolean ahe;
    public boolean ahf;
    private Set<Object> ahg = new HashSet();
    public boolean ahh;
    volatile boolean ahi;

    public a(q qVar) {
        super(qVar);
    }

    public static void ht() {
        synchronized (a.class) {
            if (ahd != null) {
                for (Runnable run : ahd) {
                    run.run();
                }
                ahd = null;
            }
        }
    }
}
