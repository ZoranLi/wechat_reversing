package com.tencent.mm.modelappbrand.a;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class b {
    public static final String hqi;
    public final Map<h, String> hqc = new ConcurrentHashMap();
    public final Map<String, h> hqd = new ConcurrentHashMap();
    public final Map<Integer, String> hqe = new ConcurrentHashMap();
    public final d hqf = new d(new ae(new af("AppBrandSimpleImageLoaderDiskIOHandlerThread").nJF.getLooper()));
    private final i hqg = new c();
    private final g hqh = new a();

    private static final class d {
        private final ae hqo;
        final Map<String, List<a>> hqp = new HashMap();
        final Map<String, Boolean> hqq = new HashMap();

        interface a {
            void Bd();

            void Be();
        }

        public d(ae aeVar) {
            this.hqo = aeVar;
        }

        final void gT(String str) {
            if (!bg.mA(str)) {
                List<a> list = (List) this.hqp.remove(str);
                if (!bg.bV(list)) {
                    for (a Bd : list) {
                        Bd.Bd();
                    }
                }
            }
        }

        final void gU(String str) {
            if (!bg.mA(str)) {
                this.hqq.remove(str);
            }
        }

        final void a(String str, a aVar) {
            if (!bg.mA(str) && aVar != null) {
                List list = (List) this.hqp.get(str);
                if (list != null) {
                    list.remove(aVar);
                }
            }
        }

        final void gV(String str) {
            if (!bg.mA(str)) {
                List<a> list = (List) this.hqp.remove(str);
                if (!bg.bV(list)) {
                    for (a Be : list) {
                        Be.Be();
                    }
                    list.clear();
                }
            }
        }

        final void f(Runnable runnable) {
            this.hqo.post(runnable);
        }
    }

    public interface e {
        Bitmap e(InputStream inputStream);
    }

    public interface f {
        String Bc();

        Bitmap i(Bitmap bitmap);
    }

    public interface g {
        OutputStream gQ(String str);

        boolean gR(String str);

        InputStream openRead(String str);
    }

    public interface h {
        void Ba();

        void Bb();

        String Bc();

        void h(Bitmap bitmap);
    }

    public interface i {
        void b(String str, Bitmap bitmap);

        void e(Bitmap bitmap);

        Bitmap gS(String str);
    }

    private static final class l {
        static final b hqE = new b();
    }

    private static final class a implements g {
        public final OutputStream gQ(String str) {
            try {
                return new FileOutputStream(b.hqi + str);
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.AppBrandSimpleImageLoader.DefaultDiskCache", e, "openWrite fileName %s", str);
                return null;
            }
        }

        public final InputStream openRead(String str) {
            try {
                return new FileInputStream(b.hqi + str);
            } catch (IOException e) {
                w.d("MicroMsg.AppBrandSimpleImageLoader.DefaultDiskCache", "openRead fileName %s, e %s", str, e);
                return null;
            }
        }

        public final boolean gR(String str) {
            return !bg.mA(str) && com.tencent.mm.loader.stub.b.deleteFile(b.hqi + str);
        }
    }

    public static class b implements h {
        public final void Ba() {
        }

        public void h(Bitmap bitmap) {
        }

        public final void Bb() {
        }

        public final String Bc() {
            return "DefaultLoadTarget";
        }
    }

    public static final class c implements i {
        public final com.tencent.mm.a.f<String, Reference<Bitmap>> hql = new AnonymousClass1(this, 31457280);

        class AnonymousClass1 extends com.tencent.mm.a.f<String, Reference<Bitmap>> {
            private final Map<Reference<Bitmap>, Integer> hqm = new ConcurrentHashMap();
            final /* synthetic */ c hqn;

            AnonymousClass1(c cVar, int i) {
                this.hqn = cVar;
                super(31457280);
            }

            protected final /* synthetic */ void entryRemoved(boolean z, Object obj, Object obj2, Object obj3) {
                String str = (String) obj;
                Reference reference = (Reference) obj2;
                Reference reference2 = (Reference) obj3;
                String str2 = "MicroMsg.AppBrandSimpleImageLoader.DefaultMemoryCache";
                String str3 = "entryRemoved, curSize %d KB, maxSize %d KB, oldBmp %s, newBmp %s";
                Object[] objArr = new Object[4];
                objArr[0] = Integer.valueOf(this.hqn.hql.size() / 10);
                objArr[1] = Integer.valueOf(this.hqn.hql.maxSize() / 10);
                objArr[2] = reference == null ? "null-ref" : reference.get();
                objArr[3] = reference2 == null ? "null-ref" : reference2.get();
                w.d(str2, str3, objArr);
                super.entryRemoved(z, str, reference, reference2);
                Bitmap bitmap = reference == null ? null : (Bitmap) reference.get();
                if (bitmap != (reference2 == null ? null : (Bitmap) reference2.get())) {
                    this.hqn.e(bitmap);
                }
                this.hqm.remove(reference);
            }

            protected final /* synthetic */ int sizeOf(Object obj, Object obj2) {
                Reference reference = (Reference) obj2;
                if (reference == null) {
                    return 0;
                }
                Integer num = (Integer) this.hqm.get(reference);
                if (num != null && num.intValue() >= 0) {
                    return num.intValue();
                }
                Bitmap bitmap = (Bitmap) reference.get();
                int b = (bitmap == null || bitmap.isRecycled()) ? 0 : android.support.v4.b.a.b(bitmap);
                this.hqm.put(reference, Integer.valueOf(b));
                return b;
            }

            public final void clear() {
                w.d("MicroMsg.AppBrandSimpleImageLoader.DefaultMemoryCache", "clear");
                super.clear();
                this.hqm.clear();
            }

            public final void a(com.tencent.mm.a.f.a<String, Reference<Bitmap>> aVar) {
                w.d("MicroMsg.AppBrandSimpleImageLoader.DefaultMemoryCache", "clear(OnClearListener)");
                super.a(aVar);
                this.hqm.clear();
            }
        }

        public final Bitmap gS(String str) {
            if (bg.mA(str)) {
                return null;
            }
            Reference reference = (Reference) this.hql.get(str);
            if (reference == null) {
                return null;
            }
            Bitmap bitmap = (Bitmap) reference.get();
            if (bitmap != null && !bitmap.isRecycled()) {
                return bitmap;
            }
            this.hql.remove(str);
            return null;
        }

        public final void b(String str, Bitmap bitmap) {
            if (!bg.mA(str) && bitmap != null) {
                w.d("MicroMsg.AppBrandSimpleImageLoader.DefaultMemoryCache", "put, key %s, bmp %s", str, bitmap);
                this.hql.put(str, new SoftReference(bitmap));
            }
        }

        public final void e(Bitmap bitmap) {
            w.d("MicroMsg.AppBrandSimpleImageLoader.DefaultMemoryCache", "release, bmp %s", bitmap);
            if (bitmap != null && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
        }
    }

    private static class j implements h {
        public final String arH;
        private final WeakReference<ImageView> hqr;
        private final b hqs;
        boolean hqt = false;

        final ImageView Bf() {
            return (ImageView) this.hqr.get();
        }

        public j(ImageView imageView, b bVar) {
            this.hqr = new WeakReference(imageView);
            this.hqs = bVar;
            this.arH = "ImageView#" + imageView.hashCode();
        }

        private void Bg() {
            if (this.hqr.get() != null) {
                this.hqs.hqe.remove(Integer.valueOf(((ImageView) this.hqr.get()).hashCode()));
            }
        }

        public void Ba() {
        }

        public final void h(Bitmap bitmap) {
            Bg();
            ImageView imageView = (ImageView) this.hqr.get();
            if (imageView != null) {
                if (!af.isMainThread()) {
                    w.h("MicroMsg.AppBrandSimpleImageLoader", "onBitmapLoaded invoke in non-main thread!!!", new Object[0]);
                }
                imageView.setImageDrawable(new d(imageView.getResources(), bitmap));
            }
            this.hqt = true;
        }

        public final void Bb() {
            Bg();
        }

        public final String Bc() {
            return this.arH;
        }
    }

    private static final class k implements a {
        final g hqh;
        public final b hqs;
        final String hqu;
        private final f hqv;
        private final i hqw;
        private final e hqx;
        private final String hqy;
        public boolean hqz = true;

        public k(String str, f fVar, b bVar, i iVar, g gVar, e eVar, String str2) {
            this.hqu = str;
            this.hqv = fVar;
            this.hqs = bVar;
            this.hqw = iVar;
            this.hqh = gVar;
            this.hqx = eVar;
            this.hqy = str2;
        }

        public final String Bh() {
            return b.P(this.hqy, Bi());
        }

        public final String Bi() {
            return this.hqu + (this.hqv == null ? "" : ":transformation:" + this.hqv.Bc());
        }

        public final void Bj() {
            try {
                Bitmap Bk = Bk();
                if (Bk != null && !Bk.isRecycled()) {
                    this.hqs.hqf.gU(b.gP(this.hqu));
                    this.hqs.hqf.a(b.gP(this.hqu), this);
                    j(Bk);
                    this.hqs.hqf.gT(b.gP(this.hqu));
                }
            } catch (c e) {
                w.d("MicroMsg.AppBrandSimpleImageLoader.LoadTask", " doIOJobImpl, exp %s", e);
                this.hqs.hqf.gU(b.gP(this.hqu));
                this.hqs.hqf.gV(b.gP(this.hqu));
                j(null);
            } catch (Throwable e2) {
                w.printErrStackTrace("MicroMsg.AppBrandSimpleImageLoader.LoadTask", e2, " doIOJobImpl, io exp ", new Object[0]);
                this.hqs.hqf.gU(b.gP(this.hqu));
                this.hqs.hqf.a(b.gP(this.hqu), this);
                this.hqs.hqf.gT(b.gP(this.hqu));
            }
        }

        public final void Bd() {
            final Bitmap gS = this.hqw.gS(Bi());
            if (gS == null || gS.isRecycled()) {
                d dVar = this.hqs.hqf;
                String gP = b.gP(this.hqu);
                if (bg.mA(gP) ? false : dVar.hqq.containsKey(gP)) {
                    d dVar2 = this.hqs.hqf;
                    String gP2 = b.gP(this.hqu);
                    if (!(bg.mA(gP2) || this == null)) {
                        List list = (List) dVar2.hqp.get(gP2);
                        if (list == null) {
                            list = new LinkedList();
                            dVar2.hqp.put(gP2, list);
                        }
                        list.add(this);
                    }
                    w.d("MicroMsg.AppBrandSimpleImageLoader.LoadTask", "already has job processing, make this job pending, key %s", b.gP(this.hqu));
                    return;
                }
                dVar = this.hqs.hqf;
                String gP3 = b.gP(this.hqu);
                if (!bg.mA(gP3)) {
                    dVar.hqq.put(gP3, Boolean.valueOf(true));
                }
                Bj();
                return;
            }
            w.d("MicroMsg.AppBrandSimpleImageLoader.LoadTask", "before actually doIOJob, same keyForMemory bitmap already exists, key %s", Bi());
            af.v(new Runnable(this) {
                final /* synthetic */ k hqB;

                public final void run() {
                    this.hqB.h(gS);
                }
            });
        }

        public final void Be() {
            h hVar = (h) this.hqs.hqd.remove(Bh());
            if (hVar != null) {
                this.hqs.hqc.remove(hVar);
            }
        }

        public final void h(Bitmap bitmap) {
            h hVar = (h) this.hqs.hqd.remove(Bh());
            if (hVar != null) {
                hVar.h(bitmap);
                this.hqs.hqc.remove(hVar);
            }
        }

        private void j(Bitmap bitmap) {
            boolean z = false;
            String str = "MicroMsg.AppBrandSimpleImageLoader.LoadTask";
            String str2 = "postLoadInWorkerThread bitmap ok %b";
            Object[] objArr = new Object[1];
            boolean z2 = (bitmap == null || bitmap.isRecycled()) ? false : true;
            objArr[0] = Boolean.valueOf(z2);
            w.d(str, str2, objArr);
            if (!(this.hqv == null || bitmap == null || bitmap.isRecycled())) {
                Bitmap i = this.hqv.i(bitmap);
                w.d("MicroMsg.AppBrandSimpleImageLoader.LoadTask", "postLoadInWorkerThread, transform bmp, origin %s, transformed %s", bitmap, i);
                if (i != bitmap) {
                    this.hqw.e(bitmap);
                }
                bitmap = i;
            }
            this.hqw.b(Bi(), bitmap);
            String str3 = "MicroMsg.AppBrandSimpleImageLoader.LoadTask";
            str = "postLoadInWorkerThread before post to main thread, bitmap %s, ok %b";
            Object[] objArr2 = new Object[2];
            objArr2[0] = bitmap;
            if (!(bitmap == null || bitmap.isRecycled())) {
                z = true;
            }
            objArr2[1] = Boolean.valueOf(z);
            w.d(str3, str, objArr2);
            af.v(new Runnable(this) {
                final /* synthetic */ k hqB;

                public final void run() {
                    k kVar = this.hqB;
                    Bitmap bitmap = bitmap;
                    if (bitmap == null || bitmap.isRecycled()) {
                        w.d("MicroMsg.AppBrandSimpleImageLoader.LoadTask", "postLoadInMainThread, onLoadFailed bmp %s", bitmap);
                        h hVar = (h) kVar.hqs.hqd.remove(kVar.Bh());
                        if (hVar != null) {
                            hVar.Bb();
                            kVar.hqs.hqc.remove(hVar);
                            return;
                        }
                        return;
                    }
                    w.d("MicroMsg.AppBrandSimpleImageLoader.LoadTask", "postLoadInMainThread, onBitmapLoaded bmp %s", bitmap);
                    kVar.h(bitmap);
                }
            });
        }

        private Bitmap Bk() {
            Bitmap bitmap = null;
            if (b.AZ()) {
                InputStream openRead;
                if (this.hqu == null || !this.hqu.startsWith("file://")) {
                    openRead = this.hqh.openRead(b.gP(this.hqu));
                    if (openRead == null) {
                        w.d("MicroMsg.AppBrandSimpleImageLoader.LoadTask", "loadFromDiskOrTriggerDownload, null from disk, tryDownload %b", Boolean.valueOf(this.hqz));
                        if (this.hqz) {
                            com.tencent.mm.sdk.f.e.post(new Runnable(this) {
                                final /* synthetic */ k hqB;

                                {
                                    this.hqB = r1;
                                }

                                public final void run() {
                                    Throwable e;
                                    Closeable closeable = null;
                                    k kVar = this.hqB;
                                    Closeable gQ;
                                    try {
                                        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(kVar.hqu).openConnection();
                                        gQ = kVar.hqh.gQ(b.gP(kVar.hqu));
                                        if (gQ == null) {
                                            bg.g(gQ);
                                            bg.g(null);
                                        } else {
                                            try {
                                                Closeable bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                                                try {
                                                    byte[] bArr = new byte[16384];
                                                    while (true) {
                                                        int read = bufferedInputStream.read(bArr, 0, 16384);
                                                        if (read == -1) {
                                                            break;
                                                        }
                                                        gQ.write(bArr, 0, read);
                                                    }
                                                    gQ.flush();
                                                    bg.g(gQ);
                                                    bg.g(bufferedInputStream);
                                                } catch (Exception e2) {
                                                    e = e2;
                                                    closeable = bufferedInputStream;
                                                    try {
                                                        w.printErrStackTrace("MicroMsg.AppBrandSimpleImageLoader.LoadTask", e, "download image url %s ", kVar.hqu);
                                                        kVar.hqh.gR(b.gP(kVar.hqu));
                                                        bg.g(gQ);
                                                        bg.g(closeable);
                                                        this.hqB.hqs.hqf.f(new Runnable(this) {
                                                            final /* synthetic */ AnonymousClass4 hqD;

                                                            {
                                                                this.hqD = r1;
                                                            }

                                                            public final void run() {
                                                                this.hqD.hqB.hqz = false;
                                                                this.hqD.hqB.Bj();
                                                            }
                                                        });
                                                    } catch (Throwable th) {
                                                        e = th;
                                                        bg.g(gQ);
                                                        bg.g(closeable);
                                                        throw e;
                                                    }
                                                } catch (Throwable th2) {
                                                    e = th2;
                                                    closeable = bufferedInputStream;
                                                    bg.g(gQ);
                                                    bg.g(closeable);
                                                    throw e;
                                                }
                                            } catch (Exception e3) {
                                                e = e3;
                                                w.printErrStackTrace("MicroMsg.AppBrandSimpleImageLoader.LoadTask", e, "download image url %s ", kVar.hqu);
                                                kVar.hqh.gR(b.gP(kVar.hqu));
                                                bg.g(gQ);
                                                bg.g(closeable);
                                                this.hqB.hqs.hqf.f(/* anonymous class already generated */);
                                            }
                                        }
                                    } catch (Exception e4) {
                                        e = e4;
                                        gQ = null;
                                        w.printErrStackTrace("MicroMsg.AppBrandSimpleImageLoader.LoadTask", e, "download image url %s ", kVar.hqu);
                                        kVar.hqh.gR(b.gP(kVar.hqu));
                                        bg.g(gQ);
                                        bg.g(closeable);
                                        this.hqB.hqs.hqf.f(/* anonymous class already generated */);
                                    } catch (Throwable th3) {
                                        e = th3;
                                        gQ = null;
                                        bg.g(gQ);
                                        bg.g(closeable);
                                        throw e;
                                    }
                                    this.hqB.hqs.hqf.f(/* anonymous class already generated */);
                                }
                            }, "AppBrandSimpleImageLoaderDownloadThread");
                        } else {
                            this.hqs.hqf.gV(b.gP(this.hqu));
                            this.hqs.hqf.gU(b.gP(this.hqu));
                        }
                    }
                } else {
                    try {
                        openRead = new FileInputStream(this.hqu.replaceFirst("file://", ""));
                    } catch (Throwable e) {
                        w.printErrStackTrace("MicroMsg.AppBrandSimpleImageLoader.LoadTask", e, "load from local file ", new Object[0]);
                    }
                }
                if (openRead != null) {
                    try {
                        bitmap = f(openRead);
                    } catch (Throwable e2) {
                        w.printErrStackTrace("MicroMsg.AppBrandSimpleImageLoader.LoadTask", e2, " decode ", new Object[0]);
                    }
                    if (bitmap == null || bitmap.isRecycled()) {
                        w.d("MicroMsg.AppBrandSimpleImageLoader.LoadTask", "loadFromDiskOrTriggerDownload, decode failed, bmp %s", bitmap);
                        throw new a();
                    }
                    w.d("MicroMsg.AppBrandSimpleImageLoader.LoadTask", "loadFromDiskOrTriggerDownload, decoded bmp %s, size %d KB, url %s", bitmap, Integer.valueOf(android.support.v4.b.a.b(bitmap) / WXMediaMessage.DESCRIPTION_LENGTH_LIMIT), this.hqu);
                }
                return bitmap;
            }
            w.d("MicroMsg.AppBrandSimpleImageLoader.LoadTask", "loadFromDiskOrTriggerDownload, sdcard unavailable");
            throw new b();
        }

        private Bitmap f(InputStream inputStream) {
            try {
                Bitmap e;
                if (this.hqx != null) {
                    e = this.hqx.e(inputStream);
                } else {
                    e = com.tencent.mm.sdk.platformtools.d.decodeStream(inputStream);
                    bg.g((Closeable) inputStream);
                }
                return e;
            } finally {
                bg.g((Closeable) inputStream);
            }
        }
    }

    public static b AY() {
        return l.hqE;
    }

    public static boolean AZ() {
        return com.tencent.mm.compatible.util.f.rZ();
    }

    public final Bitmap gM(String str) {
        Bitmap gS = this.hqg.gS(str);
        if (gS == null || gS.isRecycled()) {
            return null;
        }
        return gS;
    }

    public final Bitmap gN(String str) {
        Closeable fileInputStream;
        Throwable e;
        Throwable th;
        if (bg.mA(str)) {
            return null;
        }
        Bitmap gS = this.hqg.gS(str);
        if (gS != null) {
            return gS;
        }
        try {
            if (str.startsWith("file://")) {
                try {
                    fileInputStream = new FileInputStream(str.replaceFirst("file://", ""));
                } catch (FileNotFoundException e2) {
                    w.e("MicroMsg.AppBrandSimpleImageLoader", "findCachedLocal: load from local file, file not found ");
                    bg.g(null);
                    return null;
                }
            }
            fileInputStream = this.hqh.openRead(gP(str));
            try {
                gS = com.tencent.mm.sdk.platformtools.d.decodeStream(fileInputStream);
                if (gS != null) {
                    this.hqg.b(str, gS);
                }
                bg.g(fileInputStream);
                return gS;
            } catch (Exception e3) {
                e = e3;
                try {
                    w.printErrStackTrace("MicroMsg.AppBrandSimpleImageLoader", e, "findCachedLocal", new Object[0]);
                    bg.g(fileInputStream);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    bg.g(fileInputStream);
                    throw th;
                }
            }
        } catch (Exception e4) {
            e = e4;
            fileInputStream = null;
            w.printErrStackTrace("MicroMsg.AppBrandSimpleImageLoader", e, "findCachedLocal", new Object[0]);
            bg.g(fileInputStream);
            return null;
        } catch (Throwable e5) {
            fileInputStream = null;
            th = e5;
            bg.g(fileInputStream);
            throw th;
        }
    }

    public final String gO(String str) {
        if (bg.mA(str)) {
            return null;
        }
        return a(new b(), str, null);
    }

    public final String a(h hVar, String str, f fVar, e eVar) {
        if (hVar == null) {
            return null;
        }
        if (bg.mA(str)) {
            hVar.Bb();
            return null;
        }
        w.d("MicroMsg.AppBrandSimpleImageLoader", "load before start LoadTask url %s", str);
        k kVar = new k(str, fVar, this, this.hqg, this.hqh, eVar, hVar.Bc());
        String Bi = kVar.Bi();
        Bitmap gM = gM(Bi);
        if (gM != null) {
            hVar.h(gM);
            w.d("MicroMsg.AppBrandSimpleImageLoader", "load already cached, url %s, bitmap %s", str, gM);
            return Bi;
        }
        String Bh = kVar.Bh();
        this.hqc.put(hVar, Bh);
        this.hqd.put(Bh, hVar);
        hVar.Ba();
        kVar.hqs.hqf.f(new Runnable(kVar) {
            final /* synthetic */ k hqB;

            {
                this.hqB = r1;
            }

            public final void run() {
                this.hqB.Bd();
            }
        });
        return Bi;
    }

    public final String a(h hVar, String str, f fVar) {
        return a(hVar, str, fVar, null);
    }

    public final String a(ImageView imageView, String str, Drawable drawable, f fVar) {
        return a(imageView, str, drawable, fVar, null);
    }

    public final String a(ImageView imageView, String str, final Drawable drawable, f fVar, e eVar) {
        if (imageView == null) {
            return null;
        }
        String str2;
        if (imageView != null) {
            str2 = (String) this.hqe.get(Integer.valueOf(imageView.hashCode()));
            if (str2 != null) {
                h hVar = (h) this.hqd.get(str2);
                if (hVar != null) {
                    str2 = (String) this.hqc.get(hVar);
                    if (!bg.mA(str2)) {
                        this.hqd.remove(str2);
                    }
                }
            }
        }
        if (bg.mA(str)) {
            if (drawable != null) {
                imageView.setImageDrawable(drawable);
            }
            return null;
        }
        h anonymousClass1 = new j(this, imageView, this) {
            final /* synthetic */ b hqk;

            public final void Ba() {
                if (Bf() != null && drawable != null) {
                    Bf().setImageDrawable(drawable);
                }
            }
        };
        str2 = a(anonymousClass1, str, fVar, eVar);
        if (anonymousClass1.hqt) {
            return str2;
        }
        this.hqe.put(Integer.valueOf(imageView.hashCode()), P(anonymousClass1.arH, str2));
        return str2;
    }

    public static String P(String str, String str2) {
        return str + str2;
    }

    static {
        String str = com.tencent.mm.compatible.util.e.hgu;
        if (!str.endsWith("/")) {
            str = str + "/";
        }
        str = str + "wxacache/";
        hqi = str;
        com.tencent.mm.sdk.platformtools.h.KS(str);
    }

    public static String gP(String str) {
        if (bg.mA(str)) {
            return null;
        }
        return com.tencent.mm.a.g.n(str.getBytes());
    }
}
