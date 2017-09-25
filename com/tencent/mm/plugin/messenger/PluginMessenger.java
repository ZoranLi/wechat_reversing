package com.tencent.mm.plugin.messenger;

import com.tencent.mm.kernel.b.d;
import com.tencent.mm.kernel.b.e;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.comm.a.a;
import com.tencent.mm.plugin.messenger.a.b;

public class PluginMessenger extends d implements b {
    a nyi = new a();

    public void installed() {
        alias(b.class);
    }

    public void dependency() {
        dependsOn(a.class);
    }

    public void configure(e eVar) {
        if (eVar.ej("")) {
            h.vJ();
            h.a(com.tencent.mm.plugin.messenger.a.a.class, this.nyi);
        }
    }

    public void execute(e eVar) {
        if (eVar.ej("")) {
            pin(com.tencent.mm.plugin.ab.a.aWY());
        }
    }

    public String toString() {
        return "plugin-messenger";
    }
}
