package com.tencent.mm.pluginsdk.k.a.d;

import android.os.Looper;
import android.os.Process;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Future;

public final class o {
    public final ae handler;
    private volatile af hta = null;
    public final boolean rXW;
    public final r sGN;
    public final m sGO;
    public final i sGP;

    private static final class a {
        public static final o sGQ = new o();
    }

    private static class b implements Runnable {
        private final Runnable ibT;

        public b(Runnable runnable) {
            this.ibT = runnable;
        }

        public final void run() {
            if ((Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId() ? 1 : null) == null && Process.getThreadPriority(Process.myTid()) != 10) {
                Process.setThreadPriority(10);
            }
            if (this.ibT != null) {
                this.ibT.run();
            }
        }
    }

    public o() {
        p.init();
        this.sGN = r.bDI();
        if (this.sGN == null) {
            this.rXW = false;
            this.sGO = null;
            this.handler = null;
            this.sGP = null;
            return;
        }
        this.rXW = true;
        t tVar = new t();
        this.handler = new ae(Looper.getMainLooper());
        this.sGP = new i(vL().bJl());
        this.sGO = new m(tVar, this.sGP);
    }

    public final void y(Runnable runnable) {
        vL().D(new b(runnable));
    }

    final af vL() {
        if (this.hta == null) {
            this.hta = new af("ResDownloader-WorkerThread");
        }
        return this.hta;
    }

    public final void a(String str, d dVar) {
        w.d("MicroMsg.ResDownloaderCore", "addNetworkEventLister, groupId = %s, listener = %s", str, dVar);
        if (this.rXW) {
            i iVar = this.sGP;
            w.d("MicroMsg.ResDownloader.NetworkEventDispatcher", "addNetworkEventListener, listener = " + dVar);
            if (dVar != null) {
                int hashCode = str.hashCode();
                synchronized (iVar.sGz) {
                    List list = (List) iVar.sGy.get(hashCode);
                    if (list == null) {
                        list = new LinkedList();
                    }
                    list.add(dVar);
                    iVar.sGy.put(hashCode, list);
                }
            }
        }
    }

    static com.tencent.mm.pluginsdk.k.a.d.m.a c(k kVar) {
        w.d("MicroMsg.ResDownloaderCore", "getNetworkRequestHandler");
        int hashCode = kVar.Qo().hashCode();
        for (g gVar : p.bDH()) {
            w.i("MicroMsg.ResDownloaderCore", "plugin = %s, groupId = %s", gVar.getClass().getSimpleName(), gVar.Qo());
            if (gVar.Qo().hashCode() == hashCode) {
                return gVar.c(kVar);
            }
        }
        return null;
    }

    public final void e(q qVar) {
        if (this.rXW) {
            long Nz = bg.Nz();
            if (this.sGN.Mu(qVar.field_urlKey) != null) {
                w.i("MicroMsg.ResDownloaderCore", "doUpdate: update existing record");
                this.sGN.f(qVar);
            } else {
                w.i("MicroMsg.ResDownloaderCore", "doUpdate: insert new record");
                this.sGN.g(qVar);
            }
            w.i("MicroMsg.ResDownloaderCore", "doUpdate: urlKey = %s, cost = %d", qVar.field_urlKey, Long.valueOf(bg.aA(Nz)));
        }
    }

    public final q Mu(String str) {
        if (!this.rXW) {
            return null;
        }
        long Nz = bg.Nz();
        q Mu = this.sGN.Mu(str);
        String str2 = "MicroMsg.ResDownloaderCore";
        String str3 = "doQuery: urlKey = %s, cost = %d";
        Object[] objArr = new Object[2];
        objArr[0] = Mu == null ? "null" : Mu.field_urlKey;
        objArr[1] = Long.valueOf(bg.aA(Nz));
        w.i(str2, str3, objArr);
        return Mu;
    }

    public final int d(k kVar) {
        if (!this.rXW) {
            return -1;
        }
        if (bg.mA(kVar.url)) {
            w.i("MicroMsg.ResDownloaderCore", "request#%s with null url, ignore", kVar.sEX);
            return 3;
        }
        w.i("MicroMsg.ResDownloaderCore", "request#%s post to network worker", kVar.sEX);
        return this.sGO.b(kVar);
    }

    public final boolean Mv(String str) {
        if (!this.rXW) {
            return false;
        }
        if (this.sGO.isDownloading(str) || this.sGO.Ms(str)) {
            return true;
        }
        return false;
    }

    public final void Mw(String str) {
        if (this.rXW) {
            f fVar = this.sGO;
            Future future = (Future) fVar.sGu.remove(str);
            if (future != null) {
                future.cancel(true);
            }
            fVar.sGt.remove(str);
        }
    }
}
