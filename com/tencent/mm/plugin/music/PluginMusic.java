package com.tencent.mm.plugin.music;

import com.tencent.mm.am.a.a;
import com.tencent.mm.am.a.b;
import com.tencent.mm.kernel.b.d;
import com.tencent.mm.kernel.b.e;
import com.tencent.mm.kernel.h;

public class PluginMusic extends d implements b {
    public void configure(e eVar) {
        if (eVar.ej("")) {
            h.vJ();
            h.a(a.class, new com.tencent.mm.am.e());
        }
    }

    public void execute(e eVar) {
    }
}
