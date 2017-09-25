package com.tencent.mm.ui.chatting;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.chatting.ah.a;

final class ek extends a {
    TextView ipx;

    public ek(int i) {
        super(i);
    }

    public final a dw(View view) {
        super.dn(view);
        this.kxi = (TextView) view.findViewById(R.h.bBA);
        this.piH = (TextView) view.findViewById(R.h.bBG);
        this.ipx = (TextView) view.findViewById(R.h.bAi);
        this.mfD = (CheckBox) view.findViewById(R.h.bAd);
        this.nRW = view.findViewById(R.h.bAX);
        this.type = 2;
        return this;
    }
}
