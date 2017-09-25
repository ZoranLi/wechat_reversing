package com.tencent.mm.q;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public final class a {
    static a gUL;
    public b gUM = new b();
    ArrayList<WeakReference<a>> gUN = new ArrayList();
    public boolean gUO = false;
    private final int gUP = 0;
    private final int gUQ = 1;
    private ae handler = new ae(this, Looper.getMainLooper()) {
        final /* synthetic */ a gUR;

        public final void handleMessage(Message message) {
            if (message.what == 0 && (message.obj instanceof b)) {
                b bVar = (b) message.obj;
                if (bVar.gUT != null) {
                    a aVar = this.gUR;
                    com.tencent.mm.storage.w.a aVar2 = bVar.gUT;
                    ArrayList arrayList = null;
                    Iterator it = aVar.gUN.iterator();
                    while (it.hasNext()) {
                        WeakReference weakReference = (WeakReference) it.next();
                        if (weakReference == null || weakReference.get() == null) {
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                            }
                            arrayList.add(weakReference);
                        } else {
                            ((a) weakReference.get()).a(aVar2);
                        }
                    }
                    if (arrayList != null) {
                        Iterator it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            aVar.gUN.remove((WeakReference) it2.next());
                        }
                        arrayList.clear();
                    }
                } else {
                    this.gUR.eE(bVar.gUS);
                }
            }
            if (message.what == 1 && (message.obj instanceof c)) {
                c cVar = (c) message.obj;
                if (cVar.gUT != null) {
                    this.gUR.ui();
                } else {
                    this.gUR.eF(cVar.gUU);
                }
            }
        }
    };

    public interface a {
        void a(com.tencent.mm.storage.w.a aVar);

        void eE(int i);

        void eF(int i);
    }

    class b {
        final /* synthetic */ a gUR;
        int gUS;
        com.tencent.mm.storage.w.a gUT;
        int type;
        String value;

        public b(a aVar, int i, int i2, String str) {
            this.gUR = aVar;
            this.gUS = i;
            this.type = i2;
            this.value = str;
        }

        public b(a aVar, com.tencent.mm.storage.w.a aVar2, int i, String str) {
            this.gUR = aVar;
            this.gUT = aVar2;
            this.type = i;
            this.value = str;
        }
    }

    class c {
        final /* synthetic */ a gUR;
        int gUS;
        com.tencent.mm.storage.w.a gUT;
        int gUU;
        com.tencent.mm.storage.w.a gUV;

        public c(a aVar, int i, int i2) {
            this.gUR = aVar;
            this.gUU = i;
            this.gUS = i2;
        }

        public c(a aVar, com.tencent.mm.storage.w.a aVar2, com.tencent.mm.storage.w.a aVar3) {
            this.gUR = aVar;
            this.gUV = aVar2;
            this.gUT = aVar3;
        }
    }

    public final void init() {
        this.gUO = true;
        this.gUM.gVb = h.vI().vr();
    }

    public final void s(int i, boolean z) {
        a(i, 1, !z ? "0" : "1");
    }

    public final void a(com.tencent.mm.storage.w.a aVar, boolean z) {
        a(aVar, 1, !z ? "0" : "1");
    }

    public final void t(int i, boolean z) {
        a(i, 2, !z ? "0" : "1");
    }

    public final void b(com.tencent.mm.storage.w.a aVar, boolean z) {
        a(aVar, 2, !z ? "0" : "1");
    }

    public final void eE(int i) {
        ArrayList arrayList = null;
        Iterator it = this.gUN.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (weakReference == null || weakReference.get() == null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(weakReference);
            } else {
                ((a) weakReference.get()).eE(i);
            }
        }
        if (arrayList != null) {
            it = arrayList.iterator();
            while (it.hasNext()) {
                this.gUN.remove((WeakReference) it.next());
            }
            arrayList.clear();
        }
    }

    public final void eF(int i) {
        ArrayList arrayList = null;
        Iterator it = this.gUN.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (weakReference == null || weakReference.get() == null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(weakReference);
            } else {
                ((a) weakReference.get()).eF(i);
            }
        }
        if (arrayList != null) {
            it = arrayList.iterator();
            while (it.hasNext()) {
                this.gUN.remove((WeakReference) it.next());
            }
            arrayList.clear();
        }
    }

    public final void ui() {
        ArrayList arrayList = null;
        Iterator it = this.gUN.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (weakReference == null || weakReference.get() == null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(weakReference);
            } else {
                weakReference.get();
            }
        }
        if (arrayList != null) {
            it = arrayList.iterator();
            while (it.hasNext()) {
                this.gUN.remove((WeakReference) it.next());
            }
            arrayList.clear();
        }
    }

    private void a(int i, int i2, String str) {
        if (this.gUO) {
            b bVar = this.gUM;
            w.d("MicroMsg.NewBadgeDecoder", "[carl] updateDataSourceValue, dataSourceId %d, type %d, value %s", Integer.valueOf(i), Integer.valueOf(i2), str);
            com.tencent.mm.q.b.a eJ = bVar.eJ(i);
            if (eJ == null) {
                eJ = bVar.a(i, i2, "", "");
                bVar.gUW.put(i, eJ);
                bVar.a(eJ);
            }
            eJ.value = str;
            eJ.type = i2;
            eJ.fGV = bVar.uj();
            bVar.a(eJ);
            this.handler.sendMessage(this.handler.obtainMessage(0, new b(this, i, i2, str)));
            return;
        }
        w.w("MicroMsg.NewBadge", "updateDataSource NewBadge has not initialized");
    }

    private void a(com.tencent.mm.storage.w.a aVar, int i, String str) {
        if (this.gUO) {
            b bVar = this.gUM;
            w.d("MicroMsg.NewBadgeDecoder", "[carl] updateDataSourceValue, dataSourceKey %s, type %d, value %s", aVar, Integer.valueOf(i), str);
            com.tencent.mm.q.b.a e = bVar.e(aVar);
            if (e == null) {
                e = bVar.a(aVar, i, "", "");
                bVar.gUX.put(aVar, e);
                bVar.a(e);
            }
            e.value = str;
            e.type = i;
            e.fGV = bVar.uj();
            bVar.a(e);
            this.handler.sendMessage(this.handler.obtainMessage(0, new b(this, aVar, i, str)));
            return;
        }
        w.w("MicroMsg.NewBadge", "updateDataSource NewBadge has not initialized");
    }

    public final boolean aC(int i, int i2) {
        if (this.gUO) {
            com.tencent.mm.q.b.a p = this.gUM.p(i, i2, 1);
            if (p == null || parseInt(p.value) == 0) {
                return false;
            }
            return true;
        }
        w.w("MicroMsg.NewBadge", "hasNew NewBadge has not initialized");
        return false;
    }

    public final boolean a(com.tencent.mm.storage.w.a aVar, com.tencent.mm.storage.w.a aVar2) {
        if (this.gUO) {
            com.tencent.mm.q.b.a a = this.gUM.a(aVar, aVar2, 1);
            if (a == null || parseInt(a.value) == 0) {
                return false;
            }
            return true;
        }
        w.w("MicroMsg.NewBadge", "hasNew NewBadge has not initialized");
        return false;
    }

    public final boolean aD(int i, int i2) {
        if (this.gUO) {
            com.tencent.mm.q.b.a p = this.gUM.p(i, i2, 2);
            if (p == null || parseInt(p.value) == 0) {
                return false;
            }
            return true;
        }
        w.w("MicroMsg.NewBadge", "hasDot NewBadge has not initialized");
        return false;
    }

    public final boolean b(com.tencent.mm.storage.w.a aVar, com.tencent.mm.storage.w.a aVar2) {
        if (this.gUO) {
            com.tencent.mm.q.b.a a = this.gUM.a(aVar, aVar2, 2);
            if (a == null || parseInt(a.value) == 0) {
                return false;
            }
            return true;
        }
        w.w("MicroMsg.NewBadge", "hasDot NewBadge has not initialized");
        return false;
    }

    public final void aE(int i, int i2) {
        if (this.gUO) {
            b bVar = this.gUM;
            w.d("MicroMsg.NewBadgeDecoder", "[carl] doWatch, doWatch %d, watcherId %d", Integer.valueOf(i), Integer.valueOf(i2));
            com.tencent.mm.q.b.a eJ = bVar.eJ(i);
            if (eJ == null) {
                w.d("MicroMsg.NewBadgeDecoder", "[carl] doWatch, dataSource == null");
            } else {
                com.tencent.mm.q.b.b eK = bVar.eK(i2);
                if (eK == null) {
                    w.e("MicroMsg.NewBadgeDecoder", "[carl] doWatch, watcher == null, do some fix");
                    eK = bVar.eI(i2);
                    bVar.gUY.put(i2, eK);
                }
                eK.gVe.put(i, eJ.fGV);
                bVar.a(eK);
            }
            this.handler.sendMessage(this.handler.obtainMessage(1, new c(this, i2, i)));
            return;
        }
        w.w("MicroMsg.NewBadge", "markRead NewBadge has not initialized");
    }

    public final void c(com.tencent.mm.storage.w.a aVar, com.tencent.mm.storage.w.a aVar2) {
        if (this.gUO) {
            b bVar = this.gUM;
            w.d("MicroMsg.NewBadgeDecoder", "[carl] doWatch, doWatch %s, watcherKey %s", aVar, aVar2);
            com.tencent.mm.q.b.a e = bVar.e(aVar);
            if (e == null) {
                w.d("MicroMsg.NewBadgeDecoder", "[carl] doWatch, dataSource == null");
            } else {
                com.tencent.mm.q.b.b f = bVar.f(aVar2);
                if (f == null) {
                    w.e("MicroMsg.NewBadgeDecoder", "[carl] doWatch, watcher == null, do some fix");
                    f = bVar.d(aVar2);
                    bVar.gUZ.put(aVar2, f);
                }
                f.gVf.put(aVar.name(), e.fGV);
                bVar.a(f);
            }
            this.handler.sendMessage(this.handler.obtainMessage(1, new c(this, aVar2, aVar)));
            return;
        }
        w.w("MicroMsg.NewBadge", "markRead NewBadge has not initialized");
    }

    public static int parseInt(String str) {
        if (bg.mA(str)) {
            return 0;
        }
        return bg.PY(str);
    }

    public final void a(a aVar) {
        if (this.gUO) {
            this.gUN.add(new WeakReference(aVar));
        } else {
            w.w("MicroMsg.NewBadge", "addWatch NewBadge has not initialized");
        }
    }

    public final void b(a aVar) {
        if (this.gUO) {
            ArrayList arrayList = null;
            for (int i = 0; i < this.gUN.size(); i++) {
                WeakReference weakReference = (WeakReference) this.gUN.get(i);
                if (weakReference == null || weakReference.get() == null || weakReference.get() == aVar) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(weakReference);
                }
            }
            if (arrayList != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    this.gUN.remove((WeakReference) it.next());
                }
                arrayList.clear();
                return;
            }
            return;
        }
        w.w("MicroMsg.NewBadge", "removeWatch NewBadge has not initialized");
    }
}
