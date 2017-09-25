package com.tencent.mm.plugin.sight.decode.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.af.a.e;
import com.tencent.mm.plugin.af.a.f;
import com.tencent.mm.plugin.af.a.g;
import com.tencent.mm.sdk.platformtools.w;

public class SnsAdNativeLandingPagesVideoPlayerLoadingBar extends RelativeLayout implements a {
    public boolean fKD = false;
    private View ipu = null;
    private boolean jGP = false;
    private int kC = 0;
    public b puM = null;
    private ImageView puN;
    private ImageView puO = null;
    private ImageView puP = null;
    private ImageView puQ = null;
    private TextView puR;
    private TextView puS;
    public int puT = 0;
    private int puU = 0;
    private float puW = 0.0f;
    private int puX = -1;
    private int puY = -1;
    private int puZ = -1;
    private int pva = -1;

    static /* synthetic */ int a(SnsAdNativeLandingPagesVideoPlayerLoadingBar snsAdNativeLandingPagesVideoPlayerLoadingBar, int i) {
        int width = ((snsAdNativeLandingPagesVideoPlayerLoadingBar.puP.getWidth() - snsAdNativeLandingPagesVideoPlayerLoadingBar.puP.getPaddingLeft()) - snsAdNativeLandingPagesVideoPlayerLoadingBar.puP.getPaddingRight()) / 2;
        LayoutParams layoutParams = (LayoutParams) snsAdNativeLandingPagesVideoPlayerLoadingBar.puO.getLayoutParams();
        if (i < (layoutParams.leftMargin - snsAdNativeLandingPagesVideoPlayerLoadingBar.puP.getPaddingLeft()) - width) {
            return (layoutParams.leftMargin - snsAdNativeLandingPagesVideoPlayerLoadingBar.puP.getPaddingLeft()) - width;
        }
        return i > snsAdNativeLandingPagesVideoPlayerLoadingBar.bco() ? snsAdNativeLandingPagesVideoPlayerLoadingBar.bco() - width : i - width;
    }

    static /* synthetic */ int d(SnsAdNativeLandingPagesVideoPlayerLoadingBar snsAdNativeLandingPagesVideoPlayerLoadingBar) {
        int paddingLeft = (int) (((((double) (((LayoutParams) snsAdNativeLandingPagesVideoPlayerLoadingBar.puP.getLayoutParams()).leftMargin - (((LayoutParams) snsAdNativeLandingPagesVideoPlayerLoadingBar.puO.getLayoutParams()).leftMargin - snsAdNativeLandingPagesVideoPlayerLoadingBar.puP.getPaddingLeft()))) * 1.0d) / ((double) snsAdNativeLandingPagesVideoPlayerLoadingBar.bco())) * ((double) snsAdNativeLandingPagesVideoPlayerLoadingBar.puT));
        return paddingLeft < 0 ? 0 : paddingLeft;
    }

    public SnsAdNativeLandingPagesVideoPlayerLoadingBar(Context context) {
        super(context);
        init();
    }

    public SnsAdNativeLandingPagesVideoPlayerLoadingBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public SnsAdNativeLandingPagesVideoPlayerLoadingBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public final void a(b bVar) {
        this.puM = bVar;
    }

    private void init() {
        this.ipu = View.inflate(getContext(), f.ram, this);
        this.puN = (ImageView) this.ipu.findViewById(e.ooL);
        this.puO = (ImageView) this.ipu.findViewById(e.ooK);
        this.puP = (ImageView) this.ipu.findViewById(e.ooM);
        this.puQ = (ImageView) this.ipu.findViewById(e.crK);
        this.puR = (TextView) this.ipu.findViewById(e.ooI);
        this.puS = (TextView) this.ipu.findViewById(e.ooJ);
        this.puP.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ SnsAdNativeLandingPagesVideoPlayerLoadingBar pvy;

            {
                this.pvy = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    w.i("MicroMsg.SnsAdNativeLandingPagesVideoPlayerLoadingBar", "ontouch down");
                    this.pvy.jGP = false;
                    this.pvy.puW = motionEvent.getX();
                    if (this.pvy.puM != null) {
                        this.pvy.puM.Uh();
                    }
                } else if (motionEvent.getAction() == 2) {
                    float x = motionEvent.getX();
                    LayoutParams layoutParams = (LayoutParams) this.pvy.puP.getLayoutParams();
                    layoutParams.leftMargin = SnsAdNativeLandingPagesVideoPlayerLoadingBar.a(this.pvy, ((int) (x - this.pvy.puW)) + layoutParams.leftMargin);
                    this.pvy.puP.setLayoutParams(layoutParams);
                    int d = SnsAdNativeLandingPagesVideoPlayerLoadingBar.d(this.pvy);
                    if (this.pvy.puT > 0) {
                        layoutParams = (LayoutParams) this.pvy.puN.getLayoutParams();
                        layoutParams.width = (int) (((((double) d) * 1.0d) / ((double) this.pvy.puT)) * ((double) this.pvy.bco()));
                        this.pvy.puN.setLayoutParams(layoutParams);
                    }
                    this.pvy.puR.setText(SnsAdNativeLandingPagesVideoPlayerLoadingBar.hQ(d / 60) + ":" + SnsAdNativeLandingPagesVideoPlayerLoadingBar.hQ(d % 60));
                    this.pvy.jGP = true;
                } else if (this.pvy.jGP) {
                    int d2 = SnsAdNativeLandingPagesVideoPlayerLoadingBar.d(this.pvy);
                    if (this.pvy.puM != null) {
                        w.i("MicroMsg.SnsAdNativeLandingPagesVideoPlayerLoadingBar", "current time : " + d2);
                        this.pvy.puM.hR(d2);
                    }
                    this.pvy.jGP = false;
                }
                return true;
            }
        });
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!(i == this.puX && i2 == this.puY && i3 == this.puZ && i4 == this.pva)) {
            bcr();
        }
        this.puX = i;
        this.puY = i2;
        this.puZ = i3;
        this.pva = i4;
    }

    public final void d(OnClickListener onClickListener) {
        this.puQ.setOnClickListener(onClickListener);
    }

    public final void bX(boolean z) {
        this.fKD = z;
        if (z) {
            this.puQ.setImageResource(g.ooP);
        } else {
            this.puQ.setImageResource(g.ooQ);
        }
    }

    public final void seek(int i) {
        this.kC = i;
        bcr();
    }

    public final int bcm() {
        return this.puT;
    }

    public final void sH(final int i) {
        if (this.puP.isShown() && this.puP.getWidth() == 0) {
            post(new Runnable(this) {
                final /* synthetic */ SnsAdNativeLandingPagesVideoPlayerLoadingBar pvy;

                public final void run() {
                    this.pvy.sH(i);
                }
            });
            return;
        }
        this.puT = i;
        this.kC = 0;
        this.puS.setText(hQ(this.puT / 60) + ":" + hQ(this.puT % 60));
        bcr();
    }

    private int bco() {
        this.puU = this.puO.getWidth();
        return this.puU;
    }

    public final void bcp() {
        this.puU = 0;
    }

    private void bcr() {
        if (this.puT != 0 && !this.jGP && this.puP != null && bco() != 0) {
            int width = ((this.puP.getWidth() - this.puP.getPaddingLeft()) - this.puP.getPaddingRight()) / 2;
            this.puR.setText(hQ(this.kC / 60) + ":" + hQ(this.kC % 60));
            LayoutParams layoutParams = (LayoutParams) this.puP.getLayoutParams();
            layoutParams.leftMargin = ((((LayoutParams) this.puO.getLayoutParams()).leftMargin - this.puP.getPaddingLeft()) + ((int) (((((double) this.kC) * 1.0d) / ((double) this.puT)) * ((double) bco())))) - width;
            this.puP.setLayoutParams(layoutParams);
            layoutParams = (LayoutParams) this.puN.getLayoutParams();
            layoutParams.width = (int) (((((double) this.kC) * 1.0d) / ((double) this.puT)) * ((double) bco()));
            this.puN.setLayoutParams(layoutParams);
        }
    }

    public static String hQ(int i) {
        if (i < 10) {
            return "0" + i;
        }
        return String.valueOf(i);
    }
}
