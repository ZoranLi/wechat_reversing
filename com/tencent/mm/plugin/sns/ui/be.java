package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e;
import com.tencent.mm.plugin.sns.storage.a;
import com.tencent.mm.plugin.sns.storage.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.c.c;

public final class be {
    private String naR = v.ea(ab.getContext());
    public a qKA;
    private LinearLayout qKu;
    public TextView qKv;
    public TextView qKw;
    private View qKx;
    private View qKy;
    public b qKz;
    private View view;

    public final String bll() {
        if (this.qKA == null) {
            return "";
        }
        if (this.qKA.pZI == null) {
            return "";
        }
        return this.qKA.pZI;
    }

    public final int[] blm() {
        int[] iArr = new int[2];
        if (this.qKu != null) {
            this.qKx.getLocationInWindow(iArr);
            iArr[0] = iArr[0] + this.qKx.getMeasuredWidth();
        } else if (this.qKx != null) {
            this.qKx.getLocationInWindow(iArr);
            iArr[0] = iArr[0] + this.qKx.getMeasuredWidth();
        }
        return iArr;
    }

    public be(View view) {
        this.view = view;
        w.i("MicroMsg.TimeLineAdView", "adView init lan " + this.naR);
        this.qKv = (TextView) this.view.findViewById(f.pAF);
        this.qKw = (TextView) this.view.findViewById(f.pAI);
        this.qKx = this.view.findViewById(f.pAG);
        this.qKy = this.view.findViewById(f.pAH);
        this.qKu = (LinearLayout) this.view.findViewById(f.pAE);
        this.qKv.setText(" " + this.view.getResources().getString(j.pKl) + " ");
    }

    public final void a(OnClickListener onClickListener, OnClickListener onClickListener2) {
        this.qKw.setOnClickListener(onClickListener);
        this.qKv.setOnClickListener(onClickListener2);
        if (this.qKx != null) {
            this.qKx.setOnClickListener(onClickListener2);
        }
        if (this.qKu != null) {
            this.qKu.setOnClickListener(onClickListener2);
        }
    }

    public final void p(Object obj, Object obj2) {
        this.qKw.setTag(obj);
        this.qKv.setTag(obj2);
        if (this.qKx != null) {
            this.qKx.setTag(obj2);
        }
        if (this.qKu != null) {
            this.qKu.setTag(obj2);
        }
    }

    public final void a(b bVar, a aVar) {
        this.qKA = aVar;
        this.qKz = bVar;
        String str = "";
        if (bVar != null) {
            str = bVar.qed;
        }
        if (aVar != null && aVar.qdI == 1) {
            str = aVar.qdJ;
        }
        Context context = this.qKw.getContext();
        if (bg.mA(str)) {
            str = context.getString(j.pKp);
        }
        final int length = str.length();
        final CharSequence spannableString = new SpannableString(str + "ad_");
        Drawable drawable = context.getResources().getDrawable(i.pIL);
        if (!bg.mA(bVar.qee)) {
            d.a("adId", bVar.qee, false, 41, 0, new d.a(this) {
                final /* synthetic */ be qKD;

                public final void bgn() {
                }

                public final void bgo() {
                }

                public final void FW(String str) {
                    if (!bg.mA(str)) {
                        Drawable createFromPath = Drawable.createFromPath(str);
                        if (createFromPath != null) {
                            createFromPath.setBounds(0, 0, (int) (((double) this.qKD.qKw.getTextSize()) * 1.3d), (int) (((double) this.qKD.qKw.getTextSize()) * 1.3d));
                            spannableString.setSpan(new ImageSpan(createFromPath, 0), length, length + 3, 33);
                            this.qKD.qKw.setText(spannableString);
                        }
                    }
                }
            });
        }
        drawable.setBounds(0, 0, (int) (((double) this.qKw.getTextSize()) * 1.3d), (int) (((double) this.qKw.getTextSize()) * 1.3d));
        spannableString.setSpan(new ImageSpan(drawable, 0), length, length + 3, 33);
        this.qKw.setText(spannableString);
        if (aVar == null || bg.mA(aVar.qdP)) {
            this.qKy.setVisibility(8);
        } else {
            this.qKy.setVisibility(0);
        }
        if (bVar != null) {
            CharSequence charSequence = "";
            if ("zh_CN".equals(this.naR)) {
                charSequence = bVar.qel;
            } else if ("zh_TW".equals(this.naR) || "zh_HK".equals(this.naR)) {
                charSequence = bVar.qen;
            } else if ("en".equals(this.naR)) {
                charSequence = bVar.qem;
            }
            if (!bg.mA(charSequence)) {
                this.qKv.setText(charSequence);
            }
        }
    }

    public final void setVisibility(int i) {
        int i2;
        if (this.qKz == null || this.qKz.qec != 1) {
            this.qKw.setVisibility(i);
        } else {
            this.qKw.setVisibility(8);
        }
        com.tencent.mm.storage.a QC = c.AA().QC("Sns_CanvasAd_DetailLink_JumpWay");
        if (QC.isValid()) {
            i2 = bg.getInt(QC.field_value, -1);
        } else {
            i2 = -1;
        }
        if (i2 != -1 && this.qKz != null && this.qKz.qdV && e.Gb(this.qKz.fQX)) {
            this.qKw.setVisibility(i);
        }
        this.qKv.setVisibility(i);
        if (this.qKx != null) {
            this.qKx.setVisibility(i);
        }
        if (this.qKu != null) {
            this.qKu.setVisibility(i);
        }
        if (this.qKA == null || bg.mA(this.qKA.qdP)) {
            this.qKy.setVisibility(8);
        } else {
            this.qKy.setVisibility(i);
        }
    }
}
