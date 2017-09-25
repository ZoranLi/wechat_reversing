package com.tencent.mm.vending.app;

import android.content.Context;
import android.os.Looper;
import com.tencent.mm.vending.base.Vending;
import com.tencent.mm.vending.base.Vending.h;
import com.tencent.mm.vending.e.c;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.h.d;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import junit.framework.Assert;

public abstract class a implements com.tencent.mm.vending.e.b {
    Context mContext;
    private c wBC = new c();
    public c<Vending> wBD = new c();
    public Map<Class, a> wBE = new ConcurrentHashMap();
    byte[] wBF = new byte[0];
    public com.tencent.mm.vending.base.a<Object> wBG = new com.tencent.mm.vending.base.a<Object>(this) {
        final /* synthetic */ a wBL;

        {
            this.wBL = r1;
        }

        protected final /* synthetic */ Object resolveAsynchronous(Object obj) {
            return A((Class) obj);
        }

        protected final Object A(Class<?> cls) {
            a aVar = (a) this.wBL.wBE.get(cls);
            if (aVar != null) {
                aVar.wBN = true;
                Object NX = aVar.NX();
                aVar.wBN = false;
                if (!aVar.wBM) {
                    return NX;
                }
                aVar.wBO = defer(cls);
            }
            return null;
        }
    };
    private AtomicBoolean wBH = new AtomicBoolean(false);
    boolean wBI = false;
    public Map<Class, com.tencent.mm.vending.b.c<b>> wBJ = new HashMap();
    public com.tencent.mm.vending.d.a wBK;

    public abstract class a<_Struct> {
        final /* synthetic */ a wBL;
        boolean wBM = false;
        public boolean wBN = false;
        h wBO;

        public abstract _Struct NX();

        public a(a aVar) {
            this.wBL = aVar;
        }
    }

    public interface b<_Struct> {
        void aE(_Struct _Struct);
    }

    public a() {
        this.wBD.a(this.wBG);
        this.wBG.addVendingDataResolvedCallback(new com.tencent.mm.vending.base.a.a(this) {
            final /* synthetic */ a wBL;

            {
                this.wBL = r1;
            }

            public final /* synthetic */ void bG(Object obj) {
                Class cls = (Class) obj;
                com.tencent.mm.vending.b.c cVar = (com.tencent.mm.vending.b.c) this.wBL.wBJ.get(cls);
                if (cVar != null) {
                    cVar.a(g.bO(this.wBL.wBG.get(cls)));
                }
            }
        });
    }

    public final void a(com.tencent.mm.vending.e.a aVar) {
        Assert.assertTrue("target must be a ILifeCycle", aVar instanceof com.tencent.mm.vending.e.a);
        this.wBC.a(aVar);
    }

    public final <_Struct> void a(Class<_Struct> cls, b<_Struct> bVar) {
        com.tencent.mm.vending.b.c cVar = (com.tencent.mm.vending.b.c) this.wBJ.get(cls);
        if (cVar == null) {
            cVar = new com.tencent.mm.vending.b.c<b>(this, d.wDA) {
                final /* synthetic */ a wBL;

                public final /* synthetic */ void a(Object obj, com.tencent.mm.vending.j.a aVar) {
                    ((b) obj).aE(aVar.get(0));
                }
            };
            this.wBJ.put(cls, cVar);
        }
        cVar.bI(bVar);
        Object peek = this.wBG.peek(cls);
        if (peek != null) {
            bVar.aE(peek);
        }
    }

    public final <_Struct> _Struct y(Class<_Struct> cls) {
        cbq();
        if (Looper.myLooper() == Looper.getMainLooper() && !this.wBI) {
            synchronized (this.wBF) {
                if (!this.wBI) {
                    try {
                        this.wBF.wait();
                    } catch (Throwable e) {
                        com.tencent.mm.vending.f.a.printErrStackTrace("Vending.Interactor", e, "", new Object[0]);
                    }
                }
            }
        }
        return this.wBG.get(cls);
    }

    public final void z(Class<?> cls) {
        cbq();
        this.wBG.request(cls);
    }

    public final <_Struct> void a(Class<_Struct> cls, a<_Struct> aVar) {
        cbq();
        this.wBE.put(cls, aVar);
    }

    private void cbq() {
        if (Looper.myLooper() == this.wBG.getLooper() && !this.wBH.get()) {
            com.tencent.mm.vending.f.a.e("Vending.Interactor", "This interactor has not call onCreate() yet! Interactor : %s", new Object[]{this});
        }
    }

    public void onCreate() {
        this.wBH.set(true);
    }

    public void onDestroy() {
        this.wBC.dead();
        this.wBD.dead();
    }
}
