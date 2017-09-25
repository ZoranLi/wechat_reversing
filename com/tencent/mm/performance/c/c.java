package com.tencent.mm.performance.c;

import android.app.Activity;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.performance.d.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public final class c extends com.tencent.mm.performance.d.a {
    public static String TYPE = "MemoryLeakController";
    public HashSet<a> igA;
    public long igB = 0;
    public boolean igC = true;
    private ae igD = new ae(this, Looper.getMainLooper()) {
        final /* synthetic */ c igE;

        public final void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 1:
                    w.d("MicroMsg.WxPerformace", "gc==" + Thread.currentThread().getName());
                    com.tencent.mm.bl.b.bOf();
                    this.igE.igy = System.currentTimeMillis();
                    return;
                default:
                    return;
            }
        }
    };
    public HashSet<c> igs;
    public long igy = -1;
    public HashMap<WeakReference<Object>, Integer> igz;

    private class a {
        final /* synthetic */ c igE;
        public d<Object> igF;
        public WeakReference<Object> igG;
        public long igH = 0;
        public long igI = 0;

        public a(c cVar) {
            this.igE = cVar;
        }
    }

    public interface c {
        void a(d<Object> dVar, boolean z);
    }

    private class b extends com.tencent.mm.performance.a.a.a {
        final /* synthetic */ c igE;

        public b(c cVar) {
            this.igE = cVar;
        }

        public final void q(Activity activity) {
            super.q(activity);
            c cVar = this.igE;
            WeakReference weakReference = new WeakReference(new Object());
            d dVar = new d(activity.toString(), activity);
            synchronized (cVar) {
                a aVar = new a(cVar);
                aVar.igF = dVar;
                aVar.igG = weakReference;
                aVar.igH = System.currentTimeMillis();
                aVar.igI = cVar.igB;
                cVar.igA.add(aVar);
            }
        }

        public final void b(Activity activity, Bundle bundle) {
            super.b(activity, bundle);
            c cVar = this.igE;
            cVar.igB++;
            if (this.igE.igB < 0) {
                this.igE.igB = 0;
            }
        }
    }

    private void a(d<Object> dVar) {
        Object obj = dVar.get();
        if (obj != null) {
            boolean z = obj instanceof Activity;
            synchronized (this.igs) {
                Iterator it = this.igs.iterator();
                while (it.hasNext()) {
                    ((c) it.next()).a(dVar, z);
                }
            }
        }
    }

    public final String Nb() {
        return TYPE;
    }

    public final void Nc() {
        if (this.igA != null && !this.igA.isEmpty()) {
            long currentTimeMillis = System.currentTimeMillis();
            synchronized (this) {
                ArrayList arrayList;
                Iterator it;
                if (!this.igz.isEmpty()) {
                    arrayList = null;
                    for (WeakReference weakReference : this.igz.keySet()) {
                        if (weakReference.get() == null) {
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                            }
                            arrayList.add(weakReference);
                        }
                        arrayList = arrayList;
                    }
                    if (arrayList != null) {
                        it = arrayList.iterator();
                        while (it.hasNext()) {
                            this.igz.remove((WeakReference) it.next());
                        }
                    }
                }
                Iterator it2 = this.igA.iterator();
                ArrayList arrayList2 = null;
                Object obj = null;
                Object obj2 = null;
                while (it2.hasNext()) {
                    a aVar = (a) it2.next();
                    long j = aVar.igI;
                    if (aVar.igG.get() != null) {
                        obj2 = 1;
                    } else if (aVar.igF.get() == null) {
                        if (arrayList2 == null) {
                            arrayList2 = new ArrayList();
                        }
                        arrayList2.add(aVar);
                    } else {
                        Object obj3;
                        if (this.igB - j <= 8 || currentTimeMillis - aVar.igH < 180000) {
                            obj3 = obj;
                        } else if (this.igz.containsKey(aVar.igF)) {
                            int intValue = ((Integer) this.igz.get(aVar.igF)).intValue();
                            if (intValue >= 3) {
                                a(aVar.igF);
                                w.d("MicroMsg.WxPerformace", "memoryleak activity ===" + aVar.igF.get());
                                if (arrayList2 == null) {
                                    arrayList = new ArrayList();
                                } else {
                                    arrayList = arrayList2;
                                }
                                arrayList.add(aVar);
                                arrayList2 = arrayList;
                            } else {
                                obj = 1;
                                this.igz.put(aVar.igF, Integer.valueOf(intValue + 1));
                            }
                        } else if (aVar.igH < this.igy - 5000) {
                            this.igz.put(aVar.igF, Integer.valueOf(1));
                        } else {
                            obj3 = 1;
                        }
                        obj = obj3;
                    }
                }
                if (arrayList2 != null) {
                    it = arrayList2.iterator();
                    while (it.hasNext()) {
                        this.igA.remove((a) it.next());
                    }
                }
                if (this.igC) {
                    if (obj != null) {
                        this.igD.sendEmptyMessage(1);
                    } else if (obj2 != null && currentTimeMillis - this.igy > 30000) {
                        this.igD.sendEmptyMessage(1);
                    }
                }
            }
        }
    }
}
