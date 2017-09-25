package com.tencent.mm.plugin.search.ui.b;

import android.content.Context;
import com.tencent.mm.plugin.fts.d.a;
import com.tencent.mm.plugin.fts.d.i;
import com.tencent.mm.plugin.fts.d.i.b;

public final class d extends a {
    public final i a(Context context, b bVar, int i) {
        return new com.tencent.mm.plugin.search.ui.c.d(context, bVar, i);
    }

    public final int getType() {
        return 4112;
    }

    public final int getPriority() {
        return Integer.MAX_VALUE;
    }
}
