package com.tencent.mm.plugin.i;

import com.tencent.mm.compatible.util.k;
import com.tencent.mm.kernel.b.e;

public final class c extends com.tencent.mm.kernel.a.c {
    public final void execute(e eVar) {
        k.b("wechatvoicereco", getClass().getClassLoader());
    }

    public final String name() {
        return "boot-load-wechatvoicereco-library";
    }
}
