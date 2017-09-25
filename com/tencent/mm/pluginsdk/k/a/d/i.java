package com.tencent.mm.pluginsdk.k.a.d;

import android.util.SparseArray;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.List;

public final class i implements c {
    private final ae sGx;
    public final SparseArray<List<d>> sGy = new SparseArray();
    public final Object sGz = new Object();

    i(ae aeVar) {
        this.sGx = aeVar;
    }

    public final void a(e eVar, final l lVar) {
        w.i("MicroMsg.ResDownloader.NetworkEventDispatcher", "dispatchResponse, response = " + lVar);
        q Mu;
        final List Mt;
        final String bDp;
        switch (lVar.status) {
            case 2:
                Mu = a.sGQ.Mu(lVar.sEX);
                if (Mu != null) {
                    Mu.field_status = 2;
                    a.sGQ.e(Mu);
                }
                w.d("MicroMsg.ResDownloader.NetworkEventDispatcher", "dispatchComplete, groupId = " + eVar.Qo());
                Mt = Mt(eVar.Qo());
                if (bg.bV(Mt)) {
                    w.d("MicroMsg.ResDownloader.NetworkEventDispatcher", "dispatchComplete, listeners.size = null");
                    return;
                }
                w.d("MicroMsg.ResDownloader.NetworkEventDispatcher", "dispatchComplete, listeners.size = " + Mt.size());
                bDp = eVar.bDp();
                this.sGx.post(new Runnable(this) {
                    final /* synthetic */ i sGB;

                    public final void run() {
                        for (d dVar : Mt) {
                            if (bg.mz(dVar.Qo()).equals(lVar.groupId)) {
                                dVar.a(bDp, lVar);
                            }
                        }
                    }
                });
                return;
            case 3:
                Mu = a.sGQ.Mu(lVar.sEX);
                if (Mu != null) {
                    Mu.field_status = 3;
                    a.sGQ.e(Mu);
                }
                Mt = Mt(eVar.Qo());
                if (!bg.bV(Mt)) {
                    bDp = eVar.bDp();
                    this.sGx.post(new Runnable(this) {
                        final /* synthetic */ i sGB;

                        public final void run() {
                            for (d dVar : Mt) {
                                if (bg.mz(dVar.Qo()).equals(lVar.groupId)) {
                                    dVar.b(bDp, lVar);
                                }
                            }
                        }
                    });
                    return;
                }
                return;
            case 4:
                Mu = a.sGQ.Mu(lVar.sEX);
                if (Mu != null) {
                    Mu.field_status = 4;
                    a.sGQ.e(Mu);
                }
                Mt = Mt(eVar.Qo());
                if (!bg.bV(Mt)) {
                    bDp = eVar.bDp();
                    this.sGx.post(new Runnable(this) {
                        final /* synthetic */ i sGB;

                        public final void run() {
                            for (d dVar : Mt) {
                                if (bg.mz(dVar.Qo()).equals(lVar.groupId)) {
                                    dVar.Ji(bDp);
                                }
                            }
                        }
                    });
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void n(String str, int i, int i2) {
        w.i("MicroMsg.ResDownloader.NetworkEventDispatcher", "dispatchRetry, urlKey = %s, max = %d, count = %d", str, Integer.valueOf(i), Integer.valueOf(i2));
        q Mu = a.sGQ.Mu(str);
        if (Mu != null) {
            Mu.field_maxRetryTimes = i;
            Mu.field_retryTimes = i2;
            a.sGQ.e(Mu);
        }
    }

    public final void n(String str, long j) {
        q Mu = a.sGQ.Mu(str);
        if (Mu != null) {
            Mu.field_contentLength = j;
            a.sGQ.e(Mu);
        }
    }

    private List<d> Mt(String str) {
        List<d> list;
        int hashCode = str.hashCode();
        synchronized (this.sGz) {
            list = (List) this.sGy.get(hashCode);
        }
        return list;
    }
}
