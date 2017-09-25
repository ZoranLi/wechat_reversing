package com.tencent.mm.plugin.card.ui.view;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ah.a.a.c.a;
import com.tencent.mm.ah.n;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.protocal.c.oa;

public final class k extends i {
    private View kqf;

    public final void KC() {
    }

    public final void update() {
        if (this.kqf == null) {
            this.kqf = ((ViewStub) findViewById(R.h.bwO)).inflate();
        }
        this.kqf.setOnClickListener(this.kqe.ahn());
        oa oaVar = this.kqe.ahj().afi().toC;
        if (TextUtils.isEmpty(oaVar.opP)) {
            findViewById(R.h.bwK).setVisibility(8);
        } else {
            ((TextView) findViewById(R.h.bwJ)).setText(oaVar.opP);
            findViewById(R.h.bwK).setVisibility(0);
        }
        ImageView imageView = (ImageView) findViewById(R.h.bwN);
        if (oaVar.ttG == null || oaVar.ttG.size() <= 0 || TextUtils.isEmpty((CharSequence) oaVar.ttG.get(0))) {
            imageView.setVisibility(8);
            return;
        }
        String str = (String) oaVar.ttG.get(0);
        imageView.setVisibility(0);
        a aVar = new a();
        aVar.hIO = e.hgu;
        n.GX();
        aVar.hJg = null;
        aVar.hIN = m.sw(str);
        aVar.hIL = true;
        aVar.hJi = false;
        aVar.hIJ = true;
        n.GW().a(str, imageView, aVar.Hg());
    }

    public final void aiz() {
        if (this.kqf != null) {
            this.kqf.setVisibility(8);
        }
    }
}
