package com.tencent.mm.plugin.bottle.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ImageView;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;

public class BottleImageView extends ImageView {
    int WA;
    int Wx;
    int Wy;
    int Wz;
    Context context;
    private int jWv;
    private int jWw;
    Animation jWx = new Animation(this) {
        private float jVs = -1.0f;
        private float jVt = -1.0f;
        private float jVu = -1.0f;
        private float jVv = -1.0f;
        private float jVw = 1.0f;
        private float jVx = 0.1f;
        private float jWA;
        private float jWB;
        private float jWC;
        private boolean jWD = false;
        private float jWE = 0.0f;
        private float jWF = -850.0f;
        private float jWG = 1.0f;
        private float jWH = 0.3f;
        final /* synthetic */ BottleImageView jWI;
        private float jWy;
        private float jWz;

        {
            this.jWI = r4;
        }

        protected final void applyTransformation(float f, Transformation transformation) {
            if (this.jVs == -1.0f) {
                this.jVs = (float) this.jWI.Wx;
                this.jVt = (float) this.jWI.Wz;
                this.jVu = (float) this.jWI.Wy;
                this.jVv = (float) this.jWI.WA;
                this.jWy = this.jVs + ((this.jVt - this.jVs) / 5.0f);
                this.jWz = this.jVs + (((this.jVt - this.jVs) * 3.0f) / 5.0f);
                this.jWA = ((((this.jWy - this.jVs) / (this.jVt - this.jVs)) * (this.jVv - this.jVu)) + this.jVu) - ((float) b.a(this.jWI.context, 67.0f));
                this.jWB = ((((this.jWz - this.jVs) / (this.jVt - this.jVs)) * (this.jVv - this.jVu)) + this.jVu) - ((float) b.a(this.jWI.context, 53.0f));
            }
            transformation.setAlpha(this.jWG + ((this.jWH - this.jWG) * f));
            float f2 = this.jVw + ((this.jVx - this.jVw) * f);
            transformation.getMatrix().setScale(f2, f2, (float) (this.jWI.jWv / 2), (float) (this.jWI.jWw / 2));
            transformation.getMatrix().postRotate(this.jWE + ((this.jWF - this.jWE) * f), (float) (this.jWI.jWv / 2), (float) (this.jWI.jWw / 2));
            float f3 = ((this.jVt - this.jVs) * f) + this.jVs;
            if (f3 >= this.jWy) {
                f2 = (((f3 - this.jVs) / (this.jWy - this.jVs)) * (this.jWA - this.jVu)) + this.jVu;
            } else if (f3 >= this.jWz) {
                if (!this.jWD) {
                    this.jWD = true;
                    this.jWA = this.jWC;
                }
                f2 = (((f3 - this.jWy) / (this.jWz - this.jWy)) * (this.jWB - this.jWA)) + this.jWA;
            } else {
                f2 = (((f3 - this.jWz) / (this.jVt - this.jWz)) * (this.jVv - this.jWB)) + this.jWB;
            }
            this.jWC = f2;
            transformation.getMatrix().postTranslate(f3, f2);
            if (f == 1.0f) {
                this.jVs = -1.0f;
                this.jVt = -1.0f;
                this.jVu = -1.0f;
                this.jVv = -1.0f;
                this.jWD = false;
            }
        }
    };

    public BottleImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = context;
        adB();
    }

    public BottleImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        adB();
    }

    private void adB() {
        Drawable background = getBackground();
        if (background != null) {
            this.jWv = background.getIntrinsicWidth();
            this.jWw = background.getIntrinsicHeight();
        }
    }
}
