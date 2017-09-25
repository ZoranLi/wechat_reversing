package com.c.a.a;

import android.content.Context;
import android.os.Handler;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.LinkedList;

abstract class d {
    boolean aJi;
    private Collection<WeakReference<m>> aJj;
    private a aJk;
    boolean isReady;
    private Handler mHandler;
    private Context ty;

    static class a {
        final long aJl;

        a(long j) {
            this.aJl = Math.max(j, 0);
        }
    }

    abstract void O(Context context);

    abstract void P(Context context);

    abstract void a(Context context, Handler handler, a aVar);

    abstract void ne();

    d() {
    }

    final void c(p pVar) {
        if (this.aJi && this.aJj != null) {
            for (WeakReference weakReference : this.aJj) {
                m mVar = (m) weakReference.get();
                if (mVar != null) {
                    mVar.a(pVar);
                }
            }
        }
    }

    final synchronized void a(Context context, m... mVarArr) {
        if (context == null) {
            throw new Exception("Module: context cannot be null");
        }
        nh();
        b(context.getApplicationContext(), mVarArr);
        this.isReady = true;
    }

    final synchronized void nh() {
        if (this.isReady) {
            stop();
            ne();
            this.isReady = false;
        }
    }

    synchronized void a(Handler handler, a aVar) {
        stop();
        this.mHandler = handler;
        this.aJk = aVar;
        a(this.ty, this.mHandler, this.aJk);
        this.aJi = true;
    }

    synchronized void stop() {
        if (this.aJi) {
            P(this.ty);
            this.mHandler = null;
            this.aJk = null;
            this.aJi = false;
        }
    }

    private void b(Context context, m... mVarArr) {
        this.ty = context;
        if (mVarArr == null) {
            this.aJj = null;
        } else {
            this.aJj = new LinkedList();
            for (Object weakReference : mVarArr) {
                this.aJj.add(new WeakReference(weakReference));
            }
        }
        O(context);
    }
}
