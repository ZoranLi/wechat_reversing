package com.tencent.mm.ui.chatting;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.emoji.RTChattingEmojiView;
import com.tencent.mm.ui.chatting.ah.a;

final class do extends a {
    ProgressBar oDJ;
    ViewStub vIg;
    RTChattingEmojiView vyw;
    ImageView vyx;
    ImageView vyy;

    public do(int i) {
        super(i);
    }

    public final a p(View view, boolean z) {
        super.dn(view);
        this.kxi = (TextView) view.findViewById(R.h.bBA);
        this.vyw = (RTChattingEmojiView) view.findViewById(R.h.bAj);
        this.mfD = (CheckBox) view.findViewById(R.h.bAd);
        this.nRW = view.findViewById(R.h.bAX);
        if (z) {
            this.piH = (TextView) view.findViewById(R.h.bBG);
            this.type = 14;
        } else {
            this.oDJ = (ProgressBar) view.findViewById(R.h.cKX);
            this.piH = (TextView) view.findViewById(R.h.bBG);
            this.vyK = (ImageView) view.findViewById(R.h.bBw);
            this.type = 15;
            this.vyy = (ImageView) view.findViewById(R.h.bBy);
        }
        if (this.vyx != null) {
            ((ViewGroup) this.vyx.getParent()).setBackgroundDrawable(null);
        }
        this.vIg = (ViewStub) view.findViewById(R.h.bBm);
        return this;
    }
}
