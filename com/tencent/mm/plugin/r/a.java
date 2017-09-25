package com.tencent.mm.plugin.r;

import com.tencent.mm.bj.g;
import com.tencent.mm.kernel.api.bucket.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.storage.at;

public final class a implements d, com.tencent.mm.plugin.r.a.a {
    private at nyf;

    public final at wY() {
        h.vJ();
        h.vG().uQ();
        return this.nyf;
    }

    public final void onDataBaseOpened(g gVar, g gVar2) {
        this.nyf = new at(gVar);
    }

    public final void onDataBaseClosed(g gVar, g gVar2) {
    }
}
