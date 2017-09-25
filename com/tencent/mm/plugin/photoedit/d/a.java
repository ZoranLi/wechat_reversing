package com.tencent.mm.plugin.photoedit.d;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.tencent.mm.sdk.platformtools.w;

public abstract class a extends View {
    private Context mContext;
    protected com.tencent.mm.plugin.photoedit.c.b ojt;
    public Matrix ojv;
    public Rect ojw;
    private Matrix olc;
    public Rect old = new Rect();
    public Rect ole = new Rect();
    public Bitmap olf;
    public Rect olg;
    protected float olh;
    protected float oli;
    float[] values = new float[9];

    public interface b {
        void LT();

        void onStart();
    }

    class a extends com.tencent.mm.plugin.photoedit.a.b {
        public float fF;
        public float gj;
        ValueAnimator oiP;
        public float ojh;
        public float oji;
        float olj;
        float olk;
        public boolean oll;
        public b olm;
        final /* synthetic */ a oln;

        public a(a aVar, float f, float f2, float f3, float f4, float f5, float f6, boolean z) {
            this.oln = aVar;
            this.gj = f;
            this.olj = f2;
            this.olk = f3;
            this.ojh = f4;
            this.oji = f5;
            this.fF = f6;
            this.oll = z;
        }
    }

    public abstract void i(Canvas canvas);

    static /* synthetic */ void c(a aVar) {
        Rect rect = aVar.olg;
        float width = (((float) rect.width()) * 1.0f) / ((float) rect.height());
        if (width < (((float) aVar.old.width()) * 1.0f) / ((float) aVar.old.height())) {
            width = ((float) aVar.old.width()) / width;
            aVar.old.height();
        } else {
            width = (float) aVar.old.height();
            aVar.old.width();
        }
        width = aVar.a(aVar.ojv) % 180.0f == 0.0f ? (width * 1.0f) / ((float) rect.height()) : (width * 1.0f) / ((float) rect.width());
        if (aVar.olh < width) {
            aVar.olh = width * 1.2f;
        }
    }

    public a(Context context, com.tencent.mm.plugin.photoedit.c.b bVar) {
        super(context);
        this.ojt = bVar;
        this.olg = new Rect();
        this.olc = new Matrix();
        this.mContext = context;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        w.i("MicroMsg.BaseLayer", "[onLayout] changed:%s,  left:%s,  top:%s,  right:%s,  bottom:%s", new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        super.onLayout(z, i, i2, i3, i4);
        if (this.old.isEmpty()) {
            this.old.set(i, i2, i3, i4);
            this.ole.set(this.old);
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(0, Mode.CLEAR);
        canvas.setMatrix(this.ojv);
        canvas.save();
        canvas.clipRect(this.ojw);
        if (!(this.olf == null || this.olf.isRecycled())) {
            canvas.drawBitmap(this.olf, 0.0f, 0.0f, null);
        }
        canvas.restore();
        i(canvas);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mContext = null;
    }

    public final void h(Rect rect) {
        this.olg.set(rect);
        this.ojw.set(rect);
    }

    public final void aSv() {
        float width;
        float height;
        Rect rect = this.olg;
        if (a(this.ojv) % 180.0f == 0.0f) {
            width = (((float) rect.width()) * 1.0f) / ((float) rect.height());
        } else {
            width = (((float) rect.height()) * 1.0f) / ((float) rect.width());
        }
        if (width < (((float) this.old.width()) * 1.0f) / ((float) this.old.height())) {
            width = ((float) this.old.width()) / width;
            height = (float) this.old.height();
        } else {
            float height2 = (float) this.old.height();
            height = ((float) this.old.width()) / width;
            width = height2;
        }
        if (a(this.ojv) % 180.0f == 0.0f) {
            height = (height * 1.0f) / ((float) rect.height());
        } else {
            height = (height * 1.0f) / ((float) rect.width());
        }
        if (a(this.ojv) % 180.0f == 0.0f) {
            width = (width * 1.0f) / ((float) rect.height());
        } else {
            width = (width * 1.0f) / ((float) rect.width());
        }
        this.ojv.postScale(height, height, (float) rect.centerX(), (float) rect.centerY());
        RectF aSA = aSA();
        int centerX = (int) aSA.centerX();
        this.ojv.postTranslate((float) (this.old.centerX() - centerX), (float) (this.old.centerY() - ((int) aSA.centerY())));
        this.olc.set(this.ojv);
        this.olh = b(this.olc) * 3.0f;
        this.oli = b(this.olc) * 1.0f;
        if (this.olh < width) {
            this.olh = width * 1.2f;
        }
    }

    public final void a(b bVar, float f, boolean z) {
        float width;
        float height;
        RectF aSA = aSA();
        int centerX = (int) aSA.centerX();
        int centerY = (int) aSA.centerY();
        int centerX2 = this.old.centerX() - centerX;
        int centerY2 = this.old.centerY() - centerY;
        w.i("MicroMsg.BaseLayer", "[adaptImageWithAnim] rotation:%s", new Object[]{Float.valueOf(f)});
        if (f % 180.0f == 0.0f) {
            width = (1.0f * aSA.width()) / aSA.height();
        } else {
            width = (1.0f * aSA.height()) / aSA.width();
        }
        if (width < (1.0f * ((float) this.old.width())) / ((float) this.old.height())) {
            this.old.width();
            width = (float) this.old.height();
        } else {
            this.old.height();
            width = ((float) this.old.width()) / width;
        }
        if (f % 180.0f == 0.0f) {
            height = (width * 1.0f) / aSA.height();
        } else {
            height = (width * 1.0f) / aSA.width();
        }
        a aVar = new a(this, height, (float) centerX2, (float) centerY2, (float) centerX, (float) centerY, f, z);
        aVar.olm = bVar;
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("scale", new float[]{0.0f, 166.0f});
        PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat("deltaX", new float[]{0.0f, aVar.olj});
        PropertyValuesHolder ofFloat3 = PropertyValuesHolder.ofFloat("deltaY", new float[]{0.0f, aVar.olk});
        PropertyValuesHolder ofFloat4 = PropertyValuesHolder.ofFloat("rotation", new float[]{0.0f, aVar.fF});
        aVar.oiP = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[]{ofFloat, ofFloat2, ofFloat3, ofFloat4});
        aVar.oiP.addUpdateListener(new AnimatorUpdateListener(aVar) {
            float miO = ((float) Math.pow((double) this.olp.gj, 0.10000000149011612d));
            float oiU = 0.0f;
            float oiV = 0.0f;
            int oja = 0;
            float olo = 0.0f;
            final /* synthetic */ a olp;

            {
                this.olp = r6;
            }

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue("deltaY")).floatValue();
                float floatValue2 = ((Float) valueAnimator.getAnimatedValue("deltaX")).floatValue();
                float floatValue3 = ((Float) valueAnimator.getAnimatedValue("rotation")).floatValue();
                if (this.oja < 10) {
                    this.olp.oln.ojv.postScale(this.miO, this.miO, (float) this.olp.oln.old.centerX(), (float) this.olp.oln.old.centerY());
                    this.oja++;
                }
                this.olp.ojh += floatValue2 - this.oiV;
                this.olp.oji += floatValue - this.oiU;
                this.olp.oln.ojv.postTranslate(this.olp.ojh - this.olp.oln.aSA().centerX(), this.olp.oji - this.olp.oln.aSA().centerY());
                if (this.olp.fF != 0.0f) {
                    this.olp.oln.ojv.postRotate(floatValue3 - this.olo, this.olp.ojh, this.olp.oji);
                }
                this.olp.oln.postInvalidate();
                this.oiU = floatValue;
                this.oiV = floatValue2;
                this.olo = floatValue3;
            }
        });
        aVar.oiP.addListener(new AnimatorListener(aVar) {
            final /* synthetic */ a olp;

            {
                this.olp = r1;
            }

            public final void onAnimationStart(Animator animator) {
                if (this.olp.olm != null) {
                    this.olp.olm.onStart();
                }
                this.olp.miY = false;
            }

            public final void onAnimationEnd(Animator animator) {
                if (this.olp.olm != null) {
                    this.olp.olm.LT();
                }
                this.olp.miY = true;
                this.olp.oln.olc.set(this.olp.oln.ojv);
                this.olp.oln.oli = this.olp.oln.b(this.olp.oln.olc) * 1.0f;
                if (this.olp.oll) {
                    this.olp.oln.olh = this.olp.oln.b(this.olp.oln.olc) * 3.0f;
                    a.c(this.olp.oln);
                }
            }

            public final void onAnimationCancel(Animator animator) {
                this.olp.miY = true;
            }

            public final void onAnimationRepeat(Animator animator) {
            }
        });
        aVar.oiP.setInterpolator(new LinearInterpolator());
        aVar.oiP.setDuration(166);
        aVar.oiP.start();
    }

    public final float aSw() {
        return b(this.olc);
    }

    public final float aSx() {
        return b(this.ojv);
    }

    public final float aSy() {
        return this.olh;
    }

    public float aSz() {
        return this.oli;
    }

    public final RectF aSA() {
        RectF rectF = new RectF(this.olg);
        this.ojv.mapRect(rectF);
        return rectF;
    }

    public final com.tencent.mm.plugin.photoedit.c.b aSB() {
        return this.ojt;
    }

    private float a(Matrix matrix, int i) {
        matrix.getValues(this.values);
        return this.values[i];
    }

    private float b(Matrix matrix) {
        float a = a(matrix, 3);
        float a2 = a(matrix, 0);
        return (float) Math.sqrt((double) ((a * a) + (a2 * a2)));
    }

    public final float a(Matrix matrix) {
        return (float) Math.round(Math.atan2((double) a(matrix, 1), (double) a(matrix, 0)) * 57.29577951308232d);
    }
}
