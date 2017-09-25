package com.tencent.mm.plugin.card.ui;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.a.k.a;
import com.tencent.mm.plugin.card.b.m;
import com.tencent.mm.plugin.card.model.al;
import com.tencent.mm.plugin.card.model.g;
import com.tencent.mm.storage.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.MMActivity;

public final class i implements a {
    public MMActivity kdb;
    View khv;
    boolean kjg = false;
    View kog;
    TextView koh;
    ImageView koi;
    View koj;
    TextView kok;
    ImageView kol;

    public i(MMActivity mMActivity, View view) {
        this.kdb = mMActivity;
        this.khv = view;
    }

    public final void a(g gVar) {
        ahH();
    }

    public final void adZ() {
    }

    public final void ahH() {
        if (al.age().kdx <= 0 || !this.kjg) {
            this.kog.setVisibility(8);
            if (this.koj != null) {
                this.koj.setVisibility(8);
                return;
            }
            return;
        }
        ap.yY();
        String str = (String) c.vr().get(w.a.uAJ, "");
        ap.yY();
        String str2 = (String) c.vr().get(w.a.uAK, "");
        int dimensionPixelOffset = this.kdb.getResources().getDimensionPixelOffset(R.f.aYF);
        if (TextUtils.isEmpty(str2)) {
            this.koi.setImageResource(R.g.bdt);
        } else {
            m.a(this.koi, str2, dimensionPixelOffset, R.g.bdt, true);
        }
        if (TextUtils.isEmpty(str)) {
            this.koh.setText(this.kdb.getString(R.l.dQY, new Object[]{Integer.valueOf(r2)}));
        } else {
            this.koh.setText(str);
        }
        this.kog.setVisibility(0);
        if (this.koj != null) {
            if (TextUtils.isEmpty(str2)) {
                this.kol.setImageResource(R.g.bdt);
            } else {
                m.a(this.kol, str2, dimensionPixelOffset, R.g.bdt, true);
            }
            if (TextUtils.isEmpty(str)) {
                this.kok.setText(this.kdb.getString(R.l.dQY, new Object[]{Integer.valueOf(r2)}));
            } else {
                this.kok.setText(str);
            }
            this.koj.setVisibility(0);
        }
    }
}
