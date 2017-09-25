package com.tencent.mm.sdk.platformtools;

import android.os.Debug;
import android.os.Handler;
import android.os.Process;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class ak implements Runnable {
    private static final String utH;
    private static final String utI;
    long endTime;
    final Handler handler;
    long hpu;
    long lQB;
    final String mjV;
    int priority;
    boolean started = false;
    final Thread thread;
    final a utA;
    long utB;
    long utC;
    long utD;
    long utE;
    long utF;
    float utG = -1.0f;
    String utd;
    final Runnable uty;
    final Object utz;

    public interface a {
        void a(Runnable runnable, ak akVar);

        void a(Runnable runnable, Thread thread, long j, long j2, float f);
    }

    ak(Thread thread, Handler handler, Runnable runnable, Object obj, a aVar) {
        this.thread = thread;
        if (thread != null) {
            this.utd = thread.getName();
            this.lQB = thread.getId();
            this.priority = thread.getPriority();
        }
        this.handler = handler;
        this.uty = runnable;
        String name = runnable.getClass().getName();
        String obj2 = runnable.toString();
        if (!bg.mA(obj2)) {
            int indexOf = obj2.indexOf(124);
            if (indexOf > 0) {
                name = name + "_" + obj2.substring(indexOf + 1);
            }
        }
        this.mjV = name;
        this.utz = obj;
        this.utA = aVar;
        this.utB = System.currentTimeMillis();
    }

    public final void run() {
        new StringBuilder("/proc/self/task/").append(Process.myTid()).append("/stat");
        this.hpu = System.currentTimeMillis();
        this.utD = Debug.threadCpuTimeNanos();
        this.utE = -1;
        this.utF = -1;
        this.started = true;
        this.uty.run();
        this.utE = -1 - this.utE;
        this.utF = -1 - this.utF;
        this.endTime = System.currentTimeMillis();
        this.hpu = this.endTime - this.hpu;
        this.utD = (Debug.threadCpuTimeNanos() - this.utD) / 1000000;
        if (this.utF != 0) {
            this.utG = ((float) (100 * this.utE)) / ((float) this.utF);
        }
        if (this.utA != null) {
            this.utA.a(this.uty, this);
            this.utA.a(this, this.thread, this.hpu, this.utD, this.utG);
        }
    }

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("taskName = %s");
        stringBuilder.append("|token = %s");
        stringBuilder.append("|handler = %s");
        stringBuilder.append("|threadName = %s");
        stringBuilder.append("|threadId = %d");
        stringBuilder.append("|priority = %d");
        stringBuilder.append("|addTime = %d");
        stringBuilder.append("|delayTime = %d");
        stringBuilder.append("|usedTime = %d");
        stringBuilder.append("|cpuTime = %d");
        stringBuilder.append("|started = %b");
        utH = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append("taskName = %s");
        stringBuilder.append(" | addTime = %s");
        stringBuilder.append(" | endTime = %s");
        stringBuilder.append(" | usedTime = %d");
        stringBuilder.append(" | cpuTime = %d");
        stringBuilder.append(" | threadCpuTime = %d");
        stringBuilder.append(" | totalCpuTime = %d");
        stringBuilder.append(" | threadCpuRate = %.1f");
        utI = stringBuilder.toString();
    }

    public final String dump(boolean z) {
        if (z) {
            return String.format(utH, new Object[]{this.mjV, this.utz, this.handler, this.utd, Long.valueOf(this.lQB), Integer.valueOf(this.priority), Long.valueOf(this.utB), Long.valueOf(this.utC), Long.valueOf(this.hpu), Long.valueOf(this.utD), Boolean.valueOf(this.started)});
        }
        return String.format(utI, new Object[]{this.mjV, new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date(this.utB)), new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date(this.endTime)), Long.valueOf(this.hpu), Long.valueOf(this.utD), Long.valueOf(this.utE), Long.valueOf(this.utF), Float.valueOf(this.utG)});
    }
}
