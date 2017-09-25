package com.tencent.mm.plugin.hardwareopt;

import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.d;
import com.tencent.mm.kernel.b.e;
import com.tencent.mm.kernel.e.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.hardwareopt.a.a.a;
import com.tencent.mm.plugin.hardwareopt.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.w;

public class PluginHardwareOpt extends d implements c, b {
    public void installed() {
        alias(b.class);
    }

    public void dependency() {
        dependsOn(n.class);
    }

    public void configure(e eVar) {
        if (eVar.ej("")) {
            w.v("MicroMsg.PluginHardwareOpt", "hy: on config");
            h.a(a.class, new com.tencent.mm.plugin.hardwareopt.a.a());
        }
    }

    public void execute(e eVar) {
        if (eVar.ej("")) {
            w.i("MicroMsg.PluginHardwareOpt", "hy: on execute. ");
        }
    }

    public void onAccountInitialized(f fVar) {
        w.v("MicroMsg.PluginHardwareOpt", "hy: on onAccountInitialized");
        ((a) h.h(a.class)).eN(false);
    }

    public void onAccountRelease() {
        w.v("MicroMsg.PluginHardwareOpt", "hy: on onAccountRelease");
    }
}
