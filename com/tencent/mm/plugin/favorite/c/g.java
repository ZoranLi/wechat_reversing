package com.tencent.mm.plugin.favorite.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import android.os.SystemClock;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.a.f;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.plugin.favorite.b.j;
import com.tencent.mm.plugin.favorite.b.x;
import com.tencent.mm.pluginsdk.model.c;
import com.tencent.mm.protocal.c.rm;
import com.tencent.mm.protocal.c.ru;
import com.tencent.mm.protocal.c.rz;
import com.tencent.mm.protocal.c.sf;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.u.ap;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public final class g {
    private static Map<String, a> lGl = new HashMap();
    private static f<String, Bitmap> lGm = new f(10);
    private static y<String, Bitmap> lGn = new y(20);
    public Context context;
    public e lGi;
    public HashMap<String, String[]> lGj = new HashMap();
    private HashMap<String, String[]> lGk = new HashMap();

    class AnonymousClass2 implements Runnable {
        final /* synthetic */ String iaC;
        final /* synthetic */ j lEr;
        final /* synthetic */ rm lEs;
        final /* synthetic */ g lGo;

        public AnonymousClass2(g gVar, String str, j jVar, rm rmVar) {
            this.lGo = gVar;
            this.iaC = str;
            this.lEr = jVar;
            this.lEs = rmVar;
        }

        public final void run() {
            if (g.wh(this.iaC)) {
                x.a(this.lEr, this.lEs, false);
            }
        }

        public final String toString() {
            return super.toString() + "|attachImg";
        }
    }

    static class AnonymousClass3 implements Runnable {
        final /* synthetic */ String iaC;
        final /* synthetic */ j lEr;
        final /* synthetic */ rm lEs;
        final /* synthetic */ boolean lGp = false;

        AnonymousClass3(boolean z, String str, j jVar, rm rmVar) {
            this.iaC = str;
            this.lEr = jVar;
            this.lEs = rmVar;
        }

        public final void run() {
            if (this.lGp || g.wh(this.iaC)) {
                x.a(this.lEr, this.lEs, this.lGp);
            }
        }

        public final String toString() {
            return super.toString() + "|getBigImg";
        }
    }

    public static boolean wh(String str) {
        if (new File(str).exists()) {
            return false;
        }
        a aVar = (a) lGl.get(str);
        if (aVar == null) {
            lGl.put(str, new a());
            return true;
        } else if (aVar.se() <= 30000) {
            return false;
        } else {
            w.v("MicroMsg.FavoriteImageLogic", "error diff time");
            aVar.gSO = SystemClock.elapsedRealtime();
            return true;
        }
    }

    public g(Context context, int i) {
        this.context = context;
        if (i <= 0) {
            i = 24;
        }
        this.lGi = new e(i);
    }

    public final void destory() {
        com.tencent.mm.pluginsdk.ui.tools.g gVar = this.lGi;
        synchronized (gVar.hAl) {
            w.d("MicroMsg.ImageEngine", "do clear mark");
            gVar.sVS.clear();
            gVar.sVT.clear();
            gVar.sVS = new HashMap();
            gVar.sVT = new HashMap();
        }
        this.lGj.clear();
        this.lGk.clear();
        this.lGi.destory();
        this.context = null;
        this.lGj = null;
        this.lGk = null;
        this.lGi = null;
    }

    public final void a(ImageView imageView, final rm rmVar, final j jVar, String str, int i, int i2, int i3) {
        String vZ = x.vZ(rmVar.lKv);
        String[] strArr = null;
        if (rmVar.lKv != null) {
            String[] strArr2 = (String[]) this.lGk.get(vZ);
            if (strArr2 == null) {
                strArr = new String[]{x.h(rmVar)};
                this.lGk.put(vZ, strArr);
            } else {
                strArr = strArr2;
            }
        }
        this.lGi.a(imageView, strArr, str, i, i2, i3);
        if (strArr != null && strArr.length > 0) {
            final String str2 = strArr[0];
            ap.vL().D(new Runnable(this) {
                final /* synthetic */ g lGo;

                public final void run() {
                    if (g.wh(str2)) {
                        x.b(jVar, rmVar, true);
                    }
                }

                public final String toString() {
                    return super.toString() + "|mAttachThumb";
                }
            });
        }
    }

    public final void a(ImageView imageView, rm rmVar, j jVar, int i, int i2, int i3) {
        String str = null;
        if (imageView != null) {
            if (!com.tencent.mm.compatible.util.f.rZ()) {
                imageView.setImageResource(R.g.bhP);
            } else if (jVar != null) {
                ru ruVar;
                switch (jVar.field_type) {
                    case 4:
                    case 16:
                        if (rmVar != null) {
                            a(imageView, rmVar, jVar, rmVar.fFs, i, i2, i3);
                            return;
                        }
                        return;
                    case 5:
                        sf sfVar = jVar.field_favProto.tyy;
                        if (rmVar != null) {
                            String str2;
                            if (sfVar != null) {
                                str = sfVar.thumbUrl;
                            }
                            if (bg.mA(str)) {
                                str2 = rmVar.fFs;
                            } else {
                                str2 = str;
                            }
                            a(imageView, rmVar, jVar, str2, i, i2, i3);
                            return;
                        } else if (sfVar != null) {
                            this.lGi.a(imageView, null, sfVar.thumbUrl, i, i2, i3);
                            return;
                        } else {
                            return;
                        }
                    case 7:
                        if (rmVar != null) {
                            a(imageView, rmVar, jVar, rmVar.fFs, i, i2, i3);
                            return;
                        }
                        return;
                    case 10:
                        ruVar = jVar.field_favProto.tyA;
                        if (ruVar != null) {
                            this.lGi.a(imageView, null, ruVar.thumbUrl, i, i2, i3);
                            return;
                        }
                        return;
                    case 11:
                        ruVar = jVar.field_favProto.tyA;
                        if (ruVar != null) {
                            this.lGi.a(imageView, null, ruVar.thumbUrl, i, i2, i3);
                            return;
                        }
                        return;
                    case 15:
                        rz rzVar = jVar.field_favProto.tyC;
                        if (rzVar != null) {
                            this.lGi.a(imageView, null, rzVar.thumbUrl, i, i2, i3);
                            return;
                        }
                        return;
                    default:
                        w.w("MicroMsg.FavoriteImageLogic", "attach thumb, pass type is %d", new Object[]{Integer.valueOf(jVar.field_type)});
                        return;
                }
            }
        }
    }

    public final void b(ImageView imageView, rm rmVar, j jVar, int i, int i2, int i3) {
        String str = null;
        if (imageView != null) {
            if (!com.tencent.mm.compatible.util.f.rZ()) {
                imageView.setImageResource(R.g.bhP);
            } else if (jVar == null || rmVar == null) {
                imageView.setImageDrawable(com.tencent.mm.bg.a.a(this.context, i));
            } else {
                ru ruVar;
                switch (rmVar.aMw) {
                    case 4:
                    case 15:
                        a(imageView, rmVar, jVar, rmVar.fFs, i, i2, i3);
                        return;
                    case 5:
                        sf sfVar;
                        String str2;
                        if (rmVar.tyc != null) {
                            sfVar = rmVar.tyc.tyy;
                        } else {
                            w.w("MicroMsg.FavoriteImageLogic", "webpage: get data proto item null, dataid[%s], infoid[%d, %d]", new Object[]{rmVar.lKv, Long.valueOf(jVar.field_localId), Integer.valueOf(jVar.field_id)});
                            sfVar = null;
                        }
                        if (sfVar != null) {
                            str = sfVar.thumbUrl;
                        }
                        if (bg.mA(str)) {
                            str2 = rmVar.fFs;
                        } else {
                            str2 = str;
                        }
                        a(imageView, rmVar, jVar, str2, i, i2, i3);
                        return;
                    case 7:
                        a(imageView, rmVar, jVar, rmVar.fFs, i, i2, i3);
                        return;
                    case 10:
                        if (rmVar.tyc == null) {
                            w.w("MicroMsg.FavoriteImageLogic", "good: get data proto item null, dataid[%s], infoid[%d, %d]", new Object[]{rmVar.lKv, Long.valueOf(jVar.field_localId), Integer.valueOf(jVar.field_id)});
                            return;
                        }
                        ruVar = rmVar.tyc.tyA;
                        if (ruVar != null) {
                            this.lGi.a(imageView, null, ruVar.thumbUrl, i, i2, i3);
                            return;
                        }
                        return;
                    case 11:
                        if (rmVar.tyc == null) {
                            w.w("MicroMsg.FavoriteImageLogic", "product: get data proto item null, dataid[%s], infoid[%d, %d]", new Object[]{rmVar.lKv, Long.valueOf(jVar.field_localId), Integer.valueOf(jVar.field_id)});
                            return;
                        }
                        ruVar = rmVar.tyc.tyA;
                        if (ruVar != null) {
                            this.lGi.a(imageView, null, ruVar.thumbUrl, i, i2, i3);
                            return;
                        }
                        return;
                    case 14:
                        if (rmVar.tyc == null) {
                            w.w("MicroMsg.FavoriteImageLogic", "tv: get data proto item null, dataid[%s], infoid[%d, %d]", new Object[]{rmVar.lKv, Long.valueOf(jVar.field_localId), Integer.valueOf(jVar.field_id)});
                            return;
                        }
                        rz rzVar = rmVar.tyc.tyC;
                        if (rzVar != null) {
                            this.lGi.a(imageView, null, rzVar.thumbUrl, i, i2, i3);
                            return;
                        }
                        return;
                    default:
                        w.w("MicroMsg.FavoriteImageLogic", "attach thumb, pass type is %d", new Object[]{Integer.valueOf(jVar.field_type)});
                        return;
                }
            }
        }
    }

    private static Bitmap a(rm rmVar, boolean z, boolean z2) {
        String h;
        if (z) {
            h = x.h(rmVar);
        } else {
            h = x.g(rmVar);
        }
        if (e.aO(h)) {
            return c.aI(h, z2);
        }
        w.w("MicroMsg.FavoriteImageLogic", "getBitmap file not exist");
        return null;
    }

    public static Bitmap b(rm rmVar, j jVar, int i) {
        if (!com.tencent.mm.compatible.util.f.rZ()) {
            return BitmapFactory.decodeResource(ab.getContext().getResources(), R.g.bhP);
        }
        if (rmVar.lKv == null) {
            return null;
        }
        Bitmap bitmap;
        String g = x.g(rmVar);
        if (e.aO(g)) {
            bitmap = (Bitmap) lGm.get(g);
            if (bitmap != null) {
                w.d("MicroMsg.FavoriteImageLogic", "get bm from cache %s", new Object[]{g});
            } else {
                w.d("MicroMsg.FavoriteImageLogic", "get from cache fail, try to decode from file");
                Options options = new Options();
                options.inJustDecodeBounds = true;
                bitmap = BitmapFactory.decodeFile(g, options);
                if (bitmap != null) {
                    w.i("MicroMsg.FavoriteImageLogic", "bitmap recycle %s", new Object[]{bitmap});
                    bitmap.recycle();
                }
                int i2 = options.outWidth;
                int i3 = options.outHeight;
                w.d("MicroMsg.FavoriteImageLogic", "width: %s, height: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
                if (i2 > i) {
                    i3 = (options.outHeight * i) / options.outWidth;
                } else {
                    i = i2;
                }
                i2 = Math.max(1, i);
                i3 = Math.max(1, i3);
                w.w("MicroMsg.FavoriteImageLogic", "fit long picture, beg %d*%d, after %d*%d", new Object[]{Integer.valueOf(options.outWidth), Integer.valueOf(options.outHeight), Integer.valueOf(i2), Integer.valueOf(i3)});
                int Pc = ExifHelper.Pc(g);
                if (Pc == 90 || Pc == 270) {
                    int i4 = i2;
                    i2 = i3;
                    i3 = i4;
                }
                bitmap = d.d(g, i3, i2, false);
                if (bitmap == null) {
                    w.e("MicroMsg.FavoriteImageLogic", "getSuitableBmp fail, temBmp is null, filePath = " + g);
                    bitmap = null;
                } else {
                    bitmap = d.b(bitmap, (float) Pc);
                    lGm.put(g, bitmap);
                }
            }
        } else {
            w.w("MicroMsg.FavoriteImageLogic", "getBitmap file not exist");
            bitmap = null;
        }
        if (bitmap != null) {
            return bitmap;
        }
        ap.vL().D(new AnonymousClass3(false, x.g(rmVar), jVar, rmVar));
        return bitmap;
    }

    public static Bitmap j(rm rmVar) {
        if (!com.tencent.mm.compatible.util.f.rZ()) {
            return BitmapFactory.decodeResource(ab.getContext().getResources(), R.g.bhP);
        }
        if (rmVar.lKv == null) {
            return null;
        }
        return a(rmVar, false, true);
    }

    public static Bitmap a(final rm rmVar, final j jVar, final boolean z) {
        if (!com.tencent.mm.compatible.util.f.rZ()) {
            return BitmapFactory.decodeResource(ab.getContext().getResources(), R.g.bhP);
        }
        if (rmVar.lKv == null) {
            return null;
        }
        Bitmap a = a(rmVar, false, false);
        if (a != null) {
            return a;
        }
        final String g = x.g(rmVar);
        ap.vL().D(new Runnable() {
            public final void run() {
                if (z || g.wh(g)) {
                    x.a(jVar, rmVar, z);
                }
            }

            public final String toString() {
                return super.toString() + "|getBigImg";
            }
        });
        return a;
    }

    public static Bitmap a(final rm rmVar, final j jVar) {
        if (!com.tencent.mm.compatible.util.f.rZ()) {
            return BitmapFactory.decodeResource(ab.getContext().getResources(), R.g.bhP);
        }
        if (x.vZ(rmVar.lKv) == null) {
            return null;
        }
        Bitmap a = a(rmVar, true, false);
        if (a != null) {
            return a;
        }
        final String h = x.h(rmVar);
        ap.vL().D(new Runnable() {
            public final void run() {
                if (g.wh(h)) {
                    x.b(jVar, rmVar, true);
                }
            }

            public final String toString() {
                return super.toString() + "|getThumb";
            }
        });
        return a;
    }

    public static Bitmap c(String str, int i, int i2, boolean z) {
        IOException iOException;
        boolean z2 = false;
        if (e.aO(str)) {
            Bitmap bitmap = (Bitmap) lGn.get(str);
            if (bitmap != null || z) {
                String str2 = "MicroMsg.FavoriteImageLogic";
                String str3 = "return bm path %s, bm %s";
                Object[] objArr = new Object[2];
                objArr[0] = str;
                objArr[1] = Boolean.valueOf(bitmap != null);
                w.d(str2, str3, objArr);
                return bitmap;
            }
            try {
                Bitmap decodeFile;
                Options options = new Options();
                options.inJustDecodeBounds = true;
                d.decodeFile(str, options);
                int i3 = options.outWidth;
                int i4 = options.outHeight;
                int Pc = ExifHelper.Pc(str);
                if (Pc == 90 || Pc == 270) {
                    z2 = true;
                    int i5 = i3;
                    i3 = i4;
                    i4 = i5;
                }
                options.inSampleSize = 1;
                while (i4 / options.inSampleSize > i2 && i3 / options.inSampleSize > i) {
                    options.inSampleSize++;
                }
                int i6 = (i3 * i2) / i;
                w.d("MicroMsg.FavoriteImageLogic", "decode top region width: %d, height: %d, scaleheight: %d, rotate: %b", new Object[]{Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i6), Boolean.valueOf(z2)});
                if (i6 <= 0 || i4 <= i6) {
                    options.inJustDecodeBounds = false;
                    decodeFile = d.decodeFile(str, options);
                } else {
                    Rect rect = new Rect();
                    rect.top = 0;
                    rect.left = 0;
                    if (z2) {
                        rect.right = i6;
                        rect.bottom = i3;
                    } else {
                        rect.right = i3;
                        rect.bottom = i6;
                    }
                    BitmapRegionDecoder newInstance = BitmapRegionDecoder.newInstance(str, true);
                    options.inJustDecodeBounds = false;
                    decodeFile = newInstance.decodeRegion(rect, options);
                }
                if (decodeFile == null || !z2) {
                    bitmap = decodeFile;
                } else {
                    try {
                        bitmap = d.b(decodeFile, (float) Pc);
                    } catch (IOException e) {
                        IOException iOException2 = e;
                        bitmap = decodeFile;
                        iOException = iOException2;
                        w.e("MicroMsg.FavoriteImageLogic", iOException.getMessage());
                        return bitmap;
                    }
                }
                if (bitmap != null) {
                    w.d("MicroMsg.FavoriteImageLogic", "width %d, height %d, tw %d, th %d", new Object[]{Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), Integer.valueOf(i), Integer.valueOf(i2)});
                    lGn.put(str, bitmap);
                    return bitmap;
                }
                w.w("MicroMsg.FavoriteImageLogic", "decode bm fail!");
                return bitmap;
            } catch (IOException e2) {
                iOException = e2;
                w.e("MicroMsg.FavoriteImageLogic", iOException.getMessage());
                return bitmap;
            }
        }
        w.w("MicroMsg.FavoriteImageLogic", "file not exist");
        return null;
    }

    public static void a(ImageView imageView, int i, rm rmVar, j jVar, boolean z, int i2, int i3) {
        if (!com.tencent.mm.compatible.util.f.rZ()) {
            imageView.setImageBitmap(BitmapFactory.decodeResource(ab.getContext().getResources(), R.g.bhP));
        }
        if (rmVar.lKv == null) {
            imageView.setImageResource(i);
        }
        Bitmap a = a(rmVar, jVar);
        final String g = x.g(rmVar);
        if (e.aO(g)) {
            a = c(g, i2, i3, true);
        }
        if (a == null) {
            imageView.setImageResource(i);
            imageView.setTag(g);
            final int i4 = i2;
            final int i5 = i3;
            final j jVar2 = jVar;
            final rm rmVar2 = rmVar;
            final boolean z2 = z;
            final ImageView imageView2 = imageView;
            ap.vL().D(new Runnable() {
                public final void run() {
                    final Bitmap c = g.c(g, i4, i5, false);
                    if (c == null) {
                        g.c(jVar2, rmVar2, z2);
                        return;
                    }
                    String str = (String) imageView2.getTag();
                    if (str != null && str.equals(g)) {
                        ap.vL();
                        af.v(new Runnable(this) {
                            final /* synthetic */ AnonymousClass6 lGt;

                            public final void run() {
                                imageView2.setImageBitmap(c);
                            }
                        });
                    }
                }
            });
            return;
        }
        imageView.setImageBitmap(a);
    }

    public static void c(final j jVar, final rm rmVar, final boolean z) {
        final String g = x.g(rmVar);
        ap.vL().D(new Runnable() {
            public final void run() {
                if (z || g.wh(g)) {
                    x.a(jVar, rmVar, z);
                }
            }

            public final String toString() {
                return super.toString() + "|reDownload";
            }
        });
    }

    public static void a(j jVar, rm rmVar) {
        c(jVar, rmVar, true);
    }
}
