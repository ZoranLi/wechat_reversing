package com.tencent.mm.plugin.photoedit.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.d;

public class SelectColorBar extends View {
    private static final int[] onV = new int[]{-1, -707825, -17592, -5376, -3997905, -16535286, -14298369, -15172610, -16762936, -7054596, -26113, -169583, -449092};
    private static final int oof = com.tencent.mm.plugin.photoedit.g.a.ad(7.0f);
    int CI = -1;
    private float aed;
    private Paint fu = new Paint();
    private Path mU = new Path();
    private Rect onR = new Rect();
    private float ooD;
    private float ooE;
    private float ooF;
    private float ooa = getResources().getDimension(R.f.aZk);
    private float oog;
    private Bitmap oon = d.t(getResources().getDrawable(R.k.csq));
    private Bitmap ooo = this.oon.copy(Config.ARGB_8888, true);
    public ImageView oop;
    private Paint ooq = new Paint();
    public a oos;
    private float width;

    public interface a {
        void qZ(int i);
    }

    public SelectColorBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ooq.setStyle(Style.FILL);
        this.fu.setAntiAlias(true);
        this.fu.setStyle(Style.STROKE);
        this.fu.setStrokeWidth((float) oof);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.onR.set(i, i2, i3, i4);
        this.width = ((((float) this.onR.width()) * 1.0f) * 2.8f) / 5.0f;
        this.ooD = this.width / ((float) onV.length);
        this.ooE = (((float) this.onR.width()) * 1.1f) / 5.0f;
        this.ooF = (((float) this.onR.height()) * 1.0f) / 2.0f;
        this.oog = (this.ooD / 2.0f) - 3.0f;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.saveLayer(0.0f, 0.0f, (float) this.onR.width(), (float) this.onR.height(), null, 31);
        canvas.drawColor(0, Mode.CLEAR);
        this.fu.setStrokeCap(Cap.BUTT);
        for (int i = 0; i < onV.length; i++) {
            this.mU.reset();
            this.mU.moveTo(this.ooE + (this.ooD * ((float) i)), this.ooF);
            this.mU.lineTo(this.ooE + (this.ooD * ((float) (i + 1))), this.ooF);
            this.fu.setColor(onV[i]);
            canvas.drawPath(this.mU, this.fu);
        }
        this.fu.setColor(onV[4]);
        this.fu.setStrokeCap(Cap.ROUND);
        this.fu.setXfermode(new PorterDuffXfermode(Mode.DST_IN));
        this.mU.reset();
        this.mU.moveTo(this.ooE + (this.ooD / 3.0f), this.ooF);
        this.mU.lineTo((this.ooE + (this.ooD * ((float) onV.length))) - (this.ooD / 3.0f), this.ooF);
        canvas.drawPath(this.mU, this.fu);
        canvas.restore();
        this.fu.setXfermode(null);
        if (this.CI == -1 || this.aed == 0.0f) {
            this.CI = 0;
            this.aed = rc(this.CI);
        }
        float f = this.ooF;
        this.fu.setColor(onV[0]);
        this.fu.setStyle(Style.FILL);
        canvas.drawRoundRect(new RectF(this.aed - (this.ooD / 4.0f), f - (this.ooD / 1.6f), this.aed + (this.ooD / 4.0f), (this.ooD / 1.6f) + f), 15.0f, 15.0f, this.fu);
        this.fu.setColor(onV[this.CI]);
        canvas.drawRoundRect(new RectF((this.aed - (this.ooD / 4.0f)) + 3.0f, (f - (this.ooD / 1.6f)) + 3.0f, (this.aed + (this.ooD / 4.0f)) - 3.0f, (f + (this.ooD / 1.6f)) - 3.0f), 15.0f, 15.0f, this.fu);
        this.fu.setStyle(Style.STROKE);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 2) {
            if (motionEvent.getX() <= this.ooE + this.width && motionEvent.getX() >= this.ooE) {
                this.aed = motionEvent.getX();
                aSM();
                postInvalidate();
                if (this.oos != null) {
                    this.oos.qZ(onV[this.CI]);
                }
            }
        } else if (motionEvent.getActionMasked() == 1) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{this.aed, rc(ae(this.aed))});
            ofFloat.addUpdateListener(new AnimatorUpdateListener(this) {
                final /* synthetic */ SelectColorBar ooG;

                {
                    this.ooG = r1;
                }

                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.ooG.aed = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    this.ooG.aSM();
                    this.ooG.postInvalidate();
                }
            });
            ofFloat.addListener(new AnimatorListener(this) {
                final /* synthetic */ SelectColorBar ooG;

                {
                    this.ooG = r1;
                }

                public final void onAnimationStart(Animator animator) {
                }

                public final void onAnimationEnd(Animator animator) {
                    this.ooG.oop.setVisibility(8);
                }

                public final void onAnimationCancel(Animator animator) {
                }

                public final void onAnimationRepeat(Animator animator) {
                }
            });
            ofFloat.setInterpolator(new LinearInterpolator());
            ofFloat.start();
        }
        return true;
    }

    private void aSM() {
        if (this.oop.getVisibility() == 8) {
            this.oop.setVisibility(0);
        }
        this.oop.setX(this.aed - (((float) this.ooo.getWidth()) / 2.0f));
        this.oop.setY(((float) getTop()) - this.ooa);
        this.CI = ae(this.aed);
        this.ooq.setColorFilter(new LightingColorFilter(onV[this.CI], 1));
        Canvas canvas = new Canvas(this.ooo);
        canvas.drawColor(0, Mode.CLEAR);
        canvas.drawBitmap(this.oon, 0.0f, 0.0f, this.ooq);
        this.oop.setImageBitmap(this.ooo);
    }

    private int ae(float f) {
        int length = onV.length - 1;
        int i = 0;
        while (i < onV.length) {
            if (f >= this.ooE + (((float) i) * this.ooD) && f < this.ooE + (((float) (i + 1)) * this.ooD)) {
                break;
            }
            i++;
        }
        i = length;
        if (this.ooE > f) {
            return 0;
        }
        return i;
    }

    private float rc(int i) {
        return (this.ooE + (((float) i) * this.ooD)) + (this.ooD / 2.0f);
    }

    public final void setColor(int i) {
        int i2 = 0;
        int[] iArr = onV;
        int length = iArr.length;
        int i3 = 0;
        while (i2 < length && i != iArr[i2]) {
            i3++;
            i2++;
        }
        this.CI = i3;
        this.aed = rc(this.CI);
        postInvalidate();
    }

    public static int aSO() {
        return onV[0];
    }
}
