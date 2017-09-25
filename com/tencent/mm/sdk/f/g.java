package com.tencent.mm.sdk.f;

import android.os.Debug;
import com.tencent.mm.sdk.f.e.b;
import junit.framework.Assert;

final class g implements Comparable<g>, Runnable {
    private static final String hWO;
    private static int uxP = 1000;
    long hpu;
    final String mjV;
    final int priority;
    boolean started = false;
    long utB;
    long utD;
    final Runnable uty;
    final boolean uxQ;
    b uxR;

    public final /* synthetic */ int compareTo(Object obj) {
        g gVar = (g) obj;
        int abs = (int) (Math.abs(System.currentTimeMillis() - this.utB) / ((long) uxP));
        int i = this.priority;
        if (abs > 0) {
            i += abs;
        }
        return gVar.priority - i;
    }

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("taskName = %s");
        stringBuilder.append("|priority = %d");
        stringBuilder.append("|pooled = %b");
        stringBuilder.append("|addTime = %d");
        stringBuilder.append("|usedTime = %d");
        stringBuilder.append("|cpuTime = %d");
        stringBuilder.append("|started = %b");
        hWO = stringBuilder.toString();
    }

    g(Runnable runnable, String str, int i, boolean z, b bVar) {
        Assert.assertNotNull("ThreadTask arg task is null!", runnable);
        Assert.assertNotNull("ThreadTask arg name is null!", str);
        this.uty = runnable;
        this.mjV = str;
        this.priority = i;
        this.uxQ = z;
        this.utB = System.currentTimeMillis();
        this.uxR = bVar;
    }

    public final void run() {
        this.hpu = System.currentTimeMillis();
        this.utD = Debug.threadCpuTimeNanos();
        this.started = true;
        this.uty.run();
        this.hpu = System.currentTimeMillis() - this.hpu;
        this.utD = Debug.threadCpuTimeNanos() - this.utD;
    }

    public final String toString() {
        return String.format(hWO, new Object[]{this.mjV, Integer.valueOf(this.priority), Boolean.valueOf(this.uxQ), Long.valueOf(this.utB), Long.valueOf(this.hpu), Long.valueOf(this.utD), Boolean.valueOf(this.started)});
    }
}
