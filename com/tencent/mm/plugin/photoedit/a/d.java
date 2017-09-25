package com.tencent.mm.plugin.photoedit.a;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Rect;
import android.graphics.RectF;
import com.tencent.mm.plugin.photoedit.d.b;

public final class d extends b {
    public float gj = 1.0f;
    public ValueAnimator oiP;
    public b ojg;
    public float ojh;
    public float oji;
    public boolean ojj = true;
    public boolean ojk = false;

    class AnonymousClass1 implements AnimatorUpdateListener {
        float miO = ((float) Math.pow((double) (this.ojm.gj / this.ojl), 0.25d));
        float oiU = 0.0f;
        float oiV = 0.0f;
        int oja = 0;
        final /* synthetic */ float ojl;
        final /* synthetic */ d ojm;

        public AnonymousClass1(d dVar, float f) {
            this.ojm = dVar;
            this.ojl = f;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            float f;
            float f2 = 0.0f;
            float floatValue = ((Float) valueAnimator.getAnimatedValue("deltaY")).floatValue();
            float floatValue2 = ((Float) valueAnimator.getAnimatedValue("deltaX")).floatValue();
            if (this.oja < 4 && this.ojm.ojj) {
                this.ojm.ojg.ojv.postScale(this.miO, this.miO);
                this.oja++;
            }
            RectF aSA = this.ojm.ojg.aSA();
            Rect rect = this.ojm.ojg.old;
            if (this.ojm.ojk) {
                if (aSA.top > ((float) rect.top)) {
                    f = ((float) rect.top) - aSA.top;
                } else {
                    f = 0.0f;
                }
                if (aSA.right < ((float) rect.right)) {
                    f2 = ((float) rect.right) - aSA.right;
                }
                if (aSA.bottom < ((float) rect.bottom)) {
                    f = ((float) rect.bottom) - aSA.bottom;
                }
                if (aSA.left > ((float) rect.left)) {
                    f2 = ((float) rect.left) - aSA.left;
                }
            } else {
                d dVar = this.ojm;
                dVar.ojh += floatValue2 - this.oiV;
                dVar = this.ojm;
                dVar.oji += floatValue - this.oiU;
                f2 = this.ojm.ojh - aSA.centerX();
                f = this.ojm.oji - aSA.centerY();
            }
            this.ojm.ojg.ojv.postTranslate(f2, f);
            this.ojm.ojg.postInvalidate();
            this.oiU = floatValue;
            this.oiV = floatValue2;
        }
    }

    public d(b bVar) {
        this.ojg = bVar;
    }
}
