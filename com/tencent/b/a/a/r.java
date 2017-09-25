package com.tencent.b.a.a;

import android.content.Context;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class r {
    private static r aQG = null;
    private Map<Integer, q> aQE;
    private int aQF;

    private r(Context context) {
        this.aQE = null;
        this.aQF = 0;
        this.aQE = new HashMap(3);
        this.aQE.put(Integer.valueOf(1), new o(context));
        this.aQE.put(Integer.valueOf(2), new d(context));
        this.aQE.put(Integer.valueOf(4), new k(context));
    }

    static synchronized r T(Context context) {
        r rVar;
        synchronized (r.class) {
            if (aQG == null) {
                aQG = new r(context);
            }
            rVar = aQG;
        }
        return rVar;
    }

    final g nS() {
        return n(new ArrayList(Arrays.asList(new Integer[]{Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(4)})));
    }

    final g n(List<Integer> list) {
        if (list.size() >= 0) {
            for (Integer num : list) {
                q qVar = (q) this.aQE.get(num);
                if (qVar != null) {
                    g nS = qVar.nS();
                    if (nS != null && s.aK(nS.aQm)) {
                        return nS;
                    }
                }
            }
        }
        return new g();
    }

    final a nT() {
        return o(new ArrayList(Arrays.asList(new Integer[]{Integer.valueOf(1), Integer.valueOf(4)})));
    }

    private a o(List<Integer> list) {
        if (list.size() > 0) {
            for (Integer num : list) {
                q qVar = (q) this.aQE.get(num);
                if (qVar != null) {
                    a nT = qVar.nT();
                    if (nT != null) {
                        return nT;
                    }
                }
            }
        }
        return new a();
    }

    final void b(a aVar) {
        for (Entry value : this.aQE.entrySet()) {
            ((q) value.getValue()).b(aVar);
        }
    }

    final void b(g gVar) {
        for (Entry value : this.aQE.entrySet()) {
            ((q) value.getValue()).b(gVar);
        }
    }
}
