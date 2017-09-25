package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import com.tencent.mm.R;
import com.tencent.mm.plugin.profile.ui.HelperHeaderPreference.a;

final class o implements a {
    private final Context context;

    public o(Context context) {
        this.context = context;
    }

    public final CharSequence getHint() {
        return this.context.getString(R.l.dYo);
    }

    public final void a(HelperHeaderPreference helperHeaderPreference) {
        helperHeaderPreference.gm(true);
    }
}
