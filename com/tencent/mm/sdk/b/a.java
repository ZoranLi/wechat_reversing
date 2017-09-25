package com.tencent.mm.sdk.b;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.vending.b.b;
import com.tencent.mm.vending.g.g;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import junit.framework.Assert;

public final class a {
    public static a urY = new a();
    private final HashMap<Integer, LinkedList<c>> urZ = new HashMap();
    private final HashMap<Integer, a> usa = new HashMap();

    private class a extends com.tencent.mm.vending.b.a<c> {
        final /* synthetic */ a usc;

        public a(a aVar) {
            this.usc = aVar;
        }

        public final void a(com.tencent.mm.vending.j.a aVar) {
            LinkedList cbx = cbx();
            b bVar = (b) aVar.get(0);
            if (bVar.use) {
                Collections.sort(cbx, new Comparator<b>(this) {
                    final /* synthetic */ a usd;

                    {
                        this.usd = r1;
                    }

                    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                        return ((c) ((b) obj2).wCz).priority - ((c) ((b) obj).wCz).priority;
                    }
                });
            }
            b[] bVarArr = new b[cbx.size()];
            cbx.toArray(bVarArr);
            int length = bVarArr.length;
            int i = 0;
            while (i < length && (!((c) bVarArr[i].wCz).a(bVar) || !bVar.use)) {
                i++;
            }
            if (bVar.nFq != null) {
                bVar.nFq.run();
            }
        }
    }

    private a() {
    }

    public final b<c> a(c cVar) {
        b<c> a;
        synchronized (this) {
            Assert.assertNotNull("EventPoolImpl.add", cVar);
            w.v("MicroMsg.EventCenter", "addListener %s(%d)", cVar, Integer.valueOf(cVar.bIx()));
            com.tencent.mm.vending.b.a aVar = (a) this.usa.get(Integer.valueOf(cVar.bIx()));
            if (aVar == null) {
                HashMap hashMap = this.usa;
                Integer valueOf = Integer.valueOf(cVar.bIx());
                aVar = new a(this);
                hashMap.put(valueOf, aVar);
            }
            a = aVar.a(new b(cVar, aVar));
        }
        return a;
    }

    @Deprecated
    public final boolean b(c cVar) {
        synchronized (this) {
            Assert.assertNotNull("EventPoolImpl.add", cVar);
            w.v("MicroMsg.EventCenter", "addListener %s(%d)", cVar, Integer.valueOf(cVar.bIx()));
            LinkedList linkedList = (LinkedList) this.urZ.get(Integer.valueOf(cVar.bIx()));
            if (linkedList == null) {
                HashMap hashMap = this.urZ;
                Integer valueOf = Integer.valueOf(cVar.bIx());
                linkedList = new LinkedList();
                hashMap.put(valueOf, linkedList);
            }
            if (linkedList.contains(cVar)) {
                return true;
            }
            boolean add = linkedList.add(cVar);
            return add;
        }
    }

    @Deprecated
    public final boolean c(c cVar) {
        boolean z;
        boolean z2 = false;
        synchronized (this) {
            Assert.assertNotNull("EventPoolImpl.remove", cVar);
            w.v("MicroMsg.EventCenter", "removeListener %s(%d)", cVar, Integer.valueOf(cVar.bIx()));
            LinkedList linkedList = (LinkedList) this.urZ.get(Integer.valueOf(cVar.bIx()));
            if (linkedList != null) {
                z2 = linkedList.remove(cVar);
            }
            a aVar = (a) this.usa.get(Integer.valueOf(cVar.bIx()));
            if (aVar != null) {
                aVar.b(new b(cVar, aVar));
                z = true;
            } else {
                z = z2;
            }
        }
        return z;
    }

    public final boolean m(b bVar) {
        boolean z = false;
        boolean z2 = true;
        Assert.assertNotNull("EventPoolImpl.publish", bVar);
        w.v("MicroMsg.EventCenter", "publish %s(%d)", bVar, Integer.valueOf(bVar.bIx()));
        LinkedList linkedList = null;
        synchronized (this) {
            int bIx = bVar.bIx();
            LinkedList linkedList2 = (LinkedList) this.urZ.get(Integer.valueOf(bIx));
            if (linkedList2 != null) {
                linkedList = new LinkedList(linkedList2);
                z = true;
            }
            a aVar = (a) this.usa.get(Integer.valueOf(bIx));
            if (aVar == null) {
                z2 = z;
            }
            if (!z2) {
                w.w("MicroMsg.EventCenter", "No listener for this event %s(%d), Stack: %s.", bVar, Integer.valueOf(bIx), "");
            }
        }
        if (linkedList != null) {
            a(linkedList, bVar);
        }
        if (aVar != null) {
            aVar.a(g.bO(bVar));
        }
        return z2;
    }

    public final void a(final b bVar, Looper looper) {
        Assert.assertNotNull("EventPoolImpl.asyncPublish event", bVar);
        Assert.assertNotNull("EventPoolImpl.asyncPublish looper", looper);
        w.v("MicroMsg.EventCenter", "publish %s(%d)", bVar, Integer.valueOf(bVar.bIx()));
        new ae(looper).post(new Runnable(this) {
            final /* synthetic */ a usc;

            public final void run() {
                a.urY.m(bVar);
            }
        });
    }

    public final synchronized boolean s(Class<? extends b> cls) {
        boolean z;
        Assert.assertNotNull("EventPoolImpl.hasListener", cls);
        LinkedList linkedList = (LinkedList) this.urZ.get(Integer.valueOf(cls.getName().hashCode()));
        if (linkedList == null || linkedList.size() <= 0) {
            a aVar = (a) this.usa.get(Integer.valueOf(cls.getName().hashCode()));
            if (aVar == null || aVar.size() <= 0) {
                z = false;
            } else {
                z = true;
            }
        } else {
            z = true;
        }
        return z;
    }

    public final synchronized boolean d(c cVar) {
        boolean z;
        Assert.assertNotNull("EventPoolImpl.hadListened", cVar);
        LinkedList linkedList = (LinkedList) this.urZ.get(Integer.valueOf(cVar.bIx()));
        if (linkedList == null || linkedList.isEmpty() || !linkedList.contains(cVar)) {
            a aVar = (a) this.usa.get(Integer.valueOf(cVar.bIx()));
            if (aVar == null || aVar.size() <= 0 || !aVar.contains(cVar)) {
                z = false;
            } else {
                z = true;
            }
        } else {
            z = true;
        }
        return z;
    }

    private void a(LinkedList<c> linkedList, b bVar) {
        if (bVar.use) {
            Collections.sort(linkedList, new Comparator<c>(this) {
                final /* synthetic */ a usc;

                {
                    this.usc = r1;
                }

                public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                    return ((c) obj2).priority - ((c) obj).priority;
                }
            });
        }
        c[] cVarArr = new c[linkedList.size()];
        linkedList.toArray(cVarArr);
        int length = cVarArr.length;
        int i = 0;
        while (i < length && (!cVarArr[i].a(bVar) || !bVar.use)) {
            i++;
        }
        if (bVar.nFq != null) {
            bVar.nFq.run();
        }
    }
}
