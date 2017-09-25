package com.tencent.mm.plugin.bottle.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.l.e;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Random;

public class SprayLayout extends FrameLayout {
    private ae handler;
    private ImageView jXQ;
    private ImageView jXR;
    private ImageView jXS;
    Animation jXT;
    Animation jXU;
    Animation jXV;
    Animation jXW;
    Animation jXX;
    AnimationSet jXY;
    AnimationSet jXZ;
    AnimationSet jYa;
    private int jYb;
    private int jYc;
    private int jYd;
    private int jYe;
    private int jYf;
    private int jYg;
    private Runnable jYh;
    private int repeatCount;

    static /* synthetic */ void d(SprayLayout sprayLayout) {
        int i = -1;
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) sprayLayout.getLayoutParams();
        FrameLayout frameLayout = (FrameLayout) sprayLayout.getParent();
        if (marginLayoutParams != null && frameLayout != null) {
            if (sprayLayout.jYd == -1 && sprayLayout.jYe == -1) {
                Random random = new Random();
                int nextInt = (random.nextBoolean() ? 1 : -1) * random.nextInt(sprayLayout.jYf);
                int sqrt = (int) Math.sqrt((double) (((((sprayLayout.jYf * sprayLayout.jYf) - (nextInt * nextInt)) * sprayLayout.jYg) * sprayLayout.jYg) / (sprayLayout.jYf * sprayLayout.jYf)));
                if (random.nextBoolean()) {
                    i = 1;
                }
                marginLayoutParams.setMargins(nextInt, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, ((frameLayout.getHeight() * e.CTRL_INDEX) / 800) + (random.nextInt(Math.max(sqrt, 1)) * i));
            } else {
                marginLayoutParams.setMargins(sprayLayout.jYd - (frameLayout.getWidth() / 2), marginLayoutParams.topMargin, marginLayoutParams.rightMargin, frameLayout.getHeight() - sprayLayout.jYe);
            }
            sprayLayout.setLayoutParams(marginLayoutParams);
        }
    }

    static /* synthetic */ int k(SprayLayout sprayLayout) {
        int i = sprayLayout.jYb + 1;
        sprayLayout.jYb = i;
        return i;
    }

    public SprayLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SprayLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jXT = new ScaleAnimation(0.6f, 0.8f, 0.6f, 0.8f, 1, 0.5f, 1, 1.0f);
        this.jXU = new AlphaAnimation(0.2f, 1.0f);
        this.jXV = new ScaleAnimation(0.8f, 1.27f, 0.8f, 1.27f, 1, 0.5f, 1, 1.0f);
        this.jXW = new AlphaAnimation(1.0f, 0.5f);
        this.jXX = new ScaleAnimation(0.8f, 1.0f, 0.8f, 1.0f, 1, 0.5f, 1, 1.0f);
        this.jXY = new AnimationSet(true);
        this.jXZ = new AnimationSet(true);
        this.jYa = new AnimationSet(true);
        this.jXT.setDuration(280);
        this.jXU.setDuration(280);
        this.jXV.setDuration(280);
        this.jXW.setDuration(280);
        this.jXY.addAnimation(this.jXT);
        this.jXY.addAnimation(this.jXU);
        this.jXY.setRepeatCount(1);
        this.jXY.setDuration(280);
        this.jXZ.addAnimation(this.jXV);
        this.jXZ.setRepeatCount(1);
        this.jXZ.setDuration(280);
        this.jYa.addAnimation(this.jXX);
        this.jYa.setRepeatCount(1);
        this.jYa.setDuration(280);
        this.jYb = 0;
        this.repeatCount = 1;
        this.jYd = -1;
        this.jYe = -1;
        this.handler = new ae();
        this.jYh = new Runnable(this) {
            final /* synthetic */ SprayLayout jYi;

            {
                this.jYi = r1;
            }

            public final void run() {
                if (this.jYi.jYb == 0) {
                    this.jYi.jYc = this.jYi.jYc + 1;
                    this.jYi.jXS.clearAnimation();
                    this.jYi.jXS.setVisibility(8);
                    SprayLayout.d(this.jYi);
                } else if (this.jYi.jYb == 1) {
                    this.jYi.jXQ.startAnimation(this.jYi.jXY);
                    this.jYi.jXQ.setVisibility(0);
                    this.jYi.jXR.setVisibility(8);
                    this.jYi.jXS.setVisibility(8);
                } else if (this.jYi.jYb == 2) {
                    this.jYi.jXQ.startAnimation(this.jYi.jXZ);
                    this.jYi.jXR.startAnimation(this.jYi.jXY);
                    this.jYi.jXR.setVisibility(0);
                } else if (this.jYi.jYb == 3) {
                    this.jYi.jXQ.clearAnimation();
                    this.jYi.jXQ.setVisibility(8);
                    this.jYi.jXR.startAnimation(this.jYi.jXZ);
                    this.jYi.jXS.startAnimation(this.jYi.jXY);
                    this.jYi.jXS.setVisibility(0);
                } else if (this.jYi.jYb == 4) {
                    this.jYi.jXS.startAnimation(this.jYi.jYa);
                    this.jYi.jXR.clearAnimation();
                    this.jYi.jXR.setVisibility(8);
                }
                if (this.jYi.jYc > this.jYi.repeatCount) {
                    this.jYi.stop();
                    return;
                }
                this.jYi.handler.postDelayed(this.jYi.jYh, 280);
                this.jYi.jYb = SprayLayout.k(this.jYi) % 5;
            }
        };
    }

    public final void x(int i, int i2, int i3) {
        this.jYb = 0;
        this.repeatCount = i;
        this.jYc = 0;
        this.jYd = i2;
        this.jYe = i3;
        if (this.jXQ == null) {
            this.jXQ = (ImageView) findViewById(R.h.buv);
            this.jXR = (ImageView) findViewById(R.h.bux);
            this.jXS = (ImageView) findViewById(R.h.buw);
            DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
            this.jYf = (displayMetrics.widthPixels * 35) / 96;
            this.jYg = displayMetrics.heightPixels / 16;
        }
        this.jXQ.setVisibility(8);
        this.jXR.setVisibility(8);
        this.jXS.setVisibility(8);
        setVisibility(0);
        this.handler.removeCallbacks(this.jYh);
        this.handler.postDelayed(this.jYh, 0);
    }

    public final void stop() {
        this.handler.removeCallbacks(this.jYh);
        setVisibility(8);
    }
}
