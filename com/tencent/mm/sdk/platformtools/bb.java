package com.tencent.mm.sdk.platformtools;

public abstract class bb<R> {
    public long hnt;
    private final long hto;
    private Object lock;
    private R result;
    private Runnable uty;
    public long uvK;
    public boolean uvL;

    public abstract R run();

    public bb() {
        this(0, null);
    }

    public bb(long j, R r, boolean z) {
        this.lock = new Object();
        this.uvL = false;
        this.uty = new Runnable(this) {
            final /* synthetic */ bb uvM;

            {
                this.uvM = r1;
            }

            public final void run() {
                w.i("MicroMsg.SDK.SyncTask", "task run manualFinish = " + this.uvM.uvL);
                if (this.uvM.uvL) {
                    this.uvM.run();
                } else {
                    this.uvM.bv(this.uvM.run());
                }
                this.uvM.uvK = bg.aB(this.uvM.hnt);
            }
        };
        this.hto = j;
        this.result = r;
        this.uvL = true;
    }

    public bb(long j, R r) {
        this.lock = new Object();
        this.uvL = false;
        this.uty = /* anonymous class already generated */;
        this.hto = j;
        this.result = r;
    }

    public final void bv(R r) {
        w.i("MicroMsg.SDK.SyncTask", "setResultFinish ");
        this.result = r;
        synchronized (this.lock) {
            w.i("MicroMsg.SDK.SyncTask", "setResultFinish synchronized");
            this.lock.notify();
        }
    }

    public final R b(ae aeVar) {
        if (aeVar == null) {
            w.d("MicroMsg.SDK.SyncTask", "null handler, task in exec thread, return now");
            return run();
        }
        w.i("MicroMsg.SDK.SyncTask", "sync task exec...");
        if (Thread.currentThread().getId() == aeVar.getLooper().getThread().getId()) {
            w.i("MicroMsg.SDK.SyncTask", "same tid, task in exec thread, return now");
            return run();
        }
        this.hnt = bg.NA();
        try {
            synchronized (this.lock) {
                w.i("MicroMsg.SDK.SyncTask", "sync task exec at synchronized");
                aeVar.post(this.uty);
                this.lock.wait(this.hto);
            }
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.SDK.SyncTask", e, "", new Object[0]);
        }
        long aB = bg.aB(this.hnt);
        w.i("MicroMsg.SDK.SyncTask", "sync task done, return=%s, cost=%d(wait=%d, run=%d)", this.result, Long.valueOf(aB), Long.valueOf(this.uvK), Long.valueOf(aB - this.uvK));
        return this.result;
    }
}
