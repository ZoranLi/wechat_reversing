package com.tencent.mm.ui.e;

import android.content.Context;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.w;

public final class b extends a {
    public b(Context context, com.tencent.mm.u.b.b.b bVar) {
        super(context, bVar);
    }

    public final int getLayoutId() {
        return R.i.cYK;
    }

    protected final void Iu(String str) {
        w.w("MicroMsg.ChattingMonitoredUnClickableBanner", "hy: un clickable. should not navigate here");
    }
}
