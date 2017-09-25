package com.tencent.mm.ui.chatting;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.chatting.ah.a;

final class i extends a {
    protected View lKQ;
    protected TextView lMU;
    protected ImageView mfF;
    protected ImageView mfz;
    protected TextView vyD;
    protected TextView vyE;
    protected ImageView vyF;

    public i(int i) {
        super(i);
    }

    public final i di(View view) {
        super.dn(view);
        this.mfz = (ImageView) view.findViewById(R.h.bzN);
        this.lMU = (TextView) view.findViewById(R.h.bzK);
        this.vyD = (TextView) view.findViewById(R.h.bzD);
        this.lKQ = view.findViewById(R.h.bzE);
        this.vyE = (TextView) view.findViewById(R.h.bzy);
        this.piH = (TextView) view.findViewById(R.h.bBG);
        this.vyF = (ImageView) view.findViewById(R.h.bzF);
        this.mfD = (CheckBox) view.findViewById(R.h.bAd);
        this.nRW = view.findViewById(R.h.bAX);
        this.mfF = (ImageView) view.findViewById(R.h.bAl);
        return this;
    }
}
