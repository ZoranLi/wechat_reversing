package com.tencent.mm.plugin.search.ui.b;

import android.content.Context;
import com.tencent.mm.plugin.fts.d.a;
import com.tencent.mm.plugin.fts.d.i;

public final class b extends a {
    public final i a(Context context, com.tencent.mm.plugin.fts.d.i.b bVar, int i) {
        return new com.tencent.mm.plugin.search.ui.c.b(context, bVar, i);
    }

    public final int getType() {
        return 4128;
    }

    public final int getPriority() {
        return Integer.MAX_VALUE;
    }
}
