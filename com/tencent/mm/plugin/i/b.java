package com.tencent.mm.plugin.i;

import com.tencent.mm.compatible.util.k;
import com.tencent.mm.kernel.a.c;
import com.tencent.mm.kernel.b.e;

public final class b extends c {
    public final void execute(e eVar) {
        k.b("tencentloc", getClass().getClassLoader());
    }

    public final String name() {
        return "boot-load-tencentloc-library";
    }
}
