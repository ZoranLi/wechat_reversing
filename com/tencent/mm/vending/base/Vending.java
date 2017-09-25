package com.tencent.mm.vending.base;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class Vending<_Struct, _Index, _Change> implements com.tencent.mm.vending.e.a {
    private static final int MESSAGE_DO_DESTROY = 2;
    private static final int MESSAGE_NOTIFY_DATA_LOADED = 1;
    private static final int MESSAGE_PREPARE_VENDING_DATA = 1;
    private static final int SYNC_MESSAGE_APPLY_CHANGE = 1;
    private static final int SYNC_MESSAGE_CLEAR_RESOLVED_ONLY = 3;
    private static final int SYNC_MESSAGE_PREPARE_DATA_DEGRADE = 2;
    private static final String TAG = "Vending";
    public g<_Index, i<_Struct, _Index>> mArray;
    private byte[] mArrayDataLock;
    private AtomicBoolean mCallDestroyed;
    public volatile com.tencent.mm.vending.b.c mDataChangedCallback;
    private volatile com.tencent.mm.vending.b.c mDataResolvedCallback;
    private c<_Index> mDeadlock;
    private boolean mFreezeDataChange;
    private boolean mHasPendingDataChange;
    public f mLoader;
    private byte[] mPendingDataChangeLock;
    private boolean mResolveFromVending;
    public Handler mSubscriberHandler;
    private Looper mSubscriberLooper;
    HashSet<h> mVendingDeferring;
    public Handler mVendingHandler;
    public Looper mVendingLooper;
    private c mVendingSync;

    private static final class a<T> {
        volatile T zk;
    }

    private interface b {
        void cbt();
    }

    private static final class c<_Index> {
        a<_Index> wCb = new a();
        i wCc;

        public final void reset() {
            this.wCb.zk = null;
            this.wCc = null;
        }
    }

    public interface d {
        void bla();
    }

    public interface e<_Index> {
        void bG(_Index _Index);
    }

    public static final class f<_Index> {
        public AtomicBoolean iAu = new AtomicBoolean(false);
        Handler mVendingHandler;
        HashMap<_Index, b> wCd = new HashMap();
        public a<_Index> wCe = null;
        byte[] wCf = new byte[0];

        protected interface a<_Index> {
            void bH(_Index _Index);

            void cancel();
        }

        public enum b {
            NIL,
            PENDING,
            FILLED
        }

        protected f(Looper looper, a<_Index> aVar) {
            this.wCe = aVar;
            this.mVendingHandler = new Handler(this, looper) {
                final /* synthetic */ f wCg;

                public final void handleMessage(Message message) {
                    if (this.wCg.iAu.get()) {
                        this.wCg.wCe.cancel();
                        return;
                    }
                    Object obj = message.obj;
                    this.wCg.wCe.bH(obj);
                    synchronized (this.wCg.wCf) {
                        this.wCg.wCd.put(obj, b.FILLED);
                    }
                }
            };
        }

        protected final void cbw() {
            this.mVendingHandler.removeCallbacksAndMessages(null);
            com.tencent.mm.vending.f.a.i("Vending.Loader", "clear()", new Object[0]);
            synchronized (this.wCf) {
                this.wCd.clear();
            }
            this.wCe.cancel();
        }
    }

    static class g<K, V> extends HashMap<K, V> {
        b wCl = null;

        g() {
        }

        public final void clear() {
            super.clear();
            if (this.wCl != null) {
                this.wCl.cbt();
            }
        }
    }

    public class h {
        final /* synthetic */ Vending wCa;
        public _Index wCm;

        h(Vending vending, _Index _Index) {
            this.wCa = vending;
            this.wCm = _Index;
        }
    }

    static final class i<_Struct, _Index> {
        public byte[] gWC = new byte[0];
        public boolean jc = false;
        public boolean wBM = false;
        public _Index wCm;
        public _Struct wCn;
        public boolean wCo = false;
        public boolean wCp = false;
        public boolean wCq = false;

        i() {
        }
    }

    public abstract void applyChangeSynchronized(_Change _Change);

    public abstract void destroyAsynchronous();

    public abstract _Change prepareVendingDataAsynchronous();

    public abstract _Struct resolveAsynchronous(_Index _Index);

    f<_Index> getLoader() {
        return this.mLoader;
    }

    public void addVendingDataChangedCallback(d dVar) {
        this.mDataChangedCallback.bI(dVar);
    }

    public void addVendingDataResolvedCallback(e eVar) {
        this.mDataResolvedCallback.bI(eVar);
    }

    public Vending() {
        this(Looper.getMainLooper());
    }

    public Vending(Looper looper) {
        this.mCallDestroyed = new AtomicBoolean(false);
        this.mArrayDataLock = new byte[0];
        this.mPendingDataChangeLock = new byte[0];
        this.mHasPendingDataChange = false;
        this.mFreezeDataChange = false;
        this.mDeadlock = new c();
        this.mDataChangedCallback = new com.tencent.mm.vending.b.c<d>(this, com.tencent.mm.vending.h.d.wDA) {
            final /* synthetic */ Vending wCa;

            public final /* synthetic */ void a(Object obj, com.tencent.mm.vending.j.a aVar) {
                ((d) obj).bla();
            }
        };
        this.mDataResolvedCallback = new com.tencent.mm.vending.b.c<e>(this, com.tencent.mm.vending.h.d.wDA) {
            final /* synthetic */ Vending wCa;

            public final /* synthetic */ void a(Object obj, com.tencent.mm.vending.j.a aVar) {
                ((e) obj).bG(aVar.get(0));
            }
        };
        this.mArray = new g();
        this.mVendingDeferring = new HashSet();
        this.mResolveFromVending = false;
        this.mSubscriberLooper = looper;
        this.mVendingLooper = com.tencent.mm.vending.i.b.cbO().wDJ.getLooper();
        this.mArray.wCl = new b(this) {
            final /* synthetic */ Vending wCa;

            {
                this.wCa = r1;
            }

            public final void cbt() {
                com.tencent.mm.vending.f.a.i(Vending.TAG, "SafeSparseArray fusing.", new Object[0]);
                this.wCa.deadlock();
            }
        };
        this.mVendingSync = new c(this.mSubscriberLooper, this.mVendingLooper);
        this.mVendingSync.wCu = new com.tencent.mm.vending.base.c.a(this) {
            final /* synthetic */ Vending wCa;

            {
                this.wCa = r1;
            }

            public final void cbu() {
                com.tencent.mm.vending.f.a.i(Vending.TAG, "%s beforeSynchronize", new Object[]{this.wCa});
                this.wCa.mLoader.cbw();
            }

            public final void synchronizing(int i, Object obj) {
                com.tencent.mm.vending.f.a.i(Vending.TAG, "%s synchronizing", new Object[]{this.wCa});
                this.wCa.mVendingDeferring.clear();
                this.wCa.mLoader.cbw();
                this.wCa.mSubscriberHandler.removeCallbacksAndMessages(null);
                if (i == 2) {
                    obj = this.wCa.prepareVendingDataAsynchronous();
                }
                if (i == 2 || i == 1) {
                    this.wCa.applyChangeSynchronized(obj);
                }
                this.wCa.synchronizing(i, obj);
                this.wCa.mArray.clear();
            }

            public final void cbv() {
                com.tencent.mm.vending.f.a.i(Vending.TAG, "%s afterSynchronize", new Object[]{this.wCa});
                if (this.wCa.mDataChangedCallback != null) {
                    this.wCa.mDataChangedCallback.cby();
                }
            }
        };
        this.mSubscriberHandler = new Handler(this, this.mSubscriberLooper) {
            final /* synthetic */ Vending wCa;

            public final void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        i iVar = (i) message.obj;
                        this.wCa.onDataResolved(iVar.wCm, iVar.wCn);
                        return;
                    default:
                        return;
                }
            }
        };
        this.mVendingHandler = new Handler(this, this.mVendingLooper) {
            final /* synthetic */ Vending wCa;

            public final void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        this.wCa.callPrepareVendingData();
                        return;
                    case 2:
                        this.wCa.destroyAsynchronous();
                        return;
                    default:
                        return;
                }
            }
        };
        this.mLoader = new f(this.mVendingLooper, new a<_Index>(this) {
            final /* synthetic */ Vending wCa;

            {
                this.wCa = r1;
            }

            public final void bH(_Index _Index) {
                i lock = this.wCa.getLock(_Index);
                boolean loadFromVending = this.wCa.loadFromVending(lock, _Index);
                if (lock.wBM) {
                    com.tencent.mm.vending.f.a.d(Vending.TAG, "This lock is defer to return %s %s", new Object[]{lock, _Index});
                } else if (!loadFromVending) {
                    this.wCa.notifyDataLoadedIfNeed(lock);
                }
            }

            public final void cancel() {
                this.wCa.loaderClear();
                this.wCa.deadlock();
            }
        });
    }

    public void notifyDataLoadedIfNeed(i<_Struct, _Index> iVar) {
        if (iVar.wCq) {
            iVar.wCq = false;
        } else {
            this.mSubscriberHandler.sendMessage(this.mSubscriberHandler.obtainMessage(1, iVar));
        }
    }

    protected void synchronizing(int i, Object obj) {
    }

    protected i<_Struct, _Index> getLock(_Index _Index) {
        i<_Struct, _Index> iVar;
        synchronized (this.mArrayDataLock) {
            iVar = (i) this.mArray.get(_Index);
            if (iVar == null) {
                iVar = new i();
                this.mArray.put(_Index, iVar);
            }
        }
        return iVar;
    }

    protected i<_Struct, _Index> peekLock(_Index _Index) {
        i<_Struct, _Index> iVar;
        synchronized (this.mArrayDataLock) {
            iVar = (i) this.mArray.get(_Index);
        }
        return iVar;
    }

    public h defer(_Index _Index) {
        looperCheckForVending();
        if (this.mResolveFromVending) {
            getLock(_Index).wBM = true;
            h hVar = new h(this, _Index);
            this.mVendingDeferring.add(hVar);
            return hVar;
        }
        com.tencent.mm.vending.f.a.w(TAG, "Please call defer in resolveAsynchronous()", new Object[0]);
        return null;
    }

    public void deferResolved(h hVar, _Index _Index, _Struct _Struct) {
        if (this.mVendingDeferring.contains(hVar)) {
            i lock = getLock(_Index);
            synchronized (lock.gWC) {
                lock.wBM = false;
                lockResolved(lock, _Index, _Struct);
            }
            notifyDataLoadedIfNeed(lock);
        }
    }

    public <T> T peek(_Index _Index) {
        if (this.mCallDestroyed.get() || invalidIndex(_Index)) {
            return null;
        }
        i peekLock = peekLock(_Index);
        if (peekLock == null || peekLock.jc) {
            return null;
        }
        return peekLock.wCn;
    }

    public <T> T get(_Index _Index) {
        return getSync(_Index);
    }

    private _Struct getSync(_Index _Index) {
        Looper myLooper = Looper.myLooper();
        if (myLooper != this.mSubscriberLooper && myLooper != this.mVendingLooper) {
            throw new IllegalAccessError("Call from wrong looper");
        } else if (this.mCallDestroyed.get()) {
            return null;
        } else {
            i lock = getLock(_Index);
            if (invalidIndex(_Index)) {
                return lock.wCn;
            }
            if (myLooper == this.mSubscriberLooper) {
                return forSubscriberSync(lock, _Index).wCn;
            }
            loadFromVending(lock, _Index);
            return lock.wCn;
        }
    }

    private void lockResolved(i<_Struct, _Index> iVar, _Index _Index, _Struct _Struct) {
        iVar.wCn = _Struct;
        iVar.wCm = _Index;
        iVar.jc = false;
        iVar.wCo = false;
        iVar.wCp = true;
        if (this.mDeadlock.wCc == iVar) {
            iVar.wCq = true;
        }
        iVar.gWC.notify();
    }

    public boolean loadFromVending(i<_Struct, _Index> iVar, _Index _Index) {
        synchronized (iVar.gWC) {
            if (!iVar.wCp || iVar.jc || iVar.wCo) {
                this.mResolveFromVending = true;
                Object resolveAsynchronous = resolveAsynchronous(_Index);
                this.mResolveFromVending = false;
                if (iVar.wBM) {
                    return false;
                }
                lockResolved(iVar, _Index, resolveAsynchronous);
                return false;
            }
            return true;
        }
    }

    private i<_Struct, _Index> forSubscriberSync(i<_Struct, _Index> iVar, _Index _Index) {
        if (com.tencent.mm.vending.i.b.cbO().wDJ.isAlive()) {
            synchronized (iVar.gWC) {
                boolean requestIndex = requestIndex(iVar, _Index);
                if (!iVar.wCp || iVar.jc) {
                    if (requestIndex) {
                        this.mDeadlock.wCb.zk = _Index;
                        this.mDeadlock.wCc = iVar;
                        com.tencent.mm.vending.f.a.i(TAG, "%s waiting %s", new Object[]{this, _Index});
                        long nanoTime = System.nanoTime();
                        try {
                            iVar.gWC.wait();
                        } catch (InterruptedException e) {
                        }
                        nanoTime = System.nanoTime() - nanoTime;
                        com.tencent.mm.vending.f.a.i(TAG, "%s waiting duration %s", new Object[]{this, Long.valueOf(nanoTime)});
                        this.mDeadlock.reset();
                    }
                }
            }
        } else {
            com.tencent.mm.vending.f.a.e(TAG, "Vending thread is not running!", new Object[0]);
        }
        return iVar;
    }

    protected boolean invalidIndex(_Index _Index) {
        return false;
    }

    private _Struct getAsync(_Index _Index) {
        if (invalidIndex(_Index)) {
            return null;
        }
        i lock = getLock(_Index);
        if (!requestIndex(lock, _Index) || lock.jc) {
            return null;
        }
        return lock.wCn;
    }

    public void request(_Index _Index) {
        refillImpl(_Index, false);
    }

    public void requestConsistent(_Index _Index) {
        refillImpl(_Index, true);
    }

    private void refillImpl(_Index _Index, boolean z) {
        looperCheckBoth();
        if (!this.mCallDestroyed.get()) {
            i lock = getLock(_Index);
            synchronized (lock.gWC) {
                if (lock.wCp) {
                    if (z) {
                        lock.jc = true;
                    } else {
                        lock.wCo = true;
                    }
                }
            }
            getAsync(_Index);
        }
    }

    public void resolvedClear() {
        looperCheckBoth();
        if (!this.mCallDestroyed.get()) {
            this.mVendingSync.i(3, null);
        }
    }

    public void notifyVendingDataChange() {
        notifyVendingDataChange(false);
    }

    public void notifyVendingDataChangeSynchronize() {
        notifyVendingDataChange(true);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void notifyVendingDataChange(boolean r4) {
        /*
        r3 = this;
        r2 = 1;
        r0 = r3.mCallDestroyed;
        r0 = r0.get();
        if (r0 == 0) goto L_0x000a;
    L_0x0009:
        return;
    L_0x000a:
        r0 = android.os.Looper.myLooper();
        r1 = r3.mSubscriberLooper;
        if (r0 == r1) goto L_0x0023;
    L_0x0012:
        r0 = android.os.Looper.myLooper();
        r1 = r3.mVendingLooper;
        if (r0 == r1) goto L_0x0023;
    L_0x001a:
        r0 = new java.lang.IllegalAccessError;
        r1 = "Call from wrong thread";
        r0.<init>(r1);
        throw r0;
    L_0x0023:
        if (r4 == 0) goto L_0x002d;
    L_0x0025:
        r0 = r3.mVendingSync;
        r1 = 2;
        r2 = 0;
        r0.i(r1, r2);
        goto L_0x0009;
    L_0x002d:
        r1 = r3.mPendingDataChangeLock;
        monitor-enter(r1);
        r0 = r3.mFreezeDataChange;	 Catch:{ all -> 0x0039 }
        if (r0 == 0) goto L_0x003c;
    L_0x0034:
        r0 = 1;
        r3.mHasPendingDataChange = r0;	 Catch:{ all -> 0x0039 }
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        goto L_0x0009;
    L_0x0039:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        throw r0;
    L_0x003c:
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        r0 = android.os.Looper.myLooper();
        r1 = r3.mVendingLooper;
        if (r0 != r1) goto L_0x0049;
    L_0x0045:
        r3.callPrepareVendingData();
        goto L_0x0009;
    L_0x0049:
        r0 = r3.mVendingHandler;
        r0.removeMessages(r2);
        r0 = r3.mVendingHandler;
        r1 = r3.mVendingHandler;
        r1 = r1.obtainMessage(r2);
        r0.sendMessage(r1);
        r0 = r3.mVendingHandler;
        r1 = new com.tencent.mm.vending.base.Vending$8;
        r1.<init>(r3);
        r0.post(r1);
        goto L_0x0009;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.vending.base.Vending.notifyVendingDataChange(boolean):void");
    }

    public void freezeDataChange() {
        if (!this.mCallDestroyed.get()) {
            synchronized (this.mPendingDataChangeLock) {
                this.mFreezeDataChange = true;
            }
        }
    }

    public void unfreezeDataChange() {
        if (!this.mCallDestroyed.get()) {
            synchronized (this.mPendingDataChangeLock) {
                this.mFreezeDataChange = false;
                if (this.mHasPendingDataChange) {
                    notifyVendingDataChange();
                    this.mHasPendingDataChange = false;
                }
            }
        }
    }

    protected void loaderClear() {
    }

    public void deadlock() {
        if (this.mDeadlock.wCb.zk != null) {
            com.tencent.mm.vending.f.a.e(TAG, "Catch deadlock! Tell Carl! .. " + this.mDeadlock.wCb.zk, new Object[0]);
            if (this.mDeadlock.wCc != null) {
                synchronized (this.mDeadlock.wCc.gWC) {
                    this.mDeadlock.wCc.gWC.notify();
                }
                this.mDeadlock.reset();
            }
        }
    }

    protected void requestIndexImpl(i<_Struct, _Index> iVar, _Index _Index) {
    }

    private boolean requestIndex(i<_Struct, _Index> iVar, _Index _Index) {
        if (invalidIndex(_Index)) {
            return false;
        }
        if (this.mCallDestroyed.get()) {
            com.tencent.mm.vending.f.a.e(TAG, "Vending.destroyed() has called.", new Object[0]);
            return false;
        }
        f fVar = this.mLoader;
        if (!fVar.iAu.get()) {
            synchronized (fVar.wCf) {
                fVar.wCd.put(_Index, b.PENDING);
            }
            fVar.mVendingHandler.sendMessageAtFrontOfQueue(fVar.mVendingHandler.obtainMessage(0, _Index));
        }
        requestIndexImpl(iVar, _Index);
        return true;
    }

    public void callPrepareVendingData() {
        if (!this.mCallDestroyed.get()) {
            com.tencent.mm.vending.f.a.i(TAG, "Vending.callPrepareVendingData()", new Object[0]);
            this.mVendingSync.i(1, prepareVendingDataAsynchronous());
        }
    }

    public Looper getLooper() {
        return this.mVendingLooper;
    }

    public final void dead() {
        looperCheckBoth();
        com.tencent.mm.vending.f.a.i(TAG, "Vending.destroy()", new Object[0]);
        this.mCallDestroyed.set(true);
        this.mVendingHandler.removeCallbacksAndMessages(null);
        this.mSubscriberHandler.removeCallbacksAndMessages(null);
        this.mLoader.iAu.set(true);
        this.mLoader.cbw();
        this.mVendingHandler.sendMessage(this.mVendingHandler.obtainMessage(2));
    }

    public void onDataResolved(_Index _Index, _Struct _Struct) {
        if (!this.mCallDestroyed.get() && this.mDataResolvedCallback != null) {
            this.mDataResolvedCallback.a(com.tencent.mm.vending.g.g.bO(_Index));
        }
    }

    public void looperCheckForVending() {
        if (Looper.myLooper() != this.mVendingLooper) {
            throw new IllegalAccessError("Call from wrong looper");
        }
    }

    protected void looperCheckForSubscriber() {
        if (Looper.myLooper() != this.mSubscriberLooper) {
            throw new IllegalAccessError("Call from wrong looper");
        }
    }

    protected void looperCheckBoth() {
        Looper myLooper = Looper.myLooper();
        if (myLooper != this.mSubscriberLooper && myLooper != this.mVendingLooper) {
            throw new IllegalAccessError("Call from wrong looper");
        }
    }
}
