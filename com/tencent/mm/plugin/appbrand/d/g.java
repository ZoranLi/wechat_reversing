package com.tencent.mm.plugin.appbrand.d;

import android.content.Context;
import com.tencent.mm.plugin.appbrand.jsapi.map.f;
import com.tencent.mm.plugin.fts.d.a;
import com.tencent.mm.plugin.fts.d.i;
import com.tencent.mm.plugin.fts.d.i.b;

public final class g extends a {
    public final i a(Context context, b bVar, int i) {
        return new h(context, bVar, i);
    }

    public final int getType() {
        return f.CTRL_INDEX;
    }

    public final int getPriority() {
        return 89;
    }
}
