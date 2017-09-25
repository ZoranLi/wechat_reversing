package com.tencent.mm.ui.chatting;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.chatting.ah.a;

final class ee extends a {
    protected TextView ipx;
    protected ImageView vOd;

    public ee(int i) {
        super(i);
    }

    public final ee dv(View view) {
        super.dn(view);
        this.ipx = (TextView) view.findViewById(R.h.bzB);
        this.vOd = (ImageView) view.findViewById(R.h.bzN);
        this.mfD = (CheckBox) view.findViewById(R.h.bAd);
        this.nRW = view.findViewById(R.h.bAX);
        return this;
    }
}
