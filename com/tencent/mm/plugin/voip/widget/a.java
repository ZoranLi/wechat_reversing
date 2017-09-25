package com.tencent.mm.plugin.voip.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.R;
import com.tencent.mm.plugin.voip.model.d;
import com.tencent.mm.plugin.voip.video.CaptureView;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.OpenGlView;
import com.tencent.mm.sdk.platformtools.w;

public final class a extends BaseSmallView {
    private boolean Ps;
    private OpenGlRender rqP;
    private OpenGlView rqQ;
    private OpenGlRender rqR;
    private OpenGlView rqS;
    private int[] rqT = null;
    private int rqU = 0;
    private float rqV;
    private Runnable rqW = new Runnable(this) {
        final /* synthetic */ a rqY;

        {
            this.rqY = r1;
        }

        public final void run() {
            this.rqY.rqS.setVisibility(4);
        }
    };
    private Runnable rqX = new Runnable(this) {
        final /* synthetic */ a rqY;

        {
            this.rqY = r1;
        }

        public final void run() {
            this.rqY.rqS.setVisibility(0);
        }
    };

    public a(Context context, float f) {
        super(context, null);
        LayoutInflater.from(context).inflate(R.i.dpR, this);
        this.rqV = f;
        this.rqQ = (OpenGlView) findViewById(R.h.cpl);
        this.rqP = new OpenGlRender(this.rqQ, OpenGlRender.rpM);
        this.rqQ.a(this.rqP);
        this.rqQ.setRenderMode(0);
        this.rqS = (OpenGlView) findViewById(R.h.cpk);
        this.rqR = new OpenGlRender(this.rqS, OpenGlRender.rpL);
        this.rqS.a(this.rqR);
        this.rqS.setRenderMode(0);
        this.rqS.setZOrderMediaOverlay(true);
        this.rqS.setVisibility(4);
        this.jsW.postDelayed(new Runnable(this) {
            final /* synthetic */ a rqY;

            {
                this.rqY = r1;
            }

            public final void run() {
                this.rqY.findViewById(R.h.cOi).setVisibility(8);
            }
        }, 3000);
        this.jsW.postDelayed(this.rqX, 2000);
        this.jsW.postDelayed(this.rqW, 5000);
    }

    public final void dq(int i, int i2) {
        LayoutParams layoutParams = (LayoutParams) this.rqS.getLayoutParams();
        layoutParams.height = i2 / 4;
        layoutParams.width = (int) (this.rqV * ((float) layoutParams.height));
        this.rqS.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = (WindowManager.LayoutParams) getLayoutParams();
        if (layoutParams2 == null) {
            layoutParams2 = new WindowManager.LayoutParams();
        }
        layoutParams2.width = i;
        layoutParams2.height = i2;
        setLayoutParams(layoutParams2);
    }

    private void brG() {
        if (!this.Ps) {
            this.Ps = true;
            this.rqP.rps = true;
            this.rqR.rps = true;
        }
    }

    public final void a(int i, int i2, int[] iArr) {
        brG();
        if (OpenGlRender.rpX == 1) {
            this.rqP.a(iArr, i, i2, OpenGlRender.rpC + OpenGlRender.rpI);
        } else {
            this.rqP.a(iArr, i, i2, OpenGlRender.rpF + OpenGlRender.rpI);
        }
    }

    public final void bpR() {
        if (this.Ps) {
            this.rqR.brz();
            this.rqP.brz();
        }
    }

    public final void a(byte[] bArr, long j, int i, int i2, int i3, int i4, int i5) {
        if (this.rqS.getVisibility() == 0) {
            brG();
            if (OpenGlRender.rpX == 1) {
                if (this.rqU < i * i2) {
                    this.rqT = null;
                }
                if (this.rqT == null) {
                    this.rqU = i * i2;
                    this.rqT = new int[this.rqU];
                }
                if (d.bpd().a(bArr, (int) j, i3 & 31, i, i2, this.rqT) >= 0 && this.rqT != null) {
                    this.rqR.a(this.rqT, i, i2, (OpenGlRender.rpD + i4) + i5);
                }
            } else if (OpenGlRender.rpX == 2) {
                this.rqR.b(bArr, i, i2, (OpenGlRender.rpH + i4) + i5);
            }
        }
    }

    public final void uninit() {
        super.uninit();
        setVisibility(4);
        if (this.Ps) {
            this.rqP.bry();
            this.rqR.bry();
        }
        this.jsW.removeCallbacks(this.rqW);
    }

    public final void a(CaptureView captureView) {
        w.h("MicroMsg.Voip.BaseSmallView", "addCaptureView", new Object[0]);
        if (this.rhA != null) {
            removeView(this.rhA);
            this.rhA = null;
        }
        if (captureView != null) {
            this.rhA = captureView;
            ViewGroup.LayoutParams layoutParams = new FrameLayout.LayoutParams(1, 1);
            layoutParams.leftMargin = 20;
            layoutParams.topMargin = 20;
            addView(captureView, layoutParams);
            captureView.setVisibility(0);
            w.d("MicroMsg.Voip.BaseSmallView", "CaptureView added");
        }
    }

    protected final void brc() {
        this.rqS.setVisibility(0);
        this.jsW.removeCallbacks(this.rqW);
        this.jsW.postDelayed(this.rqW, 3000);
    }

    protected final void brd() {
        this.rqP.bry();
        this.rqR.bry();
    }

    protected final void onAnimationEnd() {
        this.rqP.rps = true;
        this.rqR.rps = true;
    }
}
