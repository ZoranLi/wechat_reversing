package com.tencent.mm.ui.chatting;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.chatting.ah.a;

final class di extends a {
    protected TextView ipx;
    protected TextView vHT;
    protected TextView vHU;
    protected Button vHV;
    protected Button vHW;
    protected ImageView vHX;

    public di(int i) {
        super(i);
    }

    public final di dt(View view) {
        super.dn(view);
        this.ipx = (TextView) view.findViewById(R.h.bzB);
        this.vHT = (TextView) view.findViewById(R.h.bzA);
        this.vHU = (TextView) view.findViewById(R.h.bzO);
        this.vHV = (Button) view.findViewById(R.h.bAO);
        this.vHW = (Button) view.findViewById(R.h.bAN);
        this.vHX = (ImageView) view.findViewById(R.h.bBB);
        this.mfD = (CheckBox) view.findViewById(R.h.bAd);
        this.nRW = view.findViewById(R.h.bAX);
        return this;
    }
}
