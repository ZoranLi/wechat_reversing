package com.tencent.mm.plugin.report;

import com.tencent.mm.kernel.api.bucket.b;
import com.tencent.mm.kernel.b.d;
import com.tencent.mm.kernel.b.e;
import com.tencent.mm.kernel.c.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.report.service.i;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.l;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class PluginReport extends d implements b, a {
    private l oTa;

    public void installed() {
        alias(a.class);
    }

    public void dependency() {
        dependsOn(n.class);
    }

    public void configure(e eVar) {
        this.oTa = new l(i.class);
        h.a(l.class, new c(this.oTa));
        c cVar = c.oTb;
        w.i("MicroMsg.ReportService", "instance set %s", g.oUh);
        cVar.oTc = r1;
    }

    public void execute(e eVar) {
    }

    public List<String> collectStoragePaths() {
        Object linkedList = new LinkedList();
        Collections.addAll(linkedList, new String[]{"logcat/"});
        return linkedList;
    }

    public String toString() {
        return "plugin-report";
    }
}
