package com.tencent.mm.ui.chatting;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.chatting.ah.a;

final class k extends a {
    public ImageView vyH;
    public TextView vyI;
    public TextView vyJ;
    public int vym = 0;

    public k(int i) {
        super(i);
    }

    public final k dk(View view) {
        super.dn(view);
        this.kxi = (TextView) this.mil.findViewById(R.h.bBA);
        this.mfD = (CheckBox) this.mil.findViewById(R.h.bAd);
        this.nRW = this.mil.findViewById(R.h.bAX);
        this.piH = (TextView) this.mil.findViewById(R.h.bBG);
        this.vyH = (ImageView) this.mil.findViewById(R.h.bqi);
        this.vyI = (TextView) this.mil.findViewById(R.h.bqj);
        this.vyJ = (TextView) this.mil.findViewById(R.h.bqh);
        this.vym = ah.eU(ab.getContext());
        return this;
    }
}
