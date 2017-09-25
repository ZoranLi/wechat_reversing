package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.support.v4.view.b.b;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;

final class l extends Drawable implements Animatable {
    private static final Interpolator Cr = new b();
    private static final Interpolator es = new LinearInterpolator();
    private final int[] Cs = new int[]{WebView.NIGHT_MODE_COLOR};
    final a Ct;
    private Resources Cu;
    private View Cv;
    private float Cw;
    private double Cx;
    private double Cy;
    boolean Cz;
    private float fF;
    private final Callback lY = new Callback(this) {
        final /* synthetic */ l CB;

        {
            this.CB = r1;
        }

        public final void invalidateDrawable(Drawable drawable) {
            this.CB.invalidateSelf();
        }

        public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            this.CB.scheduleSelf(runnable, j);
        }

        public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            this.CB.unscheduleSelf(runnable);
        }
    };
    private Animation mAnimation;
    private final ArrayList<Animation> mc = new ArrayList();

    private static class a {
        final RectF CC = new RectF();
        final Paint CD = new Paint();
        float CE = 0.0f;
        float CF = 0.0f;
        float CG = 2.5f;
        int[] CH;
        int CI;
        float CJ;
        float CK;
        float CL;
        boolean CM;
        Path CN;
        float CO;
        double CP;
        int CQ;
        int CR;
        int CS;
        final Paint CT = new Paint(1);
        int CU;
        float fF = 0.0f;
        final Paint fu = new Paint();
        private final Callback lY;
        float mw = 5.0f;
        int tQ;

        public a(Callback callback) {
            this.lY = callback;
            this.fu.setStrokeCap(Cap.SQUARE);
            this.fu.setAntiAlias(true);
            this.fu.setStyle(Style.STROKE);
            this.CD.setStyle(Style.FILL);
            this.CD.setAntiAlias(true);
        }

        public final void ah(int i) {
            this.CI = i;
            this.tQ = this.CH[this.CI];
        }

        final int ct() {
            return (this.CI + 1) % this.CH.length;
        }

        public final void x(float f) {
            this.CE = f;
            invalidateSelf();
        }

        public final void y(float f) {
            this.CF = f;
            invalidateSelf();
        }

        public final void setRotation(float f) {
            this.fF = f;
            invalidateSelf();
        }

        public final void v(boolean z) {
            if (this.CM != z) {
                this.CM = z;
                invalidateSelf();
            }
        }

        public final void cu() {
            this.CJ = this.CE;
            this.CK = this.CF;
            this.CL = this.fF;
        }

        public final void cv() {
            this.CJ = 0.0f;
            this.CK = 0.0f;
            this.CL = 0.0f;
            x(0.0f);
            y(0.0f);
            setRotation(0.0f);
        }

        final void invalidateSelf() {
            this.lY.invalidateDrawable(null);
        }
    }

    static /* synthetic */ void a(l lVar, float f, a aVar) {
        a(f, aVar);
        float floor = (float) (Math.floor((double) (aVar.CL / 0.8f)) + 1.0d);
        float a = a(aVar);
        aVar.x((((aVar.CK - a) - aVar.CJ) * f) + aVar.CJ);
        aVar.y(aVar.CK);
        aVar.setRotation(((floor - aVar.CL) * f) + aVar.CL);
    }

    public l(Context context, View view) {
        this.Cv = view;
        this.Cu = context.getResources();
        this.Ct = new a(this.lY);
        a aVar = this.Ct;
        aVar.CH = this.Cs;
        aVar.ah(0);
        a aVar2 = this.Ct;
        float f = this.Cu.getDisplayMetrics().density;
        this.Cx = ((double) f) * 40.0d;
        this.Cy = ((double) f) * 40.0d;
        float f2 = 2.5f * f;
        aVar2.mw = f2;
        aVar2.fu.setStrokeWidth(f2);
        aVar2.invalidateSelf();
        aVar2.CP = 8.75d * ((double) f);
        aVar2.ah(0);
        f2 = 10.0f * f;
        f *= 5.0f;
        aVar2.CQ = (int) f2;
        aVar2.CR = (int) f;
        f = (float) Math.min((int) this.Cx, (int) this.Cy);
        f = (aVar2.CP <= 0.0d || f < 0.0f) ? (float) Math.ceil((double) (aVar2.mw / 2.0f)) : (float) (((double) (f / 2.0f)) - aVar2.CP);
        aVar2.CG = f;
        aVar = this.Ct;
        Animation anonymousClass1 = new Animation(this) {
            final /* synthetic */ l CB;

            public final void applyTransformation(float f, Transformation transformation) {
                if (this.CB.Cz) {
                    l.a(this.CB, f, aVar);
                    return;
                }
                float b = l.a(aVar);
                float f2 = aVar.CK;
                float f3 = aVar.CJ;
                float f4 = aVar.CL;
                l.a(f, aVar);
                if (f <= 0.5f) {
                    float f5 = 0.8f - b;
                    aVar.x(f3 + (l.Cr.getInterpolation(f / 0.5f) * f5));
                }
                if (f > 0.5f) {
                    aVar.y(((0.8f - b) * l.Cr.getInterpolation((f - 0.5f) / 0.5f)) + f2);
                }
                aVar.setRotation((0.25f * f) + f4);
                this.CB.setRotation((216.0f * f) + (1080.0f * (this.CB.Cw / 5.0f)));
            }
        };
        anonymousClass1.setRepeatCount(-1);
        anonymousClass1.setRepeatMode(1);
        anonymousClass1.setInterpolator(es);
        anonymousClass1.setAnimationListener(new AnimationListener(this) {
            final /* synthetic */ l CB;

            public final void onAnimationStart(Animation animation) {
                this.CB.Cw = 0.0f;
            }

            public final void onAnimationEnd(Animation animation) {
            }

            public final void onAnimationRepeat(Animation animation) {
                aVar.cu();
                a aVar = aVar;
                aVar.ah(aVar.ct());
                aVar.x(aVar.CF);
                if (this.CB.Cz) {
                    this.CB.Cz = false;
                    animation.setDuration(1332);
                    aVar.v(false);
                    return;
                }
                this.CB.Cw = (this.CB.Cw + 1.0f) % 5.0f;
            }
        });
        this.mAnimation = anonymousClass1;
    }

    public final void u(boolean z) {
        this.Ct.v(z);
    }

    public final void v(float f) {
        a aVar = this.Ct;
        if (f != aVar.CO) {
            aVar.CO = f;
            aVar.invalidateSelf();
        }
    }

    public final void w(float f) {
        this.Ct.x(0.0f);
        this.Ct.y(f);
    }

    public final int getIntrinsicHeight() {
        return (int) this.Cy;
    }

    public final int getIntrinsicWidth() {
        return (int) this.Cx;
    }

    public final void draw(Canvas canvas) {
        Rect bounds = getBounds();
        int save = canvas.save();
        canvas.rotate(this.fF, bounds.exactCenterX(), bounds.exactCenterY());
        a aVar = this.Ct;
        RectF rectF = aVar.CC;
        rectF.set(bounds);
        rectF.inset(aVar.CG, aVar.CG);
        float f = 360.0f * (aVar.CE + aVar.fF);
        float f2 = ((aVar.CF + aVar.fF) * 360.0f) - f;
        aVar.fu.setColor(aVar.tQ);
        canvas.drawArc(rectF, f, f2, false, aVar.fu);
        if (aVar.CM) {
            if (aVar.CN == null) {
                aVar.CN = new Path();
                aVar.CN.setFillType(FillType.EVEN_ODD);
            } else {
                aVar.CN.reset();
            }
            float f3 = ((float) (((int) aVar.CG) / 2)) * aVar.CO;
            float cos = (float) ((aVar.CP * Math.cos(0.0d)) + ((double) bounds.exactCenterX()));
            float sin = (float) ((aVar.CP * Math.sin(0.0d)) + ((double) bounds.exactCenterY()));
            aVar.CN.moveTo(0.0f, 0.0f);
            aVar.CN.lineTo(((float) aVar.CQ) * aVar.CO, 0.0f);
            aVar.CN.lineTo((((float) aVar.CQ) * aVar.CO) / 2.0f, ((float) aVar.CR) * aVar.CO);
            aVar.CN.offset(cos - f3, sin);
            aVar.CN.close();
            aVar.CD.setColor(aVar.tQ);
            canvas.rotate((f + f2) - 5.0f, bounds.exactCenterX(), bounds.exactCenterY());
            canvas.drawPath(aVar.CN, aVar.CD);
        }
        if (aVar.CS < 255) {
            aVar.CT.setColor(aVar.CU);
            aVar.CT.setAlpha(255 - aVar.CS);
            canvas.drawCircle(bounds.exactCenterX(), bounds.exactCenterY(), (float) (bounds.width() / 2), aVar.CT);
        }
        canvas.restoreToCount(save);
    }

    public final void setAlpha(int i) {
        this.Ct.CS = i;
    }

    public final int getAlpha() {
        return this.Ct.CS;
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        a aVar = this.Ct;
        aVar.fu.setColorFilter(colorFilter);
        aVar.invalidateSelf();
    }

    final void setRotation(float f) {
        this.fF = f;
        invalidateSelf();
    }

    public final int getOpacity() {
        return -3;
    }

    public final boolean isRunning() {
        ArrayList arrayList = this.mc;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Animation animation = (Animation) arrayList.get(i);
            if (animation.hasStarted() && !animation.hasEnded()) {
                return true;
            }
        }
        return false;
    }

    public final void start() {
        this.mAnimation.reset();
        this.Ct.cu();
        if (this.Ct.CF != this.Ct.CE) {
            this.Cz = true;
            this.mAnimation.setDuration(666);
            this.Cv.startAnimation(this.mAnimation);
            return;
        }
        this.Ct.ah(0);
        this.Ct.cv();
        this.mAnimation.setDuration(1332);
        this.Cv.startAnimation(this.mAnimation);
    }

    public final void stop() {
        this.Cv.clearAnimation();
        setRotation(0.0f);
        this.Ct.v(false);
        this.Ct.ah(0);
        this.Ct.cv();
    }

    private static float a(a aVar) {
        return (float) Math.toRadians(((double) aVar.mw) / (6.283185307179586d * aVar.CP));
    }

    private static void a(float f, a aVar) {
        if (f > 0.75f) {
            float f2 = (f - 0.75f) / 0.25f;
            int i = aVar.CH[aVar.CI];
            int i2 = aVar.CH[aVar.ct()];
            i = Integer.valueOf(i).intValue();
            int i3 = (i >> 24) & 255;
            int i4 = (i >> 16) & 255;
            int i5 = (i >> 8) & 255;
            i &= 255;
            i2 = Integer.valueOf(i2).intValue();
            aVar.tQ = (((int) (f2 * ((float) ((i2 & 255) - i)))) + i) | ((((i3 + ((int) (((float) (((i2 >> 24) & 255) - i3)) * f2))) << 24) | ((i4 + ((int) (((float) (((i2 >> 16) & 255) - i4)) * f2))) << 16)) | ((((int) (((float) (((i2 >> 8) & 255) - i5)) * f2)) + i5) << 8));
        }
    }
}
