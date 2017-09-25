package android.support.v7.widget;

import android.support.v4.view.ai;
import android.support.v4.view.am;
import android.support.v4.view.z;
import android.support.v7.widget.RecyclerView.e;
import android.support.v7.widget.RecyclerView.t;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class v extends aj {
    private ArrayList<t> VY = new ArrayList();
    private ArrayList<t> VZ = new ArrayList();
    private ArrayList<b> Wa = new ArrayList();
    private ArrayList<a> Wb = new ArrayList();
    public ArrayList<ArrayList<t>> Wc = new ArrayList();
    public ArrayList<ArrayList<b>> Wd = new ArrayList();
    public ArrayList<ArrayList<a>> We = new ArrayList();
    public ArrayList<t> Wf = new ArrayList();
    public ArrayList<t> Wg = new ArrayList();
    public ArrayList<t> Wh = new ArrayList();
    public ArrayList<t> Wi = new ArrayList();

    private static class a {
        public int WA;
        public t Wv;
        public t Ww;
        public int Wx;
        public int Wy;
        public int Wz;

        private a(t tVar, t tVar2) {
            this.Wv = tVar;
            this.Ww = tVar2;
        }

        public a(t tVar, t tVar2, int i, int i2, int i3, int i4) {
            this(tVar, tVar2);
            this.Wx = i;
            this.Wy = i2;
            this.Wz = i3;
            this.WA = i4;
        }

        public final String toString() {
            return "ChangeInfo{oldHolder=" + this.Wv + ", newHolder=" + this.Ww + ", fromX=" + this.Wx + ", fromY=" + this.Wy + ", toX=" + this.Wz + ", toY=" + this.WA + '}';
        }
    }

    private static class b {
        public int WA;
        public t WB;
        public int Wx;
        public int Wy;
        public int Wz;

        public b(t tVar, int i, int i2, int i3, int i4) {
            this.WB = tVar;
            this.Wx = i;
            this.Wy = i2;
            this.Wz = i3;
            this.WA = i4;
        }
    }

    private static class c implements am {
        public void p(View view) {
        }

        public void q(View view) {
        }

        public void as(View view) {
        }
    }

    class AnonymousClass5 extends c {
        final /* synthetic */ v Wk;
        final /* synthetic */ t Wn;
        final /* synthetic */ ai Wo;

        AnonymousClass5(v vVar, t tVar, ai aiVar) {
            this.Wk = vVar;
            this.Wn = tVar;
            this.Wo = aiVar;
        }

        public final void p(View view) {
        }

        public final void as(View view) {
            z.d(view, 1.0f);
        }

        public final void q(View view) {
            this.Wo.a(null);
            this.Wk.k(this.Wn);
            this.Wk.Wf.remove(this.Wn);
            this.Wk.eK();
        }
    }

    class AnonymousClass6 extends c {
        final /* synthetic */ v Wk;
        final /* synthetic */ t Wn;
        final /* synthetic */ ai Wo;
        final /* synthetic */ int Wp;
        final /* synthetic */ int Wq;

        AnonymousClass6(v vVar, t tVar, int i, int i2, ai aiVar) {
            this.Wk = vVar;
            this.Wn = tVar;
            this.Wp = i;
            this.Wq = i2;
            this.Wo = aiVar;
        }

        public final void p(View view) {
            this.Wk.s(this.Wn);
        }

        public final void as(View view) {
            if (this.Wp != 0) {
                z.b(view, 0.0f);
            }
            if (this.Wq != 0) {
                z.c(view, 0.0f);
            }
        }

        public final void q(View view) {
            this.Wo.a(null);
            this.Wk.q(this.Wn);
            this.Wk.Wg.remove(this.Wn);
            this.Wk.eK();
        }
    }

    class AnonymousClass7 extends c {
        final /* synthetic */ v Wk;
        final /* synthetic */ a Wr;
        final /* synthetic */ ai Ws;

        AnonymousClass7(v vVar, a aVar, ai aiVar) {
            this.Wk = vVar;
            this.Wr = aVar;
            this.Ws = aiVar;
        }

        public final void p(View view) {
        }

        public final void q(View view) {
            this.Ws.a(null);
            z.d(view, 1.0f);
            z.b(view, 0.0f);
            z.c(view, 0.0f);
            this.Wk.k(this.Wr.Wv);
            this.Wk.Wi.remove(this.Wr.Wv);
            this.Wk.eK();
        }
    }

    class AnonymousClass8 extends c {
        final /* synthetic */ v Wk;
        final /* synthetic */ a Wr;
        final /* synthetic */ ai Wt;
        final /* synthetic */ View Wu;

        AnonymousClass8(v vVar, a aVar, ai aiVar, View view) {
            this.Wk = vVar;
            this.Wr = aVar;
            this.Wt = aiVar;
            this.Wu = view;
        }

        public final void p(View view) {
        }

        public final void q(View view) {
            this.Wt.a(null);
            z.d(this.Wu, 1.0f);
            z.b(this.Wu, 0.0f);
            z.c(this.Wu, 0.0f);
            this.Wk.k(this.Wr.Ww);
            this.Wk.Wi.remove(this.Wr.Ww);
            this.Wk.eK();
        }
    }

    public void eJ() {
        int i;
        int i2;
        int i3;
        int i4 = !this.VY.isEmpty() ? 1 : 0;
        if (this.Wa.isEmpty()) {
            i = 0;
        } else {
            i = 1;
        }
        if (this.Wb.isEmpty()) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        if (this.VZ.isEmpty()) {
            i3 = 0;
        } else {
            i3 = 1;
        }
        if (i4 != 0 || i != 0 || i3 != 0 || i2 != 0) {
            final ArrayList arrayList;
            Runnable anonymousClass1;
            Iterator it = this.VY.iterator();
            while (it.hasNext()) {
                final t tVar = (t) it.next();
                final ai V = z.V(tVar.abf);
                this.Wh.add(tVar);
                V.c(this.aag).p(0.0f).a(new c(this) {
                    final /* synthetic */ v Wk;

                    public final void p(View view) {
                        this.Wk.r(tVar);
                    }

                    public final void q(View view) {
                        V.a(null);
                        z.d(view, 1.0f);
                        this.Wk.k(tVar);
                        this.Wk.Wh.remove(tVar);
                        this.Wk.eK();
                    }
                }).start();
            }
            this.VY.clear();
            if (i != 0) {
                arrayList = new ArrayList();
                arrayList.addAll(this.Wa);
                this.Wd.add(arrayList);
                this.Wa.clear();
                anonymousClass1 = new Runnable(this) {
                    final /* synthetic */ v Wk;

                    public final void run() {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            b bVar = (b) it.next();
                            e eVar = this.Wk;
                            t tVar = bVar.WB;
                            int i = bVar.Wx;
                            int i2 = bVar.Wy;
                            int i3 = bVar.Wz;
                            int i4 = bVar.WA;
                            View view = tVar.abf;
                            i = i3 - i;
                            i2 = i4 - i2;
                            if (i != 0) {
                                z.V(view).q(0.0f);
                            }
                            if (i2 != 0) {
                                z.V(view).r(0.0f);
                            }
                            ai V = z.V(view);
                            eVar.Wg.add(tVar);
                            V.c(eVar.aah).a(new AnonymousClass6(eVar, tVar, i, i2, V)).start();
                        }
                        arrayList.clear();
                        this.Wk.Wd.remove(arrayList);
                    }
                };
                if (i4 != 0) {
                    z.a(((b) arrayList.get(0)).WB.abf, anonymousClass1, this.aag);
                } else {
                    anonymousClass1.run();
                }
            }
            if (i2 != 0) {
                arrayList = new ArrayList();
                arrayList.addAll(this.Wb);
                this.We.add(arrayList);
                this.Wb.clear();
                anonymousClass1 = new Runnable(this) {
                    final /* synthetic */ v Wk;

                    public final void run() {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            a aVar = (a) it.next();
                            e eVar = this.Wk;
                            t tVar = aVar.Wv;
                            View view = tVar == null ? null : tVar.abf;
                            t tVar2 = aVar.Ww;
                            View view2 = tVar2 != null ? tVar2.abf : null;
                            if (view != null) {
                                ai c = z.V(view).c(eVar.aai);
                                eVar.Wi.add(aVar.Wv);
                                c.q((float) (aVar.Wz - aVar.Wx));
                                c.r((float) (aVar.WA - aVar.Wy));
                                c.p(0.0f).a(new AnonymousClass7(eVar, aVar, c)).start();
                            }
                            if (view2 != null) {
                                c = z.V(view2);
                                eVar.Wi.add(aVar.Ww);
                                c.q(0.0f).r(0.0f).c(eVar.aai).p(1.0f).a(new AnonymousClass8(eVar, aVar, c, view2)).start();
                            }
                        }
                        arrayList.clear();
                        this.Wk.We.remove(arrayList);
                    }
                };
                if (i4 != 0) {
                    z.a(((a) arrayList.get(0)).Wv.abf, anonymousClass1, this.aag);
                } else {
                    anonymousClass1.run();
                }
            }
            if (i3 != 0) {
                final ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(this.VZ);
                this.Wc.add(arrayList2);
                this.VZ.clear();
                Runnable anonymousClass3 = new Runnable(this) {
                    final /* synthetic */ v Wk;

                    public final void run() {
                        Iterator it = arrayList2.iterator();
                        while (it.hasNext()) {
                            t tVar = (t) it.next();
                            e eVar = this.Wk;
                            ai V = z.V(tVar.abf);
                            eVar.Wf.add(tVar);
                            V.p(1.0f).c(eVar.aaf).a(new AnonymousClass5(eVar, tVar, V)).start();
                        }
                        arrayList2.clear();
                        this.Wk.Wc.remove(arrayList2);
                    }
                };
                if (i4 == 0 && i == 0 && i2 == 0) {
                    anonymousClass3.run();
                    return;
                }
                long j;
                long j2;
                long j3 = i4 != 0 ? this.aag : 0;
                if (i != 0) {
                    j = this.aah;
                } else {
                    j = 0;
                }
                if (i2 != 0) {
                    j2 = this.aai;
                } else {
                    j2 = 0;
                }
                z.a(((t) arrayList2.get(0)).abf, anonymousClass3, j3 + Math.max(j, j2));
            }
        }
    }

    public final boolean b(t tVar) {
        e(tVar);
        this.VY.add(tVar);
        return true;
    }

    public boolean c(t tVar) {
        e(tVar);
        z.d(tVar.abf, 0.0f);
        this.VZ.add(tVar);
        return true;
    }

    public boolean a(t tVar, int i, int i2, int i3, int i4) {
        View view = tVar.abf;
        int R = (int) (((float) i) + z.R(tVar.abf));
        int S = (int) (((float) i2) + z.S(tVar.abf));
        e(tVar);
        int i5 = i3 - R;
        int i6 = i4 - S;
        if (i5 == 0 && i6 == 0) {
            q(tVar);
            return false;
        }
        if (i5 != 0) {
            z.b(view, (float) (-i5));
        }
        if (i6 != 0) {
            z.c(view, (float) (-i6));
        }
        this.Wa.add(new b(tVar, R, S, i3, i4));
        return true;
    }

    public boolean a(t tVar, t tVar2, int i, int i2, int i3, int i4) {
        if (tVar == tVar2) {
            return a(tVar, i, i2, i3, i4);
        }
        float R = z.R(tVar.abf);
        float S = z.S(tVar.abf);
        float H = z.H(tVar.abf);
        e(tVar);
        int i5 = (int) (((float) (i3 - i)) - R);
        int i6 = (int) (((float) (i4 - i2)) - S);
        z.b(tVar.abf, R);
        z.c(tVar.abf, S);
        z.d(tVar.abf, H);
        if (tVar2 != null) {
            e(tVar2);
            z.b(tVar2.abf, (float) (-i5));
            z.c(tVar2.abf, (float) (-i6));
            z.d(tVar2.abf, 0.0f);
        }
        this.Wb.add(new a(tVar, tVar2, i, i2, i3, i4));
        return true;
    }

    private void a(List<a> list, t tVar) {
        for (int size = list.size() - 1; size >= 0; size--) {
            a aVar = (a) list.get(size);
            if (a(aVar, tVar) && aVar.Wv == null && aVar.Ww == null) {
                list.remove(aVar);
            }
        }
    }

    private void a(a aVar) {
        if (aVar.Wv != null) {
            a(aVar, aVar.Wv);
        }
        if (aVar.Ww != null) {
            a(aVar, aVar.Ww);
        }
    }

    private boolean a(a aVar, t tVar) {
        if (aVar.Ww == tVar) {
            aVar.Ww = null;
        } else if (aVar.Wv != tVar) {
            return false;
        } else {
            aVar.Wv = null;
        }
        z.d(tVar.abf, 1.0f);
        z.b(tVar.abf, 0.0f);
        z.c(tVar.abf, 0.0f);
        k(tVar);
        return true;
    }

    public void d(t tVar) {
        int size;
        View view = tVar.abf;
        z.V(view).cancel();
        for (size = this.Wa.size() - 1; size >= 0; size--) {
            if (((b) this.Wa.get(size)).WB == tVar) {
                z.c(view, 0.0f);
                z.b(view, 0.0f);
                q(tVar);
                this.Wa.remove(size);
            }
        }
        a(this.Wb, tVar);
        if (this.VY.remove(tVar)) {
            z.d(view, 1.0f);
            k(tVar);
        }
        if (this.VZ.remove(tVar)) {
            z.d(view, 1.0f);
            k(tVar);
        }
        for (size = this.We.size() - 1; size >= 0; size--) {
            List list = (ArrayList) this.We.get(size);
            a(list, tVar);
            if (list.isEmpty()) {
                this.We.remove(size);
            }
        }
        for (int size2 = this.Wd.size() - 1; size2 >= 0; size2--) {
            ArrayList arrayList = (ArrayList) this.Wd.get(size2);
            int size3 = arrayList.size() - 1;
            while (size3 >= 0) {
                if (((b) arrayList.get(size3)).WB == tVar) {
                    z.c(view, 0.0f);
                    z.b(view, 0.0f);
                    q(tVar);
                    arrayList.remove(size3);
                    if (arrayList.isEmpty()) {
                        this.Wd.remove(size2);
                    }
                } else {
                    size3--;
                }
            }
        }
        for (size = this.Wc.size() - 1; size >= 0; size--) {
            arrayList = (ArrayList) this.Wc.get(size);
            if (arrayList.remove(tVar)) {
                z.d(view, 1.0f);
                k(tVar);
                if (arrayList.isEmpty()) {
                    this.Wc.remove(size);
                }
            }
        }
        this.Wh.remove(tVar);
        this.Wf.remove(tVar);
        this.Wi.remove(tVar);
        this.Wg.remove(tVar);
        eK();
    }

    private void e(t tVar) {
        android.support.v4.a.a.v(tVar.abf);
        d(tVar);
    }

    public boolean isRunning() {
        return (this.VZ.isEmpty() && this.Wb.isEmpty() && this.Wa.isEmpty() && this.VY.isEmpty() && this.Wg.isEmpty() && this.Wh.isEmpty() && this.Wf.isEmpty() && this.Wi.isEmpty() && this.Wd.isEmpty() && this.Wc.isEmpty() && this.We.isEmpty()) ? false : true;
    }

    public void eK() {
        if (!isRunning()) {
            fS();
        }
    }

    public final void eL() {
        int size;
        for (size = this.Wa.size() - 1; size >= 0; size--) {
            b bVar = (b) this.Wa.get(size);
            View view = bVar.WB.abf;
            z.c(view, 0.0f);
            z.b(view, 0.0f);
            q(bVar.WB);
            this.Wa.remove(size);
        }
        for (size = this.VY.size() - 1; size >= 0; size--) {
            k((t) this.VY.get(size));
            this.VY.remove(size);
        }
        for (size = this.VZ.size() - 1; size >= 0; size--) {
            t tVar = (t) this.VZ.get(size);
            z.d(tVar.abf, 1.0f);
            k(tVar);
            this.VZ.remove(size);
        }
        for (size = this.Wb.size() - 1; size >= 0; size--) {
            a((a) this.Wb.get(size));
        }
        this.Wb.clear();
        if (isRunning()) {
            int size2;
            ArrayList arrayList;
            int size3;
            for (size2 = this.Wd.size() - 1; size2 >= 0; size2--) {
                arrayList = (ArrayList) this.Wd.get(size2);
                for (size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                    b bVar2 = (b) arrayList.get(size3);
                    View view2 = bVar2.WB.abf;
                    z.c(view2, 0.0f);
                    z.b(view2, 0.0f);
                    q(bVar2.WB);
                    arrayList.remove(size3);
                    if (arrayList.isEmpty()) {
                        this.Wd.remove(arrayList);
                    }
                }
            }
            for (size2 = this.Wc.size() - 1; size2 >= 0; size2--) {
                arrayList = (ArrayList) this.Wc.get(size2);
                for (size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                    t tVar2 = (t) arrayList.get(size3);
                    z.d(tVar2.abf, 1.0f);
                    k(tVar2);
                    arrayList.remove(size3);
                    if (arrayList.isEmpty()) {
                        this.Wc.remove(arrayList);
                    }
                }
            }
            for (size2 = this.We.size() - 1; size2 >= 0; size2--) {
                arrayList = (ArrayList) this.We.get(size2);
                for (size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                    a((a) arrayList.get(size3));
                    if (arrayList.isEmpty()) {
                        this.We.remove(arrayList);
                    }
                }
            }
            g(this.Wh);
            g(this.Wg);
            g(this.Wf);
            g(this.Wi);
            fS();
        }
    }

    private static void g(List<t> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            z.V(((t) list.get(size)).abf).cancel();
        }
    }

    public boolean a(t tVar, List<Object> list) {
        return !list.isEmpty() || super.a(tVar, list);
    }
}
