package com.tencent.mm.plugin.appbrand.widget.b;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.drawable.ColorDrawable;
import android.view.View;

public final class c {
    private int jsi;
    public ValueAnimator jsj;
    public View view;

    public c(View view) {
        this.view = view;
    }

    public final void a(int i, final Runnable runnable) {
        if (this.view != null) {
            this.jsi = i;
            if ((this.view.getBackground() instanceof ColorDrawable) && ((ColorDrawable) this.view.getBackground()).getColor() == i) {
                if (runnable != null) {
                    runnable.run();
                }
                if (this.jsj != null) {
                    this.jsj.cancel();
                    return;
                }
                return;
            }
            AnimatorListener anonymousClass1 = new AnimatorListenerAdapter(this) {
                final /* synthetic */ c jsl;

                public final void onAnimationCancel(Animator animator) {
                    this.jsl.jsj = null;
                }

                public final void onAnimationEnd(Animator animator) {
                    if (runnable != null) {
                        runnable.run();
                    }
                    this.jsl.jsj = null;
                }
            };
            if (this.jsj != null && this.jsj.isStarted() && this.jsj.isRunning() && this.jsi == i) {
                this.jsj.addListener(anonymousClass1);
                return;
            }
            if (this.jsj != null) {
                this.jsj.cancel();
            }
            int color = this.view.getBackground() instanceof ColorDrawable ? ((ColorDrawable) this.view.getBackground()).getColor() : 0;
            this.jsj = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{Integer.valueOf(color), Integer.valueOf(this.jsi)});
            this.jsj.addListener(anonymousClass1);
            this.jsj.addUpdateListener(new AnimatorUpdateListener(this) {
                final /* synthetic */ c jsl;

                {
                    this.jsl = r1;
                }

                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if (this.jsl.view != null) {
                        this.jsl.view.setBackgroundColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
                    }
                }
            });
            this.jsj.start();
        }
    }
}
