package com.tencent.mm.ui.chatting;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.chatting.ah.a;

final class dq extends a {
    TextView pkN;
    TextView suV;
    TextView vAg;
    View vMN;
    ImageView vMO;
    ImageView vMP;
    TextView vMQ;
    TextView vMR;

    public dq(int i) {
        super(i);
    }

    public final a du(View view) {
        super.dn(view);
        this.kxi = (TextView) view.findViewById(R.h.bBA);
        this.vAg = (TextView) view.findViewById(R.h.bBE);
        this.pkN = (TextView) view.findViewById(R.h.bBH);
        this.suV = (TextView) view.findViewById(R.h.bAi);
        this.vBZ = view.findViewById(R.h.bAe);
        this.vMR = (TextView) view.findViewById(R.h.bAY);
        this.vMN = view.findViewById(R.h.bAC);
        this.vMO = (ImageView) view.findViewById(R.h.bzb);
        this.vMP = (ImageView) view.findViewById(R.h.bAD);
        this.vMQ = (TextView) view.findViewById(R.h.bzc);
        this.mfD = (CheckBox) view.findViewById(R.h.bAd);
        this.nRW = view.findViewById(R.h.bAX);
        this.type = 9;
        return this;
    }
}
