package com.tencent.mm.plugin.appbrand.d;

import com.tencent.mm.plugin.appbrand.app.c;
import com.tencent.mm.plugin.appbrand.b.e;
import com.tencent.mm.plugin.appbrand.config.p;
import com.tencent.mm.plugin.appbrand.m.d;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.platformtools.bg;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

enum i {
    ;
    
    private static final a iJL = null;

    static {
        iJL = new a();
    }

    static void onCreate() {
        p.RG().a(iJL, d.vL().nJF.getLooper());
    }

    static void onDestroy() {
        p.RG().f(iJL);
    }

    static List<e> Sv() {
        List<e> linkedList = new LinkedList();
        if (c.PW() != null) {
            Collection Rj = c.PW().Rj();
            if (!bg.bV(Rj)) {
                linkedList.addAll(Rj);
            }
        }
        return linkedList;
    }

    static e oV(String str) {
        return c.PW() == null ? null : c.PW().nS(str);
    }

    static e oW(String str) {
        return c.PW() == null ? null : c.PW().nS(str);
    }

    static void d(a aVar) {
        if (c.PW() != null) {
            c.PW().c(aVar);
        }
    }

    static void e(a aVar) {
        if (c.PW() != null) {
            c.PW().f(aVar);
        }
    }
}
