package com.tencent.mm.ui.chatting;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.chatting.ah.a;

final class e extends a {
    public int maxSize = 0;
    public ImageView vyi;
    public TextView vyj;
    public TextView vyk;
    public TextView vyl;
    public int vym = 0;
    public int vyn = 0;

    public e(int i) {
        super(i);
    }

    public final e dg(View view) {
        super.dn(view);
        this.kxi = (TextView) this.mil.findViewById(R.h.bBA);
        this.mfD = (CheckBox) this.mil.findViewById(R.h.bAd);
        this.nRW = this.mil.findViewById(R.h.bAX);
        this.piH = (TextView) this.mil.findViewById(R.h.bBG);
        this.vyi = (ImageView) this.mil.findViewById(R.h.bpY);
        this.vyj = (TextView) this.mil.findViewById(R.h.bqa);
        this.vyk = (TextView) this.mil.findViewById(R.h.bpX);
        this.vyl = (TextView) this.mil.findViewById(R.h.bqb);
        this.vBZ = (LinearLayout) this.mil.findViewById(R.h.bAe);
        this.vym = ah.eU(ab.getContext());
        this.vyn = com.tencent.mm.bg.a.T(ab.getContext(), R.f.aWJ);
        this.maxSize = (int) (((float) com.tencent.mm.bg.a.U(ab.getContext(), R.f.aWJ)) * 1.45f);
        return this;
    }
}
