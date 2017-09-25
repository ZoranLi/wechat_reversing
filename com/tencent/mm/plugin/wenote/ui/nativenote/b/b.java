package com.tencent.mm.plugin.wenote.ui.nativenote.b;

import android.view.View;
import com.tencent.mm.plugin.wenote.model.a.a;
import com.tencent.mm.plugin.wenote.model.g;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;

public final class b extends f {
    public b(View view, k kVar) {
        super(view, kVar);
        this.syM.setVisibility(0);
        this.fKf.setVisibility(8);
        this.syR.setVisibility(8);
        this.syM.setTag(this);
        this.syM.setOnClickListener(this.mAD);
    }

    public final void a(a aVar, int i, int i2) {
        this.syP.setImageBitmap(com.tencent.mm.plugin.wenote.b.b.Lv(g.Lm(((com.tencent.mm.plugin.wenote.model.a.b) aVar).suC)));
        this.syN.setText(((com.tencent.mm.plugin.wenote.model.a.b) aVar).title);
        this.syO.setText(((com.tencent.mm.plugin.wenote.model.a.b) aVar).content);
        super.a(aVar, i, i2);
    }

    public final int bCe() {
        return 5;
    }
}
