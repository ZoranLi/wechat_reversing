package com.tencent.mm.plugin.appbrand.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;

public final class h extends Drawable {
    private static final RectF jrk = new RectF(-21.0f, -21.0f, 21.0f, 21.0f);
    private static final RectF jrl = new RectF(-19.0f, -19.0f, 19.0f, 19.0f);
    private Paint fu;
    private int jrm = Math.round(ab.getResources().getDisplayMetrics().density * 48.0f);
    private int jrn = 4;
    private boolean jro = false;
    private int jrp = 0;
    b jrq = new b();
    c jrr = new c();
    ArrayList<Animator> mc = new ArrayList();
    int mv = WebView.NIGHT_MODE_COLOR;

    private static class a {
        public static final Interpolator jrs = new LinearInterpolator();
    }

    private static class b {
        public float mB = 0.0f;
        public float mC = 0.0f;
        public float mD = 0.0f;

        @android.support.a.a
        public final void setTrimPathStart(float f) {
            this.mB = f;
        }

        @android.support.a.a
        public final void setTrimPathEnd(float f) {
            this.mC = f;
        }

        @android.support.a.a
        public final void setTrimPathOffset(float f) {
            this.mD = f;
        }
    }

    private static class c {
        public float fF;

        @android.support.a.a
        public final void setRotation(float f) {
            this.fF = f;
        }
    }

    private static class d {
        public static final Interpolator jrs = android.support.v4.view.b.e.b(jrt);
        private static final Path jrt;

        static {
            Path path = new Path();
            jrt = path;
            path.cubicTo(0.2f, 0.0f, 0.1f, 1.0f, 0.5f, 1.0f);
            jrt.lineTo(1.0f, 1.0f);
        }
    }

    private static class e {
        public static final Interpolator jrs = android.support.v4.view.b.e.b(jru);
        private static final Path jru;

        static {
            Path path = new Path();
            jru = path;
            path.lineTo(0.5f, 0.0f);
            jru.cubicTo(0.7f, 0.0f, 0.6f, 1.0f, 1.0f, 1.0f);
        }
    }

    public final int getIntrinsicWidth() {
        return this.jrm;
    }

    public final int getIntrinsicHeight() {
        return this.jrm;
    }

    public final void draw(Canvas canvas) {
        Rect bounds = getBounds();
        if (bounds.width() != 0 && bounds.height() != 0) {
            int save;
            if (this.fu == null) {
                this.fu = new Paint();
                this.fu.setAntiAlias(true);
                this.fu.setStyle(Style.STROKE);
                this.fu.setStrokeWidth((float) this.jrn);
                this.fu.setStrokeCap(Cap.SQUARE);
                this.fu.setStrokeJoin(Join.MITER);
            }
            int save2 = canvas.save();
            canvas.translate((float) bounds.left, (float) bounds.top);
            int width = bounds.width();
            int height = bounds.height();
            Paint paint = this.fu;
            canvas.scale(((float) width) / jrk.width(), ((float) height) / jrk.height());
            canvas.translate(jrk.width() / 2.0f, jrk.height() / 2.0f);
            if (this.jro) {
                save = canvas.save();
                paint.setColor(this.jrp);
                canvas.drawArc(jrl, 0.0f, 360.0f, false, paint);
                canvas.restoreToCount(save);
            }
            save = canvas.save();
            paint.setColor(this.mv);
            canvas.rotate(this.jrr.fF);
            Canvas canvas2 = canvas;
            canvas2.drawArc(jrl, -90.0f + ((this.jrq.mD + this.jrq.mB) * 360.0f), 360.0f * (this.jrq.mC - this.jrq.mB), false, paint);
            canvas.restoreToCount(save);
            canvas.restoreToCount(save2);
        }
    }

    public final void setAlpha(int i) {
    }

    public final void setColorFilter(ColorFilter colorFilter) {
    }

    public final int getOpacity() {
        return -3;
    }

    static Animator a(b bVar) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(bVar, "trimPathStart", new float[]{0.0f, 0.75f});
        ofFloat.setDuration(1333);
        ofFloat.setInterpolator(e.jrs);
        ofFloat.setRepeatCount(-1);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(bVar, "trimPathEnd", new float[]{0.0f, 0.75f});
        ofFloat2.setDuration(1333);
        ofFloat2.setInterpolator(d.jrs);
        ofFloat2.setRepeatCount(-1);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(bVar, "trimPathOffset", new float[]{0.0f, 0.25f});
        ofFloat3.setDuration(1333);
        ofFloat3.setInterpolator(a.jrs);
        ofFloat3.setRepeatCount(-1);
        Animator animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2, ofFloat3});
        return animatorSet;
    }

    static Animator a(c cVar) {
        Animator ofFloat = ObjectAnimator.ofFloat(cVar, "rotation", new float[]{0.0f, 720.0f});
        ofFloat.setDuration(6665);
        ofFloat.setInterpolator(a.jrs);
        ofFloat.setRepeatCount(-1);
        return ofFloat;
    }
}
