package com.tencent.mm.svg.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Picture;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import com.tencent.mm.svg.b.b;

public final class c extends b {
    private a uNi;

    public static class a extends ConstantState {
        protected int rcB;
        protected Picture uNj;
        protected Bitmap uNk;

        public a(Picture picture, int i) {
            this.uNj = picture;
            this.rcB = i;
        }

        public final Drawable newDrawable() {
            return new c(this.uNj, this.rcB);
        }

        public final int getChangingConfigurations() {
            return 0;
        }
    }

    public c(Picture picture, int i) {
        int i2 = 0;
        int width = picture != null ? picture.getWidth() : 0;
        if (picture != null) {
            i2 = picture.getHeight();
        }
        super(width, i2, i);
        this.uNi = new a(picture, i);
        bNU();
    }

    public final ConstantState getConstantState() {
        return this.uNi;
    }

    public final void draw(Canvas canvas) {
        Object obj = 1;
        Object obj2 = null;
        long bOc = b.bOc();
        try {
            if (canvas.isHardwareAccelerated()) {
                if (this.uNi.uNj == null) {
                    com.tencent.mm.svg.b.c.e("MicroMsg.SVGPictureDrawable", "Must not go here! %s", Integer.valueOf(this.uNa));
                } else {
                    long nanoTime = System.nanoTime();
                    if (this.uNi.uNk == null || this.uNi.uNk.isRecycled()) {
                        if (getIntrinsicWidth() > 2048 || getIntrinsicHeight() > 2048) {
                            com.tencent.mm.svg.b.c.e("MicroMsg.SVGPictureDrawable", "This drawable is too big. %s", Integer.valueOf(this.uNa));
                        } else if (getIntrinsicWidth() <= 0 || getIntrinsicHeight() <= 0) {
                            com.tencent.mm.svg.b.c.e("MicroMsg.SVGPictureDrawable", "width and height must > 0.", new Object[0]);
                        } else {
                            Bitmap createBitmap = Bitmap.createBitmap(getIntrinsicWidth(), getIntrinsicHeight(), Config.ARGB_8888);
                            Canvas canvas2 = new Canvas(createBitmap);
                            this.uNi.uNj.draw(canvas2);
                            this.uNi.uNk = createBitmap;
                            b.eD(nanoTime);
                            n(canvas2);
                        }
                    }
                }
                if (this.uNi.uNk == null || this.uNi.uNk.isRecycled()) {
                    obj = null;
                } else {
                    bNV();
                    canvas.drawBitmap(this.uNi.uNk, null, this.tZ, this.uNc);
                }
                obj2 = obj;
            } else if (!(this.uNi.uNk == null || this.uNi.uNk.isRecycled())) {
                com.tencent.mm.svg.b.c.i("MicroMsg.SVGPictureDrawable", "recycle bitmap:%s", this.uNi.uNk.toString());
                this.uNi.uNk.recycle();
                this.uNi.uNk = null;
            }
            if (this.lCU == null) {
                this.lCU = a.u(this);
            }
            a.b(this.lCU, this.uNc);
            if (obj2 == null) {
                if (!canvas.isHardwareAccelerated() || VERSION.SDK_INT >= 16) {
                    Picture picture = this.uNi.uNj;
                    if (picture != null) {
                        bNV();
                        canvas.save();
                        canvas.drawPicture(picture, this.tZ);
                        canvas.restore();
                    }
                } else {
                    com.tencent.mm.svg.b.c.i("MicroMsg.SVGPictureDrawable", "Skip this draw.", new Object[0]);
                    return;
                }
            }
            this.mDuration = b.eD(bOc);
            n(canvas);
        } finally {
            this.mDuration = b.eD(bOc);
            n(canvas);
        }
    }
}
