package com.tencent.mm.plugin.search.ui.b;

import android.content.Context;
import com.tencent.mm.plugin.fts.d.a;
import com.tencent.mm.plugin.fts.d.i;
import com.tencent.mm.plugin.fts.d.i.b;
import com.tencent.mm.plugin.gif.MMGIFException;

public final class j extends a {
    public final i a(Context context, b bVar, int i) {
        return new com.tencent.mm.plugin.search.ui.c.j(context, bVar, i);
    }

    public final int getType() {
        return MMGIFException.D_GIF_ERR_IMAGE_DEFECT;
    }

    public final int getPriority() {
        return MMGIFException.D_GIF_ERR_IMAGE_DEFECT;
    }
}
