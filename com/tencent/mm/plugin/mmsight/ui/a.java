package com.tencent.mm.plugin.mmsight.ui;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class a {
    private int duration;
    public boolean fOV;
    public aj hMA = null;
    private float nKO = 0.0f;
    private float nKP;
    public float nKQ;
    long nKR;
    public float nKS;
    public a nKT;
    private Runnable nKU = new Runnable(this) {
        final /* synthetic */ a nKV;

        {
            this.nKV = r1;
        }

        public final void run() {
            this.nKV.aMe();
            if (!this.nKV.fOV) {
                w.i("MicroMsg.ProgressHandlerAnimator", "isStart is false now");
            } else if (this.nKV.nKS < this.nKV.nKQ) {
                this.nKV.hMA.post(this);
            } else {
                this.nKV.fOV = false;
                w.i("MicroMsg.ProgressHandlerAnimator", "reach end, currentValue: %s, end: %s", new Object[]{Float.valueOf(this.nKV.nKS), Float.valueOf(this.nKV.nKQ)});
                if (this.nKV.nKT != null) {
                    this.nKV.nKT.onAnimationEnd();
                }
            }
        }
    };

    public interface a {
        void aa(float f);

        void onAnimationEnd();
    }

    public a(float f, float f2, int i) {
        this.nKP = f;
        this.nKQ = f2;
        this.duration = i;
        if (f2 > f) {
            this.nKO = ((f2 - f) / ((float) this.duration)) * 20.0f;
        }
        w.i("MicroMsg.ProgressHandlerAnimator", "create ProgressHandlerAnimator, start: %s, end: %s, duration: %s, updateStep: %s", new Object[]{Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i), Float.valueOf(this.nKO)});
        this.fOV = false;
        this.nKR = 0;
        this.hMA = new aj(Looper.getMainLooper(), new com.tencent.mm.sdk.platformtools.aj.a(this) {
            final /* synthetic */ a nKV;

            {
                this.nKV = r1;
            }

            public final boolean oQ() {
                this.nKV.aMe();
                if (!this.nKV.fOV) {
                    w.i("MicroMsg.ProgressHandlerAnimator", "isStart is false now");
                    return false;
                } else if (this.nKV.nKS < this.nKV.nKQ) {
                    return true;
                } else {
                    this.nKV.fOV = false;
                    w.i("MicroMsg.ProgressHandlerAnimator", "reach end, currentValue: %s, end: %s, callback: %s", new Object[]{Float.valueOf(this.nKV.nKS), Float.valueOf(this.nKV.nKQ), this.nKV.nKT});
                    if (this.nKV.nKT != null) {
                        this.nKV.nKT.onAnimationEnd();
                    }
                    return false;
                }
            }
        }, true);
    }

    public final void aMe() {
        w.d("MicroMsg.ProgressHandlerAnimator", "updateImpl, currentValue: %s", new Object[]{Float.valueOf(this.nKS)});
        this.nKS = (((float) bg.aB(this.nKR)) / ((float) this.duration)) * (this.nKQ - this.nKP);
        if (this.nKT != null) {
            this.nKT.aa(this.nKS);
        }
    }
}
