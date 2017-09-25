package com.tencent.mm.u;

import com.tencent.mm.bj.g;
import com.tencent.mm.kernel.api.bucket.a;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.api.bucket.e;
import com.tencent.mm.kernel.b.b;
import com.tencent.mm.kernel.e.f;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;

public class l implements a, c, e, b {
    private static HashMap<Class<? extends am>, am> hlp = new HashMap();
    private Class<? extends am> hlo;

    public static synchronized void xJ() {
        synchronized (l.class) {
            w.i("MicroMsg.CompatSubCore", "reset subcore %s", Integer.valueOf(hlp.size()));
            hlp.clear();
        }
    }

    public static synchronized <T extends am> T o(Class<T> cls) {
        T t;
        synchronized (l.class) {
            t = (am) hlp.get(cls);
            if (t == null) {
                try {
                    t = (am) cls.newInstance();
                    w.i("MicroMsg.CompatSubCore", "create subcore %s %s", cls, t);
                    hlp.put(t.getClass(), t);
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.CompatSubCore", e, "", new Object[0]);
                    throw new IllegalAccessError(e.getMessage());
                } catch (Throwable e2) {
                    w.printErrStackTrace("MicroMsg.CompatSubCore", e2, "", new Object[0]);
                    throw new IllegalAccessError(e2.getMessage());
                }
            }
        }
        return t;
    }

    public l(Class<? extends am> cls) {
        this.hlo = cls;
        o(this.hlo);
    }

    public HashMap<Integer, g.c> collectDatabaseFactory() {
        return o(this.hlo).uh();
    }

    public void onAccountInitialized(f fVar) {
        o(this.hlo).aM(fVar.gYz);
    }

    public void onAccountRelease() {
        o(this.hlo).onAccountRelease();
    }

    public final void aR(boolean z) {
    }

    public void onDataBaseOpened(g gVar, g gVar2) {
    }

    public final void vB() {
        o(this.hlo).aN(com.tencent.mm.compatible.util.f.rZ());
    }

    public void eg(String str) {
    }

    public void onDataBaseClosed(g gVar, g gVar2) {
    }
}
