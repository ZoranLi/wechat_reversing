package com.tencent.mm.plugin.performance;

import com.tencent.mm.bl.c;
import com.tencent.mm.kernel.b.d;
import com.tencent.mm.kernel.b.e;
import com.tencent.mm.performance.c.b;
import com.tencent.mm.platformtools.q;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.performance.a.a;
import com.tencent.mm.plugin.report.PluginReport;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.u.m;
import java.util.Map;

public class PluginPerformance extends d implements a {
    public void installed() {
        alias(a.class);
    }

    public void dependency() {
        dependsOn(PluginReport.class);
        dependsOn(n.class);
    }

    public void configure(e eVar) {
        c.uNC = new com.tencent.mm.bl.a() {
            public final boolean Cw(String str) {
                return q.a(str, m.xL(), true, false);
            }
        };
        com.tencent.mm.performance.c.a.igu = new b() {
            public final void a(String str, String str2, Map<String, Object> map) {
                g.oUh.d(str, str2, map);
            }
        };
    }

    public void execute(e eVar) {
    }

    public String toString() {
        return "plugin-performance";
    }
}
