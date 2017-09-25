package com.tencent.mm.plugin.card.widget;

import android.content.Context;
import android.graphics.drawable.ShapeDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ah.a.a.c.a;
import com.tencent.mm.ah.n;
import com.tencent.mm.plugin.card.b.m;
import com.tencent.mm.protocal.c.lz;
import com.tencent.mm.sdk.platformtools.w;

public final class e extends a {
    protected TextView ipw;
    private LinearLayout khT;
    private RelativeLayout krR;
    private TextView krS;
    private View krT;
    private ImageView krU;
    private ImageView krV;
    private ImageView krW;
    private ImageView krX;
    private ImageView krY;

    public e(Context context) {
        super(context);
    }

    protected final void aiS() {
        this.ipw = (TextView) aiR().findViewById(R.h.byE);
        this.krR = (RelativeLayout) aiR().findViewById(R.h.bxK);
        this.khT = (LinearLayout) aiR().findViewById(R.h.bwz);
        this.krS = (TextView) aiR().findViewById(R.h.bCY);
        this.krT = aiR().findViewById(R.h.bwx);
        this.krU = (ImageView) aiR().findViewById(R.h.bwy);
        this.krV = (ImageView) this.krv.findViewById(R.h.cjF);
        this.krW = (ImageView) this.krv.findViewById(R.h.cjE);
        this.krX = (ImageView) this.krv.findViewById(R.h.bxH);
        this.krY = (ImageView) this.krv.findViewById(R.h.bxJ);
    }

    protected final void aiT() {
        if (this.krx != null) {
            this.krx.setText(this.kcX.afi().keT);
        }
        if (this.kcX.afi().toj != null && this.kcX.afi().toj.size() > 0) {
            lz lzVar = (lz) this.kcX.afi().toj.get(0);
            if (TextUtils.isEmpty(lzVar.title)) {
                this.ipw.setText("");
            } else {
                this.ipw.setText(lzVar.title);
            }
        }
        if (this.kcX.afe()) {
            dg(true);
            this.krX.setAlpha(255);
            if (this.krX.getBackground() != null) {
                this.krX.getBackground().setAlpha(255);
            }
            String str = this.kcX.afj().code;
            if (!TextUtils.isEmpty(str)) {
                this.krT.setOnClickListener(this.iuW);
                this.krU.setOnClickListener(this.iuW);
                this.krS.setOnClickListener(this.iuW);
                switch (this.kcX.afj().tnG) {
                    case 0:
                        if (str.length() > 40) {
                            this.krS.setText("");
                            break;
                        } else {
                            this.krS.setText(m.ti(str));
                            break;
                        }
                    case 1:
                    case 2:
                        if (str.length() <= 40) {
                            if (!this.kcX.aeX()) {
                                this.krS.setText("");
                                break;
                            } else {
                                this.krS.setText(m.ti(str));
                                break;
                            }
                        }
                        this.krS.setText("");
                        break;
                    default:
                        break;
                }
            }
            w.e("MicroMsg.CardWidgetMembership", "don't updateCodeLayout, code is empty!");
            dg(false);
        } else {
            this.krS.setText("");
            this.krU.setVisibility(8);
            this.krT.setVisibility(8);
            this.krX.setAlpha(90);
            if (this.krX.getBackground() != null) {
                this.krX.getBackground().setAlpha(90);
            }
        }
        LayoutParams layoutParams = this.krR.getLayoutParams();
        layoutParams.height = ((this.mContext.getResources().getDisplayMetrics().widthPixels - (this.mContext.getResources().getDimensionPixelSize(R.f.aXu) * 2)) * 3) / 5;
        w.d("MicroMsg.CardWidgetMembership", "padding:%d,originWidth:%d,targetWidth:%d", new Object[]{Integer.valueOf(r1), Integer.valueOf(r2), Integer.valueOf(r3)});
        this.krR.setLayoutParams(layoutParams);
    }

    public final void i(boolean z, boolean z2) {
    }

    public final void dg(boolean z) {
        if (TextUtils.isEmpty(this.kcX.afj().code) || !z || this.kcX.afj().tnG == 0 || this.kcX.afi().toS) {
            this.krU.setVisibility(8);
            this.krT.setVisibility(8);
            return;
        }
        this.krU.setVisibility(0);
        this.krT.setVisibility(0);
    }

    public final void kI(int i) {
        if (!TextUtils.isEmpty(this.kcX.afj().tnR)) {
            this.krX.setBackgroundDrawable(null);
            this.krY.setVisibility(0);
            aiX();
        } else if (this.krv != null) {
            this.krX.setBackgroundResource(i);
            this.krY.setVisibility(8);
        }
    }

    public final void a(ShapeDrawable shapeDrawable) {
        if (!TextUtils.isEmpty(this.kcX.afj().tnR)) {
            this.krX.setBackgroundDrawable(null);
            this.krY.setVisibility(0);
            aiX();
        } else if (this.krv != null) {
            this.krX.setBackgroundDrawable(shapeDrawable);
            this.krY.setVisibility(8);
        }
    }

    public final void dh(boolean z) {
        if (TextUtils.isEmpty(this.kcX.afj().tnR)) {
            this.krW.setVisibility(0);
            this.krV.setVisibility(0);
            return;
        }
        this.krW.setVisibility(8);
        this.krV.setVisibility(8);
    }

    private void aiX() {
        a aVar = new a();
        aVar.hIO = com.tencent.mm.compatible.util.e.hgu;
        n.GX();
        aVar.hJg = null;
        aVar.hIN = com.tencent.mm.plugin.card.model.m.sw(this.kcX.afj().tnR);
        aVar.hIL = true;
        aVar.hJi = true;
        aVar.hJj = (float) this.mContext.getResources().getDimensionPixelSize(R.f.aYO);
        aVar.hJk = true;
        aVar.hIJ = true;
        aVar.hJa = R.g.bdF;
        n.GW().a(this.kcX.afj().tnR, this.krX, aVar.Hg());
        w.i("MicroMsg.CardWidgetMembership", "the member back ground url is " + this.kcX.afj().tnR);
    }
}
