package com.tencent.mm.ui.chatting;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.chatting.ah.a;

final class x extends a {
    TextView jWd;
    ImageView vAf;
    TextView vAg;
    TextView vAh;
    public int vym;
    ImageView vyy;

    public x(int i) {
        super(i);
    }

    public final a p(View view, boolean z) {
        super.dn(view);
        this.vAf = (ImageView) view.findViewById(R.h.bzU);
        this.kxi = (TextView) view.findViewById(R.h.bBA);
        this.vAg = (TextView) view.findViewById(R.h.bBE);
        this.vAh = (TextView) view.findViewById(R.h.bBH);
        this.jWd = (TextView) view.findViewById(R.h.bBc);
        this.piH = (TextView) view.findViewById(R.h.bBG);
        this.vBZ = view.findViewById(R.h.bAe);
        this.mfD = (CheckBox) view.findViewById(R.h.bAd);
        this.nRW = view.findViewById(R.h.bAX);
        this.type = z ? 12 : 13;
        if (!z) {
            this.vyK = (ImageView) view.findViewById(R.h.bBw);
            this.vyy = (ImageView) view.findViewById(R.h.bBy);
            this.oDJ = (ProgressBar) view.findViewById(R.h.cKX);
        }
        this.vym = ah.eU(ab.getContext());
        return this;
    }
}
