package com.tencent.mm.ah.a.b;

import com.tencent.mm.a.g;
import com.tencent.mm.ah.a.c.f;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class d implements f {
    public final String jJ(String str) {
        if (bg.mA(str)) {
            return null;
        }
        w.d("MicroMsg.imageloader.DefaultImageFileNameCreater", "[cpan] create image file name :%s", g.n(str.getBytes()));
        return g.n(str.getBytes());
    }
}
