package com.tencent.mm.plugin.webview.ui.tools.widget.input;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.view.ViewPager.e;
import android.support.v4.view.u;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMDotView;

public class WebViewSmileyPanel extends LinearLayout implements e, com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewSmileyViewPager.a {
    private View Ih = null;
    private boolean juQ = false;
    private MMDotView kSg;
    private MMActivity kdb;
    private c sof;
    private a soo;
    private WebViewSmileyViewPager sop = null;
    private boolean soq = true;

    public interface a {
        void Zh();

        void append(String str);
    }

    public final void a(int i, float f, int i2) {
    }

    public final void V(int i) {
        a bAk = this.sof.bAk();
        int pageCount = bAk.getPageCount();
        int i2 = i - bAk.kTH;
        if (pageCount <= 1) {
            this.kSg.setVisibility(4);
            return;
        }
        this.kSg.setVisibility(0);
        this.kSg.Ad(pageCount);
        this.kSg.Ae(i2);
    }

    public final void W(int i) {
    }

    public final void bAg() {
        if (this.sop != null) {
            this.sof.soq = j.aF(getContext());
            b bVar = (b) this.sop.yr;
            if (bVar != null) {
                bVar.sow.clear();
                bVar.sof = this.sof;
                bVar.notifyDataSetChanged();
            } else {
                u bVar2 = new b();
                bVar2.sof = this.sof;
                this.sop.a(bVar2);
            }
            this.sop.post(new Runnable(this) {
                final /* synthetic */ WebViewSmileyPanel sor;

                {
                    this.sor = r1;
                }

                public final void run() {
                    this.sor.V(this.sor.sop.ys);
                }
            });
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        bAj();
    }

    public void onMeasure(int i, int i2) {
        if (this.juQ) {
            super.onMeasure(i, MeasureSpec.makeMeasureSpec(0, Integer.MIN_VALUE));
            return;
        }
        j.aF(getContext());
        super.onMeasure(i, i2);
    }

    @SuppressLint({"WrongCall"})
    public final void bB(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public WebViewSmileyPanel(Context context) {
        super(context, null);
        init();
    }

    public WebViewSmileyPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public final void a(a aVar) {
        this.soo = aVar;
        this.sof.sot = this.soo;
    }

    public final void onDestroy() {
        c cVar = this.sof;
        cVar.sos = null;
        cVar.kLX = null;
        if (this.Ih != null) {
            ((ViewGroup) this.Ih.getParent()).removeView(this.Ih);
            ((ViewGroup) this.Ih).removeAllViews();
            this.Ih = null;
        }
        this.kdb = null;
    }

    public final void bAh() {
        if (this.Ih != null) {
            this.Ih.setVisibility(0);
        }
    }

    public final void bAi() {
        if (this.Ih != null) {
            this.Ih.setVisibility(4);
        }
    }

    private void init() {
        this.kdb = (MMActivity) getContext();
        this.sof = YV();
        this.sof.kLX = getContext();
        this.sof.sot = this.soo;
    }

    public c YV() {
        return new c();
    }

    public void setVisibility(int i) {
        if (i == 0) {
            this.juQ = false;
        } else {
            this.juQ = true;
        }
        super.setVisibility(i);
        if (!this.juQ) {
            this.kdb.aHf();
            KC();
        }
    }

    public final void iU(int i) {
        super.setVisibility(i);
    }

    public final void KC() {
        if (this.Ih == null || getChildCount() <= 0) {
            if (this.Ih == null) {
                this.Ih = View.inflate(ab.getContext(), R.i.drR, null);
            } else if (this.Ih.getParent() != null) {
                ((ViewGroup) this.Ih.getParent()).removeView(this.Ih);
            }
            this.sop = (WebViewSmileyViewPager) this.Ih.findViewById(R.h.cFN);
            this.sop.b(this);
            this.sop.sof = this.sof;
            this.sop.sov = this;
            this.kSg = (MMDotView) this.Ih.findViewById(R.h.cFK);
            this.kSg.Ad(1);
            bAj();
            addView(this.Ih, new LayoutParams(-1, -1));
            return;
        }
        this.Ih.setVisibility(0);
    }

    private void bAj() {
        if (this.kSg != null) {
            boolean aF = j.aF(getContext());
            if (aF != this.soq) {
                RelativeLayout.LayoutParams layoutParams;
                if (aF) {
                    this.kSg.setPadding(0, 0, 0, getContext().getResources().getDimensionPixelSize(R.f.aXz));
                    layoutParams = (RelativeLayout.LayoutParams) this.kSg.getLayoutParams();
                    layoutParams.bottomMargin = getContext().getResources().getDimensionPixelSize(R.f.aZK);
                    this.kSg.setLayoutParams(layoutParams);
                } else {
                    this.kSg.setPadding(0, 0, 0, getContext().getResources().getDimensionPixelSize(R.f.aXx));
                    layoutParams = (RelativeLayout.LayoutParams) this.kSg.getLayoutParams();
                    layoutParams.bottomMargin = 0;
                    this.kSg.setLayoutParams(layoutParams);
                }
                this.soq = aF;
            }
        }
    }
}
