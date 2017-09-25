package com.tencent.mm.plugin.card.ui.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.protocal.c.lz;

public final class u extends i {
    private View kqz;

    public final void KC() {
    }

    public final void update() {
        if (this.kqz == null) {
            this.kqz = ((ViewStub) findViewById(R.h.bxT)).inflate();
        }
        b ahj = this.kqe.ahj();
        Context ahm = this.kqe.ahm();
        lz lzVar = ahj.afj().tnO;
        if (this.kqz != null) {
            TextView textView = (TextView) this.kqz.findViewById(R.h.bxU);
            textView.setText(lzVar.title);
            textView.setTextColor(l.ta(ahj.afi().hib));
            TextView textView2 = (TextView) this.kqz.findViewById(R.h.bxS);
            LinearLayout linearLayout = (LinearLayout) this.kqz.findViewById(R.h.byM);
            LayoutParams layoutParams = (LayoutParams) linearLayout.getLayoutParams();
            if (ahj.aeP()) {
                LayoutParams layoutParams2 = (LayoutParams) textView.getLayoutParams();
                if (TextUtils.isEmpty(lzVar.kdI)) {
                    textView2.setVisibility(8);
                    layoutParams.height = ahm.getResources().getDimensionPixelOffset(R.f.aYM);
                } else {
                    textView2.setText(lzVar.kdI);
                    textView2.setVisibility(0);
                    layoutParams.height = ahm.getResources().getDimensionPixelOffset(R.f.aYL);
                    layoutParams2.bottomMargin = ahm.getResources().getDimensionPixelSize(R.f.aWA);
                    LayoutParams layoutParams3 = (LayoutParams) textView2.getLayoutParams();
                    layoutParams3.topMargin = ahm.getResources().getDimensionPixelSize(R.f.aWA);
                    textView2.setLayoutParams(layoutParams3);
                    textView2.invalidate();
                }
                layoutParams2.height = ahm.getResources().getDimensionPixelSize(R.f.aYN);
                textView.setLayoutParams(layoutParams2);
                textView.invalidate();
                textView.setBackgroundDrawable(l.c(ahm, ahj.afi().hib, ahm.getResources().getDimensionPixelSize(R.f.aYP)));
                textView.setTextColor(l.R(ahm, ahj.afi().hib));
                linearLayout.setBackgroundDrawable(null);
                textView.setOnClickListener(this.kqe.ahn());
            } else {
                if (TextUtils.isEmpty(lzVar.kdI)) {
                    textView2.setVisibility(8);
                    layoutParams.height = ahm.getResources().getDimensionPixelOffset(R.f.aYU);
                } else {
                    textView2.setText(lzVar.kdI);
                    textView2.setVisibility(0);
                    layoutParams.height = ahm.getResources().getDimensionPixelOffset(R.f.aYT);
                }
                linearLayout.setOnClickListener(this.kqe.ahn());
            }
            linearLayout.setLayoutParams(layoutParams);
            linearLayout.invalidate();
            this.kqz.invalidate();
            if (ahj.aeP()) {
                linearLayout.getLayoutParams();
            }
        }
    }

    public final void aiz() {
        if (this.kqz != null) {
            this.kqz.setVisibility(8);
        }
    }
}
