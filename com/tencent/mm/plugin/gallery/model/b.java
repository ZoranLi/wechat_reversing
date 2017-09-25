package com.tencent.mm.plugin.gallery.model;

import android.graphics.Bitmap;
import com.tencent.mm.a.f;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.File;
import java.util.Vector;

public final class b {
    k<b, String> hrc = new k<b, String>(this) {
        final /* synthetic */ b mee;

        {
            this.mee = r1;
        }

        protected final /* synthetic */ void o(Object obj, Object obj2) {
            ((b) obj).xl((String) obj2);
        }
    };
    public Vector<b> hrd = new Vector();
    f<String, a> meb = new f(100, new com.tencent.mm.a.f.b<String, a>(this) {
        final /* synthetic */ b mee;

        {
            this.mee = r1;
        }

        public final /* synthetic */ void l(Object obj, Object obj2) {
            String str = (String) obj;
            a aVar = (a) obj2;
            if (aVar == null) {
                w.d("MicroMsg.GalleryCache", "weakReference is null");
            } else if (aVar.bitmap == null) {
                w.d("MicroMsg.GalleryCache", "weakReference getbitmap is null");
            } else {
                aVar.bitmap.recycle();
                w.d("MicroMsg.GalleryCache", "gallery remove ", new Object[]{str});
            }
        }
    });
    d mec;
    private final b med = new b(this) {
        final /* synthetic */ b mee;

        {
            this.mee = r1;
        }

        public final void xl(String str) {
            w.i("MicroMsg.GalleryCache", "now listener size : " + this.mee.hrd.size());
            for (int size = this.mee.hrd.size() - 1; size >= 0; size--) {
                b bVar;
                try {
                    bVar = (b) this.mee.hrd.get(size);
                } catch (Exception e) {
                    w.e("MicroMsg.GalleryCache", "get wathcer failed:[%s]", new Object[]{e.toString()});
                    bVar = null;
                }
                if (bVar == null) {
                    w.d("MicroMsg.GalleryCache", "get listener is null");
                } else {
                    bVar.xl(str);
                }
            }
        }
    };

    private class a {
        Bitmap bitmap;
        final /* synthetic */ b mee;
        private int type;

        public a(b bVar, Bitmap bitmap, int i) {
            this.mee = bVar;
            this.bitmap = bitmap;
            this.type = i;
        }
    }

    public interface b {
        void xl(String str);
    }

    public b() {
        d dVar = new d(new File(e.hgu + "/diskcache"));
        dVar.mev = ab.getContext().getSharedPreferences(ab.bIX(), 0).getInt("com.tencent.mm.gallery.cache.suffix", 0);
        dVar.ays();
        dVar.mX(-1);
        this.mec = dVar;
        this.hrc.a(this.med, null);
    }

    public final Bitmap getBitmap(String str) {
        if (bg.mA(str)) {
            w.e("MicroMsg.GalleryCache", "null filepath");
            return null;
        } else if (this.meb == null) {
            w.w("MicroMsg.GalleryCache", "want to get bitmap, but gallery cache is null");
            return null;
        } else {
            if (this.meb.aV(str)) {
                a aVar = (a) this.meb.get(str);
                if (aVar == null) {
                    w.d("MicroMsg.GalleryCache", "weakreference is null");
                    this.meb.remove(str);
                    return null;
                }
                Bitmap bitmap = aVar.bitmap;
                if (bitmap == null) {
                    this.meb.remove(str);
                    w.i("MicroMsg.GalleryCache", "get bitmap is null");
                } else if (bitmap.isRecycled()) {
                    w.i("MicroMsg.GalleryCache", "cahce bitmap has recycled");
                    this.meb.remove(str);
                    return null;
                } else {
                    w.i("MicroMsg.GalleryCache", "get cached bitmap:" + str);
                    return bitmap;
                }
            }
            return null;
        }
    }
}
