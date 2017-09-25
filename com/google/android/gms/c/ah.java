package com.google.android.gms.c;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.w;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class ah {
    private static volatile ah aAL;
    public final List<Object> aAM = new CopyOnWriteArrayList();
    private final ad aAN = new ad();
    public final a aAO = new a(this);
    public UncaughtExceptionHandler aAP;
    private volatile aj ajc;
    public final Context mContext;

    class AnonymousClass1 implements Runnable {
        final /* synthetic */ ae aAQ;
        final /* synthetic */ ah aAR;

        public AnonymousClass1(ah ahVar, ae aeVar) {
            this.aAR = ahVar;
            this.aAQ = aeVar;
        }

        public final void run() {
            this.aAQ.aAy.a(this.aAQ);
            Iterator it = this.aAR.aAM.iterator();
            while (it.hasNext()) {
                it.next();
            }
            ah.b(this.aAQ);
        }
    }

    private class a extends ThreadPoolExecutor {
        final /* synthetic */ ah aAR;

        public a(ah ahVar) {
            this.aAR = ahVar;
            super(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
            setThreadFactory(new b());
        }

        protected final <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
            return new FutureTask<T>(this, runnable, t) {
                final /* synthetic */ a aAS;

                protected final void setException(Throwable th) {
                    UncaughtExceptionHandler uncaughtExceptionHandler = this.aAS.aAR.aAP;
                    if (uncaughtExceptionHandler != null) {
                        uncaughtExceptionHandler.uncaughtException(Thread.currentThread(), th);
                    } else if (Log.isLoggable("GAv4", 6)) {
                        new StringBuilder("MeasurementExecutor: job failed with ").append(th);
                    }
                    super.setException(th);
                }
            };
        }
    }

    private static class b implements ThreadFactory {
        private static final AtomicInteger aAT = new AtomicInteger();

        public final Thread newThread(Runnable runnable) {
            return new c(runnable, "measurement-" + aAT.incrementAndGet());
        }
    }

    private static class c extends Thread {
        c(Runnable runnable, String str) {
            super(runnable, str);
        }

        public final void run() {
            Process.setThreadPriority(10);
            super.run();
        }
    }

    private ah(Context context) {
        Context applicationContext = context.getApplicationContext();
        w.Z(applicationContext);
        this.mContext = applicationContext;
    }

    public static ah M(Context context) {
        w.Z(context);
        if (aAL == null) {
            synchronized (ah.class) {
                if (aAL == null) {
                    aAL = new ah(context);
                }
            }
        }
        return aAL;
    }

    public static void b(ae aeVar) {
        w.W("deliver should be called from worker thread");
        w.b(aeVar.aAz, "Measurement must be submitted");
        List<ai> list = aeVar.aAH;
        if (!list.isEmpty()) {
            Set hashSet = new HashSet();
            for (ai aiVar : list) {
                Uri ja = aiVar.ja();
                if (!hashSet.contains(ja)) {
                    hashSet.add(ja);
                    aiVar.b(aeVar);
                }
            }
        }
    }

    public static void im() {
        if (!(Thread.currentThread() instanceof c)) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    public final <V> Future<V> a(Callable<V> callable) {
        w.Z(callable);
        if (!(Thread.currentThread() instanceof c)) {
            return this.aAO.submit(callable);
        }
        Future futureTask = new FutureTask(callable);
        futureTask.run();
        return futureTask;
    }

    public final void c(Runnable runnable) {
        w.Z(runnable);
        this.aAO.submit(runnable);
    }

    public final aj lf() {
        if (this.ajc == null) {
            synchronized (this) {
                if (this.ajc == null) {
                    aj ajVar = new aj();
                    PackageManager packageManager = this.mContext.getPackageManager();
                    String packageName = this.mContext.getPackageName();
                    ajVar.aAU = packageName;
                    ajVar.aAV = packageManager.getInstallerPackageName(packageName);
                    String str = null;
                    try {
                        PackageInfo packageInfo = packageManager.getPackageInfo(this.mContext.getPackageName(), 0);
                        if (packageInfo != null) {
                            CharSequence applicationLabel = packageManager.getApplicationLabel(packageInfo.applicationInfo);
                            if (!TextUtils.isEmpty(applicationLabel)) {
                                packageName = applicationLabel.toString();
                            }
                            str = packageInfo.versionName;
                        }
                    } catch (NameNotFoundException e) {
                    }
                    ajVar.ahs = packageName;
                    ajVar.aht = str;
                    this.ajc = ajVar;
                }
            }
        }
        return this.ajc;
    }
}
