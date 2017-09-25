package com.tencent.mm.vending.h;

public final class f {
    private volatile d wCO;
    public volatile a wCZ;

    public interface a {
        void bM(Object obj);

        void cbG();

        void interrupt();
    }

    public f(d dVar, a aVar) {
        b(dVar);
        this.wCZ = aVar;
    }

    public final synchronized void b(d dVar) {
        c(dVar);
    }

    private synchronized void c(d dVar) {
        this.wCO = dVar;
    }

    private synchronized void a(final com.tencent.mm.vending.c.a aVar, final Object obj, long j, boolean z) {
        d UD;
        Runnable anonymousClass1;
        d dVar = this.wCO;
        if (aVar instanceof e) {
            e eVar = (e) aVar;
            if (!"Vending.ANY".equals(eVar.NN())) {
                UD = g.UD(eVar.NN());
                if (UD == null) {
                    final RuntimeException runtimeException = new RuntimeException("object is not right: " + obj);
                    anonymousClass1 = new Runnable(this) {
                        final /* synthetic */ f wDD;

                        public final void run() {
                            if (this.wDD.wCZ != null) {
                                this.wDD.wCZ.cbG();
                            }
                            try {
                                Object call = aVar.call(obj);
                                if (this.wDD.wCZ != null) {
                                    this.wDD.wCZ.bM(call);
                                }
                            } catch (Throwable e) {
                                runtimeException.initCause(e);
                                throw runtimeException;
                            }
                        }
                    };
                    if (-1 < 0) {
                        UD.h(anonymousClass1, -1);
                    } else if (z || g.cbL() != UD) {
                        UD.ab(anonymousClass1);
                    } else {
                        anonymousClass1.run();
                    }
                } else if (this.wCZ != null) {
                    this.wCZ.interrupt();
                }
            }
        }
        UD = dVar;
        if (UD == null) {
            final RuntimeException runtimeException2 = new RuntimeException("object is not right: " + obj);
            anonymousClass1 = /* anonymous class already generated */;
            if (-1 < 0) {
                UD.h(anonymousClass1, -1);
            } else {
                if (z) {
                }
                UD.ab(anonymousClass1);
            }
        } else if (this.wCZ != null) {
            this.wCZ.interrupt();
        }
    }

    public final void a(com.tencent.mm.vending.c.a aVar, Object obj, boolean z) {
        a(aVar, obj, -1, z);
    }
}
