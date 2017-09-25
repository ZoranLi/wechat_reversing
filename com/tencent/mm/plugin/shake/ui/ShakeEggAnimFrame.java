package com.tencent.mm.plugin.shake.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mm.bi.c;
import com.tencent.mm.bi.g;
import com.tencent.mm.plugin.gif.MMGIFException;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

public class ShakeEggAnimFrame extends FrameLayout {
    List<View> pqM = new ArrayList();
    int pqN = 0;
    int size = 0;

    abstract class a extends Animation {
        protected int duration = 100;
        final /* synthetic */ ShakeEggAnimFrame pqO;
        View targetView;

        a(ShakeEggAnimFrame shakeEggAnimFrame) {
            this.pqO = shakeEggAnimFrame;
        }
    }

    class b extends a {
        private int jVq;
        private int jVr;
        final /* synthetic */ ShakeEggAnimFrame pqO;
        private float pqQ;
        private float pqR;
        private float pqS;
        private float pqT;
        private float pqU = 0.01f;
        private float pqV = 0.02f;
        private float pqW;
        private float pqX;
        private float pqY;
        private float pqZ;

        public b(ShakeEggAnimFrame shakeEggAnimFrame, int i, int i2) {
            this.pqO = shakeEggAnimFrame;
            super(shakeEggAnimFrame);
            this.jVq = i;
            this.jVr = i2;
            this.pqQ = ShakeEggAnimFrame.m(0.1f, 0.9f);
            this.pqR = this.pqQ;
            this.pqT = ShakeEggAnimFrame.m(-0.3f, -0.1f);
            restart();
        }

        protected final void applyTransformation(float f, Transformation transformation) {
            float f2 = this.pqW;
            float f3 = this.pqY;
            if (this.pqW != this.pqX) {
                f2 = this.pqW + ((this.pqX - this.pqW) * f);
            }
            if (this.pqY != this.pqZ) {
                f3 = this.pqY + ((this.pqZ - this.pqY) * f);
            }
            transformation.getMatrix().setTranslate(f2, f3);
            if (f == 1.0f) {
                restart();
            }
        }

        private void restart() {
            if (this.pqT > 0.0f) {
                this.pqV += this.pqU;
            }
            this.pqS = this.pqT;
            this.pqT += this.pqV;
            if (this.pqS > 1.1f) {
                Assert.assertTrue(this.targetView != null);
                this.targetView.post(new Runnable(this) {
                    final /* synthetic */ a pqP;

                    {
                        this.pqP = r1;
                    }

                    public final void run() {
                        if (this.pqP.targetView != null) {
                            this.pqP.targetView.clearAnimation();
                            ShakeEggAnimFrame shakeEggAnimFrame = this.pqP.pqO;
                            View view = this.pqP.targetView;
                            shakeEggAnimFrame.pqM.remove(view);
                            shakeEggAnimFrame.removeView(view);
                        }
                    }
                });
            }
            this.pqW = this.pqQ * ((float) this.jVq);
            this.pqX = this.pqR * ((float) this.jVq);
            this.pqY = this.pqS * ((float) this.jVr);
            this.pqZ = this.pqT * ((float) this.jVr);
        }

        public final void initialize(int i, int i2, int i3, int i4) {
            super.initialize(i, i2, i3, i4);
            setRepeatCount(-1);
            setDuration((long) this.duration);
        }
    }

    public ShakeEggAnimFrame(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void P(Activity activity) {
        for (View view : this.pqM) {
            view.clearAnimation();
            removeView(view);
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        setVisibility(0);
        for (int i = 0; i < 30; i++) {
            Animation bVar = new b(this, displayMetrics.widthPixels, displayMetrics.heightPixels);
            g.bKH();
            com.tencent.mm.bi.b bKy = com.tencent.mm.bi.b.bKy();
            Drawable a = bKy.a((c) bKy.uyf.get(MMGIFException.D_GIF_ERR_WRONG_RECORD));
            a.setBounds(0, 0, getSize(), getSize());
            ImageSpan imageSpan = new ImageSpan(a, 1);
            CharSequence spannableString = new SpannableString("  ");
            spannableString.setSpan(imageSpan, 0, 1, 33);
            View textView = new TextView(getContext());
            textView.setSingleLine();
            textView.setText(spannableString);
            textView.setAnimation(bVar);
            textView.setTag(bVar);
            addView(textView);
            ((a) bVar).targetView = textView;
            this.pqM.add(textView);
        }
    }

    static float m(float f, float f2) {
        return (((float) Math.random()) * (f2 - f)) + f;
    }

    private int getSize() {
        if (this.size == 0) {
            return (int) (((double) new TextView(getContext()).getTextSize()) * 1.2d);
        }
        return this.size;
    }
}
