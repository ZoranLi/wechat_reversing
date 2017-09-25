package com.tencent.mm.plugin.appbrand.n.c;

import com.tencent.mm.sdk.platformtools.MMBitmapFactory;

public final class c extends b {
    public c(String str) {
        super(str);
    }

    public c(Throwable th) {
        super(MMBitmapFactory.ERROR_LOCK_BITMAP_FAILED, th);
    }
}
