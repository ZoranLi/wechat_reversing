package com.google.android.gms.analytics.internal;

import android.app.Application;
import android.content.Context;
import com.google.android.gms.analytics.a;
import com.google.android.gms.analytics.b;
import com.google.android.gms.analytics.c;
import com.google.android.gms.c.ah;
import com.google.android.gms.c.v;
import com.google.android.gms.c.w;
import com.google.android.gms.common.internal.f;
import java.lang.Thread.UncaughtExceptionHandler;

public class q {
    private static q aiq;
    public final v ahZ = w.kV();
    private final y aiA;
    public final a aiB;
    public final v aiC;
    public final af aiD;
    final Context air;
    final ac ais = r.b(this);
    final f ait;
    private final ah aiu;
    private final m aiv;
    final ag aiw;
    private final l aix;
    final i aiy;
    private final a aiz;
    final Context mContext;

    private q(r rVar) {
        Context context = rVar.aiF;
        com.google.android.gms.common.internal.w.h(context, "Application context can't be null");
        com.google.android.gms.common.internal.w.b(context instanceof Application, "getApplicationContext didn't return the application");
        Context context2 = rVar.aiG;
        com.google.android.gms.common.internal.w.Z(context2);
        this.mContext = context;
        this.air = context2;
        f fVar = new f(this);
        fVar.if();
        this.ait = fVar;
        if (f.apP) {
            ig().E("Google Analytics " + p.VERSION + " is starting up.");
        } else {
            ig().E("Google Analytics " + p.VERSION + " is starting up. To enable debug logging on a device run:\n  adb shell setprop log.tag.GAv4 DEBUG\n  adb logcat -s GAv4");
        }
        i f = r.f(this);
        f.if();
        this.aiy = f;
        l lVar = new l(this);
        lVar.if();
        this.aix = lVar;
        m mVar = new m(this, rVar);
        y a = r.a(this);
        a aVar = new a(this);
        v vVar = new v(this);
        af afVar = new af(this);
        ah M = ah.M(context);
        M.aAP = new UncaughtExceptionHandler(this) {
            final /* synthetic */ q aiE;

            {
                this.aiE = r1;
            }

            public final void uncaughtException(Thread thread, Throwable th) {
                f fVar = this.aiE.ait;
                if (fVar != null) {
                    fVar.g("Job execution failed", th);
                }
            }
        };
        this.aiu = M;
        c aVar2 = new a(this);
        a.if();
        this.aiA = a;
        aVar.if();
        this.aiB = aVar;
        vVar.if();
        this.aiC = vVar;
        afVar.if();
        this.aiD = afVar;
        ag e = r.e(this);
        e.if();
        this.aiw = e;
        mVar.if();
        this.aiv = mVar;
        if (f.apP) {
            ig().e("Device AnalyticsService version", p.VERSION);
        }
        l ik = aVar2.ajB.ik();
        if (ik.hS()) {
            e.hB().setLogLevel(ik.getLogLevel());
        }
        if (ik.hV()) {
            aVar2.ahh = ik.hW();
        }
        if (ik.hS()) {
            b hB = e.hB();
            if (hB != null) {
                hB.setLogLevel(ik.getLogLevel());
            }
        }
        aVar2.ahe = true;
        this.aiz = aVar2;
        mVar.aig.start();
    }

    public static void a(o oVar) {
        com.google.android.gms.common.internal.w.h(oVar, "Analytics service not created/initialized");
        com.google.android.gms.common.internal.w.b(oVar.isInitialized(), "Analytics service not initialized");
    }

    public static void im() {
        ah.im();
    }

    public static q u(Context context) {
        com.google.android.gms.common.internal.w.Z(context);
        if (aiq == null) {
            synchronized (q.class) {
                if (aiq == null) {
                    v kV = w.kV();
                    long elapsedRealtime = kV.elapsedRealtime();
                    q qVar = new q(new r(context.getApplicationContext()));
                    aiq = qVar;
                    a.ht();
                    elapsedRealtime = kV.elapsedRealtime() - elapsedRealtime;
                    long longValue = ((Long) aj.akE.get()).longValue();
                    if (elapsedRealtime > longValue) {
                        qVar.ig().c("Slow initialization (ms)", Long.valueOf(elapsedRealtime), Long.valueOf(longValue));
                    }
                }
            }
        }
        return aiq;
    }

    public final f ig() {
        a(this.ait);
        return this.ait;
    }

    public final ah ih() {
        com.google.android.gms.common.internal.w.Z(this.aiu);
        return this.aiu;
    }

    public final m ii() {
        a(this.aiv);
        return this.aiv;
    }

    public final a ij() {
        com.google.android.gms.common.internal.w.Z(this.aiz);
        a aVar = this.aiz;
        boolean z = aVar.ahe && !aVar.ahf;
        com.google.android.gms.common.internal.w.b(z, "Analytics instance not initialized");
        return this.aiz;
    }

    public final l ik() {
        a(this.aix);
        return this.aix;
    }

    public final y il() {
        a(this.aiA);
        return this.aiA;
    }
}
