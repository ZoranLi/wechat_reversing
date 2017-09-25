package com.tencent.mm.plugin.card.ui.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.base.b;

public final class d extends i {
    private TextView kid;
    private View kpT;
    private TextView kpU;
    private TextView kpV;

    public final void KC() {
        this.kpT = findViewById(R.h.bnT);
        this.kpU = (TextView) findViewById(R.h.bnU);
        this.kid = (TextView) findViewById(R.h.cEI);
        this.kpV = (TextView) findViewById(R.h.byd);
        this.kpU.setOnClickListener(this.kqe.ahn());
        this.kpT.setVisibility(8);
    }

    public final void update() {
        b ahj = this.kqe.ahj();
        Context ahm = this.kqe.ahm();
        this.kpT.setVisibility(0);
        if (TextUtils.isEmpty(ahj.afi().tov)) {
            this.kpU.setVisibility(8);
        } else {
            this.kpU.setVisibility(0);
            this.kpU.setText(ahj.afi().tov);
            if (ahj.aeO() || (ahj.aeN() && ahj.aeQ())) {
                this.kpU.setTextColor(ahm.getResources().getColor(R.e.white));
            } else if (ahj.aeN() && ahj.aeP()) {
                this.kpU.setTextColor(ahm.getResources().getColor(R.e.aTg));
                this.kpT.setBackgroundColor(ahm.getResources().getColor(R.e.aVj));
            } else {
                this.kpU.setTextColor(ahm.getResources().getColor(R.e.white));
            }
        }
        View findViewById = this.kpT.findViewById(R.h.byq);
        if (this.kqe.aho().aiw()) {
            findViewById.setVisibility(0);
            this.kpV.setText(ahm.getString(R.l.dRN));
            this.kpV.setTextColor(ahm.getResources().getColor(R.e.white));
            int dimensionPixelOffset = ahm.getResources().getDimensionPixelOffset(R.f.aXH);
            Button button = (Button) this.kpT.findViewById(R.h.byb);
            Drawable d = l.d(ahm, ahm.getResources().getColor(R.e.white), dimensionPixelOffset);
            Drawable bJ = l.bJ(ahm.getResources().getColor(R.e.white), dimensionPixelOffset);
            Drawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842919}, bJ);
            stateListDrawable.addState(new int[0], d);
            button.setBackgroundDrawable(stateListDrawable);
            int[] iArr = new int[]{l.ta(ahj.afi().hib), ahm.getResources().getColor(R.e.white)};
            button.setTextColor(new ColorStateList(new int[][]{new int[]{16842919, 16842910}, new int[0]}, iArr));
            button.setOnClickListener(this.kqe.ahn());
            findViewById = this.kpT.findViewById(R.h.cjR);
            View findViewById2 = this.kpT.findViewById(R.h.bxr);
            if (ahj.afi().toJ == 1) {
                findViewById.setVisibility(0);
                findViewById2.setVisibility(0);
                return;
            }
            findViewById.setVisibility(8);
            findViewById2.setVisibility(8);
            return;
        }
        findViewById.setVisibility(8);
    }

    public final void aiz() {
        this.kpT.setVisibility(8);
    }

    public final void sQ(String str) {
        this.kpV.setText(str);
    }
}
