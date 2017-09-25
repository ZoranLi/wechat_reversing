package com.tencent.mm.plugin.zero.tasks;

import com.tencent.mm.kernel.a.c;
import com.tencent.mm.kernel.b.e;
import com.tencent.mm.modelsfs.FileOp;

public final class d extends c {
    public final void execute(e eVar) {
        FileOp.init(eVar.ej(""));
    }

    public final String name() {
        return "boot-sfs";
    }
}
