package com.tencent.mm.pluginsdk.k.a.d;

import com.tencent.mm.compatible.d.v;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

public class m extends f<k> {
    private final a sGJ;
    public final c sGK;

    private static final class c extends PriorityBlockingQueue<Runnable> {
        public final /* synthetic */ boolean offer(Object obj) {
            Runnable runnable = (Runnable) obj;
            boolean offer = super.offer(runnable);
            w.d("MicroMsg.ResDownloader.NetworkWorker.BlockingQueue", "offer() | tid = %d | " + E(runnable), Long.valueOf(Thread.currentThread().getId()));
            return offer;
        }

        public final /* synthetic */ Object poll(long j, TimeUnit timeUnit) {
            Runnable runnable = (Runnable) super.poll(j, timeUnit);
            if (runnable != null) {
                w.d("MicroMsg.ResDownloader.NetworkWorker.BlockingQueue", "poll(long, TimeUnit) | tid = %d | " + E(runnable), Long.valueOf(Thread.currentThread().getId()));
            }
            return runnable;
        }

        public c() {
            super(11, new Comparator<Runnable>() {
                public final /* synthetic */ int compare(Object obj, Object obj2) {
                    int random;
                    Runnable runnable = (Runnable) obj;
                    Runnable runnable2 = (Runnable) obj2;
                    if ((runnable instanceof c) && (runnable2 instanceof c) && (((c) runnable).sGw instanceof k) && (((c) runnable2).sGw instanceof k)) {
                        k kVar = (k) ((c) runnable).sGw;
                        k kVar2 = (k) ((c) runnable2).sGw;
                        int i = kVar.priority - kVar2.priority;
                        random = (kVar.bDs() && kVar2.bDs()) ? i != 0 ? i : ((int) (Math.random() * 50.0d)) - 25 : i;
                    } else {
                        random = 0;
                    }
                    return 0 - random;
                }
            });
        }

        private static String E(Runnable runnable) {
            if (!(runnable instanceof c)) {
                return String.format("unknown runnable = %s", new Object[]{runnable});
            } else if (((c) runnable).sGw instanceof k) {
                return String.format("priority = %d, urlKey = %s", new Object[]{Integer.valueOf(((k) ((c) runnable).sGw).priority), ((c) runnable).sGw.bDp()});
            } else {
                return String.format("unknown request = %s", new Object[]{((c) runnable).sGw});
            }
        }
    }

    public static abstract class a<Req extends k> extends d<Req> implements e {
        private static final ThreadLocal<j> sGL = new ThreadLocal<j>() {
            protected final /* synthetic */ Object initialValue() {
                return new j();
            }
        };
        private volatile int hNR = this.sFh;
        private final int sFh;
        public volatile c sGM;

        public a(Req req) {
            super(req);
            this.sFh = req.sFh;
        }

        public l a(j jVar) {
            if (!Qs()) {
                return jVar.a(this);
            }
            q Mu = a.sGQ.Mu(bDp());
            if (Mu != null) {
                Mu.field_status = 1;
                a.sGQ.e(Mu);
            }
            return jVar.a(this);
        }

        public boolean Qs() {
            return true;
        }

        public final void run() {
            l a = a((j) sGL.get());
            if (a != null) {
                this.sGM.a(this, a);
                return;
            }
            w.e("MicroMsg.ResDownloader.NetworkWorker", "groupId = %s, performer get null response", Qo());
        }

        public boolean Qp() {
            return false;
        }

        public boolean Qq() {
            return true;
        }

        public boolean Qr() {
            return false;
        }

        public boolean Qt() {
            return true;
        }

        public String getURL() {
            return ((k) Qv()).url;
        }

        public final String bDB() {
            return "GET";
        }

        public final Collection<b> bDC() {
            Map requestHeaders = ((k) Qv()).getRequestHeaders();
            if (requestHeaders == null || requestHeaders.size() == 0) {
                return null;
            }
            Set<String> keySet = requestHeaders.keySet();
            if (keySet == null || keySet.size() == 0) {
                return null;
            }
            Collection<b> linkedList = new LinkedList();
            for (String str : keySet) {
                String str2 = (String) requestHeaders.get(str);
                if (!bg.mA(str2)) {
                    linkedList.add(new b(str, str2));
                }
            }
            return linkedList;
        }

        public final int getConnectTimeout() {
            return ((k) Qv()).getConnectTimeout();
        }

        public final int getReadTimeout() {
            return ((k) Qv()).getReadTimeout();
        }

        public final int bDD() {
            return ((k) Qv()).bDD();
        }

        public final String bDE() {
            return "application/x-www-form-urlencoded;charset=utf-8";
        }

        public final String bDp() {
            return ((k) Qv()).sEX;
        }

        public final String getFilePath() {
            return ((k) Qv()).getFilePath();
        }

        public boolean Qu() {
            int i = this.hNR - 1;
            this.hNR = i;
            boolean z = i > 0;
            this.sGM.n(bDp(), this.sFh, this.hNR);
            return z;
        }

        public boolean dW(long j) {
            this.sGM.n(bDp(), j);
            w.i("MicroMsg.ResDownloader.NetworkWorker", "%s: get available size = %d", bDp(), Long.valueOf(av.bJE()));
            if (av.bJE() >= j) {
                return true;
            }
            return false;
        }
    }

    private static class b extends a<k> {
        b(k kVar) {
            super(kVar);
        }

        public final String Qo() {
            return "ResDownload";
        }
    }

    public m(t tVar, c cVar) {
        this(tVar, cVar, (byte) 0);
    }

    private m(t tVar, c cVar, byte b) {
        this.sGJ = new a(this, 4, 4, 3000, TimeUnit.MILLISECONDS, new c(), tVar);
        this.sGJ.setKeepAliveTime(30000, TimeUnit.MILLISECONDS);
        this.sGJ.allowCoreThreadTimeOut(true);
        this.sGK = cVar;
    }

    public int b(k kVar) {
        int i = 0;
        if (Ms(kVar.sEX) || isDownloading(kVar.sEX)) {
            w.i("MicroMsg.ResDownloader.NetworkWorker", "urlKey = %s is already queueing, skip repeated task", kVar.sEX);
            return 0;
        }
        int rR = v.rR();
        w.i("MicroMsg.ResDownloader.NetworkWorker", "currentNetType(%d), requestNetType(%d)", Integer.valueOf(rR), Integer.valueOf(kVar.networkType));
        if (rR != 0) {
            if (2 == kVar.networkType) {
                rR = 1;
            } else if (rR == 1) {
                rR = 1;
            }
            if (rR != 0) {
                w.i("MicroMsg.ResDownloader.NetworkWorker", "urlKey = %s, mismatch networkType , skip task", kVar.sEX);
                return 1;
            }
            if (this.sGJ.isShutdown() || this.sGJ.isTerminated() || this.sGJ.isTerminating()) {
                i = 1;
            }
            if (i != 0) {
                return 4;
            }
            super.b(kVar);
            return 2;
        }
        rR = 0;
        if (rR != 0) {
            i = 1;
            if (i != 0) {
                return 4;
            }
            super.b(kVar);
            return 2;
        }
        w.i("MicroMsg.ResDownloader.NetworkWorker", "urlKey = %s, mismatch networkType , skip task", kVar.sEX);
        return 1;
    }

    public final boolean isDownloading(String str) {
        return this.sGu.containsKey(str);
    }

    protected final a bDv() {
        return this.sGJ;
    }

    public d a(k kVar) {
        w.i("MicroMsg.ResDownloader.NetworkWorker", "request.class = " + kVar.getClass().getSimpleName());
        o oVar = a.sGQ;
        d c = o.c(kVar);
        if (c == null) {
            w.i("MicroMsg.ResDownloader.NetworkWorker", "get null handler from plugin, use default handler");
            c = new b(kVar);
        }
        c.sGM = this.sGK;
        return c;
    }

    public void shutdown() {
        this.sGJ.shutdownNow();
        for (String str : this.sGu.keySet()) {
            Future future = (Future) this.sGu.get(str);
            if (future != null) {
                future.cancel(true);
            }
        }
        this.sGt.clear();
        this.sGu.clear();
    }
}
