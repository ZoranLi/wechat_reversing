package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import com.tencent.mm.R;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.profile.ui.HelperHeaderPreference.a;
import com.tencent.mm.u.m;

final class q implements a {
    private Context context;

    public q(Context context) {
        this.context = context;
    }

    public final CharSequence getHint() {
        return this.context.getString(R.l.dYm);
    }

    public final void a(HelperHeaderPreference helperHeaderPreference) {
        helperHeaderPreference.gm((m.xW() & WXMediaMessage.THUMB_LENGTH_LIMIT) == 0);
    }
}
