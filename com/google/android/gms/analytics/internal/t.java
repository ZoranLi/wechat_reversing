package com.google.android.gms.analytics.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.RemoteException;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.common.stats.b;
import java.util.Collections;

public final class t extends o {
    public final a aiM = new a(this);
    d aiN;
    private final ae aiO;
    private j aiP;

    protected class a implements ServiceConnection {
        final /* synthetic */ t aiQ;
        private volatile d aiR;
        private volatile boolean aiS;

        protected a(t tVar) {
            this.aiQ = tVar;
        }

        public final d ip() {
            d dVar = null;
            q.im();
            Intent intent = new Intent("com.google.android.gms.analytics.service.START");
            intent.setComponent(new ComponentName("com.google.android.gms", "com.google.android.gms.analytics.service.AnalyticsService"));
            Context context = this.aiQ.ahK.mContext;
            intent.putExtra("app_package_name", context.getPackageName());
            b kw = b.kw();
            synchronized (this) {
                this.aiR = null;
                this.aiS = true;
                boolean a = kw.a(context, intent, this.aiQ.aiM, 129);
                this.aiQ.d("Bind to service requested", Boolean.valueOf(a));
                if (a) {
                    try {
                        wait(((Long) aj.akz.get()).longValue());
                    } catch (InterruptedException e) {
                        this.aiQ.F("Wait for service connect was interrupted");
                    }
                    this.aiS = false;
                    dVar = this.aiR;
                    this.aiR = null;
                    if (dVar == null) {
                        this.aiQ.G("Successfully bound to service but never got onServiceConnected callback");
                    }
                } else {
                    this.aiS = false;
                }
            }
            return dVar;
        }

        public final void onServiceConnected(android.content.ComponentName r5, android.os.IBinder r6) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Exception block dominator not found, method:com.google.android.gms.analytics.internal.t.a.onServiceConnected(android.content.ComponentName, android.os.IBinder):void. bs: [B:3:0x0009, B:9:0x0017]
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:86)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
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
            r4 = this;
            r0 = "AnalyticsServiceConnection.onServiceConnected";
            com.google.android.gms.common.internal.w.V(r0);
            monitor-enter(r4);
            if (r6 != 0) goto L_0x0016;
        L_0x0009:
            r0 = r4.aiQ;	 Catch:{ all -> 0x005e }
            r1 = "Service connected with null binder";	 Catch:{ all -> 0x005e }
            r0.G(r1);	 Catch:{ all -> 0x005e }
            r4.notifyAll();	 Catch:{ all -> 0x0048 }
            monitor-exit(r4);	 Catch:{ all -> 0x0048 }
        L_0x0015:
            return;
        L_0x0016:
            r0 = 0;
            r1 = r6.getInterfaceDescriptor();	 Catch:{ RemoteException -> 0x0054 }
            r2 = "com.google.android.gms.analytics.internal.IAnalyticsService";	 Catch:{ RemoteException -> 0x0054 }
            r2 = r2.equals(r1);	 Catch:{ RemoteException -> 0x0054 }
            if (r2 == 0) goto L_0x004b;	 Catch:{ RemoteException -> 0x0054 }
        L_0x0024:
            r0 = com.google.android.gms.analytics.internal.d.a.d(r6);	 Catch:{ RemoteException -> 0x0054 }
            r1 = r4.aiQ;	 Catch:{ RemoteException -> 0x0054 }
            r2 = "Bound to IAnalyticsService interface";	 Catch:{ RemoteException -> 0x0054 }
            r1.C(r2);	 Catch:{ RemoteException -> 0x0054 }
        L_0x0030:
            if (r0 != 0) goto L_0x0063;
        L_0x0032:
            r0 = com.google.android.gms.common.stats.b.kw();	 Catch:{ IllegalArgumentException -> 0x0083 }
            r1 = r4.aiQ;	 Catch:{ IllegalArgumentException -> 0x0083 }
            r1 = r1.ahK;	 Catch:{ IllegalArgumentException -> 0x0083 }
            r1 = r1.mContext;	 Catch:{ IllegalArgumentException -> 0x0083 }
            r2 = r4.aiQ;	 Catch:{ IllegalArgumentException -> 0x0083 }
            r2 = r2.aiM;	 Catch:{ IllegalArgumentException -> 0x0083 }
            r0.a(r1, r2);	 Catch:{ IllegalArgumentException -> 0x0083 }
        L_0x0043:
            r4.notifyAll();	 Catch:{ all -> 0x0048 }
            monitor-exit(r4);	 Catch:{ all -> 0x0048 }
            goto L_0x0015;	 Catch:{ all -> 0x0048 }
        L_0x0048:
            r0 = move-exception;	 Catch:{ all -> 0x0048 }
            monitor-exit(r4);	 Catch:{ all -> 0x0048 }
            throw r0;
        L_0x004b:
            r2 = r4.aiQ;	 Catch:{ RemoteException -> 0x0054 }
            r3 = "Got binder with a wrong descriptor";	 Catch:{ RemoteException -> 0x0054 }
            r2.g(r3, r1);	 Catch:{ RemoteException -> 0x0054 }
            goto L_0x0030;
        L_0x0054:
            r1 = move-exception;
            r1 = r4.aiQ;	 Catch:{ all -> 0x005e }
            r2 = "Service connect failed to get IAnalyticsService";	 Catch:{ all -> 0x005e }
            r1.G(r2);	 Catch:{ all -> 0x005e }
            goto L_0x0030;
        L_0x005e:
            r0 = move-exception;
            r4.notifyAll();	 Catch:{ all -> 0x0048 }
            throw r0;	 Catch:{ all -> 0x0048 }
        L_0x0063:
            r1 = r4.aiS;	 Catch:{ all -> 0x005e }
            if (r1 != 0) goto L_0x0080;	 Catch:{ all -> 0x005e }
        L_0x0067:
            r1 = r4.aiQ;	 Catch:{ all -> 0x005e }
            r2 = "onServiceConnected received after the timeout limit";	 Catch:{ all -> 0x005e }
            r1.F(r2);	 Catch:{ all -> 0x005e }
            r1 = r4.aiQ;	 Catch:{ all -> 0x005e }
            r1 = r1.ahK;	 Catch:{ all -> 0x005e }
            r1 = r1.ih();	 Catch:{ all -> 0x005e }
            r2 = new com.google.android.gms.analytics.internal.t$a$1;	 Catch:{ all -> 0x005e }
            r2.<init>(r4, r0);	 Catch:{ all -> 0x005e }
            r1.c(r2);	 Catch:{ all -> 0x005e }
            goto L_0x0043;	 Catch:{ all -> 0x005e }
        L_0x0080:
            r4.aiR = r0;	 Catch:{ all -> 0x005e }
            goto L_0x0043;
        L_0x0083:
            r0 = move-exception;
            goto L_0x0043;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.internal.t.a.onServiceConnected(android.content.ComponentName, android.os.IBinder):void");
        }

        public final void onServiceDisconnected(final ComponentName componentName) {
            w.V("AnalyticsServiceConnection.onServiceDisconnected");
            this.aiQ.ahK.ih().c(new Runnable(this) {
                final /* synthetic */ a aiU;

                public final void run() {
                    n nVar = this.aiU.aiQ;
                    ComponentName componentName = componentName;
                    q.im();
                    if (nVar.aiN != null) {
                        nVar.aiN = null;
                        nVar.d("Disconnected from device AnalyticsService", componentName);
                        nVar.ahK.ii().hY();
                    }
                }
            });
        }
    }

    protected t(q qVar) {
        super(qVar);
        this.aiP = new j(qVar.ahZ);
        this.aiO = new ae(this, qVar) {
            final /* synthetic */ t aiQ;

            public final void run() {
                this.aiQ.io();
            }
        };
    }

    public final boolean connect() {
        q.im();
        ie();
        if (this.aiN != null) {
            return true;
        }
        d ip = this.aiM.ip();
        if (ip == null) {
            return false;
        }
        this.aiN = ip;
        in();
        return true;
    }

    public final boolean d(c cVar) {
        w.Z(cVar);
        q.im();
        ie();
        d dVar = this.aiN;
        if (dVar == null) {
            return false;
        }
        try {
            dVar.a(cVar.ahx, cVar.ahA, cVar.ahC ? ac.iQ() : ac.iR(), Collections.emptyList());
            in();
            return true;
        } catch (RemoteException e) {
            C("Failed to send hits to AnalyticsService");
            return false;
        }
    }

    public final void disconnect() {
        q.im();
        ie();
        try {
            b.kw().a(this.ahK.mContext, this.aiM);
        } catch (IllegalStateException e) {
        } catch (IllegalArgumentException e2) {
        }
        if (this.aiN != null) {
            this.aiN = null;
            this.ahK.ii().hY();
        }
    }

    protected final void hu() {
    }

    void in() {
        this.aiP.start();
        this.aiO.j(((Long) aj.aky.get()).longValue());
    }

    public final void io() {
        q.im();
        if (isConnected()) {
            C("Inactivity, disconnecting from device AnalyticsService");
            disconnect();
        }
    }

    public final boolean isConnected() {
        q.im();
        ie();
        return this.aiN != null;
    }
}
