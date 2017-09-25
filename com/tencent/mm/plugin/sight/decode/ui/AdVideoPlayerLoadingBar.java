package com.tencent.mm.plugin.sight.decode.ui;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.y.a.a;
import com.tencent.mm.plugin.y.a.b;
import com.tencent.mm.plugin.y.a.c;
import com.tencent.mm.sdk.platformtools.w;

public class AdVideoPlayerLoadingBar extends RelativeLayout implements a {
    public View ipu = null;
    public boolean jGP = false;
    public int kC = 0;
    public b puM = null;
    public ImageView puN;
    public ImageView puO = null;
    public ImageView puP = null;
    public ImageView puQ = null;
    public TextView puR;
    public TextView puS;
    public int puT = 0;
    private int puU = 0;
    private int puV = 0;
    public float puW = 0.0f;
    private int puX = -1;
    private int puY = -1;
    private int puZ = -1;
    private int pva = -1;

    static /* synthetic */ int a(AdVideoPlayerLoadingBar adVideoPlayerLoadingBar, int i) {
        int bcq = ((adVideoPlayerLoadingBar.bcq() - adVideoPlayerLoadingBar.puP.getPaddingLeft()) - adVideoPlayerLoadingBar.puP.getPaddingRight()) / 2;
        LayoutParams layoutParams = (LayoutParams) adVideoPlayerLoadingBar.puO.getLayoutParams();
        if (i < (layoutParams.leftMargin - adVideoPlayerLoadingBar.puP.getPaddingLeft()) - bcq) {
            return (layoutParams.leftMargin - adVideoPlayerLoadingBar.puP.getPaddingLeft()) - bcq;
        }
        if (i <= ((adVideoPlayerLoadingBar.bco() + layoutParams.leftMargin) - bcq) - adVideoPlayerLoadingBar.puP.getPaddingLeft()) {
            return i;
        }
        return ((layoutParams.leftMargin + adVideoPlayerLoadingBar.bco()) - bcq) - adVideoPlayerLoadingBar.puP.getPaddingLeft();
    }

    public AdVideoPlayerLoadingBar(Context context) {
        super(context);
        init();
    }

    public AdVideoPlayerLoadingBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public AdVideoPlayerLoadingBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public int getLayoutId() {
        return b.ooO;
    }

    public final void a(b bVar) {
        this.puM = bVar;
    }

    public void init() {
        this.ipu = View.inflate(getContext(), getLayoutId(), this);
        this.puN = (ImageView) this.ipu.findViewById(a.ooL);
        this.puO = (ImageView) this.ipu.findViewById(a.ooK);
        this.puP = (ImageView) this.ipu.findViewById(a.ooM);
        this.puQ = (ImageView) this.ipu.findViewById(a.crK);
        this.puR = (TextView) this.ipu.findViewById(a.ooI);
        this.puS = (TextView) this.ipu.findViewById(a.ooJ);
        this.puP.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ AdVideoPlayerLoadingBar pvb;

            {
                this.pvb = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    w.i("MicroMsg.VideoPlayerLoadingBar", "ontouch down");
                    this.pvb.jGP = false;
                    this.pvb.puW = motionEvent.getX();
                    if (this.pvb.puM != null) {
                        this.pvb.puM.Uh();
                    }
                } else if (motionEvent.getAction() == 2) {
                    float x = motionEvent.getX();
                    LayoutParams layoutParams = (LayoutParams) this.pvb.puP.getLayoutParams();
                    layoutParams.leftMargin = AdVideoPlayerLoadingBar.a(this.pvb, ((int) (x - this.pvb.puW)) + layoutParams.leftMargin);
                    this.pvb.puP.setLayoutParams(layoutParams);
                    int bcl = this.pvb.bcl();
                    if (this.pvb.puT > 0) {
                        layoutParams = (LayoutParams) this.pvb.puN.getLayoutParams();
                        layoutParams.width = (int) (((((double) bcl) * 1.0d) / ((double) this.pvb.puT)) * ((double) this.pvb.bco()));
                        this.pvb.puN.setLayoutParams(layoutParams);
                    }
                    this.pvb.puR.setText(AdVideoPlayerLoadingBar.hQ(bcl / 60) + ":" + AdVideoPlayerLoadingBar.hQ(bcl % 60));
                    this.pvb.jGP = true;
                } else if (this.pvb.jGP) {
                    int bcl2 = this.pvb.bcl();
                    if (this.pvb.puM != null) {
                        w.i("MicroMsg.VideoPlayerLoadingBar", "current time : " + bcl2);
                        this.pvb.puM.hR(bcl2);
                    }
                    this.pvb.jGP = false;
                }
                return true;
            }
        });
        this.puP.post(new Runnable(this) {
            final /* synthetic */ AdVideoPlayerLoadingBar pvb;

            {
                this.pvb = r1;
            }

            public final void run() {
                LayoutParams layoutParams = (LayoutParams) this.pvb.puP.getLayoutParams();
                layoutParams.leftMargin = (((LayoutParams) this.pvb.puO.getLayoutParams()).leftMargin - this.pvb.puP.getPaddingLeft()) - (((this.pvb.bcq() - this.pvb.puP.getPaddingLeft()) - this.pvb.puP.getPaddingRight()) / 2);
                this.pvb.puP.setLayoutParams(layoutParams);
            }
        });
        LayoutParams layoutParams = (LayoutParams) this.puN.getLayoutParams();
        layoutParams.width = 0;
        this.puN.setLayoutParams(layoutParams);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.puU = 0;
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

    public void bX(boolean z) {
        if (z) {
            this.puQ.setImageResource(c.ooP);
        } else {
            this.puQ.setImageResource(c.ooQ);
        }
    }

    protected final int bcl() {
        return Math.max(0, (int) (((((double) ((((LayoutParams) this.puP.getLayoutParams()).leftMargin - (((LayoutParams) this.puO.getLayoutParams()).leftMargin - this.puP.getPaddingLeft())) + (((bcq() - this.puP.getPaddingLeft()) - this.puP.getPaddingRight()) / 2))) * 1.0d) / ((double) bco())) * ((double) this.puT)));
    }

    public void seek(int i) {
        this.kC = i;
        bcr();
    }

    public final int bcm() {
        return this.puT;
    }

    public void sH(int i) {
        this.puT = i;
        if (Looper.myLooper() != Looper.getMainLooper()) {
            post(new Runnable(this) {
                final /* synthetic */ AdVideoPlayerLoadingBar pvb;

                {
                    this.pvb = r1;
                }

                public final void run() {
                    this.pvb.bcn();
                }
            });
        } else {
            bcn();
        }
    }

    public final void bcn() {
        this.puS.setText(hQ(this.puT / 60) + ":" + hQ(this.puT % 60));
        bcr();
    }

    public final int bco() {
        if (this.puU <= 0) {
            this.puU = this.puO.getWidth();
        }
        return this.puU;
    }

    public final void bcp() {
        this.puU = 0;
    }

    public int bcq() {
        if (this.puV <= 0) {
            this.puV = this.puP.getWidth();
        }
        return this.puV;
    }

    public void bcr() {
        if (this.puT != 0 && !this.jGP && this.puP != null && bco() != 0) {
            int bcq = ((bcq() - this.puP.getPaddingLeft()) - this.puP.getPaddingRight()) / 2;
            this.puR.setText(hQ(this.kC / 60) + ":" + hQ(this.kC % 60));
            LayoutParams layoutParams = (LayoutParams) this.puP.getLayoutParams();
            layoutParams.leftMargin = ((((LayoutParams) this.puO.getLayoutParams()).leftMargin - this.puP.getPaddingLeft()) + ((int) (((((double) this.kC) * 1.0d) / ((double) this.puT)) * ((double) bco())))) - bcq;
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
