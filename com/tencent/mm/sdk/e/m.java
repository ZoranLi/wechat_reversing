package com.tencent.mm.sdk.e;

import android.os.Looper;

public abstract class m implements g {
    private final k<b, a> uxh = new k<b, a>(this) {
        final /* synthetic */ m uxs;

        {
            this.uxs = r1;
        }

        protected final /* synthetic */ void o(Object obj, Object obj2) {
            b bVar = (b) obj;
            a aVar = (a) obj2;
            if (this.uxs.Fc()) {
                bVar.a(aVar.fLa, aVar.uxt, aVar.obj);
            }
        }
    };

    private class a {
        int fLa;
        Object obj;
        final /* synthetic */ m uxs;
        m uxt;

        a(m mVar, int i, m mVar2, Object obj) {
            this.uxs = mVar;
            this.fLa = i;
            this.obj = obj;
            this.uxt = mVar2;
        }
    }

    public interface b {
        void a(int i, m mVar, Object obj);
    }

    public abstract boolean Fc();

    public final void a(b bVar) {
        if (bVar != null) {
            this.uxh.a(bVar, Looper.getMainLooper());
        }
    }

    public final void b(b bVar) {
        if (bVar != null) {
            this.uxh.remove(bVar);
        }
    }

    public final void b(int i, m mVar, Object obj) {
        this.uxh.by(new a(this, i, mVar, obj));
        this.uxh.doNotify();
    }
}
