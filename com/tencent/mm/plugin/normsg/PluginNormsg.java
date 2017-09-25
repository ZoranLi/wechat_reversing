package com.tencent.mm.plugin.normsg;

import com.tencent.mm.kernel.b.d;
import com.tencent.mm.kernel.b.e;
import com.tencent.mm.plugin.normsg.a.c;
import com.tencent.mm.plugin.normsg.utils.NativeLogic;
import com.tencent.mm.plugin.report.a;

public class PluginNormsg extends d implements a {
    public void installed() {
        alias(a.class);
    }

    public void dependency() {
        dependsOn(com.tencent.mm.plugin.zero.a.d.class);
        dependsOn(a.class);
    }

    public void configure(e eVar) {
        com.tencent.mm.plugin.normsg.a.d.a(b.nZw);
        c.a(NativeLogic.a.nZH);
    }

    public void execute(e eVar) {
    }
}
