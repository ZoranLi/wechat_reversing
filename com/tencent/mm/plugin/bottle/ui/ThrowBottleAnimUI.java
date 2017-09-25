package com.tencent.mm.plugin.bottle.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.AbsoluteLayout.LayoutParams;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

@SuppressLint({"HandlerLeak"})
public class ThrowBottleAnimUI extends FrameLayout {
    int Wx;
    int Wy;
    BottleBeachUI jXf;
    private SprayLayout jYj;
    private BottleImageView jYk;
    private TextView jYl;
    private AnimationSet jYm;
    private int jYn;
    private int jYo;
    private int jYp;
    private int jYq;
    int jYr;
    a jYs;
    boolean jYt;
    private ae jYu = new ae(this) {
        final /* synthetic */ ThrowBottleAnimUI jYv;

        {
            this.jYv = r1;
        }

        public final void handleMessage(Message message) {
            super.handleMessage(message);
            if (this.jYv.jYj == null && this.jYv.jXf != null) {
                this.jYv.jYj = (SprayLayout) this.jYv.jXf.findViewById(R.h.buu);
            }
            if (this.jYv.jYj != null) {
                this.jYv.jYj.stop();
            }
            if (this.jYv.jYs != null) {
                this.jYv.jYs.adN();
            }
        }
    };

    public interface a {
        void adN();
    }

    static /* synthetic */ void f(ThrowBottleAnimUI throwBottleAnimUI) {
        float f;
        int i;
        throwBottleAnimUI.jYl.setVisibility(0);
        if (throwBottleAnimUI.jYt) {
            throwBottleAnimUI.jYl.setBackgroundDrawable(com.tencent.mm.bg.a.a(throwBottleAnimUI.jXf, R.g.biL));
            throwBottleAnimUI.jYl.setWidth(throwBottleAnimUI.jYr);
            f = 1.0f;
            i = 120;
        } else {
            throwBottleAnimUI.jYl.setBackgroundDrawable(com.tencent.mm.bg.a.a(throwBottleAnimUI.jXf, R.g.bcT));
            f = 0.5f;
            i = 25;
        }
        throwBottleAnimUI.jYm = new AnimationSet(true);
        throwBottleAnimUI.jYm.setInterpolator(throwBottleAnimUI.jXf, 17432582);
        Animation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.0f, 1, 0.0f);
        scaleAnimation.setDuration(700);
        Animation rotateAnimation = new RotateAnimation(0.0f, (float) i, 1, f, 1, 1.0f);
        rotateAnimation.setDuration(700);
        int intrinsicWidth = throwBottleAnimUI.jYk.getBackground().getIntrinsicWidth() / 2;
        int intrinsicHeight = throwBottleAnimUI.jYk.getBackground().getIntrinsicHeight() / 2;
        int a = b.a(throwBottleAnimUI.jXf, 40.0f);
        w.v("MicroMsg.ThrowBottleAnimView", "tran from (" + throwBottleAnimUI.Wx + "," + throwBottleAnimUI.Wy + ") to (" + ((throwBottleAnimUI.adO() - a) - intrinsicWidth) + " , " + ((throwBottleAnimUI.adP() - a) - intrinsicHeight));
        Animation translateAnimation = new TranslateAnimation((float) throwBottleAnimUI.Wx, (float) ((throwBottleAnimUI.adO() - a) - intrinsicWidth), (float) throwBottleAnimUI.Wy, (float) ((throwBottleAnimUI.adP() - a) - intrinsicHeight));
        translateAnimation.setDuration(700);
        throwBottleAnimUI.jYm.addAnimation(rotateAnimation);
        throwBottleAnimUI.jYm.addAnimation(scaleAnimation);
        throwBottleAnimUI.jYm.addAnimation(translateAnimation);
        throwBottleAnimUI.jYm.setAnimationListener(new AnimationListener(throwBottleAnimUI) {
            final /* synthetic */ ThrowBottleAnimUI jYv;

            {
                this.jYv = r1;
            }

            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                this.jYv.jYl.setVisibility(8);
                this.jYv.adR();
            }
        });
    }

    public ThrowBottleAnimUI(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jXf = (BottleBeachUI) context;
        KC();
    }

    public ThrowBottleAnimUI(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jXf = (BottleBeachUI) context;
        KC();
    }

    public final void release() {
        this.jXf = null;
        this.jYm = null;
        this.jYj = null;
        if (this.jYk != null) {
            BottleImageView bottleImageView = this.jYk;
            bottleImageView.context = null;
            bottleImageView.jWx = null;
        }
        this.jYk = null;
        this.jYs = null;
    }

    public boolean isInEditMode() {
        return false;
    }

    private void KC() {
        inflate(this.jXf, R.i.cVW, this);
        this.jYk = (BottleImageView) findViewById(R.h.buB);
        this.jYl = (TextView) findViewById(R.h.buE);
        DisplayMetrics displayMetrics = this.jXf.getResources().getDisplayMetrics();
        this.jYp = displayMetrics.widthPixels;
        this.jYq = displayMetrics.heightPixels;
    }

    private int adO() {
        int abs = Math.abs(getWidth());
        if (abs <= 0) {
            return this.jYp;
        }
        return abs;
    }

    private int adP() {
        int abs = Math.abs(getHeight());
        if (abs <= 0) {
            return this.jYq;
        }
        return abs;
    }

    final void adQ() {
        this.jYk.setImageDrawable(null);
        int intrinsicWidth = this.jYk.getBackground().getIntrinsicWidth();
        int intrinsicHeight = this.jYk.getBackground().getIntrinsicHeight();
        this.jYk.setVisibility(0);
        int a = b.a(this.jXf, 40.0f);
        this.jYk.setLayoutParams(new LayoutParams(-2, -2, adO() - (intrinsicWidth + a), adP() - (intrinsicHeight + a)));
    }

    final void adR() {
        int intrinsicWidth = this.jYk.getBackground().getIntrinsicWidth();
        int intrinsicHeight = this.jYk.getBackground().getIntrinsicHeight();
        this.jYk.setVisibility(0);
        int a = b.a(this.jXf, 40.0f);
        setBackgroundDrawable(com.tencent.mm.bg.a.a(this.jXf, bg.bJR() ? R.g.bcN : R.g.bcO));
        if (this.jYt) {
            this.jYk.setImageDrawable(com.tencent.mm.bg.a.a(this.jXf, R.g.bcV));
        } else {
            this.jYk.setImageDrawable(com.tencent.mm.bg.a.a(this.jXf, R.g.bcU));
        }
        this.jYk.setLayoutParams(new LayoutParams(-2, -2, 0, 0));
        BottleImageView bottleImageView = this.jYk;
        int adO = adO() - (intrinsicWidth + a);
        intrinsicWidth = this.jYn - (intrinsicWidth / 2);
        a = adP() - (a + intrinsicHeight);
        intrinsicHeight = this.jYo - (intrinsicHeight / 2);
        AnimationListener anonymousClass3 = new AnimationListener(this) {
            final /* synthetic */ ThrowBottleAnimUI jYv;

            {
                this.jYv = r1;
            }

            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                this.jYv.jYk.setVisibility(8);
                if (this.jYv.jYj == null) {
                    this.jYv.jYj = (SprayLayout) this.jYv.jXf.findViewById(R.h.buu);
                }
                this.jYv.jYj.x(1, this.jYv.jYn, this.jYv.jYo);
                this.jYv.jYu.sendEmptyMessageDelayed(0, 2000);
            }
        };
        bottleImageView.Wx = adO;
        bottleImageView.Wz = intrinsicWidth;
        bottleImageView.Wy = a;
        bottleImageView.WA = intrinsicHeight;
        bottleImageView.jWx.setAnimationListener(anonymousClass3);
        bottleImageView.jWx.setDuration(2000);
        bottleImageView.jWx.setRepeatCount(0);
        bottleImageView.jWx.setStartOffset(500);
        bottleImageView.jWx.setInterpolator(bottleImageView.context, 17432582);
        bottleImageView.startAnimation(bottleImageView.jWx);
    }

    final void adS() {
        this.jYn = adO() / 2;
        this.jYo = (adP() * 460) / 800;
        w.v("MicroMsg.ThrowBottleAnimView", "to (" + this.jYn + "," + this.jYo + ")  bottle (" + this.jYk.getDrawable().getIntrinsicWidth() + "," + this.jYk.getDrawable().getIntrinsicHeight() + ")");
    }
}
