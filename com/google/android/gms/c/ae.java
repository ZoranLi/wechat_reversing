package com.google.android.gms.c;

import com.google.android.gms.common.internal.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class ae {
    public long aAA;
    public long aAB;
    public long aAC;
    private long aAD;
    private long aAE;
    public boolean aAF;
    final Map<Class<? extends af>, af> aAG;
    final List<ai> aAH;
    public final ag aAy;
    public boolean aAz;
    public final v ahZ;

    private ae(ae aeVar) {
        this.aAy = aeVar.aAy;
        this.ahZ = aeVar.ahZ;
        this.aAA = aeVar.aAA;
        this.aAB = aeVar.aAB;
        this.aAC = aeVar.aAC;
        this.aAD = aeVar.aAD;
        this.aAE = aeVar.aAE;
        this.aAH = new ArrayList(aeVar.aAH);
        this.aAG = new HashMap(aeVar.aAG.size());
        for (Entry entry : aeVar.aAG.entrySet()) {
            af c = c((Class) entry.getKey());
            ((af) entry.getValue()).a(c);
            this.aAG.put(entry.getKey(), c);
        }
    }

    ae(ag agVar, v vVar) {
        w.Z(agVar);
        w.Z(vVar);
        this.aAy = agVar;
        this.ahZ = vVar;
        this.aAD = 1800000;
        this.aAE = 3024000000L;
        this.aAG = new HashMap();
        this.aAH = new ArrayList();
    }

    private static <T extends af> T c(Class<T> cls) {
        try {
            return (af) cls.newInstance();
        } catch (Throwable e) {
            throw new IllegalArgumentException("dataType doesn't have default constructor", e);
        } catch (Throwable e2) {
            throw new IllegalArgumentException("dataType default constructor is not accessible", e2);
        }
    }

    public final <T extends af> T a(Class<T> cls) {
        return (af) this.aAG.get(cls);
    }

    public final <T extends af> T b(Class<T> cls) {
        af afVar = (af) this.aAG.get(cls);
        if (afVar != null) {
            return afVar;
        }
        T c = c(cls);
        this.aAG.put(cls, c);
        return c;
    }

    public final void b(af afVar) {
        w.Z(afVar);
        Class cls = afVar.getClass();
        if (cls.getSuperclass() != af.class) {
            throw new IllegalArgumentException();
        }
        afVar.a(b(cls));
    }

    public final ae lb() {
        return new ae(this);
    }
}
