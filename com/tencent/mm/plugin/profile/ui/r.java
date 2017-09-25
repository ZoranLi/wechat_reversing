package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import com.tencent.mm.R;
import com.tencent.mm.plugin.profile.ui.HelperHeaderPreference.a;
import com.tencent.mm.u.m;

final class r implements a {
    private Context context;

    public r(Context context) {
        this.context = context;
    }

    public final CharSequence getHint() {
        return this.context.getString(R.l.dYG);
    }

    public final void a(HelperHeaderPreference helperHeaderPreference) {
        helperHeaderPreference.gm((m.xW() & 16777216) == 0);
    }
}
