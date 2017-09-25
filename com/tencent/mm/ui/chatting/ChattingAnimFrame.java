package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mm.ap.d;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.gif.MMGIFImageView;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.downloadservice.DownloadHelper;
import java.util.ArrayList;
import java.util.List;

public class ChattingAnimFrame extends FrameLayout {
    private static String kKa = "";
    private int jrj;
    private int jzY;
    private int mScreenHeight = com.tencent.mm.bg.a.dP(getContext());
    private int uwD = 40;
    List<MMGIFImageView> vAE = new ArrayList();
    private int vAF = 30;
    private int vAG = 30;
    private boolean vAH = false;
    private int vAI = 0;
    private ArrayList<Integer> vAJ = new ArrayList();

    class a implements AnimationListener {
        final /* synthetic */ ChattingAnimFrame vAK;

        a(ChattingAnimFrame chattingAnimFrame) {
            this.vAK = chattingAnimFrame;
        }

        public void onAnimationStart(Animation animation) {
        }

        public void onAnimationEnd(Animation animation) {
        }

        public void onAnimationRepeat(Animation animation) {
        }
    }

    private class b extends Animation {
        private int hP = 0;
        private float jVA;
        private float jVB;
        private float jVw;
        private float jVx;
        private float jVy;
        private float jVz;
        final /* synthetic */ ChattingAnimFrame vAK;
        private float vAL;
        private float vAM;
        private float vAN;
        private float vAO;
        private int vAP = 0;
        private boolean vAQ = false;
        private OnLayoutChangeListener vAR = new OnLayoutChangeListener(this) {
            final /* synthetic */ b vAS;

            {
                this.vAS = r1;
            }

            public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                this.vAS.ady();
            }
        };

        public b(ChattingAnimFrame chattingAnimFrame, int i, int i2) {
            this.vAK = chattingAnimFrame;
            this.vAP = i;
            this.hP = i2;
            this.vAQ = false;
        }

        public b(ChattingAnimFrame chattingAnimFrame, int i, int i2, boolean z) {
            this.vAK = chattingAnimFrame;
            this.vAP = i;
            this.hP = i2;
            this.vAQ = z;
        }

        public final void initialize(int i, int i2, int i3, int i4) {
            super.initialize(i, i2, i3, i4);
            switch (this.vAP) {
                case 1:
                    this.vAL = ChattingAnimFrame.m(0.1f, 0.9f);
                    this.vAM = ChattingAnimFrame.m(this.vAL - 0.25f, this.vAL + 0.25f);
                    this.vAN = DownloadHelper.SAVE_FATOR;
                    this.vAO = -0.2f;
                    setInterpolator(new LinearInterpolator());
                    break;
                case 2:
                    this.vAL = 0.0f;
                    this.vAM = 0.0f;
                    this.vAN = 0.0f;
                    this.vAO = 1.0f;
                    setInterpolator(new com.tencent.mm.ui.c.a.a());
                    break;
                case 3:
                    this.vAL = 0.0f;
                    this.vAM = 0.0f;
                    this.vAN = DownloadHelper.SAVE_FATOR;
                    if (this.vAQ) {
                        this.vAO = ChattingAnimFrame.m(0.4f, 0.55f);
                    } else {
                        this.vAO = ChattingAnimFrame.m(0.54999995f, 0.85f);
                    }
                    setInterpolator(new com.tencent.mm.ui.c.a.b());
                    break;
                case 999:
                    this.vAL = ChattingAnimFrame.m(0.1f, 0.9f);
                    this.vAM = ChattingAnimFrame.m(this.vAL - 0.5f, this.vAL + 0.5f);
                    this.vAN = 0.0f;
                    this.vAO = 0.0f;
                    this.jVw = 0.8f;
                    this.jVx = 1.1f;
                    setInterpolator(new LinearInterpolator());
                    break;
                default:
                    this.vAL = ChattingAnimFrame.m(0.1f, 0.9f);
                    this.vAM = ChattingAnimFrame.m(this.vAL - 0.5f, this.vAL + 0.5f);
                    this.vAN = -0.2f;
                    this.vAO = 1.2f;
                    setInterpolator(new LinearInterpolator());
                    break;
            }
            if (!(this.vAP == 0 || this.vAP == 1)) {
                this.vAK.addOnLayoutChangeListener(this.vAR);
            }
            ady();
        }

        protected final void applyTransformation(float f, Transformation transformation) {
            float f2 = this.jVy;
            float f3 = this.jVA;
            if (this.jVy != this.jVz) {
                f2 = this.jVy + ((this.jVz - this.jVy) * f);
            }
            if (this.jVA != this.jVB) {
                f3 = this.jVA + ((this.jVB - this.jVA) * f);
                if (this.vAP == 2) {
                    f3 -= (float) this.hP;
                }
            }
            transformation.getMatrix().setTranslate(f2, f3);
            if (this.jVw != this.jVx && 3 == this.vAP) {
                f2 = this.jVw + ((this.jVx - this.jVw) * f);
                transformation.getMatrix().postScale(f2, f2);
            }
        }

        protected final void finalize() {
            super.finalize();
            w.i("MicroMsg.ChattingAnimFrame", "finalize!");
            this.vAK.removeOnLayoutChangeListener(this.vAR);
        }

        public final void ady() {
            this.jVy = this.vAL * ((float) this.vAK.jrj);
            this.jVz = this.vAM * ((float) this.vAK.jrj);
            if (this.vAP == 2) {
                this.jVA = this.vAN * ((float) this.vAK.jzY);
                this.jVB = this.vAO * ((float) this.vAK.jzY);
            } else if (this.vAP == 3) {
                this.jVA = this.vAN * ((float) this.vAK.mScreenHeight);
                this.jVB = this.vAO * ((float) this.vAK.mScreenHeight);
                if (this.vAK.vAH) {
                    this.jVA = (this.vAN * ((float) this.vAK.mScreenHeight)) - ((float) this.vAK.vAI);
                    this.jVB = (this.vAO * ((float) this.vAK.mScreenHeight)) - ((float) this.vAK.vAI);
                }
                if (this.jVB < 0.0f) {
                    this.jVB = 0.0f;
                }
            } else {
                this.jVA = this.vAN * ((float) this.vAK.mScreenHeight);
                this.jVB = this.vAO * ((float) this.vAK.mScreenHeight);
            }
        }
    }

    class c extends AnimationSet {
        int hP;
        final /* synthetic */ ChattingAnimFrame vAK;
        private long vAT;
        MMGIFImageView vAU;

        static /* synthetic */ void a(c cVar) {
            cVar.setStartOffset(cVar.vAT);
            cVar.start();
        }

        public c(final ChattingAnimFrame chattingAnimFrame, int i, int i2, long j, boolean z) {
            this.vAK = chattingAnimFrame;
            super(false);
            this.hP = i2;
            switch (i) {
                case 0:
                case 1:
                    addAnimation(new b(chattingAnimFrame, i, this.hP));
                    break;
                case 2:
                    addAnimation(new b(chattingAnimFrame, 999, this.hP));
                    addAnimation(new b(chattingAnimFrame, i, this.hP));
                    break;
                case 3:
                    addAnimation(new b(chattingAnimFrame, i, this.hP, z));
                    addAnimation(new b(chattingAnimFrame, 999, this.hP));
                    break;
                default:
                    addAnimation(new b(chattingAnimFrame, 0, this.hP));
                    break;
            }
            setAnimationListener(new a(this) {
                final /* synthetic */ c vAW;

                public final void onAnimationEnd(Animation animation) {
                    c cVar = this.vAW;
                    if (cVar.vAU != null) {
                        cVar.vAU.post(new Runnable(cVar) {
                            final /* synthetic */ c vAW;

                            {
                                this.vAW = r1;
                            }

                            public final void run() {
                                if (this.vAW.vAU != null) {
                                    this.vAW.vAU.clearAnimation();
                                    ChattingAnimFrame chattingAnimFrame = this.vAW.vAK;
                                    MMGIFImageView mMGIFImageView = this.vAW.vAU;
                                    if (mMGIFImageView != null && chattingAnimFrame.vAE != null) {
                                        chattingAnimFrame.vAE.remove(mMGIFImageView);
                                        mMGIFImageView.recycle();
                                        if (chattingAnimFrame.vAE.isEmpty()) {
                                            mMGIFImageView.setLayerType(0, null);
                                            chattingAnimFrame.removeAllViews();
                                            return;
                                        }
                                        mMGIFImageView.setVisibility(4);
                                        mMGIFImageView.setLayerType(0, null);
                                    }
                                }
                            }
                        });
                    } else {
                        w.w("MicroMsg.ChattingAnimFrame", "mTargetView is NULL.");
                    }
                }
            });
            this.vAT = 500 + j;
            reset();
            setDuration(ChattingAnimFrame.AM(i));
        }
    }

    static /* synthetic */ long AM(int i) {
        switch (i) {
            case 2:
                return 1200;
            case 3:
                return 1500;
            default:
                return (long) ((int) m(4000.0f, 6000.0f));
        }
    }

    public ChattingAnimFrame(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.jzY = getMeasuredHeight();
        this.jrj = getMeasuredWidth();
        w.d("MicroMsg.ChattingAnimFrame", "onFinishInflate width:%d height:%d", Integer.valueOf(this.jrj), Integer.valueOf(this.jzY));
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.jzY = i4 - i2;
        this.jrj = i3 - i;
        if (this.jzY < this.mScreenHeight) {
            this.vAH = true;
            this.vAI = this.mScreenHeight - this.jzY;
        } else {
            this.vAH = false;
            this.vAI = 0;
        }
        w.d("MicroMsg.ChattingAnimFrame", "onLayout width:%d height:%d isKeyBordUp:%b keyBordHeight:%d", Integer.valueOf(this.jrj), Integer.valueOf(this.jzY), Boolean.valueOf(this.vAH), Integer.valueOf(this.vAI));
    }

    public final void a(d dVar) {
        stop();
        if (dVar == null) {
            w.w("MicroMsg.ChattingAnimFrame", "egg info is null. ignore.");
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (bg.mA(kKa)) {
            kKa = e.hgr.replace("/data/user/0", "/data/data");
            kKa += "/emoji";
        }
        String stringBuilder2 = stringBuilder.append(kKa).append("/egg/").append(dVar.hNZ).toString();
        if (com.tencent.mm.a.e.aO(stringBuilder2)) {
            setVisibility(0);
            if (dVar.hOb > 0) {
                this.vAF = dVar.hOb;
                if (this.vAF > 60) {
                    this.vAF = 60;
                }
            } else {
                this.vAF = 30;
            }
            if (dVar.hOc > 0) {
                this.vAG = dVar.hOc;
            } else {
                this.vAG = 30;
            }
            if (dVar.maxSize > 0) {
                this.uwD = dVar.maxSize;
            } else {
                this.uwD = 40;
            }
            w.i("MicroMsg.ChattingAnimFrame", "Egg viewCount:%d minSize:%d maxSize:%d AnimType:%d reportType:%d", Integer.valueOf(this.vAF), Integer.valueOf(this.vAG), Integer.valueOf(this.uwD), Integer.valueOf(dVar.hOa), Integer.valueOf(dVar.hNV));
            long j = 0;
            AL(this.vAF);
            int i = 0;
            while (i < this.vAF) {
                int fromDPToPix = com.tencent.mm.bg.a.fromDPToPix(getContext(), (int) m((float) this.vAG, (float) this.uwD));
                int i2 = dVar.hOa;
                boolean z = this.vAJ != null && this.vAJ.contains(Integer.valueOf(i));
                Animation cVar = new c(this, i2, fromDPToPix, j, z);
                View mMGIFImageView = new MMGIFImageView(getContext());
                mMGIFImageView.yj(stringBuilder2);
                mMGIFImageView.setAnimation(cVar);
                mMGIFImageView.setLayerType(2, null);
                cVar.vAU = mMGIFImageView;
                mMGIFImageView.setLayoutParams(new LayoutParams(cVar.hP, cVar.hP));
                this.vAE.add(mMGIFImageView);
                addView(mMGIFImageView);
                int i3 = dVar.hOa;
                int i4 = this.vAF;
                switch (i3) {
                    case 2:
                        j = i < 2 ? 800 + j : ((long) (((Math.abs((((double) i) - (((double) i4) * 0.5d)) - 5.0d) / ((double) (i4 * 3))) + 0.01d) * 1000.0d)) + j;
                        break;
                    case 3:
                        j += (long) (((Math.abs((((double) i) - (((double) i4) * 0.5d)) - 5.0d) / ((double) (i4 * 6))) + 0.06d) * 1000.0d);
                        break;
                    default:
                        j = (long) ((int) (m(0.0f, 4.0f) * 1000.0f));
                        break;
                }
                i++;
            }
            if (this.vAE != null) {
                for (View view : this.vAE) {
                    if (view != null && (view.getAnimation() instanceof c)) {
                        c.a((c) view.getAnimation());
                    }
                }
                return;
            }
            return;
        }
        w.w("MicroMsg.ChattingAnimFrame", "egg file isn't exist. ignore");
    }

    private void AL(int i) {
        if (i <= 0) {
            w.w("MicroMsg.ChattingAnimFrame", "count is zero.");
            return;
        }
        int i2 = (int) (((double) i) * 0.1d);
        if (this.vAJ != null) {
            this.vAJ.clear();
        } else {
            this.vAJ = new ArrayList();
        }
        while (this.vAJ.size() < i2) {
            int m = (int) m(0.0f, (float) i);
            if (!this.vAJ.contains(Integer.valueOf(m))) {
                this.vAJ.add(Integer.valueOf(m));
            }
        }
    }

    public final void stop() {
        for (MMGIFImageView mMGIFImageView : this.vAE) {
            mMGIFImageView.clearAnimation();
            mMGIFImageView.recycle();
        }
        removeAllViews();
    }

    static float m(float f, float f2) {
        return (((float) Math.random()) * (f2 - f)) + f;
    }
}
