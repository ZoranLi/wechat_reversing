package com.tencent.mm.vending.h;

import android.os.Looper;
import com.tencent.mm.vending.f.a;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public class g {
    private static Map<String, d> wDE = new ConcurrentHashMap();
    private static Map<Looper, d> wDF = new HashMap();
    private static boolean wDG = false;

    static {
        cbM();
    }

    public static void a(String str, d dVar) {
        Assert.assertNotNull("Scheduler type is null", str);
        String toUpperCase = str.toUpperCase();
        if (wDE.containsKey(toUpperCase)) {
            IllegalStateException illegalStateException = new IllegalStateException("Fatal error! Duplicate scheduler type " + str.toUpperCase());
        }
        wDE.put(toUpperCase, dVar);
        if (dVar instanceof h) {
            synchronized (g.class) {
                wDF.put(((h) dVar).aLd, dVar);
            }
        }
    }

    public static void UC(String str) {
        wDE.remove(str.toUpperCase());
    }

    public static d UD(String str) {
        Assert.assertNotNull("Scheduler type is null", str);
        d dVar = (d) wDE.get(str.toUpperCase());
        Assert.assertNotNull("Scheduler type not found: " + str.toUpperCase(), dVar);
        return dVar;
    }

    public static synchronized d cbL() {
        d cVar;
        synchronized (g.class) {
            Looper myLooper = Looper.myLooper();
            if (myLooper == null) {
                a.w("Vending.SchedulerProvider", "This is not a handler thread! %s", Thread.currentThread());
                cVar = new c();
            } else {
                cVar = (d) wDF.get(myLooper);
                if (cVar == null) {
                    cVar = new h(myLooper, myLooper.toString());
                    wDF.put(myLooper, cVar);
                }
            }
        }
        return cVar;
    }

    static synchronized void cbM() {
        synchronized (g.class) {
            if (!wDG) {
                a.i("Vending.SchedulerProvider", "SchedulerProvider provided.", new Object[0]);
                wDG = true;
                a("Vending.UI", d.wDA);
                a("Vending.LOGIC", d.wDB);
                a("Vending.HEAVY_WORK", d.wDC);
            }
        }
    }
}
