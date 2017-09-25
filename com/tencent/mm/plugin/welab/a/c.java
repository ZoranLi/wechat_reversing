package com.tencent.mm.plugin.welab.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.plugin.welab.d.b;
import com.tencent.mm.plugin.welab.ui.WelabMainUI;

public final class c implements com.tencent.mm.plugin.welab.a.a.c {
    public final void s(Context context, Intent intent) {
        intent.setClass(context, WelabMainUI.class);
        String str = "para_from_with_red_point";
        int i = (bAK() || bAL()) ? 1 : 0;
        intent.putExtra(str, i);
        context.startActivity(intent);
    }

    public final boolean bAK() {
        b.bAV();
        return b.bAX() && !bAL();
    }

    public final boolean bAL() {
        b.bAV();
        if (!b.bAY()) {
            b.bAV();
            if (b.bAX()) {
                return true;
            }
        }
        return false;
    }

    public final boolean bAM() {
        return !bAL();
    }
}
