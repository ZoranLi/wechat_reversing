package com.tencent.mm.plugin.audio;

import com.tencent.mm.kernel.b.d;
import com.tencent.mm.kernel.b.e;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.plugin.audio.a.a;
import com.tencent.mm.u.l;

public class PluginVoice extends d implements a {
    public String name() {
        return "plugin-voice";
    }

    public void installed() {
        alias(a.class);
    }

    public void dependency() {
        dependsOn(com.tencent.mm.plugin.zero.a.d.class);
    }

    public void configure(e eVar) {
    }

    public void execute(e eVar) {
        if (eVar.ej("")) {
            pin(new l(m.class));
        }
    }
}
