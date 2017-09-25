package com.tencent.mm.ui.chatting;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.chatting.ah.a;

final class f extends a {
    public TextView vyo;

    public f(int i) {
        super(i);
    }

    public final f dh(View view) {
        super.dn(view);
        this.kxi = (TextView) this.mil.findViewById(R.h.bBA);
        this.mfD = (CheckBox) this.mil.findViewById(R.h.bAd);
        this.nRW = this.mil.findViewById(R.h.bAX);
        this.piH = (TextView) this.mil.findViewById(R.h.bBG);
        this.vyo = (TextView) this.mil.findViewById(R.h.bpZ);
        return this;
    }
}
