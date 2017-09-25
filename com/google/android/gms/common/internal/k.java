package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Scope;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKClientBase;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class k<T extends IInterface> implements com.google.android.gms.common.api.a.b, com.google.android.gms.common.internal.l.a {
    public static final String[] aqF = new String[]{"service_esmobile", "service_googleme"};
    private final Account akV;
    private final Looper amB;
    private final com.google.android.gms.common.b amC;
    public final Set<Scope> amK;
    private final h anu;
    private int aqA;
    public final com.google.android.gms.common.api.c.b aqB;
    public final com.google.android.gms.common.api.c.c aqC;
    private final int aqD;
    protected AtomicInteger aqE;
    private final m aqt;
    private final Object aqu;
    public s aqv;
    public com.google.android.gms.common.api.c.e aqw;
    private T aqx;
    public final ArrayList<c<?>> aqy;
    private e aqz;
    public final Context mContext;
    final Handler mHandler;

    final class b extends Handler {
        final /* synthetic */ k aqH;

        public b(k kVar, Looper looper) {
            this.aqH = kVar;
            super(looper);
        }

        private static void a(Message message) {
            ((c) message.obj).unregister();
        }

        private static boolean b(Message message) {
            return message.what == 2 || message.what == 1 || message.what == 5 || message.what == 6;
        }

        public final void handleMessage(Message message) {
            PendingIntent pendingIntent = null;
            if (this.aqH.aqE.get() != message.arg1) {
                if (b(message)) {
                    a(message);
                }
            } else if ((message.what == 1 || message.what == 5 || message.what == 6) && !this.aqH.isConnecting()) {
                a(message);
            } else if (message.what == 3) {
                if (message.obj instanceof PendingIntent) {
                    pendingIntent = (PendingIntent) message.obj;
                }
                this.aqH.aqw.b(new ConnectionResult(message.arg2, pendingIntent));
                k.jV();
            } else if (message.what == 4) {
                this.aqH.a(4, null);
                if (this.aqH.aqB != null) {
                    this.aqH.aqB.bR(message.arg2);
                }
                int i = message.arg2;
                k.jU();
                this.aqH.a(4, 1, null);
            } else if (message.what == 2 && !this.aqH.isConnected()) {
                a(message);
            } else if (b(message)) {
                ((c) message.obj).ka();
            } else {
                Log.wtf("GmsClient", "Don't know how to handle this message.");
            }
        }
    }

    protected abstract class c<TListener> {
        private TListener aoj;
        final /* synthetic */ k aqH;
        private boolean aqI = false;

        public c(k kVar, TListener tListener) {
            this.aqH = kVar;
            this.aoj = tListener;
        }

        protected abstract void X(TListener tListener);

        public final void ka() {
            synchronized (this) {
                Object obj = this.aoj;
                if (this.aqI) {
                    new StringBuilder("Callback proxy ").append(this).append(" being reused. This is not safe.");
                }
            }
            if (obj != null) {
                try {
                    X(obj);
                } catch (RuntimeException e) {
                    throw e;
                }
            }
            synchronized (this) {
                this.aqI = true;
            }
            unregister();
        }

        public final void kb() {
            synchronized (this) {
                this.aoj = null;
            }
        }

        public final void unregister() {
            kb();
            synchronized (this.aqH.aqy) {
                this.aqH.aqy.remove(this);
            }
        }
    }

    public final class e implements ServiceConnection {
        final /* synthetic */ k aqH;
        private final int aqK;

        public e(k kVar, int i) {
            this.aqH = kVar;
            this.aqK = i;
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            w.h(iBinder, "Expecting a valid IBinder");
            this.aqH.aqv = com.google.android.gms.common.internal.s.a.i(iBinder);
            k kVar = this.aqH;
            kVar.mHandler.sendMessage(kVar.mHandler.obtainMessage(6, this.aqK, -1, new h(kVar)));
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            this.aqH.mHandler.sendMessage(this.aqH.mHandler.obtainMessage(4, this.aqK, 1));
        }
    }

    private abstract class a extends c<Boolean> {
        public final Bundle aqG;
        final /* synthetic */ k aqH;
        public final int statusCode;

        protected a(k kVar, int i, Bundle bundle) {
            this.aqH = kVar;
            super(kVar, Boolean.valueOf(true));
            this.statusCode = i;
            this.aqG = bundle;
        }

        protected final /* synthetic */ void X(Object obj) {
            PendingIntent pendingIntent = null;
            if (((Boolean) obj) == null) {
                this.aqH.a(1, null);
                return;
            }
            switch (this.statusCode) {
                case 0:
                    if (!jZ()) {
                        this.aqH.a(1, null);
                        h(new ConnectionResult(8, null));
                        return;
                    }
                    return;
                case 10:
                    this.aqH.a(1, null);
                    throw new IllegalStateException("A fatal developer error has occurred. Check the logs for further information.");
                default:
                    this.aqH.a(1, null);
                    if (this.aqG != null) {
                        pendingIntent = (PendingIntent) this.aqG.getParcelable("pendingIntent");
                    }
                    h(new ConnectionResult(this.statusCode, pendingIntent));
                    return;
            }
        }

        protected abstract void h(ConnectionResult connectionResult);

        protected abstract boolean jZ();
    }

    protected class f implements com.google.android.gms.common.api.c.e {
        final /* synthetic */ k aqH;

        public f(k kVar) {
            this.aqH = kVar;
        }

        public final void b(ConnectionResult connectionResult) {
            if (connectionResult.isSuccess()) {
                this.aqH.a(null, this.aqH.amK);
            } else if (this.aqH.aqC != null) {
                this.aqH.aqC.a(connectionResult);
            }
        }

        public final void c(ConnectionResult connectionResult) {
            throw new IllegalStateException("Legacy GmsClient received onReportAccountValidation callback.");
        }
    }

    public static final class d extends com.google.android.gms.common.internal.r.a {
        private k aqJ;
        private final int aqK;

        public d(k kVar, int i) {
            this.aqJ = kVar;
            this.aqK = i;
        }

        public final void a(int i, IBinder iBinder, Bundle bundle) {
            w.h(this.aqJ, "onPostInitComplete can be called only once per call to getRemoteService");
            this.aqJ.a(i, iBinder, bundle, this.aqK);
            this.aqJ = null;
        }

        public final void b(int i, Bundle bundle) {
            w.h(this.aqJ, "onAccountValidationComplete can be called only once per call to validateAccount");
            k kVar = this.aqJ;
            kVar.mHandler.sendMessage(kVar.mHandler.obtainMessage(5, this.aqK, -1, new i(kVar, i, bundle)));
            this.aqJ = null;
        }
    }

    protected final class g extends a {
        final /* synthetic */ k aqH;
        public final IBinder aqL;

        public g(k kVar, int i, IBinder iBinder, Bundle bundle) {
            this.aqH = kVar;
            super(kVar, i, bundle);
            this.aqL = iBinder;
        }

        protected final void h(ConnectionResult connectionResult) {
            if (this.aqH.aqC != null) {
                this.aqH.aqC.a(connectionResult);
            }
            k.jV();
        }

        protected final boolean jZ() {
            try {
                String interfaceDescriptor = this.aqL.getInterfaceDescriptor();
                if (this.aqH.jn().equals(interfaceDescriptor)) {
                    IInterface f = this.aqH.f(this.aqL);
                    if (f == null || !this.aqH.a(2, 3, f)) {
                        return false;
                    }
                    if (this.aqH.aqB != null) {
                        this.aqH.aqB.g(null);
                    }
                    return true;
                }
                new StringBuilder("service descriptor mismatch: ").append(this.aqH.jn()).append(" vs. ").append(interfaceDescriptor);
                return false;
            } catch (RemoteException e) {
                return false;
            }
        }
    }

    protected final class h extends a {
        final /* synthetic */ k aqH;

        public h(k kVar) {
            this.aqH = kVar;
            super(kVar, 0, null);
        }

        protected final void h(ConnectionResult connectionResult) {
            this.aqH.aqw.b(connectionResult);
            k.jV();
        }

        protected final boolean jZ() {
            this.aqH.aqw.b(ConnectionResult.alY);
            return true;
        }
    }

    protected final class i extends a {
        final /* synthetic */ k aqH;

        public i(k kVar, int i, Bundle bundle) {
            this.aqH = kVar;
            super(kVar, i, bundle);
        }

        protected final void h(ConnectionResult connectionResult) {
            this.aqH.aqw.c(connectionResult);
            k.jV();
        }

        protected final boolean jZ() {
            this.aqH.aqw.c(ConnectionResult.alY);
            return true;
        }
    }

    public k(Context context, Looper looper, int i, h hVar, com.google.android.gms.common.api.c.b bVar, com.google.android.gms.common.api.c.c cVar) {
        this(context, looper, m.B(context), com.google.android.gms.common.b.jg(), i, hVar, (com.google.android.gms.common.api.c.b) w.Z(bVar), (com.google.android.gms.common.api.c.c) w.Z(cVar));
    }

    private k(Context context, Looper looper, m mVar, com.google.android.gms.common.b bVar, int i, h hVar, com.google.android.gms.common.api.c.b bVar2, com.google.android.gms.common.api.c.c cVar) {
        this.aqu = new Object();
        this.aqy = new ArrayList();
        this.aqA = 1;
        this.aqE = new AtomicInteger(0);
        this.mContext = (Context) w.h(context, "Context must not be null");
        this.amB = (Looper) w.h(looper, "Looper must not be null");
        this.aqt = (m) w.h(mVar, "Supervisor must not be null");
        this.amC = (com.google.android.gms.common.b) w.h(bVar, "API availability must not be null");
        this.mHandler = new b(this, looper);
        this.aqD = i;
        this.anu = (h) w.Z(hVar);
        this.akV = hVar.akV;
        this.amK = b(hVar.aqm);
        this.aqB = bVar2;
        this.aqC = cVar;
    }

    private static Set<Scope> b(Set<Scope> set) {
        if (set != null) {
            for (Scope contains : set) {
                if (!set.contains(contains)) {
                    throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
                }
            }
        }
        return set;
    }

    protected static void jU() {
    }

    protected static void jV() {
    }

    private void jW() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(4, this.aqE.get(), 1));
    }

    public void a(int i, IBinder iBinder, Bundle bundle, int i2) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(1, i2, -1, new g(this, i, iBinder, bundle)));
    }

    public final void a(int i, T t) {
        boolean z = true;
        if ((i == 3) != (t != null)) {
            z = false;
        }
        w.ad(z);
        synchronized (this.aqu) {
            this.aqA = i;
            this.aqx = t;
            switch (i) {
                case 1:
                    if (this.aqz != null) {
                        this.aqt.b(jm(), jT(), this.aqz, this.anu.amu);
                        this.aqz = null;
                        break;
                    }
                    break;
                case 2:
                    if (this.aqz != null) {
                        new StringBuilder("Calling connect() while still connected, missing disconnect() for ").append(jm()).append(" on ").append(jT());
                        this.aqt.b(jm(), jT(), this.aqz, this.anu.amu);
                        this.aqE.incrementAndGet();
                    }
                    this.aqz = new e(this, this.aqE.get());
                    if (!this.aqt.a(jm(), jT(), this.aqz, this.anu.amu)) {
                        new StringBuilder("unable to connect to service: ").append(jm()).append(" on ").append(jT());
                        this.mHandler.sendMessage(this.mHandler.obtainMessage(3, this.aqE.get(), 9));
                        break;
                    }
                    break;
            }
        }
    }

    public void a(com.google.android.gms.common.api.c.e eVar) {
        this.aqw = (com.google.android.gms.common.api.c.e) w.h(eVar, "Connection progress callbacks cannot be null.");
        a(2, null);
    }

    public final void a(com.google.android.gms.common.api.c.e eVar, ConnectionResult connectionResult) {
        this.aqw = (com.google.android.gms.common.api.c.e) w.h(eVar, "Connection progress callbacks cannot be null.");
        this.mHandler.sendMessage(this.mHandler.obtainMessage(3, this.aqE.get(), connectionResult.alZ, connectionResult.ama));
    }

    public final void a(p pVar) {
        try {
            this.aqv.a(new d(this, this.aqE.get()), new ValidateAccountRequest(pVar, (Scope[]) this.amK.toArray(new Scope[this.amK.size()]), this.mContext.getPackageName(), null));
        } catch (DeadObjectException e) {
            jW();
        } catch (RemoteException e2) {
        }
    }

    public final void a(p pVar, Set<Scope> set) {
        try {
            Bundle jX = jX();
            GetServiceRequest getServiceRequest = new GetServiceRequest(this.aqD);
            getServiceRequest.apC = this.mContext.getPackageName();
            getServiceRequest.apF = jX;
            if (set != null) {
                getServiceRequest.apE = (Scope[]) set.toArray(new Scope[set.size()]);
            }
            if (jk()) {
                getServiceRequest.apG = this.akV != null ? this.akV : new Account("<<default account>>", "com.google");
                if (pVar != null) {
                    getServiceRequest.apD = pVar.asBinder();
                }
            }
            this.aqv.a(new d(this, this.aqE.get()), getServiceRequest);
        } catch (DeadObjectException e) {
            jW();
        } catch (RemoteException e2) {
        }
    }

    public final void a(String str, PrintWriter printWriter) {
        synchronized (this.aqu) {
            int i = this.aqA;
            IInterface iInterface = this.aqx;
        }
        printWriter.append(str).append("mConnectState=");
        switch (i) {
            case 1:
                printWriter.print("DISCONNECTED");
                break;
            case 2:
                printWriter.print(TMAssistantDownloadSDKClientBase.CONNTECTSTATE_CONNECTING);
                break;
            case 3:
                printWriter.print("CONNECTED");
                break;
            case 4:
                printWriter.print("DISCONNECTING");
                break;
            default:
                printWriter.print("UNKNOWN");
                break;
        }
        printWriter.append(" mService=");
        if (iInterface == null) {
            printWriter.println("null");
        } else {
            printWriter.append(jn()).append("@").println(Integer.toHexString(System.identityHashCode(iInterface.asBinder())));
        }
    }

    public final boolean a(int i, int i2, T t) {
        boolean z;
        synchronized (this.aqu) {
            if (this.aqA != i) {
                z = false;
            } else {
                a(i2, (IInterface) t);
                z = true;
            }
        }
        return z;
    }

    public void disconnect() {
        this.aqE.incrementAndGet();
        synchronized (this.aqy) {
            int size = this.aqy.size();
            for (int i = 0; i < size; i++) {
                ((c) this.aqy.get(i)).kb();
            }
            this.aqy.clear();
        }
        a(1, null);
    }

    public abstract T f(IBinder iBinder);

    public final boolean isConnected() {
        boolean z;
        synchronized (this.aqu) {
            z = this.aqA == 3;
        }
        return z;
    }

    public final boolean isConnecting() {
        boolean z;
        synchronized (this.aqu) {
            z = this.aqA == 2;
        }
        return z;
    }

    public String jT() {
        return "com.google.android.gms";
    }

    public Bundle jX() {
        return new Bundle();
    }

    public final T jY() {
        T t;
        synchronized (this.aqu) {
            if (this.aqA == 4) {
                throw new DeadObjectException();
            } else if (isConnected()) {
                w.a(this.aqx != null, "Client is connected but service is null");
                t = this.aqx;
            } else {
                throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
            }
        }
        return t;
    }

    public boolean jk() {
        return false;
    }

    public boolean jl() {
        return true;
    }

    public abstract String jm();

    public abstract String jn();
}
