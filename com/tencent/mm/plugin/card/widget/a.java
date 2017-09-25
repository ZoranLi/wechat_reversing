package com.tencent.mm.plugin.card.widget;

import android.content.Context;
import android.graphics.drawable.ShapeDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.b.m;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public abstract class a implements g {
    protected LayoutInflater Du;
    private final String TAG = "MicroMsg.CardWidgetCouponBase";
    protected OnClickListener iuW;
    protected b kcX;
    protected View krv;
    protected ImageView krw;
    protected TextView krx;
    protected Context mContext;

    protected abstract void aiS();

    protected abstract void aiT();

    public a(Context context) {
        this.mContext = context;
    }

    public final void k(b bVar) {
        this.kcX = bVar;
    }

    public final View aiP() {
        if (this.kcX == null || this.kcX.afi() == null) {
            w.e("MicroMsg.CardWidgetCouponBase", "mCardInfo == null or mCardInfo.getCardTpInfo() == null");
            return null;
        }
        int i;
        this.Du = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        LayoutInflater layoutInflater = this.Du;
        if (!this.kcX.aeQ()) {
            if (this.kcX.aeR()) {
                i = R.i.cXf;
            } else if (this.kcX.aeP()) {
                i = R.i.cWL;
            } else if (this.kcX.aeS()) {
                i = R.i.cWu;
            } else if (this.kcX.aeT()) {
                i = R.i.cWF;
            }
            this.krv = layoutInflater.inflate(i, null);
            this.krw = (ImageView) this.krv.findViewById(R.h.bpG);
            this.krx = (TextView) this.krv.findViewById(R.h.bpJ);
            aiS();
            aiQ();
            return this.krv;
        }
        i = R.i.cWr;
        this.krv = layoutInflater.inflate(i, null);
        this.krw = (ImageView) this.krv.findViewById(R.h.bpG);
        this.krx = (TextView) this.krv.findViewById(R.h.bpJ);
        aiS();
        aiQ();
        return this.krv;
    }

    private void aiQ() {
        if (this.kcX == null || this.kcX.afi() == null) {
            w.e("MicroMsg.CardWidgetCouponBase", "mCardInfo == null or mCardInfo.getCardTpInfo() == null");
            return;
        }
        if (!bg.mA(this.kcX.afi().kdG)) {
            int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.f.aYD);
            if (this.kcX.aeN() && this.kcX.aeQ()) {
                dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.f.aYB);
            } else if (this.kcX.aeN() && this.kcX.aeP()) {
                dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.f.aYQ);
            } else if (this.kcX.aeN() && this.kcX.aeR()) {
                dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.f.aYW);
            } else if (this.kcX.aeT()) {
                dimensionPixelSize = 0;
            }
            if (dimensionPixelSize > 0) {
                m.a(this.krw, this.kcX.afi().kdG, dimensionPixelSize, R.g.bhq, true);
            }
        }
        if (!bg.mA(this.kcX.afi().keT)) {
            this.krx.setText(this.kcX.afi().keT);
        }
        aiT();
    }

    protected final View aiR() {
        return this.krv;
    }

    public final void release() {
        this.iuW = null;
        this.mContext = null;
    }

    public void kI(int i) {
    }

    public void dg(boolean z) {
    }

    public final void f(b bVar) {
        this.kcX = bVar;
        aiQ();
    }

    public void a(ShapeDrawable shapeDrawable) {
    }

    public void dh(boolean z) {
    }

    public void i(boolean z, boolean z2) {
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.iuW = onClickListener;
    }
}
