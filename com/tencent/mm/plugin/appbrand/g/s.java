package com.tencent.mm.plugin.appbrand.g;

import android.annotation.SuppressLint;
import android.graphics.PointF;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsoluteLayout;
import android.widget.RelativeLayout;
import com.tencent.mm.plugin.appbrand.jsapi.k.c;
import com.tencent.mm.plugin.appbrand.m.m;
import com.tencent.mm.plugin.appbrand.widget.a.b;
import com.tencent.mm.plugin.appbrand.widget.a.f;
import com.tencent.mm.plugin.appbrand.widget.input.ab;
import com.tencent.mm.plugin.appbrand.widget.input.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bb;
import com.tencent.mm.u.q;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class s {
    r jde;
    u jea;
    List<a> jej;
    int jek = -1;
    int jel = -1;
    View jem;
    public ae mHandler;

    class AnonymousClass2 extends bb<Boolean> {
        final /* synthetic */ int afD;
        final /* synthetic */ int iRk;
        final /* synthetic */ s jeo;
        final /* synthetic */ int jep;
        final /* synthetic */ int[] jeq;
        final /* synthetic */ View zG;

        public AnonymousClass2(s sVar, Boolean bool, View view, int i, int i2, int[] iArr, int i3) {
            this.jeo = sVar;
            this.zG = view;
            this.iRk = i;
            this.jep = i2;
            this.jeq = iArr;
            this.afD = i3;
            super(1000, bool);
        }

        protected final /* synthetic */ Object run() {
            return Boolean.valueOf(this.jeo.a(this.zG, this.iRk, this.jep, this.jeq, this.afD));
        }
    }

    class AnonymousClass4 extends bb<Boolean> {
        final /* synthetic */ int afD;
        final /* synthetic */ int iRk;
        final /* synthetic */ s jeo;
        final /* synthetic */ int[] jeq;

        public AnonymousClass4(s sVar, Boolean bool, int i, int[] iArr, int i2) {
            this.jeo = sVar;
            this.iRk = i;
            this.jeq = iArr;
            this.afD = i2;
            super(1000, bool);
        }

        protected final /* synthetic */ Object run() {
            return Boolean.valueOf(this.jeo.a(this.iRk, this.jeq, this.afD));
        }
    }

    class AnonymousClass5 extends bb<Boolean> {
        final /* synthetic */ int iRk;
        final /* synthetic */ s jeo;
        final /* synthetic */ u jer;
        final /* synthetic */ boolean jes;

        public AnonymousClass5(s sVar, Boolean bool, int i, u uVar, boolean z) {
            this.jeo = sVar;
            this.iRk = i;
            this.jer = uVar;
            this.jes = z;
            super(1000, bool);
        }

        protected final /* synthetic */ Object run() {
            boolean z = false;
            s sVar = this.jeo;
            int i = this.iRk;
            u uVar = this.jer;
            boolean z2 = this.jes;
            if (i != sVar.jek) {
                a ij = sVar.ij(i);
                if (ij != null) {
                    a aVar;
                    sVar.jel = i;
                    ViewGroup ih = sVar.ih(ij.jeu);
                    if ((ih instanceof com.tencent.mm.plugin.appbrand.jsapi.b.a) && ((com.tencent.mm.plugin.appbrand.jsapi.b.a) ih).iSj) {
                        a ij2 = sVar.ij(ij.jeu);
                        if (ij2 != null) {
                            ViewGroup ih2 = sVar.ih(ij2.jeu);
                            if (ih2 != null) {
                                View view = (View) ij.jet.get();
                                if (view != null) {
                                    LayoutParams layoutParams = view.getLayoutParams();
                                    layoutParams.width = -1;
                                    layoutParams.height = -1;
                                    view.setLayoutParams(layoutParams);
                                }
                                sVar.jel = ij2.id;
                                ih = ih2;
                                aVar = ij2;
                                if (ih != null) {
                                    ih.addView(sVar.jem, ih.indexOfChild((View) aVar.jet.get()));
                                    ih.removeView((View) aVar.jet.get());
                                }
                                sVar.jde.g((View) aVar.jet.get(), z2);
                                sVar.jek = i;
                                sVar.jea = uVar;
                                z = true;
                            }
                        }
                    }
                    aVar = ij;
                    if (ih != null) {
                        ih.addView(sVar.jem, ih.indexOfChild((View) aVar.jet.get()));
                        ih.removeView((View) aVar.jet.get());
                    }
                    sVar.jde.g((View) aVar.jet.get(), z2);
                    sVar.jek = i;
                    sVar.jea = uVar;
                    z = true;
                }
            }
            return Boolean.valueOf(z);
        }
    }

    class AnonymousClass6 extends bb<Boolean> {
        final /* synthetic */ int iRk;
        final /* synthetic */ s jeo;

        public AnonymousClass6(s sVar, Boolean bool, int i) {
            this.jeo = sVar;
            this.iRk = i;
            super(1000, bool);
        }

        protected final /* synthetic */ Object run() {
            return Boolean.valueOf(this.jeo.io(this.iRk));
        }
    }

    private static class a {
        int h;
        int id;
        WeakReference<View> jet;
        public int jeu;
        int l;
        int t;
        int visibility;
        int w;
        int z;

        public a(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            this.jet = new WeakReference(view);
            this.id = i;
            this.jeu = i2;
            this.l = i3;
            this.t = i4;
            this.w = i5;
            this.h = i6;
            this.z = i7;
            this.visibility = i8;
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public s(r rVar) {
        this.jde = rVar;
        this.mHandler = new ae(Looper.getMainLooper());
        this.jej = new LinkedList();
        this.jem = new View(rVar.getContext());
        final ab abVar = new ab(rVar);
        rVar.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ s jeo;

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean z;
                if (motionEvent.getAction() != 0) {
                    c.a((ViewGroup) view, motionEvent);
                }
                ab abVar = abVar;
                if (motionEvent != null) {
                    e eVar = (e) abVar.jvB.bX(abVar.jde);
                    if (eVar != null) {
                        p pVar;
                        f fVar = eVar.jsD;
                        if (fVar.jrQ.onFilterTouchEventForSecurity(motionEvent)) {
                            Iterator cVar = motionEvent.getActionMasked() == 0 ? new com.tencent.mm.plugin.appbrand.widget.a.c(fVar.jrQ) : fVar.jrR.iterator();
                            fVar.jrS = motionEvent.getActionMasked() == 0 ? new a(motionEvent.getDownTime(), motionEvent.getEventTime()) : null;
                            View view2 = null;
                            z = false;
                            while (cVar.hasNext()) {
                                View view3 = (View) cVar.next();
                                int actionIndex = motionEvent.getActionIndex();
                                int pointerId = fVar.jrQ.isMotionEventSplittingEnabled() ? 1 << motionEvent.getPointerId(actionIndex) : -1;
                                float x = motionEvent.getX(actionIndex);
                                float y = motionEvent.getY(actionIndex);
                                if (motionEvent.getActionMasked() == 0) {
                                    Object obj = (view3.getVisibility() == 0 || view3.getAnimation() != null) ? 1 : null;
                                    if (obj != null) {
                                        Boolean bool = (Boolean) m.a("isTransformedTouchPointInView", fVar.jrQ, new Class[]{Float.TYPE, Float.TYPE, View.class, PointF.class}, new Object[]{Float.valueOf(x), Float.valueOf(y), view3, null}, Boolean.valueOf(false));
                                        obj = (bool == null || !bool.booleanValue()) ? null : 1;
                                        if (obj != null && (view2 == null || com.tencent.mm.plugin.appbrand.widget.a.a.bJ(view3))) {
                                            View view4;
                                            boolean z2;
                                            if (com.tencent.mm.plugin.appbrand.widget.a.a.a(fVar.jrQ, motionEvent, view3, pointerId)) {
                                                view4 = view2 == null ? view3 : view2;
                                                fVar.jrR.addLast(view3);
                                                z2 = z | 1;
                                            } else {
                                                z2 = z;
                                                view4 = view2;
                                            }
                                            z = z2;
                                            view2 = view4;
                                        }
                                    }
                                } else {
                                    z |= com.tencent.mm.plugin.appbrand.widget.a.a.a(fVar.jrQ, motionEvent, view3, pointerId);
                                }
                            }
                            switch (motionEvent.getActionMasked()) {
                                case 1:
                                case 3:
                                    fVar.jrR.clear();
                                    break;
                            }
                        }
                        z = false;
                        b.a("MicroMsg.AppBrand.InputTouchDuplicateDispatcher", "[textscroll] handled | " + z, motionEvent);
                        if (2 == motionEvent.getActionMasked()) {
                            if (z && !abVar.jvy) {
                                pVar = (p) abVar.jvC.bX(abVar.jde);
                                if (pVar != null) {
                                    abVar.jvz = !pVar.jdz;
                                    pVar.cb(false);
                                    pVar.requestDisallowInterceptTouchEvent(true);
                                    abVar.jvy = true;
                                }
                            }
                            if (z) {
                                abVar.jvA = true;
                            } else if (abVar.jvA) {
                                abVar.jvA = false;
                            }
                        }
                        switch (motionEvent.getActionMasked()) {
                            case 0:
                                break;
                            case 1:
                            case 3:
                                if (abVar.jvy) {
                                    pVar = (p) abVar.jvC.bX(abVar.jde);
                                    if (pVar != null) {
                                        pVar.cb(abVar.jvz);
                                    }
                                    abVar.jvy = false;
                                    break;
                                }
                                break;
                        }
                        z = false;
                        if (z) {
                            return false;
                        }
                        return true;
                    }
                }
                z = false;
                if (z) {
                    return false;
                }
                return true;
            }
        });
    }

    public final boolean a(View view, int i, int i2, int[] iArr, int i3) {
        if (view == null || iArr == null || iArr.length < 5) {
            return false;
        }
        ViewGroup ih = ih(i2);
        if (ih == null) {
            return false;
        }
        if (il(i) != null) {
            return false;
        }
        int i4 = iArr[0];
        int i5 = iArr[1];
        int i6 = iArr[2];
        int i7 = iArr[3];
        int i8 = iArr[4];
        LayoutParams a = a(ih, i4, i5, i6, i7);
        if (a == null) {
            return false;
        }
        int i9 = 0;
        for (a aVar : this.jej) {
            int i10;
            if (i2 != aVar.jeu || i8 < aVar.z) {
                i10 = i9;
            } else {
                i10 = i9 + 1;
            }
            i9 = i10;
        }
        if (i9 < 0) {
            i9 = 0;
        }
        if (i9 > ih.getChildCount()) {
            i9 = ih.getChildCount();
        }
        if (i3 >= 0) {
            view.setVisibility(i3 == 0 ? 0 : 8);
        }
        ih.addView(view, i9, a);
        a(view, i, i2, i4, i5, i6, i7, i8, i3);
        return true;
    }

    final ViewGroup ih(int i) {
        if (i == 0) {
            ViewGroup viewGroup = (ViewGroup) this.jde.getView();
            if (viewGroup instanceof AbsoluteLayout) {
                return viewGroup;
            }
            return null;
        }
        a ij = ij(i);
        if (ij == null) {
            return null;
        }
        View view = (View) ij.jet.get();
        return view instanceof com.tencent.mm.plugin.appbrand.jsapi.b.a ? (ViewGroup) view : null;
    }

    private static LayoutParams a(ViewGroup viewGroup, int i, int i2, int i3, int i4) {
        if (viewGroup instanceof AbsoluteLayout) {
            return new AbsoluteLayout.LayoutParams(i3, i4, i, i2);
        }
        if (!(viewGroup instanceof com.tencent.mm.plugin.appbrand.jsapi.b.a)) {
            return null;
        }
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(i3, i4);
        ((RelativeLayout.LayoutParams) layoutParams).leftMargin = i;
        ((RelativeLayout.LayoutParams) layoutParams).topMargin = i2;
        return layoutParams;
    }

    public final boolean ii(final int i) {
        bb anonymousClass3 = new bb<Boolean>(this, Boolean.valueOf(false)) {
            final /* synthetic */ s jeo;

            protected final /* synthetic */ Object run() {
                boolean z;
                s sVar = this.jeo;
                int i = i;
                a ij = sVar.ij(i);
                if (ij != null) {
                    sVar.io(i);
                    sVar.a(ij);
                    ViewGroup ih = sVar.ih(ij.jeu);
                    if (ih != null) {
                        sVar.jej.remove(ij);
                        ih.removeView((View) ij.jet.get());
                        z = true;
                        return Boolean.valueOf(z);
                    }
                }
                z = false;
                return Boolean.valueOf(z);
            }
        };
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            return ((Boolean) anonymousClass3.b(null)).booleanValue();
        }
        return ((Boolean) anonymousClass3.b(this.mHandler)).booleanValue();
    }

    public final boolean a(int i, int[] iArr, int i2) {
        if (in(i)) {
            return true;
        }
        a ij = ij(i);
        if (ij == null) {
            return false;
        }
        View view = (View) ij.jet.get();
        ViewGroup ih = ih(ij.jeu);
        if (ih == null) {
            return false;
        }
        if (i2 >= 0) {
            view.setVisibility(i2 == 0 ? 0 : 8);
        }
        if (iArr == null || iArr.length < 5) {
            return true;
        }
        int i3 = iArr[0];
        int i4 = iArr[1];
        int i5 = iArr[2];
        int i6 = iArr[3];
        int i7 = iArr[4];
        this.jej.remove(ij);
        if (ij.z != i7) {
            ih.removeView(view);
            if (a(view, i, ij.jeu, iArr, i2)) {
                return true;
            }
            a(ij);
            return false;
        }
        view.setLayoutParams(a(ih, i3, i4, i5, i6));
        a(view, i, ij.jeu, i3, i4, i5, i6, i7, i2);
        int indexOfChild = ih.indexOfChild(this.jem);
        if (ih.indexOfChild(view) == -1 && indexOfChild != -1) {
            ih.addView(view, indexOfChild);
            ih.removeView(this.jem);
        }
        return true;
    }

    final void a(a aVar) {
        this.jej.removeAll(b(aVar));
    }

    private List<a> b(a aVar) {
        List<a> linkedList = new LinkedList();
        for (a aVar2 : this.jej) {
            if (aVar2.jeu == aVar.id) {
                linkedList.addAll(b(aVar2));
            }
        }
        linkedList.add(aVar);
        return linkedList;
    }

    public final a ij(int i) {
        for (a aVar : this.jej) {
            if (aVar.id == i) {
                return aVar;
            }
        }
        return null;
    }

    public final boolean ik(int i) {
        return ij(i) != null;
    }

    public final View il(int i) {
        a ij = ij(i);
        return ij == null ? null : (View) ij.jet.get();
    }

    private void a(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.jej.add(new a(view, i, i2, i3, i4, i5, i6, i7, i8));
    }

    public final q.b im(int i) {
        return q.yC().fP(hashCode() + "#" + i);
    }

    public final q.b B(int i, boolean z) {
        return q.yC().n(hashCode() + "#" + i, z);
    }

    public final boolean in(int i) {
        return this.jel == i || this.jek == i;
    }

    public final boolean io(int i) {
        if (i != this.jek || ij(i) == null) {
            return false;
        }
        this.jde.Wf();
        return true;
    }
}
