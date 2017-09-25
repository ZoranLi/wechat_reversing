package com.tencent.mm.ui.chatting;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.d.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.chatting.ah.a;
import com.tencent.mm.ui.widget.celltextview.CellTextView;

final class em extends a {
    View lmQ;
    ChattingTranslateView vAe;
    CellTextView vOB;
    private int vOC = 0;
    ImageView vyy;

    public em(int i) {
        super(i);
    }

    public final a p(View view, boolean z) {
        super.dn(view);
        this.kxi = (TextView) view.findViewById(R.h.bBA);
        this.piH = (TextView) view.findViewById(R.h.bBG);
        this.vOB = (CellTextView) view.findViewById(R.h.bAi);
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
        this.vOC = ah.eT(ab.getContext());
        this.vOB.setTextSize(com.tencent.mm.bg.a.dI(this.vOB.getContext()) * this.vOB.getTextSize());
        this.vOB.setOnTouchListener(new dx(new k(this.vOB.getContext())));
        return this;
    }

    public final void a(CellTextView cellTextView) {
        cellTextView.setMaxWidth(this.vOC);
    }
}
