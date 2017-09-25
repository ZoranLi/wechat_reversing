package com.tencent.mm.pluginsdk.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.mm.R;
import com.tencent.mm.bg.a;
import com.tencent.mm.sdk.platformtools.w;
import java.util.Random;

public final class m extends Drawable {
    private Context context;
    private Paint jXK = new Paint(1);
    ValueAnimator jsj = ValueAnimator.ofFloat(new float[]{0.0f, 100.0f});
    private Random random = new Random(System.currentTimeMillis());
    private int sKA;
    int sKB = 2;
    private RectF sKC;
    private Drawable sKc = null;
    private int sKd = 0;
    private int sKe = 0;
    private Interpolator sKf = new LinearInterpolator();
    private Interpolator sKg = new AccelerateDecelerateInterpolator();
    private int sKh;
    private int sKi;
    private int sKj;
    private int sKk;
    private int sKl;
    private int sKm;
    private int sKn;
    private int sKo;
    private int sKp;
    private int sKq;
    private int sKr = 0;
    float sKs = 0.0f;
    private float sKt = -90.0f;
    private float sKu = 0.0f;
    private float sKv = 0.0f;
    private float sKw = 5.0f;
    boolean sKx = false;
    private int sKy;
    private int sKz;

    public m(Context context) {
        this.jsj.setInterpolator(this.sKf);
        this.jsj.addUpdateListener(new AnimatorUpdateListener(this) {
            final /* synthetic */ m sKD;

            {
                this.sKD = r1;
            }

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.sKD.sKs = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                this.sKD.invalidateSelf();
            }
        });
        this.sKC = new RectF();
        this.context = context;
        this.sKd = a.b(context, R.e.aWu);
        this.sKe = a.b(context, R.e.aVl);
        this.sKc = context.getResources().getDrawable(R.k.dAs);
        this.sKk = a.U(context, R.f.bbs);
        this.sKl = a.U(context, R.f.bbr);
        this.sKm = a.U(context, R.f.bbl);
        this.sKr = a.U(context, R.f.bbq);
        this.sKi = a.b(context, R.e.aWa);
        this.sKj = a.U(context, R.f.bbn);
        this.sKp = a.U(context, R.f.bbm);
        this.sKq = a.b(context, R.e.aWb);
        this.sKy = this.sKp;
        this.sKz = this.sKy;
        this.sKA = a.U(context, R.f.bbp);
        this.sKn = a.U(context, R.f.bbp);
        this.sKo = a.U(context, R.f.bbo);
        this.sKh = a.U(context, R.f.bbt);
    }

    public final void bEv() {
        w.d("MicroMsg.VoiceInputDrawable", "readyState %s", new Object[]{Integer.valueOf(this.sKB)});
        this.sKB = 2;
        this.jsj.cancel();
        this.sKs = 0.0f;
        this.sKt = -90.0f;
        this.sKu = 0.0f;
        this.sKv = 0.0f;
        this.sKw = 5.0f;
        invalidateSelf();
    }

    public final void draw(Canvas canvas) {
        int width;
        int height;
        if ((this.sKB == 6 || this.sKB == 7) && !m(canvas)) {
            width = canvas.getWidth() >> 1;
            height = canvas.getHeight() >> 1;
            this.jXK.setShader(null);
            this.jXK.setStyle(Style.FILL);
            this.jXK.setColor(this.sKi);
            if (this.sKB == 7) {
                if (this.sKx) {
                    this.sKA -= 4;
                } else {
                    this.sKA += 4;
                }
                this.sKA = Math.min(Math.max(this.sKn, this.sKA), this.sKo);
                canvas.drawCircle((float) width, (float) height, (float) this.sKA, this.jXK);
            } else {
                canvas.drawCircle((float) width, (float) height, (float) this.sKn, this.jXK);
            }
        }
        if (!(this.sKc == null || m(canvas))) {
            if (this.sKB == 5) {
                this.sKc.setColorFilter(this.sKe, Mode.SRC_ATOP);
            } else {
                this.sKc.setColorFilter(this.sKd, Mode.SRC_ATOP);
            }
            width = canvas.getWidth() / 2;
            height = canvas.getHeight() / 2;
            this.sKc.setBounds(width - this.sKr, height - this.sKr, width + this.sKr, height + this.sKr);
            this.sKc.draw(canvas);
        }
        if (this.sKB == 4 && canvas != null) {
            this.jXK.setColor(this.sKd);
            this.jXK.setStrokeWidth((float) this.sKh);
            this.jXK.setStyle(Style.STROKE);
            this.jXK.clearShadowLayer();
            this.jXK.setShader(null);
            this.sKC.left = (float) ((canvas.getWidth() / 2) - this.sKp);
            this.sKC.top = (float) ((canvas.getHeight() / 2) - this.sKp);
            this.sKC.right = (float) ((canvas.getWidth() / 2) + this.sKp);
            this.sKC.bottom = (float) ((canvas.getHeight() / 2) + this.sKp);
            canvas.drawArc(this.sKC, this.sKt, this.sKv, false, this.jXK);
            this.sKt += this.sKu;
            this.sKv += this.sKw;
            if (this.sKv >= 360.0f) {
                this.sKw = -this.sKw;
                this.sKu = 5.0f;
            } else if (this.sKv <= 0.0f) {
                this.sKw = -this.sKw;
                this.sKu = 0.0f;
                this.sKt = -90.0f;
                this.sKv = 0.0f;
            }
        }
        if ((this.sKB == 6 || this.sKB == 7) && !m(canvas)) {
            this.jXK.setStyle(Style.FILL);
            this.jXK.setColor(this.sKq);
            canvas.drawCircle((float) (canvas.getWidth() >> 1), (float) (canvas.getHeight() >> 1), (float) this.sKr, this.jXK);
        }
    }

    public final void setAlpha(int i) {
    }

    public final void setColorFilter(ColorFilter colorFilter) {
    }

    public final int getIntrinsicWidth() {
        if (this.context == null) {
            return 0;
        }
        return a.dO(this.context);
    }

    public final int getIntrinsicHeight() {
        return this.sKr * 2;
    }

    public final int getOpacity() {
        return -3;
    }

    private static boolean m(Canvas canvas) {
        return canvas == null || canvas.getWidth() == 0 || canvas.getHeight() == 0;
    }
}
