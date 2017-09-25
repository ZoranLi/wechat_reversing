package android.support.v7.widget;

import android.support.v4.e.e;
import android.support.v7.widget.RecyclerView.e.c;
import android.support.v7.widget.RecyclerView.t;

final class as {
    final android.support.v4.e.a<t, a> afE = new android.support.v4.e.a();
    final e<t> afF = new e();

    static class a {
        static android.support.v4.e.h.a<a> afI = new android.support.v4.e.h.b(20);
        c afG;
        c afH;
        int flags;

        private a() {
        }

        static a he() {
            a aVar = (a) afI.bF();
            return aVar == null ? new a() : aVar;
        }

        static void a(a aVar) {
            aVar.flags = 0;
            aVar.afG = null;
            aVar.afH = null;
            afI.i(aVar);
        }

        static void hf() {
            do {
            } while (afI.bF() != null);
        }
    }

    interface b {
        void a(t tVar, c cVar, c cVar2);

        void b(t tVar, c cVar, c cVar2);

        void c(t tVar, c cVar, c cVar2);

        void i(t tVar);
    }

    as() {
    }

    final void clear() {
        this.afE.clear();
        e eVar = this.afF;
        int i = eVar.hP;
        Object[] objArr = eVar.vW;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        eVar.hP = 0;
        eVar.vU = false;
    }

    final void b(t tVar, c cVar) {
        a aVar = (a) this.afE.get(tVar);
        if (aVar == null) {
            aVar = a.he();
            this.afE.put(tVar, aVar);
        }
        aVar.afG = cVar;
        aVar.flags |= 4;
    }

    final boolean u(t tVar) {
        a aVar = (a) this.afE.get(tVar);
        return (aVar == null || (aVar.flags & 1) == 0) ? false : true;
    }

    final c c(t tVar, int i) {
        c cVar = null;
        int indexOfKey = this.afE.indexOfKey(tVar);
        if (indexOfKey >= 0) {
            a aVar = (a) this.afE.valueAt(indexOfKey);
            if (!(aVar == null || (aVar.flags & i) == 0)) {
                aVar.flags &= i ^ -1;
                if (i == 4) {
                    cVar = aVar.afG;
                } else if (i == 8) {
                    cVar = aVar.afH;
                } else {
                    throw new IllegalArgumentException("Must provide flag PRE or POST");
                }
                if ((aVar.flags & 12) == 0) {
                    this.afE.removeAt(indexOfKey);
                    a.a(aVar);
                }
            }
        }
        return cVar;
    }

    final void a(long j, t tVar) {
        this.afF.put(j, tVar);
    }

    final void c(t tVar, c cVar) {
        a aVar = (a) this.afE.get(tVar);
        if (aVar == null) {
            aVar = a.he();
            this.afE.put(tVar, aVar);
        }
        aVar.afH = cVar;
        aVar.flags |= 8;
    }

    final void v(t tVar) {
        a aVar = (a) this.afE.get(tVar);
        if (aVar == null) {
            aVar = a.he();
            this.afE.put(tVar, aVar);
        }
        r0.flags |= 1;
    }

    final void w(t tVar) {
        a aVar = (a) this.afE.get(tVar);
        if (aVar != null) {
            aVar.flags &= -2;
        }
    }

    final void a(b bVar) {
        for (int size = this.afE.size() - 1; size >= 0; size--) {
            t tVar = (t) this.afE.keyAt(size);
            a aVar = (a) this.afE.removeAt(size);
            if ((aVar.flags & 3) == 3) {
                bVar.i(tVar);
            } else if ((aVar.flags & 1) != 0) {
                if (aVar.afG == null) {
                    bVar.i(tVar);
                } else {
                    bVar.a(tVar, aVar.afG, aVar.afH);
                }
            } else if ((aVar.flags & 14) == 14) {
                bVar.b(tVar, aVar.afG, aVar.afH);
            } else if ((aVar.flags & 12) == 12) {
                bVar.c(tVar, aVar.afG, aVar.afH);
            } else if ((aVar.flags & 4) != 0) {
                bVar.a(tVar, aVar.afG, null);
            } else if ((aVar.flags & 8) != 0) {
                bVar.b(tVar, aVar.afG, aVar.afH);
            } else {
                int i = aVar.flags;
            }
            a.a(aVar);
        }
    }

    final void x(t tVar) {
        a aVar;
        for (int size = this.afF.size() - 1; size >= 0; size--) {
            if (tVar == this.afF.valueAt(size)) {
                e eVar = this.afF;
                if (eVar.vW[size] != e.vT) {
                    eVar.vW[size] = e.vT;
                    eVar.vU = true;
                }
                aVar = (a) this.afE.remove(tVar);
                if (aVar != null) {
                    a.a(aVar);
                }
            }
        }
        aVar = (a) this.afE.remove(tVar);
        if (aVar != null) {
            a.a(aVar);
        }
    }
}
