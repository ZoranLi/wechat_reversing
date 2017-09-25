package com.tencent.mm.ui.chatting;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.chatting.ah.a;

final class ed extends a {
    TextView lMU;
    TextView suV;

    public ed(int i) {
        super(i);
    }

    public final a du(View view) {
        super.dn(view);
        this.kxi = (TextView) view.findViewById(R.h.bBA);
        this.piH = (TextView) view.findViewById(R.h.bBG);
        this.suV = (TextView) view.findViewById(R.h.bAi);
        this.lMU = (TextView) view.findViewById(R.h.bBl);
        this.mfD = (CheckBox) view.findViewById(R.h.bAd);
        this.nRW = view.findViewById(R.h.bAX);
        this.type = 2;
        return this;
    }
}
