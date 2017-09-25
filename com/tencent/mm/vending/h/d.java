package com.tencent.mm.vending.h;

import android.os.Looper;
import com.tencent.mm.vending.i.a;
import com.tencent.mm.vending.i.b;

public abstract class d {
    public static final h wDA = new h(Looper.getMainLooper(), "Vending.UI");
    public static final h wDB = new h(b.cbO().wDJ.getLooper(), "Vending.LOGIC");
    public static final h wDC = new h(a.cbN().ixE.getLooper(), "Vending.HEAVY_WORK");

    public abstract void ab(Runnable runnable);

    public abstract void cancel();

    public abstract String getType();

    public abstract void h(Runnable runnable, long j);

    static {
        g.cbM();
    }

    public static synchronized d cbL() {
        d cbL;
        synchronized (d.class) {
            cbL = g.cbL();
        }
        return cbL;
    }
}
