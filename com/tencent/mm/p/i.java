package com.tencent.mm.p;

import com.tencent.mm.bj.g.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.am;
import com.tencent.mm.u.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class i implements am {
    private static HashMap<Integer, c> gJr;
    private e gUI;
    private c gUJ = new c();
    Map<Integer, List<f>> gUK = new HashMap();

    static i ue() {
        return (i) l.o(i.class);
    }

    public static e uf() {
        if (ue().gUI == null) {
            ue().gUI = new e(h.vI().gYg);
        }
        return ue().gUI;
    }

    public static c ug() {
        if (ue().gUJ == null) {
            ue().gUJ = new c();
        }
        return ue().gUJ;
    }

    public static synchronized void a(f fVar) {
        synchronized (i.class) {
            w.i("MicroMsg.SubCoreFunctionMsg", "removeUpdateCallback, msgType: %s, callback: %s", Integer.valueOf(12399999), fVar);
            if (fVar != null) {
                List list = (List) ue().gUK.get(Integer.valueOf(12399999));
                if (list != null && list.contains(fVar)) {
                    list.remove(fVar);
                    ue().gUK.put(Integer.valueOf(12399999), list);
                }
            }
        }
    }

    public static synchronized void b(f fVar) {
        synchronized (i.class) {
            w.i("MicroMsg.SubCoreFunctionMsg", "addUpdateCallback, msgType: %s, callback: %s", Integer.valueOf(12399999), fVar);
            if (fVar != null) {
                List list = (List) ue().gUK.get(Integer.valueOf(12399999));
                if (list == null) {
                    list = new ArrayList();
                }
                if (!list.contains(fVar)) {
                    list.add(fVar);
                }
                ue().gUK.put(Integer.valueOf(12399999), list);
            }
        }
    }

    static {
        HashMap hashMap = new HashMap();
        gJr = hashMap;
        hashMap.put(Integer.valueOf("FunctionMsgItem".hashCode()), new c() {
            public final String[] pP() {
                return e.gUx;
            }
        });
    }

    public final HashMap<Integer, c> uh() {
        w.i("MicroMsg.SubCoreFunctionMsg", "getBaseDBFactories");
        return gJr;
    }

    public final void eD(int i) {
    }

    public final void aM(boolean z) {
        w.i("MicroMsg.SubCoreFunctionMsg", "onAccountPostReset");
        h.vL().e(new Runnable() {
            public final void run() {
                w.i("MicroMsg.FetchAllNeedFunctionJob", "FetchAllNeedFunctionJob, run");
                if (!i.ug().tW() && !i.ug().tX()) {
                    i.ug().tY();
                }
            }
        }, 10000);
    }

    public final void aN(boolean z) {
    }

    public final void onAccountRelease() {
        w.d("MicroMsg.SubCoreFunctionMsg", "onAccountRelease");
    }
}
