package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.sport.b.d;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.n;
import com.tencent.mm.u.o;

public final class df {
    private LinearLayout kZi;
    private OnClickListener oPX = new OnClickListener(this) {
        final /* synthetic */ df vHB;

        {
            this.vHB = r1;
        }

        public final void onClick(View view) {
            d.mN(1);
            o.eW("gh_43f2581f6fd6");
            Intent intent = new Intent();
            intent.putExtra("key_is_latest", true);
            intent.putExtra("rank_id", "#");
            intent.putExtra("key_only_show_latest_rank", true);
            intent.putExtra("app_username", n.eK("gh_43f2581f6fd6"));
            intent.putExtra("device_type", 1);
            com.tencent.mm.bb.d.b(view.getContext(), "exdevice", ".ui.ExdeviceRankInfoUI", intent);
        }
    };
    private ChatFooterCustom vBx;
    private FrameLayout vHA;

    public df(ChatFooterCustom chatFooterCustom) {
        this.vBx = chatFooterCustom;
    }

    public final void bSg() {
        w.i("MicroMsg.Sport.ChattingSportFooterHandler", "initFooter");
        this.vBx.findViewById(R.h.bAB).setVisibility(8);
        this.vBx.findViewById(R.h.bAw).setVisibility(8);
        this.kZi = (LinearLayout) this.vBx.findViewById(R.h.bAx);
        this.kZi.setWeightSum(1.0f);
        this.vHA = (FrameLayout) this.kZi.getChildAt(0);
        this.vHA.setVisibility(0);
        this.vHA.setOnClickListener(this.oPX);
        ((TextView) this.vHA.getChildAt(0).findViewById(R.h.bAz)).setText(R.l.egG);
        this.vHA.getChildAt(0).findViewById(R.h.bAy).setVisibility(8);
        this.vHA.getChildAt(1).setVisibility(8);
        for (int i = 1; i < 6; i++) {
            this.kZi.getChildAt(i).setVisibility(8);
        }
    }
}
