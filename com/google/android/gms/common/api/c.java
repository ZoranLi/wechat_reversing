package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.google.android.gms.c.m;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.h;
import com.google.android.gms.common.internal.w;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public interface c {

    public static final class a {
        private Account akV;
        public c amA;
        public Looper amB;
        public com.google.android.gms.common.b amC = com.google.android.gms.common.b.jg();
        public com.google.android.gms.common.api.a.a<? extends com.google.android.gms.signin.d, com.google.android.gms.signin.e> amD = com.google.android.gms.signin.b.aDu;
        public final ArrayList<b> amE = new ArrayList();
        public final ArrayList<c> amF = new ArrayList();
        private com.google.android.gms.signin.e.a amG = new com.google.android.gms.signin.e.a();
        public final Set<Scope> amq = new HashSet();
        private int amr;
        private View ams;
        private String amt;
        private String amu;
        private final Map<a<?>, com.google.android.gms.common.internal.h.a> amv = new m();
        public final Map<a<?>, Object> amw = new m();
        public FragmentActivity amx;
        public int amy = -1;
        public int amz = -1;
        public final Context mContext;

        class AnonymousClass1 implements Runnable {
            final /* synthetic */ c amH;
            final /* synthetic */ a amI;

            public AnonymousClass1(a aVar, c cVar) {
                this.amI = aVar;
                this.amH = cVar;
            }

            public final void run() {
                if (!this.amI.amx.isFinishing() && !this.amI.amx.aR().isDestroyed()) {
                    this.amI.a(u.b(this.amI.amx), this.amH);
                }
            }
        }

        public a(Context context) {
            this.mContext = context;
            this.amB = context.getMainLooper();
            this.amt = context.getPackageName();
            this.amu = context.getClass().getName();
        }

        public final void a(u uVar, c cVar) {
            int i = this.amy;
            c cVar2 = this.amA;
            w.h(cVar, "GoogleApiClient instance cannot be null");
            w.a(uVar.aoo.indexOfKey(i) < 0, "Already managing a GoogleApiClient with id " + i);
            uVar.aoo.put(i, new a(uVar, i, cVar, cVar2));
            if (uVar.ny && !uVar.aok) {
                cVar.connect();
            }
        }

        public final h jr() {
            return new h(this.akV, this.amq, this.amv, this.amr, this.ams, this.amt, this.amu, this.amG.lJ());
        }
    }

    public interface b {
        void bR(int i);

        void g(Bundle bundle);
    }

    public interface c {
        void a(ConnectionResult connectionResult);
    }

    public interface d {

        public static class a {
            public boolean amJ;
            public Set<Scope> amK;
        }

        a js();

        boolean jt();
    }

    public interface e {
        void b(ConnectionResult connectionResult);

        void c(ConnectionResult connectionResult);
    }

    ConnectionResult a(TimeUnit timeUnit);

    <A extends com.google.android.gms.common.api.a.b, R extends g, T extends com.google.android.gms.common.api.k.a<R, A>> T a(T t);

    void a(b bVar);

    void a(c cVar);

    void a(String str, PrintWriter printWriter);

    <A extends com.google.android.gms.common.api.a.b, T extends com.google.android.gms.common.api.k.a<? extends g, A>> T b(T t);

    void b(b bVar);

    void b(c cVar);

    void connect();

    void disconnect();

    Looper getLooper();

    boolean isConnected();

    boolean isConnecting();
}
