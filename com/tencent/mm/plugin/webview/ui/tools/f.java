package com.tencent.mm.plugin.webview.ui.tools;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.webview.ui.tools.LogoWebViewWrapper.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.widget.MMWebView;

public final class f implements b {
    static final int scs = R.g.blY;
    public boolean iEh = false;
    private View scA;
    public View scB;
    private TextView scC;
    private boolean scD;
    public boolean scE = false;
    a sco;
    ImageView scp;
    LogoWebViewWrapper scq;
    int scr = 0;
    private boolean sct = false;
    private boolean scu = false;
    private int scv = 0;
    private float scw = 0.0f;
    private ValueAnimator scx;
    public ViewPropertyAnimator scy;
    private float scz;

    public interface a {
        void bxU();
    }

    public final void cM(View view) {
        String str;
        this.scq = (LogoWebViewWrapper) view.findViewById(R.h.ccM);
        this.scp = (ImageView) view.findViewById(R.h.cSx);
        this.scA = view.findViewById(R.h.cSw);
        if (this.scA != null) {
            this.scB = this.scA.findViewById(R.h.cTo);
            this.scC = (TextView) this.scB.findViewById(R.h.cTp);
        }
        this.scr = BackwardSupportUtil.b.a(this.scq.getContext(), 72.0f);
        String str2 = "MicroMsg.WebViewPullDownLogoDelegate";
        String str3 = "refreshImage.id = %s, logoWrapper.id = %s";
        Object[] objArr = new Object[2];
        if (this.scp == null) {
            str = "null";
        } else {
            str = String.valueOf(this.scp.getId());
        }
        objArr[0] = str;
        if (this.scq == null) {
            str = "null";
        } else {
            str = String.valueOf(this.scq.getId());
        }
        objArr[1] = str;
        w.d(str2, str3, objArr);
        w.d("MicroMsg.WebViewPullDownLogoDelegate", "LOADING_LOGO_HEIGHT = %d", new Object[]{Integer.valueOf(this.scr)});
    }

    public final void a(MMWebView mMWebView) {
        mMWebView.wwU = this.scq;
        mMWebView.caI();
        if (VERSION.SDK_INT <= 10) {
            this.scq.bxD().setBackgroundColor(this.scq.getResources().getColor(R.e.aWs));
        }
        LogoWebViewWrapper logoWebViewWrapper = this.scq;
        logoWebViewWrapper.bxD();
        if (logoWebViewWrapper.saC != null) {
            logoWebViewWrapper.kuN = mMWebView;
            logoWebViewWrapper.saC.addView(logoWebViewWrapper.kuN);
        }
        this.scD = mMWebView.wwS;
        if (!this.scD || this.scE) {
            iQ(true);
            return;
        }
        iQ(false);
        if (this.scB != null) {
            this.scB.setVisibility(0);
        }
    }

    public final void bxS() {
        this.iEh = false;
        stopLoading();
        if (this.scD && this.scB != null && !this.scE) {
            iQ(false);
            this.scq.saK = 0;
            this.scB.setVisibility(0);
        }
    }

    public final void startLoading() {
        if (!this.sct && this.scp != null && this.scq != null) {
            this.sct = true;
            this.scq.iQ(true);
            this.scp.clearAnimation();
            if (this.scx != null) {
                this.scx.cancel();
            }
            this.scx = ObjectAnimator.ofFloat(this, "startLoadingStep", new float[]{this.scw + 0.0f, this.scw + 354.0f});
            this.scx.setDuration(960);
            this.scx.setRepeatMode(1);
            this.scx.setRepeatCount(-1);
            this.scx.setInterpolator(new LinearInterpolator());
            this.scx.start();
            if (this.sco != null) {
                this.sco.bxU();
            }
        }
    }

    public final void stopLoading() {
        if (this.sct) {
            w.d("MicroMsg.WebViewPullDownLogoDelegate", "stopLoading()");
            this.scu = true;
            this.sct = false;
            if (this.scq != null && this.iEh) {
                this.scq.iQ(false);
            }
            if (this.scx != null) {
                this.scx.cancel();
            }
            if (this.scq != null) {
                this.scq.K(0, 250);
            }
            if (this.scp != null) {
                w.d("MicroMsg.WebViewPullDownLogoDelegate", "refreshImage, alpha to 0f");
                this.scp.animate().alpha(0.0f).setDuration(500).start();
            }
        }
    }

    public final void release() {
        if (this.scq != null) {
            LogoWebViewWrapper logoWebViewWrapper = this.scq;
            if (logoWebViewWrapper.saC != null) {
                logoWebViewWrapper.saC.removeView(logoWebViewWrapper.kuN);
                logoWebViewWrapper.kuN = null;
            }
            logoWebViewWrapper = this.scq;
            logoWebViewWrapper.saM = null;
            logoWebViewWrapper.saL = null;
        }
        if (this.scA != null) {
            ((ViewGroup) this.scA).removeAllViews();
        }
        this.scq = null;
        this.scp = null;
        this.scv = 0;
        if (this.scx != null) {
            this.scx.cancel();
            this.scx = null;
        }
    }

    public final void wm(int i) {
        if (this.scA != null) {
            this.scA.setBackgroundColor(i);
        }
    }

    public final void bxT() {
        if (this.scB != null) {
            this.scB.setVisibility(8);
        }
    }

    public final void W(int i, boolean z) {
        String str;
        String str2 = "MicroMsg.WebViewPullDownLogoDelegate";
        String str3 = "onOverScrollOffset, offset = %d, pointerDown = %b, refreshImage.visibility = %s, refreshImage.drawable = %s, refreshImage.alpha = %s";
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Boolean.valueOf(z);
        if (this.scp == null) {
            str = "null";
        } else {
            str = String.valueOf(this.scp.getVisibility());
        }
        objArr[2] = str;
        if (this.scp == null) {
            str = "null";
        } else {
            str = this.scp.getDrawable().toString();
        }
        objArr[3] = str;
        if (this.scp == null) {
            str = "null";
        } else {
            str = String.valueOf(this.scp.getAlpha());
        }
        objArr[4] = str;
        w.v(str2, str3, objArr);
        if (this.iEh) {
            if (i == 0) {
                this.scu = false;
            }
            if (this.scp != null) {
                if (z) {
                    if (Math.abs(i) >= this.scr) {
                        if (this.scq != null) {
                            this.scq.saK = this.scr;
                        }
                    } else if (this.scq != null) {
                        this.scq.saK = 0;
                    }
                } else if (Math.abs(i) > this.scr && !this.sct) {
                    w.d("MicroMsg.WebViewPullDownLogoDelegate", "startLoading()");
                    startLoading();
                    return;
                } else if (this.sct) {
                    return;
                }
                if (this.scp != null && this.scp.getAlpha() < 1.0f && this.scy == null && z) {
                    w.d("MicroMsg.WebViewPullDownLogoDelegate", "refreshImage alpha to 1.0f");
                    this.scy = this.scp.animate().alpha(1.0f).setDuration(500);
                    this.scy.setListener(new AnimatorListenerAdapter(this) {
                        final /* synthetic */ f scF;

                        {
                            this.scF = r1;
                        }

                        public final void onAnimationCancel(Animator animator) {
                            super.onAnimationCancel(animator);
                            this.scF.scy = null;
                        }

                        public final void onAnimationEnd(Animator animator) {
                            super.onAnimationEnd(animator);
                            this.scF.scy = null;
                        }
                    });
                    this.scy.start();
                }
                if (!this.scu) {
                    int i2 = (-i) - this.scv;
                    if (Math.abs(i) >= this.scr) {
                        i2 *= 5;
                    } else {
                        i2 *= 2;
                    }
                    this.scv = -i;
                    float height = (float) (this.scp.getHeight() / 2);
                    float width = (float) (this.scp.getWidth() / 2);
                    this.scw -= (float) i2;
                    this.scp.setScaleType(ScaleType.MATRIX);
                    Matrix imageMatrix = this.scp.getImageMatrix();
                    imageMatrix.postRotate((float) (-i2), width, height);
                    this.scp.setImageMatrix(imageMatrix);
                    this.scp.setImageResource(scs);
                }
                this.scp.invalidate();
            }
        }
    }

    public final float getStartLoadingStep() {
        return this.scz;
    }

    public final void setStartLoadingStep(float f) {
        float f2 = 0.0f;
        this.scz = f;
        this.scp.setScaleType(ScaleType.MATRIX);
        Matrix imageMatrix = this.scp.getImageMatrix();
        float width = this.scp == null ? 0.0f : ((float) this.scp.getWidth()) / 2.0f;
        if (this.scp != null) {
            f2 = ((float) this.scp.getHeight()) / 2.0f;
        }
        imageMatrix.setRotate(f, width, f2);
        this.scw = f;
        this.scp.invalidate();
    }

    public final void iQ(boolean z) {
        if (this.scq != null && this.scq.saI != z) {
            this.scq.iQ(z);
            if (this.scB != null) {
                this.scB.setVisibility(8);
            }
            this.scE = z;
        }
    }

    public final void pE(String str) {
        if (!this.scD || this.scE) {
            iQ(true);
            if (this.scB != null && this.scB.getVisibility() == 0) {
                this.scB.setVisibility(8);
            }
        } else if (this.scC != null) {
            if (!bg.mA(str)) {
                if (!bg.mA(Uri.parse(str).getHost())) {
                    CharSequence string = this.scC.getContext().getString(R.l.fmw, new Object[]{r0});
                    this.scC.setVisibility(0);
                    this.scC.setText(string);
                    iQ(false);
                    return;
                }
            }
            this.scC.setVisibility(8);
        }
    }
}
