package com.google.android.gms.tagmanager;

import com.google.android.gms.c.at;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class ac {
    private static final v<com.google.android.gms.c.b.a> aEu = new v(ai.mr(), true);
    private final c aDY;
    private final al<String, b> aEA;
    private final Set<com.google.android.gms.c.at.b> aEB;
    private final Map<String, c> aEC;
    private volatile String aED;
    private int aEE;
    private final f aEv;
    private final Map<String, g> aEw;
    private final Map<String, g> aEx;
    private final Map<String, g> aEy;
    private final al<com.google.android.gms.c.at.a, v<com.google.android.gms.c.b.a>> aEz;

    interface a {
        void a(com.google.android.gms.c.at.b bVar, Set<com.google.android.gms.c.at.a> set, Set<com.google.android.gms.c.at.a> set2, aa aaVar);
    }

    private static class b {
        com.google.android.gms.c.b.a aBM;
        v<com.google.android.gms.c.b.a> aEK;

        public b(v<com.google.android.gms.c.b.a> vVar, com.google.android.gms.c.b.a aVar) {
            this.aEK = vVar;
            this.aBM = aVar;
        }
    }

    private static class c {
        final Set<com.google.android.gms.c.at.b> aEB = new HashSet();
        final Map<com.google.android.gms.c.at.b, List<com.google.android.gms.c.at.a>> aEL = new HashMap();
        final Map<com.google.android.gms.c.at.b, List<com.google.android.gms.c.at.a>> aEM = new HashMap();
        final Map<com.google.android.gms.c.at.b, List<String>> aEN = new HashMap();
        final Map<com.google.android.gms.c.at.b, List<String>> aEO = new HashMap();
        com.google.android.gms.c.at.a aEP;
    }

    private v<Boolean> a(com.google.android.gms.c.at.a aVar, Set<String> set, x xVar) {
        v a = a(this.aEx, aVar, (Set) set, xVar);
        Boolean c = ai.c((com.google.android.gms.c.b.a) a.aEk);
        ai.ag(c);
        return new v(c, a.aEl);
    }

    private v<Boolean> a(com.google.android.gms.c.at.b bVar, Set<String> set, aa aaVar) {
        boolean z = true;
        for (com.google.android.gms.c.at.a a : bVar.aBO) {
            v a2 = a(a, (Set) set, aaVar.lZ());
            if (((Boolean) a2.aEk).booleanValue()) {
                ai.ag(Boolean.valueOf(false));
                return new v(Boolean.valueOf(false), a2.aEl);
            }
            boolean z2 = z && a2.aEl;
            z = z2;
        }
        for (com.google.android.gms.c.at.a a3 : bVar.aBN) {
            a2 = a(a3, (Set) set, aaVar.ma());
            if (((Boolean) a2.aEk).booleanValue()) {
                z = z && a2.aEl;
            } else {
                ai.ag(Boolean.valueOf(false));
                return new v(Boolean.valueOf(false), a2.aEl);
            }
        }
        ai.ag(Boolean.valueOf(true));
        return new v(Boolean.valueOf(true), z);
    }

    private v<com.google.android.gms.c.b.a> a(com.google.android.gms.c.b.a aVar, Set<String> set, aj ajVar) {
        if (!aVar.ayK) {
            return new v(aVar, true);
        }
        com.google.android.gms.c.b.a a;
        int i;
        v a2;
        switch (aVar.type) {
            case 2:
                a = at.a(aVar);
                a.ayB = new com.google.android.gms.c.b.a[aVar.ayB.length];
                for (i = 0; i < aVar.ayB.length; i++) {
                    a2 = a(aVar.ayB[i], (Set) set, ajVar.mg());
                    if (a2 == aEu) {
                        return aEu;
                    }
                    a.ayB[i] = (com.google.android.gms.c.b.a) a2.aEk;
                }
                return new v(a, false);
            case 3:
                a = at.a(aVar);
                if (aVar.ayC.length != aVar.ayD.length) {
                    new StringBuilder("Invalid serving value: ").append(aVar.toString());
                    m.lQ();
                    return aEu;
                }
                a.ayC = new com.google.android.gms.c.b.a[aVar.ayC.length];
                a.ayD = new com.google.android.gms.c.b.a[aVar.ayC.length];
                for (i = 0; i < aVar.ayC.length; i++) {
                    a2 = a(aVar.ayC[i], (Set) set, ajVar.mh());
                    v a3 = a(aVar.ayD[i], (Set) set, ajVar.mi());
                    if (a2 == aEu || a3 == aEu) {
                        return aEu;
                    }
                    a.ayC[i] = (com.google.android.gms.c.b.a) a2.aEk;
                    a.ayD[i] = (com.google.android.gms.c.b.a) a3.aEk;
                }
                return new v(a, false);
            case 4:
                if (set.contains(aVar.ayE)) {
                    new StringBuilder("Macro cycle detected.  Current macro reference: ").append(aVar.ayE).append(".  Previous macro references: ").append(set.toString()).append(".");
                    m.lQ();
                    return aEu;
                }
                set.add(aVar.ayE);
                v<com.google.android.gms.c.b.a> a4 = ak.a(a(aVar.ayE, (Set) set, ajVar.mk()), aVar.ayJ);
                set.remove(aVar.ayE);
                return a4;
            case 7:
                a = at.a(aVar);
                a.ayI = new com.google.android.gms.c.b.a[aVar.ayI.length];
                for (i = 0; i < aVar.ayI.length; i++) {
                    a2 = a(aVar.ayI[i], (Set) set, ajVar.mj());
                    if (a2 == aEu) {
                        return aEu;
                    }
                    a.ayI[i] = (com.google.android.gms.c.b.a) a2.aEk;
                }
                return new v(a, false);
            default:
                new StringBuilder("Unknown type: ").append(aVar.type);
                m.lQ();
                return aEu;
        }
    }

    private v<com.google.android.gms.c.b.a> a(String str, Set<String> set, o oVar) {
        this.aEE++;
        b bVar = (b) this.aEA.ms();
        if (bVar == null || this.aEv.lN()) {
            c cVar = (c) this.aEC.get(str);
            if (cVar == null) {
                new StringBuilder().append(mn()).append("Invalid macro: ").append(str);
                m.lQ();
                this.aEE--;
                return aEu;
            }
            com.google.android.gms.c.at.a aVar;
            v a = a(cVar.aEB, cVar.aEL, cVar.aEN, cVar.aEM, cVar.aEO, set, oVar.lW());
            if (((Set) a.aEk).isEmpty()) {
                aVar = cVar.aEP;
            } else {
                if (((Set) a.aEk).size() > 1) {
                    new StringBuilder().append(mn()).append("Multiple macros active for macroName ").append(str);
                    m.lS();
                }
                aVar = (com.google.android.gms.c.at.a) ((Set) a.aEk).iterator().next();
            }
            if (aVar == null) {
                this.aEE--;
                return aEu;
            }
            v a2 = a(this.aEy, aVar, (Set) set, oVar.lV());
            boolean z = a.aEl && a2.aEl;
            v<com.google.android.gms.c.b.a> vVar = a2 == aEu ? aEu : new v(a2.aEk, z);
            com.google.android.gms.c.b.a aVar2 = aVar.aBM;
            if (vVar.aEl) {
                b bVar2 = new b(vVar, aVar2);
            }
            a(aVar2, set);
            this.aEE--;
            return vVar;
        }
        a(bVar.aBM, set);
        this.aEE--;
        return bVar.aEK;
    }

    private v<com.google.android.gms.c.b.a> a(Map<String, g> map, com.google.android.gms.c.at.a aVar, Set<String> set, x xVar) {
        com.google.android.gms.c.b.a aVar2 = (com.google.android.gms.c.b.a) Collections.unmodifiableMap(aVar.aBL).get(com.google.android.gms.c.a.FUNCTION.toString());
        if (aVar2 == null) {
            m.lQ();
            return aEu;
        }
        String str = aVar2.ayF;
        g gVar = (g) map.get(str);
        if (gVar == null) {
            new StringBuilder().append(str).append(" has no backing implementation.");
            m.lQ();
            return aEu;
        }
        v<com.google.android.gms.c.b.a> vVar = (v) this.aEz.ms();
        if (vVar != null && !this.aEv.lN()) {
            return vVar;
        }
        Map hashMap = new HashMap();
        Object obj = 1;
        for (Entry entry : Collections.unmodifiableMap(aVar.aBL).entrySet()) {
            entry.getKey();
            z lX = xVar.lX();
            com.google.android.gms.c.b.a aVar3 = (com.google.android.gms.c.b.a) entry.getValue();
            entry.getValue();
            v a = a(aVar3, (Set) set, lX.lY());
            if (a == aEu) {
                return aEu;
            }
            Object obj2;
            if (a.aEl) {
                aVar.aBL.put((String) entry.getKey(), (com.google.android.gms.c.b.a) a.aEk);
                obj2 = obj;
            } else {
                obj2 = null;
            }
            hashMap.put(entry.getKey(), a.aEk);
            obj = obj2;
        }
        if (hashMap.keySet().containsAll(gVar.aEf)) {
            boolean z = obj != null && gVar.lO();
            return new v(gVar.lP(), z);
        }
        new StringBuilder("Incorrect keys for function ").append(str).append(" required ").append(gVar.aEf).append(" had ").append(hashMap.keySet());
        m.lQ();
        return aEu;
    }

    private v<Set<com.google.android.gms.c.at.a>> a(Set<com.google.android.gms.c.at.b> set, Map<com.google.android.gms.c.at.b, List<com.google.android.gms.c.at.a>> map, Map<com.google.android.gms.c.at.b, List<String>> map2, Map<com.google.android.gms.c.at.b, List<com.google.android.gms.c.at.a>> map3, Map<com.google.android.gms.c.at.b, List<String>> map4, Set<String> set2, ab abVar) {
        final Map<com.google.android.gms.c.at.b, List<com.google.android.gms.c.at.a>> map5 = map;
        final Map<com.google.android.gms.c.at.b, List<String>> map6 = map2;
        final Map<com.google.android.gms.c.at.b, List<com.google.android.gms.c.at.a>> map7 = map3;
        final Map<com.google.android.gms.c.at.b, List<String>> map8 = map4;
        return a((Set) set, (Set) set2, new a(this) {
            final /* synthetic */ ac aEJ;

            public final void a(com.google.android.gms.c.at.b bVar, Set<com.google.android.gms.c.at.a> set, Set<com.google.android.gms.c.at.a> set2, aa aaVar) {
                List list = (List) map5.get(bVar);
                map6.get(bVar);
                if (list != null) {
                    set.addAll(list);
                    aaVar.mb();
                }
                list = (List) map7.get(bVar);
                map8.get(bVar);
                if (list != null) {
                    set2.addAll(list);
                    aaVar.mc();
                }
            }
        }, abVar);
    }

    private v<Set<com.google.android.gms.c.at.a>> a(Set<com.google.android.gms.c.at.b> set, Set<String> set2, a aVar, ab abVar) {
        Set hashSet = new HashSet();
        Collection hashSet2 = new HashSet();
        boolean z = true;
        for (com.google.android.gms.c.at.b bVar : set) {
            aa mf = abVar.mf();
            v a = a(bVar, (Set) set2, mf);
            if (((Boolean) a.aEk).booleanValue()) {
                aVar.a(bVar, hashSet, hashSet2, mf);
            }
            boolean z2 = z && a.aEl;
            z = z2;
        }
        hashSet.removeAll(hashSet2);
        return new v(hashSet, z);
    }

    private void a(com.google.android.gms.c.b.a aVar, Set<String> set) {
        if (aVar != null) {
            v a = a(aVar, (Set) set, new u());
            if (a != aEu) {
                Object d = ai.d((com.google.android.gms.c.b.a) a.aEk);
                if (d instanceof Map) {
                    this.aDY.d((Map) d);
                } else if (d instanceof List) {
                    for (Object d2 : (List) d2) {
                        if (d2 instanceof Map) {
                            this.aDY.d((Map) d2);
                        } else {
                            m.lS();
                        }
                    }
                } else {
                    m.lS();
                }
            }
        }
    }

    private synchronized void ap(String str) {
        this.aED = str;
    }

    private String mn() {
        if (this.aEE <= 1) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Integer.toString(this.aEE));
        for (int i = 2; i < this.aEE; i++) {
            stringBuilder.append(' ');
        }
        stringBuilder.append(": ");
        return stringBuilder.toString();
    }

    public final synchronized void ao(String str) {
        ap(str);
        ao lL = this.aEv.lM().lL();
        for (com.google.android.gms.c.at.a a : (Set) a(this.aEB, new HashSet(), new a(this) {
            final /* synthetic */ ac aEJ;

            {
                this.aEJ = r1;
            }

            public final void a(com.google.android.gms.c.at.b bVar, Set<com.google.android.gms.c.at.a> set, Set<com.google.android.gms.c.at.a> set2, aa aaVar) {
                set.addAll(bVar.aBP);
                set2.addAll(bVar.aBQ);
                aaVar.md();
                aaVar.me();
            }
        }, lL.lW()).aEk) {
            a(this.aEw, a, new HashSet(), lL.mw());
        }
        ap(null);
    }
}
