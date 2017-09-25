package com.tencent.mm.plugin.appbrand.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.e.c;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.widget.a;
import com.tencent.mm.plugin.appbrand.widget.b;
import com.tencent.mm.plugin.appbrand.widget.i;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import com.tencent.smtt.sdk.WebView;

@SuppressLint({"ViewConstructor"})
public final class d extends i implements h {
    private h ixr;
    private ThreeDotsLoadingView jhp;
    private ImageView jkB = ((ImageView) findViewById(R.h.bpd));
    private TextView jkC;
    private int jkD;
    private int jkE;
    private ViewGroup jkF;
    private View jkG;
    private LinearLayout jkH;
    private a jkI;
    private View jkJ;

    public d(Context context, h hVar) {
        super(context);
        this.ixr = hVar;
        setClickable(true);
        setLayoutParams(new LayoutParams(-1, -1));
        LayoutInflater.from(getContext()).inflate(R.i.cUu, this);
        this.jkB.setImageDrawable(com.tencent.mm.modelappbrand.a.a.AX());
        this.jkC = (TextView) findViewById(R.h.bpg);
        this.jhp = (ThreeDotsLoadingView) findViewById(R.h.bpi);
        this.jkF = (ViewGroup) findViewById(R.h.bph);
        this.jkG = findViewById(R.h.bpe);
        this.jkH = (LinearLayout) findViewById(R.h.bpf);
        this.jkI = new a(getContext());
        this.jkH.addView(this.jkI);
        this.jkJ = this.jkI.findViewById(R.h.bnb);
        this.jkC.getLayoutParams().height = b.bG(getContext());
        C(-1, true);
        this.jkI.setBackgroundColor(0);
        this.jkI.rh("black");
        this.jkI.cn(false);
        this.jkI.jqm = new OnClickListener(this) {
            final /* synthetic */ d jkK;

            {
                this.jkK = r1;
            }

            public final void onClick(View view) {
                e.a(this.jkK.ixr.ivH, c.CLOSE);
                this.jkK.ixr.finish();
            }
        };
        this.jhp.caQ();
    }

    public final void bh(String str, String str2) {
        com.tencent.mm.modelappbrand.a.b.AY().a(this.jkB, str, null, com.tencent.mm.modelappbrand.a.e.hqF);
        this.jkC.setText(str2);
    }

    public final void WT() {
        post(new Runnable(this) {
            final /* synthetic */ d jkK;

            {
                this.jkK = r1;
            }

            public final void run() {
                final ViewParent parent = this.jkK.getParent();
                if (parent instanceof ViewGroup) {
                    i iVar = this.jkK;
                    int a = this.jkK.jkE;
                    if (i.jrv) {
                        iVar.C(a, g.b(iVar.qb.getWindow()));
                    }
                    ViewPropertyAnimator animate = this.jkK.animate();
                    animate.setStartDelay((long) (((float) animate.getDuration()) * 0.8f));
                    animate.setDuration((long) (((float) animate.getDuration()) * 0.2f));
                    animate.setListener(new AnimatorListenerAdapter(this) {
                        final /* synthetic */ AnonymousClass1 jkM;

                        public final void onAnimationEnd(Animator animator) {
                            this.jkM.jkK.setVisibility(8);
                            ((ViewGroup) parent).removeView(this.jkM.jkK);
                        }
                    });
                    animate.alpha(0.0f).start();
                    this.jkK.jkB.animate().scaleX(0.0f).scaleY(0.0f).translationY((float) (-(this.jkK.jkB.getHeight() / 2))).setInterpolator(new DecelerateInterpolator()).start();
                    this.jkK.jkC.animate().translationX((float) (this.jkK.jkJ.getLeft() - this.jkK.jkC.getLeft())).translationY((float) (-this.jkK.jkC.getTop())).setInterpolator(new DecelerateInterpolator()).start();
                    this.jkK.jhp.animate().alpha(0.0f).translationY((float) (-this.jkK.jhp.getTop())).setInterpolator(new DecelerateInterpolator()).start();
                    this.jkK.jkG.animate().scaleY(((float) ((this.jkK.getHeight() - this.jkK.getPaddingTop()) - this.jkK.jkI.getHeight())) / ((float) this.jkK.jkG.getHeight())).translationY((float) (-((((this.jkK.getHeight() - this.jkK.getPaddingTop()) - this.jkK.jkI.getHeight()) - this.jkK.jkG.getHeight()) / 2))).setInterpolator(new DecelerateInterpolator()).start();
                    ValueAnimator ofObject = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{Integer.valueOf(-1), Integer.valueOf(this.jkK.jkE)});
                    ofObject.addUpdateListener(new AnimatorUpdateListener(this) {
                        final /* synthetic */ AnonymousClass1 jkM;

                        {
                            this.jkM = r1;
                        }

                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            this.jkM.jkK.jkF.setBackgroundColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    ofObject.setInterpolator(new DecelerateInterpolator());
                    ofObject.start();
                    ofObject = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{Integer.valueOf(WebView.NIGHT_MODE_COLOR), Integer.valueOf(this.jkK.jkD)});
                    ofObject.addUpdateListener(new AnimatorUpdateListener(this) {
                        final /* synthetic */ AnonymousClass1 jkM;

                        {
                            this.jkM = r1;
                        }

                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            this.jkM.jkK.jkC.setTextColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    ofObject.setInterpolator(new DecelerateInterpolator());
                    ofObject.start();
                }
            }
        });
    }

    public final void WU() {
        this.jkI.co(true);
    }

    public final void a(com.tencent.mm.plugin.appbrand.config.a.c cVar) {
        this.jkE = com.tencent.mm.plugin.webview.ui.tools.d.cd(cVar.iEc, -1);
        if ("white".equals(cVar.iEb)) {
            this.jkD = -1;
        } else {
            this.jkD = WebView.NIGHT_MODE_COLOR;
        }
    }

    public final View getView() {
        return this;
    }
}
