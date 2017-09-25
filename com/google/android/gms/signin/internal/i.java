package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.c.b;
import com.google.android.gms.common.internal.AuthAccountRequest;
import com.google.android.gms.common.internal.BinderWrapper;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.h;
import com.google.android.gms.common.internal.k;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.t;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.signin.d;
import com.google.android.gms.signin.e;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;

public final class i extends k<f> implements d {
    private final boolean aDl;
    private final ExecutorService aDm;
    private final h anu;
    private final e aqo;
    private Integer aqp;

    private static class a extends com.google.android.gms.signin.internal.d.a {
        private final ExecutorService aDm;
        private final e aqo;

        public a(e eVar, ExecutorService executorService) {
            this.aqo = eVar;
            this.aDm = executorService;
        }

        public final void a(final String str, final String str2, final f fVar) {
            this.aDm.submit(new Runnable(this) {
                final /* synthetic */ a aDq;

                public final void run() {
                    try {
                        fVar.af(this.aDq.aqo.aDE.jt());
                    } catch (RemoteException e) {
                    }
                }
            });
        }

        public final void a(final String str, final List<Scope> list, final f fVar) {
            this.aDm.submit(new Runnable(this) {
                final /* synthetic */ a aDq;

                public final void run() {
                    try {
                        c.d a = this.aDq.aqo.aDE;
                        Collections.unmodifiableSet(new HashSet(list));
                        com.google.android.gms.common.api.c.d.a js = a.js();
                        fVar.a(new CheckServerAuthResult(js.amJ, js.amK));
                    } catch (RemoteException e) {
                    }
                }
            });
        }
    }

    public i(Context context, Looper looper, boolean z, h hVar, b bVar, c.c cVar, ExecutorService executorService) {
        super(context, looper, 44, hVar, bVar, cVar);
        this.aDl = z;
        this.anu = hVar;
        this.aqo = hVar.aqo;
        this.aqp = hVar.aqp;
        this.aDm = executorService;
    }

    public final void a(p pVar, Set<Scope> set, e eVar) {
        w.h(eVar, "Expecting a valid ISignInCallbacks");
        try {
            ((f) jY()).a(new AuthAccountRequest(pVar, set), eVar);
        } catch (RemoteException e) {
            try {
                eVar.a(new ConnectionResult(8, null), new AuthAccountResult());
            } catch (RemoteException e2) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onAuthAccount should be executed from the same process, unexpected RemoteException.");
            }
        }
    }

    public final void a(p pVar, boolean z) {
        try {
            ((f) jY()).a(pVar, this.aqp.intValue(), z);
        } catch (RemoteException e) {
        }
    }

    public final void a(t tVar) {
        w.h(tVar, "Expecting a valid IResolveAccountCallbacks");
        try {
            h hVar = this.anu;
            ((f) jY()).a(new ResolveAccountRequest(hVar.akV != null ? hVar.akV : new Account("<<default account>>", "com.google"), this.aqp.intValue()), tVar);
        } catch (RemoteException e) {
            try {
                tVar.a(new ResolveAccountResponse());
            } catch (RemoteException e2) {
                Log.wtf("SignInClientImpl", "IResolveAccountCallbacks#onAccountResolutionComplete should be executed from the same process, unexpected RemoteException.");
            }
        }
    }

    public final void connect() {
        a(new f(this));
    }

    protected final /* synthetic */ IInterface f(IBinder iBinder) {
        return com.google.android.gms.signin.internal.f.a.p(iBinder);
    }

    protected final Bundle jX() {
        e eVar = this.aqo;
        Integer num = this.anu.aqp;
        ExecutorService executorService = this.aDm;
        Bundle bundle = new Bundle();
        bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", eVar.aDC);
        bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", eVar.aDD);
        bundle.putString("com.google.android.gms.signin.internal.serverClientId", eVar.alT);
        if (eVar.aDE != null) {
            bundle.putParcelable("com.google.android.gms.signin.internal.signInCallbacks", new BinderWrapper(new a(eVar, executorService).asBinder()));
        }
        if (num != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", num.intValue());
        }
        if (!this.mContext.getPackageName().equals(this.anu.amt)) {
            bundle.putString("com.google.android.gms.signin.internal.realClientPackageName", this.anu.amt);
        }
        return bundle;
    }

    public final boolean jk() {
        return this.aDl;
    }

    protected final String jm() {
        return "com.google.android.gms.signin.service.START";
    }

    protected final String jn() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    public final void lI() {
        try {
            ((f) jY()).cv(this.aqp.intValue());
        } catch (RemoteException e) {
        }
    }
}
