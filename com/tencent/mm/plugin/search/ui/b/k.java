package com.tencent.mm.plugin.search.ui.b;

import android.content.Context;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiSetBackgroundAudioState;
import com.tencent.mm.plugin.fts.d.a;
import com.tencent.mm.plugin.fts.d.i;
import com.tencent.mm.plugin.fts.d.i.b;
import com.tencent.tmassistantsdk.downloadservice.Downloads;

public final class k extends a {
    public final i a(Context context, b bVar, int i) {
        return new com.tencent.mm.plugin.search.ui.c.k(context, bVar, i);
    }

    public final int getType() {
        return JsApiSetBackgroundAudioState.CTRL_INDEX;
    }

    public final int getPriority() {
        return Downloads.RECV_BUFFER_SIZE;
    }
}
