package com.tencent.mm.plugin.downloader;

import com.tencent.mm.bj.g;
import com.tencent.mm.kernel.api.bucket.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.downloader.b.b;

public final class a implements d, com.tencent.mm.plugin.downloader.a.a {
    private b kFZ;

    public final void onDataBaseOpened(g gVar, g gVar2) {
        this.kFZ = new b(gVar);
    }

    public final void onDataBaseClosed(g gVar, g gVar2) {
    }

    public final b wX() {
        h.vJ();
        h.vG().uQ();
        return this.kFZ;
    }
}
