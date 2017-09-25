package com.tencent.mm.vending.g;

import android.os.Looper;
import android.util.Pair;
import com.tencent.mm.vending.h.f;
import com.tencent.mm.vending.h.g;
import com.tencent.mm.vending.h.h;
import com.tencent.mm.vending.j.k;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import junit.framework.Assert;

public class e<_Var> implements c<_Var> {
    public int aMo = 0;
    private volatile boolean wCK = false;
    public volatile d wCL = d.Idle;
    public boolean wCM = false;
    private Queue<a> wCN = new LinkedList();
    private volatile com.tencent.mm.vending.h.d wCO = this.wCP;
    private volatile com.tencent.mm.vending.h.d wCP = g.cbL();
    public volatile Object wCQ;
    public volatile boolean wCR;
    public volatile Object wCS;
    public a wCT;
    public a wCU;
    private long wCV = -1;
    private boolean wCW = false;
    private b wCX = new b(this);
    private com.tencent.mm.vending.h.d wCY;
    private com.tencent.mm.vending.h.f.a wCZ = new com.tencent.mm.vending.h.f.a(this) {
        final /* synthetic */ e wDh;

        {
            this.wDh = r1;
        }

        public final void cbG() {
            f cbI = f.cbI();
            e eVar = this.wDh;
            Stack stack = (Stack) cbI.wDy.get();
            if (stack == null) {
                stack = new Stack();
                cbI.wDy.set(stack);
            }
            stack.push(eVar);
        }

        public final void bM(Object obj) {
            ((Stack) f.cbI().wDy.get()).pop();
            synchronized (this.wDh) {
                this.wDh.wCT = this.wDh.wCU;
                this.wDh.wCU = null;
                if (this.wDh.wCM) {
                    com.tencent.mm.vending.f.a.i("Vending.Pipeline", "gonna retry, do not store functional result.", new Object[0]);
                } else {
                    this.wDh.wCQ = obj;
                }
                if (this.wDh.wCL == d.Interrupted) {
                    com.tencent.mm.vending.f.a.i("Vending.Pipeline", "interrupted, just return", new Object[0]);
                } else if (this.wDh.wCL == d.Pausing) {
                    com.tencent.mm.vending.f.a.i("Vending.Pipeline", "pausing, just return.", new Object[0]);
                } else {
                    this.wDh.wCL = d.Resolved;
                    this.wDh.bL(this.wDh.bK(obj));
                }
            }
        }

        public final void interrupt() {
            this.wDh.lW(true);
        }
    };
    f wCx = new f(this.wCP, this.wCZ);
    public List<Pair<com.tencent.mm.vending.g.d.a, com.tencent.mm.vending.h.d>> wDa;
    private List<Pair<com.tencent.mm.vending.g.d.b, com.tencent.mm.vending.h.d>> wDb;
    private boolean wDc = false;
    public boolean wDd = false;
    public boolean wDe = false;
    private Object wDf;
    public Object wDg;

    private static class a {
        public com.tencent.mm.vending.h.d fwy;
        public long jfb;
        public com.tencent.mm.vending.c.a wDo;
        public boolean wDp;

        public a(com.tencent.mm.vending.c.a aVar, com.tencent.mm.vending.h.d dVar, long j, boolean z) {
            this.wDo = aVar;
            this.fwy = dVar;
            this.jfb = j;
            this.wDp = z;
        }
    }

    public static class c extends Error {
        public c(String str, Object... objArr) {
            super(String.format(str, objArr));
        }
    }

    private enum d {
        Idle,
        Resolved,
        Invoking,
        Pausing,
        Interrupted,
        AllDone
    }

    class b implements b {
        final /* synthetic */ e wDh;

        b(e eVar) {
            this.wDh = eVar;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void bJ(java.lang.Object r7) {
            /*
            r6 = this;
            r1 = r6.wDh;
            monitor-enter(r1);
            r0 = r6.wDh;	 Catch:{ all -> 0x0037 }
            r0 = r0.wCL;	 Catch:{ all -> 0x0037 }
            r2 = com.tencent.mm.vending.g.e.d.Interrupted;	 Catch:{ all -> 0x0037 }
            if (r0 != r2) goto L_0x0019;
        L_0x000b:
            r0 = "Vending.Pipeline";
            r2 = "interrupted, skip this interrupt.";
            r3 = 0;
            r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x0037 }
            com.tencent.mm.vending.f.a.i(r0, r2, r3);	 Catch:{ all -> 0x0037 }
            monitor-exit(r1);	 Catch:{ all -> 0x0037 }
        L_0x0018:
            return;
        L_0x0019:
            r0 = r6.wDh;	 Catch:{ all -> 0x0037 }
            r0 = r0.cbE();	 Catch:{ all -> 0x0037 }
            if (r0 != 0) goto L_0x003a;
        L_0x0021:
            r0 = r6.wDh;	 Catch:{ all -> 0x0037 }
            r0 = r0.wCL;	 Catch:{ all -> 0x0037 }
            r2 = com.tencent.mm.vending.g.e.d.Pausing;	 Catch:{ all -> 0x0037 }
            if (r0 == r2) goto L_0x003a;
        L_0x0029:
            r0 = "Vending.Pipeline";
            r2 = "interrupt not in func scope or pending, skip this retryOrInterrupt.";
            r3 = 0;
            r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x0037 }
            com.tencent.mm.vending.f.a.i(r0, r2, r3);	 Catch:{ all -> 0x0037 }
            monitor-exit(r1);	 Catch:{ all -> 0x0037 }
            goto L_0x0018;
        L_0x0037:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x0037 }
            throw r0;
        L_0x003a:
            r0 = "Vending.Pipeline";
            r2 = "interrupt Pipeline(%s)";
            r3 = 1;
            r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x0037 }
            r4 = 0;
            r5 = r6.wDh;	 Catch:{ all -> 0x0037 }
            r3[r4] = r5;	 Catch:{ all -> 0x0037 }
            com.tencent.mm.vending.f.a.i(r0, r2, r3);	 Catch:{ all -> 0x0037 }
            r0 = r6.wDh;	 Catch:{ all -> 0x0037 }
            r2 = 0;
            r0.lW(r2);	 Catch:{ all -> 0x0037 }
            r0 = r6.wDh;	 Catch:{ all -> 0x0037 }
            r2 = 1;
            r0.wDd = r2;	 Catch:{ all -> 0x0037 }
            r0 = r6.wDh;	 Catch:{ all -> 0x0037 }
            r0.wDg = r7;	 Catch:{ all -> 0x0037 }
            r0 = r6.wDh;	 Catch:{ all -> 0x0037 }
            r0 = r0.wDa;	 Catch:{ all -> 0x0037 }
            if (r0 == 0) goto L_0x007a;
        L_0x0060:
            r0 = r6.wDh;	 Catch:{ all -> 0x0037 }
            r0 = r0.wDa;	 Catch:{ all -> 0x0037 }
            r2 = r0.iterator();	 Catch:{ all -> 0x0037 }
        L_0x0068:
            r0 = r2.hasNext();	 Catch:{ all -> 0x0037 }
            if (r0 == 0) goto L_0x007a;
        L_0x006e:
            r0 = r2.next();	 Catch:{ all -> 0x0037 }
            r0 = (android.util.Pair) r0;	 Catch:{ all -> 0x0037 }
            r3 = r6.wDh;	 Catch:{ all -> 0x0037 }
            r3.a(r0, r7);	 Catch:{ all -> 0x0037 }
            goto L_0x0068;
        L_0x007a:
            monitor-exit(r1);	 Catch:{ all -> 0x0037 }
            goto L_0x0018;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.vending.g.e.b.bJ(java.lang.Object):void");
        }

        public final void cbA() {
            synchronized (this.wDh) {
                synchronized (this.wDh) {
                    if (this.wDh.wCL == d.Interrupted || this.wDh.wCL == d.Idle) {
                        com.tencent.mm.vending.f.a.w("Vending.Pipeline", "current is state(%s), ignore pause.", this.wDh.wCL);
                    } else if (!this.wDh.cbE()) {
                        com.tencent.mm.vending.f.a.e("Vending.Pipeline", "you are using mario().pause() out of a functional scope on %s!", this.wDh);
                    } else if (this.wDh.cbF()) {
                        this.wDh.wCL = d.Pausing;
                    } else {
                        com.tencent.mm.vending.f.a.e("Vending.Pipeline", "you are using mario().pause() out of calling thread on %s!", this.wDh);
                    }
                }
            }
        }

        public final void s(Object... objArr) {
            synchronized (this.wDh) {
                if (this.wDh.wCL != d.Pausing) {
                    com.tencent.mm.vending.f.a.i("Vending.Pipeline", "state is not pausing %s, skip this wormhole", this.wDh.wCL);
                    return;
                }
                e eVar = this.wDh;
                Object u = objArr.length == 0 ? null : objArr.length == 1 ? objArr[0] : k.u(objArr);
                eVar.wCS = u;
                this.wDh.wCR = true;
                com.tencent.mm.vending.f.a.i("Vending.Pipeline", "pipline(%s) wormhole().", this.wDh);
                resume();
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void resume() {
            /*
            r6 = this;
            r1 = r6.wDh;
            monitor-enter(r1);
            r0 = r6.wDh;	 Catch:{ all -> 0x0045 }
            r0 = r0.wCL;	 Catch:{ all -> 0x0045 }
            r2 = com.tencent.mm.vending.g.e.d.Pausing;	 Catch:{ all -> 0x0045 }
            if (r0 == r2) goto L_0x001e;
        L_0x000b:
            r0 = "Vending.Pipeline";
            r2 = "this Pipeline(%s) is not pausing! why call resume?";
            r3 = 1;
            r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x0045 }
            r4 = 0;
            r5 = r6.wDh;	 Catch:{ all -> 0x0045 }
            r3[r4] = r5;	 Catch:{ all -> 0x0045 }
            com.tencent.mm.vending.f.a.e(r0, r2, r3);	 Catch:{ all -> 0x0045 }
            monitor-exit(r1);	 Catch:{ all -> 0x0045 }
        L_0x001d:
            return;
        L_0x001e:
            r0 = r6.wDh;	 Catch:{ all -> 0x0045 }
            r0 = r0.cbE();	 Catch:{ all -> 0x0045 }
            if (r0 != 0) goto L_0x0048;
        L_0x0026:
            r0 = r6.wDh;	 Catch:{ all -> 0x0045 }
            r2 = com.tencent.mm.vending.g.e.d.Resolved;	 Catch:{ all -> 0x0045 }
            r0.wCL = r2;	 Catch:{ all -> 0x0045 }
        L_0x002c:
            r0 = r6.wDh;	 Catch:{ all -> 0x0045 }
            r0 = r0.cbF();	 Catch:{ all -> 0x0045 }
            if (r0 != 0) goto L_0x0043;
        L_0x0034:
            r0 = r6.wDh;	 Catch:{ all -> 0x0045 }
            r2 = r6.wDh;	 Catch:{ all -> 0x0045 }
            r3 = r6.wDh;	 Catch:{ all -> 0x0045 }
            r3 = r3.wCQ;	 Catch:{ all -> 0x0045 }
            r2 = r2.bK(r3);	 Catch:{ all -> 0x0045 }
            r0.bL(r2);	 Catch:{ all -> 0x0045 }
        L_0x0043:
            monitor-exit(r1);	 Catch:{ all -> 0x0045 }
            goto L_0x001d;
        L_0x0045:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x0045 }
            throw r0;
        L_0x0048:
            r0 = r6.wDh;	 Catch:{ all -> 0x0045 }
            r2 = com.tencent.mm.vending.g.e.d.Invoking;	 Catch:{ all -> 0x0045 }
            r0.wCL = r2;	 Catch:{ all -> 0x0045 }
            goto L_0x002c;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.vending.g.e.b.resume():void");
        }
    }

    public c<_Var> UB(String str) {
        if (str == null) {
            Assert.assertNotNull("schedulerTypeString should not be null!", str);
        } else {
            this.wCO = g.UD(str);
            Assert.assertNotNull("mCurrentScheduler should not be null!", this.wCO);
        }
        return this;
    }

    public c<_Var> a(com.tencent.mm.vending.h.d dVar) {
        if (dVar == null) {
            Assert.assertNotNull("scheduler should not be null!", dVar);
        } else {
            this.wCO = dVar;
        }
        return this;
    }

    public c<_Var> b(com.tencent.mm.vending.e.b bVar) {
        Assert.assertNotNull("keeper should not be null!", bVar);
        bVar.a(this);
        return this;
    }

    public c<_Var> lV(boolean z) {
        this.wCW = z;
        return this;
    }

    public synchronized c<_Var> a(final com.tencent.mm.vending.g.c.a<_Var> aVar) {
        t(new Object[0]);
        a(new com.tencent.mm.vending.c.a<_Var, _Var>(this) {
            final /* synthetic */ e wDh;

            public final _Var call(_Var _Var) {
                return aVar.call();
            }
        }, true);
        return this;
    }

    public synchronized c<_Var> t(Object... objArr) {
        c<_Var> cVar;
        if (this.wCL != d.Idle) {
            cVar = this;
        } else {
            this.wCL = d.Resolved;
            Object u = objArr.length == 0 ? null : objArr.length == 1 ? objArr[0] : k.u(objArr);
            this.wCQ = u;
            bL(this.wCQ);
            u = this;
        }
        return cVar;
    }

    public void dead() {
        lW(true);
    }

    public final b cbB() {
        return this.wCX;
    }

    public <_Ret> c<_Ret> d(com.tencent.mm.vending.c.a<_Ret, _Var> aVar) {
        return UB("Vending.UI").a((com.tencent.mm.vending.c.a) aVar);
    }

    public <_Ret> c<_Ret> b(com.tencent.mm.vending.c.a<_Ret, _Var> aVar) {
        return UB("Vending.LOGIC").a((com.tencent.mm.vending.c.a) aVar);
    }

    public <_Ret> c<_Ret> c(com.tencent.mm.vending.c.a<_Ret, _Var> aVar) {
        return UB("Vending.HEAVY_WORK").a((com.tencent.mm.vending.c.a) aVar);
    }

    private synchronized <_Ret> c<_Ret> a(com.tencent.mm.vending.c.a<_Ret, _Var> aVar, boolean z) {
        c<_Ret> cVar;
        cbC();
        this.wCN.add(new a(aVar, this.wCO, this.wCV, z));
        this.wCV = -1;
        if (this.wCL == d.Idle) {
            cVar = this;
        } else if (this.wCL != d.Resolved) {
            r0 = this;
        } else {
            bL(this.wCQ);
            r0 = this;
        }
        return cVar;
    }

    public synchronized <_Ret> c<_Ret> a(com.tencent.mm.vending.c.a<_Ret, _Var> aVar) {
        return a((com.tencent.mm.vending.c.a) aVar, this.wCW);
    }

    private synchronized void cbC() {
        if (this.wCK) {
            throw new c("This Pipeline(%s) has terminate and do not allow any next().", this);
        }
    }

    public final synchronized void a(final Pair<com.tencent.mm.vending.g.d.a, com.tencent.mm.vending.h.d> pair, final Object obj) {
        com.tencent.mm.vending.h.d dVar = (com.tencent.mm.vending.h.d) pair.second;
        Runnable anonymousClass3 = new Runnable(this) {
            final /* synthetic */ e wDh;

            public final void run() {
                ((com.tencent.mm.vending.g.d.a) pair.first).aD(obj);
            }
        };
        if (dVar == null) {
            com.tencent.mm.vending.f.a.e("Vending.Pipeline", "Default scheduler %s is not available!!!", this.wCP);
        }
        dVar.ab(anonymousClass3);
    }

    private synchronized void b(final Pair<com.tencent.mm.vending.g.d.b, com.tencent.mm.vending.h.d> pair, final Object obj) {
        final RuntimeException runtimeException = new RuntimeException("object is not right: " + obj);
        new f((com.tencent.mm.vending.h.d) pair.second, null).a(new com.tencent.mm.vending.c.a<Void, Void>(this) {
            final /* synthetic */ e wDh;

            public final /* synthetic */ Object call(Object obj) {
                return cbH();
            }

            private Void cbH() {
                try {
                    ((com.tencent.mm.vending.g.d.b) pair.first).ar(obj);
                    return wCE;
                } catch (Throwable e) {
                    if (runtimeException.getCause() == null) {
                        runtimeException.initCause(e);
                    }
                    throw runtimeException;
                }
            }
        }, null, this.wCW);
    }

    private synchronized void a(com.tencent.mm.vending.g.d.a aVar, com.tencent.mm.vending.h.d dVar) {
        cbD();
        if (this.wDa == null) {
            this.wDa = new LinkedList();
        }
        Pair pair = new Pair(aVar, dVar);
        if (this.wDd) {
            a(pair, this.wDg);
        } else {
            this.wDa.add(pair);
        }
    }

    private synchronized void a(com.tencent.mm.vending.g.d.b bVar, com.tencent.mm.vending.h.d dVar) {
        cbD();
        bL(this.wCQ);
        if (this.wDb == null) {
            this.wDb = new LinkedList();
        }
        Pair pair = new Pair(bVar, dVar);
        if (this.wDc) {
            b(pair, this.wDf);
        } else {
            this.wDb.add(pair);
        }
    }

    private synchronized d<_Var> cbD() {
        this.wCK = true;
        return this;
    }

    public final synchronized d<_Var> a(com.tencent.mm.vending.g.d.a aVar) {
        a(aVar, this.wCP);
        return this;
    }

    public final synchronized d<_Var> a(com.tencent.mm.vending.g.d.b<_Var> bVar) {
        a((com.tencent.mm.vending.g.d.b) bVar, this.wCP);
        return this;
    }

    public final synchronized d<_Var> a(com.tencent.mm.vending.h.d dVar, com.tencent.mm.vending.g.d.b<_Var> bVar) {
        a((com.tencent.mm.vending.g.d.b) bVar, dVar);
        return this;
    }

    public final synchronized void lW(boolean z) {
        if (!(this.wCL == d.Interrupted || this.wCL == d.AllDone)) {
            if (z) {
                if (this.wCN.size() > 0) {
                    com.tencent.mm.vending.f.a.w("Vending.Pipeline", "Pipe is not finish and be interrupt! %s pipes did not run", Integer.valueOf(this.wCN.size()));
                }
            }
            this.wCL = d.Interrupted;
            this.wCN.clear();
            this.wCQ = null;
            if (this.wCY != null) {
                this.wCY.cancel();
            }
        }
    }

    public final synchronized Object bK(Object obj) {
        if (this.wCM) {
            this.aMo++;
            com.tencent.mm.vending.f.a.i("Vending.Pipeline", "Functional %s, gonna retry %s.", this.wCT.wDo.toString(), Integer.valueOf(this.aMo));
            ((LinkedList) this.wCN).add(0, this.wCT);
            this.wCM = false;
        } else {
            if (this.wCR) {
                this.wCQ = this.wCS;
                this.wCS = null;
                this.wCR = false;
            } else {
                this.wCQ = obj;
            }
            this.aMo = 0;
        }
        return this.wCQ;
    }

    public final synchronized void bL(final Object obj) {
        if (this.wCL == d.Resolved) {
            this.wCL = d.Invoking;
            a aVar = (a) this.wCN.peek();
            if (aVar != null) {
                final com.tencent.mm.vending.c.a aVar2 = aVar.wDo;
                com.tencent.mm.vending.h.d dVar = aVar.fwy;
                long j = aVar.jfb;
                final boolean z = aVar.wDp;
                if (this.wCL == d.Pausing) {
                    com.tencent.mm.vending.f.a.i("Vending.Pipeline", "This pipeline is Pausing. We will stop dequeFunctionAndInvoke and waiting resume() call", new Object[0]);
                } else {
                    this.wCU = (a) this.wCN.poll();
                    this.wCx.b(dVar);
                    if (j < 0) {
                        this.wCx.a(aVar2, obj, z);
                    } else {
                        if (Looper.myLooper() == null) {
                            this.wCY = new com.tencent.mm.vending.h.c();
                        } else {
                            this.wCY = new h(Looper.myLooper(), Looper.myLooper().toString());
                        }
                        this.wCY.h(new Runnable(this) {
                            final /* synthetic */ e wDh;

                            public final void run() {
                                this.wDh.wCx.a(aVar2, obj, z);
                            }
                        }, j);
                    }
                }
            } else if (this.wCK) {
                this.wCL = d.AllDone;
                this.wDc = true;
                this.wDf = obj;
                if (this.wDb != null) {
                    for (Pair b : this.wDb) {
                        b(b, this.wDf);
                    }
                }
            } else {
                this.wCL = d.Resolved;
            }
        }
    }

    public final boolean cbE() {
        return this.wCU != null;
    }

    public final boolean cbF() {
        return this.wCX == g.cbB();
    }
}
