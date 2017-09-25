package com.tencent.mm.ui.chatting;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.chatting.ah.a;
import com.tencent.mm.ui.widget.MMTextView;

final class w extends a {
    View lmQ;
    MMTextView vAd;
    ChattingTranslateView vAe;
    ImageView vyy;

    public w(int i) {
        super(i);
    }

    public final a p(View view, boolean z) {
        super.dn(view);
        this.kxi = (TextView) view.findViewById(R.h.bBA);
        this.piH = (TextView) view.findViewById(R.h.bBG);
        this.vAd = (MMTextView) view.findViewById(R.h.bAi);
        this.mfD = (CheckBox) view.findViewById(R.h.bAd);
        this.nRW = view.findViewById(R.h.bAX);
        this.lmQ = view.findViewById(R.h.bAg);
        this.vAe = (ChattingTranslateView) view.findViewById(R.h.bBD);
        if (z) {
            this.type = 2;
        } else {
            this.vyy = (ImageView) view.findViewById(R.h.bBy);
            this.vyK = (ImageView) view.findViewById(R.h.bBw);
            this.oDJ = (ProgressBar) view.findViewById(R.h.cKX);
            this.type = 4;
        }
        return this;
    }
}
