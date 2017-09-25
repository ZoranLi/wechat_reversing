package com.tencent.mm.plugin.wenote.ui.nativenote.b;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wenote.b.b;
import com.tencent.mm.plugin.wenote.model.a.a;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;

public final class c extends f {
    private ImageView syG;

    public c(View view, k kVar) {
        super(view, kVar);
        this.fKf.setVisibility(0);
        this.syR.setVisibility(8);
        this.syM.setVisibility(8);
        this.fKf.setTag(this);
        this.fKf.setOnClickListener(this.mAD);
        this.syG = (ImageView) view.findViewById(R.h.bXb);
        this.syG.setVisibility(8);
    }

    public final void a(a aVar, int i, int i2) {
        Bitmap Lv = b.Lv(((com.tencent.mm.plugin.wenote.model.a.c) aVar).fQE);
        if (Lv != null) {
            this.fKf.setImageBitmap(Lv);
        } else {
            this.fKf.setImageResource(R.k.dwW);
        }
        if (aVar.suA) {
            this.syG.setVisibility(0);
        } else {
            this.syG.setVisibility(8);
        }
        super.a(aVar, i, i2);
    }

    public final int bCe() {
        return 2;
    }
}
