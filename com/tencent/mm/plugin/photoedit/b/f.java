package com.tencent.mm.plugin.photoedit.b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.view.MotionEvent;
import com.tencent.mm.plugin.photoedit.cache.d;
import com.tencent.mm.plugin.photoedit.f.d.a;
import com.tencent.mm.plugin.photoedit.f.d.b;
import com.tencent.mm.sdk.platformtools.w;
import java.util.LinkedList;

public final class f extends b<d> {
    private float aed;
    private float aee;
    private Path mU = new Path();
    private boolean ojV = false;
    private float ojW;
    private float ojX;
    public Bitmap okI;
    private LinkedList<b> okJ = new LinkedList();
    private a okK = a.omz;
    private boolean okr = true;

    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] okL = new int[a.values().length];

        static {
            try {
                okL[a.omz.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                okL[a.omA.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public f(com.tencent.mm.plugin.photoedit.c.b bVar) {
        super(bVar);
    }

    public final void a(com.tencent.mm.plugin.photoedit.d.b bVar) {
        Bitmap bitmap;
        super.a(bVar);
        Bitmap aRX = aRX();
        if (aRX == null) {
            w.e("MicroMsg.MosaicArtist", "[generateMosaicImage] bitmap is null");
            bitmap = null;
        } else {
            int width = aRX.getWidth();
            int height = aRX.getHeight();
            int ad = com.tencent.mm.plugin.photoedit.g.a.ad(25.0f);
            Bitmap createBitmap = Bitmap.createBitmap(width, height, Config.RGB_565);
            Canvas canvas = new Canvas(createBitmap);
            int ceil = (int) Math.ceil((double) (((float) width) / ((float) ad)));
            int ceil2 = (int) Math.ceil((double) (((float) height) / ((float) ad)));
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            for (int i = 0; i < ceil; i++) {
                for (int i2 = 0; i2 < ceil2; i2++) {
                    int i3 = ad * i;
                    int i4 = ad * i2;
                    int i5 = i3 + ad;
                    int i6 = i5 > width ? width : i5;
                    i5 = i4 + ad;
                    if (i5 > height) {
                        i5 = height;
                    }
                    int pixel = aRX.getPixel(i3, i4);
                    Rect rect = new Rect(i3, i4, i6, i5);
                    paint.setColor(pixel);
                    canvas.drawRect(rect, paint);
                }
            }
            bitmap = createBitmap;
        }
        this.okI = bitmap;
        w.i("MicroMsg.MosaicArtist", "[onAlive] isReset:%s", new Object[]{Boolean.valueOf(aRQ())});
    }

    public final void onDestroy() {
        super.onDestroy();
        if (this.okI != null && !this.okI.isRecycled()) {
            this.okI.recycle();
        }
    }

    public final a aRO() {
        return a.ojp;
    }

    protected final boolean y(MotionEvent motionEvent) {
        int i = 0;
        float[] z = z(motionEvent.getX(), motionEvent.getY());
        float f;
        switch (motionEvent.getActionMasked()) {
            case 0:
                if (this.ojw.contains((int) z[0], (int) z[1])) {
                    f = z[0];
                    this.ojW = f;
                    this.aed = f;
                    float f2 = z[1];
                    this.ojX = f2;
                    this.aee = f2;
                    this.okr = true;
                } else {
                    this.okr = false;
                }
                this.ojV = false;
                break;
            case 1:
            case 5:
                if (this.okr && this.ojV) {
                    if (this.okK == a.omz) {
                        ((d) aRW()).a(new com.tencent.mm.plugin.photoedit.f.d(this.okK, new Path(this.mU), 1.0f / getScale()));
                        b(false, this.okI);
                    } else if (this.okK == a.omA) {
                        ((d) aRW()).a(new com.tencent.mm.plugin.photoedit.f.d(this.okK, new LinkedList(this.okJ), 1.0f / getScale()));
                        b(false, new Object[0]);
                    }
                    aRU();
                }
                this.okJ.clear();
                this.mU.reset();
                this.ojV = false;
                this.okr = false;
                break;
            case 2:
                if (!this.okr || !this.ojV) {
                    if (this.okr && !this.ojV) {
                        if (this.okK == a.omz) {
                            this.mU.moveTo(z[0], z[1]);
                        }
                        this.ojV = true;
                        break;
                    }
                }
                this.ojW = this.aed;
                this.ojX = this.aee;
                this.aed = z[0];
                this.aee = z[1];
                if (this.okK == a.omz) {
                    this.mU.quadTo(this.ojW, this.ojX, (this.aed + this.ojW) / 2.0f, (this.aee + this.ojX) / 2.0f);
                } else if (this.okK == a.omA) {
                    int i2;
                    double toDegrees = Math.toDegrees(Math.atan((double) ((this.aed - this.ojW) / (this.aee - this.ojX))));
                    if (getRotation() == 180.0f) {
                        i2 = 180;
                    } else {
                        i2 = 0;
                    }
                    float f3 = ((float) (((double) i2) + toDegrees)) % 360.0f;
                    LinkedList linkedList = this.okJ;
                    f = 1.0f / getScale();
                    float f4 = this.aed;
                    float f5 = this.aee;
                    Bitmap aRX = aRX();
                    if (aRX == null || f4 >= ((float) aRX.getWidth()) || f5 >= ((float) aRX.getHeight()) || f4 <= 0.0f || f5 <= 0.0f) {
                        w.w("MicroMsg.MosaicArtist", "[getPosColor] X:%s,Y:%s", new Object[]{Float.valueOf(f4), Float.valueOf(f5)});
                    } else {
                        i = aRX.getPixel((int) f4, (int) f5);
                    }
                    linkedList.add(new b(f, i, f3, this.aed, this.aee));
                }
                aRR();
                break;
                break;
        }
        return this.okr;
    }

    public final void f(Canvas canvas) {
        if (this.okK == a.omA) {
            Bitmap aRP = aRP();
            if (aRP != null) {
                new com.tencent.mm.plugin.photoedit.f.d(this.okK, this.okJ, 1.0f / getScale()).a(new Canvas(aRP), new Object[0]);
                canvas.save();
                canvas.clipRect(this.ojw);
                canvas.drawBitmap(aRP, 0.0f, 0.0f, null);
                canvas.restore();
                return;
            }
            w.w("MicroMsg.MosaicArtist", "[onDeadDraw] bitmap == null ");
            return;
        }
        super.f(canvas);
    }

    public final void g(Canvas canvas) {
        canvas.save();
        canvas.clipRect(this.ojw);
        switch (AnonymousClass1.okL[this.okK.ordinal()]) {
            case 1:
                if (!this.mU.isEmpty()) {
                    new com.tencent.mm.plugin.photoedit.f.d(this.okK, this.mU, 1.0f / getScale()).a(canvas, new Object[]{this.okI});
                    break;
                }
                break;
        }
        canvas.restore();
    }

    public final void a(a aVar) {
        w.i("MicroMsg.MosaicArtist", "[setMosaicStyle] :%s", new Object[]{aVar});
        this.okK = aVar;
    }
}
