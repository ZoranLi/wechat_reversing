package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.kernel.h;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class d implements e {
    public Map<Integer, Set<t>> htd = new HashMap();

    public d() {
        h.vH().gXC.a(452, (e) this);
    }

    public final void a(int i, t tVar) {
        if (!this.htd.containsKey(Integer.valueOf(i))) {
            this.htd.put(Integer.valueOf(i), new HashSet());
        }
        if (!((Set) this.htd.get(Integer.valueOf(i))).contains(tVar)) {
            ((Set) this.htd.get(Integer.valueOf(i))).add(tVar);
        }
    }

    public final void b(int i, t tVar) {
        if (this.htd.get(Integer.valueOf(i)) != null) {
            ((Set) this.htd.get(Integer.valueOf(i))).remove(tVar);
        }
    }

    public static void a(int i, w wVar) {
        h.vH().gXC.a(new x(i, wVar), 0);
    }

    public final void a(int i, int i2, String str, k kVar) {
        x xVar = (x) kVar;
        Set set = (Set) this.htd.get(Integer.valueOf(xVar.sDD));
        if (set != null && set.size() > 0) {
            Set<t> hashSet = new HashSet();
            hashSet.addAll(set);
            for (t tVar : hashSet) {
                if (tVar != null && set.contains(tVar)) {
                    tVar.a(i, i2, str, xVar.sDE);
                }
            }
        }
    }
}
