package com.tencent.mm.plugin.search.ui.b;

import android.content.Context;
import com.tencent.mm.plugin.fts.d.i;
import com.tencent.mm.plugin.fts.d.i.b;

public final class a extends com.tencent.mm.plugin.fts.d.a {
    public final i a(Context context, b bVar, int i) {
        return new com.tencent.mm.plugin.search.ui.c.a(context, bVar, i);
    }

    public final int getType() {
        return 8192;
    }

    public final int getPriority() {
        return Integer.MAX_VALUE;
    }
}
