package com.tencent.mm.plugin.appbrand.widget.d;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.animation.LinearInterpolator;
import com.tencent.mapsdk.raster.model.Marker;

public final class c extends e {
    private float jxO;
    private float jxP;

    public c(Marker marker, long j, float f, float f2) {
        super(marker, j);
        this.jxO = f;
        this.jxP = f2;
        this.jyc.play(iY(0));
    }

    protected final ValueAnimator iY(int i) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{this.jxO, this.jxP});
        ofFloat.setDuration(this.mDuration);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.addUpdateListener(new AnimatorUpdateListener(this) {
            final /* synthetic */ c jxQ;

            {
                this.jxQ = r1;
            }

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ((Marker) this.jxQ.jyb).setRotation((float) Double.parseDouble(String.valueOf(valueAnimator.getAnimatedValue())));
            }
        });
        return ofFloat;
    }
}
