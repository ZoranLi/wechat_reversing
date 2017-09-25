package com.tencent.mm.plugin.appbrand.widget.d;

import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import com.tencent.mapsdk.raster.model.IOverlay;

public abstract class e {
    IOverlay jyb;
    AnimatorSet jyc = new AnimatorSet();
    long mDuration;

    protected abstract ValueAnimator iY(int i);

    protected e(IOverlay iOverlay, long j) {
        this.jyb = iOverlay;
        this.mDuration = j;
    }

    public void ZB() {
        this.jyc.start();
    }

    public final void a(AnimatorListener animatorListener) {
        this.jyc.addListener(animatorListener);
    }
}
