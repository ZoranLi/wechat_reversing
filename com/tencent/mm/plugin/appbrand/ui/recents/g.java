package com.tencent.mm.plugin.appbrand.ui.recents;

import android.os.Bundle;
import android.support.v4.view.ai;
import android.support.v4.view.an;
import android.support.v4.view.z;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.q;
import android.support.v7.widget.RecyclerView.t;
import android.support.v7.widget.v;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

final class g extends v {
    boolean jng = false;
    private final android.support.v7.widget.RecyclerView.e.a jnh = new android.support.v7.widget.RecyclerView.e.a(this) {
        final /* synthetic */ g jnz;

        {
            this.jnz = r1;
        }

        public final void fT() {
            for (android.support.v7.widget.RecyclerView.e.a fT : this.jnz.jni) {
                fT.fT();
            }
            this.jnz.jny = false;
        }
    };
    public final Set<android.support.v7.widget.RecyclerView.e.a> jni = new HashSet();
    private final Interpolator jnj = new AccelerateDecelerateInterpolator();
    private final ArrayList<b> jnk = new ArrayList();
    public final ArrayList<t> jnl = new ArrayList();
    private final ArrayList<d> jnm = new ArrayList();
    public final ArrayList<t> jnn = new ArrayList();
    private final ArrayList<d> jno = new ArrayList();
    public final ArrayList<d> jnp = new ArrayList();
    private final ArrayList<d> jnq = new ArrayList();
    public final ArrayList<d> jnr = new ArrayList();
    private final ArrayList<f> jns = new ArrayList();
    public final ArrayList<d> jnt = new ArrayList();
    private final ArrayList<t> jnu = new ArrayList();
    private final ArrayList<d> jnv = new ArrayList();
    public final ArrayList<d> jnw = new ArrayList();
    public final ArrayList<d> jnx = new ArrayList();
    public boolean jny = false;

    class AnonymousClass8 extends an {
        final /* synthetic */ ai Wo;
        final /* synthetic */ d jnA;
        final /* synthetic */ g jnz;

        AnonymousClass8(g gVar, d dVar, ai aiVar) {
            this.jnz = gVar;
            this.jnA = dVar;
            this.Wo = aiVar;
        }

        public final void p(View view) {
        }

        public final void as(View view) {
            z.d(view, 1.0f);
        }

        public final void q(View view) {
            this.Wo.a(null);
            this.jnz.k(this.jnA);
            this.jnz.jnx.remove(this.jnA);
            this.jnz.eK();
        }
    }

    private static class a extends android.support.v7.widget.RecyclerView.e.c {
        public final android.support.v7.widget.RecyclerView.e.c b(t tVar, int i) {
            super.b(tVar, i);
            this.aaj = i;
            return this;
        }

        final boolean XE() {
            return (this.aaj & 2048) > 0;
        }
    }

    private static class f {
        int Wx;
        int Wy;
        d jnB;

        public f(d dVar, int i, int i2) {
            this.jnB = dVar;
            this.Wx = i;
            this.Wy = i2;
        }
    }

    private static class g {
        int Wx;
        int Wy;
        d jnB;

        g(d dVar, int i, int i2) {
            this.jnB = dVar;
            this.Wx = i;
            this.Wy = i2;
        }
    }

    private static final class b extends g {
        b(d dVar, int i, int i2) {
            super(dVar, i, i2);
        }
    }

    private static final class c extends a {
    }

    private static final class d extends g {
        d(d dVar, int i, int i2) {
            super(dVar, i, i2);
        }
    }

    private static final class e extends a {
    }

    g() {
    }

    final void b(android.support.v7.widget.RecyclerView.e.a aVar) {
        if (aVar != null) {
            this.jni.add(aVar);
        }
    }

    final void c(android.support.v7.widget.RecyclerView.e.a aVar) {
        if (aVar != null) {
            this.jni.remove(aVar);
        }
    }

    private void e(t tVar) {
        android.support.v4.a.a.v(tVar.abf);
        d(tVar);
    }

    public final void eK() {
        if (!isRunning()) {
            fS();
        }
    }

    public final boolean isRunning() {
        return (this.jnk.isEmpty() && this.jnl.isEmpty() && this.jnm.isEmpty() && this.jnn.isEmpty() && this.jno.isEmpty() && this.jnp.isEmpty() && this.jnq.isEmpty() && this.jnr.isEmpty() && this.jns.isEmpty() && this.jnt.isEmpty() && this.jnv.isEmpty() && this.jnw.isEmpty() && this.jnx.isEmpty() && !super.isRunning()) ? false : true;
    }

    public final void eJ() {
        Iterator it;
        a(this.jnh);
        if (!this.jnk.isEmpty()) {
            it = this.jnk.iterator();
            while (it.hasNext()) {
                b bVar = (b) it.next();
                this.jnl.add(bVar.jnB);
                final t tVar = bVar.jnB;
                View view = bVar.jnB.abf;
                bVar.jnB.jmB.setVisibility(0);
                z.c(view, 0.0f);
                final ai V = z.V(view);
                V.c(Math.max(this.aah, Math.min(Math.round((((double) bVar.Wy) / ((double) bVar.jnB.abf.getHeight())) * ((double) this.aah)) + this.aah, 400)));
                V.b(this.jnj);
                V.a(new an(this) {
                    final /* synthetic */ g jnz;

                    public final void p(View view) {
                        ((RecentsRecyclerView) view.getParent()).bH(view);
                        this.jnz.r(tVar);
                    }

                    public final void q(View view) {
                        ((RecentsRecyclerView) view.getParent()).bI(view);
                        V.a(null);
                        z.c(view, 0.0f);
                        this.jnz.k(tVar);
                        this.jnz.jnl.remove(tVar);
                        this.jnz.eK();
                    }
                });
                V.r((float) ((-bVar.Wy) - view.getHeight())).start();
            }
            this.jnk.clear();
        }
        if (!this.jnm.isEmpty()) {
            Iterator it2 = this.jnm.iterator();
            while (it2.hasNext()) {
                d dVar = (d) it2.next();
                this.jnn.add(dVar.jnB);
                final t tVar2 = dVar.jnB;
                View view2 = dVar.jnB.abf;
                RecentsRecyclerView recentsRecyclerView = (RecentsRecyclerView) view2.getParent();
                dVar.jnB.jmB.setVisibility(8);
                z.c(view2, 0.0f);
                V = z.V(view2);
                V.c(this.aah);
                V.a(new an(this) {
                    final /* synthetic */ g jnz;

                    public final void p(View view) {
                        ((RecentsRecyclerView) view.getParent()).bH(view);
                        this.jnz.r(tVar2);
                    }

                    public final void q(View view) {
                        ((RecentsRecyclerView) view.getParent()).bI(view);
                        V.a(null);
                        z.c(view, 0.0f);
                        this.jnz.k(tVar2);
                        this.jnz.jnn.remove(tVar2);
                        this.jnz.eK();
                    }
                });
                V.r((float) (recentsRecyclerView.getHeight() - dVar.Wy)).start();
            }
            this.jnm.clear();
        }
        if (!this.jno.isEmpty()) {
            it = this.jno.iterator();
            while (it.hasNext()) {
                final d dVar2 = (d) it.next();
                this.jnp.add(dVar2);
                z.e(dVar2.jmB, 0.1f);
                z.f(dVar2.jmB, 0.1f);
                z.d(dVar2.jmB, 0.0f);
                dVar2.jmB.setVisibility(0);
                final ai V2 = z.V(dVar2.jmB);
                V2.c(this.aai);
                V2.a(new an(this) {
                    final /* synthetic */ g jnz;

                    public final void p(View view) {
                    }

                    public final void q(View view) {
                        V2.a(null);
                        this.jnz.k(dVar2);
                        this.jnz.jnp.remove(dVar2);
                        this.jnz.eK();
                    }
                });
                V2.p(1.0f).s(1.0f).t(1.0f).start();
            }
            this.jno.clear();
        }
        if (!this.jnq.isEmpty()) {
            it = this.jnq.iterator();
            while (it.hasNext()) {
                dVar2 = (d) it.next();
                this.jnr.add(dVar2);
                z.e(dVar2.jmB, 1.0f);
                z.f(dVar2.jmB, 1.0f);
                z.d(dVar2.jmB, 1.0f);
                dVar2.jmB.setVisibility(0);
                V2 = z.V(dVar2.jmB);
                V2.c(this.aai);
                V2.a(new an(this) {
                    final /* synthetic */ g jnz;

                    public final void p(View view) {
                    }

                    public final void q(View view) {
                        z.e(dVar2.jmB, 1.0f);
                        z.f(dVar2.jmB, 1.0f);
                        z.d(dVar2.jmB, 1.0f);
                        dVar2.jmB.setVisibility(8);
                        this.jnz.k(dVar2);
                        this.jnz.jnr.remove(dVar2);
                        this.jnz.eK();
                    }
                });
                V2.p(0.0f).s(0.1f).t(0.1f).start();
            }
            this.jnq.clear();
        }
        if (!this.jns.isEmpty()) {
            it = this.jns.iterator();
            while (it.hasNext()) {
                f fVar = (f) it.next();
                this.jnt.add(fVar.jnB);
                View view3 = fVar.jnB.abf;
                z.c(view3, 0.0f);
                z.d(view3, 1.0f);
                dVar2 = fVar.jnB;
                ai V3 = z.V(view3);
                V3.c(this.aah);
                V3.a(new an(this) {
                    final /* synthetic */ g jnz;

                    public final void p(View view) {
                        this.jnz.r(dVar2);
                    }

                    public final void q(View view) {
                        z.c(view, 0.0f);
                        z.d(view, 1.0f);
                        this.jnz.k(dVar2);
                        this.jnz.jnt.remove(dVar2);
                        this.jnz.eK();
                    }
                });
                V3.p(0.0f).r((float) (-view3.getHeight())).start();
            }
            this.jns.clear();
        }
        super.eJ();
        if (!this.jnv.isEmpty()) {
            this.jnw.addAll(this.jnv);
            Runnable anonymousClass7 = new Runnable(this) {
                final /* synthetic */ g jnz;

                {
                    this.jnz = r1;
                }

                public final void run() {
                    Iterator it = this.jnz.jnw.iterator();
                    while (it.hasNext()) {
                        d dVar = (d) it.next();
                        android.support.v7.widget.RecyclerView.e eVar = this.jnz;
                        ai V = z.V(dVar.abf);
                        eVar.jnx.add(dVar);
                        V.r(0.0f).c(eVar.aah).a(new AnonymousClass8(eVar, dVar, V)).start();
                    }
                    this.jnz.jnw.clear();
                }
            };
            this.jnv.clear();
            if (this.jny) {
                z.a(((d) this.jnw.get(0)).abf, anonymousClass7, this.aag);
            } else {
                anonymousClass7.run();
            }
        }
    }

    public final void r(t tVar) {
        super.r(tVar);
        if (!this.jnt.contains(tVar)) {
            this.jny = true;
        }
    }

    public final boolean a(t tVar, int i, int i2, int i3, int i4) {
        if (tVar instanceof d) {
            return super.a(tVar, i, i2, i3, i4);
        }
        q(tVar);
        return false;
    }

    public final boolean c(t tVar) {
        e(tVar);
        k(tVar);
        return false;
    }

    public final void d(t tVar) {
        if ((tVar instanceof d) && this.jnv.remove(tVar)) {
            z.c(tVar.abf, 0.0f);
            k(tVar);
        }
        super.d(tVar);
    }

    public final boolean e(t tVar, android.support.v7.widget.RecyclerView.e.c cVar, android.support.v7.widget.RecyclerView.e.c cVar2) {
        if (cVar == null || (cVar.left == cVar2.left && cVar.top == cVar2.top)) {
            if (this.jng && (tVar.abf.getParent() instanceof RecyclerView) && (tVar instanceof d)) {
                RecyclerView recyclerView = (RecyclerView) tVar.abf.getParent();
                if (recyclerView.getHeight() > 0) {
                    d dVar;
                    if (cVar2.bottom >= recyclerView.getHeight()) {
                        dVar = (d) tVar;
                        z.c(dVar.abf, (float) dVar.abf.getHeight());
                        this.jnv.add(dVar);
                        return true;
                    } else if (cVar2.top <= 0) {
                        dVar = (d) tVar;
                        z.c(dVar.abf, (float) (-dVar.abf.getHeight()));
                        this.jnv.add(dVar);
                        return true;
                    }
                }
            }
            return c(tVar);
        }
        return super.a(tVar, cVar.left, cVar.top, cVar2.left, cVar2.top);
    }

    public final boolean d(t tVar, android.support.v7.widget.RecyclerView.e.c cVar, android.support.v7.widget.RecyclerView.e.c cVar2) {
        if (cVar instanceof c) {
            e(tVar);
            this.jnk.add(new b((d) tVar, cVar.left, cVar.top));
            return true;
        } else if (cVar instanceof e) {
            e(tVar);
            this.jnm.add(new d((d) tVar, cVar.left, cVar.top));
            return true;
        } else {
            if ((cVar.aaj & 2048) > 0 && (tVar instanceof d) && cVar2 == null) {
                boolean z;
                try {
                    z = ((d) tVar).Xx().iCc;
                } catch (Exception e) {
                    z = false;
                }
                if (!z) {
                    e(tVar);
                    this.jns.add(new f((d) tVar, cVar.left, cVar.top));
                    return true;
                }
            }
            return super.d(tVar, cVar, cVar2);
        }
    }

    public final boolean a(t tVar, t tVar2, int i, int i2, int i3, int i4) {
        k(tVar);
        k(tVar2);
        return false;
    }

    public final void l(t tVar) {
        super.l(tVar);
        ViewParent parent = tVar.abf.getParent();
        if (parent instanceof RecentsRecyclerView) {
            ((RecentsRecyclerView) parent).bI(tVar.abf);
        }
    }

    public final void s(t tVar) {
        super.s(tVar);
        if (this.jnu.contains(tVar)) {
            ((RecentsRecyclerView) tVar.abf.getParent()).bH(tVar.abf);
        }
    }

    public final void t(t tVar) {
        super.t(tVar);
        if (this.jnu.contains(tVar)) {
            this.jnu.remove(tVar);
            ((RecentsRecyclerView) tVar.abf.getParent()).bI(tVar.abf);
        }
    }

    public final android.support.v7.widget.RecyclerView.e.c a(q qVar, t tVar, int i, List<Object> list) {
        if ((i & 2) > 0) {
            for (Object next : list) {
                if (next instanceof Bundle) {
                    Boolean bool = (Boolean) ((Bundle) next).get("star");
                    if (bool != null && bool.booleanValue()) {
                        return new c().b(tVar, i);
                    }
                    if (!(bool == null || bool.booleanValue())) {
                        return new e().b(tVar, i);
                    }
                }
            }
        }
        android.support.v7.widget.RecyclerView.e.c a = super.a(qVar, tVar, i, list);
        a.aaj = i;
        return a;
    }

    public final boolean a(t tVar, t tVar2, android.support.v7.widget.RecyclerView.e.c cVar, android.support.v7.widget.RecyclerView.e.c cVar2) {
        if (cVar instanceof c) {
            if (((c) cVar).XE()) {
                ((d) tVar2).jmB.setVisibility(0);
                ((d) tVar2).jmB.invalidate();
                ((RecentsRecyclerView) tVar2.abf.getParent()).bH(tVar2.abf);
                this.jnu.add(tVar2);
                return super.a(tVar2, cVar.left, cVar.top, cVar2.left, cVar2.top);
            }
            e(tVar2);
            this.jno.add((d) tVar2);
            return true;
        } else if (!(cVar instanceof e)) {
            return super.a(tVar, tVar2, cVar, cVar2);
        } else {
            if (((e) cVar).XE()) {
                ((d) tVar2).jmB.setVisibility(8);
                return super.a(tVar2, cVar.left, cVar.top, cVar2.left, cVar2.top);
            }
            e(tVar2);
            this.jnq.add((d) tVar2);
            return true;
        }
    }

    public final boolean a(t tVar, List<Object> list) {
        super.a(tVar, list);
        return tVar instanceof d;
    }
}
