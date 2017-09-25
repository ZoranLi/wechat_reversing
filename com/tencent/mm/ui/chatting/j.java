package com.tencent.mm.ui.chatting;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.chatting.ah.a;

final class j extends a {
    protected TextView vyG;

    public j(int i) {
        super(i);
    }

    public final j dj(View view) {
        super.dn(view);
        this.vyG = (TextView) view.findViewById(R.h.ccm);
        this.piH = (TextView) view.findViewById(R.h.bBG);
        this.mfD = (CheckBox) view.findViewById(R.h.bAd);
        this.nRW = view.findViewById(R.h.bAX);
        return this;
    }
}
