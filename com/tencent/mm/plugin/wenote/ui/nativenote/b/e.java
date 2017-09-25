package com.tencent.mm.plugin.wenote.ui.nativenote.b;

import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wenote.model.a.a;
import com.tencent.mm.plugin.wenote.model.a.d;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;

public final class e extends f {
    public e(View view, k kVar) {
        super(view, kVar);
        this.syM.setVisibility(0);
        this.fKf.setVisibility(8);
        this.syR.setVisibility(8);
        this.syM.setTag(this);
        this.syM.setOnClickListener(this.mAD);
    }

    public final void a(a aVar, int i, int i2) {
        this.syP.setImageResource(R.k.dwL);
        this.syN.setText(((d) aVar).ndv);
        this.syO.setText(((d) aVar).hCE);
        super.a(aVar, i, i2);
    }

    public final int bCe() {
        return 3;
    }
}
