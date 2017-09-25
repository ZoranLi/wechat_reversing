package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.l;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.signin.internal.AuthAccountResult;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKClientBase;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;

public final class m implements p {
    public final com.google.android.gms.common.b amC;
    private final com.google.android.gms.common.api.a.a<? extends com.google.android.gms.signin.d, com.google.android.gms.signin.e> amD;
    public final o and;
    public final Lock anf;
    private ConnectionResult ang;
    private int anh;
    private int ani = 0;
    private boolean anj = false;
    private int ank;
    private final Bundle anl = new Bundle();
    private final Set<com.google.android.gms.common.api.a.c> anm = new HashSet();
    public com.google.android.gms.signin.d ann;
    private int ano;
    public boolean anp;
    boolean anq;
    public p anr;
    boolean ans;
    boolean ant;
    private final com.google.android.gms.common.internal.h anu;
    private final Map<a<?>, Integer> anv;
    private ArrayList<Future<?>> anw = new ArrayList();
    public final Context mContext;

    private abstract class i implements Runnable {
        final /* synthetic */ m anx;

        public i(m mVar) {
            this.anx = mVar;
        }

        protected abstract void jz();

        public void run() {
            this.anx.anf.lock();
            try {
                if (!Thread.interrupted()) {
                    jz();
                    this.anx.anf.unlock();
                }
            } catch (RuntimeException e) {
                o oVar = this.anx.and;
                oVar.anR.sendMessage(oVar.anR.obtainMessage(4, e));
            } finally {
                this.anx.anf.unlock();
            }
        }
    }

    private class c extends i {
        final /* synthetic */ m anx;

        public c(m mVar) {
            this.anx = mVar;
            super(mVar);
        }

        public final void jz() {
            this.anx.ann.a(this.anx.anr, this.anx.and.anV, new a(this.anx));
        }
    }

    private static class d implements com.google.android.gms.common.api.c.e {
        private final a<?> anE;
        public final int anF;
        private final WeakReference<m> any;

        public d(m mVar, a<?> aVar, int i) {
            this.any = new WeakReference(mVar);
            this.anE = aVar;
            this.anF = i;
        }

        public final void b(ConnectionResult connectionResult) {
            boolean z = false;
            m mVar = (m) this.any.get();
            if (mVar != null) {
                if (Looper.myLooper() == mVar.and.amB) {
                    z = true;
                }
                w.a(z, "onReportServiceBinding must be called on the GoogleApiClient handler thread");
                mVar.anf.lock();
                try {
                    if (mVar.bS(0)) {
                        if (!connectionResult.isSuccess()) {
                            mVar.b(connectionResult, this.anE, this.anF);
                        }
                        if (mVar.jA()) {
                            mVar.jB();
                        }
                        mVar.anf.unlock();
                    }
                } finally {
                    mVar.anf.unlock();
                }
            }
        }

        public final void c(ConnectionResult connectionResult) {
            boolean z = true;
            m mVar = (m) this.any.get();
            if (mVar != null) {
                if (Looper.myLooper() != mVar.and.amB) {
                    z = false;
                }
                w.a(z, "onReportAccountValidation must be called on the GoogleApiClient handler thread");
                mVar.anf.lock();
                try {
                    if (mVar.bS(1)) {
                        if (!connectionResult.isSuccess()) {
                            mVar.b(connectionResult, this.anE, this.anF);
                        }
                        if (mVar.jA()) {
                            mVar.jC();
                        }
                        mVar.anf.unlock();
                    }
                } finally {
                    mVar.anf.unlock();
                }
            }
        }
    }

    private class e extends i {
        private final Map<com.google.android.gms.common.api.a.b, d> anG;
        final /* synthetic */ m anx;

        public e(m mVar, Map<com.google.android.gms.common.api.a.b, d> map) {
            this.anx = mVar;
            super(mVar);
            this.anG = map;
        }

        public final void jz() {
            int i;
            int i2 = 1;
            int i3 = 0;
            int i4 = 1;
            int i5 = 0;
            for (com.google.android.gms.common.api.a.b bVar : this.anG.keySet()) {
                if (!bVar.jl()) {
                    i = 0;
                    i4 = i5;
                } else if (((d) this.anG.get(bVar)).anF == 0) {
                    i = 1;
                    break;
                } else {
                    i = i4;
                    i4 = 1;
                }
                i5 = i4;
                i4 = i;
            }
            i2 = i5;
            i = 0;
            if (i2 != 0) {
                i3 = com.google.android.gms.common.b.w(this.anx.mContext);
            }
            if (i3 == 0 || (r0 == 0 && i4 == 0)) {
                if (this.anx.anp) {
                    this.anx.ann.connect();
                }
                for (com.google.android.gms.common.api.a.b bVar2 : this.anG.keySet()) {
                    final com.google.android.gms.common.api.c.e eVar = (com.google.android.gms.common.api.c.e) this.anG.get(bVar2);
                    if (!bVar2.jl() || i3 == 0) {
                        bVar2.a(eVar);
                    } else {
                        this.anx.and.a(new b(this, this.anx) {
                            final /* synthetic */ e anI;

                            public final void jz() {
                                eVar.b(new ConnectionResult(16, null));
                            }
                        });
                    }
                }
                return;
            }
            final ConnectionResult connectionResult = new ConnectionResult(i3, null);
            this.anx.and.a(new b(this, this.anx) {
                final /* synthetic */ e anI;

                public final void jz() {
                    this.anI.anx.e(connectionResult);
                }
            });
        }
    }

    private class f extends i {
        private final ArrayList<com.google.android.gms.common.api.a.b> anK;
        final /* synthetic */ m anx;

        public f(m mVar, ArrayList<com.google.android.gms.common.api.a.b> arrayList) {
            this.anx = mVar;
            super(mVar);
            this.anK = arrayList;
        }

        public final void jz() {
            Set set = this.anx.and.anV;
            Set jH = set.isEmpty() ? this.anx.jH() : set;
            Iterator it = this.anK.iterator();
            while (it.hasNext()) {
                ((com.google.android.gms.common.api.a.b) it.next()).a(this.anx.anr, jH);
            }
        }
    }

    private class g implements com.google.android.gms.common.api.c.b, com.google.android.gms.common.api.c.c {
        final /* synthetic */ m anx;

        public g(m mVar) {
            this.anx = mVar;
        }

        public final void a(ConnectionResult connectionResult) {
            this.anx.anf.lock();
            try {
                if (this.anx.d(connectionResult)) {
                    this.anx.jF();
                    this.anx.jD();
                } else {
                    this.anx.e(connectionResult);
                }
                this.anx.anf.unlock();
            } catch (Throwable th) {
                this.anx.anf.unlock();
            }
        }

        public final void bR(int i) {
        }

        public final void g(Bundle bundle) {
            this.anx.ann.a(new b(this.anx));
        }
    }

    private class h extends i {
        private final ArrayList<com.google.android.gms.common.api.a.b> anK;
        final /* synthetic */ m anx;

        public h(m mVar, ArrayList<com.google.android.gms.common.api.a.b> arrayList) {
            this.anx = mVar;
            super(mVar);
            this.anK = arrayList;
        }

        public final void jz() {
            Iterator it = this.anK.iterator();
            while (it.hasNext()) {
                ((com.google.android.gms.common.api.a.b) it.next()).a(this.anx.anr);
            }
        }
    }

    private static class b extends com.google.android.gms.common.internal.t.a {
        private final WeakReference<m> any;

        b(m mVar) {
            this.any = new WeakReference(mVar);
        }

        public final void a(final ResolveAccountResponse resolveAccountResponse) {
            final m mVar = (m) this.any.get();
            if (mVar != null) {
                mVar.and.a(new b(this, mVar) {
                    final /* synthetic */ b anD;

                    public final void jz() {
                        m mVar = mVar;
                        ResolveAccountResponse resolveAccountResponse = resolveAccountResponse;
                        if (mVar.bS(0)) {
                            ConnectionResult connectionResult = resolveAccountResponse.aow;
                            if (connectionResult.isSuccess()) {
                                mVar.anr = com.google.android.gms.common.internal.p.a.g(resolveAccountResponse.apt);
                                mVar.anq = true;
                                mVar.ans = resolveAccountResponse.ans;
                                mVar.ant = resolveAccountResponse.apI;
                                mVar.jB();
                            } else if (mVar.d(connectionResult)) {
                                mVar.jF();
                                mVar.jB();
                            } else {
                                mVar.e(connectionResult);
                            }
                        }
                    }
                });
            }
        }
    }

    private static class a extends com.google.android.gms.signin.internal.b {
        private final WeakReference<m> any;

        a(m mVar) {
            this.any = new WeakReference(mVar);
        }

        public final void a(final ConnectionResult connectionResult, AuthAccountResult authAccountResult) {
            final m mVar = (m) this.any.get();
            if (mVar != null) {
                mVar.and.a(new b(this, mVar) {
                    final /* synthetic */ a anB;

                    public final void jz() {
                        m mVar = mVar;
                        ConnectionResult connectionResult = connectionResult;
                        if (!mVar.bS(2)) {
                            return;
                        }
                        if (connectionResult.isSuccess()) {
                            mVar.jD();
                        } else if (mVar.d(connectionResult)) {
                            mVar.jF();
                            mVar.jD();
                        } else {
                            mVar.e(connectionResult);
                        }
                    }
                });
            }
        }
    }

    public m(o oVar, com.google.android.gms.common.internal.h hVar, Map<a<?>, Integer> map, com.google.android.gms.common.b bVar, com.google.android.gms.common.api.a.a<? extends com.google.android.gms.signin.d, com.google.android.gms.signin.e> aVar, Lock lock, Context context) {
        this.and = oVar;
        this.anu = hVar;
        this.anv = map;
        this.amC = bVar;
        this.amD = aVar;
        this.anf = lock;
        this.mContext = context;
    }

    private void ab(boolean z) {
        if (this.ann != null) {
            if (this.ann.isConnected() && z) {
                this.ann.lI();
            }
            this.ann.disconnect();
            this.anr = null;
        }
    }

    private static String bT(int i) {
        switch (i) {
            case 0:
                return "STEP_GETTING_SERVICE_BINDINGS";
            case 1:
                return "STEP_VALIDATING_ACCOUNT";
            case 2:
                return "STEP_AUTHENTICATING";
            case 3:
                return "STEP_GETTING_REMOTE_SERVICE";
            default:
                return "UNKNOWN";
        }
    }

    private void jE() {
        boolean z = true;
        o oVar = this.and;
        oVar.anf.lock();
        try {
            oVar.jJ();
            oVar.anW = new l(oVar);
            oVar.anW.begin();
            oVar.anL.signalAll();
            q.jK().execute(new Runnable(this) {
                final /* synthetic */ m anx;

                {
                    this.anx = r1;
                }

                public final void run() {
                    com.google.android.gms.common.b.x(this.anx.mContext);
                }
            });
            if (this.ann != null) {
                if (this.ans) {
                    this.ann.a(this.anr, this.ant);
                }
                ab(false);
            }
            for (com.google.android.gms.common.api.a.c cVar : this.and.anU.keySet()) {
                ((com.google.android.gms.common.api.a.b) this.and.anT.get(cVar)).disconnect();
            }
            if (this.anj) {
                this.anj = false;
                disconnect();
                return;
            }
            Bundle bundle = this.anl.isEmpty() ? null : this.anl;
            l lVar = this.and.anM;
            w.a(Looper.myLooper() == lVar.mHandler.getLooper(), "onConnectionSuccess must only be called on the Handler thread");
            synchronized (lVar.aqu) {
                w.ac(!lVar.aqS);
                lVar.mHandler.removeMessages(1);
                lVar.aqS = true;
                if (lVar.aqO.size() != 0) {
                    z = false;
                }
                w.ac(z);
                ArrayList arrayList = new ArrayList(lVar.aqN);
                int i = lVar.aqR.get();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    com.google.android.gms.common.api.c.b bVar = (com.google.android.gms.common.api.c.b) it.next();
                    if (lVar.aqQ && lVar.aqM.isConnected() && lVar.aqR.get() == i) {
                        if (!lVar.aqO.contains(bVar)) {
                            bVar.g(bundle);
                        }
                    }
                }
                lVar.aqO.clear();
                lVar.aqS = false;
            }
        } finally {
            oVar.anf.unlock();
        }
    }

    private void jG() {
        Iterator it = this.anw.iterator();
        while (it.hasNext()) {
            ((Future) it.next()).cancel(true);
        }
        this.anw.clear();
    }

    public final <A extends com.google.android.gms.common.api.a.b, R extends g, T extends com.google.android.gms.common.api.k.a<R, A>> T a(T t) {
        this.and.anN.add(t);
        return t;
    }

    public final void a(ConnectionResult connectionResult, a<?> aVar, int i) {
        if (bS(3)) {
            b(connectionResult, aVar, i);
            if (jA()) {
                jE();
            }
        }
    }

    public final <A extends com.google.android.gms.common.api.a.b, T extends com.google.android.gms.common.api.k.a<? extends g, A>> T b(T t) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(com.google.android.gms.common.ConnectionResult r5, com.google.android.gms.common.api.a<?> r6, int r7) {
        /*
        r4 = this;
        r3 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;
        r1 = 0;
        r0 = 1;
        r2 = 2;
        if (r7 == r2) goto L_0x0024;
    L_0x0008:
        r6.jh();
        if (r7 != r0) goto L_0x0016;
    L_0x000d:
        r2 = r5.jf();
        if (r2 == 0) goto L_0x0030;
    L_0x0013:
        r2 = r0;
    L_0x0014:
        if (r2 == 0) goto L_0x003c;
    L_0x0016:
        r2 = r4.ang;
        if (r2 == 0) goto L_0x001e;
    L_0x001a:
        r2 = r4.anh;
        if (r3 >= r2) goto L_0x003c;
    L_0x001e:
        if (r0 == 0) goto L_0x0024;
    L_0x0020:
        r4.ang = r5;
        r4.anh = r3;
    L_0x0024:
        r0 = r4.and;
        r0 = r0.anU;
        r1 = r6.ji();
        r0.put(r1, r5);
        return;
    L_0x0030:
        r2 = r5.alZ;
        r2 = com.google.android.gms.common.b.bN(r2);
        if (r2 == 0) goto L_0x003a;
    L_0x0038:
        r2 = r0;
        goto L_0x0014;
    L_0x003a:
        r2 = r1;
        goto L_0x0014;
    L_0x003c:
        r0 = r1;
        goto L_0x001e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.m.b(com.google.android.gms.common.ConnectionResult, com.google.android.gms.common.api.a, int):void");
    }

    public final void bR(int i) {
        e(new ConnectionResult(8, null));
    }

    public final boolean bS(int i) {
        if (this.ani == i) {
            return true;
        }
        Log.wtf("GoogleApiClientConnecting", "GoogleApiClient connecting is in step " + bT(this.ani) + " but received callback for step " + bT(i));
        e(new ConnectionResult(8, null));
        return false;
    }

    public final void begin() {
        this.and.anM.aqQ = true;
        this.and.anU.clear();
        this.anj = false;
        this.anp = false;
        this.ang = null;
        this.ani = 0;
        this.ano = 2;
        this.anq = false;
        this.ans = false;
        Map hashMap = new HashMap();
        for (a aVar : this.anv.keySet()) {
            com.google.android.gms.common.api.a.b bVar = (com.google.android.gms.common.api.a.b) this.and.anT.get(aVar.ji());
            int intValue = ((Integer) this.anv.get(aVar)).intValue();
            aVar.jh();
            if (bVar.jk()) {
                this.anp = true;
                if (intValue < this.ano) {
                    this.ano = intValue;
                }
                if (intValue != 0) {
                    this.anm.add(aVar.ji());
                }
            }
            hashMap.put(bVar, new d(this, aVar, intValue));
        }
        if (this.anp) {
            this.anu.aqp = Integer.valueOf(System.identityHashCode(this.and));
            com.google.android.gms.common.api.c.b gVar = new g(this);
            this.ann = (com.google.android.gms.signin.d) this.amD.a(this.mContext, this.and.amB, this.anu, this.anu.aqo, gVar, gVar);
        }
        this.ank = this.and.anT.size();
        this.anw.add(q.jK().submit(new e(this, hashMap)));
    }

    public final void connect() {
        this.anj = false;
    }

    public final boolean d(ConnectionResult connectionResult) {
        return this.ano != 2 ? this.ano == 1 && !connectionResult.jf() : true;
    }

    public final void disconnect() {
        Iterator it = this.and.anN.iterator();
        while (it.hasNext()) {
            ((e) it.next()).cancel();
            it.remove();
        }
        this.and.jI();
        if (this.ang != null || this.and.anN.isEmpty()) {
            jG();
            ab(true);
            this.and.anU.clear();
            this.and.f(null);
            this.and.anM.kc();
            return;
        }
        this.anj = true;
    }

    public final void e(ConnectionResult connectionResult) {
        boolean z = false;
        this.anj = false;
        jG();
        ab(!connectionResult.jf());
        this.and.anU.clear();
        this.and.f(connectionResult);
        if (!this.and.anO || !com.google.android.gms.common.b.k(this.mContext, connectionResult.alZ)) {
            this.and.jJ();
            l lVar = this.and.anM;
            if (Looper.myLooper() == lVar.mHandler.getLooper()) {
                z = true;
            }
            w.a(z, "onConnectionFailure must only be called on the Handler thread");
            lVar.mHandler.removeMessages(1);
            synchronized (lVar.aqu) {
                ArrayList arrayList = new ArrayList(lVar.aqP);
                int i = lVar.aqR.get();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    com.google.android.gms.common.api.c.c cVar = (com.google.android.gms.common.api.c.c) it.next();
                    if (!lVar.aqQ || lVar.aqR.get() != i) {
                        break;
                    } else if (lVar.aqP.contains(cVar)) {
                        cVar.a(connectionResult);
                    }
                }
            }
        }
        this.and.anM.kc();
    }

    public final void g(Bundle bundle) {
        if (bS(3)) {
            if (bundle != null) {
                this.anl.putAll(bundle);
            }
            if (jA()) {
                jE();
            }
        }
    }

    public final String getName() {
        return TMAssistantDownloadSDKClientBase.CONNTECTSTATE_CONNECTING;
    }

    public final boolean jA() {
        this.ank--;
        if (this.ank > 0) {
            return false;
        }
        if (this.ank < 0) {
            Log.wtf("GoogleApiClientConnecting", "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.");
            e(new ConnectionResult(8, null));
            return false;
        } else if (this.ang == null) {
            return true;
        } else {
            e(this.ang);
            return false;
        }
    }

    public final void jB() {
        if (this.ank == 0) {
            if (!this.anp) {
                jD();
            } else if (this.anq) {
                ArrayList arrayList = new ArrayList();
                this.ani = 1;
                this.ank = this.and.anT.size();
                for (com.google.android.gms.common.api.a.c cVar : this.and.anT.keySet()) {
                    if (!this.and.anU.containsKey(cVar)) {
                        arrayList.add(this.and.anT.get(cVar));
                    } else if (jA()) {
                        jC();
                    }
                }
                if (!arrayList.isEmpty()) {
                    this.anw.add(q.jK().submit(new h(this, arrayList)));
                }
            }
        }
    }

    public final void jC() {
        this.ani = 2;
        this.and.anV = jH();
        this.anw.add(q.jK().submit(new c(this)));
    }

    public final void jD() {
        ArrayList arrayList = new ArrayList();
        this.ani = 3;
        this.ank = this.and.anT.size();
        for (com.google.android.gms.common.api.a.c cVar : this.and.anT.keySet()) {
            if (!this.and.anU.containsKey(cVar)) {
                arrayList.add(this.and.anT.get(cVar));
            } else if (jA()) {
                jE();
            }
        }
        if (!arrayList.isEmpty()) {
            this.anw.add(q.jK().submit(new f(this, arrayList)));
        }
    }

    public final void jF() {
        this.anp = false;
        this.and.anV = Collections.emptySet();
        for (com.google.android.gms.common.api.a.c cVar : this.anm) {
            if (!this.and.anU.containsKey(cVar)) {
                this.and.anU.put(cVar, new ConnectionResult(17, null));
            }
        }
    }

    public final Set<Scope> jH() {
        Set<Scope> hashSet = new HashSet(this.anu.amq);
        Map map = this.anu.aqn;
        for (a aVar : map.keySet()) {
            if (!this.and.anU.containsKey(aVar.ji())) {
                hashSet.addAll(((com.google.android.gms.common.internal.h.a) map.get(aVar)).amK);
            }
        }
        return hashSet;
    }
}
