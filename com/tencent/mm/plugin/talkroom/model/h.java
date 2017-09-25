package com.tencent.mm.plugin.talkroom.model;

import android.content.Context;
import com.tencent.mm.R;
import com.tencent.mm.e.b.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.n;
import com.tencent.mm.u.o;

public final class h {
    private static final int qXr = a.qXr;

    public static String ay(Context context, String str) {
        if (bg.mA(str)) {
            return null;
        }
        ap.yY();
        af Rc = c.wR().Rc(str);
        if (Rc == null) {
            return null;
        }
        if (!o.dH(str)) {
            return n.eK(str);
        }
        if (bg.mA(Rc.field_nickname)) {
            return context.getString(R.l.eXR);
        }
        return Rc.tK();
    }
}
