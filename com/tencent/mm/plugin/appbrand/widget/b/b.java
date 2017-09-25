package com.tencent.mm.plugin.appbrand.widget.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import com.tencent.mm.R;
import java.util.LinkedList;

public final class b extends FrameLayout {
    public final c jsa = new c(this);
    public final LinkedList<a> jsb = new LinkedList();
    private final Runnable jsc = new Runnable(this) {
        final /* synthetic */ b jsf;

        {
            this.jsf = r1;
        }

        public final void run() {
            this.jsf.removeAllViews();
            this.jsf.setVisibility(8);
        }
    };
    private a jsd;
    public a jse;
    public final OnClickListener mOnClickListener = new OnClickListener(this) {
        final /* synthetic */ b jsf;

        {
            this.jsf = r1;
        }

        public final void onClick(View view) {
            if (view == this.jsf) {
                b.a(this.jsf);
            }
        }
    };

    static /* synthetic */ void a(b bVar) {
        a aVar = (a) bVar.jsb.peekLast();
        if (aVar == null) {
            bVar.setVisibility(8);
        } else if (aVar.jrY) {
            aVar.onCancel();
            bVar.b(aVar);
        }
    }

    public b(Context context) {
        super(context);
        setVisibility(8);
        setBackgroundColor(0);
        setOnClickListener(this.mOnClickListener);
    }

    public final void b(final a aVar) {
        if (aVar.getContentView().getParent() == this && this.jsd != aVar) {
            this.jsd = aVar;
            final View contentView = aVar.getContentView();
            contentView.animate().cancel();
            contentView.clearAnimation();
            TimeInterpolator loadInterpolator = AnimationUtils.loadInterpolator(contentView.getContext(), R.a.aQR);
            TimeInterpolator loadInterpolator2 = AnimationUtils.loadInterpolator(contentView.getContext(), R.a.aQQ);
            Animator animatorSet = new AnimatorSet();
            r4 = new Animator[3];
            Animator duration = ObjectAnimator.ofFloat(contentView, "scaleX", new float[]{1.0f, 0.9f}).setDuration(220);
            duration.setInterpolator(loadInterpolator);
            r4[0] = duration;
            duration = ObjectAnimator.ofFloat(contentView, "scaleY", new float[]{1.0f, 0.9f}).setDuration(220);
            duration.setInterpolator(loadInterpolator);
            r4[1] = duration;
            Animator duration2 = ObjectAnimator.ofFloat(contentView, "alpha", new float[]{1.0f, 0.0f}).setDuration(150);
            duration2.setInterpolator(loadInterpolator2);
            r4[2] = duration2;
            animatorSet.playTogether(r4);
            animatorSet.addListener(new AnimatorListenerAdapter(this) {
                final /* synthetic */ b jsf;

                public final void onAnimationCancel(Animator animator) {
                    onAnimationEnd(animator);
                }

                public final void onAnimationEnd(Animator animator) {
                    contentView.setVisibility(8);
                    this.jsf.removeView(contentView);
                    this.jsf.jsb.remove(aVar);
                    this.jsf.jsd = null;
                }
            });
            animatorSet.start();
            if (this.jsb.size() <= 1) {
                this.jsa.a(0, this.jsc);
            }
        }
    }

    public static void bK(View view) {
        if (view != null && view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
    }
}
