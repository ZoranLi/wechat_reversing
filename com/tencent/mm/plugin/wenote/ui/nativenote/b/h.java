package com.tencent.mm.plugin.wenote.ui.nativenote.b;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wenote.b.b;
import com.tencent.mm.plugin.wenote.model.a.a;
import com.tencent.mm.plugin.wenote.model.a.g;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.ui.widget.MMPinProgressBtn;

public final class h extends f {
    public ImageView szb;
    public MMPinProgressBtn szc;
    public ImageView szd;
    private ImageView sze;

    public h(View view, k kVar) {
        super(view, kVar);
        this.szb = (ImageView) view.findViewById(R.h.cGq);
        this.szc = (MMPinProgressBtn) view.findViewById(R.h.cLY);
        this.szd = (ImageView) view.findViewById(R.h.cMj);
        this.szb.setImageResource(R.k.dzz);
        this.sze = (ImageView) view.findViewById(R.h.cLU);
        this.syR.setVisibility(8);
        this.syM.setVisibility(8);
        this.sze.setVisibility(8);
        this.syQ.setTag(this);
        this.syQ.setOnClickListener(this.mAD);
    }

    public final void a(a aVar, int i, int i2) {
        Bitmap Lv = b.Lv(((g) aVar).fKz);
        if (Lv != null) {
            this.szd.setImageBitmap(Lv);
        } else {
            this.szd.setImageResource(R.g.bdS);
        }
        if (aVar.suA) {
            this.sze.setVisibility(0);
        } else {
            this.sze.setVisibility(8);
        }
        super.a(aVar, i, i2);
    }

    public final int bCe() {
        return 6;
    }
}
