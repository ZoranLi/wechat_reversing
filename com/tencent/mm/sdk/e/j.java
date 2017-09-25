package com.tencent.mm.sdk.e;

import android.os.Looper;

public abstract class j implements f {
    public final k<a, l> uxh = new k<a, l>(this) {
        final /* synthetic */ j uxj;

        {
            this.uxj = r1;
        }

        protected final /* synthetic */ void o(Object obj, Object obj2) {
            l lVar = (l) obj2;
            ((a) obj).a(lVar.fDz, lVar);
        }
    };
    private final k<Object, String> uxi = new k<Object, String>(this) {
        final /* synthetic */ j uxj;

        {
            this.uxj = r1;
        }

        protected final /* bridge */ /* synthetic */ void o(Object obj, Object obj2) {
        }
    };

    public interface a {
        void a(String str, l lVar);
    }

    public void lock() {
        this.uxh.lock();
    }

    public void unlock() {
        this.uxh.unlock();
    }

    public void c(a aVar) {
        this.uxh.a(aVar, Looper.getMainLooper());
    }

    public final void a(a aVar, Looper looper) {
        this.uxh.a(aVar, looper);
    }

    public final void f(a aVar) {
        this.uxh.remove(aVar);
    }

    public final void doNotify() {
        this.uxh.by(new l("*"));
        this.uxh.doNotify();
    }

    public final void Qr(String str) {
        this.uxh.by(new l(str));
        this.uxh.doNotify();
    }

    public final void a(String str, int i, Object obj) {
        l lVar = new l();
        lVar.fDz = str;
        lVar.uxq = i;
        lVar.obj = obj;
        lVar.uxr = this;
        this.uxh.by(lVar);
        this.uxh.doNotify();
    }
}
