package com.tencent.mm.plugin.appbrand.performance;

import android.annotation.TargetApi;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;

@TargetApi(16)
public final class d implements FrameCallback {
    boolean AK = true;
    a jeK;
    Choreographer jeY = Choreographer.getInstance();
    long jeZ = 0;
    int jfa = 0;
    long jfb = 200;

    public interface a {
        void e(double d);
    }

    public final void doFrame(long j) {
        double d = 60.0d;
        if (this.AK) {
            long j2 = j / 1000000;
            if (this.jeZ > 0) {
                long j3 = j2 - this.jeZ;
                this.jfa++;
                if (j3 > this.jfb) {
                    double d2 = ((double) (this.jfa * 1000)) / ((double) j3);
                    if (d2 < 60.0d) {
                        d = d2;
                    }
                    this.jeZ = j2;
                    this.jfa = 0;
                    if (this.jeK != null) {
                        this.jeK.e(d);
                    }
                }
            } else {
                this.jeZ = j2;
            }
            this.jeY.postFrameCallback(this);
        }
    }
}
