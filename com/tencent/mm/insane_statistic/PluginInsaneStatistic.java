package com.tencent.mm.insane_statistic;

import com.tencent.mm.ah.q;
import com.tencent.mm.insane_statistic.a.a;
import com.tencent.mm.kernel.b.d;
import com.tencent.mm.kernel.b.e;

public class PluginInsaneStatistic extends d implements a {
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
            q.hIb = new b();
            com.tencent.mm.modelstat.q.hXD = new a();
        }
    }
}
