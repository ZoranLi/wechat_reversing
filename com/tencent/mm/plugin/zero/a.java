package com.tencent.mm.plugin.zero;

import com.tencent.mm.i.e;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.e.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.w;
import java.io.File;

public final class a implements c, com.tencent.mm.plugin.zero.b.a {
    private e sAK = new e();
    private com.tencent.mm.i.c sAL = new com.tencent.mm.i.c();

    public final e sV() {
        h.vJ();
        h.vG().uQ();
        return this.sAK;
    }

    public final com.tencent.mm.i.c sW() {
        h.vJ();
        h.vG().uQ();
        return this.sAL;
    }

    public final void onAccountInitialized(f fVar) {
        if (fVar.gYz) {
            com.tencent.mm.i.c cVar = this.sAL;
            File file = new File(com.tencent.mm.compatible.util.e.hgu + "configlist/");
            if (file.exists()) {
                File file2 = new File(com.tencent.mm.i.c.gTi);
                if (!file2.exists()) {
                    w.d("MicroMsg.ConfigListDecoder", "bugfix");
                    cVar.a(file, file2);
                }
            }
        }
        this.sAK.sL();
        this.sAL.init();
    }

    public final void onAccountRelease() {
    }
}
