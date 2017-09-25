package com.google.android.gms.analytics.internal;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.analytics.AnalyticsReceiver;
import com.google.android.gms.analytics.AnalyticsService;
import com.google.android.gms.c.ah;
import com.google.android.gms.common.internal.w;

public final class m extends o {
    public final w aig;

    class AnonymousClass1 implements Runnable {
        final /* synthetic */ boolean aih;
        final /* synthetic */ m aii;

        AnonymousClass1(m mVar, boolean z) {
            this.aii = mVar;
            this.aih = z;
        }

        public final void run() {
            this.aii.aig.iA();
        }
    }

    class AnonymousClass2 implements Runnable {
        final /* synthetic */ m aii;
        final /* synthetic */ String aij;
        final /* synthetic */ Runnable aik;

        public AnonymousClass2(m mVar, String str, Runnable runnable) {
            this.aii = mVar;
            this.aij = str;
            this.aik = runnable;
        }

        public final void run() {
            this.aii.aig.L(this.aij);
            if (this.aik != null) {
                this.aik.run();
            }
        }
    }

    public m(q qVar, r rVar) {
        super(qVar);
        w.Z(rVar);
        this.aig = rVar.c(qVar);
    }

    public final long a(s sVar) {
        ie();
        w.Z(sVar);
        q.im();
        long d = this.aig.d(sVar);
        if (d == 0) {
            this.aig.c(sVar);
        }
        return d;
    }

    public final void a(final ah ahVar) {
        ie();
        this.ahK.ih().c(new Runnable(this) {
            final /* synthetic */ m aii;

            public final void run() {
                this.aii.aig.b(ahVar);
            }
        });
    }

    public final void c(final c cVar) {
        w.Z(cVar);
        ie();
        e("Hit delivery requested", cVar);
        this.ahK.ih().c(new Runnable(this) {
            final /* synthetic */ m aii;

            public final void run() {
                this.aii.aig.c(cVar);
            }
        });
    }

    public final void hX() {
        ie();
        Context context = this.ahK.mContext;
        if (AnalyticsReceiver.s(context) && AnalyticsService.t(context)) {
            Intent intent = new Intent(context, AnalyticsService.class);
            intent.setAction("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
            context.startService(intent);
            return;
        }
        a(null);
    }

    public final void hY() {
        ie();
        ah.im();
        this.aig.hY();
    }

    final void hZ() {
        q.im();
        this.aig.hZ();
    }

    protected final void hu() {
        this.aig.if();
    }

    final void onServiceConnected() {
        q.im();
        this.aig.onServiceConnected();
    }
}
