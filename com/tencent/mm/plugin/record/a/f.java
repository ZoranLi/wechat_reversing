package com.tencent.mm.plugin.record.a;

import android.os.SystemClock;
import android.util.SparseArray;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import java.util.LinkedList;
import java.util.List;

public abstract class f<T extends a> {
    private boolean oOj = false;
    public final int oOk = 3;
    private final int oOl = 300000;
    private SparseArray<b> oOm = new SparseArray();
    private LinkedList<T> oOn = new LinkedList();

    public interface a {
        int aWC();
    }

    private final class b {
        int ihV = this.oOo.oOk;
        final /* synthetic */ f oOo;
        long oOp = SystemClock.elapsedRealtime();

        public b(f fVar) {
            this.oOo = fVar;
        }
    }

    protected abstract void a(T t);

    protected abstract List<T> aWA();

    public final void run() {
        ap.vL().D(new Runnable(this) {
            final /* synthetic */ f oOo;

            {
                this.oOo = r1;
            }

            public final void run() {
                this.oOo.aWz();
            }

            public final String toString() {
                return super.toString() + "|tryDoJob";
            }
        });
    }

    public final void aWz() {
        if (this.oOj) {
            w.d("MicroMsg.RecordMsgBaseService", "is working, return");
            return;
        }
        b bVar;
        a aVar;
        if (this.oOn.isEmpty()) {
            for (a aVar2 : aWA()) {
                bVar = (b) this.oOm.get(aVar2.aWC());
                if (bVar == null) {
                    this.oOm.put(aVar2.aWC(), new b(this));
                } else if (bVar.ihV >= 0 || SystemClock.elapsedRealtime() - bVar.oOp >= ((long) this.oOl)) {
                    if (bVar.ihV < 0) {
                        bVar.ihV = this.oOk;
                    }
                }
                w.d("MicroMsg.RecordMsgBaseService", "do add job from db, localId %d", Integer.valueOf(aVar2.aWC()));
                if (!this.oOn.contains(aVar2)) {
                    this.oOn.add(aVar2);
                }
            }
            w.i("MicroMsg.RecordMsgBaseService", "jobs list size is 0, new jobs list size[%d]", Integer.valueOf(this.oOn.size()));
        }
        if (this.oOn.isEmpty()) {
            w.i("MicroMsg.RecordMsgBaseService", "try to do job, but job list size is empty, return");
            finish();
            return;
        }
        int i;
        aVar2 = (a) this.oOn.removeFirst();
        bVar = (b) this.oOm.get(aVar2.aWC());
        if (bVar == null) {
            bVar = new b(this);
            this.oOm.put(aVar2.aWC(), bVar);
        }
        bVar.ihV--;
        if (bVar.ihV < 0) {
            if (((long) this.oOl) > SystemClock.elapsedRealtime() - bVar.oOp) {
                i = 0;
                if (i == 0) {
                    a(aVar2);
                } else {
                    run();
                }
            }
            bVar.ihV = this.oOk - 1;
        }
        bVar.oOp = SystemClock.elapsedRealtime();
        i = 1;
        if (i == 0) {
            run();
        } else {
            a(aVar2);
        }
    }

    protected final void aWB() {
        this.oOj = false;
        run();
    }

    final void finish() {
        this.oOn.clear();
        this.oOm.clear();
        this.oOj = false;
    }
}
