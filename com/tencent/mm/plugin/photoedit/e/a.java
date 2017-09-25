package com.tencent.mm.plugin.photoedit.e;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Looper;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mm.ah.n;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.d;
import com.tencent.mm.plugin.photoedit.b.e;
import com.tencent.mm.plugin.photoedit.b.f;
import com.tencent.mm.plugin.photoedit.c.b;
import com.tencent.mm.plugin.photoedit.c.c;
import com.tencent.mm.plugin.photoedit.cache.ArtistCacheManager;
import com.tencent.mm.plugin.photoedit.ui.MMPhotoEditUI;
import com.tencent.mm.plugin.photoedit.view.FeatureFooterView;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.w;
import java.util.Iterator;

public final class a implements b, com.tencent.mm.plugin.photoedit.view.SelectColorBar.a {
    public static a olC;
    public ae igD = new ae(Looper.getMainLooper());
    public View kPJ;
    public Matrix ojv = new Matrix();
    public Rect ojw = new Rect();
    public com.tencent.mm.plugin.photoedit.d.b ojz;
    public SparseArray<com.tencent.mm.plugin.photoedit.b.b> olD = new SparseArray();
    public String olE;
    public int olF;
    public int olG;
    public com.tencent.mm.plugin.photoedit.b.a olH = com.tencent.mm.plugin.photoedit.b.a.ojn;
    com.tencent.mm.plugin.photoedit.b.a olI = com.tencent.mm.plugin.photoedit.b.a.ojn;
    String olJ = "";
    public boolean olK = false;
    public Activity qb;

    class AnonymousClass1 implements Runnable {
        final /* synthetic */ Activity iic;
        final /* synthetic */ a olL;

        public AnonymousClass1(a aVar, Activity activity) {
            this.olL = aVar;
            this.iic = activity;
        }

        public final void run() {
            ArtistCacheManager.aSf();
            Iterator it = ArtistCacheManager.aSh().iterator();
            while (it.hasNext()) {
                this.olL.a(this.iic, (com.tencent.mm.plugin.photoedit.b.a) it.next());
            }
            this.olL.ojz.aSv();
            this.olL.ojz.postInvalidate();
        }
    }

    class AnonymousClass2 implements Runnable {
        final /* synthetic */ a olL;
        final /* synthetic */ String olM;
        final /* synthetic */ String olN;
        final /* synthetic */ boolean olO;
        final /* synthetic */ boolean olP;
        final /* synthetic */ a olQ;

        public AnonymousClass2(a aVar, String str, String str2, boolean z, boolean z2, a aVar2) {
            this.olL = aVar;
            this.olM = str;
            this.olN = str2;
            this.olO = z;
            this.olP = z2;
            this.olQ = aVar2;
        }

        public final void run() {
            try {
                Bitmap aRP;
                a aVar = this.olL;
                String str = this.olM;
                String str2 = this.olN;
                boolean z = this.olO;
                boolean z2 = this.olP;
                a anonymousClass1 = new a(this) {
                    final /* synthetic */ AnonymousClass2 olR;

                    {
                        this.olR = r1;
                    }

                    public final void dc(String str, String str2) {
                        for (int i = 0; i < this.olR.olL.olD.size(); i++) {
                            com.tencent.mm.plugin.photoedit.b.b bVar = (com.tencent.mm.plugin.photoedit.b.b) this.olR.olL.olD.valueAt(i);
                            if (bVar != null) {
                                w.i("MicroMsg.BaseArtist", "[onFinish] type:%s", new Object[]{bVar.aRO()});
                                bVar.hoD = true;
                                c aRW = bVar.aRW();
                                if (aRW != null) {
                                    aRW.gf(true);
                                } else {
                                    w.e("MicroMsg.BaseArtist", "[onFinish] type:%s cache is null", new Object[]{bVar.aRO()});
                                }
                            }
                        }
                        if (this.olR.olQ != null) {
                            this.olR.olL.c(this.olR.olL.olI);
                            this.olR.olQ.dc(str, str2);
                        }
                    }

                    public final void onError() {
                        this.olR.olL.igD.post(new Runnable(this) {
                            final /* synthetic */ AnonymousClass1 olS;

                            {
                                this.olS = r1;
                            }

                            public final void run() {
                                if (this.olS.olR.olQ != null) {
                                    this.olS.olR.olQ.onError();
                                }
                            }
                        });
                    }
                };
                w.i("MicroMsg.ArtistManager", "[saveEditPhoto] lastPhotoPath:%s rawPhotoPath:%s isRecycle:%s", new Object[]{str, str2, Boolean.valueOf(z)});
                if (!bg.mA(str)) {
                    com.tencent.pb.common.c.a.deleteFile(str);
                    w.w("MicroMsg.ArtistManager", "[getParams] delete file :%s ", new Object[]{str});
                }
                String mr = d.mr("jpg");
                w.i("MicroMsg.ArtistManager", " photoPath:%s", new Object[]{mr});
                f fVar = (f) aVar.b(com.tencent.mm.plugin.photoedit.b.a.ojp);
                if (fVar != null) {
                    aRP = fVar.aRP();
                    if (!(!z || aRP == null || aRP.isRecycled())) {
                        aRP.recycle();
                    }
                }
                com.tencent.mm.plugin.photoedit.b.d dVar = (com.tencent.mm.plugin.photoedit.b.d) aVar.b(com.tencent.mm.plugin.photoedit.b.a.ojo);
                if (dVar != null) {
                    aRP = dVar.aRP();
                    if (!(!z || aRP == null || aRP.isRecycled())) {
                        aRP.recycle();
                    }
                }
                e eVar = (e) aVar.b(com.tencent.mm.plugin.photoedit.b.a.ojq);
                if (eVar != null) {
                    aRP = eVar.aRP();
                    if (!(!z || aRP == null || aRP.isRecycled())) {
                        aRP.recycle();
                    }
                }
                try {
                    boolean z3;
                    Options options = new Options();
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeFile(str2, options);
                    String str3 = "MicroMsg.ArtistManager";
                    String str4 = "mDrawLayer is null? %s rawW:%s rawH:%s rawPhotoPath:%s";
                    Object[] objArr = new Object[4];
                    if (aVar.ojz == null) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    objArr[0] = Boolean.valueOf(z3);
                    objArr[1] = Integer.valueOf(options.outWidth);
                    objArr[2] = Integer.valueOf(options.outHeight);
                    objArr[3] = str2;
                    w.i(str3, str4, objArr);
                    if (aVar.ojz == null) {
                        anonymousClass1.onError();
                        return;
                    }
                    c a;
                    float a2 = aVar.ojz.a(aVar.ojv);
                    if (a2 != 0.0f) {
                        aVar.olK = true;
                    }
                    aRP = aVar.ojz.olf;
                    Canvas canvas = new Canvas(aRP);
                    float f = (1.0f * ((float) options.outHeight)) / ((float) aVar.olG);
                    float f2 = (1.0f * ((float) options.outWidth)) / ((float) aVar.olF);
                    if (f <= f2) {
                        f = f2;
                    }
                    Matrix matrix = new Matrix();
                    matrix.postScale(f, f, 0.0f, 0.0f);
                    matrix.postRotate(-a2);
                    Rect rect = new Rect(aVar.ojw);
                    w.i("MicroMsg.ArtistManager", "[saveEditPhoto] clipRectF:%s w:%s h:%s", new Object[]{rect, Integer.valueOf(aRP.getWidth()), Integer.valueOf(aRP.getHeight())});
                    if (rect.left < 0) {
                        rect.left = 0;
                    }
                    if (rect.top < 0) {
                        rect.top = 0;
                    }
                    if (rect.bottom < 0) {
                        rect.bottom = 0;
                    }
                    if (rect.right < 0) {
                        rect.right = 0;
                    }
                    if (rect.bottom > aRP.getHeight()) {
                        rect.bottom = aRP.getHeight();
                    }
                    if (rect.right > aRP.getWidth()) {
                        rect.right = aRP.getWidth();
                    }
                    if (fVar != null) {
                        ArtistCacheManager.aSf();
                        c a3 = ArtistCacheManager.a(str2, com.tencent.mm.plugin.photoedit.b.a.ojp);
                        if (a3 != null) {
                            new Object[1][0] = fVar.okI;
                            a3.h(canvas);
                        }
                    }
                    if (dVar != null) {
                        ArtistCacheManager.aSf();
                        a = ArtistCacheManager.a(str2, com.tencent.mm.plugin.photoedit.b.a.ojo);
                        if (a != null) {
                            a.h(canvas);
                        }
                    }
                    if (eVar != null) {
                        ArtistCacheManager.aSf();
                        a = ArtistCacheManager.a(str2, com.tencent.mm.plugin.photoedit.b.a.ojq);
                        if (a != null) {
                            a.h(canvas);
                        }
                    }
                    Bitmap createBitmap;
                    try {
                        if (aVar.olF - rect.width() > 6 || aVar.olG - rect.height() > 6) {
                            createBitmap = Bitmap.createBitmap(aRP, rect.left, rect.top, rect.width(), rect.height(), matrix, true);
                            if (z) {
                                aRP.recycle();
                            }
                            com.tencent.mm.sdk.platformtools.d.a(createBitmap, 100, CompressFormat.JPEG, mr, true);
                            d.b(mr, aVar.qb);
                            if (!z2 && z) {
                                aVar.olJ = n.GS().js("photoEdited_" + System.currentTimeMillis());
                                j.p(mr, aVar.olJ, false);
                            }
                            w.i("MicroMsg.ArtistManager", "[save] Successfully!!! w:%s h:%s ByteCount:%skb photoPath:%s tmpPath:%s", new Object[]{Integer.valueOf(aRP.getWidth()), Integer.valueOf(aRP.getHeight()), Integer.valueOf(aRP.getByteCount() / WXMediaMessage.DESCRIPTION_LENGTH_LIMIT), mr, aVar.olJ});
                            aVar.ojz.post(new AnonymousClass3(aVar, anonymousClass1, mr));
                        }
                        createBitmap = Bitmap.createBitmap(aRP, 0, 0, aRP.getWidth(), aRP.getHeight(), matrix, true);
                        if (z) {
                            aRP.recycle();
                        }
                        com.tencent.mm.sdk.platformtools.d.a(createBitmap, 100, CompressFormat.JPEG, mr, true);
                        d.b(mr, aVar.qb);
                        aVar.olJ = n.GS().js("photoEdited_" + System.currentTimeMillis());
                        j.p(mr, aVar.olJ, false);
                        w.i("MicroMsg.ArtistManager", "[save] Successfully!!! w:%s h:%s ByteCount:%skb photoPath:%s tmpPath:%s", new Object[]{Integer.valueOf(aRP.getWidth()), Integer.valueOf(aRP.getHeight()), Integer.valueOf(aRP.getByteCount() / WXMediaMessage.DESCRIPTION_LENGTH_LIMIT), mr, aVar.olJ});
                        aVar.ojz.post(new AnonymousClass3(aVar, anonymousClass1, mr));
                    } catch (Throwable e) {
                        w.printErrStackTrace("MicroMsg.ArtistManager", e, "", new Object[0]);
                        float f3 = 1920.0f / ((float) options.outHeight);
                        float f4 = 1920.0f / ((float) options.outWidth);
                        if (f3 <= f4) {
                            f3 = f4;
                        }
                        matrix.reset();
                        matrix.postScale(f3, f3, 0.0f, 0.0f);
                        matrix.postRotate(-a2);
                        createBitmap = (aVar.olF - rect.width() > 6 || aVar.olG - rect.height() > 6) ? Bitmap.createBitmap(aRP, rect.left, rect.top, rect.width(), rect.height(), matrix, true) : Bitmap.createBitmap(aRP, 0, 0, aRP.getWidth(), aRP.getHeight(), matrix, true);
                    }
                } catch (Throwable e2) {
                    w.printErrStackTrace("MicroMsg.ArtistManager", e2, "", new Object[0]);
                }
            } catch (Throwable e22) {
                w.printErrStackTrace("MicroMsg.ArtistManager", e22, "[onFinish] OutOfMemoryError", new Object[0]);
                this.olL.igD.post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass2 olR;

                    {
                        this.olR = r1;
                    }

                    public final void run() {
                        if (this.olR.olQ != null) {
                            this.olR.olQ.onError();
                        }
                    }
                });
            }
        }
    }

    class AnonymousClass3 implements Runnable {
        final /* synthetic */ a olL;
        final /* synthetic */ a olQ;
        final /* synthetic */ String olT;

        AnonymousClass3(a aVar, a aVar2, String str) {
            this.olL = aVar;
            this.olQ = aVar2;
            this.olT = str;
        }

        public final void run() {
            this.olQ.dc(this.olT, this.olL.olJ);
        }
    }

    static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] olB = new int[com.tencent.mm.plugin.photoedit.b.a.values().length];

        static {
            try {
                olU[FeatureFooterView.b.TEXT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                olU[FeatureFooterView.b.EMOJI.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                olU[FeatureFooterView.b.MOSAIC.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                olU[FeatureFooterView.b.DOODLE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                olU[FeatureFooterView.b.CROP.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                olU[FeatureFooterView.b.DEFAULE.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                olB[com.tencent.mm.plugin.photoedit.b.a.ojq.ordinal()] = 1;
            } catch (NoSuchFieldError e7) {
            }
            try {
                olB[com.tencent.mm.plugin.photoedit.b.a.ojp.ordinal()] = 2;
            } catch (NoSuchFieldError e8) {
            }
            try {
                olB[com.tencent.mm.plugin.photoedit.b.a.ojo.ordinal()] = 3;
            } catch (NoSuchFieldError e9) {
            }
            try {
                olB[com.tencent.mm.plugin.photoedit.b.a.ojr.ordinal()] = 4;
            } catch (NoSuchFieldError e10) {
            }
        }
    }

    public interface a {
        void dc(String str, String str2);

        void onError();
    }

    public static a aSE() {
        if (olC == null) {
            olC = new a();
        }
        return olC;
    }

    public final void a(Activity activity, com.tencent.mm.plugin.photoedit.b.a aVar) {
        com.tencent.mm.plugin.photoedit.b.b bVar = null;
        if (this.olD.get(d(aVar)) != null) {
            w.i("MicroMsg.ArtistManager", "[addArtist] type:%s has added", new Object[]{aVar});
            return;
        }
        switch (AnonymousClass5.olB[aVar.ordinal()]) {
            case 1:
                bVar = new e((MMPhotoEditUI) activity, this);
                this.olD.put(2, bVar);
                break;
            case 2:
                bVar = new f(this);
                this.olD.put(0, bVar);
                break;
            case 3:
                bVar = new com.tencent.mm.plugin.photoedit.b.d(this);
                this.olD.put(1, bVar);
                break;
            case 4:
                bVar = new com.tencent.mm.plugin.photoedit.b.c(this);
                this.olD.put(100, bVar);
                break;
        }
        if (bVar != null) {
            Matrix matrix = this.ojv;
            Rect rect = this.ojw;
            w.i("MicroMsg.BaseArtist", "[onCreate]");
            bVar.ojv = matrix;
            bVar.ojw = rect;
            bVar.a(this.ojz);
        }
    }

    public final com.tencent.mm.plugin.photoedit.b.b b(com.tencent.mm.plugin.photoedit.b.a aVar) {
        switch (AnonymousClass5.olB[aVar.ordinal()]) {
            case 1:
                return (com.tencent.mm.plugin.photoedit.b.b) this.olD.get(2);
            case 2:
                return (com.tencent.mm.plugin.photoedit.b.b) this.olD.get(0);
            case 3:
                return (com.tencent.mm.plugin.photoedit.b.b) this.olD.get(1);
            case 4:
                return (com.tencent.mm.plugin.photoedit.b.b) this.olD.get(100);
            default:
                return null;
        }
    }

    public final void c(com.tencent.mm.plugin.photoedit.b.a aVar) {
        if (this.olH != aVar) {
            this.olI = this.olH;
        }
        this.olH = aVar;
        if (this.olH == com.tencent.mm.plugin.photoedit.b.a.ojn && this.ojz != null) {
            this.ojz.oly = true;
        } else if (this.ojz != null) {
            this.ojz.oly = false;
        }
        for (int i = 0; i < this.olD.size(); i++) {
            ((com.tencent.mm.plugin.photoedit.b.b) this.olD.valueAt(i)).a(this.olI, aSr().aRO());
        }
    }

    public final com.tencent.mm.plugin.photoedit.b.a aSs() {
        return this.olI;
    }

    public final com.tencent.mm.plugin.photoedit.b.a aSt() {
        return this.olH;
    }

    public final void aRU() {
        if (this.kPJ != null) {
            this.kPJ.postInvalidate();
        }
    }

    public final void qZ(int i) {
        if (aSr().aRO() == com.tencent.mm.plugin.photoedit.b.a.ojo) {
            com.tencent.mm.plugin.photoedit.b.d dVar = (com.tencent.mm.plugin.photoedit.b.d) b(com.tencent.mm.plugin.photoedit.b.a.ojo);
            if (dVar != null) {
                dVar.sl = i;
            }
        }
    }

    public final <T extends c> T a(com.tencent.mm.plugin.photoedit.b.a aVar) {
        ArtistCacheManager.aSf();
        return ArtistCacheManager.a(this.olE, aVar);
    }

    public final <T extends com.tencent.mm.plugin.photoedit.b.b> T aSr() {
        com.tencent.mm.plugin.photoedit.b.b bVar = (com.tencent.mm.plugin.photoedit.b.b) this.olD.get(d(this.olH));
        if (bVar != null) {
            return bVar;
        }
        w.e("MicroMsg.ArtistManager", "[getAliveArtist] null, mCurSelectType:%s", new Object[]{this.olH});
        T anonymousClass4 = new com.tencent.mm.plugin.photoedit.b.b(this, this) {
            final /* synthetic */ a olL;

            public final com.tencent.mm.plugin.photoedit.b.a aRO() {
                return com.tencent.mm.plugin.photoedit.b.a.ojn;
            }

            protected final boolean y(MotionEvent motionEvent) {
                return false;
            }

            public final void g(Canvas canvas) {
            }
        };
        this.olD.put(101, anonymousClass4);
        return anonymousClass4;
    }

    private static int d(com.tencent.mm.plugin.photoedit.b.a aVar) {
        switch (AnonymousClass5.olB[aVar.ordinal()]) {
            case 1:
                return 2;
            case 2:
                return 0;
            case 3:
                return 1;
            case 4:
                return 100;
            default:
                return -1;
        }
    }
}
