package com.tencent.mm.memory;

import com.tencent.mm.sdk.b;
import com.tencent.mm.sdk.f.e;
import java.nio.ByteBuffer;

public final class h extends b<ByteBuffer> {
    public static h hgH = new h();

    static /* synthetic */ void a(h hVar, Object obj) {
        if (hVar.wf != null && hVar.wg < hVar.wf.length) {
            hVar.wf[hVar.wg] = obj;
            hVar.wg++;
        }
    }

    static {
        e.post(new Runnable() {
            public final void run() {
                for (int i = 0; i < 10; i++) {
                    h.a(h.hgH, ByteBuffer.allocate(16384));
                }
            }
        }, "DecodeTempStorage_preload");
    }

    private h() {
    }
}
