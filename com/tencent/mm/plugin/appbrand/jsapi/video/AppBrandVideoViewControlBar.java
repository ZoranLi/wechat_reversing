package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.w;

public class AppBrandVideoViewControlBar extends VideoPlayerSeekBar {
    private static int iWR = -1;
    ImageView iWH;
    ImageView iWI;
    private RelativeLayout iWJ;
    private ImageView iWK;
    private FrameLayout iWL;
    b iWM;
    aj iWN;
    aj iWO;
    boolean iWP;
    boolean iWQ;

    class AnonymousClass1 implements OnClickListener {
        final /* synthetic */ a iWS;
        final /* synthetic */ AppBrandVideoViewControlBar iWT;

        AnonymousClass1(AppBrandVideoViewControlBar appBrandVideoViewControlBar, a aVar) {
            this.iWT = appBrandVideoViewControlBar;
            this.iWS = aVar;
        }

        public final void onClick(View view) {
            AppBrandVideoViewControlBar.a(this.iWT);
            if (this.iWS != null) {
                this.iWS.bV(this.iWT.iWQ);
            }
        }
    }

    public interface a {
        void bV(boolean z);
    }

    public interface b {
        int Ui();

        int Uj();
    }

    static /* synthetic */ void a(AppBrandVideoViewControlBar appBrandVideoViewControlBar) {
        appBrandVideoViewControlBar.iWQ = !appBrandVideoViewControlBar.iWQ;
        appBrandVideoViewControlBar.Um();
    }

    public AppBrandVideoViewControlBar(Context context) {
        super(context);
    }

    public AppBrandVideoViewControlBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AppBrandVideoViewControlBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected final int getLayoutId() {
        return R.i.cUA;
    }

    protected final void init() {
        super.init();
        this.iWH = (ImageView) this.ipu.findViewById(R.h.bSl);
        this.iWI = (ImageView) this.ipu.findViewById(R.h.bHC);
        this.iWK = (ImageView) this.ipu.findViewById(R.h.crM);
        this.iWL = (FrameLayout) this.ipu.findViewById(R.h.crN);
        this.iWJ = (RelativeLayout) findViewById(R.h.czn);
        if (iWR < 0) {
            iWR = getResources().getDimensionPixelSize(R.f.aYo);
        }
    }

    public final void bX(boolean z) {
        this.fKD = z;
        Ul();
    }

    private void Ul() {
        if (this.iWP) {
            if (this.fKD) {
                this.puQ.setImageResource(R.k.dtP);
            } else {
                this.puQ.setImageResource(R.k.dtO);
            }
        } else if (this.fKD) {
            this.puQ.setImageResource(R.k.dtS);
        } else {
            this.puQ.setImageResource(R.k.dtR);
        }
    }

    final void Um() {
        if (this.iWP) {
            if (this.iWQ) {
                this.iWI.setImageResource(R.k.dtM);
            } else {
                this.iWI.setImageResource(R.k.dtL);
            }
        } else if (this.iWQ) {
            this.iWI.setImageResource(R.k.dtK);
        } else {
            this.iWI.setImageResource(R.k.dtJ);
        }
    }

    public final void Un() {
        setVisibility(0);
        if (this.iWN == null) {
            this.iWN = new aj(new com.tencent.mm.sdk.platformtools.aj.a(this) {
                final /* synthetic */ AppBrandVideoViewControlBar iWT;

                {
                    this.iWT = r1;
                }

                public final boolean oQ() {
                    this.iWT.setVisibility(8);
                    this.iWT.iWN.KH();
                    return false;
                }
            }, false);
        }
        this.iWN.KH();
        this.iWN.v(7000, 7000);
    }

    public final void Uo() {
        if ((getVisibility() == 0 ? 1 : null) != null) {
            setVisibility(8);
        } else {
            Un();
        }
    }

    public final void Uk() {
        this.iWP = false;
        Up();
    }

    final void Up() {
        LayoutParams layoutParams = this.iWJ.getLayoutParams();
        if (this.iWP) {
            layoutParams.height = getResources().getDimensionPixelSize(R.f.aYm);
        } else {
            layoutParams.height = getResources().getDimensionPixelSize(R.f.aYk);
        }
        this.iWJ.setLayoutParams(layoutParams);
        Um();
        if (this.iWP) {
            this.iWH.setImageResource(R.k.dtN);
        } else {
            this.iWH.setImageResource(R.k.dtQ);
        }
        Ul();
        float dimensionPixelSize = this.iWP ? (float) getResources().getDimensionPixelSize(R.f.aYn) : (float) getResources().getDimensionPixelSize(R.f.aYl);
        this.puR.setTextSize(0, dimensionPixelSize);
        this.puS.setTextSize(0, dimensionPixelSize);
    }

    final boolean Uq() {
        if (this.iWM == null) {
            w.i("MicroMsg.AppBrandVideoViewControlBar", "updateMiddleBar mStatePorter null");
            return false;
        }
        int Ui = this.iWM.Ui();
        int Uj = this.iWM.Uj();
        if (Ui < 0 || Uj < 0) {
            return false;
        }
        int width = this.iWL.getWidth();
        if (width <= 0) {
            return true;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.iWK.getLayoutParams();
        if (Uj != 0) {
            width = (int) (((float) width) * (1.0f - (((float) Ui) / ((float) Uj))));
        }
        if (width <= 0) {
            width = 0;
        }
        layoutParams.rightMargin = width + iWR;
        this.iWK.setLayoutParams(layoutParams);
        if (Ui < Uj || Uj == 0) {
            return true;
        }
        return false;
    }
}
