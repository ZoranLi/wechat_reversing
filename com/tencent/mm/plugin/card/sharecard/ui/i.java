package com.tencent.mm.plugin.card.sharecard.ui;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.plugin.card.model.al;
import com.tencent.mm.plugin.card.sharecard.a.b;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.ui.MMActivity;

public final class i {
    MMActivity kdb;
    private View khv;
    View kjd;
    TextView kje;
    TextView kjf;
    private boolean kjg = false;

    public i(MMActivity mMActivity, View view) {
        this.kdb = mMActivity;
        this.khv = view;
    }

    public final void ar() {
        Integer num = (Integer) al.agf().getValue("key_share_card_show_type");
        if (num == null) {
            num = Integer.valueOf(0);
        }
        if (num.intValue() == 0 || b.agx()) {
            this.kjd.setVisibility(8);
            return;
        }
        this.kjd.setVisibility(0);
        this.kje.setVisibility(0);
        ShareCardInfo shareCardInfo = new ShareCardInfo();
        if (TextUtils.isEmpty(shareCardInfo.km(10))) {
            this.kje.setVisibility(8);
        } else {
            this.kje.setVisibility(0);
            this.kje.setText(shareCardInfo.km(10));
        }
        if (TextUtils.isEmpty("")) {
            this.kjf.setVisibility(8);
            return;
        }
        this.kjf.setVisibility(0);
        this.kjf.setText("");
    }
}
