package com.tencent.mm.plugin.card.sharecard.ui;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.model.al;
import com.tencent.mm.plugin.card.sharecard.a.b;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;

public final class e {
    private ImageView fMY;
    private MMActivity kdb;
    protected LinearLayout kiA;
    private TextView kiB;
    View kix;
    b kiy;
    protected LinearLayout kiz;

    public e(MMActivity mMActivity) {
        this.kdb = mMActivity;
    }

    public final void agF() {
        if (this.kix == null) {
            this.kix = View.inflate(this.kdb, R.i.cWQ, null);
            this.fMY = (ImageView) this.kix.findViewById(R.h.boj);
            this.kiB = (TextView) this.kix.findViewById(R.h.cFh);
            this.kiz = (LinearLayout) this.kix.findViewById(R.h.cbN);
            this.kiA = (LinearLayout) this.kix.findViewById(R.h.cbL);
            this.kiz.setVisibility(8);
            this.kiA.setVisibility(8);
            Animation rotateAnimation = new RotateAnimation(0.0f, 359.0f, 1, 0.5f, 1, 0.5f);
            rotateAnimation.setDuration(1000);
            rotateAnimation.setRepeatCount(-1);
            rotateAnimation.setInterpolator(new LinearInterpolator());
            this.fMY.startAnimation(rotateAnimation);
        }
        ar();
    }

    public final void agG() {
        this.kiz.setVisibility(0);
        this.kiA.setVisibility(8);
    }

    public final void agH() {
        this.kiz.setVisibility(8);
    }

    private void agI() {
        this.kiz.setVisibility(8);
        this.kiA.setVisibility(8);
    }

    public final void agJ() {
        agI();
        this.kiB.setVisibility(8);
    }

    public final void ar() {
        Integer num = (Integer) al.agf().getValue("key_share_card_show_type");
        if (num == null) {
            num = Integer.valueOf(0);
        }
        if (this.kiy != null && b.agz() && ((r0.intValue() == 1 || r0.intValue() == 4) && b.agw())) {
            this.kiB.setVisibility(0);
        } else {
            this.kiB.setVisibility(8);
            if (this.kiy != null) {
                w.d("MicroMsg.ShareCardFooterController", "updateView isLocalEnd %s isOtherEnd %s ", new Object[]{Boolean.valueOf(b.agz()), Boolean.valueOf(b.agA())});
                if (!b.agz() || !b.agA()) {
                    agG();
                    return;
                } else if (b.agz() && b.agA()) {
                    this.kiz.setVisibility(8);
                    this.kiA.setVisibility(8);
                    return;
                } else {
                    return;
                }
            }
        }
        agI();
    }
}
