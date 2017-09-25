package com.tencent.mm.kernel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import junit.framework.Assert;

public final class f<T> {
    private final HashMap<T, a<T>> gYB = new HashMap();
    private final Set<T> gYC = new HashSet();

    private static class a<T> {
        public ArrayList<a> gYD;
        public ArrayList<a> gYE;
        T gYF;
        boolean gYG = false;

        public a(T t) {
            this.gYF = t;
        }

        public final String toString() {
            return "Ref-" + this.gYF.toString();
        }
    }

    public f(f<T> fVar) {
        this.gYB.putAll(fVar.gYB);
        reset();
    }

    private synchronized a<T> ap(T t) {
        a<T> aVar;
        aVar = (a) this.gYB.get(t);
        if (aVar == null) {
            aVar = new a(t);
            this.gYB.put(t, aVar);
        }
        return aVar;
    }

    public final synchronized boolean aq(T t) {
        boolean z;
        a aVar = (a) this.gYB.get(t);
        if (aVar != null && aVar.gYD != null && aVar.gYD.size() > 0) {
            z = true;
        } else if (this.gYC.contains(t)) {
            z = true;
        } else {
            z = false;
        }
        return z;
    }

    public final synchronized void n(T t, T t2) {
        Assert.assertNotNull(t);
        Assert.assertNotNull(t2);
        a ap = ap(t);
        a ap2 = ap(t2);
        Object[] objArr = new Object[]{ap, ap2};
        if (ap != ap2) {
            if (ap.gYD == null) {
                ap.gYD = new ArrayList(2);
            }
            ap.gYD.add(ap2);
            if (ap2.gYE == null) {
                ap2.gYE = new ArrayList(2);
            }
            ap2.gYE.add(ap);
        } else {
            this.gYC.add(t);
        }
    }

    public final ArrayList<T> vC() {
        ArrayList<T> arrayList = new ArrayList();
        for (Entry entry : this.gYB.entrySet()) {
            if (!((a) entry.getValue()).gYG) {
                arrayList.add(entry.getKey());
            }
        }
        return arrayList;
    }

    private void reset() {
        for (Entry value : this.gYB.entrySet()) {
            ((a) value.getValue()).gYG = false;
        }
    }

    public final ArrayList<T> vD() {
        ArrayList<T> arrayList = new ArrayList();
        HashMap hashMap = new HashMap(this.gYB);
        ArrayList arrayList2 = new ArrayList();
        for (Entry entry : this.gYB.entrySet()) {
            if (((a) entry.getValue()).gYD == null) {
                ((a) entry.getValue()).gYG = true;
                arrayList2.add(entry.getValue());
                arrayList.add(entry.getKey());
                new Object[1][0] = entry.getKey();
            }
        }
        new Object[1][0] = arrayList2;
        new Object[1][0] = this.gYB;
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            Object[] objArr = new Object[]{r0.gYE, ((a) it.next()).gYD};
            a(((a) it.next()).gYE, arrayList);
        }
        return arrayList;
    }

    private void a(ArrayList<a> arrayList, ArrayList<T> arrayList2) {
        new Object[1][0] = arrayList;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                Object[] objArr = new Object[]{aVar, Boolean.valueOf(aVar.gYG), aVar.gYD};
                if (!aVar.gYG) {
                    int i;
                    Iterator it2 = aVar.gYD.iterator();
                    while (it2.hasNext()) {
                        Object[] objArr2 = new Object[]{r1, Boolean.valueOf(((a) it2.next()).gYG)};
                        if (!((a) it2.next()).gYG) {
                            i = 0;
                            break;
                        }
                    }
                    boolean z = true;
                    if (i != 0) {
                        aVar.gYG = true;
                        arrayList2.add(aVar.gYF);
                        new Object[1][0] = aVar.gYF;
                        if (aVar.gYE != null) {
                            a(aVar.gYE, arrayList2);
                        }
                    }
                }
            }
        }
    }
}
