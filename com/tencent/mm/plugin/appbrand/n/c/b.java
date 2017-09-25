package com.tencent.mm.plugin.appbrand.n.c;

import com.tencent.mm.sdk.platformtools.MMBitmapFactory;

public class b extends Exception {
    public int jpA;

    public b() {
        this.jpA = MMBitmapFactory.ERROR_LOCK_BITMAP_FAILED;
    }

    public b(String str) {
        super(str);
        this.jpA = MMBitmapFactory.ERROR_LOCK_BITMAP_FAILED;
    }

    public b(int i, Throwable th) {
        super(th);
        this.jpA = i;
    }
}
