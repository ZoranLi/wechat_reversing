package com.google.android.gms.a.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.RemoteException;
import com.google.android.gms.c.d;
import com.google.android.gms.common.c;
import com.google.android.gms.common.e;
import com.google.android.gms.common.h;
import com.google.android.gms.common.internal.w;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class a {
    private static boolean agL = false;
    h agF;
    d agG;
    boolean agH;
    Object agI = new Object();
    b agJ;
    final long agK;
    private final Context mContext;

    public static final class a {
        public final String agM;
        public final boolean agN;

        public a(String str, boolean z) {
            this.agM = str;
            this.agN = z;
        }

        public final String toString() {
            return "{" + this.agM + "}" + this.agN;
        }
    }

    static class b extends Thread {
        private WeakReference<a> agO;
        private long agP;
        CountDownLatch agQ = new CountDownLatch(1);
        boolean agR = false;

        public b(a aVar, long j) {
            this.agO = new WeakReference(aVar);
            this.agP = j;
            start();
        }

        private void disconnect() {
            a aVar = (a) this.agO.get();
            if (aVar != null) {
                aVar.finish();
                this.agR = true;
            }
        }

        public final void run() {
            try {
                if (!this.agQ.await(this.agP, TimeUnit.MILLISECONDS)) {
                    disconnect();
                }
            } catch (InterruptedException e) {
                disconnect();
            }
        }
    }

    private a(Context context) {
        w.Z(context);
        this.mContext = context;
        this.agH = false;
        this.agK = -1;
    }

    private static d a(h hVar) {
        try {
            return com.google.android.gms.c.d.a.n(hVar.ky());
        } catch (InterruptedException e) {
            throw new IOException("Interrupted exception");
        } catch (Throwable th) {
            IOException iOException = new IOException(th);
        }
    }

    private void hp() {
        w.W("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.agH) {
                finish();
            }
            this.agF = q(this.mContext);
            this.agG = a(this.agF);
            this.agH = true;
        }
    }

    private a hq() {
        a aVar;
        w.W("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (!this.agH) {
                synchronized (this.agI) {
                    if (this.agJ == null || !this.agJ.agR) {
                        throw new IOException("AdvertisingIdClient is not connected.");
                    }
                }
                try {
                    hp();
                    if (!this.agH) {
                        throw new IOException("AdvertisingIdClient cannot reconnect.");
                    }
                } catch (RemoteException e) {
                    throw new IOException("Remote exception");
                } catch (Throwable e2) {
                    throw new IOException("AdvertisingIdClient cannot reconnect.", e2);
                }
            }
            w.Z(this.agF);
            w.Z(this.agG);
            aVar = new a(this.agG.getId(), this.agG.ae(true));
        }
        synchronized (this.agI) {
            if (this.agJ != null) {
                this.agJ.agQ.countDown();
                try {
                    this.agJ.join();
                } catch (InterruptedException e3) {
                }
            }
            if (this.agK > 0) {
                this.agJ = new b(this, this.agK);
            }
        }
        return aVar;
    }

    private static h q(Context context) {
        try {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            if (agL) {
                com.google.android.gms.common.b.jg();
                switch (com.google.android.gms.common.b.w(context)) {
                    case 0:
                    case 2:
                        break;
                    default:
                        throw new IOException("Google Play services not available");
                }
            }
            try {
                e.y(context);
            } catch (Throwable e) {
                throw new IOException(e);
            }
            Object hVar = new h();
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            try {
                if (com.google.android.gms.common.stats.b.kw().a(context, intent, hVar, 1)) {
                    return hVar;
                }
                throw new IOException("Connection failure");
            } catch (Throwable e2) {
                IOException iOException = new IOException(e2);
            }
        } catch (NameNotFoundException e3) {
            throw new c(9);
        }
    }

    public static a r(Context context) {
        a aVar = new a(context);
        try {
            aVar.hp();
            a hq = aVar.hq();
            return hq;
        } finally {
            aVar.finish();
        }
    }

    protected final void finalize() {
        finish();
        super.finalize();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void finish() {
        /*
        r3 = this;
        r0 = "Calling this from your main thread can lead to deadlock";
        com.google.android.gms.common.internal.w.W(r0);
        monitor-enter(r3);
        r0 = r3.mContext;	 Catch:{ all -> 0x002b }
        if (r0 == 0) goto L_0x000f;
    L_0x000b:
        r0 = r3.agF;	 Catch:{ all -> 0x002b }
        if (r0 != 0) goto L_0x0011;
    L_0x000f:
        monitor-exit(r3);	 Catch:{ all -> 0x002b }
    L_0x0010:
        return;
    L_0x0011:
        r0 = r3.agH;	 Catch:{ IllegalArgumentException -> 0x002e }
        if (r0 == 0) goto L_0x0020;
    L_0x0015:
        r0 = com.google.android.gms.common.stats.b.kw();	 Catch:{ IllegalArgumentException -> 0x002e }
        r1 = r3.mContext;	 Catch:{ IllegalArgumentException -> 0x002e }
        r2 = r3.agF;	 Catch:{ IllegalArgumentException -> 0x002e }
        r0.a(r1, r2);	 Catch:{ IllegalArgumentException -> 0x002e }
    L_0x0020:
        r0 = 0;
        r3.agH = r0;	 Catch:{ all -> 0x002b }
        r0 = 0;
        r3.agG = r0;	 Catch:{ all -> 0x002b }
        r0 = 0;
        r3.agF = r0;	 Catch:{ all -> 0x002b }
        monitor-exit(r3);	 Catch:{ all -> 0x002b }
        goto L_0x0010;
    L_0x002b:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x002b }
        throw r0;
    L_0x002e:
        r0 = move-exception;
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.a.a.a.finish():void");
    }
}
