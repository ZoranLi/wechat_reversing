package android.support.v4.view.b;

import android.view.animation.Interpolator;

abstract class d implements Interpolator {
    private final float[] At;
    private final float Au = (1.0f / ((float) (this.At.length - 1)));

    public d(float[] fArr) {
        this.At = fArr;
    }

    public float getInterpolation(float f) {
        if (f >= 1.0f) {
            return 1.0f;
        }
        if (f <= 0.0f) {
            return 0.0f;
        }
        int min = Math.min((int) (((float) (this.At.length - 1)) * f), this.At.length - 2);
        float f2 = (f - (((float) min) * this.Au)) / this.Au;
        return ((this.At[min + 1] - this.At[min]) * f2) + this.At[min];
    }
}
