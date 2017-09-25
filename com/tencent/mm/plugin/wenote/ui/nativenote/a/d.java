package com.tencent.mm.plugin.wenote.ui.nativenote.a;

import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wenote.model.a.a;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.plugin.wenote.ui.nativenote.b.f;

public final class d extends f {
    public d(View view, k kVar) {
        super(view, kVar);
        this.syM.setVisibility(0);
        this.fKf.setVisibility(8);
        this.syR.setVisibility(8);
        this.syM.setTag(this);
        this.syM.setOnClickListener(this.mAD);
    }

    public final void a(a aVar, int i, int i2) {
        this.syP.setImageResource(R.k.dxM);
        this.syN.setText(((com.tencent.mm.plugin.wenote.model.a.f) aVar).title);
        this.syO.setText(((com.tencent.mm.plugin.wenote.model.a.f) aVar).content);
        super.a(aVar, i, i2);
    }

    public final int bCe() {
        return 0;
    }
}
