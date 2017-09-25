package com.tencent.mm.plugin.search.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Looper;
import android.widget.ImageView;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.plugin.fts.d.g;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

public final class h implements g {
    private static int pgr = 32;
    public ae hgN = new ae(Looper.getMainLooper());
    public Set<String> pgA;
    private ConcurrentHashMap<String, a> pgs;
    private Vector<String> pgt;
    private boolean pgu = true;
    private int pgv = 0;
    public ae[] pgw = new ae[2];
    private ConcurrentHashMap<Long, ByteArrayOutputStream> pgx = null;
    private ConcurrentHashMap<Long, byte[]> pgy = null;
    public ae pgz = null;

    class a {
        Bitmap bitmap;
        String fQE;
        final /* synthetic */ h pgB;

        a(h hVar) {
            this.pgB = hVar;
        }
    }

    class b implements Runnable {
        private String fQE;
        private int height;
        private String iHY;
        final /* synthetic */ h pgB;
        private boolean pgD;
        private c pgE;
        private String url;
        private int width;

        public b(h hVar, String str, String str2, String str3, boolean z, int i, int i2, c cVar) {
            this.pgB = hVar;
            this.iHY = str;
            this.url = str2;
            this.fQE = str3;
            this.pgE = cVar;
            this.pgD = z;
            this.width = i;
            this.height = i2;
        }

        public final void run() {
            w.d("MicroMsg.FTS.SearchImageLoader", "Start to run load bitmap job %s", new Object[]{this.iHY});
            if (bg.mA(this.fQE)) {
                this.fQE = h.DY(this.iHY);
            }
            long currentTimeMillis = System.currentTimeMillis();
            Bitmap I = h.I(this.fQE, this.width, this.height);
            long currentTimeMillis2 = System.currentTimeMillis();
            if (I != null) {
                w.d("MicroMsg.FTS.SearchImageLoader", "Found image in local %s | localPath %s | use time %d", new Object[]{this.url, this.fQE, Long.valueOf(currentTimeMillis2 - currentTimeMillis)});
                this.pgB.a(this.iHY, this.fQE, I);
                this.pgE.ai(this.iHY, true);
                return;
            }
            Bitmap b = this.pgB.b(this.url, this.pgD, this.width, this.height);
            long currentTimeMillis3 = System.currentTimeMillis();
            w.d("MicroMsg.FTS.SearchImageLoader", "Get image from net %s | localPath %s | use time %d", new Object[]{this.url, this.fQE, Long.valueOf(currentTimeMillis3 - currentTimeMillis2)});
            if (b != null) {
                this.pgB.a(this.iHY, this.fQE, b);
                this.pgE.ai(this.iHY, true);
                return;
            }
            this.pgE.ai(this.iHY, false);
        }
    }

    interface c {
        void ai(String str, boolean z);
    }

    class d implements Runnable {
        final /* synthetic */ h pgB;
        private a pgF;

        public d(h hVar, a aVar) {
            this.pgB = hVar;
            this.pgF = aVar;
        }

        public final void run() {
            w.d("MicroMsg.FTS.SearchImageLoader", "Start to run save bitmap job");
            try {
                if (!new File(this.pgF.fQE).exists()) {
                    if (this.pgF.bitmap == null || this.pgF.bitmap.isRecycled()) {
                        w.d("MicroMsg.FTS.SearchImageLoader", "Save Bitmap is Recycled");
                        return;
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    com.tencent.mm.sdk.platformtools.d.a(this.pgF.bitmap, 100, CompressFormat.PNG, this.pgF.fQE, false);
                    w.d("MicroMsg.FTS.SearchImageLoader", "Save bitmap use time: %d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                }
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.FTS.SearchImageLoader", e, "", new Object[0]);
            }
        }
    }

    public h() {
        int i = 0;
        w.i("MicroMsg.FTS.SearchImageLoader", "create SearchImageLoader");
        if (com.tencent.mm.compatible.util.d.eo(19)) {
            pgr = 64;
        } else {
            pgr = 32;
        }
        this.pgs = new ConcurrentHashMap();
        this.pgt = new Vector();
        this.pgx = new ConcurrentHashMap();
        this.pgy = new ConcurrentHashMap();
        this.pgA = Collections.synchronizedSet(new HashSet());
        while (i < 2) {
            if (this.pgw[i] == null) {
                e.d(new Runnable(this) {
                    final /* synthetic */ h pgB;

                    public final void run() {
                        Looper.prepare();
                        this.pgB.pgw[i] = new ae();
                        Looper.loop();
                    }
                }, "SearchImageLoader_loadImage_handler", 1).start();
            }
            i++;
        }
        e.d(new Runnable(this) {
            final /* synthetic */ h pgB;

            {
                this.pgB = r1;
            }

            public final void run() {
                Looper.prepare();
                this.pgB.pgz = new ae();
                Looper.loop();
            }
        }, "SearchImageLoader_saveImage_handler", 1).start();
    }

    public final void a(final Context context, final ImageView imageView, String str, String str2, boolean z, int i, int i2) {
        String a = a(imageView, str, str2, z, i, i2);
        if (this.pgu) {
            Runnable bVar = new b(this, a, str, str2, z, i, i2, new c(this) {
                final /* synthetic */ h pgB;

                public final void ai(final String str, boolean z) {
                    w.v("MicroMsg.FTS.SearchImageLoader", "LoadBitmapJob finish: %s %b", new Object[]{str, Boolean.valueOf(z)});
                    this.pgB.pgA.remove(str);
                    if (z) {
                        final Bitmap jH = this.pgB.jH(str);
                        if (str.equals(imageView.getTag())) {
                            this.pgB.hgN.post(new Runnable(this) {
                                final /* synthetic */ AnonymousClass3 pgC;

                                public final void run() {
                                    if (str.equals(imageView.getTag())) {
                                        com.tencent.mm.plugin.fts.d.g.a.a(context.getResources(), jH, imageView);
                                    }
                                }
                            });
                        }
                    }
                }
            });
            if (this.pgA.add(a)) {
                this.pgv++;
                this.pgv %= 2;
                this.pgw[this.pgv].post(bVar);
                return;
            }
            w.v("MicroMsg.FTS.SearchImageLoader", "cacheKey: %s | runningJobTask: %s", new Object[]{a, this.pgA.toString()});
        }
    }

    public final String a(ImageView imageView, String str, String str2, boolean z, int i, int i2) {
        String b = b(str, str2, z, i, i2);
        imageView.setTag(b);
        w.d("MicroMsg.FTS.SearchImageLoader", "update image view cache key: hashcode=%d | cacheKey=%s", new Object[]{Integer.valueOf(imageView.hashCode()), b});
        return b;
    }

    public final void axX() {
        w.d("MicroMsg.FTS.SearchImageLoader", "stopLoadImageTask");
        for (int i = 0; i < 2; i++) {
            if (this.pgw[i] != null) {
                this.pgw[i].removeCallbacksAndMessages(null);
            }
        }
    }

    public final void axY() {
        w.d("MicroMsg.FTS.SearchImageLoader", "stopLoadImage");
        this.pgu = false;
        axX();
    }

    public final boolean axZ() {
        return this.pgu;
    }

    public final void aya() {
        w.d("MicroMsg.FTS.SearchImageLoader", "startLoadImage");
        this.pgu = true;
    }

    public final void ayb() {
        w.d("MicroMsg.FTS.SearchImageLoader", "clearCacheAndTask %s", new Object[]{Integer.valueOf(this.pgs.size())});
        axX();
        for (Entry key : this.pgs.entrySet()) {
            DZ((String) key.getKey());
        }
        this.pgt.clear();
        this.pgA.clear();
    }

    public final void ayc() {
        ayb();
        w.d("MicroMsg.FTS.SearchImageLoader", "destoryLoader");
        for (int i = 0; i < 2; i++) {
            if (this.pgw[i] != null) {
                this.pgw[i].getLooper().quit();
            }
        }
        for (ByteArrayOutputStream close : this.pgx.values()) {
            try {
                close.close();
            } catch (IOException e) {
            }
        }
        this.pgx.clear();
        this.pgy.clear();
        this.pgz.getLooper().quit();
    }

    public final Bitmap a(String str, String str2, boolean z, int i, int i2) {
        return jH(b(str, str2, z, i, i2));
    }

    public final Bitmap jH(String str) {
        a aVar = (a) this.pgs.get(str);
        if (!(aVar == null || aVar.bitmap == null || aVar.bitmap.isRecycled())) {
            this.pgt.remove(str);
            this.pgt.add(0, str);
        }
        return aVar == null ? null : aVar.bitmap;
    }

    private synchronized byte[] getBuffer() {
        byte[] bArr;
        bArr = (byte[]) this.pgy.get(Long.valueOf(Thread.currentThread().getId()));
        if (bArr == null) {
            bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
            this.pgy.put(Long.valueOf(Thread.currentThread().getId()), bArr);
        }
        return bArr;
    }

    private static String b(String str, String str2, boolean z, int i, int i2) {
        return "fts_search_" + com.tencent.mm.a.g.n((bg.ap(str, "null") + bg.ap(str2, "null") + z + i + "_" + i2).getBytes());
    }

    public static String DY(String str) {
        ap.yY();
        return new File(new File(com.tencent.mm.u.c.xb()), str).getAbsolutePath();
    }

    public static Bitmap I(String str, int i, int i2) {
        if (bg.mA(str) || !new File(str).exists()) {
            return null;
        }
        if (i <= 0 || i2 <= 0) {
            return j.mt(str);
        }
        return j.l(str, i, i2);
    }

    public final Bitmap b(String str, boolean z, int i, int i2) {
        Throwable e;
        Bitmap bd;
        if (bg.mA(str)) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = (ByteArrayOutputStream) this.pgx.get(Long.valueOf(Thread.currentThread().getId()));
        if (byteArrayOutputStream == null) {
            byteArrayOutputStream = new ByteArrayOutputStream(WXMediaMessage.THUMB_LENGTH_LIMIT);
            this.pgx.put(Long.valueOf(Thread.currentThread().getId()), byteArrayOutputStream);
        }
        byteArrayOutputStream.reset();
        byte[] buffer = getBuffer();
        InputStream k;
        try {
            k = com.tencent.mm.network.b.k(str, 10000, 20000);
            if (k == null) {
                w.w("MicroMsg.FTS.SearchImageLoader", "download %s error, can not open http stream", new Object[]{str});
                if (k != null) {
                    try {
                        k.close();
                    } catch (Throwable e2) {
                        w.printErrStackTrace("MicroMsg.FTS.SearchImageLoader", e2, "", new Object[0]);
                    }
                }
                return null;
            }
            int i3 = 0;
            while (true) {
                try {
                    int read = k.read(buffer);
                    if (read == -1) {
                        break;
                    }
                    i3 += read;
                    byteArrayOutputStream.write(buffer, 0, read);
                } catch (Exception e3) {
                    e2 = e3;
                }
            }
            byte[] toByteArray = byteArrayOutputStream.toByteArray();
            if (i <= 0 || i2 <= 0) {
                bd = com.tencent.mm.sdk.platformtools.d.bd(toByteArray);
            } else {
                bd = com.tencent.mm.sdk.platformtools.d.decodeByteArray(toByteArray, i, i2);
            }
            w.d("MicroMsg.FTS.SearchImageLoader", "get url[%s] ok, bufSize[%d], bitmap size %d * %d", new Object[]{str, Integer.valueOf(i3), Integer.valueOf(bd.getWidth()), Integer.valueOf(bd.getHeight())});
            if (z) {
                bd = com.tencent.mm.sdk.platformtools.d.a(bd, true, (float) bd.getWidth());
                if (k == null) {
                    return bd;
                }
                try {
                    k.close();
                    return bd;
                } catch (Throwable e4) {
                    w.printErrStackTrace("MicroMsg.FTS.SearchImageLoader", e4, "", new Object[0]);
                    return bd;
                }
            } else if (k == null) {
                return bd;
            } else {
                try {
                    k.close();
                    return bd;
                } catch (Throwable e42) {
                    w.printErrStackTrace("MicroMsg.FTS.SearchImageLoader", e42, "", new Object[0]);
                    return bd;
                }
            }
        } catch (Exception e5) {
            e2 = e5;
            k = null;
            try {
                w.printErrStackTrace("MicroMsg.FTS.SearchImageLoader", e2, "", new Object[0]);
                w.w("MicroMsg.FTS.SearchImageLoader", "get url:%s failed.", new Object[]{str});
                if (k != null) {
                    try {
                        k.close();
                    } catch (Throwable e22) {
                        w.printErrStackTrace("MicroMsg.FTS.SearchImageLoader", e22, "", new Object[0]);
                    }
                }
                return null;
            } catch (Throwable th) {
                e22 = th;
                if (k != null) {
                    try {
                        k.close();
                    } catch (Throwable e422) {
                        w.printErrStackTrace("MicroMsg.FTS.SearchImageLoader", e422, "", new Object[0]);
                    }
                }
                throw e22;
            }
        } catch (Throwable th2) {
            e22 = th2;
            k = null;
            if (k != null) {
                k.close();
            }
            throw e22;
        }
    }

    public final void a(String str, String str2, Bitmap bitmap) {
        if (this.pgs.size() > pgr) {
            DZ((String) this.pgt.lastElement());
        }
        a aVar = new a(this);
        aVar.fQE = str2;
        aVar.bitmap = bitmap;
        this.pgs.put(str, aVar);
        if (!new File(aVar.fQE).exists()) {
            this.pgz.postDelayed(new d(this, aVar), 200);
        }
    }

    private void DZ(String str) {
        a aVar = (a) this.pgs.get(str);
        this.pgt.remove(str);
        this.pgs.remove(str);
        if (aVar != null && aVar.bitmap != null) {
            if (!aVar.bitmap.isRecycled()) {
                w.i("MicroMsg.FTS.SearchImageLoader", "bitmap recycle %s", new Object[]{aVar.bitmap});
                aVar.bitmap.recycle();
            }
            aVar.bitmap = null;
        }
    }
}
