package com.tencent.mm.plugin.favorite.ui.b;

import android.content.Context;
import com.tencent.mm.plugin.fts.d.a;
import com.tencent.mm.plugin.fts.d.i;
import com.tencent.mm.plugin.fts.d.i.b;
import com.tencent.wcdb.FileUtils;

public final class d extends a {
    public final i a(Context context, b bVar, int i) {
        return new e(context, bVar, i);
    }

    public final int getType() {
        return FileUtils.S_IWUSR;
    }

    public final int getPriority() {
        return FileUtils.S_IWUSR;
    }
}
