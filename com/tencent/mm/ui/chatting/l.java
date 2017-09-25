package com.tencent.mm.ui.chatting;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.chatting.ah.a;

final class l extends a {
    protected TextView kxh;
    protected TextView lMU;
    protected ProgressBar oDJ;
    protected TextView vyE;
    protected ImageView vyK;

    public l(int i) {
        super(i);
    }

    public final l dl(View view) {
        super.dn(view);
        this.kxh = (TextView) view.findViewById(R.h.bAi);
        this.oDJ = (ProgressBar) view.findViewById(R.h.cKX);
        this.vyK = (ImageView) view.findViewById(R.h.bBw);
        this.lMU = (TextView) view.findViewById(R.h.bzK);
        this.vyE = (TextView) view.findViewById(R.h.bzy);
        this.piH = (TextView) view.findViewById(R.h.bBG);
        this.mfD = (CheckBox) view.findViewById(R.h.bAd);
        this.nRW = view.findViewById(R.h.bAX);
        return this;
    }
}
