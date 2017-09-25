package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.l;
import android.support.v4.app.s;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.e;
import com.google.android.gms.common.internal.w;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public final class v extends Fragment implements OnCancelListener, android.support.v4.app.s.a<ConnectionResult> {
    private boolean aok;
    private int aol = -1;
    private ConnectionResult aom;
    private final Handler aon = new Handler(Looper.getMainLooper());
    public final SparseArray<b> aoo = new SparseArray();

    private static class b {
        public final c aoq;
        public final com.google.android.gms.common.api.c.c aor;

        public b(c cVar, com.google.android.gms.common.api.c.c cVar2) {
            this.aoq = cVar;
            this.aor = cVar2;
        }
    }

    private class c implements Runnable {
        private final int aot;
        private final ConnectionResult aou;
        final /* synthetic */ v aox;

        public c(v vVar, int i, ConnectionResult connectionResult) {
            this.aox = vVar;
            this.aot = i;
            this.aou = connectionResult;
        }

        public final void run() {
            if (this.aou.jf()) {
                try {
                    this.aou.a(this.aox.aG(), ((this.aox.aG().aR().aW().indexOf(this.aox) + 1) << 16) + 1);
                } catch (SendIntentException e) {
                    this.aox.jL();
                }
            } else if (e.bP(this.aou.alZ)) {
                e.a(this.aou.alZ, this.aox.aG(), this.aox, this.aox);
            } else {
                this.aox.a(this.aot, this.aou);
            }
        }
    }

    static class a extends android.support.v4.content.c<ConnectionResult> implements com.google.android.gms.common.api.c.b, com.google.android.gms.common.api.c.c {
        public final c aoq;
        boolean aov;
        private ConnectionResult aow;

        public a(Context context, c cVar) {
            super(context);
            this.aoq = cVar;
        }

        private void g(ConnectionResult connectionResult) {
            this.aow = connectionResult;
            if (this.ny && !this.tu) {
                deliverResult(connectionResult);
            }
        }

        public final void a(ConnectionResult connectionResult) {
            this.aov = true;
            g(connectionResult);
        }

        public final void bR(int i) {
        }

        public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            super.dump(str, fileDescriptor, printWriter, strArr);
            this.aoq.a(str, printWriter);
        }

        public final void g(Bundle bundle) {
            this.aov = false;
            g(ConnectionResult.alY);
        }

        protected final void onReset() {
            this.aow = null;
            this.aov = false;
            this.aoq.b((com.google.android.gms.common.api.c.b) this);
            this.aoq.b((com.google.android.gms.common.api.c.c) this);
            this.aoq.disconnect();
        }

        protected final void onStartLoading() {
            super.onStartLoading();
            this.aoq.a((com.google.android.gms.common.api.c.b) this);
            this.aoq.a((com.google.android.gms.common.api.c.c) this);
            if (this.aow != null) {
                deliverResult(this.aow);
            }
            if (!this.aoq.isConnected() && !this.aoq.isConnecting() && !this.aov) {
                this.aoq.connect();
            }
        }

        protected final void onStopLoading() {
            this.aoq.disconnect();
        }
    }

    public static v c(FragmentActivity fragmentActivity) {
        w.V("Must be called from main thread of process");
        l aR = fragmentActivity.aR();
        try {
            v vVar = (v) aR.k("GmsSupportLoaderLifecycleFragment");
            if (vVar != null && !vVar.pb) {
                return vVar;
            }
            Fragment vVar2 = new v();
            aR.aV().a(vVar2, "GmsSupportLoaderLifecycleFragment").commit();
            aR.executePendingTransactions();
            return vVar2;
        } catch (Throwable e) {
            throw new IllegalStateException("Fragment with tag GmsSupportLoaderLifecycleFragment is not a SupportLoaderLifecycleFragment", e);
        }
    }

    public final android.support.v4.content.c<ConnectionResult> K(int i) {
        return new a(aG(), ((b) this.aoo.get(i)).aoq);
    }

    public final void a(int i, ConnectionResult connectionResult) {
        b bVar = (b) this.aoo.get(i);
        if (bVar != null) {
            this.aoo.remove(i);
            aI().destroyLoader(i);
            com.google.android.gms.common.api.c.c cVar = bVar.aor;
            if (cVar != null) {
                cVar.a(connectionResult);
            }
        }
        jL();
    }

    public final /* synthetic */ void a(android.support.v4.content.c cVar, Object obj) {
        ConnectionResult connectionResult = (ConnectionResult) obj;
        if (!connectionResult.isSuccess()) {
            int i = cVar.dX;
            if (!this.aok) {
                this.aok = true;
                this.aol = i;
                this.aom = connectionResult;
                this.aon.post(new c(this, i, connectionResult));
            }
        }
    }

    public final a bU(int i) {
        try {
            return (a) aI().J(i);
        } catch (Throwable e) {
            throw new IllegalStateException("Unknown loader in SupportLoaderLifecycleFragment", e);
        }
    }

    public final void jL() {
        int i = 0;
        this.aok = false;
        this.aol = -1;
        this.aom = null;
        s aI = aI();
        while (i < this.aoo.size()) {
            int keyAt = this.aoo.keyAt(i);
            a bU = bU(keyAt);
            if (bU != null && bU.aov) {
                aI.destroyLoader(keyAt);
                aI.a(keyAt, this);
            }
            i++;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onActivityResult(int r4, int r5, android.content.Intent r6) {
        /*
        r3 = this;
        r0 = 1;
        r1 = 0;
        switch(r4) {
            case 1: goto L_0x0017;
            case 2: goto L_0x000c;
            default: goto L_0x0005;
        };
    L_0x0005:
        r0 = r1;
    L_0x0006:
        if (r0 == 0) goto L_0x001b;
    L_0x0008:
        r3.jL();
    L_0x000b:
        return;
    L_0x000c:
        r2 = r3.aG();
        r2 = com.google.android.gms.common.e.w(r2);
        if (r2 != 0) goto L_0x0005;
    L_0x0016:
        goto L_0x0006;
    L_0x0017:
        r2 = -1;
        if (r5 != r2) goto L_0x0005;
    L_0x001a:
        goto L_0x0006;
    L_0x001b:
        r0 = r3.aol;
        r1 = r3.aom;
        r3.a(r0, r1);
        goto L_0x000b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.v.onActivityResult(int, int, android.content.Intent):void");
    }

    public final void onAttach(Activity activity) {
        super.onAttach(activity);
        int i = 0;
        while (i < this.aoo.size()) {
            int keyAt = this.aoo.keyAt(i);
            a bU = bU(keyAt);
            if (bU == null || ((b) this.aoo.valueAt(i)).aoq == bU.aoq) {
                aI().a(keyAt, this);
            } else {
                aI().b(keyAt, this);
            }
            i++;
        }
    }

    public final void onCancel(DialogInterface dialogInterface) {
        a(this.aol, new ConnectionResult(13, null));
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.aok = bundle.getBoolean("resolving_error", false);
            this.aol = bundle.getInt("failed_client_id", -1);
            if (this.aol >= 0) {
                this.aom = new ConnectionResult(bundle.getInt("failed_status"), (PendingIntent) bundle.getParcelable("failed_resolution"));
            }
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("resolving_error", this.aok);
        if (this.aol >= 0) {
            bundle.putInt("failed_client_id", this.aol);
            bundle.putInt("failed_status", this.aom.alZ);
            bundle.putParcelable("failed_resolution", this.aom.ama);
        }
    }

    public final void onStart() {
        super.onStart();
        if (!this.aok) {
            for (int i = 0; i < this.aoo.size(); i++) {
                aI().a(this.aoo.keyAt(i), this);
            }
        }
    }
}
