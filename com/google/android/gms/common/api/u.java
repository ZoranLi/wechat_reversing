package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.l;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.c.c;
import com.google.android.gms.common.e;
import com.google.android.gms.common.internal.w;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public final class u extends Fragment implements OnCancelListener {
    public boolean aok;
    public int aol = -1;
    public ConnectionResult aom;
    public final Handler aon = new Handler(Looper.getMainLooper());
    final SparseArray<a> aoo = new SparseArray();
    public boolean ny;

    private class b implements Runnable {
        final /* synthetic */ u aos;
        private final int aot;
        private final ConnectionResult aou;

        public b(u uVar, int i, ConnectionResult connectionResult) {
            this.aos = uVar;
            this.aot = i;
            this.aou = connectionResult;
        }

        public final void run() {
            if (this.aos.ny && !this.aos.aok) {
                this.aos.aok = true;
                this.aos.aol = this.aot;
                this.aos.aom = this.aou;
                if (this.aou.jf()) {
                    try {
                        this.aou.a(this.aos.aG(), ((this.aos.aG().aR().aW().indexOf(this.aos) + 1) << 16) + 1);
                    } catch (SendIntentException e) {
                        this.aos.jL();
                    }
                } else if (e.bP(this.aou.alZ)) {
                    e.a(this.aou.alZ, this.aos.aG(), this.aos, this.aos);
                } else {
                    this.aos.a(this.aot, this.aou);
                }
            }
        }
    }

    private class a implements c {
        public final int aop;
        public final c aoq;
        public final c aor;
        final /* synthetic */ u aos;

        public a(u uVar, int i, c cVar, c cVar2) {
            this.aos = uVar;
            this.aop = i;
            this.aoq = cVar;
            this.aor = cVar2;
            cVar.a((c) this);
        }

        public final void a(ConnectionResult connectionResult) {
            this.aos.aon.post(new b(this.aos, this.aop, connectionResult));
        }
    }

    public static u a(FragmentActivity fragmentActivity) {
        w.V("Must be called from main thread of process");
        try {
            u uVar = (u) fragmentActivity.aR().k("GmsSupportLifecycleFragment");
            return (uVar == null || uVar.pb) ? null : uVar;
        } catch (Throwable e) {
            throw new IllegalStateException("Fragment with tag GmsSupportLifecycleFragment is not a SupportLifecycleFragment", e);
        }
    }

    public static u b(FragmentActivity fragmentActivity) {
        u a = a(fragmentActivity);
        l aR = fragmentActivity.aR();
        if (a != null) {
            return a;
        }
        Fragment uVar = new u();
        aR.aV().a(uVar, "GmsSupportLifecycleFragment").commitAllowingStateLoss();
        aR.executePendingTransactions();
        return uVar;
    }

    public final void a(int i, ConnectionResult connectionResult) {
        a aVar = (a) this.aoo.get(i);
        if (aVar != null) {
            c cVar = (a) this.aoo.get(i);
            this.aoo.remove(i);
            if (cVar != null) {
                cVar.aoq.b(cVar);
                cVar.aoq.disconnect();
            }
            c cVar2 = aVar.aor;
            if (cVar2 != null) {
                cVar2.a(connectionResult);
            }
        }
        jL();
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        for (int i = 0; i < this.aoo.size(); i++) {
            a aVar = (a) this.aoo.valueAt(i);
            printWriter.append(str).append("GoogleApiClient #").print(aVar.aop);
            printWriter.println(":");
            aVar.aoq.a(str + "  ", printWriter);
        }
    }

    public final void jL() {
        this.aok = false;
        this.aol = -1;
        this.aom = null;
        for (int i = 0; i < this.aoo.size(); i++) {
            ((a) this.aoo.valueAt(i)).aoq.connect();
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.u.onActivityResult(int, int, android.content.Intent):void");
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
        this.ny = true;
        if (!this.aok) {
            for (int i = 0; i < this.aoo.size(); i++) {
                ((a) this.aoo.valueAt(i)).aoq.connect();
            }
        }
    }

    public final void onStop() {
        super.onStop();
        this.ny = false;
        for (int i = 0; i < this.aoo.size(); i++) {
            ((a) this.aoo.valueAt(i)).aoq.disconnect();
        }
    }
}
