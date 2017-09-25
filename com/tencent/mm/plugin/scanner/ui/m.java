package com.tencent.mm.plugin.scanner.ui;

import android.graphics.Point;
import android.util.DisplayMetrics;
import com.tencent.mm.R;
import com.tencent.mm.plugin.scanner.ui.i.b;
import com.tencent.mm.plugin.scanner.util.b.a;
import com.tencent.mm.plugin.scanner.util.l;

public class m extends c {
    public m(b bVar, Point point, DisplayMetrics displayMetrics, int i) {
        super(bVar, point, displayMetrics, i);
    }

    protected final float aYd() {
        return 1.586f;
    }

    protected final String aYe() {
        return "identity";
    }

    protected final int aYf() {
        return R.l.eOA;
    }

    protected final com.tencent.mm.plugin.scanner.util.b a(a aVar) {
        return new l(aVar, 1);
    }
}
