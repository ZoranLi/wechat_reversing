package com.tencent.mm.plugin.card.ui.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.ui.e.a;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;

public final class o extends i {
    private View kqv;
    private ImageView kqw;
    private TextView kqx;
    private TextView kqy;

    public final void KC() {
        this.kqv = findViewById(R.h.bSf);
        this.kqw = (ImageView) findViewById(R.h.bSd);
        this.kqx = (TextView) findViewById(R.h.bSh);
        this.kqy = (TextView) findViewById(R.h.bSg);
        this.kqv.setVisibility(8);
    }

    public final void update() {
        b ahj = this.kqe.ahj();
        Context ahm = this.kqe.ahm();
        a ahq = this.kqe.ahq();
        this.kqv.setVisibility(0);
        TextView textView = this.kqx;
        ap.yY();
        textView.setText(h.b(ahm, c.wR().Rc(ahq.kkj).tK(), this.kqx.getTextSize()));
        if (ahj.afk() != null && !TextUtils.isEmpty(ahj.afk().ubj)) {
            this.kqy.setText(h.b(ahm, ahj.afk().ubj, this.kqy.getTextSize()));
        } else if (TextUtils.isEmpty(ahj.afi().keS)) {
            this.kqy.setText(ahm.getString(R.l.dQT, new Object[]{this.kqe.ahr().getTitle()}));
        } else {
            this.kqy.setText(ahm.getString(R.l.dQT, new Object[]{ahj.afi().keS}));
        }
        com.tencent.mm.pluginsdk.ui.a.b.a(this.kqw, ahq.kkj);
        this.kqw.setOnClickListener(this.kqe.ahn());
    }

    public final void aiz() {
        this.kqv.setVisibility(8);
    }
}
