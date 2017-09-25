package com.tencent.mm.plugin.bottle.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ImageView;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.a;

public class BallonImageView extends ImageView {
    private Animation jVp = new Animation(this) {
        private float jVA;
        private float jVB;
        final /* synthetic */ BallonImageView jVC;
        private int jVq;
        private int jVr;
        private float jVs = 0.1f;
        private float jVt = AnonymousClass1.m(0.1f, 0.8f);
        private float jVu = 0.1f;
        private float jVv = AnonymousClass1.m(0.1f, 0.3f);
        private float jVw = 1.0f;
        private float jVx = AnonymousClass1.m(0.7f, 1.0f);
        private float jVy;
        private float jVz;

        {
            this.jVC = r4;
        }

        protected final void applyTransformation(float f, Transformation transformation) {
            float f2 = this.jVy;
            float f3 = this.jVA;
            if (this.jVy != this.jVz) {
                f2 = this.jVy + ((this.jVz - this.jVy) * f);
            }
            if (this.jVA != this.jVB) {
                f3 = this.jVA + ((this.jVB - this.jVA) * f);
            }
            transformation.getMatrix().setTranslate(f2, f3);
            f2 = this.jVw + ((this.jVx - this.jVw) * f);
            transformation.getMatrix().postScale(f2, f2);
            if (f == 1.0f) {
                this.jVs = this.jVt;
                this.jVu = this.jVv;
                this.jVt = AnonymousClass1.m(0.1f, 0.8f);
                this.jVv = AnonymousClass1.m(0.1f, 0.3f);
                this.jVw = this.jVx;
                this.jVx = AnonymousClass1.m(0.7f, 1.0f);
                ady();
            }
        }

        public final void initialize(int i, int i2, int i3, int i4) {
            super.initialize(i, i2, i3, i4);
            this.jVq = i3;
            this.jVr = i4;
            ady();
        }

        private void ady() {
            this.jVy = this.jVs * ((float) this.jVq);
            this.jVz = this.jVt * ((float) this.jVq);
            this.jVA = this.jVu * ((float) this.jVr);
            this.jVB = this.jVv * ((float) this.jVr);
        }

        private static float m(float f, float f2) {
            return (((float) Math.random()) * (f2 - f)) + f;
        }
    };

    public BallonImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jVp.setRepeatCount(-1);
        this.jVp.setDuration(15000);
        this.jVp.setFillAfter(true);
    }

    public BallonImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jVp.setRepeatCount(-1);
        this.jVp.setDuration(15000);
        this.jVp.setFillAfter(true);
    }

    public void setVisibility(int i) {
        if (i == 0) {
            setAnimation(this.jVp);
        } else {
            a.c(this, this.jVp);
        }
        super.setVisibility(i);
    }
}
