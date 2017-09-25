package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.s.a.g;
import com.tencent.mm.s.a.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.MMFlipper.a;
import com.tencent.mm.ui.base.MMFlipper.b;
import junit.framework.Assert;

public final class MMGridPaper extends LinearLayout {
    protected View QB;
    protected MMDotView kSg;
    protected int kyn = 0;
    protected int mNumColumns = 0;
    protected ae oPe = new ae(Looper.getMainLooper());
    protected int vgI = 10;
    protected int vgJ = 10;
    protected MMFlipper vjF;
    protected j vjG;
    protected int vjH;
    protected int vjI;
    protected int vjJ = 0;
    protected int vjK = 0;
    protected int vjL = 3;
    protected int vjM = 0;
    protected int vjN = (this.vjL - 1);
    protected int vjO = 0;
    protected boolean vjP = false;
    protected int vjQ = 9;
    protected int vjR = -1;
    protected int vjS = -1;
    protected int vjT = 96;
    protected int vjU = 96;
    protected boolean vjV = false;
    protected boolean vjW = false;
    protected int vjX = -1;
    protected int vjY = -1;
    protected int vjZ = 0;
    final b vjh = new b(this) {
        final /* synthetic */ MMGridPaper vkf;

        {
            this.vkf = r1;
        }

        public final void sh(final int i) {
            w.d("MicroMsg.MMGridPaper", "onScreenChanged:curScreen[%d], topEdge[%d], bottomEdge[%d], virtualPage[%d]", Integer.valueOf(i), Integer.valueOf(this.vkf.vjM), Integer.valueOf(this.vkf.vjN), Integer.valueOf(this.vkf.vjO));
            if (i <= this.vkf.vjM && this.vkf.vjM > 0) {
                this.vkf.oPe.post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass5 vkh;

                    public final void run() {
                        MMGridPaperGridView mMGridPaperGridView = (MMGridPaperGridView) this.vkh.vkf.vjF.getChildAt(this.vkh.vkf.vjF.getChildCount() - 1);
                        w.i("MicroMsg.MMGridPaper", "move up, old index[%d], new index[%d]", Integer.valueOf(this.vkh.vkf.vjF.getChildCount() - 1), Integer.valueOf(i - (this.vkh.vkf.vjF.getChildCount() >> 1)));
                        this.vkh.vkf.vjF.removeViewAt(this.vkh.vkf.vjF.getChildCount() - 1);
                        mMGridPaperGridView.a(r1, this.vkh.vkf.kyn, this.vkh.vkf.mNumColumns, this.vkh.vkf.vjG);
                        this.vkh.vkf.vjF.addView(mMGridPaperGridView, 0);
                        this.vkh.vkf.vjF.Af(this.vkh.vkf.vjF.getChildCount() >> 1);
                        MMGridPaper.a(this.vkh.vkf, -1);
                    }
                });
            } else if (i >= this.vkf.vjN && this.vkf.vjN < this.vkf.vjO - 1) {
                this.vkf.oPe.post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass5 vkh;

                    public final void run() {
                        MMGridPaperGridView mMGridPaperGridView = (MMGridPaperGridView) this.vkh.vkf.vjF.getChildAt(0);
                        w.i("MicroMsg.MMGridPaper", "move down, old index[0], new index[%d]", Integer.valueOf(i + (this.vkh.vkf.vjF.getChildCount() >> 1)));
                        this.vkh.vkf.vjF.removeViewAt(0);
                        mMGridPaperGridView.a(r1, this.vkh.vkf.kyn, this.vkh.vkf.mNumColumns, this.vkh.vkf.vjG);
                        this.vkh.vkf.vjF.addView(mMGridPaperGridView);
                        this.vkh.vkf.vjF.Af(this.vkh.vkf.vjF.getChildCount() >> 1);
                        MMGridPaper.a(this.vkh.vkf, 1);
                    }
                });
            }
            this.vkf.vjK = i;
            this.vkf.kSg.Ae(i);
        }
    };
    final a vji = new a(this) {
        final /* synthetic */ MMGridPaper vkf;

        {
            this.vkf = r1;
        }

        public final void cN(int i, int i2) {
            w.v("MicroMsg.MMGridPaper", "onMeasure width:[new %d, old %d] height:[new %d, old %d], dialogMode[%B], orientationChange[%B]", Integer.valueOf(i), Integer.valueOf(this.vkf.vjH), Integer.valueOf(i2), Integer.valueOf(this.vkf.vjI), Boolean.valueOf(this.vkf.vjW), Boolean.valueOf(this.vkf.vjV));
            if ((Math.abs(this.vkf.vjI - i2) < 50 && Math.abs(this.vkf.vjH - i) < 50) || i2 == 0 || i == 0) {
                w.d("MicroMsg.MMGridPaper", "match width height limit, return");
            } else if (!this.vkf.vjW || this.vkf.vjH <= i || this.vkf.vjV) {
                w.v("MicroMsg.MMGridPaper", "onMeasure: match");
                w.v("MicroMsg.MMGridPaper", "onMeasure: mIsManualMeasureMode[%b]", Boolean.valueOf(this.vkf.vkc));
                this.vkf.vjV = false;
                if (!this.vkf.vkc) {
                    this.vkf.vjI = i2;
                    this.vkf.vjH = i;
                }
                this.vkf.refresh();
            } else {
                w.d("MicroMsg.MMGridPaper", "match ori limit, return");
            }
        }
    };
    protected int vka = -1;
    protected int vkb = -1;
    protected boolean vkc = false;
    protected int vkd = 0;
    protected int vke = 0;

    static /* synthetic */ void a(MMGridPaper mMGridPaper, int i) {
        mMGridPaper.vjM += i;
        if (mMGridPaper.vjM < 0) {
            mMGridPaper.vjM = 0;
        } else if (mMGridPaper.vjM > mMGridPaper.vjO - mMGridPaper.vjL) {
            mMGridPaper.vjM = mMGridPaper.vjO - mMGridPaper.vjL;
        }
        mMGridPaper.vjN = (mMGridPaper.vjM + mMGridPaper.vjL) - 1;
    }

    public MMGridPaper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        View.inflate(getContext(), h.hei, this);
        this.vjZ = bFh();
    }

    public final void bRU() {
        this.vjT = 70;
    }

    public final void bRV() {
        this.vjU = 70;
    }

    public final void bRW() {
        this.vkb = 3;
    }

    public final void Ai(int i) {
        this.vka = i;
    }

    public final void bRX() {
        this.vjW = true;
    }

    public final void bRY() {
        this.vjY = 3;
        this.vjX = 3;
    }

    public final void bRZ() {
        this.vgI = 8;
        this.vgJ = 15;
    }

    public final void bSa() {
        this.QB = null;
        ViewGroup viewGroup = (ViewGroup) findViewById(g.hcr);
        viewGroup.removeAllViews();
        if (this.QB != null) {
            viewGroup.addView(this.QB);
        }
    }

    public final void a(j jVar) {
        boolean z = true;
        this.vjG = jVar;
        String str = "MicroMsg.MMGridPaper";
        String str2 = "setGridPaperAdapter:adapter is null[%B]";
        Object[] objArr = new Object[1];
        if (jVar != null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        w.d(str, str2, objArr);
        if (this.vjG != null) {
            this.vjG.vki = new j.a(this) {
                final /* synthetic */ MMGridPaper vkf;

                {
                    this.vkf = r1;
                }

                public final void bSe() {
                    this.vkf.refresh();
                }
            };
        }
        bFi();
    }

    public final void refresh() {
        this.vjJ = (this.vjK * this.mNumColumns) * this.kyn;
        w.v("MicroMsg.MMGridPaper", "refreshed:virtualPage[%d], col[%d], row[%d], scrollCount[%d]", Integer.valueOf(this.vjK), Integer.valueOf(this.mNumColumns), Integer.valueOf(this.kyn), Integer.valueOf(this.vjJ));
        bFi();
    }

    private int bFh() {
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        if (defaultDisplay.getWidth() < defaultDisplay.getHeight()) {
            return 1;
        }
        return 2;
    }

    private void bSb() {
        View findViewById;
        LayoutParams layoutParams;
        int fromDPToPix;
        if (-1 != this.vjR && bFh() == 2) {
            findViewById = findViewById(g.hco);
            layoutParams = (LayoutParams) findViewById.getLayoutParams();
            fromDPToPix = com.tencent.mm.bg.a.fromDPToPix(getContext(), this.vjR);
            if (fromDPToPix != layoutParams.height) {
                w.i("MicroMsg.MMGridPaper", "set land mode, special height is %d", Integer.valueOf(this.vjR));
                layoutParams.height = fromDPToPix;
                findViewById.setLayoutParams(layoutParams);
                this.oPe.post(new Runnable(this) {
                    final /* synthetic */ MMGridPaper vkf;

                    {
                        this.vkf = r1;
                    }

                    public final void run() {
                        w.w("MicroMsg.MMGridPaper", "post do setDotView");
                        this.vkf.bSd();
                    }
                });
            }
        } else if (-1 != this.vjS && bFh() == 1) {
            findViewById = findViewById(g.hco);
            layoutParams = (LayoutParams) findViewById.getLayoutParams();
            fromDPToPix = com.tencent.mm.bg.a.fromDPToPix(getContext(), this.vjS);
            if (fromDPToPix != layoutParams.height) {
                w.i("MicroMsg.MMGridPaper", "set port mode, special height is %d", Integer.valueOf(this.vjS));
                layoutParams.height = fromDPToPix;
                findViewById.setLayoutParams(layoutParams);
                this.oPe.post(new Runnable(this) {
                    final /* synthetic */ MMGridPaper vkf;

                    {
                        this.vkf = r1;
                    }

                    public final void run() {
                        w.w("MicroMsg.MMGridPaper", "post do setDotView");
                        this.vkf.bSd();
                    }
                });
            }
        }
    }

    private void bFi() {
        w.v("MicroMsg.MMGridPaper", "MMGridPaper initFlipper");
        if (this.kSg == null) {
            this.kSg = (MMDotView) findViewById(g.hcp);
            MMDotView mMDotView = this.kSg;
            w.d("MicroMsg.MMDotView", "setMaxCount:%d", Integer.valueOf(this.vjQ));
            mMDotView.gMU = r1;
        }
        if (this.vjF == null) {
            this.vjF = (MMFlipper) findViewById(g.hcq);
            this.vjF.vji = this.vji;
            this.vjF.vjh = this.vjh;
        }
        bSb();
        bSc();
    }

    private void bSc() {
        w.v("MicroMsg.MMGridPaper", "initSubGrid, grid width %d, grid height %d", Integer.valueOf(this.vjH), Integer.valueOf(this.vjI));
        if (this.vjH == 0 || this.vjI == 0) {
            w.w("MicroMsg.MMGridPaper", "initSubGrid:gridWithd or gridHeight is 0");
            return;
        }
        boolean z;
        int min;
        int fromDPToPix = com.tencent.mm.bg.a.fromDPToPix(getContext(), this.vjT);
        int fromDPToPix2 = com.tencent.mm.bg.a.fromDPToPix(getContext(), this.vjU);
        fromDPToPix = Math.max(this.vjH / fromDPToPix, 1);
        fromDPToPix2 = Math.max(this.vjI / fromDPToPix2, 1);
        if (!(fromDPToPix == this.mNumColumns && fromDPToPix2 == this.kyn)) {
            this.vjP = true;
        }
        this.mNumColumns = fromDPToPix;
        if (this.vka != -1) {
            this.mNumColumns = Math.min(this.mNumColumns, this.vka);
        }
        this.kyn = fromDPToPix2;
        if (this.vkb != -1) {
            this.kyn = Math.min(this.kyn, this.vkb);
        }
        int i = this.mNumColumns * this.kyn;
        this.vjO = 0;
        fromDPToPix2 = (this.vjG == null ? 0 : this.vjG.getCount()) + 0;
        w.d("MicroMsg.MMGridPaper", "totalCount is %d, dialogMode is %B", Integer.valueOf(fromDPToPix2), Boolean.valueOf(this.vjW));
        if (fromDPToPix2 >= 0) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        if (this.vjW) {
            fromDPToPix = dW(fromDPToPix2, this.mNumColumns);
            switch (bFh()) {
                case 1:
                    min = ((this.vjU + 10) * Math.min(fromDPToPix, this.vjX)) + 8;
                    w.d("MicroMsg.MMGridPaper", "orientation[%d], minRows[%d], targetHeight[%d], displayHeight[%d], orientationChange[%B]", Integer.valueOf(bFh()), Integer.valueOf(Math.min(fromDPToPix, this.vjX)), Integer.valueOf(min), Integer.valueOf(this.vjS), Boolean.valueOf(this.vjV));
                    if (this.vjS == min) {
                        z = true;
                        break;
                    }
                    this.vjS = min;
                    z = false;
                    break;
                case 2:
                    min = ((this.vjU + 10) * Math.min(fromDPToPix, this.vjY)) + 8;
                    w.d("MicroMsg.MMGridPaper", "orientation[%d], minRows[%d], targetHeight[%d], displayHeight[%d], orientationChange[%B]", Integer.valueOf(bFh()), Integer.valueOf(Math.min(fromDPToPix, this.vjY)), Integer.valueOf(min), Integer.valueOf(this.vjR), Boolean.valueOf(this.vjV));
                    if (this.vjR == min) {
                        z = true;
                        break;
                    }
                    this.vjR = min;
                    z = false;
                    break;
            }
        }
        z = true;
        if (z) {
            this.vjO = dW(fromDPToPix2, i);
            min = this.vjO - 1;
            int i2 = this.vjJ;
            if (i2 == 0 || i <= 0) {
                w.w("MicroMsg.MMGridPaper", "floor:total[%d], length[%d]", Integer.valueOf(i2), Integer.valueOf(i));
                fromDPToPix = 0;
            } else {
                fromDPToPix2 = i2;
                fromDPToPix = 0;
                while (fromDPToPix2 >= i) {
                    fromDPToPix2 -= i;
                    fromDPToPix++;
                }
                w.i("MicroMsg.MMGridPaper", "floor:num[%d], length[%d], result[%d]", Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(fromDPToPix));
            }
            this.vjK = Math.min(min, fromDPToPix);
            this.vjL = Math.min(3, this.vjO);
            this.vjM = Math.min(this.vjO - this.vjL, Math.max(0, this.vjK - (this.vjL >> 1)));
            this.vjN = (this.vjM + this.vjL) - 1;
            w.d("MicroMsg.MMGridPaper", "initSubGrid:item[%ddp,%ddp], row[%d], column[%d], activePage[%d], virtualPage[%d], curVirtualPage[%d], edge[%d, %d]", Integer.valueOf(this.vjT), Integer.valueOf(this.vjU), Integer.valueOf(this.kyn), Integer.valueOf(this.mNumColumns), Integer.valueOf(this.vjL), Integer.valueOf(this.vjO), Integer.valueOf(this.vjK), Integer.valueOf(this.vjM), Integer.valueOf(this.vjN));
            MMGridPaperGridView mMGridPaperGridView;
            if (this.vjF.getChildCount() != this.vjL || this.vjP) {
                w.w("MicroMsg.MMGridPaper", "error child count or RowOrColChanged(%B), reset child view", Boolean.valueOf(this.vjP));
                this.vjP = false;
                this.vjF.removeAllViews();
                for (int i3 = this.vjM; i3 <= this.vjN; i3++) {
                    mMGridPaperGridView = (MMGridPaperGridView) inflate(getContext(), h.heg, null);
                    mMGridPaperGridView.a(i3, this.kyn, this.mNumColumns, this.vjG);
                    mMGridPaperGridView.setHorizontalSpacing(com.tencent.mm.bg.a.fromDPToPix(getContext(), this.vgI));
                    mMGridPaperGridView.setVerticalSpacing(com.tencent.mm.bg.a.fromDPToPix(getContext(), this.vgJ));
                    this.vjF.addView(mMGridPaperGridView, new LayoutParams(-1, -1));
                }
            } else {
                for (fromDPToPix2 = this.vjM; fromDPToPix2 <= this.vjN; fromDPToPix2++) {
                    mMGridPaperGridView = (MMGridPaperGridView) this.vjF.getChildAt(fromDPToPix2 - this.vjM);
                    if (mMGridPaperGridView.mIndex != fromDPToPix2) {
                        w.w("MicroMsg.MMGridPaper", "old index %d, new index %d, reset it", Integer.valueOf(mMGridPaperGridView.mIndex), Integer.valueOf(fromDPToPix2));
                        mMGridPaperGridView.a(fromDPToPix2, this.kyn, this.mNumColumns, this.vjG);
                        if (mMGridPaperGridView.vko != null) {
                            mMGridPaperGridView.vko.notifyDataSetChanged();
                        }
                    } else {
                        w.v("MicroMsg.MMGridPaper", "same grid index, continus");
                    }
                }
            }
            bSd();
            return;
        }
        bSb();
    }

    private static int dW(int i, int i2) {
        if (i2 <= 0) {
            w.w("MicroMsg.MMGridPaper", "ceil:total[%d], length[%d]", Integer.valueOf(i), Integer.valueOf(i2));
            return 0;
        }
        int i3 = i;
        int i4 = 0;
        while (i3 > 0) {
            i3 -= i2;
            i4++;
        }
        w.i("MicroMsg.MMGridPaper", "ceil:num[%d], length[%d], result[%d]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i4));
        return i4;
    }

    private void bSd() {
        w.v("MicroMsg.MMGridPaper", "set DotView");
        Assert.assertTrue(this.vjO >= 0);
        this.kSg.Ad(this.vjO);
        if (this.vjG == null || this.vjO <= 1) {
            this.kSg.setVisibility(8);
            w.v("MicroMsg.MMGridPaper", "set DotView gone");
        } else {
            this.kSg.setVisibility(0);
            w.v("MicroMsg.MMGridPaper", "set DotView visible");
        }
        if (this.vjK >= this.vjO) {
            this.vjK = this.vjO - 1;
        }
        this.vjF.Af(this.vjK - this.vjM);
        this.vjF.Ag(this.vjK);
        this.kSg.Ae(this.vjK);
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        w.d("MicroMsg.MMGridPaper", "onLayout left=%s top=%s right=%s bottom=%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        if (this.vjZ != bFh()) {
            this.vjZ = bFh();
            w.d("MicroMsg.MMGridPaper", "onLayout, currentOrientation changed, reAdjustDisplayArea");
            this.vjV = true;
            clearAnimation();
            bSb();
            bSc();
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    @TargetApi(8)
    public final void onConfigurationChanged(Configuration configuration) {
        if (configuration.orientation == 1 || configuration.orientation == 2) {
            w.d("MicroMsg.MMGridPaper", "onConfigChanged:" + configuration.orientation);
            this.vjV = true;
        }
    }
}
