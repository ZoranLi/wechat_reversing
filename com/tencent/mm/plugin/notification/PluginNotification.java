package com.tencent.mm.plugin.notification;

import com.tencent.mm.kernel.b.d;
import com.tencent.mm.kernel.b.e;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.notification.b.a;
import com.tencent.mm.u.af;

public class PluginNotification extends d implements a {
    private af oac;

    public void installed() {
        alias(a.class);
    }

    public void dependency() {
        dependsOn(n.class);
    }

    public void configure(e eVar) {
    }

    public void execute(e eVar) {
    }

    public void setNotification(af afVar) {
        this.oac = afVar;
        b.nZQ = afVar;
    }

    public af getNotification() {
        return this.oac;
    }
}
