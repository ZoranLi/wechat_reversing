package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.e.a.lv;
import com.tencent.mm.e.b.af;
import com.tencent.mm.plugin.sns.b.m;
import com.tencent.mm.protocal.c.alh;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.storage.an;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.g;
import com.tencent.mm.ui.widget.QDisFadeImageView;
import java.util.LinkedList;
import java.util.List;

public final class SnsPreference extends Preference implements g {
    private MMActivity fCi;
    private List<alh> fRK;
    private int lAi;
    private String mTitle;
    private an pQT;
    private QDisFadeImageView sSV;
    private QDisFadeImageView sSW;
    private QDisFadeImageView sSX;
    private ImageView sSY;
    private ImageView sSZ;
    private ImageView sTa;
    private a sTb;

    static class a extends ColorDrawable {
        public a() {
            super(-7829368);
        }
    }

    public SnsPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        this.fCi = (MMActivity) context;
    }

    public SnsPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTitle = "";
        this.sSV = null;
        this.sSW = null;
        this.sSX = null;
        this.sSY = null;
        this.sSZ = null;
        this.sTa = null;
        this.lAi = 255;
        this.fRK = new LinkedList();
        this.sTb = new a();
        this.fCi = (MMActivity) context;
        this.mTitle = context.getString(R.l.dZG);
        setLayoutResource(R.i.diC);
    }

    private void bGr() {
        ImageView imageView;
        int i = 0;
        if (this.sSV != null) {
            this.sSV.setImageResource(R.e.white);
            this.sSV.setVisibility(4);
        }
        if (this.sSW != null) {
            this.sSW.setImageResource(R.e.white);
            this.sSW.setVisibility(4);
        }
        if (this.sSX != null) {
            this.sSX.setImageResource(R.e.white);
            this.sSX.setVisibility(4);
        }
        if (this.sSV != null && this.fRK.size() > 0) {
            int i2;
            ImageView imageView2;
            this.sSV.setVisibility(0);
            if (f.rZ()) {
                m.pQA.b((alh) this.fRK.get(0), this.sSV, this.fCi.hashCode(), this.pQT);
                imageView = this.sSY;
                if (((alh) this.fRK.get(0)).jOc == 6) {
                    i2 = 0;
                    imageView.setVisibility(i2);
                } else {
                    imageView2 = imageView;
                }
            } else {
                this.sSV.setImageResource(R.g.bhO);
                imageView2 = this.sSY;
            }
            imageView = imageView2;
            i2 = 8;
            imageView.setVisibility(i2);
        }
        if (this.sSW != null && this.fRK.size() >= 2) {
            this.sSW.setVisibility(0);
            if (f.rZ()) {
                m.pQA.b((alh) this.fRK.get(1), this.sSW, this.fCi.hashCode(), this.pQT);
                this.sSZ.setVisibility(((alh) this.fRK.get(1)).jOc == 6 ? 0 : 8);
            } else {
                this.sSW.setImageResource(R.g.bhO);
            }
        }
        if (this.sSX != null && this.fRK.size() >= 3) {
            this.sSX.setVisibility(0);
            if (f.rZ()) {
                m.pQA.b((alh) this.fRK.get(2), this.sSX, this.fCi.hashCode(), this.pQT);
                imageView = this.sTa;
                if (((alh) this.fRK.get(2)).jOc != 6) {
                    i = 8;
                }
                imageView.setVisibility(i);
                return;
            }
            this.sSX.setImageResource(R.g.bhO);
        }
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.h.content);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(R.i.diG, viewGroup2);
        return onCreateView;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        this.sSV = (QDisFadeImageView) view.findViewById(R.h.bWW);
        this.sSV.setAlpha(this.lAi);
        this.sSV.setImageDrawable(this.sTb);
        this.sSW = (QDisFadeImageView) view.findViewById(R.h.bWX);
        this.sSW.setAlpha(this.lAi);
        this.sSW.setImageDrawable(this.sTb);
        this.sSX = (QDisFadeImageView) view.findViewById(R.h.bWY);
        this.sSX.setAlpha(this.lAi);
        this.sSX.setImageDrawable(this.sTb);
        TextView textView = (TextView) view.findViewById(R.h.bon);
        if (!bg.mA(this.mTitle)) {
            textView.setText(this.mTitle);
            LayoutParams layoutParams = textView.getLayoutParams();
            layoutParams.width = com.tencent.mm.bg.a.T(this.mContext, R.f.aXk);
            textView.setLayoutParams(layoutParams);
        }
        this.sSY = (ImageView) view.findViewById(R.h.cFS);
        this.sSZ = (ImageView) view.findViewById(R.h.cFT);
        this.sTa = (ImageView) view.findViewById(R.h.cFU);
        this.sSY.setVisibility(8);
        this.sSZ.setVisibility(8);
        this.sTa.setVisibility(8);
        bGr();
        if (view != null && this.fRK != null) {
            view.setContentDescription(this.mContext.getString(R.l.eGZ, new Object[]{Integer.valueOf(this.fRK.size())}));
        }
    }

    public final void Nf(String str) {
        if (str != null) {
            this.fRK.clear();
            ap.yY();
            af Rc = c.wR().Rc(str);
            if (Rc != null && ((int) Rc.gTQ) > 0 && com.tencent.mm.j.a.ez(Rc.field_type)) {
                this.pQT = an.uJI;
            } else if (str.equals(com.tencent.mm.u.m.xL())) {
                this.pQT = an.uJI;
            } else {
                this.pQT = an.uJJ;
            }
            b lvVar = new lv();
            lvVar.fSW.username = str;
            com.tencent.mm.sdk.b.a.urY.m(lvVar);
            if (lvVar.fSX.fSY != null) {
                this.fRK.add(lvVar.fSX.fSY);
            }
            if (lvVar.fSX.fSZ != null) {
                this.fRK.add(lvVar.fSX.fSZ);
            }
            if (lvVar.fSX.fTa != null) {
                this.fRK.add(lvVar.fSX.fTa);
            }
            bGr();
        }
    }
}
