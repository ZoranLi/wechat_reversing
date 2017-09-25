package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View.MeasureSpec;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.w;

public class MultiTouchImageView extends ImageView {
    public int imageHeight;
    public int imageWidth;
    public int lom;
    public int lon;
    protected ae mHandler;
    private boolean nGp;
    public float pbn;
    public boolean qBZ;
    private a qCw;
    protected Bitmap qmk;
    protected Matrix vnZ;
    protected Matrix voa;
    private final Matrix vob;
    private final float[] voc;
    int vod;
    int voe;
    private float vof;
    private float vog;
    private float voh;
    private float voi;
    private float voj;
    private float vok;
    public boolean vol;
    public boolean vom;
    public boolean von;
    private float voo;
    private float vop;
    private float voq;
    float vor;
    public boolean vos;
    public Drawable vot;

    class AnonymousClass1 implements Runnable {
        final /* synthetic */ long hGe;
        final /* synthetic */ float okp;
        final /* synthetic */ float okq;
        final /* synthetic */ float vou = 128.0f;
        final /* synthetic */ float vov;
        final /* synthetic */ float vow;
        final /* synthetic */ MultiTouchImageView vox;

        AnonymousClass1(MultiTouchImageView multiTouchImageView, float f, long j, float f2, float f3, float f4, float f5) {
            this.vox = multiTouchImageView;
            this.hGe = j;
            this.vov = f2;
            this.vow = f3;
            this.okp = f4;
            this.okq = f5;
        }

        public final void run() {
            float min = Math.min(this.vou, (float) (System.currentTimeMillis() - this.hGe));
            this.vox.f(this.vov + (this.vow * min), this.okp, this.okq);
            if (min < this.vou) {
                this.vox.mHandler.post(this);
            }
        }
    }

    public interface a {
        void bkv();

        void bkw();
    }

    public final void at(float f) {
        if (Float.compare(f, 1.0f) < 0) {
            w.w("MicroMsg.MultiTouchImageView", "max scale limit is less than 1.0, change nothing, return");
        } else {
            this.vok = f;
        }
    }

    public MultiTouchImageView(Context context, int i, int i2, a aVar) {
        super(context);
        this.vnZ = new Matrix();
        this.voa = new Matrix();
        this.vob = new Matrix();
        this.voc = new float[9];
        this.qmk = null;
        this.vod = -1;
        this.voe = -1;
        this.vof = 0.0f;
        this.vog = 0.0f;
        this.voh = 0.0f;
        this.nGp = false;
        this.voi = 2.0f;
        this.voj = 0.75f;
        this.vok = 20.0f;
        this.vol = false;
        this.vom = false;
        this.von = false;
        this.qBZ = true;
        this.mHandler = new ae();
        this.voq = 1.0f;
        this.vor = 0.0f;
        this.vos = false;
        this.imageHeight = i2;
        this.imageWidth = i;
        this.qCw = aVar;
        init();
    }

    public MultiTouchImageView(Context context, int i, int i2) {
        this(context, i, i2, null);
    }

    public MultiTouchImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, (byte) 0);
    }

    private MultiTouchImageView(Context context, AttributeSet attributeSet, byte b) {
        super(context, attributeSet);
        this.vnZ = new Matrix();
        this.voa = new Matrix();
        this.vob = new Matrix();
        this.voc = new float[9];
        this.qmk = null;
        this.vod = -1;
        this.voe = -1;
        this.vof = 0.0f;
        this.vog = 0.0f;
        this.voh = 0.0f;
        this.nGp = false;
        this.voi = 2.0f;
        this.voj = 0.75f;
        this.vok = 20.0f;
        this.vol = false;
        this.vom = false;
        this.von = false;
        this.qBZ = true;
        this.mHandler = new ae();
        this.voq = 1.0f;
        this.vor = 0.0f;
        this.vos = false;
        this.imageHeight = 0;
        this.imageWidth = 0;
        init();
    }

    public final void dZ(int i, int i2) {
        this.imageWidth = i;
        this.imageHeight = i2;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.lom = MeasureSpec.getSize(i);
        this.lon = MeasureSpec.getSize(i2);
        if (!this.nGp) {
            this.nGp = true;
            init();
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        this.vos = false;
        this.qmk = bitmap;
        this.nGp = false;
        super.setImageBitmap(bitmap);
    }

    protected void onDraw(Canvas canvas) {
        if (this.vos || this.qmk == null || !this.qmk.isRecycled()) {
            super.onDraw(canvas);
        } else {
            w.e("MicroMsg.MultiTouchImageView", "this bitmap is recycled! draw nothing!");
        }
    }

    public final void bSJ() {
        this.voa.reset();
        bSK();
        f(this.pbn, 0.0f, 0.0f);
    }

    public final void E(float f, float f2) {
        bSK();
        g(this.pbn, f, f2);
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (configuration.orientation == 1 || configuration.orientation == 2) {
            this.nGp = false;
        }
    }

    private void bSK() {
        boolean z = true;
        this.voo = ((float) this.lom) / ((float) this.imageWidth);
        this.vop = ((float) this.lon) / ((float) this.imageHeight);
        this.vom = d.bh(this.imageWidth, this.imageHeight);
        this.von = d.bg(this.imageWidth, this.imageHeight);
        boolean z2 = this.vom && this.imageWidth > this.lom;
        this.vom = z2;
        if (!this.von || this.imageHeight <= this.lon) {
            z = false;
        }
        this.von = z;
        this.pbn = this.voo;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        if (f.bnc()) {
            e eVar = new e();
            keyEvent.startTracking();
        }
        return true;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        boolean z = false;
        if (i == 4) {
            boolean isTracking;
            if (f.bnc()) {
                e eVar = new e();
                isTracking = keyEvent.isTracking();
            } else {
                isTracking = false;
            }
            if (isTracking) {
                if (f.bnc()) {
                    e eVar2 = new e();
                    z = keyEvent.isCanceled();
                }
                if (!z && getScale() > 1.0f) {
                    f(1.0f, ((float) this.lom) / 2.0f, ((float) this.lon) / 2.0f);
                    return true;
                }
            }
        }
        return super.onKeyUp(i, keyEvent);
    }

    private void L(boolean z, boolean z2) {
        float f = 0.0f;
        if (this.qmk == null && !this.vos) {
            return;
        }
        if (this.vot != null || !this.vos) {
            RectF rectF;
            Matrix bSL = bSL();
            if (this.vos) {
                rectF = new RectF(0.0f, 0.0f, (float) this.vot.getIntrinsicWidth(), (float) this.vot.getIntrinsicHeight());
            } else {
                rectF = new RectF(0.0f, 0.0f, (float) this.qmk.getWidth(), (float) this.qmk.getHeight());
            }
            bSL.mapRect(rectF);
            float height = rectF.height();
            float width = rectF.width();
            if (z2) {
                if (height < ((float) this.lon)) {
                    height = ((((float) this.lon) - height) / 2.0f) - rectF.top;
                } else if (rectF.top > 0.0f) {
                    height = -rectF.top;
                } else {
                    if (rectF.bottom < ((float) this.lon)) {
                        height = ((float) this.lon) - rectF.bottom;
                    }
                    height = 0.0f;
                }
            } else if (rectF.top > 0.0f) {
                height = -rectF.top;
            } else {
                if (rectF.bottom < ((float) this.lon)) {
                    height = ((float) this.lon) - rectF.bottom;
                }
                height = 0.0f;
            }
            if (z) {
                if (width < ((float) this.lom)) {
                    f = ((((float) this.lom) - width) / 2.0f) - rectF.left;
                } else if (rectF.left > 0.0f) {
                    f = -rectF.left;
                } else if (rectF.right < ((float) this.lom)) {
                    f = ((float) this.lom) - rectF.right;
                }
            } else if (rectF.left > 0.0f) {
                f = -rectF.left;
            } else if (rectF.right < ((float) this.lom)) {
                f = ((float) this.lom) - rectF.right;
            }
            G(f, height);
            Matrix bSL2 = bSL();
            setImageMatrix(bSL2);
            bSL2.mapRect(rectF);
            rectF.height();
            rectF.width();
        }
    }

    private void init() {
        w.d("dktest", "init screenWidth:" + this.lom + " screenHeight :" + this.lon);
        setScaleType(ScaleType.MATRIX);
        float f = ((float) getContext().getResources().getDisplayMetrics().widthPixels) / 720.0f;
        if (f > 1.0f) {
            this.voq = f;
        }
        bSJ();
    }

    public final float getScale() {
        this.voa.getValues(this.voc);
        bSK();
        this.vog = this.vok * this.voq;
        this.voh = this.pbn * this.voj;
        if (this.vog < 1.0f) {
            this.vog = 1.0f;
        }
        if (this.voh > 1.0f) {
            this.voh = 1.0f;
        }
        return this.voc[0];
    }

    private Matrix bSL() {
        this.vob.set(this.vnZ);
        this.vob.postConcat(this.voa);
        return this.vob;
    }

    public final void bSM() {
        boolean z;
        boolean z2 = true;
        if (this.qBZ && this.vom) {
            z = false;
        } else {
            z = true;
        }
        if (this.von) {
            z2 = false;
        }
        L(z, z2);
    }

    public final void bSN() {
        if (this.vol && 0.0f == this.vof) {
            this.vof = bSO();
        }
    }

    public final void f(float f, float f2, float f3) {
        boolean z;
        boolean z2 = true;
        float scale = getScale();
        if (this.vol) {
            this.vog = 0.0f == this.vof ? this.vok * this.voq : this.vof;
        }
        if (f > this.vog * 2.0f) {
            f = (this.vog * 2.0f) + ((f - this.vog) * 0.1f);
        } else if (f < this.voh) {
            f = this.voh;
        }
        scale = f / scale;
        if (!this.vos) {
            setImageMatrix(bSL());
            this.voa.postScale(scale, scale, f2, f3);
        }
        if (this.qBZ && this.vom) {
            z = false;
        } else {
            z = true;
        }
        if (this.von) {
            z2 = false;
        }
        L(z, z2);
        if (this.qCw == null) {
            return;
        }
        if (scale > 1.0f) {
            this.qCw.bkw();
        } else if (scale < 1.0f) {
            this.qCw.bkv();
        }
    }

    public final float bSO() {
        float f = this.pbn;
        if (this.voo * 0.7f > f) {
            f = this.voo;
        } else if (this.vop * 0.7f > f) {
            f = this.vop;
        } else {
            f = this.pbn * this.voi;
        }
        if (((double) f) < 1.0d) {
            f = 1.0f;
        }
        if (f > this.vog) {
            return this.vog;
        }
        return f;
    }

    public final void F(float f, float f2) {
        this.vof = bSO();
        g(this.vof, f, f2);
    }

    private void g(float f, float f2, float f3) {
        float scale = (f - getScale()) / 128.0f;
        float scale2 = getScale();
        this.mHandler.post(new AnonymousClass1(this, 128.0f, System.currentTimeMillis(), scale2, scale, f2, f3));
    }

    public final void G(float f, float f2) {
        this.voa.postTranslate(f, f2);
        setImageMatrix(bSL());
    }
}
