package com.tencent.d.b.f;

import android.util.SparseArray;
import com.tencent.d.a.c.c;
import com.tencent.d.b.a.e;

public class f {
    private static volatile f xax = null;
    public static volatile SparseArray<d> xay = null;
    public final Object xaz = new Object();

    class AnonymousClass3 implements Runnable {
        final /* synthetic */ int sai;
        final /* synthetic */ f xaB;

        public AnonymousClass3(f fVar, int i) {
            this.xaB = fVar;
            this.sai = i;
        }

        public final void run() {
            d dVar = (d) f.xay.get(this.sai);
            if (dVar != null && (dVar instanceof a) && !((a) dVar).isCancelled()) {
                ((a) dVar).cfU();
            }
        }
    }

    private f() {
        xay = new SparseArray(5);
    }

    public static f cfX() {
        if (xax != null) {
            return xax;
        }
        f fVar;
        synchronized (f.class) {
            if (xax == null) {
                xax = new f();
            }
            fVar = xax;
        }
        return fVar;
    }

    public final boolean a(final d dVar, e eVar) {
        if (dVar.cfV()) {
            c.d("Soter.SoterTaskManager", "soter: prepare eat execute.", new Object[0]);
            return false;
        }
        int hashCode = dVar.hashCode();
        synchronized (this.xaz) {
            for (int i = 0; i < xay.size(); i++) {
                if (((d) xay.get(xay.keyAt(i))).getClass().getName().equals(dVar.getClass().getName())) {
                    c.w("Soter.SoterTaskManager", "soter: already such type of task. abandon add task", new Object[0]);
                    eVar.errCode = 26;
                    eVar.fPf = "add SOTER task to queue failed. check the logcat for further information";
                    dVar.b(eVar);
                    return false;
                }
            }
            xay.put(hashCode, dVar);
            g.cfZ().y(new Runnable(this) {
                final /* synthetic */ f xaB;

                public final void run() {
                    dVar.execute();
                }
            });
            return true;
        }
    }

    public final void cfY() {
        synchronized (this.xaz) {
            c.i("Soter.SoterTaskManager", "soter: request cancel all", new Object[0]);
            if (xay.size() != 0) {
                for (int i = 0; i < xay.size(); i++) {
                    final int keyAt = xay.keyAt(i);
                    g.cfZ().y(new Runnable(this) {
                        final /* synthetic */ f xaB;

                        public final void run() {
                            d dVar = (d) f.xay.get(keyAt);
                            if (dVar != null) {
                                dVar.cfW();
                            }
                        }
                    });
                }
            }
            xay.clear();
        }
    }
}
