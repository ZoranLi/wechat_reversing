package com.tencent.mm.plugin.appbrand;

import android.support.v4.e.a;
import com.tencent.mm.sdk.platformtools.bg;
import java.util.Map;

public final class l {
    private static final Map<String, l> gWj = new a();
    private static final l ixm = new l();
    public volatile String ixn;
    public volatile String ixo;
    public volatile int ixp;
    public volatile boolean ixq = false;

    private l() {
    }

    static l np(String str) {
        return nq(str);
    }

    private static l nq(String str) {
        if (bg.mA(str)) {
            return null;
        }
        l lVar;
        synchronized (gWj) {
            lVar = (l) gWj.get(str);
            if (lVar == null) {
                lVar = new l();
                gWj.put(str, lVar);
            }
        }
        return lVar;
    }

    private static l nr(String str) {
        if (bg.mA(str)) {
            return null;
        }
        l lVar;
        synchronized (gWj) {
            lVar = (l) gWj.get(str);
        }
        return lVar;
    }

    static void remove(String str) {
        if (!bg.mA(str)) {
            synchronized (gWj) {
                gWj.remove(str);
            }
        }
    }

    public static l ns(String str) {
        l nr = nr(str);
        return nr == null ? ixm : nr;
    }

    public static l nt(String str) {
        return nq(str);
    }
}
