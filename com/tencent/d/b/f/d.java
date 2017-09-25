package com.tencent.d.b.f;

import com.tencent.d.a.c.c;
import com.tencent.d.b.a.b;
import com.tencent.d.b.a.e;

public abstract class d {
    boolean xaa = false;
    public b xao;

    abstract boolean cfV();

    abstract void cfW();

    abstract void execute();

    final synchronized void b(final e eVar) {
        if (this.xaa) {
            c.w("Soter.BaseSoterTask", "soter: warning: already removed the task!", new Object[0]);
        } else {
            f cfX = f.cfX();
            String str = "Soter.SoterTaskManager";
            String str2 = "soter: removing task: %d";
            Object[] objArr = new Object[1];
            objArr[0] = this != null ? Integer.valueOf(hashCode()) : "null";
            c.i(str, str2, objArr);
            if (this == null) {
                c.e("Soter.SoterTaskManager", "soter: task is null", new Object[0]);
            } else {
                synchronized (cfX.xaz) {
                    if (f.xay.get(hashCode()) == null) {
                        c.i("Soter.SoterTaskManager", "soter: no such task: %d. maybe this task did not pass preExecute", Integer.valueOf(hashCode()));
                    } else {
                        f.xay.remove(hashCode());
                    }
                }
            }
            g.cfZ().v(new Runnable(this) {
                final /* synthetic */ d xaq;

                public final void run() {
                    d dVar = this.xaq;
                    e eVar = eVar;
                    if (dVar.xao != null && !dVar.xaa) {
                        dVar.xao.a(eVar);
                        dVar.xaa = true;
                    }
                }
            });
        }
    }
}
