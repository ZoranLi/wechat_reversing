package com.tencent.mm.performance.wxperformancetool;

import com.tencent.mm.performance.d.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public final class c {
    HashSet<a> iha = new HashSet();
    public b ihb;

    public final boolean Ne() {
        boolean mm = mm(com.tencent.mm.performance.a.a.TYPE);
        boolean z;
        if (mm) {
            z = false;
        } else {
            com.tencent.mm.performance.a.a aVar = new com.tencent.mm.performance.a.a();
            z = aVar.Na();
            if (z) {
                aVar.igj = new HashSet();
                this.iha.add(aVar);
            }
        }
        if (mm || r1) {
            return true;
        }
        return false;
    }

    public final void a(com.tencent.mm.performance.a.a.a aVar) {
        if (mm(com.tencent.mm.performance.a.a.TYPE)) {
            ((com.tencent.mm.performance.a.a) mn(com.tencent.mm.performance.a.a.TYPE)).a(aVar);
            return;
        }
        throw new IllegalArgumentException("registerActivityLifeCycleCallback, you must set monitor activity lifecycle first");
    }

    public final boolean Nf() {
        boolean z = false;
        if (!mm(com.tencent.mm.performance.c.c.TYPE)) {
            if (mm(com.tencent.mm.performance.a.a.TYPE)) {
                z = true;
                com.tencent.mm.performance.c.c cVar = new com.tencent.mm.performance.c.c();
                cVar.igs = new HashSet();
                cVar.igA = new HashSet();
                cVar.igz = new HashMap();
                if (com.tencent.mm.performance.c.a.isEnabled()) {
                    com.tencent.mm.performance.c.a.bl(ab.getContext());
                }
                a(new b(cVar));
                this.iha.add(cVar);
            } else {
                throw new IllegalArgumentException("setMonitorMemoryLeak, you should setMonitorActivityLifeCycle first(and return true)");
            }
        }
        return z;
    }

    public final void a(com.tencent.mm.performance.c.c.c cVar) {
        if (mm(com.tencent.mm.performance.c.c.TYPE)) {
            com.tencent.mm.performance.c.c cVar2 = (com.tencent.mm.performance.c.c) mn(com.tencent.mm.performance.c.c.TYPE);
            synchronized (cVar2.igs) {
                cVar2.igs.add(cVar);
            }
            return;
        }
        throw new IllegalArgumentException("registerMemoryLeakCallback, you must set monitor memoryleak first");
    }

    public final boolean Ng() {
        int i = 0;
        boolean mm = mm(com.tencent.mm.performance.b.a.TYPE);
        if (!mm) {
            boolean z;
            com.tencent.mm.performance.b.a aVar = new com.tencent.mm.performance.b.a();
            aVar.igK = 60000;
            aVar.igo = 50;
            aVar.igp = 70;
            aVar.igq = 90;
            if (aVar.ign > 0) {
                z = true;
            }
            aVar.igr = z;
            i = aVar.igr;
            if (i != 0) {
                aVar.igs = new HashSet();
                this.iha.add(aVar);
            }
        }
        return i | mm;
    }

    public final void a(com.tencent.mm.performance.b.a.a aVar) {
        if (mm(com.tencent.mm.performance.b.a.TYPE)) {
            com.tencent.mm.performance.b.a aVar2 = (com.tencent.mm.performance.b.a) mn(com.tencent.mm.performance.b.a.TYPE);
            synchronized (aVar2.igs) {
                aVar2.igs.add(aVar);
            }
            return;
        }
        throw new IllegalArgumentException("registerMemoryAlarmCallback, you must set monitor memoryleak first");
    }

    public final void ml(String str) {
        a mn = mn(str);
        if (mn != null) {
            mn.igK = 10000;
            return;
        }
        throw new IllegalArgumentException("setTypeMointorInterval, " + str + " is not opened");
    }

    private boolean mm(String str) {
        if (this.iha.isEmpty()) {
            return false;
        }
        Iterator it = this.iha.iterator();
        while (it.hasNext()) {
            if (((a) it.next()).Nb().equals(str)) {
                return true;
            }
        }
        return false;
    }

    private a mn(String str) {
        if (this.iha.isEmpty()) {
            return null;
        }
        Iterator it = this.iha.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar.Nb().equals(str)) {
                return aVar;
            }
        }
        return null;
    }
}
