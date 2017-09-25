package com.tencent.mm.kernel.a;

import com.tencent.mm.kernel.b.e;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.i;
import com.tencent.mm.kernel.j;
import com.tencent.mm.vending.g.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public final class a {
    private static Map<Integer, Map> gZp = new ConcurrentHashMap();
    private f<com.tencent.mm.kernel.b.a> gXQ = new f();
    private boolean gZl = false;
    private HashMap<Class<? extends com.tencent.mm.kernel.b.a>, com.tencent.mm.kernel.b.a> gZm = new HashMap();
    private final HashMap<Class<? extends com.tencent.mm.kernel.b.a>, d> gZn = new HashMap();
    public final ArrayList<d> gZo = new ArrayList();
    public b gZq;

    class AnonymousClass2 implements com.tencent.mm.vending.c.a<Void, Void> {
        final /* synthetic */ e fwb;
        final /* synthetic */ long gKe;
        final /* synthetic */ a gZs;

        AnonymousClass2(a aVar, e eVar, long j) {
            this.gZs = aVar;
            this.fwb = eVar;
            this.gKe = j;
        }

        public final /* synthetic */ Object call(Object obj) {
            a.a("final task executing.", new Object[0]);
            Iterator it = this.gZs.gZo.iterator();
            while (it.hasNext()) {
                a.a((d) it.next(), this.fwb);
            }
            a.a("all task finally execution all done in [%s].", a.H(this.gKe));
            return null;
        }
    }

    public final synchronized void a(d dVar) {
        if (this.gZl) {
            j.w("MMSkeleton.Boot", "Already executing tasks, can't add final task anymore.", new Object[0]);
        } else {
            this.gZo.add(dVar);
        }
    }

    protected final synchronized c<Void> a(c<Void> cVar, long j) {
        this.gZl = true;
        f fVar = new f(this.gXQ);
        final ArrayList vD = fVar.vD();
        a("boot task execution chain ... %s", vD);
        ArrayList vC = fVar.vC();
        if (vC.size() > 0) {
            throw new RuntimeException("Found cycle dependencies! Between " + vC);
        }
        a("boot check tasks cycle dependency ok...", new Object[0]);
        final e vj = i.vN().vF().vj();
        final long j2 = j;
        cVar.a(new com.tencent.mm.vending.c.a<Void, Void>(this) {
            final /* synthetic */ a gZs;

            public final /* synthetic */ Object call(Object obj) {
                Iterator it = vD.iterator();
                while (it.hasNext()) {
                    com.tencent.mm.kernel.b.a aVar = (com.tencent.mm.kernel.b.a) it.next();
                    if (aVar instanceof d) {
                        a.a((d) aVar, vj);
                    }
                }
                a.a("boot task execution all done in [%s].", a.H(j2));
                return null;
            }
        });
        return cVar;
    }

    public static void a(d dVar, e eVar) {
        if (gZp.containsKey(Integer.valueOf(dVar.hashCode()))) {
            a("skip task %s execution hash %s", dVar.name(), Integer.valueOf(dVar.hashCode()));
            return;
        }
        a("boot task executing [%s] hash %s...", dVar.name(), Integer.valueOf(dVar.hashCode()));
        dVar.execute(eVar);
        gZp.put(Integer.valueOf(dVar.hashCode()), gZp);
    }

    public final synchronized <T extends d> void a(Class<? extends com.tencent.mm.kernel.b.a> cls, T t) {
        Assert.assertNotNull(cls);
        Assert.assertNotNull(t);
        if (!this.gZn.containsKey(cls)) {
            this.gZn.put(cls, t);
        }
    }

    public final synchronized void a(com.tencent.mm.kernel.b.a aVar, com.tencent.mm.kernel.b.a aVar2) {
        Assert.assertNotNull(aVar);
        if (!this.gZm.containsKey(aVar.getClass())) {
            this.gZm.put(aVar.getClass(), aVar);
        }
        this.gXQ.n(aVar, aVar2);
    }

    public static final void a(String str, Object... objArr) {
        if (objArr.length == 0) {
            j.i("MMSkeleton.Boot", str, new Object[0]);
        } else {
            j.i("MMSkeleton.Boot", str, objArr);
        }
    }

    public static long timestamp() {
        return System.currentTimeMillis();
    }

    public static String H(long j) {
        return (System.currentTimeMillis() - j) + "ms";
    }
}
