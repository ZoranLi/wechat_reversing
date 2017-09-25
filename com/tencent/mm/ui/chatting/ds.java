package com.tencent.mm.ui.chatting;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.chatting.ah.a;

final class ds extends a {
    ProgressBar oDJ;
    TextView vMU;
    ImageView vMV;
    View vMW;
    TextView vyE;
    ImageView vyx;
    ImageView vyy;

    public ds(int i) {
        super(i);
    }

    public final a p(View view, boolean z) {
        super.dn(view);
        this.kxi = (TextView) view.findViewById(R.h.bBA);
        this.vyx = (ImageView) view.findViewById(R.h.bAj);
        this.mfD = (CheckBox) view.findViewById(R.h.bAd);
        this.nRW = view.findViewById(R.h.bAX);
        this.vMW = view.findViewById(R.h.cKZ);
        if (z) {
            this.piH = (TextView) view.findViewById(R.h.bBG);
            this.oDJ = (ProgressBar) view.findViewById(R.h.bKx);
            this.type = 1;
        } else {
            this.oDJ = (ProgressBar) view.findViewById(R.h.cKX);
            this.vMU = (TextView) view.findViewById(R.h.cKY);
            this.piH = (TextView) view.findViewById(R.h.bBG);
            this.type = 3;
            this.vyy = (ImageView) view.findViewById(R.h.bBy);
        }
        this.vyE = (TextView) view.findViewById(R.h.bzy);
        this.vMV = (ImageView) view.findViewById(R.h.bAl);
        return this;
    }
}
