package com.tencent.mm.plugin.appbrand.widget.input;

import android.support.v4.e.a;
import com.tencent.mm.plugin.appbrand.g.r;

public final class f {
    private static final f jsI = new f();
    private final a<r, Integer> jsH = new a();

    public static f Yv() {
        return jsI;
    }

    final void m(r rVar) {
        if (rVar != null) {
            this.jsH.remove(rVar);
            rVar.getView().setFocusable(true);
            rVar.getView().setFocusableInTouchMode(true);
        }
    }

    public final void n(r rVar) {
        if (rVar != null) {
            Integer num = (Integer) this.jsH.get(rVar);
            if (num == null) {
                num = Integer.valueOf(0);
            }
            this.jsH.put(rVar, Integer.valueOf(num.intValue() + 1));
            rVar.getView().setFocusable(false);
            rVar.getView().setFocusableInTouchMode(false);
        }
    }

    public final void o(r rVar) {
        if (rVar != null) {
            Integer num = (Integer) this.jsH.get(rVar);
            if (num != null) {
                num = Integer.valueOf(num.intValue() - 1);
                if (num.intValue() > 0) {
                    this.jsH.put(rVar, num);
                    return;
                }
            }
            m(rVar);
        }
    }
}
