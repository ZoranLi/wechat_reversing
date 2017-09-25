package com.tencent.mm.plugin.card.ui.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.a.f;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.ui.a.g;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;

public final class a extends i {
    private View kpL;

    public final void KC() {
        this.kpL = findViewById(R.h.bvT);
    }

    public final void update() {
        g aho = this.kqe.aho();
        b ahj = this.kqe.ahj();
        Context ahm = this.kqe.ahm();
        com.tencent.mm.plugin.card.ui.e.a ahq = this.kqe.ahq();
        f ahr = this.kqe.ahr();
        if (aho.aij()) {
            this.kpL.setVisibility(0);
            findViewById(R.h.bmD).setVisibility(0);
            ImageView imageView = (ImageView) findViewById(R.h.bmC);
            TextView textView = (TextView) findViewById(R.h.bmE);
            TextView textView2 = (TextView) findViewById(R.h.bmH);
            if (ahq.kkj != null) {
                ap.yY();
                textView.setText(h.b(ahm, c.wR().Rc(ahq.kkj).tK(), textView.getTextSize()));
            }
            if (ahq.jZM == 23) {
                if (!TextUtils.isEmpty(ahj.afi().toK)) {
                    textView2.setText(ahj.afi().toK);
                } else if (TextUtils.isEmpty(ahj.afi().keS)) {
                    textView2.setText(ahm.getString(R.l.dRz, new Object[]{ahr.getTitle()}));
                } else {
                    textView2.setText(ahm.getString(R.l.dRz, new Object[]{ahj.afi().keS}));
                }
            } else if (ahj.afk() != null && !TextUtils.isEmpty(ahj.afk().ubj)) {
                textView2.setText(ahj.afk().ubj);
            } else if (TextUtils.isEmpty(ahj.afi().keS)) {
                textView2.setText(ahm.getString(R.l.dQT, new Object[]{ahr.getTitle()}));
            } else {
                textView2.setText(ahm.getString(R.l.dQT, new Object[]{ahj.afi().keS}));
            }
            com.tencent.mm.pluginsdk.ui.a.b.a(imageView, ahq.kkj, 0.15f, false);
            imageView.setOnClickListener(this.kqe.ahn());
        } else if (!aho.aik()) {
            aiz();
        } else if (TextUtils.isEmpty(ahj.afi().toK)) {
            this.kpL.setVisibility(8);
        } else {
            this.kpL.setVisibility(0);
            findViewById(R.h.bmD).setVisibility(8);
            ((TextView) findViewById(R.h.bmH)).setText(ahj.afi().toK);
        }
    }

    public final void aiz() {
        this.kpL.setVisibility(8);
    }
}
