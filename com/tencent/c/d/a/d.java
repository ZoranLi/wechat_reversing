package com.tencent.c.d.a;

import com.tencent.c.d.b.d.a;
import com.tencent.c.e.g;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public final class d implements b {
    private final HashSet<Integer> wSh = new HashSet();
    private final List<a> wSi = new ArrayList();

    public final void a(a aVar) {
        if (aVar.uid == 0) {
            if (aVar.wSn == 1 && !"/sbin/adbd".equals(aVar.name)) {
                g.d("ProcessRelationAnalyzer parent : " + aVar.toString());
                this.wSh.add(Integer.valueOf(aVar.pid));
            } else if (aVar.wSn > 1 && "sh".equals(aVar.name) && "/system/bin/sh".equals(aVar.name)) {
                g.d("ProcessRelationAnalyzer child : " + aVar.toString());
                this.wSi.add(aVar);
            }
        }
    }

    public final boolean cdG() {
        for (a aVar : this.wSi) {
            if (this.wSh.contains(Integer.valueOf(aVar.wSn))) {
                g.Vi("ProcessRelationAnalyzer match : " + aVar.toString());
                return true;
            }
        }
        return false;
    }
}
