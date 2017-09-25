package com.tencent.mm.app;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.util.Base64;
import android.util.Pair;
import com.tencent.mm.compatible.d.o;
import com.tencent.mm.kernel.h;
import com.tencent.mm.loader.stub.BaseBuildInfo;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.io.File;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a {
    public static boolean fvA = true;
    public static boolean fvB = false;
    public static Thread fvC;
    public static String fvD = "";
    public static int fvp = 0;
    public static int fvq = 0;
    public static o fvr = new o((long) Process.myPid());
    private static final b fvs = new b() {
        public final void b(a aVar) {
            int i = ab.getContext().getSharedPreferences("system_config_prefs", 4).getInt("main_thread_watch_report", 0);
            String str = "MicroMsg.ANRWatchDog.summeranr";
            String str2 = "summeranr onAppNotResponding error reportFlag[%b]";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(i > 0);
            w.w(str, str2, objArr);
            try {
                String a = a.a(aVar);
                if (i > 0) {
                    com.tencent.mm.sdk.a.b.r(Base64.encodeToString(a.getBytes(), 2), "main_thread_watch");
                } else {
                    g.oUh.a(510, 14, 1, true);
                }
            } catch (OutOfMemoryError e) {
                w.e("MicroMsg.ANRWatchDog.summeranr", "summeranr buildReport OutOfMemory %s", e.getMessage());
                System.gc();
                g.oUh.a(510, 15, 1, true);
            }
        }
    };
    private static final d fvt = new d() {
        public final void a(InterruptedException interruptedException) {
            w.w("MicroMsg.ANRWatchDog.summeranr", "summeranr DEFAULT_INTERRUPTION_LISTENER onInterrupted exception.getMessage[%s]", interruptedException.getMessage());
        }
    };
    public static b fvu = fvs;
    public static d fvv = fvt;
    public static Handler fvw;
    public static int fvx = 4500;
    public static int fvy = 500;
    public static String fvz = "";

    static class a extends Error {
        LinkedList<Pair<Thread, StackTraceElement[]>> fvE;

        static class a implements Serializable {
            public final StackTraceElement[] fvG;
            public final String name;

            class a extends Throwable {
                final /* synthetic */ a fvH;

                private a(com.tencent.mm.app.a.a.a r2, com.tencent.mm.app.a.a.a.a r3) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
                    /*
                    r1 = this;
                    r1.fvH = r2;
                    r0 = r2.name;
                    r1.<init>(r0, r3);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.app.a.a.a.a.<init>(com.tencent.mm.app.a$a$a, com.tencent.mm.app.a$a$a$a):void");
                }

                public final java.lang.Throwable fillInStackTrace() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
                    /*
                    r1 = this;
                    r0 = r1.fvH;
                    r0 = r0.fvG;
                    r1.setStackTrace(r0);
                    return r1;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.app.a.a.a.a.fillInStackTrace():java.lang.Throwable");
                }
            }

            public a(java.lang.String r1, java.lang.StackTraceElement[] r2) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
                /*
                r0 = this;
                r0.<init>();
                r0.name = r1;
                r0.fvG = r2;
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.app.a.a.a.<init>(java.lang.String, java.lang.StackTraceElement[]):void");
            }
        }

        private a(com.tencent.mm.app.a.a.a.a r2, java.util.LinkedList<android.util.Pair<java.lang.Thread, java.lang.StackTraceElement[]>> r3) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r1 = this;
            r0 = "Application Not Responding";
            r1.<init>(r0, r2);
            r1.fvE = r3;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.app.a.a.<init>(com.tencent.mm.app.a$a$a$a, java.util.LinkedList):void");
        }

        public final java.lang.Throwable fillInStackTrace() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r0 = this;
            super.fillInStackTrace();
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.app.a.a.fillInStackTrace():java.lang.Throwable");
        }

        static com.tencent.mm.app.a.a g(java.lang.String r11, boolean r12) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r10 = 0;
            r0 = android.os.Looper.getMainLooper();
            r2 = r0.getThread();
            r4 = new java.util.LinkedList;
            r4.<init>();
            r3 = new java.util.TreeMap;
            r0 = new com.tencent.mm.app.a$a$1;
            r0.<init>(r2);
            r3.<init>(r0);
            r0 = java.lang.Thread.getAllStackTraces();
            r0 = r0.entrySet();
            r5 = r0.iterator();
        L_0x0024:
            r0 = r5.hasNext();
            if (r0 == 0) goto L_0x008f;
        L_0x002a:
            r0 = r5.next();
            r0 = (java.util.Map.Entry) r0;
            r1 = r0.getKey();
            if (r1 == r2) goto L_0x0051;
        L_0x0036:
            r1 = r0.getKey();
            r1 = (java.lang.Thread) r1;
            r1 = r1.getName();
            r1 = r1.startsWith(r11);
            if (r1 == 0) goto L_0x0024;
        L_0x0046:
            if (r12 != 0) goto L_0x0051;
        L_0x0048:
            r1 = r0.getValue();
            r1 = (java.lang.StackTraceElement[]) r1;
            r1 = r1.length;
            if (r1 <= 0) goto L_0x0024;
        L_0x0051:
            r1 = r0.getValue();
            if (r1 == 0) goto L_0x0024;
        L_0x0057:
            r1 = r0.getValue();
            r1 = (java.lang.StackTraceElement[]) r1;
            r1 = r1.length;
            if (r1 <= 0) goto L_0x0024;
        L_0x0060:
            r1 = r0.getKey();
            r6 = r0.getValue();
            r3.put(r1, r6);
            r1 = r0.getKey();
            if (r1 != r2) goto L_0x007e;
        L_0x0071:
            r1 = new android.util.Pair;
            r0 = r0.getValue();
            r1.<init>(r2, r0);
            r4.addFirst(r1);
            goto L_0x0024;
        L_0x007e:
            r1 = new android.util.Pair;
            r6 = r0.getKey();
            r0 = r0.getValue();
            r1.<init>(r6, r0);
            r4.addLast(r1);
            goto L_0x0024;
        L_0x008f:
            r0 = r3.containsKey(r2);
            if (r0 != 0) goto L_0x00c5;
        L_0x0095:
            r0 = "MicroMsg.ANRError";
            r1 = "summeranr getAllStackTraces not return mainthread[%s, %d] put in now";
            r5 = 2;
            r5 = new java.lang.Object[r5];
            r6 = r2.getName();
            r5[r10] = r6;
            r6 = 1;
            r8 = r2.getId();
            r7 = java.lang.Long.valueOf(r8);
            r5[r6] = r7;
            com.tencent.mm.sdk.platformtools.w.i(r0, r1, r5);
            r0 = r2.getStackTrace();
            r3.put(r2, r0);
            r0 = new android.util.Pair;
            r1 = r2.getStackTrace();
            r0.<init>(r2, r1);
            r4.addFirst(r0);
        L_0x00c5:
            r0 = 0;
            r1 = r3.entrySet();
            r5 = r1.iterator();
            r2 = r0;
        L_0x00cf:
            r0 = r5.hasNext();
            if (r0 == 0) goto L_0x00fa;
        L_0x00d5:
            r0 = r5.next();
            r0 = (java.util.Map.Entry) r0;
            r3 = new com.tencent.mm.app.a$a$a$a;
            r6 = new com.tencent.mm.app.a$a$a;
            r1 = r0.getKey();
            r1 = (java.lang.Thread) r1;
            r1 = a(r1);
            r0 = r0.getValue();
            r0 = (java.lang.StackTraceElement[]) r0;
            r6.<init>(r1, r0);
            r6.getClass();
            r3.<init>(r6, r2, r10);
            r2 = r3;
            goto L_0x00cf;
        L_0x00fa:
            r0 = new com.tencent.mm.app.a$a;
            r0.<init>(r2, r4);
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.app.a.a.g(java.lang.String, boolean):com.tencent.mm.app.a$a");
        }

        static com.tencent.mm.app.a.a nY() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r6 = 0;
            r0 = android.os.Looper.getMainLooper();
            r1 = r0.getThread();
            r2 = r1.getStackTrace();
            if (r2 != 0) goto L_0x004f;
        L_0x000f:
            r0 = -1;
        L_0x0010:
            r3 = "MicroMsg.ANRError";
            r4 = "summeranr NewMainOnly mainStackTrace size[%d]";
            r5 = 1;
            r5 = new java.lang.Object[r5];
            r0 = java.lang.Integer.valueOf(r0);
            r5[r6] = r0;
            com.tencent.mm.sdk.platformtools.w.i(r3, r4, r5);
            r0 = new java.util.TreeMap;
            r0.<init>();
            r0.put(r1, r2);
            r0 = new java.util.LinkedList;
            r0.<init>();
            r3 = new android.util.Pair;
            r3.<init>(r1, r2);
            r0.addFirst(r3);
            r3 = new com.tencent.mm.app.a$a;
            r4 = new com.tencent.mm.app.a$a$a$a;
            r5 = new com.tencent.mm.app.a$a$a;
            r1 = a(r1);
            r5.<init>(r1, r2);
            r5.getClass();
            r1 = 0;
            r4.<init>(r5, r1, r6);
            r3.<init>(r4, r0);
            return r3;
        L_0x004f:
            r0 = r2.length;
            goto L_0x0010;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.app.a.a.nY():com.tencent.mm.app.a$a");
        }

        private static java.lang.String a(java.lang.Thread r4) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r0 = new java.lang.StringBuilder;
            r0.<init>();
            r1 = r4.getName();
            r0 = r0.append(r1);
            r1 = " (prio:";
            r0 = r0.append(r1);
            r1 = r4.getPriority();
            r0 = r0.append(r1);
            r1 = " tid:";
            r0 = r0.append(r1);
            r2 = r4.getId();
            r0 = r0.append(r2);
            r1 = " state:";
            r0 = r0.append(r1);
            r1 = r4.getState();
            r0 = r0.append(r1);
            r1 = ")";
            r0 = r0.append(r1);
            r0 = r0.toString();
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.app.a.a.a(java.lang.Thread):java.lang.String");
        }
    }

    public interface b {
        void b(a aVar);
    }

    static class c implements Runnable {
        public volatile int fvI = 0;
        private final Runnable fvJ = new Runnable(this) {
            final /* synthetic */ c fvK;

            {
                this.fvK = r1;
            }

            public final void run() {
                this.fvK.fvI = (this.fvK.fvI + 1) % Integer.MAX_VALUE;
                if (this.fvK.fvI % a.fvy == 0) {
                    SharedPreferences sharedPreferences = ab.getContext().getSharedPreferences("system_config_prefs", 4);
                    int i = sharedPreferences.getInt("main_thread_watch_enable", 65535);
                    int i2 = sharedPreferences.getInt("main_thread_watch_timeout", 0);
                    int i3 = sharedPreferences.getInt("main_thread_watch_log_loop", 0);
                    int i4 = sharedPreferences.getInt("main_thread_watch_report", 0);
                    w.i("MicroMsg.ANRWatchDog.summeranr", "summeranr ticker tname[%s], tick[%d] enable[%d], timeout[%d], loop[%d], report[%d]", Thread.currentThread().getName(), Integer.valueOf(this.fvK.fvI), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
                    if (a.g(a.fvD, i)) {
                        if (i2 > 0 && i2 != a.fvx) {
                            w.i("MicroMsg.ANRWatchDog.summeranr", "summeranr reset timeout[%d, %d] by new setting", Integer.valueOf(a.fvx), Integer.valueOf(i2));
                            a.fvx = i2;
                        }
                        if (i3 > 0 && i3 != a.fvy) {
                            w.i("MicroMsg.ANRWatchDog.summeranr", "summeranr reset loop[%d, %d] by new setting", Integer.valueOf(a.fvy), Integer.valueOf(i3));
                            a.fvy = i3;
                            return;
                        }
                        return;
                    }
                    g.oUh.a(510, 12, 1, true);
                    if (a.fvC != null) {
                        a.fvC.interrupt();
                    }
                    w.i("MicroMsg.ANRWatchDog.summeranr", "summeranr disable by new setting and interrupt watch");
                }
            }
        };

        c() {
        }

        public final void run() {
            g.oUh.a(510, 0, 1, true);
            w.i("MicroMsg.ANRWatchDog.summeranr", "summeranr ANRWatchDog run thread[%s]", Thread.currentThread());
            int i = -1;
            while (!r10.isInterrupted()) {
                int i2 = this.fvI;
                a.fvw.post(this.fvJ);
                try {
                    Thread.sleep((long) a.fvx);
                    if (this.fvI == i2) {
                        if (a.fvB || !Debug.isDebuggerConnected()) {
                            a g;
                            a.fvw.removeCallbacks(this.fvJ);
                            long ry = (long) a.fvr.ry();
                            long rz = (long) a.fvr.rz();
                            long rx = (long) a.fvr.rx();
                            w.i("MicroMsg.ANRWatchDog.summeranr", "summeranr ANRWatchDog run thread detect anr CpuUsage[%d, %d, %d]", Long.valueOf(ry), Long.valueOf(rz), Long.valueOf(rx));
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                w.i("MicroMsg.ANRWatchDog.summeranr", "summeranr ANRWatchDog run thread detect anr wait for GetCpuUsage interrupted[%b]", Boolean.valueOf(r10.isInterrupted()));
                            }
                            w.i("MicroMsg.ANRWatchDog.summeranr", "summeranr ANRWatchDog run thread detect anr new sThreadNamePrefix[%s],lastTick tick[%d, %d], current[%d]", a.fvz, Integer.valueOf(i2), Integer.valueOf(this.fvI), Long.valueOf(System.currentTimeMillis()));
                            if (a.fvz != null) {
                                g = a.g(a.fvz, a.fvA);
                            } else {
                                g = a.nY();
                            }
                            g.oUh.a(510, 1, 1, true);
                            switch (a.fvp) {
                                case 1:
                                    g.oUh.a(510, 2, 1, true);
                                    break;
                                case 2:
                                    g.oUh.a(510, 3, 1, true);
                                    break;
                                case 4:
                                    g.oUh.a(510, 4, 1, true);
                                    break;
                                case 8:
                                    g.oUh.a(510, 5, 1, true);
                                    break;
                                case 16:
                                    g.oUh.a(510, 6, 1, true);
                                    break;
                                case 32:
                                    g.oUh.a(510, 13, 1, true);
                                    break;
                            }
                            if (a.fvq > 0) {
                                g.oUh.a(510, 7, 1, true);
                            }
                            a.fvu.b(g);
                            i2 = a.fvq + 1;
                            a.fvq = i2;
                            if (i2 >= 10) {
                                a.fvq = 1;
                            }
                            ry = (long) (((a.cQ(a.fvq) * 5) * 60) * 1000);
                            this.fvI = 0;
                            w.i("MicroMsg.ANRWatchDog.summeranr", "summeranr ANRWatchDog run thread set next detect sFibIndex[%d], sleepTime[%d], lastTick, tick[%d, %d]", Integer.valueOf(a.fvq), Long.valueOf(ry), Integer.valueOf(0), Integer.valueOf(this.fvI));
                            try {
                                Thread.sleep(ry);
                                w.i("MicroMsg.ANRWatchDog.summeranr", "summeranr ANRWatchDog run thread set next detect sFibIndex[%d], sleepTime[%d], lastTick, tick[%d, %d] wakeup", Integer.valueOf(a.fvq), Long.valueOf(ry), Integer.valueOf(0), Integer.valueOf(this.fvI));
                            } catch (InterruptedException e2) {
                                a.fvv.a(e2);
                                w.i("MicroMsg.ANRWatchDog.summeranr", "summeranr ANRWatchDog run thread sleep and interrupted when wait for next detect[%b]", Boolean.valueOf(r10.isInterrupted()));
                                return;
                            }
                        }
                        if (this.fvI != i) {
                            w.w("MicroMsg.ANRWatchDog.summeranr", "summeranr An ANR was detected but ignored because the debugger is connected (you can prevent this with setIgnoreDebugger(true))");
                        }
                        i = this.fvI;
                    }
                } catch (InterruptedException e22) {
                    a.fvv.a(e22);
                    w.i("MicroMsg.ANRWatchDog.summeranr", "summeranr ANRWatchDog run thread sleep and interrupted[%b]", Boolean.valueOf(r10.isInterrupted()));
                    return;
                }
            }
            w.i("MicroMsg.ANRWatchDog.summeranr", "summeranr ANRWatchDog run thread isInterrupted[%b]", Boolean.valueOf(r10.isInterrupted()));
        }
    }

    public interface d {
        void a(InterruptedException interruptedException);
    }

    public static boolean g(String str, int i) {
        if (bg.mA(str)) {
            return false;
        }
        if (str.equals(ab.getPackageName())) {
            fvp = 1;
            if ((i & 1) != 0) {
                return true;
            }
            return false;
        } else if (str.endsWith(":push")) {
            fvp = 2;
            if ((i & 2) != 0) {
                return true;
            }
            return false;
        } else if (str.endsWith(":tools")) {
            fvp = 4;
            if ((i & 4) != 0) {
                return true;
            }
            return false;
        } else if (str.endsWith(":sandbox")) {
            fvp = 8;
            if ((i & 8) != 0) {
                return true;
            }
            return false;
        } else if (str.endsWith(":exdevice")) {
            fvp = 16;
            if ((i & 16) != 0) {
                return true;
            }
            return false;
        } else if (!str.contains(":appbrand")) {
            return false;
        } else {
            fvp = 32;
            if ((i & 32) != 0) {
                return true;
            }
            return false;
        }
    }

    public static void be(String str) {
        SharedPreferences sharedPreferences = ab.getContext().getSharedPreferences("system_config_prefs", 4);
        int i = sharedPreferences.getInt("main_thread_watch_enable", 65535);
        int i2 = sharedPreferences.getInt("main_thread_watch_timeout", 0);
        int i3 = sharedPreferences.getInt("main_thread_watch_log_loop", 0);
        int i4 = sharedPreferences.getInt("main_thread_watch_report", 0);
        if (g(str, i)) {
            if (i2 <= 0) {
                i2 = 4500;
            }
            if (i3 <= 0) {
                i3 = 500;
            }
            if (fvC != null) {
                fvC.interrupt();
            }
            fvD = str;
            if (i2 > 0) {
                fvx = i2;
            }
            if (i3 > 0) {
                fvy = i3;
            }
            fvC = e.b(new c(), str + "_ANRWatchDog");
            if (fvw == null) {
                fvw = new Handler(Looper.getMainLooper());
            }
            fvC.start();
            w.i("MicroMsg.ANRWatchDog.summeranr", "summeranr startWatch sProcessName[%s], sTimeoutInterval[%d], logLoop[%d], sWatchThread[%s], stack[%s]", fvD, Integer.valueOf(fvx), Integer.valueOf(fvy), fvC.getName(), bg.bJZ());
        }
        w.i("MicroMsg.ANRWatchDog.summeranr", "summeranr startWatch processName[%s] enable[%d], timeout[%d], loop[%d], report[%d]", str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
    }

    public static String a(a aVar) {
        String substring;
        JSONObject jSONObject = new JSONObject();
        try {
            int i;
            JSONObject jSONObject2 = new JSONObject();
            jSONObject.put("head", jSONObject2);
            jSONObject2.put("protocol_ver", new Integer(1));
            jSONObject2.put("phone", new String(Build.MODEL));
            jSONObject2.put("os_ver", new String("android-" + VERSION.SDK_INT));
            JSONObject jSONObject3 = new JSONObject();
            jSONObject.put("items", jSONObject3);
            jSONObject3.put("tag", "main_thread_watch");
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject4 = new JSONObject();
            jSONArray.put(jSONObject4);
            jSONObject3.put("info", jSONArray);
            JSONObject jSONObject5 = new JSONObject();
            jSONObject4.put("traces", jSONObject5);
            Object obj = aVar.fvE;
            if (!bg.bV(obj)) {
                Iterator it = obj.iterator();
                while (it.hasNext()) {
                    Pair pair = (Pair) it.next();
                    Thread thread = (Thread) pair.first;
                    StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) pair.second;
                    if (stackTraceElementArr != null && stackTraceElementArr.length > 0) {
                        String str = thread.getName() + " (prio:" + thread.getPriority() + " tid:" + thread.getId() + " state:" + thread.getState() + ")";
                        JSONArray jSONArray2 = new JSONArray();
                        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                            if (stackTraceElement != null) {
                                jSONArray2.put(stackTraceElement.toString());
                            }
                        }
                        jSONObject5.put(str, jSONArray2);
                    }
                }
            }
            try {
                w.i("MicroMsg.ANRWatchDog.summeranr", "summeranr buildReport CpuUsage [%d, %d, %d]", Integer.valueOf(fvr.ry()), Integer.valueOf(fvr.rz()), Integer.valueOf(fvr.rx()));
                jSONObject4.put("cpu_usage_total", r0);
                jSONObject4.put("cpu_usage_pid", i);
                jSONObject4.put("cpu_count", r2);
                ActivityManager activityManager = (ActivityManager) ab.getContext().getSystemService("activity");
                MemoryInfo memoryInfo = new MemoryInfo();
                activityManager.getMemoryInfo(memoryInfo);
                long j = 0;
                if (com.tencent.mm.compatible.util.d.eo(16)) {
                    j = memoryInfo.totalMem;
                } else {
                    RandomAccessFile randomAccessFile = new RandomAccessFile("/proc/meminfo", "r");
                    try {
                        StringBuffer stringBuffer = new StringBuffer();
                        char[] toCharArray = randomAccessFile.readLine().toCharArray();
                        int length = toCharArray.length;
                        i = 0;
                        while (i < length) {
                            if (toCharArray[i] <= '9' && toCharArray[i] >= '0') {
                                stringBuffer.append(toCharArray[i]);
                            }
                            i++;
                        }
                        long j2 = bg.getLong(stringBuffer.toString(), -1);
                        if (j2 > 0) {
                            j = j2 << 10;
                        }
                    } catch (Throwable e) {
                        w.printErrStackTrace("MicroMsg.ANRWatchDog.summeranr", e, "summeranr", new Object[0]);
                    } finally {
                        randomAccessFile.close();
                    }
                }
                w.i("MicroMsg.ANRWatchDog.summeranr", "summeranr buildReport MemoryInfo[%d, %d, %d, %b]", Long.valueOf(j), Long.valueOf(memoryInfo.availMem), Long.valueOf(memoryInfo.threshold), Boolean.valueOf(memoryInfo.lowMemory));
                jSONObject4.put("mem_sys_total", j);
                jSONObject4.put("mem_sys_avail", memoryInfo.availMem);
                jSONObject4.put("mem_sys_threshold", memoryInfo.threshold);
                jSONObject4.put("mem_sys_low", memoryInfo.lowMemory);
                jSONObject4.put("mem_native_heap_size", Debug.getNativeHeapSize());
                jSONObject4.put("mem_native_heap_alloc_size", Debug.getNativeHeapAllocatedSize());
                jSONObject4.put("mem_native_heap_free_size", Debug.getNativeHeapFreeSize());
                Debug.MemoryInfo[] processMemoryInfo = activityManager.getProcessMemoryInfo(new int[]{Process.myPid()});
                if (!(processMemoryInfo == null || processMemoryInfo.length <= 0 || processMemoryInfo[0] == null)) {
                    Debug.MemoryInfo memoryInfo2 = processMemoryInfo[0];
                    jSONObject4.put("mem_private_dirty", memoryInfo2.getTotalPrivateDirty() << 10);
                    jSONObject4.put("mem_shared_dirty", memoryInfo2.getTotalSharedDirty() << 10);
                    jSONObject4.put("mem_pss", memoryInfo2.getTotalPss() << 10);
                }
                if (fvp == 1 && ap.zb() && h.vG().gXp) {
                    com.tencent.mm.storage.w.a[] aVarArr = new com.tencent.mm.storage.w.a[]{com.tencent.mm.storage.w.a.USERINFO_HEAVY_USER_REPORT_TYPE_SD_FILE_SIZE_LONG, com.tencent.mm.storage.w.a.USERINFO_HEAVY_USER_REPORT_TYPE_SD_FILE_RATIO_LONG, com.tencent.mm.storage.w.a.USERINFO_HEAVY_USER_REPORT_TYPE_DB_SIZE_LONG, com.tencent.mm.storage.w.a.USERINFO_HEAVY_USER_REPORT_TYPE_DB_MESSAGE_LONG, com.tencent.mm.storage.w.a.USERINFO_HEAVY_USER_REPORT_TYPE_DB_CONVERSATION_LONG, com.tencent.mm.storage.w.a.USERINFO_HEAVY_USER_REPORT_TYPE_DB_CONTACT_LONG, com.tencent.mm.storage.w.a.USERINFO_HEAVY_USER_REPORT_TYPE_DB_CHATROOM_LONG};
                    i = 0;
                    String str2 = "";
                    while (i < 7) {
                        com.tencent.mm.storage.w.a aVar2 = aVarArr[i];
                        StringBuilder append = new StringBuilder().append(str2);
                        ap.yY();
                        i++;
                        str2 = append.append(com.tencent.mm.u.c.vr().get(aVar2, Long.valueOf(0))).append(":").toString();
                    }
                    w.i("MicroMsg.ANRWatchDog.summeranr", "summeranr sProcessName[%s] storage_usage[%s]", fvD, str2);
                    jSONObject4.put("storage_usage", str2);
                }
            } catch (Throwable e2) {
                w.printErrStackTrace("MicroMsg.ANRWatchDog.summeranr", e2, "summeranr buildReport storage_usage:", new Object[0]);
                g.oUh.a(510, 9, 1, true);
            } catch (Throwable e22) {
                w.printErrStackTrace("MicroMsg.ANRWatchDog.summeranr", e22, "summeranr buildReport JSONException:", new Object[0]);
                g.oUh.a(510, 10, 1, true);
            }
            jSONObject4.put("time", new Integer(fvx));
            int i2 = 0;
            if (new File(com.tencent.mm.storage.w.hgq).exists()) {
                i2 = ab.getContext().getSharedPreferences("system_config_prefs", 4).getInt("default_uin", 0);
            }
            jSONObject3.put(OpenSDKTool4Assistant.EXTRA_UIN, new Long((long) i2));
            jSONObject3.put("process_name", fvD);
            jSONObject3.put("time", new Long(System.currentTimeMillis()));
            jSONObject3.put("cver", new Integer(com.tencent.mm.protocal.d.sYN));
            jSONObject3.put("revision", BaseBuildInfo.codeRevision());
            g.oUh.a(510, 8, 1, true);
        } catch (Throwable e222) {
            w.printErrStackTrace("MicroMsg.ANRWatchDog.summeranr", e222, "summeranr buildReport JSONException:", new Object[0]);
            g.oUh.a(510, 10, 1, true);
        } catch (Throwable e2222) {
            w.printErrStackTrace("MicroMsg.ANRWatchDog.summeranr", e2222, "summeranr buildReport Exception:", new Object[0]);
            g.oUh.a(510, 11, 1, true);
        }
        String jSONObject6 = jSONObject.toString();
        String str3 = "MicroMsg.ANRWatchDog.summeranr";
        String str4 = "summeranr buildReport packer len[%d][%d][%s]";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(jSONObject.length());
        objArr[1] = Integer.valueOf(jSONObject6.length());
        if (jSONObject6.length() > 51200) {
            substring = jSONObject6.substring(0, 51200);
        } else {
            substring = jSONObject6;
        }
        objArr[2] = substring;
        w.i(str3, str4, objArr);
        return jSONObject6;
    }

    public static int cQ(int i) {
        int i2 = 0;
        if (i < 0) {
            return -1;
        }
        if (i == 0) {
            return 0;
        }
        if (i == 1 || i == 2) {
            return 1;
        }
        int i3 = 1;
        int i4 = 3;
        int i5 = 1;
        while (i4 <= i) {
            i3 += i5;
            i4++;
            i2 = i3;
            int i6 = i5;
            i5 = i3;
            i3 = i6;
        }
        return i2;
    }
}
