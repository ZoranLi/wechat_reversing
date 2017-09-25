package com.tencent.mm.plugin.card.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.ck;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.b.m;
import com.tencent.mm.protocal.c.bik;
import com.tencent.mm.protocal.c.lz;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.Iterator;

public final class b extends a {
    private final String TAG = "MicroMsg.CardWidgetCommon";
    protected TextView iUO;
    private boolean kpB = false;
    protected Button krA;
    protected LinearLayout krB;
    protected TextView krC;
    protected ImageView krD;
    protected View krE;
    protected ImageView krF;
    protected TextView kry;
    protected TextView krz;

    public b(Context context) {
        super(context);
    }

    protected final void aiS() {
        this.iUO = (TextView) this.krv.findViewById(R.h.byE);
        this.kry = (TextView) this.krv.findViewById(R.h.byy);
        this.krz = (TextView) this.krv.findViewById(R.h.bwd);
        this.krA = (Button) this.krv.findViewById(R.h.bwD);
        this.krB = (LinearLayout) this.krv.findViewById(R.h.cTd);
        this.krD = (ImageView) this.krB.findViewById(R.h.bpP);
        this.krE = this.krv.findViewById(R.h.bwj);
        this.krF = (ImageView) this.krv.findViewById(R.h.bwy);
        this.krC = (TextView) this.krv.findViewById(R.h.bxS);
    }

    protected final void aiT() {
        if (this.kcX.afi().toj != null && this.kcX.afi().toj.size() > 0) {
            lz lzVar = (lz) this.kcX.afi().toj.get(0);
            if (!bg.mA(lzVar.title)) {
                this.iUO.setText(lzVar.title);
            }
            if (bg.mA(lzVar.kdH)) {
                this.kry.setVisibility(8);
            } else {
                this.kry.setText(lzVar.kdH);
                this.kry.setVisibility(0);
            }
            LayoutParams layoutParams = (LayoutParams) this.kry.getLayoutParams();
            if (bg.mA(lzVar.kdI)) {
                this.krz.setVisibility(8);
                layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(R.f.aXu);
            } else {
                this.krz.setText(lzVar.kdI);
                this.krz.setVisibility(0);
                layoutParams.bottomMargin = 0;
            }
            this.kry.setLayoutParams(layoutParams);
            this.kry.invalidate();
        }
        if (this.krA == null || this.krF == null) {
            w.e("MicroMsg.CardWidgetCommon", "consumeBtn == null || mCardCodeImg == null");
        } else if (this.kcX.afj() == null) {
            w.e("MicroMsg.CardWidgetCommon", "mCardInfo.getDataInfo() == null");
            this.krA.setVisibility(8);
            this.krF.setVisibility(8);
        } else {
            if (this.kcX.afj().tnO != null) {
                w.i("MicroMsg.CardWidgetCommon", "operate_field.title is " + this.kcX.afj().tnO.title);
                w.d("MicroMsg.CardWidgetCommon", "operate_field.url is " + this.kcX.afj().tnO.url);
                w.i("MicroMsg.CardWidgetCommon", "operate_field.aux_title is " + this.kcX.afj().tnO.kdI);
            }
            lz lzVar2 = this.kcX.afj().tnP;
            if (lzVar2 != null) {
                w.i("MicroMsg.CardWidgetCommon", "limit_field.title is " + lzVar2.title);
                w.i("MicroMsg.CardWidgetCommon", "limit_field.show_flag is " + lzVar2.tpl);
                w.i("MicroMsg.CardWidgetCommon", "limit_field.aux_title is " + lzVar2.kdI);
            }
            bik com_tencent_mm_protocal_c_bik = this.kcX.afi().toD;
            LinearLayout linearLayout = (LinearLayout) this.krB.findViewById(R.h.bwM);
            if (com_tencent_mm_protocal_c_bik == null || bg.bV(com_tencent_mm_protocal_c_bik.uhV)) {
                linearLayout.setVisibility(8);
            } else {
                linearLayout.setVisibility(0);
                linearLayout.removeAllViews();
                Iterator it = com_tencent_mm_protocal_c_bik.uhV.iterator();
                while (it.hasNext()) {
                    lz lzVar3 = (lz) it.next();
                    View inflate = LayoutInflater.from(this.mContext).inflate(R.i.cWs, null);
                    TextView textView = (TextView) inflate.findViewById(R.h.bwL);
                    ((TextView) inflate.findViewById(R.h.bwP)).setText(lzVar3.title);
                    textView.setText(lzVar3.kdH);
                    linearLayout.addView(inflate);
                }
            }
            if (lzVar2 != null && !TextUtils.isEmpty(lzVar2.title) && lzVar2.tpl != 0 && this.kcX.afe()) {
                this.krA.setClickable(false);
                this.krA.setVisibility(0);
                this.krA.setTextColor(this.mContext.getResources().getColor(R.e.aWx));
                this.krA.setText(lzVar2.title);
                if (lzVar2 == null || TextUtils.isEmpty(lzVar2.kdH)) {
                    this.krC.setVisibility(8);
                } else {
                    this.krC.setText(lzVar2.kdH);
                    this.krC.setVisibility(0);
                }
                this.krF.setVisibility(8);
                if ((lzVar2.tpl & 2) > 0) {
                    this.krA.setBackgroundDrawable(l.u(this.mContext, l.aF(this.kcX.afi().hib, ck.CTRL_INDEX)));
                    this.krC.setTextColor(l.ta(this.kcX.afi().hib));
                } else if ((lzVar2.tpl & 4) > 0) {
                    this.krA.setBackgroundDrawable(l.u(this.mContext, this.mContext.getResources().getColor(R.e.aUx)));
                    this.krC.setTextColor(this.mContext.getResources().getColor(R.e.aVl));
                } else {
                    this.krA.setBackgroundDrawable(l.u(this.mContext, l.ta(this.kcX.afi().hib)));
                    this.krC.setTextColor(this.mContext.getResources().getColor(R.e.aVl));
                }
            } else if (this.kcX.afj().tnO != null && !TextUtils.isEmpty(this.kcX.afj().tnO.title) && !TextUtils.isEmpty(this.kcX.afj().tnO.url) && this.kcX.afe()) {
                this.krA.setClickable(true);
                this.krA.setVisibility(0);
                this.krA.setBackgroundDrawable(l.u(this.mContext, l.ta(this.kcX.afi().hib)));
                this.krA.setTextColor(this.mContext.getResources().getColorStateList(R.e.aWx));
                this.krA.setText(this.kcX.afj().tnO.title);
                if (this.kcX.afj().tnO == null || TextUtils.isEmpty(this.kcX.afj().tnO.kdI)) {
                    this.krC.setVisibility(8);
                } else {
                    this.krC.setTextColor(this.mContext.getResources().getColor(R.e.aVl));
                    this.krC.setText(this.kcX.afj().tnO.kdI);
                    this.krC.setVisibility(0);
                }
                if (TextUtils.isEmpty(this.kcX.afj().code)) {
                    this.krF.setVisibility(8);
                } else {
                    this.krF.setVisibility(0);
                }
            } else if (!TextUtils.isEmpty(this.kcX.afj().code) && this.kcX.afe()) {
                w.i("MicroMsg.CardWidgetCommon", "mCardInfo.getDataInfo().code is valid");
                this.krF.setVisibility(8);
                this.krC.setVisibility(8);
                this.krA.setClickable(true);
                this.krA.setVisibility(0);
                this.krA.setBackgroundDrawable(l.u(this.mContext, l.ta(this.kcX.afi().hib)));
                this.krA.setTextColor(this.mContext.getResources().getColorStateList(R.e.aWx));
                this.krA.setText(R.l.dSh);
            } else if (this.kcX.afe()) {
                w.i("MicroMsg.CardWidgetCommon", "operate_field and code is empty!");
                this.krA.setVisibility(8);
                this.krC.setVisibility(8);
                this.krF.setVisibility(8);
            } else {
                w.i("MicroMsg.CardWidgetCommon", "mCardInfo.getDataInfo().status is " + this.kcX.afj().status);
                this.krF.setVisibility(8);
                this.krC.setVisibility(8);
                this.krA.setClickable(true);
                this.krA.setVisibility(0);
                this.krA.setTextColor(this.mContext.getResources().getColor(R.e.aUf));
                this.krA.setBackgroundDrawable(l.u(this.mContext, this.mContext.getResources().getColor(R.e.aTf)));
                if (TextUtils.isEmpty(this.kcX.afi().toI)) {
                    m.b(this.krA, this.kcX.afj().status);
                } else {
                    this.krA.setText(this.kcX.afi().toI);
                }
            }
        }
        aiU();
        this.krB.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.g.bdE));
        aiV();
        this.krv.invalidate();
    }

    private void aiU() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.krB.getLayoutParams();
        if (this.kcX.aeN()) {
            this.krw.setVisibility(0);
            this.krD.setVisibility(8);
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(R.f.aYA);
        } else if (this.kcX.aeO() && this.kpB) {
            this.krw.setVisibility(8);
            this.krD.setVisibility(8);
            layoutParams.topMargin = 0;
        } else if (this.kcX.aeO()) {
            this.krw.setVisibility(0);
            this.krD.setVisibility(8);
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(R.f.aYA);
        }
        this.krB.setLayoutParams(layoutParams);
    }

    public final void kI(int i) {
        RelativeLayout.LayoutParams layoutParams;
        this.krB.setBackgroundResource(i);
        this.krD.setVisibility(8);
        if (i == 0) {
            layoutParams = (RelativeLayout.LayoutParams) this.krB.getLayoutParams();
            if (this.kcX.aeN()) {
                this.krw.setVisibility(8);
                layoutParams.topMargin = 0;
                this.krD.setVisibility(0);
                m.a(this.krD, this.kcX.afi().kdG, this.mContext.getResources().getDimensionPixelSize(R.f.aYw), R.g.bhq, false);
            } else if (this.kcX.aeO() && this.kpB) {
                this.krw.setVisibility(8);
                layoutParams.topMargin = 0;
            }
            this.krB.setLayoutParams(layoutParams);
            this.krB.invalidate();
        } else {
            aiU();
        }
        aiV();
        layoutParams = (RelativeLayout.LayoutParams) this.krE.getLayoutParams();
        if (i == 0) {
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
        } else {
            layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(R.f.aWG);
            layoutParams.rightMargin = this.mContext.getResources().getDimensionPixelSize(R.f.aWG);
        }
        this.krE.setLayoutParams(layoutParams);
        this.krE.invalidate();
        this.krv.invalidate();
    }

    private void aiV() {
        LayoutParams layoutParams = (LayoutParams) this.krA.getLayoutParams();
        if (this.kcX.afj().tnO != null && !TextUtils.isEmpty(this.kcX.afj().tnO.kdI)) {
            layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(R.f.aXH);
        } else if (this.kcX.afj().tnP != null && !TextUtils.isEmpty(this.kcX.afj().tnP.kdH)) {
            layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(R.f.aXH);
        } else if (this.kcX.afi().toj == null || this.kcX.afi().toj.size() <= 0) {
            layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(R.f.aXu);
        } else {
            layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(R.f.aXH);
        }
        this.krA.setLayoutParams(layoutParams);
    }

    public final void setOnClickListener(OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        if (this.krA != null) {
            this.krA.setOnClickListener(onClickListener);
        }
        if (this.krF != null) {
            this.krF.setOnClickListener(onClickListener);
        }
    }

    public final void i(boolean z, boolean z2) {
        if (this.krA != null) {
            lz lzVar = this.kcX.afj().tnP;
            if (lzVar != null && !TextUtils.isEmpty(lzVar.title) && lzVar.tpl != 0 && this.kcX.afe()) {
                this.krA.setClickable(false);
                this.krA.setVisibility(0);
                this.krF.setVisibility(8);
            } else if (this.kcX.afj().tnO != null && !TextUtils.isEmpty(this.kcX.afj().tnO.title) && !TextUtils.isEmpty(this.kcX.afj().tnO.url) && this.kcX.afe()) {
                this.krA.setVisibility(0);
                this.krA.setEnabled(true);
                if (TextUtils.isEmpty(this.kcX.afj().code) || this.kcX.afj().tnG == 0) {
                    this.krF.setVisibility(8);
                } else {
                    this.krF.setVisibility(0);
                }
            } else if (z && !TextUtils.isEmpty(this.kcX.afj().code) && this.kcX.afe()) {
                this.krA.setVisibility(0);
                this.krA.setEnabled(z2);
                this.krF.setVisibility(8);
            } else if (!z || this.kcX.afe()) {
                this.krA.setVisibility(8);
                this.krF.setVisibility(8);
            } else {
                this.krA.setVisibility(0);
                this.krA.setEnabled(false);
                this.krF.setVisibility(8);
            }
        }
    }

    public final void aiW() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.krB.getLayoutParams();
        if (this.kcX.aeO()) {
            this.krw.setVisibility(0);
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(R.f.aYA);
        }
        this.krB.setLayoutParams(layoutParams);
        this.krB.invalidate();
    }

    public final void dh(boolean z) {
        this.kpB = z;
        if (z) {
            this.krE.setVisibility(0);
        } else {
            this.krE.setVisibility(8);
        }
    }
}
