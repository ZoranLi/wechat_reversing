package com.tencent.mm.ah.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.widget.ImageView;
import com.tencent.mm.ah.a.a.b;
import com.tencent.mm.ah.a.a.c;
import com.tencent.mm.ah.a.b.g;
import com.tencent.mm.ah.a.c.d;
import com.tencent.mm.ah.a.c.e;
import com.tencent.mm.ah.a.c.i;
import com.tencent.mm.ah.a.c.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.concurrent.ExecutorService;

public final class a {
    private static a hIf = null;
    public b hIc;
    private b hId;
    private final i hIe = new g();

    public static synchronized a Hd() {
        a aVar;
        synchronized (a.class) {
            if (hIf == null) {
                hIf = new a(ab.getContext());
            }
            aVar = hIf;
        }
        return aVar;
    }

    public a(Context context) {
        a(b.aX(context));
    }

    public a(b bVar) {
        a(bVar);
    }

    private synchronized void a(b bVar) {
        if (bVar == null) {
            throw new IllegalArgumentException("[cpan] image loader configuration is null.");
        } else if (this.hId == null) {
            this.hIc = new b(bVar);
            this.hId = bVar;
        } else {
            w.w("MicroMsg.imageloader.ImageLoader", "[cpan] image loader had init.");
        }
    }

    public final void a(String str, ImageView imageView) {
        a(str, imageView, null, null, null, null, null, null);
    }

    public final void a(String str, ImageView imageView, com.tencent.mm.ah.a.c.g gVar) {
        a(str, imageView, null, null, null, gVar, null, null);
    }

    public final void a(String str, ImageView imageView, c cVar, com.tencent.mm.ah.a.c.g gVar) {
        a(str, imageView, cVar, null, null, gVar, null, null);
    }

    public final void b(String str, ImageView imageView, c cVar, com.tencent.mm.ah.a.c.g gVar) {
        a(str, imageView, cVar, null, null, gVar, null, null);
    }

    public final void a(String str, ImageView imageView, c cVar) {
        a(str, imageView, cVar, null, null, null, null, null);
    }

    public final void a(String str, ImageView imageView, c cVar, e eVar, d dVar) {
        a(str, imageView, cVar, null, null, null, eVar, dVar);
    }

    public final void a(String str, ImageView imageView, c cVar, i iVar) {
        a(str, imageView, cVar, iVar, null, null, null, null);
    }

    public final void a(String str, ImageView imageView, c cVar, i iVar, j jVar, com.tencent.mm.ah.a.c.g gVar, e eVar, d dVar) {
        c cVar2;
        i iVar2;
        if (cVar == null) {
            cVar2 = this.hId.hIy;
        } else {
            cVar2 = cVar;
        }
        if (iVar == null) {
            iVar2 = this.hIe;
        } else {
            iVar2 = iVar;
        }
        c cVar3 = new c(imageView, str);
        if (bg.mA(str)) {
            w.w("MicroMsg.imageloader.ImageLoader", "[cpan load image url is null.]");
            a(imageView, cVar2);
            this.hIc.a(cVar3);
            iVar2.a(str, null, cVar2.hJm);
            return;
        }
        ae aeVar = cVar2.handler;
        if (aeVar == null || Looper.myLooper() == Looper.getMainLooper()) {
            aeVar = new ae();
        }
        Runnable bVar = new com.tencent.mm.ah.a.f.b(str, cVar3, aeVar, cVar2, iVar2, jVar, this.hIc, gVar, eVar, dVar);
        Bitmap jH = this.hIc.jH(bVar.jL(str));
        if (imageView == null || jH == null || jH.isRecycled()) {
            if (imageView != null) {
                a(imageView, cVar2);
            }
            if (bVar.hIy.hIM || !this.hIc.hIh.oV()) {
                Object obj;
                b bVar2;
                com.tencent.mm.ah.a.f.b bVar3;
                boolean z;
                b bVar4 = this.hIc;
                if (!bg.mA(str)) {
                    String str2 = (String) bVar4.hIj.get(Integer.valueOf(cVar3.He()));
                    if (bg.mA(str2) || !str.equals(str2)) {
                        bVar4.hIj.put(Integer.valueOf(cVar3.He()), str);
                        obj = 1;
                        if (obj != null) {
                            bVar2 = this.hIc;
                            if (!(bVar2.hIk == null || bVar.hJt == null)) {
                                bVar3 = (com.tencent.mm.ah.a.f.b) bVar2.hIk.get(Integer.valueOf(bVar.hJt.He()));
                                if (!(bVar3 == null || bVar3.hJt == null || bVar.hJt.He() != bVar3.hJt.He())) {
                                    bVar2.hIh.remove(bVar3);
                                    w.d("MicroMsg.imageloader.ImageLoaderManager", "remove taks url:%s", bVar3.url);
                                }
                                bVar2.hIk.put(Integer.valueOf(bVar.hJt.He()), bVar);
                            }
                            bVar2 = this.hIc;
                            z = cVar2.hIK;
                            if (((ExecutorService) bVar2.hIg.hIG).isShutdown()) {
                                bVar2.hIh = com.tencent.mm.ah.a.a.a.aN(bVar2.hIg.hIw, bVar2.hIg.hIx);
                            }
                            bVar2.hIh.execute(bVar);
                            if (z && com.tencent.mm.ah.a.g.b.Hj()) {
                                bVar2.hIi.execute(new com.tencent.mm.ah.a.f.d());
                                return;
                            }
                            return;
                        }
                        return;
                    }
                }
                obj = null;
                if (obj != null) {
                    bVar2 = this.hIc;
                    bVar3 = (com.tencent.mm.ah.a.f.b) bVar2.hIk.get(Integer.valueOf(bVar.hJt.He()));
                    bVar2.hIh.remove(bVar3);
                    w.d("MicroMsg.imageloader.ImageLoaderManager", "remove taks url:%s", bVar3.url);
                    bVar2.hIk.put(Integer.valueOf(bVar.hJt.He()), bVar);
                    bVar2 = this.hIc;
                    z = cVar2.hIK;
                    if (((ExecutorService) bVar2.hIg.hIG).isShutdown()) {
                        bVar2.hIh = com.tencent.mm.ah.a.a.a.aN(bVar2.hIg.hIw, bVar2.hIg.hIx);
                    }
                    bVar2.hIh.execute(bVar);
                    if (z) {
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        w.d("MicroMsg.imageloader.ImageLoader", "[cpan] load from cache. not need to load:%s", r5);
        if (cVar2.hIV) {
            jH = com.tencent.mm.sdk.platformtools.d.c(jH, cVar2.hIW);
        }
        imageView.setImageBitmap(jH);
        bVar.ao(0);
        if (gVar != null) {
            gVar.a(str, imageView, new com.tencent.mm.ah.a.d.b(jH));
        }
        this.hIc.a(cVar3);
    }

    public final void bi(int i) {
        w.d("MicroMsg.imageloader.ImageLoader", "[cpan] on scroll state changed :%d", Integer.valueOf(i));
        if (i == 0 || i == 1) {
            w.d("MicroMsg.imageloader.ImageLoader", "[cpan] resume");
            this.hIc.hIh.resume();
            return;
        }
        w.d("MicroMsg.imageloader.ImageLoader", "[cpan] pause");
        this.hIc.hIh.pause();
    }

    public final void detach() {
        if (this.hIc != null) {
            b bVar = this.hIc;
            if (bVar.hIg != null) {
                bVar.hIg.hIz.clear();
                bVar.hIg.hIA.Hh();
            }
        }
    }

    public final Bitmap jH(String str) {
        if (this.hIc != null) {
            return this.hIc.jH(str);
        }
        return null;
    }

    public final void h(String str, Bitmap bitmap) {
        if (this.hIc != null) {
            b bVar = this.hIc;
            if (bVar.hIg != null) {
                bVar.hIg.hIz.b(str, bitmap);
            }
        }
    }

    private void a(ImageView imageView, c cVar) {
        if (imageView == null || cVar == null) {
            w.w("MicroMsg.imageloader.ImageLoader", "[cpan] should show default image view or options is null.");
            return;
        }
        Object obj = (cVar.hJe > 0 || cVar.hJf != null) ? 1 : null;
        if (obj == null) {
            imageView.setBackgroundDrawable(null);
        } else if (cVar.hJe == 0) {
            imageView.setBackgroundDrawable(cVar.hJe != 0 ? this.hId.hIv.getDrawable(cVar.hJe) : cVar.hJf);
        } else {
            imageView.setBackgroundResource(cVar.hJe);
        }
        if (cVar.hJa > 0 || cVar.hJb != null) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            if (cVar.hJa == 0) {
                Drawable drawable;
                Resources resources = this.hId.hIv;
                if (cVar.hJa != 0) {
                    drawable = resources.getDrawable(cVar.hJa);
                } else {
                    drawable = cVar.hJb;
                }
                imageView.setImageDrawable(drawable);
                return;
            }
            imageView.setImageResource(cVar.hJa);
        } else if (cVar.hJh) {
            imageView.setImageDrawable(null);
        }
    }

    public final void a(String str, c cVar, com.tencent.mm.ah.a.c.c cVar2) {
        this.hIc.hIh.execute(new com.tencent.mm.ah.a.f.a(str, cVar, this.hIc, cVar2));
    }
}
