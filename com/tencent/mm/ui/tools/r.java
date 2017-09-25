package com.tencent.mm.ui.tools;

import android.content.Context;
import android.content.res.ColorStateList;
import com.tencent.mm.bg.a;
import com.tencent.mm.s.a.d;
import junit.framework.Assert;

public final class r {
    private static r woQ = null;
    private ColorStateList[] vvt = new ColorStateList[2];
    private boolean woR = false;

    private r(Context context) {
        this.vvt[0] = a.S(context, d.hbw);
        this.vvt[1] = a.S(context, d.hbx);
    }

    private static r fd(Context context) {
        Assert.assertTrue(context != null);
        if (woQ == null || !woQ.woR) {
            woQ = new r(context);
        }
        return woQ;
    }

    public static ColorStateList fe(Context context) {
        return fd(context).vvt[0];
    }

    public static ColorStateList ff(Context context) {
        return fd(context).vvt[1];
    }
}
