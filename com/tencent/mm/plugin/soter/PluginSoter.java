package com.tencent.mm.plugin.soter;

import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.d;
import com.tencent.mm.kernel.b.e;
import com.tencent.mm.kernel.e.f;
import com.tencent.mm.plugin.soter.a.a;
import com.tencent.mm.plugin.soter.c.g;
import com.tencent.mm.plugin.soter.d.b;
import com.tencent.mm.sdk.platformtools.w;

public class PluginSoter extends d implements c, a {
    private com.tencent.mm.plugin.soter.c.d qPM = null;
    private boolean qPN = false;

    public String name() {
        return "plugin-soter";
    }

    public void installed() {
        alias(a.class);
    }

    public void dependency() {
        dependsOn(com.tencent.mm.plugin.comm.a.a.class);
    }

    public void configure(e eVar) {
    }

    public void execute(e eVar) {
        if (eVar.ej("")) {
            w.i("MicroMsg.PluginSoter", "alvinluo PluginSoter in process: %s execute and run pipeline", new Object[]{eVar.gWO});
            this.qPN = true;
            w.v("MicroMsg.PluginSoter", "alvinluo PluginSoter add SoterDynamicConfigUpdatedEventListener");
            this.qPM = new com.tencent.mm.plugin.soter.c.d();
            safeAddListener(this.qPM);
        }
    }

    public void uninstalled() {
        super.uninstalled();
        safeRemoveListener(this.qPM);
    }

    private void safeAddListener(com.tencent.mm.sdk.b.c cVar) {
        if (cVar == null) {
            w.w("MicroMsg.PluginSoter", "hy: listener is null or id is invalid");
        } else if (com.tencent.mm.sdk.b.a.urY.d(cVar)) {
            w.w("MicroMsg.PluginSoter", "hy: already has listener");
        } else {
            com.tencent.mm.sdk.b.a.urY.b(cVar);
        }
    }

    private void safeRemoveListener(com.tencent.mm.sdk.b.c cVar) {
        if (cVar == null) {
            w.w("MicroMsg.PluginSoter", "alvinluo listener is null");
        } else {
            com.tencent.mm.sdk.b.a.urY.c(cVar);
        }
    }

    public void onAccountInitialized(f fVar) {
        w.v("MicroMsg.PluginSoter", "alvinluo onAccountInitialized, isMainProcess: %b", new Object[]{Boolean.valueOf(this.qPN)});
        if (this.qPN) {
            g.blV();
            b.blZ();
        }
    }

    public void onAccountRelease() {
        w.v("MicroMsg.PluginSoter", "alvinluo onAccountRelease");
    }
}
